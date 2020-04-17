package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.CustomerPortalSignInPage;
import co.uk.directlinegroup.tt.utils.*;
import co.uk.directlinegroup.tt.utils.common.FileOperations;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Properties;

/**
 * Created by 588800 on 10/17/2017.
 */
public class CustomerPortalLogin extends BaseStepDef {


    private CustomerPortalLoginOperations customerPortalLoginOperationsObj = new CustomerPortalLoginOperations();
    private CustomerPortalSignInPage customerPortalSignInPageObj = new CustomerPortalSignInPage();
    private User userObj = new User();
    private FileOperations fileOperationsObj = new FileOperations();
    private DigitalOperations digitalOperationsObj = new DigitalOperations();

    @Given("^I have logged into Online portal as '(.+)'$")
    public void iHaveLoggedIntoOnlinePortal(String strUser) throws Throwable {
        getDriver().get(System.getProperty("ENV"));
        List<String> lstUserDetails = userObj.getUserDetails(strUser);
        userObj.customerPortalLogin(lstUserDetails.get(1), lstUserDetails.get(2));
        Thread.sleep(3000L);
    }

    @Given("^I have logged into Digital as '(.+)'$")
    public void iHaveLoggedIntoDigital(String strUser) throws Throwable {
        customerPortalLoginOperationsObj.launchDigitalForLogin();
        List<String> lstUserDetails = userObj.getUserDetails(strUser);
        userObj.customerPortalLogin(lstUserDetails.get(1), lstUserDetails.get(2));
        Thread.sleep(3000L);
    }

    @Given("^I have logged into Aquarium as '(.+)'$")
    public void xiHaveLoggedInAstestCallCenterAgent(String validuser) throws Throwable {
        digitalOperationsObj.loginAQ(validuser);
    }

    @Given("^I should launch Online Portal application url$")
    public void iShouldLaunchOnlinePortalApplicationUrl() throws Throwable {
        customerPortalLoginOperationsObj.launchDigitalForLogin();
    }

    @When("^System should prompts customer to enter the following details$")
    public void systemShouldPromptsCustomerToEnterTheFollowingDetails(List<String> parameter) throws Throwable {
        customerPortalLoginOperationsObj.validateCredentialsFields(parameter);
    }

    @Then("^I should be able to enter the following credentials$")
    public void iShouldBeAbleToEnterTheFollowingCredentials(List<List<String>> parameter) throws Throwable {
       customerPortalLoginOperationsObj.enterCredentials(parameter);
    }

    @And("^System should validates the registered Email ID and Password$")
    public void systemShouldValidatesTheRegisteredEmailIDAndPassword() throws Throwable {
       customerPortalLoginOperationsObj.clickOnSignIn();
    }

    @Then("^Customer enters incorrect credential details$")
    public void customerEntersIncorrectCredentialDEtails(List<List<String>> parameter) throws Throwable {
        customerPortalLoginOperationsObj.enterCredentials(parameter);
    }

    @And("^On Unsuccessful validation, system notifies the customer and presents the following details$")
    public void onUnsuccessfulValidationSystemNotifiesTheCustomerAndPresentsTheFollowingDetails(List<List<String>> parameter) throws Throwable {
       customerPortalLoginOperationsObj.incorrectLogin(parameter);
    }

    @Then("^Customer enters incorrect credential detail for more than '(\\d+)' attempts$")
    public void customerEntersIncorrectCredentialDetailsForMoreThanAttempts(int attempts,List<List<String>> parameter) throws Throwable {
        customerPortalLoginOperationsObj.enterInvalidCredentials(attempts,parameter);
    }

    @And("^System should provides the following option$")
    public void systemShouldProvidesTheFollowingOption(List<List<String>> parameter) throws Throwable {
        Assert.assertTrue(customerPortalSignInPageObj.lnkForgotPwd().isDisplayed());
    }

