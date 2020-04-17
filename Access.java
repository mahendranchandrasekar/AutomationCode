package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.ManageReportsPage;
import co.uk.directlinegroup.tt.utils.Report;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import static co.uk.directlinegroup.tt.utils.PolicyOperations.policyId;

public class Access extends BaseStepDef {

    private Report reportObj = new Report();
    private ManageReportsPage manageReportsPageObj = new ManageReportsPage();

    @And("^Entering a customer's '(.+)'  reference in the Access History Report '(.+)'$")
    public void enteringACustomerSActionReferenceInTheAccessHistoryReportReport(String action,String report) throws Throwable {
        reportObj.reportEditViewAccess(report, action);
    }
    @And("^Validate the following '(.+)' for the '(.+)'$")
    public void validateTheFollowingActionForTheReport(String action,String report) throws Throwable {
        reportObj.reportEditViewAccess(report, action);
    }
    @Then("^I should be able to run the report '(.+)' and validate Customer Identification number that  should not be available$")
    public void iShouldBeAbleToRunTheReportAndValidateCustomerIdentificationNumberThatShouldNotBeAvailable(String report) throws Throwable {
        reportObj.runParticularReport(report);
    }
    @And("^I should be able to run the '(.+)' to identify that the customer closes their account$")
    public void iShouldBeAbleToRunTheToIdentifyThatTheCustomerClosesTheirAccount(String Report) throws Throwable {
        reportObj.runParticularReport(Report);
        Assert.assertTrue(manageReportsPageObj.validatePolicy(policyId).isDisplayed());
    }
    @And("^I should be able to close the report$")
    public void iShouldBeAbleToCloseTheReport() throws Throwable {
        reportObj.closeReportToNavigateToPolicy();
    }
    @And("^Run the report '(.+)' to validate the assigned workflow group displayed as '(.+)'$")
    public void iShouldBeAbleToRunTheReportWorkflowCheckToValidateTheAssignedWorkflowGroup(String reportName, String WorkflowGroup){
        reportObj.runParticularReport(reportName);
        reportObj.validateWorkFlowGroup(WorkflowGroup);
    }
}
