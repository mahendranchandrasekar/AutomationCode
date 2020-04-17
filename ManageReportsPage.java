package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ManageReportsPage extends AbstractPage {

    public WebElement reportAccess(String reportName) {
        return waitForElementPresent(By.xpath("//li[@clientid='427']/a[text()='" + reportName + "']"));
    }

    public WebElement editReport() {
        return waitForElementPresent(By.xpath("//div[@id='divToolbar']/a[text()='Edit']"));
    }

    public List<WebElement> reportAEdit() {
        return findElements(By.xpath("//div[@id='divToolbar']/a[text()='Edit']"));
    }

    public WebElement run() {
        return waitForElementPresent(By.id("btnRun"));
    }

    public WebElement reportCancel() {
        return waitForElementPresent(By.id("ctl00_cphBody_btnCancel"));
    }


    public WebElement reportClose() {
        return waitForElementPresent(By.xpath("//input[@type = 'button'][@value='Close']"));
    }


    public List<WebElement> reportNone(String reportName) {
        return findElements(By.xpath("//li[@clientid='427']/a[text()='" + reportName + "']"));
    }

    public WebElement miReports() {
        return waitForElementPresent(By.name("MI Reports"));
    }

    public WebElement noteTypeFootPrintReport() {
        return waitForElementPresent(By.name("NoteCategoryFootPrint"));
    }

    public WebElement runReportResultsTable() {
        return waitForElementPresent(By.id("ctl00_ContentPlaceHolder1_grdResults"));
    }

    public WebElement reportFolder(String folderName) {
        return waitForElementPresent(By.xpath("//li[@clientid='427'][@name='" + folderName + "']"));
    }

    public WebElement reportFolderOpenClose(String folderName) {
        return waitForElementPresent(By.xpath("//li[@clientid='427'][@name='" + folderName + "']/ins"));
    }


    public WebElement reportCount() {
        return waitForElementPresent(By.id("ctl00_ContentPlaceHolder1_lblCount"));
    }

    public WebElement pageNumberLink(String strPageNumber) {
        return waitForElementToBeClickableAndReturnElement(By.linkText(strPageNumber));
    }

    public boolean loadingPage(String strPageNumber) {
        return waitForElementInVisible(By.linkText(strPageNumber));
    }

    public WebElement validatePolicy(String policy){
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+policy+"')]"));
    }


    public WebElement txtWorkflowId(String WorkflowGroup){
        return waitForElementPresent(By.xpath("//table[@class='reportResultTable']//td[contains(text(),'"+WorkflowGroup+"')]"));
    }
    public WebElement txtClaimIdToTextBox(){
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl00_ContentPlaceHolder1')]"));
    }
}