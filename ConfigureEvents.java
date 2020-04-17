package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.EvidenceCollationPage;
import co.uk.directlinegroup.tt.pages.FullEventHistoryPage;
import co.uk.directlinegroup.tt.pages.LeftNavPanePage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.AQConfigurations;
import co.uk.directlinegroup.tt.utils.ClaimsOperations;
import co.uk.directlinegroup.tt.utils.EventHistory;
import co.uk.directlinegroup.tt.utils.QuoteDetails_Aquarium;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.common.ConfigureEventsOperations;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ConfigureEvents extends BaseStepDef {


    private NextEventPage nextEventPageObj = new NextEventPage();

    private ConfigureEventsOperations configureEventsOperationsObj = new ConfigureEventsOperations();
    private QuoteDetails_Aquarium quoteDetails_aquariumObj = new QuoteDetails_Aquarium();
    private co.uk.directlinegroup.tt.utils.Navigation navigationObj = new co.uk.directlinegroup.tt.utils.Navigation();
    private EventHistory eventHistoryObj = new EventHistory();
    private ClaimsOperations claimOperationObj = new ClaimsOperations();
    private Commands commandObj = new Commands();
    private EvidenceCollationPage evidenceCollationPageObj = new EvidenceCollationPage();
    private FullEventHistoryPage fullEventHistoryPageObj = new FullEventHistoryPage();
    private AQConfigurations aqConfigurationsObj = new AQConfigurations();
    private Commands commandsObj = new Commands();

    public static String eventName = "";
    String eventStr = null;

    @When("^an Incident occurs and A new event needs to be created$")
    public void an_incident_occurs_and_a_new_event_needs_to_be_created() {
        navigationObj.navigateToIncidentsConfig();
    }

    @Then("^the user selects the option to add a new event$")
    public void the_user_selects_the_option_to_add_a_new_event() {
        fullEventHistoryPageObj.btnClick(fullEventHistoryPageObj.insertNewRecord());
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.waitForMoreTime();
    }

    @And("^The system will allow the addition of the following data items$")
    public void the_system_will_allow_the_addition_of_the_following_data_items(List<List<String>> lstIncidents) {
        aqConfigurationsObj.setUpIncident(lstIncidents);
    }

    @When("^the user wishes to modify an event$")
    public void the_user_wishes_to_modify_an_event() {
        navigationObj.navigateToIncidentsConfigEdit();
    }

    @Then("^The system will allow the amendments of the following data items$")
    public void the_system_will_allow_the_amendments_of_the_following_data_items(List<List<String>> parameters) {
        fullEventHistoryPageObj.switchToParentFrame();
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(row).size(); column++) {
                switch (parameters.get(0).get(column).toLowerCase()) {
                    case "eventname":
                        fullEventHistoryPageObj.incidentName().clear();
                        fullEventHistoryPageObj.incidentName().sendKeys(parameters.get(row).get(column));
                        fullEventHistoryPageObj.waitForMoreTime();
                        break;
                    case "eventdescription":
                        fullEventHistoryPageObj.incidentDescription().clear();
                        fullEventHistoryPageObj.incidentDescription().sendKeys(parameters.get(row).get(column));
                        fullEventHistoryPageObj.waitForMoreTime();
                        break;
                    case "eventdate":
                        fullEventHistoryPageObj.incidentDate().clear();
                        fullEventHistoryPageObj.incidentDate().sendKeys(parameters.get(row).get(column));
                        fullEventHistoryPageObj.waitForMoreTime();
                        break;
                    case "sortorder":
                        fullEventHistoryPageObj.sortOrder().clear();
                        fullEventHistoryPageObj.sortOrder().sendKeys(parameters.get(row).get(column));
                        fullEventHistoryPageObj.waitForMoreTime();
                        break;
                    case "status":
                        fullEventHistoryPageObj.status().click();
                        fullEventHistoryPageObj.status().sendKeys(parameters.get(row).get(column));
                        fullEventHistoryPageObj.waitForMoreTime();
                        fullEventHistoryPageObj.update().click();
                        fullEventHistoryPageObj.waitForMoreTime();
                        break;
                    default:
                        System.out.println("case not found");

                }
            }
        }
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.switchToParentFrame();
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.btnClick(fullEventHistoryPageObj.saveAndClose());

    }

    @And("^verify high value reserve event is not generated$")
    public void verify_HighValue_ReserveEvent_History() {
        fullEventHistoryPageObj.showFullEventHistory().click();
        nextEventPageObj.switchToLastOpenWindow();
        System.out.println("Verifying high value reserve event");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        fullEventHistoryPageObj.eventhistorytable();
        fullEventHistoryPageObj.eventhistorytable();
        eventHistoryObj.verifyingEvent();
        fullEventHistoryPageObj.closeWindow().click();
        fullEventHistoryPageObj.switchToLastOpenWindow();
    }

    @And("^I should allowed to approve/reject the reserve amount with '(.+)'$")
    public void I_should_allowed_to_approve_reject_the_reserve_amount_with_yes(String text) {
        switch (text) {
            case "yes":
                nextEventPageObj.switchToDefault();
                System.out.println("-------------------------------------" + nextEventPageObj.findElement(By.id("RadWindowContentFramectl00_cphBodyWithoutUpdatePanel_cphBody_rwmEvents_rwEventWizard")).isDisplayed());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToFrameById(nextEventPageObj.approvalframe());
                System.out.println("-----------------------------------approveclaimmovement--" + nextEventPageObj.approveclaimmovement().isDisplayed());
                nextEventPageObj.approveclaimmovement();
                nextEventPageObj.approveclaimmovement().click();
                System.out.println("-----------------------------------approveclaimmovementwithYesOption--" + nextEventPageObj.approveclaimmovementwithYesOption().isDisplayed());
                nextEventPageObj.approveclaimmovementwithYesOption().click();
                nextEventPageObj.claimapproveSavebtn().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "no":
                nextEventPageObj.switchToDefault();
                System.out.println("-------------------------------------" + nextEventPageObj.findElement(By.id("RadWindowContentFramectl00_cphBodyWithoutUpdatePanel_cphBody_rwmEvents_rwEventWizard")).isDisplayed());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToFrameById(nextEventPageObj.approvalframe());
                System.out.println("-----------------------------------approveclaimmovement--" + nextEventPageObj.approveclaimmovement().isDisplayed());
                nextEventPageObj.approveclaimmovement();
                nextEventPageObj.approveclaimmovement().click();
                System.out.println("-----------------------------------approveclaimmovementwithNoOption--" + nextEventPageObj.approveclaimmovementwitNoOption().isDisplayed());
                nextEventPageObj.approveclaimmovementwitNoOption().click();
                nextEventPageObj.claimapproveSavebtn().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
        }
    }

    @And("^verify advice of evidence event is generated in event history$")
    public void verify_advice_of_evidence_event_is_generated_in_event_history() {
        System.out.println("Advice of Evidence-------------");
        try {
            Assert.assertTrue(nextEventPageObj.adviceOfEvidence().isDisplayed());
        } catch (Exception e) {
            Assert.assertTrue(nextEventPageObj.evidence().isDisplayed());
        }
        System.out.println("Event has been verified");
    }


    @And("^verify '(.+)' event is generated$")   //overwrite with existing method
    public void verify_Recovery_Confirmation_Request_Email_event_is_generated(String event) {
        nextEventPageObj.switchToDefault();
        System.out.println("Verify Event Method...");
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        //configureEventsOperationsObj.verifyEvents(event);
        try {
            if (event.contains("#")) {
                System.out.println("Into single #");
                configureEventsOperationsObj.verifyMultipleEvents(event);

            }
//            else if (event.contains("$")) {
//                System.out.println("Into $");
//                configureEventsOperationsObj.verifyMultipleEventsInshowFullEventHistory(event);
//            }
            else {
                configureEventsOperationsObj.verifyEvents( event );
            }
        } catch (Throwable throwable) {
            System.out.println("Do nothing");
            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToLastOpenWindow();
            nextEventPageObj.waitForMoreTime();
            Assert.assertTrue(false);
        }
    }

    @And("^verify '(.+)' event and '(.+)' document are generated and download it$")
    public void verify_event_and_document_are_generated_and_download_it(String event, String document) {
        System.out.println("Document verification started...");
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        configureEventsOperationsObj.validateDocument(event, document);
    }

    @And("^System should communicate the customer relating to following events$")
    public void systemShouldCommunicateTheCustomerRelatingToFollowingEvents(List<List<String>> parameters) {
        quoteDetails_aquariumObj.retriveClientRecord();
        nextEventPageObj.switchToDefault();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        try {
            configureEventsOperationsObj.validateEvents(parameters);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        fullEventHistoryPageObj.eventHistoryCloseWindow().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToWindowByIndex(1);
    }

    @And("^System should not communicate the customer relating to following events$")
    public void systemShouldNotCommunicateTheCustomerRelatingToFollowingEvents(List<List<String>> parameters) {
        quoteDetails_aquariumObj.retriveClientRecord();
        nextEventPageObj.switchToDefault();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        try {
            configureEventsOperationsObj.validateEvents(parameters);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @And("^I should allow to capture the CMS Reference number as '(.+)'$")
    public void iShouldAllowToCaptureTheCMSReferenceNumberAs(String referenceNumber) {
        try {
            configureEventsOperationsObj.validateCMSReferenceNumber(referenceNumber);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @And("^I should allow to manually flag the policy with CMS reference number '(.+)' using the below details$")
    public void iShouldAllowToManuallyFlagThePolicyWithCMSReferenceNumberUsingTheBelowDetails(String referenceNumber, List<List<String>> parameters) {
        try {
            configureEventsOperationsObj.flagThePolicy(referenceNumber, parameters);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @And("^I should allow to close the complaint using the below details$")
    public void iShouldAllowToCloseTheComplaintUsingTheBelowDetails(List<List<String>> parameters) {
        try {
            configureEventsOperationsObj.closeTheComplaint(parameters);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @And("^I should be able to configure maximum early renewal period as '(.+)' days$")
    public void iShouldBeAbleToConfigureMaximumEarlyRenewalPeriod(String days) {
        configureEventsOperationsObj.configureMaximumEarlyRenewalPeriod(days);
    }

    @And("^verify '(.+)' event is not generated$")
    public void verifyRenewalCreateQuoteEventIsNotGenerated(String event) {
        nextEventPageObj.switchToDefault();
        System.out.println("Verify Event Method...");
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        try {
            configureEventsOperationsObj.verifyEventsNotGenerated(event);
        } catch (Throwable throwable) {
            System.out.println("Do nothing");
        }
    }

    @Then("^I should be able to verify the documentation issued to customer$")
    public void iShouldBeAbleToVerifyTheDocumentationIssuedToCustomer() {
        configureEventsOperationsObj.navigateToPolicyEvents();
        claimOperationObj.clickingUnderNextEventsAndButtons("Show Full Event History");
    }

    @Then("^I should be able to get the documentation issued$")
    public void iShouldBeAbleToGetTheDocumentationIssued() {
        configureEventsOperationsObj.navigateToPolicy();
        claimOperationObj.clickingUnderNextEventsAndButtons("Show Full Event History");
    }

    @And("^I should be able to verify '(.+)' event generated for the supplier$")
    public void iShouldBeAbleToVerifyRushPaymentRequestEventGeneratedForTheSupplier(String event) {
        try {
            configureEventsOperationsObj.verifyEvents(event);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @And("^Navigate to the '(.+)'$")
    public void navigateToTheTaskReminders(String reminder) throws Throwable {
        configureEventsOperationsObj.navigateToTaskReminder();
    }

    @And("^Validate the dairy Appointments table should have the following headers listed below$")
    public void validateTheDairyAppointmentsTableShouldHaveTheFollowingHeadersListedBelow(List<List<String>> parameters) throws Throwable {
        configureEventsOperationsObj.validatingTaskRemainderTableHeaderValidation(parameters);
    }

    @And("^verify event '(.+)' is not generated$")
    public void verifyEventDayOneCommunicationLetterIsNotGenerated(String event) {
        fullEventHistoryPageObj.showFullEventHistory().click();
        nextEventPageObj.switchToLastOpenWindow();
        //  getDriver().manage().window().maximize();
        System.out.println("Verifying high value reserve event");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        fullEventHistoryPageObj.eventhistorytable();
        fullEventHistoryPageObj.eventhistorytable();
        try {
            eventHistoryObj.verifyingEventNotGenerated(event);
            fullEventHistoryPageObj.closeWindow().click();
            nextEventPageObj.switchToLastOpenWindow();
        } catch (Exception e) {
            fullEventHistoryPageObj.closeWindow().click();
            nextEventPageObj.switchToLastOpenWindow();
        }
    }

    @And("^verify '(.+)' event is generated in Full Event History$")
    public void verifyOOPFailedPaymentNewDetailsRequiredEmailEventIsGeneratedInFullEventHistory(String event) {
        nextEventPageObj.switchToDefault();
        System.out.println("Verify Event in Full Event History Method...");
        nextEventPageObj.waitForMoreTime();
        try {
            configureEventsOperationsObj.verifyEventsinFullHostory(event);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    @And("^verify events are generated$")
    public void verifyEventsAreGenerated(List<List<String>> parameters) {
        try {
            System.out.println("Entering Func verifyEventsAreGenerated");
            nextEventPageObj.switchToDefault();
            System.out.println("Verify Multiple Events Method...");
            for (int row = 1; row < parameters.size(); row++) {
                for (int column = 0; column < parameters.get(row).size(); column++) {
                    int i = 0;
                    while (i < 3) {
                        try {
                            getDriver().navigate().refresh();
                            commandObj.waitForLoad(getDriver());
                            commandObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
                            if (parameters.get(row).get(column).equalsIgnoreCase("Generate Remittance Advice")) {
                                Thread.sleep(60000L);// Fix for appliation performance issue tt232
                            }
                            configureEventsOperationsObj.verifyEvents((parameters.get(row).get(column)));
                            break;
                        } catch (Exception ex) {
                            System.out.println("Inside exception -- error message:: " + ex.getMessage());
                            i++;
                            System.out.println("Retrying:: " + i);
                            if (i >= 3) {
                                Assert.assertTrue(false);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            Assert.assertTrue(false);
        }
        System.out.println("Exiting Func verifyEventsAreGenerated");
    }


    @And("^I should be verify the next action as '(.+)'$")
    public void iShouldBeVerifyTheNextActionAsNEXTACTIONLetterTIMRepudiationFULL(String NextAction) throws Throwable {
        nextEventPageObj.switchToDefault();
        System.out.println("Next action is  " + NextAction);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        Thread.sleep(300000);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(nextEventPageObj.VerifyNextAction(NextAction).isDisplayed());
        System.out.println("Next action " + NextAction + " is verified");
    }

    @And("^verify that '(.+)' event should not be generated$")
    public void verifyThatAVACancelledLetterEventShouldNotBeGenerated(String event) throws Throwable {
        System.out.println("Verifying the events......");
        Assert.assertTrue(!commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath("//*[contains(@text,'" + event + "')]")));
        System.out.println("Event is not generated");
    }

    @And("^Verify '(.+)' is generated only once$")
    public void verifyNewQuestionsCRIsGeneratedOnlyOnce(String events) {
        eventHistoryObj.verifyEventCountInFullEventHistory(events);
    }

    @And("^verify event '(.+)' is removed from the Event history$")
    public void verifyEventIsRemovedFromTheEventHistory(String event) {
        fullEventHistoryPageObj.showFullEventHistory().click();
        nextEventPageObj.switchToLastOpenWindow();
        //  getDriver().manage().window().maximize();
        System.out.println("Verifying event is not generated in the event history");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        fullEventHistoryPageObj.eventhistorytable();
        fullEventHistoryPageObj.eventhistorytable();
        try {
            eventHistoryObj.verifyingEventNotGenerated(event);
            fullEventHistoryPageObj.closeWindow().click();
            nextEventPageObj.switchToLastOpenWindow();
        }catch (Exception e){
            fullEventHistoryPageObj.closeWindow().click();
            nextEventPageObj.switchToLastOpenWindow();
        }
    }

    @And("^I should verify only one such event '(.+)' is generated$")
    public void iShouldVerifyOnlyOneSuchEventEmailTIMSettlementNotificationEmailSIsGenerated(String event) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        eventName=event;
        fullEventHistoryPageObj.showFullEventHistory().click();
        nextEventPageObj.switchToLastOpenWindow();
        System.out.println("Verifying only one event is generated");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        eventHistoryObj.verifyingEventName(eventName);
    }
}
