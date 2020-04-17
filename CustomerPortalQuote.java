package co.uk.directlinegroup.tt.step_definitions;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.CustomerPortalQuotePage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.pages.QuoteDetailsPage;
import co.uk.directlinegroup.tt.pages.SearchPage;
import co.uk.directlinegroup.tt.utils.*;
import co.uk.directlinegroup.tt.utils.common.CustomerPortalCreateQuote;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;

import java.util.List;
import java.util.Properties;

public class CustomerPortalQuote extends BaseStepDef {

    private CustomerPortalCreateQuote customerPortalCreateQuoteObj = new CustomerPortalCreateQuote();
    private PerformSearch perfSearchObj = new PerformSearch();
    private SearchPage searchPageObj = new SearchPage();
    private QuoteDetailsPage quoteDetailsPageObj = new QuoteDetailsPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private QuoteDetails_Aquarium quoteDetails_aquariumObj = new QuoteDetails_Aquarium();
    private CustomerPortalQuotePage customerPortalQuotePageObj = new CustomerPortalQuotePage();
    private CustomerPortalQuoteOperations customerPortalQuoteOperationsObj = new CustomerPortalQuoteOperations();
    private QuoteAndBuyOperations quoteAndBuyOperationsObj = new QuoteAndBuyOperations();
    private CustomerPortalHomeOperations customerPortalHomeOperationsObj = new CustomerPortalHomeOperations();

    @And("^create a quote with medical condition$")
    public void createQuoteWithMedicalConditions(List<List<String>> parameters) throws Throwable {
        customerPortalCreateQuoteObj.createQuote(parameters);
    }

    @And("^validating the Quotes Details$")
    public void validatingQuoteDetails(List<List<String>> parameters) throws Throwable {
        searchPageObj.viewCustomerLinkInSearchResultTable().isDisplayed();
        perfSearchObj.retreiveFirstClientRecord();
        searchPageObj.switchToWindowByIndex(1);
        quoteDetailsPageObj.selectingQuoteDetails();
        quoteDetailsPageObj.selectingQuoteDetails();
        quoteDetailsPageObj.selectingQuoteDetails().click();
        quoteDetailsPageObj.coverDetailQuestions();
        quoteDetailsPageObj.coverDetailQuestions();
        quoteDetailsPageObj.coverDetailQuestions().click();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        quoteDetails_aquariumObj.verify_QuoteQuestioneris(parameters);
        searchPageObj.switchToDefault();
        quoteDetailsPageObj.closebtn_Questions();
        quoteDetailsPageObj.closebtn_Questions().click();
    }

    @And("^Validate only listed named people are listed$")
    public void validateNamedPeople(List<List<String>> parameters) {
    }

    @And("^validating the named people Quotes Details$")
    public void validatingNamedQuoteDetails(List<List<String>> parameters) throws Throwable {
        searchPageObj.viewCustomerLinkInSearchResultTable().isDisplayed();
        perfSearchObj.retreiveFirstClientRecord();
        searchPageObj.switchToWindowByIndex(1);
        quoteDetailsPageObj.selectCustomer_underNamedPeople();
        quoteDetailsPageObj.selectCustomer_underNamedPeople();
        quoteDetailsPageObj.selectCustomer_underNamedPeople().click();
        quoteDetailsPageObj.screeningDetails();
        quoteDetailsPageObj.screeningDetails();
        quoteDetailsPageObj.screeningDetails().click();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        quoteDetails_aquariumObj.verify_QuoteQuestioneris(parameters);
        searchPageObj.switchToDefault();
        quoteDetailsPageObj.closebtn_Questions();
        quoteDetailsPageObj.closebtn_Questions().click();
    }

    @Then("^I will be presented with Home Page$")
    public void iWillBePresentedWithHomePage() throws Throwable {
        Assert.assertTrue(customerPortalQuotePageObj.lblWelcomeMsg().isDisplayed());
    }

    @When("^I click on '(.+)'$")
    public void iClickOnGetAQuote(String parameter) throws Throwable {

        customerPortalQuoteOperationsObj.navigateToGetAQuote();
    }

    @Then("^system will display all persons covered and ask if want to add more$")
    public void systemWillDisplayAllPersonsCoveredAndAskIfWantToAddMore() throws Throwable {
        Assert.assertTrue(customerPortalQuotePageObj.lblInsuredPeopleTitle().isDisplayed());
        customerPortalQuoteOperationsObj.validateInsuredPersons();
    }

    @When("^I wish not to add any person$")
    public void iWishNotToAddAnyPerson() throws Throwable {

    }

    @And("^system presents the following questions and I answer as follows$")
    public void systemPresentsTheFollowingQuestionsAndIAnswerAsFollows(List<List<String>> questionsList) throws Throwable {

        customerPortalQuoteOperationsObj.validatePeopleQuestions(questionsList);
    }

   /* @When("^I click on '(.+)', system displays '(.+)' screen with following details$")
    public void iClickOnNextSystemDisplaysBasketScreenWithFollowingUpgrades(List<List<String>> parameters) throws Throwable {

        customerPortalQuoteOperationsObj.additionalUpgrades(parameters);


    }*/

