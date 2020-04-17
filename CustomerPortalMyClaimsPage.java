package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;


/**
 * Created by 588800 on 11/16/2017.
 */
public class CustomerPortalMyClaimsPage extends AbstractPage {
    public String lblMyClaim() {
        return "//h1[contains(text(),'My Claims')]";
    }

    public String lblClaimsOptions(String options) {
        return "//h2[contains(text(),'" + options + "')]";
    }

    public String lblMakeAClaim() {
        return "//div[@class='page-headings fade-in row']//i[@class='fa fa-plus']";
    }

    public WebElement btnMakeAClaim() {
        return waitForElementPresent(By.id("link_claims_make_claim"));
    }

    public String lblNoOpenClaims() {
        return "//p[contains(text(),'You have no open claims')]";
    }

    public String lblNoClosedClaims() {
        return "//p[contains(text(),'You have no closed claims')]";
    }

    public WebElement lnkClickHere() {
        return waitForElementPresent(By.linkText("click here"));
    }

    public WebElement lblMediAssistanceMsg() {
        return waitForElementPresent(By.xpath("(//p)[2]"));
    }

    public String lblMedicalStatement() {
        return "//div[@class='medical-statement']";
    }

    public String lblOpenClaimHeadings(String heading) {
        return "(//h3[contains(text(),'" + heading + "')])[1]";
    }

    public WebElement lblOpenClaimDetails(String details) {
        return waitForElementPresent(By.xpath("(//h3[contains(text(),'" + details + "')])[1]/../p"));
    }

    public WebElement tabMyClaims() {

        return waitForElementPresent(org.openqa.selenium.By.xpath("//span[contains(text(),'My Claims')]"));
    }

    public String listOfClaims() {
        return "//div[@class='claim row']";
    }

    public WebElement lnkEachClaimItem(int i) {
        System.out.println("(//div[@class='claim row'])[" + i + "]");
        return waitForElementPresent(By.xpath("(//div[@class='claim row'])[" + i + "]"));
    }

    public WebElement lnkClaimItemShrink() {
        System.out.println("(//div[@class='claim row active'])[1]");
        return waitForElementPresent(By.xpath("(//div[@class='claim row active'])[1]"));
    }

    public WebElement lnkClaimItem() {
        return waitForElementPresent(By.xpath("(//div[@class='claim row'])[1]"));
    }

    public WebElement lnkUpload() {
        return waitForElementPresent(By.linkText("Upload"));
    }

    public String lnkForUpload() {
        return "//span[contains(text(),'Upload')]";
    }

    public String lblEvidenceHeading() {
        return "//h1[contains(text(),'Providing Evidence')]";
    }

    public WebElement btnNext() {
        try {
            return waitForElementPresent(By.xpath("//button[contains(text(),'Next')]"));
        } catch (Exception e) {
            return waitForElementPresent(By.xpath("//div[@class='next-button']/button"));
        }

    }

    public WebElement drpdnDestination() {
        return waitForElementPresent(By.id("ddl_claims_trip_location"));
    }

    public WebElement dateTripBooked() {
        return waitForElementPresent(By.id("date_claims_trip_when"));
    }

    public WebElement futureDate() {
        return waitForElementPresent(By.xpath("(//td[@class='is-today is-selected']/following-sibling::td)[1]"));
    }

    public WebElement tripEndDateBeforeStartDate(String yesterday) {
        return waitForElementPresent(By.xpath("(//td[@data-day='" + yesterday + "'])[3]"));
    }

    public WebElement dateOfLossFutureDate(String tomorrow) {
        return waitForElementPresent(By.id("date_claims_trip_dol"));
    }

    public WebElement dateTripFrom() {
        return waitForElementPresent(By.id("date_claims_trip_start"));
    }

    public WebElement dateTripTo() {
        return waitForElementPresent(By.id("date_claims_trip_end"));
    }

    public WebElement tabTripDetails() {
        return waitForElementPresent(By.linkText("Trip Details"));
    }

    public WebElement txtDescription() {
        return waitForElementPresent(By.xpath("//textarea[@formcontrolname='description']"));
    }

    public WebElement dateofLoss() {
        return waitForElementPresent(By.id("date_claims_trip_dol"));
    }

    public WebElement drpdnCountryOfLoss() {
        return waitForElementPresent(By.id("ddl_claims_trip_loss_location"));
    }

