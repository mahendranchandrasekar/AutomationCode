package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.common.LoadTTPropertiesFiles;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;

import java.util.List;

public class ClientSearch extends BaseStepDef {

    private PerformSearch performSearchObj = new PerformSearch();
    private SearchPage searchPageObj = new SearchPage();
    private PolicySummaryPage policySummaryPageObj = new PolicySummaryPage();
    private co.uk.directlinegroup.tt.utils.Navigation navigationObj = new co.uk.directlinegroup.tt.utils.Navigation();
    private User userObj = new User();
    private Commands commandsObj = new Commands();
    private LeftNavPanePage leftNavPanePageObj = new LeftNavPanePage();
    private MyAccountPersonalOptionsPage myAccountPersonalOptionsPageObj = new MyAccountPersonalOptionsPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private Claims claimsObj = new Claims();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private SummaryView summaryViewObj = new SummaryView();
    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private DigitalOperations digitalOperationsObj = new DigitalOperations();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private TTAPIOperations ttapiOperationsObj = new TTAPIOperations();
    private IReportingPage iReportingPage=new IReportingPage();

    @Given("^I have logged in as '(.+)'$")
    public void xiHaveLoggedInAsCallCenterAgent(String validuser) throws Throwable {
        digitalOperationsObj.loginAQ(validuser);
    }

    @Given("^I have logged in as test '(.+)'$")
    public void xiHaveLoggedInAsTestCallCenterAgent(String validuser) throws Throwable {
 // %%%%%%%%========This method iClaimsOperationss used for temporary testing purpose. Once automation is completed, we will remove the step from Project========%%%%%%%%%%
//        getDriver().get("https://dlg-qa.aquarium-software.com/quotebuy/26462288/people");
        getDriver().get("https://dlg-qa.aquarium-software.com/customersleaddetails2.aspx?lid=26831795&aid=29388909");
        List<String> userDet = userObj.getUserDetails(validuser);
        String loginUserName = userDet.get(1);
        String loginPwd = userDet.get(2);
        userObj.login(loginUserName, loginPwd);


    }

    @And("^I perform a client search with Brand '(.+)' and '(.+)' '(.+)'$")
    public void iPerformAClientSearchWithBrandAnd(String brand, String searchtype, String searchvalue) throws Throwable {
        navigationObj.navigateToSearchScreen();
        performSearchObj.selectBrand(brand);
        switch (searchtype.toLowerCase()) {
            case "firstname":
            case "forename":
                performSearchObj.enterFirstName(searchvalue);
                break;
            case "lastname":
            case "surname":
                performSearchObj.enterSurname(searchvalue);
                break;
            case "claimnumber":
                performSearchObj.enterClaimNumber(searchvalue);
                break;
            case "policynumber":
                performSearchObj.enterClaimNumber(searchvalue);
                break;
            case "bankaccountnumber":
                performSearchObj.enterClaimNumber(searchvalue);
                break;
            case "dob":
                performSearchObj.enterDOB(searchvalue);
                break;
            case "riskpostcode":
            case "postcode":
                performSearchObj.enterRiskPostCode(searchvalue);
                break;
            case "email":
                performSearchObj.enterEmail(searchvalue);
                break;
            case "phonenumber":
                performSearchObj.enterPhoneNumber(searchvalue);
                break;
        }
    }

    @When("^performing a search for a client record$")
    public void performingASearchForAClientRecord() throws Throwable {
        nextEventPageObj.waitForMoreTime();
        navigationObj.navigateToSearchScreen();
        commandsObj.waitForObject(searchPageObj.standardSearch());
        Assert.assertTrue(searchPageObj.standardSearch().isDisplayed());
    }

