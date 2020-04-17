package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.ClaimPaymentPage;
import co.uk.directlinegroup.tt.pages.CommonPage;
import co.uk.directlinegroup.tt.pages.FullEventHistoryPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.ClaimsOperations;
import com.usmanhussain.habanero.framework.AbstractPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import java.util.List;

public class ClaimsPaymentNotification extends BaseStepDef {

    private FullEventHistoryPage fullEventHistoryPageObj = new FullEventHistoryPage();
    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private ClaimPaymentPage claimPaymentPageObj = new ClaimPaymentPage();
    private ClaimsOperations claimOperationObj = new ClaimsOperations();
    private CommonPage commonPage = new CommonPage();
    private AbstractPage abstractPageObj = new AbstractPage() {
        @Override
        public void switchToWindowByIndex(int iWindowIndex) {
            super.switchToWindowByIndex(iWindowIndex);
        }
    };

    private NextEventPage nextEventPageObj = new NextEventPage();

    @When("^The claim payment has been authorised$")
    public void the_claim_payment_has_been_authorised() throws Throwable {
        throw new PendingException();
    }

    @And("^I should be able to set '(.+)' for customer$")
    public void iShouldBeAbleToSetCommPreferenceForCustomer(String preference, List<List<String>> parameter) {
        fullEventHistoryPageObj.btnClick(fullEventHistoryPageObj.moreDetailsBtn());
        fullEventHistoryPageObj.btnClick(fullEventHistoryPageObj.commPreferenceTab(preference));
        fullEventHistoryPageObj.btnClick(fullEventHistoryPageObj.commPreference());
        fullEventHistoryPageObj.btnClick(fullEventHistoryPageObj.commPreferenceValue(parameter.get(1).get(0)));
        fullEventHistoryPageObj.btnClick(fullEventHistoryPageObj.saveAndCloseBtn());

    }

    @Then("^The system should send an SMS notification to the policyholder informing them of the settlement$")
    public void the_system_should_send_an_sms_notification_to_the_policyholder_informing_them_of_the_settlement() {
        try {
            Thread.sleep(60000L);
            getDriver().navigate().refresh();
            fullEventHistoryPageObj.showFullEventHistory().click();
            abstractPageObj.switchToLastOpenWindow();
            //  getDriver().manage().window().maximize();
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            Assert.assertTrue(fullEventHistoryPageObj.payUpdateClaimSMS().isDisplayed());
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
        } catch (Exception e) {
            e.printStackTrace();
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
        }


    }

    @And("^Customer selected communication channel as \"([^\"]*)\"$")
    public void customer_selected_communication_channel_as_something(String strArg1) {
        throw new PendingException();
    }

    @And("^Create a claim with approved status$")
    public void create_a_claim_with_approved_status() {
        throw new PendingException();
    }

    @And("^Select the Claim Payment$")
    public void select_the_claim_payment() {
        throw new PendingException();
    }

    @And("^The SMS should contain the following information$")
    public void the_sms_should_contain_the_following_information(List<List<String>> message) {
        Assert.assertTrue(fullEventHistoryPageObj.messageContent().isDisplayed());
        throw new PendingException();
    }

    @Then("^The system should email the policyholder notification of the settlement with a URL linking them to their portal account$")
    public void the_system_should_email_the_policyholder_notification_of_the_settlement_with_a_url_linking_them_to_their_portal_account() {
        try {
            Thread.sleep(20000L);
            getDriver().navigate().refresh();
            fullEventHistoryPageObj.showFullEventHistory().click();
            nextEventPageObj.switchToLastOpenWindow();
            //getDriver().manage().window().maximize();
            Assert.assertTrue(fullEventHistoryPageObj.claimPaymentEmail().isDisplayed());
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            fullEventHistoryPageObj.previewOfEmailLink().click();
            commonPage.switchToFrameById(commonPage.fancyFrame());
            Assert.assertTrue(fullEventHistoryPageObj.insidePreviewOfEmailURL().isDisplayed());
            nextEventPageObj.waitForMoreTime();
            System.out.println("Sclose btn displayed ----------------------------" + fullEventHistoryPageObj.previewEmailCloseBtn().isDisplayed());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
//            fullEventHistoryPageObj.previewEmailCloseBtn().click();
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
        } catch (InterruptedException e) {
            e.printStackTrace();
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
        }
    }

