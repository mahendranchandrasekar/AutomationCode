package co.uk.directlinegroup.tt.utils.common;


import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

/**
 * Created by 588800 on 7/25/2017.
 */
public class ConfigureEventsOperations {

    String eventStr = null;
    private NextEventPage nextEventPageObj = new NextEventPage();
    private SetUpPage setUpPageObj = new SetUpPage();
    private EventHistory eventHistoryObj = new EventHistory();
    private LeftNavPanePage leftNavPanePageObj = new LeftNavPanePage();
    private ClaimsOperations claimOperationObj = new ClaimsOperations();
    private FullEventHistoryPage fullEventHistoryPageObj = new FullEventHistoryPage();
    private QuoteAndBuyOperations quoteAndBuyOperationsObj = new QuoteAndBuyOperations();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private Navigation navigationObj = new Navigation();
    private ClaimPaymentPage claimPaymentPageObj = new ClaimPaymentPage();
    private Commands commandsObj = new Commands();
    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private PolicySummaryPage policySummaryPageObj = new PolicySummaryPage();
    private PolicyOperations policyOperationsObj = new PolicyOperations();
    private CustomerPortalMyPolicyOperations customerPortalMyPolicyOperationsObj = new CustomerPortalMyPolicyOperations();
    private CommonPage commonPageObj = new CommonPage();

    String txtUrl = "";
    List<WebElement> elementCount;
    int count = 0;


    public void validateEvents(List<List<String>> eventDetails) throws Throwable {
        for (int i = 1; i < eventDetails.size(); i++) {
            System.out.println( "----------i----------value ---" + i );
            for (int j = 0; j < eventDetails.get( i ).size(); j++) {
                System.out.println( "----------j----------value ---" + j );
                System.out.println( "inside event verification loop.." );
                this.verifyEvents( eventDetails.get( i ).get( j ) );
            }
        }
        try {
            nextEventPageObj.btnClick( fullEventHistoryPageObj.closeWindow() );
            fullEventHistoryPageObj.switchToLastOpenWindow();
        } catch (Exception e) {
            nextEventPageObj.btnClick( fullEventHistoryPageObj.closeWindow() );
            fullEventHistoryPageObj.switchToLastOpenWindow();
        }
    }