    @Then("^It must be possible to search for the record using the following data items either independently or in conjunction$")
    public void itMustBePossibleToSearchForTheRecordUsingTheFollowingDataItemsEitherIndependentlyOrInConjunction(List<String> fields) throws Throwable {
        for (String str : fields) {
            switch (str.toLowerCase()) {
                case "brand":
                    Assert.assertTrue(searchPageObj.brand().isDisplayed());
                    break;
                case "forename":
                    Assert.assertTrue(searchPageObj.firstName().isDisplayed());
                    break;
                case "surname":
                    Assert.assertTrue(searchPageObj.surname().isDisplayed());
                    break;
                case "risk postcode":
                    Assert.assertTrue(searchPageObj.riskPostCode().isDisplayed());
                    break;
                case "dob":
                    Assert.assertTrue(searchPageObj.dob().isDisplayed());
                    break;
                case "email":
                    Assert.assertTrue(searchPageObj.email().isDisplayed());
                    break;
                case "phone number(s)":
                    Assert.assertTrue(searchPageObj.phoneNumber().isDisplayed());
                    break;
                case "policy number":
                    Assert.assertTrue(searchPageObj.policyNumber().isDisplayed());
                    break;
                case "claim number":
                    Assert.assertTrue(searchPageObj.claimNumber().isDisplayed());
                    break;
                case "bank account number":
                    Assert.assertTrue(searchPageObj.bankAccountNumber().isDisplayed());
                    break;
            }
        }
    }

    @And("^Brand is mandatory$")
    public void brandIsMandatory() throws Throwable {
        performSearchObj.enterFirstName("");
        performSearchObj.enterSurname("");
        performSearchObj.enterRiskPostCode("");
        performSearchObj.enterDOB("");
        performSearchObj.enterPhoneNumber("");
        performSearchObj.enterEmail("");
        performSearchObj.enterPhoneNumber("");
        performSearchObj.enterPolicyNumber("");
        performSearchObj.enterClaimNumber("");
        performSearchObj.enterBankAccountNumber("");
        searchPageObj.searchButton().click();
        Assert.assertTrue(searchPageObj.brandErrorMessage().isDisplayed());
        Assert.assertTrue(searchPageObj.brandErrorMessage().getText().equalsIgnoreCase("please select a brand"));
    }

    @And("^All matching records should be displayed$")
    public void allMatchingRecordsShouldBeDisplayed() throws Throwable {
        performSearchObj.selectBrand("Royal Bank of Scotland");
        searchPageObj.firstName().sendKeys("tester");
        searchPageObj.searchButton().click();
        Assert.assertTrue(searchPageObj.searchResultTable().isDisplayed());
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(searchPageObj.findElement(By.xpath(searchPageObj.searchResultXPath().replace("##SearchPage Value##", "Royal Bank of Scotland"))).isDisplayed());
    }

    @And("^Enters partially matching surname$")
    public void entersPartiallyMatchinfSurname() throws Throwable {
        performSearchObj.selectBrand("Royal Bank of Scotland");
        searchPageObj.firstName().sendKeys("tester");
        searchPageObj.firstName().sendKeys("as");
        searchPageObj.searchButton().click();
    }

    @Given("^I am on Search screen and performing search for '(.+)'$")
    public void iAmOnSearchScreenAndPerformingSearchFor(String policyholdertype) throws Throwable {
        Assert.assertTrue(searchPageObj.standardSearch().isDisplayed());
        System.out.println(policyholdertype);
    }

    @And("^I select '(.+)' from brand dropdown$")
    public void iSelectFromBrandDropdown(String brand) throws Throwable {
        performSearchObj.selectBrand(brand);
    }

    @And("^I enter '(.+)' into First Name textbox$")
    public void iEnterIntoFirstNameTextbox(String fname) throws Throwable {
        performSearchObj.enterFirstName(fname);
    }

    @And("^I enter '(.+)' into Last Name textbox$")
    public void iEnterIntoLastNameTextbox(String lname) throws Throwable {
        performSearchObj.enterSurname(lname);
    }

    @And("^I enter '(.+)' into Risk postcode textbox$")
    public void iEnterIntoRiskPostcodeTextbox(String riskpostcode) throws Throwable {
        performSearchObj.enterRiskPostCode(riskpostcode);
    }

    @And("^I enter '(.+)' into DOB textbox$")
    public void iEnterIntoDOBTextbox(String dob) throws Throwable {
        performSearchObj.enterDOB(dob);
    }

    @And("^I enter '(.+)' into Email textbox$")
    public void iEnterIntoEmailTextbox(String email) throws Throwable {
        performSearchObj.enterEmail(email);
    }

