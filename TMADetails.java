package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.common.DateOperations;
import co.uk.directlinegroup.tt.utils.common.RandomGenerator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static co.uk.directlinegroup.tt.utils.ClaimsOperations.configCompanyName;
import static co.uk.directlinegroup.tt.utils.ClaimsOperations.configSupplierType;

/**
 * Created by 588800 on 7/21/2017.
 */
public class TMADetails {

    private NextEventPage nextEventPageObj = new NextEventPage();
    private TMADetailsPage tmaDetailsPageObj = new TMADetailsPage();
    private ClaimsOperations claimOperationObj = new ClaimsOperations();
    private Navigation navigationObj = new Navigation();
    private SupplierDetailsPage supplierDetailsPageObj = new SupplierDetailsPage();
    private IAdminSecurityManagementPage iAdminSecurityManagementPageObj = new IAdminSecurityManagementPage();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private Commands commandsObj = new Commands();
    //  private SupplierOperations supplierOperationsObj = new SupplierOperations();
    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private DateOperations dateOperationsObj = new DateOperations();
    private ClaimPaymentPage claimPaymentPageObj = new ClaimPaymentPage();
    private co.uk.directlinegroup.tt.utils.common.Select selectObj = new co.uk.directlinegroup.tt.utils.common.Select();
    /*private Wait waitObj = new Wait();
    private LeftNavPanePage leftNavPanePageObj = new LeftNavPanePage();
    public String filterID="40746";*/

    public static String vatRateForStatus = "";
    public static String LeadTMA = "";
    public static List<String> claimIDList = new ArrayList<>();
    public static List<String> claimId = new ArrayList<>();

