package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.common.DateOperations;
import co.uk.directlinegroup.tt.utils.common.Operations;
import co.uk.directlinegroup.tt.utils.common.WebTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static co.uk.directlinegroup.tt.utils.ClaimsOperations.claimID;

public class Report {

    public String filterID = "40746";
    private Operations OperationsObj = new Operations();
    private Navigation navigationObj = new Navigation();
    private ManageReportsPage manageReportsPageObj = new ManageReportsPage();
    private LeftNavPanePage leftNavPanePageObj = new LeftNavPanePage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private WebTable webTableObj = new WebTable();
    private IReportingPage iReportingPageObj = new IReportingPage();
    private LeftNavPanePage leftNavPaneObj = new LeftNavPanePage();
    private QuoteAndBuyOperations quoteAndBuyOperationsObj = new QuoteAndBuyOperations();
    private CommonPage commonPageObj = new CommonPage();
    private Commands commandsObj = new Commands();
    public static String policyNumber = "";

    public void reportEditViewAccess(String reportName, String actionType) throws InterruptedException, ParseException {
        if (!actionType.equalsIgnoreCase("no access")) {
            navigationObj.naviagteToReport();
        }
        switch (actionType.toLowerCase()) {
            case "run,view,edit":
                this.editReport( reportName);
                this.runReport( reportName);
                this.closeReport();
                break;
            case "run":
            case "view":
            case "run,view":
                this.runReport( reportName);
                this.closeReport();
                break;
            case "run,validate":
                this.runValidate( reportName);
                break;
            case "run,validate,verifydata":
                this.runValidateVerifyData(reportName);
                break;
            case "run,non-editable":
            case "view,non-editable":
            case "run,view,non-editable":
                this.runReport(reportName);
                this.closeReport();
                leftNavPanePageObj.waitForMoreTime();
                leftNavPanePageObj.waitForMoreTime();
                leftNavPanePageObj.waitForMoreTime();
                leftNavPanePageObj.waitForMoreTime();
                Assert.assertTrue(manageReportsPageObj.reportAEdit().size() == 0);
                break;
            case "no access":
                leftNavPanePageObj.iMenu().click();
                Assert.assertTrue(leftNavPanePageObj.iReportElement().size() == 0);
                break;
            case "no access to report":
                navigationObj.naviagteToReport();
                leftNavPanePageObj.waitForMoreTime();
                leftNavPanePageObj.waitForMoreTime();
                leftNavPanePageObj.waitForMoreTime();
                Assert.assertTrue(manageReportsPageObj.reportNone(reportName).size() == 0);
        }
    }

    public void searchReport(String reportName){
        iReportingPageObj.filter().clear();
        iReportingPageObj.filter().sendKeys(reportName);
        iReportingPageObj.searchButton().click();
        iReportingPageObj.waitForMoreTime();
        iReportingPageObj.waitForMoreTime();
        iReportingPageObj.searchButton().click();
        if(iReportingPageObj.accessValidReport(reportName).isDisplayed()) {
            System.out.println("Is in If part");
            iReportingPageObj.accessValidReport(reportName).click();
        }
        else{
            System.out.println("Is in else part");
            iReportingPageObj.searchButton().click();
            iReportingPageObj.waitForMoreTime();
            iReportingPageObj.accessValidReport(reportName).click();
        }
    }
    public void runReport( String reportName) throws InterruptedException {
        this.searchReport(reportName);
        iReportingPageObj.run_Report().click();
        iReportingPageObj.run().click();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        leftNavPanePageObj.waitForMoreTime();
        leftNavPanePageObj.waitForMoreTime();
        leftNavPanePageObj.waitForMoreTime();
    }

    public void runValidate(String reportName) throws InterruptedException, ParseException {
        List<List<String>> fullBD12Data;
        this.runReport(reportName);
        fullBD12Data= webTableObj.getWebTable(iReportingPageObj.reportTable());
        this.closeReport();
        int iSize =fullBD12Data.size();
        int cSize=fullBD12Data.get(0).size();
        for (int row = 1; row < 2; row++) {
            for (int column = 0; column < cSize; column++) {
                this.validateReports(fullBD12Data.get(0).get(column), fullBD12Data.get(row).get(column));
            }
        }
    }
    public void runValidateVerifyData(String reportName) throws InterruptedException, ParseException {
        List<List<String>> fullBD12Data;
        this.runReport(reportName);
        fullBD12Data= webTableObj.getWebTable(iReportingPageObj.reportTable());
        this.closeReport();
        System.out.println();
       this.verfiyData(fullBD12Data);
    }

