package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.CustomerPortalHomePage;
import co.uk.directlinegroup.tt.pages.CustomerPortalMyClaimsPage;
import co.uk.directlinegroup.tt.pages.CustomerPortalSignInPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.*;
import co.uk.directlinegroup.tt.utils.common.ConfigureEventsOperations;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

/**
 * Created by 588800 on 10/4/2017.
 */
public class Digtial extends BaseStepDef {


    private DigitalOperations digitalOperationsObj = new DigitalOperations();

    private NextEventPage nextEventPageObj = new NextEventPage();
    private ConfigureEventsOperations configureEventsOperationsObj = new ConfigureEventsOperations();
    private CustomerPortalHomeOperations customerPortalHomeOperationsObj = new CustomerPortalHomeOperations();
    private CustomerPortalHomePage customerPortalHomePageObj = new CustomerPortalHomePage();
    private QuoteAndBuyOperations quoteAndBuyOperationsObj = new QuoteAndBuyOperations();
    private CommPrefOperations commPrefOperationsObj = new CommPrefOperations();
    private co.uk.directlinegroup.tt.utils.Navigation navigationObj = new co.uk.directlinegroup.tt.utils.Navigation();
    private CustomerPortalSignInPage customerPortalSignInPageObj = new CustomerPortalSignInPage();
    private CustomerPortalRegistrationOperations customerPortalRegistrationOperationsObj = new CustomerPortalRegistrationOperations();
    private CustomerPortalMyPolicyOperations customerPortalMyPolicyOperationsObj = new CustomerPortalMyPolicyOperations();
    private CustomerPortalMyClaimsOperations customerPortalMyClaimsOperationsObj = new CustomerPortalMyClaimsOperations();
    private CustomerPortalMyClaimsPage customerPortalMyClaimsPageObj = new CustomerPortalMyClaimsPage();

    @Given("^I have setup a new digital '(.+)' as '(.+)'$")
    public void iHaveSetupADigitalCustomerAsCallCenterAgent(String customer, String user, List<List<String>> parameters) throws Throwable {

        digitalOperationsObj.loginAQ(user);
        digitalOperationsObj.createCustomerInAQ(customer, parameters);
        quoteAndBuyOperationsObj.retrieveRandomCustomerName();
        customerPortalRegistrationOperationsObj.launchRegistrationPageWithoutCaptcha();
        digitalOperationsObj.setUpCustomer(parameters);

    }

    @Then("^I should navigate to digital with portal registration$")
    public void iShouldNavigateToDigitalWithPortalRegistration(List<List<String>> parameters){
        quoteAndBuyOperationsObj.retrieveRandomCustomerName();
        customerPortalRegistrationOperationsObj.launchRegistrationPageWithoutCaptcha();
        digitalOperationsObj.setUpCustomer(parameters);
        customerPortalMyPolicyOperationsObj.navigateToHomePage();
    }


    @Then("^create a quote '(.+)'$")
    public void createAQuoteInDigital(String strQuoteType, List<List<String>> lstInputParameters) throws Throwable {
        digitalOperationsObj.navigateToPeopleScreen();
        digitalOperationsObj.createQuote(strQuoteType, lstInputParameters);

    }

    @Given("^I should create a new packaged bank account '(.+)' as '(.+)'$")
    public void iHaveCreatedANewPackagedBankAccountCustomerAsCallCenterAgent(String customer, String user, List<List<String>> parameters) throws Throwable {
        digitalOperationsObj.loginAQ(user);
        digitalOperationsObj.createCustomerInAQ(customer, parameters);
        quoteAndBuyOperationsObj.retrieveRandomCustomerName();
    }

    @And("^verify mail should sent to customer with application login url$")
    public void sendsPortalWelcomeEmailWithCustomerPortalLoginURL(List<List<String>> parameters) throws Throwable {
        digitalOperationsObj.welcomeMail(parameters);
    }


    @When("^click on the URL, system should presents the login screen$")
    public void clickTheURLOnPortalWelcomeEmailSystemShouldPresentsTheLoginScreen() throws Throwable {
        configureEventsOperationsObj.launchRegistrationURLFromWelcomeMail();
        Assert.assertTrue(customerPortalSignInPageObj.lblSignIn().isDisplayed());
    }

    @And("^I should be able to enter the Registration details$")
    public void iShouldBeAbleToEnterTheFollowingRegistrationDetails(List<List<String>> parameters) throws Throwable {
        digitalOperationsObj.setUpCustomer(parameters);
    }

