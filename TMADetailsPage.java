package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.text.Document;

/**
 * Created by 588800 on 7/21/2017.
 */
public class TMADetailsPage extends AbstractPage {

    public WebElement lnkTMAClaim() {

        return waitForElementPresent(By.xpath("(//a[text()='TMA'])[1]"));
    }

    public WebElement claimType() {

        return waitForElementVisible(By.xpath("(//input[starts-with(@id,'ucMandatoryFieldEditor_ddl302394_')])[1]"));
    }

    public WebElement fax() {

        return waitForElementVisible(By.xpath("(//input[starts-with(@id,'ucMandatoryFieldEditor_txt302687')])"));
    }

    public WebElement drpdnClaimType(String type) {
        return waitForElementPresent(By.xpath("//div[starts-with(@id,'ucMandatoryFieldEditor_ddl302394_') and contains(text(),'" + type + "')]"));
    }

    public WebElement txtFlightNumber() {

        return waitForElementVisible(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_txt302396_')]"));
    }

    public WebElement txtAirline() {

        return waitForElementVisible(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_txt302397_')]"));
    }

    public WebElement txtDepAirport() {

        return waitForElementVisible(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_txt302398_')]"));
    }

    public WebElement txtArrivalAirport() {

        return waitForElementVisible(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_txt302399_')]"));
    }

    public WebElement txtHotelName() {
        return waitForElementVisible(By.xpath("(//span[contains(text(),'Name')]/../following-sibling::div/input[@class='input textbox'])[1]"));
    }

    public WebElement txtHotelAddress() {
        return waitForElementVisible(By.xpath("(//span[contains(text(),'Address')]/../following-sibling::div/input[@class='input textbox'])[1]"));
    }

    public WebElement incidentType() {

        return waitForElementVisible(By.xpath("(//input[starts-with(@id,'ucMandatoryFieldEditor_ddl302404_')])[1]"));
    }

    public WebElement drpdnIncidentType(String type) {

        return waitForElementPresent(By.xpath("//div[starts-with(@id,'ucMandatoryFieldEditor_ddl302404_') and contains(text(),'" + type + "')]"));
    }

    public WebElement txtHospitalName() {

        return waitForElementVisible(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_txt302405_')]"));
    }

    public WebElement txtHospitalAddress() {

        return waitForElementVisible(By.xpath("//textarea[starts-with(@id,'ucMandatoryFieldEditor_txt302406_')]"));
    }

    public WebElement txtHospitalTelPhnNo() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Hospital Telephone Number')]/../following-sibling::td/input[1]"));
    }

    public WebElement txtHotelTelPhnNo() {
        return waitForElementVisible(By.xpath("(//span[contains(text(),'Phone Number')]/../following-sibling::div/input[@class='input textbox phone'])[1]"));
    }

    public WebElement txtAdmissionDate() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//span[contains(text(),'Admission')]/../following-sibling::td//input[@class='radEnabledCss_Default']"));
    }

    public WebElement txtName() {

        return waitForElementPresent(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_txt302409')]"));
    }

    public WebElement relationship() {

        return waitForElementPresent(By.xpath("(//input[starts-with(@id,'ucMandatoryFieldEditor_ddl302410_')])[1]"));
    }

    public WebElement drpdnRelationship(String relationship) {

        return waitForElementPresent(By.xpath("//div[starts-with(@id,'ucMandatoryFieldEditor_ddl302410_') and contains(text(),'" + relationship + "')]"));
    }

    public WebElement txtContactAddress() {

        return waitForElementPresent(By.xpath("//textarea[starts-with(@id,'ucMandatoryFieldEditor_txt302411')]"));
    }

    public WebElement txtPhoneNum1() {

        return waitForElementPresent(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_txt302412')]"));
    }

    public WebElement txtPhoneNum2() {

        return waitForElementPresent(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_txt302413')]"));
    }

    public WebElement txtEmail() {

        return waitForElementVisible(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_txt302414')]"));
    }

    public WebElement txtPassword() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'TMA Claim Password (A)')]/../following-sibling::td[1]/input"));
    }

    public WebElement chkBxMediaAttention() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Possible Media Attention')]/../following-sibling::td/input[1]"));
    }

    public WebElement btnSave() {
        return waitForElementPresent(By.xpath("//div[@id='pnl3_MandatoryFields']/table/tbody/tr[4]/td/input[@id='ucMandatoryFieldEditor_btnSave']"));
    }

    public WebElement btnSaveAndClose() {
        return waitForElementPresent(By.id("btnSaveAndClose"));
    }

    public WebElement btnCancel() {
        return waitForElementPresent(By.id("btnCancel"));
    }


    public WebElement createAndSendEmail() {

        return waitForElementPresent(By.xpath("//input[contains(@id,'btnSaveSendDoc')]"));
    }

    public WebElement requestInRelationDropdownImg() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Request in Relation')]/../following-sibling::td/div/div/img"));
    }

    public WebElement requestInRelationDropdownValue(String value) {

        return waitForElementPresent(By.xpath("//div[contains(text(),'" + value + "')]"));
    }

    public WebElement detailsOfRequest() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Details of Request')]/../following-sibling::td/textarea"));
    }

    public WebElement informationProvided() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Information Provided')]/../following-sibling::td/textarea"));
    }

