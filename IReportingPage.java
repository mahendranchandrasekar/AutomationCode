package co.uk.directlinegroup.tt.pages;

import co.uk.directlinegroup.tt.utils.common.TTConstants;
import co.uk.directlinegroup.tt.utils.common.WebTable;
import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IReportingPage extends AbstractPage {

    public WebElement iReporting() {
        return waitForElementToBeClickableAndReturnElement(By.linkText("iReporting"));
    }

    public WebElement manageReports() {
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_cphBody_lnkReporting2"));
    }

    public WebElement security() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id='f8716']/ins"));
    }

    public WebElement security_AccountAccess_Bypolicy() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("(//a[contains(@href, '#')])[7]"));
    }

    public WebElement searchBox() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id='JSReportTree-SearchText']"));
    }

    public WebElement searchButton() {
        return waitForElementToBeClickableAndReturnElement(By.id("JSReportTree-SearchBnt"));
    }

    public WebElement accountAccessbyPolicyRef() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id=\"q40597\"]/a"));
    }

    public WebElement getID() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id='divNodeDetail']/table/tbody/tr[1]/td[1]"));
    }

    public WebElement getCreatedBy() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id='divNodeDetail']/table/tbody/tr[4]/td[1]"));
    }

    public WebElement getCreatedOn() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//*[@id='divNodeDetail']/table/tbody/tr[5]/td[1]"));
    }

    public WebElement run_Report() {
        return waitForElementToBeClickableAndReturnElement(By.linkText("Run Report"));
    }
    public WebElement verifyingPolicyIDInReport(String policyID){
        return waitForElementPresent(By.xpath("//td[contains(text(),'"+ policyID+"')]"));
    }

    public WebElement run() {
        return waitForElementToBeClickableAndReturnElement(By.id("btnRun"));
    }
    public WebElement whenCreated(){
        return waitForElementPresent(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_pnlRuntimeParameters']/input[1]"));
    }
    public WebElement whenCreatedTwo(){
        return waitForElementPresent(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_pnlRuntimeParameters']/input[2]"));
    }

    public WebElement refresh_Count() {
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_ContentPlaceHolder1_btnRun"));
    }
    public WebElement caseIDVerification(String caseID){
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+caseID+"')]/../td[9][contains(text(),'Claim Closed')]"));
    }

    public WebElement columnVerfication(int i){
        return waitForElementPresent(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grdResults']/tbody/tr[1]/th["+i+"]"));
    }
    public void xpath_user(int start, int end) {
        System.out.println(waitAndFindElement(By.xpath("/*//*[@id='ctl00_ContentPlaceHolder1_grdResults']/tbody/tr[2]/td[4]")).getText());
    }

    public WebElement close_Report_Background() {
        return waitForElementToBeClickableAndReturnElement(By.cssSelector("div.reportBackground > input.button"));
    }

    public WebElement userLogout() {
        return waitForElementToBeClickableAndReturnElement(By.id("ctl00_btnLogOut"));
    }

    public WebElement miReport() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'MI Reports')]/preceding-sibling::ins"));
    }
    public WebElement automationReport() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[contains(text(),'Automation Reports')]/preceding-sibling::ins"));
    }

    public WebElement travelPolicy() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[contains(text(),'Travel Policy')]/preceding-sibling::ins"));
    }

    public WebElement affinionFolder() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Affinion')]/preceding-sibling::ins"));
    }
    public WebElement nonUKResidentReport() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Non UK addresses (40769)')]"));
    }

    public WebElement policyNumber(String policyNumber) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + policyNumber + "')]"));
    }

    public WebElement addressType(String policyNumber) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+policyNumber+"')]/..//following-sibling::td[13]"));
    }

    public WebElement ukAddressOfficeType(String policyNumber) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+policyNumber+"')]/..//following-sibling::td[14]"));
    }

    public WebElement expandRenewals() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Renewals')]/preceding-sibling::ins"));
    }

    public WebElement lnkRenewalByMonth() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Renewal Early Quotes By Month (40864)')]"));
    }
    public WebElement lnkEarlyRenewalsLapsed() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Number of early Renewals Lapsed in this period (41620)')]"));
    }
    public WebElement lnkEarlyRenewalsTaken() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Number of early Renewals taken up in the period (41618)"));
    }

    public WebElement lblEarlyRenewalCount() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_grdResults']/tbody/tr/td[2][contains(text(),'2018')]/../td[3][contains(text(),'5')]/../td[1]"));
    }

    public WebElement btnClose() {
        return waitForElementPresent(By.xpath("//input[@value='Close']"));
    }

    public WebElement customerBarring() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Customer Bar')]/preceding-sibling::ins"));
    }

    public WebElement integration() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[contains(text(),'Integrations')]/preceding-sibling::ins"));
    }

    public WebElement tabTravelPolicy() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Travel Policy')]/preceding-sibling::ins"));
    }

    public WebElement tabTravelPolicyEmail() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("(//a[contains(text(),'Email')]/preceding-sibling::ins)[1]"));
    }

    public WebElement lblAgeExtensionEmailExceptionReport() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Age Extension Email Exception (41645)')]"));
    }

    public WebElement customerBarringReport(String reportName) {
        return waitForElementPresent(By.xpath("//a[contains(text(),'" + reportName + "')]"));
    }
    public WebElement editingReport() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Edit')]"));
    }

    public WebElement editAllLinkSort() {
        return waitForElementPresent(By.xpath("(//a[contains(text(),'Edit All')])[last()]"));
    }
    public WebElement sortingSelect() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'WhenCreated')]/../following-sibling::td//select"));
    }

    public WebElement saveSort() {
        return waitForElementPresent(By.xpath("(//a[contains(text(),'Save')])[last()]"));
    }
    public WebElement affinionReport() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[contains(text(),'Affinion Data')]"));
    }
    public WebElement affinionChangeFieldValue() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Import - Changed field values ')]"));
    }

    public WebElement filterForEmailID() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'EmailAddress')]/../following-sibling::td/a"));
    }

   public WebElement acceptBtn() {
        return waitForElementPresent(By.id("btnAccept"));
    }

    public WebElement evaluateBtn() {
        return waitForElementPresent(By.id("btnEvaluate"));
    }
    public WebElement thisValue() {
        return waitForElementPresent(By.id("tbxCriteria1"));
    }
    public WebElement srotResultEditLink() {
        return waitForElementPresent(By.id("lnkEditSortDirection"));
    }

    public WebElement filterForWhenModifiedSortSelect() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Whenmodified')]/../following-sibling::td[2]/select"));
    }


    public WebElement saveLink() {
        return waitForElementPresent(By.id("ctl00_cphBody_grdExistingColumns_ctl01_lnkSaveSortDirection"));
    }

    public WebElement reportTable() {
        return waitForElementPresent(By.id("ctl00_ContentPlaceHolder1_grdResults"));
    }

    public WebElement fullNameFilter() {
        return waitForElementPresent(By.xpath("(//td[contains(text(),'Customers')]/following-sibling::td[3]/a)[2]"));
    }

    public WebElement thisValueInput() {
        return waitForElementPresent(By.id("tbxCriteria1"));
    }

    public WebElement validateXmlDataInReport(String firstName, String lastName, String condition) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + firstName + "')]/following-sibling::td[contains(text(),'" + lastName + "')]/following-sibling::td[2][contains(text(),'" + condition + "')]"));
    }
    public String reportForAffinionFeedTableLastRecord(String feedType) {
        return "(//table[@id='ctl00_ContentPlaceHolder1_grdResults']/tbody/tr/td[4][contains(text(),'"+feedType+"')])[last()]/../td";
    }

    public String reportForAffinionFeedTableLastRecordNew(String feedType, String brand) {
         WebTable webTableObj = new WebTable();
        int operationTypeColIndex = webTableObj.getColumnFromWebTable(reportResultTableHeader(), TTConstants.OPERATIONTYPE);
        int brandColIndex = webTableObj.getColumnFromWebTable(reportResultTableHeader(), TTConstants.H_UNIQUEFILETEXT);
        System.out.println("Test Result Table:: "+"//table[@id='ctl00_ContentPlaceHolder1_grdResults']/tbody/tr[td["+(operationTypeColIndex+1)+"][contains(text(),'"+feedType+"')] and td["+(brandColIndex+1)+"][starts-with(text(),'"+brand+"')]][1]/td");
        return "//table[@id='ctl00_ContentPlaceHolder1_grdResults']/tbody/tr[td["+(operationTypeColIndex+1)+"][contains(text(),'"+feedType+"')] and td["+(brandColIndex+1)+"][starts-with(text(),'"+brand+"')]][1]/td";
    }

    public WebElement btnEdit()
    {
        return waitForElementPresent(By.xpath("//a[@class='button'][contains(text(),'Edit')]"));
    }
    public WebElement lnkSortColumn()
    {
        return waitForElementPresent(By.id("lnkEditSortDirection"));
    }

    public WebElement btnColumn()
    {
        return waitForElementPresent(By.linkText("Columns"));
    }
    public WebElement btnClear()
    {
        return waitForElementPresent(By.id("btnClearAll"));
    }

    public WebElement acctHolderDOB()
    {
        return waitForElementPresent(By.id("ctl00_cphBody_grdExistingColumns_ctl09_ddlSortDirection"));
    }

    public WebElement lnkSortColumnSave()
    {
        return waitForElementPresent(By.id("ctl00_cphBody_grdExistingColumns_ctl01_lnkSaveSortDirection"));
    }

    public String feedDataForAgeExt(String feedType, String brand)
    {
        WebTable webTableObj = new WebTable();
        int operationTypeColIndex = webTableObj.getColumnFromWebTable(reportResultTableHeader(), TTConstants.OPERATIONTYPE);
        int brandColIndex = webTableObj.getColumnFromWebTable(reportResultTableHeader(), TTConstants.H_UNIQUEFILETEXT);
        System.out.println("Test Result Table:: "+"//table[@id='ctl00_ContentPlaceHolder1_grdResults']/tbody/tr[td["+(operationTypeColIndex+1)+"][contains(text(),'"+feedType+"')] and td["+(brandColIndex+1)+"][starts-with(text(),'"+brand+"')]][1]/td");
        return "//table[@id='ctl00_ContentPlaceHolder1_grdResults']/tbody/tr[td["+(operationTypeColIndex+1)+"][contains(text(),'"+feedType+"')] and td["+(brandColIndex+1)+"][starts-with(text(),'"+brand+"')]][1]/td";

    }

    public WebElement btnSave()
    {
        return waitForElementPresent(By.id("ctl00_cphBody_btnSave"));
    }

    public String lblAgeExtensionExceptionEmailClient(String lastName,String firstName)
    {
        return   "//td[contains(text(),'"+firstName+" "+ lastName+"')]";
    }


    public WebElement lblCustomerHistoryReport() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Customer History')]"));
    }

    public WebElement drpdnWhenChanged(){
        return  waitForElementPresent(By.id("ctl00_cphBody_grdExistingColumns_ctl10_ddlSortDirection"));
    }


    public String lblMobileNumChange()
    {
        return "(//td[contains(text(),'SONG')]/following-sibling::td[11][contains(text(),'07852222111')])[1]";
    }

    public String lblEmailChange()
    {
        return "(//td[contains(text(),'SONG')]/following-sibling::td[17][contains(text(),'SONGDONG@GMAIL.COM')])[1]";
    }
    public WebElement recordSelection(){
        return waitForElementPresent(By.xpath("//*[contains(text(),'Access by Policy Ref (40597)')]"));
    }
    public WebElement optionSelection(){
        return waitForElementPresent(By.xpath("//a[contains(text(),'Security')]"));
    }

    public WebElement reportResultTableHeader() {
        return waitForElementPresent(By.className("reportResultPaneHeader"));
    }
    public WebElement acctHolderDOBFilter()
    {
        return waitForElementPresent(By.id("ctl00_cphBody_grdExistingColumns_ctl09_imgFilter"));
    }

    public WebElement getOperationTypeFilter()
    {
        return waitForElementPresent(By.id("ctl00_cphBody_grdExistingColumns_ctl05_imgFilter"));
    }
    public WebElement getReportComparisonType() {
        return waitForElementPresent(By.id("ddlComparisonTypes"));
    }
    public WebElement getReportCriteriaType()
    {
        return waitForElementPresent(By.id("tbxCriteria1"));
    }
    public WebElement getReportEvaluate()
    {
        return waitForElementPresent(By.id("btnEvaluate"));
    }

    public WebElement getClearButton()
    {
        return waitForElementPresent(By.id("btnClearAll"));
    }
    public WebElement getReportCriteriaAccept()
    {
        return waitForElementPresent(By.id("btnAccept"));
    }
    public WebElement getReportRemoveCriteria()
    {
        return waitForElementPresent(By.id("ctl00_cphBody_grdExistingColumns_ctl09_lnkRemoveCriteria"));
    }
    public WebElement getReportRemoveOperationTypeCriteria()
    {
        return waitForElementPresent(By.id("ctl00_cphBody_grdExistingColumns_ctl05_lnkRemoveCriteria"));
    }

    public WebElement getReportUNIDSort()
    {
        return waitForElementPresent(By.id("ctl00_cphBody_grdExistingColumns_ctl02_ddlSortDirection"));
    }
    public WebElement btnCancel()
    {
        return waitForElementPresent(By.id("ctl00_cphBody_btnCancel"));
    }

    public WebElement filter() {
        return waitForElementPresent(By.id("JSReportTree-SearchText"));
    }

    public WebElement accessValidReport(String report) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+report+"')]"));
    }

    public WebElement recordsReturnedText(){
        return waitForElementPresent(By.id("ctl00_ContentPlaceHolder1_lblCount"));
    }

    public WebElement openAllBtn(){
        return waitForElementPresent(By.id("JSReportTree-OpenAllBnt"));
    }

    public WebElement peopleTableHistory() {
        return waitForElementVisible(By.xpath("//a[contains(text(),'People Table History')]/preceding-sibling::ins"));
    }

    public WebElement personType() {
        return waitForElementVisible(By.xpath("//table[contains(@id,'grdResults')]/tbody/tr[2]/td[6]"));
    }
    public WebElement firstName() {
        return waitForElementVisible(By.xpath("//table[contains(@id,'grdResults')]/tbody/tr[2]/td[8]"));
    }
    public WebElement lstName() {
        return waitForElementVisible(By.xpath("//table[contains(@id,'grdResults')]/tbody/tr[2]/td[9]"));
    }
    public WebElement dob() {
        return waitForElementVisible(By.xpath("//table[contains(@id,'grdResults')]/tbody/tr[2]/td[10]"));
    }

    public WebElement leadIDFilter(){
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl00_ContentPlaceHolder1_txtParam1')]"));
    }
    public WebElement submit(){
        return waitForElementPresent(By.xpath("//input[contains(@id,'ctl00_cphBody_btnEditingOk')]"));
    }

}