    public void verifyEvents(String event) throws Throwable {

        switch (event) {
////-------------------START---------------------------VERIFY THE EVENTS WITHOUT OPENING EVENT HISTORY------------------------------------------
            case "Request Recovery Confirmations":
                System.out.println( "Inside Recovery Confirmation Request | Email (SYSTEM) (SYSTEM) event" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Hospital Medical Report Request Generated":
                System.out.println( "Inside Hospital Medical Report Request Generated event" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Customer Guarantee | Email (SYSTEM)":
                System.out.println( "Inside Customer Guarantee | Email (SYSTEM) event" );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.getDriver.navigate().refresh();
                nextEventPageObj.waitForMoreTime();
                Thread.sleep( 90000 );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.getDriver.navigate().refresh();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Hospital Medical Report Request | Email (SYSTEM)":
                System.out.println( "Inside Hospital Medical Report Request | Email (SYSTEM) event" );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.getDriver.navigate().refresh();
                nextEventPageObj.waitForMoreTime();
                Thread.sleep( 90000 );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.getDriver.navigate().refresh();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.getDriver.navigate().refresh();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.getDriver.navigate().refresh();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
//            case "Recovery Payment Chase | Email (SYSTEM)":
//                //Added this wait as these events are exoectd to take more time
//                Thread.sleep(90000);
//                Assert.assertTrue((nextEventPageObj.recoveryPaymentChaseEmail().getText()).contains(event));
//                System.out.println("Event has been verified" + event);
//                fullEventHistoryPageObj.closeWindow().click();
//                nextEventPageObj.switchToLastOpenWindow();
//                break;
            case "Notify DLG Media Team - Email":
                System.out.println( "Inside Notify DLG Media Team - Email event" );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.getDriver.navigate().refresh();
                nextEventPageObj.waitForMoreTime();
                Thread.sleep( 90000 );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.getDriver.navigate().refresh();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.notifyDlgMediaEvent().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Inpatient Fact Sheet":
                System.out.println( "Inside Inpatient Fact Sheet event" );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.getDriver.navigate().refresh();
                nextEventPageObj.waitForMoreTime();
                Thread.sleep( 90000 );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.getDriver.navigate().refresh();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "OOP Override Limits and Excesses":
                System.out.println( "Inside OOP Override Limits and Excesses event" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "OOP Missing Person Found":
                System.out.println( "Inside OOP Missing Person Found event" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Bar / Block - Add Single":
                System.out.println( "Inside Bar / Block - Add Single event" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Assign Panel Solicitor":
                System.out.println( "Inside Assign Panel Solicitor event" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Additional Legal Expenses Data Capture":
                System.out.println( "Inside Additional Legal Expenses Data Capture event------------------------" + nextEventPageObj.recoveryEvent( event ).getText() );
                Assert.assertTrue( (nextEventPageObj.recoveryEvent( event ).getText()).contains( event ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Enter Other Party Details":
                System.out.println( "Enter Other Party Details event verification" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Flag - Auto Renewal":
                System.out.println( "Inside Flag-Auto Renewal" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Recovery Payment Request | Email (SYSTEM)":
                Thread.sleep( 90000 );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue( (nextEventPageObj.recoveryPaymentRequestEmail().getText()).contains( event ) );
                System.out.println( "Event has been verified" + event );
                fullEventHistoryPageObj.closeWindow().click();
                nextEventPageObj.switchToLastOpenWindow();
                break;
            case "Recovery Payment Chase | Email (SYSTEM)":
                //Added this wait as these events are exoectd to take more time
                Thread.sleep( 90000 );
                Assert.assertTrue( (nextEventPageObj.recoveryPaymentChaseEmail().getText()).contains( event ) );
                System.out.println( "Event has been verified" + event );
                fullEventHistoryPageObj.closeWindow().click();
                nextEventPageObj.switchToLastOpenWindow();
                break;
//            case "EMAIL (SYSTEM) - Child aged 18":
//                //Added this wait as these events are exoectd to take more time
//                Thread.sleep(90000);
//                Assert.assertTrue((nextEventPageObj.childAgedEighteenEmail().getText()).contains(event));
//                System.out.println("Event has been verified" + event);
//                break;
//            case "LETTER (SYSTEM) - Child aged 18":
//                //Added this wait as these events are exoectd to take more time
//                Thread.sleep(90000);
//                Assert.assertTrue((nextEventPageObj.childAgedEighteenLetter().getText()).contains(event));
//                System.out.println("Event has been verified" + event);
//                break;
//            case "EMAIL (SYSTEM) - Child aged 23":
//                //Added this wait as these events are exoectd to take more time
//                Thread.sleep(90000);
//                Assert.assertTrue((nextEventPageObj.childAgedTwentyThreeEmail().getText()).contains(event));
//                System.out.println("Event has been verified" + event);
//                break;
//            case "LETTER (SYSTEM) - Child aged 23":
//                Thread.sleep(90000);
//                Assert.assertTrue((nextEventPageObj.childAgedTwentyThreeLetter().getText()).contains(event));
//                System.out.println("Event has been verified" + event);
//                break;
//            case "EMAIL (SYSTEM) - Age Extension 7 day Reminder":
//                //Added this wait as these events are exoectd to take more time
//                Thread.sleep(90000);
//                Assert.assertTrue((nextEventPageObj.ageExtensionReminderEmail().getText()).contains(event));
//                System.out.println("Event has been verified" + event);
//                break;
//            case "LETTER (SYSTEM) - Age Extension 7 day Reminder":
//                Thread.sleep(90000);
//                Assert.assertTrue((nextEventPageObj.ageExtensionReminderLetter().getText()).contains(event));
//                System.out.println("Event has been verified" + event);
//                break;
            case "Supplier Service Requested":
                //#BN- PLEASE DO NOT CHANGE THE CODE LOGIC GIVEN BELOW. PLEASE CONSULT WITH BIJITH BEFORE CHANGING
                claimOperationObj.clickingUnderNextEventsAndButtons( "Show Full Event History" );
                String strExpEventinEventHistory = "";
                String strExpCommentInEventHistory = "";

                if (event.contains( "||" )) {
                    strExpEventinEventHistory = event.split( "||" )[0];
                    strExpCommentInEventHistory = event.split( "||" )[1];
                } else {
                    strExpEventinEventHistory = event;
                }
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue( "Validating event " + strExpEventinEventHistory + "in event history", nextEventPageObj.lblEvents( strExpEventinEventHistory ).isDisplayed() );
                Assert.assertTrue( "Validating event type " + strExpCommentInEventHistory + "in event history", nextEventPageObj.requestType( strExpCommentInEventHistory ).isDisplayed() );
                fullEventHistoryPageObj.closeWindow().click();
                nextEventPageObj.switchToLastOpenWindow();
                // System.out.println("OOP send LOA Form event");
                System.out.println( "Event has been verified" + event );
                break;
            case "Key TMA Event Applied":
            case "Notify Funeral Director - Email":
            case "OOP Upload Supplier Instruction Response":
            case "OOP Repatriation Required":
            case "Repatriation Process Flow":
            case "Review Repatriation Requirements":
            case "Repatriation Checklist":
            case "Contact Customer to Confirm Reqs & Set Expectation":
            case "Air Ambulance Process Flow":
            case "Request Air Ambulance Quotes":
            case "Air Ambulance Quotes Received":
            case "Review Air Ambulance Quotes":
            case "Confirm Air Ambulance Approval":
            case "Electronic Signature to Healix | Email":
            case "Healix Fit to Fly (Air Ambulance)":
            case "Contact Customer to Confirm Luggage Repatriation":
            case "Confirm Arrangements with Supplier":
            case "Confirm Passport Details (Air Ambulance)":
            case "Arrange Transfers":
            case "Confirm Transfer Arrangements with Healix":
            case "Confirm Transfer Arrangements with Facility":
            case "Request Healix Confirmation of Arrival":
            case "Triage":
            case "Triage Repudiation":
            case "Trigger Advice Of Evidence":
            case "Funeral Director Required":
            case "Notify TIM Travel Insurance Management - Email":
            case "LETTER (OOP) - Confirmation Of Cover":
                System.out.println( "event..........." + event );
                claimOperationObj.clickingUnderNextEventsAndButtons( "Show Full Event History" );
                if (event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() )) {
                    Assert.assertTrue( (nextEventPageObj.recoveryEvent( event ).getText()).contains( event ) );
                } else {
//                    claimOperationObj.clickingUnderNextEventsAndButtons("Show Full Event History");
                    Assert.assertTrue( (nextEventPageObj.recoveryEvent( event ).getText()).contains( event ) );
                }

                System.out.println( "Event has been verified" + event );

                System.out.println( "Event has been verifiedA050 System Repudiation Reasons - Unreported Loss/theft " + event );
                claimOperationObj.clickingUnderNextEventsAndButtons( "close full event window" );
                break;

//            case "OOP Chase Customer by Phone":
//                System.out.println("Recovery Payment Chase | Email (SYSTEM) event");
//                Assert.assertTrue(event.equalsIgnoreCase(nextEventPageObj.recoveryPaymentChaseEmail().getText()));
//                System.out.println("Event has been verified" + event);
//                break;

//            case "OOP Request Access to Medical Information":
//                System.out.println("OOP Request Access to Medical Information");
//                Assert.assertTrue(event.equalsIgnoreCase(nextEventPageObj.recoveryPaymentChaseEmail().getText()));
//                System.out.println("Event has been verified" + event);
//                break;

            case "Verify or Create Agent":
                System.out.println( "Verify or Create Agent" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryPaymentChaseEmail().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "OOP Request Hospital Medical Report":
                System.out.println( "OOP Request Hospital Medical Report" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Verify or Create GP":
                System.out.println( "Verify or Create GP" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryPaymentChaseEmail().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Claim Referred to Team Leader":
                System.out.println( "Claim Referred to Team Leader" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.claimReferred().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Confirmation Of Cover Letter":
                System.out.println( "Confirmation Of Cover Letter" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.confirmationOfCoverLetter().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
//            case "LETTER (OOP) - Confirmation Of Cover *FREE TEXT*":
//                System.out.println("LETTER (OOP) - Confirmation Of Cover *FREE TEXT*");
//                Assert.assertTrue(event.equalsIgnoreCase(nextEventPageObj.confirmationOfCoverSpecificRequirementsLetter().getText()));
//                System.out.println("Event has been verified" + event);
//                break;
            case "OOP Customer Chase - Start chase":
                System.out.println( "OOP Customer Chase - Start chase" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.oopCustomerChaseStartchase().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Customer Chase In Progress":

                System.out.println( "Customer Chase In Progress" );

                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.customerChaseInProgress().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "OOP Resend Document":

                System.out.println( "OOP Resend Document" );

                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.oopResendDocument().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Resend - New Product Confirmation | Letter":

                System.out.println( "Resend - New Product Confirmation | Letter" );


                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "nextEventPageObj.oopResendDocument().getText()-------------------------" + nextEventPageObj.oopResendDocument().getText() );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.oopResendDocumentConfirmation().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Dummy event for US280- For69 Years":

                System.out.println( "Resend - New Product Confirmation | Letter" );

                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "nextEventPageObj.oopResendDocument().getText()-------------------------" + nextEventPageObj.oopResendDocument().getText() );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.eventNotificationRegardingAge( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Dummy event for US280- For18 Years":

                System.out.println( "Resend - New Product Confirmation | Letter" );

                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "nextEventPageObj.oopResendDocument().getText()-------------------------" + nextEventPageObj.oopResendDocument().getText() );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.eventNotificationRegardingAge( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Dummy event for US280- For23 Years":

                System.out.println( "Resend - New Product Confirmation | Letter" );

                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "nextEventPageObj.oopResendDocument().getText()-------------------------" + nextEventPageObj.oopResendDocument().getText() );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.eventNotificationRegardingAge( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Endorsement Update":

                System.out.println( "Endorsement Update" );

                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "nextEventPageObj.oopResendDocument().getText()-------------------------" + nextEventPageObj.oopEndorsementUpdate().getText() );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.oopEndorsementUpdate().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "TESTING - WP Set Token":
                System.out.println( "TESTING - WP Set Token" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "TESTING - WP Card Notification Update":
                System.out.println( "TESTING - WP Card Notification Update" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Resolve Failure - by Correspondence":
                System.out.println( "Resolve Failure - by Correspondence" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Contact Customer Resolve DD Failure | Letter":
                System.out.println( "Contact Customer Resolve DD Failure | Letter" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Contact Customer Resolve DD Failure | SMS":
                System.out.println( "Contact Customer Resolve DD Failure | SMS" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Contact Customer Resolve DD Failure | Email":
                System.out.println( "Contact Customer Resolve DD Failure | Email" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Card Payment - Complete Billing Records":
                System.out.println( "Card Payment - Complete Billing Records" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Transactions Suspended On This Mandate":
                System.out.println( "Transactions Suspended On This Mandate" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Claim Referred to Customer Validation - Automatic":
                System.out.println( "Claim Referred to Customer Validation - Automatic" );

                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "nextEventPageObj.oopResendDocument().getText()-------------------------" + nextEventPageObj.claimReferredToCustomerValidation().getText() );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.claimReferredToCustomerValidation().getText() ) );
                System.out.println( "Event has been verified" + event );
                fullEventHistoryPageObj.closeWindow().click();
                fullEventHistoryPageObj.switchToLastOpenWindow();
                break;

           /* case "Enter Payment Details":
                System.out.println("Enter Payment Details");

                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("nextEventPageObj.choosePAtmentMethod().getText()-------------------------" + nextEventPageObj.choosepaymentMethod().getText());
                Assert.assertTrue(event.equalsIgnoreCase(nextEventPageObj.choosepaymentMethod().getText()));
                System.out.println("Event has been verified" + event);
                break;*/
            case "OOP Raise Goodwill/Compensation Payment":

                System.out.println( "OOP Raise Goodwill/Compensation Payment" );

                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "nextEventPageObj.OOP Raise Goodwill/Compensation Payment().getText()-------------------------" + nextEventPageObj.oopGoodWillPayment().getText() );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.oopGoodWillPayment().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Enter Cheque Details":

                System.out.println( "Enter Cheque Details" );

                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "nextEventPageObj.Enter Cheque Details().getText()-------------------------" + nextEventPageObj.enterChequeDetails().getText() );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.enterChequeDetails().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Enter BACS Details":

                System.out.println( "Enter BACS Details" );

                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "nextEventPageObj.Enter Cheque Details().getText()-------------------------" + nextEventPageObj.enterBACSDetails().getText() );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.enterChequeDetails().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "OOP Customer Chase - Manage chase":

                System.out.println( "OOP Customer Chase - Manage chase" );

                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "nextEventPageObj.Enter Cheque Details().getText()-------------------------" + nextEventPageObj.manageChase().getText() );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.manageChase().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Supplier LOA Form | Email":
                System.out.println( "Inside Supplier LOA Form | Email event" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;

            case "Customer LOA Form | Email":
                System.out.println( "Inside Customer LOA Form | Email event" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
            case "Next of Kin LOA Form | Email":
                System.out.println( "Inside Next of Kin LOA Form | Email event" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Supplier Access to Medical Info Request Generated":
                System.out.println( "Inside Supplier Access to Medical Info Request Generated event" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;

            case "Customer Access to Medical Info Request Generated":
                System.out.println( "Inside Customer Access to Medical Info Request Generated event" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Next of Kin Access to Medical Info Request Generated":
                System.out.println( "Inside Next of Kin Access to Medical Info Request Generated event" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                break;


            case "Card Purchase Complete MTA":
//            case "Card Purchase Complete":

                System.out.println( "Card Purchase Complete" );

                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "nextEventPageObj.cardPurchaseComplete().getText()-------------------------" + nextEventPageObj.cardPurchaseComplete().getText() );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.cardPurchaseComplete().getText() ) );
                System.out.println( "Event has been verified" + event );
//                quoteAndBuyOperationsObj.validatePurchaseCompleteCardNum();
                break;


            case "Card Failure":

                System.out.println( "Card Purchase Complete" );

                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "nextEventPageObj.cardFailure().getText()-------------------------" + nextEventPageObj.cardFailure().getText() );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.cardFailure().getText() ) );
                System.out.println( "Event has been verified" + event );
                quoteAndBuyOperationsObj.validateFailureCardNum();
                break;

            case "Confirmation Of Cover Email":


                System.out.println( "Confirmation Of Cover Email" );

                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.confirmationOfCoverEmail().getText() ) );
                System.out.println( "Event has been verified " + event );
                break;
            case "Confirmation Of Cover SMS":
                System.out.println( "Confirmation Of Cover SMS" );

                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.confirmationOfCoverSMS().getText() ) );
                System.out.println( "Event has been verified " + event );
                break;
            case "New Business Doc Pack":

                System.out.println( "New Business Doc Pack" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.newBusinessDocPack().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;

            case "New Claim Registered | SMS":
                System.out.println( "Confirmation Of Cover SMS" );

//                Assert.assertTrue(event.equalsIgnoreCase(nextEventPageObj.confirmationOfCoverSMS().getText()));
                Assert.assertTrue( !(nextEventPageObj.elementDisplayed( nextEventPageObj.registeredClaimSMS() )) );
                System.out.println( "Event has been verified " + event );
                break;
            case "New Claim Registered | Email":

                System.out.println( "Confirmation Of Cover SMS" );

//                Assert.assertFalse(event.equalsIgnoreCase(nextEventPageObj.confirmationOfCoverSMS().getText()));
                Assert.assertTrue( !(nextEventPageObj.elementDisplayed( nextEventPageObj.registeredClaimEmail() )) );
                System.out.println( "Event has been verified " + event );
                break;
            case "'OOP Customer Chase - Manage chase":
                System.out.println( "'OOP Customer Chase - Manage chase" );

                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.managechaseevent().getText() ) );
                System.out.println( "Event has been verified " + event );
                break;
            case "TESTING - BACS failure - Add failure":


                System.out.println( "TESTING - BACS failure - Add failure" );

                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.BACSFailureAddFailureEvent().getText() ) );
                System.out.println( "Event has been verified " + event );
                break;
            case "DD Request Failed":


                System.out.println( "DD Request Failed" );

                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.ddRequestFailed().getText() ) );
                System.out.println( "Event has been verified " + event );
                break;
            case "Resolve Failure - by Phone":


                System.out.println( "Resolve Failure - by Phone" );

                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.resolveFailureByPhone().getText() ) );
                System.out.println( "Event has been verified " + event );
                break;
            case "OOP Approve or Reject Reserve Movement":

                System.out.println( "Inside OOP Approve or Reject Reserve Movement" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.ReserveEvent().getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Claim Rejected Letter":

                System.out.println( "Inside Claim Rejected Letter" );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.Claimrejectedletter( event ).getText() ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Claim Closed":
                System.out.println( "Inside Claim closed" );
//                Assert.assertTrue(event.equalsIgnoreCase(nextEventPageObj.Claimclosed(event).getText()));
                Assert.assertTrue( (nextEventPageObj.recoveryEvent( event ).getText()).contains( event ) );
                System.out.println( "Event has been verified" + event );
                break;
            case "Claim Rejected Letter not generated":

                System.out.println( "Inside Claim Rejected Letter" );
                Assert.assertTrue( !(nextEventPageObj.elementDisplayed( By.xpath( nextEventPageObj.ClaimrejectedletterXpath( event ) ) )) );
                System.out.println( "Event has been verified" + event );
                break;

            case "TT293 TESTING":
            case "OOP Suppress Renewal Communication":
                //case "Renewal - Set Manual Or Automatic":
            case "Generate Renewal Quote":
            case "Fact Sheet | Fax":

            case "Update Mandate Details":
            case "Create Mandate Record":
            case "Retry Transaction":
            case "TESTING - BACS failure - rollback payment date":
            case "Retry Transaction On Existing Mandate":
            case "Enter New DD Account Details":
            case "Fail Existing Mandate":
            case "Send Mandate Details":
            case "Queue Policy DD Transaction":
            case "Request Policy DD Transaction":
            case "Sanctions Screening Required":
            case "Select Payee (Customer)":
            case "Create Payment":
            case "Add Payment Comments":
            case "Send Payment to Billing System":
            case "Renewal Review and Edit":
            case "Renewal Generate Quote":
            case "Renewal Failed To Create Early Quote":
            case "Renewal Early Quote Created":
//            case "Renewal Buy Quote":
//            case "New Quote Confirmation | SMS": - BN- 03/10/2018- Removed as per the confirmation from Jayne
//            case "New Product Confirmation | Email": - BN- 03/10/2018- Removed as per the confirmation from Jayne
//            case "Potential Fraud Workflowtask Created":
            case "Potential Fraud Workflowtask Created":
            case "Rush Payment Request Approval Email":
            case "OOP Failed Payment - New Details Required | Email":
            case "Send Mandate Request":
            case "Send Mandate Record":
            case "Generate Remittance Advice":
            case "Enter Payment Details":
            case "Enter Bank Details":
            case "Payment Approval Required":
            case "Rush Payment Request":
            case "Deceased Process Flow":
//            case "Remittance Notification Email":

                System.out.println( "Event--------------------------" + event );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.BACSAccountDetailsRelatedEvents( event ).getText() ) );
                System.out.println( "Event has been verified " + event );
                break;

            case "Renewal Create Quote#Not Generated":
            case "EMAIL (SYSTEM) - Renewal expired#Not Generated":
            case "LETTER (SYSTEM) - Renewal Expired#Not Generated":
            case "SMS (SYSTEM) - Renewal Expired#Not Generated":
            case "EMAIL (SYSTEM) 14 day renewal reminder#Not Generated":
            case "SMS (SYSTEM) 14 day renewal reminder#Not Generated":
            case "LETTER (SYSTEM) 14 day renewal reminder#Not Generated":
            case "Upgrade Expiry Chase for Manual Renew SMS#Not Generated":
            case "Upgrade Expiry Chase for Manual Renew Letter#Not Generated":
            case "Upgrade Expiry Chase for Manual Renew Email#Not Generated":
            case "Evidence Chase":
            case "Base Evidence Chase":
            case "Claim Guaranteed":
            case "Deceased - Capture Info":
            case "SMS (SYSTEM) - Age Extension Required":
            case "Full Time Education Information | Letter":
            case "Guest Cover Invitation | Letter":
            case "Email - (TIM) Evidence/Diary Claim Expired":
            case "OOP Repudiate Line Item(s)":
            case "Claim Not Validated":
//            case "LETTER (SYSTEM) - Child aged 23":
                eventStr = event.split( "#" )[0];
                System.out.println( "Event---------" + eventStr );
                Assert.assertTrue( (nextEventPageObj.elementDisplayed( By.xpath( fullEventHistoryPageObj.events( eventStr ) ) )) );
                System.out.println( "Event has been verified " + eventStr );
//
                if (eventStr.equalsIgnoreCase( "Payment Rejected (SYSTEM)" ) || eventStr.equalsIgnoreCase( "LETTER (SYSTEM) - Child aged 18" ) || eventStr.equalsIgnoreCase( "LETTER (SYSTEM) - Child aged 23" )) {
                    fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.switchToLastOpenWindow();

                }
//                fullEventHistoryPageObj.eventHistoryCloseWindow().click();
//                nextEventPageObj.waitForMoreTime();
//                nextEventPageObj.switchToLastOpenWindow();
                break;
            case "Emails - (TIM) Day One Communication":
//            case "Email - (TIM) Day One Communication":
                Assert.assertTrue( fullEventHistoryPageObj.emailCommunication( event ).isDisplayed() );
                System.out.println( "Event has been verified ----- " + event );
                nextEventPageObj.waitForMoreTime();
                fullEventHistoryPageObj.iconEmail( event ).click();
                System.out.println( "Event has been verified ----- " + event );
                commonPageObj.switchToFrameById( commonPageObj.fancyFrame() );
                System.out.println( "Event has been verified ----- " + event );
//                Assert.assertTrue(fullEventHistoryPageObj.lblBaggage().isDisplayed());
                System.out.println( "Event has been verified ----- " + event );
                nextEventPageObj.waitForMoreTime();
                System.out.println( "close btn displayed ----------------------------" + fullEventHistoryPageObj.previewEmailCloseBtn().isDisplayed() );
//                fullEventHistoryPageObj.previewEmailCloseBtn().click();
                fullEventHistoryPageObj.btnClick( fullEventHistoryPageObj.previewEmailCloseBtn() );
                nextEventPageObj.waitForMoreTime();
                break;
            case "Day One Communication | Email":
                Assert.assertTrue( fullEventHistoryPageObj.emailCommunication( event ).isDisplayed() );
                nextEventPageObj.waitForMoreTime();
                fullEventHistoryPageObj.iconEmail( event ).click();
                commonPageObj.switchToFrameById( commonPageObj.fancyFrame() );
                Assert.assertTrue( fullEventHistoryPageObj.lblBaggage().isDisplayed() );
                nextEventPageObj.waitForMoreTime();
                System.out.println( "close btn displayed ----------------------------" + fullEventHistoryPageObj.previewEmailCloseBtn().isDisplayed() );
                fullEventHistoryPageObj.previewEmailCloseBtn().click();
                break;

            case "Supplier Guarantee | Email":
//            case "Customer Guarantee | Email (SYSTEM)":
            case "Supplier Guarantee Retraction | Email":
            case "Customer Guarantee Retraction | Email":
            case "Hospital Guarantee | Email":

                claimOperationObj.clickingUnderNextEventsAndButtons( "Show Full Event History" );
                Assert.assertTrue( fullEventHistoryPageObj.iconEmail( event ).isDisplayed() );
                claimOperationObj.clickingUnderNextEventsAndButtons( "close full event window" );
                nextEventPageObj.switchToLastOpenWindow();
                break;
            case "Auto Settle Claim (SYSTEM)":
                Assert.assertTrue( fullEventHistoryPageObj.nextEventInEventHistory( event ).isDisplayed() );
//                claimOperationObj.clickingUnderNextEventsAndButtons("close full event window");
//                nextEventPageObj.switchToLastOpenWindow();
                break;
            case "CUSTOMER (PORTAL) Password Reset Email":
                System.out.println( "Event--------------------------" + event );
                Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.BACSAccountDetailsRelatedEvents( event ).getText() ) );
                nextEventPageObj.BACSAccountDetailsRelatedEvents( event ).click();
                System.out.println( "Event has been verified " + event );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frameEditEvent() );
                nextEventPageObj.emailTabInTMAEvent().click();
                nextEventPageObj.waitForMoreTime();
                this.openLinkAndSetPwd();
                break;

            case "New Base Policy Welcome | Email":
            case "New Base Policy Welcome":
            case "Portal Registration Email":
            case "EMAIL (SYSTEM) - Portal Registration":
                System.out.println( "Inside event verification method......" );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue( nextEventPageObj.elementDisplayed( By.xpath( fullEventHistoryPageObj.events( event ) ) ) );
                System.out.println( "Event has been verified " + event );
                nextEventPageObj.BACSAccountDetailsRelatedEvents( event ).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frameEditEvent() );
                nextEventPageObj.emailTabInTMAEvent().click();
                nextEventPageObj.waitForMoreTime();