    public WebElement likelyToBecomeClaimImg() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Likely to Become a Claim')]/../following-sibling::td/div/div/img"));
    }

    public WebElement likelihoodOfClaim() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Likelihood of Claim')]/../following-sibling::td/textarea"));
    }

    public WebElement customerFaxNumber() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Customer Fax Number')]/../following-sibling::td/input)[1]"));
    }

    public WebElement email() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Email')]/../following-sibling::td/input)[1]"));
    }

    public WebElement addSupplier() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Supplier')]/following-sibling::input[contains(@name,'searchButton')]"));
    }

    public WebElement selectSupplier(String fieldValue) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + fieldValue + "')]/preceding-sibling::td/a"));
    }

    public WebElement editTMAClaimValue() {
        return waitForElementPresent(By.xpath("//*[contains(@id,'ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_rgMatterHeaders_ctl01')]//a"));
    }

    public String guaranteeReasonXpath() {
        return "//div[contains(@id,'DropDownPlaceholder')]/div/div";
    }

    public WebElement comboBox() {
        return waitForElementPresent(By.xpath("//input[@class='ComboBoxInput_Default']"));
    }

    public WebElement guaranteeReasonOption(String fieldValue) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + fieldValue + "')]"));
    }

    public WebElement supplierTypeOption(String fieldValue) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + fieldValue + "')]"));
    }

    public WebElement supplierTelephone() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Supplier Telephone')]/../following-sibling::td/input)[1]"));
    }

    public WebElement supplierFax() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Supplier Fax')]/../following-sibling::td/input)[1]"));
    }

    public WebElement supplierAddress1() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Supplier Address 1')]/../following-sibling::td/input)[1]"));
    }

    public WebElement supplierAddress2() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Supplier Address 2')]/../following-sibling::td/input)[1]"));
    }

    public WebElement supplierTown() {
        return waitForElementPresent(By.xpath(" (//*[contains(text(),'Supplier Town')]/../following-sibling::td/input)[1]"));
    }

    public WebElement supplierCounty() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Supplier County')]/../following-sibling::td/input)[1]"));
    }

    public WebElement supplierPostcode() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Supplier Postcode')]/../following-sibling::td/input)[1]"));
    }

    public WebElement agentTypeOption(String fieldValue) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + fieldValue + "')]"));
    }

    public WebElement agentTelephone() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Agent Telephone')]/../following-sibling::td/input)[1]"));
    }

    public WebElement agentFax() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Agent Fax')]/../following-sibling::td/input)[1]"));
    }

    public WebElement faxNumber() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Fax Number')]/../following-sibling::td/input)[1]"));
    }

    public WebElement agentAddress1() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Agent Address 1')]/../following-sibling::td/input)[1]"));
    }

    public WebElement surgeryAddress1() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Surgery Address 1')]/../following-sibling::td/input)[1]"));
    }

    public WebElement surgeryAddress2() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Surgery Address 2')]/../following-sibling::td/input)[1]"));
    }

    public WebElement surgeryAddress3() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Surgery Address 3')]/../following-sibling::td/input)[1]"));
    }

    public WebElement surgeryAddress4() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Surgery Address 4')]/../following-sibling::td/input)[1]"));
    }

    public WebElement agentAddress2() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Agent Address 2')]/../following-sibling::td/input)[1]"));
    }

    public WebElement agentTown() {
        return waitForElementPresent(By.xpath(" (//*[contains(text(),'Agent Town')]/../following-sibling::td/input)[1]"));
    }

    public WebElement agentCounty() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Agent County')]/../following-sibling::td/input)[1]"));
    }

    public WebElement agentPostcode() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Agent Postcode')]/../following-sibling::td/input)[1]"));
    }

    public WebElement telephoneNumber() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Telephone Number')]/../following-sibling::td/input)[1]"));
    }

    public WebElement contactName() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Contact Name')]/../following-sibling::td/input)[1]"));
    }

    public WebElement surgeryPostcode() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Surgery Postcode')]/../following-sibling::td/input)[1]"));
    }

    public WebElement agentName() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Agent Name')]/../following-sibling::td/input)[1]"));
    }

    public WebElement gpName() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'GP Name')]/../following-sibling::td/input)[1]"));
    }

    public WebElement surgeryName() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Surgery Name')]/../following-sibling::td/input)[1]"));
    }

    public WebElement relevantParties(String valueToVerify) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + valueToVerify + "')]/../following-sibling::td/input[@type='checkbox']"));
    }

    public WebElement nextToKinAsMainPointOfContact() {
        return waitForElementPresent(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_chk302886')]"));
    }

    public WebElement nextToKinEmail() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt302414"));
    }

    public WebElement nextToKinAddress2() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt302889"));
    }

    public WebElement nextToKinTown() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_txt302890"));
    }


    public WebElement privateMedicalInsurance() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Private Medical Insurance')]/../following-sibling::td//img"));
    }

    public WebElement privateMedicalInsuranceOption(String fieldValue) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + fieldValue + "')]"));
    }

    public WebElement chBxSupplier() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Supplier (A)')]/../following-sibling::td/input[1]"));

    }

    public WebElement chBxCustomer() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Customer (A)')]/../following-sibling::td/input[1]"));

    }

    public WebElement chBxNextOfKin() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Next of Kin (A)')]/../following-sibling::td/input[1]"));

    }

    public WebElement btnSave1() {
        return waitForElementPresent(By.xpath("//input[starts-with(@name,'ucMandatoryFieldEditor$btnSave')]"));
    }

    public WebElement supplierEmail() {
        return waitForElementVisible(By.xpath("(//*[contains(text(),'Supplier Email')]/../following-sibling::td/input)[1]"));
    }

    public WebElement supplierName() {
        return waitForElementVisible(By.xpath("(//*[contains(text(),'Supplier Name')]/../following-sibling::td/input)[1]"));
    }

    public WebElement agentEmail() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Agent Email')]/../following-sibling::td/input)[1]"));
    }

    public WebElement addAgent() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Agent')]/following-sibling::input[contains(@name,'searchButton')]"));
    }

    public WebElement addGP() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'GP')]/following-sibling::input[contains(@name,'searchButton')]"));
    }

    public WebElement executorAsMainPointOfcontactValidation() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Executor as Main Point Of Contact')]/../following-sibling::td/input[2]"));
    }

    public WebElement executorAsMainPointOfcontact() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Executor as Main Point Of Contact')]/../following-sibling::td/input[1]"));
    }

    public WebElement titleImg() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Title')]/../following-sibling::td//img"));
    }

    public WebElement selectTitle(String fieldValue) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + fieldValue + "')]"));
    }

    public WebElement executorDetails(String fieldName) {
        System.out.println("//span[text()='" + fieldName + "']/../following-sibling::td/input[1]");
        return waitForElementPresent(By.xpath("//span[text()='" + fieldName + "']/../following-sibling::td/input[1]"));
    }

    public WebElement caseType() {
        return waitForElementPresent(By.xpath("(//input[@class='ComboBoxInput_Default'])[1]"));
    }

    public WebElement drpdnCaseType(String type) {
        return waitForElementPresent(By.xpath("//div[starts-with(@id,'ucMandatoryFieldEditor_ddl303829_') and contains(text(),'" + type + "')]"));
    }


    public WebElement escorted() {

        try{
            return waitForElementPresent(By.xpath("//span[contains(text(),'Escorted (A)')]/../following-sibling::td[1]"));
        } catch(Exception e) {
            return waitForElementVisible(By.xpath("(//input[starts-with(@class,'ComboBoxInput_Default')])[1]"));
        }
    }

    public WebElement drpdnEscorted(String type) {
        return waitForElementPresent(By.xpath("//div[starts-with(@class,'ComboBoxItem') and contains(text(),'" + type + "')]"));
    }

    public WebElement airAmbulance() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Air Ambulance (A)')]/../following-sibling::td[1]"));
    }

    public WebElement drpdnAirAmbulance(String type) {
        return waitForElementPresent(By.xpath("//div[starts-with(@class,'ComboBoxItem') and contains(text(),'" + type + "')]"));
    }

    public WebElement wheelChairAssistance() {

        return waitForElementPresent(By.xpath("(//input[@class='ComboBoxInput_Default'])[3]"));
    }

    public WebElement drpdnWheelChairAssistance(String type) {
        return waitForElementPresent(By.xpath("//div[starts-with(@class,'ComboBoxItem') and contains(text(),'" + type + "')]"));
    }


    public WebElement chkBxOnOriginalFlight() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'On Original Flight')]/../following-sibling::td/input[1]"));
    }


    public WebElement chkBxBusiness() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Business')]/../following-sibling::td/input[1]"));
    }


    public WebElement chkBxExtraSeats() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Extra Seats')]/../following-sibling::td/input[1]"));
    }


    public WebElement chkBxStretcher() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Stretcher')]/../following-sibling::td/input[1]"));
    }


    public WebElement chkBxNonMedicalEscort() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Non-Medical Escort')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxDeceased() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Deceased')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxAdmission() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Admission')]/../following-sibling::td/input[1]"));
    }


    public WebElement chkBxIntlAmbulanceRepatriation() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'International Ambulance Repatriation')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxRepatriationByTrain() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Repatriation by Train')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxRepatriationByBoat() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Repatriation by Boat')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxNoRepatriationRequired() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'No Repatriation Required')]/../following-sibling::td/input[1]"));
    }

    public WebElement seatsRequired() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'How many seats are required')]/../following-sibling::td/input[1]"));
    }

    public WebElement oxygenRequired() {

        return waitForElementPresent(By.xpath("//span[starts-with(text(),'Oxygen Required')]/../following-sibling::td/input[1]"));
    }

    public WebElement litresOfOxygenRequired() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Litres of Oxygen Required')]/../following-sibling::td/input[1]"));
    }

    public WebElement txtCallerName() {
        return waitForElementVisible(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_txt303789')]"));
    }

    public WebElement txtCallerContactNo() {
        return waitForElementVisible(By.xpath("//input[starts-with(@id,'ucMandatoryFieldEditor_txt303790')]"));
    }

    public WebElement patientRelationship() {

        return waitForElementVisible(By.xpath("(//input[starts-with(@id,'ucMandatoryFieldEditor_ddl303791_')])[1]"));
    }

    public WebElement drpdnPatientRelationship(String type) {
        return waitForElementPresent(By.xpath("//div[starts-with(@id,'ucMandatoryFieldEditor_ddl303791_') and contains(text(),'" + type + "')]"));
    }


    public WebElement currentPatientDetails() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'Current Patient Status')]/../following::td[1]//input[@class='ComboBoxInput_Default']"));
    }

    public WebElement GPChecheckRequired() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'GP Check Required')]/../following::td[1]//input[@class='ComboBoxInput_Default']"));
    }

    public WebElement options(String fieldValue) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + fieldValue + "')]"));
    }

    public WebElement namedPeopleSaveBtn() {
        return waitForElementToBeClickableAndReturnElement(By.id("ucMandatoryFieldEditor_customFieldSaveButton"));
    }

    public WebElement insertHotelButton() {
        return waitForElementPresent(By.xpath("//input[@value='Insert']"));
    }

    public WebElement saveHotelDetails() {
        return waitForElementPresent(By.id("ucMandatoryFieldEditor_btnSaveBasicTableEdit"));
    }

    public WebElement kinPassword() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Password')]/../following-sibling::td[1]/input[1]"));
    }

    public String statusList() {
        return "(//div[contains(@id,'DropDownPlaceholder')]/div[contains(@id,'DropDown')])[1]/div";
    }

    public String incidentList() {
        return "(//div[contains(@id,'DropDownPlaceholder')]/div[contains(@id,'DropDown')])[2]/div";
    }

    public WebElement flightDetails(String fieldName) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + fieldName + "')]/../following-sibling::td//input[1]"));
    }

    public WebElement latestDiagnosis() {
        return waitAndFindElement(By.xpath("//span[contains(text(),'Latest Diagnosis')]/../following-sibling::td//textarea"));
    }

    public WebElement treatingClinic() {
        return waitAndFindElement(By.xpath("//span[contains(text(),'Treating Clinic')]/../following-sibling::td//textarea"));
    }

    public WebElement flightReturnDate() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Return Flight Date')]/../following-sibling::td//input[contains(@id,'dateInput_text')]"));
    }

    public WebElement healixNurseNotes() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Healix Nurse Note')]/../following::td/textarea"));
    }

    public WebElement healixNurseNotesTime() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Nurse Next Note Time')]/../following::td//input[@class='radEnabledCss_Default']"));
    }


    public WebElement commentsTextarea() {
        return waitAndFindElement(By.xpath("//span[contains(text(),'Comments:')]/../following::td/textarea"));
    }

    public WebElement btnFinish() {
        return waitAndFindElement(By.id("btnFinish"));
    }

    public WebElement appointmentTime() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Appointment Time')]/../following::td//input)[1]"));
    }


    public WebElement requestType() {
        return waitForElementPresent(By.xpath("//tr[contains(@class,'GridRow_Default')]/td[4]"));
    }


    public WebElement requestStatus() {
        return waitForElementPresent(By.xpath("//tr[contains(@class,'GridRow_Default')]/td[16]"));
    }

    public WebElement transferRequired() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Transfer Required')]/../following::td//input)[1]"));
    }

    public WebElement clientInformedArrangements() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Client informed of Arrangements')]/../following::td//input)[1]"));
    }

    public WebElement reasonForAppointment() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Reason for Appointment')]/../following::td//textarea)[1]"));
    }

    public WebElement totalAppointmentCost() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Total Appointment Cost')]/../following::td//input)[1]"));
    }

    public WebElement optionsToSelect(String option) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + option + "')]"));
    }

    public WebElement subDetailsBtn() {
        return waitAndFindElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdItems_ctl01_aimgOpen"));
    }

    public WebElement typeOfClaimInClaimTable() {
        return waitForElementPresent(By.xpath("//table[contains(@id,'grdMedicalExclusions')]//tr[2]/td[1]"));
    }

    public WebElement isMediaInvolvedInClaimTable() {
        return waitForElementPresent(By.xpath("//table[contains(@id,'grdMedicalExclusions')]//tr[2]/td[2]"));
    }

    public WebElement diagnosisInClaimTable() {
        return waitForElementPresent(By.xpath("//table[contains(@id,'grdMedicalExclusions')]//tr[2]/td[3]"));
    }

    public WebElement destinationInClaimTable() {
        return waitForElementPresent(By.xpath("//tr[contains(@id,'grdItems_ctl01_gridRow')]/td[6]"));
    }

    public WebElement gpCheckStatusInClaimTable() {
        return waitForElementPresent(By.xpath("//table[contains(@id,'grdMedicalExclusions')]//tr[2]/td[4]"));
    }

    public WebElement editFirstTMAClaim() {
        return waitForElementPresent(By.xpath("//tr[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdItems_ctl01_gridRow']/td[1]/a"));
    }

    public WebElement medicalTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Medical')]/../.."));
    }

    public WebElement appointmentDateValue() {
        return waitAndFindElement(By.xpath("//*[contains(text(),'Appointment Date')]/../following::td//input[@class='radEnabledCss_Default']/following::input[1]"));
    }


    public WebElement repatriationTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Repatriation')]/../.."));
    }


    public WebElement capcostInput() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Cost Cap')]/../following::td[1]/input[1]"));
    }

    public WebElement applyToAll() {
        return waitForElementPresent(By.id("ChkApplyToAll"));
    }

    public WebElement prioritySelect() {
        return waitForElementPresent(By.id("ddlPriority"));
    }

    public WebElement noteDescriptionInput() {
        return waitForElementPresent(By.id("txtNoteDescription"));
    }


    public WebElement noteTypeSelect() {
        return waitForElementPresent(By.id("ddlNoteType"));
    }

    public WebElement paymentMethodSelect() {
        return waitForElementPresent(By.xpath("//h2[contains(text(),'Payment Method')]/following::select[1]"));
    }

    public WebElement addNewPaymentAccount() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Add New Payment Account')]/../following::td[1]/input[1]"));
    }

    public WebElement enterGPDetailBtn() {
        return waitForElementPresent(By.xpath("//label[contains(text(),'Enter GP Details')]/../input"));
    }

    public WebElement gpCheckRequiredBtn() {
        return waitForElementPresent(By.xpath("//label[contains(text(),'GP Check Required')]/../input"));
    }

    public WebElement gpCheckList(String fieldName) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + fieldName + "')]/../following::td/input[1]"));
    }


    public WebElement txtSupplierType() {
        return waitAndFindElement(By.xpath("//*[contains(text(),'Supplier Type')]//../following-sibling::td[1]/div/div/input"));
    }

    public WebElement txtCompanyName() {
        return waitAndFindElement(By.xpath("//*[contains(text(),'Company Name')]//../following-sibling::td/input"));
    }

    public WebElement guaranteeReason() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Guarantee Reason')]/../following::td[1]/div/div/input"));
    }


    public WebElement supplierInstructionsTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Supplier Instructions')]/../.."));
    }


    public WebElement chxSupplierSelected() {
        return waitForElementPresent(By.xpath("//span[contains(@class,'chk_303693')]/input"));
    }
    public WebElement chxluggageSelected() {
        return waitForElementPresent(By.xpath("//input[contains(@id,'ucMandatoryFieldEditor_~/CustomDetailFieldViews/Client_427/Field_303693.ascx__303693__55303762_grdSupplier_ctl04_chkSelected')]"));
    }
    public WebElement chkBxNamesOfPeopleSpeltCorrectly() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Full names of people travelling are spelt correctly')]/../following-sibling::td/input[1]"));
    }


    public WebElement chxSpecialRequirements() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Special Requirements')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxPassportDetailsReceived() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'All passport details have been received')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxCustomerExpectationSet() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Customer expectations have been set')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxOriginalTASet() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Original transfer arrangements have been set')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxClaimCovered() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Claim is covered')]/../following-sibling::td/input[1]"));
    }


    public WebElement chkBxCustomerContactSuccessful() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Customer Contact Successful')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxCustomerHappyToProceed() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Customer Happy to Proceed')]/../following-sibling::td/input[1]"));
    }

    public WebElement descriptionOfSuitcases() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Brief Description of Suitcases (Size, Colour & Weight')]/../following-sibling::td/textarea"));
    }

    public WebElement chkBxValuablesRemoved() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'All Valuables Removed & Suitcases Left Unlocked for Customs')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxLiquidsRemoved() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'All Liquids Removed from Suitcases')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxCustomerPackedSuitcase() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Customer Packed Suitcase Themselves')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxSuitcaseCorrectAddressLabels(String fieldValue) {

        return waitForElementPresent(By.xpath("//span[contains(text(),'" + fieldValue + "')]/../following-sibling::td/input[1]"));
    }

    public WebElement chkBxSuitcaseLocationContactDetails(String fieldValue) {

        return waitForElementPresent(By.xpath("//span[contains(text(),'" + fieldValue + "')]/../following-sibling::td/textarea"));
    }


    public WebElement confirmAirAmbulance() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//label[contains(text(),'Confirm Air Ambulance Approval')]/../input"));
    }


    public WebElement tmaSelectedQuoteComments() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Selected Quote')]/../following-sibling::td/textarea"));
    }


    public WebElement prpaRequired() {
        return waitForElementPresent(By.xpath("(//input[@class='ComboBoxInput_Default'])[1]"));
    }

    public WebElement drpdnPrpaRequired(String type) {
        return waitForElementPresent(By.xpath("div[starts-with(@id,'ucMandatoryFieldEditor_ddl304214_55294033_c1') and contains(text(),'" + type + "')]"));
    }

    public WebElement medicalClearanceRequired() {
        return waitForElementPresent(By.xpath("(//input[@class='ComboBoxInput_Default'])[2]"));
    }

    public WebElement drpdnMedicalClearanceRequired(String type) {
        return waitForElementPresent(By.xpath("//div[starts-with(@id,'ucMandatoryFieldEditor_ddl304215_55294033_c4') and contains(text(),'" + type + "')]"));
    }

    public WebElement fitToFlyCertificateRequired() {
        return waitForElementPresent(By.xpath("(//input[@class='ComboBoxInput_Default'])[3]"));
    }

    public WebElement drpdnfitToFlyCertificateRequired(String type) {
        return waitForElementPresent(By.xpath("//div[starts-with(@id,'ucMandatoryFieldEditor_ddl304215_55294033_c4') and contains(text(),'" + type + "')]"));
    }

    public WebElement txtToEmail() {
        return waitForElementPresent(By.xpath("//textarea[@name='ctl00$cphBody$txtRecipientsTo']"));
    }

    public WebElement btnCreateSendEmail() {
        return waitForElementPresent(By.xpath("//div[@id='ctl00_cphBody_pnlMain']/div/div/input[@value='Create Event And Send Email']"));
    }

    public WebElement txtPatientName() {
        return waitForElementPresent(By.xpath("//input[contains(@id, 'txt304340')]"));
    }

    public WebElement txtPatientDOB() {
        return waitForElementPresent(By.xpath("//input[contains(@id, 'txt304341')]"));
    }

    public WebElement txtHealixDate() {
        return waitForElementPresent(By.xpath("//input[contains(@id, 'ucMandatoryFieldEditor_txt304344')]"));
    }

    public WebElement txtHealixLocation() {
        return waitForElementPresent(By.xpath("//input[contains(@id, 'txt304345')]"));
    }

    public WebElement txtHealixDoctor() {
        return waitForElementPresent(By.xpath("//input[contains(@id, 'txt304347')]"));
    }

    public WebElement txtGPneeded() {
        return waitForElementPresent(By.xpath("//input[contains(@id, 'ucMandatoryFieldEditor_txt304353')]"));
    }

    public WebElement txtNextMedicalContact() {
        return waitForElementPresent(By.xpath("//input[contains(@id, 'ucMandatoryFieldEditor_txt304354')]"));
    }

    public WebElement txtReportWrittenBy() {
        return waitForElementPresent(By.xpath("//input[contains(@id, 'ucMandatoryFieldEditor_txt304355')]"));
    }

    public WebElement btnSaveMedicalFirstReport() {
        return waitForElementPresent(By.xpath("//input[@value='Save']"));
    }

    public WebElement lnkEditTMAclaim() {
        return waitForElementPresent(By.xpath("//a[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdItems_ctl01_lnkMatterView']"));
    }

    public WebElement tabHealixReport() {
        return waitForElementPresent(By.xpath("//a[contains(@title,'Healix Reports')]"));
    }

    public WebElement dropdownTeamLeadDecision(String decision) {
        return waitForElementVisible(By.xpath("//span[contains(text(),'"+decision+"')]/../following-sibling::td[1]/div/div/img"));
    }

    public WebElement txtTeamLeadDecision(String decision) {
        return waitForElementVisible(By.xpath("//*[contains(text(),'"+decision+"')]"));
    }

    public WebElement optionUnderwriter(String option) {
        return waitForElementVisible(By.xpath("//div[contains(text(),'"+option+"')]"));
    }

    public WebElement lnkOutsideTMAClaim() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_LeadInfo1_ctl01_lnkClaim']"));
    }

    public WebElement selectedAirAmbulanceFlightScheduleComments() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Air Ambulance Flight Schedule')]/../following-sibling::td//textarea"));
    }


    public WebElement txtDateOfIssue() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Date of Issue')]/../following-sibling::td[1]/div[1]/div/span/input[contains(@class, 'radEnabledCss_Default')]"));
    }

    public WebElement txtFullName() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Full Name')]/../following-sibling::td//input[contains(@type, 'text')]"));
    }

    public WebElement txtPassportNumber() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Passport Number')]/../following-sibling::td//input[contains(@type, 'text')]"));
    }

    public WebElement txtCountryOfIssue() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Country of Issue')]/../following-sibling::td//input[contains(@type, 'text')]"));
    }

    public WebElement txtExpirationDate() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Expiration Date')]/../following-sibling::td[1]/div[1]/div/span/input[contains(@class, 'radEnabledCss_Default')]"));
    }


    public WebElement txtToAddress() {
        return waitForElementPresent(By.xpath("//input[@value= 'To...']/../following-sibling::td//textarea"));
    }

    public WebElement btnCreateEventAndSendEmail() {
        return waitForElementPresent(By.xpath("//input[@value= 'Create Event And Send Email']"));
    }


    public WebElement chbxMedicalReportTranslationRequired() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Medical Report Translation Required')]/../following-sibling::td/input[1]"));
    }

    public WebElement btnUploadFile() {

        return waitForElementPresent(By.xpath("//div[contains(text(),'File:')]/following-sibling::div/input"));
    }

    public WebElement txtTMALeadId() {
        return waitForElementPresent(By.xpath("//span[@id='lblLeadID']"));
    }

    public WebElement btnEnterEdit() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//input[contains(@id,'btnEditMode')]"));
    }

    public WebElement chkBoxAssignee(String LeadId) {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[contains(text(),'"+LeadId+"')]/../..//input[contains(@name,'chkPickForReassignment')]"));
    }

    public WebElement btnReassign() {
        return waitForElementPresent(By.xpath("//input[@id='btnReassignSelected']"));
    }

    public WebElement drpdownReassign() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//select[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ddlAssignee']"));
    }
    public WebElement btnOK() {
        return waitForElementPresent(By.xpath("(//input[@value='OK'])[2]"));
    }

    public WebElement btnUpdateTasks() {
        return waitForElementPresent(By.xpath("//input[@value='Update All Tasks']"));
    }

    public WebElement txtReferralDecisionDetail() {
        return waitForElementPresent(By.xpath("//textarea[contains(@name,'ucMandatoryFieldEditor$txt304')]"));
    }

    public WebElement txtFlightDetails() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Original Flight Details, Date and Booking Reference (A)')]/../following-sibling::td/input[1]"));
    }

    public WebElement txtUKHospitalDetails() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'UK Hospital Details (A)')]/../following-sibling::td/textarea[1]"));
    }

    public WebElement saveBtn() {
        return waitForElementPresent(By.name("ucMandatoryFieldEditor$customFieldSaveButton"));
    }

    public WebElement txtPatientsName() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'confirmed spelling please')]/../following-sibling::td/input[starts-with(@id,'ucMandatoryFieldEditor')]"));
    }

    public WebElement txtPatientsDob() {
        return waitForElementVisible(By.xpath("(//span[contains(text(),'Date of Birth')]/../following-sibling::td//input[contains(@id,'dateInput')])[1]"));
    }

    public WebElement recipientID() {
        return waitForElementPresent(By.id("ctl00_cphBody_txtRecipientsTo"));
    }

    public WebElement TMAClaimId() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdItems_ctl01_gridRow']/td[3]"));
    }

    public String lnkTMAClaimXpath() {
        return "(//a[text()='TMA'])[1]";
    }

    public WebElement appointmentDateImg() {
        return waitForElementPresent(By.xpath("//img[not(contains(@id,'rdpDateOfBirth')) and contains(@id,'CalendarPopupButton')]"));
    }

    public WebElement appointmentFutureDate(String date) {
        try{
        return waitForElementPresent(By.xpath("(//table[not(contains(@id,'rdpDateOfBirth')) and contains(@id,'calendar_Top')]//td[@class='radCalDefault_Default']/a[text()='"+date+"'])[last()]"));
    } catch(Exception e){
            return waitForElementPresent(By.xpath("(//table[not(contains(@id,'rdpDateOfBirth')) and contains(@id,'calendar_Top')]//td[@class='radCalWeekendDefault_Default']/a[text()='"+date+"'])[last()]"));
        }

        }

    public WebElement txtAdmissionDateImg() {
        return waitForElementPresent(By.xpath("(//img[not(contains(@id,'rdpDateOfBirth')) and contains(@id,'CalendarPopupButton')])[1]"));
    }
    public WebElement txtAdmissionANdDischargeDate(String date) {
        return waitForElementPresent(By.xpath("(//table[not(contains(@id,'rdpDateOfBirth')) and contains(@id,'calendar_Top')]//a[text()='"+date+"'])[1]"));
    }
    public WebElement txtDischargeDateImg() {
        return waitForElementPresent(By.xpath("(//img[not(contains(@id,'rdpDateOfBirth')) and contains(@id,'CalendarPopupButton')])[2]"));
    }

    public WebElement claimIdTMA() {
        return waitForElementPresent(By.xpath("//*[@id=\"ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_grdClaims\"]/tbody/tr[2]/td[2]"));
    }
}
