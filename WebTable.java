package co.uk.directlinegroup.tt.utils.common;


import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class WebTable {



    //      private NextEventPage nextEventPageObj = new NextEventPage();

    public void checkWebTableHeadings(WebElement wbTable, List<List<String>> fields, int iStartCol) {
        SoftAssertions softAssertions = new SoftAssertions();
        List<WebElement> th_collection = wbTable.findElements(By.tagName("th"));
        boolean bFound = false;
        for (int iField = 0; iField < fields.get(0).size(); iField++) {
            bFound = false;
            String strValueToCheck = fields.get(0).get(iField);
            for (int iHeading = iStartCol; iHeading < th_collection.size(); iHeading++) {
                if (th_collection.get(iHeading).getText().equalsIgnoreCase(strValueToCheck)) {
                    bFound = true;
                    softAssertions.assertThat(th_collection.get(iHeading).getText()).describedAs("Validating if column with heading "+ strValueToCheck +" is displayed").contains(strValueToCheck);
                    break;
                }
            }
            if (!bFound) {
                softAssertions.assertThat("Cannot find the column with heading"+ strValueToCheck + " in WebTable");
            }
        }
        softAssertions.assertAll();
    }

    public void checkWebTableCellsNotEmpty(WebElement wbTable) {
        SoftAssertions softAssertions = new SoftAssertions();
        List<WebElement> tr_collection = wbTable.findElements(By.tagName("tr"));
        for (WebElement tr : tr_collection) {
            List<WebElement> td_collection = tr.findElements(By.tagName("td"));
            for (int iCol = 1; iCol < td_collection.size() - 2; iCol++) {
                softAssertions.assertThat(!td_collection.get(iCol).getText().isEmpty()).describedAs("Validating column "+ iCol + " is not empty");
            }
        }
        softAssertions.assertAll();
    }

    public List<List<String>> getWebTable(WebElement wbTable) {
        List<WebElement> tr_collection = wbTable.findElements(By.tagName("tr"));
        List<List<String>> allWebTableData = new ArrayList<List<String>>();
        List<String> rowData = new ArrayList<>();
        List<WebElement> th_headerCollection = wbTable.findElements(By.tagName("th"));
        for (int i = 0; i < th_headerCollection.size(); i++) {
           rowData.add(th_headerCollection.get(i).getText().toString());
        }
        allWebTableData.add(rowData);
        rowData = new ArrayList<>();
        for (int iRow = 1; iRow < tr_collection.size()-2; iRow++) {
            List<WebElement> td_collection =  tr_collection.get(iRow).findElements(By.tagName("td"));
            for (int iCol = 0; iCol < td_collection.size(); iCol++) {
               rowData.add(td_collection.get(iCol).getText().toString());
            }
            allWebTableData.add(rowData);
            rowData = new ArrayList<>();
        }
        return allWebTableData;
    }

    public int getColumnFromWebTable(WebElement wbTable, String colName) {
        int iCol = 0;
        try {
            List<WebElement> th_headerCollection = wbTable.findElements(By.tagName("th"));
            for (int i = 0; i < th_headerCollection.size(); i++) {
                if (th_headerCollection.get(i).getText().equalsIgnoreCase(colName)) {
                    iCol = i;
                    break;
                }
            }
        } catch (Exception ex) {
        }
        return iCol;
    }

    public int getRowFromWebTable(WebElement wbTable, int colIndex, String strData) {
        int iRowIndex = 0;
        try {
            List<WebElement> tr_Collection = wbTable.findElements(By.tagName("th"));
            for (int iRow = 0; iRow < tr_Collection.size(); iRow++) {
                List<WebElement> td_Collection = tr_Collection.get(iRow).findElements(By.tagName("td"));
                for (int iCol = 0; iCol < td_Collection.size(); iCol++) {
                    System.out.println("col value"+td_Collection.get(iCol).getText().trim());
                    if (td_Collection.get(iCol).getText().equalsIgnoreCase(strData)) {
                        iRowIndex = iRow;
                        break;
                    }
                }
            }
        } catch (Exception ex) {
        }
        return iRowIndex;
    }

    public void clickSpecificColEleInSpecificRow(WebElement wbTable, String strStringToMatchInRow, int iColToIdentifyRow, int iCol) {
        List<WebElement> rows = wbTable.findElements(By.tagName("tr"));
        for (WebElement r : rows) {
            List<WebElement> td_headerCollection = r.findElements(By.tagName("td"));
            for (int i = 0; i < td_headerCollection.size(); i++) {
                if (td_headerCollection.get(i).getText().equalsIgnoreCase(strStringToMatchInRow)) {
                    td_headerCollection.get(iCol).click();
                    break;
                }
            }
        }
    }

    public String getCellValue(WebElement wbTable, int iRow, int iCol) {
        List<WebElement> rows = wbTable.findElements(By.tagName("tr"));
        List<WebElement> cols = rows.get(iRow).findElements(By.tagName("td"));
        return cols.get(iCol).getText();
    }

    public int getNoofRows(WebElement wbTable){
        List<WebElement> rows = wbTable.findElements(By.tagName("tr"));
        return rows.size();
    }

    public int getNoofColumns(WebElement wbTable){
        List<WebElement> rows = wbTable.findElements(By.tagName("tr"));
        if(rows.size()>0) {
            List<WebElement> cols = rows.get(0).findElements(By.tagName("td"));
            return cols.size();
        }else {
            return 0;
        }
    }



}
