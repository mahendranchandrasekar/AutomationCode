package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.utils.RecoveryOpportunities;
import cucumber.api.java.en.And;

import java.util.List;

public class ClaimsRecoveryOpportunities extends BaseStepDef {

    private RecoveryOpportunities recoveryOpportunitiesObj = new RecoveryOpportunities();

    @And("^I should be able to select following Recovery opportunities$")
    public void iShouldBeAbleToSelectFollowingRecoveryOpportunities(List<String> lstRecoveryOpp) throws Throwable {
        recoveryOpportunitiesObj.selectRecoveryOpportunities(lstRecoveryOpp);
    }

    @And("^validate the recovery amount is based on the claim amount$")
    public void validate_the_recovery_amount_is_based_on_the_claim_amount() throws Throwable {
        recoveryOpportunitiesObj.validateRecoveryAmount();
    }

    @And("^I should be able to validate the below Recovery opportunities")
    public void iShouldBeAbleToValidateTheBelowRecoveryOpportunities(List<List<String>> inputValues) throws Throwable {
        recoveryOpportunitiesObj.validateRecoveryListed(inputValues);
    }

    @And("^I should be able to validate the below Other Insurers$")
    public void iShouldBeAbleToValidateTheBelowOtherInsurers(List<List<String>> inputValues) throws Throwable {
        recoveryOpportunitiesObj.validateOtherInsurerListed(inputValues);
    }

    @And("^I should allow to '(.+)' the recovery to the recovery Team '(.+)'$")
    public void iShouldAllowToAssignTheRecoveryToTheRecoveryTeam(String action, String team) throws Throwable {
         recoveryOpportunitiesObj.allocateRecovery(action,team);
    }

    @And("^I should be able to enter the patient details of DWP$")
    public void iShouldBeAbleToEnterThePatientDetailsOfDWP(List<List<String>> parameters) throws Throwable {
        recoveryOpportunitiesObj.enterDWPDetails(parameters);
    }
}
