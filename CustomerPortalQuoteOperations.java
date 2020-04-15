package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.*;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.math.RoundingMode;

import static co.uk.directlinegroup.tt.utils.ClaimsOperations.claimID;
import static co.uk.directlinegroup.tt.utils.QuoteAndBuyOperations.taxForSpecificRegion;
import static co.uk.directlinegroup.tt.utils.QuoteAndBuyOperations.validateFutureDate;
import static com.usmanhussain.habanero.framework.AbstractPage.getDriver;

public class CustomerPortalQuoteOperations {

    public static String accountNo = "";
    public static String randomUserFname = "";
    public static String randomUserLname = "";
    public static String randomUserFullName = "";
    public static String address = "";
    public static String addressLine1 = "";
    public static String postcode = "";
    public static String addressWorldPay = "";
    public static String postcodeWorldPay = "";
    public static String insuredPerson = "";
    public static String renewalCover = "";
    public static String homeExpiryDate = "";
    public static String amendedPerson = "";
    public static String selectedCover = "";

    String actualMsg = "";
    int days = 0;
    String cardNumber = "";
    int paymentCount = 0;
    int validDays = 0;

    private CustomerPortalQuotePage customerPortalQuotePageObj = new CustomerPortalQuotePage();
    private co.uk.directlinegroup.tt.utils.common.Select selectObj = new co.uk.directlinegroup.tt.utils.common.Select();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private QuoteDetailsPage quoteDetailsPageObj = new QuoteDetailsPage();
    private RandomGenerator randomGeneratorObj = new RandomGenerator();
    private CustomerPortalHomePage customerPortalHomePageObj = new CustomerPortalHomePage();
    private CustomerPortalMyClaimsPage customerPortalMyClaimsPageObj = new CustomerPortalMyClaimsPage();
    private DateOperations dateOperationsObj = new DateOperations();
    private FileOperations fileOperationsObj = new FileOperations();
    private RulesEngineOperation rulesEngineOperationObj = new RulesEngineOperation();
    private PolicyOperations policyOperationsObj = new PolicyOperations();
    private Commands commandsObj = new Commands();

