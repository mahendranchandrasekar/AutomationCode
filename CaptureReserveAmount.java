package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.BasicClaimDetailsPage;
import co.uk.directlinegroup.tt.pages.CommonPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.pages.SearchPage;
import co.uk.directlinegroup.tt.utils.ClaimsOperations;
import co.uk.directlinegroup.tt.utils.PerformSearch;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import java.util.List;

public class CaptureReserveAmount extends BaseStepDef {

    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private BasicClaimDetailsPage basicClaimDetailsPageObj = new BasicClaimDetailsPage();
    private SearchPage searchPageObj = new SearchPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private PerformSearch perfSerachObj = new PerformSearch();
    private CommonPage commonPageObj = new CommonPage();

    @And("^I create a policy with the following details$")
    public void i_create_a_policy_with_the_following_details() {
        // Not yet received the details
        // throw new PendingException();
    }
}
