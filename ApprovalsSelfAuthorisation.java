package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.BasicClaimDetailsPage;
import co.uk.directlinegroup.tt.utils.ClaimsOperations;
import co.uk.directlinegroup.tt.utils.PerformSearch;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApprovalsSelfAuthorisation extends BaseStepDef {

    private ClaimsOperations claimOperationObj = new ClaimsOperations();
    private PerformSearch perfSerachObj = new PerformSearch();
    private BasicClaimDetailsPage basicClaimDetailsPageObj = new BasicClaimDetailsPage();

    @And("^Search and select the Claim with ID (.+)$")
    public void search_and_select_the_claim_with_id(String claimid) {
        perfSerachObj.retreiveFirstClientRecord();
        claimOperationObj.navigateToClaimViewFromPolicyView();
        claimOperationObj.claimIdSearch(claimid);
        basicClaimDetailsPageObj.selectClaimNumber(claimid).click();
    }
}
