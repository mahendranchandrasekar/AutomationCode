package co.uk.directlinegroup.tt.pages;

import co.uk.directlinegroup.tt.utils.common.WebTable;
import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class EvidenceCollationPage extends AbstractPage {

    public WebElement save1() {
        return waitForExpectedElement(By.id("ucMandatoryFieldEditor_customFieldSaveButton"), 10000);
    }

    public boolean saveIsDisplayed() {
        List<WebElement> lstWb = getDriver.findElements(By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
        if (lstWb.size() == 0) {
            return false;
        }
        return true;
    }

    public WebElement save() {
        return waitForElementToBeClickableAndReturnElement(By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
    }

    public WebElement othrInsSave() {
        return waitForElementPresent(By.xpath("//*[@id='ucMandatoryFieldEditor_btnSave']"));
    }

    public WebElement next() {
        return waitForElementPresent(By.cssSelector("input.button[value='Next']"));
    }

    public WebElement eveNext() {
        return waitForElementPresent(By.id("btnNext"));
    }

//    public WebElement cancel() {
//        return waitForElementPresent(By.id("btnCancel"));
//
//    }

    public WebElement cancel2() {
        return waitForElementPresent(By.xpath("//*[@id=\"btnCancel\"]"));
    }

    public WebElement claimCalculationSave() {
        try {
            return waitForElementPresent(By.xpath("//input[@id='ucMandatoryFieldEditor_btnSave']"));
        } catch (Exception e) {
            return waitForElementPresent(By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
        }
    }

    public WebElement saveBtn() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
    }

    public WebElement evidenceCollationWebTable() {
        return waitForElementPresent(By.xpath("//table[contains(@id,'grdEvidence')]"));
    }

    public WebElement evidenceCollateRows(int strRowno) {
        return waitForElementPresent(By.xpath("(//input[@type='checkbox'][contains(@id,'chkProvided')])[" + strRowno + "]"));
    }

    public WebElement evidenceTypeRows(String evidenceType) {
        return waitForElementPresent(By.xpath("//span[text()='" + evidenceType + "']"));
    }

    public WebElement evidenceCollationTable() {
        return waitForElementPresent(By.xpath("//h2[text()='Evidence Collation']/../div/div/div/table/tbody"));
    }

    public WebElement incidentsTable() {
        return waitForElementPresent(By.xpath("//h2[text()='Incidents']/../div/div/div/table/tbody"));
    }

    public WebElement OtherInsurer() {
        return waitForElementPresent(By.xpath("//*[@id=\"ucMandatoryFieldEditor_ddl301332_27565799_text\"]"));
    }

    public WebElement claimTable(String colName) {
        String xpath11 = "//h3[text()='Claim Items']/../div/div/table/tbody/tr/th[text()='" + colName + "']/../../../tbody";
        return waitForElementPresent(By.xpath(xpath11));
    }

    public WebElement ClaimPaymentChkBox(WebElement Mytable, int rowNo) {
        WebElement chkBx = Mytable.findElement(By.xpath("//tr[" + rowNo + "]/td[" + 15 + "]/input[@type='checkbox']"));
        return chkBx;
    }

    public WebElement providedChkBox(WebElement Mytable, int rowNo) {
        WebElement chkBx = Mytable.findElement(By.xpath("//tr[" + rowNo + "]/td[" + 4 + "]/input[@type='checkbox']"));
        return chkBx;
    }

    public String searchEvidenceCollationTableResultXPath() {
        return ".//*[@class='MasterTable_Default']/tbody/tr/td[contains(text(),'##SearchPage Value##')]";
    }

    public boolean searchEvidenceList(String strCol, String strValue) {
        List<WebElement> rows = (List<WebElement>) findElements(By.xpath(searchEvidenceCollationTableResultXPath().replace("##SearchPage Value##", strCol)));
        boolean txt = false;
        for (WebElement row : rows) {
            WebElement key = row.findElement(By.xpath("../td[2]"));
            String s = key.getText();
            if (s.equalsIgnoreCase(strValue)) {
                txt = true;
                break;
            }
        }
        return txt;
    }


    public void searchProvidedChkBox(String strText, String strText2) {
        List<WebElement> rows = (List<WebElement>) findElements(By.xpath(searchEvidenceCollationTableResultXPath().replace("##SearchPage Value##", strText)));
        for (WebElement row : rows) {
            WebElement key = row.findElement(By.xpath("../td[2]"));
            String s = key.getText();
            if (s.equalsIgnoreCase(strText2)) {
                row.findElement(By.xpath("../td[4]/input")).click();
            }
        }
    }

    public void searchNotRequiredChkBox(String strText, String strText2) {
        List<WebElement> rows = (List<WebElement>) findElements(By.xpath(searchEvidenceCollationTableResultXPath().replace("##SearchPage Value##", strText)));
        for (WebElement row : rows) {
            WebElement key = row.findElement(By.xpath("../td[2]"));
            String s = key.getText();
            if (s.equalsIgnoreCase(strText2)) {
                row.findElement(By.xpath("../td[5]/input")).click();
            }
        }
    }

    public void claimItemsTableList() {
        WebTable webTb = new WebTable();
        WebElement Mytable = claimTable("Claim ID");
        List<WebElement> rows = (List<WebElement>) Mytable.findElements(By.xpath("tr"));
        int row_num, col_num;
        row_num = 1;
        for (WebElement row : rows) {
            List<WebElement> cols = (List<WebElement>) row.findElements(By.xpath("./*"));
            col_num = 1;
            for (WebElement col : cols) {
                col_num++;
            }
            row_num++;
        }
        int colNo = getCoulumnClaimItemsTable(Mytable, "Cause", "th");
        System.out.println("colNo : # " + colNo);

        int rowNo = getRowClaimItemsTable(Mytable, "Cause", "Baggage", "th");
        System.out.println("rowNo : # " + rowNo);

        System.out.println("final : # " + Mytable.findElement(By.xpath(".//tr[" + rowNo + "]/td[" + colNo + "]")).getText());
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

    public WebElement contactDetails_Save() {
        return waitForElementPresent(By.cssSelector("input.button[value='Save']"));
    }

    public WebElement insurance_Type() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Home Insurance')]"));
    }

    public WebElement insurance_YesorNO() {
        return waitForElementPresent(By.xpath("//select[contains(@id,'ddlYesNo')]"));
    }

    public WebElement selectInsurer() {
        return waitForElementPresent(By.xpath("//select[contains(@id,'ddlInsurer')]"));
    }

    public WebElement policyNumber() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtPolicyNo')]"));
    }

    public WebElement selectPerson() {
        return waitForElementPresent(By.xpath("//select[contains(@id,'ddlPerson')]"));
    }

    public WebElement changeStatus() {
        return waitForElementPresent(By.xpath("//select[contains(@id,'ddlStatus')] "));
    }

    public WebElement paidAmount() {
        return waitForElementPresent(By.xpath("//input[@class='txtPaidAmount']"));
    }

    public WebElement selectAction() {
        return waitForElementPresent(By.xpath("//select[contains(@id,'ddlAction')]"));
    }

    public WebElement name() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Third Party Contacts')]/../following-sibling::div[1]/div[2]/table/tbody/tr/td[2]/input"));
    }

    public WebElement title() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Contact Title')]/../td[2]/select"));
    }

    public WebElement firstName() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Contact First Name')]/../td[2]/input"));
    }

    public WebElement lastName() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Contact Last Name')]/../td[2]/input"));
    }

    public WebElement email() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Email')]/../td[2]/input"));
    }

    public WebElement Address() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Address')]/../td[2]/textarea"));
    }

    public WebElement preferredContact() {
        return waitForElementPresent(By.xpath("//td[contains(text(),'Preferred Contact Method')]/../td[2]/select"));
    }

    public WebElement add_btn() {
        return waitForElementPresent(By.cssSelector("input.button[value='Add']"));
    }

    public WebElement contactDetails_Cancel() {
        return waitForElementPresent(By.cssSelector("input.button[value='Cancel']"));
    }

    public WebElement evidenceCollationTableQues(int i) {
        return waitForElementPresent(By.xpath("(//h2[text()='Evidence Collation']/../div/div/div/table/tbody/tr/td[3])[" + i + "]"));
    }

    public WebElement ResDropDown() {
        // return waitForElementPresent(By.xpath(".//div/input[starts-with(@id,'ucMandatoryFieldEditor_ddl301350_27570311_Input')]"));
        return waitForElementPresent(By.xpath("(//input[starts-with(@id,'ucMandatoryFieldEditor_ddl301350_')])[1]"));
    }

    public WebElement ResDropDownYes() {
        return waitForElementPresent(By.xpath(".//div[starts-with(@id,'ucMandatoryFieldEditor') and contains(text(),'Yes')]"));
    }

    public WebElement ResDropDownNo() {
        return waitForElementPresent(By.xpath(".//div[starts-with(@id,'ucMandatoryFieldEditor') and contains(text(),'No')]"));
    }

    public WebElement Resreason() {
        return waitForElementPresent(By.xpath("//textarea[starts-with(@id,'ucMandatoryFieldEditor_txt301351_')]"));
    }

    public WebElement ResRejDropDown() {
        return waitForElementPresent(By.xpath("(//input[starts-with(@id,'ucMandatoryFieldEditor_ddl301409_')])[1]"));
    }

    public WebElement ResRejDropDownSelect() {
        return waitForElementPresent(By.xpath(".//div[starts-with(@id,'ucMandatoryFieldEditor') and contains(text(),'deducted wrong')]"));
    }
    public WebElement submitted1() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Death Certificate')]"));
    }
    public WebElement submitted2() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Incident Report')]"));
    }
    public WebElement notSubmitted1() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Your booking invoice(s)')]"));
    }
    public WebElement notSubmitted2() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Medical Reports')]"));
    }
    public WebElement notSubmitted3() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Other Reports')]"));
    }

    public WebElement txt1Provided(){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Loss Report (inc Police)')]"));
    }
    public WebElement txt2Provided(){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Damage Report')]"));
    }

    public WebElement txt3NotRequired(){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Your booking invoice(s)')]"));
    }
    public WebElement txt4NotRequired(){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Proof of Ownership')]"));
    }

    public WebElement txt5NotRequired(){
        return waitForElementPresent(By.xpath("//span[contains(text(),'Loss Report (inc Police)')]"));
    }
    public WebElement chkBoxNotRequired(int row){
        return waitForElementPresent(By.xpath("(//input[@type='checkbox'][contains(@id,'chkNotRequired')])["+row+"]"));
    }

    public WebElement providedRow1() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Loss Report')]/../../td[4]/input"));
    }
    public WebElement providedRow2() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Damage Report')]/../../td[4]/input"));
    }
    public WebElement notRequiredRow3() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Your booking invoice(s)')]/../../td[5]/input"));
    }
    public WebElement notRequiredRow4() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Proof of Ownership')]/../../td[5]/input"));
    }
    public WebElement notRequiredRow5() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Personal Possessions Form')]/../../td[5]/input"));
    }

    public WebElement btnSavebutton() {
        return waitForElementPresent(By.name("ucMandatoryFieldEditor$customFieldSaveButton"));
    }


    public WebElement btnCancelbutton() {
        return waitForElementPresent(By.xpath("//input[starts-with(@name,'btnCancel')]"));
    }

    public WebElement evidence(String evidence){
        return waitForElementPresent(By.xpath("//span[contains(text(),'"+evidence+"')]"));
    }
    public WebElement evidenceClick(String evidence){
        return waitForElementPresent(By.xpath("//span[contains(text(),'"+evidence+"')]/../../td[4]//input"));
    }

    public WebElement contactFirstName() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtFirstName')]"));
    }
    public WebElement contactLastName() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'txtLastName')]"));
    }

    public WebElement evidenceNotProvided(String s) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+s+"')]/../following-sibling::td/span[@class='Provided']/input"));
    }
}
