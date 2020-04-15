package co.uk.directlinegroup.tt.utils.common;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map Compare
 */
public class Operations {

    public void ListMapComp(List<Map<String, String>> currencyPairMapDT, List<Map<String, String>> currencyPairMap) {
        List<Integer> cmp = new ArrayList<Integer>();

        for (int i = 0; i < currencyPairMapDT.size(); i++) {
            cmp.add(0);
            System.out.println("row:" + i + "=" + 0);
        }
        int m1r = 0;
        int curr = 0;
        for (Map<String, String> map1 : currencyPairMapDT) {
            int c = 0;
            int m2r = 0;
            for (Map<String, String> map2 : currencyPairMap) {
                int flag = 0;
                for (String key : map1.keySet()) {
                    String val1 = map1.get(key);
                    String val2 = map2.get(key);
                    if (val1.equals(val2)) {
                        System.out.println("m1r:" + m1r + "m2r" + m2r);
                        System.out.println("val1:" + val1 + ";val2:" + val2);
                        flag++;
                        System.out.println("flag:" + flag);
                    }
                    if (flag >= 5) {
                        cmp.set(c, flag);
                    }
                }
                if (flag == 5) {
                    break;
                }
                m2r++;
            }
            m1r++;
            c++;
        }

        for (int i = 0; i < cmp.size(); i++) {
            System.out.println("cmp value" + cmp.get(i));
        }
    }

    public void ListMapComp(List<Map<String, String>> FirstListMap, List<Map<String, String>> SecondListMap, int f) {
        List<String> lstTags = new ArrayList<>();
        for (int i = 0; i < FirstListMap.size(); i++) {
            String st = "flag=" + String.valueOf(0) + ":" + FirstListMap.get(i).toString();
            lstTags.add(st);
        }
        //  int m1r = 0;
        // int curr = 0;
        for (int rowCounter = 0; rowCounter < FirstListMap.size(); rowCounter++) {
            for (int rowCounter2 = 0; rowCounter2 < SecondListMap.size(); rowCounter2++) {
                int flag = 0;
                for (String key : FirstListMap.get(rowCounter).keySet()) {
                    String val1 = FirstListMap.get(rowCounter).get(key);
                    String val2 = SecondListMap.get(rowCounter2).get(key);
                    if (val1.equals(val2)) {
                        flag++;
                    }
                }
                if (flag == 5) {
                    String st = "flag=" + String.valueOf(flag) + ":" + FirstListMap.get(rowCounter).toString();
                    lstTags.set(rowCounter, st);
                    break;
                }
            }
        }

        int iFailedTagsCount = 0;
        int iTotalTagsCount = lstTags.size();
        for (int iTagIndex = 0; iTagIndex < lstTags.size(); iTagIndex++) {
            if (lstTags.get(iTagIndex).contains("flag=0")) {
                System.out.println(lstTags.get(iTagIndex));
                iFailedTagsCount++;
            }
        }
        Assert.assertEquals(iFailedTagsCount + "out of" + iTotalTagsCount + " records are not matched", 0, iFailedTagsCount);
    }

    public List<List<String>> getWebTableData(WebElement wbTable, String Integration) {
        List<List<String>> lstTableData = new ArrayList<List<String>>();
        List<WebElement> lstRows = (List<WebElement>) wbTable.findElements(By.xpath("tr"));
        int trows_count = lstRows.size();
        int rows_count1 = lstRows.size();
        for (int row = 1; row < rows_count1; row++) {
            String className = lstRows.get(row).getAttribute("class");
            if (!className.equalsIgnoreCase("gridPaging")) {
                List<WebElement> lstCols = lstRows.get(row).findElements(By.xpath("./td"));
                List<String> lstTableRowData = new ArrayList<String>();
                int iColCount = lstCols.size();
                //   int lis = 0;
                if (iColCount > 0) {
                    if (Integration.equalsIgnoreCase("currencyexchange")) {
                        lstTableRowData.add("GBP");
                    }
                    for (int iCol = 0; iCol < iColCount; iCol++) {
                        String strCellText = lstCols.get(iCol).getText();
                        lstTableRowData.add(strCellText);
                    }
                    lstTableData.add(lstTableRowData);
                }
            }
        }
        return lstTableData;
    }

    public List<String> getHeaderFromTable(WebElement Mytable, String Integration) {
        List<String> hl = new ArrayList<>();
        //  List<List<String>> nl1 = new ArrayList<List<String>>();
        List<WebElement> rows = (List<WebElement>) Mytable.findElements(By.xpath("tr"));
        int trows_count = rows.size();
        if (Integration.equalsIgnoreCase("currencyexchange")) {
            hl.add("BaseCurrencyCode");
        }

        for (int trow = 0; trow < trows_count; trow++) {
            List<WebElement> cols = (List<WebElement>) rows.get(trow).findElements(By.xpath("./th"));
            int rowColumns = cols.size();
            for (int tcol = 0; tcol < rowColumns; tcol++) {
                hl.add(cols.get(tcol).getText());
            }
        }
        return hl;
    }

    public List<Map<String, String>> convertListtoMap(List<List<String>> parameters) {
        List<Map<String, String>> PairMapList = new ArrayList<Map<String, String>>();
        int trows_count = parameters.size();
        int rowColumns = parameters.get(0).size();
        for (int r = 1; r < trows_count; r++) {
            Map<String, String> Nodepair = new HashMap<String, String>();
            for (int c = 0; c < rowColumns; c++) {
                Nodepair.put(parameters.get(0).get(c), parameters.get(r).get(c));
            }
            PairMapList.add(Nodepair);
        }
        return PairMapList;
    }

  /*  public void displayMap(List<Map<String, String>> keyPairMap) {
        for (Map<String, String> map : keyPairMap) {
            for (String key : map.keySet()) {
                System.out.print(key + " - " + map.get(key));
            }
            System.out.println();
        }
    }*/
}