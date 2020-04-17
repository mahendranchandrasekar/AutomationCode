package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class PolicyDataFieldsPage extends AbstractPage {

    public WebElement policyIDLabelValue() {
        return waitForElementPresent(By.id("ucDetailValueHeader_lblIdentityInformation"));
    }

//    public WebElement closeButton() {
//        return waitForElementPresent(By.id("btnClose"));
//    }

    public WebElement title() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_ddlTitle"));
    }

    public WebElement firstName() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_tbFirstName"));
    }

    public WebElement lastName() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_tbLastName"));
    }

    public WebElement emailId() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_tbEmail"));
    }

    public WebElement addressLine1() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_tbAddress1"));
    }

    public WebElement addressLine2() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_tbAddress2"));
    }

    public WebElement town() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_tbTown"));
    }

    public WebElement county() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_tbCounty"));
    }

    public WebElement postCode() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_tbPostCode"));
    }

    public WebElement postCodeDropdown() {
        return waitForElementPresent(By.id("ddlEventToAdd"));
    }

    public WebElement mobileNo() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_tbMobileTel"));
    }

    public WebElement dateOfBirth() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_rdpDateOfBirth_dateInput_text"));
    }

    public WebElement dob() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_rdpDateOfBirth_dateInput"));
    }

    public WebElement policyHolderDob() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//tr[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl01_gridRow']/td[6]"));
    }

    public WebElement acceptTAndC() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_chkTerms"));
    }


    public WebElement updateCustomer() {
        return waitForElementPresent(By.xpath("//input[@name='ctl00$cphBodyWithoutUpdatePanel$cphBody$ucCustomerInfo1$btnUpdateCustomer']"));
    }
    public String updateCustomerId() {
        return "ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_btnUpdateCustomer";
    }

    public WebElement moreDetails() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_btnCustomerDF"));
    }

    public boolean moreDetailsDisplayed() {
        return elementDisplayed(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_btnCustomerDF"));
    }


    public WebElement saveCust() {
        return waitForElementPresent(By.xpath("//input[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_btnSaveNewLead']"));
    }

    public WebElement clickToView() {
        return waitForElementPresent(By.xpath("//a[text()='Click here to view it']"));
    }


    public WebElement clickAccount() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_300921_searchButton"));
    }

    public WebElement selectAccount(String accountType, String brandName) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//td[contains(text(),'" + brandName + "')]/..//td[contains(text(),'" + accountType + "')]/..//a[text()='Select']"));
    }

    public WebElement clickCover() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//input[contains(@id,'ucMandatoryFieldEditor_300930_searchButton')]"));
    }

    public WebElement selectCoverDescFilterTextBox() {
        return waitForElementPresent(By.name("detailFieldRadGrid$ctl01$ctl02$ctl02$ctl08"));
    }

    public WebElement selectCoverDescFilterImg() {
        return waitForElementPresent(By.xpath("//input[@name='detailFieldRadGrid$ctl01$ctl02$ctl02$ctl08']/../img"));
    }

    public WebElement containsFilter() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Contains')]"));
    }

    public WebElement selectCover(String coverType) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + coverType + "')]/..//a[text()='Select']"));
    }

    public WebElement policySave() {

        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id='ucMandatoryFieldEditor_btnSave']"));

    }

    public WebElement Savepolicy() {

        return waitForElementToBeClickableAndReturnElement(By.xpath("//input[@value='Save']"));

    }

    public WebElement clickOnBack() {
        return waitForElementPresent(By.xpath("//*[@id='btnBack']"));
    }

    public WebElement clickOnCancel() {
        return waitForElementPresent(By.xpath("//*[@id='ucMandatoryFieldEditor_btnCloseBasicTableEdit']"));
    }

    public WebElement jointAccountErrorMessage() {
        return waitForElementPresent(By.xpath("//span[@id='errorMessage']"));
    }

    public WebElement newProductClose() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_btnClose"));
    }


    public WebElement policyFrame() {
        return waitForElementPresent(By.id("RadWindowContentFrameucMandatoryFieldEditor_RadWindowManager1_PagesDialogWindow"));
    }

    public WebElement policyType() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//select[contains(@id,'ddlLeadType')]"));
    }

    public WebElement businessName() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtBusinessName"));
    }

    public WebElement businessAddress1() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtBusinessAddress1"));
    }

    public WebElement businessAddress2() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtBusinessAddress2"));
    }

    public WebElement businessTown() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtBusinessTown"));
    }

    public WebElement businessCounty() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtBusinessCounty"));
    }

    public WebElement businessPostcode() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtBusinessPostcode"));
    }

    public WebElement businessEmail() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtBusinessEmail"));
    }

    public WebElement businessPhone() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtBusinessTelephone"));
    }

    public WebElement advancedSearch() {
        return waitForElementPresent(By.linkText("Advanced search"));
    }

    public WebElement filterByPolicy() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ddlLeadType"));
    }

    public WebElement searchByID() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Search by ID')]"));
    }

    public WebElement policySearchbtn() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_TabContainer1_tabSearchID_btnSearchID"));
    }

    public WebElement selectPolicy() {
        return waitForElementVisible(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_tabResults_tpnlResults1_rgCustomers_ctl01_ctl04_ViewLink\"]/img"));
    }

    public WebElement morelinkforclaimcreation() {
        return waitForElementPresent(By.xpath("//a[contains(@id,'lnkClaim')]"));
    }

    public WebElement update() {
        return waitForElementPresent(By.linkText("Update"));
    }

    public WebElement edit() {
        return waitForElementPresent(By.linkText("Edit"));
    }

    public WebElement schemeid() {
        return waitForElementPresent(By.xpath("//*[@id=\"ucDetailValueHeader_lblIdentityInformation\"]"));
    }

    public WebElement saveandclose() {
        return waitForElementToBeClickableAndReturnElement(By.id("btnSaveAndClose"));
    }

    public WebElement navigateToBasePolicy() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Base Policy')]/../following-sibling::tr/td/a[contains(text(),'select')]"));
    }


    public WebElement schemeidsaveandclose() {
        return waitForElementPresent(By.xpath("//*[@id=\"btnSaveAndClose\"]"));
    }

    public WebElement moredetails() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'btnCustomerDF')]"));
    }

    public WebElement selectscheme() {
        return waitForElementVisible(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_tabResults_tpnlResults1_rgCustomers_ctl01_ctl04_ViewLink\"]/img"));
    }

    public WebElement selectparticularscheme(String schemeId) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + schemeId + "')]/../td[2]/a"));
    }


    public WebElement searchbtn() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_TabContainer1_tabSearchName_btnSearchName"));
    }

    public WebElement searchscheme() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_TabContainer1_tabSearchID_btnSearchID"));
    }

    public WebElement searchscemebtn() {
        return waitForElementPresent(By.id("__tab_ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_TabContainer1_tabSearchID"));
    }

