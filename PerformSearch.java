package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.common.FileOperations;
import co.uk.directlinegroup.tt.utils.common.RandomGenerator;
import co.uk.directlinegroup.tt.utils.common.WebTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PerformSearch {

    public static String taxPercent = "";
    public static String fromDate = "";
    public static String toDate = "";
    private static String strNoValueEntryString = "Nothing Entered";
    public String defaultValue = "Please select...";
    public String strSearchCondition = "";
    public String taxRegion = "";
    public String taxRegionCollect[];
    public static String taxfreePercent = "";
    public String taxfreeRegion = "";
    public String taxfreeRegionCollect[];
    public static String taxEntered = "";
    public static String brandName = "";
    private SearchPage searchPageObj = new SearchPage();
    private PolicySummaryPage polSummObj = new PolicySummaryPage();
    private ClaimSummaryPage claimSummObj = new ClaimSummaryPage();
    private ClaimsOperations claimOpeobj = new ClaimsOperations();
    private PolicyOperations policyOperationsObj = new PolicyOperations();
    private WebTable webTableObj = new WebTable();
    private AccountInformationPage accountInformationPageObj = new AccountInformationPage();
    private Navigation navigationObj = new Navigation();
    private SchemeSummaryPage schemeSummaryPageObj = new SchemeSummaryPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private RandomGenerator randomGeneratorObj = new RandomGenerator();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private QuoteAndBuyOperations quoteAndBuyOperationsObj = new QuoteAndBuyOperations();
    private QuoteDetailsPage quoteDetailsPageObj = new QuoteDetailsPage();
    private SupplierOperations supplierOperationsObj = new SupplierOperations();
    private IReportingOperations iReportingOperationsObj = new IReportingOperations();
    private Commands commandsObj = new Commands();
    private LeftNavPanePage leftNavPaneObj = new LeftNavPanePage();
    private CommonPage commonPage = new CommonPage();
    public static String policyNumber = "";
    public static String policyId = "";
    private FileOperations fileOperationsOObj = new FileOperations();

    public void selectBrand(String strBrand) {
        new Select(searchPageObj.brand()).selectByVisibleText(strBrand);
    }

    public void enterFirstName(String strFName) {
        searchPageObj.firstName().clear();
        if (!strFName.equalsIgnoreCase(strNoValueEntryString) && !strFName.isEmpty() && strFName != null && !strFName.equalsIgnoreCase("Random")) {
            searchPageObj.firstName().sendKeys(strFName);
        }
        if (strFName.equalsIgnoreCase("random")) {
            strFName = randomGeneratorObj.randomString(4);
            searchPageObj.firstName().sendKeys(strFName);
        }
    }

    public void enterSurname(String strLName) {
        searchPageObj.surname().clear();
        if (!strLName.equalsIgnoreCase(strNoValueEntryString) && !strLName.isEmpty() && strLName != null) {
            searchPageObj.surname().sendKeys(strLName);
        }
    }

    public void enterRiskPostCode(String strPostCode) {
        searchPageObj.riskPostCode().clear();
        if (!strPostCode.equalsIgnoreCase(strNoValueEntryString) && !strPostCode.isEmpty() && strPostCode != null) {
            searchPageObj.riskPostCode().sendKeys(strPostCode);
        }
    }

    public void enterDOB(String strDOB) {
        searchPageObj.dob().clear();
        System.out.println("DOB is-----" + strDOB);
        if (!strDOB.equalsIgnoreCase(strNoValueEntryString) && !strDOB.isEmpty() && strDOB != null) {
            System.out.println("DOB is-----" + strDOB);
            searchPageObj.dob().sendKeys(strDOB);
            searchPageObj.dob().sendKeys(Keys.TAB);
        }
    }

    public void enterEmail(String strEmail) {
        searchPageObj.email().clear();
        if (!strEmail.equalsIgnoreCase(strNoValueEntryString) && !strEmail.isEmpty() && strEmail != null) {
            searchPageObj.email().sendKeys(strEmail);
        }
    }

    public void enterPhoneNumber(String strPhoneNumber) {
        searchPageObj.phoneNumber().clear();
        if (!strPhoneNumber.equalsIgnoreCase(strNoValueEntryString) && !strPhoneNumber.isEmpty() && strPhoneNumber != null) {
            searchPageObj.phoneNumber().sendKeys(strPhoneNumber);
        }
    }

    public void enterPolicyNumber(String strPolicyNumber) {
        searchPageObj.policyNumber().clear();
        if (!strPolicyNumber.equalsIgnoreCase(strNoValueEntryString) && !strPolicyNumber.isEmpty() && strPolicyNumber != null) {
            searchPageObj.policyNumber().sendKeys(strPolicyNumber);
        }
    }

    public void enterClaimNumber(String strClaimNumber) {
        searchPageObj.claimNumber().clear();
        if (!strClaimNumber.equalsIgnoreCase(strNoValueEntryString) && !strClaimNumber.isEmpty() && strClaimNumber != null) {
            searchPageObj.claimNumber().sendKeys(strClaimNumber);
        }
    }

    public void enterBankAccountNumber(String strBankAccountNumber) {
        searchPageObj.bankAccountNumber().clear();
        if (!strBankAccountNumber.equalsIgnoreCase(strNoValueEntryString) && !strBankAccountNumber.isEmpty() && strBankAccountNumber != null) {
            searchPageObj.bankAccountNumber().sendKeys(strBankAccountNumber);
        }
    }

    public void clickSearch() throws InterruptedException {
        searchPageObj.btnClick(searchPageObj.searchButton());
    }

    public void resetSearch() {
        nextEventPageObj.waitForMoreTime();
        searchPageObj.firstName().clear();
        searchPageObj.surname().clear();
        searchPageObj.riskPostCode().clear();
        searchPageObj.dob().clear();
        searchPageObj.email().clear();
        searchPageObj.phoneNumber().clear();
        searchPageObj.policyNumber().clear();
        searchPageObj.claimNumber().clear();
        searchPageObj.bankAccountNumber().clear();
        nextEventPageObj.waitForMoreTime();
    }

    public void clientSearch(List<List<String>> lstSearchCriteria) throws Throwable {
        System.out.println("lstSearchCriteria Before parameterMappingNew::" + lstSearchCriteria);
        for (int row = 1; row < lstSearchCriteria.size(); row++) {
            System.out.println("iteration:" + row);
            boolean bClickSearchButton = true;
            this.resetSearch();
            for (int column = 0; column < lstSearchCriteria.get(0).size(); column++) {
                System.out.println("Field index:===" + column);
                String searchField = lstSearchCriteria.get(0).get(column);
                String searchValue = lstSearchCriteria.get(row).get(column);
                if (searchField.equalsIgnoreCase("expectedbehaviour")) {
                    bClickSearchButton = false;
                }
                if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
                    switch (searchField.toLowerCase()) {
                        case "brand":
                            if (System.getProperty("brand") != null) {
                                searchValue = fileOperationsOObj.getCommonProperties(System.getProperty("brand"));
                            }
                            brandName = searchValue;
                            System.out.println("Brand name :-------------------->>>>" + brandName);
                            this.selectBrand(searchValue);
                            break;
                        case "forename":
                        case "firstname":
                            if (searchValue.equalsIgnoreCase("retrieveRandomuserFirstName")) {
                                searchValue = QuoteAndBuyOperations.randomCustomerFirstName;
                                System.out.println("Search value" + searchValue);
                            } else
                                this.enterFirstName(searchValue);
                            break;
                        case "surname":
                        case "lastname":
                            if (searchValue.equalsIgnoreCase("RANDOM")) {
                                searchValue = randomGeneratorObj.randomString(5);
                                this.enterSurname(searchValue);
                            } else if (searchValue.equalsIgnoreCase("randomCustomerLastName")) {
                                searchValue = quoteAndBuyOperationsObj.randomCustomerLastName;
                                System.out.println("Random customer last name" + searchValue);
                                this.enterSurname(searchValue);
                            } else if (searchValue.equalsIgnoreCase("retrieveRandomCustomerLastName")) {
                                searchValue = policyOperationsObj.retrieveRandomCustomerLastName;
                                System.out.println("Retrieved customer last name" + searchValue);
                                this.enterSurname(searchValue);
                            }else if(searchValue.equalsIgnoreCase("getJointAcctHolder")){
                                searchValue=policyOperationsObj.jointAcctLastName;
                                this.enterSurname(searchValue);
                            }
                            else if (searchValue.equalsIgnoreCase("IjyRu")) {

                                this.enterSurname("IjyRu");
                            }
                            else {
                                this.enterSurname(searchValue);
                            }
                            break;
                        case "risk postcode":
                        case "riskpostcode":
                            this.enterRiskPostCode(searchValue);
                            break;
                        case "dateofbirth":
                            if (searchValue.equalsIgnoreCase("69years11months")) {
                                String dob = policyOperationsObj.DobDate(searchValue);
                                System.out.println("DOB --" + dob);
                                this.enterDOB(dob);
                            } else if (searchValue.equalsIgnoreCase("69years10months") || searchValue.equalsIgnoreCase("70thbirthdayreached")) {
                                String dob = policyOperationsObj.DobDate(searchValue);
                                System.out.println("DOB --" + dob);
                                this.enterDOB(dob);
                            } else {
                                this.enterDOB(searchValue);
                            }
                            searchPageObj.waitForMoreTime();
                            searchPageObj.calendarButton().click();
                            searchPageObj.waitForMoreTime();
                            searchPageObj.calendarButton().click();
                            searchPageObj.waitForMoreTime();
                            break;
                        case "email":
                            this.enterEmail(searchValue);
                            break;
                        case "phonenumber(s)":
                        case "phonenumber":
                            this.enterPhoneNumber(searchValue);
                            break;
                        case "policynumber":
                            if (searchValue.equalsIgnoreCase("getPolicyNumber")) {
                                searchValue = policyOperationsObj.getPolicyValue();
                                policyNumber=policyOperationsObj.getPolicyValue();
                                System.out.println( "Policy Number***********"+ policyNumber);
                                this.enterPolicyNumber(searchValue);
                            } else {
                                this.enterPolicyNumber(searchValue);
                            }
                            break;
                        case "claimnumber":
                            this.enterClaimNumber(searchValue);
                            break;
                        case "bankaccountnumber":
                            this.enterBankAccountNumber(searchValue);
                            break;
                        case "expectedbehaviour":
                            List<List<String>> lstSearchCriteriaToValidate = new ArrayList<>();
                            lstSearchCriteriaToValidate.add(lstSearchCriteria.get(0));
                            lstSearchCriteriaToValidate.add(lstSearchCriteria.get(row));
                            this.clickSearch();
                            commandsObj.LoadingSearchResultsInSeconds(60L);
                            searchPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            this.validateSearchCriteria(searchValue, lstSearchCriteriaToValidate);
                            searchPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                    }
                }
            }
            if (bClickSearchButton) {
                this.clickSearch();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
            }
        }
    }

    public void validateSearchCriteria(String strExpBehaviour, List<List<String>> lstSearchCondition) throws InterruptedException {
        switch (strExpBehaviour.toLowerCase()) {
            case "single record that automatically loads":
                searchPageObj.switchToWindowByIndex(1);
                Assert.assertTrue(polSummObj.customerDetailsTabDisplayed());
                navigationObj.navigateToSearchScreen();
                break;
            case "no record returned":
                int iNoOfResults = searchPageObj.searchResultTable().findElements(By.tagName("tr")).size() - 1;
                System.out.println("No records" + iNoOfResults);
                Assert.assertTrue(iNoOfResults == 1);
                break;
            case "all matching records with fields: brand, forename, surname, risk postcode, dob, primary phone number, policy number, relationship to policy holder":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue(this.validateCustomerSearchResult(lstSearchCondition));
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            case "claim record should be displayed when claim record selected from policy summary":
            case "claim record is selected from policy summary and claim record is displayed":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                try {
                    searchPageObj.viewCustomerLinkInSearchResultTable().click();
                } catch (Exception e) {
                    searchPageObj.btnClick(searchPageObj.viewCustomerLinkInSearchResultTable());
                }
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimOpeobj.navigateToClaimViewFromPolicyView();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue(claimSummObj.claimSummaryTable().isDisplayed());
                break;
        }
    }

    public void retreiveFirstClientRecord() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        String strContinue = "Yes";
        int i = 0;
        do {
            i++;
            System.out.println("first record" + searchPageObj.viewCustomerLinkInSearchResultTableIsDisplayed());
            if (searchPageObj.viewCustomerLinkInSearchResultTableIsDisplayed()) {
                System.out.println("example----------------------------");
                searchPageObj.viewCustomerLinkInSearchResultTable().click();
                break;
            }

            if (polSummObj.customerDetailsTabIsDisplayed()) {
                break;
            }

            if (polSummObj.isErrorPageDisplayed()) {
                break;
            }
            if (i > 100) {
                break;
            }
        } while (strContinue.equalsIgnoreCase("Yes"));
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
    }

    public boolean validateCustomerSearchResult(List<List<String>> lstCustomerSearchInputs) {
        System.out.println("lstCustomerSearchInputs.size()=====" + lstCustomerSearchInputs.size());
        String strStringToSearchInTable = "";
        List<WebElement> lstRows = searchPageObj.searchResultTable().findElements(By.tagName("tr"));
        if (lstRows.size() <= 2) {
            return false;
        }
        for (int row = 1; row < lstCustomerSearchInputs.size(); row++) {
            strStringToSearchInTable = "#####";
            for (int column = 0; column < lstCustomerSearchInputs.get(0).size(); column++) {
                String strSearchParameter = lstCustomerSearchInputs.get(0).get(column);
                String strSearchValue = lstCustomerSearchInputs.get(row).get(column);
                if (!strSearchValue.equalsIgnoreCase(strNoValueEntryString) && !strSearchValue.isEmpty() && strSearchValue != null) {
                    switch (strSearchParameter.toLowerCase().trim()) {
                        case "brand":
                            int iBrandColIndex = webTableObj.getColumnFromWebTable(searchPageObj.searchResultTable(), "Brand");
                            System.out.println("iBrandColIndex--------------------------" + iBrandColIndex);
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            strStringToSearchInTable = strSearchValue;
                            System.out.println("strSearchValue----------------------------------" + strSearchValue);
                            for (int i = 1; i < lstRows.size(); i++) {
                                String strStringInTable = searchPageObj.searchResultTable().findElements(By.tagName("td")).get(iBrandColIndex).getText();
                                System.out.println("Brand==" + strStringInTable.equalsIgnoreCase(strStringToSearchInTable));
                                if (!strStringInTable.equalsIgnoreCase(strStringToSearchInTable)) {
                                    return false;
                                }
                            }
                            break;
                        case "firstname":
                            int iFirstNameColIndex = webTableObj.getColumnFromWebTable(searchPageObj.searchResultTable(), "Name");
                            strStringToSearchInTable = strSearchValue;
                            for (int i = 1; i < lstRows.size(); i++) {
                                String strStringInTable = searchPageObj.searchResultTable().findElements(By.tagName("td")).get(iFirstNameColIndex).getText();
                                strStringInTable = strStringInTable.split(" ")[0];
                                System.out.println("Forename==" + strStringInTable.equalsIgnoreCase(strStringToSearchInTable));
                                if (!strStringInTable.equalsIgnoreCase(strStringToSearchInTable)) {
                                    return false;
                                }
                            }
                            break;
                        case "surname":
                            int iSurnameColIndex = webTableObj.getColumnFromWebTable(searchPageObj.searchResultTable(), "Name");
                            strStringToSearchInTable = strSearchValue;
                            for (int i = 1; i < lstRows.size(); i++) {
                                String strStringInTable = searchPageObj.searchResultTable().findElements(By.tagName("td")).get(iSurnameColIndex).getText();
                                strStringInTable = strStringInTable.split(" ")[1];
                                System.out.println("surname==" + strStringInTable.equalsIgnoreCase(strStringToSearchInTable));
                                if (!strStringInTable.equalsIgnoreCase(strStringToSearchInTable)) {
                                    return false;
                                }
                            }
                            break;
                        case "riskpostcode":
                            int iRiskPostCodeColIndex = webTableObj.getColumnFromWebTable(searchPageObj.searchResultTable(), "Postcode");
                            strStringToSearchInTable = strSearchValue;
                            for (int i = 1; i < lstRows.size(); i++) {
                                String strStringInTable = searchPageObj.searchResultTable().findElements(By.tagName("td")).get(iRiskPostCodeColIndex).getText();
                                System.out.println("riskpostcode==" + strStringInTable.equalsIgnoreCase(strStringToSearchInTable));
                                if (!strStringInTable.equalsIgnoreCase(strStringToSearchInTable)) {
                                    return false;
                                }
                            }
                            break;
                        case "dob":
                            int iDOBColIndex = webTableObj.getColumnFromWebTable(searchPageObj.searchResultTable(), "DOB");
                            String arrDob[] = strSearchValue.split("/");
                            strStringToSearchInTable = arrDob[2] + "-" + arrDob[1] + "-" + arrDob[0];
                            for (int i = 1; i < lstRows.size(); i++) {
                                String strStringInTable = searchPageObj.searchResultTable().findElements(By.tagName("td")).get(iDOBColIndex).getText();
                                System.out.println("dob==" + strStringInTable.equalsIgnoreCase(strStringToSearchInTable));
                                if (!strStringInTable.equalsIgnoreCase(strStringToSearchInTable)) {
                                    return false;
                                }
                            }
                            break;
                        case "email":
                            polSummObj.waitForMoreTime();
                            polSummObj.waitForMoreTime();
                            strStringToSearchInTable = strSearchValue;
                            lstRows.get(1).findElement(By.xpath("//img[@title='View Customer']")).click();
                            strStringToSearchInTable = strSearchValue;
                            polSummObj.switchToLastOpenWindow();
                            polSummObj.switchToDefault();
                            polSummObj.waitForMoreTime();
                            polSummObj.waitForMoreTime();
                            polSummObj.waitForMoreTime();
                            polSummObj.waitForMoreTime();
                            polSummObj.waitForMoreTime();
                            polSummObj.waitForMoreTime();
                            System.out.println("polSummObj.email().getAttribute( \"value\" )====" + polSummObj.email().getAttribute("value"));
                            if (!polSummObj.email().getAttribute("value").equalsIgnoreCase(strStringToSearchInTable)) {
                                return false;
                            } else {
                                polSummObj.closeTabByIndex(1);
                                polSummObj.switchToWindowByIndex(0);
                            }
                            break;
                        case "phonenumber":
                            int iHomeNoColIndex = webTableObj.getColumnFromWebTable(searchPageObj.searchResultTable(), "HomePhone");
                            int iMobileNoColIndex = webTableObj.getColumnFromWebTable(searchPageObj.searchResultTable(), "MobilePhone");
                            int iDayTimePhoneNoColIndex = webTableObj.getColumnFromWebTable(searchPageObj.searchResultTable(), "DaytimePhone");
                            strStringToSearchInTable = strSearchValue;
                            for (int i = 1; i < lstRows.size(); i++) {
                                String strStringInTable = searchPageObj.searchResultTable().findElements(By.tagName("td")).get(iHomeNoColIndex).getText();
                                System.out.println("homephone==" + strStringInTable.equalsIgnoreCase(strStringToSearchInTable));
                                if (!strStringInTable.equalsIgnoreCase(strStringToSearchInTable)) {
                                    strStringInTable = searchPageObj.searchResultTable().findElements(By.tagName("td")).get(iMobileNoColIndex).getText();
                                    System.out.println("mobile==" + strStringInTable.equalsIgnoreCase(strStringToSearchInTable));
                                    if (!strStringInTable.equalsIgnoreCase(strStringToSearchInTable)) {
                                        strStringInTable = searchPageObj.searchResultTable().findElements(By.tagName("td")).get(iDayTimePhoneNoColIndex).getText();
                                        System.out.println("Daytime==" + strStringInTable.equalsIgnoreCase(strStringToSearchInTable));
                                        if (!strStringInTable.equalsIgnoreCase(strStringToSearchInTable)) {
                                            return false;
                                        }
                                    }
                                }
                            }
                            break;
                        case "policynumber":
                            int iPolicyNumColIndex = webTableObj.getColumnFromWebTable(searchPageObj.searchResultTable(), "PolicyNum");
                            strStringToSearchInTable = strSearchValue;
                            for (int i = 1; i < lstRows.size(); i++) {
                                String strStringInTable = searchPageObj.searchResultTable().findElements(By.tagName("td")).get(iPolicyNumColIndex).getText();
                                System.out.println("policynumber==" + strStringInTable.equalsIgnoreCase(strStringToSearchInTable));
                                if (!strStringInTable.equalsIgnoreCase(strStringToSearchInTable)) {
                                    return false;
                                }
                            }
                            break;
                        case "claimnumber":
                            strStringToSearchInTable = strSearchValue;
                            boolean bFound = false;
                            lstRows.get(1).findElement(By.xpath("//img[@title='View Customer']")).click();
                            accountInformationPageObj.switchToWindowByIndex(1);
                            accountInformationPageObj.moreLink().click();
                            List<WebElement> lstClaims = claimSummObj.claimSummaryTable().findElements(By.tagName("tr"));
                            int iClaimIdColIndex = webTableObj.getColumnFromWebTable(claimSummObj.claimSummaryTable(), "Claim ID");
                            for (int iClaim = 1; iClaim < lstClaims.size(); iClaim++) {
                                if (lstClaims.get(iClaim).findElements(By.tagName("td")).get(iClaimIdColIndex).getText().equalsIgnoreCase(strStringToSearchInTable)) {
                                    bFound = true;
                                    break;
                                }
                            }
                            if (!bFound) {
                                accountInformationPageObj.closeTabByIndex(1);
                                accountInformationPageObj.switchToWindowByIndex(0);
                                return false;
                            } else {
                                accountInformationPageObj.closeTabByIndex(1);
                                accountInformationPageObj.switchToWindowByIndex(0);
                            }
                            break;
                        case "bankaccountnumber":
                            lstRows.get(1).findElement(By.xpath("//img[@title='View Customer']")).click();
                            accountInformationPageObj.switchToWindowByIndex(1);
                            if (!accountInformationPageObj.accountNumber().getText().equalsIgnoreCase(strSearchValue)) {
                                accountInformationPageObj.closeTabByIndex(1);
                                accountInformationPageObj.switchToWindowByIndex(0);
                                return false;
                            } else {
                                accountInformationPageObj.closeTabByIndex(1);
                                accountInformationPageObj.switchToWindowByIndex(0);
                            }
                            break;
                        case "relationshiptopolicyholder":
                            if (!strSearchValue.equalsIgnoreCase("blank")) {
                                int iRelationshipToPolColIndex = webTableObj.getColumnFromWebTable(searchPageObj.searchResultTable(), "RelationshipToPolicyholder");
                                strStringToSearchInTable = strSearchValue;
                                for (int i = 1; i < lstRows.size(); i++) {
                                    String strStringInTable = searchPageObj.searchResultTable().findElements(By.tagName("td")).get(iRelationshipToPolColIndex).getText();
                                    System.out.println("RelationshipToPolicyholder==" + strStringInTable.equalsIgnoreCase(strStringToSearchInTable));
                                    if (!strStringInTable.equalsIgnoreCase(strStringToSearchInTable)) {
                                        return false;
                                    }
                                }
                            }
                            break;
                    }
                }
            }
        }
        return true;
    }

    public void addressLookUpfornonukadress(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "post code":
                    System.out.println("Inside post code");
                    this.enterPostCodefornonuk(searchValue);
                    break;
                case "customer address1":
                    this.entercustomeradress1(searchValue);
                    break;
                case "customer address2":
                    this.entercustomeradress2(searchValue);
                    break;
                case "customer town":
                    this.entercustometown(searchValue);
                    break;
                case "customer county":
                    this.entercustomercountry(searchValue);
                    break;
                case "customer postcode":
                    this.entercustomerpostcode(searchValue);
                    break;
                case "address type":
                    this.selectAddresstype(searchValue);
                    break;
                case "uk address or branch":
                    policyDataFieldsPageObj.okAddressOrBranch().click();
                    policyDataFieldsPageObj.okAddressOrBranchValue(searchValue).click();
                    break;
                case "action":
                    System.out.println("Inside action");
                    nextEventPageObj.waitForMoreTime();
                    this.save();
                    break;
            }
        }
    }

    public void enterPostCodefornonuk(String postcode) {
        searchPageObj.enterPostcodeInAddressLookUp().clear();
        if (!postcode.equalsIgnoreCase(strNoValueEntryString) && !postcode.isEmpty() && postcode != null) {
            searchPageObj.enterPostcodeInAddressLookUp().sendKeys(postcode);
        }
    }

    public void entercustomeradress1(String currentaddrs1) {
        searchPageObj.enterPostcodeInAddressLookUp().clear();
        if (!currentaddrs1.equalsIgnoreCase(strNoValueEntryString) && !currentaddrs1.isEmpty() && currentaddrs1 != null) {
            searchPageObj.entercurrentaddrs1InAddressLookUp().sendKeys(currentaddrs1);
        }
    }

    public void entercustomeradress2(String currentaddrs2) {
        searchPageObj.enterPostcodeInAddressLookUp().clear();
        if (!currentaddrs2.equalsIgnoreCase(strNoValueEntryString) && !currentaddrs2.isEmpty() && currentaddrs2 != null) {
            searchPageObj.entercurrentaddrs2InAddressLookUp().sendKeys(currentaddrs2);
        }
    }


    public void entercustometown(String town) {
        searchPageObj.enterPostcodeInAddressLookUp().clear();
        if (!town.equalsIgnoreCase(strNoValueEntryString) && !town.isEmpty() && town != null) {
            searchPageObj.entercustomertown().sendKeys(town);
        }
    }

    public void entercustomercountry(String town) {
        searchPageObj.enterPostcodeInAddressLookUp().clear();
        if (!town.equalsIgnoreCase(strNoValueEntryString) && !town.isEmpty() && town != null) {
            searchPageObj.entercustomercountry().sendKeys(town);
        }
    }

    public void entercustomerpostcode(String postcode) {
        searchPageObj.enterPostcodeInAddressLookUp().clear();
        if (!postcode.equalsIgnoreCase(strNoValueEntryString) && !postcode.isEmpty() && postcode != null) {
            searchPageObj.entercustomerpostcode().sendKeys(postcode);
        }
    }


    public void chaseeventdetails(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "chase title":
                    this.enterchasetitle(searchValue);
                    break;
                case "chase text":
                    this.enterchasetext(searchValue);
                    break;
                case "number of days until manual chase reminder":
                    this.enternumberofdaysformanualchase(searchValue);
                    break;
                case "number of days between automated chases":
                    this.enternumberofdaysforautomation(searchValue);
                    break;
                case "action":
                    System.out.println("Inside action");
                    nextEventPageObj.waitForMoreTime();
                    this.chasesave();
                    break;
            }
        }
    }

    public void enterchasetitle(String title) {
        if (!title.equalsIgnoreCase(strNoValueEntryString) && !title.isEmpty() && title != null) {
            searchPageObj.enterchasetitle().sendKeys(title);
        }
    }

    public void enterchasetext(String chasetext) {
        if (!chasetext.equalsIgnoreCase(strNoValueEntryString) && !chasetext.isEmpty() && chasetext != null) {
            searchPageObj.enterchasetext().sendKeys(chasetext);
        }
    }

    public void enternumberofdaysformanualchase(String numberofdays) {
        if (!numberofdays.equalsIgnoreCase(strNoValueEntryString) && !numberofdays.isEmpty() && numberofdays != null) {
            searchPageObj.enternumberofdaysformanualchase().sendKeys(numberofdays);
        }
    }

    public void enternumberofdaysforautomation(String automationdays) {
        if (!automationdays.equalsIgnoreCase(strNoValueEntryString) && !automationdays.isEmpty() && automationdays != null) {
            searchPageObj.enternumberofdaysforautomationchase().sendKeys(automationdays);
        }
    }

    public void chasesave() {
        searchPageObj.chasesave().click();
    }

    public void stopchaseeventdetails(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "stop chase":
                    searchPageObj.stopchasedetailmain().click();
                    searchPageObj.stopchaseDetails(searchValue).click();
                    break;
                case "action":
                    System.out.println("Inside action");
                    nextEventPageObj.waitForMoreTime();
                    this.chasesave();
                    break;
            }
        }
    }

    public void nonukdetailsdetails(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "customer is resident in the uk":
                    searchPageObj.non_ukdetails_clickable().click();
                    searchPageObj.nonukdetails(searchValue).click();
                    break;
                case "action":
                    System.out.println("Inside non uk action");
                    nextEventPageObj.waitForMoreTime();
                    this.chasesave();
                    break;
            }
        }
    }

    public void save() {
        if (searchPageObj.save().isDisplayed()) {
            searchPageObj.save();
            searchPageObj.save().click();
        }
    }

    public void enterDataInIPT(String strEventType, List<List<String>> parameters) {
        for (int iRow = 1; iRow < parameters.size(); iRow++) {
            for (int iCol = 0; iCol < parameters.get(0).size(); iCol++) {
                String strFieldName = parameters.get(0).get(iCol);
                String strFieldValue = parameters.get(iRow).get(iCol);
                if (!strFieldValue.isEmpty()) {
                    switch (strFieldName.toLowerCase().trim()) {
                        case "taxpercent":
                            System.out.println("Inside Tax percent");
                            if (strEventType.equalsIgnoreCase("uk standard travel")) {
                                searchPageObj.UK_Standard_TaxPercent().clear();
                                searchPageObj.UK_Standard_TaxPercent().sendKeys(strFieldValue);
                                System.out.println("str field value" + strFieldValue);
                                taxEntered = strFieldValue;
                            } else if (strEventType.equalsIgnoreCase("iom")) {
                                searchPageObj.IOM_TaxPercent().clear();
                                searchPageObj.IOM_TaxPercent().sendKeys(strFieldValue);
                                taxEntered = strFieldValue;
                            } else if (strEventType.equalsIgnoreCase("channel isles")) {
                                searchPageObj.channel_TaxPercent().clear();
                                searchPageObj.channel_TaxPercent().sendKeys(strFieldValue);
                                taxEntered = strFieldValue;
                            } else if (strEventType.equalsIgnoreCase("uk tax free travel")) {
                                searchPageObj.ukTaxfree_TaxPercent().clear();
                                searchPageObj.ukTaxfree_TaxPercent().sendKeys(strFieldValue);
                                taxEntered = strFieldValue;
                            }
                            break;
                        case "region":
                            System.out.println("Inside the region");
                            if (strEventType.equalsIgnoreCase("uk standard travel")) {
                                searchPageObj.UK_TaxRegion().clear();
                                searchPageObj.UK_TaxRegion().sendKeys(strFieldValue);
                            } else if (strEventType.equalsIgnoreCase("iom")) {
                                searchPageObj.IOM_TaxRegion().clear();
                                searchPageObj.IOM_TaxRegion().sendKeys(strFieldValue);
                            } else if (strEventType.equalsIgnoreCase("channel isles")) {
                                searchPageObj.channel_TaxRegion().clear();
                                searchPageObj.channel_TaxRegion().sendKeys(strFieldValue);
                            } else if (strEventType.equalsIgnoreCase("uk tax free travel")) {
                                searchPageObj.ukTaxFree_TaxRegion().clear();
                                searchPageObj.ukTaxFree_TaxRegion().sendKeys(strFieldValue);
                            }
                            break;
                        case "from date":
                            if (strEventType.equalsIgnoreCase("uk standard travel")) {
                                searchPageObj.UK_TaxRegionFromDate().clear();
                                searchPageObj.UK_TaxRegionFromDate().sendKeys(strFieldValue);
                            } else if (strEventType.equalsIgnoreCase("channel isles")) {
                                if (strFieldValue.equalsIgnoreCase("currentdate+1")) {
                                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                    Calendar c = Calendar.getInstance();
                                    c.setTime(new Date());
                                    c.add(Calendar.DATE, 1);
                                    String date = sdf.format(c.getTime());
                                    strFieldValue = date;
                                    System.out.println("current Date +1 " + strFieldValue);
                                    searchPageObj.channelIsles_TaxRegionFromDate().clear();
                                    searchPageObj.channelIsles_TaxRegionFromDate().sendKeys(strFieldValue);
                                }
                                searchPageObj.channelIsles_TaxRegionFromDate().clear();
                                searchPageObj.channelIsles_TaxRegionFromDate().sendKeys(strFieldValue);
                            } else if (strEventType.equalsIgnoreCase("iom")) {
                                searchPageObj.iom_TaxRegionFromDate().clear();
                                searchPageObj.iom_TaxRegionFromDate().sendKeys(strFieldValue);
                            } else if (strEventType.equalsIgnoreCase("uk tax free travel")) {
                                searchPageObj.UK_TaxfFreeRegionFromDate().clear();
                                searchPageObj.UK_TaxfFreeRegionFromDate().sendKeys(strFieldValue);
                            }
                            break;
                        case "to date":
                            if (strEventType.equalsIgnoreCase("uk standard travel")) {
                                if (strFieldValue.equalsIgnoreCase("currentdate")) {
                                    String strDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                                    System.out.println("current Date " + strDate);
                                    strFieldValue = strDate;
                                    searchPageObj.UK_TaxRegionToDate().clear();
                                    searchPageObj.UK_TaxRegionToDate().sendKeys(strFieldValue);
                                } else {
                                    searchPageObj.UK_TaxRegionToDate().clear();
                                    searchPageObj.UK_TaxRegionToDate().sendKeys(strFieldValue);
                                }
                            } else if (strEventType.equalsIgnoreCase("channel isles")) {
                                searchPageObj.channelIsles_TaxRegionToDate().clear();
                                searchPageObj.channelIsles_TaxRegionToDate().sendKeys(strFieldValue);
                            } else if (strEventType.equalsIgnoreCase("iom")) {
                                searchPageObj.iom_TaxRegionToDate().clear();
                                searchPageObj.iom_TaxRegionToDate().sendKeys(strFieldValue);
                            } else if (strEventType.equalsIgnoreCase("uk tax free travel")) {
                                if (strFieldValue.equalsIgnoreCase("currentdate")) {
                                    String strDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                                    System.out.println("current Date " + strDate);
                                    strFieldValue = strDate;
                                    searchPageObj.UK_TaxFreeRegionToDate().clear();
                                    searchPageObj.UK_TaxFreeRegionToDate().sendKeys(strFieldValue);
                                } else {
                                    searchPageObj.UK_TaxFreeRegionToDate().clear();
                                    searchPageObj.UK_TaxFreeRegionToDate().sendKeys(strFieldValue);
                                }
                            }
                            break;
                        case "action":
                            System.out.println("Closing window");
                            nextEventPageObj.waitForMoreTime();
                            searchPageObj.saveAndCloseIPT();
                            nextEventPageObj.btnClick(searchPageObj.saveAndCloseIPT());
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            break;
                    }
                }
            }
        }
    }

    public void retrievDataFromIPT(String strEventType, List<List<String>> parameters) {
        for (int iRow = 1; iRow < parameters.size(); iRow++) {
            for (int iCol = 0; iCol < parameters.get(0).size(); iCol++) {
                String strFieldName = parameters.get(0).get(iCol);
                String strFieldValue = parameters.get(iRow).get(iCol);
                if (!strFieldValue.isEmpty()) {
                    switch (strFieldName.toLowerCase().trim()) {
                        case "taxpercent":
                            System.out.println("Inside Tax percent");
                            if (strEventType.equalsIgnoreCase("uk standard travel")) {
                                System.out.println("Inside UK standard travel tax percent");
                                taxPercent = searchPageObj.UK_Standard_TaxPercent().getAttribute("value");
                                taxEntered = strFieldValue;
                                System.out.println("Str field value" + strFieldValue);
                            } else if (strEventType.equalsIgnoreCase("iom")) {
                                System.out.println("Inside IOM tax percent");
                                taxPercent = searchPageObj.IOM_TaxPercent().getAttribute("value");
                            } else if (strEventType.equalsIgnoreCase("channel isles")) {
                                System.out.println("Inside channel isles tax percent");
                                taxPercent = searchPageObj.channel_TaxPercent().getAttribute("value");
                            } else if (strEventType.equalsIgnoreCase("uk tax free travel")) {
                                System.out.println("Inside Tax free Travel tax percent");
                                taxPercent = searchPageObj.ukTaxfree_TaxPercent().getAttribute("value");
                            }
                            taxfreePercent = searchPageObj.UK_Standard_TaxPercent().getAttribute("value");
                            System.out.println("Tax percent retrieved" + taxPercent);
                            System.out.println("Default  tax retrieved" + taxfreePercent);
                            break;
                        case "region":
                            System.out.println("Inside the region");
                            if (strEventType.equalsIgnoreCase("uk standard travel")) {
                                taxRegion = searchPageObj.UK_TaxRegion().getAttribute("value");
                                taxRegionCollect = taxRegion.split("\\,");
                                taxRegion = taxRegionCollect[0];
                            } else if (strEventType.equalsIgnoreCase("iom")) {
                                System.out.println("Inside IOM tax region");
                                taxRegion = searchPageObj.IOM_TaxRegion().getAttribute("value");
                                taxRegionCollect = taxRegion.split("\\,");
                                taxRegion = taxRegionCollect[0];
                            } else if (strEventType.equalsIgnoreCase("channel isles")) {
                                System.out.println("Inside channel isles tax region");
                                taxRegion = searchPageObj.channel_TaxRegion().getAttribute("value");
                                taxRegionCollect = taxRegion.split("\\,");
                                taxRegion = taxRegionCollect[0];
                            } else if (strEventType.equalsIgnoreCase("uk tax free travel")) {
                                System.out.println("Inside UK tax free tax region");
                                taxRegion = searchPageObj.ukTaxFree_TaxRegion().getAttribute("value");
                                taxRegionCollect = taxRegion.split("\\,");
                                taxRegion = taxRegionCollect[0];
                            }
                            System.out.println("Tax region going to enter" + taxRegion);
                            break;
                        case "action":
                            System.out.println("Closing window");
                            searchPageObj.closeWindowIPT();
                            searchPageObj.closeWindowIPT().click();
                            break;
                        case "from date":
                            if (strEventType.equalsIgnoreCase("uk standard travel")) {
                                fromDate = searchPageObj.UK_TaxRegionFromDate().getAttribute("value");
                                System.out.println("From date of UK" + fromDate);
                            } else if (strEventType.equalsIgnoreCase("channel isles")) {
                                fromDate = searchPageObj.channelIsles_TaxRegionFromDate().getAttribute("value");
                                System.out.println("From date of channel isles" + fromDate);
                            } else if (strEventType.equalsIgnoreCase("iom")) {
                                fromDate = searchPageObj.channelIsles_TaxRegionFromDate().getAttribute("value");
                                System.out.println("From date of iom" + fromDate);
                            } else if (strEventType.equalsIgnoreCase("uk tax free travel")) {
                                fromDate = searchPageObj.UK_TaxfFreeRegionFromDate().getAttribute("value");
                                System.out.println("From date of uk tax free travel" + fromDate);
                            }
                            break;
                        case "to date":
                            if (strEventType.equalsIgnoreCase("uk standard travel")) {
                                toDate = searchPageObj.UK_TaxRegionToDate().getAttribute("value");
                                System.out.println("To date of UK" + toDate);
                            } else if (strEventType.equalsIgnoreCase("channel isles")) {
                                toDate = searchPageObj.channelIsles_TaxRegionToDate().getAttribute("value");
                                System.out.println("To date of channel isles" + toDate);
                            } else if (strEventType.equalsIgnoreCase("iom")) {
                                toDate = searchPageObj.iom_TaxRegionToDate().getAttribute("value");
                                System.out.println("To date of iom" + toDate);
                            } else if (strEventType.equalsIgnoreCase("uk tax free travel")) {
                                toDate = searchPageObj.UK_TaxFreeRegionToDate().getAttribute("value");
                                System.out.println("To date of iom" + toDate);
                            }
                            break;
                        case "validate":
                            System.out.println("Tax percent" + taxPercent);
                            quoteAndBuyOperationsObj.validateIPTAmountInIPTtab(taxEntered, taxPercent);
                            break;
                    }
                }
            }
        }
    }

    public void validateDocumentPreferencesInCommTab(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "comm preference":
                    System.out.println("Inside Comm preference---" + searchValue);
                    this.commPreference(searchValue);
                    break;
                case "com actual":
                    System.out.println("Inside actual preference" + searchValue);
                    this.commActual(searchValue);
                    break;
            }
        }
    }

    public void commPreference(String str) {
        searchPageObj.ComPreferences_DefaultValue(str);
        System.out.println("Check in com tab:" + searchPageObj.ComPreferences_DefaultValue(str).getAttribute("checked"));
        Assert.assertTrue(searchPageObj.ComPreferences_DefaultValue(str).getAttribute("checked").equalsIgnoreCase("true"));
        System.out.println("Verified com preference value");
    }

    public void commActual(String str) {
        searchPageObj.ComActual_DefaultValue();
        Assert.assertTrue(searchPageObj.ComActual_DefaultValue().getAttribute("value").equalsIgnoreCase(str));
        System.out.println("Verified com preference value");
    }

    public void addCustomerCommunicationDetails(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "customer phnotype1":
                    System.out.println("Inside Phone Type1");
                    this.selectPhoneType1(searchValue);
                    break;
                case "customer phnotype2":
                    System.out.println("Inside Phone Type2");
                    this.selectPhoneType2(searchValue);
                    break;
                case "phno1":
                    System.out.println("Inside phone number1");
                    this.enterPhoneNumber1(searchValue);
                    break;
                case "phno2":
                    System.out.println("Inside Phone number2");
                    this.enterPhoneNumber2(searchValue);
                    break;
                case "dob":
                    System.out.println("DOB");
                    this.enterCustomerDOB(searchValue);
                    break;
                case "addressType":
                    System.out.println("addressType");
                    this.selectAddresstype(searchValue);
                    break;
                case "action":
                    System.out.println("Inside action");
                    this.save();
                    break;
                case "com preference":
                    System.out.println("Select Communication preference in Helper fields");
                    this.selectCommPreferenceInHelperFields(searchValue);
                    break;
            }
        }
    }

    public void enterPhoneNumber1(String phno) {
        searchPageObj.enterTelephoneNumberType1().clear();
        if (!phno.equalsIgnoreCase(strNoValueEntryString) && !phno.isEmpty() && phno != null) {
            searchPageObj.enterTelephoneNumberType1().sendKeys(phno);
        }
    }

    public void enterPhoneNumber2(String phno) {
        searchPageObj.enterTelephoneNumberType2().clear();
        if (!phno.equalsIgnoreCase(strNoValueEntryString) && !phno.isEmpty() && phno != null) {
            searchPageObj.enterTelephoneNumberType2().sendKeys(phno);
        }
    }

    public void selectPhoneType1(String phtype1) {
        policyDataFieldsPageObj.tele1Pref().click();
        policyDataFieldsPageObj.tele1PrefOption(phtype1).click();
    }

    public void selectPhoneType2(String phtype2) {
        policyDataFieldsPageObj.tele2Pref().click();
        policyDataFieldsPageObj.tele2PrefOption(phtype2).click();
    }

    public void selectAddresstype(String strAddressType) {
        policyDataFieldsPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.addressType().click();
        policyDataFieldsPageObj.addressTypeValue(strAddressType).click();
    }

    public void enterCustomerDOB(String searchValue) {
        searchPageObj.Customerdob().clear();
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            searchPageObj.Customerdob().sendKeys(searchValue);
        }
    }

    public void selectCommPreferenceInHelperFields(String pref) {
        if (pref.equalsIgnoreCase("Letter")) {
            System.out.println("Select comm preference as Letter");
            if (searchPageObj.verifyCommPreferenceAsEmail().getAttribute("value").equalsIgnoreCase("True")) {
                System.out.println("Inside email uncheck");
                searchPageObj.selectCommPreferenceAsEmail().click();
            }
            if (searchPageObj.verifyCommPreferenceAsSMS().getAttribute("value").equalsIgnoreCase("True")) {
                System.out.println("Inside SMS uncheck");
                searchPageObj.selectCommPreferenceAsSMS().click();
            }
            if (searchPageObj.verifyCommPreferenceAsLetter().getAttribute("value").equalsIgnoreCase("False")) {
                System.out.println("Inside Letter check");
                searchPageObj.selectCommPreferenceAsLetter().click();
            }
        } else if (pref.equalsIgnoreCase("SMS")) {
            System.out.println("Select comm preference as SMS");
            if (searchPageObj.verifyCommPreferenceAsEmail().getAttribute("value").equalsIgnoreCase("True")) {
                System.out.println("Inside email uncheck");
                searchPageObj.selectCommPreferenceAsEmail().click();
            }
            if (searchPageObj.verifyCommPreferenceAsSMS().getAttribute("value").equalsIgnoreCase("False")) {
                System.out.println("Inside SMS check");
                searchPageObj.selectCommPreferenceAsSMS().click();
            }
            if (searchPageObj.verifyCommPreferenceAsLetter().getAttribute("value").equalsIgnoreCase("False")) {
                System.out.println("Inside Letter check");
                searchPageObj.selectCommPreferenceAsLetter().click();
            }
        }
    }

    public void addJointHoldersCommunicationDetails(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "joint1 phnotype":
                    System.out.println("Inside Joint1 Phone Type");
                    this.selectJoint1PhoneType(searchValue);
                    break;
                case "joint2 phnotype":
                    System.out.println("Inside Joint2 Phone Type");
                    this.selectJoint2PhoneType(searchValue);
                    break;
                case "joint1 phno":
                    System.out.println("Inside Joint1 phone number");
                    this.enterJoint1PhoneNumber(searchValue);
                    break;
                case "joint2 phno":
                    System.out.println("Inside Joint2 Phone number");
                    this.enterJoint2PhoneNumber(searchValue);
                    break;
                case "date of birth":
                    System.out.println("DOB");
                    this.enterJointHolderDOB(searchValue);
                    break;
                case "action":
                    System.out.println("Inside action");
                    this.save();
                    break;
                case "com preference":
                    System.out.println("Select Communication preference in Helper fields");
                    this.selectCommPreferenceInHelperFields(searchValue);
                    break;
            }
        }
    }

    public void enterJoint1PhoneNumber(String phno) {
        searchPageObj.enterTelephoneNumberType_Joint1().clear();
        if (!phno.equalsIgnoreCase(strNoValueEntryString) && !phno.isEmpty() && phno != null) {
            searchPageObj.enterTelephoneNumberType_Joint1().sendKeys(phno);
        }
    }

    public void enterJoint2PhoneNumber(String phno) {
        searchPageObj.enterTelephoneNumberType_Joint2().clear();
        if (!phno.equalsIgnoreCase(strNoValueEntryString) && !phno.isEmpty() && phno != null) {
            searchPageObj.enterTelephoneNumberType_Joint2().sendKeys(phno);
        }
    }

    public void selectJoint1PhoneType(String phtype1) {
        if (phtype1.equalsIgnoreCase("Home")) {
            System.out.println("Select phno type1");
            searchPageObj.telephoneNumberType_Joint1Img();
            searchPageObj.telephoneNumberType_Joint1Img().click();
            System.out.println("select inside type1");
            nextEventPageObj.waitForMoreTime();
            searchPageObj.telephoneNumberType_Joint1_SelectHome();
            searchPageObj.telephoneNumberType_Joint1_SelectHome().click();
            System.out.println("Slected pnone type1 option");
        }
    }

    public void selectJoint2PhoneType(String phtype2) {
        if (phtype2.equalsIgnoreCase("Home")) {
            System.out.println("Select phno type2");
            searchPageObj.telephoneNumberType_Joint2Img();
            searchPageObj.telephoneNumberType_Joint2Img().click();
            System.out.println("select inside type2");
            nextEventPageObj.waitForMoreTime();
            searchPageObj.telephoneNumberType_Joint2_SelectHome();
            searchPageObj.telephoneNumberType_Joint2_SelectHome().click();
        }
    }

    public void enterJointHolderDOB(String searchValue) {
        searchPageObj.jointHolderdob().clear();
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            searchPageObj.jointHolderdob().sendKeys(searchValue);
        }
    }

    public void addressLookUp(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "post code":
                    System.out.println("Inside post code");
                    this.enterPostCode(searchValue);
                    break;
                case "action":
                    System.out.println("Inside action");
                    nextEventPageObj.waitForMoreTime();
                    this.save();
                    break;
                case "anotheraction":
                    System.out.println("Inside  another action");
                    nextEventPageObj.waitForMoreTime();
                    this.cancel();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    break;
                case "addresstype":
                    this.selectAddresstype(searchValue);
                    break;
                case "address1":
                    policyDataFieldsPageObj.addressLookUp().sendKeys(searchValue);
                    break;
            }
        }
    }

    public void cancel() {
        if (searchPageObj.cancel().isDisplayed()) {
            searchPageObj.cancel();
            searchPageObj.cancel().click();
        }
    }

    public void enterPostCode(String postcode) {
        searchPageObj.enterPostcodeInAddressLookUp().clear();
        if (!postcode.equalsIgnoreCase(strNoValueEntryString) && !postcode.isEmpty() && postcode != null) {
            searchPageObj.enterPostcodeInAddressLookUp().sendKeys(postcode);
        }
        searchPageObj.findAddressBtn();
        searchPageObj.findAddressBtn().click();
    }

    public void toSelectAddressFromAddressLookUp() {
        searchPageObj.pickAddressbtn();
        List<WebElement> lstOptions = new Select(searchPageObj.addressLookUpselect()).getOptions();
        new Select(searchPageObj.addressLookUpselect()).selectByIndex((lstOptions.size() - 1));
        searchPageObj.pickAddressbtn().click();
        nextEventPageObj.waitForMoreTime();
        this.save();
    }

    public void validateErrorMessage(String errMessage) {
        Assert.assertTrue(searchPageObj.validateErrMessageInAddressLookUp().getText().contains(errMessage));
    }

    public void enterAddress(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "customer address1":
                    System.out.println("Inside customer address1");
                    this.enterCustomerAddress1(searchValue);
                    break;
                case "customer address2":
                    System.out.println("Inside customer address2");
                    this.enterCustomerAddress2(searchValue);
                    break;
                case "customer town":
                    System.out.println("Inside customer town");
                    this.enterCustomerTown(searchValue);
                    break;
                case "customer country":
                    System.out.println("Inside customer country");
                    this.enterCustomerCountry(searchValue);
                    break;
                case "customer postcode":
                    System.out.println("Inside customer postcode");
                    this.enterCustomerPostCode(searchValue);
                    break;
                case "action":
                    System.out.println("Inside action");
                    nextEventPageObj.waitForMoreTime();
                    this.save();
                    break;
            }
        }
    }

    public void enterCustomerAddress1(String str) {
        searchPageObj.customerAddress1().clear();
        if (!str.equalsIgnoreCase(strNoValueEntryString) && !str.isEmpty() && str != null) {
            searchPageObj.customerAddress1().sendKeys(str);
        }
    }

    public void enterCustomerAddress2(String str) {
        searchPageObj.customerAddress2().clear();
        if (!str.equalsIgnoreCase(strNoValueEntryString) && !str.isEmpty() && str != null) {
            searchPageObj.customerAddress2().sendKeys(str);
        }
    }

    public void enterCustomerCountry(String str) {
        searchPageObj.customerCountry().clear();
        if (!str.equalsIgnoreCase(strNoValueEntryString) && !str.isEmpty() && str != null) {
            searchPageObj.customerCountry().sendKeys(str);
        }
    }

    public void enterCustomerTown(String str) {
        searchPageObj.customerTown().clear();
        if (!str.equalsIgnoreCase(strNoValueEntryString) && !str.isEmpty() && str != null) {
            searchPageObj.customerTown().sendKeys(str);
        }
    }

    public void enterCustomerPostCode(String str) {
        searchPageObj.customerPostcode().clear();
        if (!str.equalsIgnoreCase(strNoValueEntryString) && !str.isEmpty() && str != null) {
            searchPageObj.customerPostcode().sendKeys(str);
        }
    }

    public void productTypeVerification(String searchField) throws Throwable {
        if (!searchField.equalsIgnoreCase(strNoValueEntryString) && !searchField.isEmpty() && searchField != null) {
            switch (searchField.toLowerCase()) {
                case "brand":
                    System.out.println("********** Brand  **************");
                    polSummObj.productName();
                    System.out.println("Brand Name======>" + polSummObj.productName().getText());
                    break;
                case "type":
                    System.out.println("********** Product Type **************");
                    polSummObj.productType();
                    System.out.println("Product Type=====>" + polSummObj.productType().getText());
                    break;
            }
        }
    }

    public void navigateToschemeDeatils() {
        polSummObj.productType();
        polSummObj.productType().click();
        commonPage.switchToFrameById(commonPage.fancyFrame());
        schemeSummaryPageObj.limitAndAccessTab();
        schemeSummaryPageObj.limitAndAccessTab().click();
    }

    public void generalProductVerification(String searchField) throws Throwable {
        if (!searchField.equalsIgnoreCase(strNoValueEntryString) && !searchField.isEmpty() && searchField != null) {
            switch (searchField.toLowerCase()) {
                case "insured persons":
                    System.out.println("********** Verifying Applicable insured Persons  **************");
                    Assert.assertTrue(schemeSummaryPageObj.productDetailsVerification(searchField).isDisplayed());
                    break;
                case "residency requirement":
                    System.out.println("********** Verifying residency restrictions **************");
                    Assert.assertTrue(schemeSummaryPageObj.productDetailsVerification(searchField).isDisplayed());
                    break;
                case "age limit":
                    System.out.println("********** Verifying maximum age **************");
                    Assert.assertTrue(schemeSummaryPageObj.productDetailsVerification(searchField).isDisplayed());
                    break;
                case "geographical limit":
                    System.out.println("********** Verifying Geographical Limits **************");
                    Assert.assertTrue(schemeSummaryPageObj.productDetailsVerification(searchField).isDisplayed());
                    break;
                case "upgrades available":
                    System.out.println("********** Verifying Available Upgrades **************");
                    schemeSummaryPageObj.upgradeTab().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    Assert.assertTrue(schemeSummaryPageObj.productDetailsVerification(searchField).isDisplayed());
                    break;
                case "maximum trip length":
                    System.out.println("********** Verifying Trip Length **************");
                    Assert.assertTrue(schemeSummaryPageObj.productDetailsVerification(searchField).isDisplayed());
                    break;
            }
        }
    }

    public void createNewClientRecord() throws InterruptedException {
        searchPageObj.btnClick(searchPageObj.createNewCustomer());
    }

    public void validateDropdownContainsDefaultValue() {
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame()); //switch to frame
        searchPageObj.jointAccountDropDown();
        Assert.assertTrue(searchPageObj.jointAccountDropDown().getAttribute("value").equalsIgnoreCase(defaultValue));
        System.out.println("Verified Joint Account Holder Dropdown default value");
        searchPageObj.existingPackageDropDown();
        Assert.assertTrue(searchPageObj.existingPackageDropDown().getAttribute("value").equalsIgnoreCase(defaultValue));
        System.out.println("Verified existing package Dropdown default value");
        nextEventPageObj.switchToDefault();
    }

    public void createClientRecord(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "account":
                    System.out.println("Inside account");
                    this.enterAccountNumber(searchValue);
                    break;
                case "sort code":
                    System.out.println("Inside sort code");
                    this.enterSortCode(searchValue);
                    break;
                case "bank name":
                    System.out.println("Inside account");
                    this.enterBankName(searchValue);
                    break;
                case "expiry date":
                    System.out.println("Inside account");
                    this.enterExpiryDate(searchValue);
                    break;
                case "action":
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    System.out.println("Inside action");
                    this.save();
                    break;
                case "validate":
                    System.out.println("Validate title dropdown");
                    this.title();
                    break;
                case "existing package":
                    System.out.println("Inside existing package");
                    this.existingPackageDropDown(searchValue);
                    break;
                case "select account":
                    System.out.println("Inside Select Account");
                    this.selectAccount(searchValue);
                    break;
                case "cover":
//                    System.out.println("Inside Cover");
//                    this.selectCover(searchValue);
//                    break;
                case "title":
                    System.out.println("Inside Title");
                    this.selectTitle(searchValue);
                    break;
                case "first name":
                    System.out.println("Firstname");
                    this.enterJointHolderFirstName(searchValue);
                    break;
                case "last name":
                    System.out.println("lastname");
                    this.enterJointHolderLastName(searchValue);
                    break;
                case "date of birth":
                    System.out.println("DOB");
                    this.enterJointHolderDOB(searchValue);
                    break;
                case "joint account":
                    System.out.println("Joint account");
                    this.selectJointAccount(searchValue);
                    break;
            }
        }
    }

    public void enterAccountNumber(String acctNum) {
        searchPageObj.enterAccountNumber().clear();
        if (!acctNum.equalsIgnoreCase(strNoValueEntryString) && !acctNum.isEmpty() && acctNum != null) {
            searchPageObj.enterAccountNumber().sendKeys(acctNum);
        }
    }

    public void enterSortCode(String sortCode) {
        searchPageObj.enterSortCode().clear();
        if (!sortCode.equalsIgnoreCase(strNoValueEntryString) && !sortCode.isEmpty() && sortCode != null) {
            searchPageObj.enterSortCode().sendKeys(sortCode);
        }
    }

    public void enterBankName(String bankName) {
        searchPageObj.enterBankName().clear();
        if (!bankName.equalsIgnoreCase(strNoValueEntryString) && !bankName.isEmpty() && bankName != null) {
            searchPageObj.enterBankName().sendKeys(bankName);
        }
    }

    public void enterExpiryDate(String expiryDate) {
        searchPageObj.enterExpiryDate().clear();
        if (!expiryDate.equalsIgnoreCase(strNoValueEntryString) && !expiryDate.isEmpty() && expiryDate != null) {
            searchPageObj.enterExpiryDate().sendKeys(expiryDate);
        }
    }

    public void selectJointAccount(String searchValue) {
        searchPageObj.jointAccountDropDown().click();
        if (searchValue.equalsIgnoreCase("yes")) {
            searchPageObj.jointAccountDropDown_Yes().click();
            System.out.println("joint Account Dropdown selected-Yes");
        }
        if (searchValue.equalsIgnoreCase("no")) {
            searchPageObj.jointAccountDropDown_No().click();
            System.out.println("joint Account Dropdown selected-No");
        }
    }

    public void existingPackageDropDown(String searchValue) {
        searchPageObj.existingPackageDropDown().click();
        if (searchValue.equalsIgnoreCase("yes")) {
            searchPageObj.existingPackageDropDown_Yes().click();
            System.out.println("Existing Package Dropdown selected-Yes");
        }
        if (searchValue.equalsIgnoreCase("no")) {
            searchPageObj.existingPackageDropDown_No().click();
            System.out.println("Existing Package Dropdown selected-No");
        }
    }

    public void selectAccount(String searchValue) {
        /* System.out.println("select account");
        policyDataFieldsPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.clickAccount());
        policyDataFieldsPageObj.switchToFrameById(policyDataFieldsPageObj.policyFrame());
        String strInputProductType = searchValue;
        String strProductTypeToSelect = strInputProductType;
        if (System.getProperty("brand") != null && !System.getProperty("brand").toLowerCase().contains(fileOperationsOObj.getCommonProperties("NoLogicBrand").toLowerCase())) {
            if (!strInputProductType.endsWith("Account") && !strInputProductType.endsWith("Cover")) {
                strProductTypeToSelect = fileOperationsOObj.getCommonProperties(System.getProperty("brand") + strInputProductType + "Product");
            }
        }
        policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.selectAccount(strProductTypeToSelect, brandName));
        policyDataFieldsPageObj.switchToDefault();
        policyDataFieldsPageObj.waitForMoreTime();
        policyDataFieldsPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());*/
        if (System.getProperty("brand") != null && !System.getProperty("brand").toLowerCase().contains(fileOperationsOObj.getCommonProperties("NoLogicBrand").toLowerCase())) {
            if(System.getProperty("account") !=null){
                System.out.println("inside account if - "+System.getProperty("account"));
                searchValue =fileOperationsOObj.getCommonProperties(System.getProperty("account"));
            }
            System.out.println("outside account if strInputProductType    ----- "+searchValue);
        }
        policyDataFieldsPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        if (searchValue.contains("Cover") || searchValue.contains("Account")) {
            System.out.println("strProductTypeToSelect---------inside split------" + searchValue);
            searchValue = searchValue.split(" ")[0];
            System.out.println("strProductTypeToSelect---------after split------" + searchValue);
        }
        String brandName = PerformSearch.brandName;
        if (PerformSearch.brandName.equals("NatWest")) {
            brandName = "Natwest";
        } else if (PerformSearch.brandName.equals("Royal Bank of Scotland")) {
            brandName = "RBS";
        } else if (PerformSearch.brandName.equals("Ulster Bank")) {
            brandName = "Ulster";
        } else if (PerformSearch.brandName.equals("Nationwide Building Society")) {
            brandName = "Nationwide";
        }
        String basePolicyType = String.format("%s %s", brandName, searchValue);
        System.out.println("product type-------------------" + basePolicyType);
        policyDataFieldsPageObj.basePolicyType().click();
        policyDataFieldsPageObj.basePolicyOption(basePolicyType).click();
        policyDataFieldsPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
    }

    public void selectCover(String searchValue) {
        searchPageObj.selectCover().click();
        System.out.println("Search value" + searchValue);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToFrameById(nextEventPageObj.accountSelectionFrame());
        searchPageObj.selectSilverCover(searchValue).click();
        System.out.println("Silver Cover has been selected");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
    }

    public void title() {
        searchPageObj.titleValidation();
        Assert.assertTrue(searchPageObj.titleValidation().getText().equalsIgnoreCase("Baron"));
    }

    public void selectTitle(String title) {
        new Select(searchPageObj.title()).selectByVisibleText(title);
    }

    public void enterJointHolderFirstName(String searchValue) {
        searchPageObj.jointHolderFirstName().clear();
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null && !searchValue.equalsIgnoreCase("Random")) {
            searchPageObj.jointHolderFirstName().sendKeys(searchValue);
        } else if (searchValue.equalsIgnoreCase("random")) {
            searchValue = randomGeneratorObj.randomString(4);
            searchPageObj.jointHolderFirstName().sendKeys(searchValue);
        }
    }

    public void enterJointHolderLastName(String searchValue) {
        searchPageObj.jointHolderLastName().clear();
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            searchPageObj.jointHolderLastName().sendKeys(searchValue);
        }
    }

    public void validateJointAccountHolderDropdownContainsDefaultValue() {
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame()); //switch to frame
        nextEventPageObj.switchToDefault();
    }

    public void validateDocumentPreferences(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "comms":
                    System.out.println("Inside Comms preference");
                    this.validateComms(searchValue);
                    break;
                case "document":
                    System.out.println("Inside Document preference");
                    this.validateDocument(searchValue);
                    break;
            }
        }
    }

    public void validateComms(String str) {
        accountInformationPageObj.comms();
        Assert.assertTrue(accountInformationPageObj.comms().getText().equalsIgnoreCase(str));
        System.out.println("Verified com preference value in Account Info page");
    }

    public void validateDocument(String str) {
        accountInformationPageObj.document();
        Assert.assertTrue(accountInformationPageObj.document().getText().equalsIgnoreCase(str));
        System.out.println("Verified Document preference value in Account Info page");
    }

    public void validateNonUKResident() {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.policySave().click();
        policyDataFieldsPageObj.newProductClose().click();
        nextEventPageObj.switchToDefault();
        policyDataFieldsPageObj.newProductClose().click();
        nextEventPageObj.switchToDefault();
    }

    public void nonUKResident(List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                String searchField = parameters.get(0).get(column);
                String searchValue = parameters.get(row).get(column);
                new Select(policyDataFieldsPageObj.postCodeDropdown()).selectByVisibleText(searchField);
                policyDataFieldsPageObj.next().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                policyDataFieldsPageObj.postcodeMandatoryFieldImg().click();
                if (searchValue.equalsIgnoreCase("No")) {
                    policyDataFieldsPageObj.postcodeMandatoryFieldValueNo().click();
                } else if (searchValue.equalsIgnoreCase("Yes")) {
                    policyDataFieldsPageObj.postcodeMandatoryFieldValueYes().click();
                }
                policyDataFieldsPageObj.policySave().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
            }
        }
        policyDataFieldsPageObj.next().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
    }

    public void validateIPTAmountAgainstRegion() {
        System.out.println("Tax percent for UK retrieved from IPT:" + this.taxPercent);
        String[] taxPercent = this.taxPercent.split("\\.");
        System.out.println("Size after tax percent split" + taxPercent.length);
        int tax = Integer.parseInt(taxPercent[0]);
        System.out.println("Actual tax amount retrieved" + tax);
        System.out.println("total cost retrieved for UK retrieved from IPT:" + this.taxPercent);
        String totalCost = quoteDetailsPageObj.totalCostExcludingIPT().getText();
        String[] amount = totalCost.split("\\£");
        String[] Org_amount = amount[1].split("\\.");
        int actualAmount = Integer.parseInt(Org_amount[0]);
        System.out.println("After split the amount" + actualAmount);
        int IPTEstimate = (actualAmount * tax) / 100;
        String[] IPT = quoteDetailsPageObj.IPTAmount().getText().split("\\£|\\.");
        int actualIP = Integer.parseInt(IPT[1]);
        System.out.println("IPT Estimate" + IPTEstimate);
        System.out.println("Actual Estimate" + actualIP);
        if (IPTEstimate == actualIP) {
            System.out.println("Validated IPT calculated as per the region selection");
        }
        Assert.assertTrue(Integer.toString(IPTEstimate).equalsIgnoreCase(Integer.toString(actualIP)));
    }

    public void validateIPTAmountAgainstEffectiveDate() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
            Date date = new Date();
            String currentDate = dateFormat.format(date);
            System.out.println(currentDate);
            Date d1 = sdf.parse(this.fromDate);
            Date d2 = sdf.parse(currentDate);
            Date d3 = sdf.parse(this.toDate);
            if (d2.compareTo(d1) >= 0) {
                if (d2.compareTo(d3) <= 0) {
                    System.out.println("d2 is in between d1 and d2");
                    this.validateIPTAmountAgainstRegion();
                } else {
                    System.out.println("d2 is NOT in between d1 and d2");
                    this.validateDefaultIPTAmountAgainstRegion();
                }
            } else {
                System.out.println("d2 is NOT in between d1 and d2");
                this.validateDefaultIPTAmountAgainstRegion();
            }
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    public void validateDefaultIPTAmountAgainstRegion() {
        System.out.println("Tax percent for UK Tax free region:" + this.taxfreePercent);
        String[] taxPercent = this.taxfreePercent.split("\\.");
        System.out.println("Size after tax percent split" + taxPercent.length);
        int tax = Integer.parseInt(taxPercent[0]);
        System.out.println("Actual tax amount retrieved" + tax);
        String totalCost = quoteDetailsPageObj.totalCostExcludingIPT().getText();
        String[] amount = totalCost.split("\\£");
        String[] Org_amount = amount[1].split("\\.");
        int actualAmount = Integer.parseInt(Org_amount[0]);
        System.out.println("After split the amount" + actualAmount);
        int IPTEstimate = (actualAmount * tax) / 100;
        String[] IPT = quoteDetailsPageObj.IPTAmount().getText().split("\\£|\\.");
        int actualIP = Integer.parseInt(IPT[1]);
        if (IPTEstimate == actualIP) {
            System.out.println("Validated IPT calculated as per the region selection");
        }
        Assert.assertTrue(Integer.toString(IPTEstimate).equalsIgnoreCase(Integer.toString(actualIP)));
    }

    public void validateIPTAmountRoundoff() {
        System.out.println("Tax percent for retrieved from IPT:" + this.taxEntered);
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);
        NumberFormat nf1 = NumberFormat.getNumberInstance();
        nf1.setMaximumFractionDigits(1);
        nf1.setMinimumFractionDigits(1);
        double tax1 = Double.parseDouble(this.taxEntered);
        System.out.println("x = + " + nf.format(tax1));
        String tax = nf.format(tax1);
        System.out.println("Tax percent after system round off" + tax);
        double taxpercent = Double.parseDouble(tax);
        System.out.println("Tax percent after round off" + taxpercent);
        String totalCost = quoteDetailsPageObj.totalCostExcludingIPT().getText();
        String[] amount = totalCost.split("\\£");
        String[] Org_amount = amount[1].split("\\.");
        double actualAmount = Double.parseDouble(Org_amount[0]);
        System.out.println("After split the amount" + actualAmount);
        double IPTEstimate = (actualAmount * taxpercent) / 100;
        String[] IPT = quoteDetailsPageObj.IPTAmount().getText().split("\\£");
        double actualIP = Double.parseDouble(IPT[1]);
        System.out.println("IPT Estimate" + IPTEstimate);
        System.out.println("Actaul IPT " + actualIP);
        String iptEstimateConverted = nf1.format(IPTEstimate);
        System.out.println("iptEstimateConverted" + iptEstimateConverted);
        String actualiptEstimateConverted = nf1.format(actualIP);
        System.out.println("actualiptEstimateConverted" + actualiptEstimateConverted);
        if (IPTEstimate == actualIP) {
            System.out.println("Validated IPT calculated as per the region selection");
        }
        Assert.assertTrue(iptEstimateConverted.equalsIgnoreCase(actualiptEstimateConverted));
    }

    public void enterPostcodeInLookup(List<List<String>> parameters) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame()); //switch to frame
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                try {
                    this.addressLookUpfornonukadress(parameters.get(0).get(column), parameters.get(row).get(column));
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }
    }

    public void selectValueFromEventDropdown(List<List<String>> lstInputs) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("came to NONUK drop down start");
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                switch (lstInputs.get(0).get(j).toLowerCase()) {
                    case "event type":
                        new org.openqa.selenium.support.ui.Select(searchPageObj.eventtypeDropdown()).selectByVisibleText(lstInputs.get(i).get(j));
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        System.out.println("came NON UK ");
                        break;
                }
            }
        }
        searchPageObj.next().click();
    }

    public void enterDetailsToCompleteChaseEvent(List<List<String>> parameters) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame()); //switch to frame
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                try {
                    this.chaseeventdetails(parameters.get(0).get(column), parameters.get(row).get(column));
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }
    }

    public void selectDetailsToStopChase(List<List<String>> parameters) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame()); //switch to frame
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                try {
                    this.stopchaseeventdetails(parameters.get(0).get(column), parameters.get(row).get(column));
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }
    }

    public void navigateToParticularId(String searchCriteria) {
        new Select(searchPageObj.quickSearchDropdown()).selectByVisibleText(searchCriteria);
        searchPageObj.searchForInput().sendKeys(supplierOperationsObj.matterId);
        searchPageObj.searchButtonInQuickSearch().click();
        supplierOperationsObj.verifyingPaidInvoice();
    }

    public void retrievingTheMatterId(String searchCriteria) {
        if (leftNavPaneObj.leadManager().isDisplayed()) {
            navigationObj.navigateToLeadManager();
        }
        String supplierBusinessName = supplierOperationsObj.returnSupplierRandomName();
        String searchParameter = "Business name";
        if (searchCriteria.contains("-")) {
            searchParameter = searchCriteria.split("-")[0];
            supplierBusinessName = searchCriteria.split("-")[1];
            System.out.println("business name -------------------+++++++++++++00000000000000"+supplierBusinessName);
        }
        System.out.println("supplierOperationsObj.returnSupplierRandomName()--------------------------" + supplierOperationsObj.returnSupplierRandomName());
        if (searchCriteria.equalsIgnoreCase("Matter id")){
            new Select(searchPageObj.quickSearchDropdown()).selectByVisibleText(searchParameter);
            searchPageObj.searchForInput().sendKeys(supplierOperationsObj.matterId);
        }
        else if (searchParameter.equalsIgnoreCase("Business name")){
            new Select(searchPageObj.quickSearchDropdown()).selectByVisibleText(searchParameter);
            searchPageObj.searchForInput().sendKeys(supplierBusinessName);
        }else if (searchParameter.equalsIgnoreCase("Claim id")){
            new Select(searchPageObj.quickSearchDropdown()).selectByVisibleText("Matter ID");
            searchPageObj.searchForInput().sendKeys(ClaimsOperations.claimID);
        }
        searchPageObj.searchButtonInQuickSearch().click();
        searchPageObj.firstRecordInSearch().click();
        nextEventPageObj.switchToLastOpenWindow();
    }

    public void retrievingTheMatterId(String searchCriteria, String matterId) {
        System.out.println("Matter id------------------- " + matterId);
        navigationObj.navigateToLeadManager();
        new Select(searchPageObj.quickSearchDropdown()).selectByVisibleText(searchCriteria);
        searchPageObj.searchForInput().sendKeys(matterId);
        searchPageObj.searchButtonInQuickSearch().click();
    }

    public void retrieveSupplier(String supplierId) {
        new Select(searchPageObj.quickSearchDropdown()).selectByVisibleText("Matter ID");
        searchPageObj.searchForInput().sendKeys(supplierId);
        searchPageObj.searchButtonInQuickSearch().click();
        nextEventPageObj.waitForMoreTime();
        String strContinue = "Yes";
        int i = 0;
        do {
            i++;
            if (searchPageObj.viewCustomerLinkInSearchResultTableForSupplierIsDisplayed()) {
                System.out.println("example----------------------------");
                searchPageObj.firstRecordInSearch().click();
                commandsObj.waitForLoad(nextEventPageObj.getDriver);
                commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
                nextEventPageObj.switchToLastOpenWindow();
                break;
            }
            if (polSummObj.customerDetailsTabIsDisplayed()) {
                commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
                break;
            }
            if (polSummObj.isErrorPageDisplayed()) {
                break;
            }
            if (i > 100) {
                break;
            }
        } while (strContinue.equalsIgnoreCase("Yes"));
    }

    public void validateClientRecord() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(searchPageObj.viewCustomerLinkInSearchResultTableIsDisplayed());
    }

    public void navigateToSearchCriteria() {
        navigationObj.navigateToImenu();
        navigationObj.navigateToSearchScreen();
    }

    public void searchWithMentionedCriteria(String searchCriterias) {
        for (int i = 0; i < searchCriterias.split("#").length; i++) {
            switch (searchCriterias.split("#")[i].toLowerCase()) {
                case "brand":
                    String brand = iReportingOperationsObj.uniqueFileText;
                    String fieldValue = brand.substring(0, brand.length() - 2);
                    System.out.println("Brand --------" + fieldValue);
                    if (fieldValue.equalsIgnoreCase("RBSPCKGMBR")) {
                        new Select(searchPageObj.brand()).selectByVisibleText("Royal Bank of Scotland");
                    } else if (fieldValue.equalsIgnoreCase("NATPCKGMBR")) {
                        new Select(searchPageObj.brand()).selectByVisibleText("NatWest");
                    }
                    break;
                case "forename":
                    System.out.println("First name -----------" + iReportingOperationsObj.primaryMemberFirstName);
                    this.enterFirstName(iReportingOperationsObj.primaryMemberFirstName);
                    break;
                case "surname":
                    System.out.println("Last name -----------" + iReportingOperationsObj.primaryMemberLastName);
                    this.enterSurname(iReportingOperationsObj.primaryMemberLastName);
                    break;
                case "postcode":
                    System.out.println("postcode---------------------" + iReportingOperationsObj.mailingAddressPostCode);
                    this.enterRiskPostCode(iReportingOperationsObj.mailingAddressPostCode);
                    break;
                case "dob":
                    System.out.println("postcode---------------------" + iReportingOperationsObj.primaryMemberDOB);
                    this.enterDOB(iReportingOperationsObj.primaryMemberDOB);
                    break;
                case "email address":
                    System.out.println("postcode---------------------" + iReportingOperationsObj.mailingAddressPostCode);
                    this.enterEmail(iReportingOperationsObj.mailingAddressPostCode);
                    break;
                case "policynumber":
                    this.enterPolicyNumber(iReportingOperationsObj.policyAdminMatterID);
                    break;
                case "bankaccountnumber":
                    this.enterBankAccountNumber(iReportingOperationsObj.accountNumber);
                    break;
            }
        }
        searchPageObj.searchButton().click();
    }

    public void validateMoreThanOneMatchRecord(String criterias) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        List<WebElement> searchTable = nextEventPageObj.findElements(By.xpath(searchPageObj.customerTablerow()));
        int size = searchTable.size();
        System.out.println("------------------------size---------------------" + size);
        Assert.assertTrue(size > 1);
    }

    public void validateMoreThanOneMatchRecordAvailable() throws Exception {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOpeobj.navigateToAdvanceSearch();
        nextEventPageObj.btnClick(policyDataFieldsPageObj.searchByID());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.selectDrop(schemeSummaryPageObj.filterByPolicytypeDropdown(), "Travel Policy");
        policyDataFieldsPageObj.policyIdInput().sendKeys(this.policyNumber);
        policyDataFieldsPageObj.policySearchbtn();
        policyDataFieldsPageObj.policySearchbtn().click();
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
        List<WebElement> searchTable = nextEventPageObj.findElements(By.xpath(searchPageObj.advancedSearchResults()));
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        int size = searchTable.size();
        System.out.println("------------------------size---------------------" + size);
        if (size == 0 && !searchPageObj.noRecordDisplay().getText().equalsIgnoreCase("No results to display...")) {
            Assert.assertTrue("Only one row is displayed as expected",size==0);
        }
        else
        {
            throw new Exception("Multiple rows are displayed for single account");
        }
    }
}
