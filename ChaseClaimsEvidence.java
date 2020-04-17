package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.ClaimsOperations;
import co.uk.directlinegroup.tt.utils.PerformSearch;
import co.uk.directlinegroup.tt.utils.User;
import co.uk.directlinegroup.tt.utils.common.DateOperations;
import co.uk.directlinegroup.tt.utils.common.FileOperations;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

import static co.uk.directlinegroup.tt.utils.ClaimsOperations.claimID;

public class ChaseClaimsEvidence extends BaseStepDef {

    private User userObj = new User();
    private DateOperations dateOperationsObj = new DateOperations();
    private LeftNavPanePage leftNavPanePageObj = new LeftNavPanePage();
    private ChaseClaimsEvidencePage chaseClaimsEvidencePageObj = new ChaseClaimsEvidencePage();
    private FullEventHistoryPage fullEventHistoryPageObj = new FullEventHistoryPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private PerformSearch perfSerachObj = new PerformSearch();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private PerilQuestionsPage perilQuestionsPageObj = new PerilQuestionsPage();
    private FileOperations fileOperationsObj = new FileOperations();

    @Then("^Notification '(.+)' to the customer regarding outstanding evidence via preferred communication channel (.+)$")
    public void notification_should_be_sent_to_the_customer_regarding_outstanding_evidence_via_preferred_communication_channel(String notification, String channel) {
        getDriver().navigate().to(fileOperationsObj.getApplicationURL(System.getProperty("ENV")));
        List<String> userDet = userObj.getUserDetails("AdminUser");
        String loginUserName = userDet.get(1);
        String loginPwd = userDet.get(2);
        userObj.login(loginUserName, loginPwd);
        leftNavPanePageObj.iAdmin().click();
        leftNavPanePageObj.companyDetails().click();
        chaseClaimsEvidencePageObj.clientConfig().click();
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.waitForMoreTime();
        fullEventHistoryPageObj.switchToParentFrame();
//        TODO commented for execution of Final E2E
        chaseClaimsEvidencePageObj.batchJobModifier().click();
        chaseClaimsEvidencePageObj.batchJobModifier().clear();
        chaseClaimsEvidencePageObj.batchJobModifier().sendKeys(dateOperationsObj.getCurrentDate());
        fullEventHistoryPageObj.switchToParentFrame();
        fullEventHistoryPageObj.saveAndClose().click();
        leftNavPanePageObj.iMenu().click();
        chaseClaimsEvidencePageObj.leadManager().click();
        leftNavPanePageObj.setUP().click();
        leftNavPanePageObj.batchJobs().click();
        chaseClaimsEvidencePageObj.selectLeadType("Travel Claim");
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.switchToParentFrame();
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.evidanceChaseBase().click();
        chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
        chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
        try {
            Thread.sleep(61000L); // force wait for 1 min
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.switchToParentFrame();
        nextEventPageObj.logOut().click();
    }

    @And("^Customer selected communication channel as '(.+)'$")
    public void customer_selected_communication_channel_as_(String channel) {
        // throw new PendingException();
    }

    @And("^Select the claim with status 'Open'$")
    public void select_the_claim_with_status_open() {
        // throw new PendingException();
    }

    @And("^Customer is requested to provide an evidence for the a 'Open' claim$")
    public void customer_is_requested_to_provide_an_evidence_for_the_a_open_claim() {
        // throw new PendingException();
    }

    @Then("^Notification should be sent to the customer via his preferred communication channel (.+) stating claim will be closed with in 14 days$")
    public void notification_should_be_sent_to_the_customer_via_his_preferred_communication_channel_stating_claim_will_be_closed_with_in_14_days(String channel) {
        getDriver().navigate().to(System.getProperty("ENV"));
        List<String> userDet = userObj.getUserDetails("AdminUser");
        String loginUserName = userDet.get(1);
        String loginPwd = userDet.get(2);
        userObj.login(loginUserName, loginPwd);
        leftNavPanePageObj.iAdmin().click();
        leftNavPanePageObj.companyDetails().click();
        chaseClaimsEvidencePageObj.clientConfig().click();
        chaseClaimsEvidencePageObj.waitForMoreTime();
        fullEventHistoryPageObj.switchToParentFrame();
//        TODO commented for execution of Final E2E
        chaseClaimsEvidencePageObj.batchJobModifier().click();
        chaseClaimsEvidencePageObj.batchJobModifier().clear();
        chaseClaimsEvidencePageObj.batchJobModifier().sendKeys(dateOperationsObj.getCurrentDate());
        fullEventHistoryPageObj.switchToParentFrame();
        fullEventHistoryPageObj.saveAndClose().click();
        leftNavPanePageObj.iMenu().click();
        chaseClaimsEvidencePageObj.leadManager().click();
        leftNavPanePageObj.setUP().click();
        leftNavPanePageObj.batchJobs().click();
        chaseClaimsEvidencePageObj.selectLeadType("Travel Claim");
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.switchToParentFrame();
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.closeClaimBase().click();
        chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
        chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
        try {
            Thread.sleep(61000L); // force wait for 1 min
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.switchToParentFrame();
        nextEventPageObj.logOut().click();
    }

    @Then("^User submitted the Evidence within (.+) Days$")
    public void user_submitted_the_evidence_within_days(String days) {
        nextEventPageObj.switchToDefault();
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
    }

    @Then("^I must navigate to claims screen$")
    public void i_must_navigate_to_claims_screen() {
        perfSerachObj.retreiveFirstClientRecord();
        claimsOperationsObj.navigateToClaimViewFromPolicyView();
        claimSummaryPageObj.firstClaimSelectLink().click();
        nextEventPageObj.waitForMoreTime();
    }

    @Then("^I should validate '(.+)' Events triggered$")
    public void i_should_validate_and_events_triggered(String evidencechase) {
        getDriver().navigate().refresh();
        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        if(evidencechase.contains("-")) {
            System.out.println("Entering to IF Loop");
            String s1 = evidencechase.split("-")[1];
            System.out.println("String is----" + s1);
            Assert.assertTrue(nextEventPageObj.verifySaveQuoteEvents(s1.trim()).isDisplayed());
        }
        else{
            System.out.println("Entering to Else Loop");
            System.out.println("String is----" + evidencechase);
            Assert.assertTrue(nextEventPageObj.eventRowTableItem(evidencechase.trim()).isDisplayed());
            System.out.println("Asset is true*************************");
        }
    }

    @When("^No response has been received from client before 1 Calender Month$")
    public void no_response_has_been_received_from_client_before_1_calender_month() {
    }

    @Then("^I should validate the claims status '(.+)'$")
    public void i_should_validate_the_claims_status_(String claimclosed) {
        boolean status;
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        claimID = nextEventPageObj.firstClaimID().getText();
        System.out.println("claimID-------------------------" + claimID);
        if(!claimclosed.contains("NOT")) {
            try {
                status = claimSummaryPageObj.firstclaimStatus().getText().equals(claimclosed);
                if (status == true) {
                    System.out.println("Claim Status changed:" + claimSummaryPageObj.firstclaimStatus().getText());
                } else {
                    Thread.sleep(20000);
                    getDriver().navigate().refresh();
                }
            } catch (Exception e) {
                nextEventPageObj.waitForMoreTime();
                getDriver().navigate().refresh();
            }
            Assert.assertTrue(claimSummaryPageObj.firstclaimStatus().getText().equalsIgnoreCase(claimclosed));
        }else{
            Assert.assertTrue(!claimSummaryPageObj.firstclaimStatus().getText().equalsIgnoreCase(claimclosed.replace("NOT ","")));
        }
    }

    @Then("^I should be able to validate the claims status '(.+)'$")
    public void i_should_be_able_to_validate_the_claims_status_(String claimclosed) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(claimSummaryPageObj.firstclaimStatus().getText().equalsIgnoreCase(claimclosed));
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(nextEventPageObj.go());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        perilQuestionsPageObj.btnClick(perilQuestionsPageObj.perilQuestionSaveBtn());
    }

    @Then("^I should validate the claims reserve '(.+)'$")
    public void i_should_validate_the_claims_reserve_(String reserve) {
        Assert.assertTrue(claimSummaryPageObj.firstclaimReserve().getText().equalsIgnoreCase(reserve));
    }

    @Then("^Chase process should be stopped$")
    public void chase_process_should_be_stopped() {
    }

    @Then("^I should send (.+) to customer$")
    public void i_should_send_to_customer(String NotifyCustomer) {
        nextEventPageObj.nextButtonSensitive().click();
        nextEventPageObj.createAndSendEmail().click();
    }

    @Then("^Validate '(.+)' Events in full event history$")
    public void validateEventsInFullEventHistory(String eventName){
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        try {
            Assert.assertTrue(nextEventPageObj.generatedEvent(eventName).isDisplayed());
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
        }catch(Exception e) {
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
        }
    }

    @Then("^Notification should be sent to the customer via his preferred communication channel 'Letter' that the claim will be closed within (\\d+) days$")
    public void notificationShouldBeSentToTheCustomerViaHisPreferredCommunicationChannelLetterThatTheClaimWillBeClosedWithinDays(int arg0) throws Throwable {
        {
//            getDriver().navigate().to("http://dlg-qa.aquarium-software.com");
            getDriver().navigate().to(fileOperationsObj.getApplicationURL(System.getProperty("ENV")));
            List<String> userDet = userObj.getUserDetails("AdminUser");
            String loginUserName = userDet.get(1);
            String loginPwd = userDet.get(2);
            userObj.login(loginUserName, loginPwd);
            leftNavPanePageObj.iAdmin().click();
            leftNavPanePageObj.companyDetails().click();
            chaseClaimsEvidencePageObj.clientConfig().click();
            chaseClaimsEvidencePageObj.waitForMoreTime();
            chaseClaimsEvidencePageObj.waitForMoreTime();
            chaseClaimsEvidencePageObj.waitForMoreTime();
            chaseClaimsEvidencePageObj.waitForMoreTime();
            chaseClaimsEvidencePageObj.waitForMoreTime();
            chaseClaimsEvidencePageObj.waitForMoreTime();
            chaseClaimsEvidencePageObj.waitForMoreTime();
            chaseClaimsEvidencePageObj.waitForMoreTime();
            fullEventHistoryPageObj.switchToParentFrame();
//            TODO commented for execution of Final E2E
            chaseClaimsEvidencePageObj.batchJobModifier().click();
            chaseClaimsEvidencePageObj.batchJobModifier().clear();
            chaseClaimsEvidencePageObj.batchJobModifier().sendKeys(dateOperationsObj.getCurrentDate());
            fullEventHistoryPageObj.switchToParentFrame();
            fullEventHistoryPageObj.saveAndClose().click();
            leftNavPanePageObj.iMenu().click();
            chaseClaimsEvidencePageObj.leadManager().click();
            leftNavPanePageObj.setUP().click();
            leftNavPanePageObj.batchJobs().click();
            chaseClaimsEvidencePageObj.selectLeadType("Travel Claim");
            chaseClaimsEvidencePageObj.waitForMoreTime();
            chaseClaimsEvidencePageObj.switchToParentFrame();
            chaseClaimsEvidencePageObj.waitForMoreTime();
            chaseClaimsEvidencePageObj.closeClaimBase().click();
            chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
            chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
            try {
                Thread.sleep(61000L); // force wait for 1 min
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            chaseClaimsEvidencePageObj.waitForMoreTime();
            chaseClaimsEvidencePageObj.switchToParentFrame();
            nextEventPageObj.logOut().click();
        }
    }
}
