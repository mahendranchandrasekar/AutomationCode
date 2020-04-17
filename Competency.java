package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.ClaimCompetencyPage;
import co.uk.directlinegroup.tt.utils.ClaimsOperations;
import co.uk.directlinegroup.tt.utils.CompetencyOperations;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.List;

/**
 * Created by 324102 on 10/4/2017.
 */
public class Competency extends BaseStepDef {

    private CompetencyOperations competencyOperationsObj = new CompetencyOperations();
    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    public String claimHandlerName="";


    @Then("^I should be able to add new claim competency with the below data$")
    public void iShouldBeAbleToAddNewClaimCompetencyWithTheBelowData(List<List<String>> parameter) {
        competencyOperationsObj.enterClaimCompetencyDetails(parameter);
    }

    @And("^I should be able to verify the stored competency$")
    public void iShouldBeAbleToVerifyTheStoredCompetency(List<List<String>> parameter) {
        competencyOperationsObj.validateCreatedCompetency(parameter);
    }

    @And("^I should allow to create a new user$")
    public void iShouldAllowToCreateANewUser(List<List<String>> parameters) {
        competencyOperationsObj.createNewUser(parameters);
    }

    @Then("^I should be able to amend the claim competency '(.+)' with below data and Validate$")
    public void iShouldBeAbleToAmendTheClaimCompetencyLevelAutomationWithBelowData(String competencyLevel, List<List<String>> parameters) {
        competencyOperationsObj.amendCompetency(competencyLevel, parameters);
    }

    @Then("^I should be able to allocate the competency$")
    public void iShouldBeAbleToAllocateTheCompetency(List<List<String>> parameters) {
        competencyOperationsObj.allocateCompetency(parameters);
    }

    @And("^'(.+)' the new user '(.+)' is having the below values for the following fields$")
    public void validateTheNewUserIsHavingTheDefaultValuesForTheFollwoingFields(String action, String user, List<List<String>> parameters) {
        competencyOperationsObj.validateNewUserDefaultFields(action, user, parameters);
    }

    @And("^I should allow to add a newClaimHandlerTeam with the following details$")
    public void iShouldAllowToAddANewClaimHandlerTeamWithTheFollowingDetails(List<List<String>> parameters) {
        competencyOperationsObj.addNewClaimHandlerTeam(parameters);
    }

    @And("^I should allow to do '(.+)' the competency level '(.+)'$")
    public void iShouldAllowToDoArchiveTheCompetencyLevelForTheUser(String action, String competency) {
        competencyOperationsObj.archiveUser(action, competency);
    }

    @And("^I should allow to change the user '(.+)' values as listed below$")
    public void iShouldAllowToChangeTheUserValuesAsListedBelow(String user, List<List<String>> parameters) {
        competencyOperationsObj.changeUserStatus(user, parameters);
    }

    @And("^I should not allow to do '(.+)' the competency level '(.+)'$")
    public void iShouldNotAllowToDoArchivedTheCompetencyLevelForTheUserTestFive(String action, String user, List<List<String>> parameters) {
        competencyOperationsObj.validateNotAllowedArchived(action, user, parameters);
    }

    @Then("^I should be able to view the changes done in competency '(.+)'$")
    public void iShouldBeAbleToViewTheChangesDoneInCompetencyLevelAutomation(String competencyLevel, List<List<String>> parameters) {
        competencyOperationsObj.validateCompetencyLevelChanges(competencyLevel, parameters);
    }

    @And("^I should be able to delete the '(.+)' for '(.+)'$")
    public void iShouldBeAbleToDeleteTheCompetencyLevelForLevelAutomation(String deleteIn, String competencyLevel) {
        competencyOperationsObj.deleteCompetency(deleteIn, competencyLevel);
    }

    @And("^I should be able to verify the competency allocated$")
    public void iShouldBeAbleToVerifyTheCompetencyAllocated(List<List<String>> parameters) {
        competencyOperationsObj.validateCompetencyAllocated(parameters);

    }