    @When("^customer clicks on '(.+)',System should prompts to enter the email address$")
    public void customerClicksOnForgotPasswordSystemShouldPromptsToEnterTheEmailAddress(String frgtPwd,List<List<String>> parameter) throws Throwable {
        customerPortalLoginOperationsObj.navigateToForgotPwd(parameter);
    }

    @Then("^System should sends reset password link via email$")
    public void systemSendsResetPasswordLinkViaEmail() throws Throwable {
       customerPortalLoginOperationsObj.validateResetReqSent();
    }

    @And("^system should present the login page with the following details$")
    public void systemShouldPresentTheLoginPageWithTheFollowingDetails(List<List<String>> parameter) throws Throwable {
        customerPortalLoginOperationsObj.validateLoginPage(parameter);
    }

    @And("^verify entered password should satisfy the following business rules$")
    public void verifyEnteredPasswordShouldSatisfyTheFollowingBusinessRules(List<List<String>> parameter) throws Throwable {
        customerPortalLoginOperationsObj.validateIncorrectPassword();
    }

    @And("^system should generates One Time URL and sent to provided Email ID with below notification$")
    public void systemShouldGeneratesOneTimeURLAndSentToProvidedEmailIDWithBelowNotification(List<String> parameter) throws Throwable {
        customerPortalLoginOperationsObj.validateOTURLNotifications(parameter);
    }

    @When("^customer clicks on OTURL, system should prompts to enter the details$")
    public void customerClicksOnOTURLSystemShouldPromptsToEnterTheDetails(List<List<String>> parameter) throws Throwable {
        customerPortalLoginOperationsObj.enterCredentials(parameter);
    }

    @And("^system should notify the customer as '(.+)'$")
    public void systemShouldNotifyTheCustomerAsAccountIsLocked(String message) throws Throwable {
        customerPortalLoginOperationsObj.loginNotification(message);
    }

    @Then("^customer logged into online portal, system prompts to enter the following details$")
    public void customerLoggedIntoOnlinePortalSystemPromptsToEnterTheFollowingDetails(List<List<String>> parameter) throws Throwable {
        customerPortalLoginOperationsObj.clickOnLogin();
        customerPortalLoginOperationsObj.enterCredentials(parameter);
    }

    @Given("^I logged into Online portal as ProspectTraveller$")
    public void iLoggedIntoOnlinePortalAsProspectTraveller() throws Throwable {
        customerPortalLoginOperationsObj.launchDigitalForLogin();
        customerPortalLoginOperationsObj.loggedAsProspect();
    }

    @And("^I should be able to select '(.+)' account for the ProspectTraveller$")
    public void iShouldBeAbleToSelectSilverAccountForTheProspectTraveller(String account){
       customerPortalLoginOperationsObj.selectTheRespectiveAccount(account);
    }

    @When("^customer clicks on expired OTURL, system should notifies as '(.+)'$")
    public void customerClicksOnExpiredOTURLSystemShouldNotifiesAsOTURLIsOutOfDate(String url,List<List<String>> parameter) throws Throwable {
        customerPortalLoginOperationsObj.enterCredentials(parameter);
    }
    @And("^I have logged into customer portal as '(.+)'$")
    public void iHaveLoggedIntoCustomerPortalAsRecentRegisteredCustomer(String user) throws Throwable {
        customerPortalLoginOperationsObj.launchDigitalForLogin();
        customerPortalLoginOperationsObj.enterCredentialsForRecentUser(user);
    }

    @Given("^launch the digital portal$")
    public void launchTheDigitalPortal() throws Throwable {
        getDriver().get(fileOperationsObj.getApplicationURL("DigitalOfflineURL"));
    }

    @Then("^System must be able to display a customer facing page with the following message$")
    public void systemMustBeAbleToDisplayACustomerFacingPageWithTheFollowingMessage(List<String> parameter) throws Throwable {
        customerPortalLoginOperationsObj.validateSplashPage(parameter);
    }