    public void verfiyData(List<List<String>> fullBD12data) throws InterruptedException, ParseException{
        //System.out.println(fullBD12data);
        int reportSize=fullBD12data.size();
        //System.out.println(reportSize);
        for (int row=3;row<=7;row++) {
            for (int column = 0; column <= 3; column++) {
                this.validateReports(fullBD12data.get(0).get(column), fullBD12data.get(row).get(column));
            }
        }
    }
    public void validateReports(String searchField, String searchValue) throws ParseException {
            switch (searchField.toLowerCase()) {
                case "bdtype":
                    break;
                case "exported":
                    this.validateIntegrationfile(searchValue);
                    break;
                case "sent":
                    break;
                case "whencreated":
                    this.whenCreated(searchValue);
                    this.checkStatus(searchValue);
                    break;
            }
    }

    public void validateIntegrationfile(String searchValue){
        Integer exported = Integer.parseInt(searchValue);
        Assert.assertTrue(exported>0);
        //System.out.println(exported);
    }
    public void checkStatus(String searchValue){
        Assert.assertTrue("Checking file status --->  "+searchValue,searchValue.equalsIgnoreCase("sent"));
    }

    public void whenCreated(String searchValue) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        Date date1=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(searchValue);
        int diff = date.getDate() - date1.getDate();
        Assert.assertTrue(diff<=1);
    }

    public void closeReport() {
        manageReportsPageObj.reportClose().click();
        manageReportsPageObj.reportCancel().click();
        leftNavPanePageObj.waitForMoreTime();
        leftNavPanePageObj.waitForMoreTime();
        leftNavPanePageObj.waitForMoreTime();
    }

    public void editReport( String reportName) {
        this.searchReport(reportName);
        manageReportsPageObj.editReport().click();
        manageReportsPageObj.reportCancel().click();
        leftNavPanePageObj.waitForMoreTime();
        leftNavPanePageObj.waitForMoreTime();
        leftNavPanePageObj.waitForMoreTime();
    }

    public List<List<String>> getReportTableValues() {
        commonPageObj.switchToFrameById(commonPageObj.fancyFrame());
        List<List<String>> CurrencyListWebTable = new ArrayList<List<String>>();
        List<String> lstTableHeader = new ArrayList<>();
        String[] items = manageReportsPageObj.reportCount().getText().split("[a-zA-Z]+");
        int noOfRecord = Integer.parseInt(items[0].trim());
        int noofPages = noOfRecord / 10;
        lstTableHeader = OperationsObj.getHeaderFromTable(iReportingPageObj.reportTable(), "currencyexchange");
        CurrencyListWebTable.add(lstTableHeader);
        int i = 1;
        while (i <= noofPages) {
            List<List<String>> lstTableRow = new ArrayList<List<String>>();
            String str = String.valueOf(i);
            if (i % 10 == 1) {
                manageReportsPageObj.waitForMoreTime();
                if (manageReportsPageObj.loadingPage(str)) {
                    lstTableRow = OperationsObj.getWebTableData(iReportingPageObj.reportTable(), "currencyexchange");
                    CurrencyListWebTable.addAll(lstTableRow);
                }
            } else if (i % 10 == 0) {
                manageReportsPageObj.btnClick(manageReportsPageObj.pageNumberLink(str));
                if (manageReportsPageObj.loadingPage(str)) {
                    lstTableRow = OperationsObj.getWebTableData(iReportingPageObj.reportTable(), "currencyexchange");
                    CurrencyListWebTable.addAll(lstTableRow);
                    if (manageReportsPageObj.pageNumberLink("...").isDisplayed()) {
                        manageReportsPageObj.btnClick(manageReportsPageObj.pageNumberLink("..."));
                    }
                }
            } else {
                manageReportsPageObj.btnClick(manageReportsPageObj.pageNumberLink(str));
                if (manageReportsPageObj.loadingPage(str)) {
                    lstTableRow = OperationsObj.getWebTableData(iReportingPageObj.reportTable(), "currencyexchange");
                    CurrencyListWebTable.addAll(lstTableRow);
                }
            }
            i++;
        }
        return CurrencyListWebTable;
    }


    public void validatexmlTagvaluesInReporting(String customer, List<List<String>> parameters) {
        this.enterHealixReportXml();
        String customerFirstName, customerLastName;
        if (customer.equalsIgnoreCase("random")) {
            System.out.println("Customer is Random");
            customerFirstName =  quoteAndBuyOperationsObj.randomCustomerFullName.split(" ")[0];
            customerLastName =  quoteAndBuyOperationsObj.randomCustomerFullName.split(" ")[1];
        }
        else {
            customerFirstName = customer.split(" ")[0];
            customerLastName = customer.split(" ")[1];
        }
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                String searchField = parameters.get(0).get(j);
                String searchValue = parameters.get(1).get(j);
                String condition = "";
                switch (parameters.get(0).get(j).toLowerCase()) {
                    case "name":
                        condition = "<" + searchField + ">" + searchValue + "</" + searchField + ">";
                        System.out.println("Condition" + iReportingPageObj.validateXmlDataInReport(customerFirstName, customerLastName, condition));
                        iReportingPageObj.validateXmlDataInReport(customerFirstName, customerLastName, condition).isDisplayed();
                        break;
                    case "icd9":
                        condition = "<" + searchField + ">" + searchValue + "</" + searchField + ">";
                        System.out.println("Condition" + iReportingPageObj.validateXmlDataInReport(customerFirstName, customerLastName, condition));
                        iReportingPageObj.validateXmlDataInReport(customerFirstName, customerLastName, condition).isDisplayed();
                        break;
                    case "icd":
                        condition = "<" + searchField + ">" + searchValue + "</" + searchField + ">";
                        System.out.println("Condition" + iReportingPageObj.validateXmlDataInReport(customerFirstName, customerLastName, condition));
                        iReportingPageObj.validateXmlDataInReport(customerFirstName, customerLastName, condition).isDisplayed();
                        break;
                    case "exclusion flag":
                        condition = "<" + searchField + ">" + searchValue + "</" + searchField + ">";
                        System.out.println("Condition" + iReportingPageObj.validateXmlDataInReport(customerFirstName, customerLastName, condition));
                        iReportingPageObj.validateXmlDataInReport(customerFirstName, customerLastName, condition).isDisplayed();
                        break;
                    case "linkedConditions":
                        condition = "<" + searchField + "><LinkedCondition " + searchValue + "/></" + searchField + ">";
                        System.out.println("Condition" + iReportingPageObj.validateXmlDataInReport(customerFirstName, customerLastName, condition));
                        iReportingPageObj.validateXmlDataInReport(customerFirstName, customerLastName, condition).isDisplayed();
                        break;
                }
            }
        }
    }

    public void enterHealixReportXml() {
        leftNavPaneObj.reportClearbtn().click();
        System.out.println("Filter ID entered" + filterID);
        leftNavPaneObj.filterSearch().sendKeys(filterID);
        leftNavPaneObj.reportSearchbtn().click();
        leftNavPaneObj.reportSearchbtn().click();
        while (!commandsObj.elementDisplayedWithLessTime(By.xpath("//a[contains(text(),'40746')]"))){
            iReportingPageObj.searchButton().click();
            nextEventPageObj.btnClick(iReportingPageObj.searchButton());
        }
        iReportingPageObj.openAllBtn().click();
        iReportingPageObj.searchButton().click();
        nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.report().click();
        leftNavPaneObj.runReport().click();
        leftNavPaneObj.runbtn().click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        leftNavPaneObj.runbtnWait();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void runParticularReport(String reportName){
        navigationObj.naviagteToReport();
        iReportingPageObj.filter().clear();
        iReportingPageObj.filter().sendKeys(reportName);
        iReportingPageObj.searchButton().click();
        manageReportsPageObj.waitForMoreTime(); manageReportsPageObj.waitForMoreTime();
        iReportingPageObj.searchButton().click();
        if(iReportingPageObj.accessValidReport(reportName).isDisplayed()) {
            System.out.println("Is in If part");
            iReportingPageObj.accessValidReport(reportName).click();
        }
        else{
            System.out.println("Is in else part");
            iReportingPageObj.searchButton().click();
            manageReportsPageObj.waitForMoreTime();
            iReportingPageObj.accessValidReport(reportName).click();
        }
        nextEventPageObj.btnClick(iReportingPageObj.run_Report());
        nextEventPageObj.btnClick(iReportingPageObj.run());
        manageReportsPageObj.waitForMoreTime(); manageReportsPageObj.waitForMoreTime();
        manageReportsPageObj.waitForMoreTime(); manageReportsPageObj.waitForMoreTime();
        manageReportsPageObj.waitForMoreTime(); manageReportsPageObj.waitForMoreTime();
        manageReportsPageObj.waitForMoreTime(); manageReportsPageObj.waitForMoreTime();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
    }

    public void closeReportToNavigateToPolicy() {
        if (manageReportsPageObj.reportClose().isDisplayed()) {
            leftNavPanePageObj.waitForMoreTime();
            leftNavPanePageObj.waitForMoreTime();
            manageReportsPageObj.reportClose().click();
            leftNavPanePageObj.waitForMoreTime();
            leftNavPanePageObj.waitForMoreTime();
            manageReportsPageObj.reportCancel().click();
        } else {
            leftNavPanePageObj.waitForMoreTime();
            leftNavPanePageObj.waitForMoreTime();
            leftNavPanePageObj.waitForMoreTime();
        }
    }

    public void validateWorkFlowGroup(String workflowgroup){
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("Claim id from claim summary page----------"+claimID);
        String ClaimIdForWorkFlow = claimID;
        System.out.println("Claim id for workflow validation----------"+ClaimIdForWorkFlow);
        manageReportsPageObj.txtClaimIdToTextBox().clear();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        manageReportsPageObj.txtClaimIdToTextBox().sendKeys(ClaimIdForWorkFlow);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        manageReportsPageObj.txtClaimIdToTextBox().sendKeys(Keys.ENTER);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        String displayedWorkflowGroup = manageReportsPageObj.txtWorkflowId(workflowgroup).getText();
        System.out.println("Expected Workflow group is -------"+workflowgroup);
        System.out.println("Workflow group displayed is -------"+displayedWorkflowGroup);
        Assert.assertTrue(workflowgroup.equalsIgnoreCase(displayedWorkflowGroup));
        System.out.println("*********************verified the workflow group******************");
        try {
            manageReportsPageObj.reportClose().click();
        }catch (Exception e){
            manageReportsPageObj.btnClick(manageReportsPageObj.reportClose());
        }
    }

    public void validateWorkFlowGroupForBarring(String workflowgroup){
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("Claim id from claim summary page----------"+policyNumber);
        String ClaimIdForWorkFlow = policyNumber;
        System.out.println("Claim id for workflow validation----------"+ClaimIdForWorkFlow);
        manageReportsPageObj.txtClaimIdToTextBox().clear();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        manageReportsPageObj.txtClaimIdToTextBox().sendKeys(ClaimIdForWorkFlow);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        manageReportsPageObj.txtClaimIdToTextBox().sendKeys(Keys.ENTER);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        String displayedWorkflowGroup = manageReportsPageObj.txtWorkflowId(workflowgroup).getText();
        System.out.println("Expected Workflow group is -------"+workflowgroup);
        System.out.println("Workflow group displayed is -------"+displayedWorkflowGroup);
        Assert.assertTrue(workflowgroup.equalsIgnoreCase(displayedWorkflowGroup));
        System.out.println("*********************verified the workflow group******************");
        try {
            manageReportsPageObj.reportClose().click();
        }catch (Exception e){
            manageReportsPageObj.btnClick(manageReportsPageObj.reportClose());
        }
    }
}