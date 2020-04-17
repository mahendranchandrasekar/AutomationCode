package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.common.LoadTTPropertiesFiles;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Claims extends BaseStepDef {

    public static String claimID = "";
    public static String claimItemId = "";

    public String paymentfailurecaseid;
    private static String escalationReason = "Cannot complete, further info needed";
    public static String caseID = "";
    String claimID2 = "";
    String percentage_before = "";
    String amount_before = "";
    String strEventType = "OOP Re-Open Claim";
    String strEventType_Process = "Process Claim";
    private AccountInformationPage accountInformationPageObj = new AccountInformationPage();
    private RecoveryOpportunitiesPage recoveryOpportunitiesPageObj = new RecoveryOpportunitiesPage();
    private PerilQuestionsPage perilQuestionsPageObj = new PerilQuestionsPage();
    private FinalisePaymentPage finalisePaymentPageObj = new FinalisePaymentPage();
    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private PaymentAwaitingApprovalPage paymentAwaitingApprovalPageObj = new PaymentAwaitingApprovalPage();
    private ChequePaymentPage chequePaymentPageObj = new ChequePaymentPage();
    private FullEventHistoryPage fullEventHistoryPageObj = new FullEventHistoryPage();
    private PolicySummaryPage policySummaryPageObj = new PolicySummaryPage();
    private PolicyOperations policyOperationsObj = new PolicyOperations();
    private ManageWorkflowTaskPage manageWorkflowTaskPageObj = new ManageWorkflowTaskPage();
    private RecoveryOpportunities recoveryOpportunitiesObj = new RecoveryOpportunities();
    private SchemeSummaryPage schemeSummaryPageObj = new SchemeSummaryPage();
    private ClaimsOperations claimOperationObj = new ClaimsOperations();
    private BasicClaimDetailsPage basicClaimDetObj = new BasicClaimDetailsPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private SearchPage searchPageObj = new SearchPage();
    private PerformSearch perfSerachObj = new PerformSearch();
    private PerilsAndCostsPage perilsAndCostsPageObj = new PerilsAndCostsPage();
    private User userObj = new User();
    private SummaryView summaryViewObj = new SummaryView();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private Commands commandsObj = new Commands();
    private EvidenceCollationPage evidenceCollationPageObj = new EvidenceCollationPage();
    private co.uk.directlinegroup.tt.utils.Navigation navigationObj = new co.uk.directlinegroup.tt.utils.Navigation();
    private FinancialPage financialPageObj = new FinancialPage();
    private OutofProcessEvents outofProcessEventsObj = new OutofProcessEvents();
    private ClaimsRepudiationOperations claimsRepudiationOperationsObj = new ClaimsRepudiationOperations();
    private ClaimsRepudiationPage claimsRepudiationPageObj = new ClaimsRepudiationPage();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private ClaimCreation claimCreationObj = new ClaimCreation();
    private ClaimPaymentPage claimPaymentPageObj = new ClaimPaymentPage();
    private ClaimPaymentOperations claimPaymentOperationsObj = new ClaimPaymentOperations();
    private TMADetails tmaDetailsObj = new TMADetails();
    private QuoteDetailsPage quoteDetailsPageObj = new QuoteDetailsPage();
    private QuoteDetails_Aquarium quoteDetails_aquariumObj = new QuoteDetails_Aquarium();
    private QuoteAndBuyOperations quoteAndBuyOperationsObj = new QuoteAndBuyOperations();
    private ClientOperations clientOperationsObj = new ClientOperations();
    private ClaimHandlingOperations claimHandlingOperationsObj = new ClaimHandlingOperations();
    private SupplierOperations supplierOperationsObj = new SupplierOperations();
    private TMADetailsPage tmaDetailsPageObj = new TMADetailsPage();
    private CommonPage commonPageObj = new CommonPage();
    private TTAPIOperations ttapiOperationsObj = new TTAPIOperations();
    private String sysDate = "";

    @And("^I should be able to Create a new '(.+)' with Basic details$")
    public void i_should_be_able_to_create_a_new_with_basic_details(String strExpBeh, List<List<String>> parameters) {
        perfSerachObj.retreiveFirstClientRecord();
        claimOperationObj.navigateToClaimViewFromPolicyView();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(claimSummaryPageObj.newClaim());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForPageLoad();
        claimID = basicClaimDetObj.getFirstClaim().getText();
        claimID = nextEventPageObj.firstClaimID().getText();
        ClaimCreation.claimID = basicClaimDetObj.getFirstClaim().getText();
        System.out.println("Claim ID2:: " + claimID);
        claimOperationObj.claimID = claimID;
        try {
            if (nextEventPageObj.goDisplayed()) {
                nextEventPageObj.go().click();
            }
        } catch (org.openqa.selenium.WebDriverException ex) {
            if (nextEventPageObj.loadingPage()) {
                if (nextEventPageObj.goDisplayed()) {
                    nextEventPageObj.go().click();
                }
            }
        }
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimOperationObj.createEditClaims(strExpBeh, parameters);
    }

    @And("^I should be able to '(.+)' the claim$")
    public void i_should_be_able_to_the_claim(String saveandclose) {
        basicClaimDetObj.saveAndClose().click();
    }

    @Given("^I must be able to capture the reason for the claims '(.+)' and '(.+)'$")
    public void i_must_be_able_to_capture_the_reason_for_the_claims_and(String clmCause, String andSave, List<List<String>> parameters) {
        //    List<List<String>> newParameters = commandsObj.parameterMappingNew(1, parameters, LoadTTPropertiesFiles.CLAIMDETAILS_PROP);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        commonPageObj.switchToFrameById(commonPageObj.fancyFrame());
        claimOperationObj.validateClaimCause(clmCause, andSave, parameters);
    }

    @Then("^I must be navigate to capture claim cause screen$")
    public void i_must_be_navigate_to_capture_claim_cause_screen() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        commonPageObj.switchToFrameById(commonPageObj.fancyFrame());
    }

    @Then("^I must be able to Save the ClaimType$")
    public void i_must_be_able_to_save_the_claimtype() {
        if (!(perilsAndCostsPageObj.claimSavePeril().isDisplayed())) {
            System.out.println("save peril is not displayed");
        } else {
            perilsAndCostsPageObj.claimSavePeril().click();
        }
    }

    @Then("^It must be possible to add '(.+)' and CostItem$")
    public void it_must_be_possible_to_add_and_costitem(String customer) {
        perilsAndCostsPageObj.addPerson().click();
        perilsAndCostsPageObj.claimAddPerson(customer).click();
        perilsAndCostsPageObj.addClaimItem(customer).click();
    }

    @And("^I must be possible to add a CostItem$")
    public void i_must_be_possible_to_add_a_costitem() {
        perilsAndCostsPageObj.addClaimItem().click();
    }

    @And("^allocate '(.+)' to person and other details as per below table$")
    public void allocate_to_person_and_other_details_as_per_below_table(String clmCause, List<List<String>> parameters) {
        claimOperationObj.validateClaimCostType(clmCause, parameters);
    }

    @And("^I should be able save the '(.+)' peril")
    public void i_should_be_able_save_the_peril(String perilName) {
        perilsAndCostsPageObj.saveClaimItem().click();
        perilsAndCostsPageObj.saveClaimDetails().click();
    }

    @Then("^I should be able to Add below '(.+)'  for each Person to each ClaimType added$")
    public void i_should_be_able_to_add_below_for_each_person_to_each_claimtype_added(String person, List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.addPersonCostItem(person, parameters);
        this.sysDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString();
        System.out.println("System date ------------------------" + this.sysDate);
    }

    @And("^I should be able save the claim$")
    public void i_should_be_able_save_the_claim() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        perilsAndCostsPageObj.saveClaimDetails().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    @And("^I should be able to save the claim$")
    public void i_should_be_able_to_save_the_claim() {
        nextEventPageObj.waitForMoreTime();
        perilsAndCostsPageObj.btnClick(perilsAndCostsPageObj.saveClaimDetails());
    }

    @Given("^I am reviewing the claim$")
    public void iAmReviewingTheClaim() {
        Assert.assertTrue(claimSummaryPageObj.claimSummaryTable().isDisplayed());
    }

    @And("^I save '(.+)'$")
    public void iSaveBasicClaimDetails(String strClaimScreen) {
        claimOperationObj.saveClaim(strClaimScreen);
    }

    @And("^I should be able to Create a new '(.+)'$")
    public void iShouldBeAbleToCreateANew(String claim, List<List<String>> parameters) {
        perfSerachObj.retreiveFirstClientRecord();
        claimCreationObj.createANewClaim(claim, parameters);
    }

    @And("^I should validate the Claim Country of Loss is Alphabetical order$")
    public void i_should_validate_the_claim_country_of_loss_is_alphabetical_order() {
        claimOperationObj.validateBasicClaimDetailsFields();
    }

    @And("^I should be able to have the below Evidences$")
    public void i_should_be_able_to_have_the_below_evidences() {
    }

    @And("^I should able to select the evidence based on the below list$")
    public void i_should_able_to_select_the_evidence_based_on_the_below_list(List<List<String>> parameters) {
        int rw;
        List<Integer> rl = new ArrayList<>();
        rl = claimOperationObj.getRowListFromTable(claimOperationObj.convertList(parameters), evidenceCollationPageObj.evidenceCollationTable());
        for (int a = 0; a < rl.size(); a++) {
            if (rl.get(a) != 0) {
                rw = rl.get(a);
                evidenceCollationPageObj.providedChkBox(evidenceCollationPageObj.evidenceCollationTable(), rw).click();
            }
        }
        nextEventPageObj.btnClick(evidenceCollationPageObj.save());
    }

    @And("^I click Cancel on '(.+)'$")
    public void iClickCancelOnEvidenceDetails(String strScreen) {
        claimOperationObj.clickCancel(strScreen);
    }

    @Then("^I can amend the notes to an alternate category which should then be saved with the current User, Date and Time$")
    public void iCanAmendTheNotesToAnAlternateCategoryWhichShouldThenBeSavedWithTheCurrentUserDateAndTime(List<List<String>> lstInput) {
        String strNoteEvent = lstInput.get(1).get(0);
        String strNoteType = lstInput.get(1).get(1);
        String strNotes = lstInput.get(1).get(2);
        String strUser = lstInput.get(1).get(3);
        String strNoteCategory = lstInput.get(1).get(4);
        perfSerachObj.retreiveFirstClientRecord();
        claimOperationObj.navigateToClaimViewFromPolicyView();
        summaryViewObj.editnote();
        summaryViewObj.editNoteCategory(strNoteCategory);
        String strDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        summaryViewObj.validateNotesRecordInEventHistory(strNoteType, strNotes, strDate, strUser);
    }

    @And("^I should be able to fill Other Insurance page with following details$")
    public void i_should_be_able_to_fill_other_insurance_page_with_(List<List<String>> lstOtherInsurerDetails) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        finalisePaymentPageObj.eveNext().click();
        claimOperationObj.completeOtherInsurancePolicy(lstOtherInsurerDetails);
    }

    @And("^I should be able to select '(.+)' in next events$")
    public void i_should_be_able_to_select_in_next_events(String strEventType) {
        navigationObj.navigateToNextEventType(strEventType);
        evidenceCollationPageObj.save().click();
    }

    @And("^I should be able to Create a repudiation letter$")
    public void i_should_be_able_to_Create_a_repudiation_letter() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(nextEventPageObj.go());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
    }

    @And("^I navigate to '(.+)' and '(.+)'$")
    public void iNavigateToAndCaptureTheFollowing(String strEventType, String strAction, List<List<String>> lstInputs) {
        try {
            if (!strEventType.equalsIgnoreCase("Other Insurer") && !strEventType.equalsIgnoreCase("Claim Calculation") &&
                    !strEventType.equalsIgnoreCase("Collate Information") && !strEventType.equalsIgnoreCase("Process Claim") && !strEventType.equalsIgnoreCase("TMA advice of evidence") && !strEventType.equalsIgnoreCase("advice of evidence")) {
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                System.out.println("field name --------------------" + strEventType);
                navigationObj.navigateToNextEventType(strEventType);

            }
            switch (strEventType.trim().toLowerCase()) {
                case "capture incidents":
                    nextEventPageObj.switchToDefault();
                    nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                    if (strAction.equalsIgnoreCase("I should not be able to capture the following")) {
                        claimOperationObj.captureIncidents(lstInputs, false);
                    } else {
                        claimOperationObj.captureIncidents(lstInputs, true);
                    }
                    nextEventPageObj.switchToDefault();
                    break;
                case "collate evidence":
                case "advice of evidence":
                case "information required":
                    if (nextEventPageObj.goDisplayed()) {
                        nextEventPageObj.switchToWindowByIndex(1);
                        nextEventPageObj.btnClick(nextEventPageObj.go());
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.switchToFrameByIndex(0);
                    }
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        claimOperationObj.captureEvidence(lstInputs);
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        Thread.sleep(10000L);
                    } else if (strAction.equalsIgnoreCase("capture the following action")) {
                        claimOperationObj.captureEvidenceForDigitalClaim(lstInputs);
                    } else if (strAction.equalsIgnoreCase("validate evidences")) {
                        claimOperationObj.validateEvidences(lstInputs);
                    }
                    break;
                case "new questions - cr21":
                    if (nextEventPageObj.goDisplayed()) {
//                        nextEventPageObj.switchToWindowByIndex(1);
//                        nextEventPageObj.go().click();
                        nextEventPageObj.btnClick(nextEventPageObj.go());
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.switchToFrameByIndex(0);
                    }
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        finalisePaymentPageObj.save().click();
                    }
                    break;
                case "oop update customer details":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        policyOperationsObj.captureCustomerUpdateDetails(lstInputs);
                    }
                    break;
//                case "Review Repatriation Requirements":
//                    if (strAction.equalsIgnoreCase("validate the following")) {
//                        //call a method that will take all the required inputs and validate the evidence
//                    } else if (strAction.equalsIgnoreCase("capture the following")) {
//                        //call a method that will take all the required inputs and capture the evidence
//                        basicClaimDetObj.save().click();
//                    }
//                    break;
                case "resolve failure - by correspondence":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        finalisePaymentPageObj.btnClick(finalisePaymentPageObj.eveNext());
                    }
                    break;
                case "air ambulance quotes received":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        finalisePaymentPageObj.commentsForAirAmbulanceQuotes().sendKeys("tresting");
                        nextEventPageObj.saveBtn().click();
                    }
                    break;
                case "confirm air ambulance approval":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        nextEventPageObj.saveBtn().click();
                    }
                    break;
                case "review air ambulance quotes":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        nextEventPageObj.saveBtn().click();
                    }
                    break;
                case "card payment - complete billing records":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        finalisePaymentPageObj.btnClick(finalisePaymentPageObj.eveNext());
                    }
                    break;
                case "review repatriation requirements":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        policyOperationsObj.captureRepatriationDetails(lstInputs);
//                        nextEventPageObj.waitForMoreTime();
//                        nextEventPageObj.waitForMoreTime();
//                        nextEventPageObj.waitForMoreTime();
//                        policyDataFieldsPageObj.policySave().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.btnClick(policyDataFieldsPageObj.policySave());
//                        getDriver().navigate().refresh();
//                        nextEventPageObj.waitForMoreTime();
//                        getDriver().navigate().refresh();
//                        nextEventPageObj.waitForMoreTime();
//                        nextEventPageObj.waitForMoreTime();
//                        commandsObj.waitForLoad(getDriver());
//                        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
//                        nextEventPageObj.btnClick(nextEventPageObj.go());
//                        nextEventPageObj.waitForMoreTime();
//                        nextEventPageObj.switchToDefault();
//                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
//                        nextEventPageObj.btnClick(policyDataFieldsPageObj.policySave());
//                        nextEventPageObj.waitForMoreTime();
                    }
                    break;
                case "oop repatriation process flow":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        System.out.println( "into else if of capture the following********" );
                        policyOperationsObj.captureRepatriationDetails(lstInputs);
//                        nextEventPageObj.waitForMoreTime();
//                        nextEventPageObj.waitForMoreTime();
//                        nextEventPageObj.waitForMoreTime();
//                        policyDataFieldsPageObj.policySave().click();
                        nextEventPageObj.waitForMoreTime();
                        getDriver().navigate().refresh();
                        nextEventPageObj.waitForMoreTime();
                        getDriver().navigate().refresh();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        commandsObj.waitForLoad(getDriver());
                        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
                        nextEventPageObj.btnClick(nextEventPageObj.go());
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                        nextEventPageObj.btnClick(policyDataFieldsPageObj.policySave());
                        nextEventPageObj.waitForMoreTime();
                    }
                    break;
                case "oop upload medical report":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        tmaDetailsPageObj.chbxMedicalReportTranslationRequired().click();
                        policyDataFieldsPageObj.policySave().click();
                        policyOperationsObj.captureCustomerUpdateDetails(lstInputs);
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        tmaDetailsPageObj.btnUploadFile().click();
//                        Thread.sleep(2000);
//                        nextEventPageObj.waitForMoreTime();
//                        nextEventPageObj.waitForMoreTime();
//                        try {
//                            Runtime.getRuntime().exec("D:\\mahendran\\MedicalReportFileUpload.docx");
//                        }
//                        catch (IOException e){
//                            e.printStackTrace();
//                        }
//                        tmaDetailsPageObj.repatriationComments().sendKeys("test");
//                        policyDataFieldsPageObj.policySave().click();

                    }
                    break;
                case "oop upload gp check document":
                case "oop loa received | email":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        tmaDetailsPageObj.btnUploadFile().click();