    @And("^Details of the settlement letter should be stored on the system$")
    public void details_of_the_settlement_letter_should_be_stored_on_the_system() {
        fullEventHistoryPageObj.showFullEventHistory().click();
        nextEventPageObj.switchToLastOpenWindow();
        //getDriver().manage().window().maximize();
        try {
            Assert.assertTrue(fullEventHistoryPageObj.settlementLetter().isDisplayed());
            Assert.assertTrue(fullEventHistoryPageObj.settlementLetterPDF().isEnabled());
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
        } catch (Exception e) {
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
        }
        // getDriver().manage().window().maximize();
    }

    @Then("^The system should create a settlement letter on the system for later dispatch to the print fulfilment house$")
    public void the_system_should_create_a_settlement_letter_on_the_system_for_later_dispatch_to_the_print_fulfilment_house() {
        try {
            Thread.sleep(20000L);
            getDriver().navigate().refresh();
            fullEventHistoryPageObj.showFullEventHistory().click();
            nextEventPageObj.switchToWindowByIndex(2);
            //getDriver().manage().window().maximize();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            fullEventHistoryPageObj.settlementLetterPDF().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
//            int fileSize = (int) claimsOperationsObj.fileSize();
//            System.out.println("file size----------------------------" + fileSize);
//            Assert.assertTrue(fileSize > 0);
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
            // getDriver().manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
        }


    }

    @And("^The claim settlement is to a \"([^\"]*)\"$")
    public void the_claim_settlement_is_to_a_something(String strArg1) {
        throw new PendingException();
    }

    @Then("^The system should create a settlement email$")
    public void the_system_should_create_a_settlement_email() {
        Assert.assertTrue(fullEventHistoryPageObj.supplierEmail().isDisplayed());
        Assert.assertTrue(fullEventHistoryPageObj.supplierEmailStatus().isDisplayed());
        throw new PendingException();
    }

    @And("^The System should Send the email to Supplier$")
    public void the_system_should_send_the_email_to_supplier() {
        throw new PendingException();
    }


    @And("^The system should email the policyholder notification of the settlement with a URL$")
    public void systemShouldSendEmailNotificationAlongWithURL() {

        Assert.assertTrue(fullEventHistoryPageObj.claimPaymentEmail().isDisplayed());
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("preview email -------------------------------" + fullEventHistoryPageObj.previewEmailLink().isDisplayed());
        fullEventHistoryPageObj.previewEmailLink().click();
        commonPage.switchToFrameById(commonPage.fancyFrame());
        Assert.assertTrue(fullEventHistoryPageObj.insidePreviewEmailURL().isDisplayed());
        nextEventPageObj.waitForMoreTime();
        System.out.println("Sclose btn displayed ----------------------------" + fullEventHistoryPageObj.previewEmailCloseBtn().isDisplayed());
        fullEventHistoryPageObj.previewEmailCloseBtn().click();
    }

