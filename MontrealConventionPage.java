package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class MontrealConventionPage extends AbstractPage {

    public WebElement flightNumber() {
        return waitForElementPresent(By.xpath("//table[@id='ucMandatoryFieldEditor_tableDataEntry']//table//input[1]"));
    }

    public WebElement airlinesSearchButton() {
        return waitForElementPresent(By.xpath("//input[@title='Select Resource']"));
    }

    public WebElement airlinesFrame() {
        return waitForElementPresent(By.id("RadWindowContentFrameucMandatoryFieldEditor_RadWindowManager1_PagesDialogWindow"));
    }

    public WebElement airlinesSelect(String parameter) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + parameter + "')]/..//a"));
    }

    public WebElement airlinesName() {
        return waitForElementPresent(By.xpath("//span[text()='Airline:']/../../../tr[2]//span[contains(text(),'Name')]/../../td/input"));
    }

    public WebElement PIRNumber() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'PIR Number')]/../..//input[1]"));
    }

    public WebElement airlinesSaveBtn() {
        return waitForElementPresent(By.xpath("//input[@id='ucMandatoryFieldEditor_btnSave']"));
    }


    public WebElement lnkEditAirlines() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Airlines')][1]/following-sibling::td[5]/a"));
    }


    public WebElement lnkEditPolicyType(String type) {
        return waitForElementPresent(By.xpath("(//td[contains(text(),'"+type+"')])[1]/following-sibling::td[5]/a"));
    }

    public WebElement txtAirlinesName() {
        return waitForElementVisible(By.id("txt301415"));
    }

    public WebElement txtAirlinesAddress() {
        return waitForElementVisible(By.id("txt301416"));
    }

    public WebElement txtAirlinesEmail() {
        return waitForElementVisible(By.id("txt301417"));
    }

    public WebElement airlinesTitle() {
        return waitForElementVisible(By.id("ddl301626_Input"));
    }

    public WebElement drpdnAirlinesTitle(String title) {
        return waitForElementVisible(By.xpath("//div[starts-with(@id,'ddl301626') and contains(text(),'" + title + "')][1]"));
    }

    public WebElement drpdnAirlinesMrsTitle(String title) {
        return waitForElementVisible(By.xpath("//div[starts-with(@id,'ddl301626') and contains(text(),'" + title + "')][2]"));
    }

    public WebElement txtAirlinesFirstName() {
        return waitForElementVisible(By.id("txt301625"));
    }

    public WebElement txtAirlinesLastName() {
        return waitForElementVisible(By.id("txt301418"));
    }

    public WebElement airlinesPrefContact() {
        return waitForElementVisible(By.id("ddl301631_Input"));
    }

    public WebElement drpdnAirlinesPrefContact(String contactMethod) {
        return waitForElementVisible(By.xpath("//div[starts-with(@id,'ddl301631') and contains(text(),'" + contactMethod + "')]"));
    }

    public WebElement btnAddAirlines() {
        return waitForElementPresent(By.id("btnAdd"));
    }

    public WebElement btnClose() {
        return waitForElementPresent(By.xpath("//*[@id='CloseButtonctl00_cphBodyWithoutUpdatePanel_cphBody_rwManagerMM_DialogWindow']"));
    }

    public WebElement lnkSelectAirlines(String airlines) {
        return waitForElementPresent(By.xpath("//td[text()='" + airlines + "']/../td[1]/a"));
    }

    public WebElement lnkDelete(String supplier) {
        return waitForElementPresent(By.xpath("//td[text()='" + supplier + "']/../td[2]/a"));
    }

//    public WebElement btnCancel() {
//        return waitForElementPresent(By.id("btnCancel"));
//    }

    public WebElement airlinesFrameConfig() {
        return waitForElementPresent(org.openqa.selenium.By.id("RadWindowContentFramectl00_cphBodyWithoutUpdatePanel_cphBody_rwManagerMM_DialogWindow"));
    }

    public WebElement txtURL()
    {
        return waitForElementPresent(By.xpath("//span[contains(text(),'PortalURL')]/../../td[2]/input"));
    }

    public WebElement txtAirlineType()
    {
        return waitForElementPresent(By.xpath("(//tr[@class='GridFilterRow_Default']//input)[2]"));
    }
    public WebElement selectFilter()
    {
        return waitForElementPresent(By.xpath("(//tr[@class='GridFilterRow_Default']//input)[2]/../img"));
    }
    public WebElement selectFilterOperation()
    {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Contains')]"));
    }

    public WebElement airlinesNameFilter() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//table[@id = 'detailFieldRadGrid_ctl01']/thead/tr[2]/td/input)[2]"));
    }
    public WebElement airlinesNameFilterImg() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("(//table[@id = 'detailFieldRadGrid_ctl01']/thead/tr[2]/td/img)[2]"));
    }


    public WebElement containFilter() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//td[contains(text(),'Contains')]"));
    }
}