//    public WebElement closebtn() {
//        return waitForElementPresent(By.id("btnClose"));
//    }

    public WebElement addscheme() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_btnAddMatter"));
    }


    public WebElement supplierAddress1() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtBusinessAddress1')]"));
    }

    public WebElement supplierAddress2() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtBusinessAddress2')]"));
    }

    public WebElement supplierTown() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtBusinessTown')]"));
    }

    public WebElement supplierCounty() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtBusinessCounty')]"));
    }

    public WebElement supplierPostcode() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtBusinessPostcode')]"));
    }

    public WebElement supplierEmail() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtBusinessEmail')]"));
    }

    public WebElement supplierTelephone() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtBusinessTelephone')]"));
    }

    public WebElement supplierFax() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtBusinessFax')]"));
    }

    public WebElement updateBusinessBtn() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'btnSaveNewLead')]"));
    }

    public WebElement limitexcessTab() {
        return waitForElementPresent(By.xpath("//div[@id='holder']/div[@id='tsPages']/div/ul/li[2]/a"));
    }


    public WebElement cause() {
        return waitForElementPresent(By.xpath("//*[@id=\"Rad301055_ctl01\"]/thead/tr[1]/th[4]/span"));
    }

    public WebElement subcause() {
        return waitForElementPresent(By.xpath("//*[@id=\"Rad301055_ctl01\"]/thead/tr[1]/th[5]/span\n"));
    }

    public WebElement claimdetail_1() {
        return waitForElementPresent(By.xpath("//*[@id=\"Rad301055_ctl01\"]/thead/tr[1]/th[6]/span"));
    }

    public WebElement claimdetail2() {
        return waitForElementPresent(By.xpath("//*[@id=\"Rad301055_ctl01\"]/thead/tr[1]/th[7]"));
    }

//    public WebElement amount() {
//        return waitForElementPresent(By.xpath("//*[@id=\"Rad301055_ctl01_ctl04_flt301053_text\"]"));
//    }

    public WebElement internalTab() {
        return waitForElementPresent(By.xpath("//*[@id=\"tsPages_tab26320\"]"));
    }

//    public WebElement returnCause() {
//        return waitForElementPresent(By.xpath("//*[@id=\"Rad301055_ctl01_ctl04_ddl301049_Input\"]"));
//    }

    public WebElement returnCauseValue(String value) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + value + "')]"));
    }


    public WebElement returnCauseexcess() {
        return waitForElementPresent(By.xpath("//*[@id=\"Rad301056_ctl01_ctl04_ddl301079_Input\"]"));
    }

    public WebElement excessamount() {
        return waitForElementPresent(By.xpath("//*[@id=\"Rad301056_ctl01_ctl04_flt301081_text\"]"));
    }

    public WebElement filterByPolicytypeDropdown() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//select[contains(@id,'ddlLeadType')]"));
    }

    public WebElement returnsubCauseexcess() {
        return waitForElementPresent(By.xpath("//*[@id=\"Rad301056_ctl01_ctl04_ddl301080_Input\"]"));
    }

    public WebElement returnsubCauseValue(String value) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + value + "')]"));
    }

    public WebElement excessedit() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id=\"Rad301056_ctl01_ctl04_EditButton\"]"));
    }

    public WebElement editlimit() {
        return waitForElementPresent(By.xpath("//*[@id=\"Rad301055_ctl01_ctl04_EditButton\"]"));
    }

