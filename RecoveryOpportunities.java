package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.WebTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import org.openqa.selenium.WebDriver.*;

import static java.lang.Float.parseFloat;

public class RecoveryOpportunities {

    private static String strNoValueEntryString = "Nothing Entered";
    public String strSearchCondition = "";
    public String totalClaimValue = "";
    public String percentagecal = "";
    public String retrieveEstimatedAmount = "";
    EvidenceCollationPage evidenceCollationPageObj = new EvidenceCollationPage();
    ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    FinancialPage financialPageObj = new FinancialPage();
    ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    NextEventPage nextEventPageObj = new NextEventPage();
    private RecoveryOpportunitiesPage recoveryOpportunitiesPageObj = new RecoveryOpportunitiesPage();
    private WebTable webTableObj = new WebTable();
    private Navigation navigationObj = new Navigation();
    public String totalReserveValue = "";

    public void selectRecoveryOpportunities(List<String> lstRecoveryOpportunities) {
        nextEventPageObj.switchToDefault();
        try {
            nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        } catch (Exception ex) {
            try {
                nextEventPageObj.btnClick( nextEventPageObj.go() );
            } catch (Exception exe) {
                nextEventPageObj.btnClick( nextEventPageObj.go() );
            }
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        }
        List<WebElement> lstRows = recoveryOpportunitiesPageObj.recoveryOpportunitiesTable().findElements( By.tagName( "tr" ) );
        int iRecoveryNameColIndex = webTableObj.getColumnFromWebTable( recoveryOpportunitiesPageObj.recoveryOpportunitiesTable(), "Recovery Name" );
        for (int irecIndex = 1; irecIndex < lstRecoveryOpportunities.size(); irecIndex++) {
            String strExpRecoveryOption = lstRecoveryOpportunities.get( irecIndex );
            for (int iRow = 1; iRow < lstRows.size(); iRow++) {
                List<WebElement> lstCols = lstRows.get( iRow ).findElements( By.tagName( "td" ) );
                String strActRecoveryName = lstCols.get( iRecoveryNameColIndex ).getText();
                if (strActRecoveryName.equalsIgnoreCase( strExpRecoveryOption )) {
                    recoveryOpportunitiesPageObj.selectRecoveryCheckbox().get( (iRow - 1) ).click();
                    break;
                }
            }
        }
        evidenceCollationPageObj.save().click();
    }

