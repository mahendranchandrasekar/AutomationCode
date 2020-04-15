package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static co.uk.directlinegroup.tt.utils.CustomerPortalLoginOperations.incorrectPassword;

/**
 * Created by 588800 on 10/4/2017.
 */
public class DigitalOperations {
    private NextEventPage nextEventPageObj = new NextEventPage();
    private User userObj = new User();
    private CommPrefOperations commPrefOperationsObj = new CommPrefOperations();
    private ClaimsOperations claimOperationObj = new ClaimsOperations();
    private QuoteDetailsPage quoteDetailsPageObj = new QuoteDetailsPage();
    private QuoteAndBuyOperations quoteAndBuyOperationsObj = new QuoteAndBuyOperations();
    private CustomerPortalQuotePage customerPortalQuotePageObj = new CustomerPortalQuotePage();
    private Commands commandsObj = new Commands();
    private PolicyOperations policyOperationsObj = new PolicyOperations();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private LeftNavPanePage leftNavPanePageObj = new LeftNavPanePage();
    private ConfigureEventsOperations configureEventsOperationsObj = new ConfigureEventsOperations();
    private co.uk.directlinegroup.tt.utils.Navigation navigationObj = new co.uk.directlinegroup.tt.utils.Navigation();
    private CustomerPortalHomeOperations customerPortalHomeOperationsObj = new CustomerPortalHomeOperations();
    private PerformSearch performSearchObj = new PerformSearch();
    private SearchPage searchPageObj = new SearchPage();
    private CustomerPortalSignInPage customerPortalSignInPageObj = new CustomerPortalSignInPage();
    private RandomGenerator randomGeneratorObj = new RandomGenerator();
    private CustomerPortalHomePage customerPortalHomePageObj = new CustomerPortalHomePage();
    private CustomerPortalMyClaimsOperations customerPortalMyClaimsOperationsObj = new CustomerPortalMyClaimsOperations();
    private FileOperations fileOperationsObj = new FileOperations();

    public static String envTOAppendInTargetURL = "";
    public static String randomUserLname = "";
    public static String accountNo = "";
    public static String strCoverages = "";

    public void loginAQ(String user) {
        String strEnvProfile = System.getProperty("ENV");
        System.out.println(strEnvProfile);
        if (strEnvProfile.contains("QA")) {
            envTOAppendInTargetURL = "qa";
        } else if (strEnvProfile.contains("SIT")) {
            envTOAppendInTargetURL = "integration";
        }
        String strURL = fileOperationsObj.getApplicationURL(strEnvProfile);
        nextEventPageObj.getDriver.get(strURL);
        List<String> userDet = userObj.getUserDetails(user);
        String loginUserName = userDet.get(1);
        String loginPwd = userDet.get(2);
        userObj.login(loginUserName, loginPwd);
    }

    public void createCustomerInAQ(String customer, List<List<String>> parameters) throws Throwable {
        List<List<String>> newParameters = commandsObj.parameterMappingNew(1, parameters, LoadTTPropertiesFiles.DIGITALCUSTOMERSETUP_PROP);
        navigationObj.navigateToSearchScreen();
        commandsObj.waitForObject(searchPageObj.standardSearch());
        Assert.assertTrue(searchPageObj.standardSearch().isDisplayed());
        performSearchObj.clientSearch(newParameters);
        List<WebElement> lstRows = searchPageObj.searchResultTable().findElements(By.tagName("tr"));
        System.out.println("lstRows.size()=====" + lstRows.size());
        if (lstRows.size() <= 2) {
            nextEventPageObj.waitForMoreTime();
            try {
                if (searchPageObj.createNewCustomerDisplayed()) {
                    System.out.println("clicking create new customer");
                    searchPageObj.btnClick(searchPageObj.createNewCustomer());
                }
            } catch (org.openqa.selenium.WebDriverException ex) {
                if (nextEventPageObj.loadingPage()) {
                    if (searchPageObj.createNewCustomerDisplayed()) {
                        searchPageObj.btnClick(searchPageObj.createNewCustomer());
                    }
                }
            }
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            policyOperationsObj.createCustomer(customer, newParameters);
            if (commandsObj.elementDisplayedWithLessTime(By.id(policyDataFieldsPageObj.updateCustomerId()))) {
                policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.updateCustomer());
            }
            nextEventPageObj.waitForMoreTime();
            commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);

