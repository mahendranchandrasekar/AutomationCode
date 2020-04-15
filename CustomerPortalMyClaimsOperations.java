package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.CustomerPortalHomePage;
import co.uk.directlinegroup.tt.pages.CustomerPortalMyClaimsPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.common.Commands;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static co.uk.directlinegroup.tt.utils.ClaimsOperations.*;

/**
 * Created by 588800 on 11/16/2017.
 */
public class CustomerPortalMyClaimsOperations {

    private NextEventPage nextEventPageObj = new NextEventPage();
    private CustomerPortalMyClaimsPage customerPortalMyClaimsPageObj = new CustomerPortalMyClaimsPage();
    private Commands commandsObj = new Commands();
    private CustomerPortalQuoteOperations customerPortalQuoteOperationsObj = new CustomerPortalQuoteOperations();
    private CustomerPortalMyPolicyOperations customerPortalMyPolicyOperationsObj = new CustomerPortalMyPolicyOperations();
    private CustomerPortalHomePage customerPortalHomePageObj = new CustomerPortalHomePage();
    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private co.uk.directlinegroup.tt.utils.common.Select selectObj = new co.uk.directlinegroup.tt.utils.common.Select();

    private ClaimCreation claimCreationObj = new ClaimCreation();

    public static String cause = "";
    public static String country = "";
    public static String people = "";

    public void navigateToClaim() {
        customerPortalMyClaimsPageObj.tabMyClaims().isDisplayed();
        customerPortalMyClaimsPageObj.btnClick(customerPortalMyClaimsPageObj.tabMyClaims());
    }

    public void clickOnMakeAClaim() {
        customerPortalMyClaimsPageObj.btnMakeAClaim().isDisplayed();
        customerPortalMyClaimsPageObj.btnMakeAClaim().click();
    }

    public void verifyClaimsOptionsDisplayed(List<List<String>> parameters) {
        for (int i = 0; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(i).size(); j++) {
                this.validateClaimsOptions(parameters.get(i).get(j));
            }
        }
    }

    private void validateClaimsOptions(String availableOptions) {
        switch (availableOptions) {
            case "Make a Claim":
                System.out.println("Options : " + availableOptions);
                Assert.assertTrue(nextEventPageObj.elementDisplayed(nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblMakeAClaim()))));
                break;
            case "Medical Assistance Abroad":
            case "Open Claims":
            case "Closed Claims":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("Options : " + availableOptions);
                Assert.assertTrue(nextEventPageObj.elementDisplayed(nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblClaimsOptions(availableOptions)))));
                break;
            case "Claim No":
            case "Status":
            case "Country of loss":
            case "Date of loss":
            case "Trip Start":
            case "End Date":
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue(commandsObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.lblOpenClaimHeadings(availableOptions))));
                Assert.assertNotNull(customerPortalMyClaimsPageObj.lblOpenClaimDetails(availableOptions).getText());
                System.out.println(availableOptions + " : " + customerPortalMyClaimsPageObj.lblOpenClaimDetails(availableOptions).getText());
                break;
            case "Upload documents":
                Assert.assertTrue(commandsObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.lnkForUpload())));
                break;
            case "Providing Evidence":
                customerPortalMyClaimsPageObj.lnkUpload().click();
                Assert.assertTrue(commandsObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.lblEvidenceHeading())));
                customerPortalMyClaimsPageObj.clickNextForClaims();
                break;
            case "Option to withdraw":
                Assert.assertTrue(commandsObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.btnWithdraw())));
                break;
            case "Trip Details":
                System.out.println("Validating ...." + availableOptions);
                Assert.assertNotNull(customerPortalMyClaimsPageObj.lblDestination(availableOptions).getText());
                Assert.assertNotNull(customerPortalMyClaimsPageObj.lblTripBooked(availableOptions).getText());
                Assert.assertNotNull(customerPortalMyClaimsPageObj.lblTripFrom(availableOptions).getText());
                Assert.assertNotNull(customerPortalMyClaimsPageObj.lblTripTo(availableOptions).getText());
                break;
            case "Claim Details":
                System.out.println("Validating ...." + availableOptions);
                Assert.assertNotNull(customerPortalMyClaimsPageObj.lblClaimDetails(availableOptions).getText());
                Assert.assertNotNull(customerPortalMyClaimsPageObj.lblDateOfIncident(availableOptions).getText());
                Assert.assertNotNull(customerPortalMyClaimsPageObj.lblCountryOfLoss(availableOptions).getText());
                break;
            case "Perils Added":
                System.out.println("Validating ...." + availableOptions);
                System.out.println("Added peril -----" + cause);
                System.out.println("Peril displayed on summary page-----" + customerPortalMyClaimsPageObj.lblAddedPeril().getText());
                Assert.assertTrue(customerPortalMyClaimsPageObj.lblAddedPeril().getText().equalsIgnoreCase(cause));
                break;
            case "Claims Questions":
                System.out.println("Validating ...." + availableOptions);
                Assert.assertNotNull(customerPortalMyClaimsPageObj.lblReportedLoss(availableOptions).getText());
                Assert.assertNotNull(customerPortalMyClaimsPageObj.lblProofOwner(availableOptions).getText());
                Assert.assertNotNull(customerPortalMyClaimsPageObj.lblFavColor(availableOptions).getText());
                Assert.assertNotNull(customerPortalMyClaimsPageObj.lblWhatDay(availableOptions).getText());
                break;
        }
    }

    public void validateMedicalAssistanceAbroad(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.verifyClaimsDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void verifyClaimsDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "message displayed":
                nextEventPageObj.waitForMoreTime();
                System.out.println(" Medical Msg ----- " + customerPortalMyClaimsPageObj.lblMediAssistanceMsg().getText());
                break;
            case "action":
                customerPortalMyClaimsPageObj.lnkClickHere().click();
                Assert.assertTrue(commandsObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.lblMedicalStatement())));
                break;
            case "cause":
                Assert.assertTrue(customerPortalMyClaimsPageObj.lblClaimItemInEvidence().getText().equalsIgnoreCase(fieldValue));
                System.out.println("Claim type in Evidence screen----" + customerPortalMyClaimsPageObj.lblClaimItemInEvidence().getText());
                break;
            case "evidence type":
                Assert.assertTrue(customerPortalMyClaimsPageObj.lblEvidenceType().getText().equalsIgnoreCase(fieldValue));
                System.out.println("Subcause in Evidence screen----" + customerPortalMyClaimsPageObj.lblEvidenceType().getText());
                customerPortalMyClaimsPageObj.chkBxEvidenceType().click();
                break;
            case "status":
                Assert.assertTrue(customerPortalMyClaimsPageObj.lblClaimStatus().getText().equalsIgnoreCase(fieldValue));
                System.out.println("Submitted Claim status is----" + customerPortalMyClaimsPageObj.lblClaimStatus().getText());
                break;
            case "medical emergency":
                Assert.assertTrue(customerPortalMyClaimsPageObj.medicalEmergency(fieldValue).getText().equalsIgnoreCase(fieldValue));
                System.out.println("Medical Emergency questions are ----" + customerPortalMyClaimsPageObj.medicalEmergency(fieldValue).getText());
                break;
        }
    }

    public void clickOnEachClaimItem() {
        List<WebElement> claimItems = nextEventPageObj.findElements(By.xpath(customerPortalMyClaimsPageObj.listOfClaims()));
        for (int i = 1; i <= claimItems.size(); i++) {
            System.out.println("Total claim items -----" + claimItems.size());
            System.out.println("click on claim item ------" + i);
            customerPortalMyClaimsPageObj.lnkEachClaimItem(i).click();
            nextEventPageObj.waitForMoreTime();
            customerPortalMyClaimsPageObj.lnkClaimItemShrink().click();
        }
    }

    public void clickOnMoreItem() {
        customerPortalMyClaimsPageObj.lnkClaimItem().isDisplayed();
        customerPortalMyClaimsPageObj.lnkClaimItem().click();
    }

    public void createClaim(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.enterClaimDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void enterClaimDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "where was your trip to?":
                nextEventPageObj.waitForMoreTime();
                new Select(customerPortalMyClaimsPageObj.drpdnDestination()).selectByVisibleText(fieldValue);
                break;
            case "when was your trip booked?":
                if (fieldValue.equalsIgnoreCase("backdate5days")||fieldValue.equalsIgnoreCase("backdate22days")||fieldValue.equalsIgnoreCase("backdate1month")) {
                    System.out.println("Enter Trip booked -----" + customerPortalQuoteOperationsObj.tripDate(fieldValue));
                    customerPortalMyClaimsPageObj.dateTripBooked().clear();
                    customerPortalMyClaimsPageObj.dateTripBooked().sendKeys(customerPortalQuoteOperationsObj.tripDate(fieldValue));
                } else {
                    customerPortalMyClaimsPageObj.dateTripBooked().clear();
                    customerPortalMyClaimsPageObj.dateTripBooked().sendKeys(fieldValue);
                }
                break;
            case "trip dates - start":
                if (fieldValue.equalsIgnoreCase("currentdate") || fieldValue.equalsIgnoreCase("nextday")||fieldValue.equalsIgnoreCase("backdate5days")||fieldValue.equalsIgnoreCase("backdate4days")||fieldValue.equalsIgnoreCase("yesterday")||fieldValue.equalsIgnoreCase("backdate22days")) {
                    System.out.println("Enter from date -----" + customerPortalQuoteOperationsObj.tripDate(fieldValue));
                    customerPortalMyClaimsPageObj.dateTripFrom().clear();
                    customerPortalMyClaimsPageObj.dateTripFrom().sendKeys(customerPortalQuoteOperationsObj.tripDate(fieldValue));
                } else {
                    nextEventPageObj.waitForMoreTime();
                    customerPortalMyClaimsPageObj.dateTripFrom().clear();
                    customerPortalMyClaimsPageObj.dateTripFrom().sendKeys(fieldValue);
                }
                break;
            case "trip dates - end":
                if (fieldValue.equalsIgnoreCase("futuredate22days") || fieldValue.equalsIgnoreCase("currentdate") || fieldValue.equalsIgnoreCase("nextday")|| fieldValue.equalsIgnoreCase("futuredate31days") || fieldValue.equalsIgnoreCase("futuredate10days")||fieldValue.equalsIgnoreCase("backdate5days")||fieldValue.equalsIgnoreCase("backdate4days")||fieldValue.equalsIgnoreCase("yesterday")) {
                    System.out.println("Enter from date -----" + customerPortalQuoteOperationsObj.tripDate(fieldValue));
                    customerPortalMyClaimsPageObj.dateTripTo().clear();
                    customerPortalMyClaimsPageObj.dateTripTo().sendKeys(customerPortalQuoteOperationsObj.tripDate(fieldValue));
                } else {
                    customerPortalMyClaimsPageObj.dateTripTo().clear();
                    customerPortalMyClaimsPageObj.dateTripTo().sendKeys(fieldValue);
                }
                break;
            case "what's happened?":
                customerPortalMyClaimsPageObj.txtDescription().clear();
                customerPortalMyClaimsPageObj.txtDescription().sendKeys(fieldValue);
                break;
            case "what date did it happen?":
                if (fieldValue.equalsIgnoreCase("currentdate") || fieldValue.equalsIgnoreCase("yesterday")|| fieldValue.equalsIgnoreCase("nextday")|| fieldValue.equalsIgnoreCase("backdate4days")|| fieldValue.equalsIgnoreCase("backdate2days") || fieldValue.equalsIgnoreCase("backdate5days")) {
                    System.out.println("Enter from date -----" + customerPortalQuoteOperationsObj.tripDate(fieldValue));
                    customerPortalMyClaimsPageObj.dateofLoss().clear();
                    customerPortalMyClaimsPageObj.dateofLoss().sendKeys(customerPortalQuoteOperationsObj.tripDate(fieldValue));
                } else {
                    nextEventPageObj.waitForMoreTime();
                    customerPortalMyClaimsPageObj.dateofLoss().clear();
                    customerPortalMyClaimsPageObj.dateofLoss().sendKeys(fieldValue);
                }
                System.out.println("Enter from date ---asdas-- desc--------------" + customerPortalQuoteOperationsObj.tripDate(fieldValue));
                break;
            case "where did it happen?":
                nextEventPageObj.waitForMoreTime();
                country = fieldValue;
                new Select(customerPortalMyClaimsPageObj.drpdnCountryOfLoss()).selectByVisibleText(fieldValue);
                System.out.println("Where did it happen-----------------------" + fieldValue);
                break;
            case "action":
                if (fieldValue.equalsIgnoreCase("next")) {
                    System.out.println("Action ----------------------" + fieldValue);
                    this.clickOnNext();
                } else if (fieldValue.equalsIgnoreCase("add")) {
                    nextEventPageObj.waitForMoreTime();
                    customerPortalMyClaimsPageObj.btnClick(customerPortalMyClaimsPageObj.btnAdd());
                } else if (fieldValue.equalsIgnoreCase("cancel")) {
                    this.clickOnCancel();
                } else if (fieldValue.equalsIgnoreCase("save")) {
                    this.clickOnSave();
                } else if (fieldValue.equalsIgnoreCase("proceed")) {
                    nextEventPageObj.waitForMoreTime();
                    customerPortalMyClaimsPageObj.btnClick(customerPortalMyClaimsPageObj.btnProceed());
                } else if (fieldValue.equalsIgnoreCase("add item")) {
                    nextEventPageObj.waitForMoreTime();
                    customerPortalMyClaimsPageObj.btnClick(customerPortalMyClaimsPageObj.btnAddClaimItem());
                }
                break;
            case "claim item":
                nextEventPageObj.waitForMoreTime();
                selectObj.selectValueFromDropdown(customerPortalMyClaimsPageObj.drpdnClaimItem(),fieldValue);
                break;
            case "amount":
                customerPortalMyClaimsPageObj.txtAmount().clear();
                customerPortalMyClaimsPageObj.txtAmount().sendKeys(fieldValue);
                break;
            case "claim detail1":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                selectObj.selectValueFromDropdown(customerPortalMyClaimsPageObj.claimDetail1(),fieldValue);
                break;
            case "claim detail2":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                selectObj.selectValueFromDropdown(customerPortalMyClaimsPageObj.claimDetail2(),fieldValue);
                break;
            case "currency":
                new Select(customerPortalMyClaimsPageObj.drpdnCurrency()).selectByVisibleText(fieldValue);
                break;
            case "who does this apply to?":
                customerPortalMyClaimsPageObj.chBxMainAccountHolder().click();
                break;
            case "person":
                nextEventPageObj.waitForMoreTime();
                System.out.println("------------------------------" + new Select(customerPortalMyClaimsPageObj.drpdnPerson()).getOptions().size());
                if (fieldValue.equalsIgnoreCase("Main Account Holder")) {
                    System.out.println("select main account holder...");
                    new Select(customerPortalMyClaimsPageObj.drpdnPerson()).selectByIndex(1);
                }else if(fieldValue.equalsIgnoreCase("dependent")){

                } else {
                    new Select(customerPortalMyClaimsPageObj.drpdnPerson()).selectByVisibleText(fieldValue);
                }
                break;
            case "description":
                customerPortalMyClaimsPageObj.txtDescriptionClaimItem().clear();
                customerPortalMyClaimsPageObj.txtDescriptionClaimItem().sendKeys(fieldValue);
                break;
            case "claim cause":
                cause = fieldValue;
                customerPortalMyClaimsPageObj.chkBxClaimType(fieldValue).isDisplayed();
                customerPortalMyClaimsPageObj.chkBxClaimType(fieldValue).click();
                break;
            case "claim subcause":
                System.out.println("Claim Item----" + cause);
                selectObj.selectValueFromDropdown(customerPortalMyClaimsPageObj.drpdnSubCause(cause),fieldValue);
                break;
        }
    }

    public void iShouldSelectClaimType(List<String> parameter) {
        for (int i = 0; i < parameter.size(); i++) {
            this.selectClaimType(parameter.get(i));
        }
        this.clickOnNext();
        }

    private void selectClaimType(String claimTypes) {
        String secondaryCause ="";
        String[] claimValues = claimTypes.split("-");
        System.out.println("Peril size: "+claimValues.length);
        cause = claimValues[0];
        secondaryCause = claimValues[1];
        if(claimValues.length>2) {
           for(int i=2;i<claimValues.length;i++){
            secondaryCause = secondaryCause+"-"+ claimValues[i];
           }
        }
        System.out.println("Claim cause is -----" + cause);
        System.out.println("Claim subCause is -----" + secondaryCause);
        nextEventPageObj.waitForMoreTime();
        customerPortalMyClaimsPageObj.chkBxClaimType(cause).isDisplayed();
        nextEventPageObj.btnClick(customerPortalMyClaimsPageObj.chkBxClaimType(cause));
        nextEventPageObj.waitForMoreTime();
        System.out.println("secondary cause=========="+secondaryCause);
        selectObj.selectValueFromDropdown(customerPortalMyClaimsPageObj.drpdnSubCause(cause),secondaryCause);
    }

    public void clickOnNext() {
        nextEventPageObj.waitForMoreTime();
        customerPortalMyClaimsPageObj.btnClick(customerPortalMyClaimsPageObj.btnNext());
    }

    public void clickOnSave() {
        customerPortalMyClaimsPageObj.btnSave().isDisplayed();
        customerPortalMyClaimsPageObj.btnSave().click();
    }

    public void enterPerilQuestions(List<List<String>> parameters) {
        if (commandsObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.lblReportedLost()))) {
            for (int i = 1; i < parameters.size(); i++) {
                for (int j = 0; j < parameters.get(0).size(); j++) {
                    this.capturePerilQuestionDetails(parameters.get(0).get(j), parameters.get(i).get(j));
                }
            }
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nextEventPageObj.btnClick(customerPortalMyClaimsPageObj.btnNext());
        } else {
            for (int i = 1; i < parameters.size(); i++) {
                for (int j = 0; j < parameters.get(0).size(); j++) {
                    this.capturePerilQuestionDetails(parameters.get(0).get(j), parameters.get(i).get(j));
                }
            }
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nextEventPageObj.btnClick(customerPortalMyClaimsPageObj.btnNext());
        }
    }

    private void capturePerilQuestionDetails(String fieldName, String fieldValue) {
        switch (fieldName.trim()) {
            case "Has the item been reported lost?":
            case "Was the item reported stolen?":
            case "Do you have proof of ownership for the item(s)?":
            case "Is a loss report available?":
            case "Who was the loss reported to?":
            case "What date was the item reported lost?":
                System.out.println("Peril Question----" + fieldName);
                System.out.println("Peril Answer----" + fieldValue);
                System.out.println("answer to peril questions....");
                customerPortalMyClaimsPageObj.drpdnPerilQuestions(fieldName).click();
                new Select(customerPortalMyClaimsPageObj.drpdnPerilQuestions(fieldName)).selectByVisibleText(fieldValue);
                break;
            case "Which of the following is the affected person?":
                System.out.println("Peril Question----" + fieldName);
                System.out.println("Peril Answer----" + fieldValue);
                System.out.println("answer to peril questions....");
                customerPortalMyClaimsPageObj.drpdnPerilQuestions(fieldName).click();
                new Select(customerPortalMyClaimsPageObj.drpdnPerilQuestions(fieldName)).selectByVisibleText(fieldValue);
                break;
            case "Store notes relating to the previous question":
                System.out.println("Peril Question----" + fieldName);
                customerPortalMyClaimsPageObj.storeNotes(fieldName).sendKeys(fieldValue);
                break;
            case "Reported Lost":
                new Select(customerPortalMyClaimsPageObj.drpdnReportedLost()).selectByVisibleText(fieldValue);
                break;
            case "Proof of Ownership":
                new Select(customerPortalMyClaimsPageObj.drpdnProofOfOwnership()).selectByVisibleText(fieldValue);
                break;
            case "What's your favourite colour?":
                new Select(customerPortalMyClaimsPageObj.drpdnFavColor()).selectByVisibleText(fieldValue);
                break;
            case "What day is it?":
                new Select(customerPortalMyClaimsPageObj.drpdnDay()).selectByVisibleText(fieldValue);
                break;
            case "action":
                if (fieldValue.equalsIgnoreCase("save")) {
                    this.clickOnSave();
                } else if (fieldValue.equalsIgnoreCase("next")) {
                    System.out.println("Action ----------------------" + fieldValue);
                    this.clickOnNext();
                }
                break;
            case "Inpatient for 3 days":
                System.out.println("-----Inpatient-----");
                new Select(customerPortalMyClaimsPageObj.drpdnInpatient()).selectByVisibleText(fieldValue);
                break;
        }
    }

    public void clickOnSubmitClaim() {
        nextEventPageObj.waitForMoreTime();
        System.out.println("Submitting the claim..");
        if(customerPortalMyClaimsPageObj.btnSubmit().isDisplayed()){
            nextEventPageObj.btnClick(customerPortalMyClaimsPageObj.btnSubmit());
        }else if(customerPortalMyClaimsPageObj.btnProceed().isDisplayed()){
            nextEventPageObj.btnClick(customerPortalMyClaimsPageObj.btnProceed());
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(commandsObj.elementDisplayedWithLessTime(By.xpath(customerPortalMyClaimsPageObj.btnViewClaimsXpath()))) {
            customerPortalMyClaimsPageObj.btnViewClaims().click();
        }
    }

    public void validateYoungestClaim() {
        System.out.println("validating youngest claim.....");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalMyPolicyOperationsObj.navigateToHomePage();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        this.navigateToClaim();
        System.out.println("submitted Country of Loss-----" + country);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("Youngest claim ID------" + customerPortalMyClaimsPageObj.lblYoungestCountryOfLoss().getText());
        Assert.assertTrue(country.equalsIgnoreCase(customerPortalMyClaimsPageObj.lblYoungestCountryOfLoss().getText()));
    }

    public void navigateToClaimSummaryPage() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalMyClaimsPageObj.btnClick(customerPortalMyClaimsPageObj.clickNextForClaims());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateClaimConfirmationMsg(List<String> parameter) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalMyClaimsPageObj.msgConfirmation().isDisplayed();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        String[] msgDisplayed = parameter.get(0).split("#");
        System.out.println("Msg - No of lines-- " + msgDisplayed.length);
        System.out.println("Claim Notification msg ----" + customerPortalMyClaimsPageObj.msgConfirmation().getText());
        System.out.println("msgDisplayed[0].trim()-----------------"+msgDisplayed[0].toString().trim());
        System.out.println("msgDisplayed[0].trim()-----------------"+customerPortalMyClaimsPageObj.msgConfirmationPara1().getText().trim());
        System.out.println("msgDisplayed[1].trim()-----------------"+msgDisplayed[1].toString().trim());
        System.out.println("msgDisplayed[1].trim()-----------------"+customerPortalMyClaimsPageObj.msgConfirmationPara2().getText().trim());
        System.out.println("msgDisplayed[0].trim()-----------------"+msgDisplayed[2].toString().trim());
        System.out.println("msgDisplayed[0].trim()-----------------"+customerPortalMyClaimsPageObj.msgConfirmationPara3().getText().trim());
        //TODO need to uncomment after debugging
        Assert.assertTrue(msgDisplayed[0].toString().trim().equalsIgnoreCase(customerPortalMyClaimsPageObj.msgConfirmationPara1().getText()));
        Assert.assertTrue(msgDisplayed[1].toString().trim().equalsIgnoreCase(customerPortalMyClaimsPageObj.msgConfirmationPara2().getText()));
        Assert.assertTrue(msgDisplayed[2].toString().trim().equalsIgnoreCase(customerPortalMyClaimsPageObj.msgConfirmationPara3().getText()));
        if (msgDisplayed.length >= 4) {
            System.out.println("Validating inside loop....");
            Assert.assertTrue(msgDisplayed[3].trim().equalsIgnoreCase(customerPortalMyClaimsPageObj.msgConfirmationPara4().getText()));
        }
    }

    public void navigateToUploadEvidence() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalMyClaimsPageObj.btnUploadEvidence().click();
    }

    public void validateClaimsDetailsInEvidenceScreen(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.verifyClaimsDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    public void navigateToClaimPage() {
        customerPortalMyClaimsPageObj.btnClick(customerPortalMyClaimsPageObj.tabMyClaims());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(commandsObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.lblMyClaim())));
    }

    public void verifyImmediateSettlementNotificationMsg(String option, List<String> parameter) {
        if (option.equalsIgnoreCase("accepts")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(customerPortalMyClaimsPageObj.btnAccept());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        } else if (option.equalsIgnoreCase("declines")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(customerPortalMyClaimsPageObj.btnDiscuss());
            nextEventPageObj.waitForMoreTime();
        }
        nextEventPageObj.waitForMoreTime();
        customerPortalMyClaimsPageObj.msgConfirmation().isDisplayed();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        String[] msgDisplayed = parameter.get(0).split("#");
        System.out.println("Msg - No of lines-- " + msgDisplayed.length);
        System.out.println("Claim Notification msg ----" + customerPortalMyClaimsPageObj.msgConfirmation().getText());
        System.out.println("Claim Notification msg Para1 ----" + customerPortalMyClaimsPageObj.msgConfirmationPara1().getText());
        System.out.println("Claim Notification msg Para2----" + customerPortalMyClaimsPageObj.msgConfirmationPara2().getText());
        Assert.assertEquals("Validating Immediate Sttlement Message - Para 1",msgDisplayed[0].trim(),customerPortalMyClaimsPageObj.msgConfirmationPara1().getText());
        Assert.assertEquals("Validating Immediate Sttlement Message - Para 2",msgDisplayed[1].trim(),customerPortalMyClaimsPageObj.msgConfirmationPara2().getText());
        if (msgDisplayed.length >= 3) {
            System.out.println("Validating last line of confirmation msg....");
            Assert.assertTrue(msgDisplayed[2].trim().equalsIgnoreCase(customerPortalMyClaimsPageObj.msgConfirmationPara3().getText()));
        }
        customerPortalMyClaimsPageObj.btnViewClaims().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
    }

    public void validateClaimIsNotSettled() {
        nextEventPageObj.getDriver.navigate().refresh();
        nextEventPageObj.getDriver.navigate().refresh();
        Assert.assertTrue(customerPortalMyClaimsPageObj.lblClaimStatus().getText().equalsIgnoreCase("Claim Submitted"));
    }

    public void validateImmediateSettlementCriteria(List<String> parameter) {
        customerPortalMyClaimsPageObj.tabMyClaims().click();
        nextEventPageObj.waitForPageLoad();
        for (int i = 0; i < parameter.size(); i++) {
            this.verifyImmediateSettlementCriteria(parameter.get(i));
        }
    }

    private void verifyImmediateSettlementCriteria(String criteria) {
        switch (criteria.toLowerCase()) {
            case "no claim in last 12 months":
                this.validateNoOfClaims();
                break;
            case "all evidence provided or available":
                Assert.assertTrue(!customerPortalMyClaimsPageObj.lblClaimStatus().getText().equalsIgnoreCase("Information Required"));
                Assert.assertTrue(customerPortalMyClaimsPageObj.lblClaimStatus().getText().equalsIgnoreCase("Payment"));
                break;
            case "claim total is less than or equal to the immediate settlement limit-£300.00":
                String immedSettlementLimit[] = criteria.split("£");
                double limit = Double.parseDouble(immedSettlementLimit[1]);
                System.out.println("Immediate settlement limit -----" + limit);
                customerPortalMyClaimsPageObj.lblClaimStatus().click();
                customerPortalMyClaimsPageObj.drpdnClaimItems().click();
                String[] claimAmt = customerPortalMyClaimsPageObj.lblClaimAmt().getText().split("£");
                System.out.println("Claim Item -----" + claimAmt[1]);
                double claimItemAmt = Double.parseDouble(claimAmt[1]);
                System.out.println("Claim Item Amt -----" + claimItemAmt);
                Assert.assertTrue(claimItemAmt <= limit);
                break;
        }
    }

    public void validateNoOfClaims() {
        nextEventPageObj.waitForPageLoad();
        List<WebElement> noOFClaims = nextEventPageObj.findElements(By.xpath(customerPortalMyClaimsPageObj.claimsTable()));
        int totalClaims = noOFClaims.size();
        System.out.println("Total claims in claims summary page ----" + totalClaims);
        Assert.assertEquals(totalClaims, 1);
    }

    public void validateTripDates(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.verifyClaimTripDates(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void verifyClaimTripDates(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "trip booked date":
                new Select(customerPortalMyClaimsPageObj.drpdnDestination()).selectByIndex(1);
                if (fieldValue.equalsIgnoreCase("tomorrow")) {
                    customerPortalMyClaimsPageObj.dateTripBooked().clear();
                    customerPortalMyClaimsPageObj.dateTripBooked().sendKeys(customerPortalQuoteOperationsObj.tripDate("currentdate"));
                    nextEventPageObj.waitForMoreTime();
                    customerPortalMyClaimsPageObj.tabTripDetails().click();
                    System.out.println("Trip Booked Date ---- Future date should be disabled -----" + customerPortalMyClaimsPageObj.futureDate().getAttribute("class"));
                    Assert.assertTrue(customerPortalMyClaimsPageObj.futureDate().getAttribute("class").equalsIgnoreCase("is-disabled"));
                }
                break;
            case "trip start date":
                if (fieldValue.equalsIgnoreCase("Today")) {
                    customerPortalMyClaimsPageObj.dateTripFrom().clear();
                    System.out.println("Enter start date.....");
                    customerPortalMyClaimsPageObj.dateTripFrom().sendKeys(customerPortalQuoteOperationsObj.tripDate(fieldValue));
                    customerPortalMyClaimsPageObj.tabTripDetails().click();
                }
                break;
            case "trip end date":
                if (fieldValue.equalsIgnoreCase("Yesterday")) {
                    customerPortalMyClaimsPageObj.dateTripTo().click();
                    String[] yesterday = customerPortalQuoteOperationsObj.tripDate(fieldValue).split("/");
                    String[] singledigit = yesterday[0].split("");
                    System.out.println("----Single digit is -------" + singledigit[0]);
                    String single = singledigit[0];
                    System.out.println("----Single digit is -------" + single);
                    int result = Integer.parseInt(single);
                    if (result == 0) {
                        System.out.println("---------" + singledigit[1]);
                        Assert.assertTrue(customerPortalMyClaimsPageObj.tripEndDateBeforeStartDate(singledigit[1]).getAttribute("class").equalsIgnoreCase("is-disabled"));
                        customerPortalMyClaimsPageObj.dateTripTo().sendKeys(customerPortalQuoteOperationsObj.tripDate("nextday"));
                    } else {
                        Assert.assertTrue(customerPortalMyClaimsPageObj.tripEndDateBeforeStartDate(yesterday[0]).getAttribute("class").equalsIgnoreCase("is-disabled"));
                        customerPortalMyClaimsPageObj.dateTripTo().sendKeys(customerPortalQuoteOperationsObj.tripDate("nextday"));
                    }
                }
                break;
            case "date of loss":
                if (fieldValue.equalsIgnoreCase("Tomorrow")) {
                    String[] tomorrow = customerPortalQuoteOperationsObj.tripDate(fieldValue).split("/");
                    customerPortalMyClaimsPageObj.dateofLoss().clear();
                    customerPortalMyClaimsPageObj.dateofLoss().sendKeys(customerPortalQuoteOperationsObj.tripDate("currentdate"));
                    customerPortalMyClaimsPageObj.dateofLoss().click();
                    String[] singledigit = tomorrow[0].split("");
                    System.out.println("----Single digit is -------" + singledigit[0]);
                    String single = singledigit[0];
                    System.out.println("----Single digit is -------" + single);
                    int result = Integer.parseInt(single);
                    if (result == 0) {
                        Assert.assertTrue(customerPortalMyClaimsPageObj.dateOfLossFutureDate(singledigit[1]).getAttribute("class").equalsIgnoreCase("dob-icon ng-touched ng-dirty ng-valid"));
                        System.out.println("Date of Loss --- Future date should be disabled -----" + customerPortalMyClaimsPageObj.futureDate().getAttribute("class"));
                        Assert.assertTrue(customerPortalMyClaimsPageObj.futureDate().getAttribute("class").equalsIgnoreCase("is-disabled"));
                    } else {
                        Assert.assertTrue(customerPortalMyClaimsPageObj.dateOfLossFutureDate(tomorrow[0]).getAttribute("class").equalsIgnoreCase("dob-icon ng-touched ng-dirty ng-valid"));
                        System.out.println("Date of Loss --- Future date should be disabled -----" + customerPortalMyClaimsPageObj.futureDate().getAttribute("class"));
                        Assert.assertTrue(customerPortalMyClaimsPageObj.futureDate().getAttribute("class").equalsIgnoreCase("is-disabled"));

                    }
                }
                break;
        }
    }

    public void validateSettlementMsg(List<String> msg) {
        Assert.assertTrue(msg.get(0).equalsIgnoreCase(customerPortalHomePageObj.msgPaymentsInOpenClaimDetailsPage(1).getText()));
        Assert.assertTrue(msg.get(1).equalsIgnoreCase(customerPortalHomePageObj.msgPaymentsInOpenClaimDetailsPage(2).getText()));
    }

    public void downloadSettlementLetter() {
        customerPortalMyClaimsPageObj.claimPaymentButton().click();
        customerPortalMyClaimsPageObj.lnkSettlementLetterDownload().click();
        int docSize = 0;
        try {
            docSize = (int) claimsOperationsObj.fileSize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("file size----------------------------" + docSize);
        Assert.assertTrue(docSize > 0);
    }

    public void validateTheProvidedEvidence() {
        customerPortalMyClaimsPageObj.btnClaimEvidence().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalMyClaimsPageObj.lnkUploadEvidence().click();
        if (subcausecodestring.equalsIgnoreCase("Fatality/Death")) {
            Assert.assertTrue(commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(customerPortalMyClaimsPageObj.lnkProvidedEvidence(submittedEvidence1))));
            Assert.assertTrue(commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(customerPortalMyClaimsPageObj.lnkProvidedEvidence(submittedEvidence2))));
        }
        Assert.assertTrue(!commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(customerPortalMyClaimsPageObj.lnkProvidedEvidence(notSubmittedEvidence1))));
        Assert.assertTrue(!commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(customerPortalMyClaimsPageObj.lnkProvidedEvidence(notSubmittedEvidence2))));
        Assert.assertTrue(!commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(customerPortalMyClaimsPageObj.lnkProvidedEvidence(notSubmittedEvidence3))));
    }

    public void validatePerilDetails(List<List<String>> parameters) {
        customerPortalMyClaimsPageObj.lnkClaimDetails().click();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.verifyPerilDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void verifyPerilDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "claimitem":
                customerPortalMyClaimsPageObj.btnClaimItem().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                String claimItem = customerPortalMyClaimsPageObj.txtClaimItem(fieldValue).getText();
                Assert.assertTrue(claimItem.equalsIgnoreCase(fieldValue));
                System.out.println("Selected claim item is validated in customer portal");
                break;
            case "selectedperil":
                String selectedPeril = customerPortalMyClaimsPageObj.txtSelectedPeril().getText();
                System.out.println("Selected peril is----" + selectedPeril);
                Assert.assertTrue(selectedPeril.equalsIgnoreCase(fieldValue));
                System.out.println("Selected peril item is validated in customer portal");
                break;
            case "amount":
                String amount = customerPortalMyClaimsPageObj.txtClaimItem(fieldValue).getText();
                System.out.println("Given amount is----" + amount);
                Assert.assertTrue(amount.equalsIgnoreCase(fieldValue));
                System.out.println("Given amount is validated in customer portal");
                break;
            case "person":
                if (fieldValue.equalsIgnoreCase("Main Account Holder")) {
                    System.out.println("Added person in AQ is----" + addedPerson);
                    Assert.assertTrue(customerPortalMyClaimsPageObj.txtPerson().isDisplayed());
                    System.out.println("Added person  is validated in customer portal");
                }
                break;
            case "partial amount":
                String partialAmount = customerPortalMyClaimsPageObj.txtAmountPartialPayment().getText();
                System.out.println("Given amount is----" + partialAmount);
                Assert.assertTrue(partialAmount.equalsIgnoreCase(fieldValue));
                System.out.println("Given amount is validated in customer portal");
                break;
        }
    }

    public void clickingOnClaimNext() {
        nextEventPageObj.waitForMoreTime();
        customerPortalMyClaimsPageObj.btnclickNext().click();
    }

    public void gotoClaimdetailsPageafterSubmit(List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalMyClaimsPageObj.btnClick(customerPortalMyClaimsPageObj.btnViewClaims());
        customerPortalMyClaimsPageObj.btnClick(customerPortalMyClaimsPageObj.lnkClaimItem());
        customerPortalMyClaimsPageObj.btnClick(customerPortalMyClaimsPageObj.openClaimDetails());
        System.out.println("Claim details displayed after submitting....");
        for (int i = 0; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(i).size(); j++) {
                this.validateClaimdetailsPageafterSubmit(parameters.get(i).get(j));
            }
        }
    }

    private void validateClaimdetailsPageafterSubmit(String ClaimdetailsinSummaryPage) {
        switch (ClaimdetailsinSummaryPage.toLowerCase()) {
            case "thank you for submitting your claim online":
            case "thank you for submitting your new claim online via our portal.":
                System.out.println("Options : " + ClaimdetailsinSummaryPage);
                Assert.assertTrue(nextEventPageObj.elementDisplayed(nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblThankyouMsg(ClaimdetailsinSummaryPage)))));
                break;
            case "person":
                System.out.println("Options : " + ClaimdetailsinSummaryPage);
                Assert.assertTrue(nextEventPageObj.elementDisplayed(nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblPerson()))));
                System.out.println("Person as....." + customerPortalMyClaimsPageObj.lblPersondata());
                break;
            case "claimed items":
                System.out.println("Options : " + ClaimdetailsinSummaryPage);
                Assert.assertTrue(nextEventPageObj.elementDisplayed(nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblClaimedItems()))));
                System.out.println("Claimed items as....." + customerPortalMyClaimsPageObj.lblClaimedItemsdata());
                break;
            case "claimed":
                System.out.println("Options : " + ClaimdetailsinSummaryPage);
                Assert.assertTrue(nextEventPageObj.elementDisplayed(nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblClaimed()))));
                System.out.println("Claimed as....." + customerPortalMyClaimsPageObj.lblClaimeddata());
                break;
            case "excess":
                System.out.println("Options : " + ClaimdetailsinSummaryPage);
                Assert.assertTrue(nextEventPageObj.elementDisplayed(nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblExcess()))));
                System.out.println("Excess as....." + customerPortalMyClaimsPageObj.lblExcessdata());
                break;
            case "settle":
                System.out.println("Options : " + ClaimdetailsinSummaryPage);
                Assert.assertTrue(nextEventPageObj.elementDisplayed(nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblSettle()))));
                System.out.println("Settle as....." + customerPortalMyClaimsPageObj.lblSettledata());
                break;
        }
    }

    public void validateClaimStatus(String status) {
        for(int i =1;i<=5;i++) {
            nextEventPageObj.getDriver.navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(customerPortalMyClaimsPageObj.lblClaimStatus().getText().equalsIgnoreCase(status)){
                break;
            }
        }
        Assert.assertTrue(customerPortalMyClaimsPageObj.lblClaimStatus().getText().equalsIgnoreCase(status));
        claimCreationObj.claimID = customerPortalMyClaimsPageObj.lblYoungestClaimID().getText();
    }

    public void validateExcessAndSettleAmt(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(i).size(); j++) {
                this.verifyExcessAndSettleAmt(parameters.get(1).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void verifyExcessAndSettleAmt(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "claimed amt":
                System.out.println("Claimed as....." + nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblClaimeddata())).getText());
                Assert.assertTrue(nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblClaimeddata())).getText().equalsIgnoreCase(fieldValue));
                break;
            case "excess amt":
                System.out.println("Excess as....." + nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblExcessdata())).getText());
                Assert.assertTrue(nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblExcessdata())).getText().equalsIgnoreCase(fieldValue));
                break;
            case "settle amt":
                System.out.println("Settle as....." + nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblSettledata())).getText());
                Assert.assertTrue(nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblSettledata())).getText().equalsIgnoreCase(fieldValue));
                break;
            case "status":
                System.out.println("customerPortalMyClaimsPageObj.txtStatusInDigital().getText()-----" + customerPortalMyClaimsPageObj.txtStatusInDigital().getText());
                Assert.assertTrue(customerPortalMyClaimsPageObj.txtStatusInDigital().getText().equalsIgnoreCase(fieldValue));
                break;
            case "letter":
                customerPortalMyClaimsPageObj.txtStatusInDigital().click();
                Assert.assertTrue(nextEventPageObj.elementDisplayed(nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblClaimLetter(fieldValue)))));
                break;
            case "immediate settlement limit":
                String immedSettlementLimit[] = fieldValue.split("£");
                double limit = Double.parseDouble(immedSettlementLimit[1]);
                System.out.println("Immediate settlement limit -----" + limit);
                String[] claimAmt = nextEventPageObj.findElement(By.xpath(customerPortalMyClaimsPageObj.lblSettledata())).getText().split("£");
                System.out.println("Claim Item -----" + claimAmt[1]);
                double claimItemAmt = Double.parseDouble(claimAmt[1]);
                System.out.println("Claim Item Amt -----" + claimItemAmt);
                Assert.assertTrue(claimItemAmt <= limit);
                break;
        }
    }

    public void validateClosedClaimDetails(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(i).size(); j++) {
                this.verifyExcessAndSettleAmt(parameters.get(1).get(j), parameters.get(i).get(j));
            }
        }
    }

    public void medicalEmergencyQuestions(String yes, String no, List<List<String>> lstInputs) {
        Assert.assertTrue(customerPortalMyClaimsPageObj.emergencyMedicalYesOrNo(yes).isDisplayed());
        Assert.assertTrue(customerPortalMyClaimsPageObj.emergencyMedicalYesOrNo(no).isDisplayed());
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                Assert.assertTrue(customerPortalMyClaimsPageObj.emergencyMedicalQuestionsMakeClaimPage(lstInputs.get(i).get(j)).isDisplayed());
            }
        }
    }

    public void validateClaimSplitAmount(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.verifyClaimSplitAmt(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void verifyClaimSplitAmt(String fieldName, String fieldValue) {
        String amountValue = "";
        switch (fieldName.toLowerCase()) {
            case "people":
                people = fieldValue;
                break;
            case "amount":
                amountValue = customerPortalMyClaimsPageObj.claimAmountSplit(people, fieldValue).getText();
                System.out.println("Given price------------" + amountValue);
                System.out.println("Price from feature file---" + fieldValue);
                Assert.assertTrue(amountValue.equalsIgnoreCase(fieldValue));
                people = "";
                System.out.println("People value:" + people);
                break;
        }
    }

    public void deleteClaimitem(String parameter) {
        nextEventPageObj.waitForMoreTime();
        System.out.println("deleting the claim..");
        nextEventPageObj.btnClick(customerPortalMyClaimsPageObj.optDelete(parameter));
        nextEventPageObj.waitForMoreTime();
    }

    public void editClaimitem(String parameter) {
        nextEventPageObj.waitForMoreTime();
        System.out.println("editing the claim..");
        nextEventPageObj.btnClick(customerPortalMyClaimsPageObj.optEdit(parameter));
        nextEventPageObj.waitForMoreTime();
    }

    public void clickOnProceedClaim() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nextEventPageObj.waitForMoreTime();
        System.out.println("proceeding the claim..");
        customerPortalMyClaimsPageObj.btnProceed().isDisplayed();
        nextEventPageObj.btnClick(customerPortalMyClaimsPageObj.btnProceed());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
     public void verifyEvidences(List<List<String>> parameters){
         if(parameters.get(0).get(0).equalsIgnoreCase("Evidence Provided")) {
             for (int i = 1; i < parameters.size() - 1; i++) {
                 String evidenceRequired = customerPortalMyClaimsPageObj.evidence(parameters.get(i).get(0)).getText();
                 customerPortalMyClaimsPageObj.evidence(parameters.get(i).get(0)).isDisplayed();
                 Assert.assertTrue(evidenceRequired.equalsIgnoreCase(parameters.get(i).get(0)));
                 System.out.println("Evidence is displayed---------" + evidenceRequired);
             }
         }
     }

    public void clickOnCancel() {
        customerPortalMyClaimsPageObj.btnCancel().isDisplayed();
        customerPortalMyClaimsPageObj.btnCancel().click();
    }
}