//    public WebElement returnsubCauslimits() {
//        return waitForElementPresent(By.xpath(" //*[@id=\"Rad301055_ctl01_ctl04_ddl301050_Input\"]"));
//    }

    public WebElement updateExcess() {
        return waitForElementPresent(By.id("Rad301056_ctl01_ctl04_UpdateButton"));
    }

    public WebElement claimitem1UnderLimitTable() {
        return waitForElementPresent(By.xpath("//input[@id='Rad301055_ctl01_ctl04_ddl301051_Input']"));
    }

    public WebElement claimitem2UnderLimitTable() {
        return waitForElementPresent(By.xpath("//input[@id=\"Rad301055_ctl01_ctl04_ddl301052_Input\"]"));
    }

    public WebElement applicableToOptionLimit() {
        return waitForElementPresent(By.xpath("//input[@id='Rad301055_ctl01_ctl04_ddl301054_Input']"));
    }

    public WebElement applicableToOptionExcess() {
        return waitForElementPresent(By.xpath("//input[@id='Rad301056_ctl01_ctl04_ddl301082_Input']"));
    }

    public WebElement createEventAndOpenToPrintBtn() {
        return waitForElementPresent(By.xpath("//input[@value='Create Event And Open To Print']"));
    }

    public String createEventAndOpenToPrintBtnXpath() {
        return "//input[@value='Create Event And Open To Print']";
    }

    public WebElement customerSpecificReqInput() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Customer Specific Requirements')]/../following-sibling::td/input"));
    }

    public WebElement chaseTitle() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Chase Title')]/..//following-sibling::td/input"));
    }

    public WebElement chaseText() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Chase Text')]/../following-sibling::td/textarea"));
    }

    public WebElement manualChaseRemainderSays() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Number of days until manual chase reminder')]/../following-sibling::td//input[1]"));
    }

    public WebElement automatedChaseBetweenDays() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Number of days between automated chase')]/../following-sibling::td//input[1]"));
    }

    public WebElement documentToResend() {
        return waitForElementPresent(By.xpath("//select[@class='ddlDocument']"));
    }

    public WebElement documentToResendOption() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Further Info Request')]"));
    }


    public WebElement confirmationDocRequestedByWhom(String event) {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'" + event + "')]/following-sibling::td[5]/span)[1]"));
    }

    public WebElement outOfProcessEvent() {
        return waitForElementToBeClickableAndReturnElement(org.openqa.selenium.By.xpath("//label[contains(text(),'Add an OutOfProcess Event')]/../input"));
    }

    public WebElement specific_claim_questions() {
        return waitForElementToBeClickableAndReturnElement(org.openqa.selenium.By.xpath("//label[contains(text(),'Claim Specific Questions')]/../input"));
    }

    public WebElement Return_Claim_to_Travel_Incident_Management() {
        return waitForElementToBeClickableAndReturnElement(org.openqa.selenium.By.xpath("//label[contains(text(),'Return Claim to Travel Incident Management')]/../input"));
    }


    public WebElement eventtypeDropdown() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//select[contains(@id,'ddlEventToAdd')]"));
    }

    public WebElement next() {
        return waitForElementPresent(By.id("btnNext"));
    }

    public WebElement finish() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[@id=\"btnFinish\"]"));
    }

    public WebElement amountset() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[@id=\"txtComments\"]"));
    }

    public WebElement caseid() {
        return waitForElementPresent(By.xpath("//*[@id=\"lblCaseID\"]"));
    }

    public WebElement claimcaseid() {
        return waitForElementPresent(By.xpath("//*[@id=\"lblCaseID\"]"));
    }

    public WebElement workflowcaseid() {
        return waitForElementPresent(By.xpath("(//table[contains(@id,'rgWorkflowTasks')]/tbody/tr/td/a[@title='Go to this lead and case'])[last()-2]"));
    }

    public String workflowcaseidXpath() {
        return "//table[contains(@id,'rgWorkflowTasks')]/tbody/tr/td[12]/a";
    }

    public WebElement returnclaimtotravelincident() {
        return waitForElementPresent(By.xpath("//*[@id=\"rgEventHistory_ctl01\"]/tbody/tr[2]/td[2]"));
    }

    public WebElement customervalidation() {
        return waitForElementPresent(By.xpath("//*[@id=\"rgEventHistory_ctl01\"]/tbody/tr[1]/td[2]"));
    }

    public WebElement showFullEventHistory() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucEventHistoryList_btnShowFullEventHistory"));
    }

    public WebElement windowclose() {
        return waitForElementPresent(By.xpath("//*[@id=\"btnCloseWindow\"]"));
    }

    public WebElement onhold() {
        return waitForElementPresent(By.xpath("//tr[2]/td[contains(text(),'On Hold')]"));
    }

    public String onholdXpath() {
        return "//tr[2]/td[contains(text(),'On Hold')]";
    }

    public WebElement open() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Open')]"));
    }

//    public WebElement savebutton() {
//        return waitForElementPresent(By.xpath("//*[@id='ucMandatoryFieldEditor_customFieldSaveButton']"));
//    }

    public WebElement cancelbutton() {
        return waitForElementVisible(By.xpath("//*[@id='btnCancel']"));
    }

    public WebElement endrosementFromDate(String peril) {
        return waitForElementPresent(By.xpath("//td[text()='" + peril + "']/following-sibling::td//input[contains(@id,'FromDate')]"));
    }

    public WebElement endrosementToDate(String peril) {
        return waitForElementPresent(By.xpath("//td[text()='" + peril + "']/following-sibling::td//input[contains(@id,'ToDate')]"));
    }

    public WebElement endrosementApply(String peril) {
        return waitForElementPresent(By.xpath("//td[text()='" + peril + "']/following-sibling::td//input[contains(@id,'Applied')]"));
    }