    @When("^I navigate to Basket screen, system should displays with following details$")
    public void iNavigateToBasketScreenSystemShouldDisplayWithFollowingDetails(List<List<String>> parameters) throws Throwable {
        if (nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.buttonNext()))) {
            customerPortalQuotePageObj.btnNext().click();
        }
        customerPortalQuoteOperationsObj.additionalUpgrades(parameters);
    }

    @Then("^I should be validate the field title and the display message as below$")
    public void iShouldBeValidateTheFieldTitleAndTheDisplayMessageAsBelow(List<List<String>> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.validateTitleAndMsg(parameters);

    }

    @And("^navigate to Insured People screen$")
    public void navigateToInsuredPeopleScreen() throws Throwable {
        customerPortalQuoteOperationsObj.navigateToPeople();
    }

    @Then("^I wish to add '(.+)'$")
    public void iWishToAddPerson(String person) throws Throwable {
        customerPortalQuoteOperationsObj.wishToAddPerson(person);

    }

    @And("^validate '(.+)' field is mandatory and its selection type is Dropdown with following options$")
    public void validateTitleField(String field, List<String> options) throws Throwable {

        customerPortalQuoteOperationsObj.validateIsMandatory(field);
        if (field.equalsIgnoreCase("Title")) {
            customerPortalQuoteOperationsObj.validateIsDropdown(options);
        } else if (field.equalsIgnoreCase("Relationship")) {
            customerPortalQuoteOperationsObj.validateRelationshipIsDropdown(options);
        } else if (field.equalsIgnoreCase("Destination")) {
            customerPortalQuoteOperationsObj.validateDestinationIsDropdown(options);
        }

    }

    @And("^validate error message of a field when without enter the input$")
    public void validateErrorMessageOfAFieldWithFollowingDetails(List<List<String>> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.validateErrorMessage(parameters);

    }

    @Then("^validate '(.+)' field is mandatory along with following input details$")
    public void validateFirstNameFieldIsMandatoryAlongWithFollowingInputDetails(String field, List<List<String>> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.validateIsMandatory(field);
        customerPortalQuoteOperationsObj.validateWithFieldInput(field, parameters);

    }

    @And("^validate the message displays at Dependent child screen$")
    public void validateTheMessageDisplaysAtDependentChildScreen(List<String> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.verifyChildMsg(parameters);
    }

    @Then("^validate Winter Sports field input type as '(.+)'$")
    public void validateWinterSportsFieldInputTypeAsCheckbox(String inpType) throws Throwable {
        customerPortalQuoteOperationsObj.verifyWinterSports(inpType);
    }

    @And("^I should be able to validate '(.+)' field is mandatory,its title and its information button value as '(.+)'$")
    public void iShouldBeAbleToValidateFieldIsMandatoryTitleAndItsInformationButtonValue(String title, String infoValue) throws Throwable {

        if (title.equalsIgnoreCase("Trip Dates - From")) {
            System.out.println("Given Trip From field is a mandatory field...........");

            Assert.assertTrue(customerPortalQuotePageObj.mandatorySDate().isDisplayed());

        } else if (title.equalsIgnoreCase("Trip Dates - To")) {
            System.out.println("Given Trip To field is a mandatory field...........");
            Assert.assertTrue(customerPortalQuotePageObj.mandatoryEDate().isDisplayed());
        }
        customerPortalQuoteOperationsObj.validateFieldTitle(title);
        customerPortalQuoteOperationsObj.validateInfoButtonText(infoValue);
    }

    @And("^validate the '(.+)' field input type as follows$")
    public void validateTheInputType(String field, List<List<String>> parameters) throws Throwable {
        System.out.println("Inside step definition...");
        customerPortalQuoteOperationsObj.validateTripFromFieldInputType(field, parameters);
    }


    @When("^I navigate to People Screen$")
    public void iNavigateToPeopleScreen() throws Throwable {

        customerPortalQuoteOperationsObj.navigateToPeople();
    }

    @And("^System should notifies as '(.+)' for traveller '(.+)'$")
    public void systemShouldNotifiesTheStatusForOtherTraveller(String msg, String travellers) throws Throwable {
        customerPortalQuoteOperationsObj.notificationOnScreeningPage(msg, travellers);
    }

    @Then("^system displays a pre-defined list of medical conditions and I select one condition as '(.+)'$")
    public void systemDisplaysAPreDefinedListOfMedicalConditionsAndISelectOneCondition(String disease) throws Throwable {
        customerPortalQuoteOperationsObj.selectMedicalCondition(disease);

    }

    @And("^I should be able to select option for the following question and verify Expected behaviour in Customer Portal$")
    public void iShouldBeAbleToSelectOptionForTheFollowingQuestionAndVerifyExpectedBehaviourInCustomerPortal(List<List<String>> questionList) throws Throwable {
        customerPortalQuoteOperationsObj.selectAnswersForTheQuestions(questionList);
    }

    @And("^I should be able to '(.+)' as '(.+)' with the following details$")
    public void iShouldBeAbleToAddPartnerWithTheFollowingDetails(String person, String persontype, List<List<String>> personDetails) throws Throwable {
        customerPortalQuoteOperationsObj.enterCustomerPersondetails(person, persontype, personDetails);
    }

    @When("^System ask for one condition, one medication question and I answer as follows$")
    public void systemAskForOneConditionOneMedicationQuestionAndIAnswerAsFollows(List<List<String>> questionList) throws Throwable {
        quoteAndBuyOperationsObj.selectAnswersForTheQuestions(questionList);
    }

    @And("^I shouldn't accept any cover$")
    public void iShouldnTAcceptAnyCover() throws Throwable {
        customerPortalQuoteOperationsObj.accpetNOCoverInCustomerPortal();
    }

    @And("^System should notifies the customer as '(.+)' for the traveller '(.+)'$")
    public void systemShouldNotifiesTheCustomerAsPreExistingConditionsExcluded(String msg, String person) throws Throwable {
        customerPortalQuoteOperationsObj.validateExcludedConditionMsgInCustomerPortal(msg, person);
    }

    @And("^I should allow to purchase the additional upgrades$")
    public void iShouldAllowToPurchaseTheAdditionalUpgrades(List<List<String>> parameters) throws Throwable {

        customerPortalQuoteOperationsObj.additionalUpgrades(parameters);
    }

    @Then("^I select '(.+)'$")
    public void iSelectAcceptOrCheckCover(String option) throws Throwable {
        customerPortalQuoteOperationsObj.selectCover(option);
    }


    @And("^Enter '(.+)' medical condition as '(.+)' and answer the following question in Customer Portal$")
    public void enterMedicalConditionAndAnswerTheFollowingQuestionInCustomerPortal(String conditionCount, String medicalCondition, List<List<String>> questionList) throws Throwable {
        customerPortalQuoteOperationsObj.enterTheMedicalCondition(conditionCount, medicalCondition, questionList);
    }

    @When("^System ask for medical condition for '(.+)' and I answer as follows$")
    public void systemAskForMedicalConditionAndIAnswerAsFollows(String person, List<List<String>> questionList) throws Throwable {
        if (nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.addMedicalCondition(person)))) {
            customerPortalQuotePageObj.editMedicalCondition(person).click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
        quoteAndBuyOperationsObj.selectAnswersForTheQuestions(questionList);
    }

    @When("^System should ask medical condition for '(.+)' and I answer as follows$")
    public void systemShouldAskMedicalConditionAndIAnswerAsFollows(String person, List<List<String>> questionList) throws Throwable {
        if (nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.addMedicalCondition(person)))) {
            customerPortalQuotePageObj.editMedicalCondition(person).click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
        customerPortalQuoteOperationsObj.selectAnswersForTheQuestions(questionList);
//        quoteAndBuyOperationsObj.selectAnswersForTheQuestions(questionList);
    }