                break;

            case "New Base Policy Welcome | Email#Generated":
                eventStr = event.split( "#" )[0];
                System.out.println( "Event name ----- " + eventStr );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue( nextEventPageObj.elementDisplayed( By.xpath( fullEventHistoryPageObj.events( eventStr ) ) ) );
                System.out.println( "Event has been verified " + eventStr );
                break;
////-------------------END---------------------------VERIFY THE EVENTS WITHOUT OPENING EVENT HISTORY------------------------------------------
//// ----------------------------START--------VERIFY THE EVENTS BY OPENING EVENT HISTORY USING CODE GIVEN INSIDE CASE STATEMENT-------------------------------------
            case "OOP Send LOA Form":
            case "OOP Request Access to Medical Information":
            case "OOP Chase Supplier by Phone":
            case "OOP Chase Customer by Phone":
            case "OOP Chase Next of Kin by Phone":
            case "OOP Add Healix Nurse Note":
//            case "Inpatient Fact Sheet":
            case "Outpatient Fact Sheet":
            case "Fact Sheet | Email":
            case "Contact Customer to Confirm Transfer Details":
            case "Costs Capped":
            case "Cost Cap Exceeded":
            case "Remittance Notification Email":
            case "Payment Account Add Without Validation":
            case "Claim Validated":
            case "Outpatient Process Flow":
            case "Hospital Guarantee Generated":
            case "TMA Nurse Notification | Email":
            case "OOP Email Healix":
            case "OOP Healix First Medical Report":
            case "OOP Healix Critical Care Report":
            case "Invoices Calculate Reserves And Paid":
            case "OOP Chase GP by Phone":
            case "Notify Foreign Embassy":
            case "Notify FCO (London) | Email":
            case "Renewal Create Quote":
            case "Automatic Renewal":
            case "EMAIL (SYSTEM) - Renewal expired":
            case "EMAIL (SYSTEM) 14 day renewal reminder":
            case "Upgrade Expiry Chase for Manual Renew Email":
            case "Full Time Education Information | Email":
            case "EMAIL (SYSTEM) - Age Extension Required":
            case "Guest Cover Invitation | Email":
//            case "New Quote Confirmation | Email":
            case "OOP Send to Finance":
            case "Renewal - Set Manual Or Automatic":
            case "Request Recovery Confirmation":
            case "Reserve Movement Rejection (SYSTEM)":
            case "Renewal - Set Manual Or Automatic#Auto Description":
            case "Renewal Create Quote#Auto Description":
            case "Renewal Early Quote Created#Auto Description":
//            case "Renewal Early Quote Created":
            case "Renewal Failed To Create Early Quote#Auto Description":
            case "Renewal Create Quote#Manual Description":
            case "Supplier Guarantee Generated":
            case "Supplier Guarantee | Fax":
            case "Customer Guarantee Generated":
            case "Customer Guarantee | Fax":
            case "Claim Guarantee Retracted":
            case "Supplier Guarantee Retraction | Fax":
            case "Customer Guarantee Retraction Generated":
            case "Supplier Guarantee Retraction Generated":
            case "EMAIL (SYSTEM) - Age Extension Required#Generated":
            case "Renewal - Set Manual Or Automatic#Generated":
            case "Missing Person - Start (SYSTEM)":
            case "Confirm Decision to Handler | Email":
            case "Confirm Decision to Team Leader | Email":
            case "Western Union Payment Required":
            case "Renewal Policy Documentation":
            case "DOC PACK (SYSTEM) - New Business Acceptance":
            case "Advice of Evidence":
            case "Create Claim Lead":
            case "Renewal Buy Quote":
            case "Referral to Team Leader | Email":
            case "Referral to Underwriter | Email":
            case "Inpatient Process Flow":
            case "LETTER (OOP) - Confirmation Of Cover *FREE TEXT*":
            case "Payment Rejected (SYSTEM)":
                try {
                    claimOperationObj.clickingUnderNextEventsAndButtons( "Show Full Event History" );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    System.out.println( event );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    elementCount = new Select( nextEventPageObj.selectCase() ).getOptions();
                    count = 0;
                    for (int i = 0; i < elementCount.size(); i++) {
                        count++;
                        new Select( nextEventPageObj.selectCase() ).selectByIndex( i );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        if (commandsObj.elementDisplayedWithLessTime( By.xpath( "//td[contains(text(),'" + event + "')]" ) )) {
                            System.out.println( "Event available :-------------------------" + nextEventPageObj.cardCPAEvent( event ).getText() );
                            Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.cardCPAEvent( event ).getText() ) );
                            System.out.println( "Event has been verified------" + event );
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.switchToLastOpenWindow();
                            nextEventPageObj.waitForMoreTime();
                            break;
                        } else {
                            System.out.println( "Navigating to next case: " + event );
                            if (count == elementCount.size()) {
                                Assert.assertTrue( false );
                            }
                        }

                    }

                } catch (Exception e) {
                    fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.switchToLastOpenWindow();
                    Assert.assertTrue( false );
                }
                break;
            //// ----------------------------END--------VERIFY THE EVENTS BY OPENING EVENT HISTORY USING CODE GIVEN INSIDE CASE STATEMENT------------------------------------
            //// ----------------------------START--------VERIFY THE EVENTS BY OPENING EVENT HISTORY USING CODE GIVEN IN FEATURE FILE-----------------------------------
            case "Evidence Chase Base":
            case "Buy Quote Direct Debit":
            case "Direct Debit Purchase Complete":
            case "New Billing Account":
            case "Create Account Details":
            case "Card Payment Account":
            case "Card Purchase - Create Billing Records":
            case "Card Purchase - Complete Billing Records":
            case "Card CPA Letter":
            case "Card CPA Email":
                //case "New Quote Confirmation | SMS": BN- 03/10/2018- Removed as per the confirmation from Jayne
                //case "New Quote Confirmation | Letter": BN- 03/10/2018- Removed as per the confirmation from Jayne
                //case "New Quote Confirmation | Email": BN- 03/10/2018- Removed as per the confirmation from Jayne
                //case "New Product Confirmation | SMS": BN- 03/10/2018- Removed as per the confirmation from Jayne
                //case "New Product Confirmation | Email": BN- 03/10/2018- Removed as per the confirmation from Jayne
                //case "New Product Confirmation | Letter": BN- 03/10/2018- Removed as per the confirmation from Jayne
            case "Card CPA":