            try {
                if (nextEventPageObj.goDisplayed()) {
                    nextEventPageObj.btnClick(nextEventPageObj.go());
                }
            } catch (org.openqa.selenium.WebDriverException ex) {
                if (nextEventPageObj.loadingPage()) {
                    if (nextEventPageObj.goDisplayed()) {
                        nextEventPageObj.btnClick(nextEventPageObj.go());
                    }
                }
            }
            policyOperationsObj.createPolicy(customer, newParameters);
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.policySave());
            nextEventPageObj.waitForMoreTime();
            policyOperationsObj.updateAddress(customer, newParameters);
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(policyDataFieldsPageObj.policySave());
            nextEventPageObj.waitForMoreTime();
            this.createComms(customer, newParameters);
            if (System.getProperty("driverType") != null && System.getProperty("driverType").equalsIgnoreCase("ie")) {
                Thread.sleep(15000);
            }
            System.out.println("going to wait first time.....");
            nextEventPageObj.btnClick(policyDataFieldsPageObj.policySave());
            if (System.getProperty("driverType") != null && System.getProperty("driverType").equalsIgnoreCase("ie")) {
                Thread.sleep(15000);
            }
            System.out.println("going to wait second time.....");
            nextEventPageObj.waitForMoreTime();
            if (System.getProperty("driverType") != null && System.getProperty("driverType").equalsIgnoreCase("ie")) {
                Thread.sleep(15000);
            }
            //Comment for MVP build change
           /* try {
                if (nextEventPageObj.goDisplayed()) {
                    nextEventPageObj.btnClick(nextEventPageObj.go());
                }
            } catch (org.openqa.selenium.WebDriverException ex) {
                if (nextEventPageObj.loadingPage()) {
                    if (nextEventPageObj.goDisplayed()) {
                        nextEventPageObj.btnClick(nextEventPageObj.go());
                    }
                }
            }*/
            /*policyOperationsObj.createproduct(customer, newParameters);
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
            policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.policySave());*/
            quoteAndBuyOperationsObj.retrieveRandomCustomerName();
            policyOperationsObj.getPolicyNumberFromScreen();
            policyOperationsObj.backDatingThePolicy();
        }
    }

    public void createComms(String policy, List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                System.out.println("Field name-----" + parameters.get(0).get(column) + " Field value -------" + parameters.get(row).get(column));
                this.createCommsPref(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
    }

    public void createCommsPref(String searchField, String searchValue) {
        switch (searchField.toLowerCase()) {
            case "teleno1":
                policyDataFieldsPageObj.tele1().clear();
                policyDataFieldsPageObj.tele1().sendKeys(searchValue);
                break;
            case "teleno2":
                policyDataFieldsPageObj.tele2().clear();
                policyDataFieldsPageObj.tele2().sendKeys(searchValue);
                break;
            case "teleno1type":
                policyDataFieldsPageObj.tele1Pref().click();
                policyDataFieldsPageObj.tele1PrefOption(searchValue).click();
                break;
            case "teleno2type":
                policyDataFieldsPageObj.tele2Pref().click();
                policyDataFieldsPageObj.tele2PrefOption(searchValue).click();
                break;
            case "commspref":
                String[] communicationPref = searchValue.split(",");
                for (int i = 0; i < communicationPref.length; i++) {
                    System.out.println("Communication preference is -----" + communicationPref[i]);
                    commPrefOperationsObj.commPref(communicationPref[i]);
                }
                break;
            case "emailid":
                policyDataFieldsPageObj.custCommEmailValue().clear();
                if (searchValue.equalsIgnoreCase("Random")) {
                    searchValue = randomGeneratorObj.randomEmailAddress(5);
                    PolicyOperations.emailIdForReport = searchValue;
                    PolicyOperations.randomEmailID = searchValue;
                    PolicyOperations.retrievedSchemeEmailID = searchValue;
                    System.out.println("Random Email Id is -----" + PolicyOperations.randomEmailID);
                    policyDataFieldsPageObj.custCommEmailValue().sendKeys(searchValue);
                } else {
                    policyDataFieldsPageObj.custCommEmailValue().sendKeys(searchValue);
                }
                break;
            case "title":
                new Select(policyDataFieldsPageObj.custCommTitleValue()).selectByVisibleText(searchValue);
                break;
            case "firstname":
                policyDataFieldsPageObj.custCommFirstNameValue().clear();
                policyDataFieldsPageObj.custCommFirstNameValue().sendKeys(PolicyOperations.retrieveRandomCustomerFirstName);
                break;
            case "lastname":
                policyDataFieldsPageObj.custCommLastNameValue().clear();
                policyDataFieldsPageObj.custCommLastNameValue().sendKeys(PolicyOperations.retrieveRandomCustomerLastName);
            case "dateofbirth":
                policyDataFieldsPageObj.custCommDOBValue().clear();
                policyDataFieldsPageObj.custCommDOBValue().sendKeys(PolicyOperations.retrieveCustomerDOB);
        }
    }

    public void sendWelcomeMail(String strEventType) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        System.out.println("field name --------------------" + strEventType);
        navigationObj.navigateToNextEventType(strEventType);
        System.out.println("Inside customer welcome mail event..... ");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.btnCreateEventSendEmail());
        try {
            Thread.sleep(3500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void navigateToEventType(String eventType) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        if (nextEventPageObj.eventTypeDrpDwn().isDisplayed()) {
            System.out.println("Inside the Claims - Capture Incident");
            String strEventType = eventType.concat(" | Email");
            System.out.println("select event type as ----" + strEventType);
            new Select(nextEventPageObj.nextEventClaims()).selectByVisibleText(strEventType);
            nextEventPageObj.btnClick(nextEventPageObj.nextButtonSensitive());
        }
    }

    public void createQuote(String strQuoteType, List<List<String>> lstInputParameters) {
        List<List<String>> lstQuoteParamets = commandsObj.parameterMappingDigitalQuote(lstInputParameters, strQuoteType);
        System.out.println("Question===" + lstQuoteParamets.get(0));
        System.out.println("Answer===" + lstQuoteParamets.get(1));
        for (int i = 0; i < lstQuoteParamets.get(0).size(); i++) {
            System.out.println("question-----------------------" + lstQuoteParamets.get(0).get(i));
            if (lstQuoteParamets.get(1).get(i).equalsIgnoreCase("Next")) {
                quoteDetailsPageObj.btnClick(quoteDetailsPageObj.nextButton());
            } else if ((lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Business Cover") ||
                    lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Wedding Cover") ||
                    lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Hazardous Activities Cover") ||
                    lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Cruise Cover") ||
                    lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Increased Baggage Cover") ||
                    lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Golf cover") ||
                    lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Trip Extension") ||
                    lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Cancellation Extension")) && !lstQuoteParamets.get(1).get(i).equalsIgnoreCase("NA")) {
                if (System.getProperty("brand").toLowerCase() != "ulster") {
                    customerPortalQuotePageObj.addUpgradesOptionSelect(lstQuoteParamets.get(0).get(i), lstQuoteParamets.get(1).get(i).toLowerCase()).click();
                    if (strCoverages.isEmpty()) {
                        if (lstQuoteParamets.get(1).get(i).toLowerCase().equalsIgnoreCase("yes")) {
                            strCoverages = lstQuoteParamets.get(0).get(i);
                        }
                    } else {
                        if (lstQuoteParamets.get(1).get(i).toLowerCase().equalsIgnoreCase("yes")) {
                            strCoverages = strCoverages + "#" + lstQuoteParamets.get(0).get(i);
                        }
                    }
                }
            } else if (lstQuoteParamets.get(1).get(i).equalsIgnoreCase("Start Healix Screening")) {
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(quoteDetailsPageObj.startHealixScreeningBtn());
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
                nextEventPageObj.btnClick(quoteDetailsPageObj.medicalConditionSelectBtn(lstQuoteParamets.get(1).get(i)));
            } else if ((lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Do you have osteoporosis?") && !(lstQuoteParamets.get(1).get(i).equalsIgnoreCase("NA"))) ||
                    (lstQuoteParamets.get(0).get(i).equalsIgnoreCase("How many broken bones and/or fractures have you had in the last 5 years?") && !(lstQuoteParamets.get(1).get(i).equalsIgnoreCase("NA"))) ||
                    (lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Have you had any spinal and/or compression fractures AFTER you were diagnosed with this condition?") && !(lstQuoteParamets.get(1).get(i).equalsIgnoreCase("NA")))) {
                List<String> questAndAnswer = new ArrayList<String>();
                questAndAnswer.add(lstQuoteParamets.get(0).get(i));
                questAndAnswer.add(lstQuoteParamets.get(1).get(i));
                quoteAndBuyOperationsObj.medicalConditionAnswering(questAndAnswer);
            } else if (lstQuoteParamets.get(0).get(i).equalsIgnoreCase("Complete medical screening") && !lstQuoteParamets.get(1).get(i).equalsIgnoreCase("NA")) {
                nextEventPageObj.btnClick(quoteDetailsPageObj.continueBtn());
                nextEventPageObj.btnClick(quoteDetailsPageObj.finishBtn());
                quoteDetailsPageObj.nextButton().click();
            } else if (!lstQuoteParamets.get(1).get(i).equalsIgnoreCase("NA")) {
                System.out.println("element display----------------------------" + nextEventPageObj.elementDisplayed(org.openqa.selenium.By.xpath(quoteDetailsPageObj.editExistingMedicalCondition())));
                if (commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(quoteDetailsPageObj.editExistingMedicalCondition())))
                    nextEventPageObj.waitForElementPresent(net.serenitybdd.core.annotations.findby.By.xpath(quoteDetailsPageObj.editExistingMedicalCondition())).click();
                quoteAndBuyOperationsObj.selectOptionYesOrNo(lstQuoteParamets.get(1).get(i), lstQuoteParamets.get(0).get(i));
            }
        }
    }

    public void navigateToPeopleScreen() {
        customerPortalQuotePageObj.getAQuoteLink().isDisplayed();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
        customerPortalQuotePageObj.btnClick((customerPortalQuotePageObj.getAQuoteLink()));
        nextEventPageObj.getDriver.navigate().refresh();
        nextEventPageObj.btnClick(customerPortalQuotePageObj.getAQuoteLink());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.btnUnderstand().isDisplayed();
        customerPortalQuotePageObj.btnClick(customerPortalQuotePageObj.btnUnderstand());
    }

    public void welcomeMail(List<List<String>> newParameters) {
        for (int row = 1; row < newParameters.size(); row++) {
            for (int column = 0; column < newParameters.get(0).size(); column++) {
                System.out.println("Welcome mail event ---------Field name ----" + newParameters.get(0).get(column) + " Field value-------" + newParameters.get(row).get(column));
                this.sendWelcomeEvent(newParameters.get(0).get(column), newParameters.get(row).get(column));
            }
        }
    }

    private void sendWelcomeEvent(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "oop":
                claimOperationObj.clickingUnderNextEventsAndButtons(fieldValue);
                break;
            case "event":
                this.sendWelcomeMail(fieldValue);
                nextEventPageObj.switchToDefault();
                System.out.println("Verify Event Method...");
                nextEventPageObj.getDriver.navigate().refresh();
                try {
                    configureEventsOperationsObj.verifyEvents(fieldValue);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                break;
        }
    }

    public void setUpCustomer(List<List<String>> parameters) {
        List<List<String>> newParameters = commandsObj.parameterMappingNew(1, parameters, LoadTTPropertiesFiles.DIGITALCUSTOMERSETUP_PROP);
        for (int row = 1; row < newParameters.size(); row++) {
            for (int column = 0; column < newParameters.get(0).size(); column++) {
                System.out.println("Digital Customer setup ---------Field name ----" + newParameters.get(0).get(column) + "------- Field value-------" + newParameters.get(row).get(column));
                this.signUpDigCustomer(newParameters.get(0).get(column), newParameters.get(row).get(column));
            }
        }
    }

    public void setInCustomerForServices(List<List<String>> parameters) {
        List<List<String>> newParameters = commandsObj.parameterMappingNew(1, parameters, LoadTTPropertiesFiles.DIGITALCUSTOMERSETUP_PROP);
        for (int row = 1; row < newParameters.size(); row++) {
            for (int column = 0; column < newParameters.get(0).size(); column++) {
                System.out.println("Digital Customer setup ---------Field name ----" + newParameters.get(0).get(column) + "------- Field value-------" + newParameters.get(row).get(column));
                this.signInServicesCustomer(newParameters.get(0).get(column), newParameters.get(row).get(column));
            }
        }
    }

    public void signInServicesCustomer(String fieldName, String fieldValue){
        switch (fieldName.toLowerCase()) {
            case "email":
                quoteDetailsPageObj.enterEmail().sendKeys(fieldValue);
                break;
            case "password":
                quoteDetailsPageObj.enterPassword().sendKeys(fieldValue);
                nextEventPageObj.btnClick(quoteDetailsPageObj.clickSignIn());
                break;

        }
    }

    public void signUpDigCustomer(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {

            case "digfirstname":
                if (fieldValue.equalsIgnoreCase("registeredfirststname")) {
                    fieldValue = quoteAndBuyOperationsObj.randomCustomerFirstName;
                    System.out.println("Registered user First name -----" + quoteAndBuyOperationsObj.randomCustomerFirstName);
                } else if (fieldValue.equalsIgnoreCase("document")) {
                    quoteDetailsPageObj.firstNameOfNewPerson().clear();
                    quoteDetailsPageObj.firstNameOfNewPerson().sendKeys(fieldValue);
                    nextEventPageObj.waitForMoreTime();
                }
                quoteDetailsPageObj.firstNameOfNewPerson().clear();
                quoteDetailsPageObj.firstNameOfNewPerson().sendKeys(fieldValue);
                nextEventPageObj.waitForMoreTime();
                break;
            case "diglastname":
                if (fieldValue.equalsIgnoreCase("random")) {
                    fieldValue = randomGeneratorObj.randomString(4);
                    quoteDetailsPageObj.lastNameOfNewPerson().clear();
                    quoteDetailsPageObj.lastNameOfNewPerson().sendKeys(fieldValue);
                    randomUserLname = fieldValue;
                    System.out.println("Random user last name ----" + randomUserLname);

                } else if (fieldValue.equalsIgnoreCase("registeredlastname")) {
                    quoteDetailsPageObj.lastNameOfNewPerson().clear();
                    quoteDetailsPageObj.lastNameOfNewPerson().sendKeys(quoteAndBuyOperationsObj.randomCustomerLastName);
                    System.out.println("Registered user last name -----" + quoteAndBuyOperationsObj.randomCustomerLastName);
                } else {
                    quoteDetailsPageObj.lastNameOfNewPerson().clear();
                    quoteDetailsPageObj.lastNameOfNewPerson().sendKeys(fieldValue);
                    randomUserLname = fieldValue;
                    nextEventPageObj.waitForMoreTime();
                }
                break;
            case "dob":
                if (fieldValue.equalsIgnoreCase("69years11months") || fieldValue.equalsIgnoreCase("7daysbefore70thbirthday")) {
                    String day, month, year;
                    String dob[] = policyOperationsObj.DobDate(fieldValue).split("/");
                    day = dob[0];
                    month = dob[1];
                    year = dob[2];
                    new Select(customerPortalSignInPageObj.drpdnDOBDay()).selectByVisibleText(day);
                    new Select(customerPortalSignInPageObj.drpdnDOBMonth()).selectByVisibleText(month);
                    new Select(customerPortalSignInPageObj.drpdnDOBYear()).selectByVisibleText(year);
                } else if (fieldValue.equalsIgnoreCase("69years10months") || fieldValue.equalsIgnoreCase("70thbirthdayreached")) {
                    String day, month, year;
                    String dob[] = policyOperationsObj.DobDate(fieldValue).split("/");
                    day = dob[0];
                    month = dob[1];
                    year = dob[2];
                    new Select(customerPortalSignInPageObj.drpdnDOBDay()).selectByVisibleText(day);
                    new Select(customerPortalSignInPageObj.drpdnDOBMonth()).selectByVisibleText(month);
                    new Select(customerPortalSignInPageObj.drpdnDOBYear()).selectByVisibleText(year);
                } else {
                    String day, month, year;
                    String dob[] = fieldValue.split("/");
                    day = dob[0];
                    month = dob[1];
                    year = dob[2];
                    new Select(customerPortalSignInPageObj.drpdnDOBDay()).selectByVisibleText(day);
                    new Select(customerPortalSignInPageObj.drpdnDOBMonth()).selectByVisibleText(month);
                    new Select(customerPortalSignInPageObj.drpdnDOBYear()).selectByVisibleText(year);
                }
                break;
            case "digpostcode":
                customerPortalSignInPageObj.txtPostcode().clear();
                customerPortalSignInPageObj.txtPostcode().sendKeys(fieldValue);
                break;
            case "digaccountno":
                accountNo = fieldValue;
                customerPortalSignInPageObj.txtAcctNo().clear();
                customerPortalSignInPageObj.txtAcctNo().sendKeys(fieldValue);
                break;
            case "digsortcode":
                String sortcode[] = fieldValue.split("-");
                customerPortalSignInPageObj.txtSortcodeOne().clear();
                customerPortalSignInPageObj.txtSortcodeOne().sendKeys(sortcode[0]);
                customerPortalSignInPageObj.txtSortcodeTwo().clear();
                customerPortalSignInPageObj.txtSortcodeTwo().sendKeys(sortcode[1]);
                customerPortalSignInPageObj.txtSortcodeThree().clear();
                customerPortalSignInPageObj.txtSortcodeThree().sendKeys(sortcode[2]);
                break;
            case "captcha":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToFrameById(customerPortalSignInPageObj.frameCaptcha());
                nextEventPageObj.waitForMoreTime();
                customerPortalSignInPageObj.chkBkCaptcha().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.waitForMoreTime();
                try {
                    Thread.sleep(100000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case "register":
                nextEventPageObj.waitForMoreTime();
                customerPortalSignInPageObj.btnRegister().click();
                break;
            case "digusername":
                if (fieldValue.equalsIgnoreCase("RegisteredEmail")) {
                    System.out.println("Registration email id --------------------------" + policyOperationsObj.randomEmailID);
                    policyOperationsObj.randomEmailID = randomGeneratorObj.randomEmailAddress(5);
                    System.out.println("Registered email original: " + policyOperationsObj.randomEmailID);
                    customerPortalSignInPageObj.txtUserName().sendKeys(policyOperationsObj.randomEmailID);
                } else {
                    customerPortalSignInPageObj.txtUserName().sendKeys(fieldValue);
                }
                break;
            case "digpassword":
                customerPortalHomePageObj.txtPwd().sendKeys(fieldValue);
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                customerPortalHomePageObj.txtConfirmPwd().sendKeys(fieldValue);
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                incorrectPassword = fieldValue;
                System.out.println("Entered pwd for Digital ------" + incorrectPassword);
                break;
            case "email address":
                customerPortalSignInPageObj.digemail().sendKeys(fieldValue);
                break;
            case "digaddress1":
                customerPortalSignInPageObj.txtAddress1().sendKeys(fieldValue);
                break;
            case "digaddress2":
                customerPortalSignInPageObj.txtAddress2().sendKeys(fieldValue);
                break;
            case "town/city":
                customerPortalSignInPageObj.txtTownOrCity().sendKeys(fieldValue);
                break;
            case "tell us about everyone":
                if (!fieldValue.equalsIgnoreCase("NA"))
                    customerPortalSignInPageObj.tellUsAboutEveryOneOption(fieldValue).click();
                break;
            case "action":
                if (fieldValue.equalsIgnoreCase("register")) {
                    nextEventPageObj.waitForMoreTime();
                    customerPortalSignInPageObj.btnRegister().click();
                } else if (fieldValue.equalsIgnoreCase("save")) {
                    nextEventPageObj.waitForMoreTime();
                    customerPortalSignInPageObj.btnSave().click();
                } else {
                    customerPortalSignInPageObj.btnNext().click();
                }
                break;
            case "confirm":
                if (fieldValue.equalsIgnoreCase("na")) {
                } else if (fieldValue.equalsIgnoreCase("confirm")) {
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.btnClick(customerPortalSignInPageObj.signIn());
                }
                break;
            case "error":
                nextEventPageObj.waitForMoreTime();
                System.out.println("Registration error msg---" + customerPortalSignInPageObj.errMsgRegistration().getText());
                Assert.assertTrue(customerPortalSignInPageObj.errMsgRegistration().isDisplayed());
                break;
            case "digtitle":
                new Select(quoteDetailsPageObj.prospectTitle()).selectByVisibleText(fieldValue);
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "jtfirstname":
                customerPortalSignInPageObj.jointAccountFName().sendKeys(fieldValue);
                break;
            case "jtlastname":
                customerPortalSignInPageObj.jointAccountLName().sendKeys(fieldValue);
                break;
            case "jtdob":
                String day1, month1, year1;
                String jtdob[] = fieldValue.split("/");
                day1 = jtdob[0];
                month1 = jtdob[1];
                year1 = jtdob[2];
                System.out.println("Dob done............" + fieldValue);
                new Select(customerPortalSignInPageObj.drpdnDOBirthDay1()).selectByVisibleText(day1);
                new Select(customerPortalSignInPageObj.drpdnDOBirthMonth1()).selectByVisibleText(month1);
                new Select(customerPortalSignInPageObj.drpdnDOBirthYear1()).selectByVisibleText(year1);
                break;
            case "jttitle":
                customerPortalSignInPageObj.jointAccountTitle().sendKeys(fieldValue);
                break;
            case "digcounty":
                customerPortalSignInPageObj.txtCounty().clear();
                customerPortalSignInPageObj.txtCounty().sendKeys(fieldValue);
                break;
            case "joint":
                customerPortalQuotePageObj.insureJointYesButton().click();
                break;
        }
    }

    public void enterProspectDetails(List<List<String>> newParameters) {
        for (int row = 1; row < newParameters.size(); row++) {
            for (int column = 0; column < newParameters.get(0).size(); column++) {
                System.out.println("Digital Customer setup ---------Field name ----" + newParameters.get(0).get(column) + "------- Field value-------" + newParameters.get(row).get(column));
                this.signUpDigCustomer(newParameters.get(0).get(column), newParameters.get(row).get(column));
            }
        }
    }

    public void clickOnAgeExtNotification() {
        customerPortalHomePageObj.btnClick(customerPortalHomePageObj.btnHomePageNotification());
        customerPortalQuotePageObj.btnUnderstand().isDisplayed();
        customerPortalQuotePageObj.btnClick(customerPortalQuotePageObj.btnUnderstand());
    }

    public void createCustomerInAQForClaim(String customer, List<List<String>> parameters) throws Throwable {
        this.createCustomerInAQ(customer, parameters);
        quoteAndBuyOperationsObj.retrieveRandomCustomerName();
    }

    public void creatingClaim(List<List<String>> lstInputParameters) {
        List<List<String>> lstClaimParameters = commandsObj.parameterMappingNew(1, lstInputParameters, LoadTTPropertiesFiles.DIGITALCLAIMDETAIL_PROP);
        customerPortalMyClaimsOperationsObj.createClaim(lstClaimParameters);
        customerPortalMyClaimsOperationsObj.enterPerilQuestions(lstClaimParameters);
    }
}
