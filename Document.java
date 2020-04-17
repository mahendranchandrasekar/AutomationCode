package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.pages.UploadDocumentPage;
import co.uk.directlinegroup.tt.utils.DigitalOperations;
import co.uk.directlinegroup.tt.utils.DocumentManagerOperations;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Document extends BaseStepDef {

    private UploadDocumentPage uploadDocumentPageObj = new UploadDocumentPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private DigitalOperations digitalOperationsObj = new DigitalOperations();
    private co.uk.directlinegroup.tt.utils.Navigation navigationObj = new co.uk.directlinegroup.tt.utils.Navigation();
    private DocumentManagerOperations documentManagerOperationsObj = new DocumentManagerOperations();

    @And("^I should be able to upload a file with the below details$")
    public void iShouldBeAbleToUploadAFileWithTheBelowDetails(List<List<String>> lstInputs) throws Throwable {
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        uploadDocumentPageObj.chooseFile().click();
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_C);        // C
        r.keyRelease(KeyEvent.VK_C);
        r.keyPress(KeyEvent.VK_COLON);    // : (colon)
        r.keyRelease(KeyEvent.VK_COLON);
        r.keyPress(KeyEvent.VK_SLASH);    // / (slash)
        r.keyRelease(KeyEvent.VK_SLASH);
        r.keyPress(KeyEvent.VK_ENTER);    // confirm by pressing Enter in the end
        r.keyRelease(KeyEvent.VK_ENTER);
    }

    @Given("^An existing template needs to  be amended as '(.+)'$")
    public void anExistingTemplateNeedsToBeAmendedAsDLGAdmin(String validuser) throws Throwable {
        digitalOperationsObj.loginAQ(validuser);
        navigationObj.navigateToDocumentManager();
    }

    @When("^user updates the template with id '(.+)'$")
    public void userUpdatesTheTemplateWithId(String strDocID) throws Throwable {
        documentManagerOperationsObj.searchDocInDocManager(strDocID);
        documentManagerOperationsObj.editDocTemplate(strDocID);

    }

    @Then("^user should be able to archive out of date templates and make current template as '(.+)' with current date as well as see version history '(.+)'$")
    public void userShouldBeAbleToArchiveOutOfDateTemplatesAndMakeCurrentTemplateAsActiveWithCurrentDate(String strDocStatus, String strUser) throws Throwable {
       documentManagerOperationsObj.manageVersions(strUser);
    }
}