//                        Thread.sleep(2000);
//                        nextEventPageObj.waitForMoreTime();
//                        nextEventPageObj.waitForMoreTime();
//                        try {
//                            Runtime.getRuntime().exec("D:\\mahendran\\MedicalReportFileUpload.docx");
//                        }
//                        catch (IOException e){
//                            e.printStackTrace();
//                        }
//                        tmaDetailsPageObj.repatriationComments().sendKeys("test");
//                        policyDataFieldsPageObj.policySave().click();

                    }
                    break;
                case "oop upload supplier instruction response":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        policyOperationsObj.captureSupplierInstruction(lstInputs);
                    }
                    break;
                case "oop additional assistance required":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        policyOperationsObj.captureAdditionalInformation(lstInputs);
                    }
                    break;
                case "oop luggage repatriation start":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        policyOperationsObj.captureLuggageRepatriation(lstInputs);
                    }
                    break;
                case "contact customer to confirm luggage repatriation":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        policyDataFieldsPageObj.comments().sendKeys("Quote is Approved");
                        policyDataFieldsPageObj.finishButton().click();
                    }
                    break;
                case "confirm passport details (air ambulance)":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        tmaDetailsObj.enterPassportDetails(lstInputs);
                    }
                    break;
                case "testing - wp set token":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        policyOperationsObj.captureTestingWPSetToken(lstInputs);
                    }
                    break;
                case "testing - wp first notification system error":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        policyOperationsObj.captureTestingWPSetToken(lstInputs);
                    }
                    break;
                case "testing - wp card notification update":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        policyOperationsObj.captureTestingWPCardNotificationUpdate(lstInputs);
                        policySummaryPageObj.btnChequeSave().click();
                    }
                    break;
                case "oop re-open claim":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        policyOperationsObj.captureReopenDetails(lstInputs);
                    }
                    break;
                case "claim processing advice":
                    System.out.println("Inside claim processing advice");
                    break;
                case "oop send loa form":
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        System.out.println("Inside LOA form capture the following");
                        for (int i = 0; i < lstInputs.get(0).size(); i++) {
                            claimOperationObj.verifycheckhelperfields(lstInputs.get(0).get(i), lstInputs.get(1).get(i));
                        }
                    }
                    claimsRepudiationPageObj.helperfield_save().click();
                    break;
                case "oop chase customer by phone":
                    if (strAction.equalsIgnoreCase("capture the following")) {
                    } else if (strAction.equalsIgnoreCase("validate the following")) {

                    }
                    claimsRepudiationPageObj.helperfield_save().click();
                    break;
                case "oop chase supplier by phone":
                    if (strAction.equalsIgnoreCase("capture the following")) {
                    } else if (strAction.equalsIgnoreCase("validate the following")) {
                    }
                    claimsRepudiationPageObj.helperfield_save().click();
                    break;
                case "oop chase next of kin by phone":
                    if (strAction.equalsIgnoreCase("capture the following")) {
                    } else if (strAction.equalsIgnoreCase("validate the following")) {
                    }
                    claimsRepudiationPageObj.helperfield_save().click();
                    break;
                case "oop request access to medical information":
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        System.out.println("Inside request access to medical information form capture the following");
                        for (int i = 0; i < lstInputs.get(0).size(); i++) {
                            claimOperationObj.verifycheckhelperfields(lstInputs.get(0).get(i), lstInputs.get(1).get(i));
                        }
                    }
                    claimsRepudiationPageObj.helperfield_save().click();
                    break;
                case "oop request medical report":
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        System.out.println("Inside request access to medical information form capture the following");
                        for (int i = 0; i < lstInputs.get(0).size(); i++) {
                            claimOperationObj.verifycheckhelperfields(lstInputs.get(0).get(i), lstInputs.get(1).get(i));
                        }
                    }
                    claimsRepudiationPageObj.helperfield_save().click();
                    break;
                case "oop request hospital medical report":
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        System.out.println("Inside request access to medical information form capture the following");
                        for (int i = 0; i < lstInputs.get(0).size(); i++) {
                            claimOperationObj.verifycheckhelperfields(lstInputs.get(0).get(i), lstInputs.get(1).get(i));
                        }
                    }
                    claimsRepudiationPageObj.helperfield_save().click();
                    break;
                case "renewal early quote created":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        System.out.println("Event -----------" + strEventType);
//                    quoteDetails_aquariumObj.renewalProcess(strEventType);
                        quoteDetails_aquariumObj.enterRenewalDetails(lstInputs);
                    }
                    break;
                case "repudiation warnings":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                        nextEventPageObj.waitForMoreTime();
                        claimsRepudiationOperationsObj.repudiateClaim(lstInputs);
                        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
 //                       claimsRepudiationPageObj.claimFullRepudiationFreeText1().sendKeys("Claim is being full repudiated");
                        nextEventPageObj.saveBtn().click();
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        System.out.println("Inside repudiate warnings capture the following");
                        claimOperationObj.captureRepudiationWarnings(lstInputs);
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                        nextEventPageObj.btnClick(claimsRepudiationPageObj.save());
//                        claimsRepudiationPageObj.save().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                    } else if (strAction.equalsIgnoreCase("capture the following action")) {
                        System.out.println("Inside repudiate warnings capture the following");
                        claimOperationObj.captureRepudiationWarnings(lstInputs);
//                        nextEventPageObj.switchToDefault();
//                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                        // nextEventPageObj.saveBtn().click();
                        //nextEventPageObj.btnClick(nextEventPageObj.saveBtn());
                        // nextEventPageObj.saveBtn().click();
                    } else if (strAction.equalsIgnoreCase("validate the following data")) {
                        claimOperationObj.verifyImmediateSettlementReason(lstInputs);
                    } else if (strAction.equalsIgnoreCase("validate the following message")) {
                        claimOperationObj.verifyClaimProcessingAdviceMessage(lstInputs);
                    } else if (strAction.equalsIgnoreCase("clear following reason")) {
                        claimsRepudiationOperationsObj.validateClearCloseReason(lstInputs);
                    } else if (strAction.equalsIgnoreCase("capture the following for repudiation outcome")) {
                        claimsRepudiationOperationsObj.validateCRRepudiationMessage(lstInputs);
                    }
                   else if (strAction.equalsIgnoreCase("validate the given data")) {
                        nextEventPageObj.waitForMoreTime();
                        claimsRepudiationOperationsObj.repudiateClaim(lstInputs);
                        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
//                        claimsRepudiationPageObj.claimFullRepudiationFreeText1().sendKeys("Claim is being full repudiated");
                        nextEventPageObj.saveBtn().click();
                    }
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    if (nextEventPageObj.goDisplayed()) {
                        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                    }
                    break;
                case "approve/reject repudiation":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        claimsRepudiationOperationsObj.validateApproveRejectRepudiation(lstInputs);
                    } else if (strAction.equalsIgnoreCase("capture the following")) {

                    }
                    break;
                case "process claim":
                    nextEventPageObj.switchToDefault();
                    nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                    System.out.println("field name --------------------" + strEventType);
                    System.out.println("process claim----------------" + nextEventPageObj.elementDisplayed(nextEventPageObj.nextEventClaims()));
                    //navigationObj.navigateToNextEventType(strEventType);
                    if (nextEventPageObj.elementDisplayed(nextEventPageObj.findElement(By.xpath("//*[@id='ddlEventToAdd']")))) {
                        System.out.println("To Select Value----------------" + strEventType);
                        claimOperationObj.nextEventClaims(strEventType);
                        nextEventPageObj.nextButtonSensitive().click();
                    }
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    }
                case "other insurer - enter details":
                    if (strAction.equalsIgnoreCase("enter the details")) {
                        System.out.println("Inside enter details");
                        for (int row = 1; row < lstInputs.size(); row++) {

                            for (int column = 0; column < lstInputs.get(0).size(); column++) {
                                recoveryOpportunitiesObj.enterOtherInsuranceDetails(lstInputs.get(0).get(column), lstInputs.get(row).get(column));

                            }
                        }
                        //nextEventPageObj.btnClick(evidenceCollationPageObj.claimCalculationSave());
                    } else if (strAction.equalsIgnoreCase("capture the following")) {

                    }
                    break;
                case "third party - enter details":
                    // evidenceCollationPageObj.next();
                    // evidenceCollationPageObj.next().click(); nextEventPageObj.waitForMoreTime(); nextEventPageObj.waitForMoreTime();
                    evidenceCollationPageObj.add_btn();
                    evidenceCollationPageObj.add_btn().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    if (strAction.equalsIgnoreCase("enter third party contacts")) {
                        for (int row = 1; row < lstInputs.size(); row++) {
                            for (int column = 0; column < lstInputs.get(0).size(); column++) {
                                recoveryOpportunitiesObj.enterThirdPartyContactDetails(lstInputs.get(0).get(column), lstInputs.get(row).get(column));

                            }
                        }
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        evidenceCollationPageObj.save1();
                        evidenceCollationPageObj.save1().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                    }
                    break;
                case "claim calculation":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                    } else if (strAction.equalsIgnoreCase("saving the details")) {
                        claimOperationObj.addUserDeductionInClaimCaluculation(lstInputs);
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                        try {
                            evidenceCollationPageObj.claimCalculationSave().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                        } catch (Exception e) {
                            nextEventPageObj.btnClick(evidenceCollationPageObj.claimCalculationSave());
                        }
                    }
                    break;
                case "finalise payment (claim)":
                    paymentfailurecaseid = finalisePaymentPageObj.caseid().getText();
                    System.out.println("case id in claim detais is $$$$$$$$$ %%%%%%%%%%%%%%%%%" + paymentfailurecaseid);
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                    }
                    //nextEventPageObj.btnClick(finalisePaymentPageObj.finalisePaymentNext());
                    break;
                case "claim item":
                    if (strAction.contains("validate the following")) {
                        claimsOperationsObj.validateClaimItemTable(lstInputs);
                    }
                    int rw;
                    List<Integer> hl = new ArrayList<>();
                    hl = claimOperationObj.getRowListFromTable(claimOperationObj.convertList(lstInputs), finalisePaymentPageObj.claimItemsTable("Payment"));
                    for (int a = 0; a < hl.size(); a++) {
                        if (hl.get(a) != 0) {
                            rw = hl.get(a);
                            System.out.println("-----------checkbox---------------" + evidenceCollationPageObj.ClaimPaymentChkBox(finalisePaymentPageObj.claimItemsTable("Payment"), rw).isDisplayed());
                            evidenceCollationPageObj.ClaimPaymentChkBox(finalisePaymentPageObj.claimItemsTable("Payment"), rw).click();
                        }
                    }

                    finalisePaymentPageObj.selectClaimItems().click();
                    finalisePaymentPageObj.finalisePaymentSave().click();
                    break;
                case "add payment comments":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        //finalisePaymentPageObj.finalisePaymentNext().click();
                        Thread.sleep(3000L);
                        // finalisePaymentPageObj.finalisePaymentAddComment().sendKeys("test");
                        //finalisePaymentPageObj.paymetCommentSave().click();
                        claimPaymentOperationsObj.addPaymentComment(lstInputs);  //@US98
                    }

                    break;
                case "enter bank details":
                case "enter cheque details":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        policyOperationsObj.capturePaymentDetails(lstInputs);
                    }
                    break;
                case "collate information":
                    nextEventPageObj.switchToDefault();
                    nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                    navigationObj.navigateToNextEventType(strEventType);
                    nextEventPageObj.waitForMoreTime();
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        claimOperationObj.captureEvidence(lstInputs);
                    }
                    break;
                case "oop amend claim details":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        //this.captureEvidence( lstInputs );
                    }
                    break;
                case "montreal convention - enter details":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                        claimOperationObj.validateMontrealConvention(lstInputs);
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        //this.captureEvidence( lstInputs );
                        claimOperationObj.captureMontrealConvention(lstInputs);
                    }
                    break;
                case "dwp - enter details":
                    if (strAction.equalsIgnoreCase("validate the following") || strAction.equalsIgnoreCase("capture the following")) {
                        claimOperationObj.captureDWPDetails(lstInputs);
                    }
                    break;
                case "oop approve/reject":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        //this.captureEvidence( lstInputs );
                    }
                    break;
                case "oop raise goodwill/compensation payment":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        //this.captureEvidence( lstInputs );
                    }
                    break;
                case "validation of bank details required":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                        finalisePaymentPageObj.validateBankAcctDetailsBtn();
                        finalisePaymentPageObj.validateBankAcctDetailsBtn().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        finalisePaymentPageObj.bankAcctValidationMessage();
                        finalisePaymentPageObj.bankAcctValidationMessage().isDisplayed();
                        finalisePaymentPageObj.save();
                        finalisePaymentPageObj.save().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        finalisePaymentPageObj.finalisePaymentAddComment().sendKeys("test");
                        finalisePaymentPageObj.paymetCommentSave().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        //this.captureEvidence( lstInputs );
                    }
                    break;
                case "oop capture incidents":
                    claimOperationObj.captureIncidents(lstInputs, false);
                    break;
                case "oop recovery percentage change":
                case "oop recovery - change percentage":
                case "oop recovery - update reserve":
                    if (strAction.equalsIgnoreCase("change the amount")) {
                        System.out.println("Change the Amount");
                        percentage_before = recoveryOpportunitiesPageObj.percentage().getAttribute("value");
                        System.out.println("percentage_before*********"+percentage_before);
                        amount_before = recoveryOpportunitiesPageObj.amount().getAttribute("value");
                        System.out.println("amount_before*********"+amount_before);
                        for (int row = 1; row < lstInputs.size(); row++) {
                            for (int column = 0; column < lstInputs.get(0).size(); column++) {
                                nextEventPageObj.waitForMoreTime();
                                nextEventPageObj.waitForMoreTime();
                                nextEventPageObj.waitForMoreTime();
                                nextEventPageObj.waitForMoreTime();
                                recoveryOpportunitiesObj.enterAmount(lstInputs.get(0).get(column), lstInputs.get(row).get(column));

                            }
                        }
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        evidenceCollationPageObj.contactDetails_Save();
                        evidenceCollationPageObj.contactDetails_Save().click();

                        System.out.println("******Scheme summary Page **********");
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.waitForMoreTime();
                        financialPageObj.estRecoverAmt();
                        Assert.assertTrue(!(amount_before.equalsIgnoreCase(financialPageObj.estRecoverAmt().getText())));
                        System.out.println("Validated Estimation recovery Amount in the scheme summary page");
                    } else if (strAction.equalsIgnoreCase("validate the percentage")) {
                        System.out.println("Actual value:" + recoveryOpportunitiesPageObj.percentage().getAttribute("value"));
                        System.out.println("Before value:" + percentage_before);
                        Assert.assertTrue(!(recoveryOpportunitiesPageObj.percentage().getAttribute("value").equalsIgnoreCase(percentage_before)));
                        evidenceCollationPageObj.contactDetails_Cancel();
                        evidenceCollationPageObj.contactDetails_Cancel().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                    } else if (strAction.equalsIgnoreCase("change the percentage")) {
                        System.out.println("Change the Percentage");
                        String amount_before = recoveryOpportunitiesPageObj.amount().getAttribute("value");
                        System.out.println("Amount Before" + amount_before);
                        //String percentage_before=recoveryOpportunitiesPageObj.percentage().getText() ;
                        for (int row = 1; row < lstInputs.size(); row++) {
                            for (int column = 0; column < lstInputs.get(0).size(); column++) {
                                recoveryOpportunitiesObj.enterPercentage(lstInputs.get(0).get(column), lstInputs.get(row).get(column));
                            }
                        }
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        recoveryOpportunitiesPageObj.amount().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        evidenceCollationPageObj.contactDetails_Save();
                        evidenceCollationPageObj.contactDetails_Save().click();
                        System.out.println("******Scheme summary Page **********");
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.waitForMoreTime();
                        financialPageObj.estRecoverAmt();
                        Assert.assertTrue(!(amount_before.equalsIgnoreCase(financialPageObj.estRecoverAmt().getText())));
                        System.out.println("Validated Estimation recovery Amount in the scheme summary page");
                    } else if (strAction.equalsIgnoreCase("validate the amount")) {
                        System.out.println("Actual value:" + recoveryOpportunitiesPageObj.amount().getAttribute("value"));
                        System.out.println("Before value:" + amount_before);
                        Assert.assertTrue(!(recoveryOpportunitiesPageObj.amount().getAttribute("value").equalsIgnoreCase(amount_before)));
                        evidenceCollationPageObj.contactDetails_Cancel();
                        evidenceCollationPageObj.contactDetails_Cancel().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                    }
                    break;
                case "oop recovery - manage":
                case "oop recovery management":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        System.out.println("Inside OOP recovery Management capture the following");
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                        for (int row = 1; row < lstInputs.size(); row++) {
                            for (int column = 0; column < lstInputs.get(0).size(); column++) {
                                switch (lstInputs.get(0).get(column).toLowerCase()) {
                                    case "new action":
                                    case "status":
                                    case "amount":
                                        recoveryOpportunitiesObj.selectStatus(lstInputs.get(0).get(column), lstInputs.get(row).get(column));
                                        System.out.println("clicking Save button");
                                        nextEventPageObj.waitForMoreTime();
                                        nextEventPageObj.waitForMoreTime();
//                                        nextEventPageObj.switchToDefault();
//                                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
//                                        nextEventPageObj.btnClick(claimSummaryPageObj.btnSaveRecovery());
                                        nextEventPageObj.waitForMoreTime();
                                        nextEventPageObj.waitForMoreTime();
                                        System.out.println("clicked Save button");
                                        break;
                                    case "workflow task":
                                        recoveryOpportunitiesPageObj.workflowTaskInput().click();
                                        recoveryOpportunitiesPageObj.workflowTaskOptions(lstInputs.get(row).get(column)).click();
                                        break;
                                }
                            }
                        }
                        evidenceCollationPageObj.contactDetails_Save();
                        evidenceCollationPageObj.contactDetails_Save().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                    }
                    break;
                case "oop refer claim for customer validation":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    }
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        System.out.println("Inside capture the following- customer");
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        finalisePaymentPageObj.referCustomerValidation_Comments().sendKeys("test");
                        finalisePaymentPageObj.referCustomerValidation_Finish().click();
                    }
                    break;
                case "confirmation of cover letter":
                case "letter (oop) - confirmation of cover":
                case "letter (oop) - confirmation of cover *free text*":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    }
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        System.out.println("Inside capture the following- customer");
                        for (int i = 1; i < lstInputs.size(); i++) {
                            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                                policyOperationsObj.enterData(lstInputs.get(0).get(j), lstInputs.get(i).get(j));
                            }
                        }
                        policyDataFieldsPageObj.policySave().click();
                    }
                    if (strAction.equalsIgnoreCase("enter the following")) {
                        System.out.println("Inside enter the following- customer");
                        for (int i = 1; i < lstInputs.size(); i++) {
                            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                                policyOperationsObj.enterDeceasedDetails(lstInputs.get(0).get(j), lstInputs.get(i).get(j));
                            }
                        }
                    }
