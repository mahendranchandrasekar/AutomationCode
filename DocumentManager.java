package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DocumentManager extends AbstractPage {
    public WebElement filter(){
        return waitForElementPresent(By.id("JSDocumentTree-SearchText"));
    }

    public WebElement searchedDoc(String strDocID){
        return waitForElementPresent(By.xpath("//a[contains(text(),'" + strDocID + "')]"));
    }

    public WebElement openAll(){
        return waitForElementPresent(By.id("JSDocumentTree-OpenAllBnt"));
    }

    public WebElement search(){
        return waitForElementPresent(By.id("JSDocumentTree-SearchBnt"));
    }

    public WebElement clear(){
        return waitForElementPresent(By.id("JSDocumentTree-ClearBnt"));
    }

    public WebElement edit(){
        return waitForElementPresent(By.linkText("Edit"));
    }

    public WebElement manageVersions(){
        return waitForElementPresent(By.id("btnShowVersionManager"));
    }

    public WebElement documentVersionTable(){
        return waitForElementPresent(By.className("MasterTable_Default"));
    }

    public List<WebElement> editVersionBtn(){
        return waitForElementsPresent(By.id("ctl00_cphBody_rptVersions_ctl01_btnEditVersion"));
    }

    public WebElement activeDate(){
        return waitForElementPresent(By.id("ctl00_cphBody_rdpActiveFromDate_dateInput_text"));
    }

    public WebElement archiveChkBox(){
        return waitForElementPresent(By.id("ctl00_cphBody_chkArchive"));
    }

//    public WebElement saveVersionBtn(){
//        return waitForElementPresent(By.id("ctl00_cphBody_btnSave"));
//    }

    public WebElement doneBtn(){
        return waitForElementPresent(By.id("ctl00_cphBody_btnVersionManagerCancel"));
    }
}