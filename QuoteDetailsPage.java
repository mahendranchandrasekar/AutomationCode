package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class QuoteDetailsPage extends AbstractPage {
    public WebElement quoteLabelValue() {
        return waitForElementPresent(By.id("ucDetailValueHeader_lblIdentityInformation"));
    }

    public WebElement selectingQuoteDetails() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl01_imgOpen"));
    }

    public WebElement latestRenewalQuoteText() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Latest Renewal Quote')]"));
    }

    public WebElement coverAndPremium(String cover) {
        return waitForElementPresent(By.xpath("(//table[@class='MasterTable_Default'])[5]//td[contains(text(),'" + cover + "')]/..//td[4]"));
    }

    public WebElement coverDetailQuestions() {
        return waitForElementVisible(By.id("healixQuoteScreeningData"));
    }

    public WebElement medicalCondition() {
        return waitForElementPresent(By.xpath("//tr[@id='rptScreening_ctl01_gridRow']/td[2]"));
    }

    public WebElement medicalConditionLink() {
        return waitForElementPresent(By.xpath("//tr[@id='rptScreening_ctl01_gridRow']/td"));
    }

    public WebElement diagnosisofCOPD() {
        return waitForElementPresent(By.xpath("//td[contains(text(), 'COPD')]/following-sibling::td"));
    }

    public WebElement age_WhenAsthmaDiagnosed() {
        return waitForElementPresent(By.xpath("//td[contains(text(), 'asthma was diagnosed?')]/following-sibling::td"));
    }

    public WebElement numberOfMedicines() {
        return waitForElementPresent(By.xpath("//td[contains(text(), 'medicines are prescribed for your asthma')]/following-sibling::td"));
    }

    public WebElement nebulisers() {
        return waitForElementPresent(By.xpath("//td[contains(text(), 'nebulisers')]/following-sibling::td"));
    }

    public WebElement hospitalAdmissions() {
        return waitForElementPresent(By.xpath("//td[contains(text(), 'hospital admissions')]/following-sibling::td"));
    }

    public WebElement prescribedOxygen() {
        return waitForElementPresent(By.xpath("//td[contains(text(), 'prescribed oxygen')]/following-sibling::td"));
    }

    public WebElement everBeenASmoker() {
        return waitForElementPresent(By.xpath("//td[contains(text(), 'been a smoker?')]/following-sibling::td"));
    }

    public WebElement closebtn_Questions() {
        return waitForElementPresent(By.xpath("//*[@id=\"fancybox-close\"]"));
    }