//                    nextEventPageObj.createAndSendEmail().click();
                    break;
                case "oop cancel upgrade":
                case "oop cancel upgrade backdated":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    }
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                        for (int i = 1; i < lstInputs.size(); i++) {
                            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                                policyOperationsObj.enterCancellationData(lstInputs.get(0).get(j), lstInputs.get(i).get(j));
                            }
                        }
                    }
                    break;
                case "confirmation of cover email":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    }
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        System.out.println("Inside capture the following- customer");
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                        System.out.println("to verify the event type" + strEventType);
                        new Select(policyDataFieldsPageObj.eventLetter()).selectByVisibleText(strEventType);
                        nextEventPageObj.waitForPageLoad();
                        policyDataFieldsPageObj.getTemplatebtn().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        policyDataFieldsPageObj.btnCreateEventSendEmail().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                    }
                    break;
                case "confirmation of cover sms":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    }
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        System.out.println("Inside capture the following- customer");
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                        System.out.println("to verify the event type in sms" + strEventType);
//                        new Select(policyDataFieldsPageObj.eventLetter()).selectByVisibleText(strEventType);
//                        nextEventPageObj.waitForPageLoad();
//                        policyDataFieldsPageObj.getTemplatebtn().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        policyDataFieldsPageObj.btnCreateEventSendEmail().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                    }
                    break;
                case "testing - bacs failure - add failure":
                case "enter amended dd account details":
                case "enter new dd account details":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        //this.captureEvidence( lstInputs );
                        claimPaymentOperationsObj.captureBacsFailureDetails(lstInputs);
                    }
                    break;
                case "tma advice required":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        claimPaymentOperationsObj.enterAdviceRequiredDetails(lstInputs);
                    }
                    break;
                case "renewal create quote":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        System.out.println("Event -----------" + strEventType);
