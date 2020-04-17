package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FinalisePaymentPage extends AbstractPage {

    public WebElement save() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
    }

    public WebElement paymetCommentSave() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_btnSave"));
    }

    public WebElement rbApproveBtn() {
        return waitForElementPresent(By.cssSelector("input[value='rbApprove']"));
    }

    public WebElement next() {
        return waitForElementPresent(By.cssSelector("input.button[value='Next']"));
    }

    public WebElement eveNext() {
        return waitForElementPresent(By.id("btnNext"));
    }

    public WebElement wizardFrame() {
        return waitForElementPresent(By.id("RadWindowContentFramectl00_cphBodyWithoutUpdatePanel_cphBody_rwmEvents_rwEventWizard"));
    }

    public WebElement finalisePaymentSave() {
        return waitForElementToBeClickableAndReturnElement(By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
    }

    public WebElement finalisePaymentNext() {
        return waitForElementPresent(By.id("btnNext"));
    }

    public WebElement cancel() {
        return waitForElementPresent(By.cssSelector("input.button[value='Cancel']"));
    }

    public WebElement selectClaimItems() {
        return waitForElementPresent(By.cssSelector("input.button[value='Select']"));
    }

    public WebElement claimItemsTable(String colName) {
        String xpath11 = "//h3[text()='Claim Items']/../div/div/table/tbody/tr/th[text()='" + colName + "']/../../../tbody";
        return waitForElementPresent(By.xpath(xpath11));
    }

    public WebElement claimPerilTable(String colName) {
        String xpath11 = "//h3[text()='Claim Perils']/../div/div/table/tbody/tr/th[text()='" + colName + "']/../../../tbody";
        return waitForElementPresent(By.xpath(xpath11));
    }

    public WebElement claimLimitsTable(String colName) {
        String xpath11 = "//h3[text()='Limits']/../div/div/table/tbody/tr/th[text()='" + colName + "']/../../../tbody";
        return waitForElementPresent(By.xpath(xpath11));
    }

    public WebElement ClaimPaymentChkBox(WebElement Mytable, int rowNo) {
        WebElement chkBx = Mytable.findElement(By.xpath("//tr[" + rowNo + "]/td[" + 15 + "]/input[@type='checkbox']"));
        return chkBx;
    }

    public WebElement getRowClaimPaymentChkBox(WebElement Mytable, String colName, String rowText) {
        int colNo = getCoulumnClaimItemsTable(Mytable, colName, "th");
        System.out.println("colNo for " + colName + " : # " + colNo);
        int rowNo = getRowClaimItemsTable(Mytable, colName, rowText, "th");
        System.out.println("rowNo for " + rowText + ": # " + rowNo);
        WebElement chkBx = Mytable.findElement(By.xpath("//tr[" + rowNo + "]/td[" + 15 + "]/input[@type='checkbox']"));
        return chkBx;
    }

    public int getCoulumnClaimItemsTable(WebElement Mytable, String srcCol, String tagN) {
        List<WebElement> rows = (List<WebElement>) Mytable.findElements(By.xpath("tr"));
        int iColIndex = 0;
        int row_num, col_num = 0;
        row_num = 1;
        for (WebElement row : rows) {
            List<WebElement> cols = (List<WebElement>) row.findElements(By.xpath("./*"));
            col_num = 1;
            for (WebElement col : cols) {
                if (col.getTagName().equalsIgnoreCase(tagN)) {
                    if (col.getText().equalsIgnoreCase(srcCol)) {
                        iColIndex = col_num;
                        break;
                    }
                    col_num++;
                }
            }
            row_num++;
        }
        return iColIndex;
    }

    public int getRowClaimItemsTable(WebElement Mytable, String colName, String srcText, String tagN) {
        List<WebElement> rows = (List<WebElement>) Mytable.findElements(By.xpath("tr"));
        int iColIndex = 0;
        int row_num, col_num = 0;
        row_num = 1;
        for (WebElement row : rows) {
            List<WebElement> cols = (List<WebElement>) row.findElements(By.xpath("./*"));
            col_num = 1;
            for (WebElement col : cols) {
                if (col.getTagName().equalsIgnoreCase(tagN)) {
                    if (col.getText().equalsIgnoreCase(colName)) {
                        iColIndex = col_num;
                        break;
                    }
                    col_num++;
                }
            }
            row_num++;
        }
        tagN = "td";
        row_num = 0;
        col_num = 0;
        row_num = 1;
        int iRowIndex = 0;
        for (WebElement row : rows) {
            List<WebElement> cols = (List<WebElement>) row.findElements(By.xpath("./*"));
            col_num = 1;
            for (WebElement col : cols) {
                if (col.getTagName().equalsIgnoreCase(tagN)) {
                    if (col.getText().equalsIgnoreCase(srcText)) {
                        iRowIndex = row_num;
                        break;
                    }
                    col_num++;
                }
            }
            row_num++;
        }
        return iRowIndex;
    }

    public List<Integer> getClaimRow1(List<List<String>> parameters, WebElement Mytable) {
        List<String> hl = new ArrayList<>();
        List<List<String>> nl = new ArrayList<List<String>>();
        List<List<String>> nl1 = new ArrayList<List<String>>();
        List<WebElement> rows = (List<WebElement>) Mytable.findElements(By.xpath("tr"));
        int trows_count = rows.size();
        for (int trow = 0; trow < trows_count; trow++) {
            List<WebElement> cols = (List<WebElement>) rows.get(trow).findElements(By.xpath("./th"));
            int rowColumns = cols.size();
            for (int tcol = 0; tcol < rowColumns; tcol++) {
                for (int c = 0; c < parameters.get(0).size(); c++) {

                    if (cols.get(tcol).getText().equals(parameters.get(0).get(c))) {
                        hl.add(cols.get(tcol).getText());
                    }
                }
                if (tcol == (rowColumns - 1)) {
                    hl.add("SelectRow");
                }
            }
        }
        nl1.add(hl);

        int rows_count1 = rows.size();
        for (int row = 1; row < rows_count1; row++) {
            List<WebElement> Columns_row = rows.get(row).findElements(By.xpath("./td"));
            List<WebElement> ColumnsHd_row = rows.get(0).findElements(By.tagName("th"));
            List<String> ul1 = new ArrayList<String>();
            int columns_count = Columns_row.size();
            int lis = 0;
            if (columns_count > 0) {
                for (int column = 0; column < columns_count; column++) {
                    for (int c = 0; c < parameters.get(0).size(); c++) {
                        if (ColumnsHd_row.get(column).getText().equals(parameters.get(0).get(c))) {
                            if (parameters.get(0).get(c).equals("Payment1")) {
                                String celText = Integer.toString(row + 1);
                                ul1.add(celText);
                                System.out.println("row#" + row + "col#" + column + ":" + celText + "|");
                            } else {
                                String celText = Columns_row.get(column).getText();
                                ul1.add(celText);
                                System.out.println("row#" + row + "col#" + column + ":" + celText + "|");
                            }
                        }
                    }
                    if (column == columns_count - 1) {
                        String celText = Integer.toString(row + 1);
                        ul1.add(celText);
                        System.out.println("row#" + row + "col#" + column + ":" + celText + "|");
                    }
                }
                nl1.add(ul1);
            }
        }
        System.out.println("nl1.size()" + nl1.size());
        System.out.println("nl1.get(0).size()" + nl1.get(0).size());
        System.out.println("---------------Col list-------------");
        for (int row1 = 0; row1 < nl1.size(); row1++) {
            for (int column = 0; column < nl1.get(row1).size(); column++) {
                System.out.print(nl1.get(row1).get(column) + " ;");
            }
            System.out.println("");
        }
        return compareList1(parameters, nl1);
    }

    public List<Integer> compareList1(List<List<String>> firstList, List<List<String>> secondList) {
        List<Integer> comparingList = new ArrayList<Integer>();
        for (int a = 0; a < firstList.size(); a++) {
            comparingList.add(0);
        }
        int flag = 0;
        String findrow = "";
        int cmp = firstList.get(0).size() - 1;
        System.out.println("firstList.size()=" + firstList.size());
        System.out.println("secondList.size()" + secondList.size());
        System.out.println("firstList.get(0).size()=" + firstList.get(0).size());
        System.out.println("secondList.get(0).size()" + secondList.get(0).size());
        System.out.println("cmp:" + cmp);
        for (int rowCounter = 1; rowCounter < firstList.size(); rowCounter++) {
            for (int rowCounter1 = 1; rowCounter1 < secondList.size(); rowCounter1++) {
                flag = 0;
                for (int counter2 = 0; counter2 < secondList.get(rowCounter1).size(); counter2++) {
                    if (secondList.get(rowCounter1).get(counter2).equals(firstList.get(rowCounter).get(counter2))) {
                        flag++;
                        if (flag == cmp) {
                            findrow = secondList.get(rowCounter1).get(secondList.get(rowCounter1).size() - 1);
                            comparingList.set(rowCounter, Integer.parseInt(findrow));
                        }
                    }
                }
            }
        }
        System.out.println("comparing list");
        for (int a = 0; a < comparingList.size(); a++) {
            System.out.println(comparingList.get(a));
        }
        return comparingList;
    }

    public List<List<String>> convertList1(List<List<String>> parameters) {
        List<List<String>> nl = new ArrayList<List<String>>();
        List<List<String>> nl1 = new ArrayList<List<String>>();
        int trows_count = parameters.size();
        int rowColumns = parameters.get(0).size();
        for (int r = 0; r < trows_count; r++) {
            List<String> hl = new ArrayList<>();
            for (int c = 0; c < rowColumns; c++) {
                hl.add(parameters.get(r).get(c));
                if (c == (rowColumns - 1)) {
                    hl.add("SelectRow");
                }
            }
            nl1.add(hl);
        }
        System.out.println("nl1.size()" + nl1.size());
        System.out.println("nl1.get(0).size()" + nl1.get(0).size());
        System.out.println("---------------Col list-------------");
        for (int row1 = 0; row1 < nl1.size(); row1++) {
            for (int column = 0; column < nl1.get(row1).size(); column++) {
                System.out.print(nl1.get(row1).get(column) + " ;");
            }
            System.out.println("");
        }
        return nl1;
    }

    public WebElement finalisePaymentAddComment() {
        String xpath11 = "//textarea[contains(@id,'ucMandatoryFieldEditor')]";
        return waitForElementPresent(By.xpath(xpath11));
    }

    public WebElement selectCompleteClaim() {
        String xpath11 = "//*[@id=\"ddlEventToAdd\"]";
        return waitForElementPresent(By.xpath(xpath11));
    }

    public WebElement paymentDetailsSave() {
        return waitForElementToBeClickableAndReturnElement(By.id("btnCustomSave"));
    }

    public WebElement paymentDetailsClose() {
        return waitForElementPresent(By.id("fancybox-close"));
    }

    public WebElement validateBankAcctDetailsBtn() {
        return waitForElementPresent(By.xpath("//input[contains(@value, 'Confirm Account Details')]"));

    }

    public WebElement bankAcctValidationMessage() {
        return waitForElementPresent(By.xpath("//span[contains(text(), 'Validation successful')]"));

    }

    public WebElement referCustomerValidation_Comments() {
        return waitForElementPresent(By.xpath("//textarea[contains(@id,'txtComments')]"));
    }

    public WebElement ooppaymentfailurenotificationincident() {
        return waitForElementPresent(net.serenitybdd.core.annotations.findby.By.xpath("//td[contains(text(),'OOP Notify Payment Failure')]"));
    }

    public WebElement referCustomerValidation_Finish() {
        return waitForElementPresent(By.xpath("//input[@value='Finish']"));

    }

    public WebElement Failurecode() {
        return waitForElementPresent(net.serenitybdd.core.annotations.findby.By.xpath("//span[contains(text(),'Payment Reference')]"));
    }

    public WebElement FailureDescription() {
        return waitForElementPresent(net.serenitybdd.core.annotations.findby.By.xpath("//span[contains(text(),'Payment Reference')]"));
    }

    public WebElement caseid() {
        return waitForElementPresent(net.serenitybdd.core.annotations.findby.By.xpath("//*[@id='lblCaseID']"));

    }

    public WebElement workflowcaseid() {
        return waitForElementPresent(net.serenitybdd.core.annotations.findby.By.xpath("(//table[contains(@id,'rgWorkflowTasks')]/tbody/tr/td/a[@title='Go to this lead and case'])[last()]"));
    }

    public WebElement emailnotificationincident() {
        return waitForElementPresent(net.serenitybdd.core.annotations.findby.By.xpath("//td[contains(text(),'OOP Failed Payment - New Details Required | Email')]"));
    }

    public WebElement windowclose() {
        return waitForElementPresent(net.serenitybdd.core.annotations.findby.By.xpath("//*[@id=\"btnCloseWindow\"]"));
    }

    public WebElement CustomerContactRequirednotificationincident() {
        return waitForElementPresent(net.serenitybdd.core.annotations.findby.By.xpath("//td[contains(text(),'Customer Contact Required')]"));
    }

    public WebElement dateofpaymentfailure() {
        return waitForElementPresent(net.serenitybdd.core.annotations.findby.By.xpath("//*[@id=\"rgEventHistory_ctl01\"]/tbody/tr[2]/td[1]"));
    }
    public WebElement commentsForAirAmbulanceQuotes(){
        try{
            return waitForElementPresent(By.xpath("//span[contains(text(),'Air Ambulance Quote and selected option')]/../following-sibling::td/textarea"));
        }catch (Exception e) {
            return waitForElementPresent(By.id("ucMandatoryFieldEditor_304318_noHiddenInformationLabel_55303762"));
        }
    }

}