    public void navigateToGetAQuote() {
        try {
            nextEventPageObj.waitForMoreTime();
            customerPortalQuotePageObj.getAQuoteLink().isDisplayed();
            customerPortalQuotePageObj.getAQuoteLink().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        } catch (Exception exe) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.getDriver.navigate().refresh();
            customerPortalQuotePageObj.btnClick(customerPortalQuotePageObj.getAQuoteLink());
            nextEventPageObj.getDriver.navigate().refresh();
        }
    }

    public void navigateToPeople() {
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.btnUnderstand().isDisplayed();
        customerPortalQuotePageObj.btnClick(customerPortalQuotePageObj.btnUnderstand());
    }

    public void validateInsuredPersons() {
        Assert.assertTrue(customerPortalQuotePageObj.lblInsuredPeopleName().isDisplayed());
        Assert.assertTrue(customerPortalQuotePageObj.lblMainAcctHolder().isDisplayed());
    }

    public void validatePeopleQuestions(List<List<String>> questionList) {
        for (int i = 1; i < questionList.size(); i++) {
            for (int j = 0; j < questionList.get(1).size(); j++) {
                this.verifyQuestionAndAnswer(questionList.get(0).get(j), questionList.get(i).get(j));
                System.out.println("inside people questions and answer loop--------");
            }
        }
    }

    public void verifyQuestionAndAnswer(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "question":
                Assert.assertTrue(fieldValue.equalsIgnoreCase(customerPortalQuotePageObj.Question().getText()));
                break;
            case "optionselected":
                if (fieldValue.equalsIgnoreCase("No")) {
                    customerPortalQuotePageObj.btnPeopleAnswer(fieldValue).click();

                    if (nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.buttonConfirm()))) {
                        customerPortalQuotePageObj.btnClick(customerPortalQuotePageObj.btnConfirm());
                    }
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    customerPortalQuotePageObj.btnClick(customerPortalQuotePageObj.btnNext());
                } else if (fieldValue.equalsIgnoreCase("Yes")) {
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    customerPortalQuotePageObj.btnClick(customerPortalQuotePageObj.btnPeopleAnswer(fieldValue));
                } else {
                    nextEventPageObj.waitForMoreTime();
                    customerPortalQuotePageObj.btnClick(customerPortalQuotePageObj.btnUnderstand());
                }
                break;

            case "customer notification":
                Assert.assertTrue(fieldValue.equalsIgnoreCase(customerPortalQuotePageObj.lblCustNotifyInScreeningPage().getText()));
                break;

            case "notification":
                Assert.assertTrue(customerPortalQuotePageObj.lblMedicalCondExcluded(fieldValue).isDisplayed());
                break;
        }
    }

    public void additionalUpgrades(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(i).size(); j++) {
                Assert.assertTrue(customerPortalQuotePageObj.lblAdditionalUpgrades(parameters.get(i).get(j)).isDisplayed());
            }
        }
    }

    public void validateTitleAndMsg(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(i).size(); j++) {
                this.verifyTitleAndMsg(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void verifyTitleAndMsg(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "insured person definition":
                try {
                    Assert.assertTrue(customerPortalQuotePageObj.titleInsuredPerson().getText().equalsIgnoreCase(fieldName));
                } catch (Error e) {
                }
                customerPortalQuotePageObj.iconInsurePerson().click();
                actualMsg = customerPortalQuotePageObj.msgInsurePerson().getText();
                Assert.assertTrue(actualMsg.equalsIgnoreCase(fieldValue));
                break;
            case "uk trips":
                Assert.assertTrue(customerPortalQuotePageObj.titleUKTrips().getText().equalsIgnoreCase(fieldName));
                customerPortalQuotePageObj.iconUKtrips().click();
                actualMsg = customerPortalQuotePageObj.msgUKtrips().getText();
                Assert.assertTrue(actualMsg.equalsIgnoreCase(fieldValue));
                break;
        }
    }

    public void wishToAddPerson(String person) {
        if (person.equalsIgnoreCase("Partner")) {
            customerPortalQuotePageObj.iconPartner().click();
        } else if (person.equalsIgnoreCase("Dependent Child")) {
            customerPortalQuotePageObj.iconDepChild().click();
        } else if (person.equalsIgnoreCase("Guest")) {
            customerPortalQuotePageObj.iconGuest().click();
        }
    }

    public void validateIsMandatory(String field) {
        Assert.assertTrue(customerPortalQuotePageObj.isMandatory(field).isDisplayed());
    }

    public void validateIsDropdown(List<String> options) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.drpdnTitle().click();
        Assert.assertTrue(selectObj.validateValuesInDropDown(customerPortalQuotePageObj.drpdnTitle(), options));
    }

    public void validateRelationshipIsDropdown(List<String> options) {
        customerPortalQuotePageObj.drpdnRelationship().click();
        Assert.assertTrue(selectObj.validateValuesInDropDown(customerPortalQuotePageObj.drpdnRelationship(), options));
        new Select(customerPortalQuotePageObj.drpdnRelationship()).selectByIndex(2);
    }

    public void validateDestinationIsDropdown(List<String> options) {
        customerPortalQuotePageObj.drpdnDestination().click();
        Assert.assertTrue(selectObj.validateValuesInDropDown(customerPortalQuotePageObj.drpdnDestination(), options));
        new Select(customerPortalQuotePageObj.drpdnDestination()).selectByIndex(1);
    }

    public void validateErrorMessage(List<List<String>> parameters) {
        for (int i = 0; i < parameters.size(); i++) {
            switch (parameters.get(0).get(0).toLowerCase()) {
                case "title":
                    customerPortalQuotePageObj.randomClick().click();
                    try {
                        Assert.assertTrue("Expected Title field error message is not displaying in the application ", customerPortalQuotePageObj.errMsgTitle().getText().equalsIgnoreCase(parameters.get(1).get(0)));
                        new Select(customerPortalQuotePageObj.drpdnTitle()).selectByIndex(1);
                    } catch (Exception e) {
                    }
                    break;
                case "first name":
                    customerPortalQuotePageObj.txtFirstName().clear();
                    customerPortalQuotePageObj.randomClick().click();
                    try {
                        Assert.assertTrue("Expected First name field error message is not displaying in the application ", customerPortalQuotePageObj.errMsgFname().getText().equalsIgnoreCase(parameters.get(1).get(0)));
                    } catch (Exception e) {
                    }
                    break;
                case "last name":
                    customerPortalQuotePageObj.txtLastName().clear();
                    customerPortalQuotePageObj.txtFirstName().click();
                    try {
                        Assert.assertTrue("Expected Last name field error message is not displaying in the application ", customerPortalQuotePageObj.errMsgLname().getText().equalsIgnoreCase(parameters.get(1).get(0)));
                    } catch (Exception e) {
                    }
                    break;
                case "date of birth":
                    customerPortalQuotePageObj.txtDOB().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    customerPortalQuotePageObj.tabPeople().click();
                    try {
                        Assert.assertTrue("Expected DOB field error message is not displaying in the application ", customerPortalQuotePageObj.errMsgDOB().getText().equalsIgnoreCase(parameters.get(1).get(0)));
                    } catch (Exception e) {
                    }
                    break;
                case "relationship":
                    customerPortalQuotePageObj.drpdnRelationship().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    customerPortalQuotePageObj.tabPeople().click();
                    try {
                        Assert.assertTrue("Expected Relationship field error message is not displaying in the application ", customerPortalQuotePageObj.errMsgRelationship().getText().equalsIgnoreCase(parameters.get(1).get(0)));
                    } catch (Exception e) {
                    }
                    break;
                case "destination":
                    customerPortalQuotePageObj.drpdnDestination().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    customerPortalQuotePageObj.tabPeople().click();
                    try {
                        Assert.assertTrue("Expected Destination field error message is not displaying in the application ", customerPortalQuotePageObj.errMsgDestination().getText().equalsIgnoreCase(parameters.get(1).get(0)));
                    } catch (Exception e) {
                    }
                    break;
                case "trip dates - from":
                    customerPortalQuotePageObj.txtTripFromDate().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    customerPortalQuotePageObj.tabPeople().click();
                    try {
                        Assert.assertTrue("Expected Destination field error message is not displaying in the application ", customerPortalQuotePageObj.errMsgFromDate().getText().equalsIgnoreCase(parameters.get(1).get(0)));
                    } catch (Exception e) {
                    }
                    break;
                case "trip dates - to":
                    customerPortalQuotePageObj.txtTripToDate().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    customerPortalQuotePageObj.tabPeople().click();
                    try {
                        Assert.assertTrue("Expected Destination field error message is not displaying in the application ", customerPortalQuotePageObj.errMsgToDate().getText().equalsIgnoreCase(parameters.get(1).get(0)));
                    } catch (Exception e) {
                    }
                    break;
            }
        }
    }

    public void validateWithFieldInput(String field, List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(1).size(); j++) {
                if (field.equalsIgnoreCase("First name")) {
                    this.inputTypeAndLength(parameters.get(0).get(j), parameters.get(i).get(j));
                } else if (field.equalsIgnoreCase("Last name")) {
                    this.validateInputTypeAndLength(parameters.get(0).get(j), parameters.get(i).get(j));
                } else if (field.equalsIgnoreCase("Date of Birth")) {
                    this.validateInputTypeForDOB(parameters.get(0).get(j), parameters.get(i).get(j));
                }
            }
        }
    }

    private void validateInputTypeForDOB(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "past date":
                customerPortalQuotePageObj.txtDOB().clear();
                customerPortalQuotePageObj.txtDOB().sendKeys(fieldValue);
                this.verifyDOBisPastDate();
                break;
            case "future date":
                customerPortalQuotePageObj.txtDOB().clear();
                customerPortalQuotePageObj.txtDOB().sendKeys(fieldValue);
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                customerPortalQuotePageObj.tabPeople().click();
                this.verifyDOBisCurrentDate();
                break;
            case "calendar selection":
                customerPortalQuotePageObj.txtDOB().click();
                Assert.assertTrue(nextEventPageObj.elementDisplayed(customerPortalQuotePageObj.iconCalendar()));

                break;
        }
    }

    private void inputTypeAndLength(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase().trim()) {
            case "input type alpha":
                customerPortalQuotePageObj.txtFirstName().clear();
                customerPortalQuotePageObj.txtFirstName().sendKeys(fieldValue);
                System.out.println("Firstname ---- enter alphabets alone -------" + fieldValue);
                break;
            case "input type numeric":
                customerPortalQuotePageObj.txtFirstName().clear();
                customerPortalQuotePageObj.txtFirstName().sendKeys(fieldValue);
                System.out.println("Firstname ---- enter numeric value  -------" + fieldValue);
                break;
            case "input length minimum":
                customerPortalQuotePageObj.txtFirstName().clear();
                customerPortalQuotePageObj.txtFirstName().sendKeys(fieldValue);
                System.out.println("Firstname ---- enter minimum length (2) -------" + fieldValue);
                break;
            case "input length maximum":
                customerPortalQuotePageObj.txtFirstName().clear();
                customerPortalQuotePageObj.txtFirstName().sendKeys(fieldValue);
                System.out.println("Firstname ---- enter maximum length (30)-------" + fieldValue);
                break;
            case "input length less than min":
                customerPortalQuotePageObj.txtFirstName().clear();
                customerPortalQuotePageObj.txtFirstName().sendKeys(fieldValue);
                System.out.println("Firstname ---- enter less than min i/p length (<2)-------" + fieldValue);
                break;
            case "input length greater than max":
                customerPortalQuotePageObj.txtFirstName().clear();
                customerPortalQuotePageObj.txtFirstName().sendKeys(fieldValue);
                System.out.println("Firstname ---- enter greater than max i/p length (>30)-------" + fieldValue);
                break;
        }
    }

    private void validateInputTypeAndLength(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase().trim()) {
            case "input type alpha":
                customerPortalQuotePageObj.txtLastName().clear();
                customerPortalQuotePageObj.txtLastName().sendKeys(fieldValue);
                System.out.println("Firstname ---- enter alphabets alone -------" + fieldValue);
                break;
            case "input type numeric":
                customerPortalQuotePageObj.txtLastName().clear();
                customerPortalQuotePageObj.txtLastName().sendKeys(fieldValue);
                System.out.println("Firstname ---- enter numeric value  -------" + fieldValue);
                break;
            case "input length minimum":
                customerPortalQuotePageObj.txtLastName().clear();
                customerPortalQuotePageObj.txtLastName().sendKeys(fieldValue);
                System.out.println("Firstname ---- enter minimum length (2) -------" + fieldValue);
                break;
            case "input length maximum":
                customerPortalQuotePageObj.txtLastName().clear();
                customerPortalQuotePageObj.txtLastName().sendKeys(fieldValue);
                System.out.println("Firstname ---- enter maximum length (30)-------" + fieldValue);
                break;
            case "input length less than min":
                customerPortalQuotePageObj.txtLastName().clear();
                customerPortalQuotePageObj.txtLastName().sendKeys(fieldValue);
                System.out.println("Firstname ---- enter less than min i/p length  (<2)  -------" + fieldValue);
                break;
            case "input length greater than max":
                customerPortalQuotePageObj.txtLastName().clear();
                customerPortalQuotePageObj.txtLastName().sendKeys(fieldValue);
                System.out.println("Firstname ---- enter greater than max i/p length (>30) -------" + fieldValue);
                break;
        }
    }

    public void verifyDOBisPastDate() {
        try {
            Date dateFromPage = new SimpleDateFormat("dd/MM/yyyy").parse(customerPortalQuotePageObj.txtDOB().getAttribute("value"));
            DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(dateFormat2.format(new Date()));
            String newDate = dateFormat2.format(new Date());
            Date currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(newDate);
            Assert.assertTrue(dateFromPage.before(currentDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void verifyCustomerPortalTripFromDateisCurentDate() {
        try {
            System.out.println("Inside trip from date validation");
            Date dateFromPage = new SimpleDateFormat("dd/MM/yyyy").parse(customerPortalQuotePageObj.txtTripFromDate().getAttribute("value"));
            DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(dateFormat2.format(new Date()));
            String newDate = dateFormat2.format(new Date());
            Date currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(newDate);
            Assert.assertTrue(dateFromPage.equals(currentDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void verifyCustomerPortalTripToDateisBeyondLimit() {
        try {
            System.out.println("Inside Trip To date validation");
            Date dateFromPage = new SimpleDateFormat("dd/MM/yyyy").parse(customerPortalQuotePageObj.txtTripToDate().getAttribute("value"));
            DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 32);
            String newDate = dateFormat2.format(c.getTime());
            System.out.println("Trip EndDate should be ------" + newDate);
            Date tripEndDate = new SimpleDateFormat("dd/MM/yyyy").parse(newDate);
            Assert.assertTrue(!(dateFromPage.equals(tripEndDate)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void verifyTripFromDateisFutureDate() {
        try {
            Date dateFromPage = new SimpleDateFormat("dd/MM/yyyy").parse(customerPortalQuotePageObj.txtTripFromDate().getAttribute("value"));
            System.out.println("Application from date ------" + dateFromPage);
            DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(dateFormat2.format(new Date()));
            String newDate = dateFormat2.format(new Date());
            Date currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(newDate);
            Assert.assertTrue(dateFromPage.after(currentDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void verifyTripToDateisFutureDate() {
        try {
            Date dateFromPage = new SimpleDateFormat("dd/MM/yyyy").parse(customerPortalQuotePageObj.txtTripToDate().getAttribute("value"));
            System.out.println("Application To date ------" + dateFromPage);
            DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(dateFormat2.format(new Date()));
            String newDate = dateFormat2.format(new Date());
            Date currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(newDate);
            Assert.assertTrue(dateFromPage.after(currentDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void verifyDOBisCurrentDate() {
        try {
            Date dateFromPage = new SimpleDateFormat("dd/MM/yyyy").parse(customerPortalQuotePageObj.txtDOB().getAttribute("value"));
            System.out.println("Application date ------" + dateFromPage);
            DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(dateFormat2.format(new Date()));
            String newDate = dateFormat2.format(new Date());
            Date currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(newDate);
            Assert.assertEquals(dateFromPage, currentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void verifyChildMsg(List<String> parameters) {
        for (int i = 0; i < parameters.get(0).length(); i++) {
            System.out.println(" Verify Msg displays in dependent child screen---------" + parameters.get(0));
            Assert.assertTrue(customerPortalQuotePageObj.msgDependentChild().getText().equalsIgnoreCase(parameters.get(0)));
            break;
        }
    }

    public void verifyWinterSports(String inpType) {
        customerPortalQuotePageObj.chkBxWinterSports().click();
        Assert.assertTrue(customerPortalQuotePageObj.winterSports().getAttribute("type").equalsIgnoreCase(inpType));

    }

    public void validateFieldTitle(String title) {
        System.out.println("Given Title-------" + title);
        if (title.equalsIgnoreCase("Trip Dates - From")) {
            System.out.println("inside title method  - if loop.....");
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            System.out.println("Expected Title-------" + title + "   Application title ----------" + customerPortalQuotePageObj.titleFromDate().getText());
            Assert.assertTrue(customerPortalQuotePageObj.titleFromDate().isDisplayed());
        } else {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            Assert.assertEquals(title, customerPortalQuotePageObj.titleToDate().getText());
            System.out.println("Expected Title-------" + title + "   Application title ----------" + customerPortalQuotePageObj.titleToDate().getText());
        }
    }

    public void validateInfoButtonText(String infoValue) {
        Actions action = new Actions(getDriver);
        if (infoValue.contains("Departure date")) {
            action.moveToElement(customerPortalQuotePageObj.infoBtnFromDate());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            Assert.assertTrue(customerPortalQuotePageObj.infoBtnFromDate().getAttribute("title").equals(infoValue));
        } else if (infoValue.contains("Return date")) {
            action.moveToElement(customerPortalQuotePageObj.infoBtnToDate());
            Assert.assertTrue(customerPortalQuotePageObj.infoBtnToDate().getAttribute("title").equals(infoValue));
        }
    }

    public void validateTripFromFieldInputType(String field, List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(i).size(); j++) {
                if (field.equalsIgnoreCase("Trip From Date")) {
                    System.out.println("Given field value is ----" + field);
                    this.validateInputTypeForTripFromDate(parameters.get(0).get(j), parameters.get(i).get(j));
                } else if (field.equalsIgnoreCase("Trip To Date")) {
                    System.out.println("Given field value is ----" + field);
                    this.validateInputTypeForTripToDate(parameters.get(0).get(j), parameters.get(i).get(j));
                }
            }
        }
    }

    private void validateInputTypeForTripFromDate(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "future date":
                System.out.println("Validating the field of ...." + fieldName);
                customerPortalQuotePageObj.txtTripFromDate().clear();
                customerPortalQuotePageObj.txtTripFromDate().sendKeys(fieldValue);
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                customerPortalQuotePageObj.tabPeople().click();
                this.verifyTripFromDateisFutureDate();
                break;
            case "calendar selection":
                System.out.println("Validating the field of ...." + fieldName);
                customerPortalQuotePageObj.txtTripFromDate().click();
                Assert.assertTrue(nextEventPageObj.elementDisplayed(customerPortalQuotePageObj.iconCalendar()));
                break;
            case "alpha input":
                System.out.println("Validating the field of ...." + fieldName);
                customerPortalQuotePageObj.txtTripFromDate().clear();
                customerPortalQuotePageObj.txtTripFromDate().sendKeys(fieldValue);
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                customerPortalQuotePageObj.tabPeople().click();
                this.verifyTripFromDateisFutureDate();
                break;
        }
    }

    private void validateInputTypeForTripToDate(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "future date":
                System.out.println("Validating the field of ...." + fieldName);
                customerPortalQuotePageObj.txtTripToDate().clear();
                customerPortalQuotePageObj.txtTripToDate().sendKeys(fieldValue);
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                customerPortalQuotePageObj.tabPeople().click();
                this.verifyTripToDateisFutureDate();
                break;
            case "calendar selection":
                System.out.println("Validating the field of ...." + fieldName);
                customerPortalQuotePageObj.txtTripToDate().click();
                Assert.assertTrue(nextEventPageObj.elementDisplayed(customerPortalQuotePageObj.iconCalendar()));
                break;
            case "alpha input":
                System.out.println("Validating the field of ...." + fieldName);
                customerPortalQuotePageObj.txtTripToDate().clear();
                customerPortalQuotePageObj.txtTripToDate().sendKeys(fieldValue);
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                customerPortalQuotePageObj.tabPeople().click();
                this.verifyTripFromDateisFutureDate();
                break;
        }
    }

    public void enterCustomerPersondetails(String person, String persontype, List<List<String>> personDetails) {
           if (person.equalsIgnoreCase("add a person")) {
            new Select(customerPortalMyClaimsPageObj.drpdnPerson()).selectByVisibleText("Add person +");
            if (persontype.equalsIgnoreCase("Guest"))
                nextEventPageObj.btnClick(customerPortalQuotePageObj.addPerson(persontype));
            if (persontype.equalsIgnoreCase("Dependent Child")) {
                nextEventPageObj.btnClick(customerPortalQuotePageObj.addPerson(persontype));
            }
            if (persontype.equalsIgnoreCase("Partner")) {
                nextEventPageObj.btnClick(customerPortalQuotePageObj.addPerson(persontype));
            }
        } else if (person.equalsIgnoreCase("Add another person")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(customerPortalQuotePageObj.addPersonbuttonText());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            if (persontype.equalsIgnoreCase("Guest")) {
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(customerPortalQuotePageObj.iconGuest());
            } else if (persontype.equalsIgnoreCase("Dependent Child")) {
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(customerPortalQuotePageObj.iconDepChild());
            } else if (persontype.equalsIgnoreCase("Partner")) {
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(customerPortalQuotePageObj.iconPartner());
            }
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < personDetails.size(); i++) {
            for (int j = 0; j < personDetails.get(i).size(); j++) {
                this.addPersonDetailsInCustomerportal(personDetails.get(0).get(j), personDetails.get(i).get(j));
            }
        }
    }

    public void addPerson(String persontype, List<List<String>> personDetails) {
        if (nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.addPersonbutton()))) {
            customerPortalQuotePageObj.addPersonbuttonText().click();
        }
        if (persontype.equalsIgnoreCase("Guest")) {
            customerPortalQuotePageObj.iconGuest().click();
            nextEventPageObj.btnClick(customerPortalQuotePageObj.addPerson(persontype));
        } else if (persontype.equalsIgnoreCase("Dependent Child")) {
            customerPortalQuotePageObj.iconDepChild().click();
        } else if (persontype.equalsIgnoreCase("Partner")) {
            customerPortalQuotePageObj.iconPartner().click();
        }
        for (int i = 1; i < personDetails.size(); i++) {
            for (int j = 0; j < personDetails.get(i).size(); j++) {
                this.addPersonDetailsInCustomerportal(personDetails.get(0).get(j), personDetails.get(i).get(j));
            }
        }
    }

    private void addPersonDetailsInCustomerportal(String fieldName, String fieldValue) {
        nextEventPageObj.waitForMoreTime();
        switch (fieldName.toLowerCase()) {
            case "title":
                new Select(quoteDetailsPageObj.titleOfNewPerson()).selectByVisibleText(fieldValue);
                break;
            case "first name":
                if (fieldValue.equalsIgnoreCase("random")) {
                    fieldValue = randomGeneratorObj.randomString(4);
                    quoteDetailsPageObj.firstNameOfNewPerson().sendKeys(fieldValue);
                    randomUserFname = fieldValue;
                    System.out.println("Random user name ----" + randomUserFname);
                } else {
                    quoteDetailsPageObj.firstNameOfNewPerson().sendKeys(fieldValue);

                }
                nextEventPageObj.waitForMoreTime();
                break;
            case "description":
                quoteDetailsPageObj.txtDescriptionClaimItem().clear();
                quoteDetailsPageObj.txtDescriptionClaimItem().sendKeys(fieldValue);
                break;
            case "last name":
                quoteDetailsPageObj.lastNameOfNewPerson().sendKeys(fieldValue);
                randomUserLname = fieldValue;
                nextEventPageObj.waitForMoreTime();
                break;
            case "dob":
                quoteDetailsPageObj.DOBofNewPerson().sendKeys(fieldValue);
                quoteDetailsPageObj.DOBofNewPerson().sendKeys(Keys.TAB);
                quoteDetailsPageObj.DOBofNewPerson().sendKeys(Keys.TAB);
                break;
            case "action":
                if (fieldValue.equalsIgnoreCase("next")) {
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.btnClick(quoteDetailsPageObj.btnNextInCustomerPortal());
                    nextEventPageObj.waitForMoreTime();
                } else if (fieldValue.equalsIgnoreCase("save")) {
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.btnClick(quoteDetailsPageObj.btnSaveInCustomerPortal());
                    nextEventPageObj.waitForMoreTime();
                } else if (fieldValue.equalsIgnoreCase("add")) {
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.btnClick(quoteDetailsPageObj.btnAddInCustomerPortal());
                    nextEventPageObj.waitForMoreTime();
                } else if (fieldValue.equalsIgnoreCase("add person")) {
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.btnClick(quoteDetailsPageObj.btnAddPersonInCustomerPortal());
                    nextEventPageObj.waitForMoreTime();
                } else if (fieldValue.equalsIgnoreCase("cancel")) {
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.btnClick(quoteDetailsPageObj.btnCancelInCustomerPortal());
                    nextEventPageObj.waitForMoreTime();
                }
                break;
            case "validate trip dates from":
                if (fieldValue.equalsIgnoreCase("currentdate")||fieldValue.equalsIgnoreCase("today")|| fieldValue.equalsIgnoreCase("futuredate31days") || fieldValue.equalsIgnoreCase("futuredate1month") || fieldValue.equalsIgnoreCase("futuredate60days") || fieldValue.equalsIgnoreCase("futuredate22days")) {
                    System.out.println("Trip From date -----" + this.tripDate(fieldValue));
                    quoteDetailsPageObj.tripFromDate().sendKeys(dateValueEnter(fieldValue));
                    quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                    quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                } else {
                    quoteDetailsPageObj.tripFromDate().sendKeys(dateValueEnter(fieldValue));
                    quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                    quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                }
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "validate trip dates to":
                if (fieldValue.equalsIgnoreCase("futuredate22days")||fieldValue.equalsIgnoreCase("futuredate31days")||fieldValue.equalsIgnoreCase("futuredate32days")||fieldValue.equalsIgnoreCase("futuredate90days")) {
                    System.out.println("Enter Trip To date -----" + this.tripDate(fieldValue));
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.tripToDate().sendKeys(dateValueEnter(fieldValue));
                    nextEventPageObj.waitForMoreTime();
                }  else {
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.tripToDate().sendKeys(dateValueEnter(fieldValue));
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                }
                break;
            case "trip dates from":
                if (fieldValue.equalsIgnoreCase("currentdate") ||fieldValue.equalsIgnoreCase("today")|| fieldValue.equalsIgnoreCase("futuredate31days") || fieldValue.equalsIgnoreCase("futuredate1month") || fieldValue.equalsIgnoreCase("futuredate60days") || fieldValue.equalsIgnoreCase("futuredate22days")) {
                    System.out.println("Enter Trip From date -----" + this.tripDate(fieldValue));
                    quoteDetailsPageObj.tripFromDate().sendKeys(dateValueEnter(fieldValue));
                    quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                    quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                } else {
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.tripFromDate().sendKeys(dateValueEnter(fieldValue));
                    quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                    quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                }
                break;
            case "trip dates to":
                if (fieldValue.equalsIgnoreCase("futuredate22days") || fieldValue.equalsIgnoreCase("futuredate1month") || fieldValue.equalsIgnoreCase("futuredate31days") || fieldValue.equalsIgnoreCase("futuredate60days")) {
                    System.out.println("Enter Trip End date -----" + this.tripDate(fieldValue));
                    quoteDetailsPageObj.tripToDate().sendKeys(dateValueEnter(fieldValue));
                } else {
                    quoteDetailsPageObj.tripToDate().sendKeys(dateValueEnter(fieldValue));
                }
                break;
            case "destination":
                customerPortalQuotePageObj.drpdnDestination().click();
                new Select(customerPortalQuotePageObj.drpdnDestination()).selectByIndex(1);
                break;
            case "validate message":
                customerPortalQuotePageObj.validateErrorMessage(fieldValue).isDisplayed();
                Assert.assertTrue(customerPortalQuotePageObj.validateErrorMessage(fieldValue).isDisplayed());
                break;
            case "relationship":
                customerPortalQuotePageObj.drpdnRelationship().click();
                new Select(customerPortalQuotePageObj.drpdnRelationship()).selectByVisibleText(fieldValue);
                break;
            case "add anOther trip":
                customerPortalQuotePageObj.addAnOtherTrip().click();
                break;
            case "message validation":
                Assert.assertTrue(customerPortalQuotePageObj.messageValidation().getText().contains(fieldValue));
                break;
            case "prospect title":
                new Select(quoteDetailsPageObj.prospectTitleOfNewPerson()).selectByVisibleText(fieldValue);
                break;
            case "prospect first name":
                if (fieldValue.equalsIgnoreCase("random")) {
                    fieldValue = randomGeneratorObj.randomString(4);
                    quoteDetailsPageObj.prospectFirstNameOfNewPerson().sendKeys(fieldValue);
                    randomUserFname = fieldValue;
                    System.out.println("Random user name ----" + randomUserFname);
                } else {
                    quoteDetailsPageObj.prospectFirstNameOfNewPerson().sendKeys(fieldValue);
                }
                nextEventPageObj.waitForMoreTime();
                break;
            case "prospect last name":
                quoteDetailsPageObj.prospectLastNameOfNewPerson().sendKeys(fieldValue);
                randomUserLname = fieldValue;
                nextEventPageObj.waitForMoreTime();
                break;
            case "validate trip dates above the limit":
                System.out.println("Enter Trip To date beyond the limit-----" + this.tripDate(fieldValue));
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(quoteDetailsPageObj.tripToDate());
                quoteDetailsPageObj.tripToDate().sendKeys(dateValueEnter(fieldValue));
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                this.verifyCustomerPortalTripToDateisBeyondLimit();
                this.verifyTripToDateisFutureDate();
                break;
            case "prospect dob":
                System.out.println("-------Prospect DOB-------");
                String day, month, year;
                String dob[] = fieldValue.split("/");
                day = dob[0];
                month = dob[1];
                year = dob[2];
                new Select(quoteDetailsPageObj.dobDate()).selectByVisibleText(day);
                new Select(quoteDetailsPageObj.dobMonth()).selectByVisibleText(month);
                new Select(quoteDetailsPageObj.dobYear()).selectByVisibleText(year);
        }
    }

    public void accpetNOCoverInCustomerPortal() {
        customerPortalQuotePageObj.acceptNoCover().click();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateExcludedConditionMsgInCustomerPortal(String msg, String person) {
        customerPortalQuotePageObj.validateExcludedConditionsMsg(msg, person).isDisplayed();
        Assert.assertTrue(customerPortalQuotePageObj.validateExcludedConditionsMsg(msg, person).isDisplayed());
    }

    public void notificationOnScreeningPage(String msg, String travellers) {
        Assert.assertTrue(customerPortalQuotePageObj.notificationInScreening(msg).isDisplayed());
        System.out.println("Displaying the status for --" + travellers + " ----" + customerPortalQuotePageObj.notificationInScreening(msg));
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.btnNext().click();
    }

    public void selectMedicalCondition(String disease) {
        customerPortalQuotePageObj.toSelectMedicalcondition(disease).isDisplayed();
        customerPortalQuotePageObj.toSelectMedicalcondition(disease).click();
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.btnNext().click();
    }

    public void selectAnswersForTheQuestions(List<List<String>> questionList) {
        for (int i = 1; i < questionList.size(); i++) {
            this.verifyExpectedBehaviour(questionList.get(i), questionList.get(0));
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
        } else if (option.equalsIgnoreCase("none or 1")) {
            quoteDetailsPageObj.optionNoneOr1(question1);
            quoteDetailsPageObj.btnClick(quoteDetailsPageObj.optionNoneOr1(question1));
        } else if (option.equalsIgnoreCase("2 or more")) {
            quoteDetailsPageObj.option2OrMore(question1);
            quoteDetailsPageObj.btnClick(quoteDetailsPageObj.option2OrMore(question1));
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

    public void selectCover(String option) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.selectCover(option).click();
        try {
            Thread.sleep(2500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterTheMedicalCondition(String conditionCount, String medicalCondition, List<List<String>> questionList) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        List<WebElement> lineItemsCheckbox = nextEventPageObj.findElements(By.xpath(quoteDetailsPageObj.iframeSize()));
        nextEventPageObj.switchToFrameByIndex(0);
        System.out.println("text box medical-----------------------------" + quoteDetailsPageObj.medicalConditionText().isDisplayed());
        for (int i = 0; i < medicalCondition.length(); i++) {
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
        for (int i = 1; i < questionList.size(); i++) {
            this.medicalConditionAnswering(questionList.get(i));
        }
        nextEventPageObj.btnClick(quoteDetailsPageObj.continueBtn());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (conditionCount.equalsIgnoreCase("more than one")) {
        } else if (conditionCount.equalsIgnoreCase("the")) {
            nextEventPageObj.waitForMoreTime();
            quoteDetailsPageObj.finishBtn().isDisplayed();
            nextEventPageObj.btnClick(quoteDetailsPageObj.finishBtn());
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void medicalConditionAnswering(List<String> questionAndAnswer) {
        String question = questionAndAnswer.get(0);
        String answer = questionAndAnswer.get(1);
        System.out.println("xpath of question and answer -----------------------------" + quoteDetailsPageObj.question1(question, answer).isDisplayed());
        nextEventPageObj.btnClick(quoteDetailsPageObj.question1(question, answer));
    }

    public void removeDependants(String person, String msg) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(customerPortalQuotePageObj.removePerson(person));
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.removePersonErrorMessage(msg).isDisplayed();
        Assert.assertTrue(customerPortalQuotePageObj.removePersonErrorMessage(msg).isDisplayed());
    }

    public void selectSingleCondition(String condition) {
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.selectMedicalCondition(condition).click();
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.btnNext().click();
    }

    public void navigateToBasketScreen() throws Exception {
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.btnNext().click();
        Thread.sleep(10000L);
    }

    public void selectUpgrades(String covers) throws Exception {
        String[] upgradeCover = covers.split(",");
        Thread.sleep(4000L);
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.waitForPageLoad();
        for (int i = 0; i < upgradeCover.length; i++) {
            customerPortalQuotePageObj.selectUpgrade(upgradeCover[i]).click();
        }
        Thread.sleep(5000L);
    }

    public void addUpgradeToBasket(String cover) throws Exception {
        Thread.sleep(5000L);
        nextEventPageObj.btnClick(customerPortalQuotePageObj.selectUpgrade(cover));
    }

    public void validatePersonExistInBasketScreen(String person) {
        Assert.assertTrue(customerPortalQuotePageObj.validatePerson(person).isDisplayed());
    }

    public void validateTripDetails(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(i).size(); j++) {
                this.validateTripDetailsInBasketScreen(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    public void validateTripDetailsInBasketScreen(String fieldName, String fieldValue) {
        String trip = "";
        String tripToDate = "";
        String tripTodateDetails = "";
        String tripFromDetails = "";
        String totalTripDays1 = "";
        String tripDays = "";
        switch (fieldName.toLowerCase()) {
            case "trip details":
                customerPortalQuotePageObj.validateExtension(fieldValue).isDisplayed();
                break;
            case "country":
                customerPortalQuotePageObj.validateCountry(fieldValue).isDisplayed();
                break;
            case "trip start date":
                if (fieldValue.equalsIgnoreCase("currentdate")) {
                    trip = customerPortalQuotePageObj.lblTripDates().getText();
                    System.out.println("Entire date--------" + trip);
                    tripFromDetails = trip.split("-")[0];
                    System.out.println("TripDetails[0]-------------" + tripFromDetails);
                    System.out.println("Enter from date -----" + this.tripDate(fieldValue));
                    Assert.assertTrue(tripFromDetails.trim().equals(this.tripDate(fieldValue).trim()));
                    System.out.println("Trip Start date is validated");
                } else {
                    nextEventPageObj.waitForMoreTime();
                    trip = customerPortalQuotePageObj.lblTripDates().getText();
                    tripFromDetails = trip.split("-")[0];
                    Assert.assertTrue(tripFromDetails.trim().equals(fieldValue));
                    System.out.println("Trip Start date is validated");
                }
                break;
            case "trip to date":
                if (fieldValue.equalsIgnoreCase("futuredate22days")) {
                    trip = customerPortalQuotePageObj.lblTripDates().getText();
                    System.out.println("To date--------" + trip);
                    tripTodateDetails = trip.split(" ")[2];
                    System.out.println("----" + tripTodateDetails);
                    System.out.println("Trip To date Details[1]-------------" + tripTodateDetails.trim());
                    System.out.println("Enter To date -----" + this.tripDate(fieldValue));
                    Assert.assertTrue(tripTodateDetails.trim().equals(this.tripDate(fieldValue).trim()));
                    System.out.println("Trip To date is validated");
                } else {
                    trip = customerPortalQuotePageObj.lblTripDates().getText();
                    tripTodateDetails = trip.split(" ")[2];
                    Assert.assertTrue(tripTodateDetails.equals(fieldValue));
                    System.out.println("Trip To date is validated");
                }
                break;
            case "days":
                String days = customerPortalQuotePageObj.validateStartDate(fieldValue).getText();
                String[] totalTripDays = days.split("\\(");
                String[] totalDays = totalTripDays[1].split(" ");
                try {
                    Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(trip);
                    Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(tripToDate);
                    System.out.println("Start date ------" + startDate + " End Date ----------- " + endDate);
                    long tripCalculatedDays = ((endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24));
                    System.out.println("Calculated Days -------- " + tripCalculatedDays);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Assert.assertTrue(totalDays[0].equals(fieldValue));
                break;
            case "trip days":
                trip = customerPortalQuotePageObj.lblTripDates().getText();
                totalTripDays1 = trip.split(" ")[3];
                System.out.println("total---------" + totalTripDays1);
                tripDays = totalTripDays1.substring(1);
                System.out.println("totalDays------------" + tripDays);
                Assert.assertTrue(tripDays.equals(fieldValue));
                System.out.println("***Days verified***");
                break;
        }
    }

    public void signOutFromDigital() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(customerPortalHomePageObj.btnSignOut());
        nextEventPageObj.waitForMoreTime();
        if (customerPortalHomePageObj.lblSignOut().isDisplayed()) {
            nextEventPageObj.waitForMoreTime();
            customerPortalHomePageObj.btnConfirmSignOut().click();
        }
        nextEventPageObj.waitForMoreTime();
    }

    public void validateTripLengthDropDownValues(List<String> parameters) {
        Assert.assertTrue(selectObj.validateValuesInDropDown(customerPortalQuotePageObj.drpdnTripLength(), parameters));
    }

    public void validateButtons() {
        Assert.assertTrue(customerPortalQuotePageObj.btnSave().isEnabled());
        Assert.assertTrue(customerPortalQuotePageObj.BuyOptionValidation().isEnabled());
    }

    public void dayDifference(String cover) {
        String renewal_date = "";
        String[] upgradeCover = cover.split(",");
        for (int i = 0; i < upgradeCover.length; i++) {
            renewal_date = customerPortalQuotePageObj.validateRenewalDay(upgradeCover[i]).getText();
            try {
                days = dateOperationsObj.differenceBetweenTwoDateInDays(validateFutureDate, renewal_date);
                System.out.println("Day difference is : " + days);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String[] annualPremium = customerPortalQuotePageObj.validateAnnualPremium(upgradeCover[i]).getText().split("£");
            float actualPremium = Float.parseFloat(annualPremium[1]);
            System.out.println("Annual Premium[1] ---------" + annualPremium[1]);
            float dayPremium = (float) (actualPremium / 365.00);
            System.out.println("Day Premium is ---------" + dayPremium);
            System.out.println(days);
            System.out.println("Days------------" + days);
            float remainingDays = (float) days;
            System.out.println("Remaining days-------" + remainingDays);
            double yearPremium = (dayPremium * remainingDays);
            System.out.println("Year premium is------" + yearPremium);
            DecimalFormat df = new DecimalFormat("##.##");
            df.setRoundingMode(RoundingMode.FLOOR);
            double result=new Double(df.format(yearPremium));
            System.out.println("Year Premium" +yearPremium);
            Double expectedPremiumValue = Double.parseDouble(df.format(result));
            String value = String.valueOf(expectedPremiumValue);
            String[] amountToPay = customerPortalQuotePageObj.validateAmountToPay(upgradeCover[i]).getText().split("£");
            float actualAmountToPay = Float.parseFloat(amountToPay[1]);
            DecimalFormat df1 = new DecimalFormat("##.##");
            df1.setRoundingMode(RoundingMode.CEILING);
            double result1=new Double(df.format(yearPremium));
            Double expectedAmountToPayValue = Double.parseDouble(df.format(result1));
            String value1 = String.valueOf(expectedPremiumValue);
            Assert.assertEquals(expectedAmountToPayValue, expectedPremiumValue);
            System.out.println("Amount to pay value is verified");
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void calculate_amount_to_pay(String cover) {
        System.out.println("Amount to pay is : " + customerPortalQuotePageObj.validateAmountToPay(cover).getText());
        System.out.println("Display the renewal day : " + customerPortalQuotePageObj.validateRenewalDay(cover).getText());
        System.out.println("Annual premium is : " + customerPortalQuotePageObj.validateAnnualPremium(cover).getText());
    }

    public void validateAccountDetailsAreAutoPolpulated(String payment) {
        customerPortalQuotePageObj.paymentOption(payment).click();
        for (int i = 1; i <= 4; i++) {
            System.out.println("3 " + customerPortalQuotePageObj.accountDetails(i).getText());
            if (customerPortalQuotePageObj.accountDetails(i).getText().startsWith("Bank name:")) {
            } else {
                String[] accDetails = customerPortalQuotePageObj.accountDetails(i).getText().split(":");
                System.out.println("AutoPopulated Account Details ----- " + accDetails[1]);
                Assert.assertTrue(!accDetails[1].equalsIgnoreCase(" "));
            }
        }
        accountNo = customerPortalQuotePageObj.accountDetails(3).getText().split(":")[1];
        System.out.println("Capturing Account no..." + accountNo);
    }

    public void enterAccountDetails(String paymentOption, List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.paymentOption(paymentOption).click();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(1).size(); j++) {
                this.enterPayementDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    public void enterAccountDetail(List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(1).size(); j++) {
                this.enterPayementDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void enterPayementDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "account holder name":
                customerPortalQuotePageObj.txtAccountHolder().sendKeys(fieldValue);
                break;
            case "cardholders name":
                customerPortalQuotePageObj.txtCardHolder().sendKeys(fieldValue);
                break;
            case "sort code":
                customerPortalQuotePageObj.txtsortCode().sendKeys(fieldValue);
                break;
            case "account no.":
                accountNo = fieldValue;
                customerPortalQuotePageObj.txtAccountNo().sendKeys(fieldValue);
                System.out.println("Capturing account No-------" + accountNo);
                break;
            case "bank name":
                customerPortalQuotePageObj.txtBankName().sendKeys(fieldValue);
                break;
            case "action":
                if (fieldValue.equalsIgnoreCase("save")) {
                    customerPortalQuotePageObj.btnSaveInPayment().click();
                } else if (fieldValue.equalsIgnoreCase("buy now")) {
                    nextEventPageObj.waitForMoreTime();
                    customerPortalQuotePageObj.btnBuyNow().click();
                } else if (fieldValue.equalsIgnoreCase("save third party")) {
                    customerPortalQuotePageObj.btnSaveThirdPartyDetails().click();
                }
                break;
            case "title":
                customerPortalQuotePageObj.drpdnTitle().click();
                new Select(customerPortalQuotePageObj.drpdnTitle()).selectByVisibleText(fieldValue);
                break;
            case "first name":
                customerPortalQuotePageObj.txtFirstName().sendKeys(fieldValue);
                break;
            case "last name":
                customerPortalQuotePageObj.txtLastName().sendKeys(fieldValue);
                break;
            case "address 1":
                addressLine1 = fieldValue;
                customerPortalQuotePageObj.txtAddress1().sendKeys(fieldValue);
                break;
            case "address 2":
                customerPortalQuotePageObj.txtAddress2().sendKeys(fieldValue);
                break;
            case "town / city":
                customerPortalQuotePageObj.txtTownCity().sendKeys(fieldValue);
                break;
            case "county":
                customerPortalQuotePageObj.txtCounty().sendKeys(fieldValue);
                break;
            case "postcode":
                postcode = fieldValue;
                customerPortalQuotePageObj.txtPostcode().sendKeys(fieldValue);
                break;
            case "telephone":
                customerPortalQuotePageObj.txtTelephone().sendKeys(fieldValue);
                break;
            case "email":
                customerPortalQuotePageObj.txtEmail().sendKeys(fieldValue);
                break;
            case "consent":
                break;
            case "validate account details":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.msgValidAccount()));
                break;
            case "card permission":
                customerPortalQuotePageObj.btnCardPermission(fieldValue).click();
                break;

            case "sole authority":
                customerPortalQuotePageObj.btnCardPermission(fieldValue).click();
                break;
            case "is same billing address":
                customerPortalQuotePageObj.btnCardPermission(fieldValue).click();
                break;
        }
    }

    public void clickOnBuy() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(quoteDetailsPageObj.btnBuy());
    }

    public void navigateToBuyScreen() {
        System.out.println("Waiting for Basket screen to get loaded completely.....");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String totalCost = customerPortalQuotePageObj.lblTotalCost().getText();
        System.out.println("Total cost ---------" + totalCost);
        Assert.assertTrue(!totalCost.equalsIgnoreCase("£0.00"));
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(quoteDetailsPageObj.btnBuy());
        nextEventPageObj.waitForPageLoad();
    }

    public void enterCardDetails(List<List<String>> cardDetails) {
        for (int i = 1; i < cardDetails.size(); i++) {
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById(customerPortalQuotePageObj.paymentFrame());
            for (int j = 0; j < cardDetails.get(i).size(); j++) {
                this.addCardDetails(cardDetails.get(0).get(j), cardDetails.get(i).get(j));
            }
        }
    }

    private void addCardDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "card number":
                cardNumber = fieldValue;
                quoteDetailsPageObj.enterCardNumber().sendKeys(fieldValue);
                break;
            case "expiry date":
                quoteDetailsPageObj.enterExpiryDate().sendKeys(fieldValue);
                break;
            case "cvv":
                quoteDetailsPageObj.entercvvNumber().sendKeys(fieldValue);

                break;
            case "card holder":
                quoteDetailsPageObj.enterCardHolderName().sendKeys(fieldValue);
                break;
            case "expiry year":
                quoteDetailsPageObj.enterExpiryYear().sendKeys(fieldValue.substring(Math.max(fieldValue.length() - 2, 0)));
                break;
            case "authenticate payment":
                if (fieldValue.equalsIgnoreCase("invalid")) {
                    nextEventPageObj.btnClick(quoteDetailsPageObj.makePaymentBtn());
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.btnTryAgain().click();
                } else if (fieldValue.equalsIgnoreCase("valid")) {
                    nextEventPageObj.btnClick(quoteDetailsPageObj.makePaymentBtn());
                    nextEventPageObj.waitForMoreTime();
                } else if (fieldValue.equalsIgnoreCase("incorrect")) {
                    nextEventPageObj.btnClick(quoteDetailsPageObj.makePaymentBtn());
                    nextEventPageObj.waitForMoreTime();
                }
                break;
            case "action":
                switch (fieldValue.toLowerCase()) {
                    case "cancel":
                        nextEventPageObj.btnClick(quoteDetailsPageObj.makePaymentBtn());
                        quoteDetailsPageObj.btnTryCancel().click();
                        break;
                    case "try again":
                        nextEventPageObj.btnClick(quoteDetailsPageObj.makePaymentBtn());
                        if (paymentCount <= 1) {
                            quoteDetailsPageObj.btnTryAgain().click();
                            paymentCount++;
                        }
                        break;
                }
        }
    }

    public void completeCardPayment() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.btnClick(customerPortalQuotePageObj.btnFinishPayment());
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.waitForPageLoad();
        System.out.println("Card payment is completed -----" + customerPortalQuotePageObj.lblPaymentConfirmation().getText());
        nextEventPageObj.waitForPageLoad();
        Assert.assertTrue(customerPortalQuotePageObj.lblPaymentConfirmationText().isDisplayed());
    }

    public void declinesSoleAuthority() {
        customerPortalHomePageObj.btnSoleAuthorityNo().click();
        Assert.assertTrue(quoteDetailsPageObj.btnBuyNowDisabled().isDisplayed());
    }

    public void reviewSavedQuoteDetails(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(i).size(); j++) {
                this.validateSavedQuoteDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }

        }
    }

    public String randomUserName() {
        randomUserFullName = randomUserFname.concat(" " + randomUserLname);
        return randomUserFullName;
    }

    private void validateSavedQuoteDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "added person":
                if (fieldValue.equalsIgnoreCase("random user")) {
                    amendedPerson = this.randomUserName();
                    System.out.println("Added person is---if loop ------" + this.randomUserName());
                    Assert.assertTrue(customerPortalQuotePageObj.validateAddedPerson(this.randomUserName()).isDisplayed());
                } else {
                    amendedPerson = fieldValue;
                    System.out.println("Added person----" + amendedPerson);
                    System.out.println("Added person is---------" + customerPortalQuotePageObj.validateAddedPerson(fieldValue).getText());
                    Assert.assertTrue(customerPortalQuotePageObj.validateAddedPerson(fieldValue).isDisplayed());
                }
                break;
            case "annual upgrade":
                Assert.assertTrue(customerPortalQuotePageObj.selectedUpgrade(fieldValue).isDisplayed());
                break;
            case "age extension":
                if (fieldValue.equalsIgnoreCase("random user")) {
                    Assert.assertTrue(customerPortalQuotePageObj.validateAgeExtension(this.randomUserName(), fieldName).isDisplayed());
                } else {
                    Assert.assertTrue(customerPortalQuotePageObj.validateAgeExtension(fieldValue, fieldName).isDisplayed());
                }
                break;
            case "guest extension":
                if (fieldValue.equalsIgnoreCase("random user")) {
                    System.out.println("*****Upgrade is*****" + customerPortalQuotePageObj.lblForGuestExtension(this.randomUserName(), fieldName).getText());
                    Assert.assertTrue(customerPortalQuotePageObj.lblForGuestExtension(this.randomUserName(), fieldName).isDisplayed());
                } else {
                    System.out.println("*****Upgrade is*****" + customerPortalQuotePageObj.lblForGuestExtension(fieldValue, fieldName).getText());
                    Assert.assertTrue(customerPortalQuotePageObj.lblForGuestExtension(fieldValue, fieldName).isDisplayed());
                }
                break;
            case "medical extension included notification":
                String message = fieldValue;
                System.out.println("notification for added person ----" + amendedPerson);
                String notification = customerPortalQuotePageObj.lblMedicalExtensionIncluded(amendedPerson).getText();
                System.out.println("Message for adding screening for user------" + notification);
                Assert.assertTrue(message.equalsIgnoreCase(notification));
                break;
            case "medical extension excluded notification":
                String message1 = fieldValue;
                String notification1 = customerPortalQuotePageObj.lblMedicalExtensionExcluded(this.randomUserName()).getText();
                System.out.println("Message for adding screening for user------" + notification1);
                System.out.println("Notification Message for adding screening--" + customerPortalQuotePageObj.lblMedicalExtensionNotification(message1).getText());
                Assert.assertTrue(notification1.equals(customerPortalQuotePageObj.lblMedicalExtensionNotification(message1).getText()));
                break;
            case "medical condition":
                String condition = customerPortalQuotePageObj.addedConditions(amendedPerson).getText();
                System.out.println("Screened condition is--------" + condition);
                Assert.assertTrue(condition.contains(fieldValue));
                break;
        }
        System.out.println("Validated saved quote details .....");
    }

    public void validateTripFromDate() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.txtTripFromDate().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
        SimpleDateFormat sd = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Current Date
        c.add(Calendar.DATE, -1);
        String pMonth = sdf.format(c.getTime());
        String pastMonth = pMonth.trim().split(" ")[0];
        String pDate = sd.format(c.getTime());
        System.out.println("Past Month --" + pMonth);
        System.out.println("Date Format---" + pastMonth);
        System.out.println("*****Past date***" + pDate);
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.lblmonthFrom());
        String selectedMonth = quoteDetailsPageObj.lblmonthFrom().getText().trim().split(" ")[0];
        System.out.println("Month1--" + selectedMonth);
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.drpdnFMonth().click();
        Select sMonth = new Select(quoteDetailsPageObj.drpdnFMonth());
        System.out.println("Month needs to be selected is ------------- " + pastMonth);
        nextEventPageObj.waitForMoreTime();
        sMonth.selectByVisibleText(pastMonth);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.dateTableForTripFrom());
        WebElement dateWidget = quoteDetailsPageObj.dateTableForTripFrom();
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
        System.out.println("column value------------" + columns);
        int selectDate = Integer.parseInt(pDate);
        int beyondAAPDate1 = selectDate;
        System.out.println("Date in int format --" + pDate);
        for (WebElement dateCell : columns) {
            System.out.println("Date cell-----" + dateCell.getText());
            System.out.println("Selected Date-------" + beyondAAPDate1);
            dateCell.findElement(org.openqa.selenium.By.xpath("//td[@data-day='" + beyondAAPDate1 + "']")).click();
            if (dateCell.getText().equals(pDate)) {
                System.out.println("value of past======" + pDate);
                System.out.println("Date cell(if loop)-----" + dateCell.getText());
                dateCell.findElement(org.openqa.selenium.By.xpath("//td[@data-day='" + beyondAAPDate1 + "']")).click();
                String exceedDateAttribute = dateCell.findElement(org.openqa.selenium.By.xpath("//td[@data-day='" + beyondAAPDate1 + "']")).getAttribute("class");
                System.out.println("value of past date----------" + exceedDateAttribute);
                Assert.assertEquals("is-disabled", exceedDateAttribute);
                break;
            }
        }
        customerPortalQuotePageObj.clickBasketScreen().click();
    }

    public void validateTripToDate(String account) {
        if (account.equalsIgnoreCase("Platinum account")) {
            validDays = 31;
        } else if (account.equalsIgnoreCase("Black account")) {
            validDays = 90;
        } else if (account.equalsIgnoreCase("Silver account")) {
            validDays = 22;
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.txtTripToDate().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
        SimpleDateFormat sd = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Current Date
        int count = 0;
        c.add(Calendar.DATE, validDays);
        String fMonth = sdf.format(c.getTime());
        String futureMonth = fMonth.trim().split(" ")[0];
        String fDate = sd.format(c.getTime());
        System.out.println("Future Month --" + fMonth);
        System.out.println("Date Format---" + futureMonth);
        System.out.println("*****Future date***" + fDate);
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.lblmonthTo());
        String selectedMonth = quoteDetailsPageObj.lblmonthTo().getText().trim().split(" ")[0];
        System.out.println("Month1--" + selectedMonth);
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.txtTripToDate().clear();
        customerPortalQuotePageObj.txtTripToDate().click();
        String selectedOption = new Select(quoteDetailsPageObj.drpdnToMonth()).getFirstSelectedOption().getText();
        while (!selectedOption.equalsIgnoreCase(futureMonth) & count <= 12) {
            System.out.println("Inside selecting mopnth------Before clicking--------" + selectedOption);
            quoteDetailsPageObj.nextMonthButtonForToDate().click();
            selectedOption = new Select(quoteDetailsPageObj.drpdnToMonth()).getFirstSelectedOption().getText();
            System.out.println("Inside selecting mopnth------After clicking--------" + selectedOption);
            count++;
        }
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.dateTableForTripTo());
        WebElement dateWidget = quoteDetailsPageObj.dateTableForTripTo();
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
        System.out.println("column value------------" + columns);
        int selectDate = Integer.parseInt(fDate);
        int beyondAAPDate1 = selectDate;
        System.out.println("Date in int format --" + fDate);
        for (WebElement dateCell : columns) {
            System.out.println("Date cell-----" + dateCell.getText());
            System.out.println("Selected Date-------" + beyondAAPDate1);
            if (dateCell.getText().equals(fDate)) {
                System.out.println("value of future======" + fDate);
                System.out.println("Date cell(if loop)-----" + dateCell.getText());
                dateCell.findElement(By.xpath("(//td[@data-day='" + beyondAAPDate1 + "'])[last()]"));
                String exceedDateAttribute = dateCell.findElement(By.xpath("(//td[@data-day='" + beyondAAPDate1 + "'])[last()]")).getAttribute("class");
                System.out.println("value of future date----------" + exceedDateAttribute);
                Assert.assertEquals("is-disabled", exceedDateAttribute);
                break;
            }
        }
    }

    public void validateExceedTripToDate(int maximumDays) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.txtTripToDate().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        int count = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
        SimpleDateFormat sd = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Current Date
        c.add(Calendar.DATE, maximumDays);
        String fMonth = sdf.format(c.getTime());
        String futureMonth = fMonth.trim().split(" ")[0];
        String fDate = sd.format(c.getTime());
        System.out.println("Future Month --" + fMonth);
        System.out.println("Date Format---" + futureMonth);
        System.out.println("*****Future date***" + fDate);
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.lblmonthTo());
        String selectedMonth = quoteDetailsPageObj.lblmonthTo().getText().trim().split(" ")[0];
        System.out.println("Month1--" + selectedMonth);
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.txtTripToDate().clear();
        customerPortalQuotePageObj.txtTripToDate().click();
        quoteDetailsPageObj.drpdnFMonth2().click();
        System.out.println("div testuing --------------" + new Select(quoteDetailsPageObj.drpdnToMonth()).getFirstSelectedOption().getText());
        while (!new Select(quoteDetailsPageObj.drpdnToMonth()).getFirstSelectedOption().getText().equalsIgnoreCase(futureMonth) & count <= 12) {
            System.out.println("Inside selecting mopnth--------------" + new Select(quoteDetailsPageObj.drpdnToMonth()).getFirstSelectedOption().getText());
            quoteDetailsPageObj.nextMonthButtonForToDate().click();
            count++;
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.dateTableForTripTo());
        WebElement dateWidget = quoteDetailsPageObj.dateTableForTripTo();
        List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
        System.out.println("column value------------" + columns);
        int selectDate = Integer.parseInt(fDate);
        int beyondAAPDate1 = selectDate;
        System.out.println("Date in int format --" + fDate);
        for (WebElement dateCell : columns) {
            System.out.println("Date cell-----" + dateCell.getText());
            System.out.println("Selected Date-------" + beyondAAPDate1);
            if (dateCell.getText().equals(fDate)) {
                System.out.println("value of future======" + fDate);
                System.out.println("Date cell(if loop)-----" + dateCell.getText());
                dateCell.findElement(By.xpath("(//td[@data-day='" + beyondAAPDate1 + "'])[2]"));
                String exceedDateAttribute = dateCell.findElement(By.xpath("(//td[@data-day='" + beyondAAPDate1 + "'])[2]")).getAttribute("class");
                System.out.println("value of future date----------" + exceedDateAttribute);
                Assert.assertEquals("is-disabled", exceedDateAttribute);
                break;
            }
        }
    }

    public void selectPaymentOption(String payment) {
        switch (payment.toLowerCase()) {
            case "pay by card":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                customerPortalQuotePageObj.btnPayByCard().click();
                break;
            case "pay by direct debit":
                customerPortalQuotePageObj.btnPayByDebit().click();
                break;
            case "pay by annual direct debit":
                customerPortalQuotePageObj.btnAnnaulPayByDebit().click();
                break;
            case "card in my name":
                customerPortalQuotePageObj.btnPayByOwnCard().click();
                break;
        }
    }

    public void landBasedActivies(String parameters) {
        customerPortalQuotePageObj.clickWhatCovered().click();
        String act = customerPortalQuotePageObj.displayEverything1().getText().replace("\n", "#");
        List<String> lstActivities = new ArrayList<String>();
        String[] arrPerilHeader = act.split("#");
        lstActivities = Arrays.asList(arrPerilHeader);
        List<String> recordDetails = fileOperationsObj.getHazardousActivitiesData(parameters);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (lstActivities.size() == recordDetails.size()) {
            for (int i = 0; i < lstActivities.size(); i++) {
                if ((lstActivities.get(i).contains("Land based activities") || lstActivities.get(i).contains("Water based activities") ||
                        lstActivities.get(i).contains("Air based activities") || lstActivities.get(i).contains("Winter Sports activities"))) {

                    System.out.println("application-----if-----" + i + "----" + lstActivities.get(i).trim());
                    System.out.println("property file---if-----" + i + "----" + recordDetails.get(i).trim());

                    String value = lstActivities.get(i);
                    String icheckVal1 = value.split(" ")[0];
                    String icheckVal2 = value.split(" ")[1];
                    String icheckVal3 = value.split(" ")[2];
                    System.out.println("split value------" + icheckVal1 + "------" + icheckVal2 + "----" + icheckVal3);
                    Assert.assertTrue(lstActivities.get(i).contains(icheckVal1));
                    Assert.assertTrue(lstActivities.get(i).contains(icheckVal3));
                    System.out.println("After Assert----If part----------" + i + "-------" + lstActivities.get(i).trim());
                } else if (recordDetails.get(i).trim().contains("Trampolining")) {
                    System.out.println("application----else if -------" + i + "----" + lstActivities.get(i).substring(1).trim());
                    System.out.println("property file--else if -------" + i + "----" + recordDetails.get(i).trim());
                    String value = lstActivities.get(i).substring(1).trim();
                    String icheckVal1 = value.split(" ")[0];
                    String icheckVal2 = value.split(" ")[1];
                    String icheckVal3 = value.split(" ")[2];
                    System.out.println("split value------" + icheckVal1 + "------" + icheckVal2 + "----" + icheckVal3);
                    Assert.assertTrue(lstActivities.get(i).substring(1).trim().contains(icheckVal1));
                    Assert.assertTrue(lstActivities.get(i).substring(1).trim().contains(icheckVal3));
                    System.out.println("After Assert---else if -------" + i + "--------" + lstActivities.get(i).substring(1).trim());
                } else {
                    System.out.println("application-----else-----" + i + "----" + lstActivities.get(i).substring(1).trim());
                    System.out.println("property file---else-----" + i + "----" + recordDetails.get(i).trim());
                    Assert.assertTrue(lstActivities.get(i).substring(1).trim().equalsIgnoreCase(recordDetails.get(i).trim()));
                    System.out.println("After Assert----else-----" + i + "----" + lstActivities.get(i).substring(1).trim());
                }
            }
        }
    }


    public void validateWhatActivitiesWillCover(String parameters) {
        String act2 = customerPortalQuotePageObj.displayEverything2().getText().replace("\n", "#");
        System.out.println("Activities 2 -------------------" + act2);
        System.out.println(customerPortalQuotePageObj.displayEverything2().getText());
        List<String> lstActivities = new ArrayList<String>();
        String[] arrPerilHeader = act2.split("#");
        lstActivities = Arrays.asList(arrPerilHeader);
        System.out.println("Activities size from application--------" + lstActivities.size());
        List<String> recordDetails = fileOperationsObj.getHazardousActivitiesData(parameters);
        System.out.println("property activities---------------" + recordDetails);
        System.out.println("Activities size from properties--------" + recordDetails.size());

        if (lstActivities.size() == recordDetails.size()) {
            for (int i = 0; i < lstActivities.size(); i++) {
                System.out.println("application-----if-----" + i + "----" + lstActivities.get(i).substring(1).trim());
                System.out.println("property file---if-----" + i + "----" + recordDetails.get(i).trim());
                Assert.assertTrue(lstActivities.get(i).substring(1).trim().equalsIgnoreCase(recordDetails.get(i).trim()));
                System.out.println("After Assert----if-----" + i + "----" + lstActivities.get(i).substring(1).trim());
            }
        }
    }

    public void validateTripMaximumLength(String days) {
        List<WebElement> maxLength = new Select(customerPortalQuotePageObj.drpdnTripLength()).getOptions();
        System.out.println("Trip maximum length----" + maxLength.size());
        int index = maxLength.size() - 1;
        System.out.println("Maximum Length should be ---184----" + index);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
//        customerPortalQuotePageObj.drpdnTripLength().click();
        new Select(customerPortalQuotePageObj.drpdnTripLength()).selectByIndex(index);
//        new Select(customerPortalQuotePageObj.drpdnTripLength()).selectByVisibleText(days);
    }


    public void validateMaximumTripDays(int limitDays, String cover) {

        String[] totalDays = customerPortalQuotePageObj.lblTotalTripDays(cover).getText().split("\\(");
        System.out.println("Total Days -------" + totalDays[1].split(" ")[0]);
//        String days = totalDays[1].substring(0,3);
        String days = totalDays[1].split(" ")[0];
        System.out.println("Application maximum allowed days ----------" + days);
        int maximumDays = Integer.parseInt(days);
        System.out.println("Valid Limited days ----" + limitDays);

        if (maximumDays > limitDays) {
            Assert.assertTrue(false);
        } else if (maximumDays < limitDays) {
            Assert.assertTrue(true);
        }
    }

    public void verifyUpgradesAreNotAvailable(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(1).size(); j++) {
                this.validateUpgrades(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }

    }

    private void validateUpgrades(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "cancellation extension":
            case "trip extension":
                Assert.assertTrue(!nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.lblUpgrades(fieldValue))));
                break;
        }
    }

    public void verifyPermiumValueForSelectedUpgrade(String cover, String premium) {
        double dPremium = 0;
        System.out.println("rulesEngineOperationObj.existingUpgradeCost-------------" + rulesEngineOperationObj.existingUpgradeCost);
        if (premium.equalsIgnoreCase("original")) {
            dPremium = Double.parseDouble(rulesEngineOperationObj.existingUpgradeCost);
            System.out.println("value of dPremium-----" + dPremium);
        } else {
            dPremium = Double.parseDouble(premium);
            System.out.println("value of dPremium-----" + dPremium);
        }
        String premiumValue = customerPortalQuotePageObj.validatePremium(cover).getText();
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

    public void tripDetails(List<List<String>> tripDetails) {
        for (int i = 1; i < tripDetails.size(); i++) {
            for (int j = 0; j < tripDetails.get(0).size(); j++) {
                System.out.println("inside trip details method....");
                this.enterTripDetailsForUpgrades(tripDetails.get(0).get(j), tripDetails.get(i).get(j));
            }
        }
    }

    public void enterTripDetailsForUpgrades(String fieldName, String fieldValue) {
        System.out.println("inside trip functions");
        switch (fieldName.toLowerCase()) {
            case "trip date - from":
//                quoteDetailsPageObj.tripFromDate().clear();
                if (fieldValue.equalsIgnoreCase("currentdate") ||fieldValue.equalsIgnoreCase("today")|| fieldValue.equalsIgnoreCase("futuredate31days") || fieldValue.equalsIgnoreCase("futuredate1month") || fieldValue.equalsIgnoreCase("futuredate60days") || fieldValue.equalsIgnoreCase("futuredate22days")) {
                    System.out.println("Enter Trip From date -----" + this.tripDate(fieldValue));
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.tripFromDate().sendKeys(dateValueEnter(fieldValue));
                    quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                    quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
//                    this.dateCalendarFromDate(fieldValue, quoteDetailsPageObj.tripFromDate());

                } else {
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.tripFromDate().sendKeys(dateValueEnter(fieldValue));
                    quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                    quoteDetailsPageObj.tripFromDate().sendKeys(Keys.TAB);
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
//                    customerPortalQuotePageObj.txtTripFromDate().sendKeys(fieldValue);
                }
                break;
            case "trip date - to":
//                quoteDetailsPageObj.tripToDate().clear();
//                quoteDetailsPageObj.tripToDate().sendKeys(dateOperationsObj.addingDaysSpecificFormat(Integer.parseInt(fieldValue)));
                if (fieldValue.equalsIgnoreCase("futuredate22days") || fieldValue.equalsIgnoreCase("futuredate1month") || fieldValue.equalsIgnoreCase("futuredate31days") || fieldValue.equalsIgnoreCase("futuredate60days") || fieldValue.equalsIgnoreCase("futuredate2month")) {
                    System.out.println("Enter Trip End date -----" + this.tripDate(fieldValue));
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.tripToDate().sendKeys(dateValueEnter(fieldValue));
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
//                    this.dateCalendarTodate(fieldValue);
                } else {
//                    customerPortalQuotePageObj.txtTripToDate().sendKeys(fieldValue);
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.tripToDate().sendKeys(dateValueEnter(fieldValue));
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                }
                break;
            case "trip dates - to dates":
//                quoteDetailsPageObj.tripToDate().clear();
//                quoteDetailsPageObj.tripToDate().sendKeys(dateOperationsObj.addingDaysSpecificFormat(Integer.parseInt(fieldValue)));
                if (fieldValue.equalsIgnoreCase("currentdate") || fieldValue.equalsIgnoreCase("futuredate1month") || fieldValue.equalsIgnoreCase("futuredate6month")
                        || fieldValue.equalsIgnoreCase("futuredate1yr") || fieldValue.equalsIgnoreCase("futuredatebyexceeding1yr") || fieldValue.equalsIgnoreCase("futuredate18months")
                        || fieldValue.equalsIgnoreCase("backdate1month") || fieldValue.equalsIgnoreCase("nextday") ||
                        fieldValue.equalsIgnoreCase("futuredate2month") || fieldValue.equalsIgnoreCase("futuredate184days")
                        || fieldValue.equalsIgnoreCase("futuredate90days") || fieldValue.equalsIgnoreCase("futuredate31days") || fieldValue.equalsIgnoreCase("futuredate22days")) {
                    System.out.println("Enter To date -----" + this.tripDate(fieldValue));
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.tripToDate().clear();
                    this.dateCalendarTodate(fieldValue);
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
//                    quoteDetailsPageObj.tripToDate().sendKeys(this.tripDate(fieldValue));
                    customerPortalQuotePageObj.clickBasketScreen().click();
                } else {
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    quoteDetailsPageObj.tripToDate().clear();
                    this.dateCalendarTodate(fieldValue);
//                    quoteDetailsPageObj.tripToDate().sendKeys(fieldValue);
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                }
                break;
            case "destination":
                new Select(quoteDetailsPageObj.drpdnTripDestination()).selectByVisibleText(fieldValue);
//                Thread.sleep(5000L);
                break;
            case "cover amount":
                new Select(quoteDetailsPageObj.drpdnCancellationAmt()).selectByVisibleText(fieldValue);
                break;
            case "action":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
//                quoteDetailsPageObj.saveDetails().click();
                nextEventPageObj.btnClick(quoteDetailsPageObj.saveDetails());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "trip length":
                new Select(customerPortalQuotePageObj.drpdnTripLength()).selectByVisibleText(fieldValue);
                break;
        }
    }

    public String tripDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String returnValue = null;
        switch (date.toLowerCase()) {
            case "today":
            case "currentdate":
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate1month":
                c.add(Calendar.DATE, 30);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate184days":
                c.add(Calendar.DATE, 183);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate60days":
                c.add(Calendar.DATE, 59);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate90days":
                c.add(Calendar.DATE, 89);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate31days":
                c.add(Calendar.DATE, 30);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate30days":
                c.add(Calendar.DATE, 29);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate89days":
                c.add(Calendar.DATE, 88);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate32days":
                c.add(Calendar.DATE, 31);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate22days":
                c.add(Calendar.DATE, 22);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate2month":
                c.add(Calendar.MONTH, 2);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "tomorrow":
            case "nextday":
                c.add(Calendar.DATE, 1);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate6month":
                c.add(Calendar.MONTH, 6);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate1yr":
                c.add(Calendar.YEAR, 1);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredatebyexceeding1yr":
                c.add(Calendar.DATE, 366);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate18months":
                c.add(Calendar.MONTH, 18);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "backdate1month":
                c.add(Calendar.MONTH, -1);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "previousdayoftripstartdate":
                c.add(Calendar.DATE, 29);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "backdate5days":
                c.add(Calendar.DATE, -5);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "backdate22days":
                c.add(Calendar.DATE, -22);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "yesterday":
                c.add(Calendar.DATE, -1);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate10days":
                c.add(Calendar.DATE, 10);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "backdate4days":
                c.add(Calendar.DATE, -4);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "backdate2days":
                c.add(Calendar.DATE, -2);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
        }
        return returnValue;
    }

    public void checkAndSelectCover(String cover) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.checkSelectedUpgrade(cover)))) {
        } else {
            customerPortalQuotePageObj.selectUpgrade(cover).click();
        }
    }

    public void cardSelection(String card) {
        nextEventPageObj.waitForPageLoad();
        customerPortalQuotePageObj.selectCard(card).click();
    }

    public void validateDefaultOptions(List<String> parameters) {
        Assert.assertTrue(customerPortalQuotePageObj.defaultCardInMyName().isDisplayed());
    }

    public void validateOptions(List<String> parameters) {
        Assert.assertTrue(customerPortalQuotePageObj.btnPayByCard().isDisplayed());
        Assert.assertTrue(customerPortalQuotePageObj.btnPayByOwnCard().isDisplayed());
        Assert.assertTrue(customerPortalQuotePageObj.btnPayBySomeoneCard().isDisplayed());
    }

    public void buyScreenBillingAddress() {
        address = customerPortalQuotePageObj.lblBillingAddress().getText();
        System.out.println("Address-------------------" + address);
        String[] address1 = address.split(",");
        addressLine1 = address1[0];
        System.out.println("Address Line from digital-------------" + addressLine1);
        postcode = address1[address1.length - 1];
        System.out.println("Address Line from digital--------------" + postcode);
    }

    public void customerBillingAddress() {
        System.out.println("Address Line------------" + policyOperationsObj.addressLine1Aquarium);
        System.out.println("Address Line------------" + policyOperationsObj.postcodeAquarium);
    }

    public void verifyBillingAddress() {
        this.buyScreenBillingAddress();
        String address = policyOperationsObj.addressLine1Aquarium;
        System.out.println("Address Line from aquarium------------" + address);
        System.out.println("Address Line from digital-------------" + addressLine1);
        Assert.assertTrue(addressLine1.equalsIgnoreCase(address));
        System.out.println("Address Line from digital postcode--------------" + postcode);
        System.out.println("Address Line from aquarium postcode-------------" + policyOperationsObj.postcodeAquarium);
        Assert.assertTrue(postcode.trim().equalsIgnoreCase(policyOperationsObj.postcodeAquarium.trim()));
        System.out.println("Billing address is same as customer address");
    }

    public void completeCardInMyNamePayment() {
        customerPortalQuotePageObj.btnCardPermission1().click();
        if (nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.BuyNow()))) {
            customerPortalQuotePageObj.btnBuyNow().click();
        }
    }

    public void verifyWorldPayPageAddress() {
        addressWorldPay = customerPortalQuotePageObj.txtAddressWorldPay().getText().replace(",", " ");
        postcodeWorldPay = customerPortalQuotePageObj.txtPostcodeWorldPay().getText().replace(",", " ");
        System.out.println("Address from world pay-------" + addressWorldPay);
        System.out.println("Postcode from world pay-------" + postcodeWorldPay);
        Assert.assertTrue(addressLine1.trim().equalsIgnoreCase(addressWorldPay.trim()));
        Assert.assertTrue(postcodeWorldPay.trim().equalsIgnoreCase(postcodeWorldPay.trim()));
        nextEventPageObj.btnClick(quoteDetailsPageObj.makePaymentBtn());
    }

    public void verifySelectedUpgradesAreAdded(String upgradesAndCostAdded) {
        String[] upgradesAndCost = upgradesAndCostAdded.split(",");
        for (int i = 0; i < upgradesAndCost.length; i++) {
            String upgrades = upgradesAndCost[i].split("-")[0];
            String cost = upgradesAndCost[i].split("-")[1];
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            Assert.assertTrue(customerPortalQuotePageObj.fixedPriceUpgradesAdded(upgrades).isDisplayed());
            Assert.assertTrue(customerPortalQuotePageObj.fixedPriceUpgradesAddedCost(upgrades).getText().equalsIgnoreCase(cost));
            System.out.println("WEb page Value----------------------------" + customerPortalQuotePageObj.fixedPriceUpgradesAddedCost(upgrades).getText() + "-table value-------------" + cost);
            System.out.println("upgrades----------------------------------" + upgrades);
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void completePayment() {
        try {
            nextEventPageObj.btnClick(customerPortalQuotePageObj.btnCardPermission1());
        } catch (Exception e) {
            customerPortalQuotePageObj.btnCardPermission1().click();
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(customerPortalQuotePageObj.btnBuyNow());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(customerPortalQuotePageObj.lblPaymentConfirmationText().isDisplayed());
    }

    public void errorMessageWhileUsingSomeOneElseCard(String msg) {
        Assert.assertTrue(msg.equalsIgnoreCase(customerPortalQuotePageObj.errorMessage(msg).getText()));
    }

    public void validatePaymentErrorMsg(String errMsg) {
        String error = customerPortalQuotePageObj.errMsgPaymentFailure().getText();
        String[] applErrMsg = error.split("\n");
        String applMsg = applErrMsg[0].concat(applErrMsg[1]);
        System.out.println("Error Msg -----" + error);
        System.out.println("Combined Error Msg -----" + applMsg);
        System.out.println("Parameter -----" + errMsg);
        Assert.assertTrue(errMsg.contentEquals(applMsg));
    }

    public void validateQVPEffectiveDate() throws Exception {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        String effectiveDate = customerPortalQuotePageObj.lblLatestQuoteEffectiveDate1().getText();
        System.out.println("Effective date of latest quote -------------" + effectiveDate);
        Date dateFromPage = new SimpleDateFormat("dd/MM/yyyy").parse(customerPortalQuotePageObj.lblLatestQuoteEffectiveDate1().getText());
        DateFormat dateFormat3 = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("DATE format----------" + dateFormat3.format(dateFromPage));
        System.out.println("Application date ------" + dateFromPage);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        Date txt = c.getTime();
        System.out.println("Current date ------" + txt);
        DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("DATE format----------" + dateFormat2.format(txt));
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertEquals(dateFormat2, dateFormat3);
        System.out.println("*************");
    }

    public void validateOptionOfAddGuest() {
        Assert.assertTrue(!(nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.QuestionDisplayed()))));
        Assert.assertTrue(!(nextEventPageObj.elementDisplayed(org.openqa.selenium.By.id(customerPortalQuotePageObj.insurePeopleYesButton()))));
        clickOnNext();
    }

    public void navigateToMedicalScreen() {
        quoteDetailsPageObj.btnSaveInCustomerPortal().click();
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.btnNextInCustomerPortal().click();
    }

    public void verifyAgeGuestExtension(List<List<String>> parameter) {
        for (int i = 1; i < parameter.size(); i++) {
            for (int j = 0; j < parameter.get(1).size(); j++) {
                this.verifyAgeGuestExtMessage(parameter.get(0).get(j), parameter.get(i).get(j));
            }
        }
    }

    public void verifyAgeGuestExtMessage(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "age extension notification message":
                String message = fieldValue;
                System.out.println("Age Extension Message is-----" + customerPortalQuotePageObj.lblAgeExtension(message).getText());
                Assert.assertTrue(customerPortalQuotePageObj.lblAgeExtension(message).isDisplayed());
                break;
            case "guest extension notification message":
                String message1 = fieldValue;
                System.out.println("Guest Extension Message is-----" + customerPortalQuotePageObj.lblGuestExtension(message1).getText());
                Assert.assertTrue(customerPortalQuotePageObj.lblGuestExtension(message1).isDisplayed());
                break;
            case "notification message":
                String message2 = fieldValue;
                System.out.println("70 years Message is-----" + customerPortalQuotePageObj.lblGuestExtension(message2).getText());
                Assert.assertTrue(customerPortalQuotePageObj.lblYearsExtension(message2).isDisplayed());
                break;
        }
    }

    public void clickOnNext() {
        customerPortalQuotePageObj.btnClick(customerPortalQuotePageObj.btnNext());
        nextEventPageObj.waitForMoreTime();
    }

    public void navigateToScreeningPage() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.clickOnNext();
    }

    public void clickOnUnderstand(String button) {
        customerPortalQuotePageObj.btnUnderstandForExcluding(button).click();
    }

    public void clickOnRenewalNotification() {
        customerPortalHomePageObj.btnViewRenewal().isDisplayed();
        nextEventPageObj.btnClick(customerPortalHomePageObj.btnViewRenewal());
    }

    public void verifyCoveredInsuredPerson(List<List<String>> parameter) {
        for (int i = 1; i < parameter.size(); i++) {
            for (int j = 0; j < parameter.get(1).size(); j++) {
                this.validateCoveredPersonDetails(parameter.get(0).get(j), parameter.get(i).get(j));
            }
        }
    }

    private void validateCoveredPersonDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "insured person":
                insuredPerson = fieldValue;
                customerPortalQuotePageObj.lblForInsuredPerson(fieldValue).isDisplayed();
                Assert.assertTrue(customerPortalQuotePageObj.lblForInsuredPerson(fieldValue).isDisplayed());
                break;
            case "medical condition":
                System.out.println("Insured person-----" + insuredPerson);
                customerPortalQuotePageObj.lblForPersonMedCond(insuredPerson, fieldValue).isDisplayed();
                Assert.assertTrue(customerPortalQuotePageObj.lblForPersonMedCond(insuredPerson, fieldValue).isDisplayed());
                break;
        }
    }

    public void additionalUpgradeDetails(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(i).size(); j++) {
                for (int k = 0; k < parameters.get(i).get(j).split("#").length; k++) {
                    System.out.println("Validating upgrades----------" + customerPortalQuotePageObj.lblAdditionalUpgrades(parameters.get(i).get(j).split("#")[k]));
                    Assert.assertTrue(customerPortalQuotePageObj.lblAdditionalUpgradeDetails(parameters.get(i).get(j).split("#")[k]).isDisplayed());
                }
            }
        }
    }

    public void validateUpgradeDetails(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(1).size(); j++) {
                this.validateRenewalDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    public void validateRenewalDetails(String fieldName, String fieldValue) {
        String price = "";
        String option = "";
        switch (fieldName.toLowerCase()) {
            case "insured person":
                try {
                    Thread.sleep(61000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!fieldValue.equalsIgnoreCase("na")) {

                    insuredPerson = fieldValue;
                    System.out.println("Insured person in basket screen -----" + insuredPerson);
                    String person = customerPortalQuotePageObj.insuredPerson(insuredPerson).getText();
                    System.out.println("Insured person from application -----" + person);
                    Assert.assertTrue(person.equalsIgnoreCase(insuredPerson));
                } else {
                    System.out.println("Additional upgrade is purchased");
                }
                break;
            case "purchased upgrade":
                if (fieldValue.equalsIgnoreCase("Medical Extension") || fieldValue.equalsIgnoreCase("Medical Cover")) {
                    renewalCover = fieldValue;
                    Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.lblUpgradeMedicalExt(renewalCover, insuredPerson))));
                } else {
                    renewalCover = fieldValue;
                    String cover = customerPortalQuotePageObj.upgradeSelected(renewalCover).getText();
                    System.out.println("Upgrade from application-----" + cover);
                    System.out.println("Selected upgrade-----else loop -------" + cover.split("-")[0].trim());
                    System.out.println("Upgrade from feature file---" + renewalCover);
                    Assert.assertTrue(cover.split("-")[0].trim().equalsIgnoreCase(renewalCover.trim()));
                }
                break;
            case "option":
                if (!renewalCover.contains("Medical Cover")) {
                    option = customerPortalQuotePageObj.upgradeOption(renewalCover).getText();
                    System.out.println("Selected option-----if loop -------" + option);
                    System.out.println("Option from feature file---" + fieldValue);
                    Assert.assertTrue(option.equalsIgnoreCase(fieldValue));
                } else {
                    option = customerPortalQuotePageObj.medicalExtOption(insuredPerson, renewalCover).getText();
                    System.out.println("Selected option-----else loop -------" + option);
                    System.out.println("Option from feature file---" + fieldValue);
                    Assert.assertTrue(option.equalsIgnoreCase(fieldValue));
                }
                break;
            case "price":
                if (!renewalCover.contains("Medical Cover")) {
                    price = customerPortalQuotePageObj.validateAnnualPrice(renewalCover).getText();
                    System.out.println("Given price------------" + price);
                    System.out.println("Price from feature file---" + fieldValue);
                    Assert.assertTrue(price.equalsIgnoreCase(fieldValue));
                } else {
                    price = customerPortalQuotePageObj.medicalPremium(insuredPerson, renewalCover).getText();
                    System.out.println("Given price------------" + price);
                    System.out.println("Price from feature file---" + fieldValue);
                    Assert.assertTrue(price.equalsIgnoreCase(fieldValue));
                }
                break;
            case "action":
                if (fieldValue.equalsIgnoreCase("next")) {
                    this.clickOnNext();
                } else if (fieldValue.equalsIgnoreCase("na")) {

                }
                break;
        }
    }

    public void customerNotPurchaseAdditionalCover() {

    }

    public void navigateToHome() {
        customerPortalHomePageObj.btnHome().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        homeExpiryDate = customerPortalHomePageObj.txtHomePageExpiryDate().getText();
        System.out.println("Expiry date-----" + homeExpiryDate);
    }

    public void validateProrataPeriod() {
        String person = this.randomUserName();
        String foreName = person.split(" ")[0];
        System.out.println("Random user name -----" + foreName);
        String periodFromBasket = customerPortalQuotePageObj.txtPeriod(foreName).getText();
        System.out.println("Upgrade period-----" + periodFromBasket);
        String[] prorataPeriod = periodFromBasket.split("-");
        String current_date = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()).toString();
        System.out.println("Current date is---------" + current_date);
        System.out.println("Purchased Start date----" + prorataPeriod[0]);
        Assert.assertTrue(current_date.trim().equalsIgnoreCase(prorataPeriod[0].trim()));
        System.out.println("End date is---------" + prorataPeriod[1]);
        System.out.println("Expiry Date is------" + homeExpiryDate);
        Assert.assertTrue(homeExpiryDate.trim().equalsIgnoreCase(prorataPeriod[1].trim()));
        System.out.println("-----Pro rata period is validated-----");
    }

    public void validateBasketSummary(List<String> parameters) {
        for (int i = 0; i < parameters.size(); i++) {
            String selectedUpgrade = parameters.get(i);
            System.out.println("Selected upgrade is--------------------------" + parameters.get(i));
            System.out.println("Selected upgrade from basket summary is------" + customerPortalQuotePageObj.txtBasketSummary(selectedUpgrade).getText());
            Assert.assertTrue(customerPortalQuotePageObj.txtBasketSummary(selectedUpgrade).getText().equalsIgnoreCase(parameters.get(i)));
        }
    }

    public void amendScreenedConditions() {
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.btnEdit().click();
    }

    public void validateBasket(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(1).size(); j++) {
                this.validateBasketSummarywithPrice(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void validateBasketSummarywithPrice(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "upgrades":
                selectedCover = fieldValue;
                System.out.println("Selected cover ----" + selectedCover);
                Assert.assertTrue(customerPortalQuotePageObj.txtBasketSummary(fieldValue).getText().equalsIgnoreCase(fieldValue));
                break;
            case "price":
                System.out.println("Selected cover-- " + selectedCover + " Price----" + fieldValue);
                Assert.assertTrue(customerPortalQuotePageObj.txtBasketSummaryWithPrice(selectedCover).getText().equalsIgnoreCase(fieldValue));
                break;
        }
    }

    public void navigateBackToHomePage() {
        customerPortalHomePageObj.returnBackToHomePage().isEnabled();
        customerPortalHomePageObj.returnBackToHomePage().click();
    }

    public void verifySummarySelection() {
        commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(customerPortalQuotePageObj.lblSummary()));
        System.out.println("Prospect does not select any additional upgrade");
    }

    public void verifyButtonsAvailableForProspect() {
        Assert.assertTrue(commandsObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.btnContinueForProspect())));
        System.out.println("Application provides 'Continue' option for Prospect");
        Assert.assertTrue(!commandsObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.btnBuyNowForProspect())));
        System.out.println("Application does not provide 'Buy'option for Prospect");
    }

    public void declineRenewal() {
        customerPortalQuotePageObj.btnDoNotRenew().click();
        System.out.println("Customer declines to do renewal");
        commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(customerPortalQuotePageObj.txtThankYou()));
        System.out.println("Thank you is displayed");
    }

    public void clickOnUpgrades() {
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.getAQuoteLink().isDisplayed();
        customerPortalQuotePageObj.getAQuoteLink().click();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateInsuredPersons(List<String> parameter) {
        for (int i = 1; i < parameter.size(); i++) {
            System.out.println("i value ----" + i);
            System.out.println("Insured Persons-----" + parameter.get(i));
            Assert.assertTrue(quoteDetailsPageObj.txtSelectedGuest(parameter.get(i)).isDisplayed());
        }
        nextEventPageObj.waitForPageLoad();
    }

    public void validateUpgradesAreAdded(List<String> upgrades) {
        for (int k = 0; k < upgrades.size(); k++) {
            System.out.println("Validating Customer Operations added upgrades----" + upgrades.get(k));
            nextEventPageObj.waitForMoreTime();
            Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.selectedUpgrades(upgrades.get(k)))));
            nextEventPageObj.waitForMoreTime();
            System.out.println("Validated Customer Operations added upgrades----" + upgrades.get(k));
        }
    }

    public void clickUnderstandForSaveQuote() {
        customerPortalQuotePageObj.btnUnderstandSave().click();
    }

    public void downloadAndStoreDocument(String DocName) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(customerPortalQuotePageObj.txtDownloadFileName(DocName).isDisplayed());
        Assert.assertTrue(customerPortalQuotePageObj.linkDownloadFile(DocName).isEnabled());
        customerPortalQuotePageObj.linkDownloadFile(DocName).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void downloadAndStoreDocumentFromClaimPage(String DocName) {
        System.out.println("Claim id from claim summary page----------" + claimID);
        String claimIdFromAQ = claimID;
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        try {
            nextEventPageObj.btnClick(customerPortalQuotePageObj.btnClaimLink(claimIdFromAQ));
        } catch (Exception e) {
            customerPortalQuotePageObj.btnClaimLink(claimIdFromAQ).click();
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        try {
            Assert.assertTrue(customerPortalQuotePageObj.txtDownloadFileName(DocName).isDisplayed());
            Assert.assertTrue(customerPortalQuotePageObj.linkDownloadFileFromClaimPage(DocName).isEnabled());
            customerPortalQuotePageObj.linkDownloadFileFromClaimPage(DocName).click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            Thread.sleep(1000000);
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String dateValueEnter(String fieldValue){
        String dateValues = "";
        String formatChanged="";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfDateChange = new SimpleDateFormat("MM/dd/yyyy");
        if(!fieldValue.contains("/")){
            dateValues = this.tripDate(fieldValue);
        }else {
            dateValues = fieldValue;
        }
        try {
            formatChanged = sdfDateChange.format(sdf.parse(dateValues));
            System.out.println("Date format changed:"+formatChanged);
        }catch(Exception e){
            e.printStackTrace();
        }
        formatChanged = formatChanged.replace("/","");
        System.out.println(formatChanged);
        return formatChanged;
    }

    public void dateCalendarTodate(String fieldValue) {
        String dateValueforToDate = "";
        String sMonthValue = "";
        String sDateValue = "";
        String futureMonthValue = "";
        String futureYearValue = "";
        int count = 0;
        dateValueforToDate = this.tripDate(fieldValue);
        System.out.println("dateval:" + dateValueforToDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sMonthYear = new SimpleDateFormat("MMMM YYYY");
        SimpleDateFormat sDt = new SimpleDateFormat("dd");
        sDateValue = "";
        try {
            sMonthValue = sMonthYear.format(sdf.parse(dateValueforToDate));
            sDateValue = sDt.format(sdf.parse(dateValueforToDate));
        } catch (ParseException p) {
            System.out.println("Parse Exception : " + p);
        }
        futureMonthValue = sMonthValue.trim().split(" ")[0];
        futureYearValue = sMonthValue.trim().split(" ")[1];
        System.out.println("Date Format-Year---" + futureYearValue);
        System.out.println("Date Format-Month---" + futureMonthValue);
        System.out.println("*****Future-date***" + sDateValue);
        System.out.println("Selecting Month----------");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("div testuing --------------" + new Select(quoteDetailsPageObj.drpdnToMonth()).getFirstSelectedOption().getText());
        String selectedOption = new Select(quoteDetailsPageObj.drpdnToMonth()).getFirstSelectedOption().getText();
        while (!selectedOption.equalsIgnoreCase(futureMonthValue) & count <= 12) {
            System.out.println("Inside selecting mopnth------Before clicking--------" + selectedOption);
            quoteDetailsPageObj.nextMonthButtonForToDate().click();
            selectedOption = new Select(quoteDetailsPageObj.drpdnToMonth()).getFirstSelectedOption().getText();
            System.out.println("Inside selecting mopnth------After clicking--------" + selectedOption);
            count++;
        }
        nextEventPageObj.waitForMoreTime();
        if (sDateValue.startsWith("0")) {
            sDateValue = sDateValue.substring(1);
        }
        quoteDetailsPageObj.dateTableForTripToDateXpathGuest(sDateValue).click();
    }

    public void addPatnerAndDependentChild(String persontype, List<List<String>> personDetails) {
        if (persontype.equalsIgnoreCase("Guest")) {
            customerPortalQuotePageObj.iconGuest().click();
            nextEventPageObj.btnClick(customerPortalQuotePageObj.addPerson(persontype));
        } else if (persontype.equalsIgnoreCase("Dependent Child")) {
            customerPortalQuotePageObj.iconDepChild().click();
        } else if (persontype.equalsIgnoreCase("Partner")) {
            customerPortalQuotePageObj.iconPartner().click();
        }
        for (int i = 1; i < personDetails.size(); i++) {
            for (int j = 0; j < personDetails.get(i).size(); j++) {
                this.addPersonDetailsInCustomerportal(personDetails.get(0).get(j), personDetails.get(i).get(j));
            }
        }
    }

    public void verifyThankYouPage() {
        Assert.assertTrue(customerPortalQuotePageObj.verifyThankYou().isDisplayed());
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.btnHomePage().click();
    }

    public void verifyCPAIsDisabled() {
        quoteDetailsPageObj.editCardPaymentRow().click();
        quoteDetailsPageObj.tabCardAcctDetails().click();
        String chkboxStatus = customerPortalQuotePageObj.chkboxCPA().getAttribute("disabled");
        System.out.println("chkboxStatuschkboxStatuschkboxStatuschkboxStatuschkboxStatuschkboxStatus-----"+chkboxStatus);
        Assert.assertEquals("Validating CPA status for Third Party Card","true",chkboxStatus);
        customerPortalQuotePageObj.btnCloseWindow().click();
    }

    public void validateIcons(){
        System.out.println("Validating the icons in customer Portal");
        customerPortalQuotePageObj.weddingIconValidate();
        customerPortalQuotePageObj.tripIconValidate();
        customerPortalQuotePageObj.cancellationIconValidate();
        customerPortalQuotePageObj.businessIconValidate();
        customerPortalQuotePageObj.hazordousIconValidate();
        System.out.println("-----Validation Successful---");
    }
    public void validateTripFromDateNew()
    {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.txtTripFromDate().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM yyyy");
        SimpleDateFormat sd = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Current Date
        c.add(Calendar.DATE, -1);
        String pMonth = sdf.format(c.getTime());
        String pastMonth = pMonth.trim().split(" ")[0];
        String pastYear = pMonth.trim().split(" ")[1];
        String pDate = sd.format(c.getTime());
        System.out.println("Past Month --" + pMonth);
        System.out.println("Date Format---" + pastMonth);
        System.out.println("*****Past date***" + pDate);
        String newDate=pDate.concat("/").concat(pastMonth).concat("/").concat(pastYear);
        customerPortalQuotePageObj.txtTripFromDate().sendKeys(dateValueEnter(newDate));
        customerPortalQuotePageObj.txtTripFromDate().sendKeys(Keys.TAB);
        customerPortalQuotePageObj.txtTripFromDate().sendKeys(Keys.TAB);
    }
    public void validateTripToDateNew(String account) {
        if (account.equalsIgnoreCase("Platinum account")) {
            validDays = 31;
        } else if (account.equalsIgnoreCase("Black account")) {
            validDays = 90;
        } else if (account.equalsIgnoreCase("Silver account")) {
            validDays = 22;
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.txtTripToDate().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM yyyy");
        SimpleDateFormat sd = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Current Date
        int count = 0;
        c.add(Calendar.DATE, validDays);
        String fMonth = sdf.format(c.getTime());
        String futureMonth = fMonth.trim().split(" ")[0];
        String futureYear = fMonth.trim().split(" ")[1];
        String fDate = sd.format(c.getTime());
        System.out.println("Future Month --" + fMonth);
        System.out.println("Date Format---" + futureMonth);
        System.out.println("*****Future date***" + fDate);
        String newDate = fDate.concat("/").concat(futureMonth).concat("/").concat(futureYear);
        customerPortalQuotePageObj.txtTripToDate().sendKeys(dateValueEnter(newDate));
        customerPortalQuotePageObj.txtTripToDate().sendKeys(Keys.TAB);
        customerPortalQuotePageObj.txtTripToDate().sendKeys(Keys.TAB);
    }

    public void navigateToUpgradesTab() {
        try {
            nextEventPageObj.waitForMoreTime();
            customerPortalQuotePageObj.clickOnUpgradesTab().isDisplayed();
            customerPortalQuotePageObj.clickOnUpgradesTab().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        } catch (Exception exe) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.getDriver.navigate().refresh();
            customerPortalQuotePageObj.btnClick(customerPortalQuotePageObj.clickOnUpgradesTab());
            nextEventPageObj.getDriver.navigate().refresh();
        }
    }
}