//            case "Letter - (TIM) - Day One Communication":
            case "Third Party Card Receipt":
            case "Buy Quote Card":
            case "Card Purchase Complete":
            case "LETTER (SYSTEM) - Age Extension Required#Generated":
            case "Renewal Create Quote#Generated":
            case "Healix Notification Generated":
//            case "OOP Missing Person Found":
            case "Buy Quote Card Generated":
            case "Card Failure#Generated":
            case "Card Purchase Complete#Generated":
            case "LETTER (SYSTEM) - Age Extension 7 day reminder":
            case "EMAIL (SYSTEM) - Age Extension 7 day Reminder":
            case "LETTER (SYSTEM) - Child aged 18":
            case "EMAIL (SYSTEM) - Child aged 18":
                // case "New Product Confirmation | SMS#Generated": BN- 03/10/2018- Removed as per the confirmation from Jayne
                // case "New Quote Confirmation | SMS#Generated": BN- 03/10/2018- Removed as per the confirmation from Jayne
            case "Manual Renewal":
            case "Reserve Approval Required":
                try {
                    Thread.sleep( 30000 );
                    eventStr = event.split( "#" )[0];
                    System.out.println( "Event name ----- " + eventStr );
                    System.out.println( event );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.getDriver.navigate().refresh();
                    nextEventPageObj.waitForMoreTime();
                    elementCount = new Select( nextEventPageObj.selectCase() ).getOptions();
                    count = 0;
                    for (int i = 0; i < elementCount.size(); i++) {
                        count++;
                        new Select( nextEventPageObj.selectCase() ).selectByIndex( i );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        if (commandsObj.elementDisplayedWithLessTime( By.xpath( "//td[contains(text(),'" + eventStr + "')]" ) )) {
                            System.out.println( "Event available :-------------------------" + nextEventPageObj.cardCPAEvent( eventStr ).getText() );
                            Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.cardCPAEvent( eventStr ).getText() ) );
                            System.out.println( "Event has been verified------" + eventStr );
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            break;
                        } else {
                            System.out.println( "Navigating to next case: " + eventStr );
                            if (count == elementCount.size()) {
                                Assert.assertTrue( false );
                            }
                        }

                    }

                } catch (Exception e) {
//                    fullEventHistoryPageObj.eventHistoryCloseWindow().click();
//                    nextEventPageObj.waitForMoreTime();
//                    nextEventPageObj.switchToLastOpenWindow();
                    Assert.assertTrue( false );
                }
                nextEventPageObj.waitForMoreTime();
                break;

