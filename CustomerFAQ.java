package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.utils.CustomerFAQOperations;
import cucumber.api.java.en.Then;

import java.util.List;

/**
 * Created by 588800 on 10/4/2017.
 */
public class CustomerFAQ extends BaseStepDef {

    private CustomerFAQOperations customerFAQOperationsObj = new CustomerFAQOperations();

    @Then("^System presents FAQ page with all FAQ's listed$")
    public void systemPresentsFAQPageWithAllFAQSListed(List<String> category) throws Throwable {
        customerFAQOperationsObj.validateAllCategoriesFAQ(category);
    }
}
