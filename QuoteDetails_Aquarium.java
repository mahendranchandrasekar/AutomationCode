package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.ConfigureEventsOperations;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class QuoteDetails_Aquarium {

    private static String strNoValueEntryString = "Nothing Entered";
    String cover = "";
    String premium = "";
    String ipt = "";
    private QuoteDetailsPage quoteDetailsPageObj = new QuoteDetailsPage();
    private ClaimsOperations claimOperationObj = new ClaimsOperations();
    private QuoteRenewalPage quoteRenewalPageObj = new QuoteRenewalPage();
    private PerformSearch performSearchObj = new PerformSearch();
    private SearchPage searchPageObj = new SearchPage();
    private FullEventHistoryPage fullEventHistoryPageObj = new FullEventHistoryPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private EventHistory eventHistoryObj = new EventHistory();
    private ConfigureEventsOperations configureEventsOperationsObj = new ConfigureEventsOperations();
    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private co.uk.directlinegroup.tt.utils.common.Select selectObj = new co.uk.directlinegroup.tt.utils.common.Select();
    private String strSearchCondition = "";

    public void verify_QuoteQuestioneris(List<List<String>> parameters) throws Throwable {
        for (int row = 1; row < parameters.size(); row++) {
            boolean bClickSearchButton = true;
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.verifyQuoteQuestions(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
    }

    public void verifyQuoteQuestions(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "condition":
                    quoteDetailsPageObj.medicalCondition();
                    Assert.assertTrue(searchValue.equalsIgnoreCase(quoteDetailsPageObj.medicalCondition().getText()));
                    quoteDetailsPageObj.medicalConditionLink();
                    quoteDetailsPageObj.medicalConditionLink().click();
                    break;
                case "copd":
                    quoteDetailsPageObj.diagnosisofCOPD();
                    Assert.assertTrue(searchValue.equalsIgnoreCase(quoteDetailsPageObj.diagnosisofCOPD().getText()));
                    break;
                case "age":
                    quoteDetailsPageObj.age_WhenAsthmaDiagnosed();
                    Assert.assertTrue(searchValue.equalsIgnoreCase(quoteDetailsPageObj.age_WhenAsthmaDiagnosed().getText()));
                    break;
                case "noofmedicines":
                    quoteDetailsPageObj.numberOfMedicines();
                    Assert.assertTrue(searchValue.equalsIgnoreCase(quoteDetailsPageObj.numberOfMedicines().getText()));
                    break;
                case "nebulisers":
                    quoteDetailsPageObj.nebulisers();
                    Assert.assertTrue(searchValue.equalsIgnoreCase(quoteDetailsPageObj.nebulisers().getText()));
                    break;
                case "hospital_admissions":
                    quoteDetailsPageObj.hospitalAdmissions();
                    Assert.assertTrue(searchValue.equalsIgnoreCase(quoteDetailsPageObj.hospitalAdmissions().getText()));
                    break;
                case "oxygen":
                    quoteDetailsPageObj.prescribedOxygen();
                    Assert.assertTrue(searchValue.equalsIgnoreCase(quoteDetailsPageObj.prescribedOxygen().getText()));
                    break;
                case "smoker":
                    quoteDetailsPageObj.everBeenASmoker();
                    Assert.assertTrue(searchValue.equalsIgnoreCase(quoteDetailsPageObj.everBeenASmoker().getText()));
                    break;
            }
        }
    }

    public void setEndDate(String cover, int days) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteRenewalPageObj.selectUpgrade(cover).click();
        this.calculateEndDate(days);
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.saveandclose().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.navigateToBasePolicy().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void calculateEndDate(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String startDate = sdf.format(c.getTime());
        System.out.println("current date ---" + startDate);
        quoteRenewalPageObj.txtQStartDate().clear();
        quoteRenewalPageObj.txtQStartDate().sendKeys(startDate);
        c.add(Calendar.DATE, days);
        String endDate = sdf.format(c.getTime());
        quoteRenewalPageObj.txtQEndDate().clear();
        quoteRenewalPageObj.txtQEndDate().sendKeys(endDate);
        System.out.println("End date ---" + endDate);
    }

    public void renewalProcess(String eventType) {
        this.selectBasePolicy();
        if (eventType.equalsIgnoreCase("Renewal Suppress Communication")) {
            claimOperationObj.clickingUnderNextEventsAndButtons("out of process event");
            claimOperationObj.navigateToEventType(eventType);
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
            quoteRenewalPageObj.chkBxSupressComm().click();
            quoteRenewalPageObj.btnSave().click();
        } else {
            System.out.println("Event -----------" + eventType);
            claimOperationObj.clickingUnderNextEventsAndButtons("out of process event");
            claimOperationObj.navigateToEventType(eventType);
        }
    }

    public void initiateRenewalProcess(String renewalType, String eventType) {
        this.selectBasePolicy();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.clickingUnderNextEventsAndButtons("out of process event");
        claimOperationObj.navigateToEventType(eventType);
        this.renewalType(renewalType);
    }

    public void renewalType(String renewalType) {
        switch (renewalType) {
            case "Automatic":
                if (quoteRenewalPageObj.chkBxAutoRenewal().isSelected()) {
                } else {
                    quoteRenewalPageObj.chkBxAutoRenewal().click();
                }
                if (quoteRenewalPageObj.chkBxAutoReQuote().isSelected()) {
                } else {
                    quoteRenewalPageObj.chkBxAutoReQuote().click();
                }
                if (quoteRenewalPageObj.chkBxManualRenewal().isSelected()) {
                    quoteRenewalPageObj.chkBxManualRenewal().click();
                }
                if (quoteRenewalPageObj.chkBxMissingData().isSelected()) {
                    quoteRenewalPageObj.chkBxMissingData().click();
                }
                if (quoteRenewalPageObj.chkBxManualReQuote().isSelected()) {
                    quoteRenewalPageObj.chkBxManualReQuote().click();
                }
                quoteRenewalPageObj.btnSave().click();
                break;
            case "Manual":
                if (quoteRenewalPageObj.chkBxAutomaticRenewal().isSelected()) {
                    quoteRenewalPageObj.chkBxAutomaticRenewal().click();
                } else {
                }
                if (quoteRenewalPageObj.chkBxManualRenewal().isSelected()) {
                } else {
                    quoteRenewalPageObj.chkBxManualRenewal().click();
                }
                if (quoteRenewalPageObj.chkBxMissingData().isSelected()) {
                    quoteRenewalPageObj.chkBxMissingData().click();
                }
                fullEventHistoryPageObj.saveAndClose().click();
                break;
            case "Automatic Renewal":
                if (quoteRenewalPageObj.chkBxAutoRenewal().isSelected()) {
                } else {
                    quoteRenewalPageObj.chkBxAutoRenewal().click();
                }
                if (quoteRenewalPageObj.chkBxAutoReQuote().isSelected()) {
                } else {
                    quoteRenewalPageObj.chkBxAutoReQuote().click();
                }
                if (quoteRenewalPageObj.manualRenewal().isSelected()) {

                    quoteRenewalPageObj.manualRenewal().click();
                }
                if (quoteRenewalPageObj.missingData().isSelected()) {
                    quoteRenewalPageObj.missingData().click();
                }
                if (quoteRenewalPageObj.chkBxManualReQuote().isSelected()) {
                    quoteRenewalPageObj.chkBxManualReQuote().click();
                }
                quoteRenewalPageObj.btnSave().click();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                quoteRenewalPageObj.txtComment().sendKeys("Test");
                quoteRenewalPageObj.btnFinish().click();
                break;
            case "On Hold":
                if (!(quoteRenewalPageObj.chkBxOnHold2().isSelected())) {
                    quoteRenewalPageObj.chkBxOnHold2().click();
                }
                if (quoteRenewalPageObj.chkBxAutoRenewal().isSelected()) {
                    quoteRenewalPageObj.chkBxAutoRenewal().click();
                }
                if (quoteRenewalPageObj.chkBxAutoReQuote().isSelected()) {
                    quoteRenewalPageObj.chkBxAutoReQuote().click();
                }
                if (!quoteRenewalPageObj.manualRenewal().isSelected()) {
                    quoteRenewalPageObj.manualRenewal().click();
                }
                if (quoteRenewalPageObj.chkBxManualReQuote().isSelected()) {
                    quoteRenewalPageObj.chkBxManualReQuote().click();
                }
                if (quoteRenewalPageObj.chkBxOnHold1().isSelected()) {
                    quoteRenewalPageObj.chkBxOnHold1().click();
                }
                if (quoteRenewalPageObj.chkBxOnHold2().isSelected()) {
                    quoteRenewalPageObj.chkBxOnHold2().click();
                }
                quoteRenewalPageObj.btnSave().click();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                quoteRenewalPageObj.txtComment().sendKeys("Test");
                quoteRenewalPageObj.btnFinish().click();
                break;
            case "Manual Renewal":
                if (quoteRenewalPageObj.manualRenewal().isSelected()) {
                } else {
                    quoteRenewalPageObj.manualRenewal().click();
                }
                if (quoteRenewalPageObj.chkBxManualReQuote().isSelected()) {
                } else {
                    quoteRenewalPageObj.chkBxManualReQuote().click();
                }
                if (quoteRenewalPageObj.chkBxAutoRenewal().isSelected()) {

                    quoteRenewalPageObj.chkBxAutoRenewal().click();
                }
                if (quoteRenewalPageObj.missingData().isSelected()) {
                    quoteRenewalPageObj.missingData().click();
                }
                if (quoteRenewalPageObj.chkBxAutoReQuote().isSelected()) {
                    quoteRenewalPageObj.chkBxAutoReQuote().click();
                }
                if (quoteRenewalPageObj.chkBxOnHold1().isSelected()) {
                    quoteRenewalPageObj.chkBxOnHold1().click();
                }
                if (quoteRenewalPageObj.chkBxOnHold2().isSelected()) {
                    quoteRenewalPageObj.chkBxOnHold2().click();
                }
                quoteRenewalPageObj.btnSave().click();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                quoteRenewalPageObj.txtComment().sendKeys("Test");
                quoteRenewalPageObj.btnFinish().click();
                break;
        }
    }

    public void IshouldbeabletoverifytheQVP(int days) throws Throwable {
        String QVPfield = quoteDetailsPageObj.QVP().getText();
        System.out.println("QVPfield----------------------------" + QVPfield);
        String QVPdays = quoteDetailsPageObj.QVPDays().getText().trim().split(" ")[0];
        System.out.println("QVPdays----------------------------" + QVPdays);
        int value = Integer.parseInt(QVPdays);
        if (value >= 0 || value <= days) {
            System.out.println("Valid QVP");
            Assert.assertTrue(true);
        } else {
            System.out.println("Invalid QVP");
            Assert.assertTrue(false);
        }
    }

    public void selectBasePolicy() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (nextEventPageObj.elementDisplayed(By.xpath(quoteRenewalPageObj.lnkBasePolicySelected()))) {
        } else {
            nextEventPageObj.waitForElementPresent(By.xpath(quoteRenewalPageObj.lnkBasePolicySelect())).click();
        }
    }

    public void retriveClientRecord() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        performSearchObj.retreiveFirstClientRecord();
        searchPageObj.switchToLastOpenWindow();
    }

    public void disableSuppressComm(String eventType) {
        this.selectBasePolicy();
        claimOperationObj.clickingUnderNextEventsAndButtons("out of process event");
        claimOperationObj.navigateToEventType(eventType);
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        if (quoteRenewalPageObj.chkBxSupressComm().isSelected()) {
            quoteRenewalPageObj.chkBxSupressComm().click();
        } else {
        }
        nextEventPageObj.waitForMoreTime();
        quoteRenewalPageObj.btnSave().click();
    }

    public void updateStartAndEndDate(String cover, int month) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteRenewalPageObj.selectUpgrade(cover).click();
        this.upgradeValidityPeriod(month);
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.saveandclose().click();
    }

    public void upgradeValidityPeriod(int months) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String startDate = sdf.format(c.getTime());
        System.out.println("current date ---" + startDate);
        quoteRenewalPageObj.txtQStartDate().clear();
        quoteRenewalPageObj.txtQStartDate().sendKeys(startDate);
        c.add(Calendar.MONTH, months);
        String endDate = sdf.format(c.getTime());
        quoteRenewalPageObj.txtQEndDate().clear();
        quoteRenewalPageObj.txtQEndDate().sendKeys(endDate);
        System.out.println("End date ---" + endDate);
    }

    public void validateRenewedQuote() {
        if (quoteRenewalPageObj.lblRenewalQuote().isDisplayed()) {
            System.out.println("Current Date ----- " + new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()).toString() +
                    " Created Date ---- " + quoteRenewalPageObj.lblQuoteCreatedDate().getText());
            Assert.assertEquals(new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()).toString(), quoteRenewalPageObj.lblQuoteCreatedDate().getText());
        }
        Assert.assertTrue(!(nextEventPageObj.elementDisplayed(By.xpath(quoteRenewalPageObj.lblSecondQuote()))));
    }

    public void expireAllQuote(int days) {
        List<WebElement> upgrades = (List<WebElement>) nextEventPageObj.getDriver.findElements(By.xpath("//th[contains(text(),'Annual Upgrade')]/../following-sibling::tr/td[1]/a"));
        System.out.println("Total Existing annual upgrades -----------" + upgrades.size());
        for (int i = 1; i <= upgrades.size(); i++) {
            System.out.println("i value ------" + i);
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.getDriver.findElement(By.xpath("(//th[contains(text(),'Annual Upgrade')]/../following-sibling::tr/td[1]/a)[" + i + "]")).click();
            nextEventPageObj.waitForMoreTime();
            this.calculateEndDate(days);
            nextEventPageObj.waitForMoreTime();
            policyDataFieldsPageObj.saveandclose().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void enterRenewalDetails(List<List<String>> parameters) throws Throwable {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int row = 1; row < parameters.size(); row++) {

            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.enterRenewalPeriod(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
        nextEventPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
    }

    public void enterRenewalPeriod(String fieldName, String fieldValue) throws Throwable {
        switch (fieldName.toLowerCase()) {
            case "earliest renewal date":
                quoteRenewalPageObj.txtEarlyRenewalDate().clear();
                quoteRenewalPageObj.txtEarlyRenewalDate().sendKeys(fieldValue);
                break;
            case "valid renewal period":
                quoteRenewalPageObj.txtValidRenewalDate().clear();
                quoteRenewalPageObj.txtValidRenewalDate().sendKeys(fieldValue);
                break;
            case "standard renewal period":
                quoteRenewalPageObj.txtStdRenewalDate().clear();
                quoteRenewalPageObj.txtStdRenewalDate().sendKeys(fieldValue);
                break;
            case "reason":
                quoteRenewalPageObj.renewalReason().click();
                nextEventPageObj.waitForMoreTime();
                quoteRenewalPageObj.drpdnRenewalReason(fieldValue).click();
                break;
        }
    }

    public void captureQuoteDetails(List<List<String>> parameters) throws Throwable {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.validateQuoteContent(parameters.get(0).get(column), parameters.get(row).get(column));
                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            }
        }
          nextEventPageObj.btnClick(nextEventPageObj.btnCloseWindow());
    }
    public void singleTripUpgradeNotDisable(String cover){
        Assert.assertTrue(!quoteRenewalPageObj.coverShouldNotDisplay(cover).isDisplayed());
    }


    public void validateQuoteContent(String fieldName, String fieldValue) throws Throwable {
        switch (fieldName.toLowerCase()) {
            case "lastyearpremium":
                String lastYrPremium = fieldValue.split("-")[1];
                cover = fieldValue.split("-")[0];
                break;
            case "premiumipt":
                String ipt = fieldValue.split("-")[1];
                cover = fieldValue.split("-")[0];
                Assert.assertTrue(quoteRenewalPageObj.premiumIPT(cover).getText().equalsIgnoreCase(ipt));
                break;
            case "price":
                String price = fieldValue.split("-")[1];
                cover = fieldValue.split("-")[0];
                Assert.assertTrue(quoteRenewalPageObj.lblTotalPrice(cover).getText().equalsIgnoreCase(price));
                break;
            case "lastyearprice":
                String lastyearprice = fieldValue.split("-")[1];
                cover = fieldValue.split("-")[0];
                Assert.assertTrue(quoteRenewalPageObj.lblLastYrPrice(cover).getText().equalsIgnoreCase(lastyearprice));
                break;
            case "premium":
                String premium = fieldValue.split("-")[1];
                cover = fieldValue.split("-")[0];
                Assert.assertTrue(quoteRenewalPageObj.lblPremium(cover).getText().equalsIgnoreCase(premium));
                break;
            case "prorated premium":
                String propremium = fieldValue.split("-")[1];
                cover = fieldValue.split("-")[0];
                Assert.assertTrue(quoteRenewalPageObj.lblProPremium(cover).getText().equalsIgnoreCase(propremium));
                break;
            case "expiry date":
                quoteRenewalPageObj.tabActions().click();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue(!quoteRenewalPageObj.txtQuoteExpiryDate().getAttribute("value").isEmpty());
                break;
            case "paymentoption":
                quoteRenewalPageObj.paymentOptions().click();
                String[] payment = fieldValue.split("#");
                for (int i = 0; i < payment.length; i++) {
                    String options = payment[i].split("-")[0];
                    Assert.assertTrue(quoteRenewalPageObj.drpdnPaymentOption(options).isDisplayed());
                    nextEventPageObj.waitForMoreTime();
                }
                break;
            case "tab":
                if(!fieldValue.equalsIgnoreCase("na")){
                    quoteRenewalPageObj.quoteDetails().click();
                }break;
        }
    }

    public void inviteRenewalProcess(String eventType, List<List<String>> lstInput) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.clickingUnderNextEventsAndButtons("out of process event");
        claimOperationObj.navigateToEventType(eventType);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println("inside upgrades");
            this.enterRenewalInviteDetails(lstInput.get(i).get(0), lstInput.get(i).get(1));
            System.out.println("Field name -----------" + lstInput.get(i).get(0) + "---------------Field Value-------------" + lstInput.get(i).get(1));
        }
     }

    public void enterRenewalInviteDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "automatic re quote":
                if (fieldValue.equalsIgnoreCase("True")) {
                    if (quoteRenewalPageObj.chkBxAutoRenewalQuote().getAttribute("checked").equalsIgnoreCase("False"))
                        quoteRenewalPageObj.chkBxAutoReQuote().click();
                    else {
                    }
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxAutoReQuote().isSelected()) {
                        quoteRenewalPageObj.chkBxAutoReQuote().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxAutoReQuote().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertTrue(!(quoteRenewalPageObj.chkBxAutoReQuote().isSelected()));
                }
                break;
            case "automatic renewal":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxAutoRenewal().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxAutoRenewal().isSelected()) {
                        quoteRenewalPageObj.chkBxAutoRenewal().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxAutoRenewal().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertTrue(!(quoteRenewalPageObj.chkBxAutoRenewal().isSelected()));
                }
                break;
            case "on hold queue(1)":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxOnHold1().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxOnHold1().isSelected()) {
                        quoteRenewalPageObj.chkBxOnHold1().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxOnHold1().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertTrue(!(quoteRenewalPageObj.chkBxOnHold1().isSelected()));
                }
                break;
            case "on hold queue(2)":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxOnHold2().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxOnHold2().isSelected()) {
                        quoteRenewalPageObj.chkBxOnHold2().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxOnHold2().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertTrue(!(quoteRenewalPageObj.chkBxOnHold2().isSelected()));
                }
                break;
            case "customer deceased":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxCustomerDeceased().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxCustomerDeceased().isSelected()) {
                        quoteRenewalPageObj.chkBxCustomerDeceased().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxCustomerDeceased().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertFalse(quoteRenewalPageObj.chkBxCustomerDeceased().isSelected());
                }
                break;
            case "underwriter triggers hit":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxUnderwriterTriggersHit().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxUnderwriterTriggersHit().isSelected()) {
                        quoteRenewalPageObj.chkBxUnderwriterTriggersHit().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxUnderwriterTriggersHit().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertFalse(quoteRenewalPageObj.chkBxUnderwriterTriggersHit().isSelected());
                }
                break;
            case "outstanding payment":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxOutstandingPayment().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxOutstandingPayment().isSelected()) {
                        quoteRenewalPageObj.chkBxOutstandingPayment().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxOutstandingPayment().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertFalse(quoteRenewalPageObj.chkBxOutstandingPayment().isSelected());
                }
                break;
            case "customer barred":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxCustomerBarred().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxCustomerBarred().isSelected()) {
                        quoteRenewalPageObj.chkBxCustomerBarred().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxCustomerBarred().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertFalse(quoteRenewalPageObj.chkBxCustomerBarred().isSelected());
                }
                break;
            case "account showing as closed - upgrade not yet cancelled":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxAcctClosedUpgradeNotCancelled().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxAcctClosedUpgradeNotCancelled().isSelected()) {
                        quoteRenewalPageObj.chkBxAcctClosedUpgradeNotCancelled().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxAcctClosedUpgradeNotCancelled().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertFalse(quoteRenewalPageObj.chkBxAcctClosedUpgradeNotCancelled().isSelected());
                }
                break;
            case "upgrade on dummy client record":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxUpgradeDummyClientRecord().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxUpgradeDummyClientRecord().isSelected()) {
                        quoteRenewalPageObj.chkBxUpgradeDummyClientRecord().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxUpgradeDummyClientRecord().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertFalse(quoteRenewalPageObj.chkBxUpgradeDummyClientRecord().isSelected());
                }
                break;
            case "foreign address or no postcode":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxForeignAddress().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxForeignAddress().isSelected()) {
                        quoteRenewalPageObj.chkBxForeignAddress().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxForeignAddress().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertFalse(quoteRenewalPageObj.chkBxForeignAddress().isSelected());
                }
                break;
            case "manual re quote":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxManualReQuote().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxManualReQuote().isSelected()) {
                        quoteRenewalPageObj.chkBxManualReQuote().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxManualReQuote().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertTrue(!(quoteRenewalPageObj.chkBxManualReQuote().isSelected()));
                }
                break;
            case "manual renewal":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.manualRenewal().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.manualRenewal().isSelected()) {
                        quoteRenewalPageObj.manualRenewal().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.manualRenewal().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertTrue(!(quoteRenewalPageObj.manualRenewal().isSelected()));
                }
                break;
            case "valid cpa / ddi in place":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxValidCPAAndDDI().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxValidCPAAndDDI().isSelected()) {
                        quoteRenewalPageObj.chkBxValidCPAAndDDI().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                   String cpa=quoteRenewalPageObj.validCPAAndDDIValue().getAttribute("value");
                    System.out.println("CPA value" +cpa);
                    cpa= cpa.replace(',',' ').trim();
                    cpa=cpa.replaceAll("\\s","");
                    System.out.println("CPA trim value" +cpa);
                    int cpavalue= Integer.parseInt(cpa);
                    System.out.println("CPA Integer value" +cpavalue);
                    if(cpavalue!=0){
                       Assert.assertTrue(true);
                        System.out.println("Inside True Block");
                    } else
                        Assert.assertFalse(true);
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertFalse(quoteRenewalPageObj.chkBxValidCPAAndDDI().isSelected());
                }
                break;
            case "customers asked to cancel":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxCustAskedToCancel().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxCustAskedToCancel().isSelected()) {
                        quoteRenewalPageObj.chkBxCustAskedToCancel().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxCustAskedToCancel().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertFalse(quoteRenewalPageObj.chkBxCustAskedToCancel().isSelected());
                }
                break;
            case "medical screening score less than x":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxMedicalScreeningScore().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxMedicalScreeningScore().isSelected()) {
                        quoteRenewalPageObj.chkBxMedicalScreeningScore().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxMedicalScreeningScore().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertTrue(!(quoteRenewalPageObj.chkBxMedicalScreeningScore().isSelected()));
                }
                break;
            case "customer has turned 70 in the last 12 months":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxCustTurned70().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxCustTurned70().isSelected()) {
                        quoteRenewalPageObj.chkBxCustTurned70().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxCustTurned70().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertFalse(quoteRenewalPageObj.chkBxCustTurned70().isSelected());
                }
                break;
            case "renewal stopped by rep":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxRenewalStoppedByRep().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxRenewalStoppedByRep().isSelected()) {
                        quoteRenewalPageObj.chkBxRenewalStoppedByRep().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxRenewalStoppedByRep().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertFalse(quoteRenewalPageObj.chkBxRenewalStoppedByRep().isSelected());
                }
                break;
            case "no postcode":
                if (fieldValue.equalsIgnoreCase("True")) {
                    quoteRenewalPageObj.chkBxForeignOrNoPostcode().click();
                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (quoteRenewalPageObj.chkBxForeignOrNoPostcode().isSelected()) {
                        quoteRenewalPageObj.chkBxForeignOrNoPostcode().click();
                    }
                } else if (fieldValue.equalsIgnoreCase("Checked")) {
                    Assert.assertTrue(quoteRenewalPageObj.chkBxForeignOrNoPostcode().isSelected());
                } else if (fieldValue.equalsIgnoreCase("UnChecked")) {
                    Assert.assertFalse(quoteRenewalPageObj.chkBxForeignOrNoPostcode().isSelected());
                }
                break;
            case "comments":
                quoteRenewalPageObj.btnSave().click();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                nextEventPageObj.waitForPageLoad();
                quoteRenewalPageObj.txtComment().sendKeys(fieldValue);
                quoteRenewalPageObj.btnFinish().click();
                break;
            case "action":
                if (fieldValue.equalsIgnoreCase("cancel")) {
                    nextEventPageObj.CancelBtn().click();
                }
                if (fieldValue.equalsIgnoreCase("save")) {
                    quoteRenewalPageObj.btnSave().click();
                }
                break;
        }
    }

    public void renewalCreateQuote(String eventType, List<List<String>> parameters) throws Throwable {
        nextEventPageObj.btnClick(nextEventPageObj.go());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.navigateToEventType(eventType);
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.renewalQuote(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
        nextEventPageObj.switchToDefault();
    }

    public void renewalQuote(String fieldName, String fieldValue) throws Throwable {
        switch (fieldName.toLowerCase()) {
            case "earliest renewal date":
                quoteRenewalPageObj.renewalDetails(fieldName).clear();
                quoteRenewalPageObj.renewalDetails(fieldName).sendKeys(fieldValue);
                break;
            case "reason for early renewal":
                quoteRenewalPageObj.reasonForEarlyRenewalImg().click();
                quoteRenewalPageObj.reasonForEarlyRenewalReason(fieldValue).click();
                break;
            case "action":
                quoteRenewalPageObj.btnSave().click();
                break;
        }
    }

    public void validateQuoteResponses(List<List<String>> parameters) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 0; i < parameters.size(); i++) {
            this.validateResponses(parameters.get(i), parameters.get(0));
        }
    }

    public void validateResponses(List<String> rowValue, List<String> columnName) {
        String question1 = "", option = "", expectedBehaviour = "";
        for (int i = 0; i < columnName.size(); i++) {
            if (columnName.get(i).equalsIgnoreCase("Questions"))
                question1 = rowValue.get(i);
            else if (columnName.get(i).equalsIgnoreCase("Responses")) {
                option = rowValue.get(i);
                this.selectOptionYesOrNo(option, question1);
            }
        }
    }

    public void selectOptionYesOrNo(String option, String question1) {
        if (option.equalsIgnoreCase("yes")) {
            System.out.println("Question ---." + question1 + "----checked----" + quoteDetailsPageObj.validateResponses(question1).isSelected());
            Assert.assertTrue(quoteDetailsPageObj.validateResponses(question1).isSelected());
        } else if (option.equalsIgnoreCase("no")) {
            System.out.println("Question ---." + question1 + "----Unchecked----" + quoteDetailsPageObj.validateResponses(question1).isSelected());
            Assert.assertTrue(!quoteDetailsPageObj.validateResponses(question1).isSelected());
        }
    }

    public void convertEarlyQuoteToRenewedPolicy(List<List<String>> parameters) throws Throwable {
        nextEventPageObj.btnClick(nextEventPageObj.go());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.buyEarlyQuote(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
    }

    public void buyEarlyQuote(String fieldName, String fieldValue) throws Throwable {
        switch (fieldName.toLowerCase()) {
            case "oop event":
                claimOperationObj.navigateToEventType(fieldValue);
                nextEventPageObj.switchToDefault();
                break;
            case "verify event":
                nextEventPageObj.switchToDefault();
                System.out.println("Verify Event Method...");
                eventHistoryObj.refresh();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                eventHistoryObj.refresh();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                configureEventsOperationsObj.verifyEvents(fieldValue);
                break;
            case "validation":
                Assert.assertTrue(quoteDetailsPageObj.validateNoQuote().getText().contains(fieldValue));
                break;
        }
    }

    public void validateRenewalPolicyDocumentation(String event) throws Throwable {
        nextEventPageObj.switchToDefault();
        System.out.println("Verify Event Method...");
        eventHistoryObj.refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        eventHistoryObj.refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(nextEventPageObj.recoveryEvent(event).isDisplayed());
        nextEventPageObj.recoveryEvent(event).click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameByIndex(0);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.showDocument().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("Sizeeeeeee--------------------------" + claimsOperationsObj.fileSize());
        long fileSize = claimsOperationsObj.fileSize();
        System.out.println("Sizeeeeeee--------------------------" + fileSize);
        Assert.assertTrue(fileSize > 0);
    }

    public void quoteExpiryDate(String event, List<List<String>> parameters) {
        try {
            this.selectBasePolicy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.clickingUnderNextEventsAndButtons("out of process event");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimOperationObj.navigateToEventType(event);
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.expireQuoteWithSpecificDays(parameters.get(row).get(column));
            }
        }
        nextEventPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void expireQuoteWithSpecificDays(String fieldName) {
        try {
            if(quoteRenewalPageObj.chkBxExpireQuote().isSelected()){
                quoteRenewalPageObj.chkBxExpireQuote().click();
            }
            if(quoteRenewalPageObj.chkBxSyncQuoteExpiryDate().isSelected()){
                quoteRenewalPageObj.chkBxSyncQuoteExpiryDate().click();
            }
            if(quoteRenewalPageObj.chkBk100Days().isSelected()){
                quoteRenewalPageObj.chkBk100Days().click();
            }
            if(quoteRenewalPageObj.chkBk59Days().isSelected()){
                quoteRenewalPageObj.chkBk59Days().click();
            }
            if(quoteRenewalPageObj.chkBk30Days().isSelected()){
                quoteRenewalPageObj.chkBk30Days().click();
            }
            if(quoteRenewalPageObj.chkBk14Days().isSelected()){
                quoteRenewalPageObj.chkBk14Days().click();
            }
            if(quoteRenewalPageObj.chkBk0Days().isSelected()){
                quoteRenewalPageObj.chkBk0Days().click();
            }
            if(quoteRenewalPageObj.portalAgedLogon().isSelected()){
                quoteRenewalPageObj.portalAgedLogon().click();
            }
            quoteRenewalPageObj.txtXdaysPrior().clear();
            switch (fieldName.toLowerCase()) {
                case "expire quote":
                    quoteRenewalPageObj.chkBxExpireQuote().click();
                    break;
                case "sync quote":
                    quoteRenewalPageObj.chkBxSyncQuoteExpiryDate().click();
                    break;
                case "100 days":
                    quoteRenewalPageObj.chkBk100Days().click();
                    break;
                case "59 days":
                    quoteRenewalPageObj.chkBk59Days().click();
                    break;
                case "30 days":
                    System.out.println("Expire upgrades 30 days prior....");
                    quoteRenewalPageObj.chkBk30Days().click();
                    break;
                case "14 days":
                    quoteRenewalPageObj.chkBk14Days().click();
                    break;
                case "0 days":
                    quoteRenewalPageObj.chkBk0Days().click();
                    break;
                case "portal logon by 100 days":
                    if(quoteRenewalPageObj.portalAgedLogon().isSelected())
                    {
                        System.out.println("100 days --- Checked ");
                    }else
                    {
                        System.out.println("100 days --- UnChecked ");
                        quoteRenewalPageObj.portalAgedLogon().click();
                    }
                    break;
                case "x days prior to renewal":
                    quoteRenewalPageObj.txtXdaysPrior().sendKeys("100");
                    quoteRenewalPageObj.txtXdaysPrior().sendKeys(Keys.TAB);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkPolicy() throws Throwable {
        Assert.assertTrue(nextEventPageObj.checkPolicyicon().isDisplayed());
    }

    public void validateRenewalReminderPolicyDocumentation(String event) throws Throwable {
        nextEventPageObj.switchToDefault();
        System.out.println("Verify Event Method...");
        eventHistoryObj.refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        eventHistoryObj.refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(nextEventPageObj.recoveryReminderEvent(event).isDisplayed());
        nextEventPageObj.recoveryReminderEvent(event).click();
    }

    public void validateBackToAQ() {
        Assert.assertTrue(quoteDetailsPageObj.validateAquarium().isDisplayed());
        quoteDetailsPageObj.validateAquarium().click();
    }

    public void quoteExpireDaysPriorToRenewal(String event,String days){
        try {
            this.selectBasePolicy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        claimOperationObj.clickingUnderNextEventsAndButtons("out of process event");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimOperationObj.navigateToEventType(event);
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        quoteRenewalPageObj.txtXdaysPrior().clear();
        quoteRenewalPageObj.txtXdaysPrior().sendKeys(days);
        quoteRenewalPageObj.txtXdaysPrior().sendKeys(Keys.TAB);
        nextEventPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
    }
}