//    public WebElement save() {
//        return waitForElementPresent(By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
//    }

    public WebElement endorsementTab() {
        return waitForElementPresent(By.id("tsPages_tab26432"));
    }

    public WebElement jointAccount() {
        return waitForElementToBeClickableAndReturnElement(By.id("ucMandatoryFieldEditor_ddl301550_Input"));
    }

    public WebElement jointAccountOption(String jHOption) {
        return waitForElementPresent(By.xpath("//div[@id='ucMandatoryFieldEditor_ddl301550_DropDown']/div[contains(text(),'" + jHOption + "')]"));
    }

    public WebElement existingPackagedCust() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl301551_Input"));
    }

    public WebElement existingPackagedCustOption(String pCOption) {
        return waitForElementPresent(By.xpath("//div[@id='ucMandatoryFieldEditor_ddl301551_DropDown']/div[contains(text(),'" + pCOption + "')]"));
    }


    public WebElement tele1() {
        return waitForElementVisible(By.id("ucMandatoryFieldEditor_txt301554"));
    }

    public WebElement tele1Pref() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl301555_Input"));
    }

    public WebElement tele1PrefOption(String pCOption) {
        return waitForElementPresent(By.xpath("//div[@id='ucMandatoryFieldEditor_ddl301555_DropDown']/div[contains(text(),'" + pCOption + "')]"));
    }

    public WebElement tele2() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt301556"));
    }

    public WebElement tele2Pref() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl301557_Input"));
    }

    public WebElement tele2PrefOption(String pCOption) {
        return waitForElementPresent(By.xpath("//div[@id='ucMandatoryFieldEditor_ddl301557_DropDown']/div[contains(text(),'" + pCOption + "')]"));
    }

    public WebElement eMail() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk301894"));
    }

    public WebElement letter() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk301895"));
    }

    public WebElement phone() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk301955"));
    }

    public WebElement sms() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk301897"));
    }

    public WebElement marketingPreferenceImg() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Marketing Preference')]/../following-sibling::td/div//img"));
    }

    public WebElement marketingPreferencedropdown(String searchValue) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + searchValue + "')]"));
    }

    public WebElement addressLookUp() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_quickAddress_Address_301552_txtBuildingNumber"));
    }

    public WebElement postCodeLookup() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_quickAddress_Address_301552_txtPostcode"));
    }

    public WebElement findAddress() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_quickAddress_Address_301552_btnFindAddress"));
    }

    public WebElement accountNumber() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt301392"));
    }

    public WebElement sortCode() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt301393"));
    }

    public WebElement bankName() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl305126_Input"));
    }

    public WebElement bankNameOption(String strBankName) {
        return waitForElementPresent(By.xpath("//div[@id='ucMandatoryFieldEditor_ddl305126_DropDown']/div[contains(text(),'" + strBankName + "')]"));
    }

    public WebElement expiryDate() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt301395"));
    }

    public WebElement confirmationDocProducedByWhom(String event) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + event + "')]/../following-sibling::td[2]"));
    }

    public WebElement whoRequestTextBox() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Who Requested')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement additionalTextBox() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ucMandatoryFieldEditor_txt')]"));
    }


    public WebElement conFirmationLetter(String coverLetter) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("(//td[contains(text(),'" + coverLetter + "')]/following-sibling::td/div/input[contains(@id,'btnOpenDoc')])[1]"));
    }

    public WebElement stopChaseInput() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Stop chase')]/../following-sibling::td//input"));
    }

    public WebElement stopChaseInputYes() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//div[@class='ComboBoxItem_Default' and contains(text(),'Yes')]"));
    }

    public WebElement noCustomerExists() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//td[contains(text(),'No results to display')]"));
    }

    public String noCustomerExist() {
        return "//td[contains(text(),'No results to display')]";
    }


    public WebElement updateDetails_firstName() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtFirstName"));
    }

    public WebElement updateDetails_lastName() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtLastName"));
    }

    public WebElement updateDetails_emailId() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtEmailAddress"));
    }

    public WebElement updateDetails_addressLine1() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtAddress1"));
    }

    public WebElement updateDetails_addressLine2() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtAddress2"));
    }

    public WebElement updateDetails_town() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtTown"));
    }

    public WebElement updateDetails_county() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtCounty"));
    }

    public WebElement updateDetails_postCode() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtPostcode"));
    }

    public WebElement updateDetails_mobileNo() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtMobilePhone"));
    }

    public WebElement updateDetails_dateOfBirth() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtDateOfBirth"));
    }

    public WebElement updateDetails_commPreferenceEmail() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_chk301894"));
    }

    public WebElement insertBtn() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//input[contains(@value,'Insert')]"));
    }

    public WebElement add_PersonType() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Person Type')]/../following-sibling::div[1]/select"));
    }

    public WebElement add_Title() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Title')]/../following-sibling::div[1]/select"));
    }

    public WebElement add_FirstName() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'First Name')]/../following-sibling::div[1]/input"));
    }

    public WebElement add_LastName() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Last Name')]/../following-sibling::div[1]/input"));
    }

    public WebElement add_DateOfBirth() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Date of Birth')]/../following-sibling::div[1]/input"));
    }

    public WebElement addSub_DateOfBirth() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Date of birth:')]/../following-sibling::div[1]/input"));
    }

    public WebElement add_CurrentCovered() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Currently Covered')]/../following-sibling::div[1]/input"));
    }

    public WebElement add_EffectiveFromDate() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Effective From Date')]/../following-sibling::div[1]/input"));
    }

    public WebElement addInsuredPerson_SaveBtn() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_btnSaveBasicTableEdit"));
    }

    public WebElement updatedInsuredPersonDetails(String personDetail) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + personDetail + "')]"));
    }

    public String updatedInsuredPersonDetailsXpath(String personDetail) {
        return "//td[contains(text(),'" + personDetail + "')]";
    }


    public WebElement editCustomer(String personDetails) {
        return waitForElementPresent(By.xpath("(//td[contains(text(),'" + personDetails + "')]/following-sibling::td/a[text()='Edit'])[1]"));
    }

    public WebElement deleteCustomer(String personDetails) {
        return waitForElementPresent(By.xpath("(//td[contains(text(),'" + personDetails + "')]/following-sibling::td/a[text()='Delete'])[1]"));
    }

    public WebElement editMainAccountHolder() {
        return waitForElementPresent(By.xpath("(//td[contains(text(),'Main Account Holder')]/following-sibling::td/a[text()='Edit'])[1]"));
    }

    public WebElement deceasedCustomerChkBox() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_df_302132_0_0_0_0_DVID_775624"));
    }


    public WebElement warningmessageValidation() {
        return waitForElementPresent(By.xpath("Dummy xpath"));
    }

    public WebElement add_EffectiveFromDatePicker() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Effective From Date')]/../following-sibling::div[1]/img"));
    }

    public WebElement add_EffectiveFromDatePicker_Prev() {
        return waitForElementPresent(By.xpath("//a[@title='Prev']"));
    }

    public WebElement add_EffectiveFromDatePicker_Next() {
        return waitForElementPresent(By.xpath("//a[@title='Next']"));
    }

    public WebElement add_EffectiveFromDate1() {
        return waitForElementPresent(By.xpath("//a[text()='1' and @class='ui-state-default']"));
    }

    public WebElement chkBk_Deceased() {
        return waitForElementPresent(By.xpath("//div/input[starts-with(@id,'ucMandatoryFieldEditor_df_302132_0_0_0_0_DVID')]"));
    }

    public WebElement drpdnMarketingPref() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl301553_Input"));

    }

    public WebElement noMarketingPref() {

        return waitForElementPresent(By.xpath("//div[@id='ucMandatoryFieldEditor_ddl301553_c2']"));
    }

    public WebElement txtWhoRequested() {
        return waitForElementPresent(By.xpath("//td/input[starts-with(@id,'ucMandatoryFieldEditor_txt302017')]"));
    }

