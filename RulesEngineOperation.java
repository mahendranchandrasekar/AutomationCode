package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import static com.usmanhussain.habanero.framework.AbstractPage.getDriver;

/**
 * Created by 324102 on 7/21/2017.
 */
public class RulesEngineOperation {

    public static String premiumValue = "";
    public static String ruleSetId = "";
    public static String existingUpgradeCost = "";
    public static String existingBusinessUpgradeCost = "";
    public static String existingGolfUpgradeCost = "";
    public static String premiumFromScheme_Medical = "";
    public static String premiumFromScheme_Business = "";
    public static String premiumFromScheme_Golf = "";
    public static String thisYearPremium_Medical = "";
    public static String thisYearPremium_Business = "";
    public static String thisYearPremium_Golf = "";
    static String initialRulesSetID = "";
    public String businessPremium = "";
    public String medicalPremium = "";
    public String cancellation12500TxtBox = "";
    public static String destinationRetrievedFromRulesEngine="";
    public static String originalRawPremium="";
    private LeftNavPanePage leftNavPaneObj = new LeftNavPanePage();
    private RulesEnginePage rulesEnginePageObj = new RulesEnginePage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private SchemeSummaryPage schemeSummaryPageObj = new SchemeSummaryPage();
    private QuoteDetailsPage quoteDetailsPageObj = new QuoteDetailsPage();
    private Commands commandsObj = new Commands();
    private CommonPage commonPageObj = new CommonPage();