//    public WebElement closeBtn() {
//        return waitForElementPresent(By.xpath("//*[@id='btnClose']"));
//    }

    public WebElement selectCustomer_underNamedPeople() {
        return waitForElementVisible(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ctl07_rptPeople_ctl01_imgOpen"));
    }

    public WebElement screeningDetails() {
        return waitForElementVisible(By.id("healixScreeningData"));
    }

    public WebElement verifyMedicalQues(String ques) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + ques + "')]"));
    }

    public WebElement questionAvailable(String question) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + question + "')]"));
    }

    public WebElement optionNo(String question) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[contains(text(),'" + question + "')]/../../div[2]/toggle/div/div/div[2]"));
    }

    public WebElement optionNoneOr1(String question) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[contains(text(),'" + question + "')]/../../div[2]/toggle/div/div/div[1]"));
    }

    public WebElement option2OrMore(String question) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[contains(text(),'" + question + "')]/../../div[2]/toggle/div/div/div[2]"));
    }

    public WebElement optionNoHazardous(String question) {
        System.out.println("//*[contains(text(),'" + question + "')]/../../../div[2]/toggle/div/div/div[2]");
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[contains(text(),'" + question + "')]/../../../div[2]/toggle/div/div/div[2]"));
    }

    public WebElement optionYes(String question) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[contains(text(),'" + question + "')]/../../div[2]/toggle/div/div/div[1]"));

    }

    public WebElement optionYesHazardous(String question) {
        System.out.println("//*[contains(text(),'" + question + "')]/../../../div[2]/toggle/div/div/div[1]");
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[contains(text(),'" + question + "')]/../../../div[2]/toggle/div/div/div[1]"));

    }


    public WebElement option2OrMore() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//div[contains(text(),'2 or more')]"));

    }

    public WebElement noneOrOne() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//div[contains(text(),'None or 1')]"));

    }

    public WebElement reasonField() {
        return waitForElementPresent(By.xpath("//label[contains(text(),'Details:')]/../input"));
    }

    public WebElement para() {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'Establish reason why the customers believes this to be case.')]"));
    }

    public WebElement currentlyOnTripMessage(String messageToVerify) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + messageToVerify + "')]"));
    }

    public WebElement hoverMessage(String question) {
        return waitForElementPresent(By.xpath(" //h3[contains(text(),'" + question + "')]/../i"));
    }

    public WebElement namedPeople(String question, String people) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + question + "')]/../../../div[2]//label[contains(text(),'" + people + "')]"));
    }

    public WebElement namedPeopleSelecting(String question) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + question + "')]/../../../div[2]//label[contains(text(),'Main Account Holder')]"));
    }

    public WebElement screenDisplayed(String screenName) {
        return waitForElementPresent(By.xpath("//h1[contains(text(),'" + screenName + "')]"));
    }

    public WebElement medicalConditionText() {
        return waitForElementVisible(By.xpath("//input[contains(@id,'ConditionText')]"));
    }

    public String iframeSize(){
        return ("//iframe");
    }

    public WebElement question1(String question, String answer) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + question + "')]/../td[2]/label[text()='" + answer + "']/preceding-sibling::input[1]"));
    }

    public WebElement continueBtn() {
        return waitForElementToBeClickableAndReturnElement(By.id("Continue"));
    }

    public WebElement finishBtn() {
        return waitForElementToBeClickableAndReturnElement(By.id("Finish"));
    }

    public WebElement startHealixScreeningBtn() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//button[contains(text(),'Start Healix Screening')]"));
    }

    public WebElement OtherMedicalScreeningBtn() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//div[contains(text(),'Other')]"));
    }

    public WebElement acceptNoCoverBtn() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//button[contains(text(),'Accept No Cover')]"));
    }

    public WebElement personSelected(String personName) {

        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + personName + "')]/../../.."));
    }

    public String existingPerson(String personName) {

        return "//h3[contains(text(),'" + personName + "')]/preceding-sibling::div[1]/i[contains(@class,'fa-edit')]";
    }


    public WebElement medicalConditionSelectBtn(String medicalCondition) {
        System.out.println("condition button xpath-----------------------------" + "//div[@id='ScrollableContainer']/table/tbody/tr//button[@title='" + medicalCondition + "']");
        return waitForElementToBeClickableAndReturnElement(By.xpath("//div[@id='ScrollableContainer']/table/tbody/tr//button[@title='" + medicalCondition + "']"));
    }

    public WebElement firstRecordInQuoteListArrow() {
        return waitForElementPresent(By.xpath("//img[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl01_imgOpen']")); //for Quote

    }

    public WebElement detailsLink(String person) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + person + "')]/..//a[@id='healixQuoteScreeningData']"));
    }

    public String verifyMedicalCondition() {
        return "//img[contains(@id,'rptScreening')]";
    }

    public WebElement questionsInQuoteList(String question) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[contains(text(),'" + question + "')]/../td[2]"));
    }

    public WebElement saveQuoteBtn() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Save Quote')]"));
    }

    public WebElement IAcceptBtn() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'I Accept')]"));
    }

    public String quoteIdInQuoteList(String quoteId) {
        return "//div[@class='customWrapper']/table/tbody/tr[contains(@id,'gridRow')][last()]/td[contains(text(),'" + quoteId + "')]";
    }

    public WebElement addPersonIcon() {
        return waitForElementPresent(By.xpath("//h2[text()='Add Person' or text()='Add another person']/preceding-sibling::div/i"));
    }

    public WebElement titleOfNewPerson() {
        try {
            return waitForElementPresent(By.xpath("//select[@aria-label='Select title']"));
        } catch (Exception e) {
            return waitForElementPresent(By.xpath("//select[@aria-label='select title mandatory']"));
        }
    }

    public WebElement firstNameOfNewPerson() {
        return waitForElementPresent(By.xpath("//input[contains(@formcontrolname,'first')]"));
    }

    public WebElement lastNameOfNewPerson() {
        return waitForElementPresent(By.xpath("//input[contains(@formcontrolname,'last')]"));
    }

    public WebElement DOBofNewPerson() {
        return waitForElementPresent(By.xpath("//input[contains(@aria-label,'date')]"));
    }

    public WebElement relationshipOfNewPerson() {
        return waitForElementPresent(By.xpath("(//select[@aria-label='Select relationship'])[1]"));
    }

    public WebElement addPersonYes() {
        return waitForElementPresent(By.xpath("//div[@class='yes']"));
    }

    public WebElement ageExtensionForPerson(String personName) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + personName + "')]/../../../following-sibling::div//age-extension"));
    }

    public WebElement noOptionForAgeExtensionForPerson(String personName) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + personName + "')]/../../../following-sibling::div//h2[contains(text(),'Age Extension')]/../../following-sibling::div//div[contains(text(),'No')]"));
    }

    public WebElement itemAgeExtensionForPerson(String personName) {
        return waitForElementPresent(By.xpath("//h2[contains(text(),'" + personName + "')]/../following-sibling::div//div[contains(text(),'Age Extension')]"));
    }

    public WebElement userNameForRemoveAgeExtension() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='username']"));
    }

    public WebElement passwordForRemoveAgeExtension() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='password']"));
    }

    public WebElement saveBtnForRemoveAgeExtension() {
        return waitForElementPresent(By.xpath("//button[text()='Save']"));

    }

    public WebElement buttonYes() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Yes')]"));
    }

    public WebElement buttonNo() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Yes')]"));
    }

    public WebElement buttonIUnderstand() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'I Understand')]"));
    }

    public WebElement buttonListedCondition() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'1 listed condition')]"));
    }

    public String itemMedicalExtensionXpath(String personName) {
        return "//h2[contains(text(),'" + personName + "')]/../following-sibling::div//div[contains(text(),'Medical Extension')]";
    }

    public WebElement ageExtensionRemovalMessage(String message) {
        return waitForElementPresent(By.xpath("//div[@class='result red']/p[contains(text(),'" + message + "')]"));
    }

    public WebElement ageExtensionRemovalErrorMessage(String message) {
        return waitForElementPresent(By.xpath("//div[@class='error']/p[contains(text(),'" + message + "')]"));
    }

    public WebElement totalCost() {
        return waitForElementPresent(By.xpath("//div[@class='row total']/div[2]"));
    }

    public WebElement totalCostExcludingIPT() {
        return waitForElementPresent(By.xpath("//div[contains(@class,'premium')]/div[2]"));
    }

    public WebElement tripFromDate() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='tripFrom']"));
    }

    public WebElement tripToDate() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='tripTo']"));
    }

    public WebElement errorMsgForMoreTripLength(String error) {
        return waitForElementPresent(By.xpath("//p[contains(text(),'" + error + "')]"));
    }

    public String errorMsgForMoreTripLengthXpath(String error) {
        return "//p[contains(text(),'" + error + "')]";
    }

    public WebElement saveDetails() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Save Details')]"));
    }

    public WebElement drpdnTripDestination() {
        return waitForElementPresent(By.xpath("//select[@aria-label='select destination mandatory']"));
    }

    public WebElement winterSports() {
        return waitForElementPresent(By.xpath("//label[@for='chk_people_sports']"));
    }

    public String destinationSelectedByGuestXpath(String guestName, String fieldValue) {
        return "//h3[contains(text(),'" + guestName + "')]/following-sibling::div[@class='trips']/trip-view/div//h3[contains(text(),'" + fieldValue + "')]";
    }

    public WebElement fixedPriceUpgradesAdded(String upgrades) {
        return waitForElementPresent(By.xpath("//h2[contains(text(),'Additional Upgrades')]/../../div[@class='title']/following-sibling::div//div[contains(text(),'" + upgrades + "')]"));
    }

    public WebElement IPTAmount() {
        return waitForElementPresent(By.xpath("//div[@class='row ipt']//div[contains(text(),'IPT')]/following-sibling::div"));
    }

    public WebElement addAdditionalPriceUpgradesYes(String upgrades) {
        if (upgrades.equalsIgnoreCase("Golf cover")) {
            try {
                return waitForElementPresent(By.xpath("//h2[contains(text(),'Golf cover')]/../../following-sibling::div//div//div[contains(@class, 'yes')]"));
            } catch (Exception e) {
                return waitForElementPresent(By.xpath("//h2[contains(text(),'Golf Cover')]/../../following-sibling::div//div//div[contains(@class, 'yes')]"));
            }
        }
        try {
            return waitForElementPresent(By.xpath("//h2[contains(text(),'" + upgrades + "')]/../../following-sibling::div//div[contains(@class, 'yes')]"));
        } catch (Exception e) {
            return waitForElementPresent(By.xpath("//h2[contains(text(),'" + upgrades + "')]/../../following-sibling::div//button[contains(@class, 'yes')]"));
        }
    }

    public WebElement addAdditionalPriceUpgradesOptionSelect(String upgrades, String option) {
        if (upgrades.equalsIgnoreCase("Golf cover")) {
            System.out.println("inside goooooooooollllllllllllfffffffffff");
            try {
                return waitForElementPresent(By.xpath("//h2[contains(text(),'Golf')]/../../following-sibling::div//div//div[contains(text(),'" + option + "')]"));
            } catch (Exception e) {
                return waitForElementPresent(By.xpath("//h2[contains(text(),'Golf')]/../../following-sibling::div//div//div[contains(text(),'" + option + "')]"));
            }
        }
        else {
            System.out.println("Inside else------upgrades.split[0]-------------"+upgrades.split(" ")[0]);
            return waitForElementPresent(By.xpath("//h2[contains(text(),'" + upgrades.split(" ")[0] + "')]/../../following-sibling::div//div//div[contains(text(),'" + option + "')]"));
        }

    }

    public String addAdditionalPriceUpgradesOption(String upgrades) {
        return "//h2[contains(text(),'Additional Upgrades')]/following-sibling::div//h2[contains(text(),'" + upgrades + "')]";
    }

