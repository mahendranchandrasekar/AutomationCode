package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.common.DateOperations;
import co.uk.directlinegroup.tt.utils.common.TTConstants;
import co.uk.directlinegroup.tt.utils.common.WebTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class IReportingOperations {

    private Navigation navigationObj = new Navigation();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private IReportingPage iReportingPageObj = new IReportingPage();
    private PolicyOperations policyOperationsObj = new PolicyOperations();
    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private User userObj = new User();
    private DateOperations dateOperationsObj = new DateOperations();
    private QuoteAndBuyOperations quoteAndBuyOperationsObj = new QuoteAndBuyOperations();
    private LeftNavPanePage leftNavPaneObj = new LeftNavPanePage();
    private Commands commandsObj = new Commands();
    private CommonPage commonPageObj = new CommonPage();
    private WebTable webTableObj = new WebTable();
    private ManageReportsPage manageReportsPage=new ManageReportsPage();

    public String filterID = "40746";
    public static String affinionFeed = "";
    public static String affinionHeader = "";
    public static String uniqueFileText = "";
    public static String affinionState = "";
    public static String operationType = "";
    public static String primaryMemberExtRef = "";
    public static String primaryMemberFirstName = "";
    public static String primaryMemberLastName = "";
    public static String primaryMemberDOB = "";
    public static String mailingAddressPostCode = "";
    public static String accountNumber = "";
    public static String sortCode = "";
    public static String reconcileState = "";
    public static String reconcileMessage = "";
    public static String customerID = "";
    public static String policyAdminMatterID = "";
    public static String affinionData = "";
    public static String affinionHomePhone="";
    public static String affinionEmail="";

    public void createMIRenewalData(List<List<String>> parameters) {
        this.navigateToRenewalsReport();
        for (int i = 0; i < parameters.size(); i++) {
            System.out.println("----------i----------value ---" + i);
            for (int j = 0; j < parameters.get(i).size(); j++) {
                System.out.println("----------j----------value ---" + j);
                this.runRenewalDataReports(parameters.get(i).get(0));
                System.out.println("Report name -----------" + parameters.get(i).get(j));
            }
        }
    }

    public void runReport() {
        iReportingPageObj.run_Report().click();
        nextEventPageObj.waitForMoreTime();
        iReportingPageObj.run().click();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateTableValues() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        Assert.assertTrue(!iReportingPageObj.lblEarlyRenewalCount().getText().isEmpty());
        System.out.println("Validate table values are not empty");
        iReportingPageObj.btnClose().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToLastOpenWindow();
        manageReportsPage.reportCancel().click();
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(),60L);
    }

    public void navigateToRenewalsReport() {
        navigationObj.navigateToManageReport();
        iReportingPageObj.miReport().click();
        nextEventPageObj.waitForMoreTime();
        iReportingPageObj.travelPolicy().click();
        nextEventPageObj.waitForMoreTime();
        iReportingPageObj.expandRenewals().click();
        nextEventPageObj.waitForMoreTime();
    }

    public void runRenewalDataReports(String reports) {
        switch (reports) {
            case "Number of early Renewals generated in the month":
                System.out.println("Running monthly renewal report............");
                iReportingPageObj.lnkRenewalByMonth().click();
                nextEventPageObj.waitForMoreTime();
                this.runReport();
                this.validateTableValues();
                break;
            case "Number of early Renewals taken up in the period":
                System.out.println("early Renewals taken up in the period............");
                iReportingPageObj.lnkEarlyRenewalsTaken().click();
                nextEventPageObj.waitForMoreTime();
                this.runReport();
                this.validateTableValues();
                break;
            case "Number of early Renewals lapsed in the period":
                System.out.println("early Renewals taken up in the period............");
                iReportingPageObj.lnkEarlyRenewalsLapsed().click();
                nextEventPageObj.waitForMoreTime();
                this.runReport();
                this.validateTableValues();
                break;
        }
        }

    public void validateBarringDetails(String reportName, List<List<String>> parameters) {
        iReportingPageObj.miReport().click();
        nextEventPageObj.waitForMoreTime();
        iReportingPageObj.customerBarring().click();
        iReportingPageObj.customerBarringReport(reportName).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        iReportingPageObj.customerBarringReport("Edit").click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        iReportingPageObj.customerBarringReport("Columns").click();
        iReportingPageObj.filterForEmailID().click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        String email = policyOperationsObj.emailIdForReport;
        iReportingPageObj.thisValue().sendKeys(email);
        iReportingPageObj.evaluateBtn().click();
        iReportingPageObj.acceptBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        iReportingPageObj.srotResultEditLink().click();
        new Select(iReportingPageObj.filterForWhenModifiedSortSelect()).selectByVisibleText("ASC");
        iReportingPageObj.saveLink().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        iReportingPageObj.run().click();
        this.verifyTableDataForBarringDetails(parameters);
        iReportingPageObj.btnClose().click();
        iReportingPageObj.customerBarringReport("Edit").click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        iReportingPageObj.customerBarringReport("Columns").click();
        iReportingPageObj.filterForEmailID().click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        iReportingPageObj.btnClear().click();
        iReportingPageObj.evaluateBtn().click();
        iReportingPageObj.acceptBtn().click();
    }

    private void verifyTableDataForBarringDetails(List<List<String>> parameters) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        List<WebElement> lstRows = iReportingPageObj.reportTable().findElements(By.tagName("tr"));
        int iPolicyNumber = 21;//5;
        int iCustomerName = 20;
        int iBlockBarType = 8;//3;
        int iWhenCreated = 15;
        int iWhoAdded =13;// 14;
        int iReassessmentDate = 11;
        int iClaimNumber = 22;
        for (int j = 4; j < lstRows.size(); j++) {
            List<WebElement> lstWb = lstRows.get(j).findElements(By.tagName("td"));
            System.out.println("col size===" + lstWb.size());
            for (int k = 0; k < lstWb.size(); k++) {
                System.out.println(lstWb.get(k).getText());
            }
        }
        for (int row = 1; row < parameters.size(); row++) {
            if (lstRows.size() >= parameters.size()) {
                int iTableRowIndex = row + 2;
                for (int column = 0; column < parameters.get(0).size(); column++) {
                    List<WebElement> lstCols = lstRows.get(iTableRowIndex).findElements(By.tagName("td"));
                    String strFieldName = parameters.get(0).get(column);
                    String strFieldValue = parameters.get(row).get(column);
                    if (!strFieldValue.equalsIgnoreCase("<Blank>")) {
                        switch (strFieldName.toLowerCase()) {
                            case "policy number":
                                System.out.println("payment methid column vlaue --------------------------" + lstCols.get(iPolicyNumber).getText());
                                Assert.assertTrue(lstCols.get(iPolicyNumber).getText().equalsIgnoreCase(policyOperationsObj.policyNumber));
                                break;
                            case "customer name":
                                System.out.println("cusotmer name column vlaue --------------------------" + lstCols.get(iCustomerName).getText());
                                if (strFieldValue.equalsIgnoreCase("random")) {
                                    System.out.println("Customer Full Name" + quoteAndBuyOperationsObj.randomCustomerFullName);
                                    Assert.assertTrue(lstCols.get(iCustomerName).getText().equalsIgnoreCase(quoteAndBuyOperationsObj.randomCustomerFullName));
                                } else {
                                    Assert.assertTrue(lstCols.get(iCustomerName).getText().equalsIgnoreCase(strFieldValue));
                                }
                                break;
                            case "block / bar type":
                                System.out.println("cusotmer name column vlaue --------------------------" + lstCols.get(iBlockBarType).getText());
                                Assert.assertTrue(lstCols.get(iBlockBarType).getText().equalsIgnoreCase(strFieldValue));
                                break;
                            case "date added":
                                if (strFieldValue.equalsIgnoreCase("CurrentDate") | strFieldValue.equalsIgnoreCase("today")) {
                                    String strDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                                    strFieldValue = strDate;
                                }
                                Assert.assertTrue(lstCols.get(iWhenCreated).getText().contains(strFieldValue));
                                break;
                            case "who added":
                                System.out.println("appro value ---------------------------" + lstCols.get(iWhoAdded).getText());
                                System.out.println("input value-----------------------------" + strFieldValue);
                                Assert.assertTrue(lstCols.get(iWhoAdded).getText().equalsIgnoreCase(userObj.getUserDetails(strFieldValue).get(0)));
                                break;
                            case "reassessment date":
                                System.out.println("appro value ---------------------------" + lstCols.get(iReassessmentDate).getText());
                                System.out.println("input value-----------------------------" + strFieldValue);
                                Assert.assertTrue(lstCols.get(iReassessmentDate).getText().contains(dateOperationsObj.addingDays(2)));
                                break;
                            case "claim number":
                                System.out.println("payment methid column vlaue --------------------------" + lstCols.get(iClaimNumber).getText());
                                Assert.assertTrue(lstCols.get(iClaimNumber).getText().equalsIgnoreCase(claimsOperationsObj.calimcaseid));
                                break;
                        }
                    } else {
                        Assert.assertTrue(lstRows.size() >= (parameters.size()));
                    }
                }
            }
        }
    }

    public void affinionReportRun(String feedType) {
        if (feedType.equalsIgnoreCase("new")) {
            iReportingPageObj.automationReport().click();
            nextEventPageObj.waitForMoreTime();
            iReportingPageObj.integration().click();
            iReportingPageObj.affinionReport().click();
            this.runReport();
            this.getReportDataForAffinion(feedType);
            iReportingPageObj.btnClose().click();
        } else if (feedType.equalsIgnoreCase("amend")) {
            iReportingPageObj.miReport().click();
            nextEventPageObj.waitForMoreTime();
            iReportingPageObj.affinionFolder().click();
            nextEventPageObj.waitForMoreTime();
            iReportingPageObj.affinionChangeFieldValue().click();
            nextEventPageObj.waitForMoreTime();
            this.runReport();
            this.getReportDataForChangedData(feedType);
        } else if (feedType.equalsIgnoreCase("remove")) {
            iReportingPageObj.miReport().click();
            nextEventPageObj.waitForMoreTime();
            iReportingPageObj.affinionFolder().click();
            nextEventPageObj.waitForMoreTime();
            iReportingPageObj.affinionChangeFieldValue().click();
            nextEventPageObj.waitForMoreTime();
            this.runReport();
            this.getReportDataForChangedData(feedType);
        }
    }
    public void affinionReportRunNew(String feedType, String brand) {
        if (feedType.equalsIgnoreCase("new")) {
            nextEventPageObj.btnClick(iReportingPageObj.automationReport());
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(iReportingPageObj.integration());
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(iReportingPageObj.affinionReport());
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            setiReportFilterCriteria(feedType);
            nextEventPageObj.btnClick(iReportingPageObj.run());
            commandsObj.waitForLoad(nextEventPageObj.getDriver);
            this.getReportDataForAffinionNew(feedType, brand);
            nextEventPageObj.btnClick(iReportingPageObj.btnClose());
            removeFilterCriteria();
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(iReportingPageObj.btnSave());
            commandsObj.waitForLoad(nextEventPageObj.getDriver);
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            } else if (feedType.equalsIgnoreCase("amend")) {
            nextEventPageObj.btnClick(iReportingPageObj.automationReport());
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(iReportingPageObj.integration());
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(iReportingPageObj.affinionReport());
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            setiReportFilterCriteria(feedType);
            iReportingPageObj.run().click();
            commandsObj.waitForLoad(nextEventPageObj.getDriver);
            this.getReportDataForAffinionNew(feedType, brand);
            nextEventPageObj.btnClick(iReportingPageObj.btnClose());
            removeFilterCriteria();
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(iReportingPageObj.btnSave());
            commandsObj.waitForLoad(nextEventPageObj.getDriver);
        } else if (feedType.equalsIgnoreCase("remove")) {
            iReportingPageObj.miReport().click();
            nextEventPageObj.waitForMoreTime();
            iReportingPageObj.affinionFolder().click();
            nextEventPageObj.waitForMoreTime();
            iReportingPageObj.affinionChangeFieldValue().click();
            nextEventPageObj.waitForMoreTime();
            setiReportFilterCriteria(feedType);
            iReportingPageObj.run().click();
            this.getReportDataForChangedData(feedType);
            iReportingPageObj.btnClose().click();
            nextEventPageObj.switchToDefault();
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            iReportingPageObj.btnSave().click();
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        }
    }

    private void getReportDataForChangedData(String feedType) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        String codeValueForOperation = "";
        List<WebElement> columnValuesForUpdatedTable;
        if (feedType.equalsIgnoreCase("new")) {
            codeValueForOperation = "01";
        } else if (feedType.equalsIgnoreCase("amend")) {
            codeValueForOperation = "04";
        } else if (feedType.equalsIgnoreCase("close")) {
            codeValueForOperation = "02";
        }
        columnValuesForUpdatedTable = nextEventPageObj.findElements(By.xpath(iReportingPageObj.reportForAffinionFeedTableLastRecord(codeValueForOperation)));
    }

    public void getReportDataForAffinion(String feedType) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        String codeValueForOperation = "";
        List<WebElement> columnValues;
        if (feedType.equalsIgnoreCase("new")) {
            codeValueForOperation = "01";
        } else if (feedType.equalsIgnoreCase("amend")) {
            codeValueForOperation = "04";
        } else if (feedType.equalsIgnoreCase("close")) {
            codeValueForOperation = "02";
        }
        columnValues = nextEventPageObj.findElements(By.xpath(iReportingPageObj.reportForAffinionFeedTableLastRecord(codeValueForOperation)));
        uniqueFileText = columnValues.get(1).getText();
        System.out.println("uniqueFileText------------------" + uniqueFileText);
        affinionState = columnValues.get(2).getText();
        System.out.println("affinionState------------------" + affinionState);
        operationType = columnValues.get(3).getText();
        System.out.println("operationType------------------" + operationType);
        primaryMemberExtRef = columnValues.get(4).getText();
        System.out.println("primaryMemberExtRef------------------" + primaryMemberExtRef);
        primaryMemberFirstName = columnValues.get(5).getText();
        System.out.println("primaryMemberFirstName------------------" + primaryMemberFirstName);
        primaryMemberLastName = columnValues.get(6).getText();
        System.out.println("primaryMemberLastName------------------" + primaryMemberLastName);
        primaryMemberDOB = columnValues.get(7).getText();
        System.out.println("primaryMemberDOB------------------" + primaryMemberDOB);
        mailingAddressPostCode = columnValues.get(8).getText();
        System.out.println("mailingAddressPostCode------------------" + mailingAddressPostCode);
        accountNumber = columnValues.get(9).getText();
        System.out.println("accountNumber------------------" + accountNumber);
        sortCode = columnValues.get(10).getText();
        System.out.println("sortCode------------------" + sortCode);
        reconcileState = columnValues.get(11).getText();
        System.out.println("reconcileState------------------" + reconcileState);
        reconcileMessage = columnValues.get(12).getText();
        System.out.println("reconcileMessage------------------" + reconcileMessage);
        customerID = columnValues.get(13).getText();
        System.out.println("customerID------------------" + customerID);
        policyAdminMatterID = columnValues.get(14).getText();
        System.out.println("policyAdminMatterID------------------" + policyAdminMatterID);
        affinionData = columnValues.get(15).getText();
        System.out.println("affinionData------------------" + affinionData);
    }

    public void getReportDataForAffinionNew(String feedType, String brand) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        String codeValueForOperation = "";
        List<WebElement> columnValues;
        if (feedType.equalsIgnoreCase("new")) {
            codeValueForOperation = "01";
        } else if (feedType.equalsIgnoreCase("amend")) {
            codeValueForOperation = "04";
        } else if (feedType.equalsIgnoreCase("close")) {
            codeValueForOperation = "02";
        }
        columnValues = nextEventPageObj.findElements(By.xpath(iReportingPageObj.reportForAffinionFeedTableLastRecordNew(codeValueForOperation, brand)));
        WebTable webTableObj = new WebTable();
        int uniqueFileTextColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.H_UNIQUEFILETEXT);
        int affinionStateColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.AFFINIONSTATE);
        int operationTypeColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.OPERATIONTYPE);
        int primaryMemberExtRefColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.PRIMARYMEMBEREXTREF);
        int primaryMemberFirstNameColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.PRIMARYMEMBERFIRSTNAME);
        int primaryMemberLastNameColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.PRIMARYMEMBERLASTNAME);
        int primaryMemberDOBColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.PRIMARYMEMBERDOB);
        int mailingAddressPostCodeColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.MAILINGADDRESSPOSTCODE);
        int accountNumberColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.ACCOUNTNUMBER);
        int sortCodeColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.SORTCODE);
        int reconcileStateColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.RECONCILESTATE);
        int reconcileMessageColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.RECONCILEMESSAGE);
        int customerIDColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.CUSTOMERID);
        int policyAdminMatterIDColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.POLICYADMINMATTERID);
        int affinionDataColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.AFFINIONDATA);
        uniqueFileText = columnValues.get(uniqueFileTextColIndex).getText();
        System.out.println("uniqueFileText------------------" + uniqueFileText);
        affinionState = columnValues.get(affinionStateColIndex).getText();
        System.out.println("affinionState------------------" + affinionState);
        operationType = columnValues.get(operationTypeColIndex).getText();
        System.out.println("operationType------------------" + operationType);
        primaryMemberExtRef = columnValues.get(primaryMemberExtRefColIndex).getText();
        System.out.println("primaryMemberExtRef------------------" + primaryMemberExtRef);
        primaryMemberFirstName = columnValues.get(primaryMemberFirstNameColIndex).getText();
        System.out.println("primaryMemberFirstName------------------" + primaryMemberFirstName);
        primaryMemberLastName = columnValues.get(primaryMemberLastNameColIndex).getText();
        System.out.println("primaryMemberLastName------------------" + primaryMemberLastName);
        primaryMemberDOB = columnValues.get(primaryMemberDOBColIndex).getText();
        System.out.println("primaryMemberDOB------------------" + primaryMemberDOB);
        mailingAddressPostCode = columnValues.get(mailingAddressPostCodeColIndex).getText();
        System.out.println("mailingAddressPostCode------------------" + mailingAddressPostCode);
        accountNumber = columnValues.get(accountNumberColIndex).getText();
        System.out.println("accountNumber------------------" + accountNumber);
        sortCode = columnValues.get(sortCodeColIndex).getText();
        System.out.println("sortCode------------------" + sortCode);
        reconcileState = columnValues.get(reconcileStateColIndex).getText();
        System.out.println("reconcileState------------------" + reconcileState);
        reconcileMessage = columnValues.get(reconcileMessageColIndex).getText();
        System.out.println("reconcileMessage------------------" + reconcileMessage);
        customerID = columnValues.get(customerIDColIndex).getText();
        System.out.println("customerID------------------" + customerID);
        policyAdminMatterID = columnValues.get(policyAdminMatterIDColIndex).getText();
        System.out.println("policyAdminMatterID------------------" + policyAdminMatterID);
        affinionData = columnValues.get(affinionDataColIndex).getText();
        System.out.println("affinionData------------------" + affinionData);
    }

    public void navigateToAgeExtensionReport() {
        navigationObj.navigateToIReporting();
        navigationObj.navigateToManageReport();
        nextEventPageObj.btnClick(iReportingPageObj.automationReport());
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(iReportingPageObj.tabTravelPolicy());
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(iReportingPageObj.tabTravelPolicyEmail());
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(iReportingPageObj.lblAgeExtensionEmailExceptionReport());
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        this.runReport();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        commandsObj.waitForLoad(nextEventPageObj.getDriver);
    }

    public void validateAgeExtClient() {
        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(iReportingPageObj.lblAgeExtensionExceptionEmailClient(primaryMemberLastName,primaryMemberFirstName))));
    }

    public void affinionFeedReportRunForAgeExtension(String feedType, int age, String brand) {
        try {
            nextEventPageObj.btnClick(iReportingPageObj.automationReport());
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(iReportingPageObj.integration());
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(iReportingPageObj.affinionReport());
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(iReportingPageObj.btnEdit());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(iReportingPageObj.btnColumn());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(iReportingPageObj.lnkSortColumn());
            nextEventPageObj.waitForMoreTime();
            new Select(iReportingPageObj.getReportUNIDSort()).selectByValue("DESC");
            nextEventPageObj.waitForMoreTime();
            new Select(iReportingPageObj.acctHolderDOB()).selectByValue("ASC");
            nextEventPageObj.btnClick(iReportingPageObj.lnkSortColumnSave());
            setAffinionAgeCriteria(age);
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            iReportingPageObj.run().click();
            try {
                Thread.sleep(5500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (feedType.equalsIgnoreCase("new")) {
                this.getAffinionFeedReportDataForAgeExt(feedType, brand);
                iReportingPageObj.btnClose().click();
            }
            System.out.println("Retrieved feed data from IReport..........");
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            System.out.println("Remove sorting value....");
            iReportingPageObj.lnkSortColumn().click();
            nextEventPageObj.waitForMoreTime();
            new Select(iReportingPageObj.getReportUNIDSort()).selectByIndex(0);
            nextEventPageObj.waitForMoreTime();
            new Select(iReportingPageObj.acctHolderDOB()).selectByIndex(0);
            iReportingPageObj.lnkSortColumnSave().click();
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            System.out.println("Remove criteria value....");
            iReportingPageObj.getReportRemoveCriteria().click();
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            iReportingPageObj.btnSave().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }catch(Exception ex){
            manageReportsPage.reportCancel().click();
            ex.printStackTrace();
        }
    }

    public void getAffinionFeedReportDataForAgeExt(String feedType, String brand) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        String codeValueForOperation = "";
        List<WebElement> columnValues;
        if (feedType.equalsIgnoreCase("new")) {
            codeValueForOperation = "01";
        } else if (feedType.equalsIgnoreCase("amend")) {
            codeValueForOperation = "04";
        } else if (feedType.equalsIgnoreCase("close")) {
            codeValueForOperation = "02";
        }
        columnValues = nextEventPageObj.findElements(By.xpath(iReportingPageObj.feedDataForAgeExt(codeValueForOperation,brand)));
        WebTable webTableObj = new WebTable();
        int uniqueFileTextColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.H_UNIQUEFILETEXT);
        int affinionStateColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.AFFINIONSTATE);
        int operationTypeColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.OPERATIONTYPE);
        int primaryMemberExtRefColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.PRIMARYMEMBEREXTREF);
        int primaryMemberFirstNameColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.PRIMARYMEMBERFIRSTNAME);
        int primaryMemberLastNameColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.PRIMARYMEMBERLASTNAME);
        int primaryMemberDOBColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.PRIMARYMEMBERDOB);
        int mailingAddressPostCodeColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.MAILINGADDRESSPOSTCODE);
        int accountNumberColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.ACCOUNTNUMBER);
        int sortCodeColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.SORTCODE);
        int reconcileStateColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.RECONCILESTATE);
        int reconcileMessageColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.RECONCILEMESSAGE);
        int customerIDColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.CUSTOMERID);
        int policyAdminMatterIDColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.POLICYADMINMATTERID);
        int affinionDataColIndex = webTableObj.getColumnFromWebTable(iReportingPageObj.reportResultTableHeader(), TTConstants.AFFINIONDATA);
        uniqueFileText = columnValues.get(uniqueFileTextColIndex).getText();
        System.out.println("uniqueFileText------------------" + uniqueFileText);
        affinionState = columnValues.get(affinionStateColIndex).getText();
        System.out.println("affinionState------------------" + affinionState);
        operationType = columnValues.get(operationTypeColIndex).getText();
        System.out.println("operationType------------------" + operationType);
        primaryMemberExtRef = columnValues.get(primaryMemberExtRefColIndex).getText();
        System.out.println("primaryMemberExtRef------------------" + primaryMemberExtRef);
        primaryMemberFirstName = columnValues.get(primaryMemberFirstNameColIndex).getText();
        System.out.println("primaryMemberFirstName------------------" + primaryMemberFirstName);
        primaryMemberLastName = columnValues.get(primaryMemberLastNameColIndex).getText();
        System.out.println("primaryMemberLastName------------------" + primaryMemberLastName);
        primaryMemberDOB = columnValues.get(primaryMemberDOBColIndex).getText();
        System.out.println("primaryMemberDOB------------------" + primaryMemberDOB);
        mailingAddressPostCode = columnValues.get(mailingAddressPostCodeColIndex).getText();
        System.out.println("mailingAddressPostCode------------------" + mailingAddressPostCode);
        accountNumber = columnValues.get(accountNumberColIndex).getText();
        System.out.println("accountNumber------------------" + accountNumber);
        sortCode = columnValues.get(sortCodeColIndex).getText();
        System.out.println("sortCode------------------" + sortCode);
        reconcileState = columnValues.get(reconcileStateColIndex).getText();
        System.out.println("reconcileState------------------" + reconcileState);
        reconcileMessage = columnValues.get(reconcileMessageColIndex).getText();
        System.out.println("reconcileMessage------------------" + reconcileMessage);
        customerID = columnValues.get(customerIDColIndex).getText();
        System.out.println("customerID------------------" + customerID);
        policyAdminMatterID = columnValues.get(policyAdminMatterIDColIndex).getText();
        System.out.println("policyAdminMatterID------------------" + policyAdminMatterID);
        affinionData = columnValues.get(affinionDataColIndex).getText();
        System.out.println("affinionData------------------" + affinionData);
    }

    public void navigateToCustomerHistory() {
        iReportingPageObj.miReport().click();
        nextEventPageObj.waitForMoreTime();
        iReportingPageObj.lblCustomerHistoryReport().click();
        iReportingPageObj.btnEdit().click();
        nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
        iReportingPageObj.btnColumn().click();
        nextEventPageObj.waitForMoreTime();
        iReportingPageObj.lnkSortColumn().click();
        nextEventPageObj.waitForMoreTime();
        new Select(iReportingPageObj.drpdnWhenChanged()).selectByValue("DESC");
        iReportingPageObj.lnkSortColumnSave().click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        iReportingPageObj.run().click();
        try {
            Thread.sleep(6500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(iReportingPageObj.lblMobileNumChange())));
            Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(iReportingPageObj.lblEmailChange())));
        }
        catch (Exception e)
        {
            System.out.println("Exception occurred ...........");
            e.printStackTrace();
        }
        iReportingPageObj.btnClose().click();
        nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
        System.out.println("Remove sorting value....");
        iReportingPageObj.lnkSortColumn().click();
        nextEventPageObj.waitForMoreTime();
        new Select(iReportingPageObj.drpdnWhenChanged()).selectByIndex(0);
        iReportingPageObj.lnkSortColumnSave().click();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        iReportingPageObj.btnSave().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
    }

    public void editReport(String report) {
        leftNavPaneObj.filterSearch().sendKeys(report);
        leftNavPaneObj.automationReport().click();
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.integration().click();
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.report().click();
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.reportSearchbtnWait();
        iReportingPageObj.editingReport().click();
        iReportingPageObj.btnColumn().click();
        new Select(iReportingPageObj.sortingSelect()).selectByVisibleText("DESC");
        iReportingPageObj.saveSort().click();
    }
    public void enterReportID(List<List<String>> exclusionFlag) {
        leftNavPaneObj.reportClearbtn().click();
        System.out.println("Filter ID entered" + filterID);
        leftNavPaneObj.filterSearch().sendKeys(filterID);
        while (!commandsObj.elementDisplayedWithLessTime(By.xpath("//a[contains(text(),'40746')]"))){
            iReportingPageObj.searchButton().click();
            nextEventPageObj.btnClick(iReportingPageObj.searchButton());
        }
        iReportingPageObj.openAllBtn().click();
        iReportingPageObj.searchButton().click();

        nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.report().click();
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.reportSearchbtnWait();
        iReportingPageObj.editingReport().click();
        iReportingPageObj.btnColumn().click();
        iReportingPageObj.editAllLinkSort().click();
        new Select(iReportingPageObj.sortingSelect()).selectByVisibleText("DESC");
        iReportingPageObj.saveSort().click();
        iReportingPageObj.btnSave().click();
        leftNavPaneObj.runReport().click();
        leftNavPaneObj.runbtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        leftNavPaneObj.runbtnWait();
        System.out.println("Exclusion falg returned" + exclusionFlag);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        this.validateExclusionFlag(exclusionFlag);
    }

    public void validateExclusionFlag(List<List<String>> exclusionFlag) {
        WebElement myTable = leftNavPaneObj.resultTable();
        List<WebElement> rows_table = myTable.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        String readFlag = rows_table.get(1).findElement(By.xpath("//td[9]")).getText();
        System.out.println("Flag read from aquarium" + readFlag);
        for (int i = 1; i < exclusionFlag.size(); i++) {
            for (int j = 0; j < exclusionFlag.get(i).size(); j++) {
                Assert.assertTrue(readFlag.contains("<exclusionType>" + exclusionFlag.get(i).get(0) + "</exclusionType>"));
            }
        }
    }

    public void setAffinionAgeCriteria(int age) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, -age);
        int yearOfBirth = now.get(Calendar.YEAR);
        System.out.println("Year of Birth:: "+ yearOfBirth);
        iReportingPageObj.acctHolderDOBFilter().click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        new Select(iReportingPageObj.getReportComparisonType()).selectByVisibleText(TTConstants.FILTER_STARTS_WITH);
        nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
        iReportingPageObj.getReportCriteriaType().sendKeys(Integer.toString(yearOfBirth));
        nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
        iReportingPageObj.getReportEvaluate().click();
        nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
        iReportingPageObj.getReportCriteriaAccept().click();
        nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
    }

    public void setAffinionOperationTypeCriteria(String feedType) {
        String codeValueForOperation = "";
        List<WebElement> columnValues;
        if (feedType.equalsIgnoreCase("new")) {
            codeValueForOperation = "01";
        } else if (feedType.equalsIgnoreCase("amend")) {
            codeValueForOperation = "04";
        } else if (feedType.equalsIgnoreCase("close")) {
            codeValueForOperation = "02";
        }
        nextEventPageObj.btnClick(iReportingPageObj.getOperationTypeFilter());
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        nextEventPageObj.btnClick(iReportingPageObj.getClearButton());
        commandsObj.waitForLoad(nextEventPageObj.getDriver);
        nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
        new Select(iReportingPageObj.getReportComparisonType()).selectByVisibleText(TTConstants.FILTER_IS_EQUAL_TO);
        nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
        iReportingPageObj.getReportCriteriaType().sendKeys(codeValueForOperation);
        nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
        iReportingPageObj.getReportEvaluate().click();
        nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
        iReportingPageObj.getReportCriteriaAccept().click();
        nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
    }

    public void removeFilterCriteria() {
        System.out.println("Remove sorting value....");
        nextEventPageObj.btnClick(iReportingPageObj.lnkSortColumn());
        nextEventPageObj.waitForMoreTime();
        new Select(iReportingPageObj.getReportUNIDSort()).selectByIndex(0);
        nextEventPageObj.btnClick(iReportingPageObj.lnkSortColumnSave());
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        System.out.println("Remove criteria value....");
        nextEventPageObj.btnClick(iReportingPageObj.getReportRemoveOperationTypeCriteria());
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
    }

    public void setiReportFilterCriteria(String feedType) {
        try {
            nextEventPageObj.btnClick(iReportingPageObj.btnEdit());
            iReportingPageObj.submit().click();
            commandsObj.waitForLoad(nextEventPageObj.getDriver);
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(iReportingPageObj.btnColumn());
            commandsObj.waitForLoad(nextEventPageObj.getDriver);
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(iReportingPageObj.lnkSortColumn());
            nextEventPageObj.waitForMoreTime();
            new Select(iReportingPageObj.getReportUNIDSort()).selectByValue("DESC");
            nextEventPageObj.waitForMoreTime();
            iReportingPageObj.lnkSortColumnSave().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            setAffinionOperationTypeCriteria(feedType);
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }catch(Exception ex){
            manageReportsPage.reportCancel().click();
            ex.printStackTrace();
        }
    }

    public void runReport(String reportName){
        navigationObj.navigateToIReporting();
        navigationObj.navigateToManageReport();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        iReportingPageObj.btnClick(iReportingPageObj.openAllBtn());
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        iReportingPageObj.accessValidReport(reportName).click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        iReportingPageObj.run_Report().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        iReportingPageObj.run().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
    }
    public void verifyCaseIDInReport(List<String> parameters){
        iReportingPageObj.whenCreated().clear();
        String sf = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        iReportingPageObj.whenCreated().sendKeys(sf);
        String date = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        date = sdf.format(c.getTime());
        System.out.println("tomorrow date----" + date);
        iReportingPageObj.whenCreatedTwo().sendKeys(date);
        iReportingPageObj.refresh_Count().click();
        iReportingPageObj.caseIDVerification(claimsOperationsObj.claimcaseid).isDisplayed();
        for (int i = 1; i < parameters.size(); i++) {
                System.out.println("coloumns------"+parameters.get(i));
                System.out.println("coloumns-in application-----"+iReportingPageObj.columnVerfication(i));
                Assert.assertTrue(parameters.get(i).equalsIgnoreCase(iReportingPageObj.columnVerfication(i).getText()));
            }
    }

    public void validateCancellationCoolingOffReportDetails(List<List<String>> lstDataItems){
        iReportingPageObj.switchToFrameById(commonPageObj.fancyFrame());
        webTableObj.checkWebTableHeadings(iReportingPageObj.reportTable(),lstDataItems,0);
        String strRecordsReturned = iReportingPageObj.recordsReturnedText().getText();
        if(!strRecordsReturned.contains("0 records returned")){
            int iRows = webTableObj.getNoofRows(iReportingPageObj.reportTable());
            int iCols = webTableObj.getNoofColumns(iReportingPageObj.reportTable());
            for(int iCol=0;iCol<= iCols;iCols++){
                Assert.assertTrue("Check if value Available",!webTableObj.getCellValue(iReportingPageObj.reportTable(),1,iCol).isEmpty());
            }
        }else{
            Assert.assertFalse("Zero Records returned",false);
        }
    }

    public void executeReport(String reportName) {
        iReportingPageObj.miReport().click();
        nextEventPageObj.waitForMoreTime();
        iReportingPageObj.travelPolicy().click();
        nextEventPageObj.waitForMoreTime();
        iReportingPageObj.peopleTableHistory().click();
        iReportingPageObj.accessValidReport(reportName).click();
        iReportingPageObj.run_Report().click();
        nextEventPageObj.waitForMoreTime();
        iReportingPageObj.run().click();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateExceptionReport(List<List<String>> reportValues) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        for (int i = 1 ; i < reportValues.size() ; i++){
            for (int j = 0; j < reportValues.get(0).size() ; j++){
                switch (reportValues.get(0).get(j)){
                    case "Person type":
                        System.out.println("person type ---------------"+iReportingPageObj.personType().getText());
                        Assert.assertTrue(iReportingPageObj.personType().getText().equalsIgnoreCase(reportValues.get(i).get(j)));
                        break;
                    case "First name":
                        System.out.println("person type ---------------"+iReportingPageObj.firstName().getText());
                        Assert.assertTrue(iReportingPageObj.firstName().getText().equalsIgnoreCase(reportValues.get(i).get(j)));
                        break;
                    case "last name":
                        System.out.println("person type ---------------"+iReportingPageObj.lstName().getText());
                        Assert.assertTrue(iReportingPageObj.lstName().getText().equalsIgnoreCase(reportValues.get(i).get(j)));
                        break;
                    case "Date of birth":
                        System.out.println("person type ---------------"+iReportingPageObj.dob().getText());
                        Assert.assertTrue(iReportingPageObj.dob().getText().equalsIgnoreCase(reportValues.get(i).get(j)));
                        break;
                }
            }
        }
    }
}