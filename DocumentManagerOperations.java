package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.WebTable;
import co.uk.directlinegroup.tt.utils.common.DateOperations;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DocumentManagerOperations {
    private DocumentManager documentManagerPgOb = new DocumentManager();
    private WebTable webTableObj = new WebTable();
    private DateOperations dateOperationsObj = new DateOperations();
    private IReportingPage iReportingPage = new IReportingPage();

    public void searchDocInDocManager(String strDocID){
        documentManagerPgOb.waitForMoreTime();
        documentManagerPgOb.waitForMoreTime();
        documentManagerPgOb.waitForMoreTime();
        documentManagerPgOb.btnClick(documentManagerPgOb.openAll());
        documentManagerPgOb.waitForMoreTime();
        documentManagerPgOb.waitForMoreTime();
        documentManagerPgOb.waitForMoreTime();
        documentManagerPgOb.waitForMoreTime();
        documentManagerPgOb.searchedDoc(strDocID).click();
    }

    public void editDocTemplate(String strDocID){
        documentManagerPgOb.btnClick(documentManagerPgOb.edit());
    }

    public void manageVersions(String strUser){
        documentManagerPgOb.btnClick(documentManagerPgOb.manageVersions());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int iActiveColIndex = webTableObj.getColumnFromWebTable(documentManagerPgOb.documentVersionTable(),"Active");
        int iArchiveColIndex = webTableObj.getColumnFromWebTable(documentManagerPgOb.documentVersionTable(),"Archived");
        System.out.println("iActiveColIndex========"+iActiveColIndex);
        System.out.println("iArchiveColIndex========"+iArchiveColIndex);
        int iModifiedBy = webTableObj.getColumnFromWebTable(documentManagerPgOb.documentVersionTable(),"Modified By");
        int iModifiedOn = webTableObj.getColumnFromWebTable(documentManagerPgOb.documentVersionTable(),"Modified On");
        List<WebElement> lstRows = documentManagerPgOb.documentVersionTable().findElements(By.tagName("tr"));
        if(lstRows.size()>0){
            int iActiveDocRow = webTableObj.getRowFromWebTable(documentManagerPgOb.documentVersionTable(),iActiveColIndex,"Active");
            int iArchiveDocRow = webTableObj.getRowFromWebTable(documentManagerPgOb.documentVersionTable(),iArchiveColIndex,"True");
            System.out.println("iActiveDocRow========"+iActiveDocRow);
            System.out.println("iArchiveDocRow========"+iArchiveDocRow);
            documentManagerPgOb.editVersionBtn().get(iActiveDocRow).click();
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            documentManagerPgOb.btnClick(documentManagerPgOb.archiveChkBox());
           documentManagerPgOb.btnClick(iReportingPage.btnSave());
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            documentManagerPgOb.editVersionBtn().get(iArchiveDocRow).click();
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           String strCurrDate = dateOperationsObj.getCurrentDate();
           documentManagerPgOb.activeDate().sendKeys(strCurrDate);
           documentManagerPgOb.archiveChkBox().click();
           documentManagerPgOb.btnClick(iReportingPage.btnSave());
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Assert.assertTrue(webTableObj.getCellValue(documentManagerPgOb.documentVersionTable(),iActiveDocRow,iArchiveColIndex).contains("True"));
            Assert.assertTrue(webTableObj.getCellValue(documentManagerPgOb.documentVersionTable(),iArchiveDocRow,iActiveColIndex).contains("Active"));
            Assert.assertTrue(webTableObj.getCellValue(documentManagerPgOb.documentVersionTable(),iActiveDocRow,iModifiedBy).contains(strUser));
            Assert.assertTrue(webTableObj.getCellValue(documentManagerPgOb.documentVersionTable(),iActiveDocRow,iModifiedOn).contains(strCurrDate));
            Assert.assertTrue(webTableObj.getCellValue(documentManagerPgOb.documentVersionTable(),iArchiveDocRow,iModifiedBy).contains(strUser));
            Assert.assertTrue(webTableObj.getCellValue(documentManagerPgOb.documentVersionTable(),iArchiveDocRow,iModifiedOn).contains(strCurrDate));
            documentManagerPgOb.btnClick(documentManagerPgOb.doneBtn());
        }
    }
}