//    public WebElement btnCancel() {
//        return waitForElementPresent(By.id("ctl00_cphBody_btnCancel"));
//    }

    public WebElement editorCoverLetter() {
        return waitForElementPresent(By.id("ctl00_cphBody_divRadEditor"));
    }

    public WebElement btnCreateEventPrintLtr() {
        return waitForElementPresent(By.id("ctl00_cphBody_btnSavePrintQueue"));
    }
    //

    public WebElement executorTitle() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl302240_Input"));
    }

    public WebElement drpdnTitle(String title) {
        return waitForElementPresent(By.xpath("//div[starts-with(@id,'ucMandatoryFieldEditor') and contains(text(),'" + title + "')]"));
    }

    public WebElement txtFirstname() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt302241"));
    }

    public WebElement txtLastname() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt302242"));
    }

    public WebElement txtAddress1() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt302243"));
    }

    public WebElement txtAddress2() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt302244"));
    }

    public WebElement txtTown() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt302245"));
    }

    public WebElement txtCounty() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt302246"));
    }

    public WebElement txtPostCode() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt302247"));
    }

    public WebElement txtEmailAddress() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt302248"));
    }

    public WebElement txtHomePhone() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt302249"));
    }

    public WebElement txtMobilePhone() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt302250"));
    }

    public WebElement txtDaytimePhone() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt302251"));
    }

    public WebElement btnCreateEventSendEmail() {
        return waitForElementPresent(By.id("ctl00_cphBody_btnSaveSendDoc"));
    }

    public WebElement eventLetter() {
        return waitForElementPresent(By.id("ctl00_cphBody_ddlDocTemplate"));
    }

    public WebElement getTemplatebtn() {
        return waitForElementPresent(By.xpath("//input[@value='Get Template']"));
    }


    public String listCommunicationPref() {
        return "//td[2]/input[@type='checkbox']";
    }

    public String commPreference(int i) {
        return "(//td[2]/input[@type='checkbox'])[" + i + "]";
    }


    public WebElement policyNumber() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptPolicies_ctl01_gridRow']/td[2]"));
    }

    public WebElement policyIdForReport() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptPolicies_ctl01_hidCaseID']/../following-sibling::td[1]"));
    }

    public WebElement addressType() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl302298_Input"));
    }

    public WebElement addressTypeValue(String searchValue) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + searchValue + "')]"));
    }

    public WebElement okAddressOrBranchValue(String searchValue) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + searchValue + "')]"));
    }

    public WebElement okAddressOrBranch() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl302300_Input"));
    }

    public WebElement getPolicyNumberFromScreen() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblAccountID"));
    }

    public WebElement previewFailureEmail() {
        return waitForElementPresent(By.xpath("//*[contains(@title,'Preview this email')]"));
    }

    public WebElement nextTotalAmount() {
        return waitForElementPresent(By.xpath("//*[contains(@id,'grdAccount')]//tr[1]/td[3]"));
    }

    public WebElement nextDate() {
        return waitForElementPresent(By.xpath("//table[contains(@id,'PaymentSchedule')]/tbody/tr/td[3]"));
    }

    public WebElement inceptiondatetext() {
        return waitForElementPresent(By.id("rdp300931_dateInput_text"));
    }

    public WebElement startdatetext() {
        return waitForElementPresent(By.id("rdp300932_dateInput_text"));
    }

    public WebElement inceptionDateCalendar() {
        return waitForElementPresent(By.id("rdp300931_popupButton"));
    }

    public WebElement inceptionDatePerviousMonth() {
        return waitForElementPresent(By.id("rdp300931_calendar_NP"));
    }

    public WebElement startDateCalendar() {
        return waitForElementPresent(By.id("rdp300932_popupButton"));
    }

    public WebElement startDatePerviousMonth() {
        return waitForElementPresent(By.id("rdp300932_calendar_NP"));
    }

    public WebElement dateToSelect() {
        return waitForElementPresent(By.xpath("(//a[text()='30'])[1]"));
    }

    public WebElement endDatePerviousMonth() {
        return waitForElementPresent(By.id("rdp300933_calendar_NP"));
    }

    public WebElement endDateCalendar() {
        return waitForElementPresent(By.id("rdp300933_popupButton"));
    }

    public WebElement editPolicy() {
        return waitForElementPresent(By.xpath("//a[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptPolicies_ctl01_lnkMatterView')]"));
    }

    public WebElement txtUpgradeInceptionDate() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Inception')]/../following-sibling::td/div/div/span/input[1]"));
    }

    public WebElement txtUpgradeStartDate() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Start')]/../following-sibling::td/div/div/span/input[1]"));
    }


    public WebElement txtUpgradeEndDate() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'End')]/../following-sibling::td/div/div/span/input[1]"));
    }

    public WebElement txtCoverActionDate() {
        return waitForElementPresent(By.id("Rad302480_ctl01_ctl04_rdp302487_dateInput_text"));
    }

    public WebElement txtCoverStartDate() {
        return waitForElementPresent(By.id("Rad302480_ctl01_ctl04_rdp302482_dateInput_text"));
    }


    public WebElement txtCoverEndDate() {
        return waitForElementPresent(By.id("Rad302480_ctl01_ctl04_rdp302483_dateInput_text"));
    }

    public WebElement txtExtActionDate() {
        return waitForElementPresent(By.id("Rad302489_ctl01_ctl04_rdp302488_dateInput_text"));
    }


    public WebElement lnkEdit1() {
        return waitForElementPresent(By.xpath("(//a[contains(text(),'Edit')])[1]"));
    }

    public WebElement lnkEdit2() {
        return waitForElementPresent(By.xpath("(//a[contains(text(),'Edit')])[2]"));
    }

    public WebElement lnkUpdate() {
        return waitForElementPresent(By.partialLinkText("Update"));
    }

    public WebElement txtPremium() {
        return waitForElementPresent(By.id("cur302505"));
    }

    public WebElement txtPremiumIPT() {
        return waitForElementPresent(By.id("cur302506"));
    }

    public WebElement txtProratedPremium() {
        return waitForElementPresent(By.id("cur302507"));
    }

    public WebElement txtTotalAmt() {
        return waitForElementPresent(By.id("cur300935"));
    }

    public WebElement txtAmtToPay() {
        return waitForElementPresent(By.id("dummy"));
    }


    public WebElement txtUpgradeExpiryDate() {
        return waitForElementPresent(By.id("rdp300933_dateInput_text"));
    }


    public WebElement upgradePurchaseDate(String cover) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + cover + "')]/../following-sibling::td[2]"));
    }

    public WebElement upgradeExpiryDate(String cover) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + cover + "')]/../following-sibling::td[3]"));
    }

    public WebElement lblGeneratedQuote(String cover) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + cover + "')]"));
    }


    public WebElement endrosementTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Endorsements')]"));
    }

    public WebElement postcodeMandatoryFieldImg() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Customer is resident in the UK')]/../following-sibling::td/div/div/img"));
    }

    public WebElement postcodeMandatoryFieldValueNo() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl301996_c2"));
    }

    public WebElement postcodeMandatoryFieldValueYes() {

        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl301996_c1"));
    }

    public WebElement currentlyCovered() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Date of Birth')]"));
    }

    public WebElement endrosementDetails(String fieldValue) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + fieldValue + "')]"));
    }

    public WebElement endrosementTable() {
        return waitForElementPresent(By.xpath("//table[@id='Rad301966_ctl01']"));
    }

    public String endrosementTableXpath() {
        return "//table[@id='Rad301966_ctl01']";
    }

    public String deleteLinkXpath() {
        return "//a[contains(text(),'Delete')]";
    }

    public String coverTable() {
        return "//*[contains(@id,'ctl01_rptPolicies_ctl01_headerRow')]/th[text()='Base Policy']";
    }

    public WebElement basePolicyLink() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_rptPolicies_ctl01_lnkPolicy"));
    }