    public WebElement chkBxClaimType(String cause) {

        return waitForElementVisible(By.xpath("(//p[contains(text(),'" + cause + "')])[1]/../..//label"));
    }

    public WebElement drpdnSubCause(String cause) {
        return waitForElementPresent(By.xpath("(//p[contains(text(),'" + cause + "')])[1]/../../..//select"));
    }

    public WebElement drpdnClaimItem() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='typeID']"));
    }

    public WebElement txtAmount() {
        return waitForElementPresent(By.id("txt_claims_details_amount"));
    }

    public WebElement drpdnCurrency() {
        return waitForElementPresent(By.id("ddl_claims_details_currency"));
    }

    public WebElement drpdnPerson() {
        return waitForElementPresent(By.id("ddl_claims_details_person"));
    }

    public WebElement txtDescriptionClaimItem() {
        return waitForElementPresent(By.id("txt_claims_details_description"));
    }

    public WebElement btnAdd() {
        return waitForElementPresent(By.id("btn_claims_details_add"));
    }
    public WebElement btnSave() {
        return waitForElementPresent(By.id("ddl_claims_details_save"));
    }

    public WebElement btnNextClaimDetails() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Next')]"));
    }

    public WebElement drpdnPerilQuestions(String ques) {
        return waitForElementPresent(By.xpath("//label[contains(text(),'" + ques + "')]/../select"));
    }
    public WebElement storeNotes(String ques){
        return waitForElementPresent(By.xpath("//label[contains(text(),'"+ques+"')]/../textarea"));
    }

    public WebElement drpdnReportedLost() {
        return waitForElementPresent(By.xpath("//label[contains(text(),'reported lost')]/../select"));
    }

    public String lblReportedLost() {
        return "//h1[contains(text(),'Extra Questions')]";
    }

    public WebElement drpdnProofOfOwnership() {
        return waitForElementPresent(By.xpath("//label[contains(text(),'proof of ownership')]/../select"));
    }

    public WebElement drpdnFavColor() {
        return waitForElementPresent(By.xpath("//label[contains(text(),'favourite colour')]/../select"));
    }

    public WebElement drpdnDay() {
        return waitForElementPresent(By.xpath("//label[contains(text(),'What day is it')]/../select"));
    }

    public String btnWithdraw() {
        return "//*[contains(text(),'Withdraw Claim')]";
    }

    public WebElement lblDestination(String title) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + title + "')]/../..//div[contains(text(),'Destination')]/../div[2]"));
    }

    public WebElement lblTripBooked(String title) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + title + "')]/../..//div[contains(text(),'Trip Booked')]/../div[2]"));
    }

    public WebElement lblTripFrom(String title) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + title + "')]/../..//div[contains(text(),'Trip dates - From')]/../div[2]"));
    }

    public WebElement lblTripTo(String title) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + title + "')]/../..//div[contains(text(),'Trip dates - To')]/../div[2]"));
    }

    public WebElement lblReportedLoss(String title) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + title + "')]/../..//div[contains(text(),'Reported Lost')]/../div[2]"));
    }

    public WebElement lblProofOwner(String title) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + title + "')]/../..//div[contains(text(),'Proof of Ownership')]/../div[2]"));
    }

    public WebElement lblWhatDay(String title) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + title + "')]/../..//div[contains(text(),'What day is it?')]/../div[2]"));
    }

    public WebElement lblFavColor(String title) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + title + "')]/../..//div[contains(text(),'favourite colour')]/../div[2]"));
    }

    public WebElement lblAddedPeril() {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'Claim Type')]/../..//div[@class='heading']/h3"));
    }

    public WebElement lblClaimDetails(String title) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + title + "')]/../..//div[contains(text(),'Details')]/../div[2]"));
    }

    public WebElement lblDateOfIncident(String title) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + title + "')]/../..//div[contains(text(),'Date of incident')]/../div[2]"));
    }

    public WebElement lblCountryOfLoss(String title) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + title + "')]/../..//div[contains(text(),'Country of Loss')]/../div[2]"));
    }

    public String lblACKMsg(String msg) {
        return "//*[contains(text(),'" + msg + "')]";
    }

    public WebElement btnSubmit() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Proceed')]"));
    }

    public WebElement btnAccept() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Accept')]"));
    }

    public WebElement btnDiscuss() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Discuss')]"));
    }

    public WebElement btnViewClaims() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'View Claims')]"));
    }

    public WebElement lblYoungestClaimID() {
        return waitForElementPresent(By.xpath("(//h3[contains(text(),'Claim No')]/../p)[1]"));
    }

    public WebElement lblLatestReopenedClaim() {
        return waitForElementPresent(By.xpath("(//h3[contains(text(),'Status')]/../p)[1]"));
    }

    public WebElement clickNextForClaims() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Next')]"));
    }

    public WebElement msgConfirmation() {
        return waitForElementPresent(By.xpath("//div[@class='page-headings']"));
    }

    public WebElement msgConfirmationPara1() {
        return waitForElementPresent(By.xpath("//div[@class='page-headings']/h1"));
    }

    public WebElement msgConfirmationPara2() {
        WebElement wb = waitForElementPresent(By.xpath("//div[@class='page-headings']/p[1]"));
        if (getDriver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)getDriver).executeScript("arguments[0].style.border='3px solid red'", wb);
        }
        return wb;
    }

    public WebElement msgConfirmationPara3() {
        return waitForElementPresent(By.xpath("//div[@class='page-headings']/p[2]"));
    }

    public WebElement msgConfirmationPara4() {
        return waitForElementPresent(By.xpath("//div[@class='page-headings']/p[3]"));
    }

    public WebElement btnUploadEvidence() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Upload Evidence')]"));
    }

    public String btnUploadFiles() {
        return "//div[@class='upload-buttons']/input";
    }


    public WebElement lblClaimItemInEvidence() {
        return waitForElementPresent(By.xpath("//div[@class='row title']/h3"));
    }

    public WebElement lblEvidenceType() {
        return waitForElementPresent(By.xpath("//div[@class='checkbox row']//h3"));
    }

    public WebElement chkBxEvidenceType() {
        return waitForElementPresent(By.xpath("//div[@class='checkbox row']//label"));
    }

    public WebElement lblClaimStatus() {
        return waitForElementPresent(By.xpath("(//h3[contains(text(),'Status')]/following-sibling::p)[1]"));
    }
    public WebElement medicalEmergency(String text){
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+text+"')]"));
    }

    public WebElement btnUploadDocuments() {
        return waitForElementPresent(By.xpath("//div[@class='row evidence provide-evidence']"));
    }

    public String claimsTable() {
        return "//div[@class='claim row']";
    }

    public WebElement lblClaimAmt() {
        return waitForElementPresent(By.xpath("(//div[contains(text(),'Amount')]/../following-sibling::div//div[3])[1]"));
    }

    public WebElement lnkSettlementLetterDownload() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'A payment has been made')]/ancestor::div[@class='row']//*[contains(text(),'Download')]"));
    }

    public WebElement btnClaimEvidence() {
        return waitForElementPresent(By.xpath("//div[@class='claim row']"));
    }

    public WebElement lnkUploadEvidence() {
        return waitForElementPresent(By.xpath("//div[@class='row evidence provide-evidence']"));
    }

    public String lnkProvidedEvidence(String evidenceName) {
        return "//*[contains(text(),'" + evidenceName + "')]";
    }

    public WebElement txtStatusInDigital() {
        return waitForElementPresent(By.xpath("//div[@class='status']//p"));

    }

    public String lblEvidenceScreen() {
        return "//h3[contains(text(),'Select the evidence you want to upload now')]";
    }

    public String lblClosedClaimScreen() {
        return "//h1[contains(text(),'Closed Claim Details')]";
    }


    public String lblClaimScreen(String claims) {
        return "//h1[contains(text(),'" + claims + "')]";
    }

    public WebElement txtClaimItem(String claimItem) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + claimItem + "')]"));
    }

    public WebElement btnClaimItem() {
        return waitForElementPresent(By.xpath("//div[@class='claim-item']//i[@class='fa fa-caret-right']"));
    }

    public WebElement txtSelectedPeril() {
        return waitForElementPresent(By.xpath("//div[@class='claim-item']//div"));
    }

    public WebElement lnkClaimDetails() {
        return waitForElementPresent(By.xpath("//div[@class='claim row']"));
    }

    public WebElement btnclickNext() {
        return waitForElementPresent(By.xpath("//button[@class='primary-button']"));
    }

    public WebElement txtAmountPartialPayment() {
        return waitForElementPresent(By.xpath("//div[@class='data row']//div[1]"));
    }

    public WebElement lblYoungestCountryOfLoss() {
        return waitForElementPresent(By.xpath("(//h3[contains(text(),'Country of loss')]/../p)[1]"));
    }


    public String lblPersondata() {
        return "//div[@class='data row']/div[1]";
    }

    public String lblSettledata() {
        return "//div[@class='data row']/div[5]";
    }

    public String lblExcessdata() {
        return "//div[@class='data row']/div[4]";
    }

    public String lblClaimedItemsdata() {
        return "//div[@class='data row']/div[2]";
    }

    public String lblClaimeddata() {
        return "//div[@class='data row']/div[3]";
    }


    public String lblThankyouMsg(String option) {
        return "//h1[contains(text(),'" + option + "')]";
    }

    public String lblPerson() {
        return "//div[@class='headers row']/div[1]";
    }

    public String lblSettle() {
        return "//div[@class='headers row']/div[5]";
    }

    public String lblExcess() {
        return "//div[@class='headers row']/div[4]";
    }

    public String lblClaimedItems() {
        return "//div[@class='headers row']/div[2]";
    }

    public String lblClaimed() {
        return "//div[@class='headers row']/div[3]";
    }

    public String lblClaimLetter(String letter) {
        return "(//*[contains(text(),'" + letter + "')])[1]";
    }

    public WebElement txtPerson() {
        return waitForElementPresent(By.xpath("//div[@class='data row']//div[1]"));
    }

    public WebElement emergencyMedicalYesOrNo(String parameter) {
        return waitForElementPresent(By.xpath("//div[@class='next-button']/button[contains(text(),'" + parameter + "')]"));
    }

    public WebElement emergencyMedicalQuestionsMakeClaimPage(String questions) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + questions + "')]"));
    }


    public WebElement emergencyMedical(String parameter) {
        return waitForElementPresent(By.xpath("//div[@class='next-button']/button[contains(text(),'" + parameter + "')]"));
    }

    public WebElement claimDetail1() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='typeID']"));
    }

    public WebElement claimDetail2() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='subTypeID']"));
    }

    public WebElement chBxMainAccountHolder() {
        return waitForElementPresent(By.xpath("//label[contains(text(),'Who does this apply to?')]/../div/div/label[contains(text(),'Main Account Holder')]"));
    }

    public WebElement claimAmountSplit(String person, String amount) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + person + "')]/following-sibling::div[1][contains(text(),'" + amount + "')]"));
    }

    public WebElement btnProceed() {

        return waitForElementPresent(By.xpath("//button[contains(text(),'Proceed')]"));
    }

    public WebElement btnAddClaimItem() {
        return waitForElementPresent(By.id("btn_claims_details_add_items"));
    }

    public WebElement optDelete(String parameter) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + parameter + "')]/../following-sibling::div[4]/a/i[@class='fa fa-trash']"));
    }

    public WebElement optEdit(String parameter) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + parameter + "')]/../following-sibling::div[4]/a/i[@class='fa fa-edit']"));
    }

    public WebElement evidence(String evidence){
        return waitForElementPresent(By.xpath("//h3[contains(text(),'"+evidence+"')]"));
    }

    public WebElement openClaimDetails(){
        return waitForElementPresent(By.xpath("//i[@class='fa fa-caret-right']"));
    }

    public String btnViewClaimsXpath() {
        return "//*[contains(text(),'View Claims')]";
    }
    public WebElement emergencyYES()
    {
        return waitForElementPresent(By.id("btn_claims_emergency_yes"));
    }
    public WebElement emergencyNO()
    {
        return waitForElementPresent(By.id("btn_claims_emergency_no"));
    }
    public WebElement drpdnClaimItems() {

        try {//return waitForElementPresent(By.xpath("//select[@formcontrolname='typeID']"));
            return waitForElementPresent(By.id("ddl_claims_details_type"));
        }
        catch(Exception e)
        {
            return waitForElementPresent(By.xpath("//div[@class='claim-item']"));
        }
    }
    public WebElement drpdnInpatient()
    {
        return waitForElementPresent(By.xpath("//label[contains(text(),'inpatient')]/../select"));
    }

    public WebElement btnCancel() {
        return waitForElementPresent(By.id("btn_people_cancel"));
    }

    public String addPersonbuttonText() {
        try {
            return "//div[@class='primary-button']";
        }
        catch(Exception e)
        {
            return "//h2[contains(text(),'Add another person')]";
        }
    }
    public WebElement claimPaymentButton(){
        return waitForElementPresent(By.xpath("//*[contains(text(),'A payment has been made')]/../.."));
    }
}
