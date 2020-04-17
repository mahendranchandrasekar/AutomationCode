package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.BasicClaimDetailsPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.pages.SearchPage;
import co.uk.directlinegroup.tt.utils.ClaimsOperations;
import co.uk.directlinegroup.tt.utils.PerformSearch;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

public class AuthoriseReserveAmount extends BaseStepDef {

    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private BasicClaimDetailsPage basicClaimDetailsPageObj = new BasicClaimDetailsPage();
    private SearchPage searchPageObj = new SearchPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private PerformSearch perfSerachObj = new PerformSearch();

    @And("^I should be able to create a '(.+)' with the basic details$")
    public void i_should_be_able_to_create_a_new_claim_with_the_basic_details(String strExpBeh, List<List<String>> parameters) {
        try {
            System.out.println("Start new cliam from here");
            perfSerachObj.retreiveFirstClientRecord();
            claimsOperationsObj.navigateToClaimViewFromPolicyView();
            claimsOperationsObj.startNewClaim();
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
            claimsOperationsObj.createClaimForReserve(strExpBeh, parameters);
            basicClaimDetailsPageObj.save().click();
            nextEventPageObj.CancelBtn().click();
            System.out.println("Start edit cliam from here");
            basicClaimDetailsPageObj.getFirstOpenClaim().click();
            searchPageObj.switchToWindowByIndex(1);
            Thread.sleep(3000);
            claimsOperationsObj.createEditClaimsForReserveAmount(strExpBeh, parameters);
            basicClaimDetailsPageObj.saveAndClose().click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^the system should recognize the reserve thresholds'(.+)' and assign to '(.+)' approval group if reserve amount '(.+)' exceeds limit '(.+)'$")
    public void the_system_should_recognize_the_reserve_thresholds_and_assign_to_approval_group_if_reserve_amount_exceeds_limit_(List<List<String>> reserve, String approvalgroup, String reserveamount, String reserveapprovallimit) throws Throwable {
        System.out.println("********** reserve **************");
        for (int row = 1; row < reserve.size(); row++) {
            for (int column = 0; column < reserve.get(0).size(); column++) {
                System.out.println(reserve.get(0).get(column) + " - R - " + row + " - C -  " + column + " - " + reserve.get(row).get(column));
            }
        }
    }

    @And("^I must be able to '(.+)' the reserve with notes in case of rejection$")
    public void i_must_be_able_to_the_reserve_with_notes_in_case_of_rejection(String approvalaction) {
        throw new PendingException();
    }

    @And("^the system should record the '(.+)' with date, time, UserID '(.+)'$")
    public void the_system_should_record_the_with_date_time_userid_(String approvalaction, String approvalgroup) {
        throw new PendingException();
    }

    @And("^the Claim Adjuster should be notified with '(.+)'$")
    public void the_claim_adjuster_should_be_notified_with_(String approvalnotification) {
        throw new PendingException();
    }
}