//    public WebElement basePolicyLinkBelowTheBasicDetails() {
//        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_rptPolicies_ctl01_lnkPolicy"));
//    }

    public WebElement switchToPolicyView() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lnkPolicyNo"));
    }

    public WebElement dobUpdate() {
        return waitForElementPresent(org.openqa.selenium.By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtDateOfBirth"));
    }

    public WebElement mobilePhoneUpdate() {
        return waitForElementPresent(org.openqa.selenium.By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtMobilePhone"));
    }

    public WebElement testing_WP(String option) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + option + "')]"));
    }

    public WebElement testing_WPFirstNotification(String option) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + option + "')]/../../td[2]/input[1]"));
    }

    public WebElement validateMissingPersonFields(String searchField) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + searchField + "')]"));
    }

    public WebElement verifyingDLG() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Notify DLG Media Team')]"));
    }

    public WebElement clickCheckboxDLG() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Notify DLG Media Team')]/../../td[2]/input[1]"));
    }


    public WebElement validateMissingPersonFieldValue(String searchField) {
        return waitForElementPresent(By.xpath("(//span[contains(text(),'" + searchField + "')]/../following-sibling::td[1]/input)[1]"));
    }

    public WebElement validateTravellingCompanionFields(String searchField) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + searchField + "')]"));
    }

    public WebElement validateTravellingCompanionFieldValue(String searchField) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + searchField + "')]/../following-sibling::td[1]/textarea"));
    }

    public WebElement typeOfClaimImg() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Current Patient Status')]/../following-sibling::td[1]/div/div/img"));
    }

    public WebElement currentPatientStatus() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Current Patient Status')]/../following-sibling::td[1]/div/div/img"));
    }

    public WebElement selectTypeOfClaim(String fieldValue) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + fieldValue + "')]"));
    }

    public WebElement createEventAndSendEmail() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Type of Claim')]/../following-sibling::td[1]/div/div/img"));
    }

    public WebElement validateDLGMediaTeamCKboxValidation(String searchField) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + searchField + "')]/../following-sibling::td[1]/input[2]"));
    }
    public WebElement validateMediaTeamCKboxValidation(String searchField) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + searchField + "')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement validateDLGMediaEmailContent() {
        return waitForElementPresent(By.linkText("Notify TIM Travel Insurance Management - Email"));
    }

    public WebElement missingPersonName(String personName) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + personName + "')]"));
    }

//    public WebElement emailTabCloseBtn() {
//        return waitForElementPresent(By.id("btnCustomerLeadDetails"));
//    }

    public WebElement leadsTab() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnLeadDetails"));
    }

    public WebElement tmaTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'TMA')]"));
    }

//    public WebElement closeLeadsTab() {
//        return waitForElementPresent(By.id("btnClose"));
//    }

    public WebElement viewClaim() {
        return waitForElementPresent(By.linkText("View claim details"));
    }

    public WebElement tabToSelect(String tabName) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//span[contains(text(),'" + tabName + "')]"));
    }

    public WebElement deceasedMarkedInNamedPeopleTable() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//table[@id='Rad300927_ctl01']//td[11]/span[2]"));
    }

    public WebElement deceasedMarked() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//table[@id = 'ucMandatoryFieldEditor_tableDataEntry']//td[9]"));
    }

    public WebElement claimAllocation() {
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims']/tbody/tr/th[10][contains(text(),'Claim Handler')]/../following-sibling::tr/td[10]"));
    }

    public WebElement eventGenerated(String event) {
        return waitForElementPresent(By.linkText(event));
    }

    public WebElement emailTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Email') and @class='innerWrap']"));
    }

    public WebElement claimHandlerFirstName(String firstName) {
        System.out.println("//span[contains(text(),'" + firstName + "')]");
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + firstName + "')]"));

    }

    public WebElement claimHandlerLastName(String lastName) {
        System.out.println("//span[contains(text(),'" + lastName + "')]");
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + lastName + "')]"));

    }

    public WebElement vaidateClaimHandlerDetails(String fieldName) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + fieldName + "')]/../following-sibling::td/input"));
    }

    public WebElement validateEMCustomerContactRequest() {
        return waitForElementPresent(By.linkText("EM - To Adviser: Customer Contact Request (SYSTEM)"));
    }

    public WebElement retrieveClaimID() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Claim Handler')]/../following-sibling::tr/td[2]"));
    }

    public WebElement retrieveClaimAssignedStatus() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Claim Handler')]/../following-sibling::tr/td[10]"));
    }

    public WebElement claimTable() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims"));
    }

    public WebElement validateExistingClaimStatus(String claimID) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + claimID + "')]/following-sibling::td[8]"));
    }


    public WebElement genericSignature() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//div[contains(text(),'Kind regards')]/following-sibling::div[1]/span"));
    }

    public WebElement claimHandlerSignature() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//div[contains(text(),'Kind regards')]/following-sibling::div[1]/span"));
    }

    public WebElement claimIdInput() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[contains(text(),'Claim ID')]/following-sibling::div/input[1]"));
    }

    public WebElement selectFirstRecord() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_tabResults_tpnlResults1_rgCustomers_ctl01_ctl04_ViewLink"));
    }

    public WebElement amountPaidForTheClaim(String claimID) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[contains(text(),'" + claimID + "')]/following-sibling::td[7]"));
    }

    public WebElement editGivenClaim(String claimID) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[contains(text(),'" + claimID + "')]/preceding-sibling::td[1]/a"));
    }

    public WebElement highlightedNamedPerson(String person) {
        return waitForElementPresent(By.xpath("//*[@class='highlightRow']/td[text()='" + person + "']"));
    }

    public WebElement chkBk_RemoveNamedPerson() {
        return waitForElementPresent(By.xpath("//div/input[starts-with(@id,'ucMandatoryFieldEditor_df_302138_0_0_0_0_DVID')]"));
    }