    @Given("^I have logged into AQ as '(.+)'$")
    public void iHaveLoggedInAQ(String user) throws Throwable {
        digitalOperationsObj.loginAQ(user);
    }

    @And("^I have logged into customer portal as '(.+)' for Document testing$")
    public void iHaveLoggedIntoCustomerPortalAsRecentRegisteredCustomerForDocumentTesting(String DocUser) throws Throwable {
        customerPortalLoginOperationsObj.launchDigitalForLogin();
        customerPortalLoginOperationsObj.enterCredentialsForRecentUser(DocUser);
    }

    @And("^I have logged into Aquarium as '(.+)' for Document Testing$")
    public void iHaveLoggedIntoAquariumAsDocumentLoginForDocumentTesting(String User) throws Throwable {
        customerPortalLoginOperationsObj.launchDigitalForLogin();
        List<String> userDet = userObj.getUserDetails(User);
        String loginUserName = userDet.get(1);
        String loginPwd = userDet.get(2);
        userObj.login(loginUserName, loginPwd);
    }

    @Given("^I open Customer Portal for '(.+)' brand$")
    public void iOpenCustomerPortalForNatWestBrand(String strBrand) throws Throwable {
        customerPortalSignInPageObj.getDriver.get(fileOperationsObj.getApplicationURL("DigitalQAURL").replace("#brand#",strBrand.toLowerCase()));
        System.out.println(getDriver().getTitle());
    }

    @When("^I click on Privacy&Security Link$")
    public void iClickOnPrivacySecurityLink() throws Throwable {
        customerPortalSignInPageObj.lnkPrivacyAndSecurity().click();
    }

    @Then("^I can see privacy notices and validate the text is matching with baseline for '(.+)'$")
    public void iCanSeePrivacyNotices(String strBrand) throws Throwable {
        customerPortalLoginOperationsObj.capturePrivacyNoticesTextAndCompare(strBrand);
    }

    @And("^validate all the links in privacy notices are pointing to correct website$")
    public void validateAllTheLinksInPrivacyNoticesArePointingToCorrectWebsite() throws Throwable {
        customerPortalLoginOperationsObj.validateLinksInPrivacyNotices();
    }

    @And("^I should be able to sign out$")
    public void iShouldBeAbleToSignOut() throws Throwable {
        userObj.customerPortalSignOut();
    }

    @Given("^I should be validate the upgrade text is not displayed$")
    public void iShouldBeValidateTheUpgradeTextIsNotDisplayed() throws Throwable {
        customerPortalSignInPageObj.validateUpgradeTextNotDisplayed();
    }

    @Then("^I can able to verify website terms of use and validate the text is matching with baseline for '(.+)'$")
    public void iCanAbleToVerifyWebsiteTermsOfUse(String strBrand) throws Throwable {
        customerPortalLoginOperationsObj.captureLegalDisclaimersTextAndCompare(strBrand);
    }

    @When("^I click on Legal Link$")
    public void iClickOnLegalLink() throws Throwable {
        customerPortalSignInPageObj.linkLegal().click();
    }

    @And("^validate all the links in Legal Disclaimers are pointing to correct website$")
    public void validateAllTheLinksInLegaDisclaimersArePointingToCorrectWebsite() throws Throwable {
        customerPortalLoginOperationsObj.validateLinksInLegalDisclaimers();

    }
    @Then("^I can able to verify EDR and validate the text is matching with baseline for '(.+)'$")
    public void iCanAbleToVerifyEDR(String strBrand) throws Throwable {
        customerPortalLoginOperationsObj.captureEDRTextAndCompare(strBrand);
    }

    @And("^validate all the links in EDR are pointing to correct  website$")
    public void validateAllTheLinksInEDRArePointingToCorrectWebsite() throws Throwable {
        customerPortalLoginOperationsObj.validateLinksInEDR();
        }

}