    @And("^I should allow to view the hierarchy of the Team as listed below$")
    public void iShouldAllowToViewTheHierarchyOfTheTeamAsListedBelow(List<List<String>> parameters) {
        competencyOperationsObj.validateTeamDetails(parameters);
    }

    @And("^I should be able to edit the team '(.+)' to '(.+)' user '(.+)'$")
    public void iShouldBeAbleToEditTheTeamTTAutomationToRemoveUserRandom(String teamName, String action, String claimHandler) {
        competencyOperationsObj.editTeamDetails(teamName, action, claimHandler);
    }

    @And("^I should be able to edit the allocated competency '(.+)' to '(.+)' competency '(.+)'$")
    public void iShouldBeAbleToEditTheAllocatedCompetencyTTAutomationToRemoveCompetencyLevelAutomation(String teamName, String action, String competencyLvel) {
        competencyOperationsObj.editAllocatedCompetency(teamName, action, competencyLvel);
    }

    @Then("^I should be able to view the changes done in allocation '(.+)'$")
    public void iShouldBeAbleToViewTheChangesDoneInAllocationTTAutomation(String allocation, List<List<String>> parameters) {
        competencyOperationsObj.allocateCompetencyHistory(allocation, parameters);
    }

    @And("^I should be able to view the claim handlers competency level$")
    public void iShouldBeAbleToViewTheClaimHandlersCompetencyLevel() {
        // Assert.assertTrue(leftNavPanePageObj.claimCompetencyTab());
        competencyOperationsObj.verifyCompetencyTabDisplayed();
    }

    @And("^I should not be able to view the claim handlers competency level$")
    public void iShouldNotBeAbleToViewTheClaimHandlersCompetencyLevel() {
        competencyOperationsObj.verifyCompetencyTabNotDisplayed();
    }

    @And("^I should be able to delete the '(.+)' of '(.+)'$")
    public void iShouldBeAbleToDeleteTheAllocatedCompetencyOfTTAutomation(String competency, String teamName) {
        competencyOperationsObj.deletingCompetency(competency, teamName);
    }

    @Then("^I should allow to change all the Claim Handler Team as '(.+)'$")
    public void iShouldAllowToChangeAllTheClaimHandlerTeamAsInactive(String status) {
       competencyOperationsObj.changeClaimHandlerTeamStatus(status);
    }

    @And("^I should allow to make the '(.+)' Team as '(.+)'$")
    public void iShouldAllowToMakeThePlatinumClaimHandlerTeamTeamAsActive(String team, String status) {
       competencyOperationsObj.makeTeamAsActive(team,status);
    }

    @And("^Validate claim Handler '(.+)' allocated '(.+)'$")
    public void validateClaimHandlerTestHandlerUserAllocatedWithPoints(String user,String action) {
        competencyOperationsObj.validateClaimHandlerisAllocatedWithPoints(user,action);
    }

    @And("^I should be able to verify the claim handler assigned as '(.+)'$")
    public void iShouldBeAbleToVerifyTheClaimHandlerAssignedAsQwhNClaimHandler(String claimHandler) {
        claimsOperationsObj.validateClaimHandler(claimHandler);
    }

    @Then("^I should be able to amend '(.+)' claim competency with the below data$")
    public void iShouldBeAbleToAmendWorkLoadClaimCompetencyWithTheBelowData(String competency, List<List<String>> parameters) throws Throwable {
        competencyOperationsObj.amendClaimCompetencyDetails(competency,parameters);
    }

    @And("^I should be able to unallocated the competency '(.+)' from the Team '(.+)'$")
    public void iShouldBeAbleToUnallocatedTheCompetencyWorkLoadFromTheTeamWorkLoadTeam(String competency, String team) throws Throwable {
        competencyOperationsObj.unallocateCompetencyFromTeam(competency,team) ;
    }

    @And("^I should be able to remove the team member '(.+)' from the Team '(.+)'$")
    public void iShouldBeAbleToRemoveTheTeamMemberWorkloadHandlerFromTheTeamWorkLoadTeam(String teamMember, String team) throws Throwable {
      competencyOperationsObj.removeTeamMemberFromTeam(teamMember,team);
    }

