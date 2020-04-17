package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends AbstractPage {

    public WebElement standardSearch() {
        return waitForElementPresent(By.id("__tab_ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_TabContainer1_TabPanelCustomSearch"));
    }

    public WebElement brand() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_TabContainer1_TabPanelCustomSearch_ddlBrand"));
    }

    public WebElement firstName() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_TabContainer1_TabPanelCustomSearch_ForenameTextBox"));
    }

    public WebElement surname() {
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_TabContainer1_TabPanelCustomSearch_SurnameTextBox"));
    }

    public WebElement riskPostCode() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_TabContainer1_TabPanelCustomSearch_PostcodeTextBox"));
    }

    public WebElement dob() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_TabContainer1_TabPanelCustomSearch_DOBTextBox_dateInput_text"));
    }

    public WebElement email() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_TabContainer1_TabPanelCustomSearch_EmailTextBox"));
    }

    public WebElement phoneNumber() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_TabContainer1_TabPanelCustomSearch_PhoneNumTextBox"));
    }

    public WebElement claimNumber() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_TabContainer1_TabPanelCustomSearch_ClaimNumTextBox"));
    }

    public WebElement calendarButton() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_TabContainer1_TabPanelCustomSearch_DOBTextBox_CalendarPopupButton"));
    }

    public WebElement policyNumber() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_TabContainer1_TabPanelCustomSearch_PolicyNumTextBox"));
    }

    public WebElement bankAccountNumber() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_TabContainer1_TabPanelCustomSearch_BankNumTextBox"));
    }

    public WebElement brandErrorMessage() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_TabContainer1_TabPanelCustomSearch_rfv1"));
    }

    public WebElement searchButton() {
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_TabContainer1_TabPanelCustomSearch_ButtonCustomSearch"));
    }

    public WebElement searchResultTable() {
       return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_tabResults_TabPanelCustomResults_rgCustomResults_ctl01"));
    }

    public WebElement viewCustomerLinkInSearchResultTable() {
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_tabResults_TabPanelCustomResults_rgCustomResults_ctl01_ctl04_ViewLink")).findElement(By.tagName("img"));
    }

    public WebElement viewClaimLinkInSearchResultTable(){
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_tabResults_tpnlResults1_rgCustomers_ctl01_ctl04_ViewLink"));

    }

    public boolean viewCustomerLinkInSearchResultTableIsDisplayed() {
        List<WebElement> lstWb = getDriver.findElements(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_tabResults_TabPanelCustomResults_rgCustomResults_ctl01_ctl04_ViewLink"));
        System.out.println("lstWb.size()---------------------------"+lstWb.size());
        return lstWb.size() != 0;
    }


    public boolean viewCustomerLinkInSearchResultTableForSupplierIsDisplayed() {
        List<WebElement> lstWb = getDriver.findElements(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_tabResults_tpnlResults1_rgCustomers_ctl01"));
        return lstWb.size() != 0;
    }

    public String searchResultXPath() {
        return "//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_tabResults_TabPanelCustomResults_rgCustomResults_ctl01']/tbody/tr/td[contains(text(),'##SearchPage Value##')]";
    }

    public Boolean createNewCustomerDisplayed() {
        return elementDisplayed(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_btnDLGCustomerCreate"));
    }

    public WebElement createNewCustomer() {
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_btnDLGCustomerCreate"));
    }

    public WebElement jointAccountDropDown() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl301550_Input"));
    }

    public WebElement jointAccountDropDown_Yes() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl301550_c1"));
    }

    public WebElement jointAccountDropDown_No() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl301550_c2"));
    }

    public WebElement existingPackageDropDown() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl301551_Input"));
    }

    public WebElement existingPackageDropDown_Yes() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl301551_c1"));
    }

    public WebElement existingPackageDropDown_No() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ddl301551_c2"));
    }

    public WebElement enterAccountNumber() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt301392"));
    }

    public WebElement enterSortCode() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt301393"));
    }

    public WebElement enterBankName() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt301394"));
    }

    public WebElement enterExpiryDate() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt301395"));
    }

    public WebElement selectCover() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//span[contains(text(),'Cover')]/following-sibling::input[2]"));
    }

    public WebElement selectSilverCover(String cover) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + cover + "')]/preceding-sibling::td/a"));
    }

    public WebElement title() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_ddlPartnerTitle"));
    }

    public WebElement jointHolderFirstName() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtPartnerFirstName"));
    }

    public WebElement jointHolderLastName() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtPartnerLastName"));
    }

    public WebElement jointHolderdob() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtPartnerDateOfBirth"));
    }

    public WebElement save() {
        return waitForElementToBeClickableAndReturnElement(By.id("ucMandatoryFieldEditor_btnSave"));
    }


    public WebElement telephoneNumberType_Joint1Img() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Telephone Number 1 Joint Type')]/../../td[2]/div/div/img"));
    }

    public WebElement telephoneNumberType_Joint1_SelectHome() {
        return waitForElementVisible(By.xpath("//div[@id='ucMandatoryFieldEditor_ddl301559_DropDownPlaceholder']/div/div[2]"));
    }

    public WebElement telephoneNumberType_Joint2Img() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Telephone Number 2 Joint Type')]/../../td[2]/div/div/img"));
    }

    public WebElement telephoneNumberType_Joint2_SelectHome() {
        return waitForElementVisible(By.xpath("//div[@id='ucMandatoryFieldEditor_ddl301561_DropDownPlaceholder']//div[contains(text(),'Home')]"));
    }

    public WebElement titleValidation() {
        return waitForElementPresent(By.xpath("//select[@id='ucMandatoryFieldEditor_ucStandardCustomer_ddlPartnerTitle']/option[1]"));
    }

    public WebElement enterTelephoneNumberType_Joint1() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt301558"));
    }

    public WebElement enterTelephoneNumberType_Joint2() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt301560"));
    }

    public WebElement enterPostcodeInAddressLookUp() {
        return waitForElementPresent(By.xpath("//table[@id='AddressLookupContainer']/tbody/tr[4]/td[2]/input"));
    }

    public WebElement findAddressBtn() {
        return waitForElementPresent(By.xpath("//input[@value='Find Address']"));
    }

    public WebElement pickAddressbtn() {
        return waitForElementPresent(By.xpath("//input[contains(@value,'Pick Address')]"));
    }

    public WebElement addressLookUpselect() {
        return waitForElementToBeClickableAndReturnElement(By.id("ucMandatoryFieldEditor_quickAddress_Address_301552_lbPickList"));
    }

    public WebElement  validateErrMessageInAddressLookUp() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Address not found')]"));
    }

    public WebElement customerAddress1() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Customer Address1')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement customerAddress2() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Customer Address2')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement customerTown() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Customer Town')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement customerCountry() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Customer County')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement customerPostcode() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Customer Postcode')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement marketingPreference_ValidateDefaultValue() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Marketing Preference')]/../following-sibling::td[1]/div/div/input"));
    }

    public WebElement ComPreferences_DefaultValue(String str) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + str + "')]/../following-sibling::td[1]/span/input[1]"));
    }

    public WebElement ComActual_DefaultValue() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Com Actual')]/../../td[2]/div/div/input"));
    }

    public WebElement moreDetails() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_btnCustomerDF"));
    }

    public WebElement commPreferences() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Comms Preferences')]"));
    }

    public WebElement enterTelephoneNumberType1() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt301554"));
    }

    public WebElement enterTelephoneNumberType2() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt301556"));
    }

    public WebElement Customerdob() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_ucStandardCustomer_txtDateOfBirth"));
    }

    public WebElement cancel() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//input[@id='btnCancel']"));
    }

    public WebElement UK_Standard_TaxPercent() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl02_txtTaxPercent')]"));
    }

    public WebElement UK_TaxRegion() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl02_txtRegion')]"));
    }

    public WebElement closeWindowIPT() {
        return waitForElementPresent(By.xpath("//input[@value='Close Window']"));
    }


    public WebElement saveAndCloseIPT() {
        return waitForElementPresent(By.xpath("//input[@id='btnSaveAndClose']"));
    }

    public WebElement IOM_TaxPercent() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl04_txtTaxPercent')]"));
    }

    public WebElement channel_TaxPercent() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl05_txtTaxPercent')]"));
    }
    public WebElement ukTaxfree_TaxPercent() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl03_txtTaxPercent')]"));
    }

    public WebElement IOM_TaxRegion() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl04_txtRegion')]"));
    }

    public WebElement channel_TaxRegion() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl05_txtRegion')]"));
    }
    public WebElement ukTaxFree_TaxRegion() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl03_txtRegion')]"));
    }
    public WebElement UK_TaxRegionFromDate() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl02_txtValidFrom')]"));
    }

    public WebElement UK_TaxRegionToDate() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl02_txtValidTo')]"));
    }
    public WebElement channelIsles_TaxRegionFromDate() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl05_txtValidFrom')]"));
    }

    public WebElement channelIsles_TaxRegionToDate() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl05_txtValidTo')]"));
    }
    public WebElement iom_TaxRegionFromDate() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl04_txtValidFrom')]"));
    }

    public WebElement iom_TaxRegionToDate() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl04_txtValidTo')]"));
    }
    public WebElement UK_TaxfFreeRegionFromDate() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl03_txtValidFrom')]"));
    }

    public WebElement UK_TaxFreeRegionToDate() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl03_txtValidTo')]"));
    }
    public WebElement ComPreferencesAcctInfoPage() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblCommunicationPreference"));
    }

    public WebElement DocPreferencesAcctInfoPage() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lblDocumentPreference"));
    }

    public WebElement selectCommPreferenceAsEmail() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Email')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement selectCommPreferenceAsLetter() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Letter')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement selectCommPreferenceAsSMS() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'SMS')]/../following-sibling::td[1]/input[1]"));
    }

    public WebElement verifyCommPreferenceAsEmail() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Email')]/../following-sibling::td[1]/input[2]"));
    }

    public WebElement verifyCommPreferenceAsLetter() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Letter')]/../following-sibling::td[1]/input[2]"));
    }

    public WebElement verifyCommPreferenceAsSMS() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'SMS')]/../following-sibling::td[1]/input[2]"));
    }

    public WebElement entercurrentaddrs1InAddressLookUp() {
        return waitForElementPresent(By.xpath("//*[@id=\"ucMandatoryFieldEditor_txt301585\"]"));
    }

    public WebElement entercurrentaddrs2InAddressLookUp() {
        return waitForElementPresent(By.xpath("//*[@id=\"ucMandatoryFieldEditor_txt301586\"]"));
    }

    public WebElement entercustomertown() {
        return waitForElementPresent(By.xpath("//*[@id=\"ucMandatoryFieldEditor_txt301587\"]"));
    }

    public WebElement entercustomercountry() {
        return waitForElementPresent(By.xpath("//*[@id=\"ucMandatoryFieldEditor_txt301588\"]"));
    }

    public WebElement entercustomerpostcode() {
        return waitForElementPresent(By.xpath("//*[@id=\"ucMandatoryFieldEditor_txt301589\"]"));
    }

    public WebElement enternumberofdaysformanualchase() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Number of days until manual chase reminder')]//following::input[1]"));
    }

    public WebElement enternumberofdaysforautomationchase() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Number of days between automated chases')]//following::input[1]"));
    }

    public WebElement chasesave() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id=\"ucMandatoryFieldEditor_btnSave\"]"));
    }

    public WebElement stopchaseDetails(String value) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//div[contains(text(),'" + value + "')]"));
    }

    public WebElement stopchasedetailmain() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//span[contains(text(),'Stop chase')]//following::input[1]"));
    }

    public WebElement nonukdetails(String value) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//div[contains(text(),'" + value + "')]"));
    }

    public WebElement non_ukdetails_clickable() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[@id=\"ucMandatoryFieldEditor_ddl301996_Input\"]"));
    }

    public WebElement windowclose() {
        return waitForElementPresent(By.xpath("//*[@id=\"btnCloseWindow\"]"));
    }

    public WebElement showFullEventHistory() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucEventHistoryList_btnShowFullEventHistory"));
    }

    public WebElement startchaseevent() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'OOP Customer Chase - Start chase')]"));
    }

    public WebElement managechaseevent() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'OOP Customer Chase - Manage chase')]"));
    }

    public WebElement nonukaddressisentificationincident() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Non UK Address. Residency to be confirmed')]"));
    }

    public WebElement enterchasetitle() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Chase Title')]//following::input[1]"));
    }

    public WebElement enterchasetext() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Chase Text')]//following::textarea[1]"));
    }

    public WebElement eventtypeDropdown() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//select[contains(@id,'ddlEventToAdd')]"));
    }

    public WebElement next() {
        return waitForElementPresent(By.id("btnNext"));
    }

    public WebElement validateTransactionType() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Email')]"));
    }
    public WebElement validateDateTimeStamped() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Accessed On')]"));
    }
    public WebElement validateUSerID() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'By User')]"));
    }

    public WebElement noRecordDisplay() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'No results to display...')]"));
    }


    public WebElement quickSearchDropdown() {
        return waitForElementPresent(By.id("ctl00_ddlSearchField"));
    }

    public WebElement searchForInput() {
        return waitForElementPresent(By.id("ctl00_txtSearchText"));
    }

    public WebElement searchButtonInQuickSearch() {
        return waitForElementPresent(By.id("ctl00_btnQuickSearch"));
    }

    public WebElement firstRecordInSearch() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_tabResults_tpnlResults1_rgCustomers_ctl01_ctl04_ViewLink"));
    }

    public String customerTablerow() {
        return "//table[contains(@id,'rgCustomResults')]/tbody/tr";
    }

    public String tableSearchResult(){
        return "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_tabResults_TabPanelCustomResults_rgCustomResults_ctl01']//tbody/tr";
    }

    public WebElement lnkSearchResults(int i){

        return waitForElementPresent(By.xpath("(//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_tabResults_TabPanelCustomResults_rgCustomResults_ctl01']//tbody/tr//img)["+i+"]"));
    }
    public String advancedSearchResults() {
        return "//table[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_tabResults_tpnlResults1_rgCustomers_ctl01')]/tbody/tr";
    }

}
