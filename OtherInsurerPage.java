package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class OtherInsurerPage extends AbstractPage {


//    public WebElement cancel() {
//        return waitForElementPresent(By.id("btnCancel"));
//    }


    public WebElement enterOtherInsurerDetailsSave() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
    }

    public WebElement otherInsurerQuestion(String strOtherInsuranceOption) {
        return waitForElementPresent(By.xpath("//div[contains(@id,'ddl301332')]/div/div[contains(text(),'" + strOtherInsuranceOption + "')]"));
    }

    public WebElement otherInsuranceDetailsWebTable() {
        return waitForElementVisible(By.xpath("//table[contains(@id,'grdInsurers')]"));
    }

    public String otherInsuranceEnterDetailsWebTable() {
        return "//table[contains(@id,'CustomDetailFieldViews')]/tbody/tr";
    }

    public WebElement frame() {
        return waitForElementVisible(By.id("RadWindowContentFramectl00_cphBodyWithoutUpdatePanel_cphBody_rwmEvents_rwEventWizard"));
    }

    public WebElement otherInsurerYesNoSelect(int i) {
        return waitForElementVisible(By.xpath("//table[contains(@id,'CustomDetailFieldViews')]/tbody/tr[" + i + "]/td/select[1]"));
    }

    public WebElement otherInsurerDropdown(int i) {
        return waitForElementVisible(By.xpath("//table[contains(@id,'CustomDetailFieldViews')]/tbody/tr[" + i + "]/td/select[2]"));
    }

    public WebElement otherInsurerPolicyNo(int i) {
        return waitForElementVisible(By.xpath("//table[contains(@id,'CustomDetailFieldViews')]/tbody/tr[" + i + "]/td/input"));
    }

    public WebElement otherInsurerPerson(int i) {
        return waitForElementVisible(By.xpath("//table[contains(@id,'CustomDetailFieldViews')]/tbody/tr[" + i + "]/td/select[3]"));
    }

    public WebElement otherInsurerName() {
        return waitForElementVisible(By.xpath("dummy"));
    }


    public WebElement otherInsurerSaveBtn() {
        return waitForElementPresent(By.xpath("//input[@id='ucMandatoryFieldEditor_btnSave']"));
    }

    public WebElement insurerFrame() {
        return waitForElementPresent(By.id("RadWindowContentFramectl00_cphBodyWithoutUpdatePanel_cphBody_rwManagerMM_DialogWindow"));
    }

    public WebElement lnkEditOtherInsurer() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Other Insurers')][1]/following-sibling::td[5]/a"));
    }

    public WebElement insurerName() {
        return waitForElementVisible(By.id("ddl301447_Input"));
    }

    public WebElement drpdnInsurerName(String name) {
        return waitForElementVisible(By.xpath("//div[starts-with(@id,'ddl301447') and contains(text(),'" + name + "')]"));
    }

    public WebElement txtAddress() {
        return waitForElementVisible(By.id("txt301448"));
    }

    public WebElement txtEmail() {
        return waitForElementVisible(By.id("txt301455"));
    }

    public WebElement contactTitle() {
        return waitForElementVisible(By.id("ddl301624_Input"));
    }

    public WebElement drpdnInsurerTitle(String title) {
        return waitForElementVisible(By.xpath("//div[starts-with(@id,'ddl301624') and contains(text(),'" + title + "')][1]"));
    }

    public WebElement drpdnInsurerMrsTitle(String title) {
        return waitForElementVisible(By.xpath("//div[starts-with(@id,'ddl301624') and contains(text(),'" + title + "')][2]"));
    }

    public WebElement txtInsurerFirstName() {
        return waitForElementVisible(By.id("txt301623"));
    }

    public WebElement txtInsurerLastName() {
        return waitForElementVisible(By.id("txt301456"));
    }

    public WebElement insurerPrefContact() {
        return waitForElementVisible(By.id("ddl301630_Input"));
    }

    public WebElement drpdnInsurerPrefContact(String contactMethod) {
        return waitForElementVisible(By.xpath("//div[starts-with(@id,'ddl301630') and contains(text(),'" + contactMethod + "')]"));
    }

    public WebElement addedInsurer(String insurerName) {
        return waitForElementVisible(By.xpath("//td[contains(text(),'" + insurerName + "')]"));
    }

    public WebElement selectInsurer(String InsurerType){
        return waitForElementPresent(By.xpath("//td[contains(text(),'"+InsurerType+"')]/..//*[contains(@id,'ddlInsurer')]"));
    }
}
