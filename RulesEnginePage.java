package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RulesEnginePage extends AbstractPage {

    public WebElement rulesEngineTab() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'RULESENGINE')]"));
    }

    public WebElement tabToSelectUnderRulesEngine(String tabToSelectUnderRulesEngine) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + tabToSelectUnderRulesEngine + "')]"));
    }

    public WebElement selectUpgrades(String upgrade) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + upgrade + "')]//following-sibling::td[5]/a[@title='Select']"));
    }

    public WebElement testNowLink() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[contains(text(),'Test Now')]"));
    }

    public WebElement testNowBtn() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Test Now')]"));
    }

    public WebElement upgradesPremiumValue(String upgrades) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + upgrades + "')]/following-sibling::td[4]"));
    }

    public WebElement closeRulesWindow() {
        return waitForElementPresent(By.className("fancybox-button fancybox-button--close"));
    }

    public WebElement btnEnterGridValues() {
        return waitForExpectedElement(By.xpath("//a[contains(text(),'Enter Values in Grid')]"), 5);
    }

    public WebElement btnApply() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//button[contains(text(),'Apply')]"));
    }

    public WebElement txtGridValue() {
        return waitForElementPresent(By.xpath("(//input[@class='form-control ng-pristine ng-valid ng-valid-required'])[2]"));
    }

    public WebElement txtmedicalPremium() {
        return waitForElementPresent(By.xpath("//tr[8]/td[1]/form/input[2][@class='form-control ng-pristine ng-valid ng-valid-required']"));
    }

    public WebElement selectRules(String rules) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + rules + "')]//following-sibling::td/a[@title='Select']"));
    }

    public WebElement selectRulesBySetID(String setID) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + setID + "')]//following-sibling::td/a[@title='Select']"));
    }

    public WebElement baggageCostValueUpdateInput() {
        return waitForElementPresent(By.xpath("//label[contains(text(),'Value')]/following-sibling::input"));
    }

    public WebElement editExsistingRuleForBaggaeAmount() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Greater Than')]/following-sibling::td/button[@title='Edit']"));
    }

    public WebElement saveUpdatesRulesBtn() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Save')]"));
    }

    public WebElement closeRulesEngineFrameBtn() {
        return waitForElementPresent(By.xpath("//*[@title='Close']"));
    }

    public WebElement ruleSetIdOfUpgrade(String upgrade) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + upgrade + "')]//preceding-sibling::td"));
    }

    public WebElement enterValuesInGridBtn() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Grid')]"));
    }

    public WebElement saveOutputBtn() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Save Outputs')]"));
    }

    public WebElement weddingCoverSilverAccount() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Policy: Account Type Starts With')]/../td//input[2])[1]"));
    }

    public WebElement CancellationCoverPlatinumAccount() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Policy: Account Type Starts With')]/../../following-sibling::tbody//td//input[2])[2]"));
    }


    public WebElement selectRulesByCover(String rules) {
        return waitForElementPresent(By.xpath("//td[text()='" + rules + "']//following-sibling::td/a[@title='Select']"));
    }

    public WebElement selectSetByRules() {

        return waitForElementPresent(By.xpath("//a[contains(@class,'btn-success')]"));
    }


    public WebElement retrieveMedicalCoverValueForPlatinumAccount(String ruleSet) {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'" + ruleSet + "')]/../td[2]//input[2])[1]"));
    }

    public WebElement retrieveCoverValueForPlatinumAccount() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Policy: Account Type Starts With')])[2]/following-sibling::td[1]/form/input[2]"));
    }

    public WebElement navigateToPremiumCalculation() {
        return waitForElementPresent(By.linkText("Premium Calculation"));
    }

    public WebElement retrievePremiumValueForUpgradeInschemeSummary(String cover) {
        return waitForElementPresent(By.xpath("//a[contains(text(),'" + cover + "')]/../following-sibling::td[7]"));
    }

    public WebElement retrievePremiumValueForPlatinumAccount(int length) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Platinum')]//following-sibling::td[" + length + "]//input[2]"));
    }

    public WebElement retrieveCoverValueForBlackAccount(int length) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Black')]//following-sibling::td[" + length + "]//input[2]"));
    }


    public WebElement selectAgeUpgradeForGivenYearsAndAccount(String cover, int tdCount) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + cover + "')]//following-sibling::td[" + tdCount + "]//input[2]"));
    }

    public WebElement selecAnnualUpgradePremiumForGivenAccount(String account) {
        return waitForElementPresent(By.xpath("//th[contains(text(),'" + account + "')]/../td[1]//input[2]"));
    }

    public WebElement getPremiumForGuest(String noOfDaysComparision, String destination, String winterSport, int noOfDays, String account) {
        return waitForElementPresent(By.xpath("//h5/span[contains(text(),'" + destination + "')]/following-sibling::span[contains(text(),'Winter Sports = " + winterSport + "')]/following-sibling::span[contains(text(),'" + account + "')]/../following-sibling::table//th[contains(text(),'" + noOfDaysComparision + "')]/following-sibling::td[" + noOfDays + "]//input[2]"));
    }


    public WebElement selectAmountForAccount(String amount, String tdVal, String account) {
        return waitForElementPresent(By.xpath("//th[contains(text(),'"+amount+"')]/../../following-sibling::tbody//th[contains(text(),'"+account+"')]/following-sibling::td["+tdVal+"]//input[2]"));
    }

    public WebElement btnSelect() {
        return waitForElementPresent(By.xpath("//a[@title='Select']"));
    }

    public WebElement txtCaptureRawPremium(String product) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + product + "')]/../td//input[2]"));
    }

    public WebElement selectChangeSetButton() {
        return waitForElementPresent(By.xpath("//*[contains(@class,'rule-enabled')]/../..//a[@class='btn btn-success']"));
    }

    public WebElement txtUpdateRawPremiumForPlatinum() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Policy: Account Type Starts With')]/../td//input[2])[2]"));
    }

    public WebElement txtUpdateRawPremiumForBlack() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Policy: Account Type Starts With')]/../td//input[2])[3]"));
    }

    public WebElement autoAdjudicationTab() {
        return waitForElementPresent(By.id("ctl00_rpbMenu_RULESENGINE_PI0_Text"));
    }

    public WebElement customerValidationActionbtn() {
        return waitForElementPresent(By.xpath("//td[text()='Customer Validation']/..//a[@class='btn btn-success']"));
    }

    public WebElement destinationbtn() {
        return waitForElementPresent(By.xpath("//td[text()='Destination']/..//a[@class='btn btn-success']"));
    }

    public WebElement invalidDestination() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Trip Destination')]"));
    }

    public String retrieveDaysValueXpath() {
        return "//*[contains(text(),'InsuredPerson: Trip Length = ')]";
    }
}
