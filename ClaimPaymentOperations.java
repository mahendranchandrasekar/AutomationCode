package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.common.Wait;
import co.uk.directlinegroup.tt.utils.common.WebTable;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 324102 on 4/27/2017. //re
 */
@Component
public class ClaimPaymentOperations {

    private ClaimPaymentPage claimPaymentPageObj = new ClaimPaymentPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private PaymentFailurePage paymentFailurePageObj = new PaymentFailurePage();
    private ClaimsOperations claimOperationObj = new ClaimsOperations();
    private FinalisePaymentPage finalisePaymentPageObj = new FinalisePaymentPage();
    private PolicyOperations policyOperationsObj = new PolicyOperations();
    private TMADetailsPage tmaDetailsPageObj = new TMADetailsPage();
    private QuoteDetails_Aquarium quoteDetails_aquariumObj = new QuoteDetails_Aquarium();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private Navigation navigationObj = new Navigation();
    private BasicClaimDetailsPage basicClaimDetailsPageObj = new BasicClaimDetailsPage();
    private Wait waitObj = new Wait();
    private SchemeSummaryPage schemeSummaryPageObj = new SchemeSummaryPage();
    private QuoteAndBuyOperations quoteAndBuyOperationsObj = new QuoteAndBuyOperations();
    private Commands commandsObj = new Commands();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private WebTable webTableObj = new WebTable();

