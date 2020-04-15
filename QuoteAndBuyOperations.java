package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.*;
import com.usmanhussain.habanero.framework.WebDriverDiscovery;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class QuoteAndBuyOperations extends WebDriverDiscovery {

    public static String randomCustomerFirstName = "";
    public static String randomCustomerLastName = "";
    public static String randomCustomerFullName = "";
    public static String taxForSpecificRegion = "";
    public static String startDate = "";
    public static String currentYearMedicalUpgradePrice = "";
    public static String currentYearBusinessUpgradePrice = "";
    public static String currentYearGolfUpgradePrice = "";
    public static String updatedMedicalUpgradePrice = "";
    public static String updatedBusinessUpgradePrice = "";
    public static String updatedGolfUpgradePrice = "";
    public static String renewalQuoteExpiryDate = "";
    public static String qvpBeforeRenewal = "";
    public static String amount;
    public static String premiumValueAfterRevise;
    public static String premiumValueBeforeExpire;
    public static String iptValue = "";
    public static String insuredPersonsTablerowId = "";
    public static String medicalCoverToDate = "";
    public static String businessCoverToDate = "";
    public static String golfCoverToDate = "";
    public static String cruiseCoverToDate = "";
    public static String paymentAmount = "";
    public static RemoteWebDriver getDriver;

    static int iPremium;
    String question = "";
    String noOfDays = "";
    int lastFourDigit = 0;
    String cardNumber = "";
    int paymentCount = 0;
    static String aap = "";
    public static String validateFutureDate = "";
    String date;
    private QuoteDetailsPage quoteDetailsPageObj = new QuoteDetailsPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private SchemeSummaryPage schemeSummaryPageObj = new SchemeSummaryPage();
    private co.uk.directlinegroup.tt.utils.common.Select selectObj = new co.uk.directlinegroup.tt.utils.common.Select();
    private CustomerPortalQuotePage customerPortalQuotePageObj = new CustomerPortalQuotePage();
    private Commands commandsObj = new Commands();
    private RulesEngineOperation rulesEngineOperationObj = new RulesEngineOperation();
    private FileOperations fileOperationsObj = new FileOperations();
    private RandomGenerator randomGeneratorObj = new RandomGenerator();
    private PolicyOperations policyOperationsObj = new PolicyOperations();
    private ClaimPaymentPage claimPaymentPageObj = new ClaimPaymentPage();
    private AccountInformationPage accountInformationPageObj = new AccountInformationPage();
    private QuoteRenewalPage quoteRenewalPageObj = new QuoteRenewalPage();
    private IAdminSecurityManagementPage iAdminSecurityManagementPageObj = new IAdminSecurityManagementPage();
    private RulesEnginePage rulesEnginePageObj = new RulesEnginePage();
    private CustomerPortalQuoteOperations customerPortalQuoteOperationsObj = new CustomerPortalQuoteOperations();
    private DateOperations dateOperationsObj = new DateOperations();
    private ClaimsOperations claimOperationObj = new ClaimsOperations();
    private SetUpPage setUpPageObj = new SetUpPage();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();

    public void verifyFieldAvailable(String fieldName, String fieldValue) {
        if (!fieldValue.equalsIgnoreCase("yes") && !fieldValue.equalsIgnoreCase("no") && !fieldValue.equalsIgnoreCase("not selected")) {
            question = fieldValue;
        }
        switch (fieldName.toLowerCase()) {
            case "question":
                System.out.println("element displayed------------------------" + quoteDetailsPageObj.questionAvailable(fieldValue).isDisplayed());
                Assert.assertTrue(quoteDetailsPageObj.questionAvailable(fieldValue).isDisplayed());
                break;
            case "yes":
                String optionYes = quoteDetailsPageObj.optionYes(question).getText();//quoteDetailsPageObj.optionYes(question).getAttribute("class");
                System.out.println("option vlaue-----------------------------" + optionYes);
                Assert.assertTrue(optionYes.equalsIgnoreCase(fieldValue));
                break;
            case "no":
                String optionNo = quoteDetailsPageObj.optionNo(question).getText();//.getAttribute("class");
                System.out.println("option vlaue-----------------------------" + optionNo);
                Assert.assertTrue(optionNo.equalsIgnoreCase(fieldValue));
                break;
            case "default":
                String defaultStatusYes = quoteDetailsPageObj.optionYes(question).getAttribute("aria-checked");
                String defaultStatusNo = quoteDetailsPageObj.optionNo(question).getAttribute("aria-checked");
                Assert.assertTrue(defaultStatusYes.equalsIgnoreCase("false"));
                Assert.assertTrue(defaultStatusNo.equalsIgnoreCase("false"));
                break;
        }
    }

    public void verifyExpectedBehaviour(List<String> rowValue, List<String> columnName) {
        String question1 = "", option = "", expectedBehaviour = "";
        for (int i = 0; i < columnName.size(); i++) {
            if (columnName.get(i).equalsIgnoreCase("question"))
                question1 = rowValue.get(i);
            else if (columnName.get(i).equalsIgnoreCase("optionselected")) {
                option = rowValue.get(i);
                this.selectOptionYesOrNo(option, question1);
            } else if (columnName.get(i).equalsIgnoreCase("expected behaviour")) {
                expectedBehaviour = rowValue.get(2);
                this.selectExpectedBehaviour(expectedBehaviour);
            }
        }
    }

    private void selectExpectedBehaviour(String expectedBehaviour) {
        String buttonClass = "";
        if (expectedBehaviour.equalsIgnoreCase("next button disabled")) {
            buttonClass = quoteDetailsPageObj.nextButton().getAttribute("class");
            System.out.println("Button status ----------------------------------- " + buttonClass);
            Assert.assertTrue(buttonClass.contains("disabled"));
        } else if (expectedBehaviour.equalsIgnoreCase("next button enabled")) {
            buttonClass = quoteDetailsPageObj.nextButton().getAttribute("class");
            System.out.println("Button status ----------------------------------- " + buttonClass);
            Assert.assertTrue(buttonClass.contains("bounce-in"));
        } else if (expectedBehaviour.equalsIgnoreCase("not available")) {
        }
    }

    public void selectOptionYesOrNo(String option, String question1) {
        if (option.equalsIgnoreCase("yes")) {
            if (question1.equalsIgnoreCase("Hazardous Activities Cover")) {
                quoteDetailsPageObj.optionYesHazardous(question1);
                quoteDetailsPageObj.btnClick(quoteDetailsPageObj.optionYesHazardous(question1));
            } else {
                quoteDetailsPageObj.optionYes(question1);
                quoteDetailsPageObj.btnClick(quoteDetailsPageObj.optionYes(question1));
            }
            nextEventPageObj.waitForMoreTime();//nextEventPageObj.waitForMoreTime();
        } else if (option.equalsIgnoreCase("no")) {
            if (question1.equalsIgnoreCase("Hazardous Activities Cover")) {
                quoteDetailsPageObj.optionNoHazardous(question1);
                quoteDetailsPageObj.btnClick(quoteDetailsPageObj.optionNoHazardous(question1));
            } else {
                quoteDetailsPageObj.optionNo(question1);
                quoteDetailsPageObj.btnClick(quoteDetailsPageObj.optionNo(question1));
            }
            nextEventPageObj.waitForMoreTime();//nextEventPageObj.waitForMoreTime();
        } else if (option.equalsIgnoreCase("2 or more")) {
            quoteDetailsPageObj.btnClick(quoteDetailsPageObj.option2OrMore());
            nextEventPageObj.waitForMoreTime();
        } else if (option.equalsIgnoreCase("None or 1")) {
            quoteDetailsPageObj.noneOrOne().click();
            nextEventPageObj.waitForMoreTime();
        } else if (option.equalsIgnoreCase("none or 1")) {
            quoteDetailsPageObj.optionYes(question1);
            quoteDetailsPageObj.btnClick(quoteDetailsPageObj.optionYes(question1));
        } else if (option.equalsIgnoreCase("1 listed condition")) {
            quoteDetailsPageObj.optionYes(question1);
            quoteDetailsPageObj.btnClick(quoteDetailsPageObj.optionYes(question1));
        } else if (option.equalsIgnoreCase("other")) {
            quoteDetailsPageObj.optionNo(question1);
            quoteDetailsPageObj.btnClick(quoteDetailsPageObj.optionNo(question1));
        }
    }

    public void selectPeopleForMedicalScreening(String fieldName, String fieldValue) {
        List<String> namedPeople = new ArrayList<String>();
        switch (fieldName.toLowerCase()) {
            case "question":
                question = fieldValue;
                System.out.println("Question available ------------------------------ " + quoteDetailsPageObj.questionAvailable(fieldValue).isDisplayed());
                Assert.assertTrue(quoteDetailsPageObj.questionAvailable(fieldValue).isDisplayed());
                break;
            case "optionselected":
                this.selectOptionYesOrNo(fieldValue, question);
                if (commandsObj.elementDisplayedWithLessTime(By.xpath(customerPortalQuotePageObj.proceedBtn()))) {
                    nextEventPageObj.btnClick(nextEventPageObj.findElement(By.xpath(customerPortalQuotePageObj.proceedBtn())));
                }
                break;
            case "namedpeople":
                String[] namedPeopleList = fieldValue.split("#");
                for (int i = 0; i < namedPeopleList.length; i++) {
                    if (!namedPeopleList[i].equalsIgnoreCase("nothing") && !namedPeopleList[i].equalsIgnoreCase("random")) {
                        System.out.println("people-----if part -------------- " + quoteDetailsPageObj.namedPeople(question, namedPeopleList[i]).getText());
                        nextEventPageObj.waitForMoreTime();
                    } else if (namedPeopleList[i].equalsIgnoreCase("random")) {
                        System.out.println("people------else if part ------------- " + quoteDetailsPageObj.namedPeople(question, customerPortalQuoteOperationsObj.randomUserFname).getText());
                        quoteDetailsPageObj.namedPeople(question, customerPortalQuoteOperationsObj.randomUserFname).click();
                    }
                }
                break;
            case "selectnamedpeople":
                if (!fieldValue.equalsIgnoreCase("nothing")) {
                    String[] namedPeopleListSelect = fieldValue.split("#");
                    for (int i = 0; i < namedPeopleListSelect.length; i++) {
                        System.out.println("Selected named people" + namedPeopleListSelect[i]);
                        System.out.println("Random user name" + this.randomCustomerFullName);
                        if (namedPeopleListSelect[i].equalsIgnoreCase("random")) {
                            System.out.println("people------------------- " + quoteDetailsPageObj.namedPeopleSelecting(question).getText());
                            nextEventPageObj.waitForMoreTime();
                            if (quoteDetailsPageObj.namedPeopleSelecting(question).isSelected()) {
                            } else if (!(quoteDetailsPageObj.namedPeopleSelecting(question).isSelected())) {
                                quoteDetailsPageObj.namedPeopleSelecting(question).click();
                            }
                        } else {
                            System.out.println("people------------------- " + quoteDetailsPageObj.namedPeople(question, namedPeopleListSelect[i]).getText());
                            nextEventPageObj.waitForMoreTime();
                            if (quoteDetailsPageObj.namedPeople(question, namedPeopleListSelect[i]).isSelected()) {

                            } else if (!(quoteDetailsPageObj.namedPeople(question, namedPeopleListSelect[i]).isSelected())) {
                                quoteDetailsPageObj.namedPeople(question, namedPeopleListSelect[i]).click();
                            }
                        }
                    }
                }
                break;
            case "validation":
                if (!fieldValue.equalsIgnoreCase("nothing")) {
                    String[] namedPeopleListSelect = fieldValue.split("#");
                    for (int i = 0; i < namedPeopleListSelect.length; i++) {
                        System.out.println("people------------------- " + quoteDetailsPageObj.namedPeople(question, namedPeopleListSelect[i]).getText());
                        Assert.assertTrue(quoteDetailsPageObj.namedPeople(question, namedPeopleListSelect[i]).isDisplayed());
                    }
                }
                break;
            case "selectpeople":
                String[] namedPeopleListSelection = fieldValue.split("#");
                for (int i = 0; i < namedPeopleListSelection.length; i++) {
                    if (!namedPeopleListSelection[i].equalsIgnoreCase("nothing") && !namedPeopleListSelection[i].equalsIgnoreCase("random")) {
                        System.out.println("people-----if part -------------- " + quoteDetailsPageObj.namedPeople(question, namedPeopleListSelection[i]).getText());
                        nextEventPageObj.waitForMoreTime();
                        if (!(quoteDetailsPageObj.namedPeople(question, namedPeopleListSelection[i]).isSelected())) {
                            quoteDetailsPageObj.namedPeople(question, namedPeopleListSelection[i]).click();
                        }
                    } else if (namedPeopleListSelection[i].equalsIgnoreCase("random")) {
                        System.out.println("people------else if part ------------- " + quoteDetailsPageObj.namedPeople(question, customerPortalQuoteOperationsObj.randomUserFname).getText());
                        if (!(quoteDetailsPageObj.namedPeople(question, customerPortalQuoteOperationsObj.randomUserFname).isSelected())) {
                            quoteDetailsPageObj.namedPeople(question, customerPortalQuoteOperationsObj.randomUserFname).click();
                        }
                    }
                }
                break;
        }
    }

    public void medicalConditionAnswering(List<String> questionAndAnswer) {
        String question = questionAndAnswer.get(0);
        String answer = questionAndAnswer.get(1);
        System.out.println("xpath of question and answer -----------------------------" + quoteDetailsPageObj.question1(question, answer).isDisplayed());
        nextEventPageObj.btnClick(quoteDetailsPageObj.question1(question, answer));
    }

    public void validateQuoteSaved(String person, List<List<String>> questionAndAnswers) {
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
        String namedPeopleList = "";
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
        quoteDetailsPageObj.firstRecordInQuoteListArrow().click();
        if (person.equalsIgnoreCase("random")) {
            namedPeopleList = this.randomCustomerFullName;
            System.out.println("Random customer full name" + namedPeopleList);
        } else {
            namedPeopleList = person;
        }
        quoteDetailsPageObj.detailsLink(namedPeopleList).click();
        this.openAllMedicalConditions();
        this.verifyQuestionAndAnswers(questionAndAnswers);
        getDriver().navigate().refresh();
    }

    private void verifyQuestionAndAnswers(List<List<String>> questionAndAnswers) {
        String question = "";
        String answer = "";
        for (int i = 1; i < questionAndAnswers.size(); i++) {
            question = questionAndAnswers.get(i).get(0);
            answer = questionAndAnswers.get(i).get(1);
            Assert.assertTrue(answer.equalsIgnoreCase(quoteDetailsPageObj.questionsInQuoteList(question).getText()));
        }
    }

    private void openAllMedicalConditions() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        List<WebElement> medicalConditions = nextEventPageObj.findElements(By.xpath(quoteDetailsPageObj.verifyMedicalCondition()));
        System.out.println("no of items-----------------------------" + medicalConditions.size());
        for (int i = 0; i < medicalConditions.size(); i++) {
            medicalConditions.get(i).click();
        }
    }

    public void enterPersondetails(List<List<String>> personDetails) {
        for (int i = 1; i < personDetails.size(); i++) {
            for (int j = 0; j < personDetails.get(i).size(); j++) {
                nextEventPageObj.btnClick(quoteDetailsPageObj.addPersonIcon());
                this.addPersonDetails(personDetails.get(0).get(j), personDetails.get(i).get(j));
            }
            quoteDetailsPageObj.addPersonYes().click();
        }
    }

    private void addPersonDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "title":
                new Select(quoteDetailsPageObj.titleOfNewPerson()).selectByVisibleText(fieldValue);
                break;
            case "first name":
                if (fieldValue.equalsIgnoreCase("random")) {
                    fieldValue = randomGeneratorObj.randomString(4);
                    quoteDetailsPageObj.firstNameOfNewPerson().sendKeys(fieldValue);
                } else {
                    quoteDetailsPageObj.firstNameOfNewPerson().sendKeys(fieldValue);
                }
                break;
            case "last name":
                quoteDetailsPageObj.lastNameOfNewPerson().sendKeys(fieldValue);
                break;
            case "dob":
                quoteDetailsPageObj.DOBofNewPerson().sendKeys(fieldValue);
                quoteDetailsPageObj.DOBofNewPerson().sendKeys(Keys.ENTER);
                break;
            case "dateofbirth":
                System.out.println("Enter from date -----" + this.GuestDobDate(fieldValue));
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                quoteDetailsPageObj.DOBofNewPerson().clear();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                quoteDetailsPageObj.DOBofNewPerson().sendKeys(this.GuestDobDate(fieldValue));
                quoteDetailsPageObj.DOBofNewPerson().sendKeys(Keys.ENTER);
                break;
            case "add asguest":
                if (fieldValue.equalsIgnoreCase("Yes")) {
                    System.out.println("field value----------Guest------------------" + fieldValue);
                    quoteDetailsPageObj.AddGuest().click();
                }
                break;
            case "relationship":
                new Select(quoteDetailsPageObj.relationshipOfNewPerson()).selectByVisibleText(fieldValue);
                break;
            case "trip detail[from date;to date;destination;winter sport;anotherperson]":
                this.enterTripDetails(fieldValue);
                break;
        }
    }

    public void enterloginDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "username":
                quoteDetailsPageObj.userNameForRemoveAgeExtension().clear();
                quoteDetailsPageObj.userNameForRemoveAgeExtension().sendKeys(fieldValue);
                break;
            case "password":
                quoteDetailsPageObj.passwordForRemoveAgeExtension().clear();
                quoteDetailsPageObj.passwordForRemoveAgeExtension().sendKeys(fieldValue);
                nextEventPageObj.btnClick(quoteDetailsPageObj.saveBtnForRemoveAgeExtension());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "verify message":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (fieldValue.equalsIgnoreCase("An age extension is required")) {
                    nextEventPageObj.waitForMoreTime();
                    Assert.assertTrue(quoteDetailsPageObj.ageExtensionRemovalMessage(fieldValue).isDisplayed());
                } else {
                    nextEventPageObj.waitForMoreTime();
                    Assert.assertTrue(quoteDetailsPageObj.ageExtensionRemovalErrorMessage(fieldValue).isDisplayed());
                }
                break;
        }
    }

    public void enterTripDetails(String fieldValue) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (!fieldValue.equalsIgnoreCase("nothing")) {
            String[] tripDetails1 = fieldValue.split("#");
            for (int i = 0; i < tripDetails1.length; i++) {
                String[] tripDetails = fieldValue.split(";");
                System.out.println("trip full details --------------------------------" + tripDetails[i]);
                System.out.println("tripFieldValues-------------------------" + tripDetails.length);
                System.out.println("trip field level details--------------------------" + tripDetails[0] + " to date------" + tripDetails[1] + "---sdes------" + tripDetails[2] + "-----winter---------" + tripDetails[3]);
                if (tripDetails[0].equalsIgnoreCase("currentdate") || tripDetails[0].equalsIgnoreCase("today")) {
                    quoteDetailsPageObj.tripFromDate().click();
                    dateOperationsObj.dateCalendarFromDateGuest(fieldValue);
                } else {
                    quoteDetailsPageObj.tripFromDate().click();
                    dateOperationsObj.dateCalendarFromDateGuest(fieldValue);
                }
                if (tripDetails[1].equalsIgnoreCase("currentdate") || tripDetails[1].equalsIgnoreCase("futuredate1month") || tripDetails[1].equalsIgnoreCase("futuredate6month")
                        || tripDetails[1].equalsIgnoreCase("futuredate1yr") || tripDetails[1].equalsIgnoreCase("futuredatebyexceeding1yr") || tripDetails[1].equalsIgnoreCase("futuredate18months")
                        || tripDetails[1].equalsIgnoreCase("backdate1month") || tripDetails[1].equalsIgnoreCase("nextday") || tripDetails[1].equalsIgnoreCase("futuredate2month")
                        || tripDetails[1].equalsIgnoreCase("futuredate184days")
                        || tripDetails[1].equalsIgnoreCase("futuredate90days") || tripDetails[1].equalsIgnoreCase("futuredate31days") || tripDetails[1].equalsIgnoreCase("futuredate22days")
                        || tripDetails[1].equalsIgnoreCase("futuredate89days")) {
                    quoteDetailsPageObj.tripToDate().click();
                    dateOperationsObj.dateCalendarTodateGuest(fieldValue);
                } else if (tripDetails[1].contains("days")) {
                    quoteDetailsPageObj.tripToDate().click();
                    System.out.println("adding--------------------------DAtes-----------------" + dateOperationsObj.addingDaysSpecificFormat(Integer.parseInt(tripDetails[1].split(" ")[0])));
                    dateOperationsObj.dateCalendarTodateGuest(fieldValue);
                } else {
                    quoteDetailsPageObj.tripToDate().click();
                    dateOperationsObj.dateCalendarTodateGuest(fieldValue);
                }
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                new Select(quoteDetailsPageObj.destinationForGuest()).selectByVisibleText(tripDetails[2]);
                if (tripDetails[3].equalsIgnoreCase("yes"))
                    quoteDetailsPageObj.winterSports().click();
                if (tripDetails[4].equalsIgnoreCase("yes"))
                    nextEventPageObj.btnClick(quoteDetailsPageObj.addAnotherTripBtn());
            }
        }
    }

    public void validateDestinationDetails(String guestName, String fieldName, String fieldValue) {
        String current = "";
        String toDate = "";
        String dateFeatureFile2 = "";
        String dateFeatureFile1 = "";
        String tripDate = "";
        String dateFeatureFile3 = "";
        String dateFeatureFile4 = "";
        String datefromFeatureFile = "";
        switch (fieldName.toLowerCase()) {
            case "destination":
                List<WebElement> destinationList = nextEventPageObj.findElements(By.xpath(quoteDetailsPageObj.destinationSelectedByGuestXpath(guestName, fieldValue)));
                boolean flag = false;
                for (int i = 0; i < destinationList.size(); i++) {
                    if (fieldValue.equalsIgnoreCase(destinationList.get(i).getText())) {
                        System.out.println("field value ----------------------------" + fieldValue);
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    Assert.assertTrue(true);
                break;
            case "date":
                if (fieldValue.equalsIgnoreCase("currentdate - futuredate1month (31 days)") || fieldValue.equalsIgnoreCase("currentdate - futuredate89days (90 days)")) {
                    dateFeatureFile1 = fieldValue.split(" ")[0];
                    dateFeatureFile2 = fieldValue.split(" ")[2];
                    dateFeatureFile3 = fieldValue.split(" ")[3];
                    dateFeatureFile4 = fieldValue.split(" ")[4];
                    if (dateFeatureFile1.equalsIgnoreCase("currentdate")) {
                        current = dateOperationsObj.tripDate(dateFeatureFile1);
                    }
                    if (dateFeatureFile2.equalsIgnoreCase("futuredate1month") || dateFeatureFile2.equalsIgnoreCase("futuredate89days")) {
                        toDate = dateOperationsObj.tripDate(dateFeatureFile2);
                    }
                    String dateformat1 = current.concat(" ");
                    String dateformat2 = dateformat1.concat("-");
                    String dateformat3 = dateformat2.concat(" ");
                    String dateformat4 = dateformat3.concat(toDate);
                    String dateformat5 = dateformat4.concat(" ");
                    String dateformat6 = dateformat5.concat(dateFeatureFile3);
                    String dateformat7 = dateformat6.concat(" ");
                    datefromFeatureFile = dateformat7.concat(dateFeatureFile4);
                    System.out.println("Date from FF-----" + datefromFeatureFile);
                    System.out.println("tripDate--" + tripDate);
                    tripDate = quoteDetailsPageObj.tripDateOfSelectedGuest(datefromFeatureFile).getText();
                    System.out.println("tripDate--" + tripDate);
                    Assert.assertTrue(quoteDetailsPageObj.tripDateOfSelectedGuest(datefromFeatureFile).isDisplayed());
                    Assert.assertTrue(tripDate.equalsIgnoreCase(datefromFeatureFile));
                    noOfDays = quoteDetailsPageObj.tripDateOfSelectedGuest(datefromFeatureFile).getText();
                } else {
                    Assert.assertTrue(quoteDetailsPageObj.tripDateOfSelectedGuest(fieldValue).isDisplayed());
                    noOfDays = quoteDetailsPageObj.tripDateOfSelectedGuest(fieldValue).getText();
                }
                break;
            case "cover":
                String days = noOfDays.split("\\(")[1];
                String day = days.split("\\)")[0];
                String numberOfDays = day.split(" ")[0];
                int numOfDays = Integer.parseInt(numberOfDays);
                System.out.println("days------------------" + days + "-------day----------------" + day);
                if (fieldValue.equalsIgnoreCase("silver")) {
                    if (numOfDays <= 25)
                        Assert.assertTrue(true);
                } else if (fieldValue.equalsIgnoreCase("Platinum")) {
                    if (numOfDays <= 31)
                        Assert.assertTrue(true);
                } else if (fieldValue.equalsIgnoreCase("Black")) {
                    if (numOfDays <= 90)
                        Assert.assertTrue(true);
                } else if (fieldValue.equalsIgnoreCase("ulster bank")) {
                    if (numOfDays <= 31)
                        Assert.assertTrue(true);
                }
                break;
            case "guest":
                Assert.assertTrue(quoteDetailsPageObj.txtSelectedGuest(guestName).isDisplayed());
                System.out.println("Added Guest is :" + quoteDetailsPageObj.txtSelectedGuest(guestName).getText());
        }
    }

    public void enterTripDetailsForUpgrades(String fieldName, String fieldValue) {
        try {
            System.out.println("inside upgrades functions");
            switch (fieldName.toLowerCase()) {
                case "trip date - from":
                    quoteDetailsPageObj.tripFromDate().clear();
                    if (fieldValue.equalsIgnoreCase("currentdate") || fieldValue.equalsIgnoreCase("futuredate1month") || fieldValue.equalsIgnoreCase("futuredate6month")
                            || fieldValue.equalsIgnoreCase("futuredate1yr") || fieldValue.equalsIgnoreCase("futuredatebyexceeding1yr") || fieldValue.equalsIgnoreCase("futuredate18months")
                            || fieldValue.equalsIgnoreCase("backdate1month") || fieldValue.equalsIgnoreCase("nextday") || fieldValue.equalsIgnoreCase("futuredate2month")
                            || fieldValue.equalsIgnoreCase("futuredate184days")|| fieldValue.equalsIgnoreCase("futuredate90days") || fieldValue.equalsIgnoreCase("futuredate31days") || fieldValue.equalsIgnoreCase("futuredate22days")) {
                        System.out.println("Enter from date -----" + dateOperationsObj.tripDate(fieldValue));
                        if(!quoteDetailsPageObj.btnBackToAQ().isDisplayed()){
                        quoteDetailsPageObj.tripFromDate().sendKeys(customerPortalQuoteOperationsObj.dateValueEnter(fieldValue));
                        quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                        quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                        }else {
                            dateOperationsObj.dateCalendarFromDateWedding(fieldValue);
                        }
                    } else {
                        if (!quoteDetailsPageObj.btnBackToAQ().isDisplayed()) {
                            quoteDetailsPageObj.tripFromDate().sendKeys(customerPortalQuoteOperationsObj.dateValueEnter(fieldValue));
                            quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                            quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                            System.out.println("inside upgrades else part");
                        } else {
                            dateOperationsObj.dateCalendarFromDateWedding(fieldValue);
                        }
                    }
                    break;
                case "trip date - to":
                    if (fieldValue.equalsIgnoreCase("currentdate") || fieldValue.equalsIgnoreCase("futuredate1month") || fieldValue.equalsIgnoreCase("futuredate6month")
                            || fieldValue.equalsIgnoreCase("futuredate1yr") || fieldValue.equalsIgnoreCase("futuredatebyexceeding1yr") || fieldValue.equalsIgnoreCase("futuredate18months")
                            || fieldValue.equalsIgnoreCase("backdate1month") || fieldValue.equalsIgnoreCase("nextday") ||
                            fieldValue.equalsIgnoreCase("futuredate2month") || fieldValue.equalsIgnoreCase("futuredate184days")
                            || fieldValue.equalsIgnoreCase("futuredate90days") || fieldValue.equalsIgnoreCase("futuredate31days") || fieldValue.equalsIgnoreCase("futuredate22days")) {
                        System.out.println("Enter from date -----" + dateOperationsObj.tripDate(fieldValue));

                        if(!quoteDetailsPageObj.btnBackToAQ().isDisplayed()) {
                            quoteDetailsPageObj.tripToDate().sendKeys(customerPortalQuoteOperationsObj.dateValueEnter(fieldValue));
                        }else{
                            dateOperationsObj.dateCalendarToDateWedding(fieldValue);
                        }
                    } else if (fieldValue.contains("days")) {
                        System.out.println("adding--------------------------DAtes-----------------" + dateOperationsObj.addingDaysSpecificFormat(Integer.parseInt(fieldValue.split(" ")[0])));
                        if(!quoteDetailsPageObj.btnBackToAQ().isDisplayed()) {
                            quoteDetailsPageObj.tripToDate().sendKeys(customerPortalQuoteOperationsObj.dateValueEnter(fieldValue));
                        }else{
                            dateOperationsObj.dateCalendarToDateWedding(fieldValue);
                        }
                    } else {
                        if(!quoteDetailsPageObj.btnBackToAQ().isDisplayed()) {
                            quoteDetailsPageObj.tripToDate().sendKeys(customerPortalQuoteOperationsObj.dateValueEnter(fieldValue));
                        }else{
                            dateOperationsObj.dateCalendarToDateWedding(fieldValue);
                        }
                    }
                    break;
                case "destination":
                    Thread.sleep(2000L);
                    new Select(quoteDetailsPageObj.drpdnTripDestination()).selectByVisibleText(fieldValue);
                    Thread.sleep(2000L);
                    break;
                case "cover amount":
                    new Select(quoteDetailsPageObj.drpdnCancellationAmt()).selectByVisibleText(fieldValue);
                    break;
                case "action":
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    Thread.sleep(2000L);
                    nextEventPageObj.btnClick(quoteDetailsPageObj.saveDetails());
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    break;
                case "trip length":
                    new Select(customerPortalQuotePageObj.drpdnTripLength()).selectByVisibleText(fieldValue);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateIPTAmountInIPTtab(String taxret, String taxPercent) {
        System.out.println("Tax percent for UK retrieved from IPT:" + taxret);
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        double tax1 = Double.parseDouble(taxret);
        System.out.println("x = + " + nf.format(tax1));
        String tax = nf.format(tax1);
        System.out.println("Tax percent after system round off" + tax);
        double taxpercent = Double.parseDouble(tax);
        System.out.println("Tax percent after round off" + taxpercent);
        String calculatedTaxPercent = Double.toString(taxpercent);
        System.out.println("Tax percent passed" + taxPercent);
        Assert.assertTrue(calculatedTaxPercent.equalsIgnoreCase(taxPercent));
    }

    public void enterPaymentdetails(List<List<String>> personDetails) {
        nextEventPageObj.btnClick(quoteDetailsPageObj.btnThirdParty());
        nextEventPageObj.btnClick(quoteDetailsPageObj.permission_toUseCard());
        for (int i = 1; i < personDetails.size(); i++) {
            for (int j = 0; j < personDetails.get(i).size(); j++) {
                this.addPaymentDetails(personDetails.get(0).get(j), personDetails.get(i).get(j));
            }
        }
    }

    public void addPaymentDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "title":
                new Select(quoteDetailsPageObj.titleOfNewPerson()).selectByVisibleText(fieldValue);
                break;
            case "first name":
                quoteDetailsPageObj.firstNameOfNewPerson().clear();
                quoteDetailsPageObj.firstNameOfNewPerson().sendKeys(fieldValue);
                break;
            case "last name":
                quoteDetailsPageObj.txtPaymentFields("lastName").sendKeys(fieldValue);
                break;
            case "card holders name":
                quoteDetailsPageObj.cardHoldersName().clear();
                quoteDetailsPageObj.cardHoldersName().sendKeys(fieldValue);
                break;
            case "address 1":
                quoteDetailsPageObj.txtPaymentFields("address1").sendKeys(fieldValue);
                break;
            case "towncity":
                quoteDetailsPageObj.txtPaymentFields("townCity").sendKeys(fieldValue);
                break;
            case "postcode":
                quoteDetailsPageObj.txtPaymentFields("postcode").sendKeys(fieldValue);
                break;
            case "username":
                quoteDetailsPageObj.txtPaymentFields("username").clear();
                quoteDetailsPageObj.txtPaymentFields("username").sendKeys(fieldValue);
                break;
            case "password":
                quoteDetailsPageObj.txtPaymentFields("password").clear();
                quoteDetailsPageObj.txtPaymentFields("password").sendKeys(fieldValue);
                break;
            case "reason":
                quoteDetailsPageObj.txtPaymentFields("reason").clear();
                quoteDetailsPageObj.txtPaymentFields("reason").sendKeys(fieldValue);
                break;
            case "address 2":
                quoteDetailsPageObj.txtPaymentFields("address2").sendKeys(fieldValue);
                break;
            case "county":
                quoteDetailsPageObj.txtPaymentFields("county").sendKeys(fieldValue);
                break;
            case "telephone":
                quoteDetailsPageObj.txtPaymentFields("telephone").sendKeys(fieldValue);
                break;
            case "email":
                quoteDetailsPageObj.txtPaymentFields("email").sendKeys(fieldValue);
                break;
            case "permission":
                if (fieldValue.equalsIgnoreCase("Yes")) {
                    System.out.println("field value----------consent------------------" + fieldValue);
                    quoteDetailsPageObj.btnClick(quoteDetailsPageObj.chkBxConsent());
                }
                break;
            case "expected behaviuour":
                System.out.println("quote-------------------------------sisudtui------------------" + fieldValue);
                if (fieldValue.equalsIgnoreCase("Yes disabled"))
                    Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(quoteDetailsPageObj.yesCheckBoxInPAymentToThirdParty())));
                else
                    Assert.assertTrue(!nextEventPageObj.elementDisplayed(By.xpath(quoteDetailsPageObj.yesCheckBoxInPAymentToThirdParty())));
                break;
            case "error message":
                if (!fieldValue.equalsIgnoreCase("na")) {
                    quoteDetailsPageObj.btnSave().click();
                    Assert.assertTrue(quoteDetailsPageObj.ageExtensionRemovalErrorMessage(fieldValue).isDisplayed());
                }
                break;
        }
    }

    public void captureCardNumber(String cardNumber) {
        int lastFourDigit = Integer.parseInt(quoteDetailsPageObj.lblcardNumber().getText().substring(12));
        System.out.println("Last four digit of used card -----------" + lastFourDigit);
        Assert.assertTrue(lastFourDigit == Integer.parseInt(cardNumber));
    }

    public void enterCardDetails(List<List<String>> personDetails) {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < personDetails.size(); i++) {
            for (int j = 0; j < personDetails.get(i).size(); j++) {
                this.addCardDetails(personDetails.get(0).get(j), personDetails.get(i).get(j));
            }
        }
    }

    private void addCardDetails(String fieldName, String fieldValue) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToFrameById(customerPortalQuotePageObj.paymentFrame());
        switch (fieldName.toLowerCase()) {
            case "card number":
                cardNumber = fieldValue;
                quoteDetailsPageObj.enterCardNumber().sendKeys(fieldValue);
                break;
            case "expiry date":
                //new Select(quoteDetailsPageObj.enterExpiryDate()).selectByVisibleText(fieldValue);
                quoteDetailsPageObj.enterExpiryDate().sendKeys(fieldValue);
                break;
            case "cvv":
                quoteDetailsPageObj.entercvvNumber().sendKeys(fieldValue);
                break;
            case "card holder":
                quoteDetailsPageObj.enterCardHolderName().sendKeys(fieldValue);
                break;
            case "expiry year":
                //new Select(quoteDetailsPageObj.enterExpiryYear()).selectByVisibleText(fieldValue);
                quoteDetailsPageObj.enterExpiryYear().sendKeys(fieldValue.substring(Math.max(fieldValue.length() - 2, 0)));
                break;
            case "authenticate payment":
                System.out.println("Invalid payment......");
                if (fieldValue.equalsIgnoreCase("invalid")) {
                    nextEventPageObj.btnClick(quoteDetailsPageObj.makePaymentBtn());
                    nextEventPageObj.waitForMoreTime();
                    if (paymentCount == 0)
                        quoteDetailsPageObj.btnClick(quoteDetailsPageObj.btnTryAgain());
                    System.out.println("Payment count -------" + paymentCount);
                    paymentCount++;
                } else if (fieldValue.equalsIgnoreCase("valid")) {
                    nextEventPageObj.btnClick(quoteDetailsPageObj.makePaymentBtn());
                } else if (fieldValue.equalsIgnoreCase("incorrect")) {
                    nextEventPageObj.btnClick(quoteDetailsPageObj.makePaymentBtn());
                } else if (fieldValue.equalsIgnoreCase("cancel")) {
                    nextEventPageObj.btnClick(quoteDetailsPageObj.makePaymentBtn());
                    System.out.println("Clicking on Cancel button.....");
                    quoteDetailsPageObj.btnClick(quoteDetailsPageObj.btnTryCancel());
                } else if (fieldValue.equalsIgnoreCase("pay by direct debit")) {
                    nextEventPageObj.btnClick(quoteDetailsPageObj.makePaymentBtn());
                    nextEventPageObj.waitForMoreTime();
                    System.out.println("Clicking on Pay by DD.....");
                    nextEventPageObj.btnClick(quoteDetailsPageObj.directDebitBtn());
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                }
                break;
            case "action":
                System.out.println("Action case........");
                switch (fieldValue.toLowerCase().trim()) {
                    case "cancel":
                        System.out.println("Clicking on Cancel button.....");
                        quoteDetailsPageObj.btnClick(quoteDetailsPageObj.btnTryCancel());
                        break;
                    case "try again":
                        nextEventPageObj.btnClick(quoteDetailsPageObj.makePaymentBtn());
                        if (paymentCount <= 1) {
                            quoteDetailsPageObj.btnClick(quoteDetailsPageObj.btnTryAgain());
                            paymentCount++;
                        }
                        break;
                    case "pay by direct debit":
                        System.out.println("Clicking on Pay by DD.....");
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.btnClick(quoteDetailsPageObj.directDebitBtn());
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                }
        }
    }

    public void validateFailureCardNum() {
        int iFCardNum = nextEventPageObj.failureCardNumber().getText().indexOf(13);
        System.out.println("getText() of failure card number -----" + nextEventPageObj.purchaseCompleteCardNumber().getText());
        System.out.println("Capture failure complete card num -----------" + iFCardNum);
        Assert.assertEquals(cardNumber.substring(cardNumber.length() - 4), iFCardNum);
    }

    public void stopRecording() {
        System.out.println("Dummy method for the Mute functionality");
    }

    public void startRecording() {
        System.out.println("Dummy method for the UnMute functionality");
    }

    public void validateMute() {
        System.out.println("Dummy method for the Mute functionality");
    }

    public void validateUnMute() {
        System.out.println("Dummy method for the Mute functionality");
    }

    public void updateAAPDays(String days) {
        aap = days;
        System.out.println("AAP days --------" + aap);
        schemeSummaryPageObj.txtAAPDays().clear();
        schemeSummaryPageObj.txtAAPDays().sendKeys(days);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        schemeSummaryPageObj.btnClick(schemeSummaryPageObj.saveAndCloseBtn());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void updateAAPBrands(String days) {
        aap = days;
        schemeSummaryPageObj.btnClick(policyDataFieldsPageObj.leadsTab());
        schemeSummaryPageObj.txtAAPDays_Brand().clear();
        schemeSummaryPageObj.txtAAPDays_Brand().sendKeys(days);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        schemeSummaryPageObj.btnClick(schemeSummaryPageObj.saveAndCloseBtn());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateExceedAAPDays() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.txtStartDate().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
        SimpleDateFormat sd = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        int givenAAPDays = Integer.parseInt(aap);
        c.add(Calendar.DATE, givenAAPDays); // Adding AAP days
        String fMonth = sdf.format(c.getTime());
        String futureMonth = fMonth.trim().split(" ")[0];
        String fDate = sd.format(c.getTime());
        System.out.println("Future Month --" + fMonth);
        System.out.println("Date Format---" + futureMonth);
        System.out.println("*****Future date***" + fDate);
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.lblmonth());
        String selectedMonth = quoteDetailsPageObj.lblmonth().getText().trim().split(" ")[0];
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.drpdnFMonth().click();
        Select sMonth = new Select(quoteDetailsPageObj.drpdnFMonth());
        System.out.println(" Month needs to be selected is ------------- " + futureMonth);
        nextEventPageObj.waitForMoreTime();
        sMonth.selectByVisibleText(futureMonth);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.dateTable());
        WebElement dateWidget = quoteDetailsPageObj.dateTable();
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
        int selectDate = Integer.parseInt(fDate);
        int beyondAAPDate = selectDate + 1;
        System.out.println("Date in int format --" + beyondAAPDate);
        for (WebElement dateCell : columns) {
            dateCell.findElement(By.xpath("//td[@data-day='" + beyondAAPDate + "']")).click();
            if (dateCell.getText().equals(beyondAAPDate)) {
                dateCell.findElement(By.xpath("//td[@data-day='" + beyondAAPDate + "']")).click();
                String exceedDateAttribute = dateCell.findElement(By.xpath("//td[@data-day='" + beyondAAPDate + "']")).getAttribute("class");
                Assert.assertEquals("is-disabled", exceedDateAttribute);
                break;
            }
        }
    }

    public void selectAvailableAAPDays() {
        String sDate = "";
        nextEventPageObj.btnClick(quoteDetailsPageObj.lblNext());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.txtStartDate().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
        SimpleDateFormat sd = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        System.out.println("AAP:---------------------- " + aap);
        int givenAAPDays = Integer.parseInt(this.aap);
        c.add(Calendar.DATE, givenAAPDays);
        String fMonth = sdf.format(c.getTime());
        String futureMonth = fMonth.trim().split(" ")[0];
        String fDate = sd.format(c.getTime());
        System.out.println("Future Month --" + fMonth);
        System.out.println("Date Format---" + futureMonth);
        System.out.println("*****Future date***" + fDate);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.lblmonth());
        nextEventPageObj.waitForMoreTime();
        System.out.println(" Month needs to be selected is -------------" + futureMonth);
        new Select(quoteDetailsPageObj.drpdnFromMonth()).selectByVisibleText(futureMonth);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (sDate.startsWith("0")) {
            sDate = sDate.substring(1);
        }
        try {
            quoteDetailsPageObj.dateTableForTripFromDateXpath(sDate).click();
        } catch (Exception e) {
            nextEventPageObj.waitForMoreTime();
            quoteDetailsPageObj.dateTableForTripFromDateXpath(sDate).click();
        }
        nextEventPageObj.waitForMoreTime();
    }

    public void enterPremiumDetails(List<List<String>> premiumDetails) {
        for (int i = 1; i < premiumDetails.size(); i++) {
            for (int j = 0; j < premiumDetails.get(i).size(); j++) {
                this.selectPremiumOverrideOptions(premiumDetails.get(0).get(j), premiumDetails.get(i).get(j));
            }
        }
    }

    private void selectPremiumOverrideOptions(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "reason":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Select reason = new Select(quoteDetailsPageObj.drpdnReason());
                System.out.println("Reason FV--------------" + fieldValue);
                reason.selectByVisibleText(fieldValue);
                break;
            case "amount":
                quoteDetailsPageObj.txtPaymentFields("amount").clear();
                System.out.println("amt FV--------------" + fieldValue);
                quoteDetailsPageObj.txtPaymentFields("amount").sendKeys(fieldValue);
                break;
            case "by":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("By FV--------------" + fieldValue);
                new Select(quoteDetailsPageObj.drpdnPremiumBy()).selectByVisibleText(fieldValue);
                break;
            case "median":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("Median FV--------------" + fieldValue);
                new Select(quoteDetailsPageObj.drpdnPremiumMedian()).selectByVisibleText(fieldValue);
                break;
        }
    }

    public void enterPremiumCredentials(List<List<String>> personDetails) {
        for (int i = 1; i < personDetails.size(); i++) {
            for (int j = 0; j < personDetails.get(i).size(); j++) {
                this.addPaymentDetails(personDetails.get(0).get(j), personDetails.get(i).get(j));
            }
        }
    }

    public void validatePremiumDetails(List<List<String>> vPremiumDetails) {
        for (int i = 1; i < vPremiumDetails.size(); i++) {
            for (int j = 0; j < vPremiumDetails.get(i).size(); j++) {
                this.validatePremiumOverrideOptions(vPremiumDetails.get(0).get(j), vPremiumDetails.get(i).get(j));
            }
        }
    }

    private void validatePremiumOverrideOptions(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "reason":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertEquals(quoteDetailsPageObj.lblOverrideReason().getText(), fieldValue);
                break;
            case "override percentage":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("By Percentage --------------" + fieldValue);
                Assert.assertEquals(quoteDetailsPageObj.txtOverridePercentag().getAttribute("value"), fieldValue);
                break;
            case "override proportion":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("By Percentage --------------" + fieldValue);
                Assert.assertEquals(quoteDetailsPageObj.txtOverrideProportion().getAttribute("value"), fieldValue);
                break;
        }
        quoteDetailsPageObj.btnClick(quoteDetailsPageObj.btnSaveAndClose());
    }

    public void verifyAndEnterPaymentDetailDispalyed(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "payee":
                String name;
                if (policyOperationsObj.lastName.equals("")) {
                    fieldValue = fieldValue.concat("");
                } else {
                    fieldValue = fieldValue.concat(" ".concat(policyOperationsObj.lastName));
                }
                System.out.println("----------getText()---------------------------------" + quoteDetailsPageObj.paymentDetailsPayee().getText());
                String payeefname = quoteDetailsPageObj.paymentDetailsPayee().getText().split(" ")[1].trim();
                String payeelname = quoteDetailsPageObj.paymentDetailsPayee().getText().split(" ")[2].trim();
                String payeeFullName = payeefname.concat(" " + payeelname);
                System.out.println("-----------------------Payee--------------------------" + payeeFullName);
                if (fieldValue.equalsIgnoreCase("random")) {
                    System.out.println("Random user-------" + randomCustomerFullName);
                    Assert.assertTrue("Payee should be --" + randomCustomerFullName, payeeFullName.equalsIgnoreCase(randomCustomerFullName));
                }
                if (!(fieldValue.equalsIgnoreCase("random"))) {
                    System.out.println("Not a random user");
                    Assert.assertTrue("Payee should be --" + fieldValue, payeeFullName.equalsIgnoreCase(fieldValue));
                }
                break;
            case "sort code":
                System.out.println("----------getText()---------------------------------" + quoteDetailsPageObj.paymentDetailsSortcode().getText());
                String sortCode = quoteDetailsPageObj.paymentDetailsSortcode().getText().split(":")[1].trim();
                System.out.println("-----------------------Payee--------------------------" + sortCode);
                Assert.assertTrue("Sort code should be --" + fieldValue, sortCode.equalsIgnoreCase(fieldValue));
                break;
            case "account number":
                System.out.println("----------getText()---------------------------------" + quoteDetailsPageObj.paymentDetailsAccountNo().getText());
                String accountNo = quoteDetailsPageObj.paymentDetailsAccountNo().getText().split(":")[1].trim();
                System.out.println("-----------------------Payee--------------------------" + accountNo);
                Assert.assertTrue("Account Number should be --" + fieldValue, accountNo.equalsIgnoreCase(fieldValue));
                break;
            case "bank name":
                System.out.println("----------getText()---------------------------------" + quoteDetailsPageObj.paymentDetailsBankname().getText());
                String bankName = quoteDetailsPageObj.paymentDetailsBankname().getText().split(":")[1].trim();
                System.out.println("-----------------------Payee--------------------------" + bankName);
                Assert.assertTrue("Bank Name should be --" + fieldValue, bankName.equalsIgnoreCase(fieldValue));
                break;
            case "payee firstname":
                quoteDetailsPageObj.payeeFirstName().clear();
                quoteDetailsPageObj.payeeFirstName().sendKeys(fieldValue);
                break;
            case "payee lastname":
                quoteDetailsPageObj.payeeLastName().clear();
                quoteDetailsPageObj.payeeLastName().sendKeys(fieldValue);
                break;
            case "sortcode":
                quoteDetailsPageObj.payeeSortCode().clear();
                quoteDetailsPageObj.payeeSortCode().sendKeys(fieldValue);
                break;
            case "payee account number":
                quoteDetailsPageObj.payeeAccountNumber().clear();
                quoteDetailsPageObj.payeeAccountNumber().sendKeys(fieldValue);
                break;
            case "payee bank name":
                quoteDetailsPageObj.payeeBankName().clear();
                quoteDetailsPageObj.payeeBankName().sendKeys(fieldValue);
                break;
            case "consent":
                quoteDetailsPageObj.btnClick(quoteDetailsPageObj.payeeConsent());
                break;
            case "validate details":
                quoteDetailsPageObj.btnClick(quoteDetailsPageObj.validateDetailsbtn());
                break;
            case "upgrade":
                Assert.assertTrue(quoteDetailsPageObj.upgradeSelected().isDisplayed());
                break;
            case "customer":
                String customerName = quoteDetailsPageObj.customerNameForQuoteThatBought().getText();
                System.out.println("---------------customer name-------------" + customerName);
                Assert.assertTrue(customerName.equalsIgnoreCase(fieldValue));
                break;
            case "account holder name":
                quoteDetailsPageObj.accountHolderName().clear();
                quoteDetailsPageObj.accountHolderName().sendKeys(fieldValue);
                break;
        }
    }

    public void validateTripDestinationdropdownValues(List<String> parameters) {
        Assert.assertTrue(selectObj.validateValuesInDropDown(quoteDetailsPageObj.destinationDropdown(), parameters));
    }


    public void selectValidTripDate(String tripLength) {
        nextEventPageObj.btnClick(quoteDetailsPageObj.lblNext());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.txtStartDate().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
        SimpleDateFormat sd = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        int length = Integer.parseInt(tripLength);
        c.add(Calendar.DATE, length);
        String fMonth = sdf.format(c.getTime());
        String futureMonth = fMonth.trim().split(" ")[0];
        String fDate = sd.format(c.getTime());
        System.out.println("Future Month --" + fMonth);
        System.out.println("Date Format---" + futureMonth);
        System.out.println("*****Future date***" + fDate);
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.lblmonth());
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.drpdnFMonth().click();
        Select sMonth = new Select(quoteDetailsPageObj.drpdnFMonth());
        System.out.println(" Month needs to be selected is ------------- " + futureMonth);
        nextEventPageObj.waitForMoreTime();
        sMonth.selectByVisibleText(futureMonth);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.dateTable());
        WebElement dateWidget = quoteDetailsPageObj.dateTable();
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
        int selectDate = Integer.parseInt(fDate);
        System.out.println("Date in int format --" + selectDate);
        for (WebElement dateCell : columns) {
            dateCell.findElement(By.xpath("//td[@data-day='" + selectDate + "']")).click();
            break;
        }
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.btnClick(quoteDetailsPageObj.lblNext());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void selectEndBackToStartDate(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.selectTripCancelDates(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    public void selectTripCancelDates(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "cancel trip-start date":
                String fromdate = "";
                SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                Calendar c1 = Calendar.getInstance();
                c1.setTime(new Date());
                fromdate = sdf1.format(c1.getTime());
                if (fieldValue.equalsIgnoreCase("currentdate")) {
                    fieldValue = fromdate;
                    quoteDetailsPageObj.tripFromDate().sendKeys(fieldValue);
                }
                break;
            case "cancel trip-end date":
                String date = "";
                String todate = "";
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Calendar c = Calendar.getInstance();
                c.add(Calendar.DATE, -1);
                date = sdf.format(c.getTime());
                if (fieldValue.equalsIgnoreCase("yesterday")) {
                    fieldValue = date;
                    String onlyDate = fieldValue.split("/")[0];
                    if (onlyDate.startsWith("0")) {
                        onlyDate = onlyDate.substring(1);
                    }
                    quoteDetailsPageObj.tripToDate().click();
                    nextEventPageObj.elementDisplayed(quoteDetailsPageObj.dateTable());
                    WebElement dateWidget = quoteDetailsPageObj.dateTable();
                    List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
                    System.out.println("Date in int format --" + onlyDate);
                    for (WebElement dateCell : columns) {
                        String exceedDateAttribute = dateCell.findElement(By.xpath("//td[@data-day='" + onlyDate + "']")).getAttribute("class");
                        Assert.assertEquals("is-disabled", exceedDateAttribute);
                    }
                }
                break;
        }
    }

    public void selectAnswersForTheQuestions(List<List<String>> questionList) {
        for (int i = 1; i < questionList.size(); i++) {
            this.verifyExpectedBehaviour(questionList.get(i), questionList.get(0));
        }
    }

    public void changingPolicyDate() {
        policyDataFieldsPageObj.editPolicy().click();
        policyDataFieldsPageObj.startdatetext().clear();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c1 = Calendar.getInstance();
        c1.setTime(new Date()); // Now use today date.
        String output1 = sdf1.format(c1.getTime());
        System.out.println(output1);
        policyDataFieldsPageObj.startdatetext().sendKeys(sdf1.format(c1.getTime()));
    }

    public void latestRenewalQuote(List<List<String>> coverDetails) {
        Assert.assertTrue(quoteDetailsPageObj.latestRenewalQuoteText().isDisplayed());
        quoteDetailsPageObj.selectingQuoteDetails().click();
        for (int i = 1; i < coverDetails.size(); i++) {
            String cover = coverDetails.get(i).get(0);
            System.out.println("----cover----- premium----" + cover);
            String premium[] = coverDetails.get(i).get(1).split(".");
            int coverPremium1 = Integer.parseInt(premium[0]);
            System.out.println("----cover----- premium----" + coverPremium1);
            int coverPremium2 = Integer.parseInt(premium[1]);
            System.out.println("----cover----- premium----" + coverPremium2);
            System.out.println("----cover----- premium---from application-" + quoteDetailsPageObj.coverAndPremium(cover).getText());
            Assert.assertTrue((quoteDetailsPageObj.coverAndPremium(cover).getText().split(".")[0].equals(coverPremium1)));
            Assert.assertTrue((quoteDetailsPageObj.coverAndPremium(cover).getText().split(".")[1].equals(coverPremium2)));
        }
    }

    public void filterCaseID(String caseNumber) {
        new Select(setUpPageObj.filterWithCase()).selectByVisibleText(caseNumber);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateRenewalType(String renewalType) {
        quoteDetailsPageObj.leadDetailsTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.renewalTab().click();
        nextEventPageObj.waitForPageLoad();
        if (renewalType.equalsIgnoreCase("Automatic Renewal")) {
            Assert.assertTrue(quoteRenewalPageObj.chkBxAutomaticRenewal().isSelected());
        } else if (renewalType.equalsIgnoreCase("Manual Renewal")) {
            Assert.assertTrue(quoteRenewalPageObj.chkBxManualRenewal().isSelected());
        }
        nextEventPageObj.btnCloseWindow().click();
    }

    public void verifyQVPGenerated() {
        // ToDO increasing thread count to 9000L to check it on monday
        try {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            Thread.sleep(9000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        String QVPdays = quoteDetailsPageObj.QVPDays().getText().trim().split(" ")[0];
        System.out.println("QVPdays----------------------------" + QVPdays);
        int value = Integer.parseInt(QVPdays);
        if (value > 0 || value <= 30) {
            System.out.println("Valid QVP");
            Assert.assertTrue(true);
        } else {
            System.out.println("Invalid QVP");
            Assert.assertFalse(false);
        }
    }

    public void validateHealixQuestion(List<List<String>> questionList) {
        quoteDetailsPageObj.clickonFracture().click();
        quoteDetailsPageObj.clickonOsteoporosis().click();
        for (int row = 1; row < questionList.size(); row++) {
            for (int column = 1; column < questionList.get(0).size(); column++) {
                String question = questionList.get(row).get(0);
                String answer = questionList.get(row).get(1);
                System.out.println("----------" + question);
                System.out.println("----------" + answer);
                Assert.assertTrue(quoteDetailsPageObj.validateQuestionAndResponses(question, answer).isDisplayed());
            }
        }
        nextEventPageObj.fancyboxClose().click();
        nextEventPageObj.waitForPageLoad();
    }

    public void createBasicQuote(String strQuoteType, List<List<String>> lstInputParameters) {
        commandsObj.waitForLoad(getDriver());
        List<List<String>> lstQuoteParamets = commandsObj.parameterMappingQuote(lstInputParameters, strQuoteType);
        System.out.println("Question===" + lstQuoteParamets.get(0));
        System.out.println("Asnwer===" + lstQuoteParamets.get(1));
        for (int i = 0; i < lstQuoteParamets.get(0).size(); i++) {
            System.out.println("question-----------------------" + lstQuoteParamets.get(0).get(i));
            if (lstQuoteParamets.get(1).get(i).equalsIgnoreCase("Next")) {
                System.out.println("------------inside next button click-----------");
                quoteDetailsPageObj.btnClick(quoteDetailsPageObj.nextButton());
            } else if ((lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Business Cover") ||
                    lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Wedding Cover") ||
                    lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Hazardous Activities Cover") ||
                    lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Cruise Cover") ||
                    lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Increased Baggage Cover") ||
                    lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Golf cover") ||
                    lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Trip Extension") ||
                    lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Cancellation Extension")) && !lstQuoteParamets.get(1).get(i).equalsIgnoreCase("NA")) {
                if (commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(quoteDetailsPageObj.editExistingMedicalCondition())))
                    nextEventPageObj.waitForElementPresent(By.xpath(quoteDetailsPageObj.editExistingMedicalCondition())).click();
                quoteDetailsPageObj.addAdditionalPriceUpgradesOptionSelect(lstQuoteParamets.get(0).get(i), lstQuoteParamets.get(1).get(i)).click();
            } else if (lstQuoteParamets.get(1).get(i).equalsIgnoreCase("Start Healix Screening")) {
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(quoteDetailsPageObj.OtherHealixScreeningBtn());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(quoteDetailsPageObj.checkCoverBtn());
            } else if (lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Medical Condition") && lstQuoteParamets.get(1).get(i).equalsIgnoreCase("Fracture")) {
                System.out.println("-------------------fracture----------------------");
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameByIndex(0);
                quoteDetailsPageObj.medicalConditionText().sendKeys(lstQuoteParamets.get(1).get(i));
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(quoteDetailsPageObj.medicalConditionSelectBtn(lstQuoteParamets.get(1).get(i)));
            } else if ((lstQuoteParamets.get(0).get(i).equalsIgnoreCase("How long ago was your most recent fracture or dislocation?") && !(lstQuoteParamets.get(1).get(i).equalsIgnoreCase("NA"))) ||
                    (lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Do you need to be seen again at a hospital clinic for this condition?") && !(lstQuoteParamets.get(1).get(i).equalsIgnoreCase("NA"))) ||
                    (lstQuoteParamets.get(0).get(i).equalsIgnoreCase("As a result of this fracture or dislocation did you have a joint replacement?") && !(lstQuoteParamets.get(1).get(i).equalsIgnoreCase("NA"))) ||
                    (lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Do you have osteoporosis?") && !(lstQuoteParamets.get(1).get(i).equalsIgnoreCase("NA")))){
                List<String> questAndAnswer = new ArrayList<String>();
                questAndAnswer.add(lstQuoteParamets.get(0).get(i));
                questAndAnswer.add(lstQuoteParamets.get(1).get(i));
                this.medicalConditionAnswering(questAndAnswer);
            } else if (lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Complete medical screening") && !lstQuoteParamets.get(1).get(i).equalsIgnoreCase("NA")) {
                nextEventPageObj.btnClick(quoteDetailsPageObj.continueBtn());
                nextEventPageObj.btnClick(quoteDetailsPageObj.finishBtn());
                quoteDetailsPageObj.btnClick(quoteDetailsPageObj.nextButton());
            } else if (lstQuoteParamets.get(0).get(i).equalsIgnoreCase("In addition to the people listed above, you should tell us about everyone") && commandsObj.elementDisplayedWithLessTime(By.xpath("//*[contains(text(),'Silver Account')] "))) {
                quoteDetailsPageObj.btnClick(quoteDetailsPageObj.nextButton());
            } else if (!lstQuoteParamets.get(1).get(i).equalsIgnoreCase("NA")) {
                System.out.println("element display----------------------------" + nextEventPageObj.elementDisplayed(org.openqa.selenium.By.xpath(quoteDetailsPageObj.editExistingMedicalCondition())));
                if (commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(quoteDetailsPageObj.editExistingMedicalCondition())))
                    nextEventPageObj.waitForElementPresent(By.xpath(quoteDetailsPageObj.editExistingMedicalCondition())).click();
                this.selectOptionYesOrNo(lstQuoteParamets.get(1).get(i), lstQuoteParamets.get(0).get(i));
                System.out.println("------------inside questions button click-----------");
            }
        }
    }

    public void navigateToSpecificScreen(String button) {
        if (button.equalsIgnoreCase("next")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            try {
                quoteDetailsPageObj.btnClick(quoteDetailsPageObj.nextButton());
            } catch (Exception e) {
                quoteDetailsPageObj.nextButton().click();
            }
        } else if (button.equalsIgnoreCase("Start Healix Screening"))
            quoteDetailsPageObj.btnClick(quoteDetailsPageObj.startHealixScreeningBtn());
        else if (button.equalsIgnoreCase("Other Medical Screening"))
            quoteDetailsPageObj.btnClick(quoteDetailsPageObj.OtherMedicalScreeningBtn());
        else if (button.equalsIgnoreCase("Accept No Cover"))
            quoteDetailsPageObj.btnClick(quoteDetailsPageObj.acceptNoCoverBtn());
        else if (button.equalsIgnoreCase("save quote")) {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nextEventPageObj.btnClick(quoteDetailsPageObj.saveQuoteBtn());
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        } else if (button.equalsIgnoreCase("Buy")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(quoteDetailsPageObj.btnBuy());
        } else if (button.equalsIgnoreCase("Save")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(quoteDetailsPageObj.btnSave());
        } else if (button.equalsIgnoreCase("Check cover")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(quoteDetailsPageObj.btnCheckCover());
        } else if (button.equalsIgnoreCase("Back to AQ")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(quoteDetailsPageObj.btnBackToAQ());
        } else if (button.equalsIgnoreCase("Basket")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(quoteDetailsPageObj.btnBasketScreen());
        } else if (button.equalsIgnoreCase("Buy")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(quoteDetailsPageObj.btnBuy());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            paymentAmount = quoteDetailsPageObj.txtAmount().getText().split("£")[1].trim();
            System.out.println("Payment amount is ----" + paymentAmount);
        } else if (button.equalsIgnoreCase("I understand")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(quoteDetailsPageObj.btnIUnderstand());
        }
    }

    public void enterTheMedicalCondition(String medicalCondition, List<List<String>> questionList) {
        Actions actions = new Actions(getDriver());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameByIndex(0);
        System.out.println("text box medical-----------------------------" + quoteDetailsPageObj.medicalConditionText().isDisplayed());
        for (int i = 0; i < medicalCondition.length() - 1; i++) {
            System.out.println("-------------------STR------------------" + medicalCondition.charAt(i));
            String s = new StringBuilder().append(medicalCondition.charAt(i)).toString();
            quoteDetailsPageObj.medicalConditionText().sendKeys(s);
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("medical button----------------------------------" + quoteDetailsPageObj.medicalConditionSelectBtn(medicalCondition).isDisplayed());
        nextEventPageObj.btnClick(quoteDetailsPageObj.medicalConditionSelectBtn(medicalCondition));
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < questionList.size(); i++) {
            this.medicalConditionAnswering(questionList.get(i));
        }
        nextEventPageObj.btnClick(quoteDetailsPageObj.continueBtn());
        nextEventPageObj.btnClick(quoteDetailsPageObj.finishBtn());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateExpiredQuote(String button) {
        String reviseField = quoteDetailsPageObj.btnRevise(1).getText();
        System.out.println("ReviseField----------------------------" + reviseField);
        List<WebElement> quotes = nextEventPageObj.findElements(By.xpath(quoteDetailsPageObj.quoteList()));
        for (int k = 1; k <= quotes.size(); k++) {
            String reviseBtnText = "";
            if (k < 10) {
                quoteDetailsPageObj.btnRevise(k).isDisplayed();
                reviseBtnText = quoteDetailsPageObj.btnRevise(k).getText();
            } else {
                quoteDetailsPageObj.btnReviseforMoreValue(k).isDisplayed();
                reviseBtnText = quoteDetailsPageObj.btnReviseforMoreValue(k).getText();
            }
            Assert.assertTrue(reviseBtnText.equalsIgnoreCase(button));
        }
        String QVPdays = quoteDetailsPageObj.QVPDays().getText().trim().split(" ")[0];
        System.out.println("QVPdays----------------------------" + QVPdays);
        int value = Integer.parseInt(QVPdays);
        if (value == 0) {
            System.out.println("Valid QVP");
            Assert.assertTrue(true);
        } else {
            System.out.println("Invalid QVP");
            Assert.assertFalse(false);
        }
        quoteDetailsPageObj.btnClick(quoteDetailsPageObj.btnRevise(1));
    }

    public void validatePermiumValueForUpgrade(String upgrades) {
        switch (upgrades.toLowerCase()) {
            case "business test":
                iPremium = Integer.parseInt(rulesEngineOperationObj.businessPremium);
                System.out.println("Business Premium -------------" + iPremium);
                break;
            case "medical test":
                iPremium = Integer.parseInt(rulesEngineOperationObj.medicalPremium);
                System.out.println("Medical Premium -------------" + iPremium);
                break;
        }
        int iTotalCost = (int) Double.parseDouble(amount);
        int iIPTValue = Double.valueOf(iptValue).intValue();
        int expectedValue = iTotalCost - iIPTValue;
        System.out.println("Premium ------------" + iPremium);
        System.out.println("Subtracted value is --------" + expectedValue);
        if (iPremium == expectedValue) {
            System.out.println("Total cost and IPT value is strict with premium value---------" + expectedValue);
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void changeTripLength(String daysOfTripLength) {
        quoteDetailsPageObj.dropdowntripLength().click();
        new Select(quoteDetailsPageObj.dropdowntripLength()).selectByVisibleText(daysOfTripLength);
        new Select(quoteDetailsPageObj.destinationDropdown()).selectByVisibleText("Europe");
    }

    public void validateLengthOfTheTrip(String days, String coverType) {
        switch (coverType.toLowerCase()) {
            case "black":
                String blackTripLength = days;
                this.validateCancellationTripLengh(blackTripLength);
                break;
            case "platinum":
                String platinumTripLength = days;
                this.validateCancellationTripLengh(platinumTripLength);
                break;
            case "ulster":
                String ulsterTripLength = days;
                this.validateCancellationTripLengh(ulsterTripLength);
                break;
        }
    }

    public void validateCancellationTripLengh(String length) {
        if (quoteDetailsPageObj.tripFromDate().isDisplayed()) {
            String fromdate = "";
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c1 = Calendar.getInstance();
            c1.setTime(new Date());
            fromdate = sdf1.format(c1.getTime());
            quoteDetailsPageObj.tripFromDate().sendKeys(fromdate);
        }
        if (quoteDetailsPageObj.tripToDate().isDisplayed()) {
            int maxDays = Integer.parseInt(length);
            String date = "";
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, maxDays);
            date = sdf.format(c.getTime());
            quoteDetailsPageObj.tripToDate().sendKeys(date);
        }
    }

    public void selectValidTripLength(String coverType) {
        switch (coverType.toLowerCase()) {
            case "black":
                String blackTripLength = "90";
                this.selectValidTripDate(blackTripLength);
                break;
            case "platinum":
                String platinumTripLength = "31";
                this.selectValidTripDate(platinumTripLength);
                break;
            case "ulster":
                String ulsterTripLength = "31";
                this.selectValidTripDate(ulsterTripLength);
                break;
        }
    }

    public void selectAnswerForBasicPeopleScreening(String pages, List<List<String>> questionSet) {
        List<String> questionAndAnswer = null;
        String[] pageName = pages.split("#");
        for (int i = 0; i < pageName.length; i++) {
            questionAndAnswer = fileOperationsObj.getQuoteAndBuyData(pageName[i]);
            for (int l = 1; l < questionSet.size(); l++) {
                for (int j = 0; j < questionAndAnswer.size(); j++) {
                    String question = questionAndAnswer.get(j).split("#")[0];
                    String answer = questionAndAnswer.get(j).split("#")[1];
                    if (questionSet.get(l).get(0).contains(question)) {
                        this.selectQuestionOrUpgrade(questionSet.get(l).get(1), questionSet.get(l).get(0));
                        break;
                    } else {
                        this.selectQuestionOrUpgrade(answer, question);
                    }
                    System.out.println("Question-------------------------" + questionAndAnswer.get(j).split("#")[1] + "----------------" + questionAndAnswer.get(j).split("#")[0]);
                }
            }
            quoteDetailsPageObj.btnClick(quoteDetailsPageObj.nextButton());
        }
    }

    private void selectQuestionOrUpgrade(String answer, String question) {
        if (question.contains("Cover")) {
            quoteDetailsPageObj.btnClick(quoteDetailsPageObj.addAdditionalPriceUpgradesYes(question));
        } else {
            this.selectOptionYesOrNo(answer, question);
        }
    }

    public void validateOldAndRevisedPremium() {
        System.out.println("premiumValueBeforeExpire----------------" + premiumValueBeforeExpire);
        System.out.println("amount----------------------------" + amount);
        if (premiumValueBeforeExpire.equalsIgnoreCase(amount)) {
            if (premiumValueBeforeExpire.equalsIgnoreCase(premiumValueAfterRevise)) {
                System.out.println("Revised Premium " + premiumValueAfterRevise + " Premium value of Quote(Before expiry) " + premiumValueBeforeExpire);
                Assert.assertTrue(true);
            }
        } else if (!premiumValueBeforeExpire.equalsIgnoreCase(premiumValueAfterRevise)) {
            System.out.println("Revised Premium " + premiumValueAfterRevise + " Premium value of Quote(Before expiry) " + premiumValueBeforeExpire);
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void validateCancellationAmtDropdownValues(List<String> parameters) {
        selectObj.validateValuesInDropDown(quoteDetailsPageObj.drpdnCancellationAmt(), parameters);
    }

    public void tripDetails(List<List<String>> tripDetails) {
        try {
            for (int i = 1; i < tripDetails.size(); i++) {
                for (int j = 0; j < tripDetails.get(0).size(); j++) {
                    System.out.println("inside upgrades");
                    this.enterTripDetailsForUpgrades(tripDetails.get(0).get(j), tripDetails.get(i).get(j));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigateToBasketScreen() {
        this.navigateToSpecificScreen("next");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        this.navigateToSpecificScreen("next");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        this.navigateToSpecificScreen("next");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void changeStartDate(String date) {
        if (date.equalsIgnoreCase("currentdate")) {
            System.out.println("Inside current date");
            quoteDetailsPageObj.starDateInQuoteAndBuy().click();
            quoteDetailsPageObj.selectCurrentdateInStartDate().click();
        } else if (date.equalsIgnoreCase("future-date")) {
            System.out.println("Inside Future-date");
            this.selectEffectiveStartDate(30);
        } else if (date.equalsIgnoreCase("futuredate")) {
            System.out.println("Inside future start date of the cover");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
            Date newdate = new Date();
            newdate.setTime(newdate.getTime() + 20L * 24 * 60 * 60 * 1000);
            String strDate = dateFormat.format(newdate);
            validateFutureDate = strDate;
            System.out.println("Future start date of the cover" + validateFutureDate);
            String[] dates = strDate.split("/");
            String currentDate = dates[0];
            String currentMonth = dates[1];
            quoteDetailsPageObj.starDateInQuoteAndBuy().click();
            String currentMonthFromDatePicker = quoteDetailsPageObj.retrievecurrentDateMonth().getAttribute("data-pika-month");
            String currentDateFromDatePicker = quoteDetailsPageObj.retrievecurrentDateMonth().getAttribute("data-pika-day");
            System.out.println("Current Month" + currentMonth);
            if (!(currentMonth.equalsIgnoreCase(currentMonthFromDatePicker))) {
                quoteDetailsPageObj.nextMonth().click();
            }
            System.out.println("Current Date" + currentDate);
            if (!(currentDate.equalsIgnoreCase(currentDateFromDatePicker))) {
                int curDate = Integer.parseInt(currentDate);
                System.out.println("Current Date after Parsing" + curDate);
                if (curDate < 10) {
                    DateFormat dayFormat = new SimpleDateFormat("d");
                    Date newday = new Date();
                    currentDate = dayFormat.format(newday);
                    System.out.println("Current date after modification" + currentDate);
                }
                nextEventPageObj.btnClick(quoteDetailsPageObj.dateToSelect(currentDate));
            }
        } else if (date.equalsIgnoreCase("pastdate")) {
        } else if (date.equalsIgnoreCase("effectivedate")) {
            this.selectEffectiveStartDate(30);
        } else if (date.equalsIgnoreCase("nextday")) {
            System.out.println("Inside future start date of the cover");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
            Date newdate = new Date();
            newdate.setTime(newdate.getTime() + 1L * 24 * 60 * 60 * 1000);
            String strDate = dateFormat.format(newdate);
            validateFutureDate = strDate;
            System.out.println("Future start date of the cover" + validateFutureDate);
            String[] dates = strDate.split("/");
            String currentDate = dates[0];
            String currentMonth = dates[1];
            quoteDetailsPageObj.starDateInQuoteAndBuy().click();
            String currentMonthFromDatePicker = quoteDetailsPageObj.retrievecurrentDateMonth().getAttribute("data-pika-month");
            String currentDateFromDatePicker = quoteDetailsPageObj.retrievecurrentDateMonth().getAttribute("data-pika-day");
            System.out.println("Current Month" + currentMonth);
            System.out.println("Current Date" + currentDate);
            int curDate = Integer.parseInt(currentDate);
            System.out.println("Current Date after Parsing" + curDate);
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            quoteDetailsPageObj.dateToSelectForNextDay(curDate).click();
            nextEventPageObj.btnClick(quoteDetailsPageObj.dateToSelectForNextDay(curDate));
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void validateStartDate(String date, String cover) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (date.equalsIgnoreCase("currentdate")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            System.out.println("Inside current date validation" + quoteDetailsPageObj.coverStartDate(cover).getText());
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
            Date newdate = new Date();
            String strDate = dateFormat.format(newdate);
            System.out.println("System date:" + strDate);
            Assert.assertTrue(quoteDetailsPageObj.coverStartDate(cover).getText().equalsIgnoreCase(strDate));
        } else if (date.equalsIgnoreCase("futuredate")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
            Date newdate = new Date();
            newdate.setTime(newdate.getTime() + 20L * 24 * 60 * 60 * 1000);
            String strDate = dateFormat.format(newdate);
            System.out.println("Validate start date:" + strDate);
            Assert.assertTrue(quoteDetailsPageObj.coverStartDate(cover).getText().equalsIgnoreCase(strDate));
        } else if (date.equalsIgnoreCase("effective futuredate")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
            Date newdate = new Date();
            newdate.setTime(newdate.getTime() + 5L * 24 * 60 * 60 * 1000);
            String strDate = dateFormat.format(newdate);
            System.out.println("Validate start date:" + strDate);
            Assert.assertTrue(quoteDetailsPageObj.coverStartDate(cover).getText().equalsIgnoreCase(strDate));
        } else if (date.equalsIgnoreCase("backdated")) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
            Date newdate = new Date();
            newdate.setTime(newdate.getTime() + 30L * 24 * 60 * 60 * 1000);
            String strDate = dateFormat.format(newdate);
            System.out.println("System date:" + strDate);
            Assert.assertTrue(quoteDetailsPageObj.coverStartDate(cover).getText().equalsIgnoreCase(strDate));
        }
    }

    public void validateMTADate(String date, String cover) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        if (date.equalsIgnoreCase("currentdate")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            System.out.println("Inside current date validation" + quoteDetailsPageObj.coverMTADate(cover).getText());
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
            Date newdate = new Date();
            String strDate = dateFormat.format(newdate);
            System.out.println("System date:" + strDate);
            Assert.assertTrue(quoteDetailsPageObj.coverMTADate(cover).getText().equalsIgnoreCase(strDate));
        } else if (date.equalsIgnoreCase("futuredate")) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
            Date newdate = new Date();
            newdate.setTime(newdate.getTime() + 20L * 24 * 60 * 60 * 1000);
            String strDate = dateFormat.format(newdate);
            System.out.println("Validate start date:" + strDate);
            Assert.assertTrue(quoteDetailsPageObj.coverMTADate(cover).getText().equalsIgnoreCase(strDate));
        } else if (date.equalsIgnoreCase("effective futuredate")) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
            Date newdate = new Date();
            newdate.setTime(newdate.getTime() + 5L * 24 * 60 * 60 * 1000);
            String strDate = dateFormat.format(newdate);
            System.out.println("Validate start date:" + strDate);
            Assert.assertTrue(quoteDetailsPageObj.coverMTADate(cover).getText().equalsIgnoreCase(strDate));
        } else if (date.equalsIgnoreCase("backdated")) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
            Date newdate = new Date();
            newdate.setTime(newdate.getTime() + 30L * 24 * 60 * 60 * 1000);
            String strDate = dateFormat.format(newdate);
            System.out.println("System date:" + strDate);
            Assert.assertTrue(quoteDetailsPageObj.coverMTADate(cover).getText().equalsIgnoreCase(strDate));
        }
    }

    public void enterPaymentCredentials(List<List<String>> paymentCredentails) {
        System.out.println(" Entering into payment credentails method....1....");
        if (nextEventPageObj.elementDisplayed(By.xpath(quoteDetailsPageObj.txtPaymentUsername()))) {
            System.out.println(" Entering into payment credentails method....2....");
            for (int i = 1; i < paymentCredentails.size(); i++) {
                for (int j = 0; j < paymentCredentails.get(i).size(); j++) {
                    this.addPaymentDetails(paymentCredentails.get(0).get(j), paymentCredentails.get(i).get(j));
                }
            }
            quoteDetailsPageObj.btnSave().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        } else {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void selectEffectiveStartDate(int days) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.txtStartDate().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
        SimpleDateFormat sd = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        c.add(Calendar.DATE, days);
        String fMonth = sdf.format(c.getTime());
        String futureMonth = fMonth.trim().split(" ")[0];
        String fDate = sd.format(c.getTime());
        System.out.println("Future Month --" + fMonth);
        System.out.println("Date Format---" + futureMonth);
        System.out.println("*****Future date***" + fDate);
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.lblmonth());
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.drpdnFMonth().click();
        Select sMonth = new Select(quoteDetailsPageObj.drpdnFMonth());
        System.out.println(" Month needs to be selected is ------------- " + futureMonth);
        nextEventPageObj.waitForMoreTime();
        sMonth.selectByVisibleText(futureMonth);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.dateTable());
        WebElement dateWidget = quoteDetailsPageObj.dateTable();
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
        int selectDate = Integer.parseInt(fDate);
        System.out.println("Date in int format --" + selectDate);
        for (WebElement dateCell : columns) {
            dateCell.findElement(By.xpath("//td[@data-day='" + selectDate + "']")).click();
            break;
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void verifyPaymentDetails(List<List<String>> coverDetail) throws ParseException {
        claimPaymentPageObj.purchaseBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        int scheduleDateCol = 2;
        int collectionDateCol = 3;
        int amountCol = 8;
        for (int i = 1; i < coverDetail.size(); i++) {
            for (int j = 0; j < coverDetail.get(0).size(); j++) {
                switch (coverDetail.get(0).get(j).toLowerCase()) {
                    case "schedule date":
                        String scheduleDateFromPage = claimPaymentPageObj.paymentScheduleTable(scheduleDateCol).getText();
                        System.out.println("Date--------------schedule------------------" + scheduleDateFromPage);
                        System.out.println("Date--------------schedule------------------" + new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()).toString());
                        Assert.assertTrue(scheduleDateFromPage.equalsIgnoreCase(new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()).toString()));
                        break;
                    case "collection date":
                        String collectionDateFromPage = claimPaymentPageObj.paymentScheduleTable(collectionDateCol).getText();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar c = Calendar.getInstance();
                        c.add(Calendar.DATE, 14);
                        date = sdf.format(c.getTime());
                        String returnValue = date;
                        System.out.println("***** Date ***" + returnValue);
                        String CalculatedCollectionDate = returnValue;
                        System.out.println("Date--------------schedule------------------" + collectionDateFromPage);
                        System.out.println("Date--------------schedule------------------" + CalculatedCollectionDate);
                        Assert.assertTrue(collectionDateFromPage.equals(CalculatedCollectionDate));
                        break;
                    case "amount":
                        String amount = claimPaymentPageObj.paymentScheduleTable(amountCol).getText();
                        System.out.println("Date--------------amount------------------" + amount);
                        System.out.println("Date--------------amount------------------" + coverDetail.get(i).get(j));
                        Assert.assertTrue(amount.equalsIgnoreCase(coverDetail.get(i).get(j)));
                        break;
                    case "cover":
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        claimPaymentPageObj.paymentScheduleDetails(coverDetail.get(i).get(j)).click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "account information":
                        nextEventPageObj.waitForMoreTime();
                        System.out.println("Going into Account information");
                        claimPaymentPageObj.accountInformationDetails(coverDetail.get(i).get(j)).click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "account number":
                        System.out.println("Account number from purchase--------------------------" + claimPaymentPageObj.accountNumberInPurchase().isDisplayed());
                        System.out.println("Account number from purchase--------------------------" + claimPaymentPageObj.accountNumberInPurchase().getText());
                        Assert.assertTrue(claimPaymentPageObj.accountNumberInPurchase().getText().equalsIgnoreCase(coverDetail.get(i).get(j)));
                        break;
                    case "sort code":
                        System.out.println("Sort code from purchase--------------------------" + claimPaymentPageObj.sortCodeInPurchase().getText());
                        Assert.assertTrue(claimPaymentPageObj.sortCodeInPurchase().getText().equalsIgnoreCase(coverDetail.get(i).get(j)));
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        claimPaymentPageObj.cancelBtnAccountInformation().click();
                        nextEventPageObj.waitForPageLoad();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                }
            }
            claimPaymentPageObj.cancelBtnPayment().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void retrieveRandomCustomerName() {
        randomCustomerFirstName = accountInformationPageObj.randomCusomerFirstName().getText();
        randomCustomerLastName = accountInformationPageObj.randomCusomerLastName().getText();
        System.out.println("Random user last name ----" + randomCustomerLastName);
        randomCustomerFullName = randomCustomerFirstName.concat(" " + randomCustomerLastName);
        System.out.println("Random customer Full Name" + randomCustomerFullName);
    }

    public String getRandomCustomerLastName() {
        randomCustomerLastName = accountInformationPageObj.randomCusomerLastName().getText();
        System.out.println("Random user last name ----" + randomCustomerLastName);
        return randomCustomerLastName;
    }

    public String backdate() {
        String local = "";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date myDate = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.add(Calendar.DATE, -2);
        System.out.println(dateFormat.format(cal.getTime()));
        local = dateFormat.format(cal.getTime()).toString();
        System.out.println("Manipulated date" + local);
        return local;
    }

    public void expireBasePolicy() {
        quoteDetailsPageObj.basePolicyLink().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteRenewalPageObj.txtQInceptionDate().clear();
        quoteRenewalPageObj.txtQInceptionDate().sendKeys(this.backdate());
        quoteRenewalPageObj.txtQStartDate().clear();
        quoteRenewalPageObj.txtQStartDate().sendKeys(this.backdate());
        quoteRenewalPageObj.txtQEndDate().clear();
        quoteRenewalPageObj.txtQEndDate().sendKeys(this.backdate());
        quoteRenewalPageObj.saveAndClose().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateUpgradeDetails(String cover, List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.validateStartAndEndDate(parameters.get(0).get(column), parameters.get(row).get(column), cover);
            }
        }
    }

    private void validateStartAndEndDate(String fieldName, String fieldValue, String cover) {
        switch (fieldName.toLowerCase()) {
            case "startdate":
                System.out.println("Cover start date is ------" + dateOperationsObj.tripDate(fieldValue));
                Assert.assertTrue(quoteRenewalPageObj.lblCoverStartDate(cover).getText().equalsIgnoreCase(dateOperationsObj.tripDate(fieldValue)));
                break;
            case "enddate":
                if (fieldValue.equalsIgnoreCase("previousdayoftripstartdate") || fieldValue.equalsIgnoreCase("futuredate1month")
                        || fieldValue.equalsIgnoreCase("futuredate22days")) {
                    System.out.println("Cover end date is ------" + dateOperationsObj.tripDate(fieldValue));
                    Assert.assertTrue(quoteRenewalPageObj.lblCoverEndDate(cover).getText().equalsIgnoreCase(dateOperationsObj.tripDate(fieldValue)));
                } else {
                    Assert.assertTrue(quoteRenewalPageObj.lblCoverEndDate(cover).getText().equalsIgnoreCase(dateOperationsObj.tripDate(fieldValue)));
                }
                break;
        }
    }

    public void verifyPermiumValueForSelectedUpgrade(String cover, String premium) {
        double dPremium = 0;
        if (premium.equalsIgnoreCase("original")) {
            dPremium = Double.parseDouble(rulesEngineOperationObj.originalRawPremium);
        } else {
            dPremium = Double.parseDouble(premium);
        }
        System.out.println("Raw Premium========="+ dPremium);
        String premiumValue = "";
        /*if (cover.equalsIgnoreCase("Guest Extension")) {
            premiumValue = quoteDetailsPageObj.permiumForGuestExt(cover).getText();
        } else {
            premiumValue = quoteDetailsPageObj.permiumForcover(cover).getText();
        }*/
        quoteDetailsPageObj.waitForMoreTime();
        quoteDetailsPageObj.waitForMoreTime();
        quoteDetailsPageObj.waitForMoreTime();
        quoteDetailsPageObj.waitForMoreTime();
        quoteDetailsPageObj.waitForMoreTime();
        premiumValue = quoteDetailsPageObj.permiumForcover(cover).getText();
        System.out.println("premium value--------------------" + premiumValue);
        System.out.println("premiumValue.substring(1)-----------------" + premiumValue.substring(1).replace(".00", ""));
        String replacedPermiumVal = "";
        double dpremiumValueFromPage = 0;
        if (premiumValue.contains(".00")) {
            replacedPermiumVal = premiumValue.substring(1).replace(".00", "");
            dpremiumValueFromPage = Integer.parseInt(replacedPermiumVal);
        } else {
            dpremiumValueFromPage = Double.parseDouble(premiumValue.substring(1).replace(".00", ""));
        }
        System.out.println("ipremiumValueFromPage-----------" + dpremiumValueFromPage);
        String replacedtaxValueFromScreen = taxForSpecificRegion.replace(".00", "");
        System.out.println("replacedtaxValueFromScreen----------" + replacedtaxValueFromScreen);
        double dtaxForSpecificRegion = Integer.parseInt(replacedtaxValueFromScreen);
        System.out.println("itaxForSpecificRegion----------------" + dtaxForSpecificRegion);
        System.out.println("(dtaxForSpecificRegion/100)-----------" + (dtaxForSpecificRegion / 100));
        double dIPTApplied = 0;
        dIPTApplied = dPremium * (dtaxForSpecificRegion / 100);
        System.out.println("ipremiumValue------------" + dIPTApplied);
        System.out.println("(dIPTApplied+dPremium)------------" + (dIPTApplied + dPremium));
        double roundoff = Math.round((dIPTApplied + dPremium) * 100.0) / 100.0;
        System.out.println("rounded value to compare ---------------------" + roundoff);
        Assert.assertTrue(roundoff == dpremiumValueFromPage);
        quoteDetailsPageObj.btnClick(quoteDetailsPageObj.nextButton());
    }

    public void getIPTValueForRegion(String region) {
        taxForSpecificRegion = iAdminSecurityManagementPageObj.iptValueForSpecificRegion(region).getAttribute("value");
        System.out.println("taxForSpecificRegion--------------------" + taxForSpecificRegion);
//        quoteDetailsPageObj.btnSaveAndClose().click();
        nextEventPageObj.btnClick(quoteDetailsPageObj.btnSaveAndClose());

    }

    public void captureAndValidateEffectiveDate() {
        startDate = quoteDetailsPageObj.txtStartDate().getAttribute("value");
        System.out.println("Given start date of a upgrades -------------" + startDate);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.nextButton().click();
        nextEventPageObj.waitForMoreTime();
        String effectiveDate = quoteDetailsPageObj.lblLatestQuoteEffectiveDate().getText();
        System.out.println("Effective date of latest quote -------------" + effectiveDate);
        Assert.assertEquals(startDate, effectiveDate);
    }

    public void getIPTValueForPostCode(String postCode) {
        String region = postCode.substring(0, 3);
        System.out.println("taxForSpecificRegion--------------------" + region);
        System.out.println("Tax region percent" + iAdminSecurityManagementPageObj.validateIPTRegion(region).getAttribute("value"));
        if (iAdminSecurityManagementPageObj.validateIPTRegion(region).getAttribute("value").contains(region)) {
            taxForSpecificRegion = iAdminSecurityManagementPageObj.retrieveValueFromTaxRegion(region).getAttribute("value");
        }
        System.out.println("taxForSpecificRegion--------------------" + taxForSpecificRegion);
    }

    public void retrievePurchasedUpgradePrice(List<String> upgrades) {
        for (int i = 1; i < upgrades.size(); i++) {
            String cover = upgrades.get(i);
            System.out.println("Cover retrieved from purchase" + cover);
            switch (cover) {
                case "Medical Cover":
                    currentYearMedicalUpgradePrice = rulesEnginePageObj.retrievePremiumValueForUpgradeInschemeSummary(cover).getText();
                    System.out.println("current year Medical price" + currentYearMedicalUpgradePrice);
                    break;
                case "Business Cover":
                    currentYearBusinessUpgradePrice = rulesEnginePageObj.retrievePremiumValueForUpgradeInschemeSummary(cover).getText();
                    System.out.println("current year Business price" + currentYearMedicalUpgradePrice);
                    break;
                case "Golf cover ":
                    currentYearGolfUpgradePrice = rulesEnginePageObj.retrievePremiumValueForUpgradeInschemeSummary(cover).getText();
                    System.out.println("current year golf price" + currentYearGolfUpgradePrice);
                    break;
            }
        }
    }

    public void floorAndCeilingAlgorithm(List<String> upgrades) {
        for (int i = 1; i < upgrades.size(); i++) {
            String cover = upgrades.get(i);
            System.out.println("Cover retrieved from purchase" + cover);
            switch (cover) {
                case "Medical Cover":
                    updatedMedicalUpgradePrice = rulesEnginePageObj.retrievePremiumValueForUpgradeInschemeSummary(cover).getText();
                    System.out.println("current year Medical price" + currentYearMedicalUpgradePrice);
                    this.calculatePrice(cover);
                    break;
                case "Business Cover":
                    updatedBusinessUpgradePrice = rulesEnginePageObj.retrievePremiumValueForUpgradeInschemeSummary(cover).getText();
                    System.out.println("current year Business price" + currentYearMedicalUpgradePrice);
                    this.calculatePrice(cover);
                    break;
                case "Golf cover ":
                    updatedGolfUpgradePrice = rulesEnginePageObj.retrievePremiumValueForUpgradeInschemeSummary(cover).getText();
                    System.out.println("current year golf price" + currentYearGolfUpgradePrice);
                    this.calculatePrice(cover);
                    break;
            }
        }
    }

    public void calculatePrice(String cover) {
        double currentYearMedicalUpgradePrice_calc = 0.00;
        double currentYearBusinessUpgradePrice_calc = 0.00;
        double currentYearGolfUpgradePrice_calc = 0.00;
        double updatedMedicalUpgradePrice_calc = 0.00;
        double updatedBusinessUpgradePrice_calc = 0.00;
        double updatedGolfUpgradePrice_calc = 0.00;
        double percentDifference = 0.00;
        if (cover.equalsIgnoreCase("Medical Cover")) {
            currentYearMedicalUpgradePrice_calc = Double.parseDouble(currentYearMedicalUpgradePrice);
            updatedMedicalUpgradePrice_calc = Double.parseDouble(updatedMedicalUpgradePrice);
            percentDifference = (currentYearMedicalUpgradePrice_calc - updatedMedicalUpgradePrice_calc) / currentYearMedicalUpgradePrice_calc;
            if (percentDifference > 25.00) {
                Assert.assertTrue(currentYearMedicalUpgradePrice_calc * 1.25 == updatedMedicalUpgradePrice_calc);
            } else if (percentDifference < 25.00) {
                Assert.assertTrue(currentYearMedicalUpgradePrice_calc == updatedMedicalUpgradePrice_calc);
            }
        } else if (cover.equalsIgnoreCase("Business Cover")) {
            currentYearBusinessUpgradePrice_calc = Double.parseDouble(currentYearBusinessUpgradePrice);
            updatedBusinessUpgradePrice_calc = Double.parseDouble(updatedBusinessUpgradePrice);
            percentDifference = (updatedBusinessUpgradePrice_calc - currentYearBusinessUpgradePrice_calc) / currentYearBusinessUpgradePrice_calc;
            if (percentDifference > 25.00) {
                Assert.assertTrue(currentYearBusinessUpgradePrice_calc * 1.25 == updatedBusinessUpgradePrice_calc);
            } else if (percentDifference < 25.00) {
                Assert.assertTrue(currentYearBusinessUpgradePrice_calc == updatedBusinessUpgradePrice_calc);
            }
        } else if (cover.equalsIgnoreCase("Golf cover")) {
            currentYearGolfUpgradePrice_calc = Double.parseDouble(currentYearGolfUpgradePrice);
            updatedGolfUpgradePrice_calc = Double.parseDouble(updatedGolfUpgradePrice);
            percentDifference = (updatedGolfUpgradePrice_calc - currentYearGolfUpgradePrice_calc) / currentYearGolfUpgradePrice_calc;
            if (percentDifference > 25.00) {
                Assert.assertTrue(currentYearGolfUpgradePrice_calc * 1.25 == updatedGolfUpgradePrice_calc);
            } else if (percentDifference < 25.00) {
                Assert.assertTrue(currentYearGolfUpgradePrice_calc == updatedGolfUpgradePrice_calc);
            }
        }
    }

    public void renewlQuoteEditbtn() {
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.editBtnInRenewal().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void amendMedicalcondition() {
        System.out.println("Amend medical condition-------------------");
        nextEventPageObj.btnClick(quoteDetailsPageObj.editBtnMedicalCondition());
    }

    public void captureLatestRenewalQuoteExpiryDate() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        renewalQuoteExpiryDate = quoteDetailsPageObj.captureExpiryDateOfLatestRenewalQuote().getText();
        System.out.println("Retrieved renewal quote date from AQ" + renewalQuoteExpiryDate);
    }

    public void validateLatestActiveQuoteExpiryDate() {
        nextEventPageObj.switchToDefault();
        System.out.println("Retreieved amend date" + quoteDetailsPageObj.captureExpiryDateOfLatestRenewalQuote().getText());
        System.out.println("stored quote date" + renewalQuoteExpiryDate);
        Assert.assertTrue(renewalQuoteExpiryDate.equalsIgnoreCase(quoteDetailsPageObj.captureExpiryDateOfLatestRenewalQuote().getText()));
    }

    public void verifyAnnualUpgradeSaved(String fixedUpgrades) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.firstRecordInQuoteListArrow().click();
        for (int i = 0; i < fixedUpgrades.split("#").length; i++) {
            System.out.println("quoteDetailsPageObj.fixedUpgradesSaved(fixedUpgrades.split(\"#\")[i]).isDisplayed()------------" + quoteDetailsPageObj.fixedUpgradesSaved(fixedUpgrades.split("#")[i]).isDisplayed());
            Assert.assertTrue(quoteDetailsPageObj.fixedUpgradesSaved(fixedUpgrades.split("#")[i]).isDisplayed());
        }
        quoteDetailsPageObj.firstRecordInQuoteListArrow().click();
    }

    public void retrieveQVPBeforeRenewal() {
        qvpBeforeRenewal = quoteDetailsPageObj.qvpValueForRenewalRenewal().getText();
    }

    public void verifyQVPAfterRenewal() {
        String qvpAfterRenewal = quoteDetailsPageObj.qvpValueForRenewalRenewal().getText();
        System.out.println("qvpBeforeRenewal---------------------------" + qvpBeforeRenewal);
        System.out.println("qvpAfterRenewal---------------------------" + qvpAfterRenewal);
        Assert.assertTrue(qvpBeforeRenewal.equalsIgnoreCase(qvpAfterRenewal));
    }

    public void verifyPremiumValueForSelectedUpgradeInQuoteDetails(String cover, String premium) {
        double dPremium = 0;
        System.out.println("rulesEngineOperationObj.existingUpgradeCost-------------" + rulesEngineOperationObj.existingUpgradeCost);
        if (premium.equalsIgnoreCase("original")) {
            dPremium = Double.parseDouble(rulesEngineOperationObj.existingUpgradeCost);
            System.out.println("value of dPremium-----" + dPremium);
        } else {
            dPremium = Double.parseDouble(premium);
            System.out.println("value of dPremium-----" + dPremium);
        }
        String premiumValue = quoteDetailsPageObj.validatePremiumInQuoteList(cover).getText();
        System.out.println("premium value--------------------" + premiumValue);
        System.out.println("premiumValue.substring(1)-----------------" + premiumValue.substring(1).replace(".00", ""));
        String replacedPermiumVal = premiumValue.substring(1).replace(".00", "");
        double dpremiumValueFromPage = Float.parseFloat(replacedPermiumVal);
        DecimalFormat df = new DecimalFormat("##.00");
        System.out.println("ipremiumValueFromPage-----------" + df.format(dpremiumValueFromPage));
        String replacedtaxValueFromScreen = taxForSpecificRegion;
        System.out.println("replacedtaxValueFromScreen----------" + replacedtaxValueFromScreen);
        double dtaxForSpecificRegion = Float.parseFloat(replacedtaxValueFromScreen);
        System.out.println("itaxForSpecificRegion----------------" + df.format(dtaxForSpecificRegion));
        System.out.println("(dtaxForSpecificRegion/100)-----------" + df.format(dtaxForSpecificRegion / 100));
        double dIPTApplied = 0;
        System.out.println("value of dPremium------------" + df.format(dPremium));
        dIPTApplied = dPremium * (dtaxForSpecificRegion / 100);
        System.out.println("ipremiumValue------------" + df.format(dIPTApplied));
        System.out.println("(dIPTApplied+dPremium)------------" + df.format(dIPTApplied + dPremium));
        Assert.assertTrue(df.format(dIPTApplied + dPremium).equals(df.format(dpremiumValueFromPage)));
        System.out.println("After Assertion Both premium values are same");
        System.out.println("Premium value from digital Basket screen--------------------" + df.format(dpremiumValueFromPage));
        System.out.println("Premium- value calculated from Aquarium page----------------" + df.format(dIPTApplied + dPremium));
        quoteDetailsPageObj.nextButton().click();
    }

    public void validateExpiryDate(String effectiveDate, String expiryDate) {
        Assert.assertTrue(quoteDetailsPageObj.retrieveLatestRenewalQuote_EffectiveDate().getText().equalsIgnoreCase(quoteDetailsPageObj.retrieveLatestRenewalQuote_ExpiryDate().getText()));
    }

    public void validateInsuredPersonsAndConditions(List<List<String>> parameters) {
        quoteDetailsPageObj.leadDetailsTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            quoteDetailsPageObj.namedPeopleTab().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            this.validateInsuredPersonsMedicalCondition(parameters.get(i));
        }
        nextEventPageObj.btnCloseWindow().click();
    }

    public void validateInsuredPersonsMedicalCondition(List<String> questionAndAnswer) {
        String insuredPerson = questionAndAnswer.get(0);
        String condition = questionAndAnswer.get(1);
        insuredPersonsTablerowId = quoteDetailsPageObj.retrieveTableRowidForInsuredPersons(insuredPerson).getText();
        System.out.println("Retreievd Table rowid for the insured person " + insuredPerson + " " + insuredPersonsTablerowId);
        quoteDetailsPageObj.screeningDataTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(quoteDetailsPageObj.validateMedicalConditionforInsuredPerson(insuredPersonsTablerowId, condition).isDisplayed());
    }

    public void validateInsuredPersonsQuestionAndResponses(List<List<String>> parameters) {
        quoteDetailsPageObj.leadDetailsTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            this.validateInsuredPersonsResponses(parameters.get(i));
        }
        nextEventPageObj.btnCloseWindow().click();
    }

    public void validateInsuredPersonsResponses(List<String> questionAndAnswer) {
        String question = questionAndAnswer.get(0);
        String answer = questionAndAnswer.get(1);
        quoteDetailsPageObj.screeningDataTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(quoteDetailsPageObj.validateQuestionAndResponses(question, answer).isDisplayed());
    }

    public void validateScreeningConditionforInsuredPerson(String person, String condition) {
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
        quoteDetailsPageObj.validateQuoteDetails().click();
        Assert.assertTrue(quoteDetailsPageObj.validateMedicalCondition(person, condition).isDisplayed());
    }

    public void convertRenewedQuoteToPolicy() {
        claimOperationObj.clickingUnderNextEventsAndButtons("out of process event");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.navigateToEventType("__TestRenewals");
        quoteRenewalPageObj.chkBk30Days().click();
        quoteRenewalPageObj.chkBk0Days().click();
        quoteRenewalPageObj.chkBxSyncQuoteExpiryDate().click();
        nextEventPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
    }

    public void validatePremiumForInsuredPersons(String person, String condition) {
        if (person.equalsIgnoreCase("random")) {
            System.out.println("Inside if part and customer full name" + this.randomCustomerFullName);
            person = this.randomCustomerFullName;
            System.out.println("Validating Zero medical premium " + quoteDetailsPageObj.validateMedicalPremium(person, condition).getText());
            Assert.assertTrue(quoteDetailsPageObj.validateMedicalPremium(person, condition).getText().equalsIgnoreCase(""));
        } else {
            System.out.println("Validating Zero medical premium " + quoteDetailsPageObj.validateMedicalPremium(person, condition).getText());
            Assert.assertTrue(quoteDetailsPageObj.validateMedicalPremium(person, condition).getText().equalsIgnoreCase(""));
        }
    }

    public void storeUpgradeDetails(String action, String field, List<List<String>> parameters) {
        if (action.equalsIgnoreCase("capture")) {
            for (int i = 1; i < parameters.size(); i++) {
                System.out.println("----------i----------value ---" + i);
                for (int j = 0; j < parameters.get(i).size(); j++) {
                    System.out.println("----------j----------value ---" + j);
                    System.out.println("inside comm pref loop..");
                    this.captureUpgradeDetails(field, parameters.get(i).get(j));
                }
            }
        } else if (action.equalsIgnoreCase("retrieve")) {

        }
    }

    public void captureUpgradeDetails(String field, String upgrade) {
        switch (upgrade) {
            case "Medical Cover":
                System.out.println("Inside Medical Cover ");
                medicalCoverToDate = quoteDetailsPageObj.retrieveUpgradeDetails(field, upgrade).getText();
                System.out.println("Medical cover to date before Renewal" + medicalCoverToDate);
                break;
            case "Business Cover":
                System.out.println("Inside Business Cover ");
                businessCoverToDate = quoteDetailsPageObj.retrieveUpgradeDetails(field, upgrade).getText();
                System.out.println("Business cover to date before Renewal" + businessCoverToDate);
                break;
            case "Golf cover":
                System.out.println("Inside Golf cover ");
                golfCoverToDate = quoteDetailsPageObj.retrieveUpgradeDetails(field, upgrade).getText();
                System.out.println("Golf cover to date before Renewal" + golfCoverToDate);
                break;
            case "Cruise Cover":
                System.out.println("Inside Cruise Cover ");
                cruiseCoverToDate = quoteDetailsPageObj.retrieveUpgradeDetails(field, upgrade).getText();
                System.out.println("Cruise cover to date before Renewal" + cruiseCoverToDate);
                break;
        }
    }

    public void validateRenewalDateForUpgrades(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            this.validateRenewalDate(parameters.get(i).get(0), parameters.get(i).get(1));
        }
    }

    public void validateRenewalDate(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Medical Cover":
                if (fieldValue.equalsIgnoreCase("Renewed")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar c = Calendar.getInstance();
                    c.setTime(new Date());
                    c.add(Calendar.DATE, 364);
                    String medicalCoverRenewDate = sdf.format(c.getTime()).toString();
                    System.out.println("Converted Renew Date" + medicalCoverRenewDate);
                    Assert.assertTrue(quoteDetailsPageObj.retrieveUpgradeCoverToDate(fieldName).getText().equalsIgnoreCase(medicalCoverRenewDate));
                }
                break;
            case "Business Cover":
                if (fieldValue.equalsIgnoreCase("Renewed")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar c = Calendar.getInstance();
                    c.setTime(new Date());
                    c.add(Calendar.DATE, 364);
                    String medicalCoverRenewDate = sdf.format(c.getTime()).toString();
                    System.out.println("Converted Renew Date" + medicalCoverRenewDate);
                    Assert.assertTrue(quoteDetailsPageObj.retrieveUpgradeCoverToDate(fieldName).getText().equalsIgnoreCase(medicalCoverRenewDate));
                }
                break;
            case "Golf cover":
                if (fieldValue.equalsIgnoreCase("Renewed")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar c = Calendar.getInstance();
                    c.setTime(new Date());
                    c.add(Calendar.DATE, 364);
                    String medicalCoverRenewDate = sdf.format(c.getTime()).toString();
                    System.out.println("Converted Renew Date" + medicalCoverRenewDate);
                    Assert.assertTrue(quoteDetailsPageObj.retrieveUpgradeCoverToDate(fieldName).getText().equalsIgnoreCase(medicalCoverRenewDate));
                }
                break;
            case "Cruise Cover":
                if (fieldValue.equalsIgnoreCase("Not Renewed")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar c = Calendar.getInstance();
                    c.setTime(new Date());
                    c.add(Calendar.DATE, -1);
                    String medicalCoverRenewDate = sdf.format(c.getTime()).toString();
                    System.out.println("Converted Renew Date" + medicalCoverRenewDate);
                    Assert.assertTrue(quoteDetailsPageObj.retrieveUpgradeCoverToDate(fieldName).getText().equalsIgnoreCase(medicalCoverRenewDate));
                }
                break;
        }
    }

    public void validateUpgradePaymentOption(List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(quoteDetailsPageObj.purchasesTab());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            this.validateAccountInformationoftheUpgrades(parameters.get(i).get(0), parameters.get(i).get(1));
        }
        nextEventPageObj.btnClick(quoteDetailsPageObj.purchasesBackbtn());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateAccountInformationoftheUpgrades(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Medical Cover":
                quoteDetailsPageObj.upgradesAccountInformation(fieldName).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (fieldValue.equalsIgnoreCase("Pay By Direct Debit")) {
                    Assert.assertTrue(quoteDetailsPageObj.accountType().getText().equalsIgnoreCase("Bank"));
                } else if (fieldValue.equalsIgnoreCase("Pay By Card")) {
                    Assert.assertTrue(quoteDetailsPageObj.accountType().getText().equalsIgnoreCase("Card"));
                }
                break;
            case "Business Cover":
                quoteDetailsPageObj.upgradesAccountInformation(fieldName).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (fieldValue.equalsIgnoreCase("Pay By Direct Debit")) {
                    Assert.assertTrue(quoteDetailsPageObj.accountType().getText().equalsIgnoreCase("Bank"));
                } else if (fieldValue.equalsIgnoreCase("Pay By Card")) {
                    Assert.assertTrue(quoteDetailsPageObj.accountType().getText().equalsIgnoreCase("Card"));
                }
                break;
            case "Golf cover":
                quoteDetailsPageObj.upgradesAccountInformation(fieldName).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (fieldValue.equalsIgnoreCase("Pay By Direct Debit")) {
                    Assert.assertTrue(quoteDetailsPageObj.accountType().getText().equalsIgnoreCase("Bank"));
                } else if (fieldValue.equalsIgnoreCase("Pay By Card")) {
                    Assert.assertTrue(quoteDetailsPageObj.accountType().getText().equalsIgnoreCase("Card"));
                }
                break;
        }
        quoteDetailsPageObj.accountCancelbtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public String GuestDobDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String returnValue = null;
        switch (date.toLowerCase()) {
            case "reached23years":
                c.add(Calendar.YEAR, -23);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, 0);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "reached24years":
                c.add(Calendar.YEAR, -24);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, 0);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "reached18years":
                c.add(Calendar.YEAR, -18);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, 0);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "dob23yearsbackedfor30days":
                c.add(Calendar.YEAR, -23);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, 30);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "dob23yearsbackedfor7days":
                c.add(Calendar.YEAR, -23);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, 7);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "dob18yearsbackedfor30days":
                c.add(Calendar.YEAR, -18);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, 30);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "dob18yearsbackedfor7days":
                c.add(Calendar.YEAR, -18);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, 7);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
        }
        return returnValue;
    }

    public void verifyBankDetails() {
        nextEventPageObj.btnClick(quoteDetailsPageObj.editBankDetails());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(quoteDetailsPageObj.bankAccountDetailsTab());
        System.out.println("Checked attribute value" + quoteDetailsPageObj.isthePackagedBankAccountChkBox().getAttribute("checked"));
        Assert.assertTrue(quoteDetailsPageObj.isthePackagedBankAccountChkBox().getAttribute("checked").equalsIgnoreCase("true"));
        Assert.assertTrue(quoteDetailsPageObj.usePaperlessDDChkBox().getAttribute("checked").equalsIgnoreCase("true"));
        Assert.assertTrue(quoteDetailsPageObj.bACSFailureHistoryAmount().getText().equals("60.00"));
        nextEventPageObj.btnClick(nextEventPageObj.btnCloseWindow());
    }
    public void verifyCPA() {
        claimOperationObj.clickingUnderNextEventsAndButtons("View billing details");
        nextEventPageObj.btnClick(quoteDetailsPageObj.selectLastMatterList());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(quoteDetailsPageObj.cardAccountDetailsTab());
        System.out.println("Checked attribute value" + quoteDetailsPageObj.cpaChkBox().getAttribute("checked"));
        Assert.assertTrue(quoteDetailsPageObj.cpaChkBox().getAttribute("checked").equalsIgnoreCase("true"));
        nextEventPageObj.btnClick(nextEventPageObj.btnCloseWindow());
    }

    public void verifyExcludedCondition() {
        String message = quoteDetailsPageObj.excludingMessage().getText();
        System.out.println("Excluded message is " + quoteDetailsPageObj.excludingMessage());
        System.out.println("Excluded message is " + message);
        Assert.assertTrue(quoteDetailsPageObj.excludingMessage().isDisplayed());
    }

    public void validateAddedPersonDropDownValues(List<String> parameters) {
        Assert.assertTrue(selectObj.validateValuesInDropDown(quoteDetailsPageObj.relationshipOfNewPerson(), parameters));
    }

    public void enterPersondetailsOfAdditionalPerson(List<List<String>> personDetails) {
        for (int i = 1; i < personDetails.size(); i++) {
            for (int j = 0; j < personDetails.get(i).size(); j++) {
                nextEventPageObj.btnClick(quoteDetailsPageObj.addPersonIcon());
                this.addPersonDetails(personDetails.get(0).get(j), personDetails.get(i).get(j));

            }
        }
    }

    public void validatePartialQuote() {
        String txtPartialQuote = quoteDetailsPageObj.lblPartialQuoteDetails().getText();
        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(quoteDetailsPageObj.lblPartialQuote())));
        Date now = new Date();
        SimpleDateFormat date = new SimpleDateFormat("MMM d yyyy h");
        SimpleDateFormat year = new SimpleDateFormat("yyyy");
        SimpleDateFormat time = new SimpleDateFormat("h:mma");
        date.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        time.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println("UK Date----" + date.format(GregorianCalendar.getInstance().getTime()));
        System.out.println("UK time----" + time.format(GregorianCalendar.getInstance().getTime()));
        System.out.println("Date/Time from appl-------------" + txtPartialQuote.split("on ")[1].split(":")[0]);
        System.out.println("Time from appl-------------" + txtPartialQuote.split(year.format(GregorianCalendar.getInstance().getTime()))[1].trim());
        Assert.assertTrue(txtPartialQuote.split("on ")[1].split(":")[0].trim().equals(date.format(GregorianCalendar.getInstance().getTime())));
    }

    public void validateInsuredPersons(List<String> parameter) {
        accountInformationPageObj.quoteAndBuyLink();
        accountInformationPageObj.btnClick(accountInformationPageObj.quoteAndBuyLink());
        nextEventPageObj.waitForPageLoad();
        this.navigateToSpecificScreen("next");
        for (int i = 0; i < parameter.size(); i++) {
            System.out.println("i value ----" + i);
            System.out.println("Insured Persons-----" + parameter.get(i));
            Assert.assertTrue(quoteDetailsPageObj.txtSelectedGuest(parameter.get(i)).isDisplayed());
        }
        nextEventPageObj.waitForPageLoad();
    }

    public void validatePartialOnlineQuoteDetails(List<List<String>> parameter) {
        this.clickOnNext();
        for (int i = 1; i < parameter.size(); i++) {
            for (int j = 0; j < parameter.get(i).size(); j++) {
                this.verifyPartialQuoteDetails(parameter.get(0).get(j), parameter.get(i).get(j));
            }
        }
    }

    private void verifyPartialQuoteDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "added person":
                this.clickOnNext();
                Assert.assertTrue(quoteDetailsPageObj.txtSelectedGuest(fieldValue).isDisplayed());
                break;
            case "amended medical condition":
            case "added medical condition":
                Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(quoteDetailsPageObj.lblMedicalCondition(fieldValue))));
                break;
            case "selected annual upgrades":
                this.clickOnNext();
                String[] covers = fieldValue.split("#");
                for (int k = 0; k < covers.length; k++) {
                    System.out.println("Validating selected upgrades------" + covers[k]);
                    Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(quoteDetailsPageObj.selectedUpgrades(covers[k]))));
                }
                break;
            case "customer selected upgrades":
                String[] cover = fieldValue.split("#");
                for (int k = 0; k < cover.length; k++) {
                    System.out.println("Validating customer selected upgrades------" + cover[k]);
                    Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(quoteDetailsPageObj.selectedUpgrades(cover[k]))));
                }
                break;
        }
    }

    public void navigateToAQ() {
        quoteDetailsPageObj.lnkToAQ().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void clickOnNext() {
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.btnClick(quoteDetailsPageObj.btnNext());
        nextEventPageObj.waitForMoreTime();
    }

    public void validateRenewalQuote() {
        try {
            Thread.sleep(61000L);
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            System.out.println("Validate Renewal Quote..");
            Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(quoteDetailsPageObj.renewalQuote())));
        } catch (AssertionError exe) {
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            System.out.println("Validate Renewal Quote....Catch block1...");
            Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(quoteDetailsPageObj.renewalQuote())));
        } catch (Exception e) {
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            System.out.println("Validate Renewal Quote....Catch block2...");
            Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(quoteDetailsPageObj.renewalQuote())));
        }
    }

    public boolean verifyIfCoverAlreadyPurchased(String coverName) {
        boolean isCoverPurchased = false;
        try {
            isCoverPurchased = quoteDetailsPageObj.coverUpgraded(coverName).isDisplayed();
        } catch (Exception ex) {
            isCoverPurchased = false;
            return isCoverPurchased;
        }
        return isCoverPurchased;
    }

    public void upgradeIfCOverDoesntExists(String strQuoteType, String paymentOption, List<List<String>> lstInputParameters) {
        String coverName = null;
        String buyButton = TTConstants.BUYBUTTON_LABEL;
        for (int i = 0; i < lstInputParameters.get(0).size(); i++) {
            if (lstInputParameters.get(0).get(i).equalsIgnoreCase("Question")) {
                coverName = lstInputParameters.get(1).get(i);
                System.out.println("question-----------------------" + lstInputParameters.get(1).get(i));
            }
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        boolean isCoverAlreadyUpgraded = verifyIfCoverAlreadyPurchased(coverName);
        if (!isCoverAlreadyUpgraded) {
            retrieveRandomCustomerName();
            accountInformationPageObj.quoteAndBuyLink();
            accountInformationPageObj.btnClick(accountInformationPageObj.quoteAndBuyLink());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            createBasicQuote(strQuoteType, lstInputParameters);
            navigateToSpecificScreen(buyButton);
            switch (paymentOption.toLowerCase()) {
                case TTConstants.PAYMENT_BY_CARD:
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.btnClick(quoteDetailsPageObj.chkBxPayByCard());
                    quoteDetailsPageObj.btnClick(quoteDetailsPageObj.billingAddress());
                    break;
                case TTConstants.PAYMENT_BY_DD:
                    quoteDetailsPageObj.btnClick(quoteDetailsPageObj.chkBxPayByDebit());
                    quoteDetailsPageObj.btnClick(quoteDetailsPageObj.soleAuthority());
                    break;
                case TTConstants.PAYMENT_BY_ADD:
                    quoteDetailsPageObj.btnClick(quoteDetailsPageObj.chkBxPayByDebit());
                    break;
            }
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(quoteDetailsPageObj.btnBuyNow());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void validateExpiryDateOfAnnualUpgrade(String upgrade) throws Exception {
        String coverFrom = quoteDetailsPageObj.coverFromDate(upgrade).getText();
        String coverTo = quoteDetailsPageObj.coverToDate(upgrade).getText();
        Date coverFromDate = new SimpleDateFormat("dd/MM/yyyy").parse(coverFrom);
        Date coverToDate = new SimpleDateFormat("dd/MM/yyyy").parse(coverTo);
        long diff = coverToDate.getTime() - coverFromDate.getTime();
        long numberOfDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        System.out.println("Number of Days between two dates" + numberOfDays);
        Assert.assertTrue(Long.toString(numberOfDays).equalsIgnoreCase("364"));
        System.out.println("DAYS VALIDATED");
    }

    public void validateCustomerBarring() {
        if (!commandsObj.elementDisplayedWithLessTime(By.xpath(quoteDetailsPageObj.notification()))) {
            quoteDetailsPageObj.peopleTab().click();
            nextEventPageObj.waitForMoreTime();
        } else {
            Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(quoteDetailsPageObj.notification())));
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            quoteDetailsPageObj.btnDismiss().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            quoteDetailsPageObj.basicTab().click();
        }
    }

    public void validateBarringForPurchase() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(quoteDetailsPageObj.lblStopPurchaseNotification())));
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(quoteDetailsPageObj.btnBuyNowDisabled().isDisplayed());
    }

    public void validateIPTAmountIsDisplayed() {
        String premiumValue = quoteDetailsPageObj.validatePremiumInBasketScreen_ExcludingIPT().getText();
        String replacedPermiumVal = premiumValue.substring(1).replace(".00", "");
        double dpremiumValueFromPage = Integer.parseInt(replacedPermiumVal);
        System.out.println("ipremiumValueFromPage-----------" + dpremiumValueFromPage);
        String replacedtaxValueFromScreen = taxForSpecificRegion.replace(".00", "");
        System.out.println("replacedtaxValueFromScreen----------" + replacedtaxValueFromScreen);
        double dtaxForSpecificRegion = Integer.parseInt(replacedtaxValueFromScreen);
        System.out.println("itaxForSpecificRegion----------------" + dtaxForSpecificRegion);
        System.out.println("(dtaxForSpecificRegion/100)-----------" + (dtaxForSpecificRegion / 100));
        double iptValue = dpremiumValueFromPage * (dtaxForSpecificRegion / 100);
        double dIPTValueFromPage = Integer.parseInt(quoteDetailsPageObj.iptValueInBasketScreen().getText().substring(1).replace(".00", ""));
        System.out.println("-----dIPTValueFromPage-------------------" + dIPTValueFromPage + "--------------iptValue------------------" + iptValue);
        Assert.assertTrue(dIPTValueFromPage == iptValue);
    }

    public void verifyTripExtensionMessage(String message) {
        if (!message.contains("No Warning")) {
            Assert.assertTrue(quoteDetailsPageObj.errorMsgForMoreTripLength(message).isDisplayed());
        }
    }

    public void validateRenewalQuoteDetails(List<List<String>> coverDetails) {
        Assert.assertTrue(quoteDetailsPageObj.latestRenewalQuoteText().isDisplayed());
        quoteDetailsPageObj.selectingQuoteDetails().click();
        for (int i = 1; i < coverDetails.size(); i++) {
            String cover = coverDetails.get(i).get(0);
            System.out.println("----cover----- premium----" + cover);
            if (coverDetails.get(i).get(1).equals("0.00")) {
                System.out.println("No premium value for Upgrade");
            } else {
                System.out.println("----cover----- premium---from application-" + quoteDetailsPageObj.coverAndPremium(cover).getText());
                Assert.assertTrue((quoteDetailsPageObj.coverAndPremium(cover).getText().equals(coverDetails.get(i).get(1))));
            }
        }
    }
}