//    @When("^System ask for medical condition and I answer as follows$")
//    public void systemAskForMedicalConditionAndIAnswerAsFollows(List<List<String>> questionList) throws Throwable {
//
//        quoteAndBuyOperationsObj.selectAnswersForTheQuestions(questionList);
//    }


    @Then("^System should notify a '(.+)' with a warning message stating that '(.+)'$")
    public void systemShouldNotifyAChildTestWithAWarningMessageStatingThatClickingConfirmWillRemoveThisPerson(String person, String msg) throws Throwable {
        customerPortalQuoteOperationsObj.removeDependants(person, msg);
    }

    @And("^I should allow to select the condition as '(.+)'$")
    public void iShouldAllowToSelectTheConditionAsAsthma(String condition) throws Throwable {
        customerPortalQuoteOperationsObj.selectSingleCondition(condition);

    }

    @And("^I Navigate to Basket Page$")
    public void iNavigateToScreeningPage() throws Throwable {
        customerPortalQuoteOperationsObj.navigateToBasketScreen();
    }

    @And("^I wish to select the upgrades '(.+)'$")
    public void iWishToSelectTheUpgrades(String covers) throws Throwable {
        customerPortalQuoteOperationsObj.selectUpgrades(covers);
    }

    @And("^I wish to add a person as '(.+)'$")
    public void iWishToAddAPersonAsPartner(String personType, List<List<String>> personDetails) throws Throwable {
        customerPortalQuoteOperationsObj.addPerson(personType, personDetails);
    }

    @And("^Validate the following Guest '(.+)' has been added in the Basket screen$")
    public void validateTheFollowingGuestGuestSaveQuoteHasBeenAddedInTheBasketScreen(String person) throws Throwable {
        customerPortalQuoteOperationsObj.validatePersonExistInBasketScreen(person);
    }

    @And("^I should be able to see the Guest Extension summary and its price$")
    public void iShouldBeAbleToSeeTheGuestExtensionSummaryAndItsPrice(List<List<String>> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.validateTripDetails(parameters);
    }


    @Then("^System should allows to add more than '(.+)' children$")
    public void systemShouldAllowsToAddMoreThanChildren(int arg0) throws Throwable {
        Assert.assertTrue(customerPortalQuotePageObj.addPersonbuttonText().isEnabled());
    }

    @And("^I should be able to see the Guest Extension summary for '(.+)'$")
    public void iShouldBeAbleToSeeTheGuestExtensionSummaryForJohnHendry(String guest, List<List<String>> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.validateTripDetails(parameters);
    }

    @And("^I should logout from Digital$")
    public void iShouldLogoutFromDigital() throws Throwable {
        customerPortalQuoteOperationsObj.signOutFromDigital();
    }

    @And("^validate Trip length field contains following options$")
    public void validateTripLengthFieldContainsFollowingOptions(List<String> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.validateTripLengthDropDownValues(parameters);
    }

    @And("^system should present the following options$")
    public void iShouldAbleToViewTheFollowingOptions(List<String> buttons) throws Throwable {
        customerPortalQuoteOperationsObj.validateButtons();
    }

    @And("^I verify the system calculated Amount to pay for '(.+)'$")
    public void iVerifyTheSystemCalculatedAmountToPayForGolfCover(String cover) throws Throwable {
        customerPortalQuoteOperationsObj.calculate_amount_to_pay(cover);
        customerPortalQuoteOperationsObj.dayDifference(cover);
    }

    @Then("^system should auto populates the below account details for '(.+)'$")
    public void systemShouldAutoPopulatesTheBelowAccountDetailsForPackagedBankAccount(String payment, List<String> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.validateAccountDetailsAreAutoPolpulated(payment);
    }

    @Then("^I should be able to enter the following details to '(.+)'$")
    public void iShouldBeAbleToEnterTheFollowingDetailsToUseADifferentAccount(String paymentOption, List<List<String>> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.enterAccountDetails(paymentOption, parameters);
    }

    @And("^I should allow to complete the payment$")
    public void iShouldAllowToCompleteThePayment() throws Throwable {
        customerPortalQuoteOperationsObj.completePayment();
    }

    @And("^I navigate to Buy screen$")
    public void iShouldAllowToProceedWithPayment() throws Throwable {
        customerPortalQuoteOperationsObj.navigateToBuyScreen();
    }


    @And("^I should be navigated to Worldpay integration to capture the following card details$")
    public void iShouldBeNavigatedToWorldpayIntegrationToCaptureTheFollowingCardDetails(List<List<String>> cardDetails) throws Throwable {
        System.out.println("Waiting for WorldPay screen to get loaded.....");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalQuoteOperationsObj.enterCardDetails(cardDetails);
    }

    @And("^Verify the Payment is Successful$")
    public void iCompletedTheCardPayment() throws Throwable {
        customerPortalQuoteOperationsObj.completeCardPayment();
    }

    @Then("^System should notifies the customer to try with '(.+)' payment method$")
    public void systemShouldNotifiesTheCustomerToTryWithAnotherPaymentMethod(String paymentOption) throws Throwable {

        customerPortalQuoteOperationsObj.selectPaymentOption(paymentOption);
    }

    @When("^I declines DDM payment option$")
    public void iDeclineDDMPaymentOption() throws Throwable {
        customerPortalQuoteOperationsObj.declinesSoleAuthority();
    }

    @Then("^I should be able to Review the following Saved Quote details$")
    public void iShouldBeAbleToReviewTheFollowingSavedQuoteDetails(List<List<String>> parameters) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();

        customerPortalQuoteOperationsObj.reviewSavedQuoteDetails(parameters);

    }

    @And("^I should be able to validate the trip details for '(.+)'$")
    public void iShouldBeAbleToValidateTheTripDetailsForPlatinumAccount(String account, List<String> parameter) throws Throwable {
//        nextEventPageObj.waitForMoreTime();
//        nextEventPageObj.waitForMoreTime();
//        nextEventPageObj.waitForMoreTime();
//        nextEventPageObj.waitForMoreTime();
        customerPortalQuoteOperationsObj.validateTripFromDateNew();
        customerPortalQuoteOperationsObj.validateTripToDateNew(account);

    }


    @And("^validate system shouldn't allow to add trip length more than '(.+)' days$")
    public void validateSystemShouldnotAllowToAddTripLengthMoreThanDays(String limitDays) throws Throwable {
        customerPortalQuoteOperationsObj.validateTripMaximumLength(limitDays);
    }

    @Then("^I should validate the list of activities for '(.+)'$")
    public void iShouldValidateTheListOfActivities(String activities) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        String alreadyCover = activities.split("#")[0];
        String willCover = activities.split("#")[1];
        customerPortalQuoteOperationsObj.landBasedActivies(alreadyCover);
        customerPortalQuoteOperationsObj.validateWhatActivitiesWillCover(willCover);

    }


    @Then("^System should notify the customer to add corresponding trip extension$")
    public void systemShouldNotifyTheCustomerToAddCorrespondingTripExtension() throws Throwable {
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.errMsgCancellationExtension())));
    }

    @And("^The following option should be disabled$")
    public void theFollowingOptionShouldBeDisabled(List<String> parameters) throws Throwable {
        Assert.assertTrue(customerPortalQuotePageObj.btnBuyDisabled().isDisplayed());
    }

    @And("^After adding corresponding trip extension, system should not display any error message$")
    public void afterAddingTripCorrespondingExtensionSystemShouldNotDisplayAnyErrorMessage() throws Throwable {
        Assert.assertTrue(!nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.errMsgCancellationExtension())));
    }

    @And("^Buy option should be enabled$")
    public void buyOptionShouldBeEnabled() throws Throwable {
        Assert.assertTrue(customerPortalQuotePageObj.btnBuy().isEnabled());
    }

    @And("^I should be able to amend the '(.+)' trip details$")
    public void iShouldBeAbleToAmendTheTripDetails(String cover, List<List<String>> tripDetails) throws Throwable {
        Thread.sleep(2000L);
        nextEventPageObj.btnClick(customerPortalQuotePageObj.editBtnTripDetails(cover));
        nextEventPageObj.waitForMoreTime();
        customerPortalQuoteOperationsObj.tripDetails(tripDetails);
    }

    @Then("^validate system shouldn't allows the customer to add more than '(.+)' days for '(.+)'$")
    public void validateSystemShouldnTAllowsTheCustomerToAddMoreThanDays(int days, String cover) throws Throwable {

        customerPortalQuoteOperationsObj.validateMaximumTripDays(days, cover);
    }

    @And("^adding upgrades to Basket '(.+)'$")
    public void addToBasket(String cover) throws Throwable {
        customerPortalQuoteOperationsObj.addUpgradeToBasket(cover);
    }


    @When("^I click on Next, system does not displays Basket screen with following details for '(.+)'$")
    public void iClickOnNextSystemDoesNotDisplaysBasketScreenWithFollowingDetails(String acctType, List<List<String>> parameters) throws Throwable {

        customerPortalQuoteOperationsObj.verifyUpgradesAreNotAvailable(parameters);
    }

    @And("^Validate the trip maximum allowed period '(.+)'$")
    public void validateTheTripMaximumAllowedPeriod(String account) throws Throwable {

        customerPortalQuoteOperationsObj.validateTripFromDate();
        customerPortalQuoteOperationsObj.validateTripToDate(account);
    }

    @And("^Validate system shouldn't allow trip period more than '(.+)' days for '(.+)'$")
    public void validateSystemShouldnTAllowTripPeriodMoreThanDays(int days, String account, List<String> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.validateTripFromDate();
        customerPortalQuoteOperationsObj.validateExceedTripToDate(days);
    }

    @And("^validate the premium for '(.+)' is generated as per the rules engine value '(.+)'$")
    public void iShouldBeAbleToValidateThePremiumIsGeneratedAsPerTheRulesEngineValue(String cover, String premium) {
        customerPortalQuoteOperationsObj.verifyPermiumValueForSelectedUpgrade(cover, premium);

    }

    @Then("^'(.+)' quote$")
    public void iShouldAllowsToSaveQuote(String action) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        Thread.sleep(10000L);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalQuotePageObj.btnAction(action).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Thread.sleep(10000L);
        //TODO for monitoring
        Thread.sleep(10000L);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    @And("^I should add a upgrade '(.+)'$")
    public void iShouldAddAUpgrade(String cover) throws Throwable {
        customerPortalQuoteOperationsObj.checkAndSelectCover(cover);
    }

    @And("^I should validate the Default selected Options$")
    public void iShouldValidateTheDefaultSelectedOptions(List<String> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.validateDefaultOptions(parameters);
    }

    @And("^I should validate every options for following$")
    public void iShouldValidateEveryOptionsForFollowing(List<String> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.validateOptions(parameters);
    }

    @And("^I should verify the billing address$")
    public void iShouldVerifyTheBillingAddress() throws Throwable {

        customerPortalQuoteOperationsObj.verifyBillingAddress();
        customerPortalQuoteOperationsObj.completeCardInMyNamePayment();
    }

    @And("^customer should be able to amend the address details$")
    public void customerShouldBeAbleToAmendTheAddressDetails(List<List<String>> lstInput) {
        customerPortalQuoteOperationsObj.enterAccountDetail(lstInput);

    }

    @And("^I should verify the address of world pay page$")
    public void iShouldVerifyTheAddressOfWorldPayPage() throws Throwable {
        customerPortalQuoteOperationsObj.verifyWorldPayPageAddress();
        customerPortalQuoteOperationsObj.completeCardPayment();
    }

    @And("^I prefer card type as '(.+)'$")
    public void iPreferCardTypeAsPayByAnnualDirectDebit(String cardType) {
        customerPortalQuoteOperationsObj.cardSelection(cardType);

    }


    @And("^validate the selected upgrades are added along with cost '(.+)'$")
    public void verifyTheSelectedUpgradesAreAddedAlongWithCost(String upgradesAndCostAdded) {
        customerPortalQuoteOperationsObj.verifySelectedUpgradesAreAdded(upgradesAndCostAdded);
    }

    @And("^I should be able to select the payment option as '(.+)'$")
    public void iPreferPaymentType(String cardType) {
        customerPortalQuoteOperationsObj.cardSelection(cardType);
    }

    @And("^I should be able to complete the payment$")
    public void iShouldBeAbleToCompleteThePayment() throws Throwable {
        customerPortalQuoteOperationsObj.completeCardInMyNamePayment();
    }


    @Then("^I should proceed with payment$")
    public void iShouldProceedWithPayment() throws Throwable {
        customerPortalQuoteOperationsObj.completeCardInMyNamePayment();
    }

    @And("^Verify the Payment is not successful with error message '(.+)'$")
    public void verifyThePaymentIsNotSuccessfulWithErrorMessage(String errMsg) throws Throwable {
        customerPortalQuoteOperationsObj.validatePaymentErrorMsg(errMsg);
    }

    @And("^Validate the error message while using someone elses card without their permission '(.+)'$")
    public void Validate_the_error_message_while_using_someone_elses_card_without_their_permission(String msg){
        customerPortalQuoteOperationsObj.errorMessageWhileUsingSomeOneElseCard(msg);
    }

    @When("^I click on '(.+)', system doesn't allow any further card payments$")
    public void systemDoesnTAllowAnyFurtherCardPayments(String parameter) throws Throwable {
        if (parameter.equalsIgnoreCase("cancel")) {
//            customerPortalQuotePageObj.btnAnnaulPayByDebit().click();
            customerPortalQuotePageObj.btnPaymentCancel().click();

        }
//        Assert.assertTrue(customerPortalQuotePageObj.payByCardDisabled().isDisplayed());
    }

    @And("^I should validate the System changes the QVP as one day prior to trip start date$")
    public void iShouldValidateTheStartDateOfQuote() throws Throwable {
        customerPortalQuoteOperationsObj.validateQVPEffectiveDate();
    }

    @And("^System should not present option for adding a guest for '(.+)'$")
    public void systemDoesNotProvideOptionForAddingAGuest(String account) {
        customerPortalQuoteOperationsObj.validateOptionOfAddGuest();
    }

    @And("^I navigate to medical screen$")
    public void iNavigateToMedicalScreen() throws Throwable {
        customerPortalQuoteOperationsObj.navigateToMedicalScreen();

    }


    @And("^I should add the following trip details$")
    public void iShouldAddTheFollowingTripDetails(List<List<String>> tripDetails) {

        customerPortalQuoteOperationsObj.tripDetails(tripDetails);
    }

    @Then("^system prompts the customer to add Guest Extension as below$")
    public void systemPromptsTheCustomerToAddExtensionAsBelow(List<List<String>> parameter) throws Throwable {
        customerPortalQuoteOperationsObj.verifyAgeGuestExtension(parameter);
    }


    @Then("^system prompts the customer to add Age Extension as below$")
    public void systemPromptsTheCustomerToAddAgeExtensionAsBelow(List<List<String>> parameter) throws Throwable {
        customerPortalQuoteOperationsObj.verifyAgeGuestExtension(parameter);
    }

    @And("^System should not force age extension for added guest who's aged 70 or over$")
    public void systemShouldNotForceAgeExtensionForAddedGuestWhoSAgedOrOver(List<List<String>> parameter) throws Throwable {
        customerPortalQuoteOperationsObj.reviewSavedQuoteDetails(parameter);
    }

    @And("^I navigate to Screening page$")
    public void iNavigateToScreening() {
        customerPortalQuoteOperationsObj.navigateToScreeningPage();
    }

    @And("^click on '(.+)'$")
    public void iClickOnNext(String parameter) throws Throwable {
        customerPortalQuoteOperationsObj.clickOnNext();
    }

    @And("^I have clicked on '(.+)'$")
    public void iHaveClickedOnIUnderstand(String button) {
        customerPortalQuoteOperationsObj.clickOnUnderstand(button);
    }


    @And("^I should answer the screening questions with the following options")
    public void iShouldAnswerTheScreeningQuestionsWithTheFollowingOptions(List<List<String>> questionList) throws Throwable {

        customerPortalQuoteOperationsObj.selectAnswersForTheQuestions(questionList);
    }

    @When("^customer clicks on '(.+)' notification$")
    public void customerClicksOnViewRenewalNotification(String notification) throws Throwable {
        customerPortalQuoteOperationsObj.clickOnRenewalNotification();
        customerPortalQuoteOperationsObj.navigateToPeople();
    }

    @And("^system should display all the covered insured persons$")
    public void systemShouldDisplayAllTheCoveredInsuredPersons(List<List<String>> parameter) throws Throwable {
        customerPortalQuoteOperationsObj.verifyCoveredInsuredPerson(parameter);
    }

    @Then("^system should presents the previously declared medical condition for covered insured person$")
    public void systemShouldPresentsThePreviouslyDeclaredMedicalConditionForCoveredInsuredPerson(List<List<String>> parameter) throws Throwable {
        customerPortalQuoteOperationsObj.verifyCoveredInsuredPerson(parameter);
        customerPortalQuoteOperationsObj.clickOnNext();
    }

    @And("^I purchase the policy with payment option as '(.+)'$")
    public void iPurchaseThePolicy(String payment) throws Throwable {
        customerPortalQuoteOperationsObj.navigateToBuyScreen();
        customerPortalQuoteOperationsObj.cardSelection(payment);
        customerPortalQuoteOperationsObj.completePayment();
//        customerPortalQuoteOperationsObj.signOutFromDigital();
    }

    @And("^customer doesn't want to purchase any additional upgrades$")
    public void customerDoesnTWantToPurchaseAnyAdditionalUpgrades() throws Throwable {
        customerPortalQuoteOperationsObj.customerNotPurchaseAdditionalCover();
    }

    @And("^system should present remaining additional upgrades with purchase option$")
    public void systemShouldPresentTheBasketSummary(List<List<String>> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.additionalUpgradeDetails(parameters);
    }

    @And("^verify the upgrade validity period for insured person$")
    public void iShouldBeAbleToValidateTheProRataPeriod() throws Throwable {
        customerPortalQuoteOperationsObj.validateProrataPeriod();

    }

    @And("^verify the pro-rata cost for '(.+)'$")
    public void iShouldBeAbleToValidateTheProRataCost(String cover) throws Throwable {

        customerPortalQuoteOperationsObj.dayDifference(cover);

    }

    @And("^system should present the following added cover in basket summary$")
    public void systemShouldPresentTheFollowingAddedCoverInBasketSummary(List<String> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.validateBasketSummary(parameters);
    }

    @And("^I navigate to home page$")
    public void iNavigateToHomePage() {

        customerPortalQuoteOperationsObj.navigateToHome();
    }


    @And("^system presents the basket screen with renewal details of last year's policy$")
    public void systemPresentsTheBasketScreenWithRenewalDetailsOfLastYearSPolicy(List<List<String>> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.validateUpgradeDetails(parameters);
    }


    @Then("^Customer should navigate to relevant screen$")
    public void customerShouldNavigateToRelevantScreen() throws Throwable {
        customerPortalQuoteOperationsObj.clickOnNext();
        customerPortalQuoteOperationsObj.clickOnNext();
        customerPortalQuoteOperationsObj.navigateToBasketScreen();
    }

    @And("^I should be able to amend the screened medical conditions before$")
    public void iShouldBeAbleToAmendTheScreenedMedicalConditionsBefore() throws Throwable {
        customerPortalQuoteOperationsObj.navigateToPeople();
        customerPortalQuoteOperationsObj.navigateToScreeningPage();
        customerPortalQuoteOperationsObj.navigateToScreeningPage();
        customerPortalQuoteOperationsObj.amendScreenedConditions();
    }


    @Then("^I should be able to review the following amended details$")
    public void iShouldBeAbleToReviewTheFollowingAmendedDetails(List<List<String>> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.navigateToBasketScreen();
        customerPortalQuoteOperationsObj.reviewSavedQuoteDetails(parameters);
    }

    @And("^customer should navigate to medical screen$")
    public void customerShouldNavigateToMedicalScreen() throws Throwable {
        customerPortalQuoteOperationsObj.navigateToGetAQuote();
        customerPortalQuoteOperationsObj.navigateToPeople();
        customerPortalQuoteOperationsObj.navigateToBasketScreen();
    }

    @And("^validate the basket summary with below details$")
    public void validateTheBasketSummaryWithBelowDetails(List<List<String>> parameter) throws Throwable {
        customerPortalQuoteOperationsObj.validateBasket(parameter);
    }

    @Then("^I return back to home page$")
    public void returnBackToHomePage() {
        customerPortalQuoteOperationsObj.navigateBackToHomePage();
    }


   /* @And("^system presents the following questions and I answer as follows$")
    public void systemPresentsTheFollowingQuestionsAndIAnswerAsFollows(List<List<String>> questionsList) throws Throwable {

        customerPortalQuoteOperationsObj.validatePeopleQuestions(questionsList);
    }*/


    @And("^System presents the medical screening questions and Prospect answers as follows$")
    public void systemPresentsTheMedicalScreeningQuestionsAndProspectAnswersAsFollows(List<List<String>> questionList) throws Throwable {
        for (int i = 1; i < questionList.size(); i++) {
            for (int j = 0; j < questionList.get(1).size(); j++) {
                quoteAndBuyOperationsObj.selectPeopleForMedicalScreening(questionList.get(0).get(j), questionList.get(i).get(j));
                System.out.println("inside for looopppppppppppppppppppp");
            }
        }
        quoteDetailsPageObj.btnClick(quoteDetailsPageObj.nextButton());
    }

