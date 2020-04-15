package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.StringOperations;
import co.uk.directlinegroup.tt.utils.common.WebTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Will be used to write any reusable methods related to product testing
 */
public class AQConfigurations {

    private WebTable webTableObj = new WebTable();
    private ResourcesAndTablesPage resourcesAndTablesPageObj = new ResourcesAndTablesPage();
    private PaymentApprovalLimitsPage paymentApprovalLimitsPageObj = new PaymentApprovalLimitsPage();
    private StringOperations stringOperationsObj = new StringOperations();
    private ManageNoteTypesPage manageNoteTypesPageObj = new ManageNoteTypesPage();
    private FullEventHistoryPage fullEventHistoryPageObj = new FullEventHistoryPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();

    public void editPageDetails(String strPageName) {
        int iColToIdentifyRow = webTableObj.getColumnFromWebTable(resourcesAndTablesPageObj.resourcesTable(), "Page Name");
        int iColToClick = webTableObj.getColumnFromWebTable(resourcesAndTablesPageObj.resourcesTable(), "Edit Resource Values");
        webTableObj.clickSpecificColEleInSpecificRow(resourcesAndTablesPageObj.resourcesTable(), strPageName, iColToIdentifyRow, iColToClick);
    }

    public void addUpdateDeletePaymentApprovalLimit(String strAction, List<List<String>> lstExpPaymentApprLimitConfig) {
        boolean bMatchFound = true;
         for (int iRow = 1; iRow < lstExpPaymentApprLimitConfig.size(); iRow++) {
            for (int iCol = 0; iCol < lstExpPaymentApprLimitConfig.get(0).size(); iCol++) {
                String strFieldName = lstExpPaymentApprLimitConfig.get(0).get(iCol).toLowerCase();
                String strData = lstExpPaymentApprLimitConfig.get(iRow).get(iCol);
                switch (strFieldName) {
                    case "level":
                        if (strAction.equalsIgnoreCase("update") || strAction.equalsIgnoreCase("delete")) {
                            bMatchFound = false;//set the variable to say no match found and use for reporting in latter part of this method
                            paymentApprovalLimitsPageObj.levelName().clear();
                            paymentApprovalLimitsPageObj.levelName().sendKeys(strData.trim());
                            paymentApprovalLimitsPageObj.levelNameFilter().click();
                            paymentApprovalLimitsPageObj.levelNameFilterContains().click();
                            List<WebElement> iRows = paymentApprovalLimitsPageObj.paymentApprovalLimitTable().findElements(By.tagName("tr"));
                            //  for (int iRowIndexToUpdate = 3; iRowIndexToUpdate < iRows.size(); iRowIndexToUpdate++) {
                            //  List<WebElement> iCols = iRows.get(iRowIndexToUpdate).findElements(By.tagName("td"));
                            // String strActLevelFromTable = iCols.get(iLevelIndex).getText();
                            //   if (strActLevelFromTable.trim().equalsIgnoreCase(strData.trim())) {
                            if (strAction.equalsIgnoreCase("update")) {
                                //    System.out.println("xpath-----------------------"+(iRowIndexToUpdate - 2)+"---------------"+"(//a[text()='Select'])[" + (iRowIndexToUpdate - 2) + "]");
                                //   iCols.get(0).findElement(By.xpath("(//a[text()='Select'])[" + (iRowIndexToUpdate - 2) + "]")).click();
                                nextEventPageObj.findElement(By.xpath("//td[text()='"+strData.trim()+"']/..//a[text()='Select']")).click();
                                bMatchFound = true;
                                break;
                            } else if (strAction.equalsIgnoreCase("delete")) {
                                //   iCols.get(1).findElement(By.xpath("(//a[text()='Delete'])[" + (iRowIndexToUpdate - 2) + "]")).click();
                                nextEventPageObj.findElement(By.xpath("//td[text()='"+strData.trim()+"']/..//a[text()='Delete']")).click();
                                bMatchFound = true;
                                break;
                            }
                        }
                        if (!strAction.equalsIgnoreCase("delete")) {
                            paymentApprovalLimitsPageObj.level().clear();
                            paymentApprovalLimitsPageObj.level().sendKeys(strData);
                        }
                        break;
                    case "paymentapprovallimit":
                        paymentApprovalLimitsPageObj.paymentApprovalLimit().clear();
                        paymentApprovalLimitsPageObj.paymentApprovalLimit().sendKeys(strData);
                        break;
                    case "selfapprovallimit":
                        paymentApprovalLimitsPageObj.selfApprovalLimit().clear();
                        paymentApprovalLimitsPageObj.selfApprovalLimit().sendKeys(strData);
                        break;
                }
                if (!bMatchFound) {
                    System.out.println("Error==============Matching Level " + strData + " not found to update/delete Threshold");
                    Assert.assertTrue(false);
                }
                if (strAction.equalsIgnoreCase("delete")) {
                    break;
                }
            }
            if (strAction.equalsIgnoreCase("add") || strAction.equalsIgnoreCase("update")) {
                paymentApprovalLimitsPageObj.addUpdate().click();
                //this.validatePaymentApprovalLimitSetUp( lstExpPaymentApprLimitConfig );
            }
        }
    }

