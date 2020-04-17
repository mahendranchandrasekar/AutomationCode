package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.AccountInformationPage;
import co.uk.directlinegroup.tt.pages.CustomerDetailsFieldPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.pages.PolicyDataFieldsPage;
import co.uk.directlinegroup.tt.utils.CommPrefOperations;
import co.uk.directlinegroup.tt.utils.PerformSearch;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class CommPref extends BaseStepDef {

    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private co.uk.directlinegroup.tt.utils.Navigation navigationObj = new co.uk.directlinegroup.tt.utils.Navigation();
    private CustomerDetailsFieldPage customerDetailsFieldPageObj = new CustomerDetailsFieldPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private PerformSearch performSearchObj = new PerformSearch();
    private AccountInformationPage accountInformationPageObj = new AccountInformationPage();
    private CommPrefOperations commPrefOperationsObj = new CommPrefOperations();

    @And("^I remove e-Mail address for the customer$")
    public void iRemoveEMailAddressForTheCustomer() throws Throwable {
        nextEventPageObj.loadingPage();
        performSearchObj.retreiveFirstClientRecord();
        nextEventPageObj.switchToLastOpenWindow();
        policyDataFieldsPageObj.emailId().clear();
    }

    @When("^I navigate to Comms Preference$")
    public void iNavigateToCommsPreference() throws Throwable {
        if (!policyDataFieldsPageObj.moreDetailsDisplayed()) {
            nextEventPageObj.loadingPage();
            performSearchObj.retreiveFirstClientRecord();
            nextEventPageObj.switchToLastOpenWindow();
        }
        navigationObj.navigateToCustomerCommsPref();
    }

    @Then("^I 'should be' able to see the following comms peferences to be selected$")
    public void iShouldBeAbleToSeeTheFollowingCommsPeferencesToBeSelected(List<String> lstCommPrefInputs) throws Throwable {
        for (int iCommPref = 0; iCommPref < lstCommPrefInputs.size(); iCommPref++) {
            switch (lstCommPrefInputs.get(iCommPref).toLowerCase()) {
                case "phone":
                    Assert.assertTrue(customerDetailsFieldPageObj.commPrefPhone().isDisplayed());
                    Assert.assertTrue(customerDetailsFieldPageObj.commPrefPhoneLabel().isDisplayed());
                    Assert.assertTrue(customerDetailsFieldPageObj.commPrefPhoneLabel().getText().equalsIgnoreCase("Phone"));
                    break;
                case "email":
                    Assert.assertTrue(customerDetailsFieldPageObj.commPrefEMail().isDisplayed());
                    Assert.assertTrue(customerDetailsFieldPageObj.commPrefEMailLabel().isDisplayed());
                    Assert.assertTrue(customerDetailsFieldPageObj.commPrefEMailLabel().getText().equalsIgnoreCase("Email"));
                    break;
                case "letter":
                    Assert.assertTrue(customerDetailsFieldPageObj.commPrefLetter().isDisplayed());
                    Assert.assertTrue(customerDetailsFieldPageObj.commPrefLetterLabel().isDisplayed());
                    Assert.assertTrue(customerDetailsFieldPageObj.commPrefLetterLabel().getText().equalsIgnoreCase("letter"));
                    break;
                case "sms":
                    Assert.assertTrue(customerDetailsFieldPageObj.commPrefSMS().isDisplayed());
                    Assert.assertTrue(customerDetailsFieldPageObj.commPrefSMSLabel().isDisplayed());
                    Assert.assertTrue(customerDetailsFieldPageObj.commPrefSMSLabel().getText().equalsIgnoreCase("sms"));
                    break;
            }
        }
    }

    @And("^I 'should be' able to see the following document preferences to be selected$")
    public void iShouldBeAbleToSeeTheFollowingDocumentPreferencesToBeSelected(List<String> lstDocPrefInputs) throws Throwable {
        for (int iCommPref = 0; iCommPref < lstDocPrefInputs.size(); iCommPref++) {
            switch (lstDocPrefInputs.get(iCommPref).toLowerCase()) {
                case "electronic":
                    break;
                case "paper":
                    break;
                case "braille":
                    Assert.assertTrue(customerDetailsFieldPageObj.docPrefBraille().isDisplayed());
                    Assert.assertTrue(customerDetailsFieldPageObj.docPrefBrailleLabel().isDisplayed());
                    Assert.assertTrue(customerDetailsFieldPageObj.docPrefBrailleLabel().getText().equalsIgnoreCase("Braille"));
                    break;
                case "audio":
                    Assert.assertTrue(customerDetailsFieldPageObj.docPrefAudio().isDisplayed());
                    Assert.assertTrue(customerDetailsFieldPageObj.docPrefAudioLabel().isDisplayed());
                    Assert.assertTrue(customerDetailsFieldPageObj.docPrefAudioLabel().getText().equalsIgnoreCase("audio"));
                    break;
                case "large print":
                    Assert.assertTrue(customerDetailsFieldPageObj.docPrefLarge().isDisplayed());
                    Assert.assertTrue(customerDetailsFieldPageObj.docPrefLargeLabel().isDisplayed());
                    Assert.assertTrue(customerDetailsFieldPageObj.docPrefLargeLabel().getText().equalsIgnoreCase("Large"));
                    break;
            }
        }
    }

    @When("^I navigate away from '(.+)' screen$")
    public void iNavigateAwayFromCommsPrefScreen(String strScreen) throws Throwable {
        nextEventPageObj.btnCloseWindow().click();
    }

    @Then("^I should be able to see the default '(.+)' selected is '(.+)'$")
    public void iShouldBeAbleToSeeTheDefaultCommsPrefSelectedIsEMail(String strPref, String strPrefOption) throws Throwable {
        switch (strPref.toLowerCase()) {
            case "comms pref":
                Assert.assertTrue(customerDetailsFieldPageObj.commPrefEMailAcknowledge().getAttribute("value").equalsIgnoreCase("true"));
                break;
            case "docs pref":
                Assert.assertTrue(customerDetailsFieldPageObj.commPrefEMailAcknowledge().getAttribute("value").equalsIgnoreCase("true"));
                break;
        }
    }

    @And("^I should be able to update communication preference$")
    public void iShouldBeAbleToUpdateCommunicationPreference(List<List<String>> commpref) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        navigationObj.navigateToCustomerCommsPref();
        commPrefOperationsObj.communicationPreference(commpref);
    }

    @And("^I should be able to select Comm Preference as '(.+)' and save it$")
    public void iShouldBeAbleToSelectCommPreferenceAsEmailLetterSMSAndSaveIt(String strCommPref) throws Throwable {
        String[] strCommPrefArray = strCommPref.split("#");
        if (customerDetailsFieldPageObj.commPrefPhoneAcknowledge().getAttribute("value").equalsIgnoreCase("true")) {
            customerDetailsFieldPageObj.commPrefPhone().click();
        }
        if (customerDetailsFieldPageObj.commPrefEMailAcknowledge().getAttribute("value").equalsIgnoreCase("true")) {
            customerDetailsFieldPageObj.commPrefEMail().click();
        }
        if (customerDetailsFieldPageObj.commPrefLetterAcknowledge().getAttribute("value").equalsIgnoreCase("true")) {
            customerDetailsFieldPageObj.commPrefLetter().click();
        }
        if (customerDetailsFieldPageObj.commPrefSMSAcknowledge().getAttribute("value").equalsIgnoreCase("true")) {
            customerDetailsFieldPageObj.commPrefSMS().click();
        }
        for (int iCommPref = 0; iCommPref < strCommPrefArray.length; iCommPref++) {
            switch (strCommPrefArray[iCommPref].toLowerCase()) {
                case "phone":
                    System.out.println("com-------------phone------------------"+strCommPrefArray[iCommPref].toLowerCase());
                    customerDetailsFieldPageObj.commPrefPhone().click();
                    break;
                case "email":
                    customerDetailsFieldPageObj.commPrefEMail().click();
                    break;
                case "letter":
                    customerDetailsFieldPageObj.commPrefLetter().click();
                    break;
                case "sms":
                    customerDetailsFieldPageObj.commPrefSMS().click();
                    break;
            }
        }
        customerDetailsFieldPageObj.saveAndCloseButton().click();
    }

    @Then("^I should be able to verify the preferred contact method is highlighted as '(.+)' and document preferences as '(.+)'$")
    public void iShouldBeAbleToVerifyThePreferredContactMethodIsHighlightedAndDocumentPreferences(String commPreference, String docPreference) throws Throwable {
        Assert.assertTrue(accountInformationPageObj.comms().getText().equalsIgnoreCase(commPreference));
        Assert.assertTrue(accountInformationPageObj.document().getText().equalsIgnoreCase(docPreference));
    }
}
