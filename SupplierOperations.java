package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.ClaimSummaryPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.pages.PolicyDataFieldsPage;
import co.uk.directlinegroup.tt.pages.SupplierDetailsPage;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.common.RandomGenerator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SupplierOperations {

    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private SupplierDetailsPage supplierDetailsPageObj = new SupplierDetailsPage();
    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private Commands commandsObj = new Commands();
    private TMADetails tmaDetailsObj = new TMADetails();
    private RandomGenerator randomGeneratorObj = new RandomGenerator();
    private Navigation navigationObj = new Navigation();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();

    private String sysDate = "";
    public static String matterId = "";
    public static String caseId = "";
    public static String saveSupplierName = "";
    public static String saveSupplierType = "";



    public void addSupplierDetails(String personType, List<List<String>> supplierDetails) {

        for (int i = 1; i < supplierDetails.size(); i++) {
            for (int j = 0; j < supplierDetails.get(i).size(); j++) {
                this.enterSupplierDetails(supplierDetails.get(0).get(j), supplierDetails.get(i).get(j));
            }
        }
    }

    private void enterSupplierDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "policy type":
                new Select(policyDataFieldsPageObj.policyType()).selectByVisibleText(fieldValue);
                break;
            case "supplier name":
                if (fieldValue.equalsIgnoreCase("random")) {
                    System.out.println("Inside Random");
                    fieldValue = randomGeneratorObj.randomString(4);
                    claimsOperationsObj.retrieveRandomSupplierName = fieldValue;
                    System.out.println("Random supplier name---------------------" + claimsOperationsObj.retrieveRandomSupplierName);
                    this.businessName(fieldValue);
                } else {
                    this.businessName(fieldValue);
                }
                break;
            case "address1":
                policyDataFieldsPageObj.supplierAddress1().clear();
                policyDataFieldsPageObj.supplierAddress1().sendKeys(fieldValue);
                break;
            case "address2":
                policyDataFieldsPageObj.supplierAddress2().clear();
                policyDataFieldsPageObj.supplierAddress2().sendKeys(fieldValue);
                break;
            case "town":
                policyDataFieldsPageObj.supplierTown().clear();
                policyDataFieldsPageObj.supplierTown().sendKeys(fieldValue);
                break;
            case "county":
                policyDataFieldsPageObj.supplierCounty().clear();
                policyDataFieldsPageObj.supplierCounty().sendKeys(fieldValue);
                break;
            case "postcode":
                policyDataFieldsPageObj.supplierPostcode().clear();
                policyDataFieldsPageObj.supplierPostcode().sendKeys(fieldValue);
                break;
            case "email":
                policyDataFieldsPageObj.supplierEmail().clear();
                policyDataFieldsPageObj.supplierEmail().sendKeys(fieldValue);
                break;
            case "telephone":
                policyDataFieldsPageObj.supplierTelephone().clear();
                policyDataFieldsPageObj.supplierTelephone().sendKeys(fieldValue);
                break;
            case "fax":
                policyDataFieldsPageObj.supplierFax().clear();
                policyDataFieldsPageObj.supplierFax().sendKeys(fieldValue);
                break;
            case "accept":
                policyDataFieldsPageObj.saveCust().click();
                break;
            case "update":
                policyDataFieldsPageObj.updateBusinessBtn().click();
                commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(),60L);

                break;
        }
    }

    public void enterSupplierCoreDetails(List<List<String>> supplierDetails) {
        for (int i = 1; i < supplierDetails.size(); i++) {
            for (int j = 0; j < supplierDetails.get(i).size(); j++) {
                this.enterCoreDetailsForSupplier(supplierDetails.get(0).get(j), supplierDetails.get(i).get(j));
            }
        }
        policyDataFieldsPageObj.policySave().click();
    }

    private void enterCoreDetailsForSupplier(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "company name":
                supplierDetailsPageObj.companyName().click();
                nextEventPageObj.switchToFrameById(nextEventPageObj.findElement(By.name("PagesDialogWindow")));
                supplierDetailsPageObj.selectCompanyName().click();
                supplierDetailsPageObj.switchToDefault();
                supplierDetailsPageObj.switchToFrameById(nextEventPageObj.frame());
                break;
            case "trading as":
                supplierDetailsPageObj.tradingAs().clear();
                supplierDetailsPageObj.tradingAs().sendKeys(fieldValue);
                break;
            case "country for vat":
                supplierDetailsPageObj.countryForVAT().click();
                supplierDetailsPageObj.countryForVATValue(fieldValue).click();
                break;
            case "area":
                supplierDetailsPageObj.area().click();
                supplierDetailsPageObj.areaValue(fieldValue).click();
                break;
            case "region":
                supplierDetailsPageObj.countriesRegionAs().click();
                supplierDetailsPageObj.countriesRegionAsValue().click();
                break;
            case "checked date":
                supplierDetailsPageObj.creditCheckedDate().clear();
                supplierDetailsPageObj.creditCheckedDate().sendKeys(fieldValue);
                break;
            case "due date":
                supplierDetailsPageObj.dueDiligenceDate().clear();
                supplierDetailsPageObj.dueDiligenceDate().sendKeys(fieldValue);
                break;
            case "website":
                supplierDetailsPageObj.website().clear();
                supplierDetailsPageObj.website().sendKeys(fieldValue);
                break;
            case "supplier status":
                supplierDetailsPageObj.supplierStatus().click();
                supplierDetailsPageObj.supplierStatusValue(fieldValue).click();
                break;
            case "supplier type":
                System.out.println("Supplier case-------------------------");
                supplierDetailsPageObj.supplierType().click();
                supplierDetailsPageObj.supplierTypeValue(fieldValue).click();
                break;
            case "company registration no":
                supplierDetailsPageObj.companyRegistrationNumber().clear();
                supplierDetailsPageObj.companyRegistrationNumber().sendKeys(fieldValue);
                break;
            case "country of registration":
                supplierDetailsPageObj.countryOfRegistration().click();
                supplierDetailsPageObj.countryOfRegistrationValue(fieldValue).click();
                break;
            case "vat number":
                supplierDetailsPageObj.VATNumber().clear();
                supplierDetailsPageObj.VATNumber().sendKeys(fieldValue);
                break;
            case "preferred payment method":
                supplierDetailsPageObj.preferredPaymentMethod().click();
                supplierDetailsPageObj.preferredPaymentMethodValue(fieldValue).click();
                break;
            case "comments":
                supplierDetailsPageObj.supplierComments().clear();
                supplierDetailsPageObj.supplierComments().sendKeys(fieldValue);
                break;
            case "service level agreement":
                supplierDetailsPageObj.serviceLevelAgreement().clear();
                supplierDetailsPageObj.serviceLevelAgreement().sendKeys(fieldValue);
                break;
            case "payment terms":
                supplierDetailsPageObj.paymentTerms().clear();
                supplierDetailsPageObj.paymentTerms().sendKeys(fieldValue);
                break;
            case "opening hours":
                supplierDetailsPageObj.openingHours().clear();
                supplierDetailsPageObj.openingHours().sendKeys(fieldValue);
                break;
            case "name of contact":
                supplierDetailsPageObj.nameOfContact().clear();
                supplierDetailsPageObj.nameOfContact().sendKeys(fieldValue);
                break;
            case "money transfer":
                supplierDetailsPageObj.moneyTransfer().click();
                break;
            case "travel agent":
                supplierDetailsPageObj.travelAgent().click();
                break;
            case "air ambulance":
                supplierDetailsPageObj.ambulance().click();
                break;
            case "cost container":
                supplierDetailsPageObj.costContainer().click();
                break;
            case "funeral directors":
                supplierDetailsPageObj.funeralDirectors().click();
                break;
            case "supplier type meaningful for export":
                supplierDetailsPageObj.supplierTypeMeaningfullForExport().click();
                supplierDetailsPageObj.supplierTypeMeaningfullForExportValue(fieldValue).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "supplier type in frame":
//                supplierDetailsPageObj.companyName().click();
//                nextEventPageObj.switchToFrameById(nextEventPageObj.findElement(By.name("PagesDialogWindow")));
//                supplierDetailsPageObj.supplierTypeInFrame().sendKeys(fieldValue);
//                supplierDetailsPageObj.supplierTypeInFrameFilter().click();
//                supplierDetailsPageObj.containsFilter().click();
//                supplierDetailsPageObj.selectCompanyName(fieldValue).click();
//                supplierDetailsPageObj.switchToDefault();
//                supplierDetailsPageObj.switchToFrameById(nextEventPageObj.frame());
                supplierDetailsPageObj.supplierTypeInFrame().click();
                supplierDetailsPageObj.supplierTypeInFrameoption(fieldValue).click();
                break;
            case "surgery name":
                supplierDetailsPageObj.surgeryName().sendKeys(fieldValue);
                break;
            case "address1":
                supplierDetailsPageObj.surgeryAddressLine1().sendKeys(fieldValue);
                break;
            case "address2":
                supplierDetailsPageObj.surgeryAddressLine2().sendKeys(fieldValue);
                break;
            case "town":
                supplierDetailsPageObj.townInput().sendKeys(fieldValue);
                break;
            case "country":
                nextEventPageObj.btnClick(supplierDetailsPageObj.countryInput());
                supplierDetailsPageObj.countryOption(fieldValue).click();
                break;
            case "business name":
                supplierDetailsPageObj.companyName().click();
                nextEventPageObj.switchToFrameById(nextEventPageObj.findElement(By.name("PagesDialogWindow")));
                supplierDetailsPageObj.txtboxFilter().sendKeys(fieldValue);
//                supplierDetailsPageObj.btnNameFilter().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(supplierDetailsPageObj.btnNameFilter());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(supplierDetailsPageObj.filterDropDwnValue());
//                supplierDetailsPageObj.filterDropDwnValue().click();
                nextEventPageObj.waitForMoreTime();
                supplierDetailsPageObj.btnSelect(fieldValue).click();
                supplierDetailsPageObj.switchToDefault();
                supplierDetailsPageObj.switchToFrameById(nextEventPageObj.frame());
                break;
            case "supplier type1":
                supplierDetailsPageObj.supplierType1().click();
                supplierDetailsPageObj.supplierTypeValue(fieldValue).click();
                break;
            case "supplier type2":
                supplierDetailsPageObj.supplierType2().click();
                supplierDetailsPageObj.supplierTypeValue(fieldValue).click();
                break;
            case "supplier type3":
                supplierDetailsPageObj.supplierType3().click();
                supplierDetailsPageObj.supplierTypeValue(fieldValue).click();
                break;
            case "suppliertype mandatory":
                supplierDetailsPageObj.supplierType_MandatoryFieldImg().click();
                supplierDetailsPageObj.supplierType_MandatoryFieldValue(fieldValue).click();
                break;

            case "validate supplier type":
                System.out.println("Entered value is----" + supplierDetailsPageObj.supplierType().getAttribute("value"));
                Assert.assertTrue(supplierDetailsPageObj.supplierType().getAttribute("value").trim().equalsIgnoreCase(fieldValue));
                System.out.println("Validated supplier detail is " + fieldValue);
                System.out.println("Supplier type is validated");
                break;
            case "validate payment method":
                System.out.println("Entered value is----" + supplierDetailsPageObj.preferredPaymentMethod().getAttribute("value"));
                Assert.assertTrue(supplierDetailsPageObj.preferredPaymentMethod().getAttribute("value").equalsIgnoreCase(fieldValue));
                System.out.println("Validated supplier detail is " + fieldValue);
                System.out.println("Supplier type is validated");
                break;


        }
    }

    public void enterSupplierBankDetails(List<List<String>> supplierDetails) {
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < supplierDetails.size(); i++) {
            for (int j = 0; j < supplierDetails.get(i).size(); j++) {
                this.enterBankDetail(supplierDetails.get(0).get(j), supplierDetails.get(i).get(j));
            }
        }
        policyDataFieldsPageObj.policySave().click();

    }

    private void enterBankDetail(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "bank name":
                supplierDetailsPageObj.bankName().clear();
                supplierDetailsPageObj.bankName().sendKeys(fieldValue);
                break;
            case "bank address":
                supplierDetailsPageObj.bankAddress().clear();
                supplierDetailsPageObj.bankAddress().sendKeys(fieldValue);
                break;
            case "postcode":
                supplierDetailsPageObj.bankPostcode().clear();
                supplierDetailsPageObj.bankPostcode().sendKeys(fieldValue);
                break;
            case "bank country":
                supplierDetailsPageObj.bankCountry().clear();
                supplierDetailsPageObj.bankCountry().sendKeys(fieldValue);
                break;
            case "sort code":
                supplierDetailsPageObj.sortCode().clear();
                supplierDetailsPageObj.sortCode().sendKeys(fieldValue);
                break;
            case "account number":
                supplierDetailsPageObj.accountNumber().clear();
                supplierDetailsPageObj.accountNumber().sendKeys(fieldValue);
                break;
            case "iban number":
                if (!fieldValue.contains("only"))
                    supplierDetailsPageObj.IBANNumber().sendKeys(fieldValue);
                break;
            case "bic number":
                if (!fieldValue.contains("only"))
                    supplierDetailsPageObj.BICNumber().sendKeys(fieldValue);
                break;
            case "town":
                supplierDetailsPageObj.townInput().sendKeys(fieldValue);
                break;
            case "county":
                supplierDetailsPageObj.countyInput().sendKeys(fieldValue);
                break;
            case "account sub type":
                saveSupplierType = fieldValue;
                supplierDetailsPageObj.accountSubTypeInput().click();
                supplierDetailsPageObj.accountSubTypeOption(fieldValue).click();
                break;
            case "account holder name":
                supplierDetailsPageObj.accountHolderNameInput().sendKeys(fieldValue);
                break;
            case "account holder first name":
                supplierDetailsPageObj.accountHolderFirstNameInput().sendKeys(fieldValue);
                break;
            case "account holder second name":
                supplierDetailsPageObj.accountHolderSecondNameInput().sendKeys(fieldValue);
                break;
            case "country":
                supplierDetailsPageObj.countryInput().click();
                supplierDetailsPageObj.countryOption(fieldValue).click();
                break;
            case "account type":
                supplierDetailsPageObj.accountTypeInput().click();
                supplierDetailsPageObj.accountTypeOption(fieldValue).click();
                break;
            case "address 1":
                supplierDetailsPageObj.address1Input().sendKeys(fieldValue);
                break;
            case "address 2":
                supplierDetailsPageObj.address2Input().sendKeys(fieldValue);
                break;

            case "validate account details":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("Entered Bank detail is  " + supplierDetailsPageObj.txtAccountDetails().getText());
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue(supplierDetailsPageObj.txtAccountDetails().getText().contains(fieldValue));
                System.out.println("Validated account detail is " + fieldValue);
                nextEventPageObj.waitForMoreTime();
                break;
        }
    }

    public void amendSupplierDetails(List<List<String>> supplierDetails) {
        for (int i = 1; i < supplierDetails.size(); i++) {
            for (int j = 0; j < supplierDetails.get(i).size(); j++) {
                this.enterCoreDetailsForSupplier(supplierDetails.get(0).get(j), supplierDetails.get(i).get(j));
            }
        }
        supplierDetailsPageObj.saveAndCloseBtn().click();
    }

    public void amendSupplierBankDetails(List<List<String>> supplierDetails) {
        for (int i = 1; i < supplierDetails.size(); i++) {
            for (int j = 0; j < supplierDetails.get(i).size(); j++) {
                this.enterBankDetail(supplierDetails.get(0).get(j), supplierDetails.get(i).get(j));
            }
        }
        this.sysDate = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()).toString();
        supplierDetailsPageObj.saveAndCloseBtn().click();
    }

    public void verifyChangeTable(String dtValue, String dtDate, String dtChangedBy, String valueToCheck) {
        String listColOfOldValue = "";
        if (valueToCheck.equalsIgnoreCase("old"))
            listColOfOldValue = "//table[contains(@class,'MasterTable_Default gridrgHistory')]/tbody/tr[last()]";
        else if (valueToCheck.equalsIgnoreCase("updated"))
            listColOfOldValue = "//table[contains(@class,'MasterTable_Default gridrgHistory')]/tbody/tr[last()]/preceding-sibling::tr";
        int ivalue = 1;
        int idate = 2;
        int ichangedBy = 3;
        String sValue = nextEventPageObj.findElement(By.xpath(listColOfOldValue + "/td[" + ivalue + "]")).getText();
        String sDate = nextEventPageObj.findElement(By.xpath(listColOfOldValue + "/td[" + idate + "]")).getText();
        String sChangedByWhom = nextEventPageObj.findElement(By.xpath(listColOfOldValue + "/td[" + ichangedBy + "]")).getText();
        Assert.assertTrue(sValue.equalsIgnoreCase(dtValue));
        this.sysDate = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()).toString();
        Assert.assertTrue(sDate.contains(this.sysDate));
        Assert.assertTrue(sChangedByWhom.equalsIgnoreCase(dtChangedBy));
    }

    public void verifyUpdatedDetailsInLeadDetails(List<List<String>> supplierDetails) {
        supplierDetailsPageObj.leadDetails().click();
        for (int i = 1; i < supplierDetails.size(); i++) {
            for (int j = 0; j < supplierDetails.get(i).size(); j++) {
                this.verifyLeadDetails(supplierDetails.get(0).get(j), supplierDetails.get(i).get(j));
            }
        }
        supplierDetailsPageObj.saveAndCloseBtn().click();
    }

    private void verifyLeadDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "service level agreement":
                String valueFromPageForServiceLevel = supplierDetailsPageObj.serviceLevelAgreement().getAttribute("value");
                System.out.println("valueFromPageForServiceLevel-------------------" + valueFromPageForServiceLevel);
                Assert.assertTrue(valueFromPageForServiceLevel.equalsIgnoreCase(fieldValue));
                break;
            case "payment terms":
                String valueFromPageForPaymenterms = supplierDetailsPageObj.paymentTerms().getAttribute("value");
                System.out.println("valueFromPageForPaymenterms---------------" + valueFromPageForPaymenterms);
                Assert.assertTrue(valueFromPageForPaymenterms.equalsIgnoreCase(fieldValue));
                break;
        }
    }

    public void enteringPaymentDetails(List<List<String>> paymentDetails) {

        for (int i = 1; i < paymentDetails.size(); i++) {
            for (int j = 0; j < paymentDetails.get(0).size(); j++) {
                this.enterPaymentDetials(paymentDetails.get(0).get(j), paymentDetails.get(i).get(j));
            }
        }
        supplierDetailsPageObj.invoiceSaveBtn().click();
    }

    private void enterPaymentDetials(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "reason":
                supplierDetailsPageObj.reasonForNotValidating().clear();
                supplierDetailsPageObj.reasonForNotValidating().sendKeys(fieldValue);
                break;
            case "postcode":
                supplierDetailsPageObj.postcodeInput().clear();
                supplierDetailsPageObj.postcodeInput().sendKeys(fieldValue);
                break;
            case "bank name":
                supplierDetailsPageObj.bankNameInput().clear();
                supplierDetailsPageObj.bankNameInput().sendKeys(fieldValue);
                break;
            case "account number":
                supplierDetailsPageObj.accountNumberInput().clear();
                supplierDetailsPageObj.accountNumberInput().sendKeys(fieldValue);
                break;
            case "sort code":
                supplierDetailsPageObj.sortCodeInput().clear();
                supplierDetailsPageObj.sortCodeInput().sendKeys(fieldValue);
                break;
            case "address 1":
                supplierDetailsPageObj.address1Input().clear();
                supplierDetailsPageObj.address1Input().sendKeys(fieldValue);
                break;
            case "address 2":
                supplierDetailsPageObj.address2Input().clear();
                supplierDetailsPageObj.address2Input().sendKeys(fieldValue);
                break;
            case "town":
                supplierDetailsPageObj.townInput().clear();
                supplierDetailsPageObj.townInput().sendKeys(fieldValue);
                break;
            case "county":
                supplierDetailsPageObj.countyInput().clear();
                supplierDetailsPageObj.countyInput().sendKeys(fieldValue);
                break;
            case "account sub type":
                supplierDetailsPageObj.accountSubTypeInput().click();
                supplierDetailsPageObj.accountSubTypeOption(fieldValue).click();
                break;
            case "account holder name":
                supplierDetailsPageObj.accountHolderNameInput().clear();
                supplierDetailsPageObj.accountHolderNameInput().sendKeys(fieldValue);
                break;
            case "country":
                supplierDetailsPageObj.countryInput().click();
                supplierDetailsPageObj.countryOption(fieldValue).click();
                break;
            case "account type":
                supplierDetailsPageObj.accountTypeInput().click();
                supplierDetailsPageObj.accountTypeOption(fieldValue).click();
                break;

        }
    }

    public void navigateToEvent(String option) {
    }

    public void verifyingPaidInvoice() {
        supplierDetailsPageObj.editFirstSupplier().click();
        commandsObj.waitForLoad(supplierDetailsPageObj.getDriver);
        supplierDetailsPageObj.paidInvoicesTab().click();
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
        String claimId =supplierDetailsPageObj.invoicePaidForClaim().getText();
        System.out.println();
        Assert.assertTrue(claimId.equalsIgnoreCase(claimsOperationsObj.claimID));
        supplierDetailsPageObj.saveAndCloseBtn().click();
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
        commandsObj.waitForLoad(supplierDetailsPageObj.getDriver);
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
    }

    public void verifyRemittanceAdviceNotification() {
        supplierDetailsPageObj.remittanceNotificationLink().click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frameEditEvent());
        supplierDetailsPageObj.emailTab().click();
        Assert.assertTrue(supplierDetailsPageObj.invoicePaidMessage().isDisplayed());
        supplierDetailsPageObj.closeNotification().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void verifyPreferredPaymentMethodValue(String paymentMethod) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        String paymentMethodFromPage = supplierDetailsPageObj.preferredPaymentMethod().getAttribute("value");
        System.out.println("paymentMethodFromPage------------------------" + paymentMethodFromPage);
        Assert.assertTrue(paymentMethodFromPage.equalsIgnoreCase(paymentMethod));
    }

    public void verifyTheCurrencyConversion(String currencySelected) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        String amount = supplierDetailsPageObj.totalDueInGBP().getText();
        System.out.println("amount.isEmpty()-----------------------" + amount.isEmpty() + " -------------amount----------------------" + amount);
        Assert.assertTrue(!amount.isEmpty());
    }

    public void getTheMatterId() {
        matterId = supplierDetailsPageObj.matterInSupplier().getText();
        System.out.println("matter id ----------------------------" + matterId);
    }


    public void verifyUpdatedPaymentDetails(String accountType, String accountNumber) {
        supplierDetailsPageObj.leadDetails().click();
        supplierDetailsPageObj.supplierBankDetailsTab().click();
        //   supplierDetailsPageObj.payme
    }

    public void validatingAccountDetails(String accountValidation) {
        //Below line has be added because of the change in the flow
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.btnClick( nextEventPageObj.nextButtonSensitive());
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.btnClick(supplierDetailsPageObj.validateBankAccount());
        nextEventPageObj.waitForMoreTime();

            if (accountValidation.equalsIgnoreCase("valid")) {
                System.out.println("supplierDetailsPageObj.validationMessage().getText()---------------------------------" + supplierDetailsPageObj.validationMessage().getText());

                Assert.assertTrue(supplierDetailsPageObj.validationMessage().getText().equalsIgnoreCase("Validated sort code and account number."));
                supplierDetailsPageObj.validationSaveBtn().click();
            } else if (accountValidation.equalsIgnoreCase("validate cheque")) {
//                Assert.assertTrue(supplierDetailsPageObj.validationMessage().getText().equalsIgnoreCase("Cheque account type - validation on account and sort code is not applicable"));
                supplierDetailsPageObj.validationSaveBtn().click();
            } else if (accountValidation.equalsIgnoreCase("invalid")) {
                //  Assert.assertTrue(supplierDetailsPageObj.validationMessage().getText().contains("not Successful"));
                supplierDetailsPageObj.cancelBtn().click();
            }else if(accountValidation.equalsIgnoreCase("validate bank")){
                System.out.println("validate bank");
                Assert.assertTrue(supplierDetailsPageObj.validateBankMessage().getText().equalsIgnoreCase("Account number and sortcode validation check result: VALID"));
                nextEventPageObj.btnClick(supplierDetailsPageObj.validationSaveBtn());
//                  supplierDetailsPageObj.overrideBtn().click();

            }else if (accountValidation.equalsIgnoreCase("invalidate bank")){
                Assert.assertTrue(supplierDetailsPageObj.validationInvalidBankMessage().getText().equalsIgnoreCase("Account number and sortcode validation check result: INVALID - Modulus Check Failed"));
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(supplierDetailsPageObj.btnOverrideResult());
            }
            nextEventPageObj.switchToDefault();
            commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
            commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
            commandsObj.waitForLoad(nextEventPageObj.getDriver);
            //TODO Sujeetha - This needs to be removed once the application is stable
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }

    public void verifyChequeDetailsAreNotDisplayed() {
        Assert.assertTrue(commandsObj.elementDisplayedWithLessTime(By.xpath(supplierDetailsPageObj.chequeDetailsXpath())));
    }


    public void verifyPaidInvoices() {
       /* supplierDetailsPageObj.editFirstSupplier().click();
        supplierDetailsPageObj.paidInvoicesTab().click();
   //     for(int i = 0 ; i < tmaDetailsObj.claimIDList.size() ; i++){
            System.out.println("list------------------------"+claimsOperationsObj.claimID);
            Assert.assertTrue(nextEventPageObj.findElement(By.xpath("/*//*[contains(text(),'"+claimsOperationsObj.claimID+"')]")).isDisplayed());
     //   }*/
        //  claimsOperationsObj.claimID = "55292981";
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        supplierDetailsPageObj.editFirstSupplier().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        supplierDetailsPageObj.paidInvoicesTab().click();
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        List<WebElement> claimId = nextEventPageObj.findElements(By.xpath(supplierDetailsPageObj.invoicePaidForClaimXpath()));
        boolean flag = false;
        for (int i = 0; i < claimId.size(); i++) {
            String id = claimId.get(i).getText();
            System.out.println("claimId from table----------------" + id);
            System.out.println("claimId from table---------claimsOperationsObj.claimID-------" + claimsOperationsObj.claimID);
            if (id.equalsIgnoreCase(claimsOperationsObj.claimID)) {
                System.out.println("true----------------------------------");
                flag = true;
                break;
            }
        }
        System.out.println("Flag-------------------------" + flag);
        if (flag) {
            Assert.assertTrue(flag);
        } else {
            Assert.assertTrue(flag);
        }
        supplierDetailsPageObj.saveAndCloseBtn().click();
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
    }

    public void retrieveSupplier(String supplierId) {

    }

    public void rushPaymentDetails(List<List<String>> rushPaymentDetails) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimsOperationsObj.clickingUnderNextEventsAndButtons("add a jumpto event");
        claimsOperationsObj.navigateToEventType("Rush Payment Request");
        this.enterPaymentDetails(rushPaymentDetails);
    }

    public void enterPaymentDetails(List<List<String>> rushPaymentDetails) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        caseId = supplierDetailsPageObj.caseId().getText();
        for (int i = 1; i < rushPaymentDetails.size(); i++) {
            for (int j = 0; j < rushPaymentDetails.get(0).size(); j++) {
                switch (rushPaymentDetails.get(0).get(j).toLowerCase()) {
                    case "approve":
                        supplierDetailsPageObj.approveRushPayment().click();
                        supplierDetailsPageObj.approveRushPaymentOption(rushPaymentDetails.get(i).get(j)).click();
                        break;
                    case "rush payment request 1":
                        supplierDetailsPageObj.rushPaymentRequest1().sendKeys(rushPaymentDetails.get(i).get(j));
                        break;
                    case "rush payment request 2":
                        supplierDetailsPageObj.rushPaymentRequest2().sendKeys(rushPaymentDetails.get(i).get(j));
                        break;
                    case "action":
                        supplierDetailsPageObj.invoiceSaveBtn().click();
                        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
                        commandsObj.waitForLoad(nextEventPageObj.getDriver);
                        break;
                }
            }
        }
    }

    public void getLeadIdCaseId() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        claimsOperationsObj.clickingUnderNextEventsAndButtons("out of process event");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        caseId = supplierDetailsPageObj.caseId().getText();
        supplierDetailsPageObj.cancelBtn().click();
    }

    public void verifyTaskGenerated() {
        boolean flag = false;
        List<WebElement> caseIdElements = nextEventPageObj.findElements(By.xpath(policyDataFieldsPageObj.workflowcaseidXpath()));
        String caseIdFromScreen ="";
        for (int i = 0 ; i < caseIdElements.size() ; i++){
          caseIdFromScreen = caseIdElements.get(i).getText();
            System.out.println("caseIdFromScreen::  "+caseIdFromScreen);
            System.out.println("caseID :: "+caseId);
            if (caseIdFromScreen.equalsIgnoreCase(caseId)){
                flag=true;
                break;
            }
        }
        if (flag) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void verifyTaskIsNotListed() {
        System.out.println("caseId:: "+caseId);
        String caseIdFromScreen = policyDataFieldsPageObj.workflowcaseid().getText();
        System.out.println("caseIdFromScreen:: "+caseIdFromScreen);
        Assert.assertTrue(!caseIdFromScreen.equalsIgnoreCase(caseId));
    }

    public void verifyPaidBulkInvoicesForSupplier() {
        supplierDetailsPageObj.editFirstSupplier().click();
        nextEventPageObj.waitForPageLoad();
        supplierDetailsPageObj.paidInvoicesTab().click();
        nextEventPageObj.waitForPageLoad();
        for (int i = 0; i < tmaDetailsObj.claimIDList.size(); i++) {
//            System.out.println("size of invoices----" + tmaDetailsObj.claimIDList.size());
//            System.out.println("list------------------------" + tmaDetailsObj.claimIDList.get(i));
////            Assert.assertTrue(nextEventPageObj.findElement(By.xpath("//*[contains(text(),'" + tmaDetailsObj.claimIDList.get(i) + "')]")).isDisplayed());
//            commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath("//*[contains(text(),'" + tmaDetailsObj.claimIDList.get(i) + "')]"));
//            commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath("//*[contains(text(),'" + tmaDetailsObj.claimItemIDList.get(i) + "')]"));
//            System.out.println("Claim item id is displayed");
            System.out.println("Claim item id------------------------" + tmaDetailsObj.claimIDList.get(i));
            Assert.assertTrue(supplierDetailsPageObj.paidClaimItemId(i).getText().equalsIgnoreCase(tmaDetailsObj.claimIDList.get(i)));
        }
        nextEventPageObj.btnCloseWindow().click();
    }

    public void businessName(String businessName) {
        if (businessName.equalsIgnoreCase("random")) {
            businessName = randomGeneratorObj.randomString(4);
        }
        policyDataFieldsPageObj.businessName().sendKeys(businessName);
    }

    public void verifyDuplicateSupplier(String ErrorMsg) {
        String duplicateSuppliereErrorMsg = ""; // code to be added once the build is available for defect 826 (may be a CR)
        Assert.assertTrue(duplicateSuppliereErrorMsg.equalsIgnoreCase(ErrorMsg));
    }

    public void paymentToClaim(List<List<String>> paymentDetails) {
        for (int i = 1; i < paymentDetails.size(); i++) {
            for (int j = 0; i < paymentDetails.get(0).size(); j++) {
                switch (paymentDetails.get(0).get(j).toLowerCase()) {
                    case "event":
                        claimsOperationsObj.clickingUnderNextEventsAndButtons("add an out of process event");
                        navigationObj.navigateToNextEventType(paymentDetails.get(i).get(j));
                        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
                        break;
                    case "claim id":
                        supplierDetailsPageObj.invoiceClaimIdInput().sendKeys();
                        break;
                }

            }
        }
    }

    public void searchClaimForPayment() {
//        claimsOperationsObj.claimID="55281244";
        navigationObj.navigateToNextEventType("Create Invoice - Start");
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        supplierDetailsPageObj.invoiceClaimIdInput().clear();
        supplierDetailsPageObj.invoiceClaimIdInput().sendKeys(claimsOperationsObj.claimID);
        supplierDetailsPageObj.searchClaimInvoice().click();
        supplierDetailsPageObj.selectClaimToUpdate().click();
        new Select(supplierDetailsPageObj.invoiceClaimItemIdSelect()).selectByIndex(0);
        supplierDetailsPageObj.createInvoiceButton().click();
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
    }

    public String returnSupplierRandomName() {
        this.saveSupplierName = claimsOperationsObj.retrieveRandomSupplierName;
        return saveSupplierName;
    }

    public void verifyClaimItemInTheDropdown(List<List<String>> claimItemVal) {
        boolean flag = false;
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        supplierDetailsPageObj.selectClaimToUpdate().click();
        List<WebElement> claimItemDropdownOption = nextEventPageObj.findElements(By.xpath(supplierDetailsPageObj.selectClaimItem()));
        System.out.println("claimItemDropdownOption.get(i).getText()---------outside for loop-----" + claimItemDropdownOption.get(0).getText());
        for (int i = 0; i < claimItemDropdownOption.size(); i++) {
            for (int j = 0; j < claimItemVal.get(0).size(); j++) {
                System.out.println("claimItemDropdownOption.get(i).getText()---------------------" + claimItemDropdownOption.get(i).getText());
                if (claimItemDropdownOption.get(i).getText().contains(claimItemVal.get(1).get(j))) {
                    flag = true;
                    System.out.println("claimItemDropdownOption.get(i).getText().contains(claimItemVal.get(0).get(j))------------inside if loop-" + claimItemDropdownOption.get(i).getText().contains(claimItemVal.get(0).get(j)));
                    break;
                }
            }
        }
        if (flag) {
            Assert.assertTrue(flag);
        } else
            Assert.assertTrue(flag);
    }

    public void verifyPrepopulatedInvoiceDate(List<List<String>> invoiceDetails) {
        new Select(supplierDetailsPageObj.invoiceClaimItemIdSelect()).selectByIndex(0);
        supplierDetailsPageObj.createInvoiceButton().click();
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
//        claimsOperationsObj.customerName ="PayTMA";
//        claimsOperationsObj.customerLastName = "Supplier";
//        claimsOperationsObj.customerDOB="10/10/1986";
//        claimsOperationsObj.countryOfLoss = "France";
//        claimsOperationsObj.claimID = "55289162";
//        claimsOperationsObj.claimItemId="52140559";
//        claimsOperationsObj.claimDate = "03/03/2018";
        for (int i = 1; i < invoiceDetails.size(); i++) {
            for (int j = 0; j < invoiceDetails.get(0).size(); j++) {
                switch (invoiceDetails.get(0).get(j).toLowerCase()) {
                    case "customer name":
                        String customerName = supplierDetailsPageObj.patientNameInInvoiceTable().getText();
                        System.out.println("customerName-----------in table-------------" + customerName);
                        Assert.assertTrue(customerName.equalsIgnoreCase("Mr"+" "+claimsOperationsObj.customerName + " " + claimsOperationsObj.customerLastName));
                        break;
                    case "dob":
                        String customerDOB = supplierDetailsPageObj.patientDobInInvoiceTable().getText();
                        System.out.println("customerDOB-----------in table-------------" + customerDOB);
                        String dateFromPage = customerDOB.split("-")[2];
                        String monthFromPage = customerDOB.split("-")[1];
                        String yearFromPage = customerDOB.split("-")[0];
                        String actualDateFromDOB = claimsOperationsObj.customerDOB.split("/")[0];
                        String actualMonthFromDOB = claimsOperationsObj.customerDOB.split("/")[1];
                        String actualYearFromDOB = claimsOperationsObj.customerDOB.split("/")[2];
                        System.out.println("expected date format--------------"+claimsOperationsObj.customerDOB);
                        System.out.println("dateFromPage-----+++++actualDateFromDOB---------"+dateFromPage+"----------------"+actualDateFromDOB);
                        System.out.println("monthFromPage-----+++++monthFromPage---------"+monthFromPage+"----------------"+actualMonthFromDOB);
                        System.out.println("yearFromPage-----+++++yearFromPage---------"+yearFromPage+"----------------"+actualYearFromDOB);
                        Assert.assertTrue(dateFromPage.equalsIgnoreCase(actualDateFromDOB));
                        Assert.assertTrue(monthFromPage.equalsIgnoreCase(actualMonthFromDOB));
                        Assert.assertTrue(yearFromPage.equalsIgnoreCase(actualYearFromDOB));
                        break;
                    case "claim id":
                        String claimIDInvoiceTable = supplierDetailsPageObj.patientClaimIDInInvoiceTable().getText();
                        System.out.println("claimIDInvoiceTable-----------in table-------------" + claimIDInvoiceTable);
                        Assert.assertTrue(claimIDInvoiceTable.equalsIgnoreCase(claimsOperationsObj.claimID));
                        break;
                    case "claim item id":
                        String claimItemIDInvoiceTable = supplierDetailsPageObj.patientClaimItemIDInInvoiceTable().getText();
                        System.out.println("claimItemIDInvoiceTable-----------in table-------------" + claimItemIDInvoiceTable);
                        Assert.assertTrue(claimItemIDInvoiceTable.equalsIgnoreCase(claimsOperationsObj.claimItemId));
                        break;
                }
            }
        }
    }

    public void selectClaimItemAndCreateInvoice() {
        supplierDetailsPageObj.selectClaimToUpdate().click();
        new Select(supplierDetailsPageObj.invoiceClaimItemIdSelect()).selectByIndex(0);
        supplierDetailsPageObj.createInvoiceButton().click();
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
    }

    public void validatePreferredPaymentMethods(List<String> dropDownValues) {

        nextEventPageObj.btnClick(supplierDetailsPageObj.DropDownPreferredPayment());

        for (int i = 0; i < dropDownValues.size(); i++) {
            System.out.println("value to verify------------------------" + dropDownValues.get(i));
            supplierDetailsPageObj.drpdnPaymentValues(dropDownValues.get(i));
            Assert.assertTrue(supplierDetailsPageObj.drpdnPaymentValues(dropDownValues.get(i)).isDisplayed());

            System.out.println("Preferred Payment value is " + dropDownValues.get(i));


        }
    }

    public void validateSupplierDetails(List<List<String>> supplierDetails) {
        for (int i = 1; i < supplierDetails.size(); i++) {
            for (int j = 0; j < supplierDetails.get(i).size(); j++) {
                this.enterCoreDetailsForSupplier(supplierDetails.get(0).get(j), supplierDetails.get(i).get(j));
            }
        }
    }

    public void validateSupplierBankDetails(List<List<String>> supplierDetails) {
        for (int i = 1; i < supplierDetails.size(); i++) {
            for (int j = 0; j < supplierDetails.get(i).size(); j++) {
                this.enterBankDetail(supplierDetails.get(0).get(j), supplierDetails.get(i).get(j));
            }
        }
    }



    public void validatePaymentDetails(String paymentType){
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());


        new Select(claimSummaryPageObj.selectLetterType()).selectByVisibleText(paymentType);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nextEventPageObj.btnClick( nextEventPageObj.nextButtonSensitive());

    }
    }