    @And("^System should store the settlement letter$")
    public void systemShouldStoreTheSettlementLetter() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        Assert.assertTrue(fullEventHistoryPageObj.settlementLetter().isDisplayed());
        Assert.assertTrue(fullEventHistoryPageObj.settlementLetterPDF().isEnabled());
        fullEventHistoryPageObj.settlementLetterPDF().click();
        //To Check whether downloaded file size is greater than 0
        int size = 0;
        /*try {
            size = (int) claimsOperationsObj.fileSize();
            System.out.println("file size----------------------------" + size);
            Assert.assertTrue(size > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    @Then("^I should be able to verify that the system stored the settlement letter$")
    public void iShouldBeAbleToVerifyThatTheSystemStoredTheSettlementLetter() {
        getDriver().navigate().refresh();
        fullEventHistoryPageObj.showFullEventHistory().click();
//        nextEventPageObj.switchToWindowByIndex(2);
        nextEventPageObj.switchToLastOpenWindow();
        //getDriver().manage().window().maximize();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(fullEventHistoryPageObj.settlementLetter().isDisplayed());
        Assert.assertTrue(fullEventHistoryPageObj.settlementLetterPDF().isEnabled());
        fullEventHistoryPageObj.settlementLetterPDF().click();
        //To Check whether downloaded file size is greater than 0
        long fileSize = 0;
        try {
            fileSize = claimsOperationsObj.fileSize();
            System.out.println("file size----------------------------" + claimsOperationsObj.fileSize());
            Assert.assertTrue(fileSize > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @And("^System should store the remittance Advice$")
    public void systemShouldStoreTheRemittanceAdvice() {
        getDriver().navigate().refresh();
        fullEventHistoryPageObj.showFullEventHistory().click();
        nextEventPageObj.switchToWindowByIndex(2);
        // getDriver().manage().window().maximize();
        Assert.assertTrue(fullEventHistoryPageObj.generateRemittanceAdvice().isDisplayed());
        Assert.assertTrue(fullEventHistoryPageObj.generateRemittanceAdvicePDF().isEnabled());
        fullEventHistoryPageObj.generateRemittanceAdvicePDF().click();
        //To Check whether downloaded file size is greater than 0
        long fileSize = 0;
        try {
            fileSize = claimsOperationsObj.fileSize();
            System.out.println("file size----------------------------" + fileSize);
            Assert.assertTrue(fileSize > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @And("^System should generate '(.+)' event and remittance Advice$")
    public void systemShouldGenerateEnterBankDetailsEventAndRemittanceAdvice(String event) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        fullEventHistoryPageObj.showFullEventHistory().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToLastOpenWindow();
        //nextEventPageObj.switchToWindowByIndex(2);
        getDriver().navigate().refresh();
        //  getDriver().manage().window().maximize();
        //To check the 'Enter Bank details' event
        Assert.assertTrue(event.equalsIgnoreCase(nextEventPageObj.recoveryEventInEventHistory(event).getText()));
        Assert.assertTrue(fullEventHistoryPageObj.generateRemittanceAdvice().isDisplayed());
        Assert.assertTrue(fullEventHistoryPageObj.generateRemittanceAdvicePDF().isEnabled());
        fullEventHistoryPageObj.generateRemittanceAdvicePDF().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        //To Check whether downloaded file size is greater than 0
        long fileSize = 0;
        try {
            fileSize = claimsOperationsObj.fileSize();
            System.out.println("file size----------------------------" + fileSize);
            Assert.assertTrue(fileSize > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @And("^I should be able to view the payment mail along with the paid amount '(.+)'$")
    public void iShouldBeAbleToViewThePaymentMailAlongWithThePaidAmount(String amountInMail) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        Assert.assertTrue(fullEventHistoryPageObj.claimPaymentEmail().isDisplayed());
        claimPaymentPageObj.previewEmail().click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        String amt = claimPaymentPageObj.amountInPreview().getText();
        System.out.println("Amoubt in mail-------------------------" + amt);
        Assert.assertTrue(amountInMail.equalsIgnoreCase(amt));
        nextEventPageObj.waitForMoreTime();
        claimPaymentPageObj.previewEmailCloseBtn().click();
        nextEventPageObj.switchToDefault();
    }


    @And("^I should be able to verify that the system stored the '(.+)'$")
    public void iShouldBeAbleToVerifyThatTheSystemStoredTheCustomerLOAFormEmailSupplierLOAFormEmail(String doc) throws Throwable {
        //Sujeetha - commmented filesize calculation as the file saving location are not known in Jenkins tis steps will not work for Jenkins
        getDriver().navigate().refresh();
        nextEventPageObj.btnClick(fullEventHistoryPageObj.showFullEventHistory());
        //fullEventHistoryPageObj.showFullEventHistory().click();
        //nextEventPageObj.switchToWindowByIndex(2);
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToLastOpenWindow();
        // getDriver().manage().window().maximize();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        String[] docs = doc.split("#");
        for (int i = 0; i < docs.length; i++) {
            // System.out.println("docs length"

            if (docs[i].contains("Customer LOA Form | Email")) {
                System.out.println("Customer LOA Form | Email");
                Assert.assertTrue(fullEventHistoryPageObj.customerLOAFormEmail().isDisplayed());
                Assert.assertTrue(fullEventHistoryPageObj.customerLOAFormEmailDoc().isEnabled());
                fullEventHistoryPageObj.customerLOAFormEmailDoc().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
//                claimsOperationsObj.calculateFileSize();
            } else if (docs[i].contains("Hospital LOA Form | Email")) {
                System.out.println("Supplier LOA Form | Email");
                Assert.assertTrue(fullEventHistoryPageObj.supplierLOAFormEmail().isDisplayed());
                Assert.assertTrue(fullEventHistoryPageObj.supplierLOAFormEmailDoc().isEnabled());
                fullEventHistoryPageObj.supplierLOAFormEmailDoc().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
//                claimsOperationsObj.calculateFileSize();
            } else if (docs[i].contains("Next of Kin LOA Form | Email")) {
                System.out.println("Supplier LOA Form | Email");
                Assert.assertTrue(fullEventHistoryPageObj.supplierLOAFormEmail().isDisplayed());
                Assert.assertTrue(fullEventHistoryPageObj.supplierLOAFormEmailDoc().isEnabled());
                fullEventHistoryPageObj.supplierLOAFormEmailDoc().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
//                claimsOperationsObj.calculateFileSize();
            } else if (docs[i].equalsIgnoreCase("Hospital LOA Form Generated")) {
                System.out.println("Supplier LOA Form Generated");
                Assert.assertTrue(fullEventHistoryPageObj.formGenerated(docs[i]).isDisplayed());
                Assert.assertTrue(fullEventHistoryPageObj.formGeneratedDoc(docs[i]).isEnabled());
                fullEventHistoryPageObj.formGeneratedDoc(docs[i]).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
//                claimsOperationsObj.calculateFileSize();
            } else if (docs[i].contains("Customer LOA Form Generated")) {
                System.out.println("Customer LOA Form Generated");
                Assert.assertTrue(fullEventHistoryPageObj.formGenerated(docs[i]).isDisplayed());
                Assert.assertTrue(fullEventHistoryPageObj.formGeneratedDoc(docs[i]).isEnabled());
                fullEventHistoryPageObj.formGeneratedDoc(docs[i]).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
//                claimsOperationsObj.calculateFileSize();
            } else if (docs[i].contains("Next of Kin LOA Form Generated")) {
                System.out.println("Next of Kin LOA Form Generated");
                Assert.assertTrue(fullEventHistoryPageObj.formGenerated(docs[i]).isDisplayed());
                Assert.assertTrue(fullEventHistoryPageObj.formGeneratedDoc(docs[i]).isEnabled());
                fullEventHistoryPageObj.formGeneratedDoc(docs[i]).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimsOperationsObj.calculateFileSize();
            } else if (docs[i].contains("Next of Kin Access to Medical Request Generated")) {
                System.out.println("Next of Kin Access to Medical Request Generated");
                Assert.assertTrue(fullEventHistoryPageObj.formGenerated(docs[i]).isDisplayed());
                Assert.assertTrue(fullEventHistoryPageObj.formGeneratedDoc(docs[i]).isEnabled());
                fullEventHistoryPageObj.formGeneratedDoc(docs[i]).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
//                claimsOperationsObj.calculateFileSize();
            } else if (docs[i].contains("Customer Access to Medical Info Request Generated")) {
                System.out.println("Customer Access to Medical Info Request Generated");
                Assert.assertTrue(fullEventHistoryPageObj.formGenerated(docs[i]).isDisplayed());
                Assert.assertTrue(fullEventHistoryPageObj.formGeneratedDoc(docs[i]).isEnabled());
                fullEventHistoryPageObj.formGeneratedDoc(docs[i]).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimsOperationsObj.calculateFileSize();
            } else if (docs[i].equalsIgnoreCase("Supplier Access to Medical Info Request Generated")) {
                System.out.println("Supplier Access to Medical Info Request Generated");
                Assert.assertTrue(fullEventHistoryPageObj.formGenerated(docs[i]).isDisplayed());
                Assert.assertTrue(fullEventHistoryPageObj.formGeneratedDoc(docs[i]).isEnabled());
                fullEventHistoryPageObj.formGeneratedDoc(docs[i]).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
//                claimsOperationsObj.calculateFileSize();
            } else if (docs[i].contains("Next of Kin Access to Medical Request | Email")) {
                System.out.println("Supplier Access to Medical Info Request Generated");
                Assert.assertTrue(fullEventHistoryPageObj.formGenerated(docs[i]).isDisplayed());
                Assert.assertTrue(fullEventHistoryPageObj.formGeneratedDoc(docs[i]).isEnabled());
                fullEventHistoryPageObj.formGeneratedDoc(docs[i]).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
//                claimsOperationsObj.calculateFileSize();
            } else if (docs[i].contains("Customer Access to Medical Info Request | Email")) {
                System.out.println("Supplier Access to Medical Info Request Generated");
                Assert.assertTrue(fullEventHistoryPageObj.formGenerated(docs[i]).isDisplayed());
                // Assert.assertTrue(fullEventHistoryPageObj.formGeneratedDoc(docs[i]).isEnabled());
                //  fullEventHistoryPageObj.formGeneratedDoc(docs[i]).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimsOperationsObj.calculateFileSize();
            } else if (docs[i].contains("Hospital Access to Medical Info Request | Email")) {
                System.out.println("Supplier Access to Medical Info Request Generated");
                Assert.assertTrue(fullEventHistoryPageObj.formGenerated(docs[i]).isDisplayed());
                Assert.assertTrue(fullEventHistoryPageObj.formGeneratedDoc(docs[i]).isEnabled());
                fullEventHistoryPageObj.formGeneratedDoc(docs[i]).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
//                claimsOperationsObj.calculateFileSize();
            }


        }
        nextEventPageObj.btnClick(fullEventHistoryPageObj.eventHistoryCloseWindow());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToLastOpenWindow();
        //nextEventPageObj.switchToDefault();
        // fullEventHistoryPageObj.eventHistory_overcome().click();
        // fullEventHistoryPageObj.eventHistoryCloseWindow().click();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        System.out.println("to overcome");
        //fullEventHistoryPageObj.eventHistory_overcome().click();


    }


    @And("^I should be verify the notification sent to the customer with the calculated amount paid '(.+)'$")
    public void iShouldBeVerifyTheNotificationSentToTheCustomerWithTheAmountPaid(String amountPaid) {
        try {
            getDriver().navigate().refresh();
            fullEventHistoryPageObj.showFullEventHistory().click();
            abstractPageObj.switchToLastOpenWindow();
            // getDriver().manage().window().maximize();
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            Assert.assertTrue(fullEventHistoryPageObj.claimPaymentEmail().isDisplayed());
//            claimPaymentPageObj.previewEmail().click();
//            nextEventPageObj.switchToDefault();
//            nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
            // String amt = claimPaymentPageObj.amountInPreview().getText();
            // System.out.println("Amoubt in mail-------------------------" + amt);
            //  Assert.assertTrue(amountPaid.equalsIgnoreCase(amt));
//            nextEventPageObj.waitForMoreTime();
//            claimPaymentPageObj.previewEmailCloseBtn().click();
//            nextEventPageObj.switchToDefault();
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
        } catch (Exception e) {
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
        }

    }

    @And("^System should store the Non UK Address residency confirmed letter$")
    public void systemShouldStoreTheNonUKAddressResidencyConfirmedLetter() throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        Assert.assertTrue(fullEventHistoryPageObj.txtNonUKResidencyConfirmed().isDisplayed());
        Assert.assertTrue(fullEventHistoryPageObj.docNonUKResidencyConfirmedLetter().isEnabled());
        fullEventHistoryPageObj.docNonUKResidencyConfirmedLetter().click();
        //To Check whether downloaded file size is greater than 0
        int size = 0;
      /*  try {
            size = (int) claimsOperationsObj.fileSize();
            System.out.println("file size----------------------------" + size);
            Assert.assertTrue(size > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    @And("^I should be able to Download and Store '(.+)'$")
    public void iShouldBeAbleToDownloadAndStoreFNOLDocPack(String DocName){
        try {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            Thread.sleep(300000);
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            claimsOperationsObj.clickingUnderNextEventsAndButtons("show full event history");
//        if(DocName.equals("DOC PACK (SYSTEM) - New Business Acceptance")|| DocName.equals("DOC PACK (SYSTEM) - Mid-term Amendment") || DocName.equals("Third Party Card Receipt | Letter") || DocName.equals("DOC PACK (SYSTEM) - Renewal Invitation")
//                || DocName.equals("DOC PACK (SYSTEM) - Renewal Acceptance") || DocName.equals("Contact Customer Resolve DD Failure | Letter" ) ||  DocName.equals("Portal Registration Letter" )||DocName.equals("New Quote Confirmation | Letter")||DocName.equals("Product Cancelled Letter") || DocName.equals("LETTER (SYSTEM) 14 day renewal reminder")
//                || DocName.equals("LETTER (SYSTEM) - Age Extension Required")||DocName.equals("LETTER (SYSTEM) Child aged 18")|| DocName.equals("AVA Cancelled Letter")){
//
//            System.out.println("Inside Policy Documents");
//            Assert.assertTrue(fullEventHistoryPageObj.documentLetterPDF_TravelPolicy(DocName).isEnabled());
//            fullEventHistoryPageObj.documentLetterPDF_TravelPolicy(DocName).click();
//            System.out.println("Policy Document is downloaded " +DocName);
//        }
//        else {
//            claimsOperationsObj.clickingUnderNextEventsAndButtons("show full event history");
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            Assert.assertTrue(fullEventHistoryPageObj.documentLetters(DocName).isDisplayed());
            System.out.println("Inside Documents");
            Assert.assertTrue(fullEventHistoryPageObj.documentLetterPDF(DocName).isEnabled());
            fullEventHistoryPageObj.documentLetterPDF(DocName).click();
            System.out.println("Document is downloaded " + DocName);
            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToLastOpenWindow();
        }catch (Exception e){
            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToLastOpenWindow();
        }
//        }
        //To Check whether downloaded file size is greater than 0
//        int size = 0;
//        try {
//            size = (int) claimsOperationsObj.documentfileSize();
//            System.out.println("file size----------------------------" + size);
//            Assert.assertTrue(size > 0);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @And("^I should be able to Download the email event '(.+)'$")
    public void iShouldBeAbleToDownloadTheEmailEventEMAILSYSTEMMidTermAmendment(String DocName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        try {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            Thread.sleep(300000);
            getDriver().navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            claimsOperationsObj.clickingUnderNextEventsAndButtons("show full event history");
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            Assert.assertTrue(fullEventHistoryPageObj.documentLetters(DocName).isDisplayed());
            System.out.println("Email event is displayed");
            Assert.assertTrue(fullEventHistoryPageObj.documentLetterPDF(DocName).isEnabled());
            fullEventHistoryPageObj.email(DocName).click();
            System.out.println("Email is downloaded " + DocName);
            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToLastOpenWindow();
        }catch (Exception e){
            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToLastOpenWindow();
        }
    }
}