//// ----------------------------END--------VERIFY THE EVENTS BY OPENING EVENT HISTORY USING CODE GIVEN IN FEATURE FILE-----------------------------------
//            case "PAYMENT APPROVAL REQUIRED":
//
//                System.out.println("Card Purchase Complete");
//
//                nextEventPageObj.waitForMoreTime();
//                nextEventPageObj.waitForMoreTime();
//                System.out.println("nextEventPageObj.cardFailure().getText()-------------------------" + nextEventPageObj.cardFailure().getText());
//                Assert.assertTrue(event.equalsIgnoreCase(nextEventPageObj.cardFailure().getText()));
//                System.out.println("Event has been verified" + event);
//                quoteAndBuyOperationsObj.validateFailureCardNum();
//                break;
// //----------------------------START--------VERIFY THE EVENTS AND DOWNLOAD THE DOCUMENT-----------------------------------
            case "Day One Communication | Letter":
            case "Renewal Quote - Pending Policy Expiry SMS":
            case "Renewal Quote - Pending Policy Expiry Letter":
            case "SMS (SYSTEM) - Renewal Expired":
            case "LETTER (SYSTEM) - Renewal Expired":
            case "SMS (SYSTEM) 14 day renewal reminder":
            case "Upgrade Expiry Chase for Manual Renew SMS":
            case "Upgrade Expiry Chase for Manual Renew Letter":
                try {
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    System.out.println( event );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    elementCount = new Select( nextEventPageObj.selectCase() ).getOptions();
                    count = 0;
                    for (int i = 0; i < elementCount.size(); i++) {
                        count++;
                        new Select( nextEventPageObj.selectCase() ).selectByIndex( i );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        if (commandsObj.elementDisplayedWithLessTime( By.xpath( "//td[contains(text(),'" + event + "')]" ) )) {
                            System.out.println( "Event available :-------------------------" + nextEventPageObj.recoveryEvent( event ).getText() );
                            Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                            System.out.println( "Event has been verified------" + event );
                            Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
                            fullEventHistoryPageObj.iconDocument( event ).click();
                            Thread.sleep( 5000L );
                            System.out.println( "Event has been verified ----- " + event );
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.switchToLastOpenWindow();
                            break;
                        } else {
                            System.out.println( "Navigating to next case: " + event );
                            if (count == elementCount.size()) {
                                Assert.assertTrue( false );
                            }
                        }

                    }
                } catch (Exception e) {
                    fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.switchToLastOpenWindow();
                    Assert.assertTrue( false );
                }
                break;


//// ----------------------------END--------VERIFY THE EVENTS AND DOWNLOAD THE DOCUMENT-----------------------------------
//// ----------------------------START--------VERIFY THE EVENTS AND DOWNLOAD THE DOCUMENT BY OPENING EVENT HISTORY-----------------------------------
            case "Third Party Card Receipt | Email":
                //case "New Product Confirmation | Email#Generated": - BN- 03/10/2018- Removed as per the confirmation from Jayne
                // case "New Quote Confirmation | Email#Generated": - BN- 03/10/2018- Removed as per the confirmation from Jayne

                try {
                    eventStr = event.split( "#" )[0];
                    System.out.println( "Event name ----- " + eventStr );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    elementCount = new Select( nextEventPageObj.selectCase() ).getOptions();
                    count = 0;
                    for (int i = 0; i < elementCount.size(); i++) {
                        count++;
                        new Select( nextEventPageObj.selectCase() ).selectByIndex( i );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        if (commandsObj.elementDisplayedWithLessTime( By.xpath( "//td[contains(text(),'" + event + "')]" ) )) {
                            Assert.assertTrue( fullEventHistoryPageObj.eventsInHistory( event ).isDisplayed() );
                            nextEventPageObj.waitForMoreTime();
                            fullEventHistoryPageObj.iconEmail( event ).click();
                            commonPageObj.switchToFrameById( commonPageObj.fancyFrame() );
                            Assert.assertTrue( fullEventHistoryPageObj.lblEmailContent().isDisplayed() );
                            nextEventPageObj.waitForMoreTime();
                            System.out.println( "close btn displayed ----------------------------" + fullEventHistoryPageObj.previewEmailCloseBtn().isDisplayed() );
                            nextEventPageObj.btnClick( fullEventHistoryPageObj.previewEmailCloseBtn() );
                            System.out.println( "Event has been verified ---" + event );
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.switchToLastOpenWindow();
                            nextEventPageObj.waitForMoreTime();
                            break;
                        } else {
                            System.out.println( "Navigating to next case for : " + eventStr );
                            if (count == elementCount.size()) {
                                Assert.assertTrue( false );
                            }
                        }
                    }
                } catch (Exception e) {

                    fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.switchToLastOpenWindow();
                    Assert.assertTrue( false );
                }
                break;

////----------------------------END--------VERIFY THE EVENTS AND DOWNLOAD THE DOCUMENT BY OPENING EVENT HISTORY-----------------------------------
            // case "New Product Confirmation Generated#Generated": BN- 03/10/2018- Removed as per the confirmation from Jayne
            //case "New Product Confirmation Generated":BN- 03/10/2018- Removed as per the confirmation from Jayne
            case "Settlement Letter":
            case "Auto Note - Reserve Approval Required":
