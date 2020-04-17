package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.CustomerPortalSignInPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.ClaimsOperations;
import co.uk.directlinegroup.tt.utils.CustomerPortalCreateClaim;
import co.uk.directlinegroup.tt.utils.PerformSearch;
import co.uk.directlinegroup.tt.utils.User;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class CustomerPortalClaim extends BaseStepDef {

    private ClaimsOperations claimOperationObj = new ClaimsOperations();

    @Then("^System should ask the following questions to the customer$")
    public void systemShouldAskTheFollowingQuestionsToTheCustomer(List<List<String>> parameters) throws Throwable {
        claimOperationObj.cr21PerilQuestionsValidation(parameters);
    }

    @Then("^System should ask the following questions items to the customer$")
    public void systemShouldAskTheFollowingQuestionsItemsToTheCustomer(List<List<String>> parameters) throws Throwable {
        claimOperationObj.cr21PerilQuestionsItems(parameters);
    }
}