//    public WebElement close() {
//        return waitForElementPresent(By.id("btnClose"));
//    }

    public WebElement screendCondtionErrorMsg(String msg) {
        System.out.println("//p[contains(text(),'" + msg + "')]");
        return waitForElementPresent(By.xpath("//p[contains(text(),'" + msg + "')]"));
    }

    public WebElement validatePremium() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//th[contains(text(),'Premium')]/../following-sibling::tr[2]/td[9]"));
    }

    public WebElement exclusionsValidation(String person) {
        System.out.println("//td[contains(text(),'" + person + "')]/preceding-sibling::td/img/../../following-sibling::tr/td/div/div/table/tbody/tr[2]/td[2]");

        return waitForElementPresent(By.xpath("//td[contains(text(),'" + person + "')]/preceding-sibling::td/img/../../following-sibling::tr/td/div/div/table/tbody/tr[2]/td[2]"));
    }

    public WebElement selectLatestActiveQuote() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Latest Active Quote')]/../following-sibling::tr[1]/td[3]"));
    }

    public WebElement latestActiveQuoteID() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Latest Active Quote')]/../following-sibling::tr[1]/td[3]"));
    }

    public WebElement screeningOutcome(String person) {

        return waitForElementPresent(By.xpath("(//td[contains(text(),'" + person + "')]/following-sibling::td[1])[last()]"));
    }

    public WebElement quoteAndBuyUpgradesInPolicySummaryScreen(String person) {
        return waitForElementPresent(By.xpath("(//table[contains(@id,'grdQuoteItems')]//td[contains(text(),'" + person + "')]/preceding-sibling::td)[2]"));

    }

    public WebElement previewEmail(String event) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + event + "')]/preceding-sibling::td"));
    }

    public WebElement mailContent(String event) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + event + "')]/preceding-sibling::td"));
    }

    public WebElement QVP() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_pnlCustom']/div[3]/table/tbody/tr[1]/th[8]"));
    }

    public WebElement QVPDays() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl01_gridRow']/td[8]"));
    }


    public WebElement btnBuy() {

        return waitForElementPresent(By.xpath("//button[contains(text(),'Buy')]"));
    }

    public WebElement btnCheckCover() {

        return waitForElementPresent(By.xpath("//button[contains(text(),'Check Cover')]"));
    }

    public WebElement chkBxPayByCard() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//h3[contains(text(),'Pay by card')]"));
    }


    public WebElement chkBxPayByDebit() {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'Pay by annual direct debit')]"));
    }

    public WebElement btnThirdParty() {
        return waitForElementPresent(By.xpath("//div[@class='icon small']/i[@class='fa fa-user-plus']"));
    }

    public WebElement permission_toUseCard() {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'Do you have permission to use the card?')]/../following-sibling::div//div//div[contains(text(),'Yes')]"));
    }


    public WebElement chkBxConsent() {
        return waitForElementPresent(By.xpath("//div[3][@class='consent']/div[@class='ic checkbox']/label"));
    }


    public WebElement txtPaymentFields(String fieldName) {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='" + fieldName + "']"));
    }

    public WebElement cardHoldersName() {
        return waitForElementVisible(By.xpath("//input[@formcontrolname='cardHolder']"));
    }


    public WebElement btnYes() {
        return waitForElementVisible(By.xpath("//div[@class='yes']/i[@class='fa fa-check']"));
    }

    public WebElement btnBuyNow() {

        return waitForExpectedElement(By.xpath("//button[contains(text(),'Buy Now')]"), 20);
    }

    public WebElement btnBuyNowDisabled() {

        return waitForExpectedElement(By.xpath("//button[@class='primary-button disabled']"), 20);
    }

    public WebElement soleAuthority() {
        return waitForExpectedElement(By.xpath("//h3[contains(text(),'Do you have sole authority to use this account')]/../following-sibling::div//div[contains(text(),'Yes')]"), 20);
    }


    public WebElement billingAddress() {
        try {
            return waitForExpectedElement(By.id("same_as_billing_yes"), 20);
        } catch (Exception e) {
            return waitForExpectedElement(By.id("same_as_billing_yes"), 20);
        }
    }


    public WebElement btnSave() {
        try {
            return waitForExpectedElement(By.xpath("//*[@class='primary-button'][text()='Save']"), 20);
        } catch (Exception e) {
            return waitForExpectedElement(By.xpath("//button[@class='primary-button']"), 20);
        }
    }

    public WebElement btnCancel() {

        return waitForExpectedElement(By.xpath("//div[@class='cancel-button']"), 20);
    }


    public WebElement btnFail() {

        return waitForExpectedElement(By.xpath("//button[contains(text(),'Fail')]"), 20);
    }

    public WebElement lblcardNumber() {
        return waitForElementPresent(By.xpath("//p[@class='card']"));
    }

    public WebElement btnTryAgain() {
        return waitForExpectedElement(By.xpath("//button[contains(text(),'Try again')]"), 20);
    }

    public boolean errorMessageInSellOnDummyPolicy(String errorMessage) {
        return elementDisplayed(By.xpath("//p[contains(text(),'" + errorMessage + "')]"));
    }

    public WebElement enterCardNumber() {
        return waitForElementPresent(By.id("cardNumber"));
    }


    public WebElement enterExpiryDate() {
        return waitForElementPresent(By.id("expiryMonth"));
    }

    public WebElement entercvvNumber() {
        return waitForElementPresent(By.id("securityCode"));
    }

    public WebElement enterExpiryYear() {
        return waitForElementPresent(By.id("expiryYear"));
    }

    public WebElement enterCardHolderName() {
        return waitForElementPresent(By.id("cardholderName"));
    }

    public WebElement makePaymentBtn() {
        return waitForElementPresent(By.id("submitButton"));
    }

    public WebElement directDebitBtn() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Pay by Direct Debit')]"));
    }

    public WebElement btnYesCPA() {
        return waitForElementPresent(By.id("store_details_yes"));
    }

    public WebElement btnNoCPA() {
        return waitForElementPresent(By.id("store_details_no"));
    }

    public WebElement btnFinish() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Finish')]"));
    }

    public WebElement selectFirstQuote() {
        return waitForElementPresent(By.linkText("select"));
    }

    public WebElement editFirstQuote() {
        return waitForElementPresent(By.xpath("(//a[contains(@id,'lnkMatterView')])[1]"));
    }

    public String worldPayFrame() {
        return "//iframe[@src='worldpay/pay']";
    }

    public String editExistingMedicalCondition() {
        return "//i[@class='fa fa-edit']";
    }

    public WebElement btnRevise(int i) {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl0" + i + "_lnkQuoteExpired"));
    }

    public WebElement btnReviseforMoreValue(int i) {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl" + i + "_lnkQuoteExpired"));
    }

    public String quoteList() {
        return "//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_pnlCustom']/div[3]/table/tbody/tr[@class='GridRow_Default gridRow']";

    }

    public WebElement lblPremium() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl01_gridRow']/td[8]"));
    }

    public WebElement lblipt() {
        return waitForElementPresent(By.xpath("//div[@class='row ipt']/div[2]"));
    }

    public String yesCheckBoxInPAymentToThirdParty() {
        return "//credit-card/section//div[@class='yes disabled']";
    }

    public WebElement editLinkOfBoughtQuote() {
        return waitForElementPresent(By.xpath("(//td[contains(text(),'Card')]/../td[2]/a)[1]"));

    }

    public WebElement tabCardAcctDetails() {
        return waitForElementPresent(By.xpath("//a//span[contains(text(),'Card Account Details')]"));
    }

    public String cpaCheckBox() {
        return "chk302329";
    }

    public WebElement txtStartDate() {
        return waitForElementPresent(By.id("startDate"));
    }

    public WebElement clickOnDetails() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Covered with cost')]/../div/a[contains(text(),'Details')]"));
    }

    public WebElement clickonFracture() {
        return waitForElementPresent(By.id("rptScreening_ctl01_imgOpen"));
    }

    public WebElement clickonOsteoporosis() {
        return waitForElementPresent(By.id("rptScreening_ctl02_imgOpen"));
    }

    public WebElement lblmonth() {
        return waitForElementPresent(By.xpath("//div[@class='pika-label'][1]"));
    }

    public WebElement dateTable() {
        return waitForElementPresent(By.xpath("//div[@class='pika-lendar']/table/tbody"));
    }

    public WebElement drpdnFMonth() {
        return waitForElementPresent(By.xpath("//select[@class='pika-select pika-select-month']"));
    }

    public WebElement drpdnFMonth2() {
        return waitForElementPresent(By.xpath("(//select[@class='pika-select pika-select-month'])[2]"));
    }

    public WebElement dateTableForTripFrom() {
        return waitForElementPresent(By.xpath("(//div[@class='pika-lendar']/table/tbody)[1]"));
    }

    public WebElement dateTableForTripTo() {
        return waitForElementPresent(By.xpath("(//div[@class='pika-lendar']/table/tbody)[2]"));
    }

    public WebElement lblmonthFrom() {
        return waitForElementPresent(By.xpath("//div[@class='pika-label'][1]"));
    }

    public WebElement lblmonthTo() {
        return waitForElementPresent(By.xpath("//div[@class='pika-label'][2]"));
    }


    public WebElement lblNext() {
        return waitForElementPresent(By.xpath("//div[@class='next-button']"));
    }

    public WebElement btnRemove() {
        return waitForElementPresent(By.cssSelector(".cancel-button"));
    }

    public WebElement btnPremiumApply() {
        return waitForElementPresent(By.cssSelector(".primary-button"));
    }

    public WebElement drpdnReason() {
        return waitForElementPresent(By.xpath("//div[@class='ic']/select[@class='ng-untouched ng-pristine ng-invalid']"));
    }

    public WebElement drpdnPremiumBy() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='isPercent']"));
    }

    public WebElement tabPricingAndBilling() {
        return waitForElementPresent(By.xpath("//a/span/span[contains(text(),'Pricing and Billing')]"));
    }

    public WebElement txtOverridePercentag() {

        return waitForElementPresent(By.id("txt302163"));
    }

    public WebElement txtOverrideProportion() {
        return waitForElementPresent(By.xpath("Dummy object for calculated override Proportion"));
    }

    public WebElement lblOverrideReason() {
        return waitForElementPresent(By.id("ddl302189"));
    }

    public WebElement btnSaveAndClose() {
        return waitForElementPresent(By.id("btnSaveAndClose"));
    }


    public WebElement paymentOption(String paymentOption) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + paymentOption + "')]"));
    }

    public WebElement paymentDetailsSortcode() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//label[contains(text(),'Sort code')]/.."));
    }

    public WebElement paymentDetailsAccountNo() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//label[contains(text(),'Account no')]/.."));
    }

    public WebElement paymentDetailsPayee() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//label[contains(text(),'Payee')]/.."));
    }

    public WebElement paymentDetailsBankname() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//label[contains(text(),'Bank name')]/.."));
    }

    public WebElement cancellationReasons(String reason) {
        return waitForElementPresent(By.xpath("//div[contains(text(),'" + reason + "')]"));
    }

    public WebElement useDifferentAccountLink() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//h3[contains(text(),'Use a different account')]"));
    }

    public WebElement payeeFirstName() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//input[@formcontrolname='firstName']"));
    }

    public WebElement payeeLastName() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//input[@formcontrolname='lastName']"));
    }

    public WebElement payeeSortCode() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//input[@formcontrolname='sortCode']"));
    }

    public WebElement payeeAccountNumber() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//input[@formcontrolname='accountNo']"));
    }

    public WebElement payeeBankName() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//input[@formcontrolname='bankName']"));
    }

    public WebElement payeeConsent() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//div[@class='consent']/div[@class='ic checkbox']/label"));
    }

    public WebElement validateDetailsbtn() {
        return waitForElementPresent(By.xpath("//button[text()='Validate Details']"));
    }

    public WebElement paymentDetailsAcceptBtn() {
        return waitForElementPresent(By.xpath("//div[@class='toggle-button center-bottom']/div[@class='yes']//i"));
    }

    public WebElement customerNameForQuoteThatBought() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Medical Cover')])[1]/../following-sibling::td[1]"));
    }


    public WebElement upgradeSelected() {
        return waitForElementPresent(By.xpath("(//*[contains(text(),'Medical Cover')])[1]"));
    }

    public WebElement destinationDropdown() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='destination']"));
    }

    public WebElement tripStartDate() {
        return waitForElementPresent(By.xpath("dummy"));
    }

    public WebElement tripEndDate() {
        return waitForElementPresent(By.xpath("dummy"));
    }

    public WebElement errorMessage() {
        return waitForElementPresent(By.xpath("dummy"));
    }

    public WebElement addFixedPriceUpgradesNo(String upgrades) {  //dummy
        return waitForElementPresent(By.xpath("//h2[contains(text(),'" + upgrades + "')]/../../following-sibling::div//div//div[contains(@class,'no')]"));
    }


    public WebElement option_CustomerPortal(String option, String question) {
        System.out.println("//*[contains(text(),'" + question + " ')]/following-sibling::div/div[contains(text(),'" + option + "')]");
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[contains(text(),'" + question + "')]/following-sibling::div/div[contains(text(),'" + option + "')]"));

    }

    public WebElement addFixedPriceUpgradesYes(String upgrades) {
        return waitForElementPresent(By.xpath("//h2[contains(text(),'" + upgrades + "')]/../../following-sibling::div//div//div[contains(@class,'yes')]"));
    }

    public WebElement drpdnCancellationAmt() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='cancellationAmount']"));
    }

    public WebElement starDateInQuoteAndBuy() {
        return waitForElementPresent(By.id("startDate"));
    }

    public WebElement selectCurrentdateInStartDate() {
        return waitForElementPresent(By.xpath("//td[contains(@class,'is-today is-selected')]"));
    }

    public WebElement coverStartDate(String cover) {
        return waitForElementPresent(By.xpath("//a[contains(text(),'" + cover + "')]/../following-sibling::td[2]"));
    }

    public WebElement coverMTADate(String cover) {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Medical Cover')]/../following-sibling::td[3]"));
    }

    public WebElement retrievecurrentDateMonth() {
        return waitForElementPresent(By.xpath("//td[contains(@class,'is-today is-selected')]/button"));
    }

    public WebElement nextMonth() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Next Month')]"));
    }

    public WebElement dateToSelect(String date) {
        return waitForElementPresent(By.xpath("//td[@data-day='" + date + "']"));
    }

    public String txtPaymentUsername() {
        return "//input[@formcontrolname='username']";
    }

    public WebElement editTripDetails() {
        return waitForElementPresent(By.xpath("//i[@class='fa fa-plane']"));
    }

    public WebElement validateResponses(String question) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + question + "')]/../following-sibling::td/input[1]"));
    }

    public WebElement validateNoQuote() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'QUOTE LIST')]/following-sibling::div/div/table/tbody/tr/td"));
    }

    public WebElement showDocument() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Show Document')][1]"));
    }

    public WebElement basePolicyLink() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Base Policy')]/../following-sibling::tr[1]/td[1]/a/img"));
    }


    public String noQuote() {
        return "//div[contains(text(),'QUOTE LIST')]/following-sibling::div/div/table/tbody/tr/td";
    }

    public String renewalQuote() {
        return "//div[contains(@id,'pnlRenewal')]";
    }

    public WebElement selectAmendmentTab(String upgrade){
        return waitForElementPresent(By.xpath("//h2[contains(text(),'" + upgrade + "')]/../../../preceding-sibling::existing-tabs[1]//div[contains(text(),'Amendment')]"));
    }

    public WebElement editTripDetails(String upgrade) {
        return waitForElementPresent(By.xpath("//h2[contains(text(),'" + upgrade + "')]/../../following-sibling::div[3]//i[@class='fa fa-plane']"));
    }

    public WebElement permiumForcover(String cover) {
        try {
            return waitForElementPresent(By.xpath("//*[contains(text(),'" + cover + "')]/../../../div/price/div/span"));
        }catch (Exception ex){
            return waitForElementPresent(By.xpath("//*[contains(text(),'" + cover + "')]/../../div/price/div/span"));
        }
    }

    public WebElement dropdowntripLength() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='days']"));
    }

    public WebElement lblLatestQuoteEffectiveDate() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl01_gridRow']/td[5]"));
    }

    public WebElement btnTryCancel() {
        return waitForExpectedElement(By.xpath("//button[contains(text(),'Cancel')]"), 20);
    }

    public WebElement btnSaveInCustomerPortal() {
        try {
            return waitForElementPresent(By.id("btn_people_save"));
        }
        catch(Exception e)
                {
                    return waitForElementPresent(By.xpath("//button[contains(text(),'Save')]"));
                }
    }

    public WebElement btnNextInCustomerPortal() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Next')]"));
    }

    public WebElement dobDate() {
        return waitForElementPresent(By.xpath("//*[@formcontrolname='dobDaySelect']"));
    }

    public WebElement dobMonth() {
        return waitForElementPresent(By.xpath("//*[@formcontrolname='dobMonthSelect']"));
    }

    public WebElement dobYear() {
        return waitForElementPresent(By.xpath("//*[@formcontrolname='dobYearSelect']"));
    }

    public WebElement editBtnInRenewal() {
        return waitForElementPresent(By.xpath("//div[contains(@id,'pnlRenewal')]/..//a[contains(text(),'Edit')]"));
    }

    public WebElement editBtnMedicalCondition() {
        return waitForElementPresent(By.xpath("//i[@class='fa fa-edit']"));
    }


    public WebElement accountHolderName() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='accountHolder']"));
    }

    public WebElement validateBankDetails() {
        return waitForElementPresent(By.xpath("//div[@class='title amount bottom']/h2"));
    }

    public WebElement fixedUpgradesSaved(String fixedUpgrades) {
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_rptQuotes_ctl01_grdQuoteItems']//td[contains(text(),'" + fixedUpgrades + "')]"));
    }

    public String editBtnInRenewalXpath() {
        return "//div[contains(@id,'pnlRenewal')]/..//a[contains(text(),'Edit')]";
    }

    public WebElement qvpValueForRenewalRenewal() {
        return waitForElementPresent(By.xpath("//div[contains(@id,'pnlRenewal')]/../following-sibling::td[6]"));
    }

    public WebElement captureExpiryDateOfLatestRenewalQuote() {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Latest Renewal Quote')]/../following-sibling::tr[1]/td[5]"));
    }

    public WebElement validatePremiumInQuoteList(String cover) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + cover + "')]/following-sibling::td[5]"));
    }

    public WebElement validatePremiumInBasketScreen_ExcludingIPT() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Premium (ex IPT)')]/following-sibling::div"));
    }

    public WebElement validatePremiumInBasketScreen_IncludingIPT() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'(inc IPT)')]/../following-sibling::div"));
    }

    public WebElement iptValueInBasketScreen() {
        return waitForElementPresent(By.xpath("//div[text()='IPT']/following-sibling::div"));
    }

    public WebElement drpdnPremiumMedian() {
        return waitForElementPresent(By.xpath("//select[@formcontrolname='direction']"));
    }

    public WebElement errorMessageforpremium(String error) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//*[contains(text(),'" + error + "')]"));
    }

    public WebElement OtherHealixScreeningBtn() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//div[contains(text(),'Other')]"));
    }

    public WebElement checkCoverBtn() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//button[contains(text(),'Check Cover')]"));
    }

    public WebElement retrieveLatestRenewalQuote_EffectiveDate() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//th[contains(text(),'Latest Renewal Quote')]/../following-sibling::tr[1]/td[5]"));
    }

    public WebElement retrieveLatestRenewalQuote_ExpiryDate() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//th[contains(text(),'Latest Renewal Quote')]/../following-sibling::tr[1]/td[7]"));
    }

    public WebElement validateAquarium() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Back to AQ')]"));
    }

    public WebElement prospectLastNameOfNewPerson() {
        return waitForElementPresent(By.xpath("(//input[@aria-label='Enter your last name'])[2]"));
    }

    public WebElement prospectFirstNameOfNewPerson() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("(//input[@aria-label='Enter your first name'])[2]"));
    }

    public WebElement prospectTitleOfNewPerson() {
        return waitForElementPresent(By.xpath("(//select[@aria-label='Select title'])[2]"));
    }

    public WebElement leadDetailsTab() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnLeadDetails"));
    }

    public WebElement namedPeopleTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Named People')]"));
    }

    public WebElement renewalTab() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Renewal')]"));
    }

    public WebElement screeningDataTab() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//span[contains(text(),'Screening Data')]"));
    }

    public WebElement retrieveTableRowidForInsuredPersons(String insuredPerson) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//td[contains(text(),'" + insuredPerson + "')]/preceding-sibling::td[3]"));
    }

    public WebElement validateMedicalConditionforInsuredPerson(String tableRowID, String medicalCondition) {
        System.out.println("//td[contains(text(),'" + tableRowID + "')]/following-sibling::td[contains(text(),'" + medicalCondition + "')]");
        return waitForElementPresent(org.openqa.selenium.By.xpath("//td[contains(text(),'" + tableRowID + "')]/following-sibling::td[contains(text(),'" + medicalCondition + "')]"));
    }

    public WebElement validateQuestionAndResponses(String question, String response) {
        System.out.println("//td[contains(text(),'" + question + "')]/following-sibling::td[contains(text(),'" + response + "')]");
        return waitForElementPresent(org.openqa.selenium.By.xpath("//td[contains(text(),'" + question + "')]/following-sibling::td[contains(text(),'" + response + "')]"));
    }

    public WebElement validateQuoteDetails() {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//th[contains(text(),'Latest Renewal Quote')]/../following-sibling::tr//td[3]//img"));
    }

    public WebElement validateMedicalCondition(String person, String condition) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//td[contains(text(),'" + person + "')]/following-sibling::td/span[contains(text(),'" + condition + "')]"));
    }

    public WebElement validateMedicalPremium(String person, String condition) {
        return waitForElementPresent(By.xpath("//td[contains(text(),'" + person + "')]/following-sibling::td[8]"));
    }

    public WebElement retrieveUpgradeDetails(String field, String upgrade) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//th[contains(text(),'" + field + "')]/../following-sibling::tr/td/a[contains(text(),'" + upgrade + "')]/../following-sibling::td[3]"));
    }

    public WebElement retrieveUpgradeCoverToDate(String upgrade) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//th[contains(text(),'Cover To')]/../following-sibling::tr/td/a[contains(text(),'" + upgrade + "')]/../following-sibling::td[3]"));
    }

    public WebElement purchasesTab() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnPurchasedProducts"));
    }


    public WebElement btnback() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnGoBack"));
    }


    public WebElement upgradesAccountInformation(String upgrade) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//td[contains(text(),'" + upgrade + "')]/following-sibling::td/input[contains(@id,'btnShowAccountInformation')]"));
    }

    public WebElement accountType() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_lblAccountType"));
    }

    public WebElement accountCancelbtn() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnCancelAccountScreen"));
    }

    public WebElement purchasesBackbtn() {
        return waitForElementPresent(org.openqa.selenium.By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnGoBack"));
    }

    public WebElement btnBackToAQ() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Back to AQ')]"));
    }

    public WebElement editPerson() {
        return waitForElementPresent(By.xpath("//i[@class='fa fa-edit']"));
    }

    public WebElement AddGuest() {
        return waitForElementPresent(By.xpath("//label[@for='isGuest']"));
    }


    public WebElement prospectTitle() {
        return waitForElementPresent(By.xpath("(//select[@formcontrolname='title'])[1]"));
    }


    public WebElement additionalConditionForPerson(String person) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//h3[contains(text(),'" + person + "')]/../following-sibling::div//i"));
    }

    public WebElement selectLastMatterList() {
        return waitForElementPresent(By.xpath("(//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_rgMatterHeaders_ctl01']/tbody/tr)[last()]/td/a"));
    }

    public WebElement editBankDetails() {
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_rgMatterHeaders_ctl01']/tbody/tr[1]/td[2]/a"));
    }

    public WebElement cardAccountDetailsTab() {
        return waitForElementPresent(By.xpath("//span[text()='Card Account Details']"));
    }

    public WebElement bankAccountDetailsTab() {
        return waitForElementPresent(By.xpath("//span[text()='Bank Account Details']"));
    }

    public WebElement cpaChkBox() {
        return waitForElementPresent(By.xpath("//span[text()='CPA']/../following-sibling::td/input[1]"));
    }

    public WebElement isthePackagedBankAccountChkBox() {
        return waitForElementPresent(By.xpath("//span[text()='Is the Packaged Bank Account']/../following-sibling::td/input[1]"));
    }

    public WebElement usePaperlessDDChkBox() {
        return waitForElementPresent(By.xpath("//span[text()='Use Paperless DD']/../following-sibling::td/input[1]"));
    }

    public WebElement bACSFailureHistoryAmount() {
        return waitForElementPresent(By.xpath("//table[@id='Rad302655_ctl01']/tbody/tr/td[8]"));
    }

    public WebElement excludingMessage() {
        return waitForElementPresent(By.xpath("//div[@class='row info-message fullwidth']//h3[contains(text(),'All pre-existing conditions and directly related conditions will be excluded for')]"));
    }

    public WebElement btnRestrictionToAddGuest() {
        return waitForElementPresent(By.xpath("//div[@class='yes disabled']"));
    }

    public String lblForInActivePolicyNotToPurchase() {
        return "//h2[contains(text(),'There was a problem loading this customer')]";
    }

    public WebElement tripDateOfSelectedGuest(String fieldValue) {
        return waitForElementPresent(By.xpath("//p[contains(text(),'" + fieldValue + "')]"));
    }

    public WebElement txtSelectedGuest(String guestName) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + guestName + "')]"));
    }

    public WebElement lblPartialQuoteDetails() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_ctl01_lblPartial"));
    }

    public String lblPartialQuote()

    {
        return "//span[contains(text(),'Partial Quote from DLG Portal Users')]";
    }


    public String lblMedicalCondition(String condition) {
        return "//span[contains(text(),'" + condition + "')]";
    }

    public String selectedUpgrades(String upgrades) {
        return "//h2[contains(text(),'" + upgrades + "')]/../../following-sibling::div//div//div[@class='yes selected']";
    }


    public WebElement lnkToAQ() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Back to AQ')]"));
    }

    public WebElement btnNext() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Next')]"));
    }

    public WebElement dateToSelectForNextDay(int date) {
        return waitForElementPresent(By.xpath("//td[@data-day='" + date + "']"));
    }

    public WebElement coverFromDate(String upgrade) {
        return waitForElementPresent(By.xpath("//a[text()='" + upgrade + "']/../following-sibling::td[2]"));
    }

    public WebElement coverToDate(String upgrade) {
        return waitForElementPresent(By.xpath("//a[text()='" + upgrade + "']/../following-sibling::td[4]"));

    }


    public WebElement coverUpgraded(String coverName) {
        return waitForElementPresent(By.partialLinkText(coverName));
    }

    public WebElement txtAmount() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='amount']"));
    }

    public String notification() {
        return "//*[contains(text(),'A customer bar has been applied to this policy. You will be unable to purchase upgrades until this block is removed.')]";
    }

    public WebElement btnDismiss() {
        return waitForElementPresent(By.xpath("//*[contains(@class,'cancel-button')]"));
    }

    public WebElement peopleTab() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'People')]"));
    }

    public WebElement basicTab() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Basic')]"));
    }

    public WebElement txtTripType(String ExtensionType) {
        return waitForElementPresent(By.xpath("//h2[contains(text(),'Trip Extension')]/..//h5[contains(text(),'" + ExtensionType + "')]"));
    }

    public String txtTripTypeSingle(String ExtensionType) {
        return "//h2[contains(text(),'Trip Extension')]/..//h5[contains(text(),'" + ExtensionType + "')]";
    }

    public WebElement selectCancellationReasondrpdown() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Cancellation Reason')]/../following-sibling::td[1]/div/div/img"));
    }

    public WebElement donotRenewQuote() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Renew')]"));
    }


    public WebElement destinationForGuest() {
        try {
            return waitForElementPresent(By.xpath("//select[@aria-label='select destination mandatory']"));
        } catch (Exception e) {
            return waitForElementPresent(By.xpath("//*[contains(text(),'Destination ')]/../select[@aria-label='Select destination']"));
        }
    }

    public WebElement addAnotherTripBtn() {
        try {
            return waitForElementPresent(By.xpath("//button[contains(text(),'Add another trip')]"));
        } catch (Exception e) {
            return waitForElementPresent(By.xpath("//div[contains(text(),'Add another trip')]"));
        }
    }

    public WebElement btnIUnderstand() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'I Understand')]"));
    }


    public WebElement btnBasketScreen() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Basket')]"));
    }


    public WebElement drpdnToMonth() {
        return waitForElementPresent(By.xpath("(//div[@class='pika-title']//select[@class='pika-select pika-select-month'])[last()]"));
    }

    public WebElement btnAddInCustomerPortal() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Add')]"));
    }

    public WebElement txtDescriptionClaimItem() {
        return waitForElementPresent(By.xpath("//textarea[@formcontrolname='description']"));
    }


    public WebElement btnAddPersonInCustomerPortal() {
        return waitForElementPresent(By.xpath("//div/h2[contains(text(),'Add person')]"));
    }


    public WebElement viewSaveQuoteCover(String cover) {
        return waitForElementPresent(By.xpath("//th[contains(text(),'Latest Active Quote')]/../following-sibling::tr[1]//td[4][contains(text(),'" + cover + "')]"));
    }

    public WebElement dateTableForTripToDateXpath(String dateToSelect) {
        return waitForElementVisible(By.xpath("(//button[contains(text(),'" + dateToSelect + "')]/../../../..)[2]//button[contains(text(),'" + dateToSelect + "')]"));
    }

    public WebElement dateTableForTripFromDateXpath(String dateToSelect) {
        return waitForElementVisible(By.xpath("(//button[contains(text(),'" + dateToSelect + "')]/../../../..)[1]//button[contains(text(),'" + dateToSelect + "')]"));

    }

    public WebElement btnCancelInCustomerPortal() {
        return waitForElementPresent(By.xpath("//button[@class='primary-button red']"));
    }

    public WebElement dateTableForTripFromDateXpathGuest(String datreToSelect, String year) {
        return waitForElementPresent(org.openqa.selenium.By.xpath("//button[text()='" + datreToSelect + "' and @data-pika-year='" + year + "']"));

    }

    public WebElement dateTableForTripToDateXpathGuest(String dateToSelect) {
        return waitForElementVisible(By.xpath("(//button[text()='" + dateToSelect + "'])[last()]"));
    }

    public WebElement dateTableForTripFromMonthXpathGuest() {
        return waitForElementPresent(By.xpath("(//select[@class='pika-select pika-select-month'])[2]"));
    }

    public WebElement nextMonthButtonForToDate() {
        return waitForElementPresent(By.xpath("(//button[text()='Next Month'])[last()]"));
    }

    public WebElement editCardPaymentRow() {
        return waitForElementVisible(org.openqa.selenium.By.xpath("//td[contains(text(),'Card')]/preceding-sibling::td//a"));
    }

    public WebElement removeAdditionalInsuredPerson() {
        return waitForElementPresent(By.xpath("//div[@class='remove delete']"));
    }

    public WebElement confirmToRemoveAdditionalInsuredPerson() {
        return waitForElementPresent(By.xpath("//button[@class='primary-button']"));
    }
    public WebElement drpdnFromMonth() {
        return waitForElementPresent(By.xpath("//div[@class='pika-single is-bound']//select[@class='pika-select pika-select-month']"));
    }

    public WebElement drpdnFromYear() {
        return waitForElementPresent(By.xpath("//div[@class='pika-single is-bound']//select[@class='pika-select pika-select-year']"));
    }
    public WebElement nextButton() {
        try{
            return waitForElementPresent(By.xpath("//div[@class='next-button']/button"));
        }
        catch(Exception e)
        {
            return waitForElementPresent(By.id("btn_basket_save_quote"));
        }
    }

    public List<WebElement> QuoteAndBuyInsuredPeopleQuestion() {
        return findElements(By.xpath("//h3[contains(text(),'In addition to the people listed above, you should tell us about everyone else')]"));
    }

    public WebElement enterEmail(){
        return waitForElementPresent(By.id("Email"));
    }

    public WebElement enterPassword(){
        return waitForElementPresent(By.id("Password"));
    }

    public WebElement clickSignIn(){
        return waitForElementPresent(By.xpath("//input[@value='Sign in']"));
    }
}

