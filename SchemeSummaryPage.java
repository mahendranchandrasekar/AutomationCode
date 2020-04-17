package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class SchemeSummaryPage extends AbstractPage {

    public WebElement saveAndCloseBtn() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id='btnSaveAndClose']"));
    }

    public WebElement insertRecordFromResourceListBtn() {
        return waitForElementPresent(By.xpath("//*[@id='301535_searchButton']"));
    }

    public WebElement insertRecordFromPricingTab() {
        return waitForElementPresent(By.xpath("//input[contains(@value,'Insert')]"));
    }

    public WebElement insertRecordFromCoverTermTab() {
        return waitForElementPresent(By.xpath("(//input[contains(@value,'Insert')])[3]"));
    }

    public WebElement selectUpgradeDefination(String strValue) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + strValue + "')]/../td/a"));
    }

    public WebElement lowerLimit() {
        return waitForElementPresent(By.xpath("//*[@id='Rad301535_ctl01_ctl04_txt301547']"));
    }

    public WebElement upperLimit() {
        return waitForElementPresent(By.xpath("//*[@id='Rad301535_ctl01_ctl04_txt301548']"));
    }

    public WebElement ageLimit() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Age Limit')]/../../../following-sibling::tbody/tr/td[5]/span/input[1]"));
    }


    public WebElement limitTypeImg() {
        return waitForElementPresent(By.xpath("(//span[contains(text(),'Type')])[2]/../../../following-sibling::tbody/tr/td[4]/div/div/img"));
    }


    public WebElement startDate() {
        return waitForElementPresent(By.xpath("//*[@id='Rad301535_ctl01_ctl04_rdp301529_dateInput_text']"));
    }

    public WebElement endDate() {
        return waitForElementPresent(By.xpath("//*[@id='Rad301535_ctl01_ctl04_rdp301530_dateInput_text']"));
    }


    public WebElement updateBtn() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Update')]"));
    }

    public WebElement editBtn() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Edit')]"));
    }

    public WebElement limitAndAccessTab() {
        return waitForElementPresent(By.xpath("//*[@id=\"tsPages_tab26337\"]/span/span"));
    }

    public WebElement productType() {
        return waitForElementPresent(By.xpath("//span[text()='Type']"));
    }

    public WebElement claimId1InPolicyView(String claimID1) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims']/tbody/tr[3]/td[contains(text(),'"+claimID1 +"')]"));
    }
    public WebElement claimId1Click(String claimID1){
        return waitForElementPresent(org.openqa.selenium.By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims']/tbody/tr[3]/td[contains(text(),'"+claimID1 +"')]/../td/a"));
    }

    public WebElement claimLeadID1(){
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[@id='ucDetailValueHeader_divRow1']/div[2]/span"));
    }
    public WebElement claimLeadIDInNextTask(){
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_WorkflowTaskPane_lblLead"));
    }

    public WebElement claimId2InPolicyView(String claimID2) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims']/tbody/tr[2]/td[contains(text(),'"+claimID2 +"')]"));
    }
    public WebElement claimId2Click(String claimID2){
        return waitForElementPresent(org.openqa.selenium.By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims']/tbody/tr[2]/td[contains(text(),'"+claimID2 +"')]/../td/a/img"));
    }
    public WebElement filterByPolicytypeDropdown() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//select[contains(@id,'ddlLeadType')]"));
    }

    public WebElement account() {
        return waitForElementPresent(By.xpath("//*[@id=\"tbl301058\"]/tbody/tr[1]/td/span"));
    }

    public WebElement dateFrom() {
        return waitForElementPresent(By.xpath("//span[text()='Date From']"));
    }

    public WebElement dateTo() {

        return waitForElementPresent(By.xpath("//span[text()='Date To']"));

    }

    public WebElement editFirstScheme() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("(//table[contains(@id,'MatterList_rgMatterHeaders_ctl01')]/tbody/tr/td[2]/a)[1]"));
    }

    public WebElement limitexcessTab() {
        return waitForElementPresent(By.xpath("//div[@id='holder']/div[@id='tsPages']/div/ul/li[2]/a"));
    }

    public WebElement internalTab() {
        return waitForElementPresent(By.xpath("//*[@id=\"tsPages_tab26320\"]"));
    }


    public WebElement insertepolicylimit() {
        return waitForElementPresent(By.id("301055_searchButton"));
    }

    public WebElement cause() {
        return waitForElementPresent(By.id("Rad301055_ctl01_ctl04_ddl301049_Input"));
    }

    public WebElement subcause() {
        return waitForElementPresent(By.id("Rad301055_ctl01_ctl04_ddl301050_Input"));
    }

    public WebElement claimdetail1() {
        return waitForElementPresent(By.id("Rad301055_ctl01_ctl04_ddl301051_Input"));
    }

    public WebElement claimdetail2() {
        return waitForElementPresent(By.id("Rad301055_ctl01_ctl04_ddl301052_Input"));
    }

    public WebElement application() {
        return waitForElementPresent(By.id("Rad301055_ctl01_ctl04_ddl301054_Input"));
    }

    public WebElement accountselection() {
        return waitForElementPresent(By.xpath("//*[contains(@title,'Select Resource')]"));
    }

    public WebElement accountselection_Details(String cover) {
        System.out.println("//td[contains(text(),'" + cover + "')]/../td/a");
        return waitForElementVisible(By.xpath("//td[contains(text(),'" + cover + "')]/../td/a"));

    }

    public WebElement basecover() {
        return waitForElementVisible(By.xpath(".//*[@id='tbl301059']/descendant::input[contains(@id,'searchButton')]"));
    }

    public WebElement basecover_selection() {
        return waitForElementVisible(By.xpath(".//*[@id='detailFieldRadGrid_ctl01']/tbody/descendant::a[1]"));
    }

    public WebElement insertRecord() {
        return waitForElementPresent(By.xpath("//input[@value='Insert Record']"));
    }


    public WebElement Update() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Update')]"));
    }

    public WebElement saveAndClose() {
        return waitForElementPresent(By.id("btnSaveAndClose"));
    }