    @And("^claim should be added in the queue for manual allocation with details '(.+)'$")
    public void claimShouldBeAddedInTheQueueForManualAllocation(String details) {
        competencyOperationsObj.identifyUnallocatedClaim(details);
    }

    @And("^I should be able to find the '(.+)' compentency is added$")
    public void iShouldBeAbleToFindTheLevelAutomationCompentencyIsAdded(String competencyLevel) {
        competencyOperationsObj.competencyLevelNamefiltering(competencyLevel);
    }

    @And("^I should be able to mark the competency level '(.+)' status as '(.+)'$")
    public void iShouldBeAbleToMarkTheCompetencyLevelAutomationStatusAsCreated(String competency,String comptencyStatus) throws Throwable {
        competencyOperationsObj.changeCompetencyStatus(competency,comptencyStatus);
    }

    @And("^I should allow to delete the competency level of '(.+)'$")
    public void iShouldAllowToDeleteTheCompetencyLevelOfAutomation(String competency) throws Throwable {
       competencyOperationsObj.deleteCompetency(competency);
    }
    @And("^I should allow to change the user '(.+)' values as listed below by clicking more details$")
    public void iShouldAllowToChangeThestatus(String user, List<List<String>> parameters) {
        competencyOperationsObj.changeUserStatusByClickOnMoreDetails(user, parameters);
    }

    @And("^I should allow to navigate to '(.+)'$")
    public void iShouldAllowToNavigateToClaimCompetency(String tab) throws Throwable {
        competencyOperationsObj.navigateToClaimCompetency(tab);
    }

    @And("^I should check the status of claim handler$")
    public void iShouldCheckTheStatusOfClaimHandler(List<List<String>> parameters) throws Throwable {
        claimHandlerName= claimsOperationsObj.retrieveClaimHandlerName();
        System.out.println("******"+claimHandlerName);
        competencyOperationsObj.checkUserStatus(claimHandlerName, parameters );
    }

    @And("^I should navigate to ManageUsers tab$")
    public void iShouldNavigateToManageUsersTab(List<List<String>> parameters) throws Throwable {
        competencyOperationsObj.checkUserStatus(claimHandlerName,parameters);
    }
    @And("^I should navigate to claim competency and verify Maximum Number Of Claims field is editable$")
    public void iShouldNavigateToClaimCompetencyAndVerifyMaximumNumberOfClaimsFieldIsEditable() throws Throwable {
        competencyOperationsObj.validateMaximumNumberOfClaimantsField();
    }
    @Then("^I should be able to edit new claim competency '(.+)' with the below data$")
    public void iShouldBeAbleToEditNewClaimCompetencyWithTheBelowData(String competency, List<List<String>> parameters) throws Throwable {
        competencyOperationsObj.editNewCompetency(competency,parameters);
    }

    @Then("^validate the maximum points is greater than the allocated points$")
    public void validateTheAllocatedPointsIsGreaterThanTheMaxPoints() throws Throwable {
        claimHandlerName= claimsOperationsObj.retrieveClaimHandlerName();
        competencyOperationsObj.validateAllocatePoints(claimHandlerName);
    }

    @And("^I should be able to validate the stored competency '(.+)' with below data$")
    public void iShouldBeAbleToValidateTheStoredCompetencyTIMComplexityWithBelowData(String competencyLevel, List<List<String>> parameters) {
        competencyOperationsObj.validateExistingCompetency(competencyLevel, parameters);
    }

    @And("^I should be able to validate the stored allocate competency '(.+)' with below data$")
    public void iShouldBeAbleToValidateTheStoredAllocateCompetencyTIMComplexityWithBelowData(String competencyLevel, List<List<String>> parameters) {
        competencyOperationsObj.validateExistingAllocateCompetency(competencyLevel, parameters);
    }

    @And("^I should be able to verify the stored manage users '(.+)' with below data$")
    public void iShouldBeAbleToValidateTheStoredManageUsersTIMComplexityWithBelowData(String competencyLevel, List<List<String>> parameters) {
        competencyOperationsObj.validateExistingManageUsersCompetency(competencyLevel, parameters);

    }
}