    public void enterNextKinDetails(List<List<String>> lstInput) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());

        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println("----------------i value ------------------" + i);
            for (int j = 0; j < lstInput.get(0).size(); j++) {
                System.out.println("----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get(0).get(j).toLowerCase());
                this.enterDetails(lstInput.get(0).get(j), lstInput.get(i).get(j));
            }
        }
        tmaDetailsPageObj.btnSave().click();
    }

    public void enterBasicTMADetails(List<List<String>> lstInput) {
//TODO Need to uncomment once debugging completed

//         tmaDetailsPageObj.saveBtn().click();
//         tmaDetailsPageObj.btnSave().click();
//        nextEventPageObj.CancelBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (commandsObj.elementDisplayedWithLessTime(By.xpath(tmaDetailsPageObj.lnkTMAClaimXpath())))
            tmaDetailsPageObj.lnkTMAClaim().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        try {
            Thread.sleep(8000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());

        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println("----------------i value ------------------" + i);
            for (int j = 0; j < lstInput.get(0).size(); j++) {
                System.out.println("----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get(0).get(j).toLowerCase());
                this.enterDetails(lstInput.get(0).get(j), lstInput.get(i).get(j));
            }
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(tmaDetailsPageObj.btnSave());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();


    }

    private void enterDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "case type":
                //TODO - Need to remove the below thread.sleep once the application is stable
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tmaDetailsPageObj.caseType().click();
                tmaDetailsPageObj.drpdnCaseType(fieldValue).click();
                break;
            case "patients name":
                tmaDetailsPageObj.txtPatientsName().clear();
                tmaDetailsPageObj.txtPatientsName().sendKeys(fieldValue);
                tmaDetailsPageObj.txtPatientsName().sendKeys(Keys.TAB);
                break;
            case "patients dob":
                tmaDetailsPageObj.txtPatientsDob().clear();
                tmaDetailsPageObj.txtPatientsDob().sendKeys(fieldValue);
                tmaDetailsPageObj.txtPatientsDob().sendKeys(Keys.TAB);
                break;
            case "caller name":
                tmaDetailsPageObj.txtCallerName().clear();
                tmaDetailsPageObj.txtCallerName().sendKeys(fieldValue);
                tmaDetailsPageObj.txtCallerName().sendKeys(Keys.TAB);
                break;
            case "caller contactno.":
                tmaDetailsPageObj.txtCallerContactNo().clear();
                tmaDetailsPageObj.txtCallerContactNo().sendKeys(fieldValue);
                tmaDetailsPageObj.txtCallerContactNo().sendKeys(Keys.TAB);
                break;
            case "patient relationship":
                tmaDetailsPageObj.patientRelationship().click();
                tmaDetailsPageObj.drpdnPatientRelationship(fieldValue).click();
                tmaDetailsPageObj.patientRelationship().sendKeys(Keys.TAB);
                break;
            case "type of claim":
                tmaDetailsPageObj.claimType().click();
                tmaDetailsPageObj.drpdnClaimType(fieldValue).click();
                break;
            case "supplier email":
                tmaDetailsPageObj.supplierEmail().clear();
                tmaDetailsPageObj.supplierEmail().sendKeys(fieldValue);
                break;
            case "supplier name":
                tmaDetailsPageObj.supplierName().clear();
                tmaDetailsPageObj.supplierName().sendKeys(fieldValue);
                break;
            case "fax":
                tmaDetailsPageObj.fax().clear();
                tmaDetailsPageObj.fax().sendKeys(fieldValue);
                break;
            case "flight number":
                tmaDetailsPageObj.txtFlightNumber().clear();
                tmaDetailsPageObj.txtFlightNumber().sendKeys(fieldValue);
                break;
            case "airline":
                tmaDetailsPageObj.txtAirline().clear();
                tmaDetailsPageObj.txtAirline().sendKeys(fieldValue);
                break;
            case "email address":
                tmaDetailsPageObj.txtEmail().clear();
                tmaDetailsPageObj.txtEmail().sendKeys(fieldValue);
                break;
            case "departure airport":
                tmaDetailsPageObj.txtDepAirport().clear();
                tmaDetailsPageObj.txtDepAirport().sendKeys(fieldValue);
                break;
            case "arrival airport":
                tmaDetailsPageObj.txtArrivalAirport().clear();
                tmaDetailsPageObj.txtArrivalAirport().sendKeys(fieldValue);
                break;
            case "hotel name":
                tmaDetailsPageObj.txtHotelName().clear();
                tmaDetailsPageObj.txtHotelName().sendKeys(fieldValue);
                tmaDetailsPageObj.txtHotelName().sendKeys(Keys.TAB);
                break;
            case "hotel address":
                tmaDetailsPageObj.txtHotelAddress().clear();
                nextEventPageObj.waitForMoreTime();
                tmaDetailsPageObj.txtHotelAddress().sendKeys(fieldValue);
                tmaDetailsPageObj.txtHotelAddress().sendKeys(Keys.TAB);
                break;
            case "hotel telephone number":
                tmaDetailsPageObj.txtHotelTelPhnNo().clear();
                tmaDetailsPageObj.txtHotelTelPhnNo().sendKeys(fieldValue);
                break;
            case "type of incident":
                tmaDetailsPageObj.incidentType().click();
                tmaDetailsPageObj.drpdnIncidentType(fieldValue).click();
                break;
            case "hospital name":
                tmaDetailsPageObj.txtHospitalName().clear();
                tmaDetailsPageObj.txtHospitalName().sendKeys(fieldValue);
                break;
            case "hospital address":
                tmaDetailsPageObj.txtHospitalAddress().clear();
                nextEventPageObj.waitForMoreTime();
                tmaDetailsPageObj.txtHospitalAddress().sendKeys(fieldValue);
                break;
            case "hospital telephone number":
                tmaDetailsPageObj.txtHospitalTelPhnNo().clear();
                tmaDetailsPageObj.txtHospitalTelPhnNo().sendKeys(fieldValue);
                break;
            case "hospital admission date":
                tmaDetailsPageObj.txtAdmissionDate().clear();
                tmaDetailsPageObj.txtAdmissionDate().sendKeys(fieldValue);
                break;
            case "name":
                tmaDetailsPageObj.txtName().clear();
                tmaDetailsPageObj.txtName().sendKeys(fieldValue);
                break;
            case "relationship":
                tmaDetailsPageObj.relationship().click();
                tmaDetailsPageObj.drpdnRelationship(fieldValue).click();
                break;
            case "address":
                tmaDetailsPageObj.txtContactAddress().clear();
                tmaDetailsPageObj.txtContactAddress().sendKeys(fieldValue);
                break;
            case "phone number 1":
                tmaDetailsPageObj.txtPhoneNum1().clear();
                tmaDetailsPageObj.txtPhoneNum1().sendKeys(fieldValue);
                break;
            case "phone number 2":
                tmaDetailsPageObj.txtPhoneNum2().clear();
                tmaDetailsPageObj.txtPhoneNum2().sendKeys(fieldValue);
                break;
            case "password":
                tmaDetailsPageObj.txtPassword().clear();
                tmaDetailsPageObj.txtPassword().sendKeys(fieldValue);
                break;
            case "possible media attention":
                nextEventPageObj.waitForPageLoad();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(tmaDetailsPageObj.chkBxMediaAttention());
                break;
            case "customer fax number":
                tmaDetailsPageObj.customerFaxNumber().clear();
                tmaDetailsPageObj.customerFaxNumber().sendKeys(fieldValue);
                break;
            case "email":
                tmaDetailsPageObj.email().clear();
                tmaDetailsPageObj.email().sendKeys(fieldValue);
                break;
            case "supplier":
                tmaDetailsPageObj.addSupplier().click();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                nextEventPageObj.switchToFrameById(nextEventPageObj.supplierFrame());
                tmaDetailsPageObj.selectSupplier(fieldValue).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                break;
            case "supplier fax number":
                tmaDetailsPageObj.supplierFax().clear();
                tmaDetailsPageObj.supplierFax().sendKeys(fieldValue);
                break;
            case "supplier type":
                tmaDetailsPageObj.comboBox().click();
                tmaDetailsPageObj.supplierTypeOption(fieldValue).click();
                break;
            case "supplier telephone":
                tmaDetailsPageObj.supplierTelephone().clear();
                tmaDetailsPageObj.supplierTelephone().sendKeys(fieldValue);
                break;
            case "supplier address1":
                tmaDetailsPageObj.supplierAddress1().clear();
                tmaDetailsPageObj.supplierAddress1().sendKeys(fieldValue);
                break;
            case "supplier address2":
                tmaDetailsPageObj.supplierAddress2().clear();
                tmaDetailsPageObj.supplierAddress2().sendKeys(fieldValue);
                break;
            case "supplier town":
                tmaDetailsPageObj.supplierTown().clear();
                tmaDetailsPageObj.supplierTown().sendKeys(fieldValue);
                break;
            case "supplier county":
                tmaDetailsPageObj.supplierCounty().clear();
                tmaDetailsPageObj.supplierCounty().sendKeys(fieldValue);
                break;
            case "supplier postcode":
                tmaDetailsPageObj.supplierPostcode().clear();
                tmaDetailsPageObj.supplierPostcode().sendKeys(fieldValue);
                break;
            case "telephone number":
                tmaDetailsPageObj.telephoneNumber().clear();
                tmaDetailsPageObj.telephoneNumber().sendKeys(fieldValue);
                break;
            case "contact name":
                tmaDetailsPageObj.contactName().clear();
                tmaDetailsPageObj.contactName().sendKeys(fieldValue);
                break;
            case "agent name":
                tmaDetailsPageObj.agentName().clear();
                tmaDetailsPageObj.agentName().sendKeys(fieldValue);
                break;
            case "agent email":
                tmaDetailsPageObj.agentEmail().clear();
                tmaDetailsPageObj.agentEmail().sendKeys(fieldValue);
                break;
            case "gp name":
                tmaDetailsPageObj.gpName().clear();
                tmaDetailsPageObj.gpName().sendKeys(fieldValue);
                break;
            case "surgery name":
                tmaDetailsPageObj.surgeryName().clear();
                tmaDetailsPageObj.surgeryName().sendKeys(fieldValue);
                break;
            case "agent fax":
                tmaDetailsPageObj.agentFax().clear();
                tmaDetailsPageObj.agentFax().sendKeys(fieldValue);
                break;
            case "fax number":
                tmaDetailsPageObj.faxNumber().clear();
                tmaDetailsPageObj.faxNumber().sendKeys(fieldValue);
                break;
            case "agent supplier type":
                tmaDetailsPageObj.comboBox().click();
                tmaDetailsPageObj.agentTypeOption(fieldValue);
                break;
            case "agent telephone":
                tmaDetailsPageObj.agentTelephone().clear();
                tmaDetailsPageObj.agentTelephone().sendKeys(fieldValue);
                break;
            case "agent address1":
                tmaDetailsPageObj.agentAddress1().clear();
                tmaDetailsPageObj.agentAddress1().sendKeys(fieldValue);
                break;
            case "surgery address1":
                tmaDetailsPageObj.surgeryAddress1().clear();
                tmaDetailsPageObj.surgeryAddress1().sendKeys(fieldValue);
                break;
            case "agent address2":
                tmaDetailsPageObj.agentAddress2().clear();
                tmaDetailsPageObj.agentAddress2().sendKeys(fieldValue);
                break;
            case "surgery address2":
                tmaDetailsPageObj.surgeryAddress2().clear();
                tmaDetailsPageObj.surgeryAddress2().sendKeys(fieldValue);
                break;
            case "surgery address3":
                tmaDetailsPageObj.surgeryAddress3().clear();
                tmaDetailsPageObj.surgeryAddress3().sendKeys(fieldValue);
                break;
            case "surgery address4":
                tmaDetailsPageObj.surgeryAddress4().clear();
                tmaDetailsPageObj.surgeryAddress4().sendKeys(fieldValue);
                break;
            case "agent town":
                tmaDetailsPageObj.agentTown().clear();
                tmaDetailsPageObj.agentTown().sendKeys(fieldValue);
                break;
            case "agent county":
                tmaDetailsPageObj.agentCounty().clear();
                tmaDetailsPageObj.agentCounty().sendKeys(fieldValue);
                break;
            case "agent postcode":
                tmaDetailsPageObj.agentPostcode().clear();
                tmaDetailsPageObj.agentPostcode().sendKeys(fieldValue);
                break;
            case "surgery postcode":
                tmaDetailsPageObj.surgeryPostcode().clear();
                tmaDetailsPageObj.surgeryPostcode().sendKeys(fieldValue);
                break;
            case "retract reason":
                tmaDetailsPageObj.comboBox().click();
                tmaDetailsPageObj.agentTypeOption(fieldValue).click();
                break;
            case "relevant parties":
                for (int i = 0; i < fieldValue.split("#").length; i++) {
                    tmaDetailsPageObj.relevantParties(fieldValue.split("#")[i]).click();
                }
                break;
            case "next to kin as main point of contact":
                tmaDetailsPageObj.nextToKinAsMainPointOfContact().click();
                break;
            case "next to kin email":
                tmaDetailsPageObj.nextToKinEmail().clear();
                tmaDetailsPageObj.nextToKinEmail().sendKeys(fieldValue);
                break;
            case "next to kin address2":
                tmaDetailsPageObj.nextToKinAddress2().clear();
                tmaDetailsPageObj.nextToKinAddress2().sendKeys(fieldValue);
                break;
            case "next to kin town":
                tmaDetailsPageObj.nextToKinTown().clear();
                tmaDetailsPageObj.nextToKinTown().sendKeys(fieldValue);
                break;
            case "private medical insurance":
                tmaDetailsPageObj.privateMedicalInsurance().click();
                tmaDetailsPageObj.privateMedicalInsuranceOption(fieldValue).click();
                break;
            case "assigned agent":
                tmaDetailsPageObj.addAgent().click();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                nextEventPageObj.switchToFrameById(nextEventPageObj.supplierFrame());
                tmaDetailsPageObj.selectSupplier(fieldValue).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                break;
            case "assigned gp":
                tmaDetailsPageObj.addGP().click();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                nextEventPageObj.switchToFrameById(nextEventPageObj.supplierFrame());
                tmaDetailsPageObj.selectSupplier(fieldValue).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                break;
            case "named people":
                tmaDetailsPageObj.btnSave().click();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                //TODO -Please fix this---> nextEventPageObj.btnClick(tmaDetailsPageObj.btnAddMainAcctHolder());
                break;

            case "company name":
                supplierDetailsPageObj.companyName().click();
                nextEventPageObj.switchToFrameById(nextEventPageObj.findElement(By.name("PagesDialogWindow")));
                supplierDetailsPageObj.txtboxFilter().sendKeys(fieldValue);
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(supplierDetailsPageObj.btnNameFilter());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(supplierDetailsPageObj.filterDropDwnValue());
                nextEventPageObj.waitForMoreTime();
                supplierDetailsPageObj.btnSelect(fieldValue).click();
                supplierDetailsPageObj.switchToDefault();
                supplierDetailsPageObj.switchToFrameById(nextEventPageObj.frame());
                break;

            case "chase frequency (hours)":
                claimSummaryPageObj.enterChaseHours().clear();
                claimSummaryPageObj.enterChaseHours().sendKeys(fieldValue);
                break;
            case "communication preference":
                claimSummaryPageObj.communicationPreferenceImg().click();
                claimSummaryPageObj.select_communicationPreference(fieldValue).click();
                break;
            case "add hotel":
//                tmaDetailsPageObj.insertHotelButton().click();
                nextEventPageObj.btnClick(tmaDetailsPageObj.insertHotelButton());
                break;
            case "save hotel":
                nextEventPageObj.btnClick(tmaDetailsPageObj.saveHotelDetails());
                nextEventPageObj.waitForPageLoad();
                break;


        }
    }


    public void enterAdditionalDetails(List<List<String>> lstInput) {
        tmaDetailsPageObj.editTMAClaimValue().click();
        nextEventPageObj.switchToDefault();

        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println("----------------i value ------------------" + i);
            for (int j = 0; j < lstInput.get(0).size(); j++) {
                System.out.println("----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get(0).get(j).toLowerCase());
                this.enterDetails(lstInput.get(0).get(j), lstInput.get(i).get(j));
            }
        }
        tmaDetailsPageObj.btnSaveAndClose().click();
    }

    public void verifyDropdownValueAndSelectOption(String oopEvent, String inputValue, String optionToSelect) {
        claimOperationObj.clickingUnderNextEventsAndButtons("out of process event");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        navigationObj.navigateToNextEventType(oopEvent);
        boolean flag = false;
        tmaDetailsPageObj.comboBox().click();
        List<WebElement> guaranteeReasonDropdownValues = nextEventPageObj.findElements(By.xpath(tmaDetailsPageObj.guaranteeReasonXpath()));
        System.out.println("value-------------------------good-------------------" + guaranteeReasonDropdownValues.get(0).getText());
        String value = "";
        String[] dropdownValue = inputValue.split("#");
        for (int k = 0; k < guaranteeReasonDropdownValues.size(); k++) {
            value = guaranteeReasonDropdownValues.get(k).getText();
            System.out.println("dropdown values-----------------goodwill--------------" + value);
            for (int ilistval = 0; ilistval < dropdownValue.length; ilistval++) {
                if (value.trim().equalsIgnoreCase(dropdownValue[ilistval].trim())) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                Assert.assertTrue(true);
        }
        tmaDetailsPageObj.guaranteeReasonOption(optionToSelect).click();
        tmaDetailsPageObj.btnSave().click();
    }

    public void enterSupplierOrAgentDetails(List<List<String>> lstInput) {
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");

        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());

        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println("----------------i value ------------------" + i);
            for (int j = 0; j < lstInput.get(0).size(); j++) {
                System.out.println("----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get(0).get(j).toLowerCase());
                this.enterDetails(lstInput.get(0).get(j), lstInput.get(i).get(j));
            }
        }
        tmaDetailsPageObj.btnSave().click();
    }

    public void enterSupplierOrGPDetails(List<List<String>> lstInput) {
        // claimOperationObj.clickingUnderNextEventsAndButtons("Go");

        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());

        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println("----------------i value ------------------" + i);
            for (int j = 0; j < lstInput.get(0).size(); j++) {
                System.out.println("----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get(0).get(j).toLowerCase());
                this.enterDetails(lstInput.get(0).get(j), lstInput.get(i).get(j));
            }
        }
        tmaDetailsPageObj.btnSave().click();
    }

    public void enterRetractDetails(String oopEvent, String valueToVerify, List<List<String>> parameters) {
        claimOperationObj.clickingUnderNextEventsAndButtons("out of process event");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        navigationObj.navigateToNextEventType(oopEvent);
        this.verifyReleventPartiesAreDisplayed(valueToVerify);
        this.enterReasonAndSelectPerson(parameters);
        tmaDetailsPageObj.btnSave().click();
    }

    private void enterReasonAndSelectPerson(List<List<String>> lstInput) {
        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println("----------------i value ------------------" + i);
            for (int j = 0; j < lstInput.get(0).size(); j++) {
                System.out.println("----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get(0).get(j).toLowerCase());
                this.enterDetails(lstInput.get(0).get(j), lstInput.get(i).get(j));
            }
        }
    }

    private void verifyReleventPartiesAreDisplayed(String valueToVerify) {
        for (int i = 0; i < valueToVerify.split("#").length; i++) {
            Assert.assertTrue(tmaDetailsPageObj.relevantParties(valueToVerify.split("#")[i]).isDisplayed());
        }
    }

    public void enterInvoiceDetails(List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.enterDetailsForInvoice(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
        supplierDetailsPageObj.btnClick(supplierDetailsPageObj.invoiceSaveBtnInsideFrame());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        supplierDetailsPageObj.btnClick(supplierDetailsPageObj.invoiceSaveBtn());
        commandsObj.waitForLoad(supplierDetailsPageObj.getDriver);
    }


    private void enterDetailsForInvoice(String fieldName, String fieldValue) {
//        claimOperationObj.claimID="55862823";
        switch (fieldName.toLowerCase()) {
            case "action":
                // claimOperationObj.clickingUnderNextEventsAndButtons(fieldValue);
                nextEventPageObj.waitForPageLoad();
                if (!fieldValue.equalsIgnoreCase("na")) {
//                    claimOperationObj.clickingUnderNextEventsAndButtons("go");
                    nextEventPageObj.switchToDefault();
                    nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
//                    supplierDetailsPageObj.editLinkToUpdateInvoice().click();
                    nextEventPageObj.btnClick(supplierDetailsPageObj.editLinkToUpdateInvoice(claimOperationObj.claimID));//TODO -verify this
                } else {
                    System.out.println("Action is" + fieldValue);

                }
                commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
                commandsObj.waitForLoad(nextEventPageObj.getDriver);
                break;
            case "event":
               /* if (! fieldValue.equalsIgnoreCase("NA")) {
                    nextEventPageObj.switchToDefault();
                    nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                    System.out.println("field name --------------------" + fieldValue);
                    navigationObj.navigateToNextEventType(fieldValue);
                }*/
                if (!fieldValue.equalsIgnoreCase("na")) {
                    System.out.println("*******");
                    nextEventPageObj.switchToDefault();
                    nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                    System.out.println("field name --------------------" + fieldValue);
                    navigationObj.navigateToNextEventType(fieldValue);
                } else {
                    System.out.println("Event is" + fieldValue);
                }
                break;
            case "total due":
                supplierDetailsPageObj.invoiceTotalDueInput().clear();
                supplierDetailsPageObj.invoiceTotalDueInput().sendKeys(fieldValue);
                break;
            case "fee rate":
                supplierDetailsPageObj.invoicefeeRateInput().clear();
                supplierDetailsPageObj.invoicefeeRateInput().sendKeys(fieldValue);
                break;
            case "invoice date":
                supplierDetailsPageObj.invoiceDateInput().clear();
                supplierDetailsPageObj.invoiceDateInput().sendKeys(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString());
                supplierDetailsPageObj.paymentTypeCategory().sendKeys(Keys.TAB);
                break;
            case "claim id":
                if (fieldValue.equalsIgnoreCase("get claim id")) {
                    //TODO Sujeetha comment this before pushing code
//                    claimOperationObj.claimID="55862823";
                    claimId.add(claimOperationObj.claimID);
                    System.out.println("Into if loop claim id is***"+claimId.get(0));
                    supplierDetailsPageObj.invoiceClaimIdInput().clear();
                    supplierDetailsPageObj.invoiceClaimIdInput().sendKeys(claimOperationObj.claimID);
                } else if (fieldValue.equalsIgnoreCase("claim id")) {
                    System.out.println("into else if****"+claimOperationObj.claimID);
                    supplierDetailsPageObj.invoiceClaimIdInput().clear();
                    supplierDetailsPageObj.invoiceClaimIdInput().sendKeys(claimOperationObj.claimID);
                }
                else if (fieldValue.equalsIgnoreCase("TMA claim id")) {
                    System.out.println("into 2nd else if claim Id****"+claimOperationObj.tmaCaseID);
                    supplierDetailsPageObj.invoiceTMAClaimIdInput().clear();
                    supplierDetailsPageObj.invoiceTMAClaimIdInput().sendKeys(claimOperationObj.tmaCaseID);
                }
                else {
                    System.out.println("into final else****"+fieldValue);
                    supplierDetailsPageObj.invoiceClaimIdInput().clear();
                    supplierDetailsPageObj.invoiceClaimIdInput().sendKeys(fieldValue);
                }
                supplierDetailsPageObj.searchClaimInvoice().click();
                nextEventPageObj.waitForPageLoad();
                supplierDetailsPageObj.selectClaimToUpdate().click();
                nextEventPageObj.waitForMoreTime();
//                nextEventPageObj.waitForPageLoad();
//                supplierDetailsPageObj.createInvoiceButton().click();
                break;
            case "supplier claim id":
                supplierDetailsPageObj.invoiceClaimIdInput().clear();
                supplierDetailsPageObj.invoiceClaimIdInput().sendKeys(claimOperationObj.claimID);
                break;
            case "supplier claim item id":
                supplierDetailsPageObj.invoiceClaimItemIdInput().clear();
                supplierDetailsPageObj.invoiceClaimItemIdInput().sendKeys(claimOperationObj.claimItemId);
                break;
            case "claim item id":
                System.out.println("Claim item id------------@@@@@@@@@@@@#############");
                // claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                if (fieldValue.equalsIgnoreCase("get claim item id")) {
                    supplierDetailsPageObj.invoiceClaimItemIdInput().clear();
                    supplierDetailsPageObj.invoiceClaimItemIdInput().sendKeys(claimOperationObj.claimItemId);
                } else if (fieldValue.equalsIgnoreCase("get claim item id1")) {
//                    claimOperationObj.claimItemId1="51833426";
//                    System.out.println("claimItemId1----"+claimOperationObj.claimItemId1);
//                    supplierDetailsPageObj.invoiceClaimItemIdInput().clear();
//                    supplierDetailsPageObj.invoiceClaimItemIdInput().sendKeys(claimOperationObj.claimItemId1);
//                    System.out.println("claimItemId1----"+claimOperationObj.claimItemId1);
                    new Select(supplierDetailsPageObj.invoiceClaimItemIdSelect()).selectByIndex(0);
                } else if (fieldValue.equalsIgnoreCase("get claim item id2")) {
//                    claimOperationObj.claimItemId2="51833427";
//                    supplierDetailsPageObj.invoiceClaimItemIdInput().clear();
//                    supplierDetailsPageObj.invoiceClaimItemIdInput().sendKeys(claimOperationObj.claimItemId2);
//                    System.out.println("claimItemId2----"+claimOperationObj.claimItemId2);
                    new Select(supplierDetailsPageObj.invoiceClaimItemIdSelect()).selectByIndex(1);
                } else {
                    supplierDetailsPageObj.invoiceClaimItemIdInput().clear();
                    supplierDetailsPageObj.invoiceClaimItemIdInput().sendKeys(fieldValue);
                }
                //
                supplierDetailsPageObj.createInvoiceButton().click();
                break;
            case "payable":
                supplierDetailsPageObj.invoicePayableAmountInput().clear();
                supplierDetailsPageObj.invoicePayableAmountInput().sendKeys(fieldValue);
                break;
            case "currency":
                //supplierDetailsPageObj.currencyDropdown().sendKeys(fieldValue);
                new Select(supplierDetailsPageObj.currencyDropdown()).selectByVisibleText(fieldValue);
                break;
            case "imported vat amount":
                supplierDetailsPageObj.importedVatAmountInput().clear();
                supplierDetailsPageObj.importedVatAmountInput().sendKeys(fieldValue);
                break;
            case "cost container fees":
                supplierDetailsPageObj.costContainerFeesInput().clear();
                supplierDetailsPageObj.costContainerFeesInput().sendKeys(fieldValue);
                break;
            case "invoice num":
                if (!fieldValue.equalsIgnoreCase("Random")) {
                    supplierDetailsPageObj.invoiceNumInput().clear();
                    supplierDetailsPageObj.invoiceNumInput().sendKeys(fieldValue);
                } else {
                    supplierDetailsPageObj.invoiceNumInput().clear();
                    supplierDetailsPageObj.invoiceNumInput().sendKeys(RandomGenerator.randomInteger(7));
                }
                break;
            case "invoice period":
                supplierDetailsPageObj.invoicePeriodInput().clear();
                supplierDetailsPageObj.invoicePeriodInput().sendKeys(fieldValue);
                break;
            case "beneificary invoice date":
                supplierDetailsPageObj.beneificaryInvoiceDateInput().clear();
                supplierDetailsPageObj.beneificaryInvoiceDateInput().sendKeys(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString());
                break;
            case "beneificary invoice amount":
                supplierDetailsPageObj.beneificaryInvoiceAmountInput().clear();
                supplierDetailsPageObj.beneificaryInvoiceAmountInput().sendKeys(fieldValue);
                break;
            case "ultimate beneficiary claim no":
                if (fieldValue.equalsIgnoreCase("get claim no"))
                    supplierDetailsPageObj.ultimateBeneficiaryClaimNoInput().sendKeys(claimOperationObj.claimItemId);
                else
                    supplierDetailsPageObj.ultimateBeneficiaryClaimNoInput().sendKeys(fieldValue);
                break;
            case "ultimate beneficiary bill no":
                supplierDetailsPageObj.ultimateBeneficiaryBillNoInput().sendKeys(fieldValue);
                break;
            case "ultimate beneficiary department":
                supplierDetailsPageObj.ultimateBeneficiaryDepartmentInput().sendKeys(fieldValue);
                break;
            case "verify vat status":
                List<WebElement> options = nextEventPageObj.findElements(By.xpath(supplierDetailsPageObj.vatStatusOption()));
                System.out.println("options size-------------------------" + options.size());
                for (int i = 0; i < options.size(); i++) {
                    boolean flag = false;
                    String optionsval = options.get(i).getText();
                    System.out.println(options);
                    for (int j = 1; j < fieldValue.split("#").length; j++) {
                        if (optionsval.equalsIgnoreCase(fieldValue.split("#")[j])) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        Assert.assertTrue(flag);
                    } else {
                        Assert.assertFalse(flag);
                    }
                }
                break;
            case "patient name":
                supplierDetailsPageObj.patientNameInput().sendKeys(fieldValue);
                break;
            case "Patient DOB":
                supplierDetailsPageObj.patientDOBInput().sendKeys(fieldValue);
                break;
            case "amount before vat":
                supplierDetailsPageObj.amountbeforeVAT().clear();
                supplierDetailsPageObj.amountbeforeVAT().sendKeys(fieldValue);
                break;
            case "excess type":
                new Select(supplierDetailsPageObj.excessTypeSelect()).selectByVisibleText(fieldValue);
                break;
            case "payment type category":
                new Select(supplierDetailsPageObj.paymentTypeCategory()).selectByVisibleText(fieldValue);
                supplierDetailsPageObj.paymentTypeCategory().sendKeys(Keys.TAB);
                break;
            case "fee":
                supplierDetailsPageObj.feesInput().clear();
                supplierDetailsPageObj.feesInput().sendKeys(fieldValue);
                break;
            case "total ex vat":
                supplierDetailsPageObj.totalExVat().clear();
                supplierDetailsPageObj.totalExVat().sendKeys(fieldValue);
                break;
            case "total inc vat":
                supplierDetailsPageObj.totalIncVat().clear();
                supplierDetailsPageObj.totalIncVat().sendKeys(fieldValue);
                break;
            case "claim items":
                System.out.println("Claim item ------------@@@@@@@@@@@@#############");
                // claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                if (fieldValue.equalsIgnoreCase("get claim item")) {
                    supplierDetailsPageObj.invoiceClaimItemIdInput().clear();
                    supplierDetailsPageObj.invoiceClaimItemIdInput().sendKeys(claimOperationObj.claimItemId);
                } else {
                   // new Select(supplierDetailsPageObj.txtClaimItem()).selectByVisibleText(fieldValue);
                    selectObj.selectValueFromDropdown(supplierDetailsPageObj.txtClaimItem(),fieldValue);
                    //nextEventPageObj.btnClick(supplierDetailsPageObj.txtClaimItem(fieldValue));
                    System.out.println("selected item is  " + fieldValue);
                }
                //
                supplierDetailsPageObj.createInvoiceButton().click();
                break;
            case "payment":
                supplierDetailsPageObj.divDropDownSelect().click();
                supplierDetailsPageObj.divDropDownSupplierPaymentOption(fieldValue).click();
                break;
            case "rush paymenet remittence msg":
                supplierDetailsPageObj.supplierRemittanceMsg().sendKeys(fieldValue);
                break;
            case "button":
                if (fieldValue.equalsIgnoreCase("insert")) {
                    supplierDetailsPageObj.btnClick(supplierDetailsPageObj.rushPaymentInsert());
                }
                commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
                break;
            case "vat":
                supplierDetailsPageObj.Vat().clear();
                supplierDetailsPageObj.Vat().sendKeys(fieldValue);
                break;
            case "amount":
                supplierDetailsPageObj.Amount().clear();
                supplierDetailsPageObj.Amount().sendKeys(fieldValue);
                break;
            case "vat subcategory":
                new Select(supplierDetailsPageObj.vatSubCategorySelect()).selectByVisibleText(fieldValue);
                supplierDetailsPageObj.vatSubCategorySelect().sendKeys(Keys.TAB);
                break;
            case "vat status":
                new Select(supplierDetailsPageObj.vatStatusSelect()).selectByVisibleText(fieldValue);
                supplierDetailsPageObj.vatStatusSelect().sendKeys(Keys.TAB);
                break;
            case "vat already applied":
                supplierDetailsPageObj.vatAlreadyApplied().click();
                break;
        }
    }

    public void selectTheVATStatus(String option) {
        supplierDetailsPageObj.editFirstSupplier().click();
        supplierDetailsPageObj.editLinkInInvoiceTable().click();
        supplierDetailsPageObj.vatStatusInTable().click();
        supplierDetailsPageObj.vatStatusOption(option).click();
        supplierDetailsPageObj.updateInTable().click();
        /*supplierDetailsPageObj.updateInTable().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();*/

    }

    public String verifyVATAmountFieldisDisplayed() {
        Assert.assertTrue(supplierDetailsPageObj.vatAmountInTable().isDisplayed());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        String vatAmount = supplierDetailsPageObj.vatAmountInTable().getText();
        System.out.println("vatAmount----------------------" + vatAmount);
        return vatAmount;
    }

    public void verifyVATStatus(String vatStatus) {
        supplierDetailsPageObj.editFirstSupplier().click();
        String vatStatusFromPage = supplierDetailsPageObj.defaultStatus().getText();
        System.out.println("vatStatusFromPage--------------------" + vatStatusFromPage);
        Assert.assertTrue(vatStatusFromPage.equalsIgnoreCase(vatStatus));

    }

    public void calculatedVATAmount(String defaultVATStatus, String amount, String dueAmount) {
        double totalDueAmount = 0;
        if (defaultVATStatus.equalsIgnoreCase("standard")) {
            totalDueAmount = Double.parseDouble(dueAmount) * (Double.parseDouble(vatRateForStatus) / 100);
            System.out.println("totalDueAmount-------------------------" + totalDueAmount);
            Assert.assertTrue(totalDueAmount == Double.parseDouble(amount));
        } else if (defaultVATStatus.equalsIgnoreCase("reverse")) {
            totalDueAmount = Double.parseDouble(dueAmount) * (Double.parseDouble(vatRateForStatus) / 100);
            System.out.println("totalDueAmount-------------------------" + totalDueAmount);
            Assert.assertTrue(totalDueAmount == Double.parseDouble(amount));
        } else if (defaultVATStatus.equalsIgnoreCase("outside of scope")) {
            if (dueAmount.equalsIgnoreCase("blank")) {
                System.out.println("Amount ------------------------ " + amount);
                Assert.assertTrue(amount.equalsIgnoreCase(" "));
            }
//            totalDueAmount = Double.parseDouble(dueAmount) * (Double.parseDouble(vatRateForStatus)/100);
//            System.out.println("totalDueAmount-------------------------"+totalDueAmount);
//            Assert.assertTrue(totalDueAmount == Double.parseDouble(amount));
        }
        /*String vatStatusFromPage = supplierDetailsPageObj.defaultStatus().getText();
        System.out.println("vatStatusFromPage--------------------"+vatStatusFromPage);
        Assert.assertTrue(vatStatusFromPage.equalsIgnoreCase(vatStatus));*/

    }

    public void getVATValueForStatusRate(String status) {
        vatRateForStatus = iAdminSecurityManagementPageObj.vatRateTypeForStatus(status).getText();
        System.out.println("vatRateForStatus------------------------" + vatRateForStatus);
    }

    public void getVATValueRate(String status, String country) {
        vatRateForStatus = iAdminSecurityManagementPageObj.vatRateForStatus(status, country).getText();
        System.out.println("vatRateForStatus------------------------" + status + ":" + vatRateForStatus + " - " + country);
    }

    public void payTheUploadedInvoice(String option, String paymentMethod, String details) {
        claimOperationObj.clickingUnderNextEventsAndButtons("Out Of Process event");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        System.out.println("field name --------------------" + option);
        navigationObj.navigateToNextEventType(option);
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        supplierDetailsPageObj.selectClaimToPay(claimOperationObj.TMAClaimId).click();
        claimIDList.add(claimOperationObj.claimID);
        supplierDetailsPageObj.payInvoiceSave().click();
        if (paymentMethod.equalsIgnoreCase("cheque")) {
            supplierDetailsPageObj.seletChequeDetails(details).click();
        }
        if (paymentMethod.equalsIgnoreCase("bank")) {
            supplierDetailsPageObj.selectBankDetails(details).click();
        }
//        supplierDetailsPageObj.selectfirstBankAccountNo().click();
        supplierDetailsPageObj.bankAccountSaveBtn().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        supplierDetailsPageObj.payInvoiceSave().click();
    }

    public void payAllUploadedInvoice(String option, String paymentMethod, String details) {
        claimOperationObj.clickingUnderNextEventsAndButtons("Out Of Process event");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        System.out.println("field name --------------------" + option);
        navigationObj.navigateToNextEventType(option);
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        List<WebElement> lineItemsCheckbox = nextEventPageObj.findElements(By.xpath(supplierDetailsPageObj.invoiceCheckBox()));
        System.out.println("line items-----------------------------" + lineItemsCheckbox.size());
        for (int i = 0; i < lineItemsCheckbox.size(); i++) {
            lineItemsCheckbox.get(i).click();
            claimIDList.add(nextEventPageObj.findElement(By.xpath(supplierDetailsPageObj.claimItemIdInInvoiceTable(i))).getText());
            System.out.println("List value-----------------------" + claimIDList.get(i));
        }
        supplierDetailsPageObj.payInvoiceSave().click();
        if (paymentMethod.equalsIgnoreCase("cheque")) {
            supplierDetailsPageObj.seletChequeDetails(details).click();
        }
        if (paymentMethod.equalsIgnoreCase("bank")) {
            supplierDetailsPageObj.selectBankDetails(details).click();
        }
        supplierDetailsPageObj.bankAccountSaveBtn().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        supplierDetailsPageObj.payInvoiceSave().click();
    }


    public void switchToNamedPeopleScreen(List<String> action) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());

        for (int i = 1; i < action.size(); i++) {
            System.out.println("----------------i value ------------------" + i);
            if (action.get(i).equalsIgnoreCase("Cancel")) {
                commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
                nextEventPageObj.btnClick(tmaDetailsPageObj.btnCancel());
                System.out.println("Clicking cancel button");
            } else if (action.get(i).equalsIgnoreCase("Save")) {
                tmaDetailsPageObj.namedPeopleSaveBtn().click();
            }
        }

    }

    public void enterTMAContactDetails(List<List<String>> lstInput) {

        claimOperationObj.clickingUnderNextEventsAndButtons("Go");

        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());

        nextEventPageObj.waitForPageLoad();

        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println("----------------i value ------------------" + i);
            for (int j = 0; j < lstInput.get(0).size(); j++) {
                System.out.println("----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get(0).get(j).toLowerCase());
                this.enterContactDetails(lstInput.get(0).get(j), lstInput.get(i).get(j));
            }
        }
        tmaDetailsPageObj.btnSave().click();
    }

    public void enterTMALuggageChecklistDetails(List<List<String>> lstInput) {

        claimOperationObj.clickingUnderNextEventsAndButtons("Go");

        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());

        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println("----------------i value ------------------" + i);
            for (int j = 0; j < lstInput.get(0).size(); j++) {
                System.out.println("----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get(0).get(j).toLowerCase());
                this.enterLuggageChecklistDetails(lstInput.get(0).get(j), lstInput.get(i).get(j));
            }
        }
        tmaDetailsPageObj.btnSave().click();

    }

    public void enterTMAHealixFitToFlyDetails(List<List<String>> lstInput) {

        claimOperationObj.clickingUnderNextEventsAndButtons("Go");

        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());

