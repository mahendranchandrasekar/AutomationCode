package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.CustomerPortalMyPolicyPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.CustomerPortalMyPolicyOperations;
import co.uk.directlinegroup.tt.utils.TTAPIOperations;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;

import java.util.List;

/**
 * Created by 588800 on 10/3/2017.
 */
public class CustomerPortalMyPolicy extends BaseStepDef {

    private CustomerPortalMyPolicyOperations customerPortalMyPolicyOperationsObj = new CustomerPortalMyPolicyOperations();
    private CustomerPortalMyPolicyPage customerPortalMyPolicyPageObj = new CustomerPortalMyPolicyPage();
    private NextEventPage nextEventPageObj = new NextEventPage();

    private TTAPIOperations ttapiOperationsObj = new TTAPIOperations();

    @Then("^System presents latest documents in '(.+)' as follows and can be downloaded$")
    public void systemPresentsLatestDocumentsInMyDocumentsAsFollows(String icon, List<List<String>> parameters) throws Throwable {
        System.out.println("Validate available document ....");
        customerPortalMyPolicyOperationsObj.validateDocuments(parameters);
    }

    @And("^I must be able to download the cover letter in PDF format$")
    public void iMustBeAbleToDownloadTheCoverLetterInPDFFormat() throws Throwable {
        customerPortalMyPolicyOperationsObj.validateCoverLetter();
    }

    @Then("^System presents the personal details of account holder and I verify the details$")
    public void systemPresentsThePersonalDetailsOfAccountHolderAndInsuredPersonsAddedInEditableFormatAndIVerifyTheDetails(List<List<String>> parameters) throws Throwable {
        customerPortalMyPolicyOperationsObj.validatePersonalDetails(parameters);
    }

    @When("^I select to Edit and amend the details as follows$")
    public void iSelectToEditAndAmendTheDetailsAsFollows(List<List<String>> parameters) throws Throwable {
        customerPortalMyPolicyOperationsObj.updatePersonalDetails(parameters);
    }

    @Then("^System must display the following message$")
    public void systemMustDisplayTheFollowingMessage(List<String> parameter) throws Throwable {
        customerPortalMyPolicyOperationsObj.customerNotification(parameter);
    }

    @And("^I select to add '(.+)'$")
    public void iSelectToAddSpouse(String person, List<List<String>> parameters) throws Throwable {
        customerPortalMyPolicyOperationsObj.addPerson(person, parameters);
    }

    @Then("^System must not present any option to add dependant child/spouse for a silver account$")
    public void systemMustNotPresentAnyOptionToAddDependantChildSpouseForASilverAccount() throws Throwable {
        Assert.assertTrue(!(nextEventPageObj.elementDisplayed(By.xpath(customerPortalMyPolicyPageObj.addPersonOption()))));
    }

    @And("^system should allows to amend the communication address$")
    public void systemShouldAllowsToAmendTheCommunicationAddress(List<List<String>> parameters) throws Throwable {
        customerPortalMyPolicyOperationsObj.commPrefDetails(parameters);
    }

    @And("^I click '(.+)' icon$")
    public void iClickStringIcon(String icon) throws Throwable {
        customerPortalMyPolicyOperationsObj.clickOnIcon(icon);
    }

    @When("^I click on '(.+)' icon to add a family member$")
    public void iClickOnMyDetailsIconToAddAFamilyMember(String icon) throws Throwable {
        customerPortalMyPolicyOperationsObj.clickOnIcon(icon);
    }

    @And("^System should display the address of the customer$")
    public void systemShouldDisplayTheAddressOfTheCustomer() throws Throwable {
        customerPortalMyPolicyOperationsObj.verifyAddressInPolicyPage();
    }

    @Then("^system should prompt the customer to update personal details$")
    public void systemShouldPromptTheCustomerToUpdatePersonalDetails(List<String> parameters) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        customerPortalMyPolicyOperationsObj.validateAgedLogon(parameters);
    }

    @And("^customer should able to update personal details$")
    public void customerShouldAbleToUpdatePersonalDetails(List<List<String>> parameters) throws Throwable {
        customerPortalMyPolicyOperationsObj.updatePersonalDetails(parameters);
    }

    @And("^I should be able to retrieve the claim in AQ$")
    public void iShouldBeAbleToRetrieveTheClaimInAQ() throws Throwable {
        ttapiOperationsObj.retrieveCreatedClaim();
    }
}