//            case "Reserve Approval Required":
                //case "New Quote Confirmation | Letter#Generated": BN- 03/10/2018- Removed as per the confirmation from Jayne

                try {
                    eventStr = event.split( "#" )[0];
                    System.out.println( "Event name ----- " + eventStr );
                    claimOperationObj.clickingUnderNextEventsAndButtons( "Show Full Event History" );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    elementCount = new Select( nextEventPageObj.selectCase() ).getOptions();
                    count = 0;
                    for (int i = 0; i < elementCount.size(); i++) {
                        count++;
                        new Select( nextEventPageObj.selectCase() ).selectByIndex( i );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        if (commandsObj.elementDisplayedWithLessTime( By.xpath( "//td[contains(text(),'" + eventStr + "')]" ) )) {
                            System.out.println( "Event available :-------------------------" + nextEventPageObj.lblEvents( eventStr ).getText() );
                            fullEventHistoryPageObj.iconDocument( eventStr ).click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            int docSize = (int) claimsOperationsObj.fileSize();
                            System.out.println( "file size----------------------------" + docSize );
                            Assert.assertTrue( docSize > 0 );
                            System.out.println( "Event has been verified---- " + eventStr );
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.switchToLastOpenWindow();
                            nextEventPageObj.waitForMoreTime();
                            break;
                        } else {
                            System.out.println( "Navigating to next case for : " + eventStr );
                            if (count == elementCount.size()) {
                                Assert.assertTrue( false );
                            }
                        }
                    }
                } catch (Exception e) {

                    fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.switchToLastOpenWindow();
                    Assert.assertTrue( false );
                }
                break;


            case "Claim Payment | Email":

                System.out.println( "Event name ----- " + event );

                nextEventPageObj.waitForMoreTime();
                elementCount = new Select( nextEventPageObj.selectCase() ).getOptions();
                count = 0;
                try {
                    for (int i = 0; i < elementCount.size(); i++) {
                        count++;
                        new Select( nextEventPageObj.selectCase() ).selectByIndex( i );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        if (commandsObj.elementDisplayedWithLessTime( By.xpath( "//td[contains(text(),'" + event + "')]" ) )) {
                            Assert.assertTrue( fullEventHistoryPageObj.eventsInHistory( event ).isDisplayed() );
                            nextEventPageObj.waitForMoreTime();
                            Assert.assertTrue( this.validateSettlementLetterRecipient() );
                            fullEventHistoryPageObj.iconEmail( event ).click();
                            commonPageObj.switchToFrameById( commonPageObj.fancyFrame() );
                            Assert.assertTrue( fullEventHistoryPageObj.lblEmailContent().isDisplayed() );
                            Assert.assertTrue( nextEventPageObj.elementDisplayed( By.xpath( fullEventHistoryPageObj.linkOnEmailContent() ) ) );
                            nextEventPageObj.waitForMoreTime();
                            System.out.println( "close btn displayed ----------------------------" + fullEventHistoryPageObj.previewEmailCloseBtn().isDisplayed() );
                            nextEventPageObj.btnClick( fullEventHistoryPageObj.previewEmailCloseBtn() );
                            System.out.println( "Event has been verified ---" + event );
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.switchToLastOpenWindow();
                            nextEventPageObj.waitForMoreTime();
                            break;
                        } else {
                            System.out.println( "Navigating to next case for : " + event );
                            if (count == elementCount.size()) {
                                Assert.assertTrue( false );
                            }
                        }
                    }
                } catch (Exception e) {
                    fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.switchToLastOpenWindow();
                    Assert.assertTrue( false );
                }
                break;


            case "Email Address Verification Request | Email":
                System.out.println( "Event name ----- " + event );
                nextEventPageObj.waitForMoreTime();
                claimOperationObj.clickingUnderNextEventsAndButtons( "Show Full Event History" );
                nextEventPageObj.waitForMoreTime();
                eventHistoryObj.refresh();
                nextEventPageObj.waitForMoreTime();
                elementCount = new Select( nextEventPageObj.selectCase() ).getOptions();
                count = 0;
                try {
                    for (int i = 0; i < elementCount.size(); i++) {
                        count++;
                        new Select( nextEventPageObj.selectCase() ).selectByIndex( i );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        if (commandsObj.elementDisplayedWithLessTime( By.xpath( "//td[contains(text(),'" + event + "')]" ) )) {
                            Assert.assertTrue( nextEventPageObj.elementDisplayed( By.xpath( fullEventHistoryPageObj.lblEventsInHistory( event ) ) ) );
                            nextEventPageObj.waitForMoreTime();
                            fullEventHistoryPageObj.iconEmail( event ).click();
                            nextEventPageObj.waitForMoreTime();
                            commonPageObj.switchToFrameById( commonPageObj.fancyFrame() );
                            Assert.assertTrue( fullEventHistoryPageObj.lblEmailRecipient().getText().trim().equalsIgnoreCase( customerPortalMyPolicyOperationsObj.updatedEmailID ) );
                            Assert.assertTrue( fullEventHistoryPageObj.lblEmailContent().isDisplayed() );
                            nextEventPageObj.waitForMoreTime();
                            System.out.println( "close btn displayed ----------------------------" + fullEventHistoryPageObj.previewEmailCloseBtn().isDisplayed() );
                            nextEventPageObj.btnClick( fullEventHistoryPageObj.previewEmailCloseBtn() );
                            System.out.println( "Event has been verified ---" + event );
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.switchToLastOpenWindow();
                            nextEventPageObj.waitForMoreTime();
                            break;
                        } else {
                            System.out.println( "Navigating to next case for event : " + event );
                            if (count == elementCount.size()) {
                                Assert.assertTrue( false );
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println( "Show full event history window is closed in catch" );
                    fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.switchToLastOpenWindow();
                    Assert.assertTrue( false );
                }
                break;

// //----------------------------START--------VERIFY THE EVENTS FOR DOCUMENT TESTING----CLOSE WINDOW CODE IS HANDLED AT ANOTHER PLACE------------------------------
            case "Doc Pack - FNOL Letters/forms":
            case "Portal Registration Letter":
            case "LETTER (SYSTEM) - Portal Registration":
            case "LETTER (SYSTEM) - Third Party Card Receipt":
            case "Third Party Card Receipt | Letter":
            case "Third Party Card Receipt | Letter#MTA":
            case "Third Party Card Receipt | Letter#Renewal":
            case "Doc Pack - Document Chase":
            case "Doc Pack - Mental Capacity Issues":
            case "Doc Pack - Deceased Claims (England & Wales)":
            case "Letter - (TIM) Repudiation - FULL":
            case "Email - (TIM) Day One Communication":
            case "Letter - (TIM) - Day One Communication":
            case "Doc Pack - Deceased Claims (Scotland)":
            case "Recovery Confirmation Request | Letter (SYSTEM)":
            case "Recovery Further Info Request | Letter (SYSTEM)":
            case "Letter - (TIM) REC TPI 7day Final Notice":
            case "Letter - (TIM) REC Airline Further Info":
            case "Letter - (TIM) REC Airline 7day Final Notice":
            case "Letter - (TIM) Contribution Claim Repudiation":
            case "Letter - (TIM) Repudiation - PARTIAL":
            case "New Quote Confirmation | Letter#DocTesting":
            case "Upgrade Cancelled":
            case "New Business Doc Pack#DocTesting":
//            case "New Business Doc Pack":
            case "MTA Doc Pack":
            case "MTA Doc Pack#DocTesting":
//            case "Renewal Invitation - Doc Pack":
            case "DOC PACK (SYSTEM) - Renewal Invitation":
                //  case "Renewal Acceptance Doc Pack":
            case "DOC PACK (SYSTEM) Renewal Acceptance":
            case "Letter - (TIM) REC Dual Ins Further Info":
            case "LETTER (SYSTEM) 14 day renewal reminder":
            case "Letter - (TIM) Evidence/Diary Chase":
            case "LETTER (SYSTEM) - Age Extension Required":
            case "DOC PACK (SYSTEM) - Mid-term Amendment":
            case "AVA Cancelled Letter":
//            case "Notify DLG Media Team -  Email":
            case "Recovery Payment Request | Letter":
            case "Notification to pursue | Letter (SYSTEM)":
            case "Recovery Payment Chase | Letter (SYSTEM)":
            case "Recovery Payment 2nd Chase | Letter (SYSTEM)":
            case "Letter - (TIM) Settlement Letter":
            case "Letter - (TIM) REC DWP Letter to Customer":
            case "Letter - (TIM) REC DWP Letter to DWP":
            case "Letter - (TIM) REC DWP Payment Chase":
            case "Letter - (TIM) Contribution Settlement":
            case "Base Evidence Chase (SYSTEM)":
            case "LETTER (SYSTEM) Upgrade Cancelled":
            case "Letter - (TIM) Evidence/Diary Claim Expired":
            case "Recovery Payment Final Notice | Letter (SYSTEM)":
            case "LETTER (SYSTEM) Account Closure":
            case "EMAIL (SYSTEM) - Mid Term Amendment":
            case "Email - (TIM) Settlement Notification Email (S)":
//            case "LETTER (SYSTEM) - Child aged 18":
            case "Letter - (TIM) Compensation Payment Letter":

                try {
                    nextEventPageObj.waitForMoreTime();
//                    eventHistoryObj.refresh();
                    eventStr = event.split( "#" )[0];
                    System.out.println( "Event name ----- " + eventStr );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    elementCount = new Select( nextEventPageObj.selectCase() ).getOptions();
                    count = 0;
                    for (int i = 0; i < elementCount.size(); i++) {
                        count++;
                        new Select( nextEventPageObj.selectCase() ).selectByIndex( i );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        if (commandsObj.elementDisplayedWithLessTime( By.xpath( "//td[contains(text(),'" + eventStr + "')]" ) )) {
                            System.out.println( "//td[contains(text(),'" + eventStr + "')]" );
                            Assert.assertTrue( nextEventPageObj.elementDisplayed( fullEventHistoryPageObj.formGenerated( eventStr ) ) );
                            System.out.println( "Event has been verified---- " + eventStr );
                            if (eventStr.equalsIgnoreCase( "LETTER (SYSTEM) Upgrade Cancelled" ) || eventStr.equalsIgnoreCase( "LETTER (SYSTEM) - Third Party Card Receipt" ) || eventStr.equalsIgnoreCase( "Letter - (TIM) Evidence/Diary Claim Expired" )
                                    || eventStr.equalsIgnoreCase( "Recovery Further Info Request | Letter (SYSTEM)" )) {
                                fullEventHistoryPageObj.documentLetterPDF( eventStr ).click();
                                System.out.println( "Document is downloaded " + eventStr );
                            }
                            if (eventStr.equalsIgnoreCase( "EMAIL (SYSTEM) - Mid Term Amendment" )) {
                                fullEventHistoryPageObj.email( eventStr ).click();
                                System.out.println( "Email event is downloaded " + eventStr );
                                nextEventPageObj.waitForMoreTime();
                                nextEventPageObj.getDriver.navigate().refresh();
                                nextEventPageObj.waitForMoreTime();
                                nextEventPageObj.waitForMoreTime();
                                nextEventPageObj.waitForMoreTime();

                            }
                            fullEventHistoryPageObj.closeWindow().click();
                            nextEventPageObj.switchToLastOpenWindow();
                            break;
                        } else {
                            System.out.println( "Navigating to next case for : " + eventStr );
                            if (count == elementCount.size()) {
                                Assert.assertTrue( false );
                            }
                        }
                    }
                } catch (Exception e) {
                    fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.switchToLastOpenWindow();
                    Assert.assertTrue( false );
                }
                break;
//// ----------------------------END--------VERIFY THE EVENTS FOR DOCUMENT TESTING----CLOSE WINDOW CODE IS HANDLED AT ANOTHER PLACE------------------------------
        }
    }

    public void validateDocument(String event, String document) {
        try {
            nextEventPageObj.getDriver.navigate().refresh();
//        fullEventHistoryPageObj.showFullEventHistory().click();
//        nextEventPageObj.switchToLastOpenWindow();
            nextEventPageObj.waitForMoreTime();
            System.out.println( "Event name ----- " + event );
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            elementCount = new Select( nextEventPageObj.selectCase() ).getOptions();
            count = 0;
            for (int i = 0; i < elementCount.size(); i++) {
                count++;
                new Select( nextEventPageObj.selectCase() ).selectByIndex( i );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();

                if (commandsObj.elementDisplayedWithLessTime( By.xpath( "//td[contains(text(),'" + event + "')]" ) )) {
                    System.out.println( "//td[contains(text(),'" + event + "')]" );
                    Assert.assertTrue( nextEventPageObj.elementDisplayed( fullEventHistoryPageObj.formGenerated( event ) ) );
                    System.out.println( "Event has been verified---- " + event );

                    String[] doc = fullEventHistoryPageObj.documentName( event ).getText().split( "Document:" );
                    System.out.println( "document name1:  " + doc[0] );
                    System.out.println( "document name2:  " + doc[1] );
                    System.out.println( "document name2 trim:  " + doc[1].trim() );

                    String[] docum = doc[1].trim().split( "_" );
                    System.out.println( "document name3:  " + docum[0] );
                    System.out.println( "document name4:  " + docum[1] );

                    Assert.assertTrue( document.equalsIgnoreCase( docum[0] ) );

                    Assert.assertTrue( fullEventHistoryPageObj.documentLetterPDF( event ).isEnabled() );
                    fullEventHistoryPageObj.documentLetterPDF( event ).click();
                    System.out.println( "Document is downloaded " + event );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.switchToLastOpenWindow();
                    break;
                } else {
                    System.out.println( "Navigating to next case for : " + event );
                    if (count == elementCount.size()) {
                        Assert.assertTrue( false );
                    }
                }
            }
        } catch (Exception e) {
            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToLastOpenWindow();
            Assert.assertTrue( false );
        }
    }

    public void validateCMSReferenceNumber(String cmsReferenceNumber) throws Throwable {
        fullEventHistoryPageObj.openComplaintLink().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameByIndex( 0 );
        eventHistoryObj.getWindowTitle();
        Assert.assertTrue(fullEventHistoryPageObj.verifyCMSEntry(cmsReferenceNumber).isDisplayed());
        nextEventPageObj.noteCloseButton().click();
    }

    public void flagThePolicy(String referenceNumber, List<List<String>> parameters) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        System.out.println( "Inside out of process event" );
        claimSummaryPageObj.outOfProcessEvent().click();
        nextEventPageObj.btnClick( nextEventPageObj.go() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                String searchField = parameters.get( 0 ).get( j );
                String searchValue = parameters.get( i ).get( j );
                switch (searchField.toLowerCase()) {
                    case "event":
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                        System.out.println( "field name --------------------" + searchValue );
                        navigationObj.navigateToNextEventType( searchValue );
                        break;
                    case "cms reference number":
                        System.out.println( "Enter CMS reference Number" );
                        claimPaymentPageObj.enterCMSReferenceNumber().sendKeys( referenceNumber );
                        break;
                    case "action":
                        claimPaymentPageObj.goodwillSave().click();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "validateevent":
                        nextEventPageObj.switchToDefault();
                        eventHistoryObj.refresh();
                        Assert.assertTrue( searchValue.equalsIgnoreCase( nextEventPageObj.recoveryEvent( searchValue ).getText() ) );
                        System.out.println( "Event has been verified" + searchValue );
                        break;
                }
            }
        }

    }

    public void closeTheComplaint(List<List<String>> parameters) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        System.out.println( "Inside out of process event" );
        claimSummaryPageObj.outOfProcessEvent().click();
        nextEventPageObj.btnClick( nextEventPageObj.go() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                String searchField = parameters.get( 0 ).get( j );
                String searchValue = parameters.get( i ).get( j );
                switch (searchField.toLowerCase()) {
                    case "event":
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                        System.out.println( "field name --------------------" + searchValue );
                        navigationObj.navigateToNextEventType( searchValue );
                        break;
                    case "complaint closure reason":
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                        claimPaymentPageObj.complaintClosureReasonImg().click();
                        claimPaymentPageObj.complaintClosureReason( searchValue ).click();
                        break;
                    case "action":
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                        claimPaymentPageObj.goodwillSave().click();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "validateevent":
                        nextEventPageObj.switchToDefault();
                        eventHistoryObj.refresh();
                        Assert.assertTrue( searchValue.equalsIgnoreCase( nextEventPageObj.recoveryEvent( searchValue ).getText() ) );
                        System.out.println( "Event has been verified" + searchValue );
                        break;
                }
            }
        }

    }


    public void configureMaximumEarlyRenewalPeriod(String days) {
        try {
            navigationObj.navigateToImenu();
            navigationObj.navigateToIAdmin();
            navigationObj.navigateToCompanyDetails();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            navigationObj.navigateToSystem();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            leftNavPanePageObj.txtMaxEarlyRenewal().clear();
            leftNavPanePageObj.txtMaxEarlyRenewal().sendKeys( days );

            fullEventHistoryPageObj.saveAndClose().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();

            navigationObj.navigateToImenu();
            navigationObj.navigateToLeadManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyEventsNotGenerated(String event) {
        switch (event) {
            case "Renewal Create Quote":
                claimOperationObj.clickingUnderNextEventsAndButtons( "Show Full Event History" );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                eventStr = event.split( "#" )[0];
                System.out.println( "Event---------" + eventStr );
                Assert.assertTrue( !commandsObj.elementDisplayed( By.xpath( fullEventHistoryPageObj.eventsInHistoryXpath( eventStr ) ) ) );
                System.out.println( "Event is not displayed " + eventStr );
//                Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(fullEventHistoryPageObj.lblRenewalEventDescription(eventStr))));
//                Assert.assertTrue(fullEventHistoryPageObj.lblWhoDid(eventStr).getText().equalsIgnoreCase("Aquarium Automation"));
                fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToLastOpenWindow();
                break;

            case "LETTER (SYSTEM) - Age Extension Required":
            case "Letter - (TIM) Evidence/Diary Claim Expired":
                try {
                    elementCount = new Select( nextEventPageObj.selectCase() ).getOptions();
                    System.out.println( "elementCount.size()*********" + elementCount.size() );
                    count = 0;
                    for (int i = 0; i < elementCount.size(); i++) {
                        count++;
                        new Select( nextEventPageObj.selectCase() ).selectByIndex( i );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        if (!commandsObj.elementDisplayedWithLessTime( By.xpath( "//td[contains(text(),'" + event + "')]" ) )) {
                            Assert.assertTrue( !commandsObj.elementDisplayed( By.xpath( fullEventHistoryPageObj.eventsInHistoryXpath( event ) ) ) );
                            System.out.println( "Event not available in case" + i );
                            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.switchToLastOpenWindow();
                        } else {
                            System.out.println( "Navigating to next case for : " + eventStr );
                            if (count == elementCount.size()) {
                                Assert.assertTrue( false );
                            }
                        }
                    }
                } catch (Exception e) {
                    fullEventHistoryPageObj.eventHistoryCloseWindow().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.switchToLastOpenWindow();
                    Assert.assertTrue( false );

                }

                break;
        }

    }

    public void openLinkAndSetPwd() {
        System.out.println("Clicking and open a link in new tab....");
        String clickLinkOpenWin = Keys.chord(Keys.SHIFT, Keys.RETURN);
        nextEventPageObj.getDriver.findElement(By.linkText("here")).sendKeys(clickLinkOpenWin);
        nextEventPageObj.noteCloseButton().click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToLastOpenWindow();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();

    }


    public void validateMissingPersonFoundDetails(String team, List<List<String>> lstInputs) {
        if (team.equalsIgnoreCase( "DLG media Team" )) {
            policyDataFieldsPageObj.validateDLGMediaEmailContent().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById( nextEventPageObj.frameEditEvent() );
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            policyDataFieldsPageObj.emailTab().click();
        }
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get( 0 ).size(); j++) {
                this.missingPersonFoundDetailsInEmail( lstInputs.get( 0 ).get( j ), lstInputs.get( i ).get( j ) );
            }
        }
        nextEventPageObj.noteCloseButton().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();

    }

    private void missingPersonFoundDetailsInEmail(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "customer":
                Assert.assertTrue( policyDataFieldsPageObj.missingPersonName( fieldValue ).isDisplayed() );
                break;


        }

    }

    public void navigateToPolicyEvents() {
        policySummaryPageObj.btnBack().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policySummaryPageObj.lnkPolicyView();
        policySummaryPageObj.lnkPolicyView().click();

    }

    public void navigateToPolicy() {
        fullEventHistoryPageObj.eventHistoryCloseWindow().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToLastOpenWindow();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
//        policySummaryPageObj.lnkPolicyView();
//        policySummaryPageObj.lnkPolicyView().click();

    }

    public void navigateToTaskReminder() {
        navigationObj.navigateToImenu();
//        navigationObj.navigateToIDairy();
        nextEventPageObj.btnClick( policySummaryPageObj.navigateToTaskReminderTab() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();

    }

    public void validatingTaskRemainderTableHeaderValidation(List<List<String>> parameters) {
        for (int row = 0; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get( 0 ).size(); column++) {
                this.validatingHeaders( parameters.get( 0 ).get( column ) );
            }
        }

    }

    public void validatingHeaders(String header) {
        switch (header) {
            case "Title":
                System.out.println( "Inside Title header validation" );
                Assert.assertTrue( policySummaryPageObj.validateTableHeader( header ).isDisplayed() );
                break;
            case "AssignedTo":
                System.out.println( "Inside AssignedTo header validation" );
                Assert.assertTrue( policySummaryPageObj.validateTableHeader( header ).isDisplayed() );
                break;
            case "Due Date":
                System.out.println( "Inside Due Date header validation" );
                Assert.assertTrue( policySummaryPageObj.validateotherTableHeader( header ).isDisplayed() );
                break;
            case "End Date":
                System.out.println( "Inside End Date header validation" );
                Assert.assertTrue( policySummaryPageObj.validateotherTableHeader( header ).isDisplayed() );
                break;
            case "Creation Date":
                System.out.println( "Inside Creation Date header validation" );
                Assert.assertTrue( policySummaryPageObj.validateTableHeader( header ).isDisplayed() );
                break;
            case "View Claim":
                System.out.println( "Inside View Claim header validation" );
                Assert.assertTrue( policySummaryPageObj.validateotherTableHeader( header ).isDisplayed() );
                break;

        }
    }


    public boolean validateSettlementLetterRecipient() {
        List<WebElement> txtRecipientDetails = nextEventPageObj.findElements( By.xpath( fullEventHistoryPageObj.lblRecipientOfSettlementLetter() ) );
        System.out.println( "Recipient Details size " + txtRecipientDetails.size() );
        boolean recipient = false;
        for (WebElement row : txtRecipientDetails) {
            String emailID = row.getText();
            System.out.println( "Recipient Details-----" + emailID );
            String mailID = emailID.split( " " )[1].split( "\n" )[0].trim();
            System.out.println( "Registered Emails ----" + policyOperationsObj.randomEmailID );
            if (mailID.equalsIgnoreCase( policyOperationsObj.randomEmailID )) {
                recipient = true;
                break;
            }
        }
        return recipient;
    }

    public boolean validateEmailRecipient() {

        String emailRecipient = fullEventHistoryPageObj.lblEmailRecipient().getText();

        List<WebElement> txtRecipientDetails = nextEventPageObj.findElements( By.xpath( fullEventHistoryPageObj.lblRecipientOfSettlementLetter() ) );
        System.out.println( "Recipient Details size " + txtRecipientDetails.size() );
        boolean recipient = false;
        for (WebElement row : txtRecipientDetails) {
            String emailID = row.getText();
            System.out.println( "Recipient Details-----" + emailID );
            String mailID = emailID.split( " " )[1].split( "\n" )[0].trim();
            System.out.println( "Registered Emails ----" + customerPortalMyPolicyOperationsObj.updatedEmailID );
            if (mailID.equalsIgnoreCase( customerPortalMyPolicyOperationsObj.updatedEmailID )) {
                recipient = true;
                break;
            }
        }
        return recipient;
    }

    public void launchRegistrationURLFromWelcomeMail() {


        txtUrl = fullEventHistoryPageObj.lblRegURL().getText();
        System.out.println( "Txt URL-------" + txtUrl );

        String url = txtUrl.split( "link:" )[1];
        System.out.println( "URL ----------" + url.trim() );

        nextEventPageObj.getDriver.get( url.trim() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();

    }

    public void validateConfiguredURL() {
        txtUrl = fullEventHistoryPageObj.lblRegURL().getText();
        System.out.println( "Txt URL-------" + txtUrl );

        String url = txtUrl.split( "link:" )[1];
        System.out.println( "URL ----------" + url.trim() );

        Assert.assertEquals( claimOperationObj.portalURL, url );

    }


    public void verifyEventsinFullHostory(String event) throws Throwable {
        System.out.println( "Entering Func verifyEventsinFullHostiry- Event - " + event );
        commandsObj.waitForObject( nextEventPageObj.lblEvents( event ) );
        Assert.assertTrue( nextEventPageObj.lblEvents( event ).isDisplayed() );
        // Assert.assertTrue(eventStr.equalsIgnoreCase(nextEventPageObj.lblEvents(event).getText()));
        System.out.println( "Exiting Func verifyEventsinFullHostiry- Event - " + event );
    }

    public void verifyMultipleEvents(String event) {
        claimOperationObj.clickingUnderNextEventsAndButtons("Show Full Event History");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 0; i < event.split("#").length; i++) {
            switch (event.split("#")[i]) {
                case "Agent Guarantee Retraction Generated":
                case "Customer Guarantee Retraction Generated":
                case "Hospital Guarantee Retraction Generated":
                case "OOP Retract Claim Guarantee":
                case "Claim Not Validated":
                    Assert.assertTrue(event.equalsIgnoreCase(nextEventPageObj.sendLOA(event.split("#")[i]).getText()));
                    System.out.println("Events containing ####################" + event.split("#")[i]);
            }
        }
        fullEventHistoryPageObj.closeWindow().click();
        nextEventPageObj.switchToLastOpenWindow();
    }

    public void verifyMultipleEventsInshowFullEventHistory(String event) {
        claimOperationObj.clickingUnderNextEventsAndButtons( "Show Full Event History" );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        SoftAssertions softAssertions = new SoftAssertions();

            for (int i = 0; i < event.split( "&" ).length; i++) {
                switch (event.split( "&" )[i]) {
                    case "Doc Pack - FNOL Letters/forms":
                    case "Doc Pack - Document Chase":
                        eventStr = event.split( "&" )[i];
                        System.out.println( "Event name ----- " + eventStr );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
//                    softAssertions.assertThat(commandsObj.elementDisplayedWithLessTime( By.xpath( "//td[contains(text(),'" + eventStr + "')]" ) ) ).isEqualTo( "True" );
                        softAssertions.assertThat( nextEventPageObj.elementDisplayed( fullEventHistoryPageObj.formGenerated( eventStr ) ) );
                }
            }
            fullEventHistoryPageObj.closeWindow().click();
            nextEventPageObj.switchToLastOpenWindow();
            softAssertions.assertAll();
            System.out.println( "All the assertions are passed" );

    }

}
