package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

public class CustomerPortalQuotePage extends AbstractPage {

    public WebElement getAQuoteLink() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Upgrade')]/../../a"));
    }


    public WebElement nextbtn_GetAQuote() {
        return waitForElementToBeClickableAndReturnElement(org.openqa.selenium.By.xpath("//*[contains(@class, 'fa-arrow-right')]"));
    }

    public WebElement insuredPersonAdvice_No() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[1]/div[1]/toggle/div/div/div[2]"));
    }

    public WebElement insuredPersonAdvice_Yes() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[1]/div[1]/toggle/div/div/div[1]"));
    }

    public WebElement insuredPersonEverHad_HeartOrCancerRelatedCondition_Yes() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[2]/div[1]/toggle/div/div/div[1]"));
    }

    public WebElement insuredPersonEverHad_HeartOrCancerRelatedCondition_No() {
        return waitForElementPresent(By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[2]/div[1]/toggle/div/div/div[2]"));
    }

    public WebElement whoDoesThisApplyToPerson1() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//label[@for='heartCancer0']"));
    }

    public WebElement whoDoesThisApplyToPerson2() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//label[@for='heartCancer1']"));
    }

    public WebElement whoDoesThisApplyToPerson3() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//label[@for='heartCancer2']"));
    }

    public WebElement isInsuredPersonAwaitingForInvestigation_Yes() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[3]/div[1]/toggle/div/div/div[1]"));
    }

    public WebElement isInsuredPersonAwaitingForInvestigation_No() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[3]/div[1]/toggle/div/div/div[2]"));
    }

    public WebElement isAnyinsuredPersonOnAWaitingListForTreatment_Yes() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[4]/div[1]/toggle/div/div/div[1]"));
    }

    public WebElement isAnyinsuredPersonOnAWaitingListForTreatment_No() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[4]/div[1]/toggle/div/div/div[2]"));
    }

    public WebElement isInsuredPersonReceivedATerminalPrognosis_Yes() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[5]/div[1]/toggle/div/div/div[1]"));
    }

    public WebElement isInsuredPersonReceivedATerminalPrognosis_No() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("/html/body/app/div/screening-page/medical-page/div/div/history-details/div/div[2]/div[5]/div[1]/toggle/div/div/div[2]"));
    }

    public WebElement nextbtn_MedicalConditions() {
        return waitForElementToBeClickableAndReturnElement(org.openqa.selenium.By.xpath("//*[contains(@class, 'fa-arrow-right')]"));
    }

    public WebElement enterMedicalCondition() {
        return waitForElementPresent(By.xpath("//input[@id='ContentPlaceHolder1_ConditionText']"));
    }

    public WebElement toSelectMedicalconditionAsAsthma() {
        return waitForElementPresent(By.id("101_BTN"));
    }

    public WebElement toSelectMedicalcondition(String disease) {
        return waitForElementPresent(By.xpath("//input[@id='" + disease + "']"));
    }

    public WebElement everHadADiagnosisMadeofCOPD_No() {
        return waitForElementPresent(By.id("Answer_2"));
    }

    public WebElement everHadADiagnosisMadeofCOPD_Yes() {
        return waitForElementPresent(By.id("Answer_1"));
    }

    public WebElement howOldAreYouWhenAsthmaDiagnosed_50orOver() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[@id=\"Answer_1\"]"));
    }

    public WebElement howOldAreYouWhenAsthmaDiagnosed_Under50() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[@id=\"Answer_2\"]"));
    }

    public WebElement howManyMedicnesArePrescribedForYourBrathingCondition_oneortwoMedicines() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[@id=\"Answer_2\"]"));
    }

    public WebElement howManyHospitalAdmissions_HaveyouHadYouBreathingConditions_None() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[@id=\"Answer_1\"]"));
    }

    public WebElement howShortOfBreath_ICanWalkEasily() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[@id=\"Answer_1\"]"));
    }

    public WebElement haveYouEverBeenPrescribedOxygen_No() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[@id=\"Answer_4\"]"));
    }

    public WebElement haveYouEverBeenASmoker_No() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[@id='Answer_1'']"));
    }

    public WebElement haveYouhadAChestInfection_No() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[@id=\"Answer_2\"]"));
    }

    public WebElement medicalScreeningContinuebtn() {
        return waitForElementPresent(org.openqa.selenium.By.id("Continue"));
    }

    public WebElement lblWelcomeMsg() {
        return waitForElementPresent(By.xpath("//h1[contains(text(),'Welcome,')]"));
    }

    public WebElement lblNewUpgradeQuote() {
        return waitForElementPresent(By.xpath("//h1[contains(text(),'New Upgrade Quote')]"));
    }

    public WebElement lblInsuredPeopleTitle() {
        return waitForElementPresent(By.xpath("//h1[contains(text(),'Insured People')]"));
    }

    public WebElement lblInsuredPeopleName() {
        return waitForElementPresent(By.xpath("//h3"));
    }

    public WebElement lblMainAcctHolder() {
        return waitForElementPresent(By.xpath("//p[contains(text(),'Main Account Holder')]"));
    }

    public WebElement btnUnderstand() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'I Understand')]"));
    }

    public WebElement Question() {
        return waitForElementPresent(By.xpath("//div[@class='question row']//h3"));
    }

    public WebElement btnPeopleAnswer(String answer) {
        return waitForElementPresent(By.xpath("//div[@class='question row']/div[2]/toggle/div/div/div[contains(text(),'" + answer + "')]"));
    }

    public WebElement btnNext() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Next')]"));
    }

    public WebElement btnConfirm() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Confirm')]"));
    }

    public String buttonConfirm() {
        return "//div[contains(text(),'Confirm')]";
    }

    public String buttonNext() {
        return "//button[contains(text(),'Next')]";
    }

    public WebElement lblAdditionalUpgrades(String upgrades) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + upgrades + "')]"));
    }

    public WebElement lblCustNotifyInScreeningPage() {
        return waitForElementPresent(By.xpath("//*[@id='bottom']/div/div/p[1]"));
    }

    public WebElement notificationInScreening(String msg) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + msg + "')]"));
    }
    public WebElement lblMedicalCondExcluded(String notifiMsg) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + notifiMsg + "')]"));
    }
    public WebElement titleInsuredPerson() {
        return waitForElementPresent(By.xpath("(//div[@class='title'])[1]"));
    }

    public WebElement titleUKTrips() {
        return waitForElementPresent(By.xpath("(//div[@class='title'])[4]"));
    }

    public WebElement msgInsurePerson() {
        return waitForElementPresent(By.xpath("(//div[@class='title'])[1]/../following-sibling::td/div[2]"));
    }

    public WebElement msgUKtrips() {
        return waitForElementPresent(By.xpath("(//div[@class='title'])[4]/../following-sibling::td/div[2]"));
    }

    public WebElement iconInsurePerson() {
        return waitForElementPresent(By.xpath("(//div[@class='title'])[1]/../following-sibling::td/div[1]"));
    }

    public WebElement iconUKtrips() {
        return waitForElementPresent(By.xpath("(//div[@class='title'])[4]/../following-sibling::td/div[1]"));
    }

    public WebElement iconPartner() {
        return waitForElementVisible(By.xpath("(//div[@class='quick-links add-person row']//div[@class='icon'])[1]"));
    }

    public WebElement partner() {
        return waitForElementVisible(By.xpath("//h3[contains(text(),'Partner')]"));
    }

    public WebElement iconDepChild() {
        return waitForElementVisible(By.xpath("//i[@class='fa fa-child']"));
    }

    public WebElement iconGuest() {
        return waitForElementPresent(By.xpath("(//h3[contains(text(),'Guest')]/../..//div)[1]"));
    }

    public WebElement isMandatory(String field) {
        return waitForElementPresent(By.xpath("//label[contains(text(),'" + field + "')]/span[@class='required']"));
    }

    public WebElement drpdnTitle() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='title']"));
    }

    public WebElement errMsgTitle() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='title']/following-sibling::div[2]"));
    }

    public WebElement randomClick() {
        return waitForElementPresent(By.xpath("//div[@class='info-message side']"));
    }

    public WebElement txtFirstName() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='firstName']"));
    }

    public WebElement txtLastName() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='lastName']"));
    }

    public WebElement txtDOB() {
        return waitForElementPresent(By.id("dob"));
    }

    public WebElement errMsgFname() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='firstName']/following-sibling::div[2]"));
    }

    public WebElement errMsgLname() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='lastName']/following-sibling::div[2]"));
    }

    public WebElement iconCalendar() {
        return waitForElementPresent(By.xpath("//div[@class='pika-single is-bound']"));
    }

    public WebElement errMsgDOB() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='dob']/following-sibling::div[2]"));
    }

    public WebElement btnCancel() {
        return waitForElementPresent(By.xpath("//button[@class='primary-button red']"));
    }

    public WebElement btnSave() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Save')]"));
    }
    public WebElement drpdnRelationship() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='type']"));
    }

    public WebElement tabPeople() {
        try{
            return waitForElementPresent(By.xpath("//span[contains(text(),'People')]"));
        }
        catch (Exception e){
            return waitForElementPresent(By.xpath("//a[contains(text(),'People')]"));
        }
    }

    public WebElement drpdnDestination() {
        return waitForElementVisible(By.xpath("//select[@formcontrolname='destination']"));
    }

    public WebElement errMsgRelationship() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='type']/following-sibling::div[2]"));
    }

    public WebElement errMsgDestination() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='destination']/following-sibling::div[2]"));
    }

    public WebElement msgDependentChild() {
        return waitForElementPresent(By.xpath("//div[@class='info-message side']//p"));
    }

    public WebElement txtTripFromDate() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='tripFrom']"));
    }

    public WebElement txtTripToDate() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='tripTo']"));

    }


    public WebElement chkBxWinterSports() {
        return waitForElementPresent(By.xpath("//label[@for='winterSports']"));
    }

    public WebElement winterSports() {
        return waitForElementPresent(By.id("winterSports"));
    }

    public WebElement infoBtnFromDate() {
        return waitForElementPresent(By.xpath("(//i[@class='fa fa-question-circle'])[1]"));
    }

    public WebElement infoBtnToDate() {
        return waitForElementPresent(By.xpath("(//i[@class='fa fa-question-circle'])[2]"));
    }

    public WebElement titleFromDate() {
        return waitForElementPresent(By.xpath("//i[@title='Departure date.']/..[contains(text(),'Trip dates - From')]"));
    }

    public WebElement titleToDate() {
        return waitForElementPresent(By.xpath("(//label/text())[9]"));
    }

    public WebElement mandatorySDate() {
        return waitForElementPresent(By.xpath("(//label/i/following-sibling::span[@class='required'])[1]"));
    }

    public WebElement mandatoryEDate() {
        return waitForElementPresent(By.xpath("(//label/i/following-sibling::span[@class='required'])[2]"));
    }

    public WebElement errMsgFromDate() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='tripFrom']/following-sibling::div[2]"));
    }

    public WebElement errMsgToDate() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='tripTo']/following-sibling::div[2]"));
    }

    public WebElement addPerson(String person) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + person + "')]"));
    }
    public String addPersonbutton() {
        return "//h2[contains(text(),'Add another person')]";
    }

    public WebElement addPersonbuttonText() {
    try {
            return waitForElementVisible(By.xpath("//div[@class='primary-button']"));
        }
        catch(Exception e)
        {
            return waitForElementPresent(By.xpath("//h2[contains(text(),'Add another person')]"));
        }
    }


    public WebElement acceptNoCover() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Accept No Cover')]"));
    }

    public WebElement selectCover(String cover) {
        return waitForElementPresent(By.xpath("//button[contains(text(),'" + cover + "')]"));
    }

    public WebElement validateExcludedConditionsMsg(String msg, String person) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + person + "')]/ancestor::person/following-sibling::div//p[contains(text(),'" + msg + "')]"));
    }

    public WebElement BuyOptionValidation() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Buy')]"));
    }

    public WebElement validateErrorMessage(String errorMessage) {
        return waitForElementPresent(By.xpath("//p[contains(text(),'" + errorMessage + "')]"));
    }

    public WebElement messageValidation() {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'Details')]/../p"));
    }


    public String addMedicalCondition(String person) {
        return "//i[@class='fa fa-edit']/../../h3[contains(text(),'" + person + "')]";
    }

    public WebElement editMedicalCondition(String person) {
        return waitForElementPresent(By.xpath("//i[@class='fa fa-edit']/../../h3[contains(text(),'" + person + "')]"));
    }

    public WebElement removePerson(String person) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + person + "')]/ancestor::div[1]//following-sibling::div//div[@class='no']"));
    }

    public WebElement removePersonErrorMessage(String msg) {
        return waitForElementPresent(By.xpath("//p[contains(text(),'" + msg + "')]"));
    }

    public WebElement addAnOtherTrip() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Add anOther trip')]"));
    }

    public WebElement selectMedicalCondition(String condition) {
        return waitForElementPresent(By.xpath("//label[contains(text(),'" + condition + "')]"));
    }

    public WebElement selectUpgrade(String upgrade) {
        try {
            return waitForElementPresent(By.xpath("//*[contains(text(),'" + upgrade + "')]/../../following-sibling::div//div//button[contains(@class,'yes')]"));
        } catch (Exception e) {
            return waitForElementPresent(By.xpath("//*[contains(text(),'" + upgrade + "')]/../../following-sibling::div//div//div[contains(@class,'yes')]"));
        }
    }

    public WebElement addUpgradesOptionSelect(String upgrades, String option) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + upgrades + "')]/../../following-sibling::div//div//button[contains(@class,'" + option + "')]"));


    }
    public WebElement validatePerson(String person) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + person + "')]"));
    }

    public WebElement validateExtension(String tripExtension) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + tripExtension + "')]"));
    }

    public WebElement validateCountry(String country) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + country + "')]"));
    }

    public WebElement validateStartDate(String startDate) {
        return waitForElementPresent(By.xpath("//p[contains(text(),'" + startDate + "')]"));
    }
    public WebElement drpdnTripLength() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='days']"));
    }

    public WebElement drpdnTripLengthLastVal() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='days']/option[last()]"));
    }

    public WebElement validateAmountToPay(String cover) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + cover + "')]/../../div[@class='price']//div[@class='amount-to-pay']/span"));
    }

    public WebElement validateRenewalDay(String cover) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + cover + "')]//following::span[1]"));
    }

    public WebElement validateAnnualPremium(String cover) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + cover + "')]/../..//div[@class='premium']/span"));
    }

    public WebElement validateAnnualPrice(String cover) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + cover + "')]/../..//div[@class='price']/span"));

    }

    public WebElement paymentOption(String country) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + country + "')]"));
    }
    public WebElement accountDetails(int i) {
        return waitForElementPresent(By.xpath("//bank-details[@class]/div/div[" + i + "]"));
    }

    public WebElement txtAccountHolder() {

        return waitForElementPresent(By.xpath("//input[@formcontrolname='accountHolder']"));
    }

    public WebElement txtCardHolder() {

        return waitForElementPresent(By.xpath("//input[@formcontrolname='cardHolder']"));
    }

    public WebElement txtsortCode() {

        return waitForElementPresent(By.xpath("//input[@formcontrolname='sortCode']"));
    }

    public WebElement txtAccountNo() {

        return waitForElementPresent(By.xpath("//input[@formcontrolname='accountNo']"));
    }

    public WebElement txtBankName() {

        return waitForElementPresent(By.xpath("//input[@formcontrolname='bankName']"));
    }

    public WebElement btnSaveInPayment() {

        return waitForElementPresent(By.xpath("//span[contains(text(),'Save')]"));
    }

    public WebElement txtAddress1() {

        return waitForElementPresent(By.xpath("//input[@formcontrolname='address1']"));
    }

    public WebElement txtAddress2() {

        return waitForElementPresent(By.xpath("//input[@formcontrolname='address2']"));
    }

    public WebElement txtTownCity() {

        return waitForElementPresent(By.xpath("//input[@formcontrolname='townCity']"));
    }

    public WebElement txtCounty() {

        return waitForElementPresent(By.xpath("//input[@formcontrolname='county']"));
    }

    public WebElement txtPostcode() {

        return waitForElementPresent(By.xpath("//input[@formcontrolname='postcode']"));
    }

    public WebElement txtTelephone() {

        return waitForElementPresent(By.xpath("//input[@formcontrolname='telephone']"));
    }

    public WebElement txtEmail() {

        return waitForElementPresent(By.xpath("//input[@formcontrolname='email']"));
    }
    public WebElement btnBuyNow() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Buy Now')]"));
    }

    public String msgValidAccount() {
        return "//h3[contains(text(),'Successfully validated bank details')]";
    }

    public String BuyNow() {
        return "//button[contains(text(),'Buy Now')]";
    }
    public WebElement lblTotalCost() {
        return waitForExpectedElement(By.xpath("//div[@class='row total']//div[2]"), 10);
    }


    public WebElement paymentFrame() {
        return waitForElementPresent(By.xpath("//iframe[contains(@id,'wp-cl-custom-html')]"));
    }

    public WebElement btnFinishPayment() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Finish')]"));
    }

    public WebElement lblPaymentConfirmation() {
        return waitForElementPresent(By.xpath("//h1"));
    }

    public WebElement lblPaymentConfirmationText() {
        return waitForElementPresent(By.xpath("//h1[contains(text(),'Thank you')]"));
    }


    public WebElement validateAgeExtension(String addedPerson, String notification) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + addedPerson + "')]/../../../..//h3[contains(text(),'" + notification + "')]"));

    }

    public WebElement selectedUpgrade(String upgrade) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + upgrade + "')]/../../following-sibling::div[1]/toggle/div/div/button[@class='no not-selected']"));
    }

    public String checkSelectedUpgrade(String upgrade) {
        return "//h3[contains(text(),'" + upgrade + "')]/../../following-sibling::div[1]/toggle/div/div/button[@class='no']";
    }

    public WebElement clickBasketScreen() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Upgrades')]"));
    }

    public WebElement btnCardPermission(String permission) {
        try {
            return waitForElementPresent(By.xpath("//div[contains(text(),'" + permission + "')]"));
        } catch (Exception e) {
            return waitForElementPresent(By.xpath("//button[contains(text(),'" + permission + "')]"));
        }

    }

    public WebElement clickWhatCovered() {
        return waitForElementPresent(By.xpath("//i[@class='fa fa-caret-down']"));
    }


    public WebElement displayEverything1() {
        return waitForElementPresent(By.xpath("(//div[@class='sub-panel more-info']//div[2]//p)[1]"));
    }

    public WebElement displayEverything2() {
        return waitForElementPresent(By.xpath("(//div[@class='sub-panel more-info']//div[2]//p)[2]"));
    }

    public String errMsgCancellationExtension() {
        return "//div[@class='result red']/p";
    }

    public WebElement editBtnTripDetails(String cover) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + cover + "')]/../../../../div[2]//i[@class='fa fa-edit']"));
    }

    public WebElement btnBuyDisabled() {
        return waitForElementPresent(By.xpath("//button[@class='primary-button disabled'][contains(text(),'Buy')]"));
    }

    public WebElement btnBuy() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Buy')]"));
    }

    public WebElement lblTotalTripDays(String cover) {
        return waitForElementPresent(By.xpath("(//h3[contains(text(),'" + cover + "')]/../../../../div[2]//p)[1]"));
    }

    public String lblUpgrades(String cover) {
        return "//h3[contains(text(),'" + cover + "')]";
    }

    public WebElement btnAction(String parameter) {
        return waitForElementPresent(By.xpath("//button[contains(text(),'" + parameter + "')]"));
    }

    public WebElement btnCardPermission1() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Yes')]"));
    }
    public WebElement btnPayByCard() {
        return waitForElementPresent(By.xpath("//h2[contains(text(),'Pay by card')]"));
    }
    public WebElement defaultCardInMyName(){
        return waitForElementPresent(By.xpath("//div[@class='tabs row']/div[@class='col-xs-6 selected']//h3[contains(text(),'Card in My Name')]"));
    }

    public WebElement btnPayBySomeoneCard() {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'Card in someone elses name')]"));
    }

    public WebElement btnPayByOwnCard() {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'Card in My Name')]"));
    }

    public WebElement lblBillingAddress() {
        return waitForElementPresent(By.xpath("//div[@class='orig-address']//div"));
    }

    public WebElement txtAddressLine1() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucCustomerInfo1_tbAddress1"));
    }
    public WebElement selectCard(String card) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + card + "')]"));
    }

    public WebElement txtAddressWorldPay() {
        return waitForElementPresent(By.id("billingAddressLine1Ro"));
    }

    public WebElement txtPostcodeWorldPay() {
        return waitForElementPresent(By.id("billingAddressPostcodeRo"));
    }


    public WebElement validatePremium(String cover) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + cover + "')]/../../div[@class='price']//span"));
    }


    public WebElement fixedPriceUpgradesAdded(String upgrades) {
        return waitForElementPresent(By.xpath("//h2[contains(text(),'Basket')]/../../div[@class='title']/following-sibling::div//div[contains(text(),'" + upgrades + "')]"));
    }

    public WebElement fixedPriceUpgradesAddedCost(String upgrades) {
        return waitForElementPresent(By.xpath("//h2[contains(text(),'Basket')]/../../div[@class='title']/following-sibling::div//div[contains(text(),'" + upgrades + "')]/following-sibling::price/div[@class='price']"));
    }


    public WebElement btnPayByDebit() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Pay by Direct Debit')]"));
    }

    public WebElement btnAnnaulPayByDebit() {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'Pay by annual direct debit')]"));
    }

    public WebElement errMsgPaymentFailure() {
        return waitForElementPresent(By.xpath("//div[@class='container']/div[@class='result']/following-sibling::p"));
    }

    public WebElement errorMessage(String msg){
        return waitForElementPresent(By.xpath("//div[contains(text(),'"+msg+"')]"));
    }

    public WebElement btnPaymentCancel() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Cancel')]"));
    }

    public WebElement lblLatestQuoteEffectiveDate1() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl01_gridRow']/td[5]"));
    }

    public String QuestionDisplayed() {
      //  return "//h3[@prospecttext]";
        return "//h3[text()='Do you want to add a Joint Account holder?']";
    }

    public String insurePeopleYesButton() {
        //  return "//h3[@prospecttext]";
        return "add_joint_account_yes";
    }

    public WebElement insureJointYesButton() {
    return waitForElementPresent(org.openqa.selenium.By.id("add_joint_account_yes")); }


    public WebElement lblTripDates() {
        return waitForElementPresent(By.xpath("//div[@class='left']//p"));
    }

    public WebElement lblAgeExtension(String message) {
        return waitForElementPresent(By.xpath("//p[contains(text(),'" + message + "')]"));
    }

    public WebElement lblForGuestExtension(String addedPerson, String upgrade) {
        return waitForElementPresent(By.xpath("//h2[contains(text(),'" + addedPerson + "')]/../../div[2]//div[contains(text(),'" + upgrade + "')]"));
    }

    public WebElement lblGuestExtension(String message1) {
        return waitForElementPresent(By.xpath("//p[contains(text(),'" + message1 + "')]"));
    }

    public WebElement lblMedicalExtensionIncluded(String addedPerson) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + addedPerson + "')]/../p[2]"));
    }

    public WebElement validateAddedPerson(String addedPerson) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + addedPerson + "')]"));
    }
    public WebElement lblMedicalExtensionExcluded(String addedPerson) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + addedPerson + "')]/../div[2]//p"));
    }

    public WebElement lblMedicalExtensionNotification(String message) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + message + "')]"));
    }

    public WebElement btnScreening() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Screening')]"));
    }

    public WebElement btnUnderstandForExcluding(String button) {
        return waitForElementPresent(By.xpath("//button[contains(text(),'" + button + "')]"));
    }

    public WebElement lblForInsuredPerson(String person) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + person + "')]"));
    }

    public WebElement lblForPersonMedCond(String person, String condition) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + person + "')]/../div[2]//span[contains(text(),'" + condition + "')]"));
    }

    public WebElement insuredPerson(String person) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + person + "')]"));
    }
    public String lblUpgradeMedicalExt(String cover, String person) {

        return "//h3[contains(text(),'" + cover + "')]/ancestor::div[@class='fixed-upgrades row']/preceding-sibling::person//*[contains(text(),'" + person + "')]";
    }

    public WebElement upgradeSelected(String cover) {
        return waitForElementPresent(By.xpath("//div[@class='content']//h3[contains(text(),'" + cover + "')]"));
    }

    public WebElement upgradeOption(String cover) {
        return waitForElementPresent(By.xpath("//div[@class='content']//h3[contains(text(),'" + cover + "')]/../../..//*[contains(text(),'Remove')]"));

    }

    public WebElement medicalExtOption(String person, String cover) {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'" + person + "')]/../../..//following::div[@class='fixed-upgrades row']//h3[contains(text(),'" + cover + "')]/../../..//following::button[contains(text(),'Remove')])[1]"));
    }

    public WebElement medicalPremium(String person, String cover) {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'" + person + "')]/../../..//following::div[@class='fixed-upgrades row']//h3[contains(text(),'" + cover + "')]//following::div[@class='price']/span)[1]"));
    }

    public WebElement txtPeriod(String person) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + person + "')]/../../../following::div[@class='content']//p[contains(text(),'Upgrade period:')]//span"));
    }

    public WebElement txtBasketSummary(String selectedCover) {
        try{
            return waitForElementPresent(By.xpath("//div[@class='section']//div[contains(text(),'" + selectedCover + "')]"));
        }catch(Exception e){
            return waitForElementPresent(By.xpath("//div[@class='section']//div[@class='content']/h3[contains(text(),'" + selectedCover + "')]"));
        }

    }

    public WebElement txtBasketSummaryWithPrice(String selectedCover) {
        return waitForElementPresent(By.xpath("//div[@class='section']//div[contains(text(),'" + selectedCover + "')]/..//span"));
    }

    public WebElement btnHomePage() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Home')]"));
    }

    public WebElement lblAdditionalUpgradeDetails(String upgrade) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + upgrade + "')]/../../following::button[@class='yes not-selected']"));
    }


    public WebElement btnEdit() {
        return waitForElementPresent(By.xpath("//div[@class='text-button right-align']//following::div[@class='yes']"));
    }

    public WebElement addedConditions(String person) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + person + "')]/../../../following::div[@class='fixed-upgrades row']//p[1]"));
    }

    public WebElement navigateSubWizardUpgrades() {
        return waitForElementPresent(By.xpath("//*[@class='sub-nav wizard']//li//a[text()='Upgrades']"));
    }

    public WebElement SavedQuoteMsg(String msg) {
        return waitForElementPresent(By.xpath("//h1[contains(text(),'" + msg + "')]"));
    }

    public String lblSummary() {
        return "//section[@class='summary padding']";
    }

    public String btnContinueForProspect() {
        return "//button[@class='primary-button'][contains(text(),'Continue')]";
    }

    public String btnBuyNowForProspect() {
        return "//button[@class='primary-button'][contains(text(),'Buy')]";
    }

    public WebElement btnDoNotRenew() {
        return waitForElementPresent(By.xpath("//button[@class='cancel-button'][contains(text(), 'Renew')]"));
    }

    public String txtThankYou() {
        return "//h1[contains(text(),'Thank you')]";
    }


    public String selectedUpgrades(String upgrades) {
        return "//h3[contains(text(),'" + upgrades + "')]/../../following-sibling::div//div//button[contains(text(),'Remove')]";

    }
    public WebElement btnUnderstandSave() {
        return waitForElementPresent(By.xpath("//*[@class='primary-button'][contains(text(),'I Understand')]"));

    }

    public WebElement lblYearsExtension(String message2) {
        return waitForElementPresent(By.xpath("//p[contains(text(),'" + message2 + "')]"));
    }

    public WebElement btnSaveThirdPartyDetails() {
        try {
            return waitForElementPresent(By.xpath("//div[@class='yes']"));
        } catch (Exception e) {
            return waitForElementPresent(By.xpath("//i[@class='fa fa-check']"));
        }
    }

    public WebElement linkDownloadFile(String DocName) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + DocName + "')]/../..//following-sibling::span[contains(text(),'Download')]"));
    }


    public WebElement txtDownloadFileName(String DocName) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + DocName + "')]"));
    }

    public String proceedBtn() {
        return "//button[contains(text(),'Proceed')]";
    }

    public WebElement btnClaimLink(String claimNo){
         return waitForElementPresent(By.xpath("//*[contains(text(),'"+claimNo+"')]/../../..//div[@class='icon']"));

    }

    public WebElement linkDownloadFileFromClaimPage(String DocName){
        return waitForElementPresent(By.xpath("//div[@class='documents-container']//*[contains(text(),'"+DocName+"')]/../..//following-sibling::span[contains(text(),'Download')]"));
    }


    public WebElement verifyThankYou(){
        return waitForElementPresent(By.xpath("//h1[contains(text(),'Thank you, your quote has been saved')]"));
    }

    public WebElement btnCloseWindow() {
        return waitForElementVisible(By.name("btnClose"));
    }

    public WebElement chkboxCPA() {
        return waitForElementVisible(By.xpath("//span[contains(text(),'CPA')]/../following-sibling::td//input[@type='checkbox']"));
    }
    public  WebElement weddingIconValidate(){


        return waitForElementPresent(By.xpath("//div[@class='row']//i[@class='fa fa-wedding']"));
    }
    public  WebElement tripIconValidate(){


        return waitForElementPresent(By.xpath("//div[@class='row']//i[@class='fa fa-plane']"));
    }
    public  WebElement businessIconValidate(){


        return waitForElementPresent(By.xpath("//div[@class='row']//i[@class='fa fa-briefcase']"));
    }
    public  WebElement cancellationIconValidate(){


        return waitForElementPresent(By.xpath("//div[@class='row']//i[@class='fa fa-times']"));
    }
    public  WebElement hazordousIconValidate(){


        return waitForElementPresent(By.xpath("//div[@class='row']//i[@class='fa fa-exclamation-triangle']"));
    }

    public WebElement clickOnUpgradesTab() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Upgrades')]"));
    }

}

