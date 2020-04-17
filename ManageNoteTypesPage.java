package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ManageNoteTypesPage extends AbstractPage {

    public WebElement newRecord() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnNoteAdd"));
    }

    public WebElement name() {
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_tbxNoteTypeName"));
    }

    public WebElement description() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_tbxNoteTypeDescription"));
    }

    public WebElement enableForUse() {
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_chkEnabled"));
    }

    public WebElement alertColor() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtAlertColour"));
    }

    public WebElement normalColor() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtNormalColour"));
    }

    public WebElement acessType() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ddlAccessType"));
    }

    public WebElement save() {
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnNoteTypeSave"));
    }

    public WebElement manageNoteTypesTable() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_grdNoteTypes"));
    }

    public List<WebElement> editNoteCategoryDetailsBtn() {
        return findElements(By.xpath("//input[contains(@id,'btnEditNoteType')]"));
    }

    public WebElement noteType() {
        return waitForElementPresent(By.xpath("//td[@class='label']/select[@id='ddlNoteType']"));
    }

    public WebElement noteDescription() {
        return waitForElementPresent(By.id("txtNoteDescription"));
    }

    public WebElement notePriority() {
        return waitForElementPresent(By.xpath("//td[@class='label']/select[@id='ddlPriority']"));
    }
}