    public void enterThirdPartyContactDetails(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase( strNoValueEntryString ) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "name":
                    System.out.println( "Inside Name" );
                    this.enterName( searchValue );
                    break;
                case "title":
                    System.out.println( "Inside title" );
                    this.selectTitle( searchValue );
                    break;
                case "first name":
                    System.out.println( "Inside first Name" );
                    this.enterFirstName( searchValue );
                    break;
                case "last name":
                    System.out.println( "Inside Last Name" );
                    this.enterLastName( searchValue );
                    break;
                case "address":
                    System.out.println( "Inside address" );
                    this.enterAddress( searchValue );
                    break;
                case "preferred contact":
                    System.out.println( "Inside contact" );
                    this.selectContactMethod( searchValue );
                    break;
                case "email":
                    System.out.println( "Inside email" );
                    this.enterEmail( searchValue );
                    break;
                case "action":
                    System.out.println( "Inside save" );
                    evidenceCollationPageObj.contactDetails_Save();
                    evidenceCollationPageObj.contactDetails_Save().click();
                    break;
                case "contactfirstname":
                    evidenceCollationPageObj.contactFirstName().clear();
                    evidenceCollationPageObj.contactFirstName().sendKeys( searchValue );
                    break;
                case "contactlastname":
                    evidenceCollationPageObj.contactLastName().clear();
                    evidenceCollationPageObj.contactLastName().sendKeys( searchValue );
                    break;
            }
        }
    }

    public void enterName(String name) {
        evidenceCollationPageObj.name().clear();
        if (!name.equalsIgnoreCase( strNoValueEntryString ) && !name.isEmpty() && name != null) {
            evidenceCollationPageObj.name().sendKeys( name );
        }
    }

    public void selectTitle(String strTitle) {
        new Select( evidenceCollationPageObj.title() ).selectByVisibleText( strTitle );
    }

    public void enterFirstName(String firstName) {
        evidenceCollationPageObj.firstName().clear();
        if (!firstName.equalsIgnoreCase( strNoValueEntryString ) && !firstName.isEmpty() && firstName != null) {
            evidenceCollationPageObj.firstName().sendKeys( firstName );
        }
    }

    public void enterLastName(String LastName) {
        evidenceCollationPageObj.lastName().clear();
        if (!LastName.equalsIgnoreCase( strNoValueEntryString ) && !LastName.isEmpty() && LastName != null) {
            evidenceCollationPageObj.lastName().sendKeys( LastName );
        }
    }

    public void enterAddress(String address) {
        evidenceCollationPageObj.Address().clear();
        if (!address.equalsIgnoreCase( strNoValueEntryString ) && !address.isEmpty() && address != null) {
            evidenceCollationPageObj.Address().sendKeys( address );
        }
    }

    public void enterEmail(String strEmail) {
        evidenceCollationPageObj.email().clear();
        if (!strEmail.equalsIgnoreCase( strNoValueEntryString ) && !strEmail.isEmpty() && strEmail != null) {
            evidenceCollationPageObj.email().sendKeys( strEmail );
        }
    }

    public void selectContactMethod(String strTitle) {
        new Select( evidenceCollationPageObj.preferredContact() ).selectByVisibleText( strTitle );
    }

    public void validateRecoveryAmount() {
        claimsOperationsObj.selectFirstClaimInClaimTable();
        claimSummaryPageObj.financialTable();
        claimSummaryPageObj.financialTable().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
//        financialPageObj.retrieveTotalClaimValue();
        financialPageObj.retrieveApprovedReserve();
//        totalClaimValue = financialPageObj.retrieveTotalClaimValue().getText();
        totalReserveValue = financialPageObj.retrieveApprovedReserve().getText();
        System.out.println( "totalReserveValue" + totalReserveValue );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.recoveryTab();
        claimSummaryPageObj.recoveryTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        financialPageObj.retrieveEstimatedAmount();
        retrieveEstimatedAmount = financialPageObj.retrieveEstimatedAmount().getText();
        System.out.println( "Total Estimated Amount" + retrieveEstimatedAmount );
        financialPageObj.retrievePercentage();
        percentagecal = financialPageObj.retrievePercentage().getText();
        System.out.println( "Total Percentage" + percentagecal );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick( financialPageObj.closeWindow_FinancialTab() );
        System.out.println( "Total claim value to check" + totalReserveValue );
        String[] reserveamount = totalReserveValue.split( "\\." );
        System.out.println( "size of an array" + reserveamount.length );
        int ramount = Integer.parseInt( reserveamount[0] );
        System.out.println( "total approved reserve amount *******" + ramount );


        int percentage = Integer.parseInt( percentagecal );
        String cestamt[] = retrieveEstimatedAmount.split( "\\." );
        int estAmt = Integer.parseInt( cestamt[0] );
        int actualRecoveryAmt = (ramount * percentage / 100);
        if (estAmt == actualRecoveryAmt) {
            System.out.println( "Recovery Amount Validated" );
        }
        String recoveryAmount[] = financialPageObj.estRecoverAmt().getText().split( "\\." );
        Assert.assertTrue( cestamt[0].equalsIgnoreCase( recoveryAmount[0] ) );
        System.out.println( "Validated Estimation recovery Amount in the scheme summary page" );
    }

    public void validateRecoveryAmountInSchemeSummaryPageForMedicalExpenses(String estRecovery) {
        financialPageObj.estRecoverAmt();
        Assert.assertTrue( financialPageObj.estRecoverAmt().getText().equalsIgnoreCase( estRecovery ) );
        System.out.println( "Validated Estimation recovery Amount for the Medical expenses in the scheme summary page" );
    }

    public void enterAmount(String searchField, String searchValue) throws Throwable {
        recoveryOpportunitiesPageObj.amount();
        recoveryOpportunitiesPageObj.amount().sendKeys( Keys.chord( Keys.CONTROL, "a" ), searchValue );
    }

    public void enterPercentage(String searchField, String searchValue) throws Throwable {
        recoveryOpportunitiesPageObj.percentage();
        recoveryOpportunitiesPageObj.percentage().clear();
        recoveryOpportunitiesPageObj.percentage().sendKeys( searchValue );
    }

    public void enterOtherInsuranceDetails(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase( strNoValueEntryString ) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "insurance type":
                    System.out.println( "Inside Name" );
                    this.validateInsuranceType( searchValue );
                    break;
                case "yes/no":
                    System.out.println( "Inside title" );
                    this.selectInsurance( searchValue );
                    break;
                case "insurer":
                    System.out.println( "Inside first Name" );
                    this.selectInsurer( searchValue );
                    break;
                case "policy number":
                    System.out.println( "Inside Last Name" );
                    this.enterPolicyNumber( searchValue );
                    break;
                case "person":
                    System.out.println( "Inside address" );
                    this.selectPerson( searchValue );
                    break;
                case "action":
                    System.out.println( "Inside save" );
                    evidenceCollationPageObj.save1();
                    evidenceCollationPageObj.save1().click();
                    break;
            }
        }
    }

    public void validateInsuranceType(String type) {
        evidenceCollationPageObj.insurance_Type();
        if (!type.equalsIgnoreCase( strNoValueEntryString ) && !type.isEmpty() && type != null) {
            Assert.assertTrue( type.equalsIgnoreCase( evidenceCollationPageObj.insurance_Type().getText() ) );
            System.out.println( "Validated Insurance type" );
        }
    }

    public void selectInsurance(String text) {
        new Select( evidenceCollationPageObj.insurance_YesorNO() ).selectByVisibleText( text );
    }

    public void selectInsurer(String insurer) {
        new Select( evidenceCollationPageObj.selectInsurer() ).selectByVisibleText( insurer );
    }

    public void enterPolicyNumber(String number) {
        evidenceCollationPageObj.policyNumber().clear();
        if (!number.equalsIgnoreCase( strNoValueEntryString ) && !number.isEmpty() && number != null) {
            evidenceCollationPageObj.policyNumber().sendKeys( number );
        }
    }

    public void selectPerson(String person) {
        new Select( evidenceCollationPageObj.selectPerson() ).selectByIndex( 0 );//selectByVisibleText(person);
    }

    public void validateRecoveryPercentage(String percentage) {
        claimsOperationsObj.selectFirstClaimInClaimTable();
        claimSummaryPageObj.recoveryTab();
        claimSummaryPageObj.recoveryTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println( "Verified Other Insurance" + claimSummaryPageObj.recoveryOppurtunity_OtherInsurance().getText() );
        Assert.assertTrue( percentage.equalsIgnoreCase( claimSummaryPageObj.recoveryOppurtunity_OtherInsurance().getText() ) );
        System.out.println( "Verified Third Party" + claimSummaryPageObj.recoveryOppurtunity_ThirdParty().getText() );
        Assert.assertTrue( percentage.equalsIgnoreCase( claimSummaryPageObj.recoveryOppurtunity_ThirdParty().getText() ) );
    }

    public void selectStatus(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase( strNoValueEntryString ) && !searchValue.isEmpty() && searchValue != null) {
            switch (searchField.toLowerCase()) {
                case "status":
                    this.selectStatusInRecoveriesTab( searchValue );
                    break;
                case "amount":
                    this.enterAmount( searchValue );
                    break;
                case "new action":
                    this.selectAction( searchValue );
                    break;
            }
        }
    }

    public void selectStatusInRecoveriesTab(String status) {
        new Select( evidenceCollationPageObj.changeStatus() ).selectByVisibleText( status );
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void enterAmount(String amount) {
        evidenceCollationPageObj.paidAmount().clear();
        if (!amount.equalsIgnoreCase( strNoValueEntryString ) && !amount.isEmpty() && amount != null) {
            evidenceCollationPageObj.paidAmount().sendKeys( amount );
        }
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void selectAction(String action) {
        new Select( evidenceCollationPageObj.selectAction() ).selectByVisibleText( action );
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateStatusInRecoveries() {
        claimsOperationsObj.selectFirstClaimInClaimTable();
        claimSummaryPageObj.recoveryTab();
        claimSummaryPageObj.recoveryTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println( "Satus in Recoveries tab" + claimSummaryPageObj.recoveryStatus().getText() );
        claimSummaryPageObj.recoveryStatus();
        Assert.assertTrue( claimSummaryPageObj.recoveryStatus().getText().equalsIgnoreCase( "Confirmed" ) );
    }

    public void validateRecoveryListed(List<List<String>> inputValues) {
        String[] questions = inputValues.get( 0 ).get( 0 ).split( "#" );
        List<WebElement> table = (List<WebElement>) nextEventPageObj.findElements( By.xpath( recoveryOpportunitiesPageObj.recoveryListTable() ) );//getDriver().findElements(By.xpath(recoveryOpportunitiesPageObj.recoveryListTable()));
        System.out.println( "Question  size " + questions.length );
        System.out.println( "Table  size " + table.size() );
        for (int i = 0; i < questions.length; i++) {
            System.out.println( "i  size ------" + i );
            for (int j = 1; j < table.size(); j++) {
                System.out.println( "j  size ------" + j );
                System.out.println( "----Input questions----------- --" + questions[i] );
                System.out.println( "----Displayed Question-----------" + recoveryOpportunitiesPageObj.lblRecoveriesList( j ).getText() );
                if (questions[i].equalsIgnoreCase( recoveryOpportunitiesPageObj.lblRecoveriesList( j ).getText() )) {
                    Assert.assertEquals( questions[i], recoveryOpportunitiesPageObj.lblRecoveriesList( j ).getText() );
                    break;
                }
            }
        }
    }

    public void validateOtherInsurerListed(List<List<String>> inputValues) {
        if (inputValues.get( 0 ).get( 0 ).equalsIgnoreCase( "na" )) {
        } else {
            String[] questions = inputValues.get( 0 ).get( 0 ).split( "#" );
            List<WebElement> table = (List<WebElement>) nextEventPageObj.findElements( By.xpath( recoveryOpportunitiesPageObj.OtherInsurerTable() ) ); //getDriver().findElements(By.xpath("//h2[text()='Enter Other Insurers']/../div/div/table/tbody/tr/td[1]"));
            System.out.println( "Question  size " + questions.length );
            System.out.println( "Table  size " + table.size() );
            for (int i = 0; i < questions.length; i++) {
                System.out.println( "i  size ------" + i );
                for (int j = 1; j < table.size(); j++) {
                    System.out.println( "j  size ------" + j );
                    System.out.println( "----Input questions----------- --" + questions[i] );
                    System.out.println( "----Displayed Question-----------" + recoveryOpportunitiesPageObj.lblOtherInsurerList( j ).getText() );
                    if (questions[i].equalsIgnoreCase( recoveryOpportunitiesPageObj.lblOtherInsurerList( j ).getText() )) {
                        Assert.assertEquals( questions[i], recoveryOpportunitiesPageObj.lblOtherInsurerList( j ).getText() );
                        break;
                    }
                }
            }
        }
    }

    public void allocateRecovery(String action, String team) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        navigationObj.navigateToImenu();
        navigationObj.navigateToIAdmin();
        nextEventPageObj.btnClick( recoveryOpportunitiesPageObj.recoveryTab() );
        nextEventPageObj.btnClick( recoveryOpportunitiesPageObj.recoveryTasksTab() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println( "Claim ID retrieved" + claimsOperationsObj.claimID );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        try {
            Thread.sleep(30000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
        recoveryOpportunitiesPageObj.claimIDInputbox().clear();
        recoveryOpportunitiesPageObj.claimIDInputbox().sendKeys( claimsOperationsObj.claimID );
        recoveryOpportunitiesPageObj.claimIDInputboxFilter().click();
        recoveryOpportunitiesPageObj.equalToFilter().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        recoveryOpportunitiesPageObj.assign( claimsOperationsObj.claimID ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        recoveryOpportunitiesPageObj.assignToTeam( team, action ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("recoveryOpportunitiesPageObj.validateAllocation( claimsOperationsObj.claimID ).getText()----------"+recoveryOpportunitiesPageObj.validateAllocation( claimsOperationsObj.claimID ).getText());
        System.out.println("team------------------"+team);
        Assert.assertTrue( recoveryOpportunitiesPageObj.validateAllocation( claimsOperationsObj.claimID ).getText().equalsIgnoreCase( team ) );
    }

    public void validateRecoveryAmountPaid(String paidAmount, String estimatedAmount) {
        claimsOperationsObj.selectFirstClaimInClaimTable();
        claimSummaryPageObj.recoveryTab();
        claimSummaryPageObj.recoveryTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
//        TODO added for validating multiple items
        String pAmount[] = paidAmount.split( "#" );
        List<WebElement> searchResults = nextEventPageObj.findElements(By.xpath(claimSummaryPageObj.recoveryAmountPaidInTP()));
        List<WebElement> searchResultsEstimated = nextEventPageObj.findElements(By.xpath(claimSummaryPageObj.recoveryAmountEstimatedInTP()));
        System.out.println( "Paid " + searchResults );
        System.out.println( "Estimated " + searchResultsEstimated );
        for(int i=0;i<searchResults.size();i++){
            System.out.println("Status in Amount paid Recoveries" + claimSummaryPageObj.recoveryAmountPaidInTPList(i+1).getText());
            Assert.assertTrue(claimSummaryPageObj.recoveryAmountPaidInTPList(i+1).getText().equalsIgnoreCase(pAmount[i]));
            System.out.println("Status in Estimated Recoveries" + claimSummaryPageObj.recoveryAmountEstimatedInTPList(i+1).getText());
            Assert.assertTrue(claimSummaryPageObj.recoveryAmountEstimatedInTPList(i+1).getText().equalsIgnoreCase(estimatedAmount));
        }
        claimSummaryPageObj.saveAndCloseBtn().click();
    }

    public void enterDWPDetails(List<List<String>> parameters) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        nextEventPageObj.waitForPageLoad();
        for (int i = 1; i < parameters.size(); i++)
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                String fieldName = parameters.get( 0 ).get( j );
                String fieldValue = parameters.get( i ).get( j );
                switch (fieldName) {
                    case "Patients Full Name & Date of Birth":
                        System.out.println( "Field name is-----" + fieldName );
                        System.out.println( "Field value is-----" + fieldValue );
                        claimSummaryPageObj.txtPatientDetails( fieldName ).sendKeys( fieldValue );
                        break;
                    case "Overall amount":
                        System.out.println( "Field name is-----" + fieldName );
                        System.out.println( "Field value is-----" + fieldValue );
                        claimSummaryPageObj.txtPatientDetails( fieldName ).sendKeys( fieldValue );
                        break;
                    case "Number of patient":
                        System.out.println( "Field name is-----" + fieldName );
                        System.out.println( "Field value is-----" + fieldValue );
                        claimSummaryPageObj.txtPatientDetails( fieldName ).sendKeys( fieldValue );
                        break;
                    case "Parents Date of Birth":
                        System.out.println( "Field name is-----" + fieldName );
                        System.out.println( "Field value is-----" + fieldValue );
                        claimSummaryPageObj.txtPatientDetails( fieldName ).sendKeys( fieldValue );
                        break;
                    case "Patients Nationality":
                        System.out.println( "Field name is-----" + fieldName );
                        System.out.println( "Field value is-----" + fieldValue );
                        claimSummaryPageObj.txtPatientDetails( fieldName ).sendKeys( fieldValue );
                        break;
                    case "Patients UK Address":
                        System.out.println( "Field name is-----" + fieldName );
                        System.out.println( "Field value is-----" + fieldValue );
                        claimSummaryPageObj.txtPatientUKAddress().sendKeys( fieldValue );
                        break;
                }
            }
        nextEventPageObj.btnClick( nextEventPageObj.saveBtn() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateRecoveryEstimatedAmountPaid(String paidAmount, String estimatedAmount) throws InterruptedException {
        claimsOperationsObj.selectFirstClaimInClaimTable();
        claimSummaryPageObj.recoveryTab();
        claimSummaryPageObj.recoveryTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Thread.sleep( 10000 );
        String searchResults = nextEventPageObj.findElement( By.xpath( claimSummaryPageObj.recoveryAmountPaidInTP() ) ).getText();
        String searchResultsEstimated = nextEventPageObj.findElement( By.xpath( claimSummaryPageObj.recoveryAmountEstimatedInTP() ) ).getText();
        System.out.println( "Paid " + searchResults );
        System.out.println( "Estimated " + searchResultsEstimated );
        Assert.assertTrue( searchResults.equalsIgnoreCase( paidAmount) );
        System.out.println( "Paid amount is correct after asserstion" );
        Assert.assertTrue( searchResultsEstimated.equalsIgnoreCase( estimatedAmount ) );
        System.out.println( "Estimated amount is correct after asserstion" );
        claimSummaryPageObj.saveAndCloseBtn().click();
    }
}

