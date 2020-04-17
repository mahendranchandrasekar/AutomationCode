package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.AccountInformationPage;
import co.uk.directlinegroup.tt.pages.LeftNavPanePage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.pages.SearchPage;
import co.uk.directlinegroup.tt.pages.PolicyDataFieldsPage;
import co.uk.directlinegroup.tt.utils.UserAccessHistory;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import java.util.List;

public class AccountAccessLogging extends BaseStepDef {

    private LeftNavPanePage leftNavPanePageObj = new LeftNavPanePage();
    private UserAccessHistory userAccessHistoryObj = new UserAccessHistory();
    private SearchPage searchPageObj = new SearchPage();
    private PerformSearch perfSerachObj = new PerformSearch();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private AccountInformationPage accountInformationPageObj = new AccountInformationPage();
    private PolicyDataFieldsPage policyDataFieldsPage=new PolicyDataFieldsPage();

    @When("^navigating to the IReport$")
    public void navigating_to_the_IReport() throws Throwable {
        leftNavPanePageObj.iMenu().click();
        userAccessHistoryObj.click_On_Ireporting();
    }

    @And("^Entering a customers reference in the Access History Report, system will present  access history of client with following fields$")
    public void enteringACustomersReferenceInTheAccessHistoryReportSystemWillPresentAccessHistoryOfClientWithFollowingFields(List<String> fields) throws Throwable {
        searchPageObj.viewCustomerLinkInSearchResultTable().click();
        perfSerachObj.retreiveFirstClientRecord();
        nextEventPageObj.switchToWindowByIndex(1);
        String strPolicyNumber = policyDataFieldsPage.getPolicyNumberFromScreen().getText();
        leftNavPanePageObj.iMenu().click();
        userAccessHistoryObj.click_On_Ireporting();
        userAccessHistoryObj.click_On_ManageReports();
        userAccessHistoryObj.click_On_Security();
        userAccessHistoryObj.select_SecurityOption();
        userAccessHistoryObj.select_Record();
        userAccessHistoryObj.click_On_runReport();
        userAccessHistoryObj.click_On_Run();
        userAccessHistoryObj.enterLeadIDFilter(strPolicyNumber);
        userAccessHistoryObj.click_On_RefreshCount();
        userAccessHistoryObj.get_UserHistory();
        userAccessHistoryObj.close_Report_Backgroud();
        for (String str : fields) {
            switch (str.toLowerCase()) {
                case "Transactiontype":
                    Assert.assertTrue(searchPageObj.validateTransactionType().isDisplayed());
                    break;
                case "Datestamped":
                    Assert.assertTrue(searchPageObj.validateDateTimeStamped().isDisplayed());
                    break;
                case "Timestamped":
                    Assert.assertTrue(searchPageObj.validateDateTimeStamped().isDisplayed());
                    break;
                case "User ID":
                    Assert.assertTrue(searchPageObj.validateUSerID().isDisplayed());
                    break;
                case "Channel Accessed":
                    Assert.assertTrue(searchPageObj.validateTransactionType().isDisplayed());
                    break;
            }
        }
    }
}
