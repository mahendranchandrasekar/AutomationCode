package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.CustomerPortalMyClaimsPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.CustomerPortalMyClaimsOperations;
import co.uk.directlinegroup.tt.utils.CustomerPortalMyPolicyOperations;
import co.uk.directlinegroup.tt.utils.DigitalOperations;
import co.uk.directlinegroup.tt.utils.TTAPIOperations;
import co.uk.directlinegroup.tt.utils.common.Commands;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;

import java.util.List;

/**
 * Created by 588800 on 11/16/2017.
 */
public class CustomerPortalMyClaims extends BaseStepDef {

    private CustomerPortalMyClaimsPage customerPortalMyClaimsPageObj = new CustomerPortalMyClaimsPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private CustomerPortalMyClaimsOperations customerPortalMyClaimsOperationsObj = new CustomerPortalMyClaimsOperations();
    private Commands commandsObj = new Commands();
    private CustomerPortalMyPolicyOperations customerPortalMyPolicyOperationsObj = new CustomerPortalMyPolicyOperations();
    private TTAPIOperations ttapiOperationsObj = new TTAPIOperations();

    @And("^I should be landed in Claims home page$")
    public void iShouldBeLandedInClaimsHomePage() throws Throwable {
        Assert.assertTrue(commandsObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.lblMyClaim())));
    }

    @Then("^I should be able to view the following options displayed$")
    public void iShouldBeAbleToViewTheFollowingOptionsDisplayed(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.verifyClaimsOptionsDisplayed(parameters);
    }

    @And("^I verify system displays the message '(.+)'$")
    public void iVerifySystemDisplaysTheMessageNoClaimsExist(String message) throws Throwable {
        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.lblNoOpenClaims())));
        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.lblNoClosedClaims())));
    }

    @Then("^I should be able to view Medical Assistance Abroad with the following message$")
    public void iShouldBeAbleToViewMedicalAssistanceAbroadWithTheFollowingMessage(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.validateMedicalAssistanceAbroad(parameters);
    }

    @Then("^I should be able to view open claims with following details$")
    public void iShouldBeAbleToViewOpenClaimsWithFollowingDetails(List<List<String>> parameters) throws Throwable {
        customerPortalMyPolicyOperationsObj.navigateToHomePage();
        customerPortalMyClaimsOperationsObj.navigateToClaim();
        customerPortalMyClaimsOperationsObj.verifyClaimsOptionsDisplayed(parameters);
    }

    @When("^I click on open claims$")
    public void iClickOnMoreDetails() throws Throwable {
        customerPortalMyClaimsOperationsObj.clickOnMoreItem();
    }

    @Then("^I must be able to view the following options$")
    public void iMustBeAbleToViewTheFollowingOptions(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.verifyClaimsOptionsDisplayed(parameters);
    }

    @Then("^I should be able to provide the following details$")
    public void iShouldBeAbleToProvideTheFollowingDetails(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.createClaim(parameters);
    }

    @When("^I click on Make a claim$")
    public void iClickOnMakeAClaim() throws Throwable {
        customerPortalMyClaimsOperationsObj.clickOnMakeAClaim();
    }

    @And("^I must be able to select the Claim type$")
    public void iMustBeAbleToSelectTheClaimType(List<String> parameter) throws Throwable {
        customerPortalMyClaimsOperationsObj.iShouldSelectClaimType(parameter);
    }

    @And("^I must be able to add claim item as follows$")
    public void iMustBeAbleToAddClaimItemAsFollows(List<List<String>> parameters) throws Throwable {
        Thread.sleep(2000);
        customerPortalMyClaimsOperationsObj.createClaim(parameters);
    }

    @And("^I must be able to save the details$")
    public void iMustBeAbleToSaveTheDetails() throws Throwable {
        customerPortalMyClaimsOperationsObj.clickOnSave();
    }

    @And("^I must be able to answer the following peril questions$")
    public void iMustBeAbleToAnswerTheFollowingPerilQuestions(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.enterPerilQuestions(parameters);
    }

    @Then("^I verify the summary of claim details provided$")
    public void iVerifyTheSummaryOfClaimDetailsProvided(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.verifyClaimsOptionsDisplayed(parameters);
    }

    @And("^I verify system displays message '(.+)'$")
    public void iVerifySystemDisplaysMessage(String msg) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(commandsObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.lblACKMsg(msg))));
    }

    @Then("^I must be able to '(.+)' the claim$")
    public void iMustBeAbleToSubmitTheClaim(String parameter) throws Throwable {
        customerPortalMyClaimsOperationsObj.clickOnSubmitClaim();
    }

    @Then("^verify system should displays youngest claim at first$")
    public void verifySystemShouldDisplaysYoungestClaimAtFirst() throws Throwable {
        customerPortalMyClaimsOperationsObj.validateYoungestClaim();
    }

    @Then("^I should be able to view closed claims with following details$")
    public void iShouldBeAbleToViewClosedClaimsWithFollowingDetails(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.validateClosedClaimDetails(parameters);
    }

    @And("^I navigate to claim summary page$")
    public void iNavigateToSummaryPage() throws Throwable {
        customerPortalMyClaimsOperationsObj.navigateToClaimSummaryPage();
    }

    @And("^I must be able to verify the following message is displayed$")
    public void iMustBeAbleToVerifyTheFollowingMessageIsDisplayed(List<String> parameter) throws Throwable {
        customerPortalMyClaimsOperationsObj.validateClaimConfirmationMsg(parameter);
    }

    @And("^click on Upload Evidence$")
    public void clickOnUploadEvidence() throws Throwable {
        customerPortalMyClaimsOperationsObj.navigateToUploadEvidence();
    }

    @And("^I must be able to upload the document$")
    public void iMustBeAbleToUploadTheDocument() throws Throwable {
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.btnUploadFiles())));
    }

    @And("^I should be able to select the following list of evidence$")
    public void iShouldBeAbleToSelectTheFollowingListOfEvidence(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.validateClaimsDetailsInEvidenceScreen(parameters);
    }

    @When("^I navigate to Claims page$")
    public void iNavigateToClaimsPage() throws Throwable {
        customerPortalMyClaimsOperationsObj.navigateToClaimPage();
    }

    @Then("^I should be able to view the evidence submitted claim with following details$")
    public void iShouldBeAbleToViewTheClaimWithFollowingDetails(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.validateClaimsDetailsInEvidenceScreen(parameters);
    }

    @And("^I must be able to select the below Peril type which doesn't meet Immediate Settlement, Repudiation or Advise of Evidence$")
    public void iMustBeAbleToSelectTheClaimTypeWhichDoesnTMeetImmediateSettlementRepudiationOrAdviseOfEvidence(List<String> parameter) throws Throwable {
        customerPortalMyClaimsOperationsObj.iShouldSelectClaimType(parameter);
    }

    @And("^submit the claim$")
    public void submitTheClaim() throws Throwable {
        customerPortalMyClaimsOperationsObj.navigateToClaimSummaryPage();
        customerPortalMyClaimsOperationsObj.clickOnSubmitClaim();
    }

    @And("^I '(.+)' immediate settlement and system notifies the customer as below$")
    public void iAcceptsImmediateSettlementAndSystemNotifiesTheCustomerAsBelow(String option, List<String> parameter) throws Throwable {
        customerPortalMyClaimsOperationsObj.verifyImmediateSettlementNotificationMsg(option, parameter);
    }

    @Then("^I verify Claim is not accepted for Immediate settlement$")
    public void iVerifyClaimIsNotAcceptedForImmediateSettlement() throws Throwable {
        customerPortalMyClaimsOperationsObj.validateClaimIsNotSettled();
    }

    @When("^I verify claim meets the following Immediate settlement criteria$")
    public void iVerifyClaimMeetsTheFollowingImmediateSettlementCriteria(List<String> parameter) throws Throwable {
        customerPortalMyClaimsOperationsObj.validateImmediateSettlementCriteria(parameter);
    }

    @And("^I should select the Peril type which doesn't meet Immediate Settlement as below$")
    public void iShouldSelectThePerilTypeWhichDoesnTMeetImmediateSettlementAsBelow(List<String> parameter) throws Throwable {
        customerPortalMyClaimsOperationsObj.iShouldSelectClaimType(parameter);
    }

    @Then("^verify system shouldn't allows trip booked date as future date$")
    public void verifySystemShouldnTAllowsTripBookedDateAsFutureDate(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.validateTripDates(parameters);
    }

    @And("^verify system shouldn't allows trip start date after trip end date$")
    public void verifySystemShouldnTAllowsTripStartDateAfterTripEndDate(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.validateTripDates(parameters);
    }

    @And("^verify system shouldn't allows Date of Loss date as future date$")
    public void verifySystemShouldnTAllowsDateOfLossDateAsFutureDate(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.validateTripDates(parameters);
    }

    @And("^customer must be able to view summary details of settlement made for Open claim with the following message$")
    public void customerMustBeAbleToViewSummaryDetailsOfSettlementMadeForOpenClaimWithTheFollowingMessage(List<String> msg) throws Throwable {
        customerPortalMyClaimsOperationsObj.validateSettlementMsg(msg);
    }

    @And("^customer must be able to view summary details with the following message$")
    public void customerMustBeAbleToViewSummaryDetailsWithTheFollowingMessage(List<String> msg) throws Throwable {
        customerPortalMyClaimsOperationsObj.validateSettlementMsg(msg);
    }

    @And("^customer must be able to print or download Partial settlement letter$")
    public void customerMustBeAbleToPrintOrDownloadPartialSettlementLetter() throws Throwable {
        customerPortalMyClaimsOperationsObj.downloadSettlementLetter();
    }

    @And("^verify the provided Evidence for Submitted claim$")
    public void verifyTheProvidedEvidenceForSubmittedClaim() throws Throwable {
        customerPortalMyClaimsOperationsObj.validateTheProvidedEvidence();
    }

    @Then("^I must be navigated to Claims Evidence upload screen$")
    public void iMustBeNavigatedToClaimsEvidenceUploadScreen() throws Throwable {
        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.lblEvidenceScreen())));
    }

    @Then("^I must be navigated to Closed claim summary screen$")
    public void iMustBeNavigatedToClosedClaimSummaryScreen() throws Throwable {
        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.lblClosedClaimScreen())));
    }

    @And("^I must be able to verify the following item have been claimed$")
    public void iMustBeAbleToVerifyTheFollowingItemHaveBeenClaimed(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.validatePerilDetails(parameters);
    }

    @And("^system should presents the Claim details page after submitting the claim with following details$")
    public void systemshouldpresentstheClaimdetailspageaftersubmittingtheclaimwithfollowingdetails(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.gotoClaimdetailsPageafterSubmit(parameters);
    }

    @Then("^validate the claims status as '(.+)'$")
    public void validateTheClaimsStatusAsString(String status) throws Throwable {
        customerPortalMyClaimsOperationsObj.validateClaimStatus(status);
    }

    @And("^System should Excess and Settlement amount as below$")
    public void systemShouldExcessAndSettlementAmountAsBelow(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.validateExcessAndSettleAmt(parameters);
    }

    @And("^I verify closed claim summary is visible only for '(.+)' months$")
    public void iVerifyClosedClaimSummaryIsVisibleOnlyForMonths(String month) throws Throwable {

    }

    @Then("^I must be navigated to '(.+)' screen$")
    public void iMustBeNavigatedToOpenClaimDetailsScreen(String claimScreen) throws Throwable {
        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalMyClaimsPageObj.lblClaimScreen(claimScreen))));
    }

    @And("^I answers '(.+)' to medical emergency question$")
    public void iAnswersToMedicalEmergencyQuestion(String parameter) throws Throwable {
       /* String[] splitYesOrNo = parameter.split("/");
        System.out.println("print the Yes or No condition---" + splitYesOrNo[0]);
        customerPortalMyClaimsPageObj.emergencyMedical(splitYesOrNo[0]).click();*/
        String[] splitYesOrNo = parameter.split("/");
        System.out.println("print the Yes or No condition---" + splitYesOrNo[0]);
        if (splitYesOrNo[0].equalsIgnoreCase("yes")) {
            customerPortalMyClaimsPageObj.emergencyYES().click();
        } else if (splitYesOrNo[0].equalsIgnoreCase("no")){
            customerPortalMyClaimsPageObj.emergencyNO().click();
        }
        //customerPortalMyClaimsPageObj.emergencyMedical(splitYesOrNo[0]).click();
    }


    @And("^I must be able to validate equally split claim amount for the added person$")
    public void iMustBeAbleToValidateEquallySplitClaimAmountForTheAddedPerson(List<List<String>> parameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.validateClaimSplitAmount(parameters);
    }

    @And("^I should be able to delete '(.+)' claim item$")
    public void iShouldBeAbleToDeleteClaimItem(String parameter) throws Throwable {
        customerPortalMyClaimsOperationsObj.deleteClaimitem(parameter);
    }

    @And("^I should be able to edit '(.+)' claim item$")
    public void iShouldBeAbleToEditClaimItem(String parameter) throws Throwable {
        customerPortalMyClaimsOperationsObj.editClaimitem(parameter);
    }

    @And("^I should be able to '(.+)' with the below details through '(.+)' in API$")
    public void iShouldBeAbleToProgressClaimWithTheBelowDetailsThroughPortalAQ(String property, String claimCreatedThrough, List<List<String>> parameters) {
        ttapiOperationsObj.getRefernceID();
        ttapiOperationsObj.progressClaim(property, parameters, claimCreatedThrough);
    }

    @Then("^I must be able to '(.+)' the claims$")
    public void iMustBeAbleToProceedTheClaims(String parameter) throws Throwable {
        customerPortalMyClaimsOperationsObj.clickOnProceedClaim();
    }

    @And("^I must be able verify the evidences$")
    public void I_must_be_able_verify_the_evidences(List<List<String>> parameters) {
        customerPortalMyClaimsOperationsObj.verifyEvidences(parameters);
    }

    @And("^I should be able to verify add person is not available for Silver account$")
    public void iShouldBeAbleToVerifyAddPersonIsNotAvailableForSilverAccount() throws Throwable {
        Assert.assertTrue(!commandsObj.elementDisplayedWithLessTime(By.xpath(customerPortalMyClaimsPageObj.addPersonbuttonText())));
    }
}