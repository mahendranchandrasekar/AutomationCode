package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.CustomerPortalHomePage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.CustomerPortalHomeOperations;
import co.uk.directlinegroup.tt.utils.common.Commands;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;

import java.util.List;

/**
 * Created by 588800 on 9/26/2017.
 */
public class CustomerPortalHome extends BaseStepDef {

    private CustomerPortalHomeOperations customerPortalHomeOperationsObj = new CustomerPortalHomeOperations();
    private CustomerPortalHomePage customerPortalHomePageObj = new CustomerPortalHomePage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private Commands commandsObj = new Commands();

    @And("^System should verify the account type as '(.+)'$")
    public void systemShouldVerifyTheAccountType(String type) throws Throwable {
        customerPortalHomeOperationsObj.verifyAccountType(type);
    }

    @And("^I must be landed into home page$")
    public void iMustBeLandedIntoHomePage() throws Throwable {
        //customerPortalHomeOperationsObj.navigateToHomePage();
        Assert.assertTrue(customerPortalHomePageObj.msgWelcome().isDisplayed());
    }

    @When("^I select '(.+)' icon displayed in home page$")
    public void iSelectMyDocumentsIconDisplayedInHomePage(String icon) throws Throwable {
        customerPortalHomeOperationsObj.clickOnIcon(icon);
    }

    @When("^I select '(.+)' icon present in the footer of home page$")
    public void iSelectFAQIconPresentInTheFooterOfHomePage(String parameter) throws Throwable {
        customerPortalHomeOperationsObj.clickOnFAQ();
    }

    @When("^I select '(.+)' icon$")
    public void navigateToMainIcons(String parameter) throws Throwable {
        customerPortalHomeOperationsObj.navigateToMainMenu(parameter);
    }

    @And("^On successful validation, system should presents the Home page$")
    public void onSuccessfulValidationSystemShouldPresentsTheHomePage() throws Throwable {
        customerPortalHomeOperationsObj.navigateToHomePage();
        Assert.assertTrue(customerPortalHomePageObj.msgWelcome().isDisplayed());
    }

    @Then("^system should prompts '(.+)' to the customer$")
    public void systemShouldPromptsNotificationToTheCustomer(String notification) throws Throwable {
        customerPortalHomeOperationsObj.clickOnRenewalNotification(notification);
    }

    @And("^system should prompt the '(.+)' notification$")
    public void verifyTheSystemDisplaysAnyNotifications(String notification) throws Throwable {
        customerPortalHomeOperationsObj.validateAgeExtNotification();;
    }

    @When("^I return to home page$")
    public void iShouldReturnToHomePage() throws Throwable {
        customerPortalHomeOperationsObj.NavigateToHome();
    }

    @And("^System should remove the '(.+)' notification after accepts the renewal$")
    public void systemShouldRemoveTheRenewalNotificationAfterAcceptsTheRenewal(String notification) throws Throwable {
        Assert.assertTrue(!nextEventPageObj.elementDisplayed(By.xpath(customerPortalHomePageObj.lblViewRenewal())));
    }

    @Then("^system notifies the customer as account has been locked$")
    public void systemNotifiesTheCustomerAsAccountHasBeenLocked(List<String> parameter) throws Throwable {
        customerPortalHomeOperationsObj.verifyAccountLocked(parameter);
    }

    @And("^On successful validation, system should presents account selection screen$")
    public void onSuccessfulValidationSystemShouldPresentsAccountSelectionScreen() throws Throwable {
        customerPortalHomeOperationsObj.validateAccountSelectionScreen();
    }

    @Then("^Customer should be able to select the account as '(.+)' and should capture the following details$")
    public void customerShouldBeAbleToSelectTheAccountAsSilver(String accountType,List<String> parameters) throws Throwable {
        customerPortalHomeOperationsObj.accountSelection(accountType);
        customerPortalHomeOperationsObj.validateAccountDetails(accountType,parameters);
    }

    @And("^system should present the home page with selected account details$")
    public void systemShouldPresentTheHomePageWithSelectedAccountDetails() throws Throwable {
        Assert.assertTrue(customerPortalHomePageObj.msgWelcome().isDisplayed());
        customerPortalHomeOperationsObj.validateSelectedAccountDetails();
    }

    @And("^system should unlock the account and presents the home page$")
    public void systemShouldUnlockTheAccountAndPresentsTheHomePage() throws Throwable {
        Assert.assertTrue(customerPortalHomePageObj.msgWelcome().isDisplayed());
    }

    @And("^I should be able to verify the tabs '(.+)' is not displayed$")
    public void iShouldBeAbleToVerifyTheTabsMyPolicyMyClaimsIsNotDisplayed(String tabs) {
       customerPortalHomeOperationsObj.verifyTabsAreNotDisplayed(tabs);
    }

    @And("^System should remove the '(.+)' notification viewed from home page$")
    public void systemShouldRemoveTheAgeExtensionNotificationViewedFromHomePage(String notification) throws Throwable {
        Assert.assertTrue(!commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(customerPortalHomePageObj.btnNotificationRemoval())));
    }

    @And("^system must display the following message on portal home page$")
    public void systemMustDisplayTheFollowingMessageOnPortalHomePage(List<List<String>> parameters) throws Throwable {
       customerPortalHomeOperationsObj.navigateToHomePage();
        customerPortalHomeOperationsObj.validateClaimNotification(parameters);
    }

    @And("^System must be able to link the notification through Open claim details$")
    public void systemMustBeAbleToLinkTheNotificationThroughOpenClaimDetails() throws Throwable {
        customerPortalHomeOperationsObj.clickOnClaimNotification();
    }

    @When("^I click on the '(.+)' notification$")
    public void iClickOnTheNotification(String notification) throws Throwable {
      customerPortalHomeOperationsObj.clickOnNotification(notification);
    }

    @And("^I verify '(.+)' notification is removed from home page$")
    public void iVerifyAdviceOfEvidenceNotificationIsRemovedFromHomePage(String notification) throws Throwable {
        customerPortalHomeOperationsObj.navigateToHomePage();
        Assert.assertTrue(!nextEventPageObj.elementDisplayed(By.xpath(customerPortalHomePageObj.lblNotifications(notification))));
    }

    @And("^system should presents home page$")
    public void systemShouldPresentsHomePage() throws Throwable {
        Assert.assertTrue(customerPortalHomePageObj.msgWelcome().isDisplayed());
    }
}
