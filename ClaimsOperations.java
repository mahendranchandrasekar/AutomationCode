package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.*;
import com.usmanhussain.habanero.framework.WebDriverDiscovery;
import cucumber.api.PendingException;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import static co.uk.directlinegroup.tt.utils.PolicyOperations.*;
import static co.uk.directlinegroup.tt.utils.QuoteAndBuyOperations.paymentAmount;
import static com.usmanhussain.habanero.framework.AbstractPage.getDriver;

//import com.usmanhussain.framework.WebDriverDiscovery;

public class ClaimsOperations extends WebDriverDiscovery {


    private AccountInformationPage accountInformationPageObj = new AccountInformationPage();
    private TMADetailsPage tmaDetailsPageObj = new TMADetailsPage();
    private SearchPage searchPageObj = new SearchPage();
    private BasicClaimDetailsPage basicClaimDetailsPageObj = new BasicClaimDetailsPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private ClaimSummaryPage claimSummObj = new ClaimSummaryPage();
    private User userObj = new User();
    private StringOperations stringOperationsObj = new StringOperations();
    private DateOperations dateOperationsObj = new DateOperations();
    private PerilsAndCostsPage perilsAndCostsPageObj = new PerilsAndCostsPage();
    private EvidenceCollationPage evidenceCollationPageObj = new EvidenceCollationPage();
    private FileOperations fileOperationsObj = new FileOperations();
    private WebTable webTableObj = new WebTable();
    private OtherInsurerPage otherInsurerPageObj = new OtherInsurerPage();
    private ClaimsRepudiationPage claimsRepudiationPageObj = new ClaimsRepudiationPage();
    private IncidentsPage incidentsPageObj = new IncidentsPage();
    private FinancialPage financialPageObj = new FinancialPage();
    private ThirdPartyAtFaultPage thirdPartyAtFaultPageObj = new ThirdPartyAtFaultPage();
    private PerilQuestionsPage perilQuestionsPageObj = new PerilQuestionsPage();
    private BasicClaimDetailsPage basicClaimDetObj = new BasicClaimDetailsPage();
    private ClaimCalculationPage claimCalculationPageObj = new ClaimCalculationPage();
    private ClaimPaymentPage claimPaymentPageObj = new ClaimPaymentPage();
    private MontrealConventionPage montrealConventionPageObj = new MontrealConventionPage();
    private DWPDetailsPage dwpDetailsPageObj = new DWPDetailsPage();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private co.uk.directlinegroup.tt.utils.Navigation navigationObj = new co.uk.directlinegroup.tt.utils.Navigation();
    public FullEventHistoryPage fullEventHistoryPageObj = new FullEventHistoryPage();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private PolicySummaryPage policySummaryPageObj = new PolicySummaryPage();
    private LeftNavPanePage leftNavPanePageObj = new LeftNavPanePage();
    private CompetencyOperations competencyOperationsObj = new CompetencyOperations();
    private SupplierDetailsPage supplierDetailsPageObj = new SupplierDetailsPage();
    private Commands commandsObj = new Commands();
    private co.uk.directlinegroup.tt.utils.common.Select selectObj = new co.uk.directlinegroup.tt.utils.common.Select();
    private CustomerPortalMyClaimsPage customerPortalMyClaimsPageObj = new CustomerPortalMyClaimsPage();
    private CustomerDetailsFieldPage customerDetailsFieldPageObj = new CustomerDetailsFieldPage();
    private ClaimCompetencyPage claimCompetencyPageObj = new ClaimCompetencyPage();
    private SetUpPage setUpPageObj = new SetUpPage();
    private RulesEngineOperation rulesEngineOperationsObj = new RulesEngineOperation();
    private ManageWorkflowTaskPage manageWorkflowTaskPageObj = new ManageWorkflowTaskPage();
    private SchemeSummaryPage schemeSummaryPageObj = new SchemeSummaryPage();
    private CustomerPortalPerilQuesPage customerPortalPerilQuesPageObj = new CustomerPortalPerilQuesPage();
    private RandomGenerator randomGeneratorObj = new RandomGenerator();

    String claimExcess = "";
    String paymentTRID = "";
    String sysDate = "";
    String supplierRequestType = "";
    private static String escalationReason = "Cannot complete, further info needed";
    public static String claimHandler = "";
    public static String claimID = "";
    public static String maxAmount_PolicyLimits = "";
    public static String excessAmount_policy = "";
    public static String claimcaseid = "";
    public static String likeLihoodofSuccess = "";
    public static String getclaimItemID = "";
    public static String getclaimID = "";
    public static String leadid = "";
    public static String claimassignee = "";
    public static String calimcaseid = "";
    private static String strNoValueEntryString = "Nothing Entered";
    public String strSearchCondition = "";
    public String strEventType_Reopen = "OOP Re-Open Claim";
    public String strEventType = "OOP Close Claim";
    public String strEventType_Reopen_Line = "OOP Re-Open Line Item(s)";
    public String tableRowID = "";
    public String tmaCaseID = "";
    public static String leadID = "";
    public static String nonICUPPD = "";
    public static String ICUPPD = "";
    public static String outpatientPPD = "";
    public static String publicHospPPD = "";
    public static String icuDays = "";
    public static String nonicuDays = "";
    public static String outPatientDays = "";
    public static String publicHospitalDays = "";
    public static String limitValue = "";
    public static String excessValue = "";
    public static String claimItemId = "";
    public static String country = "";
    public static String claimItemId1 = "";
    public static String claimItemId2 = "";
    public static String caseid = "";
    public static String txt1Provided = "";
    public static String txt2Provided = "";
    public static String txt3NotRequired = "";
    public static String txt4NotRequired = "";
    public static String txt5NotRequired = "";
    public static String submittedEvidence1 = "";
    public static String submittedEvidence2 = "";
    public static String notSubmittedEvidence1 = "";
    public static String notSubmittedEvidence2 = "";
    public static String notSubmittedEvidence3 = "";
    public static String claimIDVerificationInCutomerPortal = "";
    public static String addedPerson = "";
    public static String caseID = "";
    public static String slaForProcess = "";
    public static String timeRemainingForProcess = "";
    public static String tripBookedValidationDate = "";
    public static String tripFromDateValidationDate = "";
    public static String tripToDateValidationDate = "";
    public static String subcausecodestring = "";
    public static String portalURL = "";
    public static String customerName = "";
    public static String customerLastName = "";
    public static String customerDOB = "";
    public static String countryOfLoss = "";
    public static String retrieveRandomSupplierName = "";
    public static String claimDate = "";
    public static String configSupplierType = "";
    public static String configCompanyName = "";
    public static String personType = "";
    public static String airlinesName = "";
    public static String claimAmount = "";
    public static String partialItemsAmount = "";
    public static String TMAClaimId = "";
    public static String retrievedTMAClaimId = "";
    public double tempAmount = 0;
    public static String claimHandlerName = "";
    public static String claimHandlerNameReassigned = "";

    public void navigateToClaimViewFromPolicyView() {
        searchPageObj.switchToLastOpenWindow();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        try {
            Thread.sleep( 10000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (commandsObj.elementDisplayedWithLessTime( By.xpath( accountInformationPageObj.moreLinkValidation() ) )) {
            System.out.println( "Inside more link" );
            accountInformationPageObj.btnClick( accountInformationPageObj.moreLink() );
        }
        try {
            Thread.sleep( 10000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void navigateToPolicyViewFromClaimView() {
        searchPageObj.switchToLastOpenWindow();
        accountInformationPageObj.btnClick( policySummaryPageObj.lnkPolicyView() );
    }

    public void startNewClaim() throws InterruptedException {
        claimSummObj.btnClick( claimSummObj.newClaim() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick( nextEventPageObj.go() );
    }

    public void validateBasicClaimDetailsFields() {
        System.out.println( "Enter validateBasicClaimDetailsFields Func" );
        basicClaimDetObj.getFirstOpenClaim().click();
        Assert.assertTrue( basicClaimDetailsPageObj.tripDestination().isDisplayed() );    //Country of Loss
        this.validateTripDestinationDrpDwnValuesInAlphabeticalOrder();
        System.out.println( "After validateTripDestinationDrpDwnValuesInAlphabeticalOrder" );
        Assert.assertTrue( basicClaimDetailsPageObj.tripBooked().isDisplayed() );
        Assert.assertTrue( basicClaimDetailsPageObj.tripFromDate().isDisplayed() );
        Assert.assertTrue( basicClaimDetailsPageObj.editDateOfLoss().isDisplayed() );            //Date of Loss
        Assert.assertTrue( basicClaimDetailsPageObj.description().isDisplayed() );
    }

    public void tripBookedDate(String strTripDate) {
        basicClaimDetailsPageObj.tripBooked().clear();
        if (!strTripDate.equalsIgnoreCase( strNoValueEntryString ) && !strTripDate.isEmpty() && strTripDate != null) {
            basicClaimDetailsPageObj.tripBooked().sendKeys( strTripDate );
        }
    }

    public void tripFromDate(String strTripFromDate) {
        basicClaimDetailsPageObj.tripFromDate().clear();
        if (!strTripFromDate.equalsIgnoreCase( strNoValueEntryString ) && !strTripFromDate.isEmpty() && strTripFromDate != null) {
            basicClaimDetailsPageObj.tripFromDate().sendKeys( strTripFromDate );
        }
    }

    public void tripToDate(String strTripToDate) {
        basicClaimDetailsPageObj.tripToDate().clear();
        if (!strTripToDate.equalsIgnoreCase( strNoValueEntryString ) && !strTripToDate.isEmpty() && strTripToDate != null) {
            basicClaimDetailsPageObj.tripToDate().sendKeys( strTripToDate );
        }
    }

    public void tripDestination(String strTripDestination) {
        basicClaimDetailsPageObj.tripDestination().click();
        new Select( basicClaimDetailsPageObj.tripDestination() ).selectByVisibleText( strTripDestination );
    }

    public void tripDestinationNew1(String strTripDestination) {
        basicClaimDetailsPageObj.tripDestination2().click();
        new Select( basicClaimDetailsPageObj.tripDestination2() ).selectByVisibleText( strTripDestination );
    }

    public void tripDescription(String strTripDesc) {
        basicClaimDetailsPageObj.description().clear();
        if (!strTripDesc.equalsIgnoreCase( strNoValueEntryString ) && !strTripDesc.isEmpty() && strTripDesc != null) {
            basicClaimDetailsPageObj.description().sendKeys( strTripDesc );
        }
    }

    public void addPerson(String person) {
        if (person.equalsIgnoreCase( strNoValueEntryString ) || person.isEmpty() || person == null) {
            System.out.println( "Inside person if loop" );
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick( perilsAndCostsPageObj.claimAddPH() );
        }
    }

    public void selectThirdPartyInsurer(String strOption) {
        if (!strOption.equalsIgnoreCase( strNoValueEntryString ) && !strOption.isEmpty() && strOption != null) {
            commandsObj.waitForObject( basicClaimDetailsPageObj.selectThirdParty() );
            basicClaimDetailsPageObj.selectThirdParty().click();
            basicClaimDetailsPageObj.selectThirdPartyOption( strOption ).click();
        }
    }

    public void firstName(String firstName) {
        if (!firstName.equalsIgnoreCase( strNoValueEntryString ) && !firstName.isEmpty() && firstName == null) {
            nextEventPageObj.waitForMoreTime();
            perilsAndCostsPageObj.firstName().sendKeys( firstName );
        }
    }

    public void lastName(String lastName) {
        if (!lastName.equalsIgnoreCase( strNoValueEntryString ) && !lastName.isEmpty() && lastName == null) {
            nextEventPageObj.waitForMoreTime();
            perilsAndCostsPageObj.lastName().sendKeys( lastName );
        }
    }

    public void completeOtherInsurancePolicy(List<List<String>> lstOtherInsurerDetails) {
        int iOtherInsurerDetailsIndexInTable = 0;
        int iInsuranceTypeIndex = 0;
        int iYesNoIndex = 0;
        int iInsurerIndex = 0;
        int iPolicyNoIndex = 0;
        int iPersonIndex = 0;
        int i = 1;
        List<WebElement> lstRows = new ArrayList<WebElement>();
        for (int iRow = 1; iRow < lstOtherInsurerDetails.size(); iRow++) {
            iOtherInsurerDetailsIndexInTable = 0;
            for (int iCol = 0; iCol < lstOtherInsurerDetails.get( 0 ).size(); iCol++) {
                String strFieldName = lstOtherInsurerDetails.get( 0 ).get( iCol );
                String strFieldValue = lstOtherInsurerDetails.get( iRow ).get( iCol );
                if (!strFieldValue.isEmpty()) {
                    switch (strFieldName.toLowerCase().trim()) {
                        case "otherinsurancetype":
                            if (!strFieldValue.equalsIgnoreCase( "No" )) {
                                lstRows = otherInsurerPageObj.otherInsuranceDetailsWebTable().findElements( By.tagName( "tr" ) );
                                iInsuranceTypeIndex = webTableObj.getColumnFromWebTable( otherInsurerPageObj.otherInsuranceDetailsWebTable(), "Insurance Type" );
                                iYesNoIndex = webTableObj.getColumnFromWebTable( otherInsurerPageObj.otherInsuranceDetailsWebTable(), "Yes / No" );
                                iInsurerIndex = webTableObj.getColumnFromWebTable( otherInsurerPageObj.otherInsuranceDetailsWebTable(), "Insurer" );
                                iPolicyNoIndex = webTableObj.getColumnFromWebTable( otherInsurerPageObj.otherInsuranceDetailsWebTable(), "Policy No." );
                                iPersonIndex = webTableObj.getColumnFromWebTable( otherInsurerPageObj.otherInsuranceDetailsWebTable(), "Person" );
                                for (i = 1; i < lstRows.size() - 1; i++) {
                                    List<WebElement> lstCols = lstRows.get( i ).findElements( By.tagName( "td" ) );
                                    System.out.println( "lstCols.get( iInsuranceTypeIndex ).getText()===" + lstCols.get( iInsuranceTypeIndex ).getText() );
                                    if (lstCols.get( iInsuranceTypeIndex ).getText().equalsIgnoreCase( strFieldValue )) {
                                        System.out.println( lstCols.get( iYesNoIndex ).findElement( By.tagName( "select" ) ) );
                                        new Select( lstCols.get( iYesNoIndex ).findElement( By.tagName( "select" ) ) ).selectByVisibleText( "Yes" );
                                        iOtherInsurerDetailsIndexInTable = i;
                                    }
                                }
                            }
                            else {
                                iOtherInsurerDetailsIndexInTable = 1;
                            }
                            break;
                        case "insurer":
                            lstRows = otherInsurerPageObj.otherInsuranceDetailsWebTable().findElements( By.tagName( "tr" ) );
                            WebElement wbEleInsurer = lstRows.get( iOtherInsurerDetailsIndexInTable ).findElements( By.tagName( "td" ) ).get( iInsurerIndex ).findElement( By.tagName( "select" ) );
                            new Select( wbEleInsurer ).selectByVisibleText( strFieldValue );
                            break;
                        case "policynumber":
                            lstRows = otherInsurerPageObj.otherInsuranceDetailsWebTable().findElements( By.tagName( "tr" ) );
                            WebElement wbElePolicyNo = lstRows.get( iOtherInsurerDetailsIndexInTable ).findElements( By.tagName( "td" ) ).get( iPolicyNoIndex ).findElement( By.tagName( "input" ) );
                            wbElePolicyNo.clear();
                            wbElePolicyNo.sendKeys( PolicyOperations.policyId );
                            break;
                        case "person":
                            lstRows = otherInsurerPageObj.otherInsuranceDetailsWebTable().findElements( By.tagName( "tr" ) );
                            WebElement wbElePerson = lstRows.get( iOtherInsurerDetailsIndexInTable ).findElements( By.tagName( "td" ) ).get( iInsurerIndex ).findElement( By.tagName( "select" ) );
                            new Select( wbElePerson ).selectByIndex( 0 );
                            break;
                        case "insurance type":
                            otherInsurerPageObj.otherInsurerQuestion( "Yes" ).click();
                            break;
                    }
                }
            }
        }
        if (iOtherInsurerDetailsIndexInTable != 0) {
            otherInsurerPageObj.btnClick( basicClaimDetailsPageObj.save() );
        }
        nextEventPageObj.btnClick( claimPaymentPageObj.save() );
    }

    public void captureIncidents(List<List<String>> lstIncidents, boolean bFindIndicator) {
        System.out.println( "Entering Func captureIncidents" );
        boolean bFound = false;
        WebDriverWait wait = new WebDriverWait( nextEventPageObj.getDriver, 60 );
        List<WebElement> lstRows = incidentsPageObj.incidentsWebTable().findElements( By.tagName( "tr" ) );
        int iNameIndex = webTableObj.getColumnFromWebTable( incidentsPageObj.incidentsWebTable(), "Name" );
        int iDescIndex = webTableObj.getColumnFromWebTable( incidentsPageObj.incidentsWebTable(), "Description" );
        int iDateIndex = webTableObj.getColumnFromWebTable( incidentsPageObj.incidentsWebTable(), "Date" );
        int iRelatedIndex = webTableObj.getColumnFromWebTable( incidentsPageObj.incidentsWebTable(), "Related?" );
        if (lstIncidents.get( 0 ).get( 0 ).equalsIgnoreCase( "Name" ) && lstIncidents.get( 1 ).get( 0 ).equalsIgnoreCase( "Default" )) {
            System.out.println( "inside default" );
            lstRows.get( 1 ).findElements( By.tagName( "td" ) ).get( iRelatedIndex ).findElement( By.xpath( "//input[@type='checkbox']" ) ).click();
        } else {
            for (int iRow = 1; iRow < lstIncidents.size(); iRow++) {
                bFound = false;
                String strExpName = lstIncidents.get( iRow ).get( 0 );
                String strExpDesc = lstIncidents.get( iRow ).get( 1 );
                String strExpDate = lstIncidents.get( iRow ).get( 2 );
                for (int i = 1; i < lstRows.size(); i++) {
                    String strActName = lstRows.get( i ).findElements( By.tagName( "td" ) ).get( iNameIndex ).getText();
                    String strActDesc = lstRows.get( i ).findElements( By.tagName( "td" ) ).get( iDescIndex ).getText();
                    String strActDate = lstRows.get( i ).findElements( By.tagName( "td" ) ).get( iDateIndex ).getText();
                    System.out.println( "rowID -strExpName - strActName====" + i + "-" + strExpName + "-" + strActName + "-" + strExpName.equalsIgnoreCase( strActName ) );
                    System.out.println( "rowID -strExpDesc - strActDesc====" + i + "-" + strExpDesc + "-" + strActDesc + "-" + strExpDesc.equalsIgnoreCase( strActDesc ) );
                    System.out.println( "rowID -strExpName - strActDate====" + i + "-" + strExpName + "-" + strActDate + "-" + strExpDate.equalsIgnoreCase( strActDate ) );
                    if (strExpName.equalsIgnoreCase( strActName ) && strExpDesc.equalsIgnoreCase( strActDesc ) && strExpDate.equalsIgnoreCase( strActDate )) {
                        incidentsPageObj.related( String.valueOf( i + 1 ) ).click();
                        bFound = true;
                        if (!bFindIndicator) {
                            System.out.println( "Incident capture=====Identified matching re" + strExpName );
                            Assert.assertTrue( false );
                        }
                        break;
                    }
                }
                if (bFindIndicator) {
                    if (!bFound) {
                        System.out.println( "Incident capture=====Not able to find the matching record" + strExpName );
                        Assert.assertTrue( bFound );
                    }
                } else if (!bFindIndicator) {
                    if (!bFound) {
                        System.out.println( "Incident capture=====Not able to find the matching record" + strExpName );
                        Assert.assertTrue( true );
                    }
                }
            }
        }
        basicClaimDetailsPageObj.save().click();
        System.out.println( "Exiting Func captureIncidents" );
    }

    public void validateEvidences(List<List<String>> evidences) {
        if (evidences.get( 0 ).get( 0 ).equalsIgnoreCase( "Evidence Provided" )) {
            for (int i = 1; i < evidences.size() - 1; i++) {
                String evidenceRequired = evidenceCollationPageObj.evidence( evidences.get( i ).get( 0 ) ).getText();
                evidenceCollationPageObj.evidence( evidences.get( i ).get( 0 ) ).isDisplayed();
                Assert.assertTrue( evidenceRequired.equalsIgnoreCase( evidences.get( i ).get( 0 ) ) );
                System.out.println( "Evidence is displayed---------" + evidenceRequired );
            }
        } else if (evidences.get( 0 ).get( 0 ).equalsIgnoreCase( "Evidence Provided should be clicked" )) {
            for (int i = 1; i < evidences.size() - 1; i++) {
                String evidenceRequired = evidenceCollationPageObj.evidence( evidences.get( i ).get( 0 ) ).getText();
                evidenceCollationPageObj.evidenceClick( evidences.get( i ).get( 0 ) ).click();
                System.out.println( "Evidence is clicked---------" + evidenceRequired );
            }
        }
    }

    public void captureEvidence(List<List<String>> lstEvidences) {
        List<WebElement> lstRows = evidenceCollationPageObj.evidenceCollationWebTable().findElements( By.tagName( "tr" ) );
        if (lstEvidences.get( 1 ).get( 0 ).equalsIgnoreCase( "Default" ) || lstEvidences.get( 1 ).get( 0 ).equalsIgnoreCase( "All" )) {
            for (int i = 1; i < lstRows.size() - 1; i++) { //Commented this line due to application UI change while selecting options for evidence provided
                WebElement wbEle = evidenceCollationPageObj.evidenceCollateRows( i );
                if (wbEle.getAttribute( "checked" ) == null) {
                    evidenceCollationPageObj.btnClick( evidenceCollationPageObj.evidenceCollateRows( i ) );
                }
            }
        } else if (lstEvidences.get( 1 ).get( 0 ).equalsIgnoreCase( "Partial" )) {
            evidenceCollationPageObj.evidenceCollateRows( 1 ).click();
        } else if (lstEvidences.get( 1 ).get( 0 ).equalsIgnoreCase( "Proof of Ownership" )) {
            for (int i = 1; i < lstRows.size() - 1; i++) { //Commented this line due to application UI change while selecting options for evidence provided
                WebElement wbEle = evidenceCollationPageObj.evidenceCollateRows( i );
                if (wbEle.getAttribute( "checked" ) == null) {
                    evidenceCollationPageObj.evidenceCollateRows( i ).click();

                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                }
            }
            evidenceCollationPageObj.evidenceNotProvided( lstEvidences.get( 1 ).get( 0 ) ).click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        } else if (lstEvidences.get( 1 ).get( 0 ).equalsIgnoreCase( "Proof of Expenses" )) {
            for (int i = 1; i < lstRows.size() - 1; i++) { //Commented this line due to application UI change while selecting options for evidence provided
                WebElement wbEle = evidenceCollationPageObj.evidenceCollateRows( i );
                if (wbEle.getAttribute( "checked" ) == null) {
                    evidenceCollationPageObj.evidenceCollateRows( i ).click();
                    commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_PleasewaitLocator(), 60L );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();

                }
            }
            evidenceCollationPageObj.evidenceNotProvided( lstEvidences.get( 1 ).get( 0 ) ).click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        } else if (lstEvidences.get( 1 ).get( 0 ).equalsIgnoreCase( "Loss Report (inc Police)" )) {
            for (int i = 1; i < lstRows.size() - 1; i++) { //Commented this line due to application UI change while selecting options for evidence provided
                WebElement wbEle = evidenceCollationPageObj.evidenceCollateRows( i );
                if (wbEle.getAttribute( "checked" ) == null) {
                    evidenceCollationPageObj.evidenceCollateRows( i ).click();
                    commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_PleasewaitLocator(), 60L );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                }
            }
            //TODO - Please add the btnUncheckLostReport() object
            evidenceCollationPageObj.evidenceNotProvided( lstEvidences.get( 1 ).get( 0 ) ).click();
            commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_PleasewaitLocator(), 60L );
            nextEventPageObj.waitForMoreTime();
        }
        if (lstEvidences.get( 1 ).get( 0 ).equalsIgnoreCase( "cancel" )) {
            nextEventPageObj.CancelBtn().click();
        } else {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick( evidenceCollationPageObj.save() );
            System.out.println( "Saving the Evidences" );
            System.out.println( "Saving the Evidences" );
        }
    }

    public void captureRepudiationWarnings(List<List<String>> lstRepudationDetails) {
        for (int iRow = 1; iRow < lstRepudationDetails.size(); iRow++) {
            for (int iCol = 0; iCol < lstRepudationDetails.get( 0 ).size(); iCol++) {
                String strFieldName = lstRepudationDetails.get( 0 ).get( iCol );
                String strFieldValue = lstRepudationDetails.get( iRow ).get( iCol );
                if (!strFieldValue.isEmpty()) {
                    switch (strFieldName.toLowerCase().trim()) {
                        case "repudiateclaim":
                            claimsRepudiationPageObj.repudiateClaim().click();
                            claimsRepudiationPageObj.repudiateClaimOption( strFieldValue ).click();
                            break;
                        case "escalatetocomplaints":
                            break;
                        case "repudiatereason":
                            System.out.println( "Inside repudiate reasons" );
                            claimsRepudiationPageObj.ClaimReasonbtn().click();
                            nextEventPageObj.switchToFrameById( nextEventPageObj.claimreasonframe() );
                            claimsRepudiationPageObj.repudiateClaimSubReasonInput().clear();
                            claimsRepudiationPageObj.repudiateClaimSubReasonInput().sendKeys( strFieldValue );
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.btnClick( claimsRepudiationPageObj.repudiateClaimSubReasonInputFilter() );
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.btnClick( claimSummaryPageObj.containsFilter() );
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            claimsRepudiationPageObj.repudiateClaimReasonOption( strFieldValue ).click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            break;
                        case "repudiatenotes":
                            break;
                        case "resaonforrejectionofreservemovement":
                            break;
                        case "immediatesettlement":
                            System.out.println( "Inside Immediate settlement" );
                            nextEventPageObj.waitForMoreTime();
                            System.out.println( "-----------------------------------" + claimsRepudiationPageObj.immediateSettlement().isDisplayed() );
                            claimsRepudiationPageObj.immediateSettlement().click();
                            nextEventPageObj.waitForMoreTime();
                            System.out.println( "verify Immediate settlement:" + claimsRepudiationPageObj.immediateSettlementOption( strFieldValue ) );
                            claimsRepudiationPageObj.immediateSettlementOption( strFieldValue ).click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            break;
                        case "cancelrepudiate":
                            System.out.println( "Inside cancel repudiate" );
                            nextEventPageObj.CancelBtn();
                            nextEventPageObj.CancelBtn().click();
                            break;
                        case "free text box1":
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            claimsRepudiationPageObj.text_Repudiationbox1().sendKeys( strFieldValue );
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            break;
                        case "free text box2":
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            claimsRepudiationPageObj.text_Repudiationbox2().sendKeys( strFieldValue );
                            break;
                        case "action":
                            nextEventPageObj.waitForPageLoad();
                            System.out.println( "Switch to default" );
                            nextEventPageObj.switchToDefault();
                            nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                            nextEventPageObj.waitForMoreTime();
                            break;
                    }
                }
            }
        }
    }

    public void captureBasicClaimDataFields(String searchField, String searchValue) {
        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
        SimpleDateFormat df = new SimpleDateFormat( "dd MMM yyyy" );
        Calendar c = Calendar.getInstance();
        c.setTime( new Date() );
        String returnValue = null;
        String date = "";
        commandsObj.waitForLoad( getDriver() );
        if (!searchValue.equalsIgnoreCase( strNoValueEntryString ) && !searchValue.isEmpty() && searchValue != null) {
            System.out.println( "inside loop-----------------" );
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "tripdestination":
                    System.out.println( "inside switch-----------------" );
                    if (searchValue.equalsIgnoreCase( "rertievedTripDestination" )) {
                        System.out.println( "retrieved Destination" + rulesEngineOperationsObj.destinationRetrievedFromRulesEngine );
                        searchValue = rulesEngineOperationsObj.destinationRetrievedFromRulesEngine;
                    }
                    this.tripDestination( searchValue );
                    break;
                case "datetripbooked":
                    if (searchValue.equalsIgnoreCase( "today" )) {
                        c.add( Calendar.DATE, 0 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                    } else if (searchValue.equalsIgnoreCase( "validationDate" )) {
                        searchValue = tripBookedValidationDate;
                        System.out.println( "Checking the tripBookedValidationDate" + tripBookedValidationDate );
                    } else if (searchValue.equalsIgnoreCase( "currentdate-10" )) {
                        c.add( Calendar.DATE, -10 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                    } else if (searchValue.equalsIgnoreCase( "backdate5days" )) {
                        c.add( Calendar.DATE, -5 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                    } else if (searchValue.equalsIgnoreCase( "backdate3month" )) {
                        c.add( Calendar.MONTH, -3 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                    }
                    this.tripBookedDate( searchValue );
                    break;
                case "tripfromdate":
                    if (searchValue.equalsIgnoreCase( "today" )) {
                        c.add( Calendar.DATE, 0 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                    }
                    if (searchValue.equalsIgnoreCase( "nextday" )) {
                        c.add( Calendar.DATE, 1 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                    } else if (searchValue.equalsIgnoreCase( "currentdate-8" )) {
                        c.add( Calendar.DATE, -8 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                    } else if (searchValue.equalsIgnoreCase( "currentdate-5" )) {
                        c.add( Calendar.DATE, -5 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                    } else if (searchValue.equalsIgnoreCase( "validationDate" )) {
                        searchValue = tripBookedValidationDate;
                        System.out.println( "Checking the tripFromValidationDate" + tripFromDateValidationDate );
                    } else if (searchValue.equalsIgnoreCase( "futuredate10days" )) {
                        c.add( Calendar.DATE, 10 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "***** Date ***" + searchValue );
                    } else if (searchValue.equalsIgnoreCase( "backdate40days" )) {
                        c.add( Calendar.DATE, -40 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "***** Date ***" + searchValue );
                    }
                    this.tripFromDate( searchValue );
                    break;
                case "triptodate":
                    if (searchValue.equalsIgnoreCase( "futuredate90days" )) {
                        c.add( Calendar.DATE, 90 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "***** Date ***" + searchValue );
                    } else if (searchValue.equalsIgnoreCase( "futuredate10days" )) {
                        c.add( Calendar.DATE, 10 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "***** Date ***" + searchValue );
                    } else if (searchValue.equalsIgnoreCase( "futuredate30days" )) {
                        c.add( Calendar.DATE, 30 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "***** Date ***" + searchValue );
                    } else if (searchValue.equalsIgnoreCase( "currentdate-1" )) {
                        c.add( Calendar.DATE, -1 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                    } else if (searchValue.equalsIgnoreCase( "validationDate" )) {
                        searchValue = tripToDateValidationDate;
                        System.out.println( "Checking the tripToValidationDate" + tripToDateValidationDate );
                    } else if (searchValue.equalsIgnoreCase( "today" )) {
                        c.add( Calendar.DATE, 0 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                    } else if (searchValue.equalsIgnoreCase( "backdate30days" )) {
                        c.add( Calendar.DATE, -30 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                    } else if (searchValue.equalsIgnoreCase( "futuredate1days" )) {
                        c.add( Calendar.DATE, 1 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "***** Date ***" + searchValue );
                    } else if (searchValue.equalsIgnoreCase( "currentdate-7" )) {
                        c.add( Calendar.DATE, -7 );
                        date = sdf.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                    }
                    this.tripToDate( searchValue );
                    break;
                case "validatedatetripbooked":
                    if (searchValue.equalsIgnoreCase( "true" )) {
                        c.add( Calendar.DATE, 1 );
                        date = df.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                        tripBookedValidationDate = searchValue;
                    }
                    break;
                case "validatetripfromdate":
                    if (searchValue.equalsIgnoreCase( "true" )) {
                        c.add( Calendar.DATE, 1 );
                        date = df.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                        tripFromDateValidationDate = searchValue;
                    }
                    break;
                case "validatetriptodate":
                    if (searchValue.equalsIgnoreCase( "true" )) {
                        c.add( Calendar.DATE, -1 );
                        date = df.format( c.getTime() );
                        searchValue = date;
                        System.out.println( "calculated date" + searchValue );
                        tripToDateValidationDate = searchValue;
                    }
                    break;
                case "description":
                    this.tripDescription( searchValue );
                    break;
                case "correspondencedetails":
                    nextEventPageObj.waitForMoreTime();
                    basicClaimDetailsPageObj.requestForCorrespondenceDetails().click();
                    break;
                case "thirdparty":
                    System.out.println( "Inside third party" );
                    this.selectThirdPartyInsurer( searchValue );
                    basicClaimDetObj.save().click();
                    commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_PleasewaitLocator(), 60L );
                    break;
                case "request for advice":
                    basicClaimDetailsPageObj.requestForAdviceDropDownImg().click();
                    basicClaimDetailsPageObj.requestForAdviceDropDownValue( searchValue ).click();
                    break;
                case "validateerrormessage":
                    if (searchValue.equalsIgnoreCase( "true" )) {
                        Assert.assertTrue( basicClaimDetailsPageObj.validateErrorMessage().isDisplayed() );
                        nextEventPageObj.CancelBtn().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                    }
                    break;
                case "reference number":
                    System.out.println( "Inside reference number" );
                    basicClaimDetObj.thirdPartyReferenceNumber().sendKeys( searchValue );
                    break;
                case "supplier":
                    System.out.println( "Inside supplier" );
                    this.enterSupplierDetail( searchValue );
                    nextEventPageObj.switchToDefault();
                    nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                    nextEventPageObj.saveBtn().click();
                    break;
                case "thirdpartyflag":
                    System.out.println( "flag----value----------" );
                    this.verifyThirdPartyFlag( searchValue );
                    break;
                case "basicclaimtype":
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    this.selectClaimType( searchValue );
                    break;
                case "expectedbehaviour":
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    basicClaimDetailsPageObj.editSave().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    try {
                        if (basicClaimDetailsPageObj.progressWindow() != null && basicClaimDetailsPageObj.progressWindow().get( 0 ).isDisplayed()) {
                            WebDriverWait wait = new WebDriverWait( nextEventPageObj.getDriver, 60 );
                            wait.until( ExpectedConditions.visibilityOf( basicClaimDetailsPageObj.progressWindow().get( 0 ) ) );
                            wait.until( ExpectedConditions.invisibilityOf( basicClaimDetailsPageObj.progressWindow().get( 0 ) ) );
                        }
                    } catch (Exception ex) {
                        System.out.println( "progressWindow  Not found" );
                        ex.printStackTrace();
                    }
                    if (searchValue.equalsIgnoreCase( "success" )) {
                        Assert.assertTrue( basicClaimDetailsPageObj.errorMessage().getText().equalsIgnoreCase( "Your update has been processed successfully." ) );
                    } else {
                        Assert.assertFalse( basicClaimDetailsPageObj.errorMessage().getText().equalsIgnoreCase( "Your update has been processed successfully." ) );
                    }
                    break;
                case "validatetripfrom":
                    if (searchValue.equalsIgnoreCase( "currentdate" )) {
                        DateFormat dateFormat = new SimpleDateFormat( "dd MMM yyyy" );
                        Date newdate = new Date();
                        String strDate = dateFormat.format( newdate );
                        System.out.println( "System date:" + strDate );
                        System.out.println( "inside switch-----------------" );
                        System.out.println( "Entered value is----" + basicClaimDetailsPageObj.tripFromDate().getAttribute( "value" ) );
                        String fromDate = basicClaimDetailsPageObj.tripFromDate().getAttribute( "value" ).split( "," )[1].trim();
                        Assert.assertTrue( fromDate.equals( strDate ) );
                        System.out.println( "Trip from date is validated" );
                    }
                    break;
                case "validatedescription":
                    System.out.println( "inside switch-----------------" );
                    System.out.println( "Entered value is----" + basicClaimDetailsPageObj.description().getAttribute( "value" ) );
                    Assert.assertTrue( basicClaimDetailsPageObj.description().getAttribute( "value" ).equalsIgnoreCase( searchValue ) );
                    System.out.println( "Description is validated" );
                    break;
                case "validatetripto":
                    if (searchValue.equalsIgnoreCase( "futuredate22days" )) {
                        c.add( Calendar.DATE, 22 );
                        date = df.format( c.getTime() );
                        returnValue = date;
                        System.out.println( "***** Date ***" + returnValue );
                        System.out.println( "inside switch-----------------" );
                        System.out.println( "Entered  value is----" + basicClaimDetailsPageObj.tripToDate().getAttribute( "value" ) );
                        String toDate = basicClaimDetailsPageObj.tripToDate().getAttribute( "value" ).split( "," )[1].trim();
                        Assert.assertTrue( returnValue.equals( toDate ) );
                        System.out.println( "Trip to date is validated" );
                    }
                    break;
                case "validatetripbooked":
                    if (searchValue.equalsIgnoreCase( "backdate5days" )) {
                        c.add( Calendar.DATE, -5 );
                        date = df.format( c.getTime() );
                        returnValue = date;
                        System.out.println( "***** Date ***" + returnValue );
                        System.out.println( "inside switch-----------------" );
                        System.out.println( "Entered value is----" + basicClaimDetailsPageObj.tripBooked().getAttribute( "value" ) );
                        String bookedDate = basicClaimDetailsPageObj.tripBooked().getAttribute( "value" ).split( "," )[1].trim();
                        System.out.println( "Splitted date is -----" + basicClaimDetailsPageObj.tripBooked().getAttribute( "value" ).split( "," )[1].trim() );
                        Assert.assertTrue( returnValue.equals( bookedDate ) );
                        System.out.println( "Trip booked date is validated" );
                    }
                    break;
                case "action":
                    if (searchValue.equalsIgnoreCase( "close" )) {
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                        nextEventPageObj.fancyboxClose().click();
                    }
                    break;
                case "tripbookeddate":
                    if (searchValue.equalsIgnoreCase( "past33days" )) {
                        c.add( Calendar.DATE, -33 );
                        date = df.format( c.getTime() );
                        returnValue = date;
                        System.out.println( "***** Date ***" + returnValue );
                        this.tripBookedDate( returnValue );
                    } else if (searchValue.equalsIgnoreCase( "past92days" )) {
                        c.add( Calendar.DATE, -92 );
                        date = df.format( c.getTime() );
                        returnValue = date;
                        System.out.println( "***** Date ***" + returnValue );
                        this.tripBookedDate( returnValue );
                    } else if (searchValue.equalsIgnoreCase( "past24days" )) {
                        c.add( Calendar.DATE, -24 );
                        date = df.format( c.getTime() );
                        returnValue = date;
                        System.out.println( "***** Date ***" + returnValue );
                        this.tripBookedDate( returnValue );
                    } else {
                        this.tripBookedDate( returnValue );
                    }
                    break;
                case "trip-from date":
                    if (searchValue.equalsIgnoreCase( "past32days" )) {
                        c.add( Calendar.DATE, -32 );
                        date = df.format( c.getTime() );
                        returnValue = date;
                        System.out.println( "***** Date ***" + returnValue );
                        this.tripFromDate( returnValue );
                    } else if (searchValue.equalsIgnoreCase( "past91days" )) {
                        c.add( Calendar.DATE, -91 );
                        date = df.format( c.getTime() );
                        returnValue = date;
                        System.out.println( "***** Date ***" + returnValue );
                        this.tripFromDate( returnValue );
                    } else if (searchValue.equalsIgnoreCase( "past23days" )) {
                        c.add( Calendar.DATE, -23 );
                        date = df.format( c.getTime() );
                        returnValue = date;
                        System.out.println( "***** Date ***" + returnValue );
                        this.tripFromDate( returnValue );
                    } else {
                        this.tripFromDate( returnValue );
                    }
                    break;
                case "trip-to date":
                    if (searchValue.equalsIgnoreCase( "past1day" )) {
                        c.add( Calendar.DATE, -1 );
                        date = df.format( c.getTime() );
                        returnValue = date;
                        System.out.println( "***** Date ***" + returnValue );
                        System.out.println( "Past 1 days is----" + returnValue );
                        this.tripToDate( returnValue );
                    } else {
                        this.tripToDate( returnValue );
                    }
                    break;
                case "thirdparty_repudiation":
                    System.out.println( "Inside third party" );
                    this.selectThirdPartyInsurer( searchValue );
                    nextEventPageObj.waitForMoreTime();
                    break;
                case "editdateofloss":
                    System.out.print( "Inside editdateofloss" + searchValue );
                    this.editDateOfLoss( searchValue );
                    break;
            }
        }
    }

    private void selectClaimType(String searchValue) {
        basicClaimDetailsPageObj.selectClaimType().click();
        basicClaimDetailsPageObj.claimTypeOption( searchValue ).click();
    }

    private void verifyThirdPartyFlag(String searchValue) {
        if (!searchValue.equalsIgnoreCase( strNoValueEntryString ) && !searchValue.isEmpty() && searchValue != null) {
            basicClaimDetailsPageObj.selectThirdParty().click();
            for (int i = 0; i < searchValue.split( "#" ).length; i++) {
                Assert.assertTrue( basicClaimDetailsPageObj.selectThirdPartyOption( searchValue.split( "#" )[i] ).isDisplayed() );
            }
        }
    }

    public void captureBasicClaimDataFieldsForReserve(String searchField, String searchValue) {
        if (!searchValue.equalsIgnoreCase( strNoValueEntryString ) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "user":
                    break;
                case "action":
                    break;
                case "claimtype":
                    break;
                case "changes":
                    break;
                case "tripdestination":    //Destination
                    this.tripDestinationNew1( searchValue );
                    break;
                case "tripbooked":
                    this.tripBookedDate( searchValue );
                    break;
                case "tripfrom":
                    this.tripFromDate( searchValue );
                    break;
                case "dateofloss":
                    //this.tripDateOfLoss(searchValue);
                    break;
                case "tripto":
                    this.tripToDate( searchValue );
                    break;
                case "description":
                    this.tripDescription( searchValue );
                    break;
                case "otherinsurancepolicy":
                    break;
                case "totalreserveamount":
                    this.captureReserveAmount( searchValue );
                    break;
                case "expectedbehaviour":
                    break;
                case "policytype":
                    break;
                case "insurername":
                    break;
                case "otherpolicyno":
                    break;

            }

        }
    }

    public void validateTripDestinationDrpDwnValuesInAlphabeticalOrder() {
        System.out.println( "Entering validateTripDestinationDrpDwnValuesInAlphabeticalOrder func" );
        basicClaimDetailsPageObj.tripDestination().click();
        List<WebElement> drpValue = basicClaimDetailsPageObj.findElements( By.xpath( basicClaimDetailsPageObj.tripDestinationDropDownDivXPath() ) );
        List<String> lstDrpDwnValue = new ArrayList<String>();
        int drpValueCount = drpValue.size();
        for (int i = 2; i <= drpValueCount; i++) {
            System.out.println( "value passed:: " + basicClaimDetailsPageObj.tripDestDrpDwnList( i ).getText() );
            lstDrpDwnValue.add( basicClaimDetailsPageObj.tripDestDrpDwnList( i ).getText() );
        }
        Assert.assertTrue( stringOperationsObj.validateStringIsInAlphabeticalOrder( lstDrpDwnValue ) );
        System.out.println( "Exiting validateTripDestinationDrpDwnValuesInAlphabeticalOrder func" );
    }

    public void createClaimForReserve(String strExpBeh, List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get( 0 ).size(); column++) {
                this.captureBasicClaimDataFieldsForReserve( parameters.get( 0 ).get( column ), parameters.get( row ).get( column ) );
            }
        }
    }

    public void createEditClaimsForReserveAmount(String strExpBeh, List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get( 0 ).size(); column++) {
                this.captureBasicClaimDataFieldsForReserve( parameters.get( 0 ).get( column ), parameters.get( row ).get( column ) );
            }
        }
    }

    public void createEditClaims(String strExpBeh, List<List<String>> parameters) {
        int iSize = 2;
        if (parameters.size() != 0) {
            if (strExpBeh.equalsIgnoreCase( "Expected" )) {
                iSize = parameters.size();
            } else {
                iSize = 2;
            }
            for (int row = 1; row < iSize; row++) {
                for (int column = 0; column < parameters.get( 0 ).size(); column++) {
                    this.captureBasicClaimDataFields( parameters.get( 0 ).get( column ), parameters.get( row ).get( column ) );
                }
            }
        }
    }

    public void captureReserveAmount(String strAmount) {
        basicClaimDetailsPageObj.reserveAmount().clear();
        if (!strAmount.equalsIgnoreCase( strNoValueEntryString ) && !strAmount.isEmpty() && strAmount != null) {
            basicClaimDetailsPageObj.reserveAmount().sendKeys( strAmount );
        }
    }

    public void validateClaimCause(String clmCause, String andSave, List<List<String>> parameters) {
        System.out.println( "inside validate claim cause" );
        commandsObj.waitForLoad( getDriver() );
        int iSize = 2;
        if (clmCause.contains( "Cause" )) {
            iSize = parameters.size();
        } else {
            iSize = 2;
        }
        for (int row = 1; row < iSize; row++) {
            for (int column = 0; column < parameters.get( 0 ).size(); column++) {
                this.validateClaimCauseAndComments( parameters.get( 0 ).get( column ), parameters.get( row ).get( column ) );
            }
        }
    }

    public void validateMandatoryFields(String searchField, String searchValue) {
        nextEventPageObj.waitForMoreTime();
        try {
            switch (searchField.toLowerCase()) {
                case "reported lost":
                    new Select( perilQuestionsPageObj.reportedLost() ).selectByVisibleText( searchValue );
                    break;
                case "reports produced":
                    new Select( perilQuestionsPageObj.reportsProduced() ).selectByVisibleText( searchValue );
                    break;
                case "loss report available":
                    new Select( perilQuestionsPageObj.lossReportAvailable() ).selectByVisibleText( searchValue );
                    break;
                case "who reported to":
                    new Select( perilQuestionsPageObj.whoReportedTo() ).selectByVisibleText( searchValue );
                    break;
                case "proof of ownership":
                    new Select( perilQuestionsPageObj.proofOfOwnership() ).selectByVisibleText( searchValue );
                    break;
                case "date reported":
                    perilQuestionsPageObj.dateReported().clear();
                    perilQuestionsPageObj.dateReported().sendKeys( searchValue );
                    nextEventPageObj.waitForMoreTime();
                    break;
                case "affected person":
                    new Select( perilQuestionsPageObj.affectedPerson() ).selectByVisibleText( searchValue );
                    break;
                case "store notes":
                    perilQuestionsPageObj.storeNotes().clear();
                    perilQuestionsPageObj.storeNotes().sendKeys( searchValue );
                    break;
                case "favourite colour":
                    new Select( perilQuestionsPageObj.favouriteColor() ).selectByVisibleText( searchValue );
                    break;
                case "what day is it":
                    new Select( perilQuestionsPageObj.whatDayItIs() ).selectByVisibleText( searchValue );
                    break;
                case "what injury did you suffer from?":
                    new Select( perilQuestionsPageObj.whatInjuryDidYouSufferFrom() ).selectByVisibleText( searchValue );
                    break;
                case "was the injury linked to a undeclared medical condition?":
                    new Select( perilQuestionsPageObj.Wastheinjurylinkedtoaundeclaredmedicalcondition() ).selectByVisibleText( searchValue );
                    break;
                case "noquestion":
                    break;
                case "was the luggage delayed":
                case "was the redundancy voluntary":
                case "has an application for jobseeker":
                case "jury service been previously deferred":
                case "you aware of the possibility for jury duty prior to booking":
                    new Select( perilQuestionsPageObj.perilQuesSelect( searchField ) ).selectByVisibleText( searchValue );
                    break;
                case "how long was the luggage delayed for":
                case "condition that caused the claim":
                case "injury/illness that has caused":
                case "who has been called for jury duty":
                    perilQuestionsPageObj.perilQuesTextArea( searchField ).sendKeys( searchValue );
                    break;
                case "was the luggage in the care of an airline":
                case "were you refused travel as a result of the damage":
                    new Select( perilQuestionsPageObj.perilQuesSelect( searchField ) ).selectByVisibleText( searchValue );
                    break;
                case "delay luggage include winter sports equipment":
                    new Select( perilQuestionsPageObj.perilQuesSelect( searchField ) ).selectByVisibleText( searchValue );
                    break;
                case "delay luggage include golf equipment":
                    new Select( perilQuestionsPageObj.perilQuesSelect( searchField ) ).selectByVisibleText( searchValue );
                    break;
                case "treated as an inpatient for 3 days":
                    new Select( perilQuestionsPageObj.perilQuesSelect( searchField ) ).selectByVisibleText( searchValue );
                    break;
                case "have you made a claim from anywhere else":
                case "another person insured on this policy":
                case "can evidence be provided":
                case "have you, or anyone else, specifically insured the item":
                case "was the loss reported":
                case "what was the last known location":
                case "have you attempted to claim the additional expenses":
                case "were you treated as an inpatient":
                case "can evidence be provided for the item":
                case "what was the last known location of the item":
                case "do you, or another person insured on this policy, own":
                case "was the loss reported within 24 hours of it":
                case "have you attempted to claim the additional expenses from the tour":
                case "had the items been left in a motor vehicle":
                case "the claim occurred due to the items being in the care of an airline":
                case "the items been left unattended at the time of the loss":
                case "the items been replaced":
                case "the claim as a result of a collision involving another skier":
                case "what was delayed?":
                case "was the trip a journey solely within the uk?":
                case "how long was the delay?":
                case "was it eventually cancelled?":
                case "did you make alternative arrangements to get to your destination?":
                case "have you claimed for any refunds or compensation from the transport operator?":
                    new Select( perilQuestionsPageObj.perilQuesSelect( searchField ) ).selectByVisibleText( searchValue );
                    break;
                case "do you have any other general insurance":
                case "how did the damage occur":
                case "who has been made redundant":
                case "where in the vehicle were they":
                case "if the items were in a motor vehicle, where in the vehicle":
                case "how old is the equipment you are claiming":
                case "the incident been reported to a relevant authority":
                    perilQuestionsPageObj.perilQuesTextArea( searchField ).sendKeys( searchValue );
                    break;
                case "on what date did the consultancy period start":
                case "on what date did you depart to return home":
                    System.out.println( "values displayed: " );
                    if (searchValue.equalsIgnoreCase( "today" )) {
                        searchValue = new SimpleDateFormat( "dd/MM/yyyy" ).format( new Date() );
                    }
                    perilQuestionsPageObj.perilQuesInput( searchField ).sendKeys( searchValue );
                    break;
                case "patient been admitted as a inpatient":
                case "claim as a result of you being a passenger":
                case "trip have to be cut short, or extended":
                case "anyone have to travel from the uk, to be with the patient":
                case "participating in hazardous activities?":
                case "treated in a public hospital and was the european health insurance card":
                case "medical professional advised":
                case "requested a refund of the unused costs from the travel/ski":
                    new Select( perilQuestionsPageObj.perilQuesSelect( searchField ) ).selectByVisibleText( searchValue );
                    break;
            }
        } catch (NoSuchElementException e) {
            // Do Nothing
        }
    }

    public void validateClaimCauseAndComments(String searchField, String searchValue) {
        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
        Calendar c = Calendar.getInstance();
        c.setTime( new Date() );
        String returnValue = null;
        String date = "";
        switch (searchField.toLowerCase()) {
            case "dateofloss":
                try {
                    nextEventPageObj.switchToDefault();
                    nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                    nextEventPageObj.switchToFrameById( nextEventPageObj.fancyFrame() );
                    perilsAndCostsPageObj.dateOfLoss().clear();
                } catch (Exception ex) {
                    System.out.println( "Inside date of loss exception -- " + ex.getMessage() );
                    perilsAndCostsPageObj.dateOfLoss().clear();
                }
                if (searchValue.equalsIgnoreCase( "today" )) {
                    c.add( Calendar.DATE, 0 );
                    date = sdf.format( c.getTime() );
                    searchValue = date;
                    System.out.println( "calculated date" + searchValue );
                } else if (searchValue.equalsIgnoreCase( "currentdate-1" )) {
                    c.add( Calendar.DATE, -1 );
                    date = sdf.format( c.getTime() );
                    searchValue = date;
                    System.out.println( "calculated date" + searchValue );
                } else if (searchValue.equalsIgnoreCase( "currentdate" )) {
                    date = sdf.format( c.getTime() );
                    searchValue = date;
                    System.out.println( "calculated date" + searchValue );
                } else if (searchValue.equalsIgnoreCase( "currentdate-3" )) {
                    c.add( Calendar.DATE, -3 );
                    date = sdf.format( c.getTime() );
                    searchValue = date;
                    System.out.println( "calculated date" + searchValue );
                } else if (searchValue.equalsIgnoreCase( "backdate2month" )) {
                    c.add( Calendar.MONTH, -2 );
                    date = sdf.format( c.getTime() );
                    searchValue = date;
                    System.out.println( "calculated date" + searchValue );
                } else if (searchValue.equalsIgnoreCase( "backdate35days" )) {
                    c.add( Calendar.MONTH, -35 );
                    date = sdf.format( c.getTime() );
                    searchValue = date;
                    System.out.println( "calculated date" + searchValue );
                } else if (searchValue.equalsIgnoreCase( "currentdate-7" )) {
                    c.add( Calendar.DATE, -7 );
                    date = sdf.format( c.getTime() );
                    searchValue = date;
                    System.out.println( "calculated date" + searchValue );
                }
                perilsAndCostsPageObj.dateOfLoss().sendKeys( searchValue );
                perilsAndCostsPageObj.dateOfLoss().sendKeys( Keys.TAB );
                break;
            case "countryofloss":
                if (searchValue.equalsIgnoreCase( "rertievedTripDestination" )) {
                    System.out.println( "retrieved Destination" + rulesEngineOperationsObj.destinationRetrievedFromRulesEngine );
                    searchValue = rulesEngineOperationsObj.destinationRetrievedFromRulesEngine;
                }
                perilsAndCostsPageObj.countryOfLoss().click();
                new Select( perilsAndCostsPageObj.countryOfLoss() ).selectByVisibleText( searchValue );
                perilsAndCostsPageObj.addPeril().click();
                commandsObj.waitForLoad( getDriver() );
                break;
            case "peril":
                this.addNewPeril( searchValue );
                break;
            case "causecode":
                String strContinue = "Yes";
                int iTried = 0;
                do {
                    iTried++;
                    try {
                        selectObj.selectValueFromDropdown( perilsAndCostsPageObj.claimCause(), searchValue );
                        break;
                    } catch (Exception ex) {
                        if (ex.equals( "org.openqa.selenium.NoSuchElementException" )) {
                            strContinue = "Yes";
                            if (iTried > 5) {
                                strContinue = "No";
                                break;
                            }
                        } else if (iTried > 15) {
                            break;
                        }
                    }
                } while (strContinue.equalsIgnoreCase( "Yes" ));
                break;
            case "descriptioncausecode":
                perilsAndCostsPageObj.claimCauseDesc().clear();
                perilsAndCostsPageObj.claimCauseDesc().sendKeys( searchValue );
                perilsAndCostsPageObj.claimSavePeril().click();
                break;
            case "subcausecode":
                subcausecodestring = searchValue;
                selectObj.selectValueFromDropdown( perilsAndCostsPageObj.claimSubCause(), searchValue );
                break;
            case "lossdate":
                perilsAndCostsPageObj.claimLossDate().clear();
                perilsAndCostsPageObj.claimLossDate().sendKeys( searchValue );
                perilsAndCostsPageObj.claimLossDate().sendKeys( Keys.TAB );
                break;
            case "validatedateofloss":
                if (searchValue.equalsIgnoreCase( "currentdate" )) {
                    DateFormat dateFormat = new SimpleDateFormat( "dd/MM/YYYY" );
                    Date newdate = new Date();
                    String strDate = dateFormat.format( newdate );
                    System.out.println( "System date:" + strDate );
                    System.out.println( "inside switch-----------------" );
                    System.out.println( "Entered value is----" + perilsAndCostsPageObj.dateOfLoss().getAttribute( "value" ) );
                    Assert.assertTrue( perilsAndCostsPageObj.dateOfLoss().getAttribute( "value" ).equalsIgnoreCase( strDate ) );
                    System.out.println( "Date of loss is validated" );
                }
                break;
            case "validatecountryofloss":
                System.out.println( "inside switch-----------------" );
                System.out.println( "Entered value is----" + new Select( perilsAndCostsPageObj.countryOfLoss() ).getFirstSelectedOption().getText() );
                Assert.assertTrue( new Select( perilsAndCostsPageObj.countryOfLoss() ).getFirstSelectedOption().getText().equals( searchValue ) );
                System.out.println( "Country of loss is validated" );
                break;
            case "validatecausecode":
                perilsAndCostsPageObj.btnEditParticularPeril( searchValue ).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "inside switch-----------------" );
                System.out.println( "Entered value is----" + new Select( perilsAndCostsPageObj.claimCause() ).getFirstSelectedOption().getText() );
                Assert.assertTrue( (new Select( perilsAndCostsPageObj.claimCause() ).getFirstSelectedOption().getText()).equals( searchValue ) );
                System.out.println( "CauseCode is validated" );
                break;
            case "validatesubcausecode":
                System.out.println( "inside switch-----------------" );
                System.out.println( "Entered value is----" + new Select( perilsAndCostsPageObj.claimSubCause() ).getFirstSelectedOption().getText() );
                Assert.assertTrue( (new Select( perilsAndCostsPageObj.claimSubCause() ).getFirstSelectedOption().getText()).equals( searchValue ) );
                System.out.println( "Sub CauseCode is validated" );
                break;
            case "edit peril":
                perilsAndCostsPageObj.btnEditParticularPeril( searchValue ).click();
                break;
            case "edit person":
                perilsAndCostsPageObj.btnEditParticularPerson( searchValue ).click();
                addedPerson = perilsAndCostsPageObj.txtAddedPerson().getText();
                System.out.println( "Added person is-----" + addedPerson );
                nextEventPageObj.btnClick( perilsAndCostsPageObj.claimAddPH() );
                break;
            case "edit claimitem":
                perilsAndCostsPageObj.btnEditParticularClaimItem( addedPerson ).click();
                break;
            case "action":
                if (searchValue.equalsIgnoreCase( "close" )) {
                    nextEventPageObj.switchToDefault();
                    nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                    nextEventPageObj.fancyboxClose().click();
                }
                break;
            case "loss date for claim":
                if (searchValue.equalsIgnoreCase( "past10days" )) {
                    c.add( Calendar.DATE, -10 );
                    date = sdf.format( c.getTime() );
                    returnValue = date;
                    System.out.println( "***** Date ***" + returnValue );
                    perilsAndCostsPageObj.dateOfLoss().sendKeys( returnValue );
                    perilsAndCostsPageObj.dateOfLoss().sendKeys( Keys.TAB );
                } else {
                    perilsAndCostsPageObj.dateOfLoss().sendKeys( returnValue );
                    perilsAndCostsPageObj.dateOfLoss().sendKeys( Keys.TAB );
                }
                break;
        }
    }

    public void addNewPeril(String value1) {
        switch (value1.toLowerCase()) {
            case "new":
                perilsAndCostsPageObj.addPeril().click();
                break;
            case "amend":
                break;
        }
    }

    public void validateClaimCostType(String clmCause, List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get( 0 ).size(); column++) {
                this.validateCostType( parameters.get( 0 ).get( column ), parameters.get( row ).get( column ) );
            }
        }
    }

    public void validateCostType(String searchField, String searchValue) {
        switch (searchField.toLowerCase()) {
            case "person":
                System.out.println( searchValue );
                if (searchValue.equalsIgnoreCase( "default" )) {
                    this.addPersonClaimCost();
                    nextEventPageObj.btnClick( perilsAndCostsPageObj.addClaimItem() );
                }
                break;
            case "claimitem1":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                try {
                    System.out.println( "Executing Claim Item 1 try block...." );
                    selectObj.selectValueFromDropdown( perilsAndCostsPageObj.claimDetail1(), searchValue );
                } catch (NoSuchElementException e) {
                    System.out.println( "Executing Claim Item 1 catch block...." );
                    nextEventPageObj.btnClick( perilsAndCostsPageObj.cancelClaimItems() );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.btnClick( perilsAndCostsPageObj.addClaimItem() );
                    List<WebElement> lstOption = new Select( perilsAndCostsPageObj.claimDetail1() ).getOptions();
                    perilsAndCostsPageObj.waitForMoreTime();
                    new Select( perilsAndCostsPageObj.claimDetail1() ).selectByIndex( ((lstOption.size()) - 1) );
                    perilsAndCostsPageObj.waitForMoreTime();
                    selectObj.selectValueFromDropdown( perilsAndCostsPageObj.claimDetail1(), searchValue );
                }
                break;
            case "claimitem2":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                selectObj.selectValueFromDropdown( perilsAndCostsPageObj.claimDetail2(), searchValue );
                break;
            case "descriptioncosttype":
                perilsAndCostsPageObj.costTypeDesc().clear();
                perilsAndCostsPageObj.costTypeDesc().sendKeys( searchValue );
                break;
            case "cost":
                perilsAndCostsPageObj.costTypeAmount().sendKeys( searchValue );
                break;
            case "currency":
                perilsAndCostsPageObj.waitForMoreTime();
                perilsAndCostsPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                List<WebElement> lstOptions = new Select( perilsAndCostsPageObj.costTypeCurrency() ).getOptions();
                new Select( perilsAndCostsPageObj.costTypeCurrency() ).selectByIndex( (lstOptions.size() - 1) );
                new Select( perilsAndCostsPageObj.costTypeCurrency() ).selectByVisibleText( searchValue );
                break;
            case "gbpvalue":
                perilsAndCostsPageObj.costTypeGBP().sendKeys( searchValue );
                break;
        }
    }

    public void addPersonCostItem(String person, List<List<String>> parameters) {
        String causeCodeValue = "";
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get( 0 ).size(); column++) {
                String causeCode = parameters.get( 0 ).get( column );
                if (causeCode.equalsIgnoreCase( "subcausecode" )) {
                    causeCodeValue = parameters.get( row ).get( column - 1 ) + " - " + parameters.get( row ).get( column );
                    System.out.println( "causeCodeValue------------------causeCodeValue----------------" + causeCodeValue );
                }
                this.addPersonCostItemTable( parameters.get( 0 ).get( column ), parameters.get( row ).get( column ), causeCodeValue );
            }
        }
    }

    public void claimIdSearch(String claimId) {
        System.out.println( "the claim id is -- " + claimId );
    }

    public void addPersonCostItemTable(String searchField, String searchValue, String causeCodeValue) {
        switch (searchField.toLowerCase()) {
            case "persontype":
                personType = searchValue;
                break;
            case "personname":
                System.out.println( "first------" + searchValue );
                if (searchValue.equalsIgnoreCase( "default" )) {
                    this.addPersonClaimCost();
                    nextEventPageObj.btnClick( perilsAndCostsPageObj.addClaimItem() );
                } else {
                    perilsAndCostsPageObj.claimAddPersonPeril( causeCodeValue ).click();
                    if (!perilsAndCostsPageObj.claimAddPerson( searchValue ).isDisplayed()) {
                        new Select( perilsAndCostsPageObj.personTitle() ).selectByIndex( 1 );
                        perilsAndCostsPageObj.personFName().sendKeys( searchValue );
                        perilsAndCostsPageObj.personLName().sendKeys( searchValue );
                        perilsAndCostsPageObj.personDOB().sendKeys( searchValue );
                        new Select( perilsAndCostsPageObj.personTitle() ).selectByVisibleText( personType );
                        perilsAndCostsPageObj.personSave().click();
                    } else {
                        perilsAndCostsPageObj.claimAddPerson( searchValue ).click();
                    }
                    commandsObj.waitForLoad( getDriver() );
                    perilsAndCostsPageObj.addClaimItemPerson( searchValue, causeCodeValue ).click();
                    commandsObj.waitForLoad( getDriver() );
                    nextEventPageObj.waitForMoreTime();
                }
                break;
            case "personnameforSilver":
                System.out.println( "first------" + searchValue );
                if (searchValue.equalsIgnoreCase( "default" )) {
                    this.addPersonClaimCost();
                    nextEventPageObj.btnClick( perilsAndCostsPageObj.addClaimItem() );
                } else {
                    perilsAndCostsPageObj.claimAddPersonPeril( causeCodeValue ).click();
                    if (!perilsAndCostsPageObj.claimAddPerson( searchValue ).isDisplayed()) {
                        new Select( perilsAndCostsPageObj.personTitle() ).selectByIndex( 1 );
                        perilsAndCostsPageObj.personFName().sendKeys( searchValue );
                        perilsAndCostsPageObj.personLName().sendKeys( searchValue );
                        perilsAndCostsPageObj.personDOB().sendKeys( searchValue );
                        new Select( perilsAndCostsPageObj.personTitle() ).selectByVisibleText( personType );
                        perilsAndCostsPageObj.personSave().click();
                    } else {
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        Assert.assertTrue( perilsAndCostsPageObj.validationofAddingNewPerson().size() == 0 );
                        perilsAndCostsPageObj.claimAddPerson( searchValue ).click();
                    }
                    commandsObj.waitForLoad( getDriver() );
                    perilsAndCostsPageObj.addClaimItemPerson( searchValue, causeCodeValue ).click();
                    commandsObj.waitForLoad( getDriver() );
                    nextEventPageObj.waitForMoreTime();
                }
                break;
            case "claimitem1":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                nextEventPageObj.switchToFrameById( nextEventPageObj.fancyFrame() );
                nextEventPageObj.btnClick( perilsAndCostsPageObj.cancelClaimItems() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick( perilsAndCostsPageObj.addClaimItem() );
                List<WebElement> lstOption = new Select( perilsAndCostsPageObj.claimDetail1() ).getOptions();
                perilsAndCostsPageObj.waitForMoreTime();
                new Select( perilsAndCostsPageObj.claimDetail1() ).selectByIndex( ((lstOption.size()) - 1) );
                perilsAndCostsPageObj.waitForMoreTime();
                try {
                    System.out.println( "Claim Item 1 try block...." );
                    selectObj.selectValueFromDropdown( perilsAndCostsPageObj.claimDetail1(), searchValue );
                } catch (NoSuchElementException e) {
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
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    System.out.println( "Claim Item 1 catch block...." );
                    nextEventPageObj.btnClick( perilsAndCostsPageObj.cancelClaimItems() );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.btnClick( perilsAndCostsPageObj.addClaimItem() );
                    List<WebElement> lstOptions = new Select( perilsAndCostsPageObj.claimDetail1() ).getOptions();
                    perilsAndCostsPageObj.waitForMoreTime();
                    new Select( perilsAndCostsPageObj.claimDetail1() ).selectByIndex( ((lstOptions.size()) - 1) );
                    perilsAndCostsPageObj.waitForMoreTime();
                    selectObj.selectValueFromDropdown( perilsAndCostsPageObj.claimDetail1(), searchValue );
                }
                break;
            case "claimitem2":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (searchValue.equalsIgnoreCase( "Hospital Bill" )) {
                }
                List<WebElement> lstOptionClaimItem = new Select( perilsAndCostsPageObj.claimDetail2() ).getOptions();
                perilsAndCostsPageObj.waitForMoreTime();
                new Select( perilsAndCostsPageObj.claimDetail2() ).selectByIndex( ((lstOptionClaimItem.size()) - 1) );
                perilsAndCostsPageObj.waitForMoreTime();
                selectObj.selectValueFromDropdown( perilsAndCostsPageObj.claimDetail2(), searchValue );
                break;
            case "descriptioncosttype":
                perilsAndCostsPageObj.costTypeDesc().clear();
                perilsAndCostsPageObj.costTypeDesc().sendKeys( searchValue );
                break;
            case "cost":
                if (searchValue.equalsIgnoreCase( "NA" )) {
                    System.out.println( "Do Nothing" );
                } else {
                    tempAmount = tempAmount + Double.parseDouble( searchValue );
                    claimAmount = Double.toString( tempAmount );
                    System.out.println( "Claim amount displayed**********" + claimAmount );
                    perilsAndCostsPageObj.costTypeAmount().sendKeys( searchValue );
                }
                break;
            case "gbpvalue":
                perilsAndCostsPageObj.costTypeGBP().sendKeys( searchValue );
                break;
            case "currency":
                perilsAndCostsPageObj.waitForMoreTime();
                List<WebElement> lstOptions = new Select( perilsAndCostsPageObj.costTypeCurrency() ).getOptions();
                perilsAndCostsPageObj.waitForMoreTime();
                new Select( perilsAndCostsPageObj.costTypeCurrency() ).selectByIndex( ((lstOptions.size()) - 1) );
                perilsAndCostsPageObj.waitForMoreTime();
                new Select( perilsAndCostsPageObj.costTypeCurrency() ).selectByVisibleText( searchValue );
                break;
            case "action":
            case "type":
                if (!searchValue.equalsIgnoreCase( "Do Not Save" )) {
                    perilsAndCostsPageObj.saveClaimItem().click();
                }
                break;
        }
    }

    public void saveClaim(String strClaimScreen) {
        switch (strClaimScreen.toLowerCase()) {
            case "basic claim details":
                if (basicClaimDetailsPageObj.saveAndCloseIsDisplayed()) {
                    basicClaimDetailsPageObj.saveAndClose().click();
                }
                break;
            case "claim details":
                if (perilsAndCostsPageObj.saveClaimDetailsIsDisplayed()) {
                    perilsAndCostsPageObj.saveClaimDetails().click();
                }
                break;
            case "capture incidents":
                evidenceCollationPageObj.save().click();
                break;
            case "evidence details":
                String strContinue = "Yes";
                nextEventPageObj.waitForMoreTime();
                int i = 0;
                do {
                    i++;
                    if (evidenceCollationPageObj.saveIsDisplayed()) {
                        evidenceCollationPageObj.save().click();
                        break;
                    }
                    if (i > 1000) {
                        break;
                    }
                } while (strContinue.equalsIgnoreCase( "Yes" ));
                break;
        }
    }

    public void clickCancel(String strClaimScreen) {
        switch (strClaimScreen.toLowerCase()) {
            case "basic claim details":
                break;
            case "claim details":
                break;
            case "other insurance policy":
                otherInsurerPageObj.switchToFrameById( nextEventPageObj.frame() );
                claimSummaryPageObj.cancel_btn().click();
                break;
            case "evidence details":
                String strContinue = "Yes";
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                nextEventPageObj.CancelBtn().click();
                break;
        }
    }

    public void addPersonClaimCost() {
        nextEventPageObj.btnClick( perilsAndCostsPageObj.addPerson() );
        commandsObj.waitForLoad( getDriver() );
        addedPerson = perilsAndCostsPageObj.txtAddedPerson().getText();
        System.out.println( "Added person is-----" + addedPerson );
        nextEventPageObj.btnClick( perilsAndCostsPageObj.claimAddPH() );
    }

    public void addAnotherPersonClaimCost() {
        nextEventPageObj.btnClick( perilsAndCostsPageObj.addAnotherPerson() );
        nextEventPageObj.btnClick( perilsAndCostsPageObj.claimAddPH() );
    }

    public List<Integer> getRowListFromTable(List<List<String>> parameters, WebElement Mytable) {
        List<String> hl = new ArrayList<>();
        List<List<String>> nl1 = new ArrayList<List<String>>();
        List<WebElement> rows = (List<WebElement>) Mytable.findElements( By.xpath( "tr" ) );
        int trows_count = rows.size();
        for (int trow = 0; trow < trows_count; trow++) {
            List<WebElement> cols = (List<WebElement>) rows.get( trow ).findElements( By.xpath( "./th" ) );
            int rowColumns = cols.size();
            for (int tcol = 0; tcol < rowColumns; tcol++) {
                for (int c = 0; c < parameters.get( 0 ).size(); c++) {
                    if (cols.get( tcol ).getText().equals( parameters.get( 0 ).get( c ) )) {
                        hl.add( cols.get( tcol ).getText() );
                    }
                }
                if (tcol == (rowColumns - 1)) {
                    hl.add( "SelectRow" );
                }
            }
        }
        nl1.add( hl ); // master list having header, row values nl1
        int rows_count1 = rows.size();
        for (int row = 1; row < rows_count1; row++) {
            List<WebElement> Columns_row = rows.get( row ).findElements( By.xpath( "./td" ) );
            List<WebElement> ColumnsHd_row = rows.get( 0 ).findElements( By.tagName( "th" ) );
            List<String> ul1 = new ArrayList<String>();
            int columns_count = Columns_row.size();
            int lis = 0;
            if (columns_count > 0) {
                for (int column = 0; column < columns_count; column++) {
                    for (int c = 0; c < parameters.get( 0 ).size(); c++) {
                        if (ColumnsHd_row.get( column ).getText().equals( parameters.get( 0 ).get( c ) )) {
                            String celText = Columns_row.get( column ).getText();
                            ul1.add( celText );
                            System.out.println( "row#" + row + "col#" + column + ":" + celText + "|" );
                        }
                    }
                    if (column == columns_count - 1) {
                        String celText = Integer.toString( row + 1 );
                        ul1.add( celText );
                        System.out.println( "row#" + row + "col#" + column + ":" + celText + "|" );
                    }
                }
                nl1.add( ul1 );
            }
        }
        System.out.println( "nl1.size()" + nl1.size() );
        System.out.println( "nl1.get(0).size()" + nl1.get( 0 ).size() );
        System.out.println( "---------------Col list-------------" );
        for (int row1 = 0; row1 < nl1.size(); row1++) {
            for (int column = 0; column < nl1.get( row1 ).size(); column++) {
                System.out.print( nl1.get( row1 ).get( column ) + " ;" );
            }
            System.out.println( "" );
        }
        return compareList( parameters, nl1, 0 ); // 0 means - row number, 1 means no of occurances
    }

    public List<Integer> compareList(List<List<String>> firstList, List<List<String>> secondList, int find) {
        List<Integer> comparingList = new ArrayList<Integer>();
        for (int a = 0; a < firstList.size(); a++) {
            comparingList.add( 0 );
        }
        int flag = 0;
        String findrow = "";
        int cmp = firstList.get( 0 ).size() - 1;
        for (int rowCounter = 1; rowCounter < firstList.size(); rowCounter++) {
            for (int rowCounter1 = 1; rowCounter1 < secondList.size(); rowCounter1++) {
                flag = 0;
                for (int counter2 = 0; counter2 < secondList.get( rowCounter1 ).size(); counter2++) {
                    if (secondList.get( rowCounter1 ).get( counter2 ).equals( firstList.get( rowCounter ).get( counter2 ) )) {
                        flag++;
                        if (flag == cmp) {
                            findrow = secondList.get( rowCounter1 ).get( secondList.get( rowCounter1 ).size() - 1 );
                            if (find == 0) {
                                comparingList.set( rowCounter, Integer.parseInt( findrow ) );
                            } else {
                                comparingList.set( rowCounter, flag );
                            }
                        }
                    }
                }
            }
        }
        return comparingList;
    }

    public List<List<String>> convertList(List<List<String>> parameters) {
        List<List<String>> nl = new ArrayList<List<String>>();
        List<List<String>> nl1 = new ArrayList<List<String>>();
        int trows_count = parameters.size();
        int rowColumns = parameters.get( 0 ).size();
        for (int r = 0; r < trows_count; r++) {
            List<String> hl = new ArrayList<>();
            for (int c = 0; c < rowColumns; c++) {
                hl.add( parameters.get( r ).get( c ) );
                if (c == (rowColumns - 1)) {
                    hl.add( "SelectRow" );
                }
            }
            nl1.add( hl );
        }
        System.out.println( "nl1.size()" + nl1.size() );
        System.out.println( "nl1.get(0).size()" + nl1.get( 0 ).size() );
        System.out.println( "---------------Col list-------------" );
        for (int row1 = 0; row1 < nl1.size(); row1++) {
            for (int column = 0; column < nl1.get( row1 ).size(); column++) {
                System.out.print( nl1.get( row1 ).get( column ) + " ;" );
            }
            System.out.println( "" );

            System.out.println( "nl1.size()" + nl1.size() );
            System.out.println( "nl1.get(0).size()" + nl1.get( 0 ).size() );
            System.out.println( "---------------Col list-------------" );
        }
        return nl1;
    }

    public void nextEventClaims(String nextEventClaims) {
        new Select( nextEventPageObj.nextEventClaims() ).selectByVisibleText( nextEventClaims );
    }

    public void searchRepudiation(String repudiation) {
        Assert.assertTrue( claimsRepudiationPageObj.repudiationReason1( repudiation ).isDisplayed() );
    }

    public long fileSize() {
        long fileSize = 0;
        try {
            String home = System.getProperty( "user.home" );
            System.out.println( "location---" + home );
            String newfileLocation = home.concat( "\\" + "Downloads" );
            System.out.println( "File location----" + newfileLocation );
            File downloadedFile = new File( newfileLocation );
            File[] downloadDirFile = downloadedFile.listFiles();
            File lastModifiedFile = downloadDirFile[0];
            for (int i = 1; i < downloadDirFile.length; i++) {
                if (lastModifiedFile.lastModified() < downloadDirFile[i].lastModified()) {
                    lastModifiedFile = downloadDirFile[i];
                }
            }
            fileSize = lastModifiedFile.length();
            System.out.println( "Returned Length" + fileSize );
        } catch (Exception e) {
            fullEventHistoryPageObj.closeWindow().click();
            nextEventPageObj.switchToLastOpenWindow();
        }
        return fileSize;
    }

    public void completeThirdPartyAtFault(List<List<String>> parameters) {
        int listRowSize = parameters.size();
        String fieldValue = "";
        for (int i = 1; i < listRowSize; i++) {
            for (int j = 0; j < parameters.get( i ).size(); j++) {
                String fieldName = parameters.get( 0 ).get( j );
                fieldValue = parameters.get( i ).get( j );
                System.out.println( "----field Name ---------------" + fieldName );
                System.out.println( "----field Name ---------------" + fieldValue );
                switch (fieldName) {
                    case "ThirdPartyAtFault":
                        thirdPartyAtFaultPageObj.thirdPartyQuestion().click();
                        thirdPartyAtFaultPageObj.thirdPartyAnswer( parameters.get( i ).get( j ) ).click();
                        System.out.println( "Thirparty ---------------------------" + fieldValue );
                        thirdPartyAtFaultPageObj.thirdPartyAtFaultSave().click();
                        break;
                    case "ContactCreation":
                        System.out.println( "ContactCreation ---------------------------" + fieldValue );
                        if (commandsObj.elementDisplayedWithLessTime( By.xpath( thirdPartyAtFaultPageObj.thirdPartyAtFaultAddXpath() ) ))
                            thirdPartyAtFaultPageObj.thirdPartyAtFaultAdd().click();
                        else if (!fieldValue.equalsIgnoreCase( "first" ))
                            thirdPartyAtFaultPageObj.thirdPartyAtFaultSaveBtn().click();
                        break;
                    case "ContactName":
                        System.out.println( "ContactName ---------------------------" + fieldValue );
                        thirdPartyAtFaultPageObj.thirdPartyAtFaultContactName().sendKeys( fieldValue );
                        break;
                    case "Name":
                        System.out.println( "Name ---------------------------" + fieldValue );
                        thirdPartyAtFaultPageObj.thirdPartyAtFaultName().sendKeys( fieldValue );
                        break;
                    case "Email":
                        System.out.println( "Email ---------------------------" + fieldValue );
                        thirdPartyAtFaultPageObj.thirdPartyAtFaultEmail().sendKeys( fieldValue );
                        break;
                    case "Address":
                        System.out.println( "Address ---------------------------" + fieldValue );
                        thirdPartyAtFaultPageObj.thirdPartyAtFaultAddress().sendKeys( fieldValue );
                        break;
                    case "ContactFirstName":
                        System.out.println( "ContactFirstName ---------------------------" + fieldValue );
                        thirdPartyAtFaultPageObj.thirdPartyAtContactFirstName().sendKeys( fieldValue );
                        break;
                    case "ContactLastName":
                        System.out.println( "Address ---------------------------" + fieldValue );
                        thirdPartyAtFaultPageObj.thirdPartyAtContactLastName().sendKeys( fieldValue );
                        break;
                    case "ContactTitle":
                        System.out.println( "Title ---------------------------" + fieldValue );
                        thirdPartyAtFaultPageObj.thirdPartyAtContactTitle();
                        Select select = new Select( thirdPartyAtFaultPageObj.thirdPartyAtContactTitle() );
                        select.selectByVisibleText( fieldValue );
                        break;
                }
            }
            thirdPartyAtFaultPageObj.thirdPartyAtFaultContactSaveButton().click();
        }
        Assert.assertTrue( thirdPartyAtFaultPageObj.thirdPartyAtFaultContactUpdateCheck( fieldValue ).isDisplayed() );
        thirdPartyAtFaultPageObj.thirdPartyAtFaultSaveBtn().click();
    }

    public void addUserDeductionInClaimCaluculation(List<List<String>> lstInput) {
        try {
            int listSize = lstInput.size();
            System.out.println( "list size -------------------------" + listSize );
            if (lstInput.get( 1 ).get( 0 ).equalsIgnoreCase( "yes" )) {
                for (int i = 1; i < listSize; i++) {
                    List<WebElement> tableRows = claimCalculationPageObj.claimCalculationTable().findElements( By.tagName( "tr" ) );
                    int tableSize = tableRows.size();
                    System.out.println( "Table size ----------------------------------" + tableSize );
                    int userDeductionColumn = webTableObj.getColumnFromWebTable( claimCalculationPageObj.claimCalculationTable(), "User Deduct." );
                    int totalColumn = webTableObj.getColumnFromWebTable( claimCalculationPageObj.claimCalculationTable(), "Total" );
                    System.out.println( "total column -------------------" + totalColumn );
                    System.out.println( "user deduction  column -------------------" + userDeductionColumn );
                    for (int j = 2; j < tableSize; j++) {
                        String xpath = claimCalculationPageObj.claimCalculationTableStr() + "//tr[" + j + "]/td[" + (totalColumn + 1) + "]";
                        String totalValue = nextEventPageObj.findElement( By.xpath( xpath ) ).getText();
                        System.out.println( "xpath text --------------------------------" + nextEventPageObj.findElement( By.xpath( xpath ) ).getText() );
                        System.out.println( "Total Value before ---------------------------" + totalValue );
                        tableRows.get( j ).findElements( By.tagName( "td" ) ).get( userDeductionColumn ).findElement( By.xpath( "//a[contains(@id,'lnkUserDeduct')]" ) ).click();
                        addUserDeductionInClaimCalculation( lstInput, i );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                        Thread.sleep( 5000L );
                        System.out.println( "After deduction --------------------------------" + nextEventPageObj.findElement( By.xpath( xpath ) ).getText() );
                        String totalValueAfterDeduction = nextEventPageObj.findElement( By.xpath( xpath ) ).getText();//tableRows.get(j).findElements(By.tagName("td")).get(totalColumn).getText();
                        System.out.println( "Total Value After----------------------------------" + totalValueAfterDeduction );
                        Double total = Double.parseDouble( totalValue ) - 10;
                        System.out.println( "Total Value ----------------------------------" + total );
                        Assert.assertTrue( total == Double.parseDouble( totalValueAfterDeduction ) );
                        this.sysDate = new SimpleDateFormat( "yyyy-MM-dd" ).format( new java.util.Date() ).toString();
                        System.out.println( "System date ------------------------" + this.sysDate );
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUserDeductionInClaimCalculation(List<List<String>> lstInput, int rowposition) {
        nextEventPageObj.switchToFrameById( nextEventPageObj.fancyFrame() );
        for (int j = 0; j < lstInput.get( rowposition ).size(); j++) {
            switch (lstInput.get( 0 ).get( j ).toLowerCase()) {
                case "user deduction reason":
                    System.out.println( "inside claim calcualtion case----------" + lstInput.get( rowposition ).get( j ) );
                    new Select( claimCalculationPageObj.userdeductionsReasons() ).selectByVisibleText( lstInput.get( rowposition ).get( j ) );
                    break;
                case "amount deducted":
                    System.out.println( "amount deductede----------" + lstInput.get( rowposition ).get( j ) );
                    claimCalculationPageObj.userdeductionsAmount().sendKeys( lstInput.get( rowposition ).get( j ) );
                    break;
            }
        }
        claimCalculationPageObj.userdeductionsAddBtn().click();
        claimCalculationPageObj.userdeductionsAddBtn().isDisplayed();
        claimCalculationPageObj.userdeductionsSaveBtn().click();
    }


    public void verifyFinancialTabData(String tabToView, List<List<String>> parameters) {
        System.out.println( "insided amended value" );
        navigateToFinancial();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( i ).size(); j++) {
                switch (parameters.get( 0 ).get( j ).toLowerCase()) {
                    case "date":
                        claimMovementTableManipulation( parameters.get( 0 ).get( 0 ), parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
                        break;
                    case "amount":
                        claimMovementTableManipulation( parameters.get( 0 ).get( 0 ), parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
                        break;
                    case "agent":
                        claimMovementTableManipulation( parameters.get( 0 ).get( 0 ), parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
                        break;
                    case "reserve":
                        claimMovementTableManipulation( parameters.get( 0 ).get( 0 ), parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
                        break;
                }
            }
        }
    }

    public void navigateToFinancial() {
        if (nextEventPageObj.elementDisplayed( By.xpath( "//*[@id='lbl300938']" ) )) {
            System.out.println( "Inside navigate financial----------------" );
            nextEventPageObj.switchToLastOpenWindow();
            nextEventPageObj.switchToDefault();
            financialPageObj.financialTab().click();
            Assert.assertTrue( financialPageObj.claimMovementTable().isDisplayed() );
        } else {
            nextEventPageObj.switchToLastOpenWindow();
            nextEventPageObj.switchToDefault();
            financialPageObj.financialTab().click();
            Assert.assertTrue( financialPageObj.claimMovementTable().isDisplayed() );
        }
    }

    private void navigateToInternal() {
        if (nextEventPageObj.elementDisplayed( By.xpath( "//*[@id='lbl300938']" ) )) {
            System.out.println( "Inside navigate financial----------------" );
            searchPageObj.switchToWindowByIndex( 1 );
            nextEventPageObj.switchToDefault();
            financialPageObj.internalTab().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            Assert.assertTrue( nextEventPageObj.waitForElementPresent( By.xpath( claimPaymentPageObj.goodwillPaymentRecentRecord() ) ).isDisplayed() );
        }
    }

    public void claimMovementTableManipulation(String action, String actionType, String inputValue) {
        List<WebElement> tableRows = nextEventPageObj.findElements( By.xpath( "//table[@id='Rad301184_ctl01']/tbody/tr" ) ); //financialPageObj.claimMovementTable().findElements(By.tagName("tr"));
        int tableSize = tableRows.size();
        System.out.println( "Table size ----------------------------------" + tableSize );
        int movementDateColumn = webTableObj.getColumnFromWebTable( financialPageObj.claimMovementTable(), "Movement DateTime" );
        int agentColumn = webTableObj.getColumnFromWebTable( financialPageObj.claimMovementTable(), "Agent" );
        int userDeductionColumn = webTableObj.getColumnFromWebTable( financialPageObj.claimMovementTable(), "User Deduction" );
        int reasonColumn = webTableObj.getColumnFromWebTable( financialPageObj.claimMovementTable(), "Reason" );
        int paymentColumn = webTableObj.getColumnFromWebTable( financialPageObj.claimMovementTable(), "Payment" );
        int reserveColumn = webTableObj.getColumnFromWebTable( financialPageObj.claimMovementTable(), "Reserve" );
        int causeCodeColumn = webTableObj.getColumnFromWebTable( financialPageObj.claimMovementTable(), "Cause Code" );
        int limitExcessColumn = webTableObj.getColumnFromWebTable( financialPageObj.claimMovementTable(), "Limit and Excess" );
        System.out.println( "payment column value ------------------------------" + paymentColumn );
        System.out.println( "Reason column value ------------------------------" + reasonColumn );
        System.out.println( "date column value ------------------------------" + movementDateColumn );
        System.out.println( "agent column value ------------------------------" + agentColumn );
        System.out.println( "dedeuction column value ------------------------------" + userDeductionColumn );
        System.out.println( "Cause Code column value ------------------------------" + causeCodeColumn );
        for (int i = 1; i < tableSize; i++) {
            String reasonXpath = financialPageObj.claimMovementTableStr() + "/tbody/tr[" + i + "]/td[" + (reasonColumn + 1) + "]";
            System.out.println( "reason column xpath ------------------------------" + reasonXpath );
            String reason = nextEventPageObj.findElement( By.xpath( reasonXpath ) ).getText();
            System.out.println( "Reason in finance tab-------------------------------" + reason );
            if (reason.equalsIgnoreCase( action )) {
                switch (actionType.toLowerCase()) {
                    case "date":
                        String movementDate = nextEventPageObj.findElement( By.xpath( financialPageObj.claimMovementTableStr() + "/tbody/tr[" + i + "]/td[" + (movementDateColumn + 1) + "]" ) ).getText();
                        System.out.println( "movement date ----------------------------" + movementDate.contains( this.sysDate ) );
                        Assert.assertTrue( movementDate.contains( this.sysDate ) );
                        break;
                    case "agent":
                        String agentName = nextEventPageObj.findElement( By.xpath( financialPageObj.claimMovementTableStr() + "/tbody/tr[" + i + "]/td[" + (agentColumn + 1) + "]" ) ).getText();
                        System.out.println( "Agent----------------------------------------" + agentName.equalsIgnoreCase( (userObj.getUserDetails( inputValue )).get( 0 ) ) + "-----------------------" + agentName );
                        Assert.assertTrue( agentName.equalsIgnoreCase( (userObj.getUserDetails( inputValue )).get( 0 ) ) );
                        break;
                    case "amount":
                        Double amountChanged = Double.parseDouble( nextEventPageObj.findElement( By.xpath( financialPageObj.claimMovementTableStr() + "/tbody/tr[" + i + "]/td[" + (userDeductionColumn + 1) + "]" ) ).getText() );
                        System.out.println( "Amount -----------------------Changed------------" + amountChanged );
                        System.out.println( "Amount input---------------------------" + inputValue );
                        System.out.println( "Amount----------------------------------" + (amountChanged == Double.parseDouble( inputValue )) );
                        Assert.assertTrue( amountChanged == Double.parseDouble( inputValue ) );
                        break;
                    case "reserve":
                        Double reserveAmount = Double.parseDouble( nextEventPageObj.findElement( By.xpath( financialPageObj.claimMovementTableStr() + "/tbody/tr[" + i + "]/td[" + (reserveColumn + 1) + "]" ) ).getText() );
                        System.out.println( "Reserve -----------------------Changed------------" + reserveAmount );
                        System.out.println( "Reserve input---------------------------" + inputValue );
                        System.out.println( "Reserve----------------------------------" + (reserveAmount == Double.parseDouble( inputValue )) );
                        System.out.println( "cause code value-----------------------------------" + nextEventPageObj.findElement( By.xpath( financialPageObj.claimMovementTableStr() + "/tbody/tr[" + i + "]/td[" + (causeCodeColumn + 1) + "]" ) ).getText() );
                        if (nextEventPageObj.findElement( By.xpath( financialPageObj.claimMovementTableStr() + "/tbody/tr[" + i + "]/td[" + (causeCodeColumn + 1) + "]" ) ).getText().equalsIgnoreCase( "Baggage" )) {
                            Assert.assertTrue( reserveAmount == (Double.parseDouble( inputValue )) );
                            System.out.println( "reserve after subtraction-----------------------------" + (reserveAmount == (Double.parseDouble( inputValue ))) );
                        } else
                            System.out.println( "in else part" );
                        break;
                    case "limit and excess":
                        Double limitExcessAmount = Double.parseDouble( nextEventPageObj.findElement( By.xpath( financialPageObj.claimMovementTableStr() + "/tbody/tr[" + i + "]/td[" + (limitExcessColumn + 1) + "]" ) ).getText() );
                        System.out.println( "Reserve -----------------------Changed------------" + limitExcessAmount );
                        System.out.println( "Reserve input---------------------------" + inputValue );
                        System.out.println( "Reserve----------------------------------" + (limitExcessAmount == Double.parseDouble( inputValue )) );
                        System.out.println( "cause code value-----------------------------------" + nextEventPageObj.findElement( By.xpath( financialPageObj.claimMovementTableStr() + "/tbody/tr[" + i + "]/td[" + (causeCodeColumn + 1) + "]" ) ).getText() );
                        if (nextEventPageObj.findElement( By.xpath( financialPageObj.claimMovementTableStr() + "/tbody/tr[" + i + "]/td[" + (causeCodeColumn + 1) + "]" ) ).getText().equalsIgnoreCase( "Baggage" )) {
                            Assert.assertTrue( limitExcessAmount == (Double.parseDouble( inputValue )) );
                            System.out.println( "reserve after subtraction-----------------------------" + (limitExcessAmount == (Double.parseDouble( inputValue ))) );
                        } else
                            System.out.println( "in else part" );
                        break;
                }
                break;
            }
        }
        System.out.println( "total column -------------------" + agentColumn );
        System.out.println( "user deduction  column -------------------" + userDeductionColumn );
    }

    public void validateColumnValues(String columnToValidate, List<List<String>> criteria) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        String allColumnXpath = nextEventPageObj.claimTable() + "/tr/th";
        System.out.println( "Xpath value in claim table validationm--------------------------" + allColumnXpath );
        int columnCount = nextEventPageObj.findElements( By.xpath( allColumnXpath ) ).size();
        int statusColumn = webTableObj.getColumnFromWebTable( nextEventPageObj.findElement( By.xpath( nextEventPageObj.claimTable() ) ), "Status" );
        int subStatusColumn = webTableObj.getColumnFromWebTable( nextEventPageObj.findElement( By.xpath( nextEventPageObj.claimTable() ) ), "Sub Status" );
        System.out.println( "Column count in claim table--------------------------" + columnCount );
        for (int i = 1; i < criteria.size(); i++) {
            for (int j = 0; j < criteria.get( i ).size(); j++) {
                for (int k = 1; k < columnCount; k++) {
                    String columnXpath = nextEventPageObj.claimTable() + "/tr[1]/th" + "[" + k + "]";
                    String columnvalue = nextEventPageObj.findElement( By.xpath( columnXpath ) ).getText();
                    System.out.println( "column name in the claim table -----------------------------------" + columnvalue );
                    System.out.println( "criteria-----------------------" + criteria.get( i ).get( j ).toLowerCase() );
                    if (columnvalue.equalsIgnoreCase( columnToValidate )) {
                        System.out.println( "row count ----------------------------------" + nextEventPageObj.claimTable() + "/tr[2]/td[" + k + "]" );
                        String reserveAmount = nextEventPageObj.findElement( By.xpath( nextEventPageObj.claimTable() + "/tr[2]/td[" + k + "]" ) ).getText();
                        if (reserveAmount.contains( "," )) {
                            reserveAmount.replaceAll( ",", "" );
                        }
                        switch (criteria.get( i ).get( j ).toLowerCase()) {
                            case "greater than zero":
                                double reserveTableValue = Double.parseDouble( reserveAmount );
                                System.out.println( "Status in greater ------------------" + nextEventPageObj.findElement( By.xpath( nextEventPageObj.claimTable() + "/tr[2]/td[" + (statusColumn + 1) + "]" ) ).getText() );
                                if (!nextEventPageObj.findElement( By.xpath( nextEventPageObj.claimTable() + "/tr[2]/td[" + (statusColumn + 1) + "]" ) ).getText().equalsIgnoreCase( "Claim Closed" )) {
                                    Assert.assertTrue( reserveTableValue > 0 );
                                    System.out.println( "Value in the reserve column ----------------------------------------" + reserveTableValue );
                                }
                                break;
                            case "equal to zero":
                                double reserveTableValue1 = Double.parseDouble( reserveAmount );
                                Assert.assertTrue( reserveTableValue1 == 0 );
                                System.out.println( "Value in the reserve column -------equal to---------------------------------" + reserveTableValue1 );
                                break;
                            case "immediately settled":
                            case "auto settled":
                                nextEventPageObj.waitForMoreTime();
                                nextEventPageObj.waitForMoreTime();
                                getDriver().navigate().refresh();
                                nextEventPageObj.waitForMoreTime();
                                nextEventPageObj.waitForMoreTime();
                                getDriver().navigate().refresh();
                                try {
                                    Thread.sleep( 10000 );
                                    Thread.sleep( 10000 );
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                getDriver().navigate().refresh();
                                String statusValue = nextEventPageObj.findElement( By.xpath( nextEventPageObj.claimTable() + "/tr[2]/td[" + (subStatusColumn + 1) + "]" ) ).getText();
                                Assert.assertEquals( "Validating " + criteria.get( 0 ).get( j ), criteria.get( i ).get( j ), statusValue );
                                break;
                            case "on hold":
                            case "repudiated":
                            case "contribution claim":
                                nextEventPageObj.waitForMoreTime();
                                nextEventPageObj.waitForMoreTime();
                                getDriver().navigate().refresh();
                                nextEventPageObj.waitForMoreTime();
                                nextEventPageObj.waitForMoreTime();
                                getDriver().navigate().refresh();
                                String subStatusValue = nextEventPageObj.findElement( By.xpath( nextEventPageObj.claimTable() + "/tr[2]/td[" + (subStatusColumn + 1) + "]" ) ).getText();
                                Assert.assertTrue( "value should display as " + criteria.get( i ).get( j ), subStatusValue.equalsIgnoreCase( criteria.get( i ).get( j ) ) );
                                break;
                            case "information required":
                            case "claim closed":
                            case "payment rejected":
                            case "tma":
                                try {
                                    Thread.sleep( 85000L );
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                String statusValue1 = nextEventPageObj.findElement( By.xpath( nextEventPageObj.claimTable() + "/tr[2]/td[" + (statusColumn + 1) + "]" ) ).getText();
                                if (statusValue1.equalsIgnoreCase( "payment" )) {
                                    nextEventPageObj.waitForMoreTime();
                                    nextEventPageObj.waitForMoreTime();
                                    nextEventPageObj.waitForMoreTime();
                                    nextEventPageObj.waitForMoreTime();
                                    getDriver().navigate().refresh();
                                    nextEventPageObj.waitForMoreTime();
                                    nextEventPageObj.waitForMoreTime();
                                    nextEventPageObj.waitForMoreTime();
                                    nextEventPageObj.waitForMoreTime();
                                    getDriver().navigate().refresh();
                                }
                                getDriver().navigate().refresh();
                                System.out.println( "Waiting for application to reflect the claim status....." );
                                try {
                                    Thread.sleep( 15000L );
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                getDriver().navigate().refresh();
                                nextEventPageObj.waitForMoreTime();
                                nextEventPageObj.waitForMoreTime();
                                nextEventPageObj.waitForMoreTime();
                                nextEventPageObj.waitForMoreTime();
                                getDriver().navigate().refresh();
                                statusValue1 = nextEventPageObj.findElement( By.xpath( nextEventPageObj.claimTable() + "/tr[2]/td[" + (statusColumn + 1) + "]" ) ).getText();
                                System.out.println( "Value should display as " + statusValue1 );
                                Assert.assertTrue( "value should display as " + criteria.get( i ).get( j ), statusValue1.equalsIgnoreCase( criteria.get( i ).get( j ) ) );
                                break;
                            case "open":
                            case "claim repudiated":
                            case "claim submitted":
                            case "payment":
                                String statusValueopen = nextEventPageObj.findElement( By.xpath( nextEventPageObj.claimTable() + "/tr[2]/td[" + (statusColumn + 1) + "]" ) ).getText();
                                Assert.assertTrue( "value should display as " + criteria.get( i ).get( j ), statusValueopen.equalsIgnoreCase( criteria.get( i ).get( j ) ) );
                                break;
                            default:
                                double reserveTableValue2 = 1.0;
                                if (reserveAmount.contains( "," )) {
                                    reserveAmount.replaceAll( ",", "" );
                                    reserveTableValue2 = Double.parseDouble( reserveAmount.replaceAll( ",", "" ) );
                                } else {
                                    nextEventPageObj.waitForMoreTime();
                                    nextEventPageObj.waitForMoreTime();
                                    nextEventPageObj.waitForMoreTime();
                                    System.out.println( "checking reserve value before double conversion" + reserveTableValue2 );
                                    reserveTableValue2 = Double.parseDouble( reserveAmount );
                                    System.out.println( "checking reserve value after double conversion" + reserveTableValue2 );
                                }
                                System.out.println( "reserve value--------------in table----------------" + reserveTableValue2 );
                                System.out.println( "input value----------------------------------------" + criteria.get( i ).get( j ) );
                                Assert.assertTrue( reserveTableValue2 == Double.parseDouble( criteria.get( i ).get( j ) ) );
                        }
                    }
                }
            }
        }
    }

    public void validateClaimAmendmentsFootPrint(List<List<String>> lstFootPrintDetails) {
        List<WebElement> lstRows = financialPageObj.claimMovementTable().findElements( By.tagName( "tr" ) );
        int iMovementColIndex = 3;
        System.out.println( "iMovementColIndex====" + iMovementColIndex );
        int iMovementDateColIndex = 4;
        int iAgentColindex = 6;//5;
        int iReasonColIndex = 7;//6;
        int iLiabilityColIndex = 8;// 7;
        int iCauseCodeColIndex = 19;// 18;
        int iCauseSubCodeColIndex = 20;//19;
        int iClaimDetail1ColIndex = 24;//20;
        int iClaimDetail2ColIndex = 25;//21;
        int iClaimDescColIndex = 26;//22;
        int iLimitAndExcess = 9;//8;
        int iReserve = 14;//13;
        int iWhoApproved = 17;//16;
        int iPayment = 11;//10;
        int iUserDeduction = 10;//9;
        int iStatus = 16;//15;
        int iWhenAppronved = 18;//17;
        for (int j = 4; j < lstRows.size(); j++) {
            List<WebElement> lstWb = lstRows.get( j ).findElements( By.tagName( "td" ) );
            System.out.println( "col size===" + lstWb.size() );
            for (int k = 0; k < lstWb.size(); k++) {
                System.out.println( lstWb.get( k ).getText() );
            }
        }
        for (int row = 1; row < lstFootPrintDetails.size(); row++) {
            if (lstRows.size() >= lstFootPrintDetails.size() + 3) {
                int iTableRowIndex = row + 3;
                for (int column = 0; column < lstFootPrintDetails.get( 0 ).size(); column++) {
                    List<WebElement> lstCols = lstRows.get( iTableRowIndex ).findElements( By.tagName( "td" ) );
                    String strFieldName = lstFootPrintDetails.get( 0 ).get( column );
                    String strFieldValue = lstFootPrintDetails.get( row ).get( column );
                    if (!strFieldValue.equalsIgnoreCase( "<Blank>" )) {
                        switch (strFieldName.toLowerCase()) {
                            case "movement":
                                Assert.assertTrue( lstCols.get( iMovementColIndex ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "movementdatetime":
                                if (strFieldValue.equalsIgnoreCase( "CurrentDate" ) | strFieldValue.equalsIgnoreCase( "today" )) {
                                    String strDate = new SimpleDateFormat( "yyyy-MM-dd" ).format( new Date() );
                                    strFieldValue = strDate;
                                }
                                System.out.println( strFieldValue );
                                Assert.assertTrue( lstCols.get( iMovementDateColIndex ).getText().contains( strFieldValue ) );
//                                Assert.assertTrue(dateOperationsObj.isThisDateValid(lstCols.get(iMovementDateColIndex).getText(), "yyyy-MM-dd mm:ss"));
                                break;
                            case "agent":
                                if (strFieldValue.contains( "Agent" ) || strFieldValue.contains( "TestUser" ) || strFieldValue.contains( "Level" )) {
                                    Assert.assertTrue( lstCols.get( iAgentColindex ).getText().equalsIgnoreCase( userObj.getUserDetails( strFieldValue ).get( 0 ) ) );
                                } else
                                    Assert.assertTrue( lstCols.get( iAgentColindex ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "reason":
                                System.out.println( "RAseon-------------------" + lstCols.get( iReasonColIndex ).getText() );
                                Assert.assertTrue( lstCols.get( iReasonColIndex ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "liability":
                                System.out.println( "lstCols.get(iLiabilityColIndex).getText()---------------------" + lstCols.get( iLiabilityColIndex ).getText() );
                                System.out.println( "strFieldValue----------------" + strFieldValue );
                                Assert.assertTrue( lstCols.get( iLiabilityColIndex ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "causecode":
                                Assert.assertTrue( lstCols.get( iCauseCodeColIndex ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "causesubcode":
                                Assert.assertTrue( lstCols.get( iCauseSubCodeColIndex ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "claimdetail1":
                                System.out.println( "lstCols.get(iClaimDetail1ColIndex).getText()--------------" + lstCols.get( iClaimDetail1ColIndex ).getText() );
                                System.out.println( "strFieldValue--claimdetail1-------------------" + strFieldValue );
                                Assert.assertTrue( lstCols.get( iClaimDetail1ColIndex ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "claimdetail2":
                                Assert.assertTrue( lstCols.get( iClaimDetail2ColIndex ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "claimdescription":
                                Assert.assertTrue( lstCols.get( iClaimDescColIndex ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "limitandexcess":
                                System.out.println( "table value ---------------------------" + lstCols.get( iLimitAndExcess ).getText() );
                                System.out.println( "input value-----------------------------" + strFieldValue );
                                Assert.assertTrue( lstCols.get( iLimitAndExcess ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "reserve":
                                System.out.println( "table value ---------------------------" + lstCols.get( iReserve ).getText() );
                                System.out.println( "input value-----------------------------" + strFieldValue );
                                Assert.assertTrue( lstCols.get( iReserve ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "whoapproved":
                                System.out.println( "appro value ---------------------------" + lstCols.get( iWhoApproved ).getText() );
                                System.out.println( "input value-----------------------------" + strFieldValue );
                                Assert.assertTrue( lstCols.get( iWhoApproved ).getText().equalsIgnoreCase( userObj.getUserDetails( strFieldValue ).get( 0 ) ) );
                                break;
                            case "payment":
                                System.out.println( "paym value ---------------------------" + lstCols.get( iPayment ).getText() );
                                System.out.println( "input value-----------------------------" + strFieldValue );
                                Assert.assertTrue( lstCols.get( iPayment ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "userdeduction":
                                System.out.println( "userde value ---------------------------" + lstCols.get( iUserDeduction ).getText() );
                                System.out.println( "input value-----------------------------" + strFieldValue );
                                Assert.assertTrue( lstCols.get( iUserDeduction ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "status":
                                System.out.println( "status value ---------------------------" + lstCols.get( iStatus ).getText() );
                                System.out.println( "input value-----------------------------" + strFieldValue );
                                Assert.assertTrue( lstCols.get( iStatus ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "whenapproved":
                                if (strFieldValue.equalsIgnoreCase( "CurrentDate" ) | strFieldValue.equalsIgnoreCase( "today" )) {
                                    String strDate = new SimpleDateFormat( "yyyy-MM-dd" ).format( new Date() );
                                    strFieldValue = strDate;
                                }
                                System.out.println( "lstCols.get(iWhenAppronved).getText()lstCols.get(iWhenAppronved).getText()-----------" + lstCols.get( iWhenAppronved ).getText() );
                                Assert.assertTrue( lstCols.get( iWhenAppronved ).getText().contains( strFieldValue ) );
                                //   Assert.assertTrue(dateOperationsObj.isThisDateValid(lstCols.get(iWhenAppronved).getText(), "yyyy-MM-dd mm:ss"));
                                break;
                        }
                    }
                }
            } else {
                System.out.println( "table size-------------" + lstRows.size() );
                System.out.println( "input table size ---------------" + lstFootPrintDetails.size() );
                Assert.assertTrue( lstRows.size() >= (lstFootPrintDetails.size() + 2) );
            }
        }
    }

    public void captureDWPDetails(List<List<String>> parameters) {
        int listSize = parameters.size();
        for (int i = 0; i < listSize - 1; i++)
            for (int j = 0; j < listSize - 1; j++) {
                switch (parameters.get( 0 ).get( j )) {
                    case "Enter DWP Details":
                        System.out.println( "dwp options inside loop =========================" + parameters.get( 1 ).get( j ) );
                        Assert.assertTrue( "Recovery form checkbox was not diaplayed :" + dwpDetailsPageObj.dwpMandatoryFields( parameters.get( 1 ).get( j ) ), dwpDetailsPageObj.dwpMandatoryFields( parameters.get( 1 ).get( j ) ).isDisplayed() );
                        dwpDetailsPageObj.dwpMandatoryFields( parameters.get( 1 ).get( j ) ).click();
                        break;
                    case "Select DWP Details":
                        montrealConventionPageObj.airlinesSearchButton().click();
                        nextEventPageObj.switchToFrameById( montrealConventionPageObj.airlinesFrame() );
                        montrealConventionPageObj.txtAirlineType().sendKeys( parameters.get( 1 ).get( j ) );
                        nextEventPageObj.btnClick( montrealConventionPageObj.selectFilter() );
                        nextEventPageObj.btnClick( montrealConventionPageObj.selectFilterOperation() );
                        montrealConventionPageObj.airlinesSelect( parameters.get( 1 ).get( j ) ).click();
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                        break;

                }
            }
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        dwpDetailsPageObj.dwpSaveBtn().click();
    }

    public void verifyImmediateSettlementReason(List<List<String>> lstInput) {
        for (int i = 1; i < lstInput.size(); i++) {
            for (int j = 0; j < lstInput.get( 0 ).size(); j++) {
                switch (lstInput.get( 0 ).get( 0 )) {
                    case "Verify Immediate Settlement Reason":
                        System.out.println( "Immediate settlement reason----------------------------" + claimsRepudiationPageObj.immediateSettlementReason( lstInput.get( i ).get( j ) ).getText() );
//                        Assert.assertTrue("Immediate settlement reason should display ", claimsRepudiationPageObj.immediateSettlementReason(lstInput.get(i).get(j)).isDisplayed());
                        Assert.assertTrue( claimsRepudiationPageObj.immediateSettlementReason( lstInput.get( i ).get( j ) ).getText().equalsIgnoreCase( lstInput.get( i ).get( j ) ) );
                        break;
                }
            }
        }
    }

    public void verifyClaimProcessingAdviceMessage(List<List<String>> lstInput) {
        for (int i = 1; i < lstInput.size(); i++) {
            for (int j = 0; j < lstInput.get( 0 ).size(); j++) {
                if (lstInput.get( i ).get( j ).equalsIgnoreCase( "A CLAIM PAYMENT HAS FAILED" )) {
                    String paymentAdvice = claimsRepudiationPageObj.failedPaymentadvice().getText().toLowerCase();
                    Assert.assertTrue( paymentAdvice.contains( lstInput.get( i ).get( j ).toLowerCase() ) );
                } else {
                    System.out.println( "------------------------------------------------" + claimsRepudiationPageObj.repudiationReasonsWarning( lstInput.get( i ).get( j ) ).isDisplayed() );
                    Assert.assertTrue( claimsRepudiationPageObj.repudiationReasonsWarning( lstInput.get( i ).get( j ) ).isDisplayed() );
                }
            }
        }
    }

    public void verifycheckhelperfields(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "supplier":
                System.out.println( "Inside enter supplier" );
                if (fieldValue.equalsIgnoreCase( "True" )) {
                    claimsRepudiationPageObj.check_Supplier().click();
                }
                break;
            case "customer":
                System.out.println( "Inside select Customer" );
                if (fieldValue.equalsIgnoreCase( "True" )) {
                    claimsRepudiationPageObj.check_customer().click();
                }
                break;
            case "next of kin":
                System.out.println( "Inside select next of kin" );
                if (fieldValue.equalsIgnoreCase( "True" )) {
                    claimsRepudiationPageObj.check_nextofkin().click();
                }
                break;
        }
    }

    public void validatePaymentTableData(List<List<String>> lstPaymentDetails) {
        this.navigateToFinancial();
        List<WebElement> lstRows = financialPageObj.claimsPaymentTable().findElements( By.tagName( "tr" ) );
        int iPaymentMethod = 7;//6;//5;
        int iChequeStatus = 9;//6;
        int iBACSStatus = 10;//9;//8;
        int iPaymentStatus = 14;// 12;
        int iWhoApproved = 15;//14;
        int iWhenApproved = 17;// 16;
        int paymentAmount = 5;//4;


        for (int j = 4; j < lstRows.size(); j++) {
            List<WebElement> lstWb = lstRows.get( j ).findElements( By.tagName( "td" ) );
            System.out.println( "col size===" + lstWb.size() );
            for (int k = 0; k < lstWb.size(); k++) {
                System.out.println( lstWb.get( k ).getText() );
            }
        }
        for (int row = 1; row < lstPaymentDetails.size(); row++) {
            if (lstRows.size() >= lstPaymentDetails.size() + 3) {
                int iTableRowIndex = row + 3;
                for (int column = 0; column < lstPaymentDetails.get( 0 ).size(); column++) {
                    List<WebElement> lstCols = lstRows.get( iTableRowIndex ).findElements( By.tagName( "td" ) );
                    String strFieldName = lstPaymentDetails.get( 0 ).get( column );
                    System.out.println( "column********" + column );
                    System.out.println( "strFieldName********" + strFieldName );
                    String strFieldValue = lstPaymentDetails.get( row ).get( column );
                    System.out.println( "strFieldValue********" + strFieldValue );
                    System.out.println( "row********" + row );
                    if (!strFieldValue.equalsIgnoreCase( "<Blank>" )) {
                        switch (strFieldName.toLowerCase()) {
                            case "payment method":
                                System.out.println( "payment methid column vlaue --------------------------" + lstCols.get( iPaymentMethod ).getText() );
                                Assert.assertTrue( lstCols.get( iPaymentMethod ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "cheque status":
                                System.out.println( "cheque status column vlaue --------------------------" + lstCols.get( iChequeStatus ).getText() );
                                if (strFieldValue.equalsIgnoreCase( "Completed" )) {
                                    System.out.println( "--------inside if in payment---------------------" );
                                    Assert.assertTrue( "Cheque status is comepleted------------------" + lstCols.get( iChequeStatus ).getText(), lstCols.get( iChequeStatus ).getText().equalsIgnoreCase( " " ) );
                                } else if (strFieldValue.equalsIgnoreCase( "Pending" )) {
                                    System.out.println( "into else if looooooooop*********************" );
                                    System.out.println( "lstCols.get(iChequeStatus).getText()***********" + lstCols.get( iChequeStatus ).getText() );
                                    Assert.assertTrue( lstCols.get( iChequeStatus ).getText().equalsIgnoreCase( strFieldValue ) );
                                } else {
                                    Assert.assertTrue( lstCols.get( iChequeStatus ).getText().equalsIgnoreCase( strFieldValue ) );
                                }
                                break;
                            case "bacs status":
                                System.out.println( "BACS methid column vlaue --------------------------" + lstCols.get( iBACSStatus ).getText() );
                                if (strFieldValue.equalsIgnoreCase( "Completed" )) {
                                    System.out.println( "--------inside if in payment---------------------" );
                                    Assert.assertTrue( "Cheque status is comepleted------------------" + lstCols.get( iBACSStatus ).getText(), lstCols.get( iBACSStatus ).getText().equalsIgnoreCase( " " ) );
                                } else
                                    Assert.assertTrue( lstCols.get( iBACSStatus ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "payment status":
                                System.out.println( "payment status column vlaue --------------------------" + lstCols.get( iPaymentStatus ).getText() );
                                Assert.assertTrue( lstCols.get( iPaymentStatus ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "whoapproved":
                                System.out.println( "appro value ---------------------------" + lstCols.get( iWhoApproved ).getText() );
                                System.out.println( "input value-----------------------------" + strFieldValue );
                                Assert.assertTrue( lstCols.get( iWhoApproved ).getText().equalsIgnoreCase( userObj.getUserDetails( strFieldValue ).get( 0 ) ) );
                                break;
                            case "whenapproved":
                                if (strFieldValue.equalsIgnoreCase( "CurrentDate" ) | strFieldValue.equalsIgnoreCase( "today" )) {
                                    String strDate = new SimpleDateFormat( "dd-MM-yyyy" ).format( new Date() );
                                    strFieldValue = strDate;
                                }
                                System.out.println( "IWhenApproved----------------------" + lstCols.get( iWhenApproved ).getText() );
                                System.out.println( "Argument-------------" + strFieldValue );
                                Assert.assertTrue( lstCols.get( iWhenApproved ).getText().contains( strFieldValue ) );
                                break;
                            case "payment amount paid":
                                System.out.println( "Payment amount from AQ -------------------" + lstCols.get( paymentAmount ).getText() );
                                Assert.assertTrue( "Payment amount--" + lstCols.get( paymentAmount ).getText(), lstCols.get( paymentAmount ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                        }
                    }
                }
            } else {
                Assert.assertTrue( lstRows.size() >= (lstPaymentDetails.size() + 3) );
            }
        }
    }

    public void validateClaimItemTable(List<List<String>> lstClaimItem) {
        List<WebElement> lstRows = claimCalculationPageObj.claimCalculationTable().findElements( By.tagName( "tr" ) );
        int iMovementColIndex = 3;
        System.out.println( "iMovementColIndex====" + iMovementColIndex );
        int iCause = 1;
        int iSubcause = 2;
        int iPerson = 3;
        int iDetail1 = 4;
        int iDetail2 = 5;
        int iAmount = 6;
        int iTotal = 12;
        int iPayment = 14;
        for (int j = 1; j < lstRows.size() - 1; j++) {
            List<WebElement> lstWb = lstRows.get( j ).findElements( By.tagName( "td" ) );
            System.out.println( "col size===" + lstWb.size() );
            for (int k = 0; k < lstWb.size(); k++) {
                System.out.println( "column value----------------" + lstWb.get( k ).getText() );
            }
        }
        for (int row = 1; row < lstClaimItem.size(); row++) {
            if (lstRows.size() >= lstClaimItem.size() + 1) {
                int iTableRowIndex = row + 1;
                for (int column = 0; column < lstClaimItem.get( 0 ).size(); column++) {
                    List<WebElement> lstCols = lstRows.get( iTableRowIndex ).findElements( By.tagName( "td" ) );
                    String strFieldName = lstClaimItem.get( 0 ).get( column );
                    String strFieldValue = lstClaimItem.get( row ).get( column );
                    if (!strFieldValue.equalsIgnoreCase( "<Blank>" )) {
                        switch (strFieldName.toLowerCase()) {
                            case "cause":
                                System.out.println( "payment methid column vlaue --------------------------" + lstCols.get( iCause ).getText() );
                                Assert.assertTrue( lstCols.get( iCause ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "subcause":
                                System.out.println( "cheque status column vlaue --------------------------" + lstCols.get( iSubcause ).getText() );
                                System.out.println( "--------inside if in payment---------------------" );
                                Assert.assertTrue( "Cheque status is comepleted------------------" + lstCols.get( iSubcause ).getText(), lstCols.get( iSubcause ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "person":
                                Assert.assertTrue( "Person------------------" + lstCols.get( iPerson ).getText(), lstCols.get( iPerson ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "detail1":
                                Assert.assertTrue( "detail1------------------" + lstCols.get( iDetail1 ).getText(), lstCols.get( iDetail1 ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "detail2":
                                Assert.assertTrue( "detail2------------------" + lstCols.get( iDetail2 ).getText(), lstCols.get( iDetail2 ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "amount":
                                Assert.assertTrue( "amount------------------" + lstCols.get( iAmount ).getText(), lstCols.get( iAmount ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "total":
                                Assert.assertTrue( "total------------------" + lstCols.get( iTotal ).getText(), lstCols.get( iTotal ).getText().equalsIgnoreCase( strFieldValue ) );
                                break;
                            case "payment":
                                System.out.println( "Checkbox displayed --------------------" + lstCols.get( iPayment ).findElement( By.xpath( "//input[@type='checkbox']" ) ).isDisplayed() );
                                break;
                        }
                    }
                }
            } else {
                Assert.assertTrue( lstRows.size() >= (lstClaimItem.size() + 1) );
            }
        }
    }

    public void validateOtherPaymentTable(List<List<String>> otherPaymentDetails) {
        this.navigateToInternal();
        List<WebElement> columns = nextEventPageObj.findElements( By.xpath( claimPaymentPageObj.goodwillPaymentRecentRecord() ) );
        int otherPaymentType = 3;
        int goodwillPaymentType = 4;
        int paymentAmount = 5;
        int paymentDescription = 6;
        int colpaymentTRID = 7;
        for (int i = 0; i < otherPaymentDetails.get( 0 ).size(); i++) {
            switch (otherPaymentDetails.get( 0 ).get( i ).toLowerCase()) {
                case "other payment type":
                    System.out.println( "other payment type -------------------" + columns.get( otherPaymentType ).getText() );
                    Assert.assertTrue( "other type displayed wrongly--" + columns.get( otherPaymentType ).getText(), columns.get( otherPaymentType ).getText().equalsIgnoreCase( otherPaymentDetails.get( 1 ).get( i ) ) );
                    break;
                case "goodwill payment type":
                    System.out.println( "other payment type -------goodwillPaymentType------------" + columns.get( goodwillPaymentType ).getText() );
                    Assert.assertTrue( "other type displayed wrongly--" + columns.get( goodwillPaymentType ).getText(), columns.get( goodwillPaymentType ).getText().equalsIgnoreCase( otherPaymentDetails.get( 1 ).get( i ) ) );
                    break;
                case "payment amount":
                    System.out.println( "other payment type -------paymentAmount------------" + columns.get( paymentAmount ).getText() );
                    Assert.assertTrue( "other type displayed wrongly--" + columns.get( paymentAmount ).getText(), columns.get( paymentAmount ).getText().equalsIgnoreCase( otherPaymentDetails.get( 1 ).get( i ) ) );
                    break;
                case "payment description":
                    this.paymentTRID = columns.get( colpaymentTRID ).getText();
                    System.out.println( "TRID_______________________________________" + paymentTRID );
                    System.out.println( "other payment type ----------paymentDescription---------" + columns.get( paymentDescription ).getText() );
                    Assert.assertTrue( "other type displayed wrongly--" + columns.get( paymentDescription ).getText(), columns.get( paymentDescription ).getText().equalsIgnoreCase( otherPaymentDetails.get( 1 ).get( i ) ) );
                    break;
            }
        }
    }

    public void validatePaymentTableRecord(List<List<String>> otherPaymentDetails) {
        List<WebElement> columns = nextEventPageObj.findElements( By.xpath( claimPaymentPageObj.paymentRecordForGoodWill( paymentTRID ) ) );
        int paymentDate = 17;//15;
        int authorisedBy = 15;//14;
        int paymentAmount = 5;//4;
        for (int i = 0; i < otherPaymentDetails.get( 0 ).size(); i++) {
            switch (otherPaymentDetails.get( 0 ).get( i ).toLowerCase()) {
                case "authorised by":
                    System.out.println( "other payment type -------------------" + columns.get( authorisedBy ).getText() );
                    Assert.assertTrue( "other type displayed wrongly--" + columns.get( authorisedBy ).getText(), columns.get( authorisedBy ).getText().equalsIgnoreCase( userObj.getUserDetails( otherPaymentDetails.get( 1 ).get( i ) ).get( 0 ) ) );
                    break;
                case "payment date":
                    System.out.println( "other payment type -------------------" + columns.get( paymentDate ).getText() );
                    Assert.assertTrue( "other type displayed wrongly--" + columns.get( paymentDate ).getText(), columns.get( paymentDate ).getText().contains( this.sysDate ) );
                    break;
                case "payment amount paid":
                    System.out.println( "other payment type -------------------" + columns.get( paymentAmount ).getText() );
                    Assert.assertTrue( "other type displayed wrongly--" + columns.get( paymentAmount ).getText(), columns.get( paymentAmount ).getText().equalsIgnoreCase( otherPaymentDetails.get( 1 ).get( i ) ) );
                    break;
                case "close":
                    nextEventPageObj.btnClick( perilsAndCostsPageObj.editClaimSaveAndCloseBtn() );
                    commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_Loading(), 60L );
            }
        }
    }

    public void navigateToClaimViewFromPolicyView_one() {
        searchPageObj.switchToWindowByIndex( 1 );
        System.out.println( "inside navigate" );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        accountInformationPageObj.btnClick( accountInformationPageObj.moreLink() );
    }

    public void verifyClaimTable() {
        List<WebElement> rowElement = nextEventPageObj.claimTableRows().findElements( By.tagName( "tr" ) );
        int rowCount = rowElement.size();
        System.out.println( "row----------------------" + rowCount );
    }

    public void amount() throws InterruptedException {
        schemeSummaryPageObj.txtAmtCancellation().sendKeys( "300" );
    }

//    public void newamount() throws InterruptedException {
//        basicClaimDetailsPageObj.newamountset().clear();
//        basicClaimDetailsPageObj.newamountset().sendKeys( "200" );
//    }

    public void assignshemeid(String id) throws InterruptedException {
        basicClaimDetailsPageObj.schemeidset().clear();
        basicClaimDetailsPageObj.schemeidset().sendKeys( id );
        System.out.println( "in claim operations id is $$$$$$$$$$$$$$$$$$$$" + id );
    }

    public void openscheme(String id) throws InterruptedException {
        basicClaimDetailsPageObj.schemeidsearch().clear();
        basicClaimDetailsPageObj.schemeidsearch().sendKeys( id );
        System.out.println( "in claim operations id is $$$$$$$$$$$$$$$$$$$$" + id );
    }

//    public void causeoptionselection() throws InterruptedException {
//        basicClaimDetailsPageObj.causeoptionselect().sendKeys( "Baggage" );
//    }

//    public void subcauseoptionselection() throws InterruptedException {
//        basicClaimDetailsPageObj.subcauseoptionselect().sendKeys( "Accidental Damage" );
//    }

//    public void claimdetailoptionselection() throws InterruptedException {
//        basicClaimDetailsPageObj.claimdetailoptionselect().sendKeys( "Single Item (Clothing, Toiletries, Bags etc.)" );
//    }
//
//    public void claimdetail2optionselection() throws InterruptedException {
//        basicClaimDetailsPageObj.claimdetail2optionselect().sendKeys( "Suitcase" );
//    }

//    public void applicationoptionselection() throws InterruptedException {
//        basicClaimDetailsPageObj.applicationoptionselect().sendKeys( "Per Claim" );
//    }

    public void closingClaimAndValidateReasons_WithReserve() {
        System.out.println( "Providing confirmation" );
        claimsRepudiationPageObj.claimCloseConfirmationResponse();
        claimsRepudiationPageObj.claimCloseConfirmationResponse().click();
        claimsRepudiationPageObj.claimCloseConfirmationResponse_Yes().click();
        claimsRepudiationPageObj.claimReasonSelection();
        claimsRepudiationPageObj.claimReasonSelection().click();
        nextEventPageObj.switchToFrameByIndex( 0 );
        System.out.println( "validating the reason" );
        claimsRepudiationPageObj.claimReasonSelectionWindow();
        claimsRepudiationPageObj.claimReasonSelectionWindow().click();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        claimsRepudiationPageObj.claimCloseSaveBtn();
        claimsRepudiationPageObj.claimCloseSaveBtn().click();
        claimsRepudiationPageObj.readingReserveErrorMessage();
        String errorMessage = claimsRepudiationPageObj.readingReserveErrorMessage().getText();
        if (errorMessage != null) {
            Assert.assertTrue( errorMessage.equalsIgnoreCase( "You cannot close this claim as it still has a reserve. On the \"Close Claim\" event, you must select to clear the reserve." ) );
            System.out.println( "***********Not allowed to Close the Claim*********" + errorMessage );
        }
        nextEventPageObj.CancelBtn();
        nextEventPageObj.CancelBtn().click();
        nextEventPageObj.switchToDefault();
        claimSummaryPageObj.outOfProcessEvent().click();
        nextEventPageObj.btnClick( nextEventPageObj.go() );
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        navigationObj.navigateToNextEventType( strEventType );
        claimsRepudiationPageObj.clearTheReserve();
        claimsRepudiationPageObj.clearTheReserve().click();
        claimsRepudiationPageObj.claimCloseConfirmationResponse_Yes().click();
        claimsRepudiationPageObj.claimCloseSaveBtn();
        claimsRepudiationPageObj.claimCloseSaveBtn().click();
        nextEventPageObj.switchToDefault();
        System.out.println( "Verifying the claim close parameters " );
        claimsRepudiationPageObj.claimStatusInEventHistory();
        if (claimsRepudiationPageObj.claimStatusInEventHistory().getText().equalsIgnoreCase( "Claim Closed" )) {
            Assert.assertTrue( claimsRepudiationPageObj.claimStatusInEventHistory().getText().equalsIgnoreCase( "Claim Closed" ) );
            System.out.println( "********Claim has been closed*************" );
            System.out.println( "**********Claim closed details" );
            System.out.println( "Claim Status" + claimsRepudiationPageObj.claimStatusInEventHistory().getText() );
            System.out.println( "Claim closed time" + claimsRepudiationPageObj.claimClosedTime().getText() );
            System.out.println( "Claim closed By" + claimsRepudiationPageObj.claimClosedBy().getText() );
        } else {
            System.out.println( "OOPS!!!!!!!!!!!!! Claim not closed" );
        }
    }

    public void closingClaim_WithSubreasonAsUpgradeNotPurchased() {
        nextEventPageObj.switchToDefault();
        System.out.println( "Verifying the claim close parameters " );
        claimsRepudiationPageObj.claimStatusInEventHistory();
        if (claimsRepudiationPageObj.claimStatusInEventHistory().getText().equalsIgnoreCase( "Upgrade Sales" )) {
            Assert.assertTrue( claimsRepudiationPageObj.claimStatusInEventHistory().getText().equalsIgnoreCase( "Upgrade Sales" ) );
            System.out.println( "********Upgrade sales event is generated*************" );
            claimsRepudiationPageObj.claimStatusInEventHistory().click();
            nextEventPageObj.switchToFrameById( claimsRepudiationPageObj.UpgradeSales_Frame() );
            Assert.assertTrue( claimsRepudiationPageObj.UpgradeSales_EventText().getText().contains( "Upgrade Potential flagged" ) );
            System.out.println( "Upgrade Potential Flag has been generated" );
            nextEventPageObj.switchToDefault();
        } else {
            System.out.println( "OOPS!!!!!!!!!!!!!" );
        }
    }

    public void reOpenClosedClaim() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        navigationObj.navigateToNextEventType( strEventType_Reopen );
    }

    public void validateReasonsforReopeningClaim(List<List<String>> listInput) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        claimsRepudiationPageObj.reOpenReasonDropdown();
        claimsRepudiationPageObj.reOpenReasonDropdown().click();
        for (int row = 1; row < listInput.size(); row++) {
            for (int column = 0; column < listInput.get( 0 ).size(); column++) {
                System.out.println( "Option verified" + listInput.get( row ).get( column ) );
                claimsRepudiationPageObj.reOpenReason( listInput.get( row ).get( column ) ).isDisplayed();
                Assert.assertTrue( claimsRepudiationPageObj.reOpenReason( listInput.get( row ).get( column ) ).isDisplayed() );
            }
        }
    }

    public void notAllowedToReopenLineItem() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        navigationObj.navigateToNextEventType( strEventType_Reopen_Line );
        nextEventPageObj.verifyNotallowedToOpenClaimItem();
        Assert.assertTrue( nextEventPageObj.verifyNotallowedToOpenClaimItem().getText().equalsIgnoreCase( "There are no claim items." ) );
        System.out.println( "*************There are no Claim Item to Re-open************" );
        nextEventPageObj.CancelBtn();
        nextEventPageObj.CancelBtn().click();
    }

    public void amendClaimDetailsInTheReopenedClaim(String eventType, List<List<String>> parameters) {
        String searchValue = "United Kingdom Pounds";
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        navigationObj.navigateToNextEventType( eventType );
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( i ).size(); j++) {
                switch (parameters.get( 0 ).get( j ).toLowerCase()) {
                    case "cost":
                        System.out.println( "Inside Cost Case" );
                        nextEventPageObj.switchToFrameById( nextEventPageObj.fancyFrame() );
                        perilsAndCostsPageObj.editClaimitem();
                        perilsAndCostsPageObj.editClaimitem().click();
                        perilsAndCostsPageObj.waitForMoreTime();
                        List<WebElement> lstOptions = new Select( perilsAndCostsPageObj.costTypeCurrency() ).getOptions();
                        new Select( perilsAndCostsPageObj.costTypeCurrency() ).selectByIndex( (lstOptions.size() - 1) );
                        new Select( perilsAndCostsPageObj.costTypeCurrency() ).selectByVisibleText( searchValue );
                        perilsAndCostsPageObj.costTypeAmount();
                        perilsAndCostsPageObj.costTypeAmount().clear();
                        perilsAndCostsPageObj.costTypeAmount().sendKeys( parameters.get( i ).get( j ) );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        perilsAndCostsPageObj.saveClaimItem().isDisplayed();
                        perilsAndCostsPageObj.saveClaimItem().click();
                        perilsAndCostsPageObj.saveClaimDetailsIsDisplayed();
                        perilsAndCostsPageObj.saveClaimDetails().click();
                        nextEventPageObj.switchToDefault();
                        break;
                    case "new":
                        nextEventPageObj.switchToFrameById( nextEventPageObj.fancyFrame() );
                        nextEventPageObj.btnClick( perilsAndCostsPageObj.addPeril() );
                        this.validateClaimCause( eventType, "Save", parameters );
                        this.addPersonClaimCost();
                        nextEventPageObj.btnClick( perilsAndCostsPageObj.addClaimItem() );
                        this.validateClaimCostType( eventType, parameters );
                        perilsAndCostsPageObj.saveClaimItem().click();
                        this.sysDate = new SimpleDateFormat( "yyyy-MM-dd" ).format( new java.util.Date() ).toString();
                        System.out.println( "System date ------------------------" + this.sysDate );
                        break;
                }
            }
        }
    }

    public void selectFirstClaimInClaimTable() {
        claimSummaryPageObj.selectFirstClaimInClaimTable();
        claimSummaryPageObj.selectFirstClaimInClaimTable().click();
    }

    public void retrieveClaimID() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimID = nextEventPageObj.selectedClaimID().getText();
        System.out.println( "claim ID retrieved to compare " + claimID );
    }

    public void retrieveTableRowID() {
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
        financialPageObj.retrieveTableRowIDFromFinancialTable();
        tableRowID = financialPageObj.retrieveTableRowIDFromFinancialTable().getText();
        System.out.println( "Table Row ID" + tableRowID );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick( financialPageObj.closeWindow_FinancialTab() );
    }

    public void enterMandatoryDataForPaymentFailureEvent(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "payref":
                System.out.println( "Inside Payment reference" );
                this.enterPaymentReferenceID( fieldValue );
                break;
            case "failure code":
                System.out.println( "Inside fail code" );
                this.enterFailureCode( fieldValue );
                break;
            case "file name":
                System.out.println( "Inside fail name" );
                this.enterFileName( fieldValue );
                break;
            case "action":
                System.out.println( "Inside save" );
                nextEventPageObj.saveBtn();
                nextEventPageObj.saveBtn().click();
                break;
        }
    }

    public void enterPaymentReferenceID(String str) {
        if (!str.equalsIgnoreCase( strNoValueEntryString ) && !str.isEmpty() && str != null) {
            if (str.equals( "rowid" )) {
                System.out.println( "Verifying the table row id:" + tableRowID );
                nextEventPageObj.referenceTableRowId().clear();
                nextEventPageObj.referenceTableRowId().sendKeys( tableRowID );
            } else {
                System.out.println( "Table rowId not valid" );
            }
        }
    }

    public void enterFailureCode(String str) {
        nextEventPageObj.failureCode().clear();
        if (!str.equalsIgnoreCase( strNoValueEntryString ) && !str.isEmpty() && str != null) {
            nextEventPageObj.failureCode().sendKeys( str );
        }
    }

    public void enterFileName(String str) {
        nextEventPageObj.fileName().clear();
        if (!str.equalsIgnoreCase( strNoValueEntryString ) && !str.isEmpty() && str != null) {
            nextEventPageObj.fileName().sendKeys( str );
        }
    }

    public void validateEventAndClaimStatus(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "status":
                System.out.println( "Inside claim status verification" );
                this.validateClaimStatus( fieldValue );
                break;
            case "event":
                System.out.println( "Inside Payment Failed" );
                this.validateEvent( fieldValue );
                break;
        }
    }

    public void validateClaimStatus(String str) {
        if (!str.equalsIgnoreCase( strNoValueEntryString ) && !str.isEmpty() && str != null) {
            claimSummaryPageObj.verifyStatus();
            if (claimSummaryPageObj.verifyStatus().getText().equalsIgnoreCase( str )) {
                System.out.println( "Claim status has been changed to Payment Failed" );
            }
        }
    }

    public void validateEvent(String str) {
        if (!str.equalsIgnoreCase( strNoValueEntryString ) && !str.isEmpty() && str != null) {
            if ((claimSummaryPageObj.verifyPaymentFailedEvent().getText().equalsIgnoreCase( "Payment failed" )) && (claimSummaryPageObj.verifyPaymentFailedEvent().getText().equalsIgnoreCase( str ))) {
                System.out.println( "Payment Failure and Payment Failure event has been generated" );
            }
        }
    }

    public void validateclaimdetailsinNextTask(String CaseID1) {
        claimSummaryPageObj.getNextTask().click();
        String[] splitcaseId = nextEventPageObj.validateClaimID().getText().split( " " );
        System.out.println( "Case ID in referral user----------" + splitcaseId[0] );
        while (!(splitcaseId[0].equalsIgnoreCase( CaseID1 ))) {
            if (nextEventPageObj.elementDisplayed( claimSummaryPageObj.getNextTask() )) {
                System.out.println( "Inside Get Next Task" );
                claimSummaryPageObj.getNextTask().click();
            }
            if (nextEventPageObj.elementDisplayed( claimSummaryPageObj.escalateTask() )) {
                System.out.println( "Inside Escalate Task" );
                claimSummaryPageObj.escalateTask().click();
                new Select( claimSummaryPageObj.escalateReasonDropDown() ).selectByVisibleText( escalationReason );
                claimSummaryPageObj.escalateReasonOkbtn().click();
            }
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            System.out.println( "CaseID......." + nextEventPageObj.validateClaimID() );
        }
        if (nextEventPageObj.elementDisplayed( claimSummaryPageObj.escalateTask() )) {
            System.out.println( "Inside Escalate Task" );
            claimSummaryPageObj.escalateTask().click();
            new Select( claimSummaryPageObj.escalateReasonDropDown() ).selectByVisibleText( escalationReason );
            claimSummaryPageObj.escalateReasonOkbtn().click();
        }
    }

    public void validateClaimAllocation(String customer) {
        int i = 0;
        claimSummaryPageObj.getNextTask().click();
        nextEventPageObj.waitForMoreTime();
        System.out.println( "Customer Name from aquarium" + claimSummaryPageObj.customerName().getText() );
        while (!(claimSummaryPageObj.customerName().getText().equalsIgnoreCase( customer ))) {
            System.out.println( "Counter:" + (++i) );
            System.out.println( "Inside get Next task loop" );
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            WebElement rows = claimSummaryPageObj.findElement( By.xpath( claimSummaryPageObj.namePeopleRows() ) );
            List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();
            List<WebElement> rowElements = rows.findElements( By.xpath( claimSummaryPageObj.namePeopleRowsTableData() ) );
            ArrayList<String> rowData = new ArrayList<String>();
            for (WebElement column : rowElements) {
                rowData.add( column.getText().toString() );
            }
            rowsData.add( rowData );
            System.out.println( " " + rowsData );
            if ((rowsData.contains( customer ))) {
                Assert.assertTrue( (rowsData.contains( customer )) );
                System.out.println( "claim has been allocated" + customer );
                System.out.println( "Row data" + rowsData.toString() );
            } else if (!(rowsData.contains( customer ))) {
                Assert.assertTrue( !(rowsData.contains( customer )) );
                System.out.println( "No such claim" );
                if (nextEventPageObj.elementDisplayed( claimSummaryPageObj.getNextTask() )) {
                    System.out.println( "Inside Get Next Task" );
                    claimSummaryPageObj.getNextTask().click();
                }
                if (nextEventPageObj.elementDisplayed( claimSummaryPageObj.escalateTask() )) {
                    System.out.println( "Inside Escalate Task" );
                    claimSummaryPageObj.escalateTask().click();
                    new Select( claimSummaryPageObj.escalateReasonDropDown() ).selectByVisibleText( escalationReason );
                    claimSummaryPageObj.escalateReasonOkbtn().click();
                }
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
            }
        }
    }

    public void validateClaimNotAllocated(String customer, String warning) {
        Assert.assertTrue( claimSummaryPageObj.getNextTask().isDisplayed() );
        claimSummaryPageObj.getNextTask().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (claimSummaryPageObj.errorMessage().isDisplayed()) {
            Assert.assertTrue( claimSummaryPageObj.errorMessage().getText().equalsIgnoreCase( warning ) );
        } else {

            WebElement caseIDElement = manageWorkflowTaskPageObj.caseIdInWorkflow( caseID );
            while (!caseIDElement.isDisplayed()) {
                System.out.println( "Inside Escalate Task" );
                claimSummaryPageObj.escalateTask().click();
                new Select( claimSummaryPageObj.escalateReasonDropDown() ).selectByVisibleText( escalationReason );
                claimSummaryPageObj.escalateReasonOkbtn().click();
                claimSummaryPageObj.errorMessage().isDisplayed();
            }
        }
    }

    public void navigateToClaimViewFromPolicyViewAnotherPolicy() {
        nextEventPageObj.switchToLastOpenWindow();
        System.out.println( "window title" + getDriver().getTitle() );
        accountInformationPageObj.btnClick( accountInformationPageObj.moreLink() );
    }

    public void verifySanctionCheck() {
        claimSummaryPageObj.sanctionCheck();
        System.out.println( "Verify Sanction check box is displayed" + claimSummaryPageObj.sanctionCheck().isDisplayed() );
        Assert.assertTrue( claimSummaryPageObj.sanctionCheck().isDisplayed() );
        financialPageObj.closeWindow_FinancialTab();
        financialPageObj.closeWindow_FinancialTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void addNewPerson(List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get( 0 ).size(); column++) {
                this.addNewPersonDetails( parameters.get( 0 ).get( column ), parameters.get( row ).get( column ) );
            }
            perilsAndCostsPageObj.claimSavePeril().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void addNewPersonDetails(String searchField, String searchValue) {
        switch (searchField.toLowerCase()) {
            case "title":
                System.out.println( "Select title" );
                new Select( perilsAndCostsPageObj.selectTitle() ).selectByVisibleText( searchValue );
                break;
            case "firstname":
                System.out.println( "Enter firstName" );
                perilsAndCostsPageObj.firstName().clear();
                perilsAndCostsPageObj.firstName().sendKeys( searchValue );
                break;
            case "lastname":
                System.out.println( "Enter lastName" );
                perilsAndCostsPageObj.lastName().clear();
                perilsAndCostsPageObj.lastName().sendKeys( searchValue );
                break;
            case "dob":
                System.out.println( "Enter dob" );
                perilsAndCostsPageObj.enterdob().clear();
                perilsAndCostsPageObj.enterdob().sendKeys( searchValue );
                break;
            case "type":
                System.out.println( "Enter type" );
                new Select( perilsAndCostsPageObj.selectType() ).selectByVisibleText( searchValue );
                break;
        }
    }

    public List<List<String>> getPerilQuestions(List<List<String>> parameters, int perilRow) {
        List<List<String>> perilQuestions = new ArrayList<>();
        String dataRecord = (parameters.get( perilRow ).get( 0 )) + "Ques";
        System.out.println( dataRecord );
        List<String> headerDetails = fileOperationsObj.getPerilQuestions( dataRecord );
        perilQuestions.add( headerDetails );
        List<String> recordDetails = fileOperationsObj.getPerilQuestions( parameters.get( perilRow ).get( 0 ) );
        perilQuestions.add( recordDetails );
        return perilQuestions;
    }

    public void comments() throws InterruptedException {
        policyDataFieldsPageObj.amountset().sendKeys( "testtt" );
    }

    public void captureMontrealConvention(List<List<String>> parameters) {
        int listSize = parameters.size();
        for (int i = 1; i < listSize; i++) {
            montrealConventionPageObj.flightNumber().sendKeys( parameters.get( i ).get( 0 ) );
            montrealConventionPageObj.airlinesSearchButton().click();
            nextEventPageObj.switchToFrameById( montrealConventionPageObj.airlinesFrame() );
            montrealConventionPageObj.txtAirlineType().sendKeys( parameters.get( i ).get( 1 ) );
            nextEventPageObj.btnClick( montrealConventionPageObj.selectFilter() );
            nextEventPageObj.btnClick( montrealConventionPageObj.selectFilterOperation() );
            montrealConventionPageObj.airlinesSelect( parameters.get( i ).get( 1 ) ).click();
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
            System.out.println( "Displayed------------------" + montrealConventionPageObj.airlinesSearchButton().isDisplayed() );
            String airlinesName = montrealConventionPageObj.airlinesName().getAttribute( "value" );
            System.out.println( "airlines---------------------" + airlinesName );
            montrealConventionPageObj.PIRNumber().sendKeys( parameters.get( i ).get( 2 ) );
            Assert.assertTrue( "value in flight name should display as " + parameters.get( i ).get( 1 ), airlinesName.trim().contains( parameters.get( i ).get( 1 ).trim() ) );
        }
        montrealConventionPageObj.airlinesSaveBtn().click();
    }

    public void validateMontrealConvention(List<List<String>> parameters) {
        int listSize = parameters.size();
        for (int i = 1; i < listSize; i++) {
            montrealConventionPageObj.flightNumber().sendKeys( parameters.get( i ).get( 0 ) );
            montrealConventionPageObj.airlinesSearchButton().click();
            nextEventPageObj.switchToFrameById( montrealConventionPageObj.airlinesFrame() );
            montrealConventionPageObj.airlinesNameFilter().sendKeys( airlinesName );
            montrealConventionPageObj.airlinesNameFilterImg().click();
            montrealConventionPageObj.containFilter().click();
            montrealConventionPageObj.airlinesSelect( airlinesName ).click();
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
            System.out.println( "Displayed------------------" + montrealConventionPageObj.airlinesSearchButton().isDisplayed() );
            String airlinesNameDisplayed = montrealConventionPageObj.airlinesName().getAttribute( "value" );
            System.out.println( "airlines---------airlinesNameDisplayed------------" + airlinesNameDisplayed );
            montrealConventionPageObj.PIRNumber().sendKeys( parameters.get( i ).get( 2 ) );
            System.out.println( "get(1)..." + airlinesNameDisplayed.trim().contains( airlinesName.trim() ) );
            System.out.println( "get(0)..." + airlinesNameDisplayed.trim().contains( parameters.get( i ).get( 0 ).trim() ) );
            Assert.assertTrue( "value in flight name should display as " + airlinesName, airlinesName.trim().contains( airlinesNameDisplayed.trim() ) );
        }
        claimSummaryPageObj.cancel_btn().click();
    }

    public void airlinesDetails(List<List<String>> lstInput) {
        montrealConventionPageObj.lnkEditAirlines().click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( montrealConventionPageObj.airlinesFrameConfig() );
        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println( "----------------i value ------------------" + i );
            for (int j = 0; j < lstInput.get( 0 ).size(); j++) {
                System.out.println( "----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get( 0 ).get( j ).toLowerCase() );
                this.enterDetails( lstInput.get( 0 ).get( j ), lstInput.get( i ).get( j ) );
            }
        }
        this.addAirlinesDetails();
    }

    public void amendAirlinesDetails(List<List<String>> lstInput) {
        montrealConventionPageObj.lnkEditAirlines().click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( montrealConventionPageObj.airlinesFrameConfig() );
        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println( "----------------i value ------------------" + i );
            for (int j = 0; j < lstInput.get( 0 ).size(); j++) {
                System.out.println( "----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get( 0 ).get( j ).toLowerCase() );
                this.enterDetails( lstInput.get( 0 ).get( j ), lstInput.get( i ).get( j ) );
            }
        }
        this.addAirlinesDetails();
    }

    private void enterDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "name":
                fieldValue = randomGeneratorObj.randomString( 4 );
                airlinesName = fieldValue;
                System.out.println( "airlinesName-------------------" + airlinesName );
                montrealConventionPageObj.txtAirlinesName().clear();
                montrealConventionPageObj.txtAirlinesName().sendKeys( fieldValue );
                break;
            case "address":
                montrealConventionPageObj.txtAirlinesAddress().clear();
                montrealConventionPageObj.txtAirlinesAddress().sendKeys( fieldValue );
                break;
            case "email address":
                montrealConventionPageObj.txtAirlinesEmail().clear();
                montrealConventionPageObj.txtAirlinesEmail().sendKeys( fieldValue );
                break;
            case "title":
                if (fieldValue.equalsIgnoreCase( "Mrs" )) {
                    montrealConventionPageObj.airlinesTitle().click();
                    nextEventPageObj.waitForMoreTime();
                    montrealConventionPageObj.drpdnAirlinesMrsTitle( fieldValue ).click();
                } else {
                    montrealConventionPageObj.airlinesTitle().click();
                    nextEventPageObj.waitForMoreTime();
                    montrealConventionPageObj.drpdnAirlinesTitle( fieldValue ).click();
                }
                break;
            case "first name":
                montrealConventionPageObj.txtAirlinesFirstName().clear();
                montrealConventionPageObj.txtAirlinesFirstName().sendKeys( fieldValue );
                break;
            case "last name":
                montrealConventionPageObj.txtAirlinesLastName().clear();
                montrealConventionPageObj.txtAirlinesLastName().sendKeys( fieldValue );
                break;
            case "preferred contact method":
                montrealConventionPageObj.airlinesPrefContact().click();
                nextEventPageObj.waitForMoreTime();
                montrealConventionPageObj.drpdnAirlinesPrefContact( fieldValue ).click();
                break;
            case "select airlines":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                montrealConventionPageObj.airlinesNameFilter().sendKeys( airlinesName );
                montrealConventionPageObj.airlinesNameFilterImg().click();
                montrealConventionPageObj.containFilter().click();
                System.out.println( "Select the airlines---" + montrealConventionPageObj.lnkSelectAirlines( airlinesName ) );
                nextEventPageObj.btnClick( montrealConventionPageObj.lnkSelectAirlines( airlinesName ) );
                nextEventPageObj.waitForMoreTime();
                break;
        }
    }

    public void addAirlinesDetails() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        montrealConventionPageObj.btnAddAirlines().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.btnClick( montrealConventionPageObj.btnClose() );
    }

    public void addInsurerDetails() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        montrealConventionPageObj.btnAddAirlines().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void insurerDetails(List<List<String>> lstInput) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        otherInsurerPageObj.lnkEditOtherInsurer().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( otherInsurerPageObj.insurerFrame() );
        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println( "----------------i value ------------------" + i );
            for (int j = 0; j < lstInput.get( 0 ).size(); j++) {
                System.out.println( "----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get( 0 ).get( j ).toLowerCase() );
                this.enterInsurerDetails( lstInput.get( 0 ).get( j ), lstInput.get( i ).get( j ) );
            }
        }
        this.addInsurerDetails();
    }

    private void enterInsurerDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "name":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                otherInsurerPageObj.insurerName().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                otherInsurerPageObj.drpdnInsurerName( fieldValue ).click();
                break;
            case "address":
                otherInsurerPageObj.txtAddress().clear();
                otherInsurerPageObj.txtAddress().sendKeys( fieldValue );
                break;
            case "email address":
                otherInsurerPageObj.txtEmail().clear();
                otherInsurerPageObj.txtEmail().sendKeys( fieldValue );
                break;
            case "title":
                if (fieldValue.equalsIgnoreCase( "Mrs" )) {
                    otherInsurerPageObj.contactTitle().click();
                    nextEventPageObj.waitForMoreTime();
                    otherInsurerPageObj.drpdnInsurerMrsTitle( fieldValue ).click();
                } else {
                    otherInsurerPageObj.contactTitle().click();
                    nextEventPageObj.waitForMoreTime();
                    otherInsurerPageObj.drpdnInsurerTitle( fieldValue ).click();
                }
                break;
            case "first name":
                otherInsurerPageObj.txtInsurerFirstName().clear();
                otherInsurerPageObj.txtInsurerFirstName().sendKeys( fieldValue );
                break;
            case "last name":
                otherInsurerPageObj.txtInsurerLastName().clear();
                otherInsurerPageObj.txtInsurerLastName().sendKeys( fieldValue );
                break;
            case "preferred contact method":
                otherInsurerPageObj.insurerPrefContact().click();
                nextEventPageObj.waitForMoreTime();
                otherInsurerPageObj.drpdnInsurerPrefContact( fieldValue ).click();
                break;
            case "select brand":
            case "select insurer":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "Select the insurer---" + montrealConventionPageObj.lnkSelectAirlines( fieldValue ) );
                nextEventPageObj.btnClick( montrealConventionPageObj.lnkSelectAirlines( fieldValue ) );
                nextEventPageObj.waitForMoreTime();
                break;
            case "portal url":
                portalURL = montrealConventionPageObj.txtURL().getAttribute( "value" );
                System.out.println( "Configured Portal URL ------" + portalURL );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.btnClick( montrealConventionPageObj.btnClose() );
                break;
        }
    }

    public void todoMethod(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "validate added insurer":
                System.out.println( "Added insurer should display as-------" + otherInsurerPageObj.addedInsurer( fieldValue ) );
                Assert.assertTrue( "Added insurer should display ", otherInsurerPageObj.addedInsurer( fieldValue ).isDisplayed() );
                nextEventPageObj.switchToDefault();
                nextEventPageObj.btnClick( montrealConventionPageObj.btnClose() );
                break;
            case "delete added insurer":
                otherInsurerPageObj.lnkEditOtherInsurer().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( otherInsurerPageObj.insurerFrame() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick( montrealConventionPageObj.lnkDelete( fieldValue ) );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.btnClick( montrealConventionPageObj.btnClose() );
                break;
            case "delete added airlines":
                montrealConventionPageObj.lnkEditAirlines().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( montrealConventionPageObj.airlinesFrameConfig() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                montrealConventionPageObj.airlinesNameFilter().sendKeys( airlinesName );
                montrealConventionPageObj.airlinesNameFilterImg().click();
                montrealConventionPageObj.containFilter().click();
                nextEventPageObj.btnClick( montrealConventionPageObj.lnkDelete( airlinesName ) );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.btnClick( montrealConventionPageObj.btnClose() );
                break;
        }
    }

    public void amendInsurerDetails(List<List<String>> lstInput) {
        otherInsurerPageObj.lnkEditOtherInsurer().click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( otherInsurerPageObj.insurerFrame() );
        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println( "----------------i value ------------------" + i );
            for (int j = 0; j < lstInput.get( 0 ).size(); j++) {
                System.out.println( "----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get( 0 ).get( j ).toLowerCase() );
                this.enterInsurerDetails( lstInput.get( 0 ).get( j ), lstInput.get( i ).get( j ) );
            }
        }
        this.addAirlinesDetails();
    }

    public void retrieveDetails(String type, List<List<String>> lstInput) {
        montrealConventionPageObj.lnkEditPolicyType( type ).click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( otherInsurerPageObj.insurerFrame() );
        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println( "----------------i value ------------------" + i );
            for (int j = 0; j < lstInput.get( 0 ).size(); j++) {
                System.out.println( "----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get( 0 ).get( j ).toLowerCase() );
                this.enterInsurerDetails( lstInput.get( 0 ).get( j ), lstInput.get( i ).get( j ) );
            }
        }
    }

    public void validateEvidenceListed(List<List<String>> inputValues) {
        if (inputValues.get( 1 ).get( 0 ).equalsIgnoreCase( "na" )) {
            nextEventPageObj.btnClick( evidenceCollationPageObj.save() );
        } else {
            String[] questions = inputValues.get( 1 ).get( 0 ).split( "#" );
            List<WebElement> table = (List<WebElement>) getDriver().findElements( By.xpath( "//h2[text()='Evidence Collation']/../div/div/div/table/tbody/tr/td[3]" ) );
            System.out.println( "Question  size " + questions.length );
            System.out.println( "Question  size " + table.size() );
            for (int i = 0; i < questions.length; i++) {
                System.out.println( "i  size ------" + i );
                for (int j = 1; j < table.size(); j++) {
                    System.out.println( "j  size ------" + j );
                    System.out.println( "Input questions----------- --" + questions[i] );
                    System.out.println( " ----Displayed Question----" + evidenceCollationPageObj.evidenceCollationTableQues( j ).getText() );
                    if (questions[i].equalsIgnoreCase( evidenceCollationPageObj.evidenceCollationTableQues( j ).getText() )) {
                        Assert.assertEquals( questions[i], evidenceCollationPageObj.evidenceCollationTableQues( j ).getText() );
                        break;
                    }
                }
            }
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
            nextEventPageObj.btnClick( evidenceCollationPageObj.save() );
        }
    }

    public void reopenAClosedClaim(String ClaimNumber) {
        if (ClaimNumber.equalsIgnoreCase( "Second" )) {
            nextEventPageObj.clickOnSecondClaim().click();
        }
    }

    public void clickingUnderNextEventsAndButtons(String btnType) {
        switch (btnType.toLowerCase()) {
            case "proceed":
            case "go":
                System.out.println( "Inside go" );
                nextEventPageObj.switchToDefault();
                nextEventPageObj.waitForMoreTime();
                getDriver().navigate().refresh();
                nextEventPageObj.waitForMoreTime();
                commandsObj.waitForLoad( getDriver() );
                commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_Loading(), 60L );
                try {
                    nextEventPageObj.btnClick( nextEventPageObj.go() );
                } catch (Exception exe) {
                    nextEventPageObj.btnClick( nextEventPageObj.go() );
                }
                commandsObj.waitForLoad( getDriver() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "add a note":
                nextEventPageObj.waitForMoreTime();
                claimSummaryPageObj.noteEvent().click();
                nextEventPageObj.btnClick( nextEventPageObj.go() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "enter cheque details":
                nextEventPageObj.switchToDefault();
                basicClaimDetObj.enterChequeDetailsbtn().click();
                nextEventPageObj.btnClick( nextEventPageObj.go() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "edit first claim":
                basicClaimDetObj.getFirstOpenClaim().click();
                break;
            case "confirm air ambulance approval":
                tmaDetailsPageObj.confirmAirAmbulance().click();
                nextEventPageObj.btnClick( nextEventPageObj.go() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                tmaDetailsPageObj.tmaSelectedQuoteComments().sendKeys( btnType );
                break;
            case "edit selected claim":
                System.out.println( "Edite selected claim" );
                basicClaimDetObj.getSelectedClaim().click();
                break;
            case "back":
                System.out.println( "Click on back button" );
                policyDataFieldsPageObj.clickOnBack().click();
                break;
            case "out of process event":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "Inside out of process event" );
                if (nextEventPageObj.elementDisplayed( By.xpath( claimsRepudiationPageObj.validateretrieveClaimID() ) )) {
                    claimIDVerificationInCutomerPortal = claimsRepudiationPageObj.retrieveClaimID().getText();
                    System.out.println( "Retrieved Claim ID" + claimIDVerificationInCutomerPortal );
                }
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimSummaryPageObj.outOfProcessEvent().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                try {
                    nextEventPageObj.btnClick( nextEventPageObj.go() );
                } catch (Exception exe) {
                    commandsObj.waitForLoad( getDriver() );
                    nextEventPageObj.btnClick( nextEventPageObj.go() );
                }
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "gp check generated":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimSummaryPageObj.gpcheckgeneratedEvent().click();
                nextEventPageObj.btnClick( nextEventPageObj.go() );
                nextEventPageObj.waitForMoreTime();
                break;
            case "add an out of process event":
                nextEventPageObj.waitForMoreTime();
                System.out.println( "Inside Add an out of process event" );
                nextEventPageObj.btnClick( claimSummaryPageObj.outOfProcessEvent() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick( nextEventPageObj.go() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "close edit claim":
                nextEventPageObj.btnClick( perilsAndCostsPageObj.editClaimSaveAndCloseBtn() );
                commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_Loading(), 60L );
                break;
            case "ok":
                nextEventPageObj.CancelBtn().click();
                nextEventPageObj.waitForMoreTime();
                break;
            case "refresh":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                getDriver().navigate().refresh();
                commandsObj.waitForLoad( getDriver() );
                break;
            case "save":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                evidenceCollationPageObj.claimCalculationSave().click();
                break;
            case "tmasave":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                evidenceCollationPageObj.btnSavebutton().click();
                break;
            case "tmacancel":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                evidenceCollationPageObj.btnCancelbutton().click();
                break;
            case "show full event history":
                getDriver().navigate().refresh();
                commandsObj.waitForLoad( getDriver() );
                fullEventHistoryPageObj.showFullEventHistory().click();
                nextEventPageObj.switchToLastOpenWindow();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                getDriver().navigate().refresh();
                break;
            case "verify full event history":
                fullEventHistoryPageObj.showFullEventHistory().click();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToWindowByIndex( 2 );
                getDriver().getTitle();
                System.out.println( "Verifying full event history" );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "edit base policy":
                policySummaryPageObj.basePolicyEdit().click();
                break;
            case "cancel":
                try {
                    if (nextEventPageObj.frame().isDisplayed()) {
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                        nextEventPageObj.btnClick( nextEventPageObj.CancelBtn() );
                        nextEventPageObj.switchToDefault();
                    } else {
                        nextEventPageObj.btnClick( nextEventPageObj.CancelBtn() );
                    }
                } catch (Exception e) {
                    nextEventPageObj.btnClick( nextEventPageObj.CancelBtn() );
                }
                break;
            case "add a jumpto event":
                nextEventPageObj.btnClick( claimSummaryPageObj.jumpToEvent() );
                nextEventPageObj.btnClick( nextEventPageObj.go() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "quote and buy":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                accountInformationPageObj.quoteAndBuyLink().click();
                break;
            case "save bank account":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick( claimPaymentPageObj.savePaymentBtn() );
                commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_PleasewaitLocator(), 60L );
                commandsObj.waitForLoad( nextEventPageObj.getDriver );
                getDriver().navigate().refresh();
                commandsObj.waitForLoad( nextEventPageObj.getDriver );
                commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_Loading(), 60L );
                break;
            case "save existing bank account":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                nextEventPageObj.waitForMoreTime();
                policySummaryPageObj.radioExistingBankAccount().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                policySummaryPageObj.saveBankAccount().click();
                System.out.println( "Inside go" );
                nextEventPageObj.switchToDefault();
                nextEventPageObj.btnClick( nextEventPageObj.go() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "save existing cheque details":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                nextEventPageObj.waitForMoreTime();
                policySummaryPageObj.radioExistingCheque().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimPaymentPageObj.btnVerifyAccount().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                policySummaryPageObj.saveChequeAccount().click();
                System.out.println( "Inside go" );
                nextEventPageObj.switchToDefault();
                nextEventPageObj.btnClick( nextEventPageObj.go() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "pay with saved cheque details":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                nextEventPageObj.waitForMoreTime();
                policySummaryPageObj.radioExistingCheque().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                policySummaryPageObj.saveChequeAccount().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                nextEventPageObj.waitForMoreTime();
                policySummaryPageObj.paymentCommentSave().click();
                break;
            case "save payment":
                if (btnType.equalsIgnoreCase( "new" )) {
                    claimPaymentPageObj.savePaymentBtn().click();
                } else {
                    claimPaymentPageObj.selectPayee( btnType ).click();
                }
                break;
            case "view billing details":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                policySummaryPageObj.waitForPageLoad();
                policySummaryPageObj.waitForPageLoad();
                policySummaryPageObj.viewBillingDetailsLink().click();
                nextEventPageObj.waitForMoreTime();
                break;
            case "view claim details":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                policySummaryPageObj.waitForPageLoad();
                policySummaryPageObj.waitForPageLoad();
                claimSummaryPageObj.viewClaim().click();
                nextEventPageObj.waitForMoreTime();
                break;
            case "ledger":
                System.out.println( "Inside Ledger" );
                policySummaryPageObj.ledgerBtn().click();
                break;
            case "close full event window":
                nextEventPageObj.btnClick( fullEventHistoryPageObj.closeWindow() );
                nextEventPageObj.switchToLastOpenWindow();
                break;
            case "insert":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                supplierDetailsPageObj.invoiceDetailsInsertBtn().click();
                break;
            case "approve or reject rush payment":
                nextEventPageObj.waitForMoreTime();
                System.out.println( "Inside Add an out of process event" );
                claimSummaryPageObj.approveRejectRushPayment().click();
                nextEventPageObj.btnClick( nextEventPageObj.go() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "raise bulk payment":
                nextEventPageObj.waitForMoreTime();
                System.out.println( "Inside Add an out of process event" );
                claimSummaryPageObj.raiseBulkPayment().click();
                nextEventPageObj.btnClick( nextEventPageObj.go() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "card":
                nextEventPageObj.waitForMoreTime();
                try {
                    System.out.println( "Waiting for payment type validation...." );
                    Thread.sleep( 6000l );
                    policySummaryPageObj.btnAccounts().click();
                    policySummaryPageObj.waitForPageLoad();
                    policySummaryPageObj.waitForPageLoad();
                    Assert.assertTrue( policySummaryPageObj.txtCardPayment( btnType ).isDisplayed() );
                    System.out.println( "Account type is validated" );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                nextEventPageObj.waitForMoreTime();
                policySummaryPageObj.btnBack().click();
                policySummaryPageObj.waitForPageLoad();
                break;
            case "bank":
                try {
                    System.out.println( "Waiting for payment type validation...." );
                    Thread.sleep( 6000l );
                    nextEventPageObj.waitForMoreTime();
                    policySummaryPageObj.btnAccounts().click();
                    policySummaryPageObj.waitForPageLoad();
                    policySummaryPageObj.waitForPageLoad();
                    Assert.assertTrue( policySummaryPageObj.txtCardPayment( btnType ).isDisplayed() );
                    System.out.println( "Account type is validated" );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                nextEventPageObj.waitForMoreTime();
                policySummaryPageObj.btnBack().click();
                policySummaryPageObj.waitForPageLoad();
                break;
            case "purchases":
                try {
                    System.out.println( "Waiting for payment amount and date validation...." );
                    Thread.sleep( 600l );
                    nextEventPageObj.waitForMoreTime();
                    policySummaryPageObj.purchaseBtn().click();
                    policySummaryPageObj.waitForPageLoad();
                    policySummaryPageObj.waitForPageLoad();

                    DateFormat dateFormat = new SimpleDateFormat( "dd/MM/YYYY" );
                    Date newdate = new Date();
                    String strDate = dateFormat.format( newdate );
                    System.out.println( "System date:" + strDate );
                    Assert.assertTrue( policySummaryPageObj.txtpurchaseDate( strDate ).isDisplayed() );
                    System.out.println( "Purchase date is validated" );
                    Assert.assertTrue( policySummaryPageObj.txtpurchasedAmount( paymentAmount ).isDisplayed() );
                    System.out.println( "Purchased amount is validated" );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                policySummaryPageObj.btnBack().click();
                policySummaryPageObj.waitForPageLoad();
                break;
            case "save_repudiation":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                nextEventPageObj.waitForPageLoad();
                nextEventPageObj.btnClick( nextEventPageObj.saveBtn() );
                System.out.println( "Repudiation details are saved" );
                break;
            case "payment account without validation":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.btnClick( claimSummaryPageObj.paymentAccountWithoutValidation() );
                try {
                    nextEventPageObj.btnClick( nextEventPageObj.go() );
                } catch (Exception exe) {
                    nextEventPageObj.btnClick( nextEventPageObj.go() );
                }
                commandsObj.waitForLoad( getDriver() );
                break;
            case "enter air ambulance flight schedule":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.waitForMoreTime();
                commandsObj.waitForLoad( getDriver() );
                commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_Loading(), 60L );
                try {
                    nextEventPageObj.btnClick( nextEventPageObj.go() );
                } catch (Exception exe) {
                    nextEventPageObj.btnClick( nextEventPageObj.go() );
                }
                commandsObj.waitForLoad( getDriver() );
                tmaDetailsPageObj.selectedAirAmbulanceFlightScheduleComments().sendKeys( "test" );
                policyDataFieldsPageObj.policySave().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "card edit":
                nextEventPageObj.waitForMoreTime();
                policySummaryPageObj.cardEditButton().click();
                nextEventPageObj.waitForPageLoad();
                claimSummaryPageObj.close().click();
                nextEventPageObj.waitForPageLoad();
            case "next action: collate evidence":
            case "NEXT ACTION: Select Payee (Customer)":
            case "NEXT ACTION: Enter Medical Case Details":
            case "NEXT ACTION: Return Claim to Travel Incident Management":
            case "NEXT ACTION: Clearance Required?":
                nextEventPageObj.VerifyNextAction( btnType ).click();
                nextEventPageObj.btnClick( nextEventPageObj.go() );
                break;
            case "save_details":
                nextEventPageObj.btnClick( nextEventPageObj.saveBtn() );
                break;
            case "NEXT ACTION: Partial Repudiation Letter Options":
                nextEventPageObj.btnClick( nextEventPageObj.go() );
                break;
            case "next":
                System.out.println( "INTO NEXT BUTTON*****" );
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                nextEventPageObj.nextButtonSensitive().click();
            case "goto":
                System.out.println( "Inside goto" );
                nextEventPageObj.switchToDefault();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                commandsObj.waitForLoad( getDriver() );
                commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_Loading(), 60L );
                try {
                    nextEventPageObj.btnClick( nextEventPageObj.go() );
                } catch (Exception exe) {
                    nextEventPageObj.btnClick( nextEventPageObj.go() );
                }
                commandsObj.waitForLoad( getDriver() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
        }
    }

    public void navigateToEventType(String strEventType) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        System.out.println( "field name --------------------" + strEventType );
        navigationObj.navigateToNextEventType( strEventType );
    }

    public void selectAccountNumber(String accountNo) throws Throwable {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        claimPaymentPageObj.selectAccountDetail( accountNo ).click();
        nextEventPageObj.waitForPageLoad();
        claimPaymentPageObj.btnVerifyAccount().click();
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.waitForMoreTime();
        claimPaymentPageObj.savePaymentBtn().click();
    }

    public void selectAccountNumberValidation(String accountNo) throws Throwable {
        String validationSplit[] = accountNo.split( "#" );
        System.out.println( "claim amount----------------------- remodified" + claimAmount.split( "\\." )[0] );
        String amt = "";
        if (!partialItemsAmount.equals( "" )) {
            claimAmount = partialItemsAmount;
        }
        if (!claimAmount.equals( "" )) {
            if (claimAmount.contains( "." )) {
                System.out.println( "claim amount -----------split---------" + claimAmount.split( "\\." )[0] );
                amt = claimAmount.split( "\\." )[0];
            } else {
                amt = claimAmount;
            }
            Integer amount = Integer.parseInt( amt );
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
            claimPaymentPageObj.selectAccountDetail( validationSplit[0] ).click();
            nextEventPageObj.waitForPageLoad();
            if (amount > 500) {
                if (accountNo.equalsIgnoreCase( "Cheque" )) {
                    claimPaymentPageObj.btnVerifyAccount().click();
                    claimPaymentPageObj.savePaymentBtn().click();
                } else {
                    claimPaymentPageObj.btnVerifyAccount().click();
                    nextEventPageObj.waitForPageLoad();
                    if (validationSplit.length > 1) {
                        Assert.assertTrue( claimPaymentPageObj.verifyBankValidationMessage( validationSplit[1] ).isDisplayed() );
                    }
                    nextEventPageObj.waitForMoreTime();
                    if (commandsObj.elementDisplayedWithLessTime( By.xpath( claimPaymentPageObj.buttonnVerifyAccount() ) )) {
                        claimPaymentPageObj.btnVerifyAccount().click();
                    }
                    claimPaymentPageObj.savePaymentBtn().click();
//                    claimPaymentPageObj.btnOverrideResult().click();
                }
            } else {
                System.out.println( "into else loop" );
                if (validationSplit.length > 1) {
                    Assert.assertTrue( claimPaymentPageObj.verifyBankValidationMessage( validationSplit[1] ).isDisplayed() );
                }
                if (accountNo.equalsIgnoreCase( "Cheque" )) {

                    if (commandsObj.elementDisplayedWithLessTime( By.xpath( claimPaymentPageObj.buttonnVerifyAccount() ) )) {
                        claimPaymentPageObj.btnVerifyAccount().click();
                    }

                }
                claimPaymentPageObj.savePaymentBtn().click();
            }
        } else {
            System.out.println( "into final else loop**************" );
            if (accountNo.equalsIgnoreCase( "Cheque" )) {
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                claimPaymentPageObj.selectAccountDetail( validationSplit[0] ).click();
                try {
                    if (claimPaymentPageObj.verifyBankValidationMessage( "Payment amount is less than £500, does not need verification." ).isDisplayed()) {
                        System.out.println( "MESS DISPLAYED-----------------------" );

                        claimPaymentPageObj.savePaymentBtn().click();
                    }
                } catch (Exception e) {
                    System.out.println( "MESS NOT DISPLAYED-----------------------" );
                    claimPaymentPageObj.btnVerifyAccount().click();
                    claimPaymentPageObj.savePaymentBtn().click();
                }
            }
        }
    }

    public void selectPaymentMethod(String method) throws Throwable {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        new Select( claimPaymentPageObj.createPayment() ).selectByVisibleText( method );
        nextEventPageObj.nextButtonSensitive().click();
        claimPaymentPageObj.goodwillSave().click();
    }

    public void validateTMAEmail(String event, String message) throws Throwable {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
        Assert.assertTrue( event.equalsIgnoreCase( nextEventPageObj.recoveryEvent( event ).getText() ) );
        System.out.println( "Event has been verified" + event );
        this.validateTMAEmailContent( event, message );
    }

    public void validateTMAEmailContent(String event, String message) throws Throwable {
        nextEventPageObj.recoveryEvent( event ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frameEditEvent() );
        System.out.println( "window title" + getDriver().getTitle() );
        nextEventPageObj.emailTabInTMAEvent().click();
        nextEventPageObj.waitForMoreTime();
        System.out.println( "Input message" + message );
        System.out.println( "TMA Email message" + nextEventPageObj.emailContentInTMAEvent().getText() );
        Assert.assertTrue( nextEventPageObj.emailContentInTMAEvent().getText().equalsIgnoreCase( message ) );
        nextEventPageObj.noteCloseButton().click();
        nextEventPageObj.waitForMoreTime();
    }

    public void CaptureDisclaimerRequest(String option) {
        nextEventPageObj.switchToDefault();
        this.clickingUnderNextEventsAndButtons( "Out Of Process event" );
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        System.out.println( "field name --------------------" + option );
        navigationObj.navigateToNextEventType( option );
        nextEventPageObj.btnClick( nextEventPageObj.createAndSendEmail() );
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
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
        System.out.println( "Event has been verified" + option );
    }

    public void claimasclaimclosed() {
        accountInformationPageObj.selectclaimasclaimclosed().click();
        System.out.println( "@@@@@@@ after click claim Page @@@@@@@@@@@" );
    }

    public void enterDOBOfCustomer(String dob) {
        claimPaymentPageObj.enterDOBtxtBox().sendKeys( dob );
        claimPaymentPageObj.updateCustomerbtn().click();
    }

    public void retrieveTMAcaseid() {
        basicClaimDetailsPageObj.medicalReportRequestEmailLink().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToLastOpenWindow();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frameEditEvent() );
        basicClaimDetailsPageObj.moreInfoLink().click();
        nextEventPageObj.waitForMoreTime();
        tmaCaseID = perilQuestionsPageObj.retrievecaseID().getText();
        System.out.println( "Retrived TMA case id in the event history" );
        nextEventPageObj.noteCloseButton().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateRepudiateClaimItems(List<List<String>> parameters) {
        String parameterValues = "";
        String reason, subReason = "";
        try {
            List<WebElement> lineItemsCheckbox = nextEventPageObj.findElements( By.xpath( claimPaymentPageObj.claimImtemCheckboxXpath() ) );
            System.out.println( "line items-----------------------------" + lineItemsCheckbox.size() );
            parameterValues = parameters.get( 1 ).get( 0 );
            reason = parameters.get( 1 ).get( 1 );
            subReason = parameters.get( 1 ).get( 2 );
            System.out.println( "line items value-----------------------------" + parameterValues );
            switch (parameterValues) {
                case "All":
                    for (int i = 0; i < lineItemsCheckbox.size(); i++) {
                        lineItemsCheckbox.get( i ).click();
                        new Select( claimsRepudiationPageObj.ReasonPrimaryDropdown( i + 2 ) ).selectByVisibleText( reason );
                        new Select( claimsRepudiationPageObj.ReasonSecDropdown( i + 2 ) ).selectByVisibleText( subReason );
                        System.out.println( "^^^^^^^^^^^^^^^^^^^^Save btn" );
                    }
                    break;
                case "Default":
                    lineItemsCheckbox.get( 0 ).click();
                    new Select( claimsRepudiationPageObj.ReasonPrimaryDropdown( 2 ) ).selectByVisibleText( reason );
                    new Select( claimsRepudiationPageObj.ReasonSecDropdown( 2 ) ).selectByVisibleText( subReason );
                    System.out.println( "^^^^^^^^^^^^^^^^^^^^Save btn" );
                    break;
            }
            claimsRepudiationPageObj.save().click();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void getCaseId() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        claimcaseid = policyDataFieldsPageObj.claimcaseid().getText();
        System.out.println( "case id in claim craetion is $$$$$$$$$$$$$$$$$$$$$$$$$$ %%%%%%%%%%%%%%%%%" + claimcaseid );
    }

    public void calculateFileSize() {
        long fileSize = 0;
        try {
            fileSize = this.fileSize();
            System.out.println( "file size----------------------------" + this.fileSize() );
            Assert.assertTrue( fileSize > 0 );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateMedicalType() {
        claimPaymentPageObj.clickOnMedicalImage().click();
        Assert.assertTrue( claimPaymentPageObj.medicalClaimTypeText().getText().equalsIgnoreCase( "Inpatient" ) );
    }

    public void validateMissingPersonFoundDetailsInLeadsTab(List<List<String>> lstInputs) {
        policyDataFieldsPageObj.leadsTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.tmaTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get( 0 ).size(); j++) {
                this.missingPersonFoundDetailsInLeadsTab( lstInputs.get( 0 ).get( j ), lstInputs.get( i ).get( j ) );
            }
        }
        claimSummaryPageObj.close().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    private void missingPersonFoundDetailsInLeadsTab(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "who is missing":
                Assert.assertTrue( policyDataFieldsPageObj.validateMissingPersonFields( fieldName ).isDisplayed() );
                Assert.assertTrue( policyDataFieldsPageObj.validateMissingPersonFieldValue( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "name and contact details of travelling companion if any":
                Assert.assertTrue( policyDataFieldsPageObj.validateTravellingCompanionFields( fieldName ).isDisplayed() );
                Assert.assertTrue( policyDataFieldsPageObj.validateTravellingCompanionFieldValue( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "name and contact details of any witnesses including last seen details date time location":
                Assert.assertTrue( policyDataFieldsPageObj.validateMissingPersonFields( fieldName ).isDisplayed() );
                Assert.assertTrue( policyDataFieldsPageObj.validateMissingPersonFieldValue( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "circumstances that led to the missing person report":
                Assert.assertTrue( policyDataFieldsPageObj.validateTravellingCompanionFields( fieldName ).isDisplayed() );
                Assert.assertTrue( policyDataFieldsPageObj.validateTravellingCompanionFieldValue( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "notify dlg media team":
                claimSummaryPageObj.close().click();
                nextEventPageObj.btnClick( tmaDetailsPageObj.lnkEditTMAclaim() );
                nextEventPageObj.waitForPageLoad();
                nextEventPageObj.btnClick( tmaDetailsPageObj.repatriationTab() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue( policyDataFieldsPageObj.validateTravellingCompanionFields( fieldName ).isDisplayed() );
                if (fieldValue.equalsIgnoreCase( "true" ))
                    Assert.assertTrue( policyDataFieldsPageObj.validateMediaTeamCKboxValidation( fieldName ).getAttribute( "value" ).equalsIgnoreCase( "true" ) );
                break;
            case "the foreign embassy has been notified":
            case "notify foreign embassy":
                Assert.assertTrue( policyDataFieldsPageObj.validateTravellingCompanionFields( fieldName ).isDisplayed() );
                if (fieldValue.equalsIgnoreCase( "true" )) {
                    Assert.assertTrue( policyDataFieldsPageObj.validateForeignEmbassyCKboxValidation( fieldName ).getAttribute( "value" ).equalsIgnoreCase( "true" ) );
                }
                break;
            case "foreign embassy contact details":
                Assert.assertTrue( policyDataFieldsPageObj.validateMissingPersonFields( fieldName ).isDisplayed() );
                Assert.assertTrue( policyDataFieldsPageObj.validateMissingPersonFieldValue( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "travelling companion":
                Assert.assertTrue( policyDataFieldsPageObj.validateMissingPersonFields( fieldName ).isDisplayed() );
                Assert.assertTrue( policyDataFieldsPageObj.validateMissingPersonFieldValue( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Missing Person Found Details":
                Assert.assertTrue( policyDataFieldsPageObj.validateMissingPersonFieldValue( fieldName ).isDisplayed() );
                Assert.assertTrue( policyDataFieldsPageObj.validateMissingPersonFieldValue( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
        }
    }

    public void viewTMAClaim() {
        nextEventPageObj.switchToDefault();
        policyDataFieldsPageObj.viewClaim().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateClaimAllocatedToclaimHandler(String claimHandler) {
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
        System.out.println( "Claim Allocation" + policyDataFieldsPageObj.claimAllocation().getText() );
        Assert.assertTrue( policyDataFieldsPageObj.claimAllocation().getText().equalsIgnoreCase( claimHandler ) );
    }

    public void validateClaimUnallocatedWithClaimHandlerReason() {
        competencyOperationsObj.unallocatedClaimHandlerReason();
        nextEventPageObj.btnCloseWindow().click();
    }

    public void validateClaimHandlerInAutoGeneratedLetter(String event) {
        policyDataFieldsPageObj.eventGenerated( event ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frameEditEvent() );
        policyDataFieldsPageObj.emailTab().click();
        policyDataFieldsPageObj.claimHandlerFirstName( claimHandler.trim().split( " " )[0] );
        policyDataFieldsPageObj.claimHandlerLastName( claimHandler.trim().split( " " )[1] );
        System.out.println( "policyDataFieldsPageObj.claimHandlerFirs----------------------" + policyDataFieldsPageObj.claimHandlerSignature().getText() );
        Assert.assertTrue( "Claim Handler First Name verified", policyDataFieldsPageObj.claimHandlerFirstName( claimHandler.split( " " )[0] ).isDisplayed() );
        Assert.assertTrue( "Claim Handler Last Name verified", policyDataFieldsPageObj.claimHandlerLastName( claimHandler.split( " " )[1] ).isDisplayed() );
        nextEventPageObj.noteCloseButton().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
    }

    public void validateClaimHandlerDetails(List<List<String>> lstInput) {
        for (int i = 1; i < lstInput.size(); i++) {
            for (int j = 0; j < lstInput.get( 0 ).size(); j++) {
                this.claimHAndlerDetails( lstInput.get( 0 ).get( j ), lstInput.get( i ).get( j ) );
            }
        }
        policyDataFieldsPageObj.policySave().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    private void claimHAndlerDetails(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Claim Handler ID":
                System.out.println( "Claim handler first name --------------" + claimHandler );
                Assert.assertTrue( policyDataFieldsPageObj.vaidateClaimHandlerDetails( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Claim Handler First Name":
                System.out.println( "Claim handler first name --------------" + claimHandler );
                Assert.assertTrue( claimHandler.contains( policyDataFieldsPageObj.vaidateClaimHandlerDetails( fieldName ).getAttribute( "value" ) ) );
                break;
            case "Claim Handler Last Name":
                System.out.println( "Claim handler first name --------------" + claimHandler );
                Assert.assertTrue( claimHandler.contains( policyDataFieldsPageObj.vaidateClaimHandlerDetails( fieldName ).getAttribute( "value" ) ) );
                break;
            case "Claim Handler Email Address":
                Assert.assertTrue( policyDataFieldsPageObj.vaidateClaimHandlerDetails( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
        }
    }

    public void enterClaimHandlerDetails(List<List<String>> lstInput) {
        for (int i = 1; i < lstInput.size(); i++) {
            for (int j = 0; j < lstInput.get( 0 ).size(); j++) {
                this.enterClaimHandlerDetails( lstInput.get( 0 ).get( j ), lstInput.get( i ).get( j ) );
            }
        }
        policyDataFieldsPageObj.policySave().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    private void enterClaimHandlerDetails(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Claim Handler ID":
                policyDataFieldsPageObj.vaidateClaimHandlerDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "Claim Handler First Name":
                policyDataFieldsPageObj.vaidateClaimHandlerDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "Claim Handler Last Name":
                policyDataFieldsPageObj.vaidateClaimHandlerDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "Claim Handler Email Address":
                policyDataFieldsPageObj.vaidateClaimHandlerDetails( fieldName ).sendKeys( fieldValue );
                break;
        }
    }

    public void retrieveClaimHandler() {
        claimHandler = policyDataFieldsPageObj.retrieveClaimAssignedStatus().getText();
        Assert.assertFalse( claimHandler.equalsIgnoreCase( "Not Assigned" ) );
        claimID = policyDataFieldsPageObj.retrieveClaimID().getText();
    }

    public void validateRetrievedClaimHandler() {
        System.out.println( "Validation of retrieved Claim Handler" + this.claimHandler );
        System.out.println( "handler assigned in claim" + policyDataFieldsPageObj.retrieveClaimAssignedStatus().getText() );
        Assert.assertTrue( policyDataFieldsPageObj.retrieveClaimAssignedStatus().getText().equalsIgnoreCase( this.claimHandler ) );
    }

    public void validateClaimHandler(String handler) {
        System.out.println( "Handler" + policyDataFieldsPageObj.retrieveClaimAssignedStatus().getText() );
        if (handler.equalsIgnoreCase( "random" )) {
            System.out.println( "Handler" + competencyOperationsObj.userGenerated );
            Assert.assertTrue( policyDataFieldsPageObj.retrieveClaimAssignedStatus().getText().equalsIgnoreCase( competencyOperationsObj.userGenerated ) );
        } else {
            try {
                System.out.println( "Try---------------------------------" );
                Assert.assertTrue( policyDataFieldsPageObj.retrieveClaimAssignedStatus().getText().equalsIgnoreCase( handler ) );
            } catch (Error e) {
                System.out.println( "-------------------Exception occured-----------------------" );
                Assert.assertTrue( policyDataFieldsPageObj.retrieveClaimAssignedStatus().getText().equalsIgnoreCase( handler ) );
            }
        }
        System.out.println( "Handler" + policyDataFieldsPageObj.retrieveClaimAssignedStatus().getText() );
    }

    public void validateExistingClaimStatus() {
        System.out.println( "Existing claim handler" + policyDataFieldsPageObj.validateExistingClaimStatus( claimID ).getText() );
        System.out.println( "Retrieved HAndler" + claimHandler );
        Assert.assertTrue( policyDataFieldsPageObj.validateExistingClaimStatus( claimID ).getText().equalsIgnoreCase( claimHandler ) );
    }

    public void validateClaimAllocatedToAclaimHandler() {
        System.out.println( "Claim Allocation-----------" + policyDataFieldsPageObj.claimAllocation().getText() );
        claimHandler = policyDataFieldsPageObj.claimAllocation().getText();
        Assert.assertTrue( !policyDataFieldsPageObj.claimAllocation().getText().equalsIgnoreCase( null ) & !policyDataFieldsPageObj.claimAllocation().getText().equalsIgnoreCase( "Not Assigned" ) );
    }

    public void getClaimIdAndClaimItemId() {
        claimID = nextEventPageObj.firstClaimID().getText();
        System.out.println( "claimID-------------------------" + claimID );
        claimSummaryPageObj.editFirstClaim().click();
        claimSummaryPageObj.perilsAndCost().click();
        commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_Loading(), 60L );
        commandsObj.waitForLoad( claimSummaryPageObj.getDriver );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimItemId = claimSummaryPageObj.perilsAndCostClaimItemId().getText();
        System.out.println( "claimItemId------------------------" + claimItemId );
        claimSummaryPageObj.saveAndCloseBtn().click();
    }

    public void getquestionandAnswer(List<List<String>> questionID) {
        claimID = nextEventPageObj.firstClaimID().getText();
        System.out.println( "claimID-------------------------" + claimID );
        claimSummaryPageObj.editFirstClaim().click();
        claimSummaryPageObj.perilsAndCost().click();
        commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_Loading(), 60L );
        commandsObj.waitForLoad( claimSummaryPageObj.getDriver );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < questionID.size(); i++) {
            for (int j = 1; j < questionID.get( 0 ).size(); j++) {
                String id = questionID.get( i ).get( j - 1 );
                String ans = questionID.get( i ).get( j );
                System.out.println( "question ID ------------" + id + "-----Answer---------" + ans );
                if (id.contains( "Outcome" )) {
                    if (id.equalsIgnoreCase( "Outcome" )) {
                        Assert.assertTrue( claimSummaryPageObj.validateOutcome( id ).getText().equalsIgnoreCase( ans ) );
                    } else if (id.equalsIgnoreCase( "Outcome2" )) {
                        Assert.assertTrue( claimSummaryPageObj.validateOutcome2( id ).getText().equalsIgnoreCase( ans ) );
                    }
                } else {
                    if (ans.contains( "ConditionId" )) {
                        String conditionDeC = ans.split( ":" )[1].split( "," )[0];
                        String condition = ans.split( ":" )[2].split( "," )[0].substring( 1, ans.split( ":" )[2].split( "," )[0].length() - 1 );
                        System.out.println( "conditionDeC-------------------" + conditionDeC );
                        System.out.println( "condition-----------------" + condition );
                        String conditionDecFromGetText = claimSummaryPageObj.validateAnswer( id ).getText().split( ":" )[1].split( "," )[0];
                        String conditionFromPage = claimSummaryPageObj.validateAnswer( id ).getText().split( ":" )[2].split( "," )[0].substring( 1, claimSummaryPageObj.validateAnswer( id ).getText().split( ":" )[2].split( "," )[0].length() - 1 );
                        System.out.println( "conditionFromPage--------------------" + conditionFromPage );
                        System.out.println( "conditionDecFromGetText--------------------" + conditionDecFromGetText );
                        Assert.assertTrue( condition.equalsIgnoreCase( conditionFromPage ) );
                        Assert.assertTrue( conditionDeC.equalsIgnoreCase( conditionDecFromGetText ) );
                    } else {
                        Assert.assertTrue( claimSummaryPageObj.validateAnswer( id ).getText().equalsIgnoreCase( ans ) );
                        System.out.println( "Answers from app----------------------" + claimSummaryPageObj.validateAnswer( id ).getText() );
                    }
                }
            }
        }
        claimSummaryPageObj.saveAndCloseBtn().click();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateRequestTypeTemplate(List<String> parameters) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        claimSummaryPageObj.requestTypeImg().click();
        for (int i = 0; i < parameters.size(); i++) {
            System.out.println( "Value retrieved" + parameters.get( i ) );
            claimSummaryPageObj.requestTypeTemplate( parameters.get( i ) );
        }
        claimSummaryPageObj.requestTypeImg().click();
    }

    public void selectTemplate(String template) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        claimSummaryPageObj.requestTypeImg().click();
        claimSummaryPageObj.requestTypeTemplate( template ).click();
        nextEventPageObj.saveBtn().click();
    }

    public void validateTemplatePrePopulated(String template, String policyHolder) {
        claimSummaryPageObj.TMAClaim_editIcon( policyHolder ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.suppliersTab().click();
        claimSummaryPageObj.requestType( template ).isDisplayed();
        claimSummaryPageObj.close().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void enterChaseHours(String chasehours, List<List<String>> parameters) {
        this.clickingUnderNextEventsAndButtons( "Go" );
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        claimSummaryPageObj.enterChaseHours().clear();
        claimSummaryPageObj.enterChaseHours().sendKeys( chasehours );
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                this.enterCommuincationPreference( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
            }
        }
        policyDataFieldsPageObj.policySave().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void enterCommuincationPreference(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Communication Preference":
                claimSummaryPageObj.communicationPreferenceImg().click();
                claimSummaryPageObj.select_communicationPreference( fieldValue ).click();
                break;
        }
    }

    public void removeTemplate(String template, String policyHolder) {
        claimSummaryPageObj.TMAClaim_editIcon( policyHolder ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.supplier_internalTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.remove_supplier( template ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.saveAndCloseBtn().click();
    }

    public void validatePrepopulatedSupplier(String allocation, List<List<String>> parameters) {
        policySummaryPageObj.waitForPageLoad();
        policySummaryPageObj.waitForPageLoad();
        claimSummaryPageObj.viewClaim().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (allocation.equalsIgnoreCase( "allocate" )) {
            System.out.println( "Retrieved country from supplier" + country );
            System.out.println( "Retrieved country from claim " + claimSummaryPageObj.retrieveCountry_Claim().getText() );
            Assert.assertTrue( claimSummaryPageObj.retrieveCountry_Claim().getText().equalsIgnoreCase( country ) );
            tmaDetailsPageObj.lnkTMAClaim().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            this.clickingUnderNextEventsAndButtons( "Go" );
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
            for (int i = 1; i < parameters.size(); i++) {
                for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                    this.validateSupplierDetails( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
                }
            }
            policyDataFieldsPageObj.policySave().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        } else if (allocation.equalsIgnoreCase( "should not allocate" )) {
            System.out.println( "Retrieved country from supplier" + country );
            System.out.println( "Retrieved country from claim " + claimSummaryPageObj.retrieveCountry_Claim().getText() );
            Assert.assertTrue( claimSummaryPageObj.retrieveCountry_Claim().getText().equalsIgnoreCase( country ) );
            claimSummaryPageObj.navigateBackTMAClaim().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            this.clickingUnderNextEventsAndButtons( "Go" );
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
            for (int i = 1; i < parameters.size(); i++) {
                for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                    this.validateSupplierDetails( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
                }
            }
            policyDataFieldsPageObj.policySave().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void validateSupplierDetails(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Company Name":
                System.out.println( "Company Name retrieved" + claimSummaryPageObj.validatePrePopulatedSupplier( fieldName ).getAttribute( "value" ) );
                if(fieldValue.contains("That Taxi Company")) {
                    Assert.assertTrue(claimSummaryPageObj.validatePrePopulatedSupplier(fieldName).getAttribute("value").equalsIgnoreCase("That Taxi Company"));
                }else{
                    Assert.assertTrue( claimSummaryPageObj.validatePrePopulatedSupplier( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                    }
                    break;
            case "Supplier Type":
                System.out.println( "supplier Type retrieved" + claimSummaryPageObj.validatePrePopulatedSupplierType().getAttribute( "value" ) );
                if(fieldValue.contains("Taxi")) {
                    Assert.assertTrue(claimSummaryPageObj.validatePrePopulatedSupplierType().getAttribute("value").equalsIgnoreCase("Taxi"));
                }else{
                    Assert.assertTrue( claimSummaryPageObj.validatePrePopulatedSupplierType().getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                }
                break;
        }
    }

    public void validateMultiplePrepopulatedSuppliers(String policyHolder, List<List<String>> parameters) {
        claimSummaryPageObj.TMAClaim_editIcon( policyHolder ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.suppliersTab().click();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 1 ).size(); j++) {
                this.validateMultipleSupplierDetails( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
            }
        }
        claimSummaryPageObj.close().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateMultipleSupplierDetails(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Request Type":
                supplierRequestType = fieldName;
                System.out.println( "Request Type retrieved" + claimSummaryPageObj.requestType( fieldValue ).getText() );
                Assert.assertTrue( claimSummaryPageObj.requestType( fieldValue ).isDisplayed() );
                break;
            case "Request Status":
                System.out.println( "Request Status retrieved" + claimSummaryPageObj.validateSupplierRequestStatus( supplierRequestType ).getText() );
                Assert.assertTrue( claimSummaryPageObj.validateSupplierRequestStatus( supplierRequestType ).isDisplayed() );
                break;
        }
    }

    public void searchClaimThroughAdvanceSearchAndVerifyAmountPaid(String amount) {
        this.navigateToAdvanceSearch();
        nextEventPageObj.btnClick( policyDataFieldsPageObj.searchByID() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.selectDrop( schemeSummaryPageObj.filterByPolicytypeDropdown(), "Travel Claim" );
        policyDataFieldsPageObj.claimIdInput().sendKeys( this.claimID );
        policyDataFieldsPageObj.policySearchbtn();
        policyDataFieldsPageObj.policySearchbtn().click();
        commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_Loading(), 60L );
        policyDataFieldsPageObj.selectFirstRecord().click();
        commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_Loading(), 60L );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToLastOpenWindow();
        String amountFromPage = policyDataFieldsPageObj.amountPaidForTheClaim( this.claimID ).getText();
        System.out.println( "amountFromPage-------------main-------" + amountFromPage );
        Assert.assertTrue( amountFromPage.equalsIgnoreCase( amount ) );
        this.verifyAmountPaidInTnternalTab( amount );
        this.verifyAmountPaidInFinancialTab( amount );
    }

    public void retrieveAmountandExcess(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                this.retrieveLimtsandExcess( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
            }
        }
        nextEventPageObj.btnClick( claimSummaryPageObj.close() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void retrieveLimtsandExcess(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Cover":
                claimSummaryPageObj.retrieveCoverTerms( fieldValue ).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "Policy Limits-Claim Detail1":
                claimSummaryPageObj.coverTermsTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimSummaryPageObj.claimDetail1_PolicyLimits().clear();
                claimSummaryPageObj.claimDetail1_PolicyLimits().sendKeys( fieldValue );
                claimSummaryPageObj.claimDetail1_PolicyLimits_filter().click();
                claimSummaryPageObj.containsFilter().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                maxAmount_PolicyLimits = claimSummaryPageObj.maximumAmount_PolicyLimits( fieldValue ).getText();
                System.out.println( "Maximum Amount in Policy Limits" + maxAmount_PolicyLimits );
                break;
            case "Policy Limits-Cause":
                claimSummaryPageObj.coverTermsTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimSummaryPageObj.cause_PolicyLimits().clear();
                claimSummaryPageObj.cause_PolicyLimits().sendKeys( fieldValue );
                claimSummaryPageObj.cause_PolicyLimits_filter().click();
                claimSummaryPageObj.containsFilter().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();

                break;
            case "Policy Limits-SubCause":
                claimSummaryPageObj.coverTermsTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimSummaryPageObj.Subcause_PolicyLimits().clear();
                claimSummaryPageObj.Subcause_PolicyLimits().sendKeys( fieldValue );
                claimSummaryPageObj.Subcause_PolicyLimits_filter().click();
                claimSummaryPageObj.containsFilter().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "Policy Excess-Cause":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimSummaryPageObj.cause_PolicyExcess().clear();
                claimSummaryPageObj.cause_PolicyExcess().sendKeys( fieldValue );
                claimSummaryPageObj.cause_PolicyExcess_filter().click();
                claimSummaryPageObj.containsFilter().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                excessAmount_policy = claimSummaryPageObj.maximumAmount_PolicyExcess( fieldValue ).getText();
                System.out.println( "Excess Amount in Policy Limits" + excessAmount_policy );
                break;
        }
    }

    public void validateClaimDetailsInInternaltab(List<List<String>> parameters) {
        claimSummaryPageObj.editClaim().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.internalTab_Claim().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                this.validateClaimDetails( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
            }
        }
        claimSummaryPageObj.close().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateClaimDetails(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Claim Detail 1":
                System.out.println( "Claim Details1" + claimSummaryPageObj.claimDetail1().getText() );
                Assert.assertTrue( claimSummaryPageObj.claimDetail1().getText().equalsIgnoreCase( fieldValue ) );
                break;
            case "Claim Detail 2":
                System.out.println( "Claim Details2" + claimSummaryPageObj.claimDetail2().getText() );
                Assert.assertTrue( claimSummaryPageObj.claimDetail2().getText().equalsIgnoreCase( fieldValue ) );
                break;
            case "Claim Description":
                System.out.println( "Claim Description" + claimSummaryPageObj.claimDescription().getText() );
                Assert.assertTrue( claimSummaryPageObj.claimDescription().getText().equalsIgnoreCase( fieldValue ) );
                break;
            case "Claim Amount":
                System.out.println( "Claim Amount" + claimSummaryPageObj.claimAmount().getText() );
                Assert.assertTrue( claimSummaryPageObj.claimAmount().getText().equalsIgnoreCase( fieldValue ) );
                break;
            case "Currency Code":
                System.out.println( "Currency Code" + claimSummaryPageObj.currencyCode().getText() );
                Assert.assertTrue( claimSummaryPageObj.currencyCode().getText().equalsIgnoreCase( fieldValue ) );
                break;
            case "GBP":
                System.out.println( "GBP" + claimSummaryPageObj.gbp().getText() );
                Assert.assertTrue( claimSummaryPageObj.gbp().getText().equalsIgnoreCase( fieldValue ) );
                break;
            case "Excess":
                System.out.println( "Claim Excess" + claimSummaryPageObj.excess().getText() );
                Assert.assertTrue( claimSummaryPageObj.excess().getText().equalsIgnoreCase( "-" + excessAmount_policy ) );
                break;
            case "Total":
                System.out.println( "Claim Total" + claimSummaryPageObj.total().getText() );
                Assert.assertTrue( claimSummaryPageObj.total().getText().equalsIgnoreCase( fieldValue ) );
                break;
        }
    }

    public void retrieveCountry(String supplier) {
        navigationObj.navigateToCompanyDetails();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.tmaTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.supplierTypeInput().clear();
        claimSummaryPageObj.supplierTypeInput().sendKeys( supplier );
        claimSummaryPageObj.supplierTypeFilter().click();
        claimSummaryPageObj.containsFilter().click();
        nextEventPageObj.waitForMoreTime();
        country = claimSummaryPageObj.retrieveCountry().getText();
        System.out.println( "Retrieved country" + country );
        nextEventPageObj.btnClick( claimSummaryPageObj.close() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateWhoandWhenDetails(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                this.validateEventDetails( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
            }
        }
    }

    public void validateEventDetails(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "who was done":
                Assert.assertTrue( claimSummaryPageObj.whodone().getText().equalsIgnoreCase( fieldValue ) );
                break;
            case "when":
                if (fieldValue.equalsIgnoreCase( "CurrentDate" ) | fieldValue.equalsIgnoreCase( "today" )) {
                    String strDate = new SimpleDateFormat( "dd/MM/yyyy" ).format( new Date() );
                    fieldValue = strDate;
                }
                System.out.println( "Date retrieved from AQ" + claimSummaryPageObj.whendone().getText() );
                System.out.println( "Field value modified" + fieldValue );
                Assert.assertTrue( claimSummaryPageObj.whendone().getText().contains( fieldValue ) );
                break;
        }
    }

    private void verifyAmountPaidInFinancialTab(String amount) {
        policyDataFieldsPageObj.editGivenClaim( this.claimID ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        financialPageObj.financialTab().click();
        String amountFromPage = claimSummaryPageObj.totalAmountPaidDisplayedFromFinancialTab().getText();
        System.out.println( "amountFromPage-------------financial-------" + amountFromPage );
        Assert.assertTrue( amountFromPage.equalsIgnoreCase( amount ) );
        claimSummaryPageObj.close().click();
    }

    private void verifyAmountPaidInTnternalTab(String amount) {
        policyDataFieldsPageObj.editGivenClaim( this.claimID ).click();
        claimSummaryPageObj.InternalTab();
        claimSummaryPageObj.InternalTab().click();
        String amountFromPage = claimSummaryPageObj.totalAmountPaidDisplayedFromInternalTab( this.claimItemId ).getText();
        System.out.println( "amountFromPage-------------internal-------" + amountFromPage );
        Assert.assertTrue( amountFromPage.equalsIgnoreCase( amount ) );
        claimSummaryPageObj.close().click();
    }

    public void navigateToAdvanceSearch() {
        policyDataFieldsPageObj.advancedSearch();
        policyDataFieldsPageObj.advancedSearch().click();
        policyDataFieldsPageObj.filterByPolicy();
        policyDataFieldsPageObj.filterByPolicy().click();
        new Select( policyDataFieldsPageObj.policyType() ).selectByVisibleText( "Travel Claim" );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void getClaimIdAndMultipleClaimItemId() {
        claimID = nextEventPageObj.firstClaimID().getText();
        System.out.println( "claimID-------------------------" + claimID );
        claimSummaryPageObj.editFirstClaim().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.InternalTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimItemId1 = claimSummaryPageObj.claimItemId1().getText();
        claimItemId2 = claimSummaryPageObj.claimItemId2().getText();
        System.out.println( "Claim ItemId for item 1 ------------------------" + claimItemId1 );
        System.out.println( "Claim ItemId for item 2 ------------------------" + claimItemId2 );
        claimSummaryPageObj.saveAndCloseBtn().click();
    }

    public void navigateToBasePolicy() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick( policyDataFieldsPageObj.navigateBasePolicyLink() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void navigateToPolicyViewFromBilling() {
        nextEventPageObj.btnClick( policyDataFieldsPageObj.navigateToPolicyLinkFromBillingView() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateNamedPeopleColor(String persons, String expectedColor) {
        String strExpectedColor = expectedColor;
        String strActualColor = null;
        try {
            for (int i = 0; i < persons.split( "#" ).length; i++) {
                strActualColor = stringOperationsObj.getColorInHexCode( policySummaryPageObj.deceasedCustomerColor( persons.split( "#" )[i] ).getCssValue( "background-color" ) );
                System.out.println( "Actual color" + strActualColor );
                Assert.assertTrue( strActualColor.equalsIgnoreCase( strExpectedColor ) );
                System.out.println( "After assertion account holder is updated in black" );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void retrieveCaseId(String caseId) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        caseId = this.claimcaseid;
        System.out.println( "claim case id is-----" + this.claimcaseid );
        System.out.println( "claim case id is-----" + caseId );
        System.out.println( "came to workflow task case id verification $$$$$$$$$$" );
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
        String id = policyDataFieldsPageObj.retrieveWorkflowcaseid( caseId ).getText();
        System.out.println( "in work flow case id%%%%%%% " + id );
        Assert.assertTrue( id.equals( caseId ) );
        System.out.println( "after assert equal%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" );
    }

    private void enterSupplierDetail(String fieldValue) {
        basicClaimDetObj.selectOtherPartyAddBtn().click();
        nextEventPageObj.switchToFrameById( nextEventPageObj.supplierFrame() );
        basicClaimDetObj.selectOtherParty( fieldValue ).click();
        nextEventPageObj.switchToDefault();
    }

    public void selectReasonForClaimClose(List<List<String>> lstInputs) {
        claimsRepudiationPageObj.claimCloseConfirmationResponse();
        claimsRepudiationPageObj.claimCloseConfirmationResponse().click();
        claimsRepudiationPageObj.claimCloseConfirmationResponse_Yes().click();
        System.out.println( "Claim has been closed" );
        claimSummaryPageObj.selectReasonForClaimClose().click();
        nextEventPageObj.waitForMoreTime();
        System.out.println( "lstInputs.get(0).get(0) is : " + lstInputs.get( 0 ).get( 0 ) );
        supplierDetailsPageObj.switchToFrameById( nextEventPageObj.findElement( By.id( "RadWindowContentFrameucMandatoryFieldEditor_RadWindowManager1_PagesDialogWindow" ) ) );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.selectFilter1ForClaimClose().click();
        claimSummaryPageObj.selectFilter1ForClaimClose().sendKeys( lstInputs.get( 0 ).get( 0 ) );
        System.out.println( "Filter 1 is selected" );
        claimSummaryPageObj.filter_1_ClaimClose().click();
        claimSummaryPageObj.filterConstraint().click();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.selectFilter2ForClaimClose().click();
        claimSummaryPageObj.selectFilter2ForClaimClose().sendKeys( lstInputs.get( 0 ).get( 1 ) );
        System.out.println( "Filter 2 is selected" );
        claimSummaryPageObj.filter_2_ClaimClose().click();
        claimSummaryPageObj.filterConstraint().click();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.selectFilter3ForClaimClose().click();
        claimSummaryPageObj.selectFilter3ForClaimClose().sendKeys( lstInputs.get( 0 ).get( 2 ) );
        System.out.println( "Filter 3 is selected" );
        claimSummaryPageObj.filter_3_ClaimClose().click();
        claimSummaryPageObj.filterConstraint().click();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.btnSelectReasonForClaimClose().click();
        supplierDetailsPageObj.switchToDefault();
        supplierDetailsPageObj.switchToFrameById( nextEventPageObj.findElement( By.id( "RadWindowContentFramectl00_cphBodyWithoutUpdatePanel_cphBody_rwmEvents_rwEventWizard" ) ) );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimsRepudiationPageObj.clearTheReserve();
        claimsRepudiationPageObj.clearTheReserve().click();
        claimsRepudiationPageObj.claimCloseConfirmationResponse_Yes().click();
        claimsRepudiationPageObj.claimCloseSaveBtn();
        claimsRepudiationPageObj.claimCloseSaveBtn().click();
    }

    public void assignSolicitor(String solicitor, List<List<String>> parameters) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        System.out.println( "field name --------------------" + solicitor );
        navigationObj.navigateToNextEventType( solicitor );
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                this.enterSolicitorDetails( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
            }
        }
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        nextEventPageObj.btnClick( nextEventPageObj.saveBtn() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void enterSolicitorDetails(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Assigned Panel Solicitor":
                claimSummaryPageObj.assignPanelSolicitor().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToFrameById( nextEventPageObj.supplierFrame() );
                claimSummaryPageObj.assignSolicitor().click();
                nextEventPageObj.waitForMoreTime();
                break;
            case "Firm Name":
                claimSummaryPageObj.enterNonSolicitorDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "Solicitor/Contact Name":
                claimSummaryPageObj.enterNonSolicitorDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "Address Line 1":
                claimSummaryPageObj.enterNonSolicitorDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "Firm Address Line 2":
                claimSummaryPageObj.enterNonSolicitorDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "Firm Address Line 3":
                claimSummaryPageObj.enterNonSolicitorDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "Firm Address Line 4":
                claimSummaryPageObj.enterNonSolicitorDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "Firm Address Postcode":
                claimSummaryPageObj.enterNonSolicitorDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "Email Address":
                claimSummaryPageObj.enterNonSolicitorDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "Telephone Number":
                claimSummaryPageObj.enterNonSolicitorDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "Town":
                claimSummaryPageObj.enterNonSolicitorDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "County":
                claimSummaryPageObj.enterNonSolicitorDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "Postcode":
                claimSummaryPageObj.enterNonSolicitorDetails( fieldName ).sendKeys( fieldValue );
                break;
            case "Addressee Claim Reference":
                claimSummaryPageObj.enterNonSolicitorDetails( fieldName ).sendKeys( fieldValue );
                break;
        }
    }

    public void legalExpenseDataCapture(List<List<String>> parameters) {
        this.clickingUnderNextEventsAndButtons( "Go" );
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                this.enterLegalExpenseDataCapture( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
            }
        }
        nextEventPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void enterLegalExpenseDataCapture(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Likelihood of Success":
                likeLihoodofSuccess = fieldValue;
                System.out.println( "Likelihood of success" + likeLihoodofSuccess );
                claimSummaryPageObj.enterLegalExpenseDataCapture( fieldName ).sendKeys( fieldValue );
                break;
            case "Legal Claim Check Frequency":
                claimSummaryPageObj.enterLegalExpenseDataCapture( fieldName ).sendKeys( fieldValue );
                break;
        }
    }

    public void validateTooltip(String toolTipMsg) {
        StringBuffer sb = new StringBuffer( toolTipMsg );
        sb.insert( 22, "50" ); // Insert a new String
        toolTipMsg = sb.toString();
        System.out.println( "String modified" + toolTipMsg );
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        Calendar c = Calendar.getInstance();
        c.setTime( new Date() );
        c.add( Calendar.MONTH, 1 );
        String date = sdf.format( c.getTime() );
        sb.append( " " + date );
        toolTipMsg = sb.toString();
        System.out.println( "String modified" + toolTipMsg );
        System.out.println( "Tooltip Message retrieved from AQ" + claimSummaryPageObj.validateToolTipMsg().getAttribute( "title" ) );
        Assert.assertTrue( claimSummaryPageObj.validateToolTipMsg().getAttribute( "title" ).equalsIgnoreCase( toolTipMsg ) );
    }

    public void validateLegalClaimDetails(List<List<String>> parameters) {
        claimSummaryPageObj.editLegalClaim().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.legalTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                this.validateLegalDetails( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
            }
        }
        claimSummaryPageObj.close().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateLegalDetails(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "Solicitor Name":
                Assert.assertTrue( claimSummaryPageObj.validateSolicitorName().getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Likelihood of Success":
                Assert.assertTrue( claimSummaryPageObj.validateLikelihoodOfSuccess().getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Legal Claim Check Frequency":
                Assert.assertTrue( claimSummaryPageObj.validateLegalClaimCheckFrequency().getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Next Check Date":
                if (fieldValue.equalsIgnoreCase( "futuredate31days" )) {
                    SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
                    Calendar c = Calendar.getInstance();
                    c.setTime( new Date() );
                    String returnValue = null;

                    c.add( Calendar.DATE, 30 );
                    String date = sdf.format( c.getTime() );
                    returnValue = date;
                    System.out.println( "***** Date ***" + returnValue );
                    Assert.assertTrue( claimSummaryPageObj.validateNextActionDate().getAttribute( "value" ).contains( returnValue ) );
                } else {
                    Assert.assertTrue( claimSummaryPageObj.validateNextActionDate().getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                }
                break;
            case "Firm Name":
                Assert.assertTrue( claimSummaryPageObj.validateNonSolicitorDetails( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Solicitor/Contact Name":
                Assert.assertTrue( claimSummaryPageObj.validateNonSolicitorDetails( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Address Line 1":
                Assert.assertTrue( claimSummaryPageObj.validateNonSolicitorDetails( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Firm Address Line 2":
                Assert.assertTrue( claimSummaryPageObj.validateNonSolicitorDetails( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Firm Address Line 3":
                Assert.assertTrue( claimSummaryPageObj.validateNonSolicitorDetails( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Firm Address Line 4":
                Assert.assertTrue( claimSummaryPageObj.validateNonSolicitorDetails( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Firm Address Postcode":
                Assert.assertTrue( claimSummaryPageObj.validateNonSolicitorDetails( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Email Address":
                System.out.println( "Email Address in Application" + claimSummaryPageObj.validateNonSolicitorDetails( fieldName ).getAttribute( "value" ) );
                System.out.println( "email Address retrieved" + fieldValue );
                Assert.assertTrue( claimSummaryPageObj.validateNonSolicitorDetailsEmail( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Email Address Non Panel":
                System.out.println( "Email Address in Application" + claimSummaryPageObj.validateNonSolicitorDetailsEmail( fieldName ).getAttribute( "value" ) );
                System.out.println( "email Address retrieved" + fieldValue );
                Assert.assertTrue( claimSummaryPageObj.validateNonSolicitorDetailsEmail( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Telephone Number":
                Assert.assertTrue( claimSummaryPageObj.validateNonSolicitorDetailsEmail( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Town":
                Assert.assertTrue( claimSummaryPageObj.validateNonSolicitorDetails( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "County":
                Assert.assertTrue( claimSummaryPageObj.validateNonSolicitorDetails( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Postcode":
                Assert.assertTrue( claimSummaryPageObj.validateNonSolicitorDetails( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
            case "Addressee Claim Reference":
                Assert.assertTrue( claimSummaryPageObj.validateNonSolicitorDetails( fieldName ).getAttribute( "value" ).equalsIgnoreCase( fieldValue ) );
                break;
        }
    }

    public void captureClaimItemID(String claimDetails) {
        for (int i = 0; i < claimDetails.split( "#" ).length; i++) {
            System.out.println( "Claim Items" + claimDetails.split( "#" )[i] );
            this.captureClaimDetails( claimDetails.split( "#" )[i] );
        }
    }

    public void captureClaimDetails(String claimItems) {
        switch (claimItems) {
            case "claimid":
                getclaimID = claimSummaryPageObj.getClaimfirstClaimID().getText();
                System.out.println( "Retrieved claim ID" + getclaimID );
                break;
            case "claimitemid":
                claimSummaryPageObj.editfirstClaimID().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimSummaryPageObj.supplier_internalTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                getclaimItemID = claimSummaryPageObj.getfirstClaimItemID().getText();
                System.out.println( "Retrieved claim Item ID" + getclaimItemID );
                nextEventPageObj.btnCloseWindow().click();
                break;
        }
    }

    public void entersupplierDetailsInLeadTab(String field, String value) {
        claimSummaryPageObj.countryForVATdropdownImg().click();
        claimSummaryPageObj.countryForVATdropdownValue( value ).click();
        customerDetailsFieldPageObj.saveAndCloseButton().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void captureClaimDetails(List<List<String>> parameters) {
        for (int row = 0; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get( 0 ).size(); column++) {
                this.captureDetails( parameters.get( 0 ).get( column ) );
            }
        }
    }

    public void captureDetails(String detail) {
        switch (detail) {
            case "Claim ID":
                claimID = claimSummaryPageObj.retrieveClaimID().getText();
                System.out.println( "Claim ID retrieved" + claimID );
                break;
            case "Assignee":
                claimassignee = claimSummaryPageObj.retrieveClaimAssignee().getText();
                System.out.println( "Retrieved Assignee" + claimassignee );
                break;
        }
    }

    public void retrieveLeadID() {
        leadID = claimSummaryPageObj.claimleadID().getText();
        System.out.println( "Retrived lead ID" + leadID );
    }

    public void validateLeadIdInWorkflow() {
        Assert.assertTrue( claimSummaryPageObj.leadIDDisplayed( this.leadID ).isDisplayed() );
    }

    public void navigateToTaskReminder() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        navigationObj.navigateToImenu();
        nextEventPageObj.btnClick( policySummaryPageObj.navigateToTaskReminderTab() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateClaimlistedUnderTaskReminder(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                this.validateTaskReminderDetails( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );

            }
        }
    }

    public void validateTaskReminderDetails(String searchField, String searchValue) {
        switch (searchField) {
            case "Title":
                claimSummaryPageObj.title_Reminder().clear();
                claimSummaryPageObj.title_Reminder().sendKeys( searchValue );
                claimSummaryPageObj.filter_titleReminder().click();
                claimSummaryPageObj.equalTofilter_Reminder().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "ClaimID":
                claimSummaryPageObj.viewClaim_Reminder().clear();
                claimSummaryPageObj.viewClaim_Reminder().sendKeys( this.claimID );
                claimSummaryPageObj.filter_viewClaim_Reminder().click();
                claimSummaryPageObj.equalTofilter_Reminder().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "Creation Date":
                String creationDate = "";
                String currentDate = "";
                List<WebElement> rows = getDriver().findElements( By.xpath( claimSummaryPageObj.retrievedTable_Reminder() ) );
                System.out.println( rows.size() );
                if (rows.size() > 0) {
                    creationDate = claimSummaryPageObj.creationDate_Reminder().getText();
                    creationDate = creationDate.split( " " )[0];
                    currentDate = new SimpleDateFormat( "dd/MM/yyyy" ).format( new java.util.Date() ).toString();
                    System.out.println( "Before Assert" );
                    Assert.assertTrue( creationDate.equalsIgnoreCase( currentDate ) );
                } else {
                    throw new PendingException();
                }
                break;
            case "Due Date":
                String dueDate = claimSummaryPageObj.dueDate_Reminder().getText();
                this.validateDateisValid( dueDate );
                break;
            case "End Date":
                String endDate = claimSummaryPageObj.endDate_Reminder().getText();
                this.validateDateisValid( endDate );
                break;
            case "AssignedTo":
                Assert.assertTrue( claimassignee.equalsIgnoreCase( claimSummaryPageObj.assignee_Reminder().getText() ) );
                break;
        }
    }

    public boolean validateDateisValid(String inputdate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        dateFormat.setLenient( false );
        try {
            dateFormat.parse( inputdate.trim() );
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public void validateDefaultReserves(List<String> parameters) {
        leftNavPanePageObj.companyDetails().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.tmaTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 0; i < parameters.size(); i++) {
            this.validateReserveTableHeaders( parameters.get( i ) );
        }
        claimSummaryPageObj.close().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateReserveTableHeaders(String fieldName) {
        switch (fieldName) {
            case "Country":
                System.out.println( "Inside Country" );
                Assert.assertTrue( claimSummaryPageObj.validateCountry().isDisplayed() );
                break;
            case "Non-ICU per day":
            case "Private hospital Reserves -  Non-ICU per day":
                System.out.println( "Non-ICU per day" );
                Assert.assertTrue( claimSummaryPageObj.validateNonICUPPPD().isDisplayed() );
                break;
            case "ICU per day":
            case "Private hospital Reserves -  ICU per day":
                System.out.println( "ICU per day" );
                Assert.assertTrue( claimSummaryPageObj.validateICUPPD().isDisplayed() );
                break;
            case "Outpatient per day":
            case "Private hospital Reserves -  Outpatient per day":
                System.out.println( "Outpatient per day" );
                Assert.assertTrue( claimSummaryPageObj.validateOutPatient().isDisplayed() );
                break;
            case "Reciprocal Agreement":
                System.out.println( "Reciprocal Agreement" );
                Assert.assertTrue( claimSummaryPageObj.validateReciprocalAgreement().isDisplayed() );
                break;
            case "Type of agreement":
                System.out.println( "Type of Agreement" );
                Assert.assertTrue( claimSummaryPageObj.validateTypeOfAgreement().isDisplayed() );
                break;
            case "Reserve for a public hospital per day":
                System.out.println( "Reserve for a public hospital per day" );
                Assert.assertTrue( claimSummaryPageObj.validateHospital().isDisplayed() );
                break;
        }
    }

    public void captureReserveValue(String country, List<String> parameters) {
        leftNavPanePageObj.companyDetails().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.tmaTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 0; i < parameters.size(); i++) {
            this.captureDefaultReserveValue( country, parameters.get( i ) );
        }
        claimSummaryPageObj.close().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void captureDefaultReserveValue(String country, String reserve) {
        switch (reserve) {
            case "Non-ICU per day":
                System.out.println( "Capture Non-ICU per day" );
                nonICUPPD = claimSummaryPageObj.retrieveNonICUPPDValue( country ).getText();
                System.out.println( "nonICUPPD" + nonICUPPD );
                break;
            case "ICU per day":
                System.out.println( "Capture ICU per day" );
                ICUPPD = claimSummaryPageObj.retrieveICUPPDValue( country ).getText();
                System.out.println( "ICUPPD" + ICUPPD );
                break;
            case "Outpatient per day":
                System.out.println( "Capture Outpatient per day" );
                outpatientPPD = claimSummaryPageObj.retrieveHospOutpatientPPDValue( country ).getText();
                System.out.println( "outpatientPPD" + outpatientPPD );
                break;
            case "Reserve for a public hospital per day":
                System.out.println( "Capture Reserve for a public hospital per day" );
                publicHospPPD = claimSummaryPageObj.retrievepublicHospPPDValue( country ).getText();
                System.out.println( "publicHospPPD" + publicHospPPD );
                break;
        }
    }

    public void validateDefaultReserve(String claimItem2, List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        new Select( perilsAndCostsPageObj.claimDetail2() ).selectByVisibleText( claimItem2 );
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            int iCalculatedICUReserve = 0;
            int iCalculatedNonICUReserve = 0;
            int iCalculatedOutPatientReserve = 0;
            int iCalculatedPublicHospitalReserve = 0;
            String fieldValue = "";
            String fieldName = "";
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                fieldName = parameters.get( 0 ).get( j );
                fieldValue = parameters.get( i ).get( j );
                if (fieldValue.equalsIgnoreCase( "-" )) {
                    fieldValue = "0";
                }
                switch (fieldName.toLowerCase()) {
                    case "icu days":
                        if (!fieldValue.equalsIgnoreCase( "No" )) {
                            icuDays = fieldValue;
                            System.out.println( "Number of icuDays" + icuDays );
                            claimSummaryPageObj.numberOfICUDays().clear();
                            claimSummaryPageObj.numberOfICUDays().sendKeys( fieldValue );
                            iCalculatedICUReserve = Integer.parseInt( icuDays ) * Integer.parseInt( ICUPPD );
                            System.out.println( "iCalculatedICUReserve====" + iCalculatedICUReserve + "---ICUPPD" + ICUPPD );
                        } else {
                            System.out.println( "Validating field is ---" + fieldName );
                            if (!commandsObj.elementDisplayedWithLessTime( org.openqa.selenium.By.xpath( claimSummaryPageObj.fieldICUDays() ) )) {

                                System.out.println( "Field is not available" );
                                System.out.println( "Validated field is ---" + fieldName );
                            }
                        }
                        break;
                    case "non-icu days":
                        if (!fieldValue.equalsIgnoreCase( "No" )) {
                            nonicuDays = fieldValue;
                            System.out.println( "Number of Non icuDays" + nonicuDays );
                            claimSummaryPageObj.numberOfNonICUDays().clear();
                            claimSummaryPageObj.numberOfNonICUDays().sendKeys( fieldValue );
                            iCalculatedNonICUReserve = Integer.parseInt( nonicuDays ) * Integer.parseInt( nonICUPPD );
                            System.out.println( "iCalculatedNonICUReserve====" + iCalculatedNonICUReserve + "---nonICUPPD" + nonICUPPD );
                        } else {
                            System.out.println( "Validating field is ---" + fieldName );
                            if (!commandsObj.elementDisplayedWithLessTime( org.openqa.selenium.By.xpath( claimSummaryPageObj.fieldNonICUDays() ) )) {

                                System.out.println( "Field is not available" );
                                System.out.println( "Validated field is ---" + fieldName );
                            }
                        }
                        break;
                    case "outpatient days":
                        if (!fieldValue.equalsIgnoreCase( "No" )) {
                            outPatientDays = fieldValue;
                            System.out.println( "Number of Out Patient Days" + outPatientDays );
                            claimSummaryPageObj.numberOfOutPatientDays().clear();
                            claimSummaryPageObj.numberOfOutPatientDays().sendKeys( fieldValue );
                            iCalculatedOutPatientReserve = Integer.parseInt( outPatientDays ) * Integer.parseInt( outpatientPPD );
                            System.out.println( "iCalculatedOutPatientReserve====" + iCalculatedOutPatientReserve + "---outpatientPPD" + outpatientPPD );
                        } else {
                            System.out.println( "Validating field is ---" + fieldName );
                            if (!commandsObj.elementDisplayedWithLessTime( org.openqa.selenium.By.xpath( claimSummaryPageObj.fieldOutPatientDays() ) )) {

                                System.out.println( "Field is not available" );
                                System.out.println( "Validated field is ---" + fieldName );
                            }
                        }
                        break;
                    case "public hospital days":
                        if (!fieldValue.equalsIgnoreCase( "No" )) {
                            publicHospitalDays = fieldValue;
                            System.out.println( "Number of Public Hospital days" + publicHospitalDays );
                            claimSummaryPageObj.numberOfPublicHospitalDays().clear();
                            claimSummaryPageObj.numberOfPublicHospitalDays().sendKeys( fieldValue );
                            iCalculatedPublicHospitalReserve = Integer.parseInt( publicHospitalDays ) * Integer.parseInt( publicHospPPD );
                            System.out.println( "iCalculatedPublicHospitalReserve====" + iCalculatedPublicHospitalReserve + "---publicHospPPD" + publicHospPPD );

                        } else {
                            System.out.println( "Validating field is ---" + fieldName );
                            if (!commandsObj.elementDisplayedWithLessTime( org.openqa.selenium.By.xpath( claimSummaryPageObj.fieldPublicHospitalDays() ) )) {

                                System.out.println( "Field is not available" );
                                System.out.println( "Validated field is ---" + fieldName );
                            }
                        }
                        break;
                    case "default reserve":
                        claimSummaryPageObj.estimateCost().click();
                        String iTotalCalculatedReserve = String.valueOf( iCalculatedICUReserve + iCalculatedNonICUReserve + iCalculatedOutPatientReserve + iCalculatedPublicHospitalReserve ) + ".00";
                        String iActualTotalReserveFromSystem = claimSummaryPageObj.amount().getAttribute( "value" );
                        System.out.println( "Total Reserve From System =============" + iActualTotalReserveFromSystem );
                        System.out.println( "Total Calculated Reserve =============" + iTotalCalculatedReserve );
                        Assert.assertTrue( "Validating Default Reserve Calculation====", iTotalCalculatedReserve.equalsIgnoreCase( iActualTotalReserveFromSystem ) );
                        break;
                }
            }
        }
        perilsAndCostsPageObj.saveClaimItem().click();
    }

    public void retrieveLimitAndExcess(String limit, String excess, String cause) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.coverTermsTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.enterCause_PolicyLimits().clear();
        claimSummaryPageObj.enterCause_PolicyLimits().sendKeys( cause );
        claimSummaryPageObj.enterCause_PolicyLimitsImg().click();
        claimSummaryPageObj.containsFilter().click();
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
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        limitValue = claimSummaryPageObj.retrievepolicyLimitsAmount().getText();
        System.out.println( "Limit value" + limitValue );
        claimSummaryPageObj.enterCause_PolicyExcess().clear();
        claimSummaryPageObj.enterCause_PolicyExcess().sendKeys( cause );
        claimSummaryPageObj.enterCause_PolicyExcessImg().click();
        claimSummaryPageObj.containsFilter().click();
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
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        excessValue = claimSummaryPageObj.retrievepolicyExcessAmount().getText();
        System.out.println( "Excess value" + excessValue );
        claimSummaryPageObj.saveAndCloseBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void overrideLimitAndExcess(String field, List<List<String>> parameters) {
        this.clickingUnderNextEventsAndButtons( "out of process event" );
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                this.toOverrideLimitAndExcess( field, parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );

            }
        }
        claimSummaryPageObj.savebtnInOverride().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
    }

    public void toOverrideLimitAndExcess(String field, String fieldName, String fieldValue) {
        switch (fieldName) {
            case "event":
                navigationObj.navigateToNextEventType( fieldValue );
                break;
            case "action":
                if (field.equalsIgnoreCase( "Policy Limit Overrides" )) {
                    System.out.println( "Inside Policy Limit Overrides" );
                    claimSummaryPageObj.insertPolicyOverrideLimit().click();

                } else if (field.equalsIgnoreCase( "Policy Excess Overrides" )) {
                    System.out.println( "Inside Policy Excess Overrides" );
                    claimSummaryPageObj.insertExcessOverrideLimit().click();
                }
                break;
            case "Cause":
                selectObj.selectValueFromDropdown( claimSummaryPageObj.overrideFields( fieldName ), fieldValue );
                break;
            case "Sub Cause":
                selectObj.selectValueFromDropdown( claimSummaryPageObj.overrideFields( fieldName ), fieldValue );
                break;
            case "Claim Detail 1":
                selectObj.selectValueFromDropdown( claimSummaryPageObj.overrideFields( fieldName ), fieldValue );
                break;
            case "Claim Detail 2":
                selectObj.selectValueFromDropdown( claimSummaryPageObj.overrideFields( fieldName ), fieldValue );
                break;
            case "Amount":
                claimSummaryPageObj.amountField().clear();
                claimSummaryPageObj.amountField().sendKeys( fieldValue );
                break;
            case "Application":
                selectObj.selectValueFromDropdown( claimSummaryPageObj.overrideFields( fieldName ), fieldValue );
                break;
         }
    }

    public void navigateToClaimSummaryView() {
        this.navigateToClaimViewFromPolicyView();
        nextEventPageObj.btnClick( claimSummaryPageObj.newClaim() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void navigateToClaimView() {
        this.navigateToClaimViewFromPolicyView();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void saveClaimItem() {
        perilsAndCostsPageObj.saveClaimItem().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateClaimSubStatus() {
        getDriver().navigate().refresh();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        Assert.assertTrue( policyDataFieldsPageObj.onhold().isDisplayed() );
        System.out.println( " CAME TO ONHOLD VALIDATION ################################" + policyDataFieldsPageObj.onhold().isDisplayed() + "###################" );
    }

    public void validateBarHasApplied(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                this.validateBar( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
            }
        }
    }

    public void validateBar(String fieldName, String fieldValue) {
        switch (fieldName) {
            case "event":
                this.clickingUnderNextEventsAndButtons( fieldValue );
                break;
            case "navigationEvent":
                navigationObj.navigateToNextEventType( fieldValue );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                this.clickingUnderNextEventsAndButtons( "go" );
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                break;
            case "NameOfBar":
                Assert.assertTrue( claimSummaryPageObj.barApplied( fieldValue ).isDisplayed() );
                break;
            case "BarStatus":
                Assert.assertTrue( claimSummaryPageObj.barStatus( fieldValue ).isDisplayed() );
                break;
            case "action":
                claimSummaryPageObj.cancel_btn().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
        }
    }

    public void referClaimForCustomerValidation(List<List<String>> lstInputs) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println( "came to oop drop down start" );
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get( 0 ).size(); j++) {
                switch (lstInputs.get( 0 ).get( j ).toLowerCase()) {
                    case "event type":
                        navigationObj.navigateToNextEventType( lstInputs.get( i ).get( j ) );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "referal reason":
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                        claimSummaryPageObj.referralReasonDropdownImg().click();
                        claimSummaryPageObj.referralReasonDropdownvalue( lstInputs.get( i ).get( j ) ).click();
                        nextEventPageObj.btnClick( claimSummaryPageObj.savebtn() );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "comments":
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                        claimSummaryPageObj.comments_txtbox().sendKeys( lstInputs.get( i ).get( j ) );
                        claimSummaryPageObj.finish_btn().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                }
            }
        }
    }

    public void returnClaimToTIM(List<List<String>> lstInputs) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.unlockTIMClaim().click();
        nextEventPageObj.btnClick( nextEventPageObj.go() );
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        for (int row = 1; row < lstInputs.size(); row++) {
            for (int column = 0; column < lstInputs.get( 0 ).size(); column++) {
                this.validateUnlockTravelClaim( lstInputs.get( 0 ).get( column ), lstInputs.get( row ).get( column ) );
            }
        }
    }

    public void validateUnlockTravelClaim(String searchName, String searchValue) {
        switch (searchName.toLowerCase()) {
            case "returnclaimreason":
                claimSummaryPageObj.selectReturnTIMClaimDropdown().click();
                claimSummaryPageObj.selectReturnTIMClaimReason( searchValue ).click();
                claimSummaryPageObj.savebtn().click();
                break;
            case "comments":
                claimSummaryPageObj.comments_txtbox().sendKeys( searchValue );
                claimSummaryPageObj.finish_btn().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
        }
    }

    public void navigateToAQ() {
        claimSummaryPageObj.backtoAqLink().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void captureEvidenceForDigitalClaim(List<List<String>> lstEvidences) {
        List<WebElement> lstRows = evidenceCollationPageObj.evidenceCollationWebTable().findElements( By.tagName( "tr" ) );
        if (lstEvidences.get( 1 ).get( 0 ).equalsIgnoreCase( "Default" ) || lstEvidences.get( 1 ).get( 0 ).equalsIgnoreCase( "All" )) {
            System.out.println( "size of evidence----" + lstRows.size() );
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            txt1Provided = evidenceCollationPageObj.txt1Provided().getText();
            System.out.println( "text---1---is----" + txt1Provided );
            txt2Provided = evidenceCollationPageObj.txt2Provided().getText();
            System.out.println( "text---2---is----" + txt2Provided );
            txt3NotRequired = evidenceCollationPageObj.txt3NotRequired().getText();
            System.out.println( "text---3---is----" + txt3NotRequired );
            txt4NotRequired = evidenceCollationPageObj.txt4NotRequired().getText();
            System.out.println( "text---4---is----" + txt4NotRequired );
            txt5NotRequired = evidenceCollationPageObj.txt5NotRequired().getText();
            System.out.println( "text---5---is----" + txt5NotRequired );
            nextEventPageObj.btnClick( evidenceCollationPageObj.evidenceCollateRows( 1 ) );
            nextEventPageObj.btnClick( evidenceCollationPageObj.evidenceCollateRows( 2 ) );
            nextEventPageObj.btnClick( evidenceCollationPageObj.chkBoxNotRequired( 3 ) );
            nextEventPageObj.btnClick( evidenceCollationPageObj.chkBoxNotRequired( 4 ) );
            nextEventPageObj.btnClick( evidenceCollationPageObj.chkBoxNotRequired( 5 ) );
            evidenceCollationPageObj.save().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.CancelBtn().click();
        } else if (lstEvidences.get( 1 ).get( 0 ).equalsIgnoreCase( "Some" )) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick( evidenceCollationPageObj.notRequiredRow3() );
            nextEventPageObj.btnClick( evidenceCollationPageObj.notRequiredRow4() );
            nextEventPageObj.btnClick( evidenceCollationPageObj.notRequiredRow5() );
            if (subcausecodestring.equalsIgnoreCase( "Lost" )) {
                nextEventPageObj.btnClick( evidenceCollationPageObj.providedRow1() );
                submittedEvidence1 = evidenceCollationPageObj.submitted1().getText();
                System.out.println( "text---1---is----" + submittedEvidence1 );
            } else if (subcausecodestring.equalsIgnoreCase( "Accidentally Damaged" )) {
                nextEventPageObj.btnClick( evidenceCollationPageObj.providedRow2() );
                submittedEvidence2 = evidenceCollationPageObj.submitted2().getText();
                System.out.println( "text---2---is----" + submittedEvidence2 );
            }
            notSubmittedEvidence1 = evidenceCollationPageObj.notSubmitted1().getText();
            System.out.println( "text---3---is----" + notSubmittedEvidence1 );
            notSubmittedEvidence2 = evidenceCollationPageObj.notSubmitted2().getText();
            System.out.println( "text---4---is----" + notSubmittedEvidence2 );
            notSubmittedEvidence3 = evidenceCollationPageObj.notSubmitted3().getText();
            System.out.println( "text---5---is----" + notSubmittedEvidence3 );
            evidenceCollationPageObj.save().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.CancelBtn().click();
        } else {
            evidenceCollationPageObj.save().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.CancelBtn().click();
        }
    }

    public void navigateToSubmittedDigClaim() {
        claimSummaryPageObj.editFirstClaim().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.saveAndCloseBtn().click();
    }

    public void selectIncidentForRecovery(String incident) {
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.chkBoxIncident( incident ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        evidenceCollationPageObj.save().click();
    }

    public void verifyStatusOfRecovery(String status, String action) {
        this.clickingUnderNextEventsAndButtons( "refresh" );
        claimSummaryPageObj.recoveryTab();
        claimSummaryPageObj.recoveryTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println( "Recovery status is------" + status );
        System.out.println( "claimSummaryPageObj.txtRecoveryStatus().getText() is------" + claimSummaryPageObj.txtRecovery( status ).getText() );
        Assert.assertTrue( claimSummaryPageObj.txtRecovery( status ).getText().equalsIgnoreCase( status ) );
        nextEventPageObj.waitForMoreTime();
        System.out.println( "Recovery action is------" + action );
        System.out.println( "claimSummaryPageObj.txtRecoveryAction().getText() is------" + claimSummaryPageObj.txtRecovery( action ).getText() );
        Assert.assertTrue( claimSummaryPageObj.txtRecovery( action ).getText().equalsIgnoreCase( action ) );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerDetailsFieldPageObj.saveAndCloseButton().click();
    }

    public void closeClaim(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                this.closeClaimDetails( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
            }
        }
    }

    public void closeClaimDetails(String searchField, String fieldValue) {
        switch (searchField) {
            case "event":
                this.clickingUnderNextEventsAndButtons( fieldValue );
                break;
            case "operation":
                navigationObj.navigateToNextEventType( fieldValue );
                break;
            case "Confirmation to close the Claim":
                claimsRepudiationPageObj.claimCloseConfirmationResponse().click();
                claimsRepudiationPageObj.claimCloseConfirmationResponse( fieldValue ).click();
                break;
            case "Close Claim Reason":
                claimsRepudiationPageObj.claimReasonSelection().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToFrameByIndex( 0 );
                System.out.println( "validating the reason" );
                claimsRepudiationPageObj.closeClaimReasonInput().clear();
                claimsRepudiationPageObj.closeClaimReasonInput().sendKeys( fieldValue );
                claimsRepudiationPageObj.closeClaimReasonInputFilter().click();
                claimSummaryPageObj.containsFilter().click();
                nextEventPageObj.waitForMoreTime();
                break;
            case "Close Claim SubReason":
                claimsRepudiationPageObj.closeClaimSubReasonInput().clear();
                claimsRepudiationPageObj.closeClaimSubReasonInput().sendKeys( fieldValue );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimsRepudiationPageObj.closeClaimSubReasonInput().sendKeys( Keys.RETURN );
                nextEventPageObj.btnClick( claimsRepudiationPageObj.closeClaimSubReasonInputFilter() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimsRepudiationPageObj.closeClaimSubReasonInput().sendKeys( Keys.RETURN );
                nextEventPageObj.btnClick( claimSummaryPageObj.containsFilter() );
                nextEventPageObj.waitForMoreTime();
                claimsRepudiationPageObj.selectCloseClaimReason().click();
                break;
            case "Clear the reserve":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                claimsRepudiationPageObj.clearReserveImg().click();
                claimsRepudiationPageObj.clearReserveValue( fieldValue ).click();
                nextEventPageObj.saveBtn().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
        }
    }

    public void validateCloseClaimWithReserve(String errorMessage) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        Assert.assertTrue( claimsRepudiationPageObj.clearReserveErrorMessage( errorMessage ).isDisplayed() );
        nextEventPageObj.CancelBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void claimClosureFootPrint(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                this.validateClaimClosureFootPrint( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
            }
        }
    }

    public void validateClaimClosureFootPrint(String serachField, String searchValue) {
        switch (serachField) {
            case "event":
                Assert.assertTrue( claimsRepudiationPageObj.eventValidation( searchValue ).isDisplayed() );
                break;
            case "When":
                String todayDate = "";
                SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
                Calendar c = Calendar.getInstance();
                c.setTime( new Date() );
                todayDate = sdf.format( c.getTime() );
                System.out.println( "Todays date" + todayDate );
                System.out.println( "new SimpleDateFormat(\"dd/MM/yyyy\").format(new java.util.Date()).toString();---------" + new SimpleDateFormat( "dd/MM/yyyy" ).format( new java.util.Date() ).toString() );
                Assert.assertTrue( claimsRepudiationPageObj.claimDetailValidation( new SimpleDateFormat( "dd/MM/yyyy" ).format( new java.util.Date() ).toString() ).isDisplayed() );
                break;
            case "Who":
                Assert.assertTrue( claimsRepudiationPageObj.claimDetailValidation( searchValue ).isDisplayed() );
                break;
        }
    }

    public void validateClaimCloseReasons(List<List<String>> parameters) {
        this.clickingUnderNextEventsAndButtons( "Out Of Process event" );
        navigationObj.navigateToNextEventType( "OOP Close Claim" );
        claimsRepudiationPageObj.claimReasonSelection().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToFrameByIndex( 0 );
        System.out.println( "validating the reason" );
        claimsRepudiationPageObj.closeClaimReasonInput().clear();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 1; j < parameters.get( 0 ).size(); j++) {
                this.claimCloseReasonsValidations( parameters.get( i ).get( j ) );
            }
        }
    }

    public void claimCloseReasonsValidations(String reasons) {
        switch (reasons) {
            case "REPUDIATED":
            case "WITHDRAWN":
            case "SETTLED":
                System.out.println( "Reasons retrieved" + reasons );
                claimsRepudiationPageObj.closeClaimReasonInput().click();
                claimsRepudiationPageObj.closeClaimReasonInput().sendKeys( reasons );
                claimsRepudiationPageObj.closeClaimReasonInputFilter().click();
                claimSummaryPageObj.containsFilter().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue( claimsRepudiationPageObj.claimReasonValidation( reasons ).isDisplayed() );
        }
    }

    public void claimReopendFootPrint(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                this.validateClaimReopenedFootPrint( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
            }
        }
    }

    public void validateClaimReopenedFootPrint(String serachField, String searchValue) {
        switch (serachField) {
            case "event":
                Assert.assertTrue( claimsRepudiationPageObj.eventValidation( searchValue ).isDisplayed() );
                break;
            case "When":
                String todayDate = "";
                SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
                Calendar c = Calendar.getInstance();
                c.setTime( new Date() );
                todayDate = sdf.format( c.getTime() );
                System.out.println( "Todays date" + todayDate );
                Assert.assertTrue( claimsRepudiationPageObj.claimDetailValidation( todayDate ).isDisplayed() );
                break;
            case "Who":
                Assert.assertTrue( claimsRepudiationPageObj.claimDetailValidation( searchValue ).isDisplayed() );
                break;
        }
    }

    public void claimStatusInDigitalPortal(String claimStatus) {
        this.navigateToDigitalClaimPage();
        System.out.println( "claimID in Digital portal" + claimIDVerificationInCutomerPortal );
        claimsRepudiationPageObj.validateClaimStatusInDigitalPortal( claimIDVerificationInCutomerPortal, claimStatus );
        Assert.assertTrue( claimsRepudiationPageObj.validateClaimStatusInDigitalPortal( claimIDVerificationInCutomerPortal, claimStatus ).isDisplayed() );
    }

    public void navigateToDigitalClaimPage() {
        customerPortalMyClaimsPageObj.tabMyClaims().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue( commandsObj.elementDisplayed( net.serenitybdd.core.annotations.findby.By.xpath( customerPortalMyClaimsPageObj.lblMyClaim() ) ) );
    }

    public void validatePartialOnlineClaimDetails() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver().navigate().refresh();
        commandsObj.elementDisplayedWithLessTime( net.serenitybdd.core.annotations.findby.By.xpath( claimSummaryPageObj.txtPartialOnlineClaim() ) );
        System.out.println( "Partial online claim is-----" + claimSummaryPageObj.txtPartialOnlineClaim() );
        commandsObj.elementDisplayedWithLessTime( net.serenitybdd.core.annotations.findby.By.xpath( claimSummaryPageObj.btnCreate() ) );
        System.out.println( "Create button is displayed" );
        String date = claimSummaryPageObj.txtdate().getText().split( ":" )[0];
        System.out.println( "Claim creation date is----" + date.trim() );
        DateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy HH" );
        Date newdate = new Date();
        String strDate = dateFormat.format( newdate );
        System.out.println( "System date:" + strDate.trim() );
        Assert.assertTrue( date.trim().equals( strDate.trim() ) );
        System.out.println( "******Date is validated******" );
        claimSummaryPageObj.btncreateClicking().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateClaimdetailsInClaimTable(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                this.verifyPerilDetails( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
            }
        }
    }

    private void verifyPerilDetails(String fieldName, String fieldValue) {
        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
        Calendar c = Calendar.getInstance();
        c.setTime( new Date() );
        String returnValue = null;
        String date = "";
        switch (fieldName.toLowerCase()) {
            case "perils":
                Assert.assertTrue( claimSummaryPageObj.txtPeril( fieldValue ).isDisplayed() );
                System.out.println( "Selected peril is validated in AQ" );
                break;
            case "destination":
                String selectedPeril_des = claimSummaryPageObj.txtPeril( fieldValue ).getText();
                System.out.println( "Selected peril is----" + fieldValue );
                Assert.assertTrue( selectedPeril_des.equalsIgnoreCase( fieldValue ) );
                System.out.println( "Selected destination  is validated in AQ" );
                break;
            case "reserve":
                String reserve = claimSummaryPageObj.txtPeril( fieldValue ).getText();
                System.out.println( "Selected peril is----" + fieldValue );
                Assert.assertTrue( reserve.equalsIgnoreCase( fieldValue ) );
                System.out.println( "Selected destination  is validated in AQ" );
                break;
            case "trip from":
                if (fieldValue.equalsIgnoreCase( "currentdate" )) {
                    DateFormat dateFormat = new SimpleDateFormat( "dd/MM/YYYY" );
                    Date newdate = new Date();
                    String strDate = dateFormat.format( newdate );
                    System.out.println( "System date:" + strDate );
                    Assert.assertTrue( claimSummaryPageObj.txtPeril( strDate ).isDisplayed() );
                    System.out.println( "Given trip from date is validated in AQ" );
                }
                break;
            case "trip to":
                if (fieldValue.equalsIgnoreCase( "futuredate22days" )) {
                    c.add( Calendar.DATE, 22 );
                    date = sdf.format( c.getTime() );
                    returnValue = date;
                    System.out.println( "***** Date ***" + returnValue );
                    System.out.println( "inside switch-----------------" );
                    Assert.assertTrue( claimSummaryPageObj.txtPeril( returnValue ).isDisplayed() );
                    System.out.println( "Given trip from date is validated in AQ" );
                    break;
                }
            case "dol":
                if (fieldValue.equalsIgnoreCase( "currentdate" )) {
                    DateFormat dateFormat = new SimpleDateFormat( "dd/MM/YYYY" );
                    Date newdate = new Date();
                    String strDate = dateFormat.format( newdate );
                    System.out.println( "System date:" + strDate );
                    Assert.assertTrue( claimSummaryPageObj.txtPeril( strDate ).isDisplayed() );
                    System.out.println( "Given trip from date is validated in AQ" );
                }
                break;
        }
    }

    public void createNewClaim() {
        this.navigateToClaimViewFromPolicyView();
        nextEventPageObj.btnClick( claimSummaryPageObj.newClaim() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimID = claimSummaryPageObj.retrieveNewlyCreatedClaimID().getText();
        System.out.println( "Claim ID retrieved" + claimID );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void enterBasicClaimDetails(String operation, String claimID, List<List<String>> parameters) {
        this.retreiveFirstClientRecord();
        this.navigateToClaimViewFromPolicyView();
        if (nextEventPageObj.elementDisplayed( By.xpath( claimSummaryPageObj.selectParticularClaim( this.claimID ) ) )) {
            claimSummaryPageObj.selectClaim( this.claimID ).click();
        }
        switch (operation.toLowerCase()) {
            case "basic claim details":
                this.enterBasicClaimDetails( operation, parameters );
                break;
            case "enter claim details":
                this.enterClaimDetails( parameters );
                break;
            case "assign panel solicitor":
                this.assignPanelSolicitor( parameters );
                break;
        }
    }

    public void enterBasicClaimDetails(String strExpBeh, List<List<String>> parameters) {
        try {
            if (nextEventPageObj.goDisplayed()) {
                nextEventPageObj.go().click();
            }
        } catch (org.openqa.selenium.WebDriverException ex) {
            if (nextEventPageObj.loadingPage()) {
                if (nextEventPageObj.goDisplayed()) {
                    nextEventPageObj.go().click();
                }
            }
        }
        try {
            if (nextEventPageObj.elementDisplayed( By.xpath( nextEventPageObj.enterBasicClaimDetails() ) )) {
                nextEventPageObj.btnClick( nextEventPageObj.go() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
            }
            nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
            this.createEditClaims( strExpBeh, parameters );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchClaim() {
        new Select( leftNavPanePageObj.quickSearchOn() ).selectByVisibleText( "Matter ID" );
    }

    public void retreiveFirstClientRecord() {
        nextEventPageObj.waitForMoreTime();
        String strContinue = "Yes";
        int i = 0;
        do {
            i++;
            System.out.println( "first record" + searchPageObj.viewCustomerLinkInSearchResultTableIsDisplayed() );
            if (searchPageObj.viewCustomerLinkInSearchResultTableIsDisplayed()) {
                System.out.println( "example----------------------------" );
                searchPageObj.viewCustomerLinkInSearchResultTable().click();
                break;
            }

            if (policySummaryPageObj.customerDetailsTabIsDisplayed()) {
                break;
            }

            if (policySummaryPageObj.isErrorPageDisplayed()) {
                break;
            }
            if (i > 100) {
                break;
            }
        } while (strContinue.equalsIgnoreCase( "Yes" ));
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void enterClaimDetails(List<List<String>> lstInputs) {
        try {
            if (nextEventPageObj.goDisplayed()) {
                nextEventPageObj.go().click();
            }
        } catch (org.openqa.selenium.WebDriverException ex) {
            if (nextEventPageObj.loadingPage()) {
                if (nextEventPageObj.goDisplayed()) {
                    nextEventPageObj.go().click();
                }
            }
        }
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        nextEventPageObj.switchToFrameById( nextEventPageObj.fancyFrame() );
        for (int row = 1; row < lstInputs.size(); row++) {
            for (int column = 0; column < lstInputs.get( 0 ).size(); column++) {
                this.validateClaimCauseAndComments( lstInputs.get( 0 ).get( column ), lstInputs.get( row ).get( column ) );
            }
        }
    }

    public void allocationOfClaimToClaimHandlerManually(String claimID, String claimHandler) {
        nextEventPageObj.waitForMoreTime();
        leftNavPanePageObj.claimCompetencyTab().click();
        leftNavPanePageObj.manualClaimHandlerAlloc().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.claimIDHeader_UnallocatedClaims().clear();
        claimCompetencyPageObj.claimIDHeader_UnallocatedClaims().sendKeys( this.claimID );
        claimCompetencyPageObj.claimIDHeader_UnallocatedClaims_Filter().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.equalToFilter().click();
        try {
            Thread.sleep( 20000L );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        claimCompetencyPageObj.allocateClaim( this.claimID ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        List<String> userDet = userObj.getUserDetails( claimHandler );
        String username = userDet.get( 0 );
        claimCompetencyPageObj.claimHandlerUsername().clear();
        claimCompetencyPageObj.claimHandlerUsername().sendKeys( username );
        claimCompetencyPageObj.claimHandlerUsernameFilter().click();
        claimCompetencyPageObj.containsTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.assignClaimToClaimHandler( username ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue( claimCompetencyPageObj.validateAllocation().isDisplayed() );
    }

    public void assignPanelSolicitor(List<List<String>> parameters) {
        try {
            if (nextEventPageObj.goDisplayed()) {
                nextEventPageObj.go().click();
            }
        } catch (org.openqa.selenium.WebDriverException ex) {
            if (nextEventPageObj.loadingPage()) {
                if (nextEventPageObj.goDisplayed()) {
                    nextEventPageObj.go().click();
                }
            }
        }
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get( 0 ).size(); column++) {
                String searchField = parameters.get( 0 ).get( column );
                String searchValue = parameters.get( row ).get( column );
                switch (searchField.toLowerCase()) {
                    case "solicitor type":
                        new Select( claimSummaryPageObj.selectSolicitorType() ).selectByVisibleText( searchValue );
                        policyDataFieldsPageObj.next().click();
                        break;
                    case "assign solicitor":
                        claimSummaryPageObj.addSolicitorImg().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.accountSelectionFrame() );
                        claimSummaryPageObj.addSolicitor( searchValue ).click();
                        nextEventPageObj.switchToDefault();
                        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                        searchPageObj.save().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                }
            }
        }
    }

    public void validateClaimListedUnderDashBoard(String claimID) {
        System.out.println( "claim id in validateClaimListedUnderDashBoard******" + this.claimID );
        if (!commandsObj.elementDisplayedWithLessTime( net.serenitybdd.core.annotations.findby.By.xpath( claimSummaryPageObj.claimListedUnderDashBoard( this.claimID ) ) )) {
            System.out.println( "into if loop" );
            System.out.println( "claim id is not listed under dashboard after assertion" );
            navigatingToNextPage();
        } else {
            System.out.println( "into else loop" );
            Assert.assertTrue( commandsObj.elementDisplayedWithLessTime( net.serenitybdd.core.annotations.findby.By.xpath( claimSummaryPageObj.claimListedUnderDashBoard( this.claimID ) ) ) );
            System.out.println( "claim id is listed under dashboard after assertion" );
        }
    }

    public void navigatingToNextPage() {
        claimSummaryPageObj.navigateToNextPage().click();
        System.out.println( "Navigating to next page" );
        validateClaimListedUnderDashBoard( claimID );
    }

    public void validateSLAColor(String color) {
        if (color.equalsIgnoreCase( "Green" )) {
            System.out.println( "claim id in validateSLAColor ******" + this.claimID );
            Assert.assertTrue( claimSummaryPageObj.slaColor( this.claimID ).getAttribute( "alt" ).equalsIgnoreCase( "InsideSla" ) );
        } else if (color.equalsIgnoreCase( "Red" )) {
            Assert.assertTrue( claimSummaryPageObj.slaColor( this.claimID ).getAttribute( "alt" ).equalsIgnoreCase( "OutsideSla" ) );
        }
    }

    public void validateToolTipInDashBoard(String deadLine, String claimID) {
        claimSummaryPageObj.hoveringOverClaimIdInDashboard().click();
        if (claimID.equalsIgnoreCase( "claimId" )) {
            if (commandsObj.elementDisplayedWithLessTime( By.xpath( claimSummaryPageObj.validateDeadlineInDashBoard( this.claimID, deadLine ) ) )) {
                Assert.assertTrue( true );
                System.out.println( "Deadline displayed after assertion" );
            } else {
                System.out.println( "Deadline NOT displayed after assertion" );
            }
        } else if (claimID.equalsIgnoreCase( "TMAclaimId" )) {
            if (commandsObj.elementDisplayedWithLessTime( By.xpath( claimSummaryPageObj.validateDeadlineInDashBoard( this.TMAClaimId, deadLine ) ) )) {
                Assert.assertTrue( true );
                System.out.println( "Deadline displayed after assertion" );
            } else {
                System.out.println( "Deadline NOT displayed after assertion" );
            }
        }
    }

    public void navigateClaimFromDashBoard(String claimID) {
        claimSummaryPageObj.viewClaimFromDashBoard( this.claimID ).click();
        nextEventPageObj.switchToLastOpenWindow();
    }

    public void validateClaimRemovedFromDashBoard(String claimID) {
        claimSummaryPageObj.navigateToDashBoard().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateClaimRemovedFromSLA(String claimID, List<List<String>> parameters) {
        this.retrieveTasksSlaTab( parameters );
    }

    public void retrieveTasksSlaTab(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( i ).size(); j++) {
                String searchField = parameters.get( 0 ).get( j );
                String searchValue = parameters.get( i ).get( j );
                switch (searchField.toLowerCase()) {
                    case "lead type":
                        new Select( setUpPageObj.leadTypeInSLA() ).selectByVisibleText( searchValue );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "service level agreement":
                        new Select( setUpPageObj.slaInSLA() ).selectByVisibleText( searchValue );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "completed":
                        if (searchValue.equalsIgnoreCase( "false" )) {
                        } else if (searchValue.equalsIgnoreCase( "true" )) {
                            setUpPageObj.completedStatusInSLA().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                        }
                        break;
                    case "sla":
                        if (searchValue.equalsIgnoreCase( "withinSLA" )) {
                            setUpPageObj.withinslaInSLA().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                        } else if (searchValue.equalsIgnoreCase( "outsideSLA" )) {
                            setUpPageObj.outsideslaInSLA().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                        }
                        break;
                    case "fromdate":
                        String fromdate = "";
                        SimpleDateFormat sdf1 = new SimpleDateFormat( "dd/MM/yyyy" );
                        Calendar c1 = Calendar.getInstance();
                        c1.setTime( new Date() );
                        fromdate = sdf1.format( c1.getTime() );
                        if (searchValue.equalsIgnoreCase( "currentdate" )) {
                            searchValue = fromdate;
                        }
                        setUpPageObj.fromDateInSLA().sendKeys( Keys.CONTROL + "a" );
                        setUpPageObj.fromDateInSLA().sendKeys( Keys.DELETE );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        setUpPageObj.fromDateInSLA().sendKeys( searchValue );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "todate":
                        String date = "";
                        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
                        Calendar c = Calendar.getInstance();
                        c.setTime( new Date() );
                        date = sdf.format( c.getTime() );
                        if (searchValue.equalsIgnoreCase( "currentdate" )) {
                            searchValue = date;
                        }
                        setUpPageObj.toDateInSLA().sendKeys( Keys.CONTROL + "a" );
                        setUpPageObj.toDateInSLA().sendKeys( Keys.DELETE );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        setUpPageObj.toDateInSLA().sendKeys( searchValue );
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "claimid":
                        String retrievedClaimID = "";
                        retrievedClaimID = ClaimsOperations.claimID;
                        System.out.println( "Retrieved claimID from ClaimOperations Page" + retrievedClaimID );
                        if (!(retrievedClaimID.equals( null ))) {
                            setUpPageObj.claimIDInputBoxInSLA().sendKeys( Keys.CONTROL + "a" );
                            setUpPageObj.claimIDInputBoxInSLA().sendKeys( Keys.DELETE );
                            setUpPageObj.claimIDInputBoxInSLA().sendKeys( retrievedClaimID );
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            setUpPageObj.claimIDInputBoxFilterInSLA().click();
                            setUpPageObj.equalToFilter().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                        } else
                            Assert.assertFalse( true );
                        break;
                    case "validation":
                        if (searchValue.equalsIgnoreCase( "claim should be listed" )) {
                            int size = setUpPageObj.claimValidationInTaskTable().findElements( By.tagName( "tr" ) ).size();
                            System.out.println( "size of task table" + size );
                            if (setUpPageObj.claimValidationInTaskTable().findElements( By.tagName( "tr" ) ).size() > 0) {
                                Assert.assertTrue( true );
                            } else {
                                Assert.assertTrue( false );
                            }
                        } else if (searchValue.equalsIgnoreCase( "claim should not be listed" )) {
                            Assert.assertTrue( setUpPageObj.validateNoTaskListed().isDisplayed() );

                        }
                    case "time remaining":
                        if (searchField.equalsIgnoreCase( "validate" )) {
                            slaForProcess = setUpPageObj.slaInTaskTable().getText();
                            timeRemainingForProcess = setUpPageObj.timeRemainingInTaskTable().getText();
                            boolean flg = false;
                            for (int loop = 0; loop < slaForProcess.length(); loop++) {
                                if (slaForProcess.charAt( loop ) != timeRemainingForProcess.charAt( loop )) {
                                    flg = true;
                                }
                            }
                            if (flg) {
                                Assert.assertTrue( true );
                            } else {
                                Assert.assertFalse( true );
                            }
                        } else if (searchField.equalsIgnoreCase( "Null" )) {
                            slaForProcess = setUpPageObj.slaInTaskTable().getText();
                            Assert.assertTrue( slaForProcess.equalsIgnoreCase( "" ) );
                        }
                        break;
                    case "assignedto":
                        List<String> userDet = userObj.getUserDetails( searchValue );
                        searchValue = userDet.get( 0 );
                        Assert.assertTrue( claimCompetencyPageObj.validateClaimHandlerAssignee( searchValue ).isDisplayed() );
                        break;
                    case "viewclaim":
                        claimSummaryPageObj.viewClaim( ClaimsOperations.claimID ).click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                }
            }
        }
    }

    public void getClaimIdAndMultipleClaimItem(String claimDetails) {
        claimID = nextEventPageObj.firstClaimID().getText();
        System.out.println( "claimID-------------------------" + claimID );
        claimSummaryPageObj.editFirstClaim().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.InternalTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.waitForMoreTime();
        claimItemId1 = claimSummaryPageObj.claimItemIdInInternalTab( claimDetails.split( "#" )[0] ).getText();
        claimItemId2 = claimSummaryPageObj.claimItemIdInInternalTab( claimDetails.split( "#" )[1] ).getText();
        System.out.println( "Claim ItemId for item 1 ------------------------" + claimItemId1 );
        System.out.println( "Claim ItemId for item 2 ------------------------" + claimItemId2 );
        claimSummaryPageObj.saveAndCloseBtn().click();
    }

    public void verifyingReferredClaim(String tabName) {
        navigationObj.navigateToClaimTasks( tabName );
        nextEventPageObj.switchToDefault();
        claimCompetencyPageObj.claimTasksClaimIDFilter().clear();
        claimCompetencyPageObj.claimTasksClaimIDFilter().sendKeys( claimID );
        claimCompetencyPageObj.btnClick( claimCompetencyPageObj.claimTasksClaimIDFilterBtn() );
        System.out.println( "Claim id--------------++++++++++++++++#############" + claimID );
        Assert.assertTrue( claimCompetencyPageObj.referredClaimId( claimID ).isDisplayed() );
    }

    public void editDateOfLoss(String strEditDateOfLoss) {
        basicClaimDetailsPageObj.editDateOfLoss().clear();
        if (!strEditDateOfLoss.equalsIgnoreCase( strNoValueEntryString ) && !strEditDateOfLoss.isEmpty() && strEditDateOfLoss != null) {
            basicClaimDetailsPageObj.editDateOfLoss().sendKeys( strEditDateOfLoss );
            System.out.print( "Inside editDateOfLoss-- after setting" );
        }
    }

    public void navigateToBasePolicyFromPurchasesTab() {
        policyDataFieldsPageObj.navigateToPolicyLinkFromBillingView().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void enterFreeText(String text) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.txtFreeTextBox().sendKeys( text );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick( nextEventPageObj.saveBtn() );
        System.out.println( "Further Information is entered" );
    }

    public void getClaimDetails(String claimDetails) {
        for (int i = 0; i < claimDetails.split( "#" ).length; i++) {
            String calimDetailToRetrieve = claimDetails.split( "#" )[i];
            switch (calimDetailToRetrieve.toLowerCase()) {
                case "customer first name":
                    customerName = policyDataFieldsPageObj.firstName().getAttribute( "value" );
                    System.out.println( "customerName------------------------------" + customerName );
                    break;
                case "customer last name":
                    customerLastName = policyDataFieldsPageObj.lastName().getAttribute( "value" );
                    System.out.println( "customerLastName------------------------------" + customerLastName );
                    break;
                case "dob":
                    customerDOB = policyDataFieldsPageObj.policyHolderDob().getText();
                    System.out.println( "customerDOB------------------------------" + customerDOB );
                    break;
                case "country of loss":
                    countryOfLoss = claimsRepudiationPageObj.lblFirstCountryOfLoss().getText();
                    System.out.println( "countryOfLoss------------------------------" + countryOfLoss );
                    break;
                case "claim id":
                    claimID = claimsRepudiationPageObj.lblFirstClaimID().getText();
                    System.out.println( "claimID------------------------------" + claimID );
                    tmaDetailsPageObj.lnkTMAClaim().click();
                    TMAClaimId = tmaDetailsPageObj.TMAClaimId().getText();
                    System.out.println( "TMA claim id -------------------" + TMAClaimId );
                    break;
                case "claim item id":
                    basicClaimDetObj.getFirstOpenClaim().click();
                    financialPageObj.internalTab().click();
                    commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_PleasewaitLocator(), 60L );
                    commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_Loading(), 60L );
                    commandsObj.waitForLoad( nextEventPageObj.getDriver );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    claimItemId = claimSummaryPageObj.claimItemId().getText();
                    System.out.println( "claimItemId------------------------" + claimItemId );
                    claimSummaryPageObj.saveAndCloseBtn().click();
                    commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_PleasewaitLocator(), 60L );
                    commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_Loading(), 60L );
                    commandsObj.waitForLoad( nextEventPageObj.getDriver );
                    nextEventPageObj.waitForMoreTime();
                    break;
                case "claim date":
                    claimDate = claimsRepudiationPageObj.lblFirstClaimLossDate().getText();
                    break;
                case "tmaclaimid":
                    TMAClaimId = tmaDetailsPageObj.claimIdTMA().getText();
                    System.out.println( "TMA claim id -------------------" + TMAClaimId );
                    tmaDetailsPageObj.lnkTMAClaim().click();
                    retrievedTMAClaimId = tmaDetailsPageObj.TMAClaimId().getText();
                    System.out.println( "Retrieved TMA claim id -------------------" + retrievedTMAClaimId );
            }
        }
    }

    public void captureSupplierType(String country) {
        leftNavPanePageObj.companyDetails().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForPageLoad();
        claimSummaryPageObj.tmaTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForPageLoad();
        configSupplierType = claimSummaryPageObj.txtSupplierType( country ).getText();
        System.out.println( "Supplier type is from configuration----" + configSupplierType );
        configCompanyName = claimSummaryPageObj.txtCompanyName( country ).getText();
        System.out.println( "Company Name is from configuration----" + configCompanyName );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick( claimSummaryPageObj.close() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void verifyPaymentIsOnHold() {
        this.clickingUnderNextEventsAndButtons( "edit first claim" );
        commandsObj.waitForLoad( nextEventPageObj.getDriver );
        navigateToFinancial();
        commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_PleasewaitLocator(), 60L );
        String paymentRowId = financialPageObj.paymentsRowID().getText();
        Assert.assertTrue( financialPageObj.paymentsRowID().getText().equalsIgnoreCase( financialPageObj.onholdPayments( paymentRowId ).getText() ) );
    }

    public void selectRepudiateReasonDropowns(List<List<String>> parameters) {
        try {
            nextEventPageObj.switchToDefault();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            claimSummaryPageObj.outOfProcessEvent().click();
            nextEventPageObj.btnClick( nextEventPageObj.go() );
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
            navigationObj.navigateToNextEventType( "OOP Repudiate Line Item(s)" );
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            this.validateRepudiateClaimItems( parameters );
            System.out.println( "^^^^^^^^^^^^^^^^^^^^Save btnnnnnnnnnnnnn" );
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void selectApproveRejectForPartialRepudiationWithReasons(String approveReject, List<List<String>> parameters) {
        String parameterHeader, parameterValues = "";
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        System.out.println( "Parameters size: " + parameters.size() );
        for (int k = 0; k < parameters.size() - 1; k++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                parameterHeader = parameters.get( 0 ).get( j );
                parameterValues = parameters.get( 1 ).get( j );
                System.out.println( "line items header-----------------------------" + parameterHeader );
                System.out.println( "line items value-----------------------------" + parameterValues );
                switch (parameterHeader.toLowerCase()) {
                    case "reason":
                        new Select( claimsRepudiationPageObj.ReasonApproveRejectPrimaryReason( k + 2 ) ).selectByVisibleText( parameterValues );
                        break;
                    case "subreason":
                        new Select( claimsRepudiationPageObj.ReasonApproveRejectSubReason( k + 2 ) ).selectByVisibleText( parameterValues );
                        break;
                    case "approve/reject":
                        if (parameterValues.equalsIgnoreCase( "yes" )) {
                            new Select( claimsRepudiationPageObj.ApproveRejectPartialRepudiation( k + 2 ) ).selectByVisibleText( "Approve" );
                        } else {
                            new Select( claimsRepudiationPageObj.ApproveRejectPartialRepudiation( k + 2 ) ).selectByVisibleText( "Rejection" );
                        }
                        break;
                }
            }
        }
        claimsRepudiationPageObj.btnSave().click();
    }

    public void valueForRepudiationLetter(List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_PleasewaitLocator(), 60L );
        commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_Loading(), 60L );
        nextEventPageObj.switchToDefault();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                String fieldName = parameters.get( 0 ).get( j );
                String fieldValue = parameters.get( i ).get( j );
                switch (fieldName) {
                    case "enter policy wording related to repudiation":
                        claimSummaryPageObj.enterPolicyWordingRelatesToRepudiation().sendKeys( fieldValue );
                        break;
                    case "to explain how the circumstances relates to policy wording":
                        claimSummaryPageObj.enterExplainationRelatesToPolicyWording().sendKeys( fieldValue );
                        break;
                }
            }
        }
    }

    public void validateAdditionalPerilsWithClaim(List<List<String>> parameters) {
        String causeCodeValue = "";
        commandsObj.waitForLoad( getDriver() );
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                String causeCode = parameters.get( 0 ).get( j );
                if (causeCode.equalsIgnoreCase( "subcausecode" )) {
                    causeCodeValue = parameters.get( i ).get( j - 1 ) + " - " + parameters.get( i ).get( j );
                    System.out.println( "causeCodeValue------------------causeCodeValue----------------" + causeCodeValue );
                }
                validatePerilClaimDetails( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ), causeCodeValue );
            }
        }
    }

    public void validatePerilClaimDetails(String searchField, String searchValue, String causeCodeValue) {
        switch (searchField.toLowerCase()) {
            case "causecode":
                String strContinue = "Yes";
                int iTried = 0;
                do {
                    iTried++;
                    try {
                        new Select( perilsAndCostsPageObj.claimCause() ).selectByVisibleText( searchValue );
                        break;
                    } catch (Exception ex) {
                        if (ex.equals( "org.openqa.selenium.NoSuchElementException" )) {
                            strContinue = "Yes";
                            if (iTried > 5) {
                                strContinue = "No";
                                break;
                            }
                        } else if (iTried > 15) {
                            break;
                        }
                    }
                } while (strContinue.equalsIgnoreCase( "Yes" ));
                break;
            case "subcausecode":
                subcausecodestring = searchValue;
                new Select( perilsAndCostsPageObj.claimSubCause() ).selectByVisibleText( searchValue );
                break;
            case "descriptioncausecode":
                perilsAndCostsPageObj.claimCauseDesc().clear();
                perilsAndCostsPageObj.claimCauseDesc().sendKeys( searchValue );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                perilsAndCostsPageObj.claimSavePeril().click();
                break;
            case "personname":
                System.out.println( searchValue );
                if (searchValue.equalsIgnoreCase( "default" )) {
                    this.addPersonClaimCost();
                    nextEventPageObj.btnClick( perilsAndCostsPageObj.addClaimItem() );
                } else {
                    perilsAndCostsPageObj.claimAddPersonPeril( causeCodeValue ).click();
                    perilsAndCostsPageObj.claimAddPerson( searchValue ).click();
                    commandsObj.waitForLoad( getDriver() );
                    perilsAndCostsPageObj.addClaimItemPerson( searchValue, causeCodeValue ).click();
                    commandsObj.waitForLoad( getDriver() );
                    nextEventPageObj.waitForMoreTime();
                }
                break;
            case "claimitem1":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
                nextEventPageObj.switchToFrameById( nextEventPageObj.fancyFrame() );
                nextEventPageObj.btnClick( perilsAndCostsPageObj.cancelClaimItems() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick( perilsAndCostsPageObj.addClaimItem() );
                List<WebElement> lstOption = new Select( perilsAndCostsPageObj.claimDetail1() ).getOptions();
                perilsAndCostsPageObj.waitForMoreTime();
                new Select( perilsAndCostsPageObj.claimDetail1() ).selectByIndex( ((lstOption.size()) - 1) );
                perilsAndCostsPageObj.waitForMoreTime();
                try {
                    System.out.println( "Claim Item 1 try block...." );
//                    new Select(perilsAndCostsPageObj.claimDetail1()).selectByVisibleText(searchValue);
                    selectObj.selectValueFromDropdown( perilsAndCostsPageObj.claimDetail1(), searchValue );
                } catch (NoSuchElementException e) {
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    System.out.println( "Claim Item 1 catch block...." );
                    nextEventPageObj.btnClick( perilsAndCostsPageObj.cancelClaimItems() );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.btnClick( perilsAndCostsPageObj.addClaimItem() );
                    List<WebElement> lstOptions = new Select( perilsAndCostsPageObj.claimDetail1() ).getOptions();
                    perilsAndCostsPageObj.waitForMoreTime();
                    new Select( perilsAndCostsPageObj.claimDetail1() ).selectByIndex( ((lstOptions.size()) - 1) );
                    perilsAndCostsPageObj.waitForMoreTime();
                    // new Select(perilsAndCostsPageObj.claimDetail1()).selectByVisibleText(searchValue);
                    selectObj.selectValueFromDropdown( perilsAndCostsPageObj.claimDetail1(), searchValue );
                }
                break;
            case "claimitem2":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (searchValue.equalsIgnoreCase( "Hospital Bill" )) {
                }
                List<WebElement> lstOptionClaimItem = new Select( perilsAndCostsPageObj.claimDetail2() ).getOptions();
                perilsAndCostsPageObj.waitForMoreTime();
                new Select( perilsAndCostsPageObj.claimDetail2() ).selectByIndex( ((lstOptionClaimItem.size()) - 1) );
                perilsAndCostsPageObj.waitForMoreTime();
//                new Select(perilsAndCostsPageObj.claimDetail2()).selectByVisibleText(searchValue);
                //  new Select(perilsAndCostsPageObj.claimDetail2()).selectByVisibleText(searchValue);
                selectObj.selectValueFromDropdown( perilsAndCostsPageObj.claimDetail2(), searchValue );
                break;
            case "descriptioncosttype":
                perilsAndCostsPageObj.costTypeDesc().clear();
                perilsAndCostsPageObj.costTypeDesc().sendKeys( searchValue );
                break;
            case "cost":
                if (searchValue.equalsIgnoreCase( "NA" )) {
                    System.out.println( "Do Nothing" );
                } else {
                    perilsAndCostsPageObj.costTypeAmount().sendKeys( searchValue );
                }
                break;
            case "gbpvalue":
                perilsAndCostsPageObj.costTypeGBP().sendKeys( searchValue );
                break;
            case "currency":
                perilsAndCostsPageObj.waitForMoreTime();
                List<WebElement> lstOptions = new Select( perilsAndCostsPageObj.costTypeCurrency() ).getOptions();
                perilsAndCostsPageObj.waitForMoreTime();
                new Select( perilsAndCostsPageObj.costTypeCurrency() ).selectByIndex( ((lstOptions.size()) - 1) );
                perilsAndCostsPageObj.waitForMoreTime();
                new Select( perilsAndCostsPageObj.costTypeCurrency() ).selectByVisibleText( searchValue );
                break;
            case "action":
            case "type":
                if (!searchValue.equalsIgnoreCase( "Do Not Save" )) {
                    perilsAndCostsPageObj.saveClaimItem().click();
                }
                break;
            case "peril":
                if (searchValue.equalsIgnoreCase( "add" )) {
                    perilsAndCostsPageObj.addPeril().click();
                }
        }
    }

    public void selectLetterType(String type) {
        nextEventPageObj.switchToDefault();
        this.clickingUnderNextEventsAndButtons( "Go" );
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        new Select( claimSummaryPageObj.selectLetterType() ).selectByVisibleText( type );
        try {
            Thread.sleep( 2000L );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nextEventPageObj.btnClick( nextEventPageObj.nextButtonSensitive() );
    }

    public void gettingExcessValue(List<List<String>> perilDetails) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        schemeSummaryPageObj.editSpecificScheme().click();
        schemeSummaryPageObj.coverTermsTab().click();
        for (int i = 1; i < perilDetails.size(); i++) {
            for (int j = 0; j < perilDetails.get( 0 ).size(); j++) {
                switch (perilDetails.get( 0 ).get( j ).toLowerCase()) {
                    case "cause":
                        if (!perilDetails.get( i ).get( j ).equalsIgnoreCase( "Blank" )) {
                            schemeSummaryPageObj.causeExcess().sendKeys( perilDetails.get( i ).get( j ) );
                            schemeSummaryPageObj.causeExcessFilter().click();
                            schemeSummaryPageObj.containsFilter().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                        }
                        break;
                    case "sub cause":
                        if (!perilDetails.get( i ).get( j ).equalsIgnoreCase( "Blank" )) {
                            schemeSummaryPageObj.subCauseExcess().sendKeys( perilDetails.get( i ).get( j ) );
                            schemeSummaryPageObj.subCauseExcessFilter().click();
                            schemeSummaryPageObj.containsFilter().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                        }
                        break;
                    case "claim detail1":
                        if (!perilDetails.get( i ).get( j ).equalsIgnoreCase( "Blank" )) {
                            schemeSummaryPageObj.claimDetail1Excess().sendKeys( perilDetails.get( i ).get( j ) );
                            schemeSummaryPageObj.claimDetail11Filter().click();
                            schemeSummaryPageObj.containsFilter().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                        }
                        break;
                    case "claim detail2":
                        if (!perilDetails.get( i ).get( j ).equalsIgnoreCase( "Blank" )) {
                            schemeSummaryPageObj.claimDetail2Excess().sendKeys( perilDetails.get( i ).get( j ) );
                            schemeSummaryPageObj.claimDetail21Filter().click();
                            schemeSummaryPageObj.containsFilter().click();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                        }
                        break;
                }
            }
        }
        excessValue = claimSummaryPageObj.retrievepolicyExcessAmount().getText();
        System.out.println( "Excess value----------------" + excessValue );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        schemeSummaryPageObj.saveAndCloseBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validatingExcessValue() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        clickingUnderNextEventsAndButtons( "cancel" );
        nextEventPageObj.switchToDefault();
        clickingUnderNextEventsAndButtons( "edit first claim" );
        financialPageObj.financialTab().click();
        String excessValueDed = financialPageObj.excessValueDeducted().getText();//getAttribute("value");
        System.out.println( "excess -------------------" + excessValueDed + "-----excessValue----------------" + excessValue );
        Assert.assertTrue( excessValue.equalsIgnoreCase( excessValueDed ) );
        clickingUnderNextEventsAndButtons( "close edit claim" );
    }

    public void cr21PerilQuestionsValidation(List<List<String>> parameters) {
        SoftAssertions softAssertions = new SoftAssertions();
        for (int iRow = 1; iRow < parameters.size(); iRow++) {
            String strFieldName = "";
            String strFieldValue = "";
            String chooseAns = "";
            String questionFromInput = "";
            String questionFromAppln = "";
            String yesOption = "";
            String noOption = "";
            String optionsVal = "";
            for (int iCol = 0; iCol < parameters.get( 0 ).size(); iCol++) {
                strFieldName = parameters.get( 0 ).get( iCol );
                strFieldValue = parameters.get( iRow ).get( iCol );
                switch (strFieldName.toLowerCase()) {
                    case "question":
                        questionFromInput = strFieldValue;
                        System.out.println( "Question from input:: " + questionFromInput );
                        break;
                    case "questionid":
                        questionFromAppln = customerPortalPerilQuesPageObj.perilQuestionforClaimOccurDueToPerilItem( strFieldValue ).getText();
                        System.out.println( "Question from appln:: " + questionFromAppln );
                        break;
                    case "options":
                        optionsVal = strFieldValue;
                        System.out.println( "Option value:: " + optionsVal );
                        break;
                    case "answer":
                        chooseAns = strFieldValue;
                        System.out.println( "Chosen Answer :: " + chooseAns );
                        break;
                }
            }
            if (questionFromInput.length() - questionFromAppln.length() == 2) {
                questionFromInput = questionFromInput.substring( 0, questionFromInput.length() - 2 );
            }
            //Assert.assertTrue("Validating Question: " + questionFromInput, questionFromInput.equalsIgnoreCase(questionFromAppln));
            softAssertions.assertThat( questionFromAppln.trim() ).describedAs( "Validating Question: " + questionFromInput ).isEqualToIgnoringCase( questionFromInput.trim() );
            String[] options = optionsVal.split( "#" );
            for (String option : options) {
                if (option.equalsIgnoreCase( "Yes" )) {
                    yesOption = customerPortalPerilQuesPageObj.ansButton( option ).getText();
                    //Assert.assertTrue("Validating Answer Options: " + yesOption, "Yes".equalsIgnoreCase(yesOption));
                    softAssertions.assertThat( yesOption.trim() ).describedAs( "Validating Answer Options: " + yesOption ).isEqualToIgnoringCase( "Yes" );
                } else if (option.equalsIgnoreCase( "No" )) {
                    noOption = customerPortalPerilQuesPageObj.ansButton( option ).getText();
                    //Assert.assertTrue("Validating Answer Options: " + noOption, "No".equalsIgnoreCase(noOption));
                    softAssertions.assertThat( noOption.trim() ).describedAs( "Validating Answer Options: " + noOption ).isEqualToIgnoringCase( "No" );
                } else {
                    List<WebElement> webOptions = customerPortalPerilQuesPageObj.itemLostLocationDropDown().findElements( By.tagName( "Option" ) );
                    boolean dropDownMatch = false;
                    for (WebElement webelement : webOptions) {
                        String dropDownText = webelement.getText();
                        if (option.equalsIgnoreCase( dropDownText )) {
                            dropDownMatch = true;
                            break;
                        }
                    }
                    softAssertions.assertThat( dropDownMatch ).describedAs( "Validating Drop Down Options:: " + option );
                }
            }
            if ("Yes".equalsIgnoreCase( chooseAns ) || "No".equalsIgnoreCase( chooseAns )) {
                nextEventPageObj.btnClick( customerPortalPerilQuesPageObj.ansButton( chooseAns ) );
            } else {
                nextEventPageObj.selectDrop( customerPortalPerilQuesPageObj.itemLostLocationDropDown(), chooseAns );
            }
        }
        softAssertions.assertAll();
    }

    public void cr21PerilQuestionsItems(List<List<String>> parameters) {
        for (int iRow = 1; iRow < parameters.size(); iRow++) {
            String strFieldName = "";
            String strFieldValue = "";
            String chooseAns = "";
            String questionFromAppln = "";
            String optionsVal = "";
            Calendar c = Calendar.getInstance();
            c.setTime( new Date() );
            System.out.println( "Claim no------------------------" );
            for (int iCol = 0; iCol < parameters.get( 0 ).size(); iCol++) {
                strFieldName = parameters.get( 0 ).get( iCol );
                strFieldValue = parameters.get( iRow ).get( iCol );
                switch (strFieldName.toLowerCase()) {
                    case "questionid":
                        questionFromAppln = customerPortalPerilQuesPageObj.perilQuestionforClaimOccurDueToPerilItem( strFieldValue ).getText();
                        System.out.println( "Question from appln:: " + questionFromAppln );
                        break;
                    case "options":
                        optionsVal = strFieldValue;
                        System.out.println( "Option value:: " + optionsVal );
                        break;
                    case "answer":
                        if (strFieldValue.equalsIgnoreCase( "main account holder" )) {
                            chooseAns = customerPortalPerilQuesPageObj.itemLostLocationDropDown().findElement( By.xpath( "//option[2]" ) ).getText();
                        } else {
                            chooseAns = strFieldValue;
                        }
                        System.out.println( "Chosen Answer :: " + chooseAns );
                        break;
                }
            }
            if ("Yes#No".equalsIgnoreCase( optionsVal )) {
                nextEventPageObj.btnClick( customerPortalPerilQuesPageObj.ansButton( chooseAns ) );
            } else if ("DropDown".equalsIgnoreCase( optionsVal )) {
                if (chooseAns.equalsIgnoreCase( "Default" ) || chooseAns.equalsIgnoreCase( "Document" ) || chooseAns.equalsIgnoreCase( "DigTester" ) || chooseAns.equalsIgnoreCase( "Test" )) {
                    List<WebElement> person = new Select( customerPortalPerilQuesPageObj.selectInsuredPerson() ).getOptions();
                    for (WebElement webElement : person) {
                        String selectPerson = webElement.getText();
                        System.out.println( "Selecting person is ------" + selectPerson );
                        if (selectPerson.contains( "Document" ) || selectPerson.contains( "DigTester" )) {
                            webElement.click();
                            break;
                        }
                    }
                } else {
                    selectObj.selectValueFromDropdown( customerPortalPerilQuesPageObj.itemLostLocationDropDown(), chooseAns );
                }
            }
            else if ("TextField".equalsIgnoreCase( optionsVal )) {
                customerPortalPerilQuesPageObj.itemEnterDetails().sendKeys( chooseAns );
                customerPortalPerilQuesPageObj.itemEnterDetailsValidate().click();
            } else if ("TextFieldForSearchCondition".equalsIgnoreCase( optionsVal ) || ("AjaxCall".equalsIgnoreCase( optionsVal ))) {
                if (commandsObj.elementDisplayedWithLessTime( By.xpath( customerPortalPerilQuesPageObj.otherMedicalRadioBtn() ) )) {
                    nextEventPageObj.btnClick( customerPortalPerilQuesPageObj.otherMedicalRadioBtnElement() );
                }
                customerPortalPerilQuesPageObj.searchCondition().sendKeys( chooseAns );
                customerPortalPerilQuesPageObj.clickOnCondition( chooseAns ).click();
            } else if ("Radiobutton".equalsIgnoreCase( optionsVal )) {
                customerPortalPerilQuesPageObj.clickPreMedicalCondition( chooseAns ).click();
            } else if ("DateField".equalsIgnoreCase( optionsVal )) {
                customerPortalPerilQuesPageObj.clickReturnHome().click();
                this.dateCalendarForPerilQuestions( chooseAns );
            }
        }
        nextEventPageObj.waitForMoreTime();
        customerPortalMyClaimsPageObj.btnClick( customerPortalMyClaimsPageObj.btnNext() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void verifyExcessValue(List<List<String>> parameters) {
        excessValue = parameters.get( 1 ).get( 1 );
        nextEventPageObj.switchToDefault();
        clickingUnderNextEventsAndButtons( "edit first claim" );
        claimSummaryPageObj.perilsAndCost().click();
        commandsObj.waitForElementInVisibleInSec( nextEventPageObj.getLoader_Loading(), 60L );
        commandsObj.waitForLoad( claimSummaryPageObj.getDriver );
        String excessValueDed = perilsAndCostsPageObj.validateExcessValue().getText();
        System.out.println( "excess -------------------" + excessValueDed + "-----excessValue----------------" + excessValue );
        Assert.assertEquals( "Validating Excess", excessValue, excessValueDed );
        clickingUnderNextEventsAndButtons( "close edit claim" );
    }

    public void answerPerilQuestions(List<List<String>> questions) {
        String strQuesID = "";
        String strchooseAns = "";
        String strAvailableoption = "";
        for (int i = 1; i < questions.size(); i++) {
            strQuesID = questions.get( i ).get( 0 );
            strAvailableoption = questions.get( i ).get( 1 );
            strchooseAns = questions.get( i ).get( 2 );
            String questionFromApplication = claimsRepudiationPageObj.questionFromAQ( strQuesID ).getText();
            System.out.println( "Question from application---------------" + questionFromApplication );
            if (strAvailableoption.equalsIgnoreCase( "Yes#No" )) {
                System.out.println( "Available options----" + strAvailableoption + "------selected option-------" + strchooseAns );
                claimsRepudiationPageObj.selectAnswerYesOrNo( strQuesID, strchooseAns ).click();
            } else if (strAvailableoption.equalsIgnoreCase( "DropDown" )) {
                System.out.println( "Available options----" + strAvailableoption + "------drop down----" + strchooseAns );
                if (strchooseAns.equalsIgnoreCase( "main account holder" )) {
                    List<WebElement> options = new Select( claimsRepudiationPageObj.selectAnswerDropdown( strQuesID ) ).getOptions();
                    for (int j = 0; j < options.size(); j++) {
                        String optionTxt = options.get( j ).getText();
                        System.out.println( "customer ---------------" + retrieveRandomCustomerFirstName.concat( " " + retrieveRandomCustomerLastName + "(" + retrieveCustomerDOB + ")" ) );
                        System.out.println( "options ---------- " + optionTxt );
                        if (optionTxt.equalsIgnoreCase( retrieveRandomCustomerFirstName.concat( " " + retrieveRandomCustomerLastName + " (" + retrieveCustomerDOB + ")" ) )) {
                            strchooseAns = optionTxt;
                            System.out.println( "First name------------------" + strchooseAns );
                            break;
                        }
                    }
                } else if (strchooseAns.equalsIgnoreCase( "main account holder affinion" )) {
                    List<WebElement> options = new Select( claimsRepudiationPageObj.selectAnswerDropdown( strQuesID ) ).getOptions();
                    for (int j = 0; j < options.size(); j++) {
                        String optionTxt = options.get( j ).getText();
                        System.out.println( "customer ---------------" + TTAPIMappingValueRequestOperations.firstName );
                        System.out.println( "options ---------- " + optionTxt );
                        if (optionTxt.contains( TTAPIMappingValueRequestOperations.firstName )) {
                            strchooseAns = optionTxt;
                            System.out.println( "First name------------------" + strchooseAns );
                            break;
                        }
                    }
                } else if (strchooseAns.equalsIgnoreCase( "primary joint account holder affinion" )) {
                    System.out.println( "into else part1 of primary joint account holder" );
                    List<WebElement> options = new Select( claimsRepudiationPageObj.selectAnswerDropdown( strQuesID ) ).getOptions();
                    for (int j = 0; j < options.size(); j++) {
                        String optionTxt = options.get( j ).getText();
                        System.out.println( "into else part2 of primary joint account holder" );
                        System.out.println( "customer ---------------" + TTAPIMappingValueRequestOperations.secondaryFirstName );
                        System.out.println( "options ---------- " + optionTxt );
                        if (optionTxt.contains( TTAPIMappingValueRequestOperations.secondaryFirstName )) {
                            strchooseAns = optionTxt;
                            System.out.println( "First name------------------" + strchooseAns );
                            break;
                        }
                    }
                } else if (strchooseAns.equalsIgnoreCase( "second joint account holder affinion" )) {
                    List<WebElement> options = new Select( claimsRepudiationPageObj.selectAnswerDropdown( strQuesID ) ).getOptions();
                    for (int j = 0; j < options.size(); j++) {
                        String optionTxt = options.get( j ).getText();
                        System.out.println( "customer ---------------" + TTAPIMappingValueRequestOperations.secondJHFirstName );
                        System.out.println( "options ---------- " + optionTxt );
                        if (optionTxt.contains( TTAPIMappingValueRequestOperations.secondJHFirstName )) {
                            strchooseAns = optionTxt;
                            System.out.println( "First name------------------" + strchooseAns );
                            break;
                        }
                    }
                } else if (strchooseAns.equalsIgnoreCase( "third joint account holder affinion" )) {
                    List<WebElement> options = new Select( claimsRepudiationPageObj.selectAnswerDropdown( strQuesID ) ).getOptions();
                    for (int j = 0; j < options.size(); j++) {
                        String optionTxt = options.get( j ).getText();
                        System.out.println( "customer ---------------" + TTAPIMappingValueRequestOperations.thirdJHFirstName );
                        System.out.println( "options ---------- " + optionTxt );
                        if (optionTxt.contains( TTAPIMappingValueRequestOperations.thirdJHFirstName )) {
                            strchooseAns = optionTxt;
                            System.out.println( "First name------------------" + strchooseAns );
                            break;
                        }
                    }
                }
                selectObj.selectValueFromDropdown( claimsRepudiationPageObj.selectAnswerDropdown( strQuesID ), strchooseAns );
            } else if (strAvailableoption.equalsIgnoreCase( "TextField" )) {
                System.out.println( "Available options----" + strAvailableoption + "-------Textfield -------" + strchooseAns );
                claimsRepudiationPageObj.selectAnswerTextArea( strQuesID ).sendKeys( strchooseAns );
                claimsRepudiationPageObj.selectAnswerTextAreaClick( strQuesID ).click();
            }
             else if (strAvailableoption.equalsIgnoreCase( "TextSearchField" ) || strAvailableoption.equalsIgnoreCase( "Ajaxcall" )) {
                if (commandsObj.elementDisplayedWithLessTime( By.xpath( customerPortalPerilQuesPageObj.otherMedicalRadioBtn() ) )) {
                    System.out.println( "inside the other medical option" );
                    nextEventPageObj.btnClick( customerPortalPerilQuesPageObj.otherMedicalRadioBtnElement() );
                }
                System.out.println( "Available options----" + strAvailableoption + "-------TextSearchField -------" + strchooseAns );
                claimsRepudiationPageObj.selectAnswerTextSearchField( strQuesID ).sendKeys( strchooseAns );
                claimsRepudiationPageObj.selectAnswerTextSearchFieldClick( strQuesID, strchooseAns ).click();
            } else if (strAvailableoption.equalsIgnoreCase( "DateField" )) {
                System.out.println( "Available options----" + strAvailableoption + "-------DateField -------" + strchooseAns );
                claimsRepudiationPageObj.clickReturnHome().click();
                this.dateCalendarForPerilQuestions( strchooseAns );
            } else if (strAvailableoption.equalsIgnoreCase( "RadioControl" )) {
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println( "Available options----" + strAvailableoption + "-------DateField -------" + strchooseAns );
                claimsRepudiationPageObj.selectMedicalCondition( strchooseAns ).click();
            }
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void verifyOutcome(String outcome) {
        claimsRepudiationPageObj.outcome( outcome ).isDisplayed();
        String appoutcome[] = claimsRepudiationPageObj.outcome( outcome ).getText().split( " " );
        System.out.println( "Outcome-------" + claimsRepudiationPageObj.outcome( outcome ).getText() );
        System.out.println( "Outcome-------" + appoutcome[0] );
        System.out.println( "Outcome-------" + appoutcome[1] );
        Assert.assertTrue( outcome.equalsIgnoreCase( appoutcome[1] ) );
    }

    public void comparePerilQuestionsAndAnswers(List<List<String>> ques) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        nextEventPageObj.switchToFrameById( nextEventPageObj.fancyFrame() );
        for (int i = 1; i < ques.size(); i++) {
            for (int j = 0; j < ques.get( 0 ).size(); j++) {
                String id = ques.get( i ).get( 0 );
                String ans = ques.get( i ).get( 1 );
                System.out.println( "question ID ------------" + id + "-----Answer---------" + ans );
                System.out.println( "Answers from app----------------------" + claimSummaryPageObj.compareAnswer( id, ans ).getText() );
                Assert.assertTrue( claimSummaryPageObj.compareAnswer( id, ans ).getText().equalsIgnoreCase( ans ) );
            }
        }
    }

    public void dateCalendarForPerilQuestions(String fieldValue) {
        String dateValues = "";
        String sMonth = "";
        String sDate = "";
        String futureMonth = "";
        String futureYear = "";
        dateValues = this.tripDate( fieldValue );
        System.out.println( "dateval:" + dateValues );
        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
        SimpleDateFormat sMonthYear = new SimpleDateFormat( "MMMM YYYY" );
        SimpleDateFormat sDt = new SimpleDateFormat( "dd" );
        sDate = "";
        try {
            sMonth = sMonthYear.format( sdf.parse( dateValues ) );
            sDate = sDt.format( sdf.parse( dateValues ) );
        } catch (ParseException p) {
            System.out.println( "Parse Exception : " + p );
        }
        futureMonth = sMonth.trim().split( " " )[0];
        futureYear = sMonth.trim().split( " " )[1];
        System.out.println( "Date Format-Year---" + futureYear );
        System.out.println( "Date Format-Month---" + futureMonth );
        System.out.println( "*****Future-date***" + sDate );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.elementDisplayed( customerPortalPerilQuesPageObj.lblmonth() );
        nextEventPageObj.waitForMoreTime();
        System.out.println( " Month needs to be selected is -------------" + futureMonth );
        new Select( customerPortalPerilQuesPageObj.drpdnFromMonth() ).selectByVisibleText( futureMonth );
        nextEventPageObj.waitForMoreTime();
        if (sDate.startsWith( "0" )) {
            sDate = sDate.substring( 1 );
        }
        customerPortalPerilQuesPageObj.dateTableForTripFromDateXpath( sDate ).click();
        nextEventPageObj.waitForMoreTime();
    }

    public String tripDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
        Calendar c = Calendar.getInstance();
        c.setTime( new Date() );
        String returnValue = null;
        switch (date.toLowerCase()) {
            case "today":
            case "currentdate":
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "futuredate1month":
                c.add( Calendar.DATE, 30 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "futuredate184days":
                c.add( Calendar.DATE, 184 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "futuredate60days":
                c.add( Calendar.DATE, 59 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "futuredate90days":
                c.add( Calendar.DATE, 90 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "futuredate31days":
                c.add( Calendar.DATE, 30 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "futuredate30days":
                c.add( Calendar.DATE, 29 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "futuredate32days":
                c.add( Calendar.DATE, 31 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "futuredate22days":
                c.add( Calendar.DATE, 22 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "futuredate2month":
                c.add( Calendar.MONTH, 2 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "tomorrow":
            case "nextday":
                c.add( Calendar.DATE, 1 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "futuredate6month":
                c.add( Calendar.MONTH, 6 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "futuredate1yr":
                c.add( Calendar.YEAR, 1 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "futuredatebyexceeding1yr":
                c.add( Calendar.DATE, 366 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "futuredate18months":
                c.add( Calendar.MONTH, 18 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "backdate1month":
                c.add( Calendar.MONTH, -1 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "previousdayoftripstartdate":
                c.add( Calendar.DATE, 29 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "backdate5days":
                c.add( Calendar.DATE, -5 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "backdate22days":
                c.add( Calendar.DATE, -22 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "yesterday":
                c.add( Calendar.DATE, -1 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "futuredate10days":
                c.add( Calendar.DATE, 10 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "backdate4days":
                c.add( Calendar.DATE, -4 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
            case "backdate2days":
                c.add( Calendar.DATE, -2 );
                date = sdf.format( c.getTime() );
                returnValue = date;
                System.out.println( "***** Date ***" + returnValue );
                break;
        }
        return returnValue;
    }

    public void enterClaimsLevelCorrespondenceDetails(List<List<String>> lstInput) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById( nextEventPageObj.frame() );
        for (int i = 1; i < lstInput.size(); i++) {
            System.out.println( "----------------i value ------------------" + i );
            for (int j = 0; j < lstInput.get( 0 ).size(); j++) {
                System.out.println( "----------------j value ------------------" + j + "----------lstInput.get(0).get(j).toLowerCase()------------" + lstInput.get( 0 ).get( j ).toLowerCase() );
                this.enterCorrespondenceDetails( lstInput.get( 0 ).get( j ), lstInput.get( i ).get( j ) );
            }
        }
    }

    private void enterCorrespondenceDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "title":
                basicClaimDetailsPageObj.txtTitleName().sendKeys( fieldValue );
                basicClaimDetailsPageObj.txtTitleName().sendKeys( Keys.TAB );
                break;
            case "firstname":
                basicClaimDetailsPageObj.txtFirstName().sendKeys( fieldValue );
                basicClaimDetailsPageObj.txtFirstName().sendKeys( Keys.TAB );
                break;
            case "surname":
                basicClaimDetailsPageObj.txtSurname().sendKeys( fieldValue );
                basicClaimDetailsPageObj.txtSurname().sendKeys( Keys.TAB );
                break;
            case "addressline1":
                basicClaimDetailsPageObj.txtAddressLine1().sendKeys( fieldValue );
                basicClaimDetailsPageObj.txtAddressLine1().sendKeys( Keys.TAB );
                break;
            case "town":
                basicClaimDetailsPageObj.txtTown().sendKeys( fieldValue );
                basicClaimDetailsPageObj.txtTown().sendKeys( Keys.TAB );
                break;
            case "postcode":
                basicClaimDetailsPageObj.txtPostcode().sendKeys( fieldValue );
                basicClaimDetailsPageObj.txtPostcode().sendKeys( Keys.TAB );
                break;
            case "mobile telephone":
                basicClaimDetailsPageObj.txtMobileTelephone().sendKeys( fieldValue );
                basicClaimDetailsPageObj.txtMobileTelephone().sendKeys( Keys.TAB );
                break;
            case "home telephone":
                basicClaimDetailsPageObj.txtHomeTelephone().sendKeys( fieldValue );
                basicClaimDetailsPageObj.txtHomeTelephone().sendKeys( Keys.TAB );
                break;
            case "email address":
                basicClaimDetailsPageObj.txtEmailAddress().sendKeys( fieldValue );
                basicClaimDetailsPageObj.txtEmailAddress().sendKeys( Keys.TAB );
                break;
            case "relationship to customer":
                basicClaimDetailsPageObj.drpRelationshipToCustomer().click();
                basicClaimDetailsPageObj.drpClickRelationshipToCustomer( fieldValue ).click();
                break;
            case "mental incapacity claimant name":
                basicClaimDetailsPageObj.txtMentalIncapacityClaimant().sendKeys( fieldValue );
                basicClaimDetailsPageObj.txtMentalIncapacityClaimant().sendKeys( Keys.TAB );
                break;
        }
    }

    public void partialClaimSelectedItems() {
        List<WebElement> lineItemsSelectedCheckboxValues = nextEventPageObj.findElements( By.xpath( claimPaymentPageObj.claimItemsSelectedXpath() ) );
        System.out.println( "line items-----------------------------" + lineItemsSelectedCheckboxValues.size() );
        partialItemsAmount = claimPaymentPageObj.calculatedClaimAmount().getText().replaceAll( ".00", "" );
        System.out.println( "Displayed partialItemsAmount*****" + partialItemsAmount );
//        if (lineItemsSelectedCheckboxValues.size() > 0) {
//            for (int i = 0; i < lineItemsSelectedCheckboxValues.size(); i++) {
//                values = Integer.parseInt(lineItemsSelectedCheckboxValues.get(i).getText().replaceAll(".00", ""));
//                System.out.println("Claim values: " + values);
//                itemsValues = itemsValues + values;
//            }
//        }

    }

    public void validateClaimDetailsInPerilAndCoststab(List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimSummaryPageObj.perilsAndCost_Tab_Claim().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
//        for (int i = 1; i < parameters.size(); i++) {
//            for (int j = 0; j < parameters.get(0).size(); j++) {
        this.validateClaimDetailsInPerilCost( parameters );
//            }
//        }
        claimSummaryPageObj.close().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }


    public void validateClaimDetailsInPerilCost(List<List<String>> parameters) {
//        List<WebElement> lstRows = getDriver().findElements(By.xpath("//*[contains(text(),'Claim Items:')]/../../following-sibling::tr//table//tbody/tr"));
        List<WebElement> lstRows = claimSummaryPageObj.claimItemsTable().findElements( By.tagName( "tr" ) );
        System.out.println( "row size:" + lstRows.size() );
//        for (int iRow = 0; iRow < lstRows.size(); iRow++) {
        int iRow = 0;
        while (iRow < lstRows.size()) {
            for (int i = 1; i < parameters.size(); i++) {
                for (int j = 0; j < parameters.get( 0 ).size(); j++) {

                    switch (parameters.get( 0 ).get( j ).toLowerCase()) {
                        case "claimdetail1":
                            System.out.println( "xpath--------------" + claimSummaryPageObj.claimDetail1( iRow + 1 ) );
                            System.out.println( "Claim Details1" + claimSummaryPageObj.claimDetail1( iRow + 1 ).getText() );
                            Assert.assertTrue( claimSummaryPageObj.claimDetail1( iRow + 1 ).getText().equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                            break;
                        case "claimdetail2":
                            System.out.println( "Claim Details2" + claimSummaryPageObj.claimDetail2( iRow + 1 ).getText() );
                            Assert.assertTrue( claimSummaryPageObj.claimDetail2( iRow + 1 ).getText().equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                            break;
                        case "claimdescription":
                            System.out.println( "Claim Description" + claimSummaryPageObj.claimDescription( iRow + 1 ).getText() );
                            Assert.assertTrue( claimSummaryPageObj.claimDescription( iRow + 1 ).getText().equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                            break;
                        case "claimamount":
                            System.out.println( "xpath--------------" + claimSummaryPageObj.claimAmount( iRow + 1 ) );
                            System.out.println( "Claim Amount" + claimSummaryPageObj.claimAmount( iRow + 1 ).getText() );
                            Assert.assertTrue( claimSummaryPageObj.claimAmount( iRow + 1 ).getText().equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                            break;
                        case "currencycode":
                            System.out.println( "Currency Code" + claimSummaryPageObj.currencyCode( iRow + 1 ).getText() );
                            Assert.assertTrue( claimSummaryPageObj.currencyCode( iRow + 1 ).getText().equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                            break;
                        case "gbp":
                            System.out.println( "GBP" + claimSummaryPageObj.gbp( iRow + 1 ).getText() );
                            Assert.assertTrue( claimSummaryPageObj.gbp( iRow + 1 ).getText().equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                            break;
                        case "excess":
                            System.out.println( "xpath--------------" + claimSummaryPageObj.excess( iRow + 1 ) );
                            System.out.println( "Claim Excess" + claimSummaryPageObj.excess( iRow + 1 ).getText() );
                            claimExcess = claimSummaryPageObj.excess( iRow + 1 ).getText();
//                            int claimExcessAmt = Integer.parseInt(claimExcess);
//                            if(claimExcess.equals(claimExcessAmt)) {
                            if (claimExcess.equalsIgnoreCase( "0.00" )) {
                                Assert.assertTrue( claimSummaryPageObj.excess( iRow + 1 ).getText().equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                            } else {
//                                Assert.assertTrue(claimSummaryPageObj.excess(iRow+1).getText().equalsIgnoreCase("-" + excessAmount_policy));
                                Assert.assertTrue( claimSummaryPageObj.excess( iRow + 1 ).getText().equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                            }
                            break;
                        case "limit":
                            System.out.println( "xpath--------------" + claimSummaryPageObj.limit( iRow + 1 ) );
                            System.out.println( "Claim Excess" + claimSummaryPageObj.limit( iRow + 1 ).getText() );
                            claimExcess = claimSummaryPageObj.limit( iRow + 1 ).getText();
//                            int claimExcessAmt = Integer.parseInt(claimExcess);
//                            if(claimExcess.equals(claimExcessAmt)) {
                            if (claimExcess.equalsIgnoreCase( "0.00" )) {
                                Assert.assertTrue( claimSummaryPageObj.limit( iRow + 1 ).getText().equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                            } else {
//                                Assert.assertTrue(claimSummaryPageObj.limit(iRow+1).getText().equalsIgnoreCase("-" + excessAmount_policy));
                                Assert.assertTrue( claimSummaryPageObj.limit( iRow + 1 ).getText().equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                            }
                            break;
                        case "total":
                            System.out.println( "Claim Total" + claimSummaryPageObj.total( iRow + 1 ).getText() );
                            Assert.assertTrue( claimSummaryPageObj.total( iRow + 1 ).getText().equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                            break;
                    }
                }
                iRow++;
                System.out.println( "Current Row:" + iRow );
            }
        }
    }

    public void financialTableContentSplitupToValidateWithUI(String tabToView, String finanacialTableContentFromPropertyFile) {
        List<String> valuesInEachCell;
        List<String> splitingToGetRowData;
        List<List<String>> financialTableValuesToCompare = new ArrayList<>();
        String[] splitingWithAt = finanacialTableContentFromPropertyFile.split( "@@" );
        splitingToGetRowData = Arrays.asList( splitingWithAt );
        System.out.println( "------" + splitingToGetRowData.size() );
        for (int i = 0; i < splitingToGetRowData.size(); i++) {
            System.out.println( "my----------" + splitingToGetRowData.get( i ) );
            valuesInEachCell = Arrays.asList( splitingToGetRowData.get( i ).split( "#" ) );
            financialTableValuesToCompare.add( valuesInEachCell );
        }
        this.navigateToFinancial();
        this.validateClaimAmendmentsFootPrint( financialTableValuesToCompare );
    }

    public void saveHandlerName() throws Throwable {
        claimHandlerName = claimSummObj.saveClaimHandlerName().getText();
        System.out.println( "Claim Handler Name from Claim Summary Page*****" + claimHandlerName );
        if (claimHandlerName.equalsIgnoreCase( "Not Assigned" )) {
            allocationOfClaimToClaimHandlerManually( claimID, claimHandler );
        }
    }

    public void ValidateHandlerName() {
        claimHandlerNameReassigned = claimSummObj.saveClaimHandlerName().getText();
        if (competencyOperationsObj.checkUserStatus.equalsIgnoreCase( "True" )) {
            Assert.assertTrue( claimHandlerName.equalsIgnoreCase( claimHandlerNameReassigned ) );
            System.out.println( "Both the claim handlers are same after assertion as the claim handler is active*****" );
        } else {
            System.out.println( "Previous claim handler is not active and assigned to different handler*****" );
        }

    }

    public String retrieveClaimHandlerName() {
        claimHandlerNameReassigned = claimSummObj.saveClaimHandlerName().getText();
        System.out.println( "Retreiving claim handler name*****" + claimHandlerNameReassigned );
        return claimHandlerNameReassigned;
    }

    public void validateToolTipOfDashBoard(String deadLine, String claimID) {
        claimSummaryPageObj.hoveringOverClaimIdInDashboard().click();
        if (claimID.equalsIgnoreCase( "claimId" )) {
            if (!commandsObj.elementDisplayedWithLessTime( By.xpath( claimSummaryPageObj.validateDeadlineInDashBoard( this.claimID, deadLine ) ) )) {
                Assert.assertTrue( true );
                System.out.println( "Deadline not displayed after assertion" );
            }
        } else if (claimID.equalsIgnoreCase( "TMAclaimId" )) {
            if (!commandsObj.elementDisplayedWithLessTime( By.xpath( claimSummaryPageObj.validateDeadlineInDashBoard( this.TMAClaimId, deadLine ) ) )) {
                Assert.assertTrue( true );
                System.out.println( "Deadline not displayed after assertion" );
            }
        }
    }

    public void retrieveClaimId() {
        claimID = claimSummObj.retrieveClaimID().getText();
        System.out.println( "Retreiving claim Id*****" + claimID );
    }

    public void allocationOfTMAClaimToClaimHandlerManually(String claimHandler) {
        nextEventPageObj.waitForMoreTime();
        leftNavPanePageObj.claimCompetencyTab().click();
        leftNavPanePageObj.manualClaimHandlerAlloc().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.claimIDHeader_UnallocatedClaims().clear();
        claimCompetencyPageObj.claimIDHeader_UnallocatedClaims().sendKeys( this.TMAClaimId );
        claimCompetencyPageObj.claimIDHeader_UnallocatedClaims_Filter().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.equalToFilter().click();
        try {
            Thread.sleep( 20000L );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        claimCompetencyPageObj.allocateClaim( this.TMAClaimId ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        List<String> userDet = userObj.getUserDetails( claimHandler );
        String username = userDet.get( 0 );
        claimCompetencyPageObj.claimHandlerUsername().clear();
        claimCompetencyPageObj.claimHandlerUsername().sendKeys( username );
        claimCompetencyPageObj.claimHandlerUsernameFilter().click();
        claimCompetencyPageObj.containsTab().click();
        claimCompetencyPageObj.assignClaimToClaimHandler( username ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue( claimCompetencyPageObj.validateAllocation().isDisplayed() );
    }

    public void validateTMAClaimListedUnderDashBoard() {
        System.out.println( "claim id in validateClaimListedUnderDashBoard******" + this.TMAClaimId );
        if (!commandsObj.elementDisplayedWithLessTime( net.serenitybdd.core.annotations.findby.By.xpath( claimSummaryPageObj.claimListedUnderDashBoard( this.TMAClaimId ) ) )) {
            System.out.println( "into if loop" );
            System.out.println( "claim id is not listed under dashboard after assertion" );
            navigatingToNextPageOfDashboard();
        } else {
            System.out.println( "into else loop" );
            Assert.assertTrue( commandsObj.elementDisplayedWithLessTime( net.serenitybdd.core.annotations.findby.By.xpath( claimSummaryPageObj.claimListedUnderDashBoard( this.TMAClaimId ) ) ) );
            System.out.println( "claim id is listed under dashboard after assertion" );
        }
    }

    public void navigatingToNextPageOfDashboard() {
        claimSummaryPageObj.navigateToNextPage().click();
        System.out.println( "Navigating to next page" );
        validateTMAClaimListedUnderDashBoard();
    }

    public void validateSLAColoring(String color, String claimId) {
        if (color.equalsIgnoreCase( "Green" ) && claimId.equalsIgnoreCase( "TMAClaimId" )) {
            System.out.println( "claim id in validateSLAColor ******" + this.TMAClaimId );
            Assert.assertTrue( claimSummaryPageObj.slaColor( this.TMAClaimId ).getAttribute( "alt" ).equalsIgnoreCase( "InsideSla" ) );
            System.out.println( "Assertion true after checking Green color" );
        } else if (color.equalsIgnoreCase( "Red" ) && claimId.equalsIgnoreCase( "TMAClaimId" )) {
            Assert.assertTrue( claimSummaryPageObj.slaColor( this.TMAClaimId ).getAttribute( "alt" ).equalsIgnoreCase( "OutsideSla" ) );
            System.out.println( "Assertion true after checking Red color" );
        }
        if (color.equalsIgnoreCase( "Green" ) && claimId.equalsIgnoreCase( "ClaimId" )) {
            System.out.println( "claim id in validateSLAColor ******" + this.claimID );
            Assert.assertTrue( claimSummaryPageObj.slaColor( this.claimID ).getAttribute( "alt" ).equalsIgnoreCase( "InsideSla" ) );
            System.out.println( "Assertion true after checking Green color" );
        } else if (color.equalsIgnoreCase( "Red" ) && claimId.equalsIgnoreCase( "ClaimId" )) {
            Assert.assertTrue( claimSummaryPageObj.slaColor( this.claimID ).getAttribute( "alt" ).equalsIgnoreCase( "OutsideSla" ) );
            System.out.println( "Assertion true after checking Red color" );
        }
    }

    public void captureTMAClaimDetails(List<List<String>> parameters) {
        for (int row = 0; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get( 0 ).size(); column++) {
                this.captureDetails( parameters.get( 0 ).get( column ) );
            }
        }
    }


}