//                    quoteDetails_aquariumObj.renewalProcess(strEventType);
                        quoteDetails_aquariumObj.enterRenewalDetails(lstInputs);
                    }
                    break;
                case "oop flag open complaint":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        claimPaymentOperationsObj.enterCMSReferenceNumber(lstInputs);
                    }
                    break;
                case "endorsement update":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        policyOperationsObj.captureEndrosementDetail(lstInputs);
                    }
                    break;
                case "oop missing person":
                case "missing person":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        // policyOperationsObj.captureDLG();
                        nextEventPageObj.switchToDefault();
                        claimOperationObj.clickingUnderNextEventsAndButtons("go");
                        policyOperationsObj.captureMissingPersonDetails(lstInputs);
                    }
                    break;
                case "notify foreign embassy":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        policyDataFieldsPageObj.createEventAndSendEmail().click();
                        nextEventPageObj.waitForMoreTime();
                    }
                    break;
                case "oop missing person found":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        policyOperationsObj.captureMissingPersonFoundDetails(lstInputs);
                    }
                    break;
                case "portal welcome email":
                    System.out.println("Inside customer welcome mail event..... ");
                    nextEventPageObj.switchToDefault();
                    nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                    policyDataFieldsPageObj.btnCreateEventSendEmail().click();
                    Thread.sleep(3500L);
                    break;
                case "oop contact customer":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                        System.out.println("Validate the following");
                        claimOperationObj.validateClaimHandlerDetails(lstInputs);
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        System.out.println("Capture the following");
                        claimOperationObj.enterClaimHandlerDetails(lstInputs);
                    }
                    break;
                case "email - (tim) additional information required":
                case "email - (tim) additional information required (S)":
                case "letter - (tim) additional information required":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                        claimHandlingOperationsObj.verifySignatureInEmail(lstInputs, strEventType);
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                    }
                    break;
                case "oop add healix nurse note":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        tmaDetailsObj.addHealixNotes(lstInputs);
                    }
                    break;
                case "oop cap claim costs":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        tmaDetailsObj.capturingCapCosts(lstInputs);
                    }
                    break;
                case "oop mark claim as guaranteed":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else {
                        if (strAction.equalsIgnoreCase("validate and capture the following")) {
                            tmaDetailsObj.validateAndCaptureReason(lstInputs);
                        }
                    }
                    break;
                case "oop chase gp by phone":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else {
                        if (strAction.equalsIgnoreCase("capture the following")) {
                            nextEventPageObj.switchToDefault();
                            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                            tmaDetailsPageObj.btnSave().click();
                        }
                    }
                    break;
                case "rush payment request":
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        supplierOperationsObj.enterPaymentDetails(lstInputs);
                    }
                    break;
                case "tma nurse notification | email":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        tmaDetailsObj.addNurseNotification(lstInputs);
                    }
                    break;
                case "oop healix review of provider medical report":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        tmaDetailsObj.addHealixReviewOfProviderMedicalReport(lstInputs);
                        policyDataFieldsPageObj.policySave().click();
                    }
                    break;
                case "oop email healix":
                    if (strAction.equalsIgnoreCase("validate the following")) {
//                        nextEventPageObj.switchToDefault();
//                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        Thread.sleep(10000L);
//                        nextEventPageObj.switchToDefault();
//                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                        // nextEventPageObj.waitForPageLoad();
                        System.out.println("Inside Email Healix");
                        nextEventPageObj.waitForPageLoad();
                        System.out.println("Clicking the button");
                        nextEventPageObj.btnClick(tmaDetailsPageObj.btnCreateSendEmail());
                        System.out.println("Clicked the button");
                        nextEventPageObj.waitForPageLoad();
                        Thread.sleep(10000L);
                    }
                    break;
                case "oop healix first medical meport":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        nextEventPageObj.waitForPageLoad();
                        tmaDetailsObj.addFirstMedicalReportDetails(lstInputs);
                    }
                    break;
                case "oop healix critical care report":
                    if (strAction.equalsIgnoreCase("validate the following")) {
                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        nextEventPageObj.waitForPageLoad();
                        tmaDetailsObj.addFirstMedicalReportDetails(lstInputs);
                    }
                    break;
                case "oop resend hospital guarantee":
                    if (strAction.equalsIgnoreCase("validate the following")) {

                    } else if (strAction.equalsIgnoreCase("capture the following")) {
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                        tmaDetailsPageObj.btnCreateEventAndSendEmail().click();
                    }
                    break;
                case "TMA advice of evidence":
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.btnClick(nextEventPageObj.go());
                        claimOperationObj.captureEvidence(lstInputs);
                    } else {
                        System.out.println("validate TMA advice");
                    }
                    break;
                case "oop process mtc refund request":
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                        for (int i = 1; i < lstInputs.size(); i++) {
                            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                                policyOperationsObj.authorisationMTCRefundRequest(lstInputs.get(0).get(j), lstInputs.get(i).get(j));
                            }
                        }
                        policyDataFieldsPageObj.policySave().click();
                    }
                case "Contact Customer to Confirm Reqs & Set Expectation":
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                        nextEventPageObj.btnClick(claimsRepudiationPageObj.nextButton());
                    }
                case "Unescorted Repatriation Process Flow":
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                        nextEventPageObj.btnClick(claimsRepudiationPageObj.nextButton());
                    }
                case "Clearance Not Required":
                    if (strAction.equalsIgnoreCase("capture the following")) {
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                        nextEventPageObj.btnClick( claimsRepudiationPageObj.nextButton() );
                    }
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Exiting func iNavigateToAndCaptureTheFollowing- " + " strEventType= " + strEventType + " strAction= " + strAction);
    }

    @And("^I should be able to add and amend '(.+)'$")
    public void iShouldBeAbleToAddOrAmendDetails(List<List<String>> lstInputs) {
    }

    @And("^Add the '(.+)' as supplier with a Supplier type of '(.+)' ")
    public void addTheSupplierAndSupplierType(List<List<String>> lstInputs) {
    }

    @And("^I should be unable to find the case ID$")
    public void IshouldbeUnabletofindtheclaimID() {
        System.out.println("Case ID checked in Manage workflow event" + caseID);
        WebElement caseIDElement = manageWorkflowTaskPageObj.caseIdInWorkflow(caseID);
        Assert.assertTrue("-------Case id is not displayed------" + caseID, !caseIDElement.isDisplayed());
    }

    @And("^I should be able to save '(.+)' with '(.+)'$")
    public void saveThePerilQuestionScreen(String strEventType, String strAction, List<List<String>> listInput) throws InterruptedException {
        Thread.sleep(1000L);
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.switchToFrameById(perilQuestionsPageObj.frame());
        nextEventPageObj.waitForPageLoad();
        for (int i = 1; i < listInput.size(); i++) {
            for (int j = 0; j < listInput.get(i).size(); j++) {
                switch (listInput.get(0).get(j).toLowerCase()) {
                    case "questions":
                        caseID = finalisePaymentPageObj.caseid().getText();
                        System.out.println("case id retrieved in the peril questions" + caseID);
                        break;
                }
            }
        }
        if (strEventType.equalsIgnoreCase("peril question save") | strEventType.equalsIgnoreCase("peril questions save")) {
            System.out.println("peril-----------save----" + strEventType);
            navigationObj.navigateToNextEventType("Claim Specific Questions");
            claimOperationObj.retrieveLeadID();
            perilQuestionsPageObj.btnClick(perilQuestionsPageObj.perilQuestionSaveBtn());
        } else if (strEventType.equalsIgnoreCase("peril question cancel") | strEventType.equalsIgnoreCase("peril questions cancel")) {
            System.out.println("peril------------cancel---" + strEventType);
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            perilQuestionsPageObj.btnClick(perilQuestionsPageObj.perilQuestionCancelBtn());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
    }

    @And("^I should be able to click on '(.+)' claim$")
    public void I_Should_be_able_to_click_on_claim(String ClaimNumber) {
        claimOperationObj.reopenAClosedClaim(ClaimNumber);
    }

    @And("^verify the peril questions and answers in AQ$")
    public void verifyThePerilQuestionsAndAnswersInAQ(List<List<String>> questionID) {
        claimsOperationsObj.getquestionandAnswer(questionID);
    }

    @And("^I should be able to click on '(.+)' button$")
    public void toClickInGoUnderNextEvent(String btnType) {
        claimOperationObj.clickingUnderNextEventsAndButtons(btnType);
    }

    @And("^I should be able to get the case id from next action$")
    public void Ishouldbeabletogetthecaseidfromnextaction() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        caseID = policyDataFieldsPageObj.caseid().getText();
        System.out.println("caseIDcaseIDcaseIDcaseIDcaseID-----------------" + caseID);
        nextEventPageObj.switchToDefault();
    }

    @And("^I should add comments in '(.+)'$")
    public void iShouldAddCommentsinAarrangeTransfers(String transfer) {
        if (transfer.equalsIgnoreCase("arrange transfers")) {
            perilQuestionsPageObj.enterComments().sendKeys("Healixtransfer@healix.com");
            policyDataFieldsPageObj.btnCreateEventSendEmail().click();
        } else {
            policyDataFieldsPageObj.btnCreateEventSendEmail().click();
        }
    }

    @And("^I should be able to '(.+)' with Claim Final settlement$")
    public void iShouldBeAbleToProceedWithClaimFinalSettlement(String btnType) throws Throwable {
        claimOperationObj.clickingUnderNextEventsAndButtons(btnType);
    }

    @And("^I should be able to view amended '(.+)' details$")
    public void iShouldAbleToViewAmendedDetails(String tabToView, List<List<String>> lstInput) {
        nextEventPageObj.switchToLastOpenWindow();
        System.out.println("inside amended value");
        switch (tabToView.toLowerCase()) {
            case "financial":
                claimOperationObj.verifyFinancialTabData(tabToView, lstInput);
                break;
            case "financial table":
                claimOperationObj.navigateToFinancial();
                claimOperationObj.validateClaimAmendmentsFootPrint(lstInput);
                break;
            case "financial payment table":
                claimOperationObj.validatePaymentTableData(lstInput);
                break;
        }
    }

    @And("^Validate '(.+)' value in the claim table$")
    public void validateColumnInClaimTable(String columnToValidate, List<List<String>> criteria) {
        claimOperationObj.claimID = nextEventPageObj.firstClaimID().getText();
        System.out.println("claimID-------------------------" + claimOperationObj.claimID);
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        try {
            Thread.sleep(30000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        claimOperationObj.validateColumnValues(columnToValidate, criteria);
        quoteAndBuyOperationsObj.retrieveRandomCustomerName();
    }

    @And("^I should be able to add another '(.+)' with following details$")
    public void iShouldBeAbleToAddAnotherClaim(String claim, List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        commonPageObj.switchToFrameById(commonPageObj.fancyFrame());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(perilsAndCostsPageObj.addPeril());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.validateClaimCause(claim, "Save", parameters);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.addAnotherPersonClaimCost();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(perilsAndCostsPageObj.addAnotherClaimItem());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.validateClaimCostType(claim, parameters);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        perilsAndCostsPageObj.saveClaimItem().click();
        this.sysDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString();
        System.out.println("System date ------------------------" + this.sysDate);
        nextEventPageObj.waitForMoreTime();
    }

    @And("^I can capture 'Date Of Loss' and 'Country of Loss' with the details below$")
    public void iCanCaptureDateOfLossAndCountryOfLossWithTheDetailsBelow(List<List<String>> lstInputs) throws Throwable {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        commonPageObj.switchToFrameById(commonPageObj.fancyFrame());
        for (int row = 1; row < lstInputs.size(); row++) {
            for (int column = 0; column < lstInputs.get(0).size(); column++) {
                claimOperationObj.validateClaimCauseAndComments(lstInputs.get(0).get(column), lstInputs.get(row).get(column));
            }
        }
    }

    @And("^I should be able to verify the total reserve amount$")
    public void iShouldBeAbleToVerifyReserveAmount(List<List<String>> lstInputs) {
        String reserveAmount = financialPageObj.totalAmountPaid().getAttribute("value");
        System.out.println("reserve amount ----------------------------" + reserveAmount);
        Assert.assertTrue(reserveAmount.equalsIgnoreCase(lstInputs.get(1).get(0)));
    }

    @And("^I should be able to '(.+)'$")
    public void iShouldBeAbleToValidateErrorMessage(String errorMessage, List<List<String>> lstInput) {
        if (lstInput.get(1).get(0).equalsIgnoreCase("Only members of the counter fraud team can unlock a case which is on hold")) {
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(claimsRepudiationPageObj.btnOK()))) {
            try {
                Assert.assertTrue(claimsRepudiationPageObj.errorMessage(lstInput.get(1).get(0)).isDisplayed());//getText().equalsIgnoreCase(lstInput.get(1).get(0).trim()));
                System.out.println("Error message Validation -----------------------" + claimsRepudiationPageObj.errorMessage(lstInput.get(1).get(0)).getText());
                claimsRepudiationPageObj.btnOK_FraudReferral().click();
                nextEventPageObj.switchToDefault();
            } catch (Exception e) {
                claimsRepudiationPageObj.btnOK_FraudReferral().click();
                nextEventPageObj.switchToDefault();
            }
        }
        if (lstInput.get(1).get(0).equalsIgnoreCase("You have selected trips that have start dates before your policy start date.")) {
            Assert.assertTrue(claimsRepudiationPageObj.errorMessage(lstInput.get(1).get(0)).isDisplayed());
            Assert.assertTrue(claimsRepudiationPageObj.errorMessage(lstInput.get(1).get(1)).isDisplayed());
            claimsRepudiationPageObj.weddingbtnOK().click();
        }
    }

    @And("I should be able to '(.+)' the payment request$")
    public void iShouldBeAbleYoApproveRejectPayment(String input) {
        if (input.equalsIgnoreCase("approve")) {
            paymentAwaitingApprovalPageObj.approveRadioBtn().click();
            paymentAwaitingApprovalPageObj.saveBtn().click();
        } else {
            paymentAwaitingApprovalPageObj.rejectRadioBtn().click();
            paymentAwaitingApprovalPageObj.saveBtn().click();
        }
    }

    @And("I should navigate to '(.+)' screen and '(.+)'$")
    public void iShouldBeAbleToNavigateToTheScreenAndSelectOptions(String screenToNavigate, String optionToSelect) throws InterruptedException {
        this.toClickInGoUnderNextEvent("Out Of Process event");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        navigationObj.navigateToNextEventType(optionToSelect.split("#")[1]);
        if ((screenToNavigate.equalsIgnoreCase("Cheque Payment") || screenToNavigate.equalsIgnoreCase("BACS Payment"))
                && (optionToSelect.split("#")[0].equalsIgnoreCase("select stop cheque") || optionToSelect.split("#")[0].equalsIgnoreCase("select stop BACS"))) {
            System.out.println("inside if for stop cheque or BACS");
            chequePaymentPageObj.paymentStopCheckBox().click();
            chequePaymentPageObj.paymentStopSaveBtn().click();
        } else if ((screenToNavigate.equalsIgnoreCase("Cheque Payment") || screenToNavigate.equalsIgnoreCase("BACS Payment"))
                && (optionToSelect.equalsIgnoreCase("verify stopped cheque") || optionToSelect.equalsIgnoreCase("Verify Stopped BACS"))) {
            System.out.println("MEssage in cheque payment -----------------" + chequePaymentPageObj.messageDisplayedInChequePayment().getText());
            Assert.assertTrue("Stopped cheque should display the text ------" + chequePaymentPageObj.messageDisplayedInChequePayment().getText(), chequePaymentPageObj.messageDisplayedInChequePayment().isDisplayed());
        }
    }

    @And("^Details of '(.+)' has been displayed to the user$")
    public void Details_of_client_record_has_been_displayed_to_the_user(String strExpBeh) {
        System.out.println("inside view customwer-----------");
        perfSerachObj.retreiveFirstClientRecord();
        claimOperationObj.navigateToClaimViewFromPolicyView_one();
    }

    @Then("^in policy information screen i should be able to see the following four fields$")
    public void in_policy_information_screen_i_should_be_able_to_see_the_following_four_fields
            (List<List<String>> listInputs) {
        claimOperationObj.verifyClaimTable();
        Assert.assertTrue(fullEventHistoryPageObj.perils().isDisplayed());
        System.out.println("################################" + fullEventHistoryPageObj.perils().isDisplayed());
        Assert.assertTrue(fullEventHistoryPageObj.dol().isDisplayed());
        Assert.assertTrue(fullEventHistoryPageObj.paid().isDisplayed());
        Assert.assertTrue(fullEventHistoryPageObj.statuss().isDisplayed());
    }

    @And("^I should be able to view the following message$")
    public void I_should_be_able_to_view_the_following_message(List<List<String>> parameters) {
        String message = fullEventHistoryPageObj.MESSAGE().getText();
        System.out.println("###########mess####################" + message);
        Assert.assertTrue(message.equalsIgnoreCase(parameters.get(1).get(0)));
        Assert.assertTrue(fullEventHistoryPageObj.MESSAGE().isDisplayed());
        System.out.println("################################" + fullEventHistoryPageObj.MESSAGE().isDisplayed() + "###################");
    }

    @And("^Verify Highvalue Reserve Email notification event is generated in the full event history page$")
    public void verifyHighvalueReserverNotificationsent() throws Throwable {
        System.out.println("Verifying High Value Reserve Email Notification (SYSTEM)");
        try {
            fullEventHistoryPageObj.highvalueReserveEmailevent();
            Assert.assertTrue(fullEventHistoryPageObj.highvalueReserveEmailevent().isDisplayed());
        } catch (Exception e) {
        }
    }

    @And("^Verify Highvalue Reserve Event is generated in the full event history page$")
    public void verifyHighvalueReserveEvent() {
        try {
            System.out.println("Verifying High value reserve event");
            fullEventHistoryPageObj.highvalueReserveevent();
            Assert.assertTrue(fullEventHistoryPageObj.highvalueReserveevent().isDisplayed());
            nextEventPageObj.btnClick(fullEventHistoryPageObj.closeWindow());
            nextEventPageObj.switchToLastOpenWindow();
        } catch (Exception e) {
            nextEventPageObj.btnClick(fullEventHistoryPageObj.closeWindow());
            nextEventPageObj.switchToLastOpenWindow();
        }
    }

    @And("^I should allow to close any outstanding events$")
    public void I_should_allow_to_close_any_outstanding_events() {
        Assert.assertTrue(claimSummaryPageObj.btnSelectionOfOOPEvent().isDisplayed());
    }

    @And("^I should allow to re-open the closed Claim$")
    public void I_should_allow_to_re_open_the_closed_Claim() {
        claimOperationObj.reOpenClosedClaim();
    }

    @And("^I should allow to '(.+)' in the reopened claim$")
    public void I_should_allow_to_OOP_Amend_Claim_Details_in_the_reopened_claim(String eventType, List<List<String>> parameters) {
        nextEventPageObj.btnClick(nextEventPageObj.go());
        claimOperationObj.amendClaimDetailsInTheReopenedClaim(eventType, parameters);
    }

    @And("^I should not allow to re-open the claim item$")
    public void I_should_allow_to_re_open_the_claim_item() {
        claimOperationObj.notAllowedToReopenLineItem();
    }

    @And("^I should be able to add another '(.+)' in the '(.+)' event with following details$")
    public void iShouldBeAbleToAddAnotherClaimInAmendClaimDeatils(String claim, String
            eventType, List<List<String>> parameters) {
        nextEventPageObj.btnClick(nextEventPageObj.go());
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        navigationObj.navigateToNextEventType(eventType);
        commonPageObj.switchToFrameById(commonPageObj.fancyFrame());
        nextEventPageObj.btnClick(perilsAndCostsPageObj.addPeril());
        claimOperationObj.validateClaimCause(claim, "Save", parameters);
        claimOperationObj.addPersonClaimCost();
        nextEventPageObj.btnClick(perilsAndCostsPageObj.addClaimItem());
        claimOperationObj.validateClaimCostType(claim, parameters);
        perilsAndCostsPageObj.saveClaimItem().click();
        this.sysDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString();
        System.out.println("System date ------------------------" + this.sysDate);
    }

    @And("^I should allow to retrieve the table row ID$")
    public void I_should_allow_to_enable_payment_failure_flag() {
        claimOperationObj.selectFirstClaimInClaimTable();
        claimOperationObj.retrieveTableRowID();
    }

    @And("^I should allow to enter the below mandatory fields for the payment failure event$")
    public void I_should_allow_to_enter_the_below_mandatory_fields_for_the_payment_failure_event(List<List<String>> parameters) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                claimOperationObj.enterMandatoryDataForPaymentFailureEvent(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
    }

    @And("^validate the payment failure status in the claim table$")
    public void validate_the_payment_failure_status_in_the_claim_table(List<List<String>> parameters) throws Throwable {
        nextEventPageObj.switchToDefault();
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                claimOperationObj.validateEventAndClaimStatus(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    @Then("^I should be able to add '(.+)'$")
    public void Ishouldbeabletoaddcomment(String strResult) {
        basicClaimDetObj.Referralcomment().sendKeys("Need to be reviewd by TL");
        nextEventPageObj.saveBtn();
        nextEventPageObj.saveBtn().click();
    }

    @And("^I should be able to click on '(.+)'$")
    public void Abletoclickongetnexttaskandviewreferredclaim(String strResult) {
        claimSummaryPageObj.getNextTask().click();
    }

    @And("^I click on get next Task for navigating to next caseID$")
    public void I_click_on_get_next_Task_for_navigating_to_next_caseID() {
        String[] caseIDOnly = nextEventPageObj.validateClaimID().getText().split(" ");
        while (!(caseID.equalsIgnoreCase(caseIDOnly[0]))) {
            if (nextEventPageObj.elementDisplayed(claimSummaryPageObj.escalateTask())) {
                System.out.println("Inside Escalate Task");
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimSummaryPageObj.escalateTask().click();
                new Select(claimSummaryPageObj.escalateReasonDropDown()).selectByVisibleText(escalationReason);
                claimSummaryPageObj.escalateReasonOkbtn().click();
            }
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    @And("^I should be able to find the case ID$")
    public void IshouldbeabletofindtheclaimID() {
        System.out.println("Case ID checked in Manage workflow event" + caseID);
        WebElement caseIDElement = manageWorkflowTaskPageObj.caseIdInWorkflow(caseID);
        Assert.assertTrue("-------Case id is displayed------" + caseID, caseIDElement.isDisplayed());
    }

    @And("^I should be able to find the case ID for bar block$")
    public void IshouldbeabletofindtheclaimIDforbarblock() {
        System.out.println("Case ID checked in Manage workflow event" + clientOperationsObj.caseIdForPolicy);
        WebElement caseIDElement = manageWorkflowTaskPageObj.caseIdInWorkflow(clientOperationsObj.caseIdForPolicy);
        Assert.assertTrue("-------Case id is displayed------" + clientOperationsObj.caseIdForPolicy, caseIDElement.isDisplayed());
    }

    @And("^I should be able to find the case ID with allocated experienced advisor$")
    public void I_should_be_able_to_find_the_case_ID_with_allocated_experienced_advisor() {
        System.out.println("Case ID checking in Manage workflow event with alloctaed experienced advisor" + caseID);
        WebElement caseIDElement = manageWorkflowTaskPageObj.caseIdInWorkflow(caseID);
        Assert.assertTrue("-------Case id is displayed------" + caseID, caseIDElement.isDisplayed());
        navigationObj.caseIDVerificationInWorkflow(caseID);
        navigationObj.claimIDVerificationInPolicyPage(claimID);
        System.out.println("---------experienced advisor is verified----------");
    }

    @And("^validate the caseID$")
    public void validatethecaseID() {
        System.out.println("Validating case ID.........." + caseID);
        claimsOperationsObj.validateclaimdetailsinNextTask(caseID);
    }

    @And("^validate the claim '(.+)' is allocated$")
    public void validate_the_claim_is_allocated(String customer) {
        claimOperationObj.validateClaimAllocation(customer);
    }

    @And("^the referred claim should be able to view by the experienced supervisor$")
    public void the_referred_claim_should_be_able_to_view_by_the_experienced_supervisor() {
        System.out.println("claim ID in validation" + claimID);
        navigationObj.navigateToClaimTasks(claimID);
        navigationObj.reassignSecondTimeTheClaimReferral(claimID);
        System.out.println("Assigning the claimID---------" + claimID);
        navigationObj.verifyReAssigneeName(claimID);
    }

    @And("^I should be able to view the referred claim$")
    public void I_should_be_able_to_view_the_referred_claim() {
        System.out.println("Verifying the claim ID");
        System.out.println("claim ID in validation" + claimID);
        System.out.println("claim ID from thogata" + nextEventPageObj.firstClaimID().getText());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(nextEventPageObj.go());
        nextEventPageObj.waitForMoreTime();
        perilQuestionsPageObj.switchToFrameById(perilQuestionsPageObj.frame());
        evidenceCollationPageObj.othrInsSave().click();
        nextEventPageObj.waitForMoreTime();
    }

    @Then("^I should be able to allocate the claim to a more experienced advisor$")
    public void I_should_be_able_to_allocate_the_claim_to_a_more_experienced_advisor() {
        System.out.println("claim ID in validation" + claimID);
        navigationObj.navigateToClaimTasks(claimID);
        navigationObj.reassignTheClaimReferral(claimID);
        System.out.println("Assigning the claimID---------" + claimID);
        navigationObj.verifyReAssigneeName(claimID);
    }

    @And("^I should be able to view the claim with allocated experienced advisor$")
    public void I_should_be_able_to_view_the_claim_with_allocated_experienced_advisor() {
        navigationObj.claimIDVerificationInPolicyPage(claimID);
        System.out.println("---------experienced advisor is verified----------");
    }

    @And("^validate the claim '(.+)' is not allocated and validate the message '(.+)'$")
    public void validate_the_claim_Green_is_not_allocated_and_validate_the_message_(String claim, String warning) {
        claimOperationObj.validateClaimNotAllocated(claim, warning);
    }

    @And("^I should be able to create another '(.+)'$")
    public void I_should_be_able_to_create_another_claim(String claim, List<List<String>> parameters) throws Throwable {
        accountInformationPageObj.btnClick(accountInformationPageObj.moreLink());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        List<List<String>> newParameters = commandsObj.parameterMappingNew(1, parameters, LoadTTPropertiesFiles.CLAIMDETAILS_PROP);
        nextEventPageObj.btnClick(claimSummaryPageObj.newClaim());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Thread.sleep(10000);
        claimID2 = nextEventPageObj.firstClaimID().getText();
        System.out.println("Claim ID2" + claimID2);
        nextEventPageObj.btnClick(nextEventPageObj.go()); // get new claim id after this step
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.createEditClaims(claim, newParameters);
        basicClaimDetObj.save().click();
        commonPageObj.switchToFrameById(commonPageObj.fancyFrame());
        perilsAndCostsPageObj.claimLossDate().clear();
        perilsAndCostsPageObj.claimLossDate().sendKeys("23/12/2016");
        perilsAndCostsPageObj.claimLossDate().sendKeys(Keys.TAB);
        nextEventPageObj.btnClick(perilsAndCostsPageObj.addPeril());
        claimOperationObj.validateClaimCause(claim, "Save", newParameters);
        claimOperationObj.addPersonClaimCost();
        nextEventPageObj.btnClick(perilsAndCostsPageObj.addClaimItem());
        claimOperationObj.validateClaimCostType(claim, newParameters);
        perilsAndCostsPageObj.saveClaimItem().click();
        this.sysDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString();
        System.out.println("System date ------------------------" + this.sysDate);
        Thread.sleep(10000);
    }

    @And("^I should be able to view the referred claim in order$")
    public void I_should_be_able_to_view_the_referred_claim_in_order() {
        if ((schemeSummaryPageObj.claimId1InPolicyView(claimID).getText().equalsIgnoreCase(claimID)) && (schemeSummaryPageObj.claimId1InPolicyView(claimID2).getText().equalsIgnoreCase(claimID2))) {
            System.out.println("Verifying order of entry");
            schemeSummaryPageObj.claimId1InPolicyView(claimID).isDisplayed();
            schemeSummaryPageObj.claimId1InPolicyView(claimID2).isDisplayed();
        }
    }

    @And("^I should be able to view the oldest referral date first$")
    public void I_should_be_able_to_view_the_oldest_referral_date_first() {
        schemeSummaryPageObj.claimId1InPolicyView(claimID).isDisplayed();
        schemeSummaryPageObj.claimId1Click(claimID).click();
        String Lead = schemeSummaryPageObj.claimLeadID1().getText();
        System.out.println("Lead ID------------" + Lead);
        claimSummaryPageObj.close().click();
        Assert.assertTrue(schemeSummaryPageObj.claimLeadIDInNextTask().getText().equalsIgnoreCase(Lead));
        System.out.println("Old is verified------------");
        if (nextEventPageObj.elementDisplayed(claimSummaryPageObj.escalateTask())) {
            System.out.println("Inside Escalate Task");
            claimSummaryPageObj.escalateTask().click();
            new Select(claimSummaryPageObj.escalateReasonDropDown()).selectByVisibleText(escalationReason);
            claimSummaryPageObj.escalateReasonOkbtn().click();
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        schemeSummaryPageObj.claimId2InPolicyView(claimID2).isDisplayed();
        nextEventPageObj.switchToDefault();
        System.out.println("ClaimID 2---------" + claimID2);
        try {
            schemeSummaryPageObj.btnClick(schemeSummaryPageObj.claimId2Click(claimID2));
        } catch (Exception e) {
            schemeSummaryPageObj.btnClick(schemeSummaryPageObj.claimId2Click(claimID2));
        }
        System.out.println("ClaimID 2---------" + claimID2);
        String Lead2 = schemeSummaryPageObj.claimLeadID1().getText();
        System.out.println("Lead ID------------" + Lead2);
        claimSummaryPageObj.close().click();
        Assert.assertTrue(schemeSummaryPageObj.claimLeadIDInNextTask().getText().equalsIgnoreCase(Lead2));
        System.out.println("New is verified------------");
    }

    @And("^I should allow to select the first record$")
    public void I_should_allow_to_select_the_first_claim() {
        perfSerachObj.retreiveFirstClientRecord();
        commandsObj.switchToDesiredWindow(By.xpath(policyDataFieldsPageObj.coverTable()));
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
    }

    @And("^I should allow to select the first record in the standard search$")
    public void I_should_allow_to_select_the_first_claim_in_the_claim_table() {
        perfSerachObj.retreiveFirstClientRecord();
        claimOperationObj.navigateToClaimViewFromPolicyViewAnotherPolicy();
    }

    @And("^I should allow to select the first record in the search$")
    public void iShouldAllowToSelectTheFirstRecordInTheSearch() {
        // if(commandsObj.elementDisplayedWithLessTime(By.xpath(searchPageObj.viewCustomerLinkInSearchResultTablexpath()))) {
        try {
            perfSerachObj.retreiveFirstClientRecord();
            commandsObj.waitForLoad(getDriver());
            searchPageObj.switchToLastOpenWindow();
        } catch (Exception exe) {
            perfSerachObj.retreiveFirstClientRecord();
            commandsObj.switchToDesiredWindow(By.xpath(policyDataFieldsPageObj.coverTable()));
        }
    }

    @And("^I should be able to fill the Mandatory questions below$")
    public void i_should_be_able_to_fill_the_mandatory_questions_below(List<List<String>> lstInputs) throws Throwable {
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        navigationObj.navigateToNextEventType("Claim Specific Questions");
        if (lstInputs.get(1).get(0).equalsIgnoreCase("Save")) {
            perilQuestionsPageObj.savePerilQuestions().click();
        } else {
//          TODO one or more perils with their peril questions
            for (int perilRow = 1; perilRow < lstInputs.size(); perilRow++) {
                List<List<String>> perilQuestions = claimOperationObj.getPerilQuestions(lstInputs, perilRow);
                for (int row = 1; row < perilQuestions.size(); row++) {
                    for (int column = 0; column < perilQuestions.get(0).size(); column++) {
                        System.out.println(" perilq ++++++" + perilQuestions.get(0).get(column));
                        System.out.println("perilq =======" + perilQuestions.get(row).get(column));
                        claimOperationObj.validateMandatoryFields(perilQuestions.get(0).get(column), perilQuestions.get(row).get(column));
                    }
                }
            }
            perilQuestionsPageObj.savePerilQuestions().click();
        }
    }

    @And("^I should be able to validate the affected person is selectable from the below list$")
    public void i_should_be_able_to_validate_the_affected_person_is_selectable_from_the_below_list
            (List<List<String>> lstInputs) {
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        navigationObj.navigateToNextEventType("Claim Specific Questions");
        for (int row = 1; row < lstInputs.size(); row++) {
            for (int column = 0; column < lstInputs.get(0).size(); column++) {
                claimOperationObj.validateMandatoryFields(lstInputs.get(0).get(column), lstInputs.get(row).get(column));
            }
        }
    }

    @And("^I should be able to validate the affected person is not available$")
    public void i_should_be_able_to_validate_the_affected_person_is_not_available() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        Assert.assertTrue(perilQuestionsPageObj.affectedPersonS().size() == 0);
    }

    @And("^I add an Out of Process Event '(.+)'$")
    public void iAddAnOutOfProcessEventOOPAmendClaimDetails(String strOOPEvent) {
        outofProcessEventsObj.startOutOfProcesEvent(strOOPEvent);
    }

    @And("^I should be able to see the foot print of the changes made as given below$")
    public void iShouldBeAbleToSeeTheFootPrintOfTheChangesMadeAsGivenBelow
            (List<List<String>> lstFootPrintDetails) {
        nextEventPageObj.loadingPage();
        claimSummaryPageObj.waitForMoreTime();
        claimSummaryPageObj.waitForMoreTime();
        claimSummaryPageObj.editFirstClaim().click();
        claimSummaryPageObj.waitForMoreTime();
        claimSummaryPageObj.waitForMoreTime();
        financialPageObj.financialTab().click();
        claimSummaryPageObj.waitForMoreTime();
        claimSummaryPageObj.waitForMoreTime();
        claimSummaryPageObj.waitForMoreTime();
        claimOperationObj.validateClaimAmendmentsFootPrint(lstFootPrintDetails);
    }

    @Then("^Validate a message sent to (.+) for (.+)$")
    public void validate_a_message_sent_to_for(String advisor, String messagetoadvisor) {
        List<String> userDet = userObj.getUserDetails(advisor);
        String loginUserName = userDet.get(1);
        Assert.assertTrue(summaryViewObj.captureCommReceiverFromEventHistory(messagetoadvisor).equalsIgnoreCase(loginUserName));
    }

    @Then("^I should validate '(.+)' Events triggered and sent to Customer (.+) Address$")
    public void iShouldValidateChannelEventsTriggeredAndSentToCustomerEmailAddress(String event, String
            commsPref) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        System.out.println(commsPref);
        if (commsPref.equalsIgnoreCase("email")) {
            commsPref = policyDataFieldsPageObj.emailId().getAttribute("value");
            System.out.println("Inside Email" + commsPref);
        } else if (commsPref.equalsIgnoreCase("phone")) {
            commsPref = policyDataFieldsPageObj.mobileNo().getAttribute("value");
        } else {
            commsPref = "Letter";
        }
        System.out.println("value printed - " + commsPref);
        Assert.assertTrue(summaryViewObj.captureCommReceiverFromEventHistory(event).equalsIgnoreCase(commsPref));
    }

    @And("^I need to validate  caseid in workflow task of payment failure$")
    public void I_need_to_validate_caseid_in_workflow_task_of_payment_failure() {
        System.out.println("came to workflow task case id verification $$$$$$$$$$");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        String id = finalisePaymentPageObj.workflowcaseid().getText();
        System.out.println("in work flow case id%%%%%%% " + id + " and id captured by the system :: " + paymentfailurecaseid);
        Assert.assertTrue(id.equals(paymentfailurecaseid));
        System.out.println("after assert equal%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
    }

    @And("^I should validate date of payment failure should present in event history$")
    public void I_should_validate_date_of_payment_failure_should_present_in_event_history() {
        Assert.assertTrue(finalisePaymentPageObj.CustomerContactRequirednotificationincident().isDisplayed());
        System.out.println(" CAME TO EVENT HISTORY ################################" + finalisePaymentPageObj.dateofpaymentfailure().isDisplayed() + "###################");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        finalisePaymentPageObj.windowclose().click();
        nextEventPageObj.switchToWindowByIndex(1);
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
    }

    @And("^I should validate Failure code and Failure Description$")
    public void I_should_validate_Failure_code_and_Failure_Description() {
        Assert.assertTrue(finalisePaymentPageObj.Failurecode().isDisplayed());
        Assert.assertTrue(finalisePaymentPageObj.FailureDescription().isDisplayed());
    }

    @And("^I should be able to retrieve  the first claim ID$")
    public void I_should_be_able_to_retrieve_the_first_claim_ID() {
        claimOperationObj.retrieveClaimID();
    }

    @And("^Details of payment should be displayed in the GL Feed$")
    public void Details_of_payment_should_be_displayed_in_the_GL_Feed() {
        System.out.println("Implementation is pending from Integration part");
    }

    @And("^validate the flag for '(.+)' screening in the financial table$")
    public void validate_the_flag_for_sanction_screening(String flag) {
        nextEventPageObj.switchToDefault();
        claimsOperationsObj.selectFirstClaimInClaimTable();
        claimSummaryPageObj.financialTable();
        claimSummaryPageObj.financialTable().click();
        claimsOperationsObj.verifySanctionCheck();
    }

    @And("^verify claim item cannot be editable$")
    public void verify_claim_item_cannot_be_editable() {
        commonPageObj.switchToFrameById(commonPageObj.fancyFrame());
        claimSummaryPageObj.verifyClaimItemCannotBeEditable();
        System.out.println("Verifying claim Item cannot be editable");
        Assert.assertTrue(claimSummaryPageObj.verifyClaimItemCannotBeEditable().isDisplayed());
        System.out.println("*************************Claim Item cannot be editable***************************");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.fancyClose();
        nextEventPageObj.fancyClose().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    @And("^Validate the following claim reasons are displayed while reopening the claim$")
    public void Validate_the_following_claim_reasons_are_displayed_while_reopening_the_claim(List<List<String>> parameters) {
        claimsOperationsObj.validateReasonsforReopeningClaim(parameters);
    }

    @And("^select the claim close reason as '(.+)'$")
    public void select_the_claim_close_reason_as_Decision_overturned(String reason) {
        claimsRepudiationPageObj.reopenReasonInput().click();
        claimsRepudiationPageObj.reOpenReason(reason).isDisplayed();
        claimsRepudiationPageObj.reOpenReason(reason).click();
        claimsRepudiationPageObj.claimCloseSaveBtn();
        claimsRepudiationPageObj.claimCloseSaveBtn().click();
        claimsRepudiationPageObj.enterReopenComments();
        claimsRepudiationPageObj.enterReopenComments().sendKeys("Reopened");
        claimsRepudiationPageObj.reOpenFinishbtn();
        claimsRepudiationPageObj.reOpenFinishbtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(claimsRepudiationPageObj.verifyClaimClosedEventinEventHistoryTable().getText().equalsIgnoreCase("Reopened"));
        System.out.println("Closed Claim has been Reopened");
        System.out.println("Claim Reopened Date" + claimsRepudiationPageObj.claimReopenedDate().getText());
        System.out.println("Claim Reopened By" + claimsRepudiationPageObj.claimReopenedBy().getText());
    }

    @And("^I should allow to select the '(.+)' upgrade to cancel$")
    public void I_should_allow_to_select_the_Business_Cover_upgrade_to_cancel(String upgrade) {
        claimSummaryPageObj.selectUpgrade(upgrade);
        claimSummaryPageObj.selectUpgrade(upgrade).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    @And("^validate the '(.+)' upgrade has been '(.+)'$")
    public void validate_the_Business_Cover_upgrade_has_been_cancelled(String upgrade, String status) {
        nextEventPageObj.switchToDefault();
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.upgradeStatus(upgrade, status).isDisplayed();
        Assert.assertTrue(claimSummaryPageObj.upgradeStatus(upgrade, status).isDisplayed());
    }

    @And("^I should allow to enter refund reason as '(.+)'$")
    public void I_should_allow_to_enter_refund_reason_as_Refunded(String reason) {
        claimSummaryPageObj.customerRefundCheckBox().click();
        claimSummaryPageObj.refundReasontextarea().sendKeys(reason);
    }

    @And("^I should be able to save the cancellation reason$")
    public void I_should_be_able_to_save_the_cancellation_reason() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        policyDataFieldsPageObj.policySave().click();
    }

    @And("^validate the following error message '(.+)' displayed$")
    public void validate_the_following_error_message_Chosen_cancellation_date_is_outside_the_cooling_off_period_displayed(String errorMessage) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        Assert.assertTrue(claimSummaryPageObj.refundErrorMessage(errorMessage).isDisplayed());
        if (errorMessage.contains("Unable to approve or reject this rush payment.")) {
            claimOperationObj.clickingUnderNextEventsAndButtons("ok");
        }
    }

    @And("^validate the claim has been '(.+)'$")
    public void validate_the_claim_has_been_Reopened(String status) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
        Assert.assertTrue(claimsRepudiationPageObj.verifyClaimClosedEventinEventHistoryTable().getText().equalsIgnoreCase(status));
        System.out.println("Closed Claim has been Reopened");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    @And("^I should able to enter the below '(.+)' details$")
    public void iShouldAbleToEnterTheBelowThirdPartyDetails(String supplierOption, List<List<String>> thirdPartyDetails) {
        for (int i = 1; i < thirdPartyDetails.size(); i++) {
            for (int j = 0; j < thirdPartyDetails.get(0).size(); j++) {
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                claimCreationObj.enterThirPartyDetails(thirdPartyDetails.get(0).get(j), thirdPartyDetails.get(i).get(j));
            }
        }
    }

    @And("^Select Account detail '(.+)'$")
    public void selectAccountNumber(String accountNo) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimPaymentPageObj.selectAccountDetail(accountNo).click();
        claimPaymentPageObj.savePaymentBtn().click();
    }

    @And("^System should generate the corresponce for the claim and send to supplier$")
    public void systemShouldGenerateTheCorresponceForTheClaimAndSendToSupplier() {
        try {
            Thread.sleep(20000L);
            getDriver().navigate().refresh();
            fullEventHistoryPageObj.showFullEventHistory().click();
            nextEventPageObj.switchToWindowByIndex(2);
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            fullEventHistoryPageObj.settlementLetterPDF().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            int fileSize = (int) claimsOperationsObj.fileSize();
            System.out.println("file size----------------------------" + fileSize);
            Assert.assertTrue(fileSize > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^Enter the packaged bank detail of the account holder$")
    public void enterThePackagedBankDetailOfTheAccountHolder() {
        throw new PendingException();
    }

    @And("^System should not allow to add accound details of account holder$")
    public void systemShouldNotAllowToAddAccoundDetailsOfAccountHolder() {
        throw new PendingException();
    }

    @Then("^I should be able to validate the below Evidences$")
    public void iShouldBeAbleToValidateTheBelowEvidences(List<List<String>> inputValues) {
        claimOperationObj.validateEvidenceListed(inputValues);
    }

    @And("^I should be able to select the repudiation reason$")
    public void Ishouldbeabletoselecttherepudiationreason() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimsRepudiationPageObj.Reasonbtn().click();
        claimsRepudiationPageObj.Reasondropdown().click();
        new Select(claimsRepudiationPageObj.Reasondropdown()).selectByIndex(1);
        System.out.println("^^^^^^^^^^^^^^^^^^^^Save btn");
        claimsRepudiationPageObj.save().click();
        System.out.println("^^^^^^^^^^^^^^^^^^^^Save btnnnnnnnnnnnnn");
    }

    @And("^I should be able to do the followings$")
    public void Ishouldbeabletodothefollowings(List<List<String>> list) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        evidenceCollationPageObj.ResDropDown().click();
        evidenceCollationPageObj.ResDropDownYes().click();
        System.out.println("^^^^^^^^^^^^^^^^^^^^Save btn");
        claimsRepudiationPageObj.saveresBtn().click();
        System.out.println("^^^^^^^^^^^^^^^^^^^^Save btnnnnnnnnnnnnn");
    }

    @And("^I should be able to select the following$")
    public void Ishouldbeabletoselectthefollowing(List<List<String>> list) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        evidenceCollationPageObj.ResDropDown().click();
        evidenceCollationPageObj.ResDropDownNo().click();
        evidenceCollationPageObj.Resreason().sendKeys("nil");
        evidenceCollationPageObj.ResRejDropDown().click();
        evidenceCollationPageObj.ResRejDropDownSelect().click();
        System.out.println("^^^^^^^^^^^^^^^^^^^^Save btn");
        claimsRepudiationPageObj.saveresBtn().click();
        System.out.println("^^^^^^^^^^^^^^^^^^^^Save btnnnnnnnnnnnnn");
    }

    @And("^I should be able to enter the following TMA details$")
    public void iShouldBeAbleToEnterTheFollowingTMADetails(List<List<String>> extraDetails) {
        tmaDetailsObj.enterBasicTMADetails(extraDetails);
    }

    @And("^It must be possible to trigger a '(.+)' and validate the event is generated$")
    public void itMustBePossibleToTriggerAOOPTMADisclaimerRequestAndValidateTheFollowing(String option) {
        claimsOperationsObj.CaptureDisclaimerRequest(option);
    }

    @And("^Validate the '(.+)' has been triggered and the Email '(.+)'$")
    public void validteTheDisclaimerRequestEmailHasBeenTriggered(String event, String message) {
        try {
            claimOperationObj.validateTMAEmail(event, message);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @And("^I should be able to '(.+)' with following data to make a check payment$")
    public void iShouldBeAbleToEnterChequeDetailsWithFollowingDataToMakeACheckPayment(String eventType, List<List<String>> paymentDetail) {
        try {
            claimPaymentOperationsObj.makeCheckPayment(eventType, paymentDetail);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @And("^I should be able to enter payment comment$")
    public void iShouldBeAbleToEnterPaymentComment(List<List<String>> paymentDetail) {
        try {
            claimPaymentOperationsObj.addPaymentComment(paymentDetail);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @And("^verify the supplier with the below details$")
    public void verifyTheSupplier(List<List<String>> parameters) {
        claimPaymentOperationsObj.verifySupplier(parameters);
    }

    @And("^I should be able to click on '(.+)' button and enter the values$")
    public void iShouldBeAbleToClickOnEnterGPDetailsButtonAndEnterTheValues(String customer, List<List<String>> parameters) {
        claimSummaryPageObj.enterGPDetails().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.clickingUnderNextEventsAndButtons("Goto");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimPaymentOperationsObj.verifyGP(parameters);
    }

    @And("^I should be able to click on '(.+)' button for customer authorization$")
    public void iShouldBeAbleToClickOnGPCheckRequiredButtonForCustomerAuthorization(String customer, List<List<String>> parameters) {
        claimSummaryPageObj.gpCheckRequired().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.clickingUnderNextEventsAndButtons("Goto");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimSummaryPageObj.gpCheckCustomerAuthorise().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.policySave().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.clickingUnderNextEventsAndButtons("Goto");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
//        claimPaymentOperationsObj.verifyGP(parameters);
    }

    @And("^I should allow to create the product for the '(.+)'$")
    public void iShouldAllowToCreateTheProduct(String customer, List<List<String>> parameters) {
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        policyOperationsObj.createproduct(customer, parameters);
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        policyDataFieldsPageObj.policySave().click();
    }

    @Then("^I should be able to select a claim with status as Claim closed$")
    public void I_should_be_able_to_select_a_claim_with_status_as_Claim_closed() {
        nextEventPageObj.loadingPage();
        nextEventPageObj.waitForMoreTime();
        perfSerachObj.retreiveFirstClientRecord();
        claimOperationObj.navigateToClaimViewFromPolicyView();
        System.out.println("@@@@@@@ claim Page @@@@@@@@@@@");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.claimasclaimclosed();
    }

    @Then("^I should be able to Create another '(.+)'$")
    public void iShouldBeAbleToCreateAnotherClaim(String claim, List<List<String>> parameters) {
        claimCreationObj.createAnotherNewClaim(claim, parameters);
    }

    @And("^Navigate to the Policy$")
    public void navigateToThePolicy() {
        claimCreationObj.navigateToTheClaim();
    }

    @And("^I should allow to update the dateofBirth of the customer as '(.+)'$")
    public void iShouldAllowToUpdateTheDateofBirthOfTheCustomer(String dob) {
        claimsOperationsObj.enterDOBOfCustomer(dob);
    }

    @And("^I should be able to retrieve the TMACaseid$")
    public void iShouldBeAbleToRetrieveTheTMACaseid() {
        claimsOperationsObj.retrieveTMAcaseid();
    }

    @And("^I should be able to find the tma case ID$")
    public void IshouldbeabletofindthetmacaseID() {
        System.out.println("Case ID checked in Manage workflow event" + claimsOperationsObj.tmaCaseID);
        WebElement caseIDElement = manageWorkflowTaskPageObj.caseIdInWorkflow(claimsOperationsObj.tmaCaseID);
        Assert.assertTrue("-------Case id is not displayed------" + claimsOperationsObj.tmaCaseID, caseIDElement.isDisplayed());
    }

    @And("^I should be able to select '(.+)'$")
    public void iShouldBeAbleToSelectOOPEvents(String oopEvent) {
        claimOperationObj.clickingUnderNextEventsAndButtons("out of process event");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        navigationObj.navigateToNextEventType(oopEvent);
    }

    @And("^I should be able to enter supplier/Agent details for the TMA claim$")
    public void iShouldBeAbleToEnterSupplierDetailsForTheTMAClaim(List<List<String>> parameters) {
        tmaDetailsObj.enterSupplierOrAgentDetails(parameters);
    }

    @And("^I should be able to enter supplier/GP details for the TMA claim$")
    public void iShouldBeAbleToEnterSupplierGPDetailsForTheTMAClaim(List<List<String>> parameters) {
        tmaDetailsObj.enterSupplierOrGPDetails(parameters);
    }

    @And("^I should allow to update the claim payment details$")
    public void iShouldAllowToUpdateTheClaimPaymentDetails() {
    }

    @And("^validate the record is updated$")
    public void validateTheRecordIsUpdated() {
    }

    @And("^The system should allow to store the key audit changes listed below$")
    public void theSystemShouldAllowToStoreTheKeyAuditChangesListedBelow() {
    }

    @And("^I should be able to select all or specific repudiation reason$")
    public void Ishouldbeabletoselectallorspecificrepudiationreason(List<List<String>> parameters) {
        claimOperationObj.selectRepudiateReasonDropowns(parameters);
    }

    @And("^I should be able to choose '(.+)' and verify that the following parties are displayed to intimate about the retract '(.+)'$")
    public void iShouldBeAbleToChooseAndVerifyThatTheFollowingPartiesAreDisplayedToIntimateAboutTheRetract(String oopEvent, String valueToVerify, List<List<String>> parameters) {
        tmaDetailsObj.enterRetractDetails(oopEvent, valueToVerify, parameters);
    }

    @And("^I should allow to validate and enter the GP details$")
    public void iShouldAllowToEnterTheGPDetails(List<List<String>> parameters) {
        claimPaymentOperationsObj.verifySupplier(parameters);
    }

    @And("^I should be able to retrieve the data from the UIS to aquarium$")
    public void iShouldBeAbleToRetrieveTheDataFromTheUISToAquarium() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimPaymentOperationsObj.retrieveDataFromUIS();
    }

    @And("^I should be able to verify the options for the below fields$")
    public void iShouldBeAbleToVerifyTheOptionsForTheBelowFields(List<List<String>> parameters) {
        clientOperationsObj.verifyOptions(parameters);
    }

    @And("^I should be able to view the bars added for '(.+)'$")
    public void iShouldBeAbleToViewTheBarsAdded(String bar, List<List<String>> parameters) {
        clientOperationsObj.verifyNameOfBarAdded(bar, parameters);
    }

    @Then("^I should be able to verify the message displayed for '(.+)'$")
    public void iShouldBeAbleToVerifyTheMessageDisplayedForComplianceS(String notificationType, List<List<String>> message) {
        clientOperationsObj.verifyMessageForNotification(notificationType, message);
    }

    @And("^I navigate back to the policy '(.+)'$")
    public void iNavigateBackToThePolicySophiaMason(String policyHolder) throws Throwable {
        claimPaymentOperationsObj.navigatingToThePolicy(policyHolder);
    }

    @And("^validate the following linked conditions is displayed for the '(.+)'$")
    public void validateTheFollowingLinkedConditionsIsDisplayedForTheMainAccountHolder(String namedPeople, List<List<String>> parameters) throws Throwable {
        clientOperationsObj.validateLinkedConditionsDataInSchemesummary(namedPeople, parameters);
    }

    @And("^I navigate to the LeadManager$")
    public void iNavigateToTheLeadManager() throws Throwable {
        clientOperationsObj.navigateTOLeadManager();
    }

    @And("^verify medical type in claim table$")
    public void verify_medical_type_in_claim_table() {
        claimOperationObj.validateMedicalType();
    }

    @And("^validate the following fields has been captured and notified$")
    public void validateTheFollowingFieldsHasBeenCapturedAndNotified(List<List<String>> parameters) throws Throwable {
        claimOperationObj.validateMissingPersonFoundDetailsInLeadsTab(parameters);
    }

    @And("^I navigate to the TMA claim$")
    public void iNavigateToTheTMAClaim() throws Throwable {
        claimOperationObj.viewTMAClaim();
    }

    @And("^Validate the claim has been allocated to the claim Handler '(.+)'$")
    public void validateTheClaimHasBeenAllocatedToTheClaimHandlerPabloTest(String claimHandler) throws Throwable {
        claimOperationObj.validateClaimAllocatedToclaimHandler(claimHandler);
    }

    @And("^Validate the claim allocated or unallocated with claim handler reason$")
    public void validateTheClaimAllocatedOrUnallocatedWithClaimHandlerReason() {
        claimOperationObj.validateClaimUnallocatedWithClaimHandlerReason();
    }

    @And("^The claim handler signature should be available in the email generated for '(.+)'$")
    public void verifySystemGeneratesAnAutomatedLetterAndalongWiththeClaimHandlerSignature(String event) throws Throwable {
        claimOperationObj.validateClaimHandlerInAutoGeneratedLetter(event);
    }

    @And("^I should allow to retrieve the ClaimHandler$")
    public void iShouldAllowToRetrieveTheClaimHandler() throws Throwable {
        claimOperationObj.retrieveClaimHandler();
    }

    @And("^validate claim Handler is '(.+)'$")
    public void validateClaimHandlerIsNotAssigned(String handler) throws Throwable {
        claimOperationObj.validateClaimHandler(handler);
    }

    @And("^validate the any existing claims and associated tasks already allocated will still be managed by the nominated claim handler$")
    public void validateTheAnyExistingClaimsAndAssociatedTasksAlreadyAllocatedWillStillBeManagedByTheNominatedClaimHandler() throws Throwable {
        claimOperationObj.validateExistingClaimStatus();
    }

    @And("^I should be able to '(.+)' for premium$")
    public void iShouldBeAbleToValidateTheErrorMessageForPremium(String errorMessage, List<List<String>> lstInput) {
        if (lstInput.get(1).get(0).equalsIgnoreCase("Only members of the counter fraud team can unlock a case which is on hold")) {
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        }
        System.out.println("Error message Validation -----------------------" + quoteDetailsPageObj.errorMessageforpremium(lstInput.get(1).get(0)).getText());
        Assert.assertTrue(quoteDetailsPageObj.errorMessageforpremium(lstInput.get(1).get(0)).getText().equalsIgnoreCase(lstInput.get(1).get(0)));
        quoteDetailsPageObj.btnCancel().click();
    }

    @And("^I should be able to validate the claim has been allocated to a claim handler and save the claim handler detail$")
    public void iShouldBeAbleToValidateTheClaimHasBeenAllocatedToAClaimHandler() throws Throwable {
        claimOperationObj.validateClaimAllocatedToAclaimHandler();
    }

    @And("^I should be able to select the '(.+)'$")
    public void iShouldBeAbleToSelectTheOOPEvents(String oopEvent, List<List<String>> parameters) {
        claimOperationObj.clickingUnderNextEventsAndButtons("out of process event");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        navigationObj.navigateToNextEventType1(oopEvent, parameters);
    }

    @And("^I should be able to retrieve the claim id and claim item id$")
    public void iShouldBeAbleToRetrieveTheClaimIdAndClaimItemId() {
        claimOperationObj.getClaimIdAndClaimItemId();
    }

    @And("^I should be able to update the invoice details$")
    public void iShouldBeAbleToUpdateTheInvoiceDetails(List<List<String>> parameters) {
        tmaDetailsObj.enterInvoiceDetails(parameters);
    }

    @And("^Verify the default VAT status is '(.+)'$")
    public void verifyTheDefaultVATStatusIsStandard(String vatStatus) {
        tmaDetailsObj.verifyVATStatus(vatStatus);
    }

    @And("^I should be able to verify the default VAT status as '(.+)' and verify the VAT amount generated for due amount '(.+)'$")
    public void iShouldBeAbleToVerifyTheDefaultVATStatusAsStandardAndVerifyTheVATAmountGenerated(String defaultVATStatus, String dueAmount) {
        tmaDetailsObj.verifyVATStatus(defaultVATStatus);
        String amount = tmaDetailsObj.verifyVATAmountFieldisDisplayed();
        tmaDetailsObj.calculatedVATAmount(defaultVATStatus, amount, dueAmount);
    }

    @And("^I should be able to pay the invoice for the claim using '(.+)' option using '(.+)' details '(.+)'$")
    public void iShouldBeAbleToPayTheInvoiceForTheClaim(String option, String paymentMethod, String details) {
        tmaDetailsObj.payTheUploadedInvoice(option, paymentMethod, details);
    }

    @And("^I should allow to enter contact details$")
    public void iShouldAllowToEnterContactDetails(List<List<String>> parameters) {
        tmaDetailsObj.enterTMAContactDetails(parameters);
    }

    @And("^I should allow to enter Contact Customer to discuss Repatriation details$")
    public void iShouldAllowToEnterContactCustomerToDiscussRepatriationDetails(List<List<String>> parameters) {
        tmaDetailsObj.enterTMAContactCustomerToDiscussRepatriationDetails(parameters);
    }

    @And("^I should allow to enter healix fit to fly details$")
    public void iShouldAllowToEnterHealixFitToFlyDetails(List<List<String>> parameters) {
        tmaDetailsObj.enterTMAHealixFitToFlyDetails(parameters);
    }

    @And("^I should allow to enter luggage checklist details$")
    public void iShouldAllowToEnterLuggageChecklistDetails(List<List<String>> parameters) {
        tmaDetailsObj.enterTMALuggageChecklistDetails(parameters);
    }

    @And("^I should allow to enter repatriation checklist details$")
    public void iShouldAllowToEnterRepatriationChecklistDetails(List<List<String>> parameters) {
        tmaDetailsObj.enterTMARepatriationChecklistDetails(parameters);
    }

    @And("^validate the following Request Type templates are displayed$")
    public void validateTheFollowingRequestTypeTemplatesAreDisplayed(List<String> parameters) {
        claimOperationObj.validateRequestTypeTemplate(parameters);
    }

    @And("^I should allow to assign a template '(.+)'$")
    public void iShouldAllowToAssignATemplateTaxi(String template) {
        claimOperationObj.selectTemplate(template);
    }

    @And("^validate the template '(.+)' has been pre-populated for the policy holder '(.+)'$")
    public void validateTheTemplateTaxiHasBeenPrePopulatedForThePolicyHolderFortyTwoAutomationPolicy(String template, String policyHolder) {
        claimOperationObj.validateTemplatePrePopulated(template, policyHolder);
    }

    @And("^I should allow to enter chase hours as '(.+)'$")
    public void iShouldAllowToEnterChaseHoursAs(String chasehours, List<List<String>> parameters) {
        claimOperationObj.enterChaseHours(chasehours, parameters);
    }

    @And("^I should allow to remove the template '(.+)' for the policy holder '(.+)'$")
    public void iShouldAllowToRemoveTheTemplateTaxiForThePolicyHolderFortyTwoAutomationPolicy(String template, String policyHolder) {
        claimOperationObj.removeTemplate(template, policyHolder);
    }

    @And("^I should be able to verify the claim status and the amount paid as '(.+)'$")
    public void iShouldBeAbleToVerifyTheClaimStatusAndTheAmountPaid(String amount) {
        claimOperationObj.searchClaimThroughAdvanceSearchAndVerifyAmountPaid(amount);
    }

    @And("^System should automatically '(.+)' the supplier based on the Template and the Country$")
    public void systemShouldAutomaticallyAllocateTheSupplierBasedOnTheTemplateAndTheCountry(String allocation, List<List<String>> parameters) {
        claimOperationObj.validatePrepopulatedSupplier(allocation, parameters);
    }

    @And("^validate the multiple suppliers requests are generated for the policy holder '(.+)'$")
    public void validateTheMultipleSuppliersRequestsAreGeneratedForThePolicyHolderFortyTwoAutomationPolicy(String policyHolder, List<List<String>> parameters) {
        claimOperationObj.validateMultiplePrepopulatedSuppliers(policyHolder, parameters);
    }

    @And("^I should allow to retrieve the excess amount for the following scheme$")
    public void iShouldAllowToRetrieveTheExcessAmountForTheFollowingScheme(List<List<String>> parameters) {
        claimOperationObj.retrieveAmountandExcess(parameters);
    }

    @And("^validate the correct excess has been applied for the claim with the following details$")
    public void validateTheCorrectExcessHasBeenAppliedForTheClaimWithTheFollowingDetails(List<List<String>> parameters) {
        claimOperationObj.validateClaimDetailsInInternaltab(parameters);
    }

    @And("^I should allow to retrieve the country for the supplier '(.+)'$")
    public void iShouldAllowToRetrieveTheCountryForTheSupplierTaxi(String supplier) {
        claimOperationObj.retrieveCountry(supplier);
    }

    @And("^I should allow to attach the template to the client record with the following details$")
    public void iShouldAllowToAttachTheTemplateToTheClientRecordWithTheFollowingDetails(List<List<String>> parameters) {
        claimOperationObj.validateWhoandWhenDetails(parameters);
    }

    @And("^I should be able to pay all the invoice using '(.+)' with the same payment details '(.+)' using '(.+)'$")
    public void iShouldBeAbleToPayAllTheInvoiceUsingInvoicePayOOPWithTheSamePaymentDetailsUsingBank(String option, String details, String paymentMethod) {
        tmaDetailsObj.payAllUploadedInvoice(option, paymentMethod, details);
    }

    @And("^I should be able to enter the following TMA basic details$")
    public void iShouldBeAbleToCaptureTheFollowingTMADetails(List<List<String>> extraDetails) throws Throwable {
        tmaDetailsObj.enterBasicTMADetails(extraDetails);
    }

    @And("^I navigate to claim$")
    public void iNavigateToClaim() throws Throwable {
        claimOperationObj.navigateToClaimViewFromPolicyView();
    }

    @And("^validate the claim Hanlder remains same$")
    public void validateTheClaimHanlderRemainsSame() throws Throwable {
        claimOperationObj.validateRetrievedClaimHandler();
    }

    @And("^validate the TeamLeader has been notified$")
    public void validateTheTeamLeaderHasBeenNotified() throws Throwable {

    }

    @And("^I should allow to navigate to the base policy$")
    public void iShouldAllowToNavigateToTheBasePolicy() throws Throwable {
        claimOperationObj.navigateToBasePolicy();
    }

    @And("^Navigate to the policy view from billing view$")
    public void navigateToThePolicyViewFromBillingView() throws Throwable {
        claimOperationObj.navigateToPolicyViewFromBilling();
    }

    @And("^Verify deceased customer '(.+)' is highlighted in '(.+)' color$")
    public void verifyDeceasedCustomerMainAccountHolderDaughterIsHighlightedInBlackColor(String customer, String color) throws Throwable {
        claimOperationObj.validateNamedPeopleColor(customer, color);
    }

    @And("^I should be able to click on '(.+)' button and select valid reasons for closing claim$")
    public void iShouldBeAbleToClickOnOutOfProcessEventButtonAndSelectValidReasonsForClosingClaim(String action, List<List<String>> lstInputs) throws Throwable {
        if (!strEventType.equalsIgnoreCase("Other Insurer") && !strEventType.equalsIgnoreCase("Claim Calculation") &&
                !strEventType.equalsIgnoreCase("Collate Information") && !strEventType.equalsIgnoreCase("Process Claim")) {
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
            System.out.println("field name --------------------" + action);
            navigationObj.navigateToNextEventType(action);
            claimOperationObj.selectReasonForClaimClose(lstInputs);
        }
        System.out.println("*************Closing Claim********");
    }

    @And("^I should allow to assign '(.+)' with the below details$")
    public void iShouldAllowToAssignPanelSolicitor(String solicitor, List<List<String>> parameters) throws Throwable {
        claimOperationObj.assignSolicitor(solicitor, parameters);
    }

    @And("^I should allow to enter legal expense data$")
    public void iShouldAllowToEnterLegalExpenseData(List<List<String>> parameters) throws Throwable {
        claimOperationObj.legalExpenseDataCapture(parameters);
    }

    @And("^validate tooltip '(.+)' is displayed$")
    public void validateTooltipLikelihoodOfSuccessNextCheckDateIsDisplayed(String tooltipMsg) throws Throwable {
        claimOperationObj.validateTooltip(tooltipMsg);
    }

    @And("^validate the Legal Expense Claim details are reflected in the Claim$")
    public void validateTheLegalExpenseClaimDetailsAreReflectedInTheClaim(List<List<String>> parameters) throws Throwable {
        claimOperationObj.validateLegalClaimDetails(parameters);
    }

    @And("^I should allow to capture the '(.+)'$")
    public void iShouldAllowToCaptureTheClaimItemID(String claimItemID) throws Throwable {
        claimOperationObj.captureClaimItemID(claimItemID);
    }

    @And("^I should be able to update the '(.+)' as '(.+)'$")
    public void iShouldBeAbleToUpdateTheCountryForVATAsGUERNSEY(String field, String country) throws Throwable {
        claimOperationObj.entersupplierDetailsInLeadTab(field, country);
    }

    @And("^I should allow to capture the following details$")
    public void iShouldAllowToCaptureTheFollowingDetails(List<List<String>> parameters) throws Throwable {
        claimOperationObj.captureClaimDetails(parameters);
    }

    @And("^I should be able to find the case ID in workflow$")
    public void iShouldBeAbleToFindTheCaseIDInWorkflow() throws Throwable {
        claimOperationObj.validateLeadIdInWorkflow();
    }

    @And("^I navigate to Task Reminder$")
    public void iNavigateToTaskReminder() throws Throwable {
        claimOperationObj.navigateToTaskReminder();
    }

    @And("^validate the claimID is listed under the Task Reminder and validate the following fields$")
    public void validateTheClaimIDIsListedUnderTheTaskReminder(List<List<String>> parameters) throws Throwable {
        claimOperationObj.validateClaimlistedUnderTaskReminder(parameters);
    }

    @Then("^I must be able to manage default reserves by storing and maintaining the following data items$")
    public void iMustBeAbleToManageDefaultReservesByStoringAndMaintainingTheFollowingDataItems(List<String> parameters) throws Throwable {
        claimOperationObj.validateDefaultReserves(parameters);
    }

    @And("^I should allow to capture the reserve for the country '(.+)'$")
    public void iShouldAllowToCaptureTheReserveForTheCountryFrance(String country, List<String> parameters) throws Throwable {
        claimOperationObj.captureReserveValue(country, parameters);
    }

    @And("^I should allow to validate the Default reserve for the ClaimItem2 '(.+)'$")
    public void iShouldAllowToValidateTheDefaultReserveForTheClaimItemHospitalBill(String claimItem2, List<List<String>> parameters) throws Throwable {
        claimOperationObj.validateDefaultReserve(claimItem2, parameters);
    }

    @And("^I should be able to capture the '(.+)' and '(.+)' for the '(.+)'$")
    public void iShouldBeAbleToRetrieveTheLimitAndExcessForTheEmergencyMedicalAndRelatedCosts(String limit, String excess, String cause) throws Throwable {
        claimOperationObj.retrieveLimitAndExcess(limit, excess, cause);
    }

    @And("^I should allow to change the '(.+)' wih the following fields$")
    public void iShouldAllowToChangeThePolicyLimitOverridesWihTheFollowingFields(String field, List<List<String>> parameters) throws Throwable {
        claimOperationObj.overrideLimitAndExcess(field, parameters);
    }

    @And("^I should allow to navigate to the Claim summary$")
    public void iShouldAllowToNavigateToTheClaimSummary() throws Throwable {
        claimOperationObj.navigateToClaimSummaryView();
    }

    @And("^I should be able to save the claimItem$")
    public void iShouldBeAbleToSaveTheClaimItem() throws Throwable {
        claimOperationObj.saveClaimItem();
    }

    @And("^I should allow to pay the invoice with the following details for the account (.+)$")
    public void iShouldAllowToPayTheInvoiceWithTheFollowingDetails(String account, List<List<String>> paramters) throws Throwable {
        tmaDetailsObj.toPayUploadedInvoice(paramters, account);
    }

    @And("^validate the bar has been applied to the base policy$")
    public void validateTheBarHasBeenAppliedToTheBasePolicy(List<List<String>> parameters) throws Throwable {
        claimOperationObj.validateBarHasApplied(parameters);
    }

    @And("^I should allow to navigate to Aquarium$")
    public void iShouldAllowToNavigateToAquarium() throws Throwable {
        claimOperationObj.navigateToAQ();
    }

    @And("^I should allow to close the claim with the following details$")
    public void iShouldAllowToCloseTheClaimWithTheFollowingDetails(List<List<String>> parameters) throws Throwable {
        claimOperationObj.closeClaim(parameters);
    }

    @And("^validate the system shouldn't allow to close the claim with outstanding reserve and displays an error message '(.+)'$")
    public void validateTheSystemShouldnTAllowToCloseTheClaimWithOutstandingReserve(String errorMessage) throws Throwable {
        claimOperationObj.validateCloseClaimWithReserve(errorMessage);
    }

    @And("^I should allow to validate the Claim Closure FootPrint$")
    public void iShouldAllowToValidateTheClaimClosureFootPrint(List<List<String>> parameters) throws Throwable {
        claimOperationObj.claimClosureFootPrint(parameters);
    }

    @And("^I should allow to validate the following claim Close Reasons$")
    public void iShouldAllowToValidateTheFollowingClaimCloseReasons(List<List<String>> parameters) throws Throwable {
        claimOperationObj.validateClaimCloseReasons(parameters);
    }

    @And("^I must be able to review the claim submitted by the customer$")
    public void iMustBeAbleToReviewTheClaimSubmittedByTheCustomer() throws Throwable {
        claimOperationObj.navigateToSubmittedDigClaim();
    }

    @And("^validate the '(.+)' workflow task has been triggered$")
    public void validateTheUpgradeSalesWorkflowTaskHasBeenTriggered(String event) throws Throwable {
        claimOperationObj.closingClaim_WithSubreasonAsUpgradeNotPurchased();
    }

    @And("^I should allow to validate the Claim Reopened FootPrint$")
    public void iShouldAllowToValidateTheClaimReopenedFootPrint(List<List<String>> parameters) throws Throwable {
        claimOperationObj.claimReopendFootPrint(parameters);
    }

    @And("^I should allow to validate the claim has '(.+)' in the Customer Portal$")
    public void iShouldAllowToValidateTheClaimHasReopenedInTheCustomerPortal(String claimStatus) throws Throwable {
        claimOperationObj.claimStatusInDigitalPortal(claimStatus);
    }

    @And("^I navigate to Recovery tab and verify the status '(.+)' and  the action '(.+)'$")
    public void iNavigateToRecoveryTabAndVerifyTheStatusConfirmationRequestedAndTheActionLiabilityConfirmationRequest(String status, String action) throws Throwable {
        claimOperationObj.verifyStatusOfRecovery(status, action);
    }

    @And("^I select the incidents for recovery '(.+)'$")
    public void iSelectTheIncidentsForRocovery(String incident) throws Throwable {
        claimOperationObj.selectIncidentForRecovery(incident);
    }

    @Then("^It must be possible to Add a Person$")
    public void itMustBePossibleToAddAPerson() throws Throwable {
        claimOperationObj.addPersonClaimCost();
    }

    @And("^validate the '(.+)' details reflected in Aquarium$")
    public void validateThePartialOnlineClaimDetailsReflectedInAquarium(String claim, List<List<String>> parameter) {
        claimCreationObj.createPartialOnlineClaim(claim, parameter);
    }

    @And("^enter the remaining '(.+)' details in Aquarium$")
    public void enterTheRemainingPartialOnlineClaimDetailsInAquarium(String claim, List<List<String>> parameters) throws Throwable {
        claimCreationObj.enterPartialClaimDetails(claim, parameters);
    }

    @And("^I validate the partial online claim details$")
    public void iValidateThePartialOnlineClaimDetails() {
        claimsOperationsObj.validatePartialOnlineClaimDetails();
    }

    @And("^I validate the details in claim table$")
    public void iValidateTheDetailsInClaimTable(List<List<String>> parameters) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
        claimOperationObj.validateClaimdetailsInClaimTable(parameters);
    }

    @And("^Enter the additional (.+) details in Aquarium$")
    public void enterTheAdditionalPerilDetailsInAquarium(String claim, List<List<String>> parameters) throws Throwable {
        claimCreationObj.enterMultiplePerilDetails(claim, parameters);
    }

    @And("^I should allow to create a new Claim$")
    public void iShouldAllowToCreateANewClaim() throws Throwable {
        claimOperationObj.createNewClaim();
    }

    @And("^I should allow to enter '(.+)' for the '(.+)'$")
    public void iShouldAllowToEnterBasicClaimDetailsForTheClaimID(String operation, String claimID, List<List<String>> parameters) throws Throwable {
        claimOperationObj.enterBasicClaimDetails(operation, claimID, parameters);
    }

    @And("^I should allow to manually allocate the '(.+)' to ClaimHandler '(.+)'$")
    public void iShouldAllowToManuallyAllocateTheClaimIDToClaimHandlerCallCenterAgent(String claimID, String claimHandler) throws Throwable {
        claimOperationObj.allocationOfClaimToClaimHandlerManually(claimID, claimHandler);
    }

    @And("^validate the '(.+)' is listed under the DashBoard$")
    public void validateTheClaimIDIsListedUnderTheDashBorad(String claimID) throws Throwable {
        claimOperationObj.validateClaimListedUnderDashBoard(claimID);
    }

    @And("^I have to validate The SLA is in '(.+)' color$")
    public void I_have_to_validate_The_SLA_is_in_color(String color) {
        claimOperationObj.validateSLAColor(color);
    }

    @And("^validate the '(.+)' deadline is in effect for the '(.+)'$")
    public void validateTheAssigningSolicitorForLegalClaimsDeadlineIsInEffectForTheClaimID(String deadline, String claimID) throws Throwable {
        claimOperationObj.validateToolTipInDashBoard(deadline, claimID);
    }

    @And("^I should allow to close the claim with reason as '(.+)'$")
    public void iShouldAllowToCloseTheClaim(String claimID) throws Throwable {
        claimOperationObj.navigateClaimFromDashBoard(claimID);
    }

    @And("^I should allow to navigate to the '(.+)' through DashBoard$")
    public void iShouldAllowToNavigateToTheClaimThroughDashBoard(String claimID) throws Throwable {
        claimOperationObj.navigateClaimFromDashBoard(claimID);
    }

    @And("^I should be able to retrieve the claim id for '(.+)'$")
    public void iShouldBeAbleToRetrieveTheClaimId(String claimDetails) {
        claimOperationObj.getClaimIdAndMultipleClaimItem(claimDetails);
    }

    @And("^I should able to search the claim and update the invoice details$")
    public void iShouldAbleToSearchTheClaimAndUpdateTheInvoiceDetails(List<List<String>> parameters) {
        tmaDetailsObj.enterInvoiceDetailsForMultipleClaimItem(parameters);
    }

    @And("^I should verify the claim amount paid for the claims is displayed as '(.+)'$")
    public void iShouldVerifyTheClaimAmountPaidForTheClaimsIsDisplayedAs(String claimAmount) throws Throwable {
        tmaDetailsObj.claimAmountPaidBySupplier(claimAmount);
    }

    @And("^I should be able to click on '(.+)' button for '(.+)' times$")
    public void iShouldBeAbleToClickOnRefreshButtonForTimes(String action, int times) throws Throwable {
        System.out.println("No of times for doing refresh----" + times);
        for (int i = 0; i <= times; i++) {
            Thread.sleep(10000L);
            claimOperationObj.clickingUnderNextEventsAndButtons(action);
        }
    }

    @Then("^I should be able to Create a new '(.+)' for Competency$")
    public void iShouldBeAbleToCreateANewClaimForCompetency(String claim, List<List<String>> parameters) throws Throwable {
        //claimCreationObj.createANewClaimForCompetency(claim, parameters);
    }

    @And("^validate the repudiation reason for the claim$")
    public void validateTheRepudiationReasonForTheClaim(List<String> reason) throws Throwable {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("---------" + reason.get(0).trim());
        nextEventPageObj.waitForMoreTime();
        System.out.println("---------" + reason.get(0).trim());
        Assert.assertTrue(claimsRepudiationPageObj.txtRepudiationReason(reason.get(0).trim()).isDisplayed());
        System.out.println("Reason is validated");
        nextEventPageObj.btnClick(claimsRepudiationPageObj.lnkRepudiationReason(reason.get(0).trim()));
        System.out.println("Editing the Repudiation Reason");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (reason.size() > 1) {
            for (int i = 0; i <= reason.size() - 1; i++) {
                if (reason.get(i).equalsIgnoreCase("currentDate")) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar c = Calendar.getInstance();
                    c.setTime(new Date());
                    String returnValue = null;
                    String date = sdf.format(c.getTime());
                    returnValue = date;
                    System.out.println("***** Date ***" + returnValue);
                    Assert.assertTrue(claimsRepudiationPageObj.verifyTxtRepudiationDetails(returnValue).isDisplayed());
                    System.out.println("Detail " + reason.get(i) + " is validated");
                } else if (reason.get(0).equalsIgnoreCase("Unreported Loss or Theft") ||
                        reason.get(0).equalsIgnoreCase("No Proof of Ownership") ||
                        reason.get(0).equalsIgnoreCase("No Proof of Expenditure")) {
                    System.out.println("Detail " + reason.get(1) + " is validated");
                    Assert.assertTrue(claimsRepudiationPageObj.verifyTxtRepudiationDetails(reason.get(1).trim()).isDisplayed());
                    System.out.println("Detail " + reason.get(1) + " is validated");
                    System.out.println("Detail " + reason.get(2) + " is validated");
                    Assert.assertTrue(claimsRepudiationPageObj.verifyTxtRepudiationDetails(reason.get(2).trim()).isDisplayed());
                    System.out.println("Detail " + reason.get(2) + " is validated");
                } else {
                    System.out.println("Reason " + reason.get(i));
                    Assert.assertTrue(claimsRepudiationPageObj.verifyTxtRepudiationDetails(reason.get(i).trim()).isDisplayed());
                    System.out.println("Detail " + reason.get(i) + " is validated");
                }
            }
        }
    }

    @And("^Validate the system will not allow the payment to be made$")
    public void validateTheSystemWillNotAllowThePaymentToBeMade(List<String> parameter) {
        //Assert.assertTrue(claimSummaryPageObj.txtPaymentRestriction(parameter.get(0).trim(),parameter.get(1).trim()).isDisplayed());
        //System.out.println("Restriction message is "+claimSummaryPageObj.txtPaymentRestriction(parameter.get(0).trim(),parameter.get(1).trim()));
    }

    @Then("^Validate the list of Repudiation reasons for the claim$")
    public void validateTheListOfRepudiationReasonsForTheClaim(List<String> parameters) {
        claimsRepudiationOperationsObj.validateTheRepudiationReasonList(parameters);
    }

    @And("^Validate the system must not possible to proceed any further with the claim$")
    public void validateTheSystemMustNotPossibleToProceedAnyFurtherWithTheClaim() {
        Assert.assertTrue(claimSummaryPageObj.btnSelectionOfOOPEvent().isDisplayed());
    }

    @And("^I should be able to enter the claim details for '(.+)'$")
    public void iShouldBeAbleToEnterTheClaimDetailsForRepudiation(String claim, List<List<String>> parameters) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.navigateToClaimViewFromPolicyView();
        nextEventPageObj.btnClick(claimSummaryPageObj.newClaim());
        claimID = basicClaimDetObj.getFirstClaim().getText();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimID = nextEventPageObj.firstClaimID().getText();
        System.out.println("Claim ID2" + claimID);
        try {
            if (nextEventPageObj.goDisplayed()) {
                nextEventPageObj.go().click();
            }
        } catch (org.openqa.selenium.WebDriverException ex) {
            if (nextEventPageObj.loadingPage()) {
                if (nextEventPageObj.goDisplayed()) {
                    nextEventPageObj.go().click();
                }
            }
        }
        nextEventPageObj.waitForMoreTime();
        claimCreationObj.createPartialOnlineClaim(claim, parameters);
        claimCreationObj.enterPartialClaimDetails(claim, parameters);
    }

    @And("^I should be able to click on '(.+)' button and validate the purchased details$")
    public void iShouldBeAbleToClickOnCardButtonAndValidateThePurchasedDetails(String action) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.clickingUnderNextEventsAndButtons(action);
    }

    @And("^I should be able to verify the claim tasks created under '(.+)' tab$")
    public void iShouldBeAbleToVerifyTheClaimTasksCreatedUnderClaimTasksTab(String tabName) {
        claimOperationObj.verifyingReferredClaim(tabName);
    }

    @And("^I should be able to click on save the payment$")
    public void iShouldBeAbleToClickOnSaveThePayment() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimPaymentPageObj.savePaymentBtn().click();
    }

    @And("^I should be able to create a claim$")
    public void iShouldBeAbleToCreateAClaim() {
        perfSerachObj.retreiveFirstClientRecord();
        claimOperationObj.navigateToClaimViewFromPolicyView();
        nextEventPageObj.btnClick(claimSummaryPageObj.newClaim());
    }

    @And("^I shoud allow to navigate to the base policy$")
    public void iShoudAllowToNavigateToTheBasePolicy() throws Throwable {
        claimOperationObj.navigateToBasePolicyFromPurchasesTab();
    }

    @And("^I should be able to retrieve claim details such as '(.+)'$")
    public void iShouldBeAbleToRetrieveClaimDetailsSuchAs(String claimDetails) throws Throwable {
        claimOperationObj.getClaimDetails(claimDetails);
    }

    @And("^I should be able to enter free text '(.+)' for further information$")
    public void iShouldBeAbleToEnterFreeTextForFurtherInformation(String text) throws Throwable {
        claimOperationObj.enterFreeText(text);
    }

    @And("^I should allow to capture the Supplier type for the country '(.+)'$")
    public void iShouldAllowToCaptureTheSupplierTypeForTheCountryFrance(String countryName) throws Throwable {
        claimOperationObj.captureSupplierType(countryName);
    }

    @And("^I should be able to navigate to inside TMA claim$")
    public void iShouldBeAbleToNavigateToInsideTMAClaim() throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        tmaDetailsPageObj.lnkTMAClaim().click();
        nextEventPageObj.waitForPageLoad();
    }

    @And("^validate that TMA user must be able to add Reserve values for '(.+)'$")
    public void validateThatTMAUserMustBeAbleToAddReserveValuesForReserveType(String Reserve, List<List<String>> parameters) throws Throwable {
        claimOperationObj.validateDefaultReserve(Reserve, parameters);
    }

    @And("^I should be able to store the claim Handlers-TMA$")
    public void iShouldBeAbleToStoreTheClaimHandlersTMA() throws Throwable {
        navigationObj.txtClaimHandlersTMA();
    }

    @And("^I should be able to allocate the TMA claim '(.+)' to the handler$")
    public void iShouldBeAbleToAllocateTheTMAClaimClaimIdToTheHandler(String claimID) throws Throwable {
        navigationObj.allocateClaim(claimID);
    }

    @And("^I should be able to '(.+)' the '(.+)' claim '(.+)' to the '(.+)' named '(.+)' allocation$")
    public void iShouldBeAbleToAllocateTheTMAClaimClaimIdToTMAHandler(String allocation,String claimType,String claimID, String hanlderType,String handler) throws Throwable {
        navigationObj.allocateClaimToHandler(allocation,claimID, handler);
    }

    @And("^I should be able to store the Assignee names and compare with Claim Handlers-TMA$")
    public void iShouldBeAbleToStoreTheAssigneeNamesAndCompareWithClaimHandlersTMA() throws Throwable {
        navigationObj.validateAssigneewithClaimHandlersTMA();
    }

    @And("^I should be able to assignee the claim to handler and also validate that claim in '(.+)' level$")
    public void iShouldBeAbleToAssigneeToHandlerAndAlsoValidateThatClaimInAssigneeLevel(String user) throws Throwable {
        navigationObj.validateClaimAtAssigneeLevel(user);
    }

    @And("^I should be able to verify the payment is on hold under financial tab$")
    public void iShouldBeAbleToVerifyThePaymentIsOnHoldUnderFinancialTab() {
        claimOperationObj.verifyPaymentIsOnHold();
    }

    @And("^I should allow to enter passport details for air ambulance$")
    public void iShouldAllowToEnterPassportDetailsForAirAmbulance(List<List<String>> parameters) {
        tmaDetailsObj.enterTMAPassportandTransferDetails(parameters);
    }

    @And("^I should be able to provide arranging transfers$")
    public void iShouldBeAbleToProvideArrangingTransfers(List<List<String>> parameters) {
        tmaDetailsObj.enterTMAPassportandTransferDetails(parameters);
    }

    @And("^I should be able to navigate to TMA processing advice$")
    public void iShouldBeAbleToNavigateToTMAProcessingAdvice() throws Throwable {
        claimsRepudiationOperationsObj.validateTMAProcessingAdvice();
    }

    @And("^BAU Processing is initiated$")
    public void bauProcessingIsInitiated() {
        System.out.println("BAU process initiated");
    }

    @And("^I should be able to provide value for Repudiation letter$")
    public void iShouldBeAbleToProvideValueForRepudiationLetter(List<List<String>> parameters) throws Throwable {
        claimsOperationsObj.valueForRepudiationLetter(parameters);
    }

    @And("^I should allow to select the '(.+)' upgrades to cancel the cover$")
    public void I_should_allow_to_select_the_Business_Cover_upgrades_to_cancel_the_cover(String upgrade) {
        claimSummaryPageObj.selectUpgrade(upgrade);
        claimSummaryPageObj.selectUpgrade(upgrade).click();
//        List<WebElement> lst = nextEventPageObj.findElements(By.xpath(claimSummaryPageObj.selectUpgrades(upgrade)));
//        System.out.println("list size: " + lst.size());
//        lst.get(1).click();
    }

    @Then("^I must be able to capture multiple peril details for each person to each claim type$")
    public void iMustBeAbleToCaptureMultiplePerilDetailsForEachPersonToEachClaimType(List<List<String>> parameters) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        //   claimOperationObj.validateClaimCause(clmCause, andSave, newParameters);
        claimOperationObj.validateAdditionalPerilsWithClaim(parameters);
    }

    @And("^I should be able to create a claim using API$")
    public void iShouldBeAbleToCreateAClaimUsingAPI(List<List<String>> claimValue) throws Throwable {
        ttapiOperationsObj.gettingClaimConfig(claimValue);
        ttapiOperationsObj.getPersonID();
        ttapiOperationsObj.createClaimUsingAPI(claimValue);
    }

    @And("^I should be able to select the Letter type as '(.+)'$")
    public void iShouldBeAbleToSelectTheLetterTypeAs(String LetterType) throws Throwable {
        claimOperationObj.selectLetterType(LetterType);
    }

    @And("^I should be able to select the repudiation reason as '(.+)'$")
    public void iShouldBeAbleToSelectTheRepudiationReasonAsCustomerHasIncorrectAccount(String reason) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimsRepudiationPageObj.Reasonbtn().click();
        claimsRepudiationPageObj.Reasondropdown().click();
        new Select(claimsRepudiationPageObj.Reasondropdown()).selectByVisibleText(reason);
        System.out.println("^^^^^^^^^^^^^^^^^^^^Save btn");
        claimsRepudiationPageObj.save().click();
        System.out.println("^^^^^^^^^^^^^^^^^^^^Save btnnnnnnnnnnnnn");
    }

    @And("^Claim moved to BAU Process$")
    public void claimMovedToBAUProcess() throws Throwable {
        System.out.println("Claim moved to BAU Process");
    }

    @And("^I should to able to get the excess value for below peril$")
    public void iShouldToAbleToGetTheExcessValueForBelowPeril(List<List<String>> perilDetails) {
        claimOperationObj.gettingExcessValue(perilDetails);
    }

    @And("^I should be validate the excess value deducted$")
    public void iShouldBeValidateTheExcessValueDeducted() {
        claimOperationObj.validatingExcessValue();
    }


    @And("^I should be able to fill the Mandatory questions below using API$")
    public void iShouldBeAbleToFillTheMandatoryQuestionsBelowUsingAPI(List<List<String>> perilQuestions) throws Throwable {
        ttapiOperationsObj.mappingPerilQuestions(perilQuestions);
        ttapiOperationsObj.selectCreatedClaim();
    }

    @And("^verify the excess amount deducted in AQ$")
    public void verifyTheExcessAmountDeductedInAQ(List<List<String>> excessValue) throws Throwable {
        claimsOperationsObj.verifyExcessValue(excessValue);
    }

    @And("^I should be able to save Claim Specific Questions in AQ$")
    public void I_should_be_able_to_save_Claim_Specific_QuestionsInAQ(List<List<String>> perilQuestions) throws Throwable {
        System.out.println("peril-----------save----" + strEventType);
        navigationObj.navigateToNextEventType("Claim Specific Questions");
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        claimsOperationsObj.answerPerilQuestions(perilQuestions);
    }

    @And("^verify outcome should be '(.+)'$")
    public void verify_outcome_should_be(String outcome) {
        claimsOperationsObj.verifyOutcome(outcome);
        try {
            claimsRepudiationPageObj.next().click();
        } catch (Exception e) {
            claimsRepudiationPageObj.btnClick(claimsRepudiationPageObj.next());
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
//        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
//        try {
//            policyDataFieldsPageObj.perilQuesSave().click();
//        } catch (Exception e) {
//            nextEventPageObj.btnClick(policyDataFieldsPageObj.perilQuesSave());
//        }
        nextEventPageObj.waitForMoreTime();
    }

    @And("^I navigate to new Questions CR21 for verifying answers$")
    public void I_navigate_to_new_Questions_CR21_for_verifying_answers(List<List<String>> ques) {
        getDriver().navigate().refresh();
        commandsObj.waitForLoad(getDriver());
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
        try {
            nextEventPageObj.btnClick(nextEventPageObj.go());
        } catch (Exception exe) {
            nextEventPageObj.btnClick(nextEventPageObj.go());
        }
        commandsObj.waitForLoad(getDriver());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        navigationObj.navigateToNextEventType("Claim Specific Questions");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        claimsOperationsObj.comparePerilQuestionsAndAnswers(ques);
    }

    @And("^I navigate to Recovery oppurtunity questions$")
    public void I_navigate_to_Recovery_oppurtunity_questions(List<List<String>> ques) {
        claimsOperationsObj.answerPerilQuestions(ques);
    }

    @Then("^Aquarium should ask the following peril questions items to the customer$")
    public void aquariumShouldAskTheFollowingPerilQuestionsItemsToTheCustomer(List<List<String>> perilQuestions) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
//        nextEventPageObj.switchToDefault();
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        claimOperationObj.cr21PerilQuestionsItems(perilQuestions);
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
//        perilQuestionsPageObj.btnClick(perilQuestionsPageObj.perilQuestionSaveBtn());  //Commented by Sony---Savebutton is not displaying now
//        nextEventPageObj.switchToDefault();
    }

    @And("^I should be able to select the claim$")
    public void iShouldBeAbleToSelectTheClaim() throws Throwable {
        ttapiOperationsObj.selectCreatedClaim();
    }

    @And("^I should be able to save the answers$")
    public void iShouldBeAbleToSaveTheAnswers() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        claimsRepudiationPageObj.btnClick(claimsRepudiationPageObj.next());

        nextEventPageObj.waitForMoreTime();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // claimsRepudiationPageObj.next().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
//            policyDataFieldsPageObj.perilQuesSave().click();
        nextEventPageObj.waitForMoreTime();
    }

    @And("^I should be able to enter the following Claims level correspondence details$")
    public void iShouldBeAbleToEnterTheFollowingClaimsLevelCorrespondenceDetails(List<List<String>> lstInput) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.enterClaimsLevelCorrespondenceDetails(lstInput);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.policySave().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    @And("^I should be able to select the claimId$")
    public void iShouldBeAbleToSelectTheClaimId() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        nextEventPageObj.getDriver.findElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_grdClaims_ctl02_lnkPerils")).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    @And("^I should allow to select the checkbox for '(.+)'$")
    public void I_should_allow_to_select_the_checkbox_for_customer_already_on_the_trip(String trip) {
        claimSummaryPageObj.customerAlreadyTrip().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    @And("^I should be able to save the Peril answers$")
    public void iShouldBeAbleToSaveThePerilAnswers() throws Throwable {
        try {
            claimsRepudiationPageObj.next().click();
        } catch (Exception e) {
            claimsRepudiationPageObj.btnClick(claimsRepudiationPageObj.next());
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
//        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
//        try {
//            policyDataFieldsPageObj.perilQuesSave().click();
//        } catch (Exception e) {
//            nextEventPageObj.btnClick(policyDataFieldsPageObj.perilQuesSave());
//        }
        nextEventPageObj.waitForMoreTime();
    }

    @And("^I should be able to enter free text '(.+)'$")
    public void iShouldBeAbleToEnterFreeTextTesting(String freetext) throws Throwable {
        nextEventPageObj.getDriver.findElement(By.xpath("//textarea[contains(@id,'ucMandatoryFieldEditor_txt304123')]")).sendKeys(freetext);
        nextEventPageObj.getDriver.findElement(By.xpath("//textarea[contains(@id,'ucMandatoryFieldEditor_txt304122')]")).sendKeys(freetext);
    }

    @And("^I should be able to enter free text as '(.+)'$")
    public void iShouldBeAbleToEnterFreeTextAsTest(String freetext) throws Throwable {
        nextEventPageObj.getDriver.findElement(By.xpath("//span[contains(@id,'ucMandatoryFieldEditor_lbl305305_55926135')]")).sendKeys(freetext);
    }

    @And("^I should be able to verify Perils and Costs details$")
    public void iShouldAbleToVerifyPerilCostDetails(List<List<String>> parameters) {
        claimOperationObj.validateClaimDetailsInPerilAndCoststab(parameters);
    }

    @And("^I should be able to validate the error message '(.+)'$")
    public void iShouldBeAbleToValidateTheErrorMessage(String text) throws Throwable {
        claimCreationObj.getErrorMessage(text);
        nextEventPageObj.getDriver.findElement(By.id("btnCancel")).click();

    }

    @And("^I should be able to validate '(.+)' details for '(.+)'$")
    public void iShouldBeAbleToValidateFinancialTableDetailsForScenarioName(String tabToView,String scenarioName) {
     String finanacialTableContentFromPropertyFile = commandsObj.readingFinancialTableValues(scenarioName);
     claimOperationObj.financialTableContentSplitupToValidateWithUI(tabToView,finanacialTableContentFromPropertyFile);
    }

    @And("^I should be able to enter the free text '(.+)'$")
    public void iShouldBeAbleToEnterTheFreeTextFinaltesting(String freetext) throws Throwable {
        nextEventPageObj.getDriver.findElement(By.xpath("//textarea[contains(@id,'ucMandatoryFieldEditor_txt304610')]")).sendKeys(freetext);
        nextEventPageObj.getDriver.findElement(By.xpath("//textarea[contains(@id,'ucMandatoryFieldEditor_txt304609')]")).sendKeys(freetext);
    }

    @Then("^I should be able to click on first claim button$")
    public void iShouldBeAbleToClickOnFirstClaimButton() throws Throwable {
        summaryViewObj.editclaim();
    }

    @And("^I should validate that the add person options are not available$")
    public void iShouldValidateThatTheAddPersonOptionsAreNotAvailable() {
        nextEventPageObj.btnClick(perilsAndCostsPageObj.addPerson());
        commandsObj.waitForLoad(getDriver());
        System.out.println("commandsObj.elementDisplayedWithLessTime(By.xpath(perilsAndCostsPageObj.validationofAddingNewPersonXpath()))------------"+commandsObj.elementDisplayedWithLessTime(By.xpath(perilsAndCostsPageObj.validationofAddingNewPersonXpath())));
        Assert.assertTrue(commandsObj.elementDisplayedWithLessTime(By.xpath(perilsAndCostsPageObj.validationofAddingNewPersonXpath())));
    }

    @And("^I should be able to wait for the document to get generated$")
    public void iShouldBeAbleToWaitForTheDocumentToGetGenerated() throws Throwable {
        Thread.sleep(900000);
    }

    @And("^I should be able to save the claim handler name$")
    public void iShouldBeAbleToSaveTheClaimHandlerName() throws Throwable {
        claimOperationObj.saveHandlerName();
    }

    @And("^I should be able to verify the claim handler assigned is same as previously assigned handler$")
    public void iShouldBeAbleToVerifyTheClaimHandlerAssignedIsSameAsPreviouslyAssignedHandler() throws Throwable {
        claimOperationObj.ValidateHandlerName();
    }

    @And("^validate the '(.+)' deadline is not in effect for the '(.+)'$")
    public void validateTheBasicDetailsCollectionsDeadlineIsNotInEffectForTheClaimID(String deadline, String claimID) throws Throwable {
        claimOperationObj.validateToolTipOfDashBoard(deadline, claimID);
    }

    @And("^I should be able to get the claim Id$")
    public void iShouldBeAbleToGetTheClaimId() throws Throwable {
        claimOperationObj.retrieveClaimId();
    }

    @And("^I should allow to manually allocate the TMAClaim to ClaimHandler '(.+)'$")
    public void iShouldAllowToManuallyAllocateTheTMAClaimToClaimHandlerClaimHandler(String claimHandler) throws Throwable {
        claimOperationObj.allocationOfTMAClaimToClaimHandlerManually(claimHandler);
    }

    @And("^validate the TMAclaimID is listed under the DashBoard$")
    public void validateTheTMAclaimIDIsListedUnderTheDashBoard() throws Throwable {
        claimOperationObj.validateTMAClaimListedUnderDashBoard();
    }

    @And("^I have to validate The SLA is in '(.+)' color for '(.+)'$")
    public void iHaveToValidateTheSLAIsInGreenColorForTMAclaimId(String color, String claimId) throws Throwable {
        claimOperationObj.validateSLAColoring(color,claimId);
    }

    @And("^I should be able to send notification to customer$")
    public void iShouldBeAbleToSendNotificationToCustomer() {
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        claimPaymentPageObj.saveInPaymentMethod().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        nextEventPageObj.recipientToMail().sendKeys("abc@example.com");
        nextEventPageObj.btnClick(nextEventPageObj.createAndSendEmail());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }


    @And("^I should be able to navigate on '(.+)' button for '(.+)' times$")
    public void iShouldBeAbleToNavigateOnNextButtonForTimes(String action, int times) throws Throwable {
            System.out.println("No of times for Navigating NEXT BUTTON----" + times);
            for (int i = 0; i <= times; i++) {
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                try {
                    quoteDetailsPageObj.btnClick(quoteDetailsPageObj.nextButton());
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                } catch (Exception e) {
                    quoteDetailsPageObj.nextButton().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                }
            }
        }

    }




