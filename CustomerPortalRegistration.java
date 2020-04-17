package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.pages.CustomerPortalRegistrationPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.CustomerPortalLoginOperations;
import co.uk.directlinegroup.tt.utils.CustomerPortalMyPolicyOperations;
import co.uk.directlinegroup.tt.utils.CustomerPortalRegistrationOperations;
import co.uk.directlinegroup.tt.utils.DigitalOperations;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;

import java.util.List;

/**
 * Created by 588800 on 11/2/2017.
 */
public class CustomerPortalRegistration {

    private CustomerPortalRegistrationOperations customerPortalRegistrationOperationsObj = new CustomerPortalRegistrationOperations();
    private CustomerPortalRegistrationPage customerPortalRegistrationPageObj = new CustomerPortalRegistrationPage();
    private CustomerPortalMyPolicyOperations customerPortalMyPolicyOperationsObj = new CustomerPortalMyPolicyOperations();
    private DigitalOperations digitalOperationsObj = new DigitalOperations();
    private CustomerPortalLoginOperations customerPortalLoginOperationsObj = new CustomerPortalLoginOperations();
    private NextEventPage nextEventPageObj = new NextEventPage();

    @And("^select Register and I should navigated to Registration page$")
    public void selectRegisterAndIShouldNavigatedToRegistrationPage() throws Throwable {
        customerPortalRegistrationOperationsObj.clickOnRegistration();
        customerPortalRegistrationOperationsObj.launchRegistrationPageWithoutCaptcha();
    }

    @When("^account details matches, system should prompt customer to capture the mandatory and non-mandatory details in My policy page$")
    public void accountDetailsMatchesSystemShouldPromptCustomerToCaptureTheMandatoryAndNonMandatoryDetailsInMyPolicyPage(List<List<String>> parameters) throws Throwable {
        customerPortalLoginOperationsObj.clickOnConfirm();
        customerPortalMyPolicyOperationsObj.updatePersonalDetails(parameters);
    }


    @When("^I '(.+)' screen, Age Extension will be added with pro-rated premium$")
    public void iNavigateToBasketScreenAgeExtensionWillBeAddedWithProRatedPremium(String strQuoteType, List<List<String>> lstInputParameters) throws Throwable {
        customerPortalMyPolicyOperationsObj.clickOnAddPerson();
        digitalOperationsObj.navigateToPeopleScreen();
        digitalOperationsObj.createQuote(strQuoteType, lstInputParameters);
    }


    @And("^system should allow to enter the Registration details$")
    public void systemShouldAllowToEnterTheRegistrationDetails(List<List<String>> lstInputParameters) throws Throwable {
        customerPortalRegistrationOperationsObj.enterRegistrationDetails(lstInputParameters);
    }

    @When("^Entered account details doesn't match then allows the user to re-enter details$")
    public void enteredAccountDetailsDoesnTMatchThenAllowsTheUserToReEnterDetails(List<List<String>> parameters) throws Throwable {
        customerPortalRegistrationOperationsObj.enterRegistrationDetails(parameters);
    }

    @When("^Entered account details doesn't match then allows the user to re-enter details for more than '(.+)' times$")
    public void enteredAccountDetailsDoesnTMatchThenAllowsTheUserToReEnterDetailsForMoreThanTimes(int attempts,List<List<String>> parameters) throws Throwable {
        customerPortalRegistrationOperationsObj.reEnterCustomerRegistrationDetails(attempts,parameters);
    }

    @Then("^System should notify the customer to call customer operations$")
    public void systemShouldNotifyTheCustomerToCallCustomerOperations() throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(nextEventPageObj.elementDisplayed(nextEventPageObj.findElement(By.xpath(customerPortalRegistrationPageObj.errMsgExceedingRegAttempts()))));
        Assert.assertTrue(nextEventPageObj.elementDisplayed(nextEventPageObj.findElement(By.xpath(customerPortalRegistrationPageObj.lnkCustCare()))));

    }

    @When("^I '(.+)' screen, system should navigate to relevant screen$")
    public void iClickOnAgeExtensionScreenSystemShouldNavigateToRelavantScreen(String strQuoteType, List<List<String>> lstInputParameters) throws Throwable {
        digitalOperationsObj.clickOnAgeExtNotification();
        digitalOperationsObj.createQuote(strQuoteType, lstInputParameters);
    }

}