    @And("^I enter '(.+)' into PhoneNumber textbox$")
    public void iEnterIntoPhoneNumberTextbox(String phonenumber) throws Throwable {
        performSearchObj.enterPhoneNumber(phonenumber);
    }

    @And("^I enter '(.+)' into Policy Number textbox$")
    public void iEnterIntoPolicyNumberTextbox(String policynumber) throws Throwable {
        performSearchObj.enterPolicyNumber(policynumber);
    }

    @And("^I enter '(.+)' into Claim Number textbox$")
    public void iEnterIntoClaimNumberTextbox(String claimnumber) throws Throwable {
        performSearchObj.enterClaimNumber(claimnumber);
    }

    @And("^I enter '(.+)' into Bank Account Number textbox$")
    public void iEnterIntoBankAccountNumberTextbox(String bankaccountnumber) throws Throwable {
        performSearchObj.enterBankAccountNumber(bankaccountnumber);
    }

    @And("^I should be on '(.+)' screen$")
    public void iShouldBeOnScreen(String screen) throws Throwable {
        Assert.assertTrue(policySummaryPageObj.customerDetailsTab().isDisplayed());
    }

    @When("^I click on Search button$")
    public void iClickOnSearchButton() throws Throwable {
        searchPageObj.searchButton().click();
    }

    @Then("^I should be able to see '(.+)' records are displayed with following fields$")
    public void iShouldBeAbleToSeeRecordsAreDisplayedWithFollowingFields(List<String> fields, String record) throws Throwable {
        switch (record.toLowerCase()) {
            case "all matching records":
                throw new PendingException();
            case "no records":
                throw new PendingException();
        }
    }

    @Then("^I should be able to see '(.+)' when searched with following details$")
    public void iShouldBeAbleToSeeExpectedBehaviourWhenSearchedWithFollowingDetails(String strResult, List<List<String>> lstSearchCriteria) throws Throwable {
        //TODO-Sruthi Start
        //lstSearchCriteria = commandsObj.parameterMappingNew(1, lstSearchCriteria, LoadTTPropertiesFiles.POLICYDETAILS_PROP);
        lstSearchCriteria = commandsObj.singleParameterMappingProp(lstSearchCriteria, LoadTTPropertiesFiles.POLICYDETAILS_PROP);
        //TODO-Sruthi End
        performSearchObj.clientSearch(lstSearchCriteria);
    }