    @And("^I should be able to fill my details$")
    public void iShouldBeAbleToFillMyDetails(List<List<String>> parameters) {
        digitalOperationsObj.setUpCustomer(parameters);
    }

    @And("^I should be able to fill details for ProspectUser$")
    public void iShouldBeAbleToFillDetailsForProspectUser(List<List<String>> parameter) {
        digitalOperationsObj.enterProspectDetails(parameter);
    }

    @And("^verify the added joint account holders in customer portal$")
    public void verifyTheAddedJointAccountHoldersInCustomerPortal(List<List<String>> parameters) throws Throwable {
      /*  digitalOperationsObj.welcomeMail(parameters);
        customerPortalRegistrationOperationsObj.clickOnRegistration();*/
        customerPortalRegistrationOperationsObj.launchRegistrationPageWithoutCaptcha();
        digitalOperationsObj.setUpCustomer(parameters);
        //customerPortalMyPolicyOperationsObj.navigateToHomePage();
        customerPortalMyPolicyOperationsObj.verifyJointAccountHolder();
    }

    @Given("^create a new digital '(.+)' as '(.+)'$")
    public void createANewDigitalCustomerAsCallCenterAgent(String customer, String user, List<List<String>> parameters) throws Throwable {
        digitalOperationsObj.loginAQ(user);
        digitalOperationsObj.createCustomerInAQForClaim(customer, parameters);
        customerPortalRegistrationOperationsObj.launchRegistrationPageWithoutCaptcha();
        digitalOperationsObj.setUpCustomer(parameters);
        customerPortalMyPolicyOperationsObj.navigateToHomePage();
    }

    @Given("^create a new membership services '(.+)' as '(.+)'$")
    public void createANewMemberShipServicesCustomerAsCallCenterAgent(String customer, String user, List<List<String>> parameters) throws Throwable {
        digitalOperationsObj.loginAQ(user);
        digitalOperationsObj.createCustomerInAQForClaim(customer, parameters);
        customerPortalRegistrationOperationsObj.launchRegistrationPage();
        digitalOperationsObj.setInCustomerForServices(parameters);

    }

    @Then("^customer should be able to submit a claim$")
    public void customerShouldBeAbleToSubmitAClaim(List<List<String>> lstInputParameters) throws Throwable {

        customerPortalMyClaimsOperationsObj.navigateToClaimPage();
        customerPortalMyClaimsOperationsObj.clickOnMakeAClaim();
        customerPortalMyClaimsPageObj.emergencyMedical("No").click();
        digitalOperationsObj.creatingClaim(lstInputParameters);
        customerPortalMyClaimsOperationsObj.clickOnSubmitClaim();

    }

    @And("^customer has created a partly registered claim$")
    public void customerHasCreatedAPartlyRegisteredClaim(List<List<String>> lstInputParameters) throws Throwable {
        customerPortalMyClaimsOperationsObj.navigateToClaimPage();
        customerPortalMyClaimsOperationsObj.clickOnMakeAClaim();
        digitalOperationsObj.creatingClaim(lstInputParameters);
    }


    @Then("^I must be landed into customer portal login page$")
    public void iMustBeLandedIntoCustomerPortalLoginPage() throws Throwable {
        configureEventsOperationsObj.launchRegistrationURLFromWelcomeMail();
        Assert.assertTrue(customerPortalSignInPageObj.lblSignIn().isDisplayed());
    }


    @Then("^System will show a pop up with medical emergency question with two options - '(.+)' or '(.+)'$")
    public void systemWillShowAPopUpWithMedicalEmergencyQuestionWithTwoOptionsYesOrNoIAmInUK(String optionYes,String optionNo,List<List<String>> lstInput) throws Throwable {
        customerPortalMyClaimsOperationsObj.medicalEmergencyQuestions(optionYes,optionNo,lstInput);
    }

    @Then("^User is presented with the appropriate TMA number '(.+)' to call$")
    public void userIsPresentedWithTheAppropriateTMANumberToCall(String number,List<List<String>> lstInputs) throws Throwable {
        customerPortalHomeOperationsObj.medicalEmergencyAssitance(number,lstInputs);
    }
    @Then("^Register the main account holder API in Portal$")
    public void registerTheMainAccountHolderAPIInPortal(List<List<String>> parameters) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //quoteAndBuyOperationsObj.retrieveRandomCustomerName();
        customerPortalRegistrationOperationsObj.launchRegistrationPageWithoutCaptcha();
        digitalOperationsObj.setUpCustomer(parameters);
        //throw new PendingException();
    }

}