    public void verifyFields(String fieldToVerify, String valueToVerify) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        List<WebElement> paymentMethod = new org.openqa.selenium.support.ui.Select(claimPaymentPageObj.paymentMethod()).getOptions();
        List<WebElement> payeeType = new org.openqa.selenium.support.ui.Select(claimPaymentPageObj.payeeType()).getOptions();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimPaymentPageObj.othersRadioButton().click();
        for (int i = 0; i < paymentMethod.size(); i++)
            System.out.println("payment methods----21111-------------" + paymentMethod.get(i).getText());
        for (int i = 0; i < payeeType.size(); i++)
            System.out.println("payment methods----21111-------------" + payeeType.get(i).getText());
        switch (fieldToVerify.toLowerCase()) {
            case "payee type":
                boolean bFoundType = false;
                for (int i = 0; i < payeeType.size(); i++) {
                    if (payeeType.get(i).getText().equalsIgnoreCase(valueToVerify)) {
                        System.out.println("payee type----21111-------------" + payeeType.get(i).getText());
                        System.out.println("dt value ------------------------" + valueToVerify);
                        bFoundType = true;
                        break;
                    }
                }
                if (bFoundType)
                    Assert.assertTrue(true);
                break;
            case "payment method":
                boolean bFoundMethod = false;
                for (int i = 0; i < paymentMethod.size(); i++) {
                    if (paymentMethod.get(i).getText().equalsIgnoreCase(valueToVerify)) {
                        System.out.println("payment methods----21111-------------" + paymentMethod.get(i).getText());
                        System.out.println("dt value ------------------------" + valueToVerify);
                        bFoundMethod = true;
                        break;
                    }
                }
                if (bFoundMethod)
                    Assert.assertTrue(true);
                break;
            case "amount":
                Assert.assertTrue(claimPaymentPageObj.amount().getText().equalsIgnoreCase(valueToVerify));
                break;
            case "type":
                break;
        }
    }

    public void claimItemTableManipulation(List<List<String>> claimTableContent) {
        for (int i = 1; i < claimTableContent.size(); i++) {
            for (int j = 0; j < claimTableContent.get(0).size(); j++) {
                this.selectCheckbox(claimTableContent.get(i).get(j));
            }
        }
    }

    public void selectCheckbox(String detail2) {
        System.out.println("claim item chk box------------------" + nextEventPageObj.findElement(By.xpath(claimPaymentPageObj.paymentCheckbox(detail2))).isDisplayed());
        nextEventPageObj.findElement(By.xpath(claimPaymentPageObj.paymentCheckbox(detail2))).click();
    }

    public void enterPayeeDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "options":
                System.out.println("Inside Option");
                claimPaymentPageObj.othersRadioButton().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "payee firstname":
                claimPaymentPageObj.payeeFirstName().click();
                claimPaymentPageObj.payeeFirstName().sendKeys(fieldValue);
                break;
            case "payee lastname":
                claimPaymentPageObj.payeeFirstName().click();
                claimPaymentPageObj.payeeLastName().sendKeys(fieldValue);
                break;
            case "sort code":
                claimPaymentPageObj.payeeSortCode().sendKeys(fieldValue);
                break;
            case "account number":
                claimPaymentPageObj.accountNumber().sendKeys(fieldValue);
                break;
            case "bank name":
                claimPaymentPageObj.bankName().sendKeys(fieldValue);
                break;
            case "address1":
                claimPaymentPageObj.address1().sendKeys(fieldValue);
                break;
            case "address2":
                claimPaymentPageObj.address2().sendKeys(fieldValue);
                break;
            case "town":
                claimPaymentPageObj.town().sendKeys(fieldValue);
                break;
            case "county":
                claimPaymentPageObj.county().sendKeys(fieldValue);
                break;
            case "postcode":
                claimPaymentPageObj.postCode().sendKeys(fieldValue);
                break;
            case "country":
                claimPaymentPageObj.country().sendKeys(fieldValue);
                break;
            case "guest people":
                new org.openqa.selenium.support.ui.Select(claimPaymentPageObj.guestPeople()).selectByVisibleText(fieldValue);
                break;
        }
    }

    public void fieldSelection(String fieldName, String fieldValue) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        String[] values = fieldValue.split(",");
        for (int i = 0; i < values.length; i++) {
            if (fieldName.equalsIgnoreCase("payee type")) {
                new org.openqa.selenium.support.ui.Select(claimPaymentPageObj.payeeType()).selectByVisibleText(values[0]);
            } else if (fieldName.equalsIgnoreCase("payment method")) {
                new org.openqa.selenium.support.ui.Select(claimPaymentPageObj.paymentMethod()).selectByVisibleText(values[0]);
            } else if (fieldName.equalsIgnoreCase("option")) {
                claimPaymentPageObj.othersRadioButton().click();
            } else if (values[1].equalsIgnoreCase("Packaged Bank Account")) {
                claimPaymentPageObj.radBtnPackagedAccount().click();
            } else if (values[i].equalsIgnoreCase("Other")) {
                claimPaymentPageObj.othersRadioButton().click();
            }
        }
    }

    public void verifyFieldsAreReadOnly(String fieldToVerify) {
        String attributeReadonly = "";
        switch (fieldToVerify.toLowerCase()) {
            case "payee firstname":
                attributeReadonly = claimPaymentPageObj.payeeFirstName().getAttribute("readonly");
                System.out.println("attribute ----first----------------------" + attributeReadonly);
                Assert.assertTrue(attributeReadonly.equalsIgnoreCase("true"));
                break;
            case "payee lastname":
                attributeReadonly = claimPaymentPageObj.payeeLastName().getAttribute("readonly");
                System.out.println("attribute ----last----------------------" + attributeReadonly);
                Assert.assertTrue(attributeReadonly.equalsIgnoreCase("true"));
                break;
            case "sort code":
                attributeReadonly = claimPaymentPageObj.payeeSortCode().getAttribute("readonly");
                System.out.println("attribute --------code------------------" + attributeReadonly);
                Assert.assertTrue(attributeReadonly.equalsIgnoreCase("true"));
                break;
            case "account number":
                attributeReadonly = claimPaymentPageObj.accountNumber().getAttribute("readonly");
                System.out.println("attribute -----no---------------------" + attributeReadonly);
                Assert.assertTrue(attributeReadonly.equalsIgnoreCase("true"));
                break;
            case "bank name":
                attributeReadonly = claimPaymentPageObj.bankName().getAttribute("readonly");
                System.out.println("attribute ---------name-----------------" + attributeReadonly);
                Assert.assertTrue(attributeReadonly.equalsIgnoreCase("true"));
                break;
            case "address1":
                attributeReadonly = claimPaymentPageObj.address1().getAttribute("readonly");
                System.out.println("attribute ------1--------------------" + attributeReadonly);
                Assert.assertTrue(attributeReadonly.equalsIgnoreCase("true"));
                break;
            case "address2":
                attributeReadonly = claimPaymentPageObj.address2().getAttribute("readonly");
                System.out.println("attribute ------------2--------------" + attributeReadonly);
                Assert.assertTrue(attributeReadonly.equalsIgnoreCase("true"));
                break;
            case "town":
                attributeReadonly = claimPaymentPageObj.town().getAttribute("readonly");
                System.out.println("attribute ----town----------------------" + attributeReadonly);
                Assert.assertTrue(attributeReadonly.equalsIgnoreCase("true"));
                break;
            case "county":
                attributeReadonly = claimPaymentPageObj.county().getAttribute("readonly");
                System.out.println("attribute ----county----------------------" + attributeReadonly);
                Assert.assertTrue(attributeReadonly.equalsIgnoreCase("true"));
                break;
            case "postcode":
                attributeReadonly = claimPaymentPageObj.postCode().getAttribute("readonly");
                System.out.println("attribute -----------post---------------" + attributeReadonly);
                Assert.assertTrue(attributeReadonly.equalsIgnoreCase("true"));
                break;
            case "country":
                attributeReadonly = claimPaymentPageObj.country().getAttribute("readonly");
                System.out.println("attribute -------country-------------------" + attributeReadonly);
                Assert.assertTrue(attributeReadonly.equalsIgnoreCase("true"));
                break;
            case "payee":
                Assert.assertTrue(claimPaymentPageObj.txtFieldPayee().isDisplayed());
                System.out.println("Payee field is displayed");
                break;
            case "payee type":
                Assert.assertTrue(claimPaymentPageObj.txtFieldPayeeType().isDisplayed());
                System.out.println("Payee type field is displayed");
                break;
            case "account number field":
                Assert.assertTrue(claimPaymentPageObj.txtFieldAccountNumber().isDisplayed());
                System.out.println("Account number field is displayed");
                break;
            case "bank name field":
                Assert.assertTrue(claimPaymentPageObj.txtFieldBankName().isDisplayed());
                System.out.println("Payee field is displayed");
                break;
            case "sort code field":
                Assert.assertTrue(claimPaymentPageObj.txtFieldSortCode().isDisplayed());
                System.out.println("Payee field is displayed");
                break;
            case "town field":
                Assert.assertTrue(claimPaymentPageObj.txtFieldTown().isDisplayed());
                System.out.println("Payee field is displayed");
                break;
            case "address1 field":
                Assert.assertTrue(claimPaymentPageObj.txtFieldAddress1().isDisplayed());
                System.out.println("Payee field is displayed");
                break;
            case "address2 field":
                Assert.assertTrue(claimPaymentPageObj.txtFieldAddress2().isDisplayed());
                System.out.println("Payee field is displayed");
                break;
            case "county field":
                Assert.assertTrue(claimPaymentPageObj.txtFieldcounty().isDisplayed());
                System.out.println("Payee field is displayed");
                break;
            case "postcode field":
                Assert.assertTrue(claimPaymentPageObj.txtFieldPostCode().isDisplayed());
                System.out.println("Payee field is displayed");
                break;
        }
    }

    public void validatePaymentField(String eventType, List<List<String>> paymentDetail) throws Throwable{
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimOperationObj.navigateToEventType(eventType);
    }

    public void captureBacsFailureDetails(List<List<String>> lstInputs) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                switch (lstInputs.get(0).get(j).toLowerCase()) {
                    case "transaction code":
                        paymentFailurePageObj.bacsFailureTransactionCodeTxt().clear();
                        paymentFailurePageObj.bacsFailureTransactionCodeTxt().sendKeys(lstInputs.get(i).get(j));
                        break;
                    case "amount":
                        paymentFailurePageObj.bacsFailureAmountTxt().clear();
                        paymentFailurePageObj.bacsFailureAmountTxt().sendKeys(lstInputs.get(i).get(j));
                        break;
                    case "advice type":
                        paymentFailurePageObj.bacsFailureAdviceTypeTxt().clear();
                        paymentFailurePageObj.bacsFailureAdviceTypeTxt().sendKeys(lstInputs.get(i).get(j));
                        break;
                    case "failure code":
                        paymentFailurePageObj.bacsFailureFailureCodeTxt().clear();
                        paymentFailurePageObj.bacsFailureFailureCodeTxt().sendKeys(lstInputs.get(i).get(j));
                        break;
                    case "account number":
                        paymentFailurePageObj.bacsFailureAccountNumberTxt().clear();
                        paymentFailurePageObj.bacsFailureAccountNumberTxt().sendKeys(lstInputs.get(i).get(j));
                        break;
                    case "sort code":
                        paymentFailurePageObj.bacsFailureSortCodeTxt().clear();
                        paymentFailurePageObj.bacsFailureSortCodeTxt().sendKeys(lstInputs.get(i).get(j));
                        break;
                    case "account name":
                        paymentFailurePageObj.bacsFailureAccountNameTxt().clear();
                        paymentFailurePageObj.bacsFailureAccountNameTxt().sendKeys(lstInputs.get(i).get(j));
                        break;
                    case "use papaerless dd":
                        paymentFailurePageObj.bacsFailurePaperlessDDTxt().click();
                        break;
                }
            }
        }
        paymentFailurePageObj.nextEventBacsFailureSaveBtn().click();
    }

    public void makePayment(String eventType, List<List<String>> paymentDetail) throws Throwable {
        policyOperationsObj.capturePaymentDetails(paymentDetail);
    }

    public void addPaymentComment(List<List<String>> paymentDetail) throws Throwable {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < paymentDetail.size(); i++) {
            for (int j = 0; j < paymentDetail.get(0).size(); j++) {
                switch (paymentDetail.get(0).get(j).toLowerCase()) {
                    case "add payment comments":
                        nextEventPageObj.waitForMoreTime();
                        finalisePaymentPageObj.finalisePaymentAddComment().sendKeys(paymentDetail.get(i).get(j));
                        finalisePaymentPageObj.paymetCommentSave().click();
                        break;
                }
            }
        }
    }

    public void enterAdviceRequiredDetails(List<List<String>> lstInputs) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                String searchField = lstInputs.get(0).get(j);
                String searchValue = lstInputs.get(i).get(j);
                switch (searchField.toLowerCase()) {
                    case "request in relation to":
                        System.out.println("Inside Request in relation to");
                        tmaDetailsPageObj.requestInRelationDropdownImg().click();
                        tmaDetailsPageObj.requestInRelationDropdownValue(searchValue).click();
                        break;
                    case "details of request":
                        System.out.println("Inside details of request");
                        tmaDetailsPageObj.detailsOfRequest().clear();
                        tmaDetailsPageObj.detailsOfRequest().sendKeys(searchValue);
                        break;
                    case "likely to become a claim":
                        tmaDetailsPageObj.likelyToBecomeClaimImg().click();
                        tmaDetailsPageObj.requestInRelationDropdownValue(searchValue).click();
                        break;
                    case "information provided":
                        tmaDetailsPageObj.informationProvided().clear();
                        tmaDetailsPageObj.informationProvided().sendKeys(searchValue);
                        break;
                    case "reason for view on likelihood of claim in future":
                        tmaDetailsPageObj.likelihoodOfClaim().clear();
                        tmaDetailsPageObj.likelihoodOfClaim().sendKeys(searchValue);
                        break;
                }
            }
        }
        tmaDetailsPageObj.btnSave().click();
    }

    public void makeCheckPayment(String eventType, List<List<String>> paymentDetail) throws Throwable {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimOperationObj.clickingUnderNextEventsAndButtons("Save Payment");
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        claimOperationObj.navigateToEventType(eventType);
        policyOperationsObj.capturePaymentDetails(paymentDetail);
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
    }

    public void paymentErrorMsg() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        Assert.assertTrue(claimPaymentPageObj.errMsgPayment().isDisplayed());
        claimSummaryPageObj.cancel_btn().click();
    }

    public void verifyAccountDetailUnderPurchase(List<List<String>> accountDetails) {
        claimPaymentPageObj.purchaseBtn().click();
        claimPaymentPageObj.accountInformationDetails(policyOperationsObj.policyId).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < accountDetails.size(); i++) {
            for (int j = 0; j < accountDetails.get(0).size(); j++) {
                switch (accountDetails.get(0).get(j).toLowerCase()) {
                    case "account number":
                        System.out.println("Account number from puirchse--------------------------" + claimPaymentPageObj.accountNumberInPurchase().isDisplayed());
                        System.out.println("Account number from puirchse--------------------------" + claimPaymentPageObj.accountNumberInPurchase().getText());
                        Assert.assertTrue(claimPaymentPageObj.accountNumberInPurchase().getText().equalsIgnoreCase(accountDetails.get(i).get(j)));
                        break;
                    case "sort code":
                        System.out.println("Account number from puirchse--------------------------" + claimPaymentPageObj.sortCodeInPurchase().getText());
                        Assert.assertTrue(claimPaymentPageObj.sortCodeInPurchase().getText().equalsIgnoreCase(accountDetails.get(i).get(j)));
                        break;
                }
            }
        }
        claimPaymentPageObj.cancelBtnAccountInformation().click();
        claimPaymentPageObj.backBtnAccountInformation().click();
    }

    public void enterCMSReferenceNumber(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                String searchField = parameters.get(0).get(j);
                String searchValue = parameters.get(i).get(j);
                switch (parameters.get(0).get(j).toLowerCase()) {
                    case "cms reference number":
                        System.out.println("Enter CMS reference Number");
                        claimPaymentPageObj.enterCMSReferenceNumber().sendKeys(searchValue);
                        break;
                    case "action":
                        claimPaymentPageObj.goodwillSave().click();
                        nextEventPageObj.waitForMoreTime();
                        break;
                }
            }
        }
    }

    public void validateMedicalReportReceipt(String parameters) {
        quoteDetails_aquariumObj.retriveClientRecord();
        nextEventPageObj.switchToDefault();
        claimPaymentPageObj.firstclaim().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        tmaDetailsPageObj.lnkTMAClaim().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("Inside out of process event");
        claimSummaryPageObj.outOfProcessEvent().click();
        nextEventPageObj.btnClick(nextEventPageObj.go());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        this.selectReportReceivedEvent(parameters);
    }

    public void selectReportReceivedEvent(String parameters) {
        System.out.println("Report Received event " + parameters);
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        System.out.println("field name --------------------" + parameters);
        navigationObj.navigateToNextEventType(parameters);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

	public void verifyGP(List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        this.enterGPDetails(parameters);
    }

    public void enterGPDetails(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                String searchField = parameters.get(0).get(j);
                String searchValue = parameters.get(i).get(j);
                switch (searchField.toLowerCase()) {
                    case "supplier name":
                        System.out.println("Enter Supplier Name");
                        claimSummaryPageObj.supplierFields(searchField).sendKeys(searchValue);
                        break;
                    case "supplier type":
                        System.out.println("Enter Supplier Type");
                        claimSummaryPageObj.supplierTypeImg().click();
                        claimSummaryPageObj.supplierType(searchValue).click();
                        break;
                    case "supplier provides medical assistance":
                        System.out.println("Enter Supplier Provides Medical Assistance");
                        claimSummaryPageObj.supplierFields(searchField).click();
                        break;
                    case "supplier email":
                        System.out.println("Enter Supplier Email");
                        claimSummaryPageObj.supplierFields(searchField).sendKeys(searchValue);
                        break;
                    case "supplier telephone":
                        System.out.println("Enter Supplier Telephone");
                        claimSummaryPageObj.supplierFields(searchField).sendKeys(searchValue);
                        break;
                    case "supplier address 1":
                        System.out.println("Enter Supplier Address 1");
                        claimSummaryPageObj.supplierFields(searchField).sendKeys(searchValue);
                        break;
                    case "supplier address 2":
                        System.out.println("Enter Supplier Address 2");
                        claimSummaryPageObj.supplierFields(searchField).sendKeys(searchValue);
                        break;
                    case "supplier town":
                        System.out.println("Enter Supplier Town");
                        claimSummaryPageObj.supplierFields(searchField).sendKeys(searchValue);
                        break;
                    case "supplier county":
                        System.out.println("Enter Supplier County");
                        claimSummaryPageObj.supplierFields(searchField).sendKeys(searchValue);
                        break;
                    case "supplier postcode":
                        System.out.println("Enter Supplier Postcode");
                        claimSummaryPageObj.supplierFields(searchField).sendKeys(searchValue);
                        break;
                    case "action":
                        System.out.println("Enter action");
                        basicClaimDetailsPageObj.supplierSave().click();
                        break;
                    case "agent name":
                        basicClaimDetailsPageObj.enterAgentFields(searchField).sendKeys(searchValue);
                        break;
                    case "agent email":
                        basicClaimDetailsPageObj.enterAgentFields(searchField).sendKeys(searchValue);
                        break;
                    case "gp name":
                        basicClaimDetailsPageObj.enterGPFields(searchField).sendKeys(searchValue);
                        Assert.assertTrue(basicClaimDetailsPageObj.enterGPFields(searchField).isDisplayed());
                        break;
                    case "surgery name":
                        basicClaimDetailsPageObj.enterGPFields(searchField).sendKeys(searchValue);
                        Assert.assertTrue(basicClaimDetailsPageObj.enterGPFields(searchField).isDisplayed());
                        break;
                    case "surgery address 1":
                        basicClaimDetailsPageObj.enterGPFields(searchField).sendKeys(searchValue);
                        Assert.assertTrue(basicClaimDetailsPageObj.enterGPFields(searchField).isDisplayed());
                        break;
                    case "surgery address 2":
                        basicClaimDetailsPageObj.enterGPFields(searchField).sendKeys(searchValue);
                        Assert.assertTrue(basicClaimDetailsPageObj.enterGPFields(searchField).isDisplayed());
                        break;
                    case "surgery address 3":
                        basicClaimDetailsPageObj.enterGPFields(searchField).sendKeys(searchValue);
                        Assert.assertTrue(basicClaimDetailsPageObj.enterGPFields(searchField).isDisplayed());
                        break;
                    case "surgery postcode":
                        basicClaimDetailsPageObj.enterGPFields(searchField).sendKeys(searchValue);
                        Assert.assertTrue(basicClaimDetailsPageObj.enterGPFields(searchField).isDisplayed());
                        break;
                    case "telephone number":
                        basicClaimDetailsPageObj.enterGPFields(searchField).sendKeys(searchValue);
                        Assert.assertTrue(basicClaimDetailsPageObj.enterGPFields(searchField).isDisplayed());
                        break;
                    case "contact name":
                        basicClaimDetailsPageObj.enterGPFields(searchField).sendKeys(searchValue);
                        Assert.assertTrue(basicClaimDetailsPageObj.enterGPFields(searchField).isDisplayed());
                        break;
                    case "do we have customer authorisation":
                        System.out.println("provide customer authorization");
                        claimSummaryPageObj.gpCheckRequiredFields(searchField).click();
                        break;

                }
            }
        }
    }

    public void verifySupplier(List<List<String>> parameters) {
        nextEventPageObj.btnClick(nextEventPageObj.go());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        this.enterGPDetails(parameters);
        // claimOperationObj.clickingUnderNextEventsAndButtons("Go");
    }

    public void makePaymentForContribution(String eventType, List<List<String>> paymentDetail) throws Throwable {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimOperationObj.clickingUnderNextEventsAndButtons("Save Payment");
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        claimOperationObj.navigateToEventType(eventType);
        policyOperationsObj.capturePaymentDetails(paymentDetail);
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        System.out.println("Account number ------" + policyOperationsObj.accountNumber);
        claimOperationObj.selectAccountNumber(policyOperationsObj.accountNumber);
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        claimOperationObj.navigateToEventType("Add Payment Comments");
        this.addPaymentComment(paymentDetail);
    }

    public void retrieveDataFromUIS() {
        policyDataFieldsPageObj.leadsTab().click();
        waitObj.waitForElementToLoad(claimPaymentPageObj.renewalTab());
        claimPaymentPageObj.renewalTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (!(claimPaymentPageObj.upgradeImportedFromUISchkboxValueChecked().getAttribute("value").equalsIgnoreCase("true"))) {
            System.out.println("Inside if condition for migration");
            claimPaymentPageObj.upgradeImportedFromUISchkbox().click();
        }
        claimPaymentPageObj.saveAndClosebtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void navigatingToThePolicy(String policy) {
        if (policy.equalsIgnoreCase("random")) {
            policy = quoteAndBuyOperationsObj.randomCustomerFullName;
        }
        navigationObj.navigateToImenu();
        navigationObj.navigateToLeadManager();
        schemeSummaryPageObj.navigateToPolicyInDashBorad(policy).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void paymentProcessWithExistingAccount(String paymentType,String accountDetails,String paymentMethod) {
        commandsObj.waitForLoad(nextEventPageObj.getDriver );
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        claimPaymentPageObj.selectAvailableAccountDetails(paymentType,accountDetails).click();
        commandsObj.waitForElementInVisibleInSec(org.openqa.selenium.By.id("pleasewait"), 60L);
        claimPaymentPageObj.savePaymentBtn().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        claimOperationObj.navigateToEventType("Select Payment Method");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimPaymentPageObj.paymentMethodInput().click();
        claimPaymentPageObj.paymentMethodValue(paymentMethod).click();
        claimPaymentPageObj.saveInPaymentMethod().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("refresh");
        System.out.println("before if------------------------------"+commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(policyDataFieldsPageObj.returnToTravelIncident())));
        if(commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(policyDataFieldsPageObj.returnToTravelIncident()))){
            System.out.println("after if------------------------------"+commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(policyDataFieldsPageObj.returnToTravelIncident())));
            policyDataFieldsPageObj.Return_Claim_to_Travel_Incident_Management().click();
            nextEventPageObj.btnClick(nextEventPageObj.go());
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
            policyDataFieldsPageObj.returnClaimReasons().click();
            policyDataFieldsPageObj.invalidReferralXpath().click();
            nextEventPageObj.saveBtn().click();
            policyDataFieldsPageObj.comments().sendKeys("Text");
            policyDataFieldsPageObj.finishButton().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        finalisePaymentPageObj.finalisePaymentAddComment().sendKeys("Existing Bank Account");
        finalisePaymentPageObj.paymetCommentSave().click();
    }

    public void selectWithExistingAccount(String paymentType,String accountDetails) {
        try {
            System.out.println("Entering Func selectWithExistingAccount ");
            commandsObj.waitForLoad(nextEventPageObj.getDriver);
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
            nextEventPageObj.waitForMoreTime();
            Thread.sleep(10000L);// Fix for appliation performance issue tt232
            claimPaymentPageObj.selectExistingAccForCompensation(paymentType, accountDetails).click();
            commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
            Thread.sleep(10000L);// Fix for appliation performance issue tt232
            nextEventPageObj.btnClick( claimPaymentPageObj.savePaymentBtn());
            commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
            Thread.sleep(10000L);// Fix for appliation performance issue tt323
            commandsObj.waitForLoad(nextEventPageObj.getDriver);
            nextEventPageObj.getDriver.navigate().refresh();
            commandsObj.waitForLoad(nextEventPageObj.getDriver);
            Thread.sleep(10000L);// Fix for appliation performance issue tt232
        }catch(Exception ex){
            System.out.println("Inside Exception-------------");
            ex.printStackTrace();
        }
        System.out.println("Exiting Func selectWithExistingAccount ");
    }

    public void partialPaymentProcessWithExistingAccount(String paymentType,String accountDetails,String paymentMethod) {
        commandsObj.waitForLoad(nextEventPageObj.getDriver );
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimPaymentPageObj.selectAvailableAccountDetails(paymentType,accountDetails).click();
        commandsObj.waitForElementInVisibleInSec(org.openqa.selenium.By.id("pleasewait"), 60L);
        claimPaymentPageObj.savePaymentBtn().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        claimOperationObj.navigateToEventType("Select Payment Method");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimPaymentPageObj.paymentMethodInput().click();
        claimPaymentPageObj.paymentMethodValue(paymentMethod).click();
        claimPaymentPageObj.saveInPaymentMethod().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
    }

    public void validateDetails(List<String> dropDownValues) {
        claimPaymentPageObj.txtDropDownValuesInPayeeType().click();
        for (int i = 0; i < dropDownValues.size(); i++) {
            System.out.println("value to verify------------------------" + dropDownValues.get(i));
            claimPaymentPageObj.drpdnfieldValue(dropDownValues.get(i));
            Assert.assertTrue(claimPaymentPageObj.drpdnfieldValue(dropDownValues.get(i)).isDisplayed());
        }
    }

    public void enterPaymentDetails(String eventType, List<List<String>> paymentDetail) throws Throwable {
        policyOperationsObj.enterNonPackagedPaymentDetails(paymentDetail);
    }

    public void validateDetailsForPaymentMethod(List<String> dropDownValues){
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimPaymentPageObj.selectPayeeMethod().click();
        for (int i = 0; i < dropDownValues.size(); i++) {
            System.out.println("value to verify------------------------" + dropDownValues.get(i));
            Assert.assertTrue(claimPaymentPageObj.selectPayeeMethodOption(dropDownValues.get(i)).isDisplayed());
        }
    }

    public void paymentprocessWithoutAddingPaymentComments(String paymentType,String accountDetails,String paymentMethod) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimPaymentPageObj.selectAvailableAccountDetails(paymentType,accountDetails).click();
        claimPaymentPageObj.savePaymentBtn().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        claimOperationObj.navigateToEventType("Select Payment Method");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimPaymentPageObj.paymentMethodInput().click();
        claimPaymentPageObj.paymentMethodValue(paymentMethod).click();
        claimPaymentPageObj.saveInPaymentMethod().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
    }

    public void selectPayeeForTMA(String txtpayee){
        System.out.println("Payee for TMA Claim is ------"+txtpayee);
        new Select(claimPaymentPageObj.txtPayeeTMA()).selectByVisibleText(txtpayee);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick( nextEventPageObj.nextButtonSensitive());
        nextEventPageObj.waitForPageLoad();
    }

    public void paymentProcessWithExistingThirdPartySupplierDetail(String paymentType,String accountDetails,String paymentMethod) {
        commandsObj.waitForLoad(nextEventPageObj.getDriver );
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        claimPaymentPageObj.selectAvailableAccountDetails(paymentType,accountDetails).click();
//        claimPaymentPageObj.btnVerifyAccount().click();
//        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
//        nextEventPageObj.waitForPageLoad();
//        claimPaymentPageObj.btnOverrideResult().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForPageLoad();
        commandsObj.waitForElementInVisibleInSec(org.openqa.selenium.By.id("pleasewait"), 60L);
        claimPaymentPageObj.savePaymentBtn().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        claimOperationObj.navigateToEventType("Select Payment Method");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimPaymentPageObj.paymentMethodInput().click();
        claimPaymentPageObj.paymentMethodValue(paymentMethod).click();
        claimPaymentPageObj.saveInPaymentMethod().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("refresh");
        System.out.println("before if------------------------------"+commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(policyDataFieldsPageObj.returnToTravelIncident())));
        if(commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(policyDataFieldsPageObj.returnToTravelIncident()))){
            System.out.println("after if------------------------------"+commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(policyDataFieldsPageObj.returnToTravelIncident())));
            policyDataFieldsPageObj.Return_Claim_to_Travel_Incident_Management().click();
            nextEventPageObj.btnClick(nextEventPageObj.go());
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
            policyDataFieldsPageObj.returnClaimReasons().click();
            policyDataFieldsPageObj.invalidReferralXpath().click();
            nextEventPageObj.saveBtn().click();
            policyDataFieldsPageObj.comments().sendKeys("Text");
            policyDataFieldsPageObj.finishButton().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        finalisePaymentPageObj.finalisePaymentAddComment().sendKeys("Existing Bank Account");
        finalisePaymentPageObj.paymetCommentSave().click();
    }

    public void selectExistingThirdPartySupplierAccount(String paymentType,String accountDetails,String paymentMethod){
        commandsObj.waitForLoad(nextEventPageObj.getDriver );
        String [] paymentSplit = paymentType.split("#");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        claimPaymentPageObj.selectAvailableAccountDetails(paymentSplit[0],accountDetails).click();
        commandsObj.waitForElementInVisibleInSec(org.openqa.selenium.By.id("pleasewait"), 60L);
        nextEventPageObj.waitForPageLoad();
       // Integer claimCost = Integer.parseInt(ClaimsOperations.claimAmount);
//        if(claimCost>500){
            claimPaymentPageObj.btnVerifyAccount().click();
            nextEventPageObj.waitForPageLoad();
//            if (paymentSplit.length>1){
//                verifyBankMessage(paymentSplit[1]);
//            }
            nextEventPageObj.waitForMoreTime();
        if ((commandsObj.elementDisplayedWithLessTime( By.xpath(claimPaymentPageObj.overrideVerificationResultButton()) ))) {
            System.out.println("**IF LOOP****");
            nextEventPageObj.btnClick(claimPaymentPageObj.btnOverrideResult());
        }
           // claimPaymentPageObj.btnOverrideResult().click();
//        }else{
//            if (paymentSplit.length>1) {
//                verifyBankMessage(paymentSplit[1]);
//            }
            claimPaymentPageObj.savePaymentBtn().click();
//        }
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        claimOperationObj.navigateToEventType("Select Payment Method");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimPaymentPageObj.paymentMethodInput().click();
        claimPaymentPageObj.paymentMethodValue(paymentMethod).click();
        claimPaymentPageObj.saveInPaymentMethod().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("refresh");
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        finalisePaymentPageObj.finalisePaymentAddComment().sendKeys("Existing Third party Account");
        finalisePaymentPageObj.paymetCommentSave().click();
    }

    public void verifyBankMessage(String message){
        Assert.assertTrue(claimPaymentPageObj.verifyBankValidationMessage(message).isDisplayed());
    }

    public String captureClaimItemAmount(WebElement wbTable, String col, int iRow){
        int iClaimAmountCol = webTableObj.getColumnFromWebTable(wbTable,col);
        int iClaimItemRow = iRow;
        String strClaimAmount = webTableObj.getCellValue(wbTable,iClaimItemRow,iClaimAmountCol);
        return strClaimAmount;
    }
}