    public void validatePaymentApprovalLimitSetUp(List<List<String>> lstExpPaymentApprLimitConfig) {
        List<List<String>> lstActPaymentApprLimitConfig = new ArrayList<List<String>>();
        String strContinue = "Yes";
        paymentApprovalLimitsPageObj.switchToFrameById(paymentApprovalLimitsPageObj.dialogFrame());
        int iLevelIndex = webTableObj.getColumnFromWebTable(paymentApprovalLimitsPageObj.paymentApprovalLimitTable(), "Level");
        int iPaymentApprLimitIndex = webTableObj.getColumnFromWebTable(paymentApprovalLimitsPageObj.paymentApprovalLimitTable(), "Payment Approval Limit");
        int iSelfApprLimitIndex = webTableObj.getColumnFromWebTable(paymentApprovalLimitsPageObj.paymentApprovalLimitTable(), "Self Approval Limit");
        lstActPaymentApprLimitConfig.add(Arrays.asList("Level", "PaymentApprovalLimit", "SelfApprovalLimit"));
        do {
            List<WebElement> iRows = paymentApprovalLimitsPageObj.paymentApprovalLimitTable().findElements(By.tagName("tr"));
            for (int iRow = 3; iRow < iRows.size(); iRow++) {
                List<WebElement> iCols = iRows.get(iRow).findElements(By.tagName("td"));
                lstActPaymentApprLimitConfig.add(Arrays.asList(iCols.get(iLevelIndex).getText().trim(), iCols.get(iPaymentApprLimitIndex).getText().trim(), iCols.get(iSelfApprLimitIndex).getText().trim()));
            }
            if (paymentApprovalLimitsPageObj.elementDisplayed(By.linkText("Next"))) {
                paymentApprovalLimitsPageObj.next().click();
            } else {
                break;
            }
        } while (strContinue.equalsIgnoreCase("Yes"));
        Assert.assertTrue(stringOperationsObj.checkExpListInActList(lstExpPaymentApprLimitConfig, lstActPaymentApprLimitConfig));
    }

    public void fillInNoteCategoryDetails(List<List<String>> lstNoteCategoryDetails) {
        for (int row = 1; row < lstNoteCategoryDetails.size(); row++) {
            for (int column = 0; column < lstNoteCategoryDetails.get(0).size(); column++) {
                String searchField = lstNoteCategoryDetails.get(0).get(column);
                String searchValue = lstNoteCategoryDetails.get(row).get(column);
                if (!searchValue.equalsIgnoreCase("Nothing Entered") && !searchValue.isEmpty() && searchValue != null) {
                    switch (searchField.toLowerCase()) {
                        case "notecategory":
                            break;
                        case "name":
                            manageNoteTypesPageObj.name().clear();
                            manageNoteTypesPageObj.name().sendKeys(searchValue);
                            break;
                        case "description":
                            manageNoteTypesPageObj.description().clear();
                            manageNoteTypesPageObj.description().sendKeys(searchValue);
                            break;
                        case "enabled":
                            if (searchValue.equalsIgnoreCase("Yes")) {
                                if (manageNoteTypesPageObj.enableForUse().getAttribute("checked") == null) {
                                    manageNoteTypesPageObj.enableForUse().click();
                                }
                            }
                            if (searchValue.equalsIgnoreCase("No")) {
                                if (manageNoteTypesPageObj.enableForUse().getAttribute("checked") != null) {
                                    manageNoteTypesPageObj.enableForUse().click();
                                }
                            }
                            break;
                        case "alertcolor":
                            manageNoteTypesPageObj.alertColor().clear();
                            manageNoteTypesPageObj.alertColor().sendKeys(searchValue);
                            break;
                        case "normalcolor":
                            manageNoteTypesPageObj.normalColor().clear();
                            manageNoteTypesPageObj.normalColor().sendKeys(searchValue);
                            break;
                        case "accesstype":
                            new Select(manageNoteTypesPageObj.acessType()).selectByVisibleText(searchValue);
                            break;
                    }
                }
            }
        }
    }

    public void addNoteCategory(List<List<String>> lstNoteCategoryDetails) {
        manageNoteTypesPageObj.newRecord().click();
        this.fillInNoteCategoryDetails(lstNoteCategoryDetails);
        manageNoteTypesPageObj.save().click();
    }

