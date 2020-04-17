package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.PolicyDataFieldsPage;
import co.uk.directlinegroup.tt.utils.ClaimPaymentOperations;
import co.uk.directlinegroup.tt.utils.ClientOperations;
import cucumber.api.java.en.And;

import java.util.List;

/**
 * Created by 324102 on 9/18/2017.
 */
public class CustomerDetails extends BaseStepDef {
    private ClientOperations clientOperationsObj = new ClientOperations();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();

    @And("^I should allow to select '(.+)' and verify the below fields are displayed$")
    public void iShouldAllowToAddBarWithFieldsListedBelow(String bar, List<List<String>> parameters) {
        clientOperationsObj.verifyBarringFieldDetails(bar, parameters);
    }

    @And("^I should be able to select barring type '(.+)' for '(.+)'$")
    public void iShouldBeAbleToSelectSystemLockdownTypeStopClaimCreation(String systemLockType, String bar) {
        clientOperationsObj.selectBarType(systemLockType, bar,"2" );
    }

    @And("^I should be able to select bar '(.+)' for '(.+)'$")
    public void iShouldBeAbleToSelectBar(String systemLockType, String OOPForBar) {
        clientOperationsObj.selectBarType(systemLockType, OOPForBar,"2");
    }
    @And("^I should be able to select bar '(.+)' for '(.+)' with allow Payment$")
    public void iShouldBeAbleToSelectBarForWithAllowPayment(String systemLockType, String OOPForBar) {
        clientOperationsObj.selectAllowOption(systemLockType, OOPForBar);
    }

    @And("^I should be able to select barring type '(.+)' for '(.+)' and reassessment date after '(.+)' days$")
    public void iShouldBeAbleToSelectSystemLockdownTypeStopClaimCreationReassementDate(String systemLockType, String bar, String days) {
        clientOperationsObj.selectBarType(systemLockType,bar,days);
    }

    @And("^I should select barring type as '(.+)' for '(.+)'$")
    public void iShouldSelectBarringTypeAsStopIndividualClaimPaymentsForBarBlockAddOOP(String barringType, String OOPForBar) throws Throwable {
        clientOperationsObj.selectBarType(barringType,OOPForBar,"NA");
    }

    @And("^I should be able to remove the block of '(.+)' and verify block message is removed$")
    public void iShouldBeAbleToRemoveTheBlockOfAndVerifyBlockMessageIsRemoved(String block) {
        clientOperationsObj.removeBlockAndVerfyBlockMessageRemoved(block);
    }

    @And("^I should be able to validate that the task is assigned to '(.+)' workflow$")
    public void iShouldBeAbleToValidateThatTheTaskIsAssignedToFraudReviewWorkflow(String workflowGroup) {
        clientOperationsObj.verifyTaskAllocated();
    }

    @And("^I should be able to verify the task is added in the Get next task$")
    public void iShouldBeAbleToVerifyTheTaskIsAddedInTheGetNextTask() {
        clientOperationsObj.verifyTaskAllocatedInGetNextTask();
    }

    @And("^I should be able to inactive barring type '(.+)' for '(.+)'$")
    public void iShouldBeAbleToInactiveBarringTypeStopClaimCreationForBarBlockAddOOP(String barringOption, String oopEvent) throws Throwable {
        clientOperationsObj.inactivateBarringOption(barringOption, oopEvent);
    }

    @And("^I should be able to inactive barring type '(.+)' for '(.+)' and reassessment date after '(.+)' days$")
    public void I_should_be_able_to_inactive_barring_type_and_reassessment_date_after_days(String systemLockType, String bar, String days){
        clientOperationsObj.selectBarType(systemLockType, bar, days);
    }

    @And("^I should be able to select the base policy$")
    public void iShouldBeAbleToSelectTheBasePolicy() throws Throwable {
        policyDataFieldsPageObj.basePolicyLink().click();
    }

    @And("^I should be able to validate the exeception$")
    public void iShouldBeAbleToValidateTheExeception(List<List<String>> message) {
        clientOperationsObj.validateErrorMessage(message);
    }

    @And("^I should be able to select '(.+)' and capture the following details about  cause of death and notify the same to different level$")
    public void iShouldBeAbleToSelectDeceasedOOPAndCaptureTheFollowingDetailsAboutCauseOfDeathAndNotifyTheSameToDifferentLevel(String oopEvents, List<List<String>> parameters) {
        clientOperationsObj.enterDeceasedDetails(oopEvents, parameters);
    }

    @And("^I should be able to verify the notification send to the respective team$")
    public void iShouldBeAbleToVerifyTheNotificationSendToTheRespectiveTeam(List<List<String>> parameters) {
        clientOperationsObj.verifyNotificationEventsAndMail(parameters);
    }

    @And("^I should be able to verify the specific task is added in the Get next task$")
    public void iShouldBeAbleToVerifyTheSpecificTaskIsAddedInTheGetNextTask(List<List<String>> parameters){
        clientOperationsObj.verifySpecificTaskAllocatedInGetNextTask(parameters);
    }
}