//    public WebElement save() {
//        return waitForElementPresent(By.id("btnSave"));
//    }


    public WebElement endorsementUpdate(String subPeril) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + subPeril + "')]/following-sibling::td/a[text()='Update']"));
    }

    public WebElement endrosementInstanceFromDate(String subPeril) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + subPeril + "')]/following-sibling::td/div//input[contains(@id,'dateInput_text')][1]"));
    }

    public WebElement endrosementInstanceToDate(String subPeril) {
        return waitForElementPresent(By.xpath("(//td[contains(text(),'" + subPeril + "')]/following-sibling::td/div//input[contains(@id,'dateInput_text')])[2]"));
    }

    public WebElement endrosementReviewDate(String subPeril) {
        return waitForElementPresent(By.xpath("(//td[contains(text(),'" + subPeril + "')]/following-sibling::td/div//input[contains(@id,'dateInput_text')])[3]"));
    }

    public WebElement endrosementApplyInScheme(String subPeril) {
        return waitForElementPresent(By.xpath("(//td[contains(text(),'" + subPeril + "')]/following-sibling::td/div//input[contains(@id,'dateInput_text')])[3]/../../../following-sibling::td/input"));
    }

    public WebElement endrosementEdit(String subPeril) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + subPeril + "')]/following-sibling::td/a[contains(text(),'Edit')]"));
    }

    public WebElement editSpecificScheme() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Silver Cover')]/preceding-sibling::td/a"));
    }

    public WebElement productDescription() {
        return waitForElementPresent(By.xpath("//span[text()='Description']"));
    }

    public WebElement code() {
        return waitForElementPresent(By.xpath("//*[@id=\"tbl300929_301059\"]/tbody/tr/td[1]"));
    }

    public WebElement brand() {
        return waitForElementPresent(By.xpath("//*[@id=\"tbl300928_301059\"]/tbody/tr/td[1]"));
    }

    public WebElement productCode() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'UIS Code')]"));
    }


    public WebElement name() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Name')]"));
    }

    public WebElement tabCoverTerms() {
        return waitForElementPresent(By.xpath("//a[@id='tsPages_tab26337']/span/span"));
    }

    public WebElement verifyFields(String validateFeild) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + validateFeild + "')]"));
    }

