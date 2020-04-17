package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ThirdPartyAtFaultPage extends AbstractPage {

    public WebElement thirdPartyQuestion() {
        return waitForElementPresent(By.xpath("//table[contains(@id,'tbl301365')]/tbody/tr/td[2]/div"));
    }

    public WebElement thirdPartyAnswer(String thirdPartyOption) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + thirdPartyOption + "')]"));
    }

    public WebElement thirdPartyAtFaultSave() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_btnSave"));
    }

    public WebElement thirdPartyAtFaultAdd() {
        return waitForElementPresent(By.xpath("//input[contains(@value,'Add')]"));
    }

    public String thirdPartyAtFaultAddXpath() {
        return "//input[contains(@value,'Add')]";
    }


    public WebElement thirdPartyAtFaultContactName() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtContactName')]"));
    }

    public WebElement thirdPartyAtFaultName() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtName')]"));
    }

    public WebElement thirdPartyAtFaultEmail() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtEmail')]"));
    }

    public WebElement thirdPartyAtFaultAddress() {
        return waitForElementPresent(By.xpath("//textarea[contains(@id,'txtAddress')]"));
    }

    public WebElement thirdPartyAtFaultSaveBtn() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
    }

    public WebElement thirdPartyAtFaultContactSaveButton() {
        return waitForElementPresent(By.xpath("//div[@id='ucMandatoryFieldEditor_holder']/table/tbody/tr[3]/td/div/div/div/div/input[1]"));
    }

    public WebElement thirdPartyAtFaultContactUpdateCheck(String updatedValue) {
        return waitForElementPresent(By.xpath("//table[contains(@id,'grdTPContacts')]//td[contains(text(),'" + updatedValue + "')]"));
    }


    public WebElement thirdPartyAtContactFirstName() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtFirstName')]"));
    }

    public WebElement thirdPartyAtContactLastName() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtLastName')]"));
    }

    public WebElement thirdPartyAtContactTitle() {
        return waitForElementPresent(By.xpath("//td/select[contains(@id,'ddlTitle') and contains(@name,'ddlTitle')]"));
    }

}