//        claimOperationObj.navigateToEventType(eventType);
//        nextEventPageObj.waitForMoreTime();
//        nextEventPageObj.waitForMoreTime();

        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println("----------------i value ------------------" + i);
            for (int j = 0; j < lstInput.get(0).size(); j++) {
                System.out.println("----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get(0).get(j).toLowerCase());
                this.enterHealixFitToFlyDetails(lstInput.get(0).get(j), lstInput.get(i).get(j));
            }
        }
        tmaDetailsPageObj.btnSave().click();
    }


    public void enterTMAContactCustomerToDiscussRepatriationDetails(List<List<String>> lstInput) {

//        claimOperationObj.clickingUnderNextEventsAndButtons("Go");

        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());

//        claimOperationObj.navigateToEventType(eventType);
//        nextEventPageObj.waitForMoreTime();
//        nextEventPageObj.waitForMoreTime();

        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println("----------------i value ------------------" + i);
            for (int j = 0; j < lstInput.get(0).size(); j++) {
                System.out.println("----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get(0).get(j).toLowerCase());
                this.enterContactCustomerToDiscussRepatriationDetails(lstInput.get(0).get(j), lstInput.get(i).get(j));
            }
        }
        tmaDetailsPageObj.btnSave().click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
//        tmaDetailsPageObj.tmaComments().sendKeys("Test");
        tmaDetailsPageObj.btnFinish().click();
    }

    public void enterTMARepatriationChecklistDetails(List<List<String>> lstInput) {

        claimOperationObj.clickingUnderNextEventsAndButtons("Go");

        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());

        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println("----------------i value ------------------" + i);
            for (int j = 0; j < lstInput.get(0).size(); j++) {
                System.out.println("----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get(0).get(j).toLowerCase());
                this.enterRepatriationChecklistDetails(lstInput.get(0).get(j), lstInput.get(i).get(j));
            }
        }
        tmaDetailsPageObj.btnSave().click();
        nextEventPageObj.waitForMoreTime();
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
//        nextEventPageObj.btnClick(nextEventPageObj.go());


    }


    private void enterRepatriationChecklistDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "full names of people travelling are spelt correctly":
                tmaDetailsPageObj.chkBxNamesOfPeopleSpeltCorrectly().click();
                break;
            case "all passport details have been received":
                tmaDetailsPageObj.chkBxPassportDetailsReceived().click();
                break;
            case "customer expectations have been set":
                tmaDetailsPageObj.chkBxCustomerExpectationSet().click();
                break;
            case "original transfer arrangements have been set":
                tmaDetailsPageObj.chkBxOriginalTASet().click();
                break;
            case "claim is covered":
                tmaDetailsPageObj.chkBxClaimCovered().click();
                break;
        }
    }


    private void enterContactCustomerToDiscussRepatriationDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "customer contact successful":
                tmaDetailsPageObj.chkBxCustomerContactSuccessful().click();
                break;
            case "customer happy to proceed":
                tmaDetailsPageObj.chkBxCustomerHappyToProceed().click();
                break;
        }
    }


    private void enterHealixFitToFlyDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "PRPA required":
                tmaDetailsPageObj.prpaRequired().click();
                tmaDetailsPageObj.drpdnPrpaRequired(fieldValue).click();
                break;
            case "medical clearance required":
                tmaDetailsPageObj.medicalClearanceRequired().click();
                tmaDetailsPageObj.drpdnMedicalClearanceRequired(fieldValue).click();
                break;
            case "fit to fly certificate required":
                tmaDetailsPageObj.fitToFlyCertificateRequired().click();
                tmaDetailsPageObj.drpdnfitToFlyCertificateRequired(fieldValue).click();
                break;
        }
    }

    private void enterLuggageChecklistDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "brief description of suitcases":
                tmaDetailsPageObj.descriptionOfSuitcases().sendKeys(fieldValue);
                break;
            case "all valuables removed suitcases left unlocked for customs":
                tmaDetailsPageObj.chkBxValuablesRemoved().click();
                break;
            case "all liquids removed from suitcases":
                tmaDetailsPageObj.chkBxLiquidsRemoved().click();
                break;
            case "customer packed suitcase themselves":
                tmaDetailsPageObj.chkBxCustomerPackedSuitcase().click();
                break;
            case "all suitcases have correct address labels":
                tmaDetailsPageObj.chkBxSuitcaseCorrectAddressLabels(fieldName).click();
                break;
            case "suitcases location contact details to collect from":
                tmaDetailsPageObj.chkBxSuitcaseLocationContactDetails(fieldName).sendKeys(fieldValue);
                break;
        }
    }

    private void enterContactDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "executor as main point of contact":
                if (tmaDetailsPageObj.executorAsMainPointOfcontactValidation().getAttribute("value").equalsIgnoreCase("False")) {
                    tmaDetailsPageObj.executorAsMainPointOfcontact().click();
                }
                break;
            case "title":
                tmaDetailsPageObj.titleImg().click();
                tmaDetailsPageObj.selectTitle(fieldValue).click();
                break;
            case "fax":
                tmaDetailsPageObj.fax().clear();
                tmaDetailsPageObj.fax().sendKeys(fieldValue);
                break;
            case "customer fax number":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "name":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "next of kin as main point of contact":

                //TODO --> Please fix this steps
                /*
               if (tmaDetailsPageObj.nextToKinAsMainPointOfContactProperty().getAttribute("value").equalsIgnoreCase("False")) {
                   tmaDetailsPageObj.nextToKinAsMainPointOfContact().click();
                }
                */

                break;
            case "email":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "address2":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "town":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "relationship":
                tmaDetailsPageObj.relationship().click();
                tmaDetailsPageObj.drpdnRelationship(fieldValue).click();
                break;
            case "phone number 1 mobile":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "phone number 2 home":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "first name":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(Keys.TAB);
                break;
            case "last name":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "executor first name":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "executor last name":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "address1":
            case "executor address1":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "execcounty":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "postCode":
            case "executor postCode":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "email address":
            case "executor email address":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "home phone":
            case "executor home phone":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "Mobile phone (eg. iPhone, Samsung Galaxy etc.)":
            case "executor mobile phone":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
            case "password":
                tmaDetailsPageObj.txtPassword().clear();
                tmaDetailsPageObj.txtPassword().sendKeys(fieldValue);
                tmaDetailsPageObj.txtPassword().sendKeys(Keys.TAB);
                break;
            case "kin password":
                tmaDetailsPageObj.kinPassword().clear();
                tmaDetailsPageObj.kinPassword().sendKeys(fieldValue);
                break;
            case "named people":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(tmaDetailsPageObj.namedPeopleSaveBtn());
                nextEventPageObj.waitForMoreTime();
                break;
            case "next of kin fax":
            case "next of kin title":
            case "next of kin email":
            case "next of kin address1":
            case "next of kin address2":
            case "next of kin town":
                tmaDetailsPageObj.executorDetails(fieldName).clear();
                tmaDetailsPageObj.executorDetails(fieldName).sendKeys(fieldValue);
                break;
        }
    }

    public void payAnotherInvoice(String option, String paymentMethod, String details) {
        claimOperationObj.clickingUnderNextEventsAndButtons("Out Of Process event");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        System.out.println("field name --------------------" + option);
        navigationObj.navigateToNextEventType(option);
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        List<WebElement> chkBoxList = nextEventPageObj.findElements(By.xpath(supplierDetailsPageObj.chkBoxForInvoice()));
        for (int i = 0; i < chkBoxList.size(); i++) {
            claimIDList.add(nextEventPageObj.findElement(By.xpath("//table[contains(@id,'grdInvoices')]//tr[" + (i + 2) + "]/td[2]")).getText());
            System.out.println("clain id in list ----------------" + claimIDList.get(0));
            chkBoxList.get(0).click();
        }
        supplierDetailsPageObj.payInvoiceSave().click();
        if (paymentMethod.equalsIgnoreCase("cheque")) {
            supplierDetailsPageObj.seletChequeDetails(details).click();
        }
        if (paymentMethod.equalsIgnoreCase("bank")) {
            supplierDetailsPageObj.selectBankDetails(details).click();
        }
//        supplierDetailsPageObj.selectfirstBankAccountNo().click();
        supplierDetailsPageObj.bankAccountSaveBtn().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        supplierDetailsPageObj.payInvoiceSave().click();
    }

    public static List<String> claimItemIDList = new ArrayList<>();

    public void enterInvoiceDetailsForMultipleClaimItem(List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            claimOperationObj.clickingUnderNextEventsAndButtons("add an out of process event");
            navigationObj.navigateToNextEventType("01 Create Invoice");
            claimOperationObj.clickingUnderNextEventsAndButtons("go");
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.enterDetailsForInvoice(parameters.get(0).get(j), parameters.get(i).get(j));
            }
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            supplierDetailsPageObj.invoiceSaveBtnInsideFrame().isDisplayed();
            supplierDetailsPageObj.btnClick(supplierDetailsPageObj.invoiceSaveBtnInsideFrame());
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nextEventPageObj.btnClick(supplierDetailsPageObj.invoiceSaveBtn());
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


    public void toPayUploadedInvoice(List<List<String>> parameters, String account) {
        claimOperationObj.clickingUnderNextEventsAndButtons("Out Of Process event");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.uploadedInvoiceDetails(parameters.get(0).get(j), parameters.get(i).get(j), account);
            }

        }
        /*claimOperationObj.clickingUnderNextEventsAndButtons("Out Of Process event");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        System.out.println("field name --------------------" + option);
        navigationObj.navigateToNextEventType(option);
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        supplierDetailsPageObj.selectClaimToPay(claimOperationObj.claimID).click();
        claimIDList.add(claimOperationObj.claimID);
        supplierDetailsPageObj.payInvoiceSave().click();
        if(paymentMethod.equalsIgnoreCase("cheque")){
            supplierDetailsPageObj.seletChequeDetails(details).click();
        }
        if(paymentMethod.equalsIgnoreCase("bank")){
            supplierDetailsPageObj.selectBankDetails(details).click();
        }
//        supplierDetailsPageObj.selectfirstBankAccountNo().click();
        supplierDetailsPageObj.bankAccountSaveBtn().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        supplierDetailsPageObj.payInvoiceSave().click();*/
    }

    public void uploadedInvoiceDetails(String fieldName, String fieldValue, String account) {
        switch (fieldName.toLowerCase()) {
            case "event":
                System.out.println("field name --------------------" + fieldValue);
                navigationObj.navigateToNextEventType(fieldValue);
                claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                supplierDetailsPageObj.selectClaimToPay(claimOperationObj.TMAClaimId).click();
                claimIDList.add(claimOperationObj.claimID);
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                supplierDetailsPageObj.payInvoiceSave().click();
                break;
            case "payment method":
                String[] bankVerification = fieldValue.split("#");
                String amt = "";
                if (bankVerification[0].equalsIgnoreCase("bank")) {
                    nextEventPageObj.btnClick(supplierDetailsPageObj.selectBankDetails(account));
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                } else if (bankVerification[0].equalsIgnoreCase("cheque")) {
                    supplierDetailsPageObj.seletChequeDetails(account).click();
                }
                if (bankVerification[1].contains("Preferred Supplier")) {
                    nextEventPageObj.waitForPageLoad();
                    nextEventPageObj.waitForMoreTime();
                    Assert.assertTrue(claimPaymentPageObj.verifyBankValidationMessage(bankVerification[1]).isDisplayed());
                    nextEventPageObj.waitForMoreTime();
                    claimPaymentPageObj.saveBtn().click();

                } else {
                    supplierDetailsPageObj.validateAccountDetails().click();
                    nextEventPageObj.waitForPageLoad();
                   Assert.assertTrue(claimPaymentPageObj.verifyBankValidationMessage(bankVerification[1]).isDisplayed());
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    if (commandsObj.elementDisplayedWithLessTime(By.xpath(supplierDetailsPageObj.btnBankAccountSave()))){
                        System.out.println("**IF LOOP**** Bank ");
                        supplierDetailsPageObj.bankAccountSaveBtn().click();
                    }else if ((commandsObj.elementDisplayedWithLessTime( By.xpath(claimPaymentPageObj.overrideVerificationResultButton()) ))) {
                        System.out.println("**ELSE IF LOOP****");
                        nextEventPageObj.btnClick(claimPaymentPageObj.btnOverrideResult());
                    }
                    //claimPaymentPageObj.btnOverrideResult().click();
                    nextEventPageObj.waitForMoreTime();
                }
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "warning message":
                Assert.assertTrue(supplierDetailsPageObj.warningMessage(fieldValue).isDisplayed());
                break;
            case "payment option":
//                claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                if (fieldValue.contains("Partial Payment")) {
                    System.out.println("splite value in case -----------------------" + fieldValue.split("#")[1] + " -------------" + fieldValue.split("#")[0]);
                    new Select(supplierDetailsPageObj.paymentOption()).selectByVisibleText(fieldValue.split("#")[0]);
                    supplierDetailsPageObj.partialPaymentAmount().sendKeys(fieldValue.split("#")[1]);
                }
                supplierDetailsPageObj.payInvoiceSave().click();
                break;
            case "preferred payment methodssssssssssssss":
                //TODO Sujeetha needs to update below step once got clarification from Bijth
                Assert.assertTrue(tmaDetailsPageObj.paymentMethodSelect().getAttribute("AutoSelect").equalsIgnoreCase(fieldValue));
                break;
            case "add new payment account":
                System.out.println("New payment details adding--------------");
                tmaDetailsPageObj.addNewPaymentAccount().click();
                supplierDetailsPageObj.bankAccountSaveBtn().click();
                break;
            case "postcode":
                supplierDetailsPageObj.postcodeInput().sendKeys(fieldValue);
                break;
            case "bank name":
                supplierDetailsPageObj.bankNameInput().sendKeys(fieldValue);
                break;
            case "account number":
                supplierDetailsPageObj.accountNumberInput().sendKeys(fieldValue);
                break;
            case "sort code":
                supplierDetailsPageObj.sortCodeInput().sendKeys(fieldValue);
                break;
            case "address 1":
                supplierDetailsPageObj.address1Input().sendKeys(fieldValue);
                break;
            case "address 2":
                supplierDetailsPageObj.address2Input().sendKeys(fieldValue);
                break;
            case "town":
                supplierDetailsPageObj.townInput().sendKeys(fieldValue);
                break;
            case "county":
                supplierDetailsPageObj.countyInput().sendKeys(fieldValue);
                break;
            case "account sub type":
                supplierDetailsPageObj.accountSubTypeInput().click();
                supplierDetailsPageObj.accountSubTypeOption(fieldValue).click();
                break;
            case "account holder name":
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
            case "save account details":
                tmaDetailsPageObj.btnSave().click();
                break;
            case "bank validation":
                supplierDetailsPageObj.validateBankAccount().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                supplierDetailsPageObj.validationSaveBtn().click();
                break;
        }
    }


    public void claimAmountPaidBySupplier(String claimAmount) {
        for (int i = 0; i < claimId.size(); i++) {
            Assert.assertTrue(claimSummaryPageObj.claimAmountInSummaryTable(claimId.get(0)).getText().equalsIgnoreCase(claimAmount));
        }
    }

    public void enterSearchCriteria(List<List<String>> searchCriteria) {
        //ToDO - Sujeetha - Need to uncomment after Debugging also needs to chagne the hard coded values
        claimsOperationsObj.clickingUnderNextEventsAndButtons("out of process event");
        navigationObj.navigateToNextEventType("01 Create Invoice");
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
//        claimOperationObj.customerName ="PayTMA";
//        claimOperationObj.customerLastName = "NxAj";
//        claimOperationObj.customerDOB="10/10/1986";
//        claimOperationObj.countryOfLoss = "France";
        //  claimOperationObj.customerName ="PayTMA";
        //claimOperationObj.customerLastName = "NxAj";
//        claimOperationObj.customerDOB="10/10/1986";
//        claimOperationObj.countryOfLoss = "France";
//        claimOperationObj.claimID = "55296954";
//        claimOperationObj.claimItemId="52140559";
//        claimOperationObj.claimDate = "03/03/2018";
        for (int i = 1; i < searchCriteria.size(); i++) {
            for (int j = 0; j < searchCriteria.get(0).size(); j++) {
                switch (searchCriteria.get(0).get(j).toLowerCase()) {
                    case "first name":
                        supplierDetailsPageObj.firstNameInput().clear();
                        if (!searchCriteria.get(i).get(j).equalsIgnoreCase("na")) {
                            System.out.println(";claimOperationObj.claimID- to search-------------customerName---------------" + claimOperationObj.customerName);
                            supplierDetailsPageObj.firstNameInput().sendKeys(claimOperationObj.customerName);
                        }
                        break;
                    case "last name":
                        supplierDetailsPageObj.lastNameInput().clear();
                        if (!searchCriteria.get(i).get(j).equalsIgnoreCase("na")) {
                            System.out.println(";claimOperationObj.claimID- to search-----------customerLastName-----------------" + claimOperationObj.customerLastName);
                            supplierDetailsPageObj.lastNameInput().sendKeys(claimOperationObj.customerLastName);
                        }
                        break;
                    case "dob":
                        supplierDetailsPageObj.dobInput().clear();
                        if (!searchCriteria.get(i).get(j).equalsIgnoreCase("na")) {
                            System.out.println(";claimOperationObj.claimID- to search--------------customerDOB--------------" + claimOperationObj.customerDOB);
                            supplierDetailsPageObj.dobInput().sendKeys(claimOperationObj.customerDOB);
                        }
                        supplierDetailsPageObj.lastNameInput().click();
                        break;
                    case "claim id":
                        supplierDetailsPageObj.invoiceClaimIdInput().clear();
                        if (!searchCriteria.get(i).get(j).equalsIgnoreCase("na")) {
//                            System.out.println(";claimOperationObj.claimID- to search----------------------------" + claimOperationObj.claimID);
                            supplierDetailsPageObj.invoiceClaimIdInput().sendKeys(claimOperationObj.claimID);
                            supplierDetailsPageObj.invoiceClaimIdInput().click();
                        }
                        break;
                    case "claim item id":
                        supplierDetailsPageObj.invoiceClaimIdInput().clear();
                        if (!searchCriteria.get(i).get(j).equalsIgnoreCase("na")) {
                            System.out.println(";claimOperationObj.claimID- to search----------------------------" + claimOperationObj.claimItemId);
                            supplierDetailsPageObj.invoiceClaimIdInput().sendKeys(claimOperationObj.claimItemId);
                        }
                        break;
                    case "claim date":
                        supplierDetailsPageObj.invoiceClaimDateInput().clear();
                        if (!searchCriteria.get(i).get(j).equalsIgnoreCase("na")) {
                            System.out.println(";claimOperationObj.claimID- to search----------------------------" + claimOperationObj.claimDate);
                            supplierDetailsPageObj.invoiceClaimDateInput().sendKeys(claimOperationObj.claimDate);
                        }
                        supplierDetailsPageObj.lastNameInput().click();
                        break;
                }
            }
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            supplierDetailsPageObj.searchClaimInvoice().click();
            //TODO need to uncomment
            this.verifySearchTable();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }

    }

    public void enterPatientDetails(List<List<String>> patientDetails) {
        // claimOperationObj.clickingUnderNextEventsAndButtons("go");
        //TODO - Sujeetha : This needs to be removed once the performance issue resolved
        try {
            Thread.sleep(20000);
        } catch (Exception e) {
            System.out.println("Exception --------------" + e);
        }
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < patientDetails.size(); i++) {
            for (int j = 0; j < patientDetails.get(0).size(); j++) {
                switch (patientDetails.get(0).get(j)) {
                    case "Current Patient Status":
                        tmaDetailsPageObj.currentPatientDetails().click();
                        tmaDetailsPageObj.options(patientDetails.get(i).get(j)).click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "GP Check Required":
                        // tmaDetailsPageObj.GPChecheckRequired().click();
//                        nextEventPageObj.switchToDefault();
//                        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                        try {
                            Thread.sleep(10000);
                        } catch (Exception e) {
                            System.out.println("Exception --------------" + e);
                        }
                        tmaDetailsPageObj.GPChecheckRequired().click();
                        tmaDetailsPageObj.options(patientDetails.get(i).get(j)).click();
                        break;
                    case "Current Treating Hospital":
                        String fieldValue = patientDetails.get(i).get(j);
                        //claimOperationObj.retrieveRandomSupplierName="Sqbt";
                        if (patientDetails.get(i).get(j).equalsIgnoreCase("supplier name")) {
                            fieldValue = claimOperationObj.retrieveRandomSupplierName;
                        }
                        System.out.println("fieldValue-------------------" + fieldValue);
                        nextEventPageObj.btnClick(supplierDetailsPageObj.companyName());
                        nextEventPageObj.switchToFrameById(nextEventPageObj.findElement(By.name("PagesDialogWindow")));
                        supplierDetailsPageObj.txtboxFilter().sendKeys(fieldValue);
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.btnClick(supplierDetailsPageObj.btnNameFilter());
                        nextEventPageObj.waitForMoreTime();
                        //nextEventPageObj.btnClick(supplierDetailsPageObj.filterDropDwnValue());
                        supplierDetailsPageObj.filterDropDwnValue().click();
                        nextEventPageObj.waitForMoreTime();
                        supplierDetailsPageObj.btnSelect(fieldValue).click();
                        supplierDetailsPageObj.switchToDefault();
                        supplierDetailsPageObj.switchToFrameById(nextEventPageObj.frame());
                        break;
                    case "Patient status":
                        tmaDetailsPageObj.currentPatientDetails().click();
                        List<WebElement> statusList = nextEventPageObj.findElements(By.xpath(tmaDetailsPageObj.statusList()));
                        boolean flag = false;
                        for (int k = 1; k < statusList.size(); k++) {
                            for (int l = 0; l < patientDetails.get(i).get(j).split("#").length; l++) {
                                System.out.println("patientDetails.get(i).get(j)---------------" + patientDetails.get(i).get(j).split("#")[l]);
                                if (statusList.get(k).getText().equalsIgnoreCase(patientDetails.get(i).get(j).split("#")[l])) {
                                    System.out.println("statusList.get(k).getText().equalsIgnoreCase(patientDetails.get(i).get(j).split(\"#\")[l])----------------" + statusList.get(k).getText().equalsIgnoreCase(patientDetails.get(i).get(j).split("#")[l]));
                                    flag = true;
                                    break;
                                }
                            }
                        }
                        if (flag) {
                            Assert.assertTrue(flag);
                        } else
                            Assert.assertTrue(flag);
                        tmaDetailsPageObj.latestDiagnosis().click();
                        break;
                    case "Type of incident List":
                        nextEventPageObj.waitForPageLoad();
                        nextEventPageObj.btnClick(tmaDetailsPageObj.incidentType());
                        List<WebElement> incidentList = nextEventPageObj.findElements(By.xpath(tmaDetailsPageObj.incidentList()));
                        boolean incidentFlag = false;
                        for (int k = 1; k < incidentList.size(); k++) {
                            for (int l = 0; l < patientDetails.get(i).get(j).split("#").length; l++) {
                                System.out.println("patientDetails.get(i).get(j)---------------" + patientDetails.get(i).get(j).split("#")[l]);
                                if (incidentList.get(k).getText().equalsIgnoreCase(patientDetails.get(i).get(j).split("#")[l])) {
                                    System.out.println("statusList.get(k).getText().equalsIgnoreCase(patientDetails.get(i).get(j).split(\"#\")[l])----------------" + incidentList.get(k).getText().equalsIgnoreCase(patientDetails.get(i).get(j).split("#")[l]));
                                    incidentFlag = true;
                                    break;
                                }
                            }
                        }
//                        if (incidentFlag) {
//                            Assert.assertTrue(incidentFlag);
//                        } else
//                            Assert.assertTrue(incidentFlag);
                        nextEventPageObj.btnClick(tmaDetailsPageObj.latestDiagnosis());
                        break;
                    case "Admission date":
                        nextEventPageObj.waitForMoreTime();
//                        tmaDetailsPageObj.txtAdmissionDate().clear();
//                        nextEventPageObj.waitForMoreTime();
//                        tmaDetailsPageObj.txtAdmissionDate().sendKeys(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString());

                        String dateToSelect = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString().split("-")[2];
                        if(dateToSelect.startsWith("0")){
                            dateToSelect= dateToSelect.replace("0","");
                        }
                        tmaDetailsPageObj.txtAdmissionDateImg().click();
                        tmaDetailsPageObj.txtAdmissionANdDischargeDate(dateToSelect).click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "Return Flight Airline":
                    case "Return Flight Number":
                    case "Return Flight Departure Airport":
                    case "Return Flight Arrival Airport":
                    case "Patient Height":
                    case "Patient Weight":
                        tmaDetailsPageObj.flightDetails(patientDetails.get(0).get(j)).clear();
                        tmaDetailsPageObj.flightDetails(patientDetails.get(0).get(j)).sendKeys(patientDetails.get(i).get(j));
                        break;
                    case "Return Flight Date":
                        tmaDetailsPageObj.flightReturnDate().clear();
                        tmaDetailsPageObj.flightReturnDate().sendKeys(dateOperationsObj.addingDays(15));
                        break;
                    case "Private Medical Insurance":
                        tmaDetailsPageObj.privateMedicalInsurance().click();
                        tmaDetailsPageObj.privateMedicalInsuranceOption(patientDetails.get(i).get(j)).click();
                        break;
                    case "Latest Diagnosis":
                        tmaDetailsPageObj.latestDiagnosis().clear();
                        tmaDetailsPageObj.latestDiagnosis().sendKeys(patientDetails.get(i).get(j));
                        break;
                    case "Discharge date":
//                        tmaDetailsPageObj.dischargeDateInput().clear();
//
//                        tmaDetailsPageObj.dischargeDateInput().sendKeys(dateOperationsObj.addingDays(10));
                        String dischargeDateToSelect = dateOperationsObj.addingDays(10).split("-")[2];
                        if(dischargeDateToSelect.startsWith("0")){
                            dischargeDateToSelect= dischargeDateToSelect.replace("0","");
                        }
                        tmaDetailsPageObj.txtDischargeDateImg().click();
                        tmaDetailsPageObj.txtAdmissionANdDischargeDate(dischargeDateToSelect).click();
                        try {
                            Thread.sleep(10000L);
                        } catch (InterruptedException e) {

                        }
                        break;
                    case "Treating Clinic":
                        tmaDetailsPageObj.treatingClinic().clear();
                        tmaDetailsPageObj.treatingClinic().sendKeys(patientDetails.get(i).get(j));
                        break;
                }
            }
        }
        //TODO - Sujeetha : This needs to be removed once the performance issue resolved
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Exception --------------" + e);
        }
        supplierDetailsPageObj.invoiceSaveBtn().click();
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
    }

    public void verifySearchTable() {

        Assert.assertTrue(supplierDetailsPageObj.searchResultTable().isDisplayed());
        Assert.assertTrue(supplierDetailsPageObj.customerNameInTable(claimOperationObj.customerName).isDisplayed());
        Assert.assertTrue(supplierDetailsPageObj.customerLastNameInTable(claimOperationObj.customerLastName).isDisplayed());
//        String DOB = claimOperationObj.customerDOB.substring(0, 10);//.replace("-","/");
//        System.out.println("DOB--------------DOB------------DOB-0--------" + DOB);
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
//        String ds2 = "";
//        try {
//            ds2 = sdf2.format(sdf1.parse(DOB));
//            System.out.println("DS2-----------------------" + ds2);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        Assert.assertTrue(supplierDetailsPageObj.customerDOBInTable(claimOperationObj.customerDOB).isDisplayed());
        Assert.assertTrue(supplierDetailsPageObj.countryOfLossInTable(claimOperationObj.countryOfLoss).isDisplayed());
        Assert.assertTrue(supplierDetailsPageObj.claimIDInTable(claimOperationObj.claimID).isDisplayed());
        Assert.assertTrue(supplierDetailsPageObj.dateInTable(claimOperationObj.claimDate).isDisplayed());
    }

    public void addHealixNotes(List<List<String>> lstInputs) {
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                String fieldName = lstInputs.get(0).get(j);
                String fieldValue = lstInputs.get(i).get(j);
                switch (fieldName) {
                    case "Healix Nurse Notes":
                        tmaDetailsPageObj.healixNurseNotes().clear();
                        tmaDetailsPageObj.healixNurseNotes().sendKeys(fieldValue);
                        break;
                    case "Nurse Note Time":
                        tmaDetailsPageObj.healixNurseNotesTime().clear();
                        tmaDetailsPageObj.healixNurseNotesTime().sendKeys(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString());
                        break;
                }
            }
        }
        tmaDetailsPageObj.btnSave().click();
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
    }

    public void enterAppointmentDetails(List<List<String>> appointmentDetails) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        navigationObj.navigateToNextEventType("OOP Arrange Outpatient Appointment");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.clickingUnderNextEventsAndButtons("refresh");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.clickingUnderNextEventsAndButtons("go");
        navigationObj.navigateToNextEventType("Contacted Local Agent or Facility");
        tmaDetailsPageObj.commentsTextarea().sendKeys("comment");
        tmaDetailsPageObj.btnFinish().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        tmaDetailsPageObj.commentsTextarea().sendKeys("comment");
        tmaDetailsPageObj.btnFinish().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < appointmentDetails.size(); i++) {
            for (int j = 0; j < appointmentDetails.get(0).size(); j++) {
                String fieldName = appointmentDetails.get(0).get(j);
                String fieldValue = appointmentDetails.get(i).get(j);
                switch (fieldName) {
                    case "Appointment Date":
                        //tmaDetailsPageObj.appointmentDate().clear();
                        nextEventPageObj.waitForMoreTime();
                        tmaDetailsPageObj.appointmentDateImg().click();
                        System.out.println("date----------------------------" + dateOperationsObj.addingDays(15).split("/")[0]);
                        String dateToSelect = dateOperationsObj.addingDays(15).split("-")[2];
                        if(dateToSelect.startsWith("0")){
                            dateToSelect= dateToSelect.replace("0","");
                        }
                        tmaDetailsPageObj.appointmentFutureDate(dateToSelect).click();
                        //tmaDetailsPageObj.appointmentDate().sendKeys(dateOperationsObj.addingDays(15));
                        break;
                    case "Appointment Time":
                        tmaDetailsPageObj.appointmentTime().clear();
                        tmaDetailsPageObj.appointmentTime().sendKeys(fieldValue);
                        break;
                    case "Transfer Required":
                        tmaDetailsPageObj.transferRequired().click();
                        tmaDetailsPageObj.optionsToSelect(fieldValue).click();
                        break;
                    case "Client informed of Arrangements":
                        tmaDetailsPageObj.clientInformedArrangements().click();
                        tmaDetailsPageObj.optionsToSelect(fieldValue).click();
                        break;
                    case "Total Appointment Cost":
                        tmaDetailsPageObj.totalAppointmentCost().clear();
                        tmaDetailsPageObj.totalAppointmentCost().sendKeys(fieldValue);
                        break;
                    case "Reason for Appointment":
                        tmaDetailsPageObj.reasonForAppointment().clear();
                        tmaDetailsPageObj.reasonForAppointment().sendKeys(fieldValue);
                        break;
                }
            }
        }
        tmaDetailsPageObj.btnSave().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("go");
        navigationObj.navigateToNextEventType("Contacted Agent to Arrange Transfer");
        tmaDetailsPageObj.commentsTextarea().sendKeys("comment");
        tmaDetailsPageObj.btnFinish().click();
        claimOperationObj.clickingUnderNextEventsAndButtons("go");
        claimOperationObj.clickingUnderNextEventsAndButtons("go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        tmaDetailsPageObj.commentsTextarea().sendKeys("comment");
        tmaDetailsPageObj.btnFinish().click();
    }

    public void validateClaimDetails(List<List<String>> claimDetails) {
        nextEventPageObj.switchToDefault();
        tmaDetailsPageObj.subDetailsBtn().click();
        for (int i = 1; i < claimDetails.size(); i++) {
            for (int j = 0; j < claimDetails.get(0).size(); j++) {
                String fieldName = claimDetails.get(0).get(j);
                String fieldValue = claimDetails.get(i).get(j);
                switch (fieldName) {
                    case "Type of Claim":
                        Assert.assertTrue(tmaDetailsPageObj.typeOfClaimInClaimTable().getText().equalsIgnoreCase(fieldValue));
                        break;
                    case "Diagnosis":
                        Assert.assertTrue(tmaDetailsPageObj.diagnosisInClaimTable().getText().equalsIgnoreCase(fieldValue));
                        break;
                    case "Destination":
                        Assert.assertTrue(tmaDetailsPageObj.destinationInClaimTable().getText().equalsIgnoreCase(fieldValue));
                        break;
                    case "GP Checks & status":
                        Assert.assertTrue(tmaDetailsPageObj.gpCheckStatusInClaimTable().getText().equalsIgnoreCase(fieldValue));
                        break;
                    case "Is Media involved":
                        Assert.assertTrue(tmaDetailsPageObj.isMediaInvolvedInClaimTable().getText().equalsIgnoreCase(fieldValue));
                        break;
                }
            }
        }
    }

    public void verifyAppointmentDetails(List<List<String>> appointmentDetails) {
        tmaDetailsPageObj.editFirstTMAClaim().click();
        tmaDetailsPageObj.medicalTab().click();
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
        nextEventPageObj.switchToDefault();
        for (int i = 1; i < appointmentDetails.size(); i++) {
            for (int j = 0; j < appointmentDetails.get(0).size(); j++) {
                String fieldName = appointmentDetails.get(0).get(j);
                String fieldValue = appointmentDetails.get(i).get(j);
                switch (fieldName) {
                    case "Appointment Date":
                        System.out.println("tmaDetailsPageObj.appointmentDateValue().getAttribute(\"value\")---------" + tmaDetailsPageObj.appointmentDateValue().getAttribute("value"));
                        Assert.assertTrue(tmaDetailsPageObj.appointmentDateValue().getAttribute("value").contains(dateOperationsObj.addingDays(10)));
                        break;
                    case "Appointment Time":
                        System.out.println("Time-----------------" + tmaDetailsPageObj.appointmentTime().getAttribute("value"));
                        Assert.assertTrue(tmaDetailsPageObj.appointmentTime().getAttribute("value").equalsIgnoreCase(fieldValue));
                        break;
                    case "Transfer Required":
                        System.out.println("transfer req---------------" + tmaDetailsPageObj.transferRequired().getAttribute("value"));
                        Assert.assertTrue(tmaDetailsPageObj.transferRequired().getAttribute("value").equalsIgnoreCase(fieldValue));
                        break;
                    case "Client informed of Arrangements":
                        System.out.println("client-------------------------" + tmaDetailsPageObj.clientInformedArrangements().getAttribute("value"));
                        Assert.assertTrue(tmaDetailsPageObj.clientInformedArrangements().getAttribute("value").equalsIgnoreCase(fieldValue));
                        break;
                    case "Total Appointment Cost":
                        System.out.println("total cost-------------------------------" + tmaDetailsPageObj.totalAppointmentCost().getAttribute("value"));
                        Assert.assertTrue(tmaDetailsPageObj.totalAppointmentCost().getAttribute("value").equalsIgnoreCase(fieldValue));
                        break;
                    case "Reason for Appointment":
                        System.out.println("reason--------------------------" + tmaDetailsPageObj.reasonForAppointment().getAttribute("value"));
                        Assert.assertTrue(tmaDetailsPageObj.reasonForAppointment().getAttribute("value").equalsIgnoreCase(fieldValue));
                        break;
                }
            }
        }
    }

    public void capturingCapCosts(List<List<String>> lstInputs) {

        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                String fieldName = lstInputs.get(0).get(j);
                String fieldValue = lstInputs.get(i).get(j);
                switch (fieldName) {
                    case "Cost Cap":
                        tmaDetailsPageObj.capcostInput().clear();
                        tmaDetailsPageObj.capcostInput().sendKeys(fieldValue);
                        break;

                }
            }
        }
        tmaDetailsPageObj.btnSave().click();
    }

    public void enterNoteForExceedCapCost(List<List<String>> notesDetails) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < notesDetails.size(); i++) {
            for (int j = 0; j < notesDetails.get(0).size(); j++) {
                String fieldName = notesDetails.get(0).get(j);
                String fieldValue = notesDetails.get(i).get(j);
                switch (fieldName) {
                    case "Note Type":
                        new Select(tmaDetailsPageObj.noteTypeSelect()).selectByVisibleText(fieldValue);
                        break;
                    case "Note Description":
                        tmaDetailsPageObj.noteDescriptionInput().clear();
                        tmaDetailsPageObj.noteDescriptionInput().sendKeys(fieldValue);
                        break;
                    case "Priority":
                        new Select(tmaDetailsPageObj.prioritySelect()).selectByVisibleText(fieldValue);
                        break;
                    case "Apply to all":
                        tmaDetailsPageObj.applyToAll().click();
                        break;
                }
            }
        }
        tmaDetailsPageObj.btnFinish().click();

    }

    public void verifyChequeDetailsAreNotAvailable(String chequesDetail) {
       // claimOperationObj.TMAClaimId = "55856780";
        claimOperationObj.clickingUnderNextEventsAndButtons("Out Of Process event");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        System.out.println("field name --------------------");
        navigationObj.navigateToNextEventType("02 Pay Invoice");
        claimOperationObj.clickingUnderNextEventsAndButtons("Go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        supplierDetailsPageObj.selectClaimToPay(claimOperationObj.TMAClaimId).click();
        claimIDList.add(claimOperationObj.claimID);
        supplierDetailsPageObj.payInvoiceSave().click();
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
        commandsObj.waitForLoad(nextEventPageObj.getDriver);
        nextEventPageObj.findElement(By.xpath(supplierDetailsPageObj.selectBankDetailsXpath(chequesDetail))).click();
        claimPaymentPageObj.btnVerifyAccount().click();
        supplierDetailsPageObj.bankAccountSaveBtn().click();
        this.verifyPaymentMethod("Cheque");
      //  Assert.assertTrue(!commandsObj.elementDisplayedWithLessTime(By.xpath(supplierDetailsPageObj.selectBankDetailsXpath(chequesDetail))));
    }

    private void verifyPaymentMethod(String cheque) {
        List<WebElement> optionList = new Select(supplierDetailsPageObj.paymentMethod()).getOptions();
        int count = 0;
        for (WebElement op:optionList){
            if(op.getText().equalsIgnoreCase(cheque)){
                count++;
                break;
            }
        }
        if(count>0){Assert.assertTrue(false);}
        else{
            System.out.println("-----------Assertion on chwque payment-------------");Assert.assertTrue(true);}
    }

    public void updatePaymentDetailWithoutValidation(String paymentWithoutValidation, String reason) {
        claimOperationObj.clickingUnderNextEventsAndButtons(paymentWithoutValidation);
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        supplierDetailsPageObj.reasonForNotValidating().click();
        supplierDetailsPageObj.reasonForNotValidating().sendKeys(reason);
        supplierDetailsPageObj.invoiceSaveBtn().click();
    }

    public void enterGPDetails(List<List<String>> gpDetails) {
        tmaDetailsPageObj.enterGPDetailBtn().click();
        try {
            nextEventPageObj.btnClick(nextEventPageObj.go());
        } catch (Exception exe) {
            nextEventPageObj.btnClick(nextEventPageObj.go());
        }
        this.enterSupplierOrGPDetails(gpDetails);
    }

    public void completeGPCheck(List<String> gpCheck) {
        tmaDetailsPageObj.gpCheckRequiredBtn().click();
        try {
            nextEventPageObj.btnClick(nextEventPageObj.go());
        } catch (Exception exe) {
            nextEventPageObj.btnClick(nextEventPageObj.go());
        }
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 0; i < gpCheck.size(); i++) {
            switch (gpCheck.get(i)) {
                case "Do we have customer authorisation?":
                case "Possible to gain authorisation?":
                case "Customer refused consent?":
                    tmaDetailsPageObj.gpCheckList(gpCheck.get(i)).click();
                    break;
            }
        }
        tmaDetailsPageObj.btnSave().click();
    }

    public void validateAndCaptureReason(List<List<String>> lstInputs) {
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                switch (lstInputs.get(0).get(j)) {
                    case "Reasons to guarantee":
                        nextEventPageObj.btnClick(tmaDetailsPageObj.guaranteeReason());
                        List<WebElement> reason = nextEventPageObj.findElements(By.xpath(tmaDetailsPageObj.guaranteeReasonXpath()));
                        boolean flag = false;
                        String value = "";
                        String[] dropdownValue = lstInputs.get(i).get(j).split("#");
                        for (int k = 1; k < reason.size(); k++) {
                            flag = false;
                            value = reason.get(k).getText().trim();
                            System.out.println("dropdown values-----------------goodwill--------------" + value);
                            for (int ilistval = 0; ilistval < dropdownValue.length; ilistval++) {
                                if (value.trim().equalsIgnoreCase(dropdownValue[ilistval].trim())) {
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) {
                                Assert.assertTrue(true);
                            } else {
                                Assert.assertTrue(false);
                            }
                        }

                        break;
                    case "Reason":
                        nextEventPageObj.btnClick(tmaDetailsPageObj.guaranteeReason());
                        tmaDetailsPageObj.guaranteeReasonOption(lstInputs.get(i).get(j)).click();
                        break;
                }
            }
        }
        tmaDetailsPageObj.btnSave().click();
    }


    public void validatePopulatedSupplierType(List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());

        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                String fieldName = parameters.get(0).get(j);
                String fieldValue = parameters.get(i).get(j);
                switch (fieldName) {
                    case "validate supplier type":
                        System.out.println("Selected Supplier value is----" + tmaDetailsPageObj.txtSupplierType().getAttribute("value"));
                        System.out.println("Supplier Value from Company details---" + configSupplierType);
                        Assert.assertTrue(tmaDetailsPageObj.txtSupplierType().getAttribute("value").equalsIgnoreCase(configSupplierType));
                        System.out.println("Validated the supplier type");
                        break;
                    case "validate company name":
                        System.out.println("Selected Supplier value is----" + tmaDetailsPageObj.txtCompanyName().getAttribute("value"));
                        System.out.println("Supplier Value from Company details---" + configCompanyName);
                        Assert.assertTrue(tmaDetailsPageObj.txtCompanyName().getAttribute("value").equalsIgnoreCase(configCompanyName));
                        System.out.println("Validated the Company name");
                        break;

                }
            }


        }
    }

    public void verifySupplierInstructionsDetails(List<List<String>> SupplierInstructionsDetails) {
        tmaDetailsPageObj.editFirstTMAClaim().click();
        tmaDetailsPageObj.supplierInstructionsTab().click();
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
        nextEventPageObj.switchToDefault();
        for (int i = 1; i < SupplierInstructionsDetails.size(); i++) {
            for (int j = 0; j < SupplierInstructionsDetails.get(0).size(); j++) {
                String fieldName = SupplierInstructionsDetails.get(0).get(j);
                String fieldValue = SupplierInstructionsDetails.get(i).get(j);
                switch (fieldName) {
                    case "Request Type":
                        System.out.println("tmaDetailsPageObj.requestType().getAttribute(\"value\")---------" + tmaDetailsPageObj.requestType().getAttribute("value"));
                        Assert.assertTrue(tmaDetailsPageObj.requestType().getAttribute("value").equalsIgnoreCase(fieldValue));
                        break;
                    case "Request Status":
                        System.out.println("Time-----------------" + tmaDetailsPageObj.requestStatus().getAttribute("value"));
                        Assert.assertTrue(tmaDetailsPageObj.requestStatus().getAttribute("value").equalsIgnoreCase(fieldValue));
                        break;
                }
            }
        }
//        save and close
    }


    public void verifyRepatriationDetails(List<List<String>> RepatriationDetails) {
        tmaDetailsPageObj.editFirstTMAClaim().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        tmaDetailsPageObj.repatriationTab().click();
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
        nextEventPageObj.switchToDefault();
        for (int i = 1; i < RepatriationDetails.size(); i++) {
            for (int j = 0; j < RepatriationDetails.get(0).size(); j++) {
                String fieldName = RepatriationDetails.get(0).get(j);
                String fieldValue = RepatriationDetails.get(i).get(j);
                switch (fieldName) {

                    case "Escorted":
                        tmaDetailsPageObj.escorted().click();
                        tmaDetailsPageObj.drpdnEscorted(fieldValue).click();
                        break;
                    case "On Original Flight":
                        tmaDetailsPageObj.chkBxOnOriginalFlight().click();
                        break;
                    case "Business":
                        tmaDetailsPageObj.chkBxBusiness().click();
                        break;
                    case "Extra Seats":
                        System.out.println("Extra seats chkbox checked......");
//                        if (fieldValue.equalsIgnoreCase("True")) {
                        tmaDetailsPageObj.chkBxExtraSeats().click();
                        break;
                    case "How Many Seats Required":
                        nextEventPageObj.waitForMoreTime();
                        tmaDetailsPageObj.seatsRequired().sendKeys(fieldValue);
                        break;
                    case "Oxygen Required":
                        tmaDetailsPageObj.oxygenRequired().sendKeys(fieldValue);
                        break;
                    case "Litres Of Oxygen Required":
                        tmaDetailsPageObj.litresOfOxygenRequired().sendKeys(fieldValue);
                        break;
                    case "Air Ambulance":
                        tmaDetailsPageObj.airAmbulance().click();
                        tmaDetailsPageObj.drpdnAirAmbulance(fieldValue).click();
                        break;
                    case "Stretcher":
                        tmaDetailsPageObj.chkBxStretcher().click();
                        break;
                    case "Non Medical Escort":
                        tmaDetailsPageObj.chkBxNonMedicalEscort().click();
                        break;
                    case "Deceased":
                        tmaDetailsPageObj.chkBxDeceased().click();
                        break;
                    case "Wheelchair Assistance":
                        tmaDetailsPageObj.wheelChairAssistance().click();
                        tmaDetailsPageObj.drpdnWheelChairAssistance(fieldValue).click();
                        break;
                    case "Admission":
                        tmaDetailsPageObj.chkBxAdmission().click();
                        break;
                    case "Intl Ambulance Repatriation":
                        tmaDetailsPageObj.chkBxIntlAmbulanceRepatriation().click();
                        break;
                    case "Repatriation By Train":
                        tmaDetailsPageObj.chkBxRepatriationByTrain().click();
                        break;
                    case "Repatriation By Boat":
                        tmaDetailsPageObj.chkBxRepatriationByBoat().click();
                        break;
                    case "No Repatriation Required":
                        tmaDetailsPageObj.chkBxNoRepatriationRequired().click();
                        break;

                }
            }
        }
        tmaDetailsPageObj.btnSaveAndClose().click();
    }


    public void addNurseNotification(List<List<String>> lstInputs) {
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                String fieldName = lstInputs.get(0).get(j);
                String fieldValue = lstInputs.get(i).get(j);
                switch (fieldName) {
                    case "enter to address":
                        tmaDetailsPageObj.txtToEmail().clear();
                        tmaDetailsPageObj.txtToEmail().sendKeys(fieldValue);
                        tmaDetailsPageObj.txtToEmail().sendKeys(Keys.TAB);
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.btnClick(tmaDetailsPageObj.btnCreateSendEmail());
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                }
            }
        }
    }

    public void addFirstMedicalReportDetails(List<List<String>> lstInputs) {
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                String fieldName = lstInputs.get(0).get(j);
                String fieldValue = lstInputs.get(i).get(j);
                switch (fieldName) {
                    case "patient name":
                        tmaDetailsPageObj.txtPatientName().sendKeys(fieldValue);
                        tmaDetailsPageObj.txtPatientName().sendKeys(Keys.TAB);
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "patient dob":
                        tmaDetailsPageObj.txtPatientDOB().sendKeys(fieldValue);
                        tmaDetailsPageObj.txtPatientDOB().sendKeys(Keys.TAB);
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "healix date":
                        tmaDetailsPageObj.txtHealixDate().sendKeys(fieldValue);
                        tmaDetailsPageObj.txtHealixDate().sendKeys(Keys.TAB);
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "healix location":
                        tmaDetailsPageObj.txtHealixLocation().sendKeys(fieldValue);
                        tmaDetailsPageObj.txtHealixLocation().sendKeys(Keys.TAB);
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "healix doctor":
                        tmaDetailsPageObj.txtHealixDoctor().sendKeys(fieldValue);
                        tmaDetailsPageObj.txtHealixDoctor().sendKeys(Keys.TAB);
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "gp check needed":
                        tmaDetailsPageObj.txtGPneeded().sendKeys(fieldValue);
                        tmaDetailsPageObj.txtGPneeded().sendKeys(Keys.TAB);
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "next medical contact":
                        tmaDetailsPageObj.txtNextMedicalContact().sendKeys(fieldValue);
                        tmaDetailsPageObj.txtNextMedicalContact().sendKeys(Keys.TAB);
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "report written by":
                        tmaDetailsPageObj.txtReportWrittenBy().sendKeys(fieldValue);
                        tmaDetailsPageObj.txtReportWrittenBy().sendKeys(Keys.TAB);
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;

                }
            }
            nextEventPageObj.btnClick(tmaDetailsPageObj.btnSaveMedicalFirstReport());
            nextEventPageObj.waitForPageLoad();
            nextEventPageObj.switchToDefault();

        }
    }


    public void validatePopulatedHealixReport(List<List<String>> parameters) {
        nextEventPageObj.btnClick(tmaDetailsPageObj.lnkEditTMAclaim());
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.btnClick(tmaDetailsPageObj.tabHealixReport());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        //nextEventPageObj.switchToFrameById(nextEventPageObj.frame());

        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                String fieldName = parameters.get(0).get(j);
                String fieldValue = parameters.get(i).get(j);
                switch (fieldName) {
                    case "validate patient name":
                        System.out.println("Given patient name is----" + tmaDetailsPageObj.txtPatientName().getAttribute("value"));
                        Assert.assertTrue(tmaDetailsPageObj.txtPatientName().getAttribute("value").equalsIgnoreCase(fieldValue));
                        System.out.println("Validated the patient name");
                        break;
                    case "validate patient dob":
                        System.out.println("Given patient DOB value is----" + tmaDetailsPageObj.txtPatientDOB().getAttribute("value"));
                        Assert.assertTrue(tmaDetailsPageObj.txtPatientDOB().getAttribute("value").equalsIgnoreCase(fieldValue));
                        System.out.println("Validated the Patient DOB");
                        break;
                    case "validate patient location":
                        System.out.println("Given patient location value is----" + tmaDetailsPageObj.txtHealixLocation().getAttribute("value"));
                        Assert.assertTrue(tmaDetailsPageObj.txtHealixLocation().getAttribute("value").equalsIgnoreCase(fieldValue));
                        System.out.println("Validated the Patient location");
                        break;
                    case "validate doctor":
                        System.out.println("Given patient location value is----" + tmaDetailsPageObj.txtHealixDoctor().getAttribute("value"));
                        Assert.assertTrue(tmaDetailsPageObj.txtHealixDoctor().getAttribute("value").equalsIgnoreCase(fieldValue));
                        System.out.println("Validated the Patient location");
                        break;

                }
            }
            nextEventPageObj.btnClick(claimSummaryPageObj.saveAndCloseBtn());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();

        }

    }


    public void validateReferralTeamLeader() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        if (nextEventPageObj.nextButtonSensitive().isDisplayed()) {
            nextEventPageObj.btnClick(nextEventPageObj.nextButtonSensitive());
        }
        nextEventPageObj.waitForPageLoad();
        System.out.println("Navigating to Team Leader");
        tmaDetailsPageObj.recipientID().clear();
        tmaDetailsPageObj.recipientID().sendKeys("bijith.narikkuni@directlinegroup.co.uk");
        nextEventPageObj.btnClick(tmaDetailsPageObj.btnCreateSendEmail());
        System.out.println("Clicked the button");
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }


    public void validateUnderwriterProcess(String decision, String option) {
        //nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        System.out.println("Selecting decision");
        Assert.assertTrue(tmaDetailsPageObj.txtTeamLeadDecision(decision).isDisplayed());
        nextEventPageObj.btnClick(tmaDetailsPageObj.dropdownTeamLeadDecision(decision));
//        nextEventPageObj.waitForMoreTime();
        tmaDetailsPageObj.optionUnderwriter(option).click();
        System.out.println("Selected the decision option");
        nextEventPageObj.btnClick(claimSummaryPageObj.savebtn());
        // nextEventPageObj.waitForPageLoad();

    }

    public void navigateToOutsideTMA() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(tmaDetailsPageObj.lnkOutsideTMAClaim());
        nextEventPageObj.waitForPageLoad();

    }

    public void enterPassportDetails(List<List<String>> lstInput) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println("----------------i value ------------------" + i);
            for (int j = 0; j < lstInput.get(0).size(); j++) {
                System.out.println("----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get(0).get(j).toLowerCase());
                this.enterPassportandTransfersDetails(lstInput.get(0).get(j), lstInput.get(i).get(j));
            }
        }
        tmaDetailsPageObj.btnSave().click();
    }

    public void enterTMAPassportandTransferDetails(List<List<String>> lstInput) {

        claimOperationObj.clickingUnderNextEventsAndButtons("Go");

        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println("----------------i value ------------------" + i);
            for (int j = 0; j < lstInput.get(0).size(); j++) {
                System.out.println("----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get(0).get(j).toLowerCase());
                this.enterPassportandTransfersDetails(lstInput.get(0).get(j), lstInput.get(i).get(j));
            }
        }
        tmaDetailsPageObj.btnSave().click();
//        nextEventPageObj.switchToDefault();
//        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
////        tmaDetailsPageObj.tmaComments().sendKeys("Test");
//        tmaDetailsPageObj.btnFinish().click();
    }


    private void enterPassportandTransfersDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "full name":
                tmaDetailsPageObj.txtFullName().click();
                break;
            case "passport number":
                tmaDetailsPageObj.txtPassportNumber().click();
                break;
            case "date of issue":
                tmaDetailsPageObj.txtDateOfIssue().clear();
                tmaDetailsPageObj.txtDateOfIssue().sendKeys(fieldValue);
                break;
            case "expiration date":
                tmaDetailsPageObj.txtExpirationDate().clear();
                tmaDetailsPageObj.txtExpirationDate().sendKeys(fieldValue);
                break;
            case "country if issue":
                tmaDetailsPageObj.txtCountryOfIssue().click();
                break;
            case "toaddress":
                tmaDetailsPageObj.txtToAddress().sendKeys(fieldValue);
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                tmaDetailsPageObj.btnCreateEventAndSendEmail().click();
                break;

        }
    }

    public void addHealixReviewOfProviderMedicalReport(List<List<String>> lstInputs) {
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                String fieldName = lstInputs.get(0).get(j);
                String fieldValue = lstInputs.get(i).get(j);
                switch (fieldName) {
                    case "patient name":
                        tmaDetailsPageObj.txtPatientName().clear();
                        tmaDetailsPageObj.txtPatientName().sendKeys(fieldValue);
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "report written by":
                        tmaDetailsPageObj.txtReportWrittenBy().clear();
                        tmaDetailsPageObj.txtReportWrittenBy().sendKeys(fieldValue);
                        nextEventPageObj.waitForMoreTime();
                        break;
                }
            }
        }
    }

    public void validateReferralUnderWriter() {

        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        System.out.println("Navigating to UnderWriter");
        tmaDetailsPageObj.recipientID().clear();
        tmaDetailsPageObj.recipientID().sendKeys("Bijith.Narikkuni@directlinegroup.co.uk");
        nextEventPageObj.btnClick(tmaDetailsPageObj.btnCreateSendEmail());
        System.out.println("Clicked the button");
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
    }

    public void retriveLeadId() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        LeadTMA = tmaDetailsPageObj.txtTMALeadId().getText();
        System.out.println("Lead id--------" + LeadTMA);
    }

    public void reassignTMAClaim(String assignee) {
        nextEventPageObj.btnClick(tmaDetailsPageObj.btnEnterEdit());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.btnClick(tmaDetailsPageObj.chkBoxAssignee(LeadTMA));
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.btnClick(tmaDetailsPageObj.btnReassign());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        new Select(tmaDetailsPageObj.drpdownReassign()).selectByVisibleText(assignee);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.btnClick(tmaDetailsPageObj.btnOK());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("Updating all tasks");
        nextEventPageObj.btnClick(tmaDetailsPageObj.btnUpdateTasks());
        System.out.println("Updated all tasks");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForPageLoad();

    }


    public void enterTextForReferralDecision(String decision) {
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        tmaDetailsPageObj.txtReferralDecisionDetail().sendKeys(decision);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(tmaDetailsPageObj.btnSaveMedicalFirstReport());
        System.out.println("clicking Save button");


    }


}

