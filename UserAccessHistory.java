package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.IReportingPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;

public class UserAccessHistory {

    private IReportingPage iReportingPageObj = new IReportingPage();
    private NextEventPage nextEventPageObj = new NextEventPage();

    public void click_On_Ireporting() {
        iReportingPageObj.iReporting().click();
    }

    public void click_On_ManageReports() {
        iReportingPageObj.manageReports().click();
    }

    public void click_On_Security() {
        iReportingPageObj.security().click();
    }

    public void click_On_runReport() {
        iReportingPageObj.run_Report().click();
    }

    public void click_On_Run() {
        iReportingPageObj.run().click();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        iReportingPageObj.switchToFrameByIndex(0);
    }

    public void click_On_RefreshCount() {
        iReportingPageObj.refresh_Count().click();
    }

    public void get_UserHistory() {
        iReportingPageObj.xpath_user(2, 6);
    }

    public void close_Report_Backgroud() {
        iReportingPageObj.close_Report_Background().click();
        nextEventPageObj.waitForMoreTime();
        iReportingPageObj.userLogout().click();
    }
    public void select_Record(){
        iReportingPageObj.recordSelection().click();
    }
    public void select_SecurityOption(){
        iReportingPageObj.optionSelection().click();
    }

    public void enterLeadIDFilter(String strFilterValue){
        iReportingPageObj.leadIDFilter().clear();
        iReportingPageObj.leadIDFilter().sendKeys(strFilterValue);
    }
}