    @And("^I set my Personal option to '(.+)' to navigate directly for a single record$")
    public void iSetMyPersonalOptionToONToNavigateDirectlyForASingleRecord(String strOption) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPanePageObj.iMenu().click();
        leftNavPanePageObj.myAccount().click();
        leftNavPanePageObj.personalOption().click();
        myAccountPersonalOptionsPageObj.searchOptions().click();
        if (strOption.equalsIgnoreCase("on")) {
            if (myAccountPersonalOptionsPageObj.navigateDirectForSingleRecordOption().getAttribute("checked") == null) {
                myAccountPersonalOptionsPageObj.navigateDirectForSingleRecordOption().click();
                iReportingPage.btnSave().click();
            }
        }
        if (strOption.equalsIgnoreCase("off")) {
            if (myAccountPersonalOptionsPageObj.navigateDirectForSingleRecordOption().getAttribute("checked") != null) {
                myAccountPersonalOptionsPageObj.navigateDirectForSingleRecordOption().click();
                iReportingPage.btnSave().click();
            }
        }
        navigationObj.navigateToSearchScreen();
    }

    @Then("^verify the product type")
    public void verifyProductType(List<List<String>> parameters) throws Throwable {
        for (int row = 0; row < parameters.get(0).size(); row++) {
            System.out.println("Row size:" + parameters.get(0).size());
            System.out.println(parameters.get(0).get(row));
            performSearchObj.productTypeVerification(parameters.get(0).get(row));
        }
    }

    @Then("^verify general product parameters$")
    public void verifyGeneralProductParameters(List<List<String>> parameters) throws Throwable {

        performSearchObj.navigateToschemeDeatils();
        for (int row = 0; row < parameters.get(0).size(); row++) {
            System.out.println("Row size:" + parameters.get(0).size());
            performSearchObj.generalProductVerification(parameters.get(0).get(row));

        }

    }

    @Then("^Verify Brand type$")
    public void verifyBrandType() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Verify '(.+)' Type$")
    public void verifyBrandProductType(String strType, List<String> lstInput) throws Throwable {
        String strValue = "";
        boolean bFound = false;
        switch (strType.toLowerCase()) {
            case "brand":
                strValue = policySummaryPageObj.productName().getText();
                System.out.println("*************Brand Given ***********" + strValue);
                break;
            case "product":
                strValue = policySummaryPageObj.productType().getText();
                System.out.println("*************Product Given ***********" + strValue);
                break;
        }

        for (int i = 0; i < lstInput.size(); i++) {
            if (strValue.equalsIgnoreCase(lstInput.get(i))) {
                bFound = true;
                System.out.println("List Input Size:" + lstInput.size());
                break;
            }
        }
        if (!bFound) {
            System.out.println("Unable to find right match");
            System.out.println("List Input Size:" + lstInput.size());
            Assert.assertTrue(false);
        }
    }


    @And("^Validating the email receipt and validate claim$")
    public void validatingemailreceipt() {
        claimsOperationsObj.navigateToClaimViewFromPolicyView();
        Assert.assertTrue(summaryViewObj.validateAndSelectClaimFromClaimSummaryTable(claimsObj.claimID));
    }

    @When("^the client record doesn't exist create a new record$")
    public void the_client_record_doesnt_exist_create_a_new_record() throws Throwable {

        performSearchObj.createNewClientRecord();
    }

    @And("^validate all the dropdowns in the New product page should have only default value$")
    public void validate_all_the_dropdowns_in_the_New_product_page_should_have_only_default_value() throws Throwable {
        //This step definition is to validate the default values in the dropdown in the New product creation page
        performSearchObj.validateDropdownContainsDefaultValue();

    }

    @And("^I should allow to capture the following details for the account holder$")
    public void I_should_allow_to_capture_the_following_details_for_the_account_holder(List<List<String>> parameters) throws Throwable {
        //This step definition is to enter the  values in the dropdown in the New product creation page
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame()); //switch to frame
        for (int row = 1; row < parameters.size(); row++) {
            // performSearchObj.resetSearch();
            for (int column = 0; column < parameters.get(0).size(); column++) {
                performSearchObj.createClientRecord(parameters.get(0).get(column), parameters.get(row).get(column));

            }

        }

    }

    @And("^validate all the dropdowns in the Joint Account Holder Page should have only default value$")
    public void validate_all_the_dropdowns_in_the_Joint_Account_Holder_Page_should_have_only_default_value() throws Throwable {

        performSearchObj.validateJointAccountHolderDropdownContainsDefaultValue();
    }

    @And("^I should allow to add joint communication details mentioned below$")
    public void I_should_allow_to_add_joint_communication_details_mentioned_below(List<List<String>> parameters) throws Throwable {
        //This step definition is to update joint account holders communication details
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame()); //switch to frame
        for (int row = 1; row < parameters.size(); row++) {
            // performSearchObj.resetSearch();
            for (int column = 0; column < parameters.get(0).size(); column++) {
                performSearchObj.addJointHoldersCommunicationDetails(parameters.get(0).get(column), parameters.get(row).get(column));

            }

        }
    }

    @And("^I should allow to enter below postcode in the address lookup$")
    public void I_should_allow_to_enter_below_postcode_in_the_address_lookup(List<List<String>> parameters) throws Throwable {
        //This step definition is to enter postcode in the address lookup
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame()); //switch to frame
        for (int row = 1; row < parameters.size(); row++) {
            // performSearchObj.resetSearch();
            for (int column = 0; column < parameters.get(0).size(); column++) {

                performSearchObj.addressLookUp(parameters.get(0).get(column), parameters.get(row).get(column));

            }

        }
    }

    @And("^I should allow to select the address from the AddressLookUp$")
    public void I_should_allow_to_select_the_address_from_the_AddressLookUp() throws Throwable {

        performSearchObj.toSelectAddressFromAddressLookUp();
    }

    @And("^validate invalid postcode returns the error message as '(.+)'$")
    public void validate_invalid_postcode_returns_the_error_message(String errMessage) throws Throwable {
        performSearchObj.validateErrorMessage(errMessage);
    }

    @And("^I should allow to enter the address manually$")
    public void I_should_allow_to_enter_the_address_manually(List<List<String>> parameters) throws Throwable {
        //This step definition is to enter address manually
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame()); //switch to frame
        for (int row = 1; row < parameters.size(); row++) {
            // performSearchObj.resetSearch();
            for (int column = 0; column < parameters.get(0).size(); column++) {
                performSearchObj.enterAddress(parameters.get(0).get(column), parameters.get(row).get(column));

            }

        }


    }

    @And("^I should allow to add customer communication details mentioned below$")
    public void I_should_allow_to_add_customer_communication_details_mentioned_below(List<List<String>> parameters) throws Throwable {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame()); //switch to frame
        for (int row = 1; row < parameters.size(); row++) {
            // performSearchObj.resetSearch();
            for (int column = 0; column < parameters.get(0).size(); column++) {
                performSearchObj.addCustomerCommunicationDetails(parameters.get(0).get(column), parameters.get(row).get(column));

            }

        }
    }


    @And("^Validate the comm details in the Com tab$")
    public void Validate_the_comm_details_in_the_Com_tab(List<List<String>> parameters) throws Throwable {
        nextEventPageObj.switchToDefault();
        searchPageObj.moreDetails();
        searchPageObj.moreDetails().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        searchPageObj.commPreferences().isDisplayed();
        searchPageObj.commPreferences().click();
        Thread.sleep(4000L);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        // nextEventPageObj.switchToFrameById(nextEventPageObj.frame()); //switch to frame
        for (int row = 1; row < parameters.size(); row++) {
            // performSearchObj.resetSearch();
            for (int column = 0; column < parameters.get(0).size(); column++) {
                performSearchObj.validateDocumentPreferencesInCommTab(parameters.get(0).get(column), parameters.get(row).get(column));

            }

        }

    }

    @And("^Validate the Document Preferences$")
    public void Validate_the_Document_Preferences(List<List<String>> parameters) throws Throwable {
        //This step definition is to validate the document preference
        nextEventPageObj.switchToDefault();
        //nextEventPageObj.switchToFrameById(nextEventPageObj.frame()); //switch to frame
        for (int row = 1; row < parameters.size(); row++) {
            // performSearchObj.resetSearch();
            for (int column = 0; column < parameters.get(0).size(); column++) {
                performSearchObj.validateDocumentPreferences(parameters.get(0).get(column), parameters.get(row).get(column));
            }

        }
    }


    @And("^validate the customer is from non UK resident$")
    public void validateTheCustomerIsFromNonUKResident() throws Throwable {
        performSearchObj.validateNonUKResident();

    }

    @And("^Confirm customer is resident in UK$")
    public void confirmCustomerIsResidentInUK(List<List<String>> parameters) {
        performSearchObj.nonUKResident(parameters);
    }

    @And("^I should be able to retrieve the '(.+)' and verify the invoice is paid$")
    public void iShouldBeAbleToRetrieveTheMatterIdAndVerifyTheInvoiceIsPaid(String searchCriteria) {
        performSearchObj.navigateToParticularId(searchCriteria);
    }

    @And("^I should be able to retrieve the '(.+)' to update the invoice detail$")
    public void iShouldBeAbleToRetrieveTheMatterIdToUpdateTheInvoiceDetail(String searchCriteria) {
        performSearchObj.retrievingTheMatterId(searchCriteria);
    }

    @And("^I should be able to retrieve the supplier '(.+)'$")
    public void iShouldBeAbleToRetrieveTheSupplier(String supplierId) {
        performSearchObj.retrieveSupplier(supplierId);
    }

    @Then("^verify client record should exists$")
    public void verifyClientRecordShouldExists() {
        performSearchObj.validateClientRecord();
    }

   /* @Then("^system should retrieve the updated record received from affinion in Aquarium with following details$")
    public void systemShouldUpdatesTheReceivedAffinionFeedInAquarium(List<List<String>> parameters) throws Throwable {
        performSearchObj.searchAffinionProcessedCustomer(parameters);
    }
    */

    @And("^I should be able to navigate to search criteria$")
    public void iShouldBeAbleToNavigateToSearchCriteria() {
        performSearchObj.navigateToSearchCriteria();
    }

    @And("^I should be able to enter search criteria '(.+)'$")
    public void iShouldBeAbleToEnterSearchCriteria(String searchCriterias) {
        performSearchObj.searchWithMentionedCriteria(searchCriterias);
    }

    @And("^I shoule be able to verify the message '(.+)'$")
    public void iShouleBeAbleToVerifyTheMessageNoRecordToDisplay(String message) {
        Assert.assertTrue(searchPageObj.noRecordDisplay().isDisplayed());
    }

    @And("^I should be able to verify the more than match available for the affinion data '(.+)'$")
    public void iShouldBeAbleToVerifyTheMoreThanMatchAvailableForTheAffinionData(String criteria) throws Throwable {
        performSearchObj.validateMoreThanOneMatchRecord(criteria);
    }

    @And("^I should be able to verify the updated data based on the priority$")
    public void iShouldBeAbleToVerifyTheUpdatedDataBasedOnThePriority() {
        System.out.println("--------------------------need to update code here----------------------");
    }


    @Then("^I should be able to retrieve the submitted Claim for below the '(.+)'$")
    public void iShouldBeAbleToRetrieveTheSubmittedClaimForBelowTheClientRecord(String parameter, List<List<String>> lstSearchCriteria) throws Throwable {
        this.performingASearchForAClientRecord();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        performSearchObj.clientSearch(lstSearchCriteria);
        nextEventPageObj.loadingPage();
        nextEventPageObj.waitForMoreTime();
        performSearchObj.retreiveFirstClientRecord();
        claimsOperationsObj.navigateToClaimViewFromPolicyView();
        claimSummaryPageObj.firstClaimSelectLink().click();

    }

    @Then("^I retrieve the partial quote details saved by the below '(.+)'$")
    public void iShouldRetrieveThePartialQuoteDetailsSavedByTheBelowClient(String parameter, List<List<String>> lstSearchCriteria) throws Throwable {
        this.performingASearchForAClientRecord();
        performSearchObj.clientSearch(lstSearchCriteria);
        nextEventPageObj.loadingPage();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();

        performSearchObj.retreiveFirstClientRecord();
        commandsObj.switchToDesiredWindow(By.xpath(policyDataFieldsPageObj.coverTable()));
    }

    @Then("^I should be able to retrieve the partial online Claim for below the '(.+)'$")
    public void iShouldBeAbleToRetrieveThePartialOnlineClaimForBelowTheClientRecord(String parameter, List<List<String>> lstSearchCriteria) throws Throwable {
        this.performingASearchForAClientRecord();
        performSearchObj.clientSearch(lstSearchCriteria);
        nextEventPageObj.loadingPage();
        nextEventPageObj.waitForMoreTime();
        performSearchObj.retreiveFirstClientRecord();
        claimsOperationsObj.navigateToClaimViewFromPolicyView();
//        claimSummaryPageObj.firstClaimSelectLink().click(); // Commented By Sony
    }

    @And("^I should be able to retrieve the supplier with '(.+)' given '(.+)'$")
    public void iShouldBeAbleToRetrieveTheSupplierWithMatterIDAs(String searchCriteria, String matterId) throws Throwable {
        performSearchObj.retrievingTheMatterId(searchCriteria, matterId);
    }


    @Given("^I have logged in as '(.+)' API$")
    public void iHaveLoggedInAsTestAgentUserAPI(String loginDetails) throws Throwable {
        ttapiOperationsObj.loginAPI(loginDetails);
    }

    @And("^I should be able to verify that the search result displays only one record$")
    public void iShouldBeAbleToVerifyThatTheSearchResultDisplaysOnlyOneRecord() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        performSearchObj.validateMoreThanOneMatchRecordAvailable();
    }

    @Then("^No record should be displayed for the partially matching values$")
    public void noRecordShouldBeDisplayedForThePartiallyMatchingValues() {
        Assert.assertTrue(searchPageObj.searchResultTable().isDisplayed());
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        System.out.println("------------"+searchPageObj.noRecordDisplay().getText());
        Assert.assertTrue(searchPageObj.noRecordDisplay().isDisplayed());
    }
}
