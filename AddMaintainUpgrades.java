package co.uk.directlinegroup.tt.step_definitions;


import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AddMaintainUpgrades {
    public String schemeid;
    private Navigation navigationObj = new Navigation();
    private PolicyOperations policyOperationsObj = new PolicyOperations();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private SchemeSummaryPage schemeSummaryPageObj = new SchemeSummaryPage();
    private ClaimsOperations claimOperationObj = new ClaimsOperations();
    private Commands commandsObj = new Commands();
    private PerilsAndCostsPage perilsAndCostsPageObj = new PerilsAndCostsPage();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private BasicClaimDetailsPage basicClaimDetObj = new BasicClaimDetailsPage();
    private RulesEngineOperation rulesEngineOperationObj = new RulesEngineOperation();
    private CommonPage commonPageObj = new CommonPage();
    private String sysDate = "";

    @When("^I have created a new scheme with the below details$")
    public void ihaveCreatedANewSchemeWithGivenDetails(List<List<String>> parameters) {
        navigationObj.navigateToNewPolicy();
        new org.openqa.selenium.support.ui.Select(schemeSummaryPageObj.filterByPolicytypeDropdown()).selectByVisibleText("Travel Schemes");
        policyOperationsObj.createScheme(parameters);
    }

    @And("^I should able to view the created scheme$")
    public void iShouldAbleToViewTheCreatedScheme() {
        policyDataFieldsPageObj.clickToView().click();
    }

    @Then("^I should be able to click on edit  scheme and navigate to edit scheme$")
    public void iShouldBeAbleToClickOnEditScheme() {
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(schemeSummaryPageObj.editFirstScheme());
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
    }

    @And("^I should be able to view the following fileds with the changes$")
    public void iShouldBeAbleToViewTheChangesMade(List<List<String>> parameters) {
        policyOperationsObj.validateDetails(parameters);
    }

    @And("^I search for a Travel schemes '(.+)'$")
    public void isearchforaTravelscheme(String schemeID) {
        navigationObj.validatePoliciesPanelIsDisplayed();
        policyDataFieldsPageObj.advancedSearch();
        policyDataFieldsPageObj.advancedSearch().click();
        policyDataFieldsPageObj.filterByPolicy();
        policyDataFieldsPageObj.filterByPolicy().click();
        new Select(policyDataFieldsPageObj.policyType()).selectByVisibleText("Travel Schemes");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(policyDataFieldsPageObj.searchByID());
        policyDataFieldsPageObj.policySearchbtn();
        policyDataFieldsPageObj.policySearchbtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policyOperationsObj.selectNatwestScheme();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToLastOpenWindow();
        schemeSummaryPageObj.editFirstScheme();
        schemeSummaryPageObj.editFirstScheme().click();
    }

    @When("^I have to navigate to  scheme$")
    public void ihaveto_navigateSchemeWithGivenDetails() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        navigationObj.navigateToNewPolicy();
    }

    @And("^I should be able  to select the following fields in advance search page$")
    public void I_have_to_select_Travel_scheme_with_the_below_details(List<List<String>> lstInputs) {
         nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.advancedSearch();
        policyDataFieldsPageObj.advancedSearch().click();
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                {
                    switch (lstInputs.get(0).get(j).toLowerCase()) {
                        case "filter by policy type":
                            new org.openqa.selenium.support.ui.Select(schemeSummaryPageObj.filterByPolicytypeDropdown()).selectByVisibleText(lstInputs.get(i).get(j));
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            break;
                        case "company name":
                            schemeSummaryPageObj.companyNameTextBox().sendKeys(lstInputs.get(i).get(j));
                            break;
                    }
                }
            }
            policyDataFieldsPageObj.searchbtn().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            policyOperationsObj.selectNatwestScheme();
            nextEventPageObj.switchToLastOpenWindow();
            nextEventPageObj.waitForMoreTime();
        }
    }

    @And("^I should be able to see the following fields$")
    public void Ishouldbeabletoseethefollowingfields(List<String> parameters) {
        for(int i=0; i<parameters.size(); i++){
            System.out.println("I value" + parameters.get(i));
            switch(parameters.get(i).toLowerCase()){
                case "brand":
                    Assert.assertTrue(schemeSummaryPageObj.brand().isDisplayed());
                    System.out.println("Verified Brand");
                    break;
                case "product code":
                    Assert.assertTrue(schemeSummaryPageObj.productCode().isDisplayed());
                    System.out.println("Verified product Code");
                    break;
                case "product type":
                    Assert.assertTrue(schemeSummaryPageObj.productType().isDisplayed());
                    System.out.println("Verified product Type");
                    break;
                case "product description":
                    Assert.assertTrue(schemeSummaryPageObj.productDescription().isDisplayed());
                    System.out.println("Verified product description");
                    break;
                case "start date of product":
                    Assert.assertTrue(schemeSummaryPageObj.dateFrom().isDisplayed());
                    System.out.println("Verified start date of product");
                    break;
                case "end date of product":
                    Assert.assertTrue(schemeSummaryPageObj.dateTo().isDisplayed());
                    System.out.println("Verified end date of product");
                    break;
            }
        }
        nextEventPageObj.btnCloseWindow().click();
        nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
    }

    @And("^I should be able to create a new '(.+)' with below detailss$")
    public void i_should_be_able_to_create_a_new_with_below_details(String policy, List<List<String>> parameters) throws Throwable {
        nextEventPageObj.switchToDefault();
        policyOperationsObj.createPolicy_scheme(policy, parameters);
        nextEventPageObj.switchToDefault();
    }

    @And("^I should be able to '(.+)' the following fields under limits and excesses tab with insured persons trip length and geographical limit$")
    public void iShouldBeAbleToVerifyFieldsDisplayedInlimitsandexcesses(String action,List<List<String>> parameters) throws Throwable {
        policyOperationsObj.validateProductTermsAndConditions(action,parameters);
    }

    @And("^I should be able to Create a new for scheme'(.+)'$")
    public void i_should_be_able_to_create_a_new_(String claim, List<List<String>> parameters) {
        try {
            List<List<String>> newParameters = commandsObj.parameterMapping(1, parameters);
            nextEventPageObj.btnClick(claimSummaryPageObj.newClaim());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            Thread.sleep(10000);
            nextEventPageObj.btnClick(nextEventPageObj.go()); // get new claim id after this step
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
            nextEventPageObj.waitForMoreTime();
            claimOperationObj.createEditClaims(claim, newParameters);
            basicClaimDetObj.save().click();
            commonPageObj.switchToFrameById(commonPageObj.fancyFrame());
            perilsAndCostsPageObj.claimLossDate().clear();
            perilsAndCostsPageObj.claimLossDate().sendKeys("23/12/2016");
            perilsAndCostsPageObj.claimLossDate().sendKeys(Keys.TAB);
            nextEventPageObj.btnClick(perilsAndCostsPageObj.addPeril());
            claimOperationObj.validateClaimCause(claim, "Save", newParameters);
            claimOperationObj.addPersonClaimCost();
            nextEventPageObj.btnClick(perilsAndCostsPageObj.addClaimItem());
            claimOperationObj.validateClaimCostType(claim, newParameters);
            perilsAndCostsPageObj.saveClaimItem().click();
            this.sysDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString();
            System.out.println("System date ------------------------" + this.sysDate);
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I should be able to update the scheme '(.+)'$")
    public void iShouldBeAbleToUpdateTheScheme(String schemeId) {
        schemeid = schemeId;
        System.out.println("############################after clicking of scheme  search button$$$$$$$");
        policyOperationsObj.selectparticularcheme(schemeid);
        nextEventPageObj.switchToDefault();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    @And("^I should be able to edit '(.+)' scheme for endrosement$")
    public void iShouldBeAbleToEditSilverCoverSchemeForEndrosement(String cover) {
        schemeSummaryPageObj.editSpecificScheme().click();
    }

    @And("^I should be able to able '(.+)' with below details$")
    public void iShouldBeAbleToAbleApplyEndrosementWithBelowDetails(String endrosementOperations, List<List<String>> lstInput) {
        policyDataFieldsPageObj.endorsementTab().click();
        for (int i = 1; i < lstInput.size(); i++) {
            for (int j = 0; j < lstInput.get(0).size(); j++) {
                policyOperationsObj.enterEndorsementDetails(lstInput.get(0).get(j), lstInput.get(i).get(j));
            }
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        schemeSummaryPageObj.saveAndCloseBtn().click();
    }

    @And("^I should be able to update the Pricing date$")
    public void iShouldBeAbleToUpdateThePricingDate() {
        schemeSummaryPageObj.tabPricing().click();
        schemeSummaryPageObj.linkEditPricing().click();
        DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
        Date dateobj = new Date();
        String dateValue = df.format(dateobj);
        System.out.println(df.format(dateobj));
        System.out.println("Date -------------------" + dateValue);
        schemeSummaryPageObj.txtEndDate().clear();
        schemeSummaryPageObj.txtEndDate().sendKeys(dateValue);
        schemeSummaryPageObj.lnkUpdatePricing(4).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        schemeSummaryPageObj.insertRecord().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        schemeSummaryPageObj.pricingTableId().clear();
        schemeSummaryPageObj.pricingTableId().sendKeys(rulesEngineOperationObj.ruleSetId);
        schemeSummaryPageObj.txtStartDate().clear();
        schemeSummaryPageObj.txtStartDate().sendKeys(dateValue);
        schemeSummaryPageObj.lnkUpdatePricing(5).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnCloseWindow().click();
    }

    @And("^I should be able to edit '(.+)' scheme$")
    public void iShouldBeAbleToEditScheme(String cover) {
        commandsObj.switchToDesiredWindow(By.xpath(schemeSummaryPageObj.specificSchemexpath(cover)));
        schemeSummaryPageObj.specificScheme(cover).click();
    }

    @And("^I should be able to edit '(.+)' quote")
    public void iShouldBeAbleToEditQuote(String cover) {
        schemeSummaryPageObj.specificQuote(cover).click();
    }


    @And("^I should be able to edit '(.+)'$")
    public void iShouldBeAbleToEditCover(String cover) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        schemeSummaryPageObj.specificCover(cover).click();
    }

    @And("^I should be able to update the details for '(.+)' scheme$") //@addons
    public void iShouldBeAbleToUpdateThedetailsForBlackCoverScheme(String cover, List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        schemeSummaryPageObj.specificScheme(cover).click();
        policyOperationsObj.updateUpgradeFields(parameters);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policyOperationsObj.closeSchemesWindow();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    @And("^I should be able to navigate to upgrade scheme and '(.+)' updagrades$")
    public void iShouldBeAbleToVerifyFieldsDisplayedInUpgrade(String action, List<List<String>> parameters) {
        nextEventPageObj.elementDisplayed(schemeSummaryPageObj.saveAndCloseBtn());
        schemeSummaryPageObj.upgradeTab().click();
        Assert.assertTrue("Navigated to upgrade page -----------------------" + schemeSummaryPageObj.insertRecordFromResourceListBtn().isDisplayed(), schemeSummaryPageObj.insertRecordFromResourceListBtn().isDisplayed());
        switch (action.toLowerCase()) {
            case "add":
                schemeSummaryPageObj.insertRecordFromResourceListBtn().click();
                policyOperationsObj.updateUpgradeFields(parameters);
                break;
            case "amend":
                nextEventPageObj.waitForMoreTime();
                schemeSummaryPageObj.editBtn();
                schemeSummaryPageObj.editBtn().click();
                policyOperationsObj.updateUpgradeFields(parameters);
                break;
            case "verify":
                policyOperationsObj.verifyUpgradeFields(parameters);
                break;
        }
    }

    @And("^I should be able to edit the end date for previously available scheme and add revised rate set for '(.+)'$")
    public void iShouldBeAbleToEditTheEndDateForPreviouslyAvailableSchemeAndAddRevisedRateSetForUpgrade(String cover) {
        policyOperationsObj.updatePricingDetailsForScheme(cover);
    }

    @And("^I should be able to delete the rule set defined for '(.+)'$")
    public void iShouldBeAbleToDeleteTheRuleSetDefinedForWeddingCover(String cover) {
        policyOperationsObj.deleteRuleSetDefined(cover);
    }

    @And("^I should be able to get the original rule set id for '(.+)'$")
    public void iShouldBeAbleToGetTheOriginalRuleSetId(String cover) {
        rulesEngineOperationObj.getPricingTableId(cover);
    }

    @And("^I should allow to add new scheme with the following parameters$")
    public void iShouldAllowToAddNewSchemeWithTheFollowingParameters(List<List<String>> parameters) throws Throwable {
       policyOperationsObj.addNewScheme(parameters);
    }

    @And("^I should allow to amend the following details for the '(.+)' scheme$")
    public void iShouldAllowToAmendTheFollowingDetailsForTheBlackCoverScheme(String scheme, List<List<String>> parameters) throws Throwable {
       policyOperationsObj.updateSchemeDetails(scheme,parameters);
    }

    @Given("^test the rerun '(.+)'$")
    public void testTheRerunTrue(String var) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if(var.equalsIgnoreCase("true")) {
            Assert.assertTrue(true);
        }
        else{
            Assert.fail();
        }
    }

    @And("^I should be able to edit '(.+)' travel scheme$")
    public void iShouldBeAbleToEditTravelScheme(String cover) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        commandsObj.switchToDesiredWindow(By.xpath(schemeSummaryPageObj.specificSchemexpath(cover)));
        schemeSummaryPageObj.specificTravelSchemexpath(cover).click();
    }
}