//    public WebElement btnCloseWindow() {
//        return waitForElementPresent(By.id("btnClose"));
//    }

    public WebElement proRateable() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'chk')]"));
    }

    public WebElement pricingTableId() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Table ID')]/../../../following-sibling::tbody/tr/td[4]/input"));
    }

    public WebElement tabPricing() {
        return waitForElementPresent(By.xpath("//*[@id='tsPages_tab26429']/span/span"));
    }

    public WebElement linkEditPricing() {
        return waitForElementPresent(By.xpath("(//*[text()='Edit'])[1]"));
    }

    public WebElement lnkUpdatePricing(int i) {
        return waitForElementPresent(By.id("Rad301874_ctl01_ctl0" + i + "_UpdateButton"));
    }

    public WebElement txtStartDate() {
        return waitForElementToBeClickableAndReturnElement(By.id("Rad301874_ctl01_ctl05_rdp301853_dateInput_text"));
    }

    public WebElement txtEndDate() {
        return waitForElementToBeClickableAndReturnElement(By.id("Rad301874_ctl01_ctl04_rdp301854_dateInput_text"));
    }

    public WebElement productDetailsVerification(String searchfield) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + searchfield + "')]"));
    }

    public WebElement upgradeTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Upgrades')]"));
    }

    public WebElement pricingTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Pricing')]"));
    }

    public WebElement upgradeDetailsVerification(String searchfield) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + searchfield + "')]"));
    }

    public WebElement upgradeDetailsTableRowID(String searchfield) {
        return waitForElementPresent(By.xpath("//th[contains(text(),'" + searchfield + "')]"));
    }


    public WebElement txtAAPDays() {
        return waitForElementPresent(By.id("txt301954"));
    }

    public WebElement txtAAPDays_Brand() {
        return waitForElementPresent(By.id("int301953_text"));
    }