    public void amendNoteCategory(List<List<String>> lstNoteCategoryDetails) {
        boolean bFound = false;
        int iNameIndex = webTableObj.getColumnFromWebTable(manageNoteTypesPageObj.manageNoteTypesTable(), "Name");
        int iEnabledIndex = webTableObj.getColumnFromWebTable(manageNoteTypesPageObj.manageNoteTypesTable(), "Enabled");
        List<WebElement> lstRows = manageNoteTypesPageObj.manageNoteTypesTable().findElements(By.tagName("tr"));
        for (int iIndex = 1; iIndex < lstNoteCategoryDetails.size(); iIndex++) {
            String strNoteCategory = lstNoteCategoryDetails.get(iIndex).get(0);
            System.out.println("strNoteCategory===" + strNoteCategory);
            for (int row = 2; row < lstRows.size(); row++) {
                List<WebElement> lstCols = lstRows.get(row).findElements(By.tagName("td"));
                String strNoteNameFromTable = lstCols.get(iNameIndex).getText();
                System.out.println("strNoteNameFromTable==" + strNoteNameFromTable);
                if (strNoteNameFromTable.equalsIgnoreCase(strNoteCategory)) {
                    System.out.println("lstCols.get(iEnabledIndex).findElement(By.tagName(\"img\")).getAttribute(\"src\")==" + lstCols.get(iEnabledIndex).findElement(By.tagName("img")).getAttribute("src"));
                    if (lstCols.get(iEnabledIndex).findElement(By.tagName("img")).getAttribute("src").endsWith("images/icons/tick.png")) {
                        System.out.println("row==" + row);
                        manageNoteTypesPageObj.editNoteCategoryDetailsBtn().get(row - 2).click();
                        this.fillInNoteCategoryDetails(lstNoteCategoryDetails);
                        manageNoteTypesPageObj.save().click();
                        manageNoteTypesPageObj.waitForMoreTime();
                        bFound = true;
                        break;
                    }
                }
            }
            if (!bFound) {
                System.out.println("Amend Note Category Details==========No matching records found for the note category" + strNoteCategory);
                Assert.assertTrue(false);
            }
        }
    }

    public void setUpIncident(List<List<String>> lstIncidents) {
        fullEventHistoryPageObj.switchToParentFrame();
        for (int row = 1; row < lstIncidents.size(); row++) {
            System.out.println(lstIncidents.size());
            for (int column = 0; column < lstIncidents.get(row).size(); column++) {
                String strSearchField = lstIncidents.get(0).get(column);
                String strSearchValue = lstIncidents.get(row).get(column);
                switch (strSearchField.toLowerCase()) {
                    case "incidentname":
                        fullEventHistoryPageObj.waitForMoreTime();
                        fullEventHistoryPageObj.incidentName().clear();
                        fullEventHistoryPageObj.incidentName().sendKeys(strSearchValue);
                        break;
                    case "incidentdescription":
                        fullEventHistoryPageObj.waitForMoreTime();
                        fullEventHistoryPageObj.incidentDescription().clear();
                        fullEventHistoryPageObj.incidentDescription().sendKeys(strSearchValue);
                        break;
                    case "incidentdate":
                        fullEventHistoryPageObj.waitForMoreTime();
                        fullEventHistoryPageObj.incidentDate().clear();
                        fullEventHistoryPageObj.incidentDate().sendKeys(strSearchValue);
                        break;
                    case "sortorder":
                        fullEventHistoryPageObj.waitForMoreTime();
                        fullEventHistoryPageObj.sortOrder().clear();
                        fullEventHistoryPageObj.sortOrder().sendKeys(strSearchValue);
                        break;
                    case "status":
                        fullEventHistoryPageObj.waitForMoreTime();
                        fullEventHistoryPageObj.status().click();
                        fullEventHistoryPageObj.statusValue(strSearchValue).click();
                        break;
                    default:
                        System.out.println("case not found");
                }
            }
        }
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.update().click();
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.switchToParentFrame();
        fullEventHistoryPageObj.btnClick(fullEventHistoryPageObj.saveAndClose());
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.waitForMoreTime();
        if (fullEventHistoryPageObj.saveAndCloseDisplayed()) {
            fullEventHistoryPageObj.waitForMoreTime();
            fullEventHistoryPageObj.btnClick(fullEventHistoryPageObj.saveAndClose());
            fullEventHistoryPageObj.waitForMoreTime();
        }
    }

    public void addNote(List<List<String>> lstNoteCategory) {
        nextEventPageObj.switchToDefault();
        claimSummaryPageObj.noteEvent().click();
        nextEventPageObj.btnClick(nextEventPageObj.go());
        for (int i = 1; i < lstNoteCategory.size(); i++) {
            for (int j = 0; j < lstNoteCategory.get(i).size(); j++) {
                this.fillInNoteCategory(lstNoteCategory.get(0).get(j), lstNoteCategory.get(i).get(j));
            }
        }
        claimSummaryPageObj.finish_btn().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
    }

    public void fillInNoteCategory(String fieldName, String fieldValue) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        switch (fieldName.toLowerCase()) {
            case "notetype":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                new Select(manageNoteTypesPageObj.noteType()).selectByVisibleText(fieldValue);
                System.out.println("noteType--------------" + fieldValue);
                break;
            case "notedescription":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                manageNoteTypesPageObj.noteDescription().sendKeys(fieldValue);
                System.out.println("noteType--------------" + fieldValue);
                break;
            case "priority":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                new Select(manageNoteTypesPageObj.notePriority()).selectByVisibleText(fieldValue);
                System.out.println("noteType--------------" + fieldValue);
                break;

        }
    }
}