    public void updateTheParameterDetails(List<List<String>> parameter) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        for (int i = 1; i < parameter.size(); i++) {
            for (int j = 0; j < parameter.get(0).size(); j++) {
                this.updateTheRulesEngineParameter(parameter.get(0).get(j), parameter.get(i).get(j));
            }
        }
        nextEventPageObj.switchToDefault();
        Actions action = new Actions(getDriver);
        action.moveToElement(rulesEnginePageObj.closeRulesEngineFrameBtn()).click(rulesEnginePageObj.closeRulesEngineFrameBtn()).build().perform();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    private void updateTheRulesEngineParameter(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "baggage claim value":
                rulesEnginePageObj.btnSelect().click();
                rulesEnginePageObj.selectRules("Customer Validation").click();
                rulesEnginePageObj.selectRules("Baggage Claim Value").click();
                rulesEnginePageObj.selectRules("Claim: Total Baggage Loss Value").click();
                rulesEnginePageObj.editExsistingRuleForBaggaeAmount().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                rulesEnginePageObj.baggageCostValueUpdateInput().clear();
                rulesEnginePageObj.baggageCostValueUpdateInput().sendKeys(fieldValue);
                rulesEnginePageObj.saveUpdatesRulesBtn().click();
                break;
        }
    }

    public void updateRawPremiumForCover(String coverTerm, String cover) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        ruleSetId = rulesEnginePageObj.ruleSetIdOfUpgrade(cover).getText();
        System.out.println("Rules set id---------------------" + ruleSetId);
        rulesEnginePageObj.selectRules(cover).click();
        rulesEnginePageObj.selectRules("Raw Premium").click();
        nextEventPageObj.btnClick(rulesEnginePageObj.enterValuesInGridBtn());
        rulesEnginePageObj.btnApply().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        rulesEnginePageObj.btnApply().click();
        nextEventPageObj.waitForMoreTime();
        rulesEnginePageObj.weddingCoverSilverAccount().clear();
        rulesEnginePageObj.weddingCoverSilverAccount().sendKeys(coverTerm.split("-")[1]);
        rulesEnginePageObj.saveOutputBtn().click();
        nextEventPageObj.switchToDefault();
        Actions action = new Actions(getDriver);
        action.moveToElement(rulesEnginePageObj.closeRulesEngineFrameBtn()).click(rulesEnginePageObj.closeRulesEngineFrameBtn()).build().perform();
    }

    public void captureRawPremiumForCover(String coverTerm) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        nextEventPageObj.btnClick(rulesEnginePageObj.selectSetByRules());
        if (!(initialRulesSetID.isEmpty())) {
            System.out.println("initialRulesSetID----------------" + initialRulesSetID);
            rulesEnginePageObj.selectRulesBySetID(initialRulesSetID).click();
        } else if (!(coverTerm.isEmpty())) {
            System.out.println("select by cover");
            rulesEnginePageObj.selectRulesByCover(coverTerm).click();
        }
        rulesEnginePageObj.selectRules("Raw Premium").click();
        nextEventPageObj.btnClick(rulesEnginePageObj.enterValuesInGridBtn());
        rulesEnginePageObj.btnApply().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        rulesEnginePageObj.btnApply().click();
        nextEventPageObj.waitForMoreTime();
        if (coverTerm.equalsIgnoreCase("Cancellation")) {
            existingUpgradeCost = rulesEnginePageObj.CancellationCoverPlatinumAccount().getAttribute("value");

        } else {
            existingUpgradeCost = rulesEnginePageObj.weddingCoverSilverAccount().getAttribute("value");
        }
        System.out.println("Existing upgrades cost ---------" + existingUpgradeCost);
    }

    public void getPricingTableId(String cover) {
        commandsObj.switchToDesiredWindow(By.xpath(schemeSummaryPageObj.specificSchemexpath(cover)));
        schemeSummaryPageObj.btnClick(schemeSummaryPageObj.specificCover(cover));
        schemeSummaryPageObj.pricingTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        initialRulesSetID = schemeSummaryPageObj.initialRulesSetIdUnderPricingInScheme().getText();
        System.out.println("initialRulesSetID---------------" + initialRulesSetID);
        nextEventPageObj.btnClick(quoteDetailsPageObj.btnSaveAndClose());
    }

    public void updateAndGetValues(String upgrades, String rules) {
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        ruleSetId = rulesEnginePageObj.ruleSetIdOfUpgrade(upgrades).getText();
        rulesEnginePageObj.selectUpgrades(upgrades).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        rulesEnginePageObj.selectRules("Raw Premium").isDisplayed();
        rulesEnginePageObj.selectRules("Raw Premium").click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        rulesEnginePageObj.btnEnterGridValues().isDisplayed();
        rulesEnginePageObj.btnEnterGridValues().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        rulesEnginePageObj.btnApply().isDisplayed();
        rulesEnginePageObj.btnApply().click();
        rulesEnginePageObj.btnApply().click();
        switch (rules.toLowerCase()) {
            case "business":
                this.businessPremium = rulesEnginePageObj.txtGridValue().getAttribute("value");
                System.out.println("Grid value is --------------------------" + this.businessPremium);
                break;
            case "medical":
                this.medicalPremium = rulesEnginePageObj.txtmedicalPremium().getAttribute("value");
                System.out.println("Grid value is --------------------------" + this.medicalPremium);
                break;
        }
    }

    public void accessingPremiumValuesInRulesEngine(String action, List<List<String>> parameters) {
        if (action.equalsIgnoreCase("retrieve")) {
            System.out.println("parameters size" + parameters.size());
            for (int i = 1; i < parameters.size(); i++) {
                this.retrieveRawPremiumFromRulesEngine(parameters.get(i), parameters.get(0));
            }
            nextEventPageObj.switchToDefault();
            Actions actions = new Actions(getDriver);
            actions.moveToElement(rulesEnginePageObj.closeRulesEngineFrameBtn()).click(rulesEnginePageObj.closeRulesEngineFrameBtn()).build().perform();
        } else if (action.equalsIgnoreCase("update")) {
            for (int i = 1; i < parameters.size(); i++) {
                this.updateRawPremiumFromRulesEngine(parameters.get(i), parameters.get(0));
            }
            nextEventPageObj.switchToDefault();
            Actions actions = new Actions(getDriver);
            actions.moveToElement(rulesEnginePageObj.closeRulesEngineFrameBtn()).click(rulesEnginePageObj.closeRulesEngineFrameBtn()).build().perform();
        }
    }

    public void retrieveRawPremiumFromRulesEngine(List<String> rowValue, List<String> columnValue) {
        String cover = "", ruleSet = "";
        for (int i = 0; i < columnValue.size(); i++) {
            if (columnValue.get(i).equalsIgnoreCase("cover"))
                cover = rowValue.get(i);
            else if (columnValue.get(i).equalsIgnoreCase("ruleset")) {
                ruleSet = rowValue.get(i);
                this.captureRawPremiumForCoverwithSepcificcoverset(cover, ruleSet);
            }
        }
    }

    public void captureRawPremiumForCoverwithSepcificcoverset(String coverTerm, String ruleSet) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        if (!(initialRulesSetID.isEmpty())) {
            System.out.println("initialRulesSetID----------------" + initialRulesSetID);
            rulesEnginePageObj.selectRulesBySetID(initialRulesSetID).click();
        } else if (!(coverTerm.isEmpty())) {
            System.out.println("select by cover");
            rulesEnginePageObj.selectRulesByCover(coverTerm).click();
        }
        rulesEnginePageObj.selectRules("Raw Premium").click();
        nextEventPageObj.btnClick(rulesEnginePageObj.enterValuesInGridBtn());
        rulesEnginePageObj.btnApply().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        rulesEnginePageObj.btnApply().click();
        nextEventPageObj.waitForMoreTime();
        if (coverTerm.equalsIgnoreCase("medical")) {
            existingUpgradeCost = rulesEnginePageObj.retrieveMedicalCoverValueForPlatinumAccount(ruleSet).getAttribute("value");
            System.out.println("Inside Medical cover");
        } else if ((coverTerm.equalsIgnoreCase("business"))) {
            existingBusinessUpgradeCost = rulesEnginePageObj.retrieveCoverValueForPlatinumAccount().getAttribute("value");
            System.out.println("Inside general cover" + existingBusinessUpgradeCost);
        } else if ((coverTerm.equalsIgnoreCase("golf"))) {
            existingGolfUpgradeCost = rulesEnginePageObj.retrieveCoverValueForPlatinumAccount().getAttribute("value");
            System.out.println("Inside general cover" + existingGolfUpgradeCost);
        }
        System.out.println("Existing upgrades cost ---------" + existingUpgradeCost);
        System.out.println("Inside general cover" + existingBusinessUpgradeCost);
        System.out.println("Inside general cover" + existingGolfUpgradeCost);
        rulesEnginePageObj.navigateToPremiumCalculation().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void updateRawPremiumFromRulesEngine(List<String> rowValue, List<String> columnValue) {
        String cover = "", ruleSet = "", premium = "";
        for (int i = 0; i < columnValue.size(); i++) {
            if (columnValue.get(i).equalsIgnoreCase("cover"))
                cover = rowValue.get(i);
            else if (columnValue.get(i).equalsIgnoreCase("ruleset")) {
                ruleSet = rowValue.get(i);

            } else if (columnValue.get(i).equalsIgnoreCase("premium")) {
                this.updateRawPremiumForCoverwithSepcificcoverset(cover, ruleSet, premium);
            }
        }
    }

    public void updateRawPremiumForCoverwithSepcificcoverset(String coverTerm, String ruleSet, String premium) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        if (!(initialRulesSetID.isEmpty())) {
            System.out.println("initialRulesSetID----------------" + initialRulesSetID);
            rulesEnginePageObj.selectRulesBySetID(initialRulesSetID).click();
        } else if (!(coverTerm.isEmpty())) {
            System.out.println("select by cover");
            rulesEnginePageObj.selectRulesByCover(coverTerm).click();
        }
        rulesEnginePageObj.selectRules("Raw Premium").click();
        nextEventPageObj.btnClick(rulesEnginePageObj.enterValuesInGridBtn());
        rulesEnginePageObj.btnApply().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        rulesEnginePageObj.btnApply().click();
        nextEventPageObj.waitForMoreTime();
        if (coverTerm.equalsIgnoreCase("medical")) {
            rulesEnginePageObj.retrieveMedicalCoverValueForPlatinumAccount(ruleSet).clear();
            rulesEnginePageObj.retrieveMedicalCoverValueForPlatinumAccount(ruleSet).sendKeys(premium);
            System.out.println("Inside Medical cover");
        } else if ((coverTerm.equalsIgnoreCase("business"))) {
            rulesEnginePageObj.retrieveCoverValueForPlatinumAccount().clear();
            rulesEnginePageObj.retrieveCoverValueForPlatinumAccount().sendKeys(premium);
            System.out.println("Inside Business cover");
        } else if ((coverTerm.equalsIgnoreCase("golf"))) {
            rulesEnginePageObj.retrieveCoverValueForPlatinumAccount().clear();
            rulesEnginePageObj.retrieveCoverValueForPlatinumAccount().sendKeys(premium);
            System.out.println("Inside Golf cover");
        }
        rulesEnginePageObj.saveOutputBtn().click();
        rulesEnginePageObj.navigateToPremiumCalculation().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void vaidatePremiunValuesForUpgrades(List<String> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            this.validatePremiumValues(parameters.get(i));
        }
    }

    public void validatePremiumValues(String cover) {
        switch (cover) {
            case "Medical":
                int tax_Calc, premium_FromScheme_calc, premium_FromRulesEng_calc;
                int totalPremium_calc;
                String[] tax = QuoteAndBuyOperations.taxForSpecificRegion.split("\\.");
                tax_Calc = Integer.parseInt(tax[0]);
                System.out.println("Tax retrieved" + tax_Calc);
                premiumFromScheme_Medical = rulesEnginePageObj.retrievePremiumValueForUpgradeInschemeSummary(cover).getText();
                String[] premium_FromScheme = premiumFromScheme_Medical.split("\\.");
                premium_FromScheme_calc = Integer.parseInt(premium_FromScheme[0]);
                String premium_FromScheme_calc_Modified = Integer.toString(premium_FromScheme_calc);
                System.out.println("Premium value retrieved in scheme summary page" + premium_FromScheme_calc_Modified);
                premium_FromRulesEng_calc = Integer.parseInt(existingUpgradeCost);
                System.out.println("Premium retrieved from rules Engine" + premium_FromRulesEng_calc);
                totalPremium_calc = (premium_FromRulesEng_calc * (100 + tax_Calc)) / 100;
                thisYearPremium_Medical = Integer.toString(totalPremium_calc);
                Assert.assertTrue(premium_FromScheme_calc_Modified.equalsIgnoreCase(thisYearPremium_Medical));
                break;
            case "Business Cover":
                int tax_Calc_Business, premium_FromScheme_calc_Business, premium_FromRulesEng_calc_Business;
                int totalPremium_calc_Business;
                String[] tax_Business = QuoteAndBuyOperations.taxForSpecificRegion.split("\\.");
                tax_Calc_Business = Integer.parseInt(tax_Business[0]);
                System.out.println("Tax retrieved" + tax_Calc_Business);
                premiumFromScheme_Business = rulesEnginePageObj.retrievePremiumValueForUpgradeInschemeSummary(cover).getText();
                String[] premium_FromScheme_Business = premiumFromScheme_Business.split("\\.");
                premium_FromScheme_calc_Business = Integer.parseInt(premium_FromScheme_Business[0]);
                String premium_FromScheme_calc_BusinessModified = Integer.toString(premium_FromScheme_calc_Business);
                System.out.println("Premium value retrieved in scheme summary page" + premium_FromScheme_calc_BusinessModified);
                premium_FromRulesEng_calc_Business = Integer.parseInt(existingBusinessUpgradeCost);
                System.out.println("Premium retrieved from rules Engine" + premium_FromRulesEng_calc_Business);
                totalPremium_calc_Business = (premium_FromRulesEng_calc_Business * (100 + tax_Calc_Business)) / 100;
                thisYearPremium_Business = Integer.toString(totalPremium_calc_Business);
                Assert.assertTrue(premium_FromScheme_calc_BusinessModified.equalsIgnoreCase(thisYearPremium_Business));
                break;
            case "Golf cover":
                int tax_Calc_Golf_cover, premium_FromScheme_calc_Golf_cover, premium_FromRulesEng_calc_Golf_cover;
                int totalPremium_calc_Golf_cover;
                String[] tax_Golf_cover = QuoteAndBuyOperations.taxForSpecificRegion.split("\\.");
                tax_Calc_Golf_cover = Integer.parseInt(tax_Golf_cover[0]);
                System.out.println("Tax retrieved" + tax_Calc_Golf_cover);
                premiumFromScheme_Golf = rulesEnginePageObj.retrievePremiumValueForUpgradeInschemeSummary(cover).getText();
                String[] premium_FromScheme_Golf_cover = premiumFromScheme_Golf.split("\\.");
                premium_FromScheme_calc_Golf_cover = Integer.parseInt(premium_FromScheme_Golf_cover[0]);
                String premium_FromScheme_calc_GolfModified = Integer.toString(premium_FromScheme_calc_Golf_cover);
                System.out.println("Premium value retrieved in scheme summary page" + premium_FromScheme_calc_GolfModified);
                premium_FromRulesEng_calc_Golf_cover = Integer.parseInt(existingGolfUpgradeCost);
                System.out.println("Premium retrieved from rules Engine" + premium_FromRulesEng_calc_Golf_cover);
                totalPremium_calc_Golf_cover = (premium_FromRulesEng_calc_Golf_cover * (100 + tax_Calc_Golf_cover)) / 100;
                thisYearPremium_Golf = Integer.toString(totalPremium_calc_Golf_cover);
                Assert.assertTrue(premium_FromScheme_calc_GolfModified.equalsIgnoreCase(thisYearPremium_Golf));
                break;
        }
    }

    public void validatePremiumForExtension(String cover, int length, String account) {
        int tdCount = 0;
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        rulesEnginePageObj.selectChangeSetButton().click();
        if (!(initialRulesSetID.isEmpty())) {
            System.out.println("initialRulesSetID----------------" + initialRulesSetID);
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            rulesEnginePageObj.selectRulesBySetID(initialRulesSetID).click();
        } else if (!(cover.isEmpty())) {
            System.out.println("select by cover");
            rulesEnginePageObj.selectRulesByCover(cover).click();
        }

        rulesEnginePageObj.selectRules("Raw Premium").click();
        nextEventPageObj.btnClick(rulesEnginePageObj.enterValuesInGridBtn());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("Account value-----" + account);
        List<WebElement> daysAvailableToCalculate = nextEventPageObj.findElements(By.xpath(rulesEnginePageObj.retrieveDaysValueXpath()));
        for(int i = 0 ;i < daysAvailableToCalculate.size() ; i++){
            String daysFromPage = daysAvailableToCalculate.get(i).getText();
            if(!daysFromPage.equalsIgnoreCase("InsuredPerson: Trip Length = "+length)){
               tdCount++;
            }
            else {
                break;
            }
        }
        if (account.equalsIgnoreCase("Platinum")) {
            nextEventPageObj.waitForMoreTime();
            rulesEnginePageObj.retrievePremiumValueForPlatinumAccount(tdCount).click();
            existingUpgradeCost = rulesEnginePageObj.retrievePremiumValueForPlatinumAccount(tdCount+1).getAttribute("value");
            System.out.println("Trip Length------" + existingUpgradeCost);
        } else if (account.equalsIgnoreCase("Black")) {
            nextEventPageObj.waitForMoreTime();
            rulesEnginePageObj.retrievePremiumValueForPlatinumAccount(tdCount).click();
            existingUpgradeCost = rulesEnginePageObj.retrieveCoverValueForBlackAccount(tdCount).getAttribute("value");
            System.out.println("Trip Length------" + existingUpgradeCost);
        }
        originalRawPremium = existingUpgradeCost;
        System.out.println("RulesEngine premium-------" + existingUpgradeCost);
        rulesEnginePageObj.switchToDefault();
        Actions action = new Actions(getDriver);
        action.moveToElement(rulesEnginePageObj.closeRulesEngineFrameBtn()).click(rulesEnginePageObj.closeRulesEngineFrameBtn()).build().perform();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
    }

    public void captureRawPremiumForCancellation(String coverTerm, String increaseAmount, String Account) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        if(!(initialRulesSetID.isEmpty())) {
            System.out.println("initialRulesSetID----------------" + initialRulesSetID);
            rulesEnginePageObj.selectRulesBySetID(initialRulesSetID).click();
        } else if(!(coverTerm.isEmpty())){
            System.out.println("select by cover");
            rulesEnginePageObj.selectRulesByCover(coverTerm).click();
        }
        rulesEnginePageObj.selectRules("Raw Premium").click();
        nextEventPageObj.btnClick(rulesEnginePageObj.enterValuesInGridBtn());
        rulesEnginePageObj.btnApply().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        rulesEnginePageObj.btnApply().click();
        nextEventPageObj.waitForMoreTime();
        if(coverTerm.equalsIgnoreCase("Cancellation")){
            existingUpgradeCost = rulesEnginePageObj.CancellationCoverPlatinumAccount().getAttribute("value");

        }else {
            existingUpgradeCost = rulesEnginePageObj.weddingCoverSilverAccount().getAttribute("value");
        }
        System.out.println("Existing upgrades cost ---------" + existingUpgradeCost);
    }


    public void getAgeExtensioPremium(String upgrade, String year, String account) {
        int tdCount = 0;
       this.navigateToGivenUpgrade(upgrade);
        nextEventPageObj.waitForMoreTime();
        List<WebElement> daysAvailableToCalculate = nextEventPageObj.findElements(By.xpath(rulesEnginePageObj.retrieveDaysValueXpath()));
        for(int i = 0 ;i < daysAvailableToCalculate.size() ; i++){
            String daysFromPage = daysAvailableToCalculate.get(i).getText();
            if(!daysFromPage.equalsIgnoreCase("InsuredPerson: Age in years at term start = "+year)){
                tdCount++;
            }
            else {
                break;
            }
        }
        existingUpgradeCost = rulesEnginePageObj.selectAgeUpgradeForGivenYearsAndAccount(account,tdCount+1).getAttribute("value");
        originalRawPremium=existingUpgradeCost;
        System.out.println("premiumValue--------------------------"+existingUpgradeCost);
        nextEventPageObj.switchToDefault();
        Actions action = new Actions(getDriver);
        action.moveToElement(rulesEnginePageObj.closeRulesEngineFrameBtn()).click(rulesEnginePageObj.closeRulesEngineFrameBtn()).build().perform();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void getAnnualPremiumUpgrade(String upgrade, String account) {
        this.navigateToGivenUpgrade(upgrade);
        nextEventPageObj.waitForMoreTime();
        existingUpgradeCost=rulesEnginePageObj.selecAnnualUpgradePremiumForGivenAccount(account).getAttribute("value");
        originalRawPremium=existingUpgradeCost;
        System.out.println("premiumValue--------------------------"+existingUpgradeCost);
        System.out.println("originalRawPremium--------------------------"+originalRawPremium);
        nextEventPageObj.switchToDefault();
        Actions action = new Actions(getDriver);
        action.moveToElement(rulesEnginePageObj.closeRulesEngineFrameBtn()).click(rulesEnginePageObj.closeRulesEngineFrameBtn()).build().perform();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }
    public void navigateToGivenUpgrade(String upgrade){
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        rulesEnginePageObj.selectChangeSetButton().click();
        rulesEnginePageObj.selectRulesByCover(upgrade).click();
        rulesEnginePageObj.selectRules("Raw Premium").click();
        nextEventPageObj.btnClick(rulesEnginePageObj.enterValuesInGridBtn());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
      }

    public void getRawPremiumForGuest(String upgrade, String age, String destination, String winterSport, String account, String noOfDays) {
        String updatedAge = "";
        if(Integer.parseInt(age)< 70){
            updatedAge = "InsuredPerson: Age in years at term start < 70";
        }
        else if(Integer.parseInt(age) >= 70){
            updatedAge = "InsuredPerson: Age in years at term start >= 70";
        }
        if(winterSport.equalsIgnoreCase("no")){
            winterSport="0";
        }
        else if(winterSport.equalsIgnoreCase("yes")){
            winterSport = "1";
        }
        if(destination.contains("Worldwide"))
            destination = "Worldwide";
        this.navigateToGivenUpgrade(upgrade);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        int tdCount = 0;
        List<WebElement> daysAvailableToCalculate = nextEventPageObj.findElements(By.xpath(rulesEnginePageObj.retrieveDaysValueXpath()));
        for(int i = 0 ;i < daysAvailableToCalculate.size() ; i++){
            String daysFromPage = daysAvailableToCalculate.get(i).getText();
            if(!daysFromPage.equalsIgnoreCase("InsuredPerson: Trip Length = "+noOfDays)){
                tdCount++;
            }
            else {
                break;
            }
        }
        existingUpgradeCost = rulesEnginePageObj.getPremiumForGuest(updatedAge,destination,winterSport,tdCount,account).getAttribute("value");
        originalRawPremium = existingUpgradeCost;
        System.out.println("premiumValue--------------------------"+existingUpgradeCost);
        nextEventPageObj.switchToDefault();
        Actions action = new Actions(getDriver);
        action.moveToElement(rulesEnginePageObj.closeRulesEngineFrameBtn()).click(rulesEnginePageObj.closeRulesEngineFrameBtn()).build().perform();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void getRawPremiumForCancellation(String upgrade, String amount, String account) {
        String tdVal = "";
        int amt= 0;
        if (account.equalsIgnoreCase("Black")) {
            tdVal = "1";
            amt = Integer.parseInt(amount) - 10000;
            amount = String.valueOf(amt);
        }
        else if (account.equalsIgnoreCase("Platinum")) {
            tdVal = "2";
            amt = Integer.parseInt(amount) - 5000;
            amount = String.valueOf(amt);
        }
        else if (account.equalsIgnoreCase("silver")) {
            tdVal = "3";
            amt = Integer.parseInt(amount) - 5000;
            amount = String.valueOf(amt);
        }
        else if (account.equalsIgnoreCase("Ufirst")) {
            tdVal = "4";
            amt = Integer.parseInt(amount) - 5000;
            amount = String.valueOf(amt);
        }
        this.navigateToGivenUpgrade(upgrade);
        nextEventPageObj.waitForMoreTime();
        existingUpgradeCost = rulesEnginePageObj.selectAmountForAccount(amount,tdVal,account).getAttribute("value");
        System.out.println("premiumValue--------------------------"+existingUpgradeCost);
        originalRawPremium = existingUpgradeCost;
        nextEventPageObj.switchToDefault();
        Actions action = new Actions(getDriver);
        action.moveToElement(rulesEnginePageObj.closeRulesEngineFrameBtn()).click(rulesEnginePageObj.closeRulesEngineFrameBtn()).build().perform();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void gettingRawPremium(String coverTerm, String product) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        rulesEnginePageObj.btnSelect().click();
        rulesEnginePageObj.selectRulesByCover(coverTerm).click();
        rulesEnginePageObj.selectRules("Raw Premium").click();
        nextEventPageObj.btnClick(rulesEnginePageObj.enterValuesInGridBtn());
        originalRawPremium =  rulesEnginePageObj.txtCaptureRawPremium(product).getAttribute("value");
        System.out.println("Value of Raw Premium------"+originalRawPremium);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        Actions action = new Actions(getDriver);
        action.moveToElement(rulesEnginePageObj.closeRulesEngineFrameBtn()).click(rulesEnginePageObj.closeRulesEngineFrameBtn()).build().perform();
    }

    public void updateRawPremium(String coverTerm, String product, String value) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        rulesEnginePageObj.btnSelect().click();
        rulesEnginePageObj.selectRulesByCover(coverTerm).click();

        rulesEnginePageObj.selectRules("Raw Premium").click();
        nextEventPageObj.btnClick(rulesEnginePageObj.enterValuesInGridBtn());
        if(product.equalsIgnoreCase("Platinum")) {
            rulesEnginePageObj.txtUpdateRawPremiumForPlatinum().clear();
            rulesEnginePageObj.txtUpdateRawPremiumForPlatinum().sendKeys(value);
        }
        else if(product.equalsIgnoreCase("Black")) {
            rulesEnginePageObj.txtUpdateRawPremiumForBlack().clear();
            rulesEnginePageObj.txtUpdateRawPremiumForBlack().sendKeys(value);
        }
        else if(product.equalsIgnoreCase("Silver")){
            rulesEnginePageObj.weddingCoverSilverAccount().clear();
            rulesEnginePageObj.weddingCoverSilverAccount().sendKeys(value);
        }
    }

    public void captureInvalidTripDestinationFromRulesEngine(){
        leftNavPaneObj.leadManager().click();
        rulesEnginePageObj.rulesEngineTab().click();
        nextEventPageObj.waitForMoreTime();
        rulesEnginePageObj.autoAdjudicationTab().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        commonPageObj.switchToFrameById(commonPageObj.fancyFrame());
        rulesEnginePageObj.selectChangeSetButton().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        rulesEnginePageObj.customerValidationActionbtn().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        rulesEnginePageObj.destinationbtn().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        rulesEnginePageObj.enterValuesInGridBtn().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        destinationRetrievedFromRulesEngine=rulesEnginePageObj.invalidDestination().getText().split("=")[1].trim();
        System.out.println("Destination retrieved" +destinationRetrievedFromRulesEngine);
        nextEventPageObj.switchToDefault();
        Actions action = new Actions(getDriver);
        action.moveToElement(rulesEnginePageObj.closeRulesEngineFrameBtn()).click(rulesEnginePageObj.closeRulesEngineFrameBtn()).build().perform();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
    }
}