//    public WebElement lnkBrandDetails() {
//        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnLeadDetails"));
//    }


    public WebElement specificCover(String cover) {
        return waitForElementPresent(By.xpath("//td[text()='" + cover + "']/preceding-sibling::td/a"));
    }


    public WebElement specificScheme(String cover) { //@reg
        return  waitForElementPresent(org.openqa.selenium.By.xpath("//*[contains(text(),'"+cover+"')]/..//a"));
    }

    public String specificSchemexpath(String cover) { //@reg
        return "(//*[contains(text(),'" + cover + "')]/..//a)[1]";
    }

    public WebElement lnkEditCancellation() {
        return waitForElementPresent(By.xpath("//*[@id='tbl301055']//td[text()='Cancellation']/following-sibling::td[6]/a"));
    }

    public WebElement txtAmtCancellation() {
        return waitForElementPresent(By.id("Rad301055_ctl01_ctl04_flt301053_text"));
    }

    public WebElement lnkUpdateCancellation() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Update')]"));
    }

    public WebElement deatilsOfWhen() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'When')]/../../following-sibling::tbody/tr/td[2]"));
    }

    public WebElement deatilsOfWho() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Who')]/../../following-sibling::tbody/tr/td[3]"));
    }

    public WebElement coverTermsTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Cover Terms')]"));
    }

    public WebElement limitTypeSelection(String searchValue) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + searchValue + "')]"));
    }

    public WebElement startDateTxt() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Table ID')]/../../../following-sibling::tbody/tr/td[5]//span/input"));
    }


    public WebElement initialRulesSetIdUnderPricingInScheme() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Table ID')]/../../../following-sibling::tbody/tr[1]/td[4]"));
    }

    public WebElement navigateToPolicyInDashBorad(String policy) {
        return waitForElementPresent(By.xpath("//a[contains(text(),'" + policy + "')]"));
    }

    public WebElement addSchemebtn(){
        return waitForElementPresent(By.xpath("//input[@value='Add Scheme']"));
    }
    public String addSchemebtnVisibility(){
        return "//input[@value='Add Scheme']";
    }
    public WebElement editCreatedScheme(String retrievedSchemeID){
        return waitForElementPresent(By.xpath("//td[contains(text(),'"+retrievedSchemeID+"')]/preceding-sibling::td[1]/a/img"));
    }


    public WebElement addCover(){
        return waitForElementPresent(By.xpath("//input[@title='Select Resource']"));
    }
    public WebElement selectCover(String cover){
        return waitForElementPresent(By.xpath("//td[contains(text(),'"+cover+"')]/preceding-sibling::td/a[contains(text(),'Select')]"));
    }
    public WebElement dateFromtextbox(){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Date From')]/../following-sibling::td//span/input[1]"));
    }
    public WebElement dateTotextbox(){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Date To')]/../following-sibling::td//span/input[1]"));
    }
    public WebElement retrieveSchemeID(){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Scheme ID')]/../following-sibling::div/span"));
    }
    public WebElement covertermsTab(){
        return waitForElementPresent(By.xpath("//span[text()='Cover Terms']"));
    }

    public WebElement insertRecord_InsuredPersons(){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Insured Persons')]/../../following-sibling::tr[2]/td/input[contains(@value,'Insert Record')]"));
    }

    public WebElement insuredPersonsTypedropdownImg(){
        return waitForElementPresent(By.xpath("//a[contains(text(),'Update')]/../preceding-sibling::td[4]/div/div/img"));
    }
    public WebElement insuredPersonsType(String type){
        return waitForElementPresent(By.xpath("//div[contains(text(),'"+type+"')]"));
    }
    public WebElement residencyRestrictiondropdownImg(){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Residency Requirement')]/../following-sibling::td/div/div"));
    }
    public WebElement residencyRequirementDropdownValues(String fieldValue){
        return waitForElementPresent(By.xpath("//div[contains(text(),'"+fieldValue+"')]"));
    }
    public WebElement ageLimitInputbox(){
        return waitForElementPresent(By.xpath("//a[contains(text(),'Update')]/../preceding-sibling::td[3]/span/input[1]"));
    }
    public WebElement fullTimeEducationChkbox(){
        return waitForElementPresent(By.xpath("//a[contains(text(),'Update')]/../preceding-sibling::td[2]/input[1]"));
    }
    public WebElement independentTravelChkbox(){
        return waitForElementPresent(By.xpath("//a[contains(text(),'Update')]/../preceding-sibling::td[1]/input[1]"));
    }

    public WebElement updatebtnInsuredPersons(){
        return waitForElementPresent(By.xpath("//a[contains(text(),'Update')]"));
    }
    public WebElement tripLengthInputBox(String searchField){
        return waitForElementPresent(By.xpath("//span[contains(text(),'"+searchField+"')]/../following-sibling::td/span/input"));
    }
    public WebElement insertRecord_geographicalLimit(){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Geographical Limit')]/../../following-sibling::tr[2]/td/input[contains(@value,'Insert Record')]"));
    }
    public WebElement geographicalLimitdropdownImg(){
        return waitForElementPresent(By.xpath("//a[contains(text(),'Update')]/../preceding-sibling::td[1]/div/div/img"));
    }
    public WebElement geographicalLimitdropDownValues(String region){
        return waitForElementPresent(By.xpath("//div[contains(text(),'"+region+"')]"));
    }
    public WebElement amend_InsuredPersons(){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Insured Persons')]/../../following-sibling::tr[1]//table/tbody/tr[1]/td/a[contains(text(),'Edit')]"));
    }
    public WebElement amend_GeographicalLimit(){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Geographical Limit')]/../../following-sibling::tr[1]//table/tbody/tr[1]/td/a[contains(text(),'Edit')]"));
    }
    public WebElement selectBlackCoverScheme(String scheme){
        return waitForElementPresent(By.xpath("//td[contains(text(),'"+scheme+"')]/../td/a/img"));
    }
    public WebElement upgradeTabInScheme(){
        return waitForElementPresent(By.xpath("//span[text()='Upgrades']"));
    }
    public WebElement toValidateUpgradeAvailability(String upgrade){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Upgrades Available')]/../../following-sibling::tr//table/tbody/tr/td[text()='"+upgrade+"']"));
    }
    public String validityOfBlackCoverScheme(String scheme){
        return "//td[contains(text(),'"+scheme+"')]/../td/a/img";
    }
    public String validateUpgradeNonAvailability(String upgrade){
        return "//span[contains(text(),'Upgrades Available')]/../../following-sibling::tr//table/tbody/tr/td[text()='"+upgrade+"']";
    }

    public WebElement causeExcess() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//table[@id = 'Rad301056_ctl01']//tr[2]/td[4]/input"));
    }

    public WebElement causeExcessFilter() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//table[@id = 'Rad301056_ctl01']//tr[2]/td[4]/img"));
    }

    public WebElement containsFilter() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//td[contains(text(),'Contains')]"));
    }

    public WebElement subCauseExcess() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//table[@id = 'Rad301056_ctl01']//tr[2]/td[5]/input"));
    }
    public WebElement subCauseExcessFilter() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//table[@id = 'Rad301056_ctl01']//tr[2]/td[5]/img"));
    }

    public WebElement claimDetail1Excess() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//table[@id = 'Rad301056_ctl01']//tr[2]/td[6]/input"));
    }
    public WebElement claimDetail11Filter() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//table[@id = 'Rad301056_ctl01']//tr[2]/td[6]/img"));
    }
    public WebElement claimDetail2Excess() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//table[@id = 'Rad301056_ctl01']//tr[2]/td[7]/input"));
    }
    public WebElement claimDetail21Filter() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//table[@id = 'Rad301056_ctl01']//tr[2]/td[7]/img"));
    }

    public WebElement specificQuote(String cover) { //@reg
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+cover+"')]/preceding-sibling::td[3]//a"));
    }

    public WebElement specificTravelSchemexpath(String cover) { //@reg
        return waitForElementPresent(By.xpath("(//*[contains(text(),'" + cover + "')]/..//a)[1]"));
    }


    public WebElement companyNameTextBox() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_TabContainer1_tabSearchName_txtCompanyName"));

    }
}
