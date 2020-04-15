package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.common.DateOperations;
import co.uk.directlinegroup.tt.utils.common.StringOperations;
import co.uk.directlinegroup.tt.utils.common.WebTable;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SummaryView {

    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private AccountInformationPage accountInformationPageObj = new AccountInformationPage();
    private PolicySummaryPage policySummaryPageObj = new PolicySummaryPage();
    private PolicyDataFieldsPage polDataFieldsPgObj = new PolicyDataFieldsPage();
    private QuoteDetailsPage quoteDetailsPageObj = new QuoteDetailsPage();
    private FullEventHistoryPage fullEventHistoryPageObj = new FullEventHistoryPage();
    private ClaimsOperations claimOpeObj = new ClaimsOperations();
    private WebTable webTableObj = new WebTable();
    private DateOperations dateOperationsObj = new DateOperations();
    private StringOperations stringOperationsObj = new StringOperations();
    private AccountInformationPage accountInformationObj = new AccountInformationPage();
    private co.uk.directlinegroup.tt.utils.common.Select selectObj = new co.uk.directlinegroup.tt.utils.common.Select();
    private Commands commandsObj = new Commands();
    private PolicyDataFieldsPage policyDataFieldsPage=new PolicyDataFieldsPage();

    public void verifyClaimRecordInSummary(List<List<String>> record) {
        SoftAssertions softAssertions = new SoftAssertions();
        List<WebElement> tr_collection = claimSummaryPageObj.claimSummaryTable().findElements(By.tagName("tr"));
        if (tr_collection.size() >= record.size()) {
            int iRecordIndex = 1;
            for (int iRow = 1; iRow < tr_collection.size(); iRow++) {
                List<WebElement> td_collection = tr_collection.get(iRow).findElements(By.tagName("td"));
                if (td_collection.get(1).getText().equalsIgnoreCase(record.get(iRecordIndex).get(0))) {
                    softAssertions.assertThat(td_collection.get(1).getText()).describedAs("Validating Claim record in Summary").isEqualToIgnoringCase(record.get(iRecordIndex).get(0));
                    softAssertions.assertThat(td_collection.get(2).getText()).describedAs("Validating Claim record in Summary").isEqualToIgnoringCase(record.get(iRecordIndex).get(1));
                    softAssertions.assertThat(td_collection.get(3).getText()).describedAs("Validating Claim record in Summary").isEqualToIgnoringCase(record.get(iRecordIndex).get(2));
                    softAssertions.assertThat(td_collection.get(4).getText()).describedAs("Validating Claim record in Summary").isEqualToIgnoringCase(record.get(iRecordIndex).get(3));
                    softAssertions.assertThat(td_collection.get(5).getText()).describedAs("Validating Claim record in Summary").isEqualToIgnoringCase(record.get(iRecordIndex).get(4));
                    softAssertions.assertThat(td_collection.get(6).getText()).describedAs("Validating Claim record in Summary").isEqualToIgnoringCase(record.get(iRecordIndex).get(5));
                    softAssertions.assertThat(td_collection.get(7).getText()).describedAs("Validating Claim record in Summary").isEqualToIgnoringCase(record.get(iRecordIndex).get(6));
                    softAssertions.assertThat(td_collection.get(8).getText()).describedAs("Validating Claim record in Summary").isEqualToIgnoringCase(record.get(iRecordIndex).get(7));
                    softAssertions.assertThat(td_collection.get(9).getText()).describedAs("Validating Claim record in Summary").isEqualToIgnoringCase(record.get(iRecordIndex).get(8));
                    softAssertions.assertThat(td_collection.get(10).getText()).describedAs("Validating Claim record in Summary").isEqualToIgnoringCase(record.get(iRecordIndex).get(9));
                }
            }
        }
        softAssertions.assertAll();
    }

    public List<String> captureThreeRecentClaimsDataFromClaimSummary() {
        List<String> claimsData = new ArrayList<String>();
        Assert.assertTrue(claimSummaryPageObj.claimSummaryTable().isDisplayed());
        int iRowsInClaimSummary = claimSummaryPageObj.claimSummaryTable().findElements(By.tagName("tr")).size();
        List<WebElement> trCollection = claimSummaryPageObj.claimSummaryTable().findElements(By.tagName("tr"));
        for (int iRow = 1; iRow < iRowsInClaimSummary; iRow++) {
            List<WebElement> tdCollection = trCollection.get(iRow).findElements(By.tagName("td"));
            String data = "";
            data = tdCollection.get(2).getText() + "#" + tdCollection.get(6).getText() + "#" + tdCollection.get(10).getText() + "#" + tdCollection.get(7).getText();
            claimsData.add(iRow - 1, data);
            if (iRow == 3) {
                break;//exit from loop if 3 rows of data are collected
            }
        }
        return claimsData;
    }

    public void validateClaimsHistorySectionDetails(List<String> claimsData) {
        System.out.println(" ---- claims data ----- " + claimsData.size());
        for (int i = 0; i < claimsData.size(); i++) {
            System.out.println(i + " claim data -- " + claimsData.get(i));
        }
        claimOpeObj.navigateToPolicyViewFromClaimView();
        claimSummaryPageObj.switchToWindowByIndex(1);
        //get the total number of rows in Claims History table
        List<WebElement> trCollection = accountInformationPageObj.claimsHistoryTable().findElements(By.tagName("tr"));
        int iNoOfClaims = trCollection.size() - 1;
        //If there are no claims, then nothing should be displayed in Claims History section
        if (claimsData.size() != 0) {
            //check if no of rows of claims displayed is equal to no of rows of claims data collected(max should be 3)
            if (iNoOfClaims == claimsData.size()) {
                System.out.println("inside iNoOfClaims==ClaimsDat.size loop.trCollection.size()==" + trCollection.size());
                for (int iRow = 1; iRow < trCollection.size(); iRow++) {
                    System.out.println("Row ID === " + iRow);
                    List<WebElement> tdCollection = trCollection.get(iRow).findElements(By.tagName("td"));
                    System.out.println("tdCollection.size()==" + tdCollection.size());
                    if (tdCollection.size() > 3) {
                        // claim type and date are not getting from tdcollection. need to fix this.
                        System.out.println("claimsData.get(iRow-1).split(\"#\")[0]==" + claimsData.get(iRow - 1).split("#")[0] + "==tdCollection.get(0).getText()==" + tdCollection.get(0).getText());
                        Assert.assertTrue(tdCollection.get(0).getText().equalsIgnoreCase(claimsData.get(iRow - 1).split("#")[0]));
                        System.out.println("claimsData.get(iRow-1).split(\"#\")[1]==" + claimsData.get(iRow - 1).split("#")[1] + "==tdCollection.get(1).getText()==" + tdCollection.get(1).getText());
                        Assert.assertTrue(tdCollection.get(1).getText().equalsIgnoreCase(claimsData.get(iRow - 1).split("#")[1]));
                        System.out.println("claimsData.get(iRow-1).split(\"#\")[2]==" + claimsData.get(iRow - 1).split("#")[2] + "==tdCollection.get(2).getText()==" + tdCollection.get(2).getText());
                        Assert.assertTrue(tdCollection.get(2).getText().equalsIgnoreCase(claimsData.get(iRow - 1).split("#")[2]));
                        System.out.println("claimsData.get(iRow-1).split(\"#\")[3]==" + claimsData.get(iRow - 1).split("#")[3] + "==tdCollection.get(3).getText()==" + tdCollection.get(4).getText());
                        Assert.assertTrue(tdCollection.get(4).getText().equalsIgnoreCase(claimsData.get(iRow - 1).split("#")[3]));
                    } else {
                        Assert.assertTrue("Expected >=4", false);
                    }
                }
            }
        } else {
            Assert.assertTrue(iNoOfClaims == claimsData.size());
        }
    }

    public void validateMoreLinkIsDisplayed(List<String> claimsData) {
        int iRowsInClaimSummary = claimSummaryPageObj.claimSummaryTable().findElements(By.tagName("tr")).size();
        claimOpeObj.navigateToPolicyViewFromClaimView();
        if (iRowsInClaimSummary > 3) {
            //if there are more than 3 claims in the policy, claims history section in policy summary
            //should display 3 claims with 'More' link
            Assert.assertTrue(accountInformationPageObj.claimsHistoryTable().findElements(By.tagName("tr")).size() == 4);
            Assert.assertTrue(accountInformationPageObj.moreLink().isDisplayed());
            accountInformationPageObj.moreLink().click();
            Assert.assertTrue(claimSummaryPageObj.claimSummaryTable().isDisplayed());
            claimOpeObj.navigateToPolicyViewFromClaimView();
        } else {
            //'More' link should not be displayed
            Assert.assertFalse(accountInformationPageObj.claimsHistoryTable().isDisplayed());
        }
    }

    public void verifyIfIndividualClaimCanBeClicked() {
        List<WebElement> trCollection = accountInformationPageObj.claimsHistoryTable().findElements(By.tagName("tr"));
        for (int iRow = 1; iRow < trCollection.size(); iRow++) {
            int iRowIndexForLink = iRow + 1;
            String xPath = accountInformationPageObj.claimsHistoryTable().getAttribute("id");
            xPath = ".//*[@id='" + xPath + "']/tbody/tr[" + iRowIndexForLink + "]/td[1]/a";
            accountInformationPageObj.findElement(By.xpath(xPath)).click();
            Assert.assertTrue(claimSummaryPageObj.claimSummaryTable().isDisplayed());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            claimOpeObj.navigateToPolicyViewFromClaimView();
        }
    }

    public void createnote(String conversationType, String noteType, String descriptionText) {
        nextEventPageObj.switchToWindowByIndex(1);
        nextEventPageObj.addANote().click();
        nextEventPageObj.go().click();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        new Select(nextEventPageObj.conversationType()).selectByVisibleText(conversationType);
        new Select(nextEventPageObj.noteType()).selectByVisibleText(noteType);
        nextEventPageObj.descriptionNote().sendKeys(descriptionText);
        nextEventPageObj.finishnote().click();
    }

    public void validateNoteCategories(List<String> lstNoteCaegories) {
        nextEventPageObj.switchToWindowByIndex(1);
        nextEventPageObj.addANote().click();
        nextEventPageObj.go().click();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        Assert.assertTrue(selectObj.validateValuesInDropDown(nextEventPageObj.conversationType(), lstNoteCaegories));
    }

    public void editnote() {
        nextEventPageObj.switchToWindowByIndex(1);
        if (claimSummaryPageObj.elementDisplayed(By.id(claimSummaryPageObj.firstClaimSelectLinkXPath()))) {
            claimSummaryPageObj.firstClaimSelectLink().click();
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.firstRowinEvent().click();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frameEditEvent());
    }

    public void editclaim(){
        claimSummaryPageObj.firstClaimSelectLink().click();
    }

    public void editNoteDescription(String strNotes) {
        nextEventPageObj.noteDescEdit().clear();
        nextEventPageObj.noteDescEdit().sendKeys(strNotes);
        nextEventPageObj.noteEditSave().click();
        nextEventPageObj.noteCloseButton().click();
    }

    public void editNoteCategory(String strNoteCategory) {
        nextEventPageObj.noteDescEdit().clear();
        new Select(nextEventPageObj.noteCategoryEdit()).selectByVisibleText(strNoteCategory);
        nextEventPageObj.noteEditSave().click();
        nextEventPageObj.noteCloseButton().click();
    }

    public void validateEditNoteDesc() {
        Assert.assertTrue(nextEventPageObj.noteDescEdit().getAttribute("disabled"), true);
    }

    public void validateEditNoteType(String strInput) {
        String whenCreated;
        boolean bFound = false;
        nextEventPageObj.noteMoreInfo().click();
        whenCreated = nextEventPageObj.noteWhenCreated().getText();
        whenCreated = whenCreated.substring(0, whenCreated.length() - 3);
        nextEventPageObj.waitForMoreTime();
        new Select(nextEventPageObj.noteTypeEdit()).selectByVisibleText(strInput);
        nextEventPageObj.noteEditSave().click();
        nextEventPageObj.noteCloseButton().click();
        nextEventPageObj.switchToWindowByIndex(1);
        List<WebElement> tr_collection = nextEventPageObj.eventRowTable().findElements(By.tagName("tr"));
        for (int iRow = 1; iRow < tr_collection.size(); iRow++) {
            List<WebElement> td_collectionCurrentRow = tr_collection.get(iRow).findElements(By.tagName("td"));
            String strDateInCurrentRow = td_collectionCurrentRow.get(1).getText();
            if (whenCreated.trim().equals(strDateInCurrentRow.trim())) {
                String strXpath = nextEventPageObj.eventTableXpath() + "/tbody/tr[" + iRow + "]/td[1]/a";
                nextEventPageObj.findElement(By.xpath(strXpath)).click();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frameEditEvent());
                nextEventPageObj.noteMoreInfo().click();
                System.out.println("----------------------"+new Select(nextEventPageObj.noteTypeEdit()).getFirstSelectedOption().getText());
                Assert.assertTrue(new Select(nextEventPageObj.noteTypeEdit()).getFirstSelectedOption().getText().equalsIgnoreCase(strInput));
                bFound = true;
                break;
            }
        }
        if (!bFound) {
            System.out.println("Did not find a matching record");
            Assert.assertTrue(nextEventPageObj.noteTypeEdit().getText().equalsIgnoreCase(strInput));
        }
        nextEventPageObj.noteCloseButton().click();
        nextEventPageObj.switchToWindowByIndex(1);
    }

    public void createSensitiveRecord(String strInput) {
        nextEventPageObj.addOutOfProcessEvent().click();
        nextEventPageObj.go().click();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        new Select(nextEventPageObj.eventTypeSensitive()).selectByVisibleText(strInput);
        nextEventPageObj.nextButtonSensitive().click();
    }

    public List<Integer> getCoverageDisplayIndex(List<String> lstCoverages) {
        List<Integer> lstCovIndex = new ArrayList<Integer>();
        List<WebElement> tr_collection = policySummaryPageObj.policySummaryTable().findElements(By.tagName("tr"));
        int iBasePolicyIndex = 0;
        int iAnnualUpgradeIndex = 0;
        int iTripUpgradeIndex = 0;
        String strBaseCov = lstCoverages.get(0);
        String strAnnualUpgrade = lstCoverages.get(1);
        String strTripUpgrade = lstCoverages.get(2);
        for (int iRow = 0; iRow < tr_collection.size(); iRow++) {
            //check the order of display of base policy, annual upgrade, trip upgrade
            List<WebElement> th_collection = tr_collection.get(iRow).findElements(By.tagName("th"));
            if (th_collection.size() > 0) {
                if (th_collection.get(0).getText().equalsIgnoreCase(strBaseCov)) {
                    iBasePolicyIndex = iRow;
                } else if (th_collection.get(0).getText().equalsIgnoreCase(strAnnualUpgrade)) {
                    iAnnualUpgradeIndex = iRow;
                } else if (th_collection.get(0).getText().equalsIgnoreCase(strTripUpgrade)) {
                    iTripUpgradeIndex = iRow;
                }
            }
            if (iBasePolicyIndex > 0 && iAnnualUpgradeIndex > 0 && iTripUpgradeIndex > 0) {
                lstCovIndex.add(iBasePolicyIndex);
                lstCovIndex.add(iAnnualUpgradeIndex);
                lstCovIndex.add(iTripUpgradeIndex);
                break;
            }
        }
        return lstCovIndex;
    }

    public int getCoverageDisplayIndex(String strCoverage) {
        List<WebElement> tr_collection = policySummaryPageObj.policySummaryTable().findElements(By.tagName("tr"));
        int iCovIndex = 0;
        for (int iRow = 0; iRow < tr_collection.size(); iRow++) {
            List<WebElement> th_collection = tr_collection.get(iRow).findElements(By.tagName("th"));
            if (th_collection.size() > 0) {
                if (th_collection.get(0).getText().equalsIgnoreCase(strCoverage)) {
                    iCovIndex = iRow;
                }
            }
        }
        return iCovIndex;
    }

    public void verifyOrderOfDisplayOfCoverages(List<String> lstCoverages) {
        List<Integer> lstCovIndex = this.getCoverageDisplayIndex(lstCoverages);
        int iBasePolicyIndex = lstCovIndex.get(0);
        int iAnnualUpgradeIndex = lstCovIndex.get(1);
        int iTripUpgradeIndex = lstCovIndex.get(2);
        Assert.assertTrue(iBasePolicyIndex < iAnnualUpgradeIndex);
        Assert.assertTrue(iAnnualUpgradeIndex < iTripUpgradeIndex);
    }

    public void verifyCoverageDisplayDateOrder(String strCoverage) {
        List<String> lstFromDate = new ArrayList<String>();
        List<String> lstToDate = new ArrayList<String>();
        List<WebElement> tr_collection = policySummaryPageObj.policySummaryTable().findElements(By.tagName("tr"));
        int iAnnualUpgradeIndex = this.getCoverageDisplayIndex(strCoverage);
        int iFromDateCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.policySummaryTable(), "Cover From");
        int iToDateCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.policySummaryTable(), "Cover To");
        for (int iRow = iAnnualUpgradeIndex + 1; iRow < tr_collection.size()-1; iRow++) {
            if (tr_collection.get(iRow).getAttribute("id").endsWith("footerRow")) {
                break;
            }
            if (tr_collection.get(iRow).findElements(By.tagName("th")).size() > 0) {
                break;
            }
            List<WebElement> td_Collection = tr_collection.get(iRow).findElements(By.tagName("td"));
            String strFromDate = td_Collection.get(iFromDateCol).getText();
            String strToDate = td_Collection.get(iToDateCol).getText();
            int iNoOfMonths = dateOperationsObj.getMonthsBetWeenTwoDates(strFromDate, strToDate, "dd/MM/yyyy");
            if (strCoverage.equalsIgnoreCase("annual upgrade")) {
                Assert.assertTrue(iNoOfMonths >= 12);
            } else if (strCoverage.equalsIgnoreCase("single trip upgrade")) {
                Assert.assertTrue(iNoOfMonths < 12);
            }
            Assert.assertTrue(dateOperationsObj.isThisDateValid(strFromDate, "dd/MM/yyyy"));
            Assert.assertTrue(dateOperationsObj.isThisDateValid(strToDate, "dd/MM/yyyy"));
            lstFromDate.add(td_Collection.get(iFromDateCol).getText());
            lstToDate.add(td_Collection.get(iToDateCol).getText());
        }
        Assert.assertTrue(dateOperationsObj.compareDateSortOrder("desc", "dd/MM/yyyy", lstFromDate));
        Assert.assertTrue(dateOperationsObj.compareDateSortOrder("desc", "dd/MM/yyyy", lstToDate));
    }

    public void verifyIfCovDisplaysStartDateAndEndDate(String strCoverage, String strStartDtString, String strEndDtString) {
        List<WebElement> tr_collection = policySummaryPageObj.policySummaryTable().findElements(By.tagName("tr"));
        int iCovIndex = this.getCoverageDisplayIndex(strCoverage);
        int iFromDateCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.policySummaryTable(), "Cover From");
        int iToDateCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.policySummaryTable(), "Cover To");
        for (int iRow = iCovIndex + 1; iRow < tr_collection.size()-1; iRow++) {
            if (tr_collection.get(iRow).getAttribute("id").endsWith("footerRow")) {
                break;
            }
            if (tr_collection.get(iRow).findElements(By.tagName("th")).size() > 0) {
                break;
            }
            List<WebElement> td_Collection = tr_collection.get(iRow).findElements(By.tagName("td"));
            String strFromDate = td_Collection.get(iFromDateCol).getText();
            String strToDate = td_Collection.get(iToDateCol).getText();
            if (strStartDtString.equalsIgnoreCase("with start date")) {
                System.out.println(!strFromDate.isEmpty());
                Assert.assertTrue(!strFromDate.isEmpty());
                Assert.assertTrue(dateOperationsObj.isThisDateValid(strFromDate, "dd/MM/yyyy"));
            }
            if (strEndDtString.equalsIgnoreCase("with end date")) {
                Assert.assertTrue(!strToDate.isEmpty());
                Assert.assertTrue(dateOperationsObj.isThisDateValid(strToDate, "dd/MM/yyyy"));
            }
            if (strEndDtString.equalsIgnoreCase("no end date")) {
                Assert.assertTrue(strToDate.isEmpty());
                Assert.assertFalse(dateOperationsObj.isThisDateValid(strToDate, "dd/MM/yyyy"));
            }
        }
    }

    public void verifyInForceVsExpiredCov(String strCoverage, String strCovType, String strTermStatusIndicator) {
        List<WebElement> tr_collection = policySummaryPageObj.policySummaryTable().findElements(By.tagName("tr"));
        int iCovIndex = this.getCoverageDisplayIndex(strCoverage);
        int iTermCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.policySummaryTable(), "Term");
        int iStatusCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.policySummaryTable(), "Status");
        int iFromDateCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.policySummaryTable(), "Cover From");
        int iToDateCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.policySummaryTable(), "Cover To");
        for (int iRow = iCovIndex + 1; iRow < tr_collection.size()-1; iRow++) {
            if (tr_collection.get(iRow).getAttribute("id").endsWith("footerRow")) {
                break;
            }
            if (tr_collection.get(iRow).findElements(By.tagName("th")).size() > 0) {
                break;
            }
            List<WebElement> td_Collection = tr_collection.get(iRow).findElements(By.tagName("td"));
            String strFromDate = td_Collection.get(iFromDateCol).getText();
            String strToDate = td_Collection.get(iToDateCol).getText();
            String strTerm = td_Collection.get(iTermCol).getText();
            String strStatus = td_Collection.get(iStatusCol).getText();
            if (strCoverage.equalsIgnoreCase("Base Policy")) {
                Assert.assertTrue(strTerm.isEmpty());
                Assert.assertTrue(strStatus.isEmpty());
            } else if (strCoverage.equalsIgnoreCase("Annual Upgrade") || strCoverage.equalsIgnoreCase("Single Trip Upgrade")) {
                Assert.assertTrue(!strTerm.isEmpty());
                Assert.assertTrue(!strStatus.isEmpty());
                if (strCoverage.equalsIgnoreCase("Annual Upgrade")) {
                    int iNoOfMonths = dateOperationsObj.getMonthsBetWeenTwoDates(strFromDate, strToDate, "dd/MM/yyyy");
                    Assert.assertTrue(Integer.parseInt(strTerm) == (iNoOfMonths / 12));
                } else {
                    Assert.assertTrue(Integer.parseInt(strTerm) == 1);
                }
                Date dtCurrentDate = new Date();
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                if (dateOperationsObj.compareTwoDates(df.format(dtCurrentDate), strToDate, "dd/MM/yyyy", ">")) {
                    Assert.assertTrue(strStatus.equalsIgnoreCase("expired") | strStatus.equalsIgnoreCase("Lapsed"));
                } else {
                    Assert.assertTrue(strStatus.equalsIgnoreCase("live") | strStatus.equalsIgnoreCase("Lapsed"));
                }
            }
        }
    }

    public void verifyIfEachCovCanBeClickedAndViewedInPolSumm() {
        List<WebElement> tr_collection = policySummaryPageObj.policySummaryTable().findElements(By.tagName("tr"));
        int iRows = tr_collection.size();
        int iPolicyIDCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.policySummaryTable(), "Policy ID");
        int iRowIndex = 0;//This is used to keep a tab on which row the validation was done last and continue from there
        for (int iRow = iRowIndex; iRow < iRows; iRow++) {
            tr_collection = policySummaryPageObj.policySummaryTable().findElements(By.tagName("tr"));
            List<WebElement> td_Collection = tr_collection.get(iRow).findElements(By.tagName("td"));
            if (td_Collection.size() > 0) {
                String strPolicyID = td_Collection.get(iPolicyIDCol).getText();
                System.out.println("Policy Id " + strPolicyID);
                if (!strPolicyID.isEmpty() && strPolicyID.length() == 8) {
                    policySummaryPageObj.btnClick(td_Collection.get(0).findElement(By.tagName("a")));
                    Assert.assertTrue(polDataFieldsPgObj.policyIDLabelValue().getText().equalsIgnoreCase(strPolicyID));
                    policySummaryPageObj.btnClick(claimSummaryPageObj.close());
                }
                iRowIndex++;
            }
        }
    }

    public void verifyIfPremiumDisplayeForCoverages(String strPremDisplayCondition, String strCoverage) {
        List<WebElement> tr_collection = policySummaryPageObj.policySummaryTable().findElements(By.tagName("tr"));
        int iCovIndex = this.getCoverageDisplayIndex(strCoverage);
        int iPremiumCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.policySummaryTable(), "Premium");
        for (int iRow = iCovIndex + 1; iRow < tr_collection.size(); iRow++) {
            if (tr_collection.get(iRow).getAttribute("id").endsWith("gridRow")) {
                break;
            }
            if (tr_collection.get(iRow).findElements(By.tagName("th")).size() > 0) {
                break;
            }
            List<WebElement> td_Collection = tr_collection.get(iRow).findElements(By.tagName("td"));
            String strPremium = td_Collection.get(iPremiumCol).getText();
            if (strPremDisplayCondition.equalsIgnoreCase("should not be displayed")) {
                Assert.assertTrue(strPremium.isEmpty());
            } else if (strPremDisplayCondition.equalsIgnoreCase("should be displayed")) {
                Assert.assertTrue(!strPremium.isEmpty());
                //Assert.assertTrue(stringOperationsObj.checkStringIsValidCurrency(strPremium));
            }
        }
    }

    public void verifyIfTotalPremiumIsDisplayed(List<String> lstCoverages) {
        double dExpTotalPremium = 0;
        double dActTotalPremium = 0;
        double dPremium = 0;
        int iPremiumCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.policySummaryTable(), "Premium");
        for (int i = 0; i < lstCoverages.size(); i++) {
            int iCovIndex = this.getCoverageDisplayIndex(lstCoverages.get(i));
            List<WebElement> tr_collection = policySummaryPageObj.policySummaryTable().findElements(By.tagName("tr"));
            for (int iRow = iCovIndex + 1; iRow < tr_collection.size(); iRow++) {
                if (tr_collection.get(iRow).getAttribute("id").endsWith("footerRow")) {
                    break;
                }
                if (tr_collection.get(iRow).findElements(By.tagName("th")).size() > 0) {
                    break;
                }
                List<WebElement> td_Collection = tr_collection.get(iRow).findElements(By.tagName("td"));
                if (td_Collection.get(1).getText().equalsIgnoreCase("Total Premium")) {
                    dActTotalPremium = Double.parseDouble(td_Collection.get(2).getText());
                    System.out.println("dActTotalPremium----------------"+dActTotalPremium);
                    break;
                }
                if(!td_Collection.get(iPremiumCol).getText().equalsIgnoreCase("")) {
                    dPremium = Double.parseDouble(td_Collection.get(iPremiumCol).getText());
                    dExpTotalPremium = dExpTotalPremium + dPremium;
                }
                System.out.println("dExpTotalPremium-------------------"+dExpTotalPremium);
            }
        }
        Assert.assertTrue(dActTotalPremium == dExpTotalPremium);
    }

    public void verifyIfEachQuoteCanBeClickedAndViewedInPolSumm() {
        List<WebElement> tr_collection = policySummaryPageObj.quoteSummaryTable().findElements(By.tagName("tr"));
        int iRows = tr_collection.size();
        int iQuoteIDCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.quoteSummaryTable(), "Quote ID");
        int iRowIndex = 0;//This is used to keep a tab on which row the validation was done last and continue from there
        Assert.assertTrue(iRows >= 2);//check if there is atleast one quote(including header row and hence two)
        for (int iRow = iRowIndex; iRow < iRows-1; iRow++) {
            tr_collection = policySummaryPageObj.quoteSummaryTable().findElements(By.tagName("tr"));
            List<WebElement> td_Collection = tr_collection.get(iRow).findElements(By.tagName("td"));
            if (td_Collection.size() > 0) {
                String strQuoteID = td_Collection.get(iQuoteIDCol).getText();
                if (!strQuoteID.isEmpty() && strQuoteID.length() == 8) {
                    policySummaryPageObj.btnClick(td_Collection.get(0).findElement(By.tagName("a")));
                    Assert.assertTrue(quoteDetailsPageObj.quoteLabelValue().getText().equalsIgnoreCase(strQuoteID));
                    policySummaryPageObj.btnClick(claimSummaryPageObj.close());
                }
                iRowIndex++;
            }
        }
    }

    public void verifyQuoteDisplayDateOrder() {
        List<String> lstFromDate = new ArrayList<String>();
        List<String> lstToDate = new ArrayList<String>();
        List<WebElement> tr_collection = policySummaryPageObj.quoteSummaryTable().findElements(By.tagName("tr"));
        int iFromDateCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.quoteSummaryTable(), "Effective");
        int iToDateCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.quoteSummaryTable(), "Expiry");
        Assert.assertTrue(tr_collection.size() >= 2);//check if there is atleast one quote(including header row and hence two)
        for (int iRow = 1; iRow < tr_collection.size(); iRow++) {
            if (tr_collection.get(iRow).getAttribute("id").endsWith("footerRow")) {
                break;
            }
            if (tr_collection.get(iRow).findElements(By.tagName("th")).size() > 0) {
                break;
            }
            List<WebElement> td_Collection = tr_collection.get(iRow).findElements(By.tagName("td"));
            String strFromDate = td_Collection.get(iFromDateCol).getText();
            String strToDate = td_Collection.get(iToDateCol).getText();
            Assert.assertTrue(dateOperationsObj.isThisDateValid(strFromDate, "dd/MM/yyyy"));
            Assert.assertTrue(dateOperationsObj.isThisDateValid(strToDate, "dd/MM/yyyy"));
            lstFromDate.add(td_Collection.get(iFromDateCol).getText());
            lstToDate.add(td_Collection.get(iToDateCol).getText());
        }
        Assert.assertTrue(dateOperationsObj.compareDateSortOrder("desc", "dd/MM/yyyy", lstFromDate));
        Assert.assertTrue(dateOperationsObj.compareDateSortOrder("desc", "dd/MM/yyyy", lstToDate));
    }

    public void verifyOnlyThreeMostRecentQuotesAreDisplayed() {
        List<String> lstFromDate = new ArrayList<String>();
        List<String> lstToDate = new ArrayList<String>();
        List<WebElement> tr_collection = policySummaryPageObj.quoteSummaryTable().findElements(By.tagName("tr"));
        int iFromDateCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.quoteSummaryTable(), "Effective");
        int iToDateCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.quoteSummaryTable(), "Expiry");
        int iNoOfQuotes = 0;
        boolean bLatestActiveHeaderFound = false;
        boolean bPreviousVersionHeaderFound = false;
        //BN - 09/06/2017. As per the new implementation, only one active will be displayed
        // and system will show all previous vesion of the quote
        //Logic changed to reflect this
        /*
        //====old logic====
        for (int iRow = 1; iRow < tr_collection.size(); iRow++) {
            //Check if we get a footer row or a row with the next coverage. If yes, quit the for loop
            if (tr_collection.get( iRow ).getAttribute( "id" ).endsWith( "footerRow" )) {
                break;
            }
            if (tr_collection.get(iRow).findElements(By.tagName("th")).size() > 0) {
                break;
            }
            iNoOfQuotes++;
            List<WebElement> td_Collection = tr_collection.get(iRow).findElements(By.tagName("td"));
            //get the dates
            String strFromDate = td_Collection.get(iFromDateCol).getText();
            String strToDate = td_Collection.get(iToDateCol).getText();
            //Check dates are valid
            Assert.assertTrue(dateOperationsObj.isThisDateValid(strFromDate, "dd/MM/yyyy"));
            Assert.assertTrue(dateOperationsObj.isThisDateValid(strToDate, "dd/MM/yyyy"));
            lstFromDate.add(td_Collection.get(iFromDateCol).getText());
            lstToDate.add(td_Collection.get(iToDateCol).getText());
        }

        //check if there were only 3 quotes
        Assert.assertTrue(iNoOfQuotes == 3);
        //navigate to quote details screen and verify if the listed quotes are the most recent quotes
        //write code here
        //throw new PendingException();
        */

        //===new logic==
        for (int iRow = 1; iRow < tr_collection.size(); iRow++) {
            if(tr_collection.get(iRow).findElements(By.tagName("th")).size()==1){
                if(tr_collection.get(iRow).findElements(By.tagName("th")).get(0).getText().equalsIgnoreCase("Latest Active Quote")){
                    bLatestActiveHeaderFound = true;
                    continue;
                }
                if(tr_collection.get(iRow).findElements(By.tagName("th")).get(0).getText().equalsIgnoreCase("Previous Versions")){
                    bPreviousVersionHeaderFound = true;
                    continue;
                }
            }
            System.out.println("iteration: "+ iRow);
            if (bLatestActiveHeaderFound && !bPreviousVersionHeaderFound) {
                System.out.println("increasing iNoOFQuotes");
                List<WebElement> td_Collection = tr_collection.get(iRow).findElements(By.tagName("td"));
                if(td_Collection.size()==10) {
                    iNoOfQuotes++;
                    String strFromDate = td_Collection.get(iFromDateCol).getText();
                    String strToDate = td_Collection.get(iToDateCol).getText();
                    Assert.assertTrue(dateOperationsObj.isThisDateValid(strFromDate, "dd/MM/yyyy"));
                    Assert.assertTrue(dateOperationsObj.isThisDateValid(strToDate, "dd/MM/yyyy"));
                }
            }
            System.out.println("iNoOfQuotes----------------------"+iNoOfQuotes);
        }
        Assert.assertTrue((iNoOfQuotes) == 1);
    }

    public void verifyAllPartialAndCompleteQuotes() {
    }

    public void validateNotesRecordInEventHistory(String strConversationType, String strNotes, String strDate, String strWho) {
        boolean bFound = false;
        WebElement wbEle = nextEventPageObj.eventRowTable();
        int iEventIndex = webTableObj.getColumnFromWebTable(wbEle, "Event");
        int iWhenIndex = webTableObj.getColumnFromWebTable(wbEle, "When");
        int iWhoIndex = webTableObj.getColumnFromWebTable(wbEle, "Who");
        List<WebElement> lstRows = wbEle.findElements(By.tagName("tr"));
        for (int iRow = 1; iRow < lstRows.size(); iRow++) {
            List<WebElement> lstCols = lstRows.get(iRow).findElements(By.tagName("td"));
            if (lstCols.get(iEventIndex).getAttribute("title").contains("Note: " + strNotes)) {
                bFound = true;
                System.out.println("iEventIndex==" + iEventIndex);
                System.out.println("iWhenIndex==" + iWhenIndex);
                System.out.println("iWhoIndex==" + iWhoIndex);
                System.out.println(" lstCols.get( iWhenIndex ).getText()==" + lstCols.get(iWhenIndex).getText());
                System.out.println("strDate==" + strDate);
                System.out.println("lstCols.get( iWhoIndex ).getText()==" + lstCols.get(iWhoIndex).getText());
                System.out.println("strWho==" + strWho);
                Assert.assertTrue(dateOperationsObj.isThisDateValid(lstCols.get(iWhenIndex).getText(), "dd/MM/yyyy HH:mm"));
                Assert.assertTrue((lstCols.get(iWhenIndex).getText().split(" ")[0]).equalsIgnoreCase(strDate));
                Assert.assertTrue(lstCols.get(iWhoIndex).getText().equalsIgnoreCase(strWho));
                break;
            }
        }
        if (!bFound) {
            Assert.assertTrue(false);
        }
    }

    public String captureCommReceiverFromEventHistory(String strEvent) {
        fullEventHistoryPageObj.waitForMoreTime();
        String strCommReceiver = "";
        fullEventHistoryPageObj.switchToLastOpenWindow();
        fullEventHistoryPageObj.showFullEventHistory().click();
        fullEventHistoryPageObj.switchToLastOpenWindow();
        fullEventHistoryPageObj.closeWindow().click();
        fullEventHistoryPageObj.switchToLastOpenWindow();
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.showFullEventHistory().click();
        fullEventHistoryPageObj.switchToLastOpenWindow();
      //  claimOpeObj.maximizeDriver();
        int iCommentColIndex = webTableObj.getColumnFromWebTable(fullEventHistoryPageObj.eventHistoryTableHeader(), "Comments");
        int iEventColIndex = webTableObj.getColumnFromWebTable(fullEventHistoryPageObj.eventHistoryTableHeader(), "Event");
        List<String> lstNotesRowOrder = new ArrayList<String>();
        boolean bFound = false;
        List<WebElement> lstRows = fullEventHistoryPageObj.eventHistoryTable().findElements(By.tagName("tr"));
        for (int iRow = 0; iRow < lstRows.size(); iRow++) {
            List<WebElement> lstCols = lstRows.get(iRow).findElements(By.tagName("td"));
            String strEventName = lstCols.get(iEventColIndex).getText();
            if (strEventName.startsWith(strEvent)) {
                bFound = true;
                strCommReceiver = lstCols.get(iCommentColIndex).findElement(By.tagName("span")).getText();
                strCommReceiver = strCommReceiver.split(" ")[2].split("\n")[0].trim();
                break;
            }
        }
        if (!bFound) {
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
            Assert.assertTrue(false);
        }
        fullEventHistoryPageObj.closeWindow().click();
        fullEventHistoryPageObj.switchToLastOpenWindow();
        System.out.println("strCommReceiver----------------------------"+strCommReceiver);
        return strCommReceiver;
    }

    public List<String> captureClaimLeadIDCaseID(String strUrl) {
        List<String> lstLeadIDCaseID = new ArrayList<>();
        int iLeadIDStringIndex = strUrl.indexOf("lid=");
        int iCaseIDStringIndex = strUrl.indexOf("aid=");
        System.out.println("strUrl===" + strUrl);
        System.out.println("iLeadIDStringIndex===" + iLeadIDStringIndex);
        System.out.println("iCaseIDStringIndex====" + iCaseIDStringIndex);
        String strLeadID = strUrl.substring((iLeadIDStringIndex + 4), (iLeadIDStringIndex + 12));
        String strCaseID = strUrl.substring((iCaseIDStringIndex + 4), (iCaseIDStringIndex + 12));
        lstLeadIDCaseID.add(strLeadID);
        lstLeadIDCaseID.add(strCaseID);
        return lstLeadIDCaseID;
    }

    public boolean validateAndSelectClaimFromClaimSummaryTable(String strClaimID) {
        boolean bFound = false;
        List<WebElement> tr_collection = claimSummaryPageObj.claimSummaryTable().findElements(By.tagName("tr"));
        for (int iRow = 1; iRow < tr_collection.size(); iRow++) {
            List<WebElement> td_collection = tr_collection.get(iRow).findElements(By.tagName("td"));
            //check if claim ID in table(2nd column in table) matches the claim ID from input(2nd row first column)
            if (td_collection.get(1).getText().equalsIgnoreCase(strClaimID)) {
                if (iRow > 1) {
                    claimSummaryPageObj.SelectClaim(String.valueOf(iRow)).click();
                }
                bFound = true;
                break;
            }
        }
        return bFound;
    }

    public String captureReserveApprovalSupervisor() {
        String strApprovalSupervisor = "";
        try {
            fullEventHistoryPageObj.waitForMoreTime();
            int iCommentColIndex = webTableObj.getColumnFromWebTable(fullEventHistoryPageObj.eventHistoryTableHeader(), "Comments");
            int iEventColIndex = webTableObj.getColumnFromWebTable(fullEventHistoryPageObj.eventHistoryTableHeader(), "Event");
            List<String> lstNotesRowOrder = new ArrayList<String>();
            boolean bFound = false;
            List<WebElement> lstRows = fullEventHistoryPageObj.eventHistoryTable().findElements(By.tagName("tr"));
            for (int iRow = 0; iRow < lstRows.size(); iRow++) {
                List<WebElement> lstCols = lstRows.get(iRow).findElements(By.tagName("td"));
                String strEventName = lstCols.get(iEventColIndex).getText();
                if (strEventName.startsWith("EM Supervisor - Reserve Authorisation Request") || strEventName.startsWith("EM - To Supervisor: Reserve Authorisation Request")) {
                    bFound = true;
                    strApprovalSupervisor = lstCols.get(iCommentColIndex).findElement(By.tagName("span")).getText();
                    strApprovalSupervisor = strApprovalSupervisor.split(" ")[2].split("\n")[0].trim();
                    System.out.println("****************Reserve Approval Supervisor****************************");
                    System.out.println(strApprovalSupervisor);
                    break;
                }
            }
            if (!bFound) {
                Assert.assertTrue(false);
            }
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
            fullEventHistoryPageObj.waitForMoreTime();
        }catch (Exception e){
            System.out.println("Assertion failed Event not available in the table in Show full event history");
            fullEventHistoryPageObj.closeWindow().click();
            fullEventHistoryPageObj.switchToLastOpenWindow();
            fullEventHistoryPageObj.waitForMoreTime();
        }
        return strApprovalSupervisor;
    }

    public void assertElementDisplayed(String section, List<List<String>> fields) {
        SoftAssertions softAssertions = new SoftAssertions();
        accountInformationObj.switchToWindowByIndex(1);
        switch (section.toLowerCase()) {
            case "policy information":
            case "account information":
                softAssertions.assertThat(accountInformationObj.productAndClaims().isDisplayed()).describedAs("Validating if Lead Information is displayed");
                softAssertions.assertThat(accountInformationObj.productAndClaims().getText()).describedAs("Validating Title").contains(section);
                System.out.println("Brand----");
                softAssertions.assertThat(accountInformationObj.brandLabel().isDisplayed()).describedAs("Validating Brand Label is displayed");
                System.out.println(accountInformationObj.brandLabel().getText());
                softAssertions.assertThat(accountInformationObj.brandLabel().getText()).describedAs("Validating Brand Label text").isEqualToIgnoringCase(fields.get(0).get(0));
                softAssertions.assertThat(policySummaryPageObj.productName().getText()).describedAs("Validating Brand name").isEqualToIgnoringCase(fields.get(1).get(0));
                System.out.println("Brand Logo---");
                softAssertions.assertThat(accountInformationObj.brandLogo().isDisplayed()).describedAs("Validating Brand Logo is displayed");
                softAssertions.assertThat(accountInformationObj.brandLogo().getAttribute("alt")).describedAs("Validating Brand Logo is correct").isEqualToIgnoringCase(fields.get(1).get(1));
                System.out.println("Account Name---");
                softAssertions.assertThat(accountInformationObj.accountNameLabel().isDisplayed()).describedAs("Validating Account Name label is displayed");
                softAssertions.assertThat(accountInformationObj.accountNameLabel().getText()).describedAs("Validating Account Name Label text is correct").isEqualToIgnoringCase(fields.get(0).get(2));
                softAssertions.assertThat(accountInformationObj.accountName1().getText()).describedAs("Validating Account Name is correct").isEqualToIgnoringCase(fields.get(1).get(2));
                System.out.println("Account Number---");
                softAssertions.assertThat(policyDataFieldsPage.getPolicyNumberFromScreen().getText()).describedAs("Validating Account Number is correct").isEqualToIgnoringCase(fields.get(1).get(3));
                System.out.println("Policy No---");
                softAssertions.assertThat(accountInformationObj.policyNumberLabel().isDisplayed()).describedAs("Validating Policy Number Label is displayed");
                softAssertions.assertThat(accountInformationObj.policyNumberLabel().getText()).describedAs("Validating Policy Number Label is correct").isEqualToIgnoringCase(fields.get(0).get(3));
                softAssertions.assertThat(policyDataFieldsPage.getPolicyNumberFromScreen().getText()).describedAs("Validating  if Policy Number format is correct").matches("[0-9]+");
                softAssertions.assertThat(policyDataFieldsPage.getPolicyNumberFromScreen().getText().length()).describedAs("Validating Policy Number length is 8 characters").isEqualTo(8);
                softAssertions.assertThat(accountInformationObj.claimsHistoryTitle().isDisplayed()).describedAs("Validating Claims History Title is displayed");
                softAssertions.assertThat(accountInformationObj.claimsHistoryTable().isDisplayed()).describedAs("Validating Claims History Table is displayed");
                break;
            case "lead information":
            case "lead":
                System.out.println("Lead Information---");
                softAssertions.assertThat(accountInformationObj.productAndClaims().isDisplayed()).describedAs("Validating if Lead Information is displayed");
                softAssertions.assertThat(accountInformationObj.productAndClaims().getText()).describedAs("Validating Title").contains(section);
                System.out.println("Brand----");
                softAssertions.assertThat(accountInformationObj.brandLabel().isDisplayed()).describedAs("Validating Brand Label is displayed");
                System.out.println(accountInformationObj.brandLabel().getText());
                softAssertions.assertThat(accountInformationObj.brandLabel().getText()).describedAs("Validating Brand Label text").isEqualToIgnoringCase(fields.get(0).get(0));
                softAssertions.assertThat(policySummaryPageObj.productName().getText()).describedAs("Validating Brand name").isEqualToIgnoringCase(fields.get(1).get(0));
                System.out.println("Brand Logo---");
                softAssertions.assertThat(accountInformationObj.brandLogo().isDisplayed()).describedAs("Validating Brand Logo is displayed");
                softAssertions.assertThat(accountInformationObj.brandLogo().getAttribute("alt")).describedAs("Validating Brand Logo is correct").isEqualToIgnoringCase(fields.get(1).get(1));
                System.out.println("Account Name---");
                softAssertions.assertThat(accountInformationObj.accountNameLabel().isDisplayed()).describedAs("Validating Account Name label is displayed");
                softAssertions.assertThat(accountInformationObj.accountNameLabel().getText()).describedAs("Validating Account Name Label text is correct").isEqualToIgnoringCase(fields.get(0).get(2));
                softAssertions.assertThat(accountInformationObj.accountName1().getText()).describedAs("Validating Account Name is correct").isEqualToIgnoringCase(fields.get(1).get(2));
                System.out.println("Account Number---");
                softAssertions.assertThat(accountInformationObj.accountNumber().getText()).describedAs("Validating Account Number is correct").isEqualToIgnoringCase(fields.get(1).get(3));
                System.out.println("Policy No---");
                softAssertions.assertThat(accountInformationObj.policyNumberLabel().isDisplayed()).describedAs("Validating Policy Number Label is displayed");
                softAssertions.assertThat(accountInformationObj.policyNumberLabel().getText()).describedAs("Validating Policy Number Label is correct").isEqualToIgnoringCase(fields.get(0).get(4));
                softAssertions.assertThat(policySummaryPageObj.lnkPolicyView().getText()).describedAs("Validating  if Policy Number format is correct").matches("[0-9]+");
                softAssertions.assertThat(policySummaryPageObj.lnkPolicyView().getText().length()).describedAs("Validating Policy Number length is 8 characters").isEqualTo(8);
                System.out.println("Product---");
                softAssertions.assertThat(accountInformationObj.basePolicyHeader().isDisplayed()).describedAs("Validating Base Policy Header Label is displayed");
                softAssertions.assertThat(accountInformationObj.basePolicyLink().isDisplayed()).describedAs("Validating Base Policy Link is displayed");
                softAssertions.assertThat(accountInformationObj.basePolicyHeader().getText()).describedAs("Validating Base Policy Header Label text is correct").isEqualToIgnoringCase(fields.get(0).get(5));
                softAssertions.assertThat(accountInformationObj.basePolicyLink().getText()).describedAs("Validating Based Policy is correct").isEqualToIgnoringCase(fields.get(1).get(5));
                System.out.println("From application-----" + accountInformationObj.basePolicyLink().getText());
                System.out.println("From Feature file-----" + fields.get(1).get(5));
                System.out.println("Upgrade---");
                softAssertions.assertThat(accountInformationObj.annualUpgradeHeader().isDisplayed()).describedAs("Validating Annual Upgrade Header is displayed");
                softAssertions.assertThat(accountInformationObj.annualUpgradeHeader().getText()).describedAs("Validating Annual Upgrade Header text is correct").isEqualToIgnoringCase(fields.get(0).get(6));
                softAssertions.assertThat(accountInformationObj.annualUpgradeHeader().isDisplayed()).describedAs("Validating Annual Upgrade Link is displayed");
                softAssertions.assertThat(accountInformationObj.annualUpgradeLink().getText()).describedAs("Validating Annual Upgrade link text is correct").isEqualToIgnoringCase(fields.get(1).get(6));
                break;
            case "product & claims":
                if (section.toLowerCase().equalsIgnoreCase("product & claims")) {
                    softAssertions.assertThat(accountInformationObj.claimsHistoryTitle().isDisplayed()).describedAs("Validating Claim History Title is displayed");
                    softAssertions.assertThat(accountInformationObj.claimsHistoryTable().isDisplayed()).describedAs("Validating Claim History Table is displayed");
                }
                softAssertions.assertThat(accountInformationObj.basePolicyHeader().isDisplayed()).describedAs("Validating Base Policy Header is displayed");
                softAssertions.assertThat(accountInformationObj.basePolicyHeader().getText()).describedAs("Validating Base Policy Header text is correct").isEqualToIgnoringCase(fields.get(0).get(4));
                softAssertions.assertThat(accountInformationObj.basePolicyLink().isDisplayed()).describedAs("Validating Base Policy Link is displayed");
                softAssertions.assertThat(accountInformationObj.basePolicyLink().getText()).describedAs("Validating Base Policy Link text is correct").isEqualToIgnoringCase(fields.get(1).get(4));
                softAssertions.assertThat(accountInformationObj.annualUpgradeHeader().isDisplayed()).describedAs("Validating Annual Upgrade Header is displayed");
                softAssertions.assertThat(accountInformationObj.annualUpgradeHeader().getText()).describedAs("Validating Annual Upgrade Header text is correct").isEqualToIgnoringCase(fields.get(0).get(5));
                softAssertions.assertThat(accountInformationObj.annualUpgradeLink().isDisplayed()).describedAs("Validating Annual Upgrade Link is displayed");
                softAssertions.assertThat(accountInformationObj.annualUpgradeLink().getText()).describedAs("Validating Annual Upgrade Link text is correct").isEqualToIgnoringCase(fields.get(1).get(5));
                break;
            case "claims information":
                softAssertions.assertThat(claimSummaryPageObj.claimsSectionTitle().getText()).describedAs("Validating Claim Section Title is correct").isEqualToIgnoringCase(section);
                softAssertions.assertThat(claimSummaryPageObj.claimSummaryTable().isDisplayed()).describedAs("Validating Claim Summary table is displayed");
                webTableObj.checkWebTableHeadings(claimSummaryPageObj.claimSummaryTable(), fields, 1);
                webTableObj.checkWebTableCellsNotEmpty(claimSummaryPageObj.claimSummaryTable());
                this.verifyClaimRecordInSummary(fields);
                break;
            case "claim list":
                softAssertions.assertThat(claimSummaryPageObj.claimSummaryTable().isDisplayed()).describedAs("Validating Claim Summary table is displayed");
                List<WebElement> lstHeaders = claimSummaryPageObj.claimSummaryTable().findElements(By.tagName("th"));
                softAssertions.assertThat(lstHeaders.get(1).getText()).describedAs("Validating Claim Table Columns").isEqualToIgnoringCase("CLAIM ID");
                softAssertions.assertThat(lstHeaders.get(2).getText()).describedAs("Validating Claim Table Columns").isEqualToIgnoringCase("Perils");
                softAssertions.assertThat(lstHeaders.get(3).getText()).describedAs("Validating Claim Table Columns").isEqualToIgnoringCase("Destination");
                softAssertions.assertThat(lstHeaders.get(4).getText()).describedAs("Validating Claim Table Columns").isEqualToIgnoringCase("Trip From");
                softAssertions.assertThat(lstHeaders.get(5).getText()).describedAs("Validating Claim Table Columns").isEqualToIgnoringCase("Trip To");
                softAssertions.assertThat(lstHeaders.get(6).getText()).describedAs("Validating Claim Table Columns").isEqualToIgnoringCase("DoL");
                softAssertions.assertThat(lstHeaders.get(7).getText()).describedAs("Validating Claim Table Columns").isEqualToIgnoringCase("Reserve");
                softAssertions.assertThat(lstHeaders.get(8).getText()).describedAs("Validating Claim Table Columns").isEqualToIgnoringCase("Paid");
                softAssertions.assertThat(lstHeaders.get(9).getText()).describedAs("Validating Claim Table Columns").isEqualToIgnoringCase("Claim Handler");
                softAssertions.assertThat(lstHeaders.get(10).getText()).describedAs("Validating Claim Table Columns").isEqualToIgnoringCase("Status");
                softAssertions.assertThat(lstHeaders.get(11).getText()).describedAs("Validating Claim Table Columns").isEqualToIgnoringCase("Sub Status");
                softAssertions.assertThat(lstHeaders.get(12).getText()).describedAs("Validating Claim Table Columns").isEqualToIgnoringCase("Est. Recov.");
                softAssertions.assertThat(lstHeaders.get(13).getText()).describedAs("Validating Claim Table Columns").isEqualToIgnoringCase("Recov.");
                break;
            default:
                System.out.println("Did not match any case");
        }
        softAssertions.assertAll();
    }

    public void verifyIfPurchasedCoveragesAreDisplayedInSummary(List<List<String>> strInput) {
        SoftAssertions softAssertions = new SoftAssertions();
        List<WebElement> tr_collection = policySummaryPageObj.policySummaryTable().findElements(By.tagName("tr"));
        int iAnnualUpgradeIndex = this.getCoverageDisplayIndex("Annual Upgrade");
        int iSingleTripUpgradeIndex = this.getCoverageDisplayIndex("Single Trip Upgrade");
        int iProductCol = webTableObj.getColumnFromWebTable(policySummaryPageObj.policySummaryTable(), "Product");
        for (int i = 1; i < strInput.size(); i++) {
            boolean iFound = false;
            String strCoverage = strInput.get(i).get(1);
            String strCoverType = strCoverage.split("#")[0];
            String strCoverName = strCoverage.split("#")[1];
            switch (strCoverType.toLowerCase()) {
                case "basepolicy":
                    softAssertions.assertThat(policySummaryPageObj.basePolicy().findElements(By.tagName("td")).get(2).getText()).describedAs("Validating base policy is displayed").contains(strCoverName);
                    break;
                case "annualupgrade":
                    for (int iRow = iAnnualUpgradeIndex + 1; iRow < tr_collection.size() - 1; iRow++) {
                        if (tr_collection.get(iRow).getAttribute("id").endsWith("footerRow")) {
                            break;
                        }
                        if (tr_collection.get(iRow).findElements(By.tagName("th")).size() > 0) {
                            break;
                        }
                        List<WebElement> td_Collection = tr_collection.get(iRow).findElements(By.tagName("td"));
                        String strProduct = td_Collection.get(iProductCol).getText();
                        if (strProduct.equalsIgnoreCase(strCoverName)) {
                            iFound = true;
                            break;
                        }
                    }
                    if (iFound) {
                        softAssertions.assertThat(true).describedAs(strCoverName + "is displayed under Annual Upgrade section");
                    } else {
                        softAssertions.assertThat(false).describedAs(strCoverName + "is not displayed under Annual Upgrade section");
                    }
                    break;
                case "singletripupgrade":
                    for (int iRow = iSingleTripUpgradeIndex + 1; iRow < tr_collection.size() - 1; iRow++) {
                        if (tr_collection.get(iRow).getAttribute("id").endsWith("footerRow")) {
                            break;
                        }
                        if (tr_collection.get(iRow).findElements(By.tagName("th")).size() > 0) {
                            break;
                        }
                        List<WebElement> td_Collection = tr_collection.get(iRow).findElements(By.tagName("td"));
                        String strProduct = td_Collection.get(iProductCol).getText();
                        if (strProduct.equalsIgnoreCase(strCoverName)) {
                            iFound = true;
                            break;
                        }
                    }
                    if (iFound) {
                        softAssertions.assertThat(true).describedAs(strCoverName + "is displayed under Single Trip Upgrade section");
                    } else {
                        softAssertions.assertThat(false).describedAs(strCoverName + "is not displayed under Single Trip Upgrade section");
                    }
                    break;
            }
        }
        softAssertions.assertAll();
    }
}