//    public WebElement lblPolicyNumber() {
//
//        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptPolicies_ctl01_gridRow']/td[2]"));
//    }

    public WebElement lblPolicyType() {
        return waitForElementPresent(By.id("policySchemeData"));

    }

    public WebElement lblMainAcctHolderFirstName() {

        return waitForElementPresent(By.xpath("//td[contains(text(),'Main Account Holder')]/following-sibling::td[2]"));
    }

    public WebElement lblJointAcctHolderFirstName() {

        return waitForElementPresent(By.xpath("//td[contains(text(),'Joint Account Holder')]/following-sibling::td[2]"));
    }

    public WebElement lblMainAcctHolderLastName() {

        return waitForElementPresent(By.xpath("//td[contains(text(),'Main Account Holder')]/following-sibling::td[3]"));
    }

    public WebElement lblJointAcctHolderLastName() {

        return waitForElementPresent(By.xpath("//td[contains(text(),'Joint Account Holder')]/following-sibling::td[3]"));
    }

    public WebElement txtAcctOpenDate() {

        return waitForElementPresent(By.id("txt303849"));
    }

    public WebElement namedPeopleTab() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//span[contains(text(),'Named People')]"));
    }

    public WebElement tabAccountDetails() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Account Details')]"));
    }

    public WebElement navigateBasePolicyLink() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Base Policy')]/../following-sibling::tr//a[contains(@id,'lnkPolicy')]"));
    }

    public WebElement navigateToPolicyLinkFromBillingView() {
        return waitForElementPresent(By.xpath("//span[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblAccountLID']"));
    }
    /*public WebElement retrieveWorkflowcaseid(String caseId) {
        return waitForElementPresent(By.xpath("(//table[contains(@id,'rgWorkflowTasks')]/tbody/tr/td/a[@title='Go to this lead and case'])[contains(text(),'"+caseId+"')]"));
    }*/

    public WebElement retrieveWorkflowcaseid(String caseId) {
        return waitForElementPresent(By.xpath("(//a[@title='Go to this lead and case'])[contains(text(),'" + caseId + "')]"));
    }

    public WebElement lnkPolicy() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Travel Policy')]"));
    }


    public WebElement txtPolicyId() {
        return waitForElementPresent(By.xpath("//span[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblAccountID']"));
    }

    public WebElement dropDownPolicyStatus() {
        return waitForElementPresent(By.xpath("//input[@id='ddl302227_Input']"));
    }

    public WebElement dropDownPolicyStatusValue(String value) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + value + "')]"));
    }

    public WebElement restrictionMessage() {
        return waitForElementPresent(By.xpath("//h2"));
    }

    public WebElement removalOfCover() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Cover Removed')]/../following-sibling::div/input"));
    }

    public WebElement commPreferenceTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Comms Preferences')]"));
    }

    public WebElement retrievingMarketingPreferenceValue() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Marketing Preference')]/../following-sibling::td/div/div/input"));
    }

    public String lblJointAcctHolders() {
        return "//*[contains(text(),'Joint Account Holder')]";
    }

    public WebElement returnClaimReasons() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[@class='ComboBoxInput_Default']"));
    }

    public WebElement invalidReferralXpath() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//div[contains(text(),'Invalid referral')]"));
    }

    public WebElement comments() {
        return waitForElementPresent(org.openqa.selenium.By.id("txtComments"));
    }

    public WebElement finishButton() {
        return waitForElementPresent(org.openqa.selenium.By.id("btnFinish"));
    }