/*
    @And("^I should answer the screening questions with the following options")
    public void iShouldAnswerTheScreeningQuestionsWithTheFollowingOptions(List<List<String>> questionList) throws Throwable {

        customerPortalQuoteOperationsObj.selectAnswersForTheQuestions(questionList);
    }*/

    @And("^prospect doesn't wish to add any additional upgrade$")
    public void prospectDoesnTWishToAddAnyAdditionalUpgrade() throws Throwable {
        customerPortalQuoteOperationsObj.verifySummarySelection();
    }

    @And("^system should present the following options to the prospect$")
    public void systemShouldPresentTheFollowingOptionsToTheProspect(List<List<String>> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.verifyButtonsAvailableForProspect();
    }

    @And("^system should present the basket screen to obtain quote on additional upgrades$")
    public void systemShouldPresentTheBasketScreenToObtainQuoteOnAdditionalUpgrades(List<List<String>> parameters) throws Throwable {
        customerPortalQuoteOperationsObj.additionalUpgradeDetails(parameters);
    }

    @And("^I should answer the screening questions for '(.+)' with the following options$")
    public void iShouldAnswerTheScreeningQuestionsForMainAccountHolderWithTheFollowingOptions(String person, List<List<String>> questionList) throws Throwable {
        if (nextEventPageObj.elementDisplayed(By.xpath(customerPortalQuotePageObj.addMedicalCondition(person)))) {
            customerPortalQuotePageObj.editMedicalCondition(person).click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
        quoteAndBuyOperationsObj.selectAnswersForTheQuestions(questionList);
    }

    @Then("^customer declines to renew the quote$")
    public void customerDeclinesToRenewTheQuote() throws Throwable {
        customerPortalQuoteOperationsObj.declineRenewal();
    }

    @And("^I wish to select payment option as '(.+)'$")
    public void iWishToSelectPaymentOption(String paymentOption) throws Throwable {
        customerPortalQuoteOperationsObj.selectPaymentOption(paymentOption);
    }

    @And("^proceed with payment process via '(.+)'$")
    public void iProceedWithPayment(String payment) throws Throwable {
        customerPortalQuoteOperationsObj.clickOnBuy();
        customerPortalQuoteOperationsObj.cardSelection(payment);
        customerPortalQuoteOperationsObj.completePayment();
//        customerPortalQuoteOperationsObj.signOutFromDigital();
    }


    @Then("^System should capture and update the customer provided inputs$")
    public void systemShouldCaptureAndUpdateTheCustomerProvidedInputs() throws Throwable {
//        customerPortalQuoteOperationsObj.navigateToScreening();
                customerPortalHomeOperationsObj.navigateToHomePage();
    }

    @Then("^I must be able to capture the following quote changes made from Customer operations in Insured people screen$")
    public void iMustBeAbleToCaptureTheFollowingQuoteChangesMadeFromCustomerOperationsInInsuredPeopleScreen(List<String> parameter) throws Throwable {

        customerPortalQuoteOperationsObj.clickOnUpgrades();
        customerPortalQuoteOperationsObj.navigateToPeople();
        customerPortalQuoteOperationsObj.validateInsuredPersons(parameter);

    }

    @And("^I must be able to verify the added medical condition entered as follows$")
    public void iMustBeAbleToVerifyTheAddedMedicalConditionEnteredAsFollows(List<List<String>> quoteDetails) throws Throwable {
        quoteAndBuyOperationsObj.validatePartialOnlineQuoteDetails(quoteDetails);
    }

    @And("^I must be able to view the following additional upgrades are selected$")
    public void iMustBeAbleToViewTheFollowingAdditionalUpgradesAreSelected(List<String> upgrades) throws Throwable {
        customerPortalQuoteOperationsObj.validateUpgradesAreAdded(upgrades);
    }

    @Then("^proceed with payment process$")
    public void proceedWithPaymentProcess() throws Throwable {
        customerPortalQuoteOperationsObj.clickOnBuy();
    }



    @And("^I navigate to Basket screen to review the saved quote details$")
    public void iNavigateToBasketScreenToReviewTheSavedQuoteDetails() throws Throwable {
        customerPortalQuoteOperationsObj.navigateToPeople();
        customerPortalQuoteOperationsObj.navigateToScreeningPage();
        customerPortalQuoteOperationsObj.navigateToScreeningPage();
        customerPortalQuoteOperationsObj.navigateToBasketScreen();
    }

    @And("^I navigate to screening page to review the Saved Quote details$")
    public void iNavigateToScreeningPageToReviewTheSavedQuoteDetails() throws Throwable {
        customerPortalQuoteOperationsObj.navigateToGetAQuote();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        customerPortalQuoteOperationsObj.navigateToPeople();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        customerPortalQuoteOperationsObj.navigateToScreeningPage();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        customerPortalQuoteOperationsObj.navigateToScreeningPage();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
    }

    @And("^click on '(.+)' to save the quote$")
    public void clickOnUnderstandToSaveTheQuote(String parameter) throws Throwable {
        customerPortalQuoteOperationsObj.clickUnderstandForSaveQuote();
    }

    @And("^I should be able to Download and Store '(.+)' in customer Portal$")
    public void iShouldBeAbleToDownloadAndStoreYourQuoteConfirmationInCustomerPortal(String DocName) throws Throwable {
        customerPortalQuoteOperationsObj.downloadAndStoreDocument(DocName);
    }

    @And("^I wish to add a person as '(.+)' in claim$")
    public void iWishToAddAPersonAsPartnerInClaim(String personType, List<List<String>> personDetails) throws Throwable {
        customerPortalQuoteOperationsObj.addPatnerAndDependentChild(personType, personDetails);
    }

    @And("^I should be able to Download and Store '(.+)' from Claims page in customer Portal$")
    public void iShouldBeAbleToDownloadAndStoreDependentChildrenAgedToFromClaimsPageInCustomerPortal(String DocName) throws Throwable {
        customerPortalQuoteOperationsObj.downloadAndStoreDocumentFromClaimPage(DocName);
    }
    @When("^I should be able to see Thank you page for saving the quote$")
    public void I_should_be_able_to_see_Thank_you_page_for_saving_the_quote(){
        customerPortalQuoteOperationsObj.verifyThankYouPage();
    }

    @And("^I should be able to verify the CPA is disabled for the ThirdParty card$")
    public void iShouldBeAbleToVerifyTheCPAIsDisabledForTheThirdPartyCard(){
       customerPortalQuoteOperationsObj.verifyCPAIsDisabled();
    }
    @Then("^I need to validate the icons in basket screen$")
    public void iNeedToValidatetheIconsInBasketScreen(){
        customerPortalQuoteOperationsObj.validateIcons();
    }

    @When("^I click on '(.+)' in Portal$")
    public void iClickOnUpgradesInPortal(String parameter) throws Throwable {

        customerPortalQuoteOperationsObj.navigateToUpgradesTab();
    }
}