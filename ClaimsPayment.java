package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.common.LoadTTPropertiesFiles;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClaimsPayment extends BaseStepDef {

    String strEventType_Process = "Process Claim";
    private FinalisePaymentPage finalisePaymentPageObj = new FinalisePaymentPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private EvidenceCollationPage evidenceCollationPageObj = new EvidenceCollationPage();
    private ClaimsOperations claimOperationObj = new ClaimsOperations();
    private co.uk.directlinegroup.tt.utils.Navigation navigationObj = new co.uk.directlinegroup.tt.utils.Navigation();
    private AQConfigurations aqConfigurationsObj = new AQConfigurations();
    private SummaryView summaryViewObj = new SummaryView();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private Commands commandsObj = new Commands();
    private BasicClaimDetailsPage basicClaimDetailsPageObj = new BasicClaimDetailsPage();
    private ClaimPaymentPage claimPaymentPageObj = new ClaimPaymentPage();
    private PerilsAndCostsPage perilsAndCostsPageObj = new PerilsAndCostsPage();
    private PerformSearch performSearchObj = new PerformSearch();
    private ClaimPaymentOperations claimPaymentOperationsObj = new ClaimPaymentOperations();
    private RecoveryOpportunities recoveryOpportunitiesObj = new RecoveryOpportunities();
    private ClaimsRepudiationPage claimsRepudiationPageObj = new ClaimsRepudiationPage();
    private String sysDate = "";


    @And("^I navigate to Manage Details Page$")
    public void iNavigateToManageDetailsPage() {
        navigationObj.navigateToDetailFieldListPage();
        navigationObj.navigateToResourcesAndTablesManagePagesScreen();
    }

    @And("^I am editing '(.+)'$")
    public void iAmEditingPaymentApprovalLimit(String strPageName) {
        aqConfigurationsObj.editPageDetails(strPageName);
    }

    @And("^I can '(.+)' a profile with Payment threshold and it should become effective with changes made$")
    public void iCanAddAProfileWithPaymentThresholdAndItShouldBecomeEffectiveWithChangesMade(String strAction, List<List<String>> lstExpPaymentApprLimitConfig) {
        aqConfigurationsObj.addUpdateDeletePaymentApprovalLimit(strAction, lstExpPaymentApprLimitConfig);
    }

    @Then("^I can see the following details set up for Payment Threshold$")
    public void iCanSeeTheFollowingDetailsSetUpForPaymentThreshold(List<List<String>> lstExpPaymentApprLimitConfig) {
        aqConfigurationsObj.validatePaymentApprovalLimitSetUp(lstExpPaymentApprLimitConfig);
    }

    @Then("^payment status should be '(.+)' '(.+)'$")
    public void paymentStatusShouldBePaymentStatusAndCommunicationShouldBeTriggeredToCustomer(String strPaymentStatus, String strCustomerCommString) {
        switch (strPaymentStatus.toLowerCase()) {
            case "approved":
                break;
            case "payment approval required":
                nextEventPageObj.loadingPage();
                String strDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                summaryViewObj.validateNotesRecordInEventHistory(strPaymentStatus, "Payment amount greater than agent limit", strDate, "Aquarium Automation");
        }
    }

    @And("^I should be able to select the claim items$")
    public void ishouldBeAbleToSelectTheClaimItems() {
        List<WebElement> lineItemsCheckbox = nextEventPageObj.findElements(By.xpath(claimPaymentPageObj.claimImtemCheckboxXpath()));
        System.out.println("line items-----------------------------" + lineItemsCheckbox.size());
        for (int i = 0; i < lineItemsCheckbox.size(); i++) {
            lineItemsCheckbox.get(i).click();
        }
        nextEventPageObj.waitForPageLoad();nextEventPageObj.waitForMoreTime();
        claimPaymentPageObj.selectBtn().click();
        finalisePaymentPageObj.finalisePaymentSave().click();
    }

    @And("^I should be able to select the claim item for Partial Payment$")
    public void ishouldBeAbleToSelectTheClaimItemsForPartialPayment() {
        List<WebElement> lineItemsCheckbox = nextEventPageObj.findElements(By.xpath(claimPaymentPageObj.claimImtemCheckboxXpath()));
        System.out.println("claim items-----------------------------" + lineItemsCheckbox.size());
        lineItemsCheckbox.get(1).click();
        claimPaymentPageObj.selectBtn().click();
        finalisePaymentPageObj.finalisePaymentSave().click();
    }

    @And("^I should select the remaining claim item for final settlement$")
    public void iShouldSelectTheRemainingClaimItemForFinalSettlement() throws Throwable {
        this.ishouldBeAbleToSelectTheClaimItemsForPartialPayment();
    }

    @And("^I should be able to select the following claim items in the claim payment table$")
    public void iShouldBeAbleToSelectTheFollowingClaimItemsInTheClaimPaymentTable(List<List<String>> claimItemsList) {
        claimPaymentOperationsObj.claimItemTableManipulation(claimItemsList);
        claimPaymentPageObj.selectBtn().click();
        claimOperationObj.partialClaimSelectedItems();
        finalisePaymentPageObj.finalisePaymentSave().click();
    }

    @And("^I should be able to verify the dropdown value and fill the fields with following data$")
    public void iShouldBeAbleToVerifyTheDropdownValueAndFillTheFieldsWithFollowingData(List<List<String>> paymentDetails) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < paymentDetails.size(); i++) {
            for (int j = 0; j < paymentDetails.get(0).size(); j++) {
                switch (paymentDetails.get(0).get(j)) {
                    case "Payment Type":
                        boolean flag = false;
                        //nextEventPageObj.findElement(By.xpath("(//input[@value='Please select...'])[1]")).click();
                        claimPaymentPageObj.paymentMethodInput().click();
                        List<WebElement> paymentTypeDropdownValues = nextEventPageObj.findElements(By.xpath(claimPaymentPageObj.paymentTypeDropdownValues()));
                        String value = "";
                        String[] dropdownValue = paymentDetails.get(i).get(j).split("#");
                        for (int k = 0; k < paymentTypeDropdownValues.size(); k++) {
                            flag = false;
                            value = paymentTypeDropdownValues.get(k).getText().trim();
                            System.out.println("dropdown values-----------------goodwill--------------" + value);
                            for (int ilistval = 0; ilistval < dropdownValue.length; ilistval++) {
                                if (value.trim().equalsIgnoreCase(dropdownValue[ilistval].trim())) {
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) {
                                Assert.assertTrue(true);
                            } else {
                                Assert.assertTrue(false);
                            }
                        }
                        break;
                    case "Payment type to select":
                        this.sysDate = new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()).toString();
                        System.out.println("System date ------------------------" + this.sysDate);
                        claimPaymentPageObj.paymentMethodInput().click();
                        claimPaymentPageObj.paymentType(paymentDetails.get(i).get(j)).click();
                        break;
                    case "Payment Amount":
                        claimPaymentPageObj.paymentAmount().sendKeys(paymentDetails.get(i).get(j));
                        break;
                    case "Payment Description":
                        claimPaymentPageObj.paymentDescription().click();
                        claimPaymentPageObj.paymentDescription().sendKeys(paymentDetails.get(i).get(j));
                        break;
                }
            }
        }
        finalisePaymentPageObj.paymetCommentSave().click();
        try {
            Thread.sleep(10000L);// Fix for appliation performance issue tt232
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        getDriver().navigate().refresh();
        commandsObj.waitForLoad(getDriver());
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
        nextEventPageObj.waitForMoreTime();
    }

    @And("^verify the payment record updated in the table$")
    public void verifyThePaymentRecordUpdatedInTheTable(List<List<String>> dataToVerify) {
        claimOperationObj.validateOtherPaymentTable(dataToVerify);
        claimOperationObj.navigateToFinancial();
        claimOperationObj.validatePaymentTableRecord(dataToVerify);
    }

    @And("^I should be able to selct '(.+)' as '(.+)' and enter the following data$")
    public void iShouldBeAbleToFilePaymentDetails(String fieldName, String fieldValue, List<List<String>> dataToFill) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimPaymentPageObj.paymentHelperFields();
        claimPaymentPageObj.paymentHelperFields().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToFrameById(getDriver().findElement(By.id("fancybox-frame")));
        claimPaymentOperationsObj.fieldSelection(fieldName, fieldValue);
        nextEventPageObj.waitForMoreTime();
        System.out.println("first name displayed=====================" + claimPaymentPageObj.payeeFirstName().isDisplayed());
        System.out.println("last name displayed=====================" + claimPaymentPageObj.payeeLastName().isDisplayed());
        for (int i = 1; i < dataToFill.size(); i++) {
            for (int j = 1; j < dataToFill.get(0).size(); j++) {
                claimPaymentOperationsObj.enterPayeeDetails(dataToFill.get(0).get(j), dataToFill.get(i).get(j));
            }
        }
        finalisePaymentPageObj.paymentDetailsSave().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        finalisePaymentPageObj.paymentDetailsClose();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        finalisePaymentPageObj.finalisePaymentSave().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    @And("^validate the estimation recovery for Medical reasons should be '(.+)'$")
    public void validate_the_estimation_recovery_for_Medical_reasons_should_be_(String estRec) {
        recoveryOpportunitiesObj.validateRecoveryAmountInSchemeSummaryPageForMedicalExpenses(estRec);
    }

    @And("^validate the recovery amount percentage has been splitted as '(.+)'$")
    public void validate_the_recovery_amount_has_been_split_as_per_the_recovery(String percentage) {
        recoveryOpportunitiesObj.validateRecoveryPercentage(percentage);
    }

    @And("^validate the status in the recoveries$")
    public void validate_the_status_in_the_recoveries() {
        nextEventPageObj.switchToDefault();
        recoveryOpportunitiesObj.validateStatusInRecoveries();
    }

    @And("^I should be able to verify the dropdown value and fill the fields with following data in policy level$")
    public void iShouldBeAbleToVerifyTheDropdownValueAndFillTheFieldsWithFollowingDataInPolicyLevel(List<List<String>> paymentDetail) {
        this.iShouldBeAbleToVerifyTheDropdownValueAndFillTheFieldsWithFollowingData(paymentDetail);
    }

    @And("^I should be able to '(.+)' with following data to make a payment$")
    public void iShouldBeAbleToEnterBankDetailsWithFollowingDataToMakeAPayment(String eventType, List<List<String>> paymentDetail) throws Throwable {
        claimPaymentOperationsObj.makePayment(eventType, paymentDetail);
    }

    @Then("^System should not allow for payment$")
    public void systemShouldNotAllowForPayment() {
        claimPaymentOperationsObj.paymentErrorMsg();
    }


    @And("^I should be able to verify the account details$")
    public void iShouldBeAbleToVerifyTheAccountDetails(List<List<String>> accountDetails) {
        claimPaymentOperationsObj.verifyAccountDetailUnderPurchase(accountDetails);
    }

    @And("^I should be able to pay the claim with existing '(.+)' details '(.+)' using payment type '(.+)'$")
    public void iShouldBeAbleToPayTheClaimWithExistingBankDetailsusingPaymentType(String paymentType, String accountDetails, String paymentMethod) {
        claimPaymentOperationsObj.paymentProcessWithExistingAccount(paymentType, accountDetails, paymentMethod);
    }

    @And("^I should be able to pay the claim without payment type with existing '(.+)' details '(.+)'$")
    public void iShouldBeAbleToPayTheClaimWithoutPaymentTypeWithExistingBankDetails(String paymentType, String accountDetails) {
        claimPaymentOperationsObj.selectWithExistingAccount(paymentType, accountDetails);
    }

    @And("^I should be able to select the claim items for partial payment$")
    public void iShouldBeAbleToSelectTheClaimItemsForPartialPayment() throws Throwable {
        List<WebElement> lineItemsCheckbox = nextEventPageObj.findElements(By.xpath(claimPaymentPageObj.claimImtemCheckboxXpath()));
        System.out.println("line items-----------------------------" + lineItemsCheckbox.size());
        for (int i = 0; i < lineItemsCheckbox.size() - 1; i++) {
            lineItemsCheckbox.get(i).click();
        }
        claimPaymentPageObj.selectBtn().click();
        finalisePaymentPageObj.finalisePaymentSave().click();
    }


    @And("^validate the recovery amount paid as '(.+)' and estimated amout as '(.+)'$")
    public void validateTheRecoveryAmountPaidAsAndEstimatedAmoutAs(String paidAmount, String estimatedAmount) {
        recoveryOpportunitiesObj.validateRecoveryAmountPaid(paidAmount, estimatedAmount);
    }

    @And("^I should make a partial claim payment with existing '(.+)' details '(.+)' using payment type '(.+)'$")
    public void iShouldMakeAPartialClaimPaymentWithExistingBankDetailsUsingPaymentTypeBACS(String paymentType, String accountDetails, String paymentMethod) throws Throwable {
        claimPaymentOperationsObj.partialPaymentProcessWithExistingAccount(paymentType, accountDetails, paymentMethod);
    }

    @And("^I should be able to verify the following values in Payee type field$")
    public void iShouldBeAbleToVerifyTheFollowingValuesInPayeeTypeField(List<String> payeeTypeDetail) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimPaymentOperationsObj.validateDetails(payeeTypeDetail);
    }

    @And("^I should be able to enter '(.+)' with following data to make a payment$")
    public void iShouldBeAbleToEnterDetailsWithFollowingDataToMakeAPayment(String eventType, List<List<String>> paymentDetail) throws Throwable {
        claimPaymentOperationsObj.enterPaymentDetails(eventType, paymentDetail);
    }

    @And("^I validate the following values in payment method$")
    public void iValidateTheFollowingValuesInPaymentMethod(List<String> dropDownValues) throws Throwable {
        claimPaymentOperationsObj.validateDetailsForPaymentMethod(dropDownValues);
    }

    @And("^validate the '(.+)'  fields$")
    public void validateTheEnterChequeDetailsFields(String event, List<List<String>> fieldsToVerify) throws Throwable {
        claimPaymentOperationsObj.validatePaymentField(event, fieldsToVerify);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 0; i < fieldsToVerify.size(); i++) {
            for (int j = 0; j < fieldsToVerify.get(0).size(); j++) {
                claimPaymentOperationsObj.verifyFieldsAreReadOnly(fieldsToVerify.get(i).get(j));
            }
        }
    }

    @And("^I validate the error message when entered the wrong bank details$")
    public void iValidateTheErrorMessageWhenEnteredTheWrongBankDetails(List<String> fieldvalue) throws Throwable {
        System.out.println("ErrorMessage is-----" + basicClaimDetailsPageObj.validateErrorMessage().getText());
        System.out.println("ErrorMessage is-----" + fieldvalue);
        Assert.assertTrue(basicClaimDetailsPageObj.validateErrorMessage().isDisplayed());
    }

    @And("^I should be able to select the claim items for validating error message$")
    public void iShouldBeAbleToSelectTheClaimItemsForValidatingErrorMessage() throws Throwable {
        List<WebElement> lineItemsCheckbox = nextEventPageObj.findElements(By.xpath(claimPaymentPageObj.claimImtemCheckboxXpath()));
        System.out.println("line items-----------------------------" + lineItemsCheckbox.size());
        for (int i = 0; i < lineItemsCheckbox.size(); i++) {
            lineItemsCheckbox.get(i).click();
            System.out.println("Claim item cost = " + claimPaymentOperationsObj.captureClaimItemAmount(claimPaymentPageObj.ClaimItemTable(),"Total",i+1));
        }
        claimPaymentPageObj.selectBtn().click();
    }

    @And("^I should be able to pay the claim with existing '(.+)' details '(.+)' to validate the read only access$")
    public void iShouldBeAbleToPayTheClaimWithExistingBankDetailsToValidateTheReadOnlyAccess(String paymentType, String accountDetails) {
        claimPaymentOperationsObj.selectWithExistingAccount(paymentType, accountDetails);
    }

    @And("^I should be able to select the partial claim items$")
    public void ishouldBeAbleToSelectThePartialClaimItems() {
        List<WebElement> lineItemsCheckbox = nextEventPageObj.findElements(By.xpath(claimPaymentPageObj.claimImtemCheckboxXpath()));
        System.out.println("line items-----------------------------" + lineItemsCheckbox.size());
        if (lineItemsCheckbox.get(0).isEnabled()) {
            lineItemsCheckbox.get(0).click();
        } else {
            lineItemsCheckbox.get(1).click();
        }
        claimPaymentPageObj.selectBtn().click();
        finalisePaymentPageObj.finalisePaymentSave().click();
    }

    @And("^I should be able to pay the claim with existing '(.+)' details '(.+)' using payment type '(.+)' without adding payment comments$")
    public void iShouldBeAbleToPayTheClaimWithoutPaymentComments(String paymentType, String accountDetails, String paymentMethod) {
        claimPaymentOperationsObj.paymentprocessWithoutAddingPaymentComments(paymentType, accountDetails, paymentMethod);
    }

    @And("^I should be able to select payee '(.+)' for TMA Claim$")
    public void iShouldBeAbleToSelectPayeeForTMAClaim(String payee) throws Throwable {
        claimPaymentOperationsObj.selectPayeeForTMA(payee);

    }

    @And("^I should be able to pay the claim with existing TP supplier '(.+)' details '(.+)' using payment type '(.+)'$")
    public void iShouldBeAbleToPayTheClaimWithExistingTPSupplierBankDetailsUsingPaymentTypeBACS(String paymentType, String accountDetails, String paymentMethod) throws Throwable {
        claimPaymentOperationsObj.selectExistingThirdPartySupplierAccount(paymentType, accountDetails, paymentMethod);
    }

    @And("^validate the recovery amount as '(.+)' and estimated amout as '(.+)'$")
    public void validateTheRecoveryAmountAsAndEstimatedAmoutAs(String Paid, String Estimated) throws Throwable {
        recoveryOpportunitiesObj.validateRecoveryEstimatedAmountPaid(Paid, Estimated);
    }

}