//    public WebElement communicationPref() {
//        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblCommunicationPreference"));
//    }

    public WebElement documentPref() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblDocumentPreference"));
    }

    public String returnToTravelIncident() {
        return "//label[contains(text(),'Return Claim to Travel Incident Management')]/../input";
    }

    public WebElement wp_cardToken() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt303656_55296189"));
    }

    public WebElement wp_MaskedCardNumber() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt303657_55296189"));
    }

    public WebElement wp_ExpiryMonth() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt303658_55296189"));
    }

    public WebElement wp_ExpiryYear() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_tbl303659_55296189"));
    }

    public WebElement wp_CardType() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_lbl303660_55296189"));
    }

    public WebElement wp_PaymentStatus() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt303661_55296189"));
    }

    public WebElement wp_TokenExpiryDayofMonth() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt303964_55296189"));
    }

    public WebElement wp_TokenExpiryMonth() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt303965_55296189"));
    }

    public WebElement wp_TokenExpiryYear() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt303966_55296189"));
    }

    public WebElement wp_CardHolderName() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt304650_55296189"));
    }

    public WebElement wp_Address1() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt304656_55296189"));
    }

    public WebElement wp_Address2() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt304657_55296189"));
    }

    public WebElement wp_PostalCode() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt304658_55296189"));
    }

    public WebElement wp_City() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt304659_55296189"));
    }

    public WebElement wp_County() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_lbl304660_55296189"));
    }

    public WebElement wp_CountryCode() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt304661_55296189"));
    }

    public WebElement dateofBirthOfDeceasedPerson() {
        return waitForElementPresent(By.xpath("//*[@id='ucMandatoryFieldEditor_df_300927_0_52785613_0_0_DVID_0']/tbody/tr[2]/td[6]"));
    }

    public WebElement enterdateofBirthOfDeceasedPerson() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_df_300926_0_0_0_0_DVID_13559289"));
    }

    public WebElement markedAsDeceased() {
        return waitForElementPresent(By.xpath("//*[@id='ucMandatoryFieldEditor_df_300927_0_52785613_0_0_DVID_0']/tbody/tr[2]/td[9]"));
    }

    public WebElement removedNamedPerson() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Cover Removed')]/../following-sibling::div[1]/input"));
    }


    public WebElement validateForeignEmbassyCKboxValidation(String fieldName) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//span[contains(text(),'"+fieldName+"')]/../following-sibling::td[1]/input[1]"));
    }
    public WebElement selectnatwestscheme() {
        return waitForElementVisible(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_tabResults_tpnlResults1_rgCustomers_ctl01_ctl12_ViewLink\"]/img"));
    }

    public WebElement custCommEmailValue(){
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtEmailAddress"));
    }

    public WebElement custCommTitleValue(){
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_ddlTitle"));
    }

    public WebElement custCommFirstNameValue(){
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtFirstName"));
    }

    public WebElement custCommLastNameValue(){
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtLastName"));
    }

    public WebElement custCommDOBValue(){
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtDateOfBirth"));
    }

    public WebElement acctHolderType(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl01_gridRow')]/td[2]"));
    }
    public WebElement acctHolderTitle(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl01_gridRow')]/td[3]"));
    }
    public WebElement acctHolderFirstName(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl01_gridRow')]/td[4]"));
    }
    public WebElement acctHolderLastName(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl01_gridRow')]/td[5]"));
    }
    public WebElement acctHolderDOB(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl01_gridRow')]/td[6]"));
    }
    public WebElement viewErrorMessage(String message){
        return waitForElementPresent(By.xpath("//span[contains(text(),'" +message+ " ')]"));
    }

    public WebElement verifyCinNumber(){
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtCustomerRef"));
    }

    public WebElement verifyMainEmail(){
        return waitForElementPresent(By.xpath("//table[@id='Rad300927_ctl01']/tbody/tr[1]/td[19]"));
    }
    public WebElement verifyJointEmail(){
        return waitForElementPresent(By.xpath("//table[@id='Rad300927_ctl01']/tbody/tr[2]/td[19]"));
    }
    public WebElement verifySecondJointEmail(){
        return waitForElementPresent(By.xpath("//table[@id='Rad300927_ctl01']/tbody/tr[3]/td[19]"));
    }
    public WebElement verifyThirdJointEmail(){
        return waitForElementPresent(By.xpath("//table[@id='Rad300927_ctl01']/tbody/tr[4]/td[19]"));
    }
    public WebElement verifyContactNumberMain(){
        return waitForElementPresent(By.xpath("//table[@id='Rad300927_ctl01']/tbody/tr[2]/td[18]"));
    }
    public WebElement verifyContactNumberJoint(){
        return waitForElementPresent(By.xpath("//table[@id='Rad300927_ctl01']/tbody/tr[2]/td[18]"));
    }
    public WebElement editPrimaryJointAccountHolder(){
        return waitForElementPresent(By.xpath("//a[contains(@href,\"Edit$0\")]"));
    }
    public WebElement editSecondaryJointAccountHolder(){
        return waitForElementPresent(By.xpath("//a[contains(@href,\"Edit$1\")]"));
    }
    public WebElement mobileText(){
        return waitForElementPresent(By.xpath("//input[contains(@id,'ucMandatoryFieldEditor_df_303047')]"));
    }
    public WebElement email(){
        return waitForElementPresent(By.xpath("//input[contains(@id,'ucMandatoryFieldEditor_df_303048')]"));
    }
    public WebElement dobJoint(){
        return waitForElementPresent(By.xpath("//input[contains(@id,'ucMandatoryFieldEditor_df_300926')]"));
    }
    public WebElement validateUlsterHomepage(){
        return waitForElementPresent(By.xpath("//img[contains(@class, 'logo-img')]"));
    }

    public String jointAcctHolderType(){
        return ("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl04_gridRow')]/td[2]");
    }

    public WebElement primaryJointAcctHolderType(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl02_gridRow')]/td[2]"));
    }

    public WebElement primaryJointAcctHolderTitle(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl02_gridRow')]/td[3]"));
    }
    public WebElement primaryJointAcctHolderFirstName(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl02_gridRow')]/td[4]"));
    }
    public WebElement primaryJointAcctHolderLastName(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl02_gridRow')]/td[5]"));
    }
    public WebElement primaryJointAcctHolderDOB(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl02_gridRow')]/td[6]"));
    }

    public WebElement secondJointAcctHolderType(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl03_gridRow')]/td[2]"));
    }

    public WebElement secondJointAcctHolderTitle(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl03_gridRow')]/td[3]"));
    }
    public WebElement secondJointAcctHolderFirstName(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl03_gridRow')]/td[4]"));
    }
    public WebElement secondJointAcctHolderLastName(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl03_gridRow')]/td[5]"));
    }
    public WebElement secondJointAcctHolderDOB(){
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl08_rptPeople_ctl03_gridRow')]/td[6]"));
    }
    public WebElement policyIdInput() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[contains(text(),'Policy ID')]/following-sibling::div/input[1]"));
    }
    public WebElement updateJointAccountHolder_dateOfBirth() {
        return waitForElementPresent(By.xpath("//*[contains(@id,'ucMandatoryFieldEditor_df_300926')]"));
    }

    public WebElement basePolicyType() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//span[contains(text(),'Base Policy Type')]/../following-sibling::td//div[@class='ComboBox_Default']/input"));
    }

    public WebElement basePolicyOption(String basePolicyType) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//div[contains(text(),'"+basePolicyType+"')]"));
    }
}