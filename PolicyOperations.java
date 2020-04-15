package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.*;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PolicyOperations {

    public static String policyNumber = "";
    public static String policyValue = "";
    public String accountNumber = "";
    String subPeril = "";
    String existingUpgradeExpiryDate = "";
    String newUpgradeExpiryDate = "";
    String upgradeExpiryDate = "";

    public static String addressLine1Aquarium = "";
    public static String addressLine2Aquarium = "";
    public static String postcodeAquarium = "";
    public static String randomEmailID = "";
    public static String type = "";
    public static String townAquarium = "";
    public static String retrieveRandomCustomerLastName = "";
    public static String retrieveCustomerDOB = "";
    public static String retrieveRandomCustomerFirstName = "";
    public static String retrievedSchemeID = "";
    public static String retrieveBusinessName = "";
    public static String retrievedSchemeEmailID = "";
    public static String emailIdForReport = "";
    public static String policyId = "";
    public static String policyIdForReport = "";
    public static String product = "";
    public static String jointAcctLastName = "";
    List<WebElement> elementCount;

    int date;
    String lastName = "";

    public static String affinionData = "";
    public static int namedPeopleCount = 0;
    public static int j = 0;
    public static int jhCount = 0;
    public static String fname1 = "";
    public static String lname = "";
    public static Date dob;
    public static String Date = "";
    public static String address1 = "";
    public static String town = "";
    public static String country = "";
    public static String postcode = "";
    public static String email = "";
    public static String mobile = "";
    public static String homePhone = "";
    public static String customerTabName = "";
    public String updatedEmailId = "";

    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private RandomGenerator randomGeneratorObj = new RandomGenerator();
    private SchemeSummaryPage schemeSummaryPageObj = new SchemeSummaryPage();
    private BasicClaimDetailsPage basicClaimDetailsPageObj = new BasicClaimDetailsPage();
    private ClaimPaymentPage claimPaymentPageObj = new ClaimPaymentPage();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private QuoteDetailsPage quoteDetailsPageObj = new QuoteDetailsPage();
    private DateOperations dateOperationsObj = new DateOperations();
    private ClaimsOperations claimOperationObj = new ClaimsOperations();
    private FinalisePaymentPage finalisePaymentPageObj = new FinalisePaymentPage();
    private WebTable webTableObj = new WebTable();
    private QuoteRenewalPage quoteRenewalPageObj = new QuoteRenewalPage();
    private RulesEngineOperation rulesEngineOperationObj = new RulesEngineOperation();
    private Commands commandsObj = new Commands();
    private PaymentFailurePage paymentFailurePageObj = new PaymentFailurePage();
    private PolicySummaryPage policySummaryPageObj = new PolicySummaryPage();
    private CustomerDetailsFieldPage customerDetailsFieldPageObj = new CustomerDetailsFieldPage();
    private Navigation navigationObj = new Navigation();
    private TMADetailsPage tmaDetailsPageObj = new TMADetailsPage();
    private FileOperations fileOperationsOObj = new FileOperations();
    private FullEventHistoryPage fullEventHistoryPageObj = new FullEventHistoryPage();
    public TTAPIMappingValueRequestOperations mappingFieldValues = new TTAPIMappingValueRequestOperations();


    public void title(String title) {
        new Select(policyDataFieldsPageObj.title()).selectByVisibleText(title);
    }

    public void firstName(String fName) {
        policyDataFieldsPageObj.firstName().clear();
        policyDataFieldsPageObj.firstName().sendKeys(fName);
    }

    public void lastName(String lName) {
        policyDataFieldsPageObj.lastName().clear();
        lastName = lName;
        policyDataFieldsPageObj.lastName().sendKeys(lName);
    }

    public void emailID(String emailID) {
        policyDataFieldsPageObj.emailId().clear();
        if (emailID.equalsIgnoreCase("Random")) {
            emailID = randomGeneratorObj.randomEmailAddress(5);
            emailIdForReport = emailID;
            randomEmailID = emailID;
            retrievedSchemeEmailID = emailID;
            System.out.println("Random Email Id is -----" + randomEmailID);
            policyDataFieldsPageObj.emailId().sendKeys(emailID);
        } else
            policyDataFieldsPageObj.emailId().sendKeys(emailID);
    }

    public void address1(String address1) {
        policyDataFieldsPageObj.addressLine1().clear();
        policyDataFieldsPageObj.addressLine1().sendKeys(address1);
        addressLine1Aquarium = address1;
    }

    public void mobile(String mobile) {
        policyDataFieldsPageObj.mobileNo().clear();
        policyDataFieldsPageObj.mobileNo().sendKeys(mobile);
    }

    public void address2(String address2) {
        policyDataFieldsPageObj.addressLine2().clear();
        policyDataFieldsPageObj.addressLine2().sendKeys(address2);
        addressLine2Aquarium = address2;
    }

    public void town(String town) {
        policyDataFieldsPageObj.town().clear();
        policyDataFieldsPageObj.town().sendKeys(town);
        townAquarium = town;
    }

    public void county(String county) {
        policyDataFieldsPageObj.county().clear();
        policyDataFieldsPageObj.county().sendKeys(county);
    }

    public void postCode(String postCode) {
        policyDataFieldsPageObj.postCode().clear();
        policyDataFieldsPageObj.postCode().sendKeys(postCode);
        postcodeAquarium = postCode;
    }

    public void acceptTandC() {
        policyDataFieldsPageObj.acceptTAndC().click();
    }

    public void dateOfBirth(String DoB) {
        policyDataFieldsPageObj.dateOfBirth().clear();
        System.out.println("Enter DOB ------" + DoB);
        policyDataFieldsPageObj.dateOfBirth().sendKeys(DoB);
    }

    public void createCustomer(String customer, List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.createCustMaster(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
    }

    public void updateAddress(String customer, List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.createAddress(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
    }

    public void createAddress(String searchField, String searchValue) {
        switch (searchField.toLowerCase()) {
            case "addresstype":
                policyDataFieldsPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                nextEventPageObj.waitForMoreTime();
                policyDataFieldsPageObj.addressType().click();
                policyDataFieldsPageObj.addressTypeValue(searchValue).click();
                break;
            case "address1":
                policyDataFieldsPageObj.addressLookUp().sendKeys(searchValue);
                break;
            case "postcode":
                policyDataFieldsPageObj.postCodeLookup().sendKeys(searchValue);
                policyDataFieldsPageObj.findAddress().click();
                policyDataFieldsPageObj.waitForMoreTime();
                policyDataFieldsPageObj.waitForMoreTime();
                policyDataFieldsPageObj.waitForMoreTime();
                break;
        }
    }

    public void createCustMaster(String searchField, String searchValue) {
        switch (searchField.toLowerCase()) {
            case "title":
                this.title(searchValue);
                break;
            case "firstname":
                if (searchValue.equalsIgnoreCase("random")) {
                    System.out.println("Inside Random");
                    searchValue = randomGeneratorObj.randomString(5);
                    retrieveRandomCustomerFirstName = searchValue;
                    this.firstName(searchValue);
                } else {
                    retrieveRandomCustomerFirstName = searchValue;
                    this.firstName(searchValue);
                }
                break;
            case "lastname":
                if (searchValue.equalsIgnoreCase("random")) {
                    System.out.println("Inside Random");
                    searchValue = randomGeneratorObj.randomString(5);
                    retrieveRandomCustomerLastName = searchValue;
                    this.lastName(searchValue);
                } else {
                    this.lastName(searchValue);
                    retrieveRandomCustomerLastName = searchValue;
                }
                break;
            case "dateofbirth":
                if (searchValue.equalsIgnoreCase("69years11months") || (searchValue.equalsIgnoreCase("7daysbefore70thbirthday"))) {
                    String dob = this.DobDate(searchValue);
                    System.out.println("DOB --69 yrs 11M--- " + dob);
                    this.dateOfBirth(dob);
                    retrieveCustomerDOB = dob;
                } else if (searchValue.equalsIgnoreCase("69years10months") || searchValue.equalsIgnoreCase("70thbirthdayreached")) {
                    String dob = this.DobDate(searchValue);
                    System.out.println("DOB --69 and 70 age-- " + dob);
                    this.dateOfBirth(dob);
                    retrieveCustomerDOB = dob;
                } else {
                    this.dateOfBirth(searchValue);
                    retrieveCustomerDOB = searchValue;
                }
                break;
            case "emailid":
                this.emailID(searchValue);
                break;
            case "mobile":
                this.mobile(searchValue);
                break;
            case "address1":
                this.address1(searchValue);
                break;
            case "address2":
                this.address2(searchValue);
                break;
            case "town":
                this.town(searchValue);
                break;
            case "county":
                this.county(searchValue);
                break;
            case "postcode":
                this.postCode(searchValue);
                break;
            case "accept":
                this.acceptTandC();
                policyDataFieldsPageObj.saveCust().click();
        }
    }

    public void createPolicy(String policy, List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.createPolMaster(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
    }

    public void createComms(String policy, List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.createCommsPref(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
    }

    public void createproduct(String policy, List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.createproductdetails(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
    }

    public void createPolMaster(String searchField, String searchValue) {
        switch (searchField.toLowerCase()) {
            case "jointaccount":
                policyDataFieldsPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                nextEventPageObj.waitForMoreTime();
                policyDataFieldsPageObj.jointAccount().click();
                policyDataFieldsPageObj.jointAccountOption(searchValue).click();
                policyDataFieldsPageObj.switchToDefault();
                break;
            case "existingpackagedcustomer":
                policyDataFieldsPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                policyDataFieldsPageObj.existingPackagedCust().click();
                policyDataFieldsPageObj.existingPackagedCustOption(searchValue).click();
                policyDataFieldsPageObj.switchToDefault();
                break;
            case "producttype":
                /*policyDataFieldsPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.clickAccount());
                policyDataFieldsPageObj.switchToFrameById(policyDataFieldsPageObj.policyFrame());
                String strInputProductType = searchValue;
                String strProductTypeToSelect = strInputProductType;
                System.out.println("-----------cover-------" + strProductTypeToSelect);
                if (System.getProperty("brand") != null && !System.getProperty("brand").toLowerCase().contains(fileOperationsOObj.getCommonProperties("NoLogicBrand").toLowerCase())) {
                    if (!strInputProductType.endsWith("Account") && !strInputProductType.endsWith("Cover")) {
                        strProductTypeToSelect = fileOperationsOObj.getCommonProperties(System.getProperty("brand") + strInputProductType + "Product");
                        System.out.println("-----------cover-------" + strProductTypeToSelect);
                        product = strProductTypeToSelect;
                    }
                }
                if (strProductTypeToSelect.contains("Cover")) {
                    System.out.println("strProductTypeToSelect---------inside split------" + strProductTypeToSelect);
                    strProductTypeToSelect = strProductTypeToSelect.split(" ")[0];
                    System.out.println("strProductTypeToSelect---------after split------" + strProductTypeToSelect);
                }
                policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.selectAccount(strProductTypeToSelect, PerformSearch.brandName));
                policyDataFieldsPageObj.switchToDefault();
                policyDataFieldsPageObj.waitForMoreTime();
                policyDataFieldsPageObj.waitForMoreTime();*/
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
                }
                String basePolicyType = String.format("%s %s", brandName, searchValue);
                System.out.println("product type-------------------" + basePolicyType);
                policyDataFieldsPageObj.basePolicyType().click();
                policyDataFieldsPageObj.basePolicyOption(basePolicyType).click();
                policyDataFieldsPageObj.switchToDefault();
                break;
            case "accountnumber":
                policyDataFieldsPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                policyDataFieldsPageObj.accountNumber().clear();
                policyDataFieldsPageObj.accountNumber().sendKeys(searchValue);
                policyDataFieldsPageObj.switchToDefault();
                break;
            case "sortcode":
                policyDataFieldsPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                policyDataFieldsPageObj.sortCode().clear();
                policyDataFieldsPageObj.sortCode().sendKeys(searchValue);
                policyDataFieldsPageObj.switchToDefault();
                break;
            case "bankname":
               /* policyDataFieldsPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.bankName());
                if (System.getProperty("brand") != null) {
                    searchValue = fileOperationsOObj.getCommonProperties(System.getProperty("brand"));
                }
                policyDataFieldsPageObj.bankNameOption(searchValue).click();
                policyDataFieldsPageObj.switchToDefault();*/
                break;
        }
    }

    public void createproductdetails(String searchField, String searchValue) {
        switch (searchField.toLowerCase()) {
            case "coverage":
                String strInputCoverage = searchValue;
                String strExpCoverageToSelect = strInputCoverage;
                System.out.println("fileOperationsOObj.getCommonProperties(\"NoLogicBrand\").toLowerCase()====" + fileOperationsOObj.getCommonProperties("NoLogicBrand").toLowerCase());
                if (System.getProperty("brand") != null && System.getProperty("brand").toLowerCase() != fileOperationsOObj.getCommonProperties("NoLogicBrand").toLowerCase()) {
                    if (!strInputCoverage.endsWith("Cover")) {
                        strExpCoverageToSelect = fileOperationsOObj.getCommonProperties(System.getProperty("brand") + strInputCoverage + "Cover");
                    }
                }
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                nextEventPageObj.btnClick(policyDataFieldsPageObj.clickCover());
                policyDataFieldsPageObj.switchToFrameById(policyDataFieldsPageObj.policyFrame());
                if (System.getProperty("driverType") != null && System.getProperty("driverType").equalsIgnoreCase("ie")) {
                    policyDataFieldsPageObj.selectCover(searchValue).click();
                } else {
                    this.selectCover(strExpCoverageToSelect);
                }
                policyDataFieldsPageObj.switchToDefault();
                commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
                commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
                policyDataFieldsPageObj.waitForMoreTime();
                break;
        }
    }

    public void createCommsPref(String searchField, String searchValue) {
        switch (searchField.toLowerCase()) {
            case "teleno1":
                policyDataFieldsPageObj.tele1().clear();
                policyDataFieldsPageObj.tele1().sendKeys(searchValue);
                break;
            case "teleno2":
                policyDataFieldsPageObj.tele2().clear();
                policyDataFieldsPageObj.tele2().sendKeys(searchValue);
                break;
            case "teleno1type":
                policyDataFieldsPageObj.tele1Pref().click();
                policyDataFieldsPageObj.tele1PrefOption(searchValue).click();
                break;
            case "teleno2type":
                policyDataFieldsPageObj.tele2Pref().click();
                policyDataFieldsPageObj.tele2PrefOption(searchValue).click();
                break;
            case "commspref":
                if (searchValue.equalsIgnoreCase("email")) {
                    policyDataFieldsPageObj.eMail().click();
                }
                if (searchValue.equalsIgnoreCase("letter")) {
                    policyDataFieldsPageObj.letter().click();
                }
                if (searchValue.equalsIgnoreCase("sms")) {
                    policyDataFieldsPageObj.sms().click();
                }
                if (searchValue.equalsIgnoreCase("phone")) {
                    policyDataFieldsPageObj.phone().click();
                }
                break;
            case "marketingpreference":
                policyDataFieldsPageObj.marketingPreferenceImg().click();
                policyDataFieldsPageObj.marketingPreferencedropdown(searchValue).click();
                break;
        }
    }

    public void createScheme(List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.createTravelScheme(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
    }

    public void createTravelScheme(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "policy type":
                this.policyType(fieldValue);
                nextEventPageObj.waitForMoreTime();
                break;
            case "business name":
                this.businessName(fieldValue);
                break;
            case "address1":
                this.businessAddress1(fieldValue);
                break;
            case "address2":
                this.businessAddress2(fieldValue);
                break;
            case "town":
                this.businessTown(fieldValue);
                break;
            case "county":
                this.businessCounty(fieldValue);
                break;
            case "email":
                this.businessEmailID(fieldValue);
                break;
            case "phone":
                this.businessTelePhone(fieldValue);
                break;
            case "postcode":
                this.businessPostCode(fieldValue);
                break;
            case "accept":
                policyDataFieldsPageObj.saveCust().click();
                break;
        }
    }

    public void policyType(String valueToSelect) {
        System.out.println("Policy type----------------------");
        new Select(policyDataFieldsPageObj.policyType()).selectByVisibleText(valueToSelect);
    }

    public void businessName(String businessName) {
        if (businessName.equalsIgnoreCase("random")) {
            businessName = randomGeneratorObj.randomString(5);
            retrieveBusinessName = businessName;
            System.out.println("Retrieved business name " + retrieveBusinessName);
            policyDataFieldsPageObj.businessName().sendKeys(businessName);
        } else
            policyDataFieldsPageObj.lastName().sendKeys(businessName);
    }

    public void businessAddress1(String address1) {
        policyDataFieldsPageObj.businessAddress1().clear();
        policyDataFieldsPageObj.businessAddress1().sendKeys(address1);
    }

    public void businessTelePhone(String mobile) {
        policyDataFieldsPageObj.businessPhone().clear();
        policyDataFieldsPageObj.businessPhone().sendKeys(mobile);
    }

    public void businessAddress2(String address2) {
        policyDataFieldsPageObj.businessAddress2().clear();
        policyDataFieldsPageObj.businessAddress2().sendKeys(address2);
    }

    public void businessTown(String town) {
        policyDataFieldsPageObj.businessTown().clear();
        policyDataFieldsPageObj.businessTown().sendKeys(town);
    }

    public void businessCounty(String county) {
        policyDataFieldsPageObj.businessCounty().clear();
        policyDataFieldsPageObj.businessCounty().sendKeys(county);
    }

    public void businessPostCode(String postCode) {
        policyDataFieldsPageObj.businessPostcode().clear();
        policyDataFieldsPageObj.businessPostcode().sendKeys(postCode);
    }

    public void businessEmailID(String emailID) {
        policyDataFieldsPageObj.businessEmail().clear();
        if (emailID.equalsIgnoreCase("Random")) {
            emailID = randomGeneratorObj.randomEmailAddress(5);
            policyDataFieldsPageObj.businessEmail().sendKeys(emailID);
        } else
            policyDataFieldsPageObj.businessEmail().sendKeys(emailID);
    }

    public void updateUpgradeFields(List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.addUpgrades(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
    }

    public void closeSchemesWindow() {
        nextEventPageObj.getDriver.close();
        nextEventPageObj.switchToWindowByIndex(0);
    }

    public void addUpgrades(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "name":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(policySummaryPageObj.addCoverBtnFrame());
                schemeSummaryPageObj.selectUpgradeDefination(fieldValue).click();
                nextEventPageObj.switchToDefault();
                break;
            case "lower limit":
                schemeSummaryPageObj.upperLimit().clear();
                schemeSummaryPageObj.lowerLimit().sendKeys(fieldValue);
                break;
            case "upper limit":
                schemeSummaryPageObj.upperLimit().clear();
                schemeSummaryPageObj.upperLimit().sendKeys(fieldValue);
                break;
            case "age limit":
                schemeSummaryPageObj.ageLimit().clear();
                schemeSummaryPageObj.ageLimit().sendKeys(fieldValue);
                break;
            case "limit type":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(quoteDetailsPageObj.btnSaveAndClose());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(schemeSummaryPageObj.editFirstScheme());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                schemeSummaryPageObj.coverTermsTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(schemeSummaryPageObj.insertRecordFromCoverTermTab());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                schemeSummaryPageObj.limitTypeImg().click();
                schemeSummaryPageObj.limitTypeSelection(fieldValue).click();
                break;
            case "start date":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (fieldValue.equalsIgnoreCase("today"))
                    schemeSummaryPageObj.startDateTxt().sendKeys(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString());
                else if (!fieldValue.equalsIgnoreCase("-"))
                    schemeSummaryPageObj.startDate().sendKeys(fieldValue);
                break;
            case "end date":
                if (fieldValue.equalsIgnoreCase("today"))
                    schemeSummaryPageObj.txtEndDate().sendKeys(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString());
                else if (!fieldValue.equalsIgnoreCase("-"))
                    schemeSummaryPageObj.endDate().sendKeys(fieldValue);
                break;
            case "pro rateable":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                schemeSummaryPageObj.pricingTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(schemeSummaryPageObj.insertRecordFromPricingTab());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                schemeSummaryPageObj.proRateable().click();
                break;
            case "pricing table id":
                if (fieldValue.equalsIgnoreCase("rules set id")) {
                    schemeSummaryPageObj.insertRecord().click();
                    schemeSummaryPageObj.pricingTableId().sendKeys(rulesEngineOperationObj.ruleSetId);
                } else
                    schemeSummaryPageObj.pricingTableId().sendKeys(fieldValue);
                break;
            case "accept":
                schemeSummaryPageObj.updateBtn().click();
                break;
            case "amount":
                schemeSummaryPageObj.tabCoverTerms().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                schemeSummaryPageObj.lnkEditCancellation().click();
                nextEventPageObj.waitForMoreTime();
                schemeSummaryPageObj.txtAmtCancellation().clear();
                schemeSummaryPageObj.txtAmtCancellation().sendKeys(fieldValue);
                nextEventPageObj.waitForMoreTime();
                schemeSummaryPageObj.lnkUpdateCancellation().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(quoteDetailsPageObj.btnSaveAndClose());
                break;
            case "action":
                System.out.println("Field value" + fieldValue);
                if (fieldValue.equalsIgnoreCase("update")) {
                    nextEventPageObj.waitForMoreTime();
                    schemeSummaryPageObj.updateBtn().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                } else if (fieldValue.equalsIgnoreCase("edit")) {
                    nextEventPageObj.waitForMoreTime();
                    System.out.println("Inside edit button");
                    schemeSummaryPageObj.editBtn().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                } else if (fieldValue.equalsIgnoreCase("save")) {
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    basicClaimDetailsPageObj.editSave().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                } else if (fieldValue.equalsIgnoreCase("saveandclose")) {
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.btnClick(quoteDetailsPageObj.btnSaveAndClose());
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();

                }
                break;
        }
    }

    public void selectfirstscheme() {
        if (policyDataFieldsPageObj.selectPolicy().isDisplayed()) {
            System.out.println("***********Element is displayed**************");
            nextEventPageObj.btnClick(policyDataFieldsPageObj.selectPolicy());
        } else {
            System.out.println("***************Element Not displayed ********************");
        }
    }

    public void verifyUpgradeFields(List<List<String>> parameters) {
        for (int column = 0; column < parameters.get(0).size(); column++) {
            this.verifyUpgrades(parameters.get(0).get(column));
        }
    }

    public void verifyUpgrades(String fieldName) {
        switch (fieldName.toLowerCase()) {
            case "age limit":
                schemeSummaryPageObj.tabCoverTerms().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("Age limit field is displayed======" + schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                Assert.assertTrue("Age limit field is displayed--------", schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                break;
            case "start date":
                schemeSummaryPageObj.upgradeTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("Start date field is displayed======" + schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                Assert.assertTrue("Start date field is displayed--------", schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                break;
            case "end date":
                schemeSummaryPageObj.upgradeTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("End date field is displayed======" + schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                Assert.assertTrue("End date field is displayed--------", schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                break;
            case "pricing table id":
                schemeSummaryPageObj.tabPricing().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("Pricing table id displayed======" + schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                Assert.assertTrue("Pricing table id is displayed--------", schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                break;
            case "tablerowid":
                Assert.assertTrue("Validate Table RowID field", schemeSummaryPageObj.upgradeDetailsTableRowID(fieldName).isDisplayed());
                System.out.println("verified Table row id =========" + schemeSummaryPageObj.upgradeDetailsTableRowID(fieldName).isDisplayed());
                break;
            case "prorateable":
                schemeSummaryPageObj.tabPricing().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("prorateable field is displayed======" + schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                Assert.assertTrue("prorateable  field is displayed--------", schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                break;

            case "pricing startdate":
                Assert.assertTrue("Validate Start date field", schemeSummaryPageObj.verifyFields("Start Date").isDisplayed());
                System.out.println("verified Start Date =========" + schemeSummaryPageObj.verifyFields("Start Date").getText());
                break;
            case "pricing enddate":
                Assert.assertTrue("Validate end date field", schemeSummaryPageObj.verifyFields("End Date").isDisplayed());
                System.out.println("verified End Date =========" + schemeSummaryPageObj.verifyFields("End Date").getText());
                break;
            case "accept":
                schemeSummaryPageObj.updateBtn().click();
                break;
            case "name":
                schemeSummaryPageObj.upgradeTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("name field is displayed======" + schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                Assert.assertTrue("name  field is displayed--------", schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                break;
            case "type":
                schemeSummaryPageObj.upgradeTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("Type field is displayed======" + schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                Assert.assertTrue("Type field field is displayed--------", schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                break;
            case "limit type":
                schemeSummaryPageObj.tabCoverTerms().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("Validate Limit Type field " + schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                Assert.assertTrue(schemeSummaryPageObj.upgradeDetailsVerification(fieldName).isDisplayed());
                break;
            case "description":
                Assert.assertTrue(schemeSummaryPageObj.verifyFields("Description").isDisplayed());
                System.out.println("Validate Description field " + schemeSummaryPageObj.verifyFields("Description").isDisplayed());
                break;
        }
    }

    public void selectFirstScheme() {
        if (policyDataFieldsPageObj.selectscheme().isDisplayed()) {
            System.out.println("***********Element is displayed**************");
            policyDataFieldsPageObj.selectscheme().click();
        } else {
            System.out.println("***************Element Not displayed ********************");
        }
    }

    public void selectNatwestScheme() {
        if (policyDataFieldsPageObj.selectnatwestscheme().isDisplayed()) {
            System.out.println("***********Element is displayed**************");
            policyDataFieldsPageObj.selectnatwestscheme().click();
        } else {
            System.out.println("***************Element Not displayed ********************");
        }
    }

    public void createPolicy_scheme(String policy, List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.createPolMaster_scheme(parameters.get(0).get(column), parameters.get(row).get(column));
            }
            basicClaimDetailsPageObj.savescheme().click();
        }
    }

    public void selectparticularcheme(String schemeid) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (policyDataFieldsPageObj.selectparticularscheme(schemeid).isDisplayed()) {
            System.out.println("***********Element is displayed**************");
            policyDataFieldsPageObj.selectparticularscheme(schemeid).click();
        } else {
            System.out.println("***************Element Not displayed ********************");
        }
    }


    public void createPolMaster_scheme(String searchField, String searchValue) {
        System.out.println("searchField.toLowerCase");
        switch (searchField.toLowerCase()) {
            case "producttype":
                System.out.println("***************In Account Info *************");
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                schemeSummaryPageObj.accountselection().click();
                nextEventPageObj.switchToFrameByIndex(0);
                schemeSummaryPageObj.accountselection_Details(searchValue).click();
                break;

            case "coverage":
                System.out.println("***************In Account Info Base Cover *************");
                schemeSummaryPageObj.basecover().click();
                nextEventPageObj.switchToFrameByIndex(0);
                schemeSummaryPageObj.basecover_selection().click();
                break;

            case "fromdate":
                System.out.println("***************In Account Date From *************");
                nextEventPageObj.switchToDefault();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                basicClaimDetailsPageObj.datefrom().sendKeys(searchValue);
                nextEventPageObj.waitForMoreTime();
            case "todate":
                System.out.println("***************In Account Date To *************");
                basicClaimDetailsPageObj.dateto().sendKeys(searchValue);
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
        }
    }

    public void enterData(String fieldName, String fieldValue) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        switch (fieldName.toLowerCase()) {
            case "customer specific requirement":
                policyDataFieldsPageObj.customerSpecificReqInput().sendKeys(fieldValue);
                break;
            case "chase title":
                policyDataFieldsPageObj.chaseTitle().clear();
                policyDataFieldsPageObj.chaseTitle().sendKeys(fieldValue);
                break;
            case "chase text":
                policyDataFieldsPageObj.chaseText().clear();
                policyDataFieldsPageObj.chaseText().sendKeys(fieldValue);
                break;
            case "number of days until manual chase reminder":
                policyDataFieldsPageObj.manualChaseRemainderSays().clear();
                policyDataFieldsPageObj.manualChaseRemainderSays().sendKeys(fieldValue);
                break;
            case "number of days between automated chases":
                policyDataFieldsPageObj.automatedChaseBetweenDays().clear();
                policyDataFieldsPageObj.automatedChaseBetweenDays().sendKeys(fieldValue);
                break;
            case "document to resend":
                policyDataFieldsPageObj.documentToResend().click();
                policyDataFieldsPageObj.documentToResendOption().click();
                break;
            case "stop chase":
                policyDataFieldsPageObj.stopChaseInput().click();
                policyDataFieldsPageObj.stopChaseInputYes().click();
                break;
            case "who requested":
                policyDataFieldsPageObj.whoRequestTextBox().clear();
                policyDataFieldsPageObj.whoRequestTextBox().sendKeys(fieldValue);
                break;
            case "cover letter additional text":
                policyDataFieldsPageObj.additionalTextBox().clear();
                policyDataFieldsPageObj.additionalTextBox().sendKeys(fieldValue);
                break;
        }
    }

    public void captureEndrosementDetail(List<List<String>> lstInputs) {
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                this.enterEndrosementPeriodDetails(lstInputs.get(0).get(j), lstInputs.get(i).get(j));
            }
        }
        basicClaimDetailsPageObj.save().click();
    }

    private void enterEndrosementPeriodDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "sub peril":
                subPeril = fieldValue;
                break;
            case "from date":
                policyDataFieldsPageObj.endrosementFromDate(subPeril).clear();
                policyDataFieldsPageObj.endrosementFromDate(subPeril).sendKeys(fieldValue);
                break;
            case "to date":
                policyDataFieldsPageObj.endrosementToDate(subPeril).clear();
                policyDataFieldsPageObj.endrosementToDate(subPeril).sendKeys(fieldValue);
                break;
            case "apply":
            case "remove":
                policyDataFieldsPageObj.endrosementApply(subPeril).click();
                break;
        }
    }

    public void enterEndorsementDetails(String fieldName, String fieldValue) {
        System.out.println("Endorsement fieldname-----------------------" + fieldName);
        System.out.println("Endorsement fieldname-----------------------" + fieldValue);
        switch (fieldName.toLowerCase()) {
            case "sub peril":
                subPeril = fieldValue;
                schemeSummaryPageObj.endrosementEdit(subPeril).click();
                break;
            case "instance from date":
                schemeSummaryPageObj.endrosementInstanceFromDate(subPeril).clear();
                schemeSummaryPageObj.endrosementInstanceFromDate(subPeril).sendKeys(fieldValue);
                break;
            case "instance to date":
                schemeSummaryPageObj.endrosementInstanceToDate(subPeril).clear();
                schemeSummaryPageObj.endrosementInstanceToDate(subPeril).sendKeys(fieldValue);
                break;
            case "review date":
                schemeSummaryPageObj.endrosementReviewDate(subPeril).clear();
                schemeSummaryPageObj.endrosementReviewDate(subPeril).sendKeys(fieldValue);
                break;
            case "apply":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                schemeSummaryPageObj.endrosementApplyInScheme(subPeril).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                schemeSummaryPageObj.endorsementUpdate(subPeril).click();
                break;
        }
    }

    public void capturePaymentDetails(List<List<String>> lstInputs) throws Throwable {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                this.enterPaymentDetails(lstInputs.get(0).get(j), lstInputs.get(i).get(j));
            }
        }
    }

    private void enterPaymentDetails(String fieldName, String fieldValue) throws Throwable {
        System.out.println("Entering  Func enterPaymentDetails:: Field Name--" + fieldName + " Field Value---" + fieldValue);
        switch (fieldName.toLowerCase()) {
            case "select payee":
                if (fieldValue.equalsIgnoreCase("new")) {
                    nextEventPageObj.switchToDefault();
                    nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                    claimPaymentPageObj.saveBtn().click();
                    nextEventPageObj.waitForPageLoad();
                    Thread.sleep(5000L);
                } else {
                    System.out.println("Code for already existing bank accout details");
                }
                break;
            case "payment options":
                if (fieldValue.equalsIgnoreCase("Enter and Validate Bank Details")) {
                    nextEventPageObj.switchToDefault();
                    claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                    nextEventPageObj.waitForPageLoad();
                    Thread.sleep(5000L);
                    claimOperationObj.navigateToEventType("Enter and Validate Bank Details");
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                } else if (fieldValue.equalsIgnoreCase("Enter Cheque Details (GW)")) {
                    System.out.println(" Enter Cheque Details (GW)");
                    nextEventPageObj.switchToDefault();
                    claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                    nextEventPageObj.waitForPageLoad();
                    Thread.sleep(5000L);
                    claimOperationObj.navigateToEventType(fieldValue);
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                } else {
                    System.out.println("code to enter cheque details");
                    nextEventPageObj.switchToDefault();
                    claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                    claimOperationObj.navigateToEventType("Enter Cheque Details");
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                }
                break;
            case "payee":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                System.out.println("Payee entering*********" + fieldValue);
                claimPaymentPageObj.payeeGoodWill().click();
                claimPaymentPageObj.payeeGoodWill().sendKeys(fieldValue);
                break;
            case "select payment account":
                nextEventPageObj.switchToDefault();
                claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimOperationObj.selectAccountNumberValidation(fieldValue);
                break;
            case "select payment account validation":
                nextEventPageObj.switchToDefault();
                claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimOperationObj.selectAccountNumberValidation(fieldValue);
                break;
            case "payment method":
                if (nextEventPageObj.goDisplayed()) {
                    claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                }
                if ((fieldValue.equalsIgnoreCase("BACS")) || (fieldValue.equalsIgnoreCase("CHAPS"))) {
                    claimOperationObj.navigateToEventType("Select Payment Method");
                    claimPaymentPageObj.selectPaymentImg().click();
                    claimPaymentPageObj.selectPaymentMethod(fieldValue).click();
                    claimPaymentPageObj.goodwillSave().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.switchToDefault();
                    claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                } else if (fieldValue.equalsIgnoreCase("Finalise Payment (GW)")) {
                    System.out.println("testtttttttttttttt");
                    claimOperationObj.selectPaymentMethod(fieldValue);
                    nextEventPageObj.switchToDefault();
                } else {
                    nextEventPageObj.switchToDefault();
                }
                break;
            case "account number":
                claimPaymentPageObj.accountNoGoodWill().sendKeys(fieldValue);
                break;
            case "add payment comments":
                nextEventPageObj.switchToDefault();
                claimOperationObj.clickingUnderNextEventsAndButtons("Go");
                this.addPaymentComment(fieldValue);
                break;
            case "sort code":
                claimPaymentPageObj.enterSortCode().clear();
                claimPaymentPageObj.enterSortCode().sendKeys(fieldValue);
                break;
            case "bank name":
                claimPaymentPageObj.bankNameGoodWill().sendKeys(fieldValue);
                break;
            case "addressline1":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                claimPaymentPageObj.addressLine1Goodwill().sendKeys(fieldValue);
                break;
            case "addressline2":
                claimPaymentPageObj.addressline2Goodwill().sendKeys(fieldValue);
                break;
            case "addressline3":
                claimPaymentPageObj.addressline3Goodwill().sendKeys(fieldValue);
                break;
            case "city":
                claimPaymentPageObj.cityGoodwill().sendKeys(fieldValue);
                break;
            case "county":
                claimPaymentPageObj.countyGoodwill().sendKeys(fieldValue);
                break;
            case "country":
                claimPaymentPageObj.countryGoodwill().sendKeys(fieldValue);
                break;
            case "postcode":
                claimPaymentPageObj.postcodeGoodwill().sendKeys(fieldValue);
                break;
            case "supplier account number":
            case "accountnumber":
                accountNumber = fieldValue;
                claimPaymentPageObj.paymentPageAccountNo().clear();
                claimPaymentPageObj.paymentPageAccountNo().sendKeys(fieldValue);
                break;
            case "supplier sort code":
            case "sortcode":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                System.out.println("Sort code ----" + fieldValue);
                claimPaymentPageObj.paymentPageSortCode().clear();
                claimPaymentPageObj.paymentPageSortCode().sendKeys(fieldValue);
                break;
            case "payee name":
                accountNumber = fieldValue;
                if (fieldValue.contains("#")) {
                    String FirstName = fieldValue.split("#")[0];
                    String SurName = fieldValue.split("#")[1];
                    System.out.println("First name is-------" + FirstName);
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    claimPaymentPageObj.paymentPayeeFirstName().sendKeys(FirstName);
                    System.out.println("First name is-------" + FirstName + " Entered");
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    System.out.println("Surname is-------" + SurName);
                    claimPaymentPageObj.paymentPayeeSurName().sendKeys(SurName);
                    System.out.println("Surname is-------" + SurName + " Entered");
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                } else {
                    claimPaymentPageObj.paymentPayee().clear();
                    claimPaymentPageObj.paymentPayee().sendKeys(fieldValue);
                }
                break;
            case "supplier bank name":
            case "bankname":
                claimPaymentPageObj.paymentPageBankName().clear();
                claimPaymentPageObj.paymentPageBankName().sendKeys(fieldValue);
                break;
            case "address1":
                claimPaymentPageObj.paymentPageAddress1().sendKeys(fieldValue);
                break;
            case "address2":
                claimPaymentPageObj.paymentPageAddress2().sendKeys(fieldValue);
                break;
            case "town":
                claimPaymentPageObj.paymentPageTown().sendKeys(fieldValue);
                break;
            case "county name":
                claimPaymentPageObj.paymentPageCounty().sendKeys(fieldValue);
                break;
            case "post code":
                claimPaymentPageObj.paymentPagePostcode().sendKeys(fieldValue);
                break;
            case "payee method":
                claimPaymentPageObj.selectPayeeMethod().click();
                claimPaymentPageObj.selectPayeeMethodOption(fieldValue).click();
                break;
            case "payee type":
                if (fieldValue.equalsIgnoreCase("Third Party")) {
                    claimPaymentPageObj.typePayee().click();
                    nextEventPageObj.waitForMoreTime();
                    claimPaymentPageObj.drpdnPayeeTypeThirdParty(fieldValue).click();
                } else {
                    claimPaymentPageObj.typePayee().click();
                    nextEventPageObj.waitForMoreTime();
                    claimPaymentPageObj.drpdnPayeeType(fieldValue).click();
                }
                claimPaymentPageObj.goodwillSave().click();
                break;
            case "action":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                policyDataFieldsPageObj.policySave().click();
                break;
            case "error message":
                System.out.println("claimPaymentPageObj.errorMessageForPHPayment(fieldValue).isDisplayed()------------------" + claimPaymentPageObj.errorMessageForPHPayment(fieldValue).isDisplayed());
                Assert.assertTrue(claimPaymentPageObj.errorMessageForPHPayment(fieldValue).isDisplayed());
                break;
            case "goodwillsortcode":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                System.out.println("Goodwillsortcode ----" + fieldValue);
                claimPaymentPageObj.sortNoGoodWill().clear();
                claimPaymentPageObj.sortNoGoodWill().sendKeys(fieldValue);
                break;
            case "goodwillaccountnumber":
                System.out.println("Goodwillaccountnumber--------" + fieldValue);
                claimPaymentPageObj.accountNoGoodWill().clear();
                claimPaymentPageObj.accountNoGoodWill().sendKeys(fieldValue);
                break;
            case "goodwillbankname":
                System.out.println("Goodwillbankname ----" + fieldValue);
                claimPaymentPageObj.bankNameGoodWill().clear();
                claimPaymentPageObj.bankNameGoodWill().sendKeys(fieldValue);
                break;
            case "goodwillaction":
                policyDataFieldsPageObj.policySave().click();
                commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
                Thread.sleep(10000L);// Fix for appliation performance issue tt232
                break;
            case "payee title":
                nextEventPageObj.btnClick(claimPaymentPageObj.dropdownPayeeTitle());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimPaymentPageObj.selectPayeeTitle(fieldValue).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
            default:
                System.out.println("--------No matching case found for ------------ " + fieldName.toLowerCase());
        }
        System.out.println("Exiting  Func enterPaymentDetails");
    }

    public void editCustomerDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "person":
                policyDataFieldsPageObj.editCustomer(fieldValue).click();
                break;
            case "firstname":
                policyDataFieldsPageObj.updateDetails_firstName().clear();
                policyDataFieldsPageObj.updateDetails_firstName().sendKeys(fieldValue);
                break;
            case "lastname":
                policyDataFieldsPageObj.updateDetails_lastName().clear();
                policyDataFieldsPageObj.updateDetails_lastName().sendKeys(fieldValue);
                break;
            case "dob":
                policyDataFieldsPageObj.updateDetails_dateOfBirth().clear();
                policyDataFieldsPageObj.updateDetails_dateOfBirth().sendKeys(fieldValue);
                break;
            case "dateofbirth":
                if (fieldValue.equalsIgnoreCase("7daysbefore70thbirthday")) {
                    String dob = this.DobDate(fieldValue);
                    System.out.println("DOB --7 Days before 70th birthday--- " + dob);
                    policyDataFieldsPageObj.updateJointAccountHolder_dateOfBirth().clear();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    policyDataFieldsPageObj.updateJointAccountHolder_dateOfBirth().sendKeys((dob));
                    break;
                } else {
                    System.out.println("Enter from date -----" + this.DobDate(fieldValue));
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    policyDataFieldsPageObj.updateDetails_dateOfBirth().clear();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    policyDataFieldsPageObj.updateDetails_dateOfBirth().sendKeys(this.DobDate(fieldValue));
                    break;
                }
            case "addressline1":
                policyDataFieldsPageObj.updateDetails_addressLine1().clear();
                policyDataFieldsPageObj.updateDetails_addressLine1().sendKeys(fieldValue);
                break;
            case "addressline2":
                policyDataFieldsPageObj.updateDetails_addressLine2().clear();
                policyDataFieldsPageObj.updateDetails_addressLine2().sendKeys(fieldValue);
                break;
            case "town":
                policyDataFieldsPageObj.updateDetails_town().clear();
                policyDataFieldsPageObj.updateDetails_town().sendKeys(fieldValue);
                break;
            case "county":
                policyDataFieldsPageObj.updateDetails_county().clear();
                policyDataFieldsPageObj.updateDetails_county().sendKeys(fieldValue);
                break;
            case "postcode":
                policyDataFieldsPageObj.updateDetails_postCode().clear();
                policyDataFieldsPageObj.updateDetails_postCode().sendKeys(fieldValue);
                break;
            case "email":
                policyDataFieldsPageObj.updateDetails_emailId().clear();
                if (fieldValue.equalsIgnoreCase("random")) {
                    fieldValue = randomGeneratorObj.randomEmailAddress(1);
                    policyDataFieldsPageObj.updateDetails_emailId().sendKeys(fieldValue);
                } else
                    policyDataFieldsPageObj.updateDetails_emailId().sendKeys(fieldValue);
                break;
            case "mobilenumber":
                policyDataFieldsPageObj.updateDetails_mobileNo().clear();
                policyDataFieldsPageObj.updateDetails_mobileNo().sendKeys(fieldValue);
                break;
            case "commpreferenceemail":
                policyDataFieldsPageObj.updateDetails_commPreferenceEmail().click();
                break;
            case "removenamedperson":
                if (fieldValue.equalsIgnoreCase("yes")) {
                    policyDataFieldsPageObj.removedNamedPerson().click();
                }
                nextEventPageObj.waitForMoreTime();
                break;
            case "save_detail":
                if (fieldValue.equalsIgnoreCase("yes")) {
                    nextEventPageObj.waitForMoreTime();
                    policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.addInsuredPerson_SaveBtn());
                    nextEventPageObj.waitForMoreTime();
                }
                break;
        }
    }

    public void addAmendInsuredPerson(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "person":
                policyDataFieldsPageObj.editCustomer(fieldValue).click();
                break;
            case "persontype":
                new Select(policyDataFieldsPageObj.add_PersonType()).selectByVisibleText(fieldValue);
                break;
            case "title":
                new Select(policyDataFieldsPageObj.add_Title()).selectByVisibleText(fieldValue);
                break;
            case "firstname":
                policyDataFieldsPageObj.add_FirstName().clear();
                policyDataFieldsPageObj.add_FirstName().sendKeys(fieldValue);
                break;
            case "lastname":
                if (fieldValue.equalsIgnoreCase("random")) {
                    jointAcctLastName = randomGeneratorObj.randomString(5);
                    policyDataFieldsPageObj.add_LastName().sendKeys(jointAcctLastName);
                } else {
                    policyDataFieldsPageObj.add_LastName().clear();
                    policyDataFieldsPageObj.add_LastName().sendKeys(fieldValue);
                }
                break;
            case "dob":
                policyDataFieldsPageObj.add_DateOfBirth().clear();
                policyDataFieldsPageObj.add_DateOfBirth().sendKeys(fieldValue);
                break;
            case "dateofbirth":
                policyDataFieldsPageObj.add_DateOfBirth().clear();
                policyDataFieldsPageObj.add_DateOfBirth().sendKeys(fieldValue);
                if (fieldValue.equalsIgnoreCase("7daysbefore70thbirthday") || fieldValue.equalsIgnoreCase("30daysbefore18thbirthday")
                        || fieldValue.equalsIgnoreCase("7daysbefore18thbirthday") || fieldValue.equalsIgnoreCase("30daysbefore23rdbirthday") || fieldValue.equalsIgnoreCase("7daysbefore23rdbirthday")) {
                    System.out.println("Enter from date -----" + this.DobDate(fieldValue));
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    policyDataFieldsPageObj.add_DateOfBirth().clear();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    policyDataFieldsPageObj.add_DateOfBirth().sendKeys(this.DobDate(fieldValue));
                } else {
                    policyDataFieldsPageObj.add_DateOfBirth().clear();
                    policyDataFieldsPageObj.add_DateOfBirth().sendKeys(fieldValue);
                }
                break;
            case "currentlycovered":
                policyDataFieldsPageObj.currentlyCovered().click();
                policyDataFieldsPageObj.currentlyCovered().click();
                policyDataFieldsPageObj.add_CurrentCovered().click();
                break;
            case "effiecttivefromdate":
                policyDataFieldsPageObj.add_EffectiveFromDate().clear();
                policyDataFieldsPageObj.add_EffectiveFromDate().sendKeys(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("Inside effiecttivefromdate end");
                break;
            case "save_detail":
                if (fieldValue.equalsIgnoreCase("yes")) {
                    nextEventPageObj.waitForMoreTime();
                    policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.addInsuredPerson_SaveBtn());
                } else if (fieldValue.equalsIgnoreCase("errormessage")) {
                    nextEventPageObj.waitForMoreTime();
                    policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.addInsuredPerson_SaveBtn());
                    //TODO-Mahendran Start - for validating the error message "Natwest Silver should not accept a claim with a named person"
//                    Assert.assertTrue(policyDataFieldsPageObj.addInsuredPerson_SaveBtn().isDisplayed());
//                    Assert.assertTrue(policyDataFieldsPageObj.addInsuredPerson_SaveBtn().getText().equalsIgnoreCase("Error textmessage"));
//                    policyDataFieldsPageObj.btnClick( policyDataFieldsPageObj.addInsuredPerson_CancelBtn() );
                    //TODO-Mahendran End
                }
                break;
            case "insert_detail":
                if (fieldValue.equalsIgnoreCase("yes")) {
                    nextEventPageObj.waitForMoreTime();
                    policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.insertBtn());
                }
                break;
            case "addressline1":
                policyDataFieldsPageObj.updateDetails_addressLine1().clear();
                policyDataFieldsPageObj.updateDetails_addressLine1().sendKeys(fieldValue);
                break;
            case "addressline2":
                policyDataFieldsPageObj.updateDetails_addressLine2().clear();
                policyDataFieldsPageObj.updateDetails_addressLine2().sendKeys(fieldValue);
                break;
            case "town":
                policyDataFieldsPageObj.updateDetails_town().clear();
                policyDataFieldsPageObj.updateDetails_town().sendKeys(fieldValue);
                break;
            case "county":
                policyDataFieldsPageObj.updateDetails_county().clear();
                policyDataFieldsPageObj.updateDetails_county().sendKeys(fieldValue);
                break;
            case "postcode":
                policyDataFieldsPageObj.updateDetails_postCode().clear();
                policyDataFieldsPageObj.updateDetails_postCode().sendKeys(fieldValue);
                break;
            case "email":
                policyDataFieldsPageObj.updateDetails_emailId().clear();
                if (fieldValue.equalsIgnoreCase("random")) {
                    fieldValue = randomGeneratorObj.randomEmailAddress(1);
                    policyDataFieldsPageObj.updateDetails_emailId().sendKeys(fieldValue);
                } else
                    policyDataFieldsPageObj.updateDetails_emailId().sendKeys(fieldValue);
                break;
            case "mobilenumber":
                policyDataFieldsPageObj.updateDetails_mobileNo().clear();
                policyDataFieldsPageObj.updateDetails_mobileNo().sendKeys(fieldValue);
                break;
            case "commpreferenceemail":
                policyDataFieldsPageObj.updateDetails_commPreferenceEmail().click();
                break;
            case "removenamedperson":
                if (fieldValue.equalsIgnoreCase("yes")) {
                    policyDataFieldsPageObj.removedNamedPerson().click();
                }
                nextEventPageObj.waitForMoreTime();
                break;
//            case "save_detail":
//                if (fieldValue.equalsIgnoreCase( "yes" )) {
//                    nextEventPageObj.waitForMoreTime();
//                    policyDataFieldsPageObj.btnClick( policyDataFieldsPageObj.addInsuredPerson_SaveBtn() );
//                    nextEventPageObj.waitForMoreTime();
//                }
//                break;
            case "save":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(policyDataFieldsPageObj.policySave());
                break;
            case "cover removed":
                policyDataFieldsPageObj.removalOfCover().click();
                nextEventPageObj.waitForMoreTime();
                break;
//            case "removenamedperson":
//                if (fieldValue.equalsIgnoreCase( "yes" )) {
//                    policyDataFieldsPageObj.removedNamedPerson().click();
//                }
//                nextEventPageObj.waitForMoreTime();
//            case "email":
//                policyDataFieldsPageObj.jointAccountHoldereMail().clear();
//                policyDataFieldsPageObj.jointAccountHoldereMail().sendKeys( fieldValue );
//                break;
            case "birthdate":
                if (fieldValue.equalsIgnoreCase("7daysbefore70thbirthday") || fieldValue.equalsIgnoreCase("30daysbefore18thbirthday")
                        || fieldValue.equalsIgnoreCase("7daysbefore18thbirthday") || fieldValue.equalsIgnoreCase("30daysbefore23rdbirthday") || fieldValue.equalsIgnoreCase("7daysbefore23rdbirthday")) {
                    System.out.println("into birth date***********************");
                    System.out.println("Enter from date -----" + this.DobDate(fieldValue));
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    policyDataFieldsPageObj.addSub_DateOfBirth().clear();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    policyDataFieldsPageObj.addSub_DateOfBirth().sendKeys(this.DobDate(fieldValue));
                } else {
                    policyDataFieldsPageObj.addSub_DateOfBirth().clear();
                    policyDataFieldsPageObj.addSub_DateOfBirth().sendKeys(fieldValue);
                }
                break;
            case "ValidateMessage":
                if (fieldValue.equalsIgnoreCase("You cannot have more than four joint account holders on the same policy") || fieldValue.equalsIgnoreCase("You cannot have more partners than account holders"))
                    Assert.assertTrue(policyDataFieldsPageObj.viewErrorMessage(fieldValue).isDisplayed());
                break;
        }
    }

    public void enterCancellationData(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "cancellation date":
                claimSummaryPageObj.enterCancellationDate().click();
                claimSummaryPageObj.enterCancellationDate().clear();
                nextEventPageObj.waitForMoreTime();
                claimSummaryPageObj.enterCancellationDate().sendKeys(this.calculateDate(fieldValue));
                nextEventPageObj.waitForMoreTime();
                break;
            case "cancellation reason":
                claimSummaryPageObj.selectCancellationReasondrpdown().click();
                claimSummaryPageObj.selectCancellationReason(fieldValue).click();
                break;
            case "customer refund":
                if (fieldValue.equalsIgnoreCase("True")) {
                    claimSummaryPageObj.selectRefund().click();

                } else if (fieldValue.equalsIgnoreCase("False")) {
                    if (claimSummaryPageObj.selectRefund().isSelected()) {
                    }
                }
                break;
            case "refund reason":
                claimSummaryPageObj.refundReasontextarea().sendKeys(fieldValue);
                break;
            case "customer claimed":
                claimSummaryPageObj.customerClaimedChkBox().click();
                break;
        }
    }

    public void flagDeceasedPerson(String fieldName) {
        switch (fieldName.toLowerCase()) {
            case "main account holder":
                System.out.println("main account holder..........");
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                policyDataFieldsPageObj.editCustomer(fieldName.trim()).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (policyDataFieldsPageObj.chkBk_Deceased().isSelected()) {
                    Assert.assertTrue(policyDataFieldsPageObj.chkBk_Deceased().isDisplayed());
                } else {
                    Assert.assertTrue(policyDataFieldsPageObj.chkBk_Deceased().isDisplayed());
                    policyDataFieldsPageObj.chkBk_Deceased().click();

                }
                policyDataFieldsPageObj.add_DateOfBirth().click();
                policyDataFieldsPageObj.add_DateOfBirth().sendKeys(fieldName);
                policyDataFieldsPageObj.add_DateOfBirth().sendKeys(Keys.ENTER);
                nextEventPageObj.btnClick(policyDataFieldsPageObj.addInsuredPerson_SaveBtn());
                break;
            case "joint account holder":
                System.out.println("joint account holder..........");
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                policyDataFieldsPageObj.editCustomer(fieldName.trim()).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (policyDataFieldsPageObj.chkBk_Deceased().isSelected()) {
                    Assert.assertTrue(policyDataFieldsPageObj.chkBk_Deceased().isDisplayed());
                } else {
                    Assert.assertTrue(policyDataFieldsPageObj.chkBk_Deceased().isDisplayed());
                    policyDataFieldsPageObj.chkBk_Deceased().click();
                }
                nextEventPageObj.btnClick(policyDataFieldsPageObj.addInsuredPerson_SaveBtn());
                break;
            case "daughter":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime(); //Required wait time
                policyDataFieldsPageObj.editCustomer(fieldName).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (policyDataFieldsPageObj.chkBk_Deceased().isSelected()) {
                    System.out.println("if part ..");
                    Assert.assertTrue(policyDataFieldsPageObj.chkBk_Deceased().isDisplayed());
                } else {
                    System.out.println("else part ..");
                    Assert.assertTrue(policyDataFieldsPageObj.chkBk_Deceased().isDisplayed());
                    policyDataFieldsPageObj.chkBk_Deceased().click();
                }
                nextEventPageObj.btnClick(policyDataFieldsPageObj.addInsuredPerson_SaveBtn());
                break;
            case "guest":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                policyDataFieldsPageObj.editCustomer(fieldName).click();
                if (policyDataFieldsPageObj.chkBk_Deceased().isSelected()) {
                    Assert.assertTrue(policyDataFieldsPageObj.chkBk_Deceased().isDisplayed());
                } else {
                    Assert.assertTrue(policyDataFieldsPageObj.chkBk_Deceased().isDisplayed());
                    policyDataFieldsPageObj.chkBk_Deceased().click();
                }
                nextEventPageObj.btnClick(policyDataFieldsPageObj.addInsuredPerson_SaveBtn());
                break;
            case "son":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                policyDataFieldsPageObj.editCustomer(fieldName).click();
                if (policyDataFieldsPageObj.chkBk_Deceased().isSelected()) {
                    Assert.assertTrue(policyDataFieldsPageObj.chkBk_Deceased().isDisplayed());
                } else {
                    Assert.assertTrue(policyDataFieldsPageObj.chkBk_Deceased().isDisplayed());
                    policyDataFieldsPageObj.chkBk_Deceased().click();
                }
                nextEventPageObj.btnClick(policyDataFieldsPageObj.addInsuredPerson_SaveBtn());
                break;
        }
    }

    public void enterDeceasedDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "who requested cover letter":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                policyDataFieldsPageObj.txtWhoRequested().clear();
                policyDataFieldsPageObj.txtWhoRequested().sendKeys(fieldValue);
                policyDataFieldsPageObj.policySave().click();
                break;
        }
    }

    public void addExecutorDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "title":
                policyDataFieldsPageObj.executorTitle().click();
                nextEventPageObj.waitForMoreTime();
                policyDataFieldsPageObj.drpdnTitle(fieldValue).click();
                break;
            case "firstname":
                policyDataFieldsPageObj.txtFirstname().clear();
                policyDataFieldsPageObj.txtFirstname().sendKeys(fieldValue);
                break;
            case "lastname":
                policyDataFieldsPageObj.txtLastname().clear();
                policyDataFieldsPageObj.txtLastname().sendKeys(fieldValue);
                break;
            case "address1":
                policyDataFieldsPageObj.txtAddress1().clear();
                policyDataFieldsPageObj.txtAddress1().sendKeys(fieldValue);
                break;
            case "address2":
                policyDataFieldsPageObj.txtAddress2().clear();
                policyDataFieldsPageObj.txtAddress2().sendKeys(fieldValue);
                break;
            case "town":
                policyDataFieldsPageObj.txtTown().clear();
                policyDataFieldsPageObj.txtTown().sendKeys(fieldValue);
                break;
            case "execcounty":
                policyDataFieldsPageObj.txtCounty().clear();
                policyDataFieldsPageObj.txtCounty().sendKeys(fieldValue);
                break;
            case "postcode":
                policyDataFieldsPageObj.txtPostCode().clear();
                policyDataFieldsPageObj.txtPostCode().sendKeys(fieldValue);
                break;
            case "email address":
                policyDataFieldsPageObj.txtEmailAddress().clear();
                policyDataFieldsPageObj.txtEmailAddress().sendKeys(fieldValue);
                break;
            case "home phone":
                policyDataFieldsPageObj.txtHomePhone().clear();
                policyDataFieldsPageObj.txtHomePhone().sendKeys(fieldValue);
                break;
            case "mobile phone":
                policyDataFieldsPageObj.txtMobilePhone().clear();
                policyDataFieldsPageObj.txtMobilePhone().sendKeys(fieldValue);
                break;
            case "daytime phone":
                policyDataFieldsPageObj.txtDaytimePhone().clear();
                policyDataFieldsPageObj.txtDaytimePhone().sendKeys(fieldValue);
                break;
            case "action":
                policyDataFieldsPageObj.policySave().click();
                break;
        }
    }

    public String calculateDate(String date) {
        String local = "";
        if (date.equalsIgnoreCase("currentdate")) {
            System.out.println("Inside current date");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date myDate = new Date(System.currentTimeMillis());
            Calendar cal = Calendar.getInstance();
            cal.setTime(myDate);
            System.out.println(dateFormat.format(cal.getTime()));
            local = dateFormat.format(cal.getTime()).toString();
        } else if (date.equalsIgnoreCase("backdated")) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date myDate = new Date(System.currentTimeMillis());
            Calendar cal = Calendar.getInstance();
            cal.setTime(myDate);
            cal.add(Calendar.DATE, -2);
            System.out.println(dateFormat.format(cal.getTime()));
            local = dateFormat.format(cal.getTime()).toString();
        } else if (date.equalsIgnoreCase("futuredate")) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date myDate = new Date(System.currentTimeMillis());
            Calendar cal = Calendar.getInstance();
            cal.setTime(myDate);
            cal.add(Calendar.DATE, +25);
            System.out.println(dateFormat.format(cal.getTime()));
            local = dateFormat.format(cal.getTime()).toString();
        } else if (date.equalsIgnoreCase("withincoolingoffperiod")) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date myDate = new Date(System.currentTimeMillis());
            Calendar cal = Calendar.getInstance();
            cal.setTime(myDate);
            cal.add(Calendar.DATE, +12);
            System.out.println(dateFormat.format(cal.getTime()));
            local = dateFormat.format(cal.getTime()).toString();
        } else if (date.equalsIgnoreCase("outsidecoolingoffperiod")) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date myDate = new Date(System.currentTimeMillis());
            Calendar cal = Calendar.getInstance();
            cal.setTime(myDate);
            cal.add(Calendar.DATE, +15);
            System.out.println(dateFormat.format(cal.getTime()));
            local = dateFormat.format(cal.getTime()).toString();
        }
        return local;
    }

    public void validateTheExpectedValueInBillingTable(String fieldName, String fieldValue) throws ParseException {
        switch (fieldName.toLowerCase()) {
            case "next amount":
                Assert.assertTrue(policyDataFieldsPageObj.nextTotalAmount().getText().equalsIgnoreCase(fieldValue));
                break;
            case "next date":
                this.verifyDateisFutureDate();
                break;
        }
    }

    public void verifyDateisFutureDate() {
        try {
            Date dateFromPage = new SimpleDateFormat("dd/MM/yyyy").parse(policyDataFieldsPageObj.nextDate().getText());
            DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println(dateFormat2.format(new Date()));
            String newDate = dateFormat2.format(new Date());
            Date currentDate = new SimpleDateFormat("dd/MM/yyyy").parse(newDate);
            Assert.assertTrue(dateFromPage.after(currentDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void verifyDateCurrentDate() {
        try {
            System.out.println("Inside current date validation---" + policyDataFieldsPageObj.nextDate().getText());
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
            Date currentDate = new Date();
            String strDate = dateFormat.format(currentDate);
            System.out.println("System current date:" + strDate);
            Assert.assertTrue(policyDataFieldsPageObj.nextDate().getText().equalsIgnoreCase(strDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterPolicyDetailsInEditScreen(String detailsToUpdate) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.editPolicy().click();
        for (int i = 0; i < detailsToUpdate.split("#").length; i++) {
            switch (detailsToUpdate.split("#")[i].toLowerCase()) {
                case "inception date":
                    policyDataFieldsPageObj.inceptionDateCalendar().click();
                    policyDataFieldsPageObj.inceptionDatePerviousMonth().click();
                    policyDataFieldsPageObj.inceptionDatePerviousMonth().click();
                    policyDataFieldsPageObj.dateToSelect().click();
                    break;
                case "start date":
                    policyDataFieldsPageObj.startDateCalendar().click();
                    policyDataFieldsPageObj.startDatePerviousMonth().click();
                    policyDataFieldsPageObj.startDatePerviousMonth().click();
                    policyDataFieldsPageObj.dateToSelect().click();
                    break;
                case "end date":
                    policyDataFieldsPageObj.endDateCalendar().click();
                    policyDataFieldsPageObj.endDatePerviousMonth().click();
                    policyDataFieldsPageObj.dateToSelect().click();
                    break;
                case "back date":
                    policyDataFieldsPageObj.txtCoverStartDate().clear();
                    policyDataFieldsPageObj.txtCoverStartDate().sendKeys(calculateStartDate());
                    policyDataFieldsPageObj.txtCoverEndDate().clear();
                    policyDataFieldsPageObj.txtCoverEndDate().sendKeys(calculateStartDate());
                    break;
                case "inception date 4 days expiry":
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar c = Calendar.getInstance();
                    c.setTime(new Date()); // Now use today date.
                    c.add(Calendar.DATE, 361); // Adding 5 days
                    String output = sdf.format(c.getTime());
                    System.out.println(output);
                    policyDataFieldsPageObj.inceptiondatetext().clear();
                    policyDataFieldsPageObj.inceptiondatetext().sendKeys(sdf.format(c.getTime()));
                    break;
                case "start date 4 days expiry":
                    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar c1 = Calendar.getInstance();
                    c1.setTime(new Date()); // Now use today date.
                    c1.add(Calendar.DATE, 361); // Adding 5 days
                    String output1 = sdf1.format(c1.getTime());
                    System.out.println(output1);
                    policyDataFieldsPageObj.startdatetext().clear();
                    policyDataFieldsPageObj.startdatetext().sendKeys(sdf1.format(c1.getTime()));
                    break;
            }
        }
        nextEventPageObj.btnClick(policyDataFieldsPageObj.saveandclose());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateDetails(List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.validateEntryDetails(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
    }

    public void validateEntryDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "when":
                System.out.println("Current Date" + dateOperationsObj.getCurrentDate());
                schemeSummaryPageObj.deatilsOfWhen().getText().equalsIgnoreCase(dateOperationsObj.getCurrentDate());
                break;
            case "who":
                System.out.println("Current creator" + fieldValue);
                schemeSummaryPageObj.deatilsOfWho().getText().equalsIgnoreCase(fieldValue);
                break;
        }
    }

    public void updateUpgradesDate() {
        policyDataFieldsPageObj.txtUpgradeStartDate().clear();
        policyDataFieldsPageObj.txtUpgradeStartDate().sendKeys(calculateStartDate());
        policyDataFieldsPageObj.txtUpgradeInceptionDate().clear();
        policyDataFieldsPageObj.txtUpgradeInceptionDate().sendKeys(calculateStartDate());
        policyDataFieldsPageObj.txtUpgradeEndDate().clear();
        policyDataFieldsPageObj.txtUpgradeEndDate().sendKeys(calculateEndDate());
        policyDataFieldsPageObj.lnkEdit1().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.txtCoverActionDate().clear();
        policyDataFieldsPageObj.txtCoverActionDate().sendKeys(calculateStartDate());
        policyDataFieldsPageObj.txtCoverStartDate().clear();
        policyDataFieldsPageObj.txtCoverStartDate().sendKeys(calculateStartDate());
        policyDataFieldsPageObj.txtCoverEndDate().clear();
        policyDataFieldsPageObj.txtCoverEndDate().sendKeys(calculateEndDate());
        policyDataFieldsPageObj.lnkUpdate().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.lnkEdit2().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.txtExtActionDate().clear();
        policyDataFieldsPageObj.txtExtActionDate().sendKeys(calculateStartDate());
        policyDataFieldsPageObj.lnkUpdate().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(quoteDetailsPageObj.btnSaveAndClose());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public String calculateStartDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        String startDate = sdf.format(c.getTime());
        System.out.println("Start date ---" + startDate);
        return startDate;
    }

    public String calculateEndDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        String startDate = sdf.format(c.getTime());
        System.out.println("Start date ---" + startDate);
        c.add(Calendar.MONTH, 12);
        String endDate = sdf.format(c.getTime());
        System.out.println("End date ---" + endDate);
        return endDate;
    }

    public void updateUpgradesDetails(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.enterUpgradeDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    public void enterUpgradeDetails(String searchField, String searchValue) {
        switch (searchField.toLowerCase()) {
            case "start date":
                System.out.println("Inside start date");
                if (searchValue.equalsIgnoreCase("backdated")) {
                    policyDataFieldsPageObj.txtUpgradeStartDate().sendKeys(Keys.CONTROL + "a");
                    policyDataFieldsPageObj.txtUpgradeStartDate().sendKeys(Keys.DELETE);
                    policyDataFieldsPageObj.txtUpgradeStartDate().sendKeys(calculateStartDate());
                    System.out.println("Backdated of the cover satrt date in AQ" + calculateStartDate());
                } else if (searchValue.equalsIgnoreCase("futuredate")) {
                    policyDataFieldsPageObj.txtUpgradeInceptionDate().sendKeys(Keys.CONTROL + "a");
                    policyDataFieldsPageObj.txtUpgradeInceptionDate().sendKeys(Keys.DELETE);
                    policyDataFieldsPageObj.txtUpgradeStartDate().sendKeys(calculateFutureStartDate());
                }
                break;
            case "inception date":
                System.out.println("Inside inception date");
                if (searchValue.equalsIgnoreCase("backdated")) {
                    policyDataFieldsPageObj.txtUpgradeInceptionDate().click();
                    policyDataFieldsPageObj.txtUpgradeInceptionDate().sendKeys(Keys.CONTROL + "a");
                    policyDataFieldsPageObj.txtUpgradeInceptionDate().sendKeys(Keys.DELETE);
                    policyDataFieldsPageObj.txtUpgradeInceptionDate().sendKeys(calculateStartDate());
                    System.out.println("Backdated of the cover Inception date in AQ" + calculateStartDate());
                } else if (searchValue.equalsIgnoreCase("futuredate")) {
                    policyDataFieldsPageObj.txtUpgradeInceptionDate().click();
                    policyDataFieldsPageObj.txtUpgradeInceptionDate().sendKeys(Keys.CONTROL + "a");
                    policyDataFieldsPageObj.txtUpgradeInceptionDate().sendKeys(Keys.DELETE);
                    policyDataFieldsPageObj.txtUpgradeInceptionDate().sendKeys((calculateFutureStartDate()));
                }
                break;
            case "end date":
                System.out.println("Inside end date");
                policyDataFieldsPageObj.txtUpgradeEndDate().click();
                policyDataFieldsPageObj.txtUpgradeEndDate().sendKeys(Keys.CONTROL + "a");
                policyDataFieldsPageObj.txtUpgradeEndDate().sendKeys(Keys.DELETE);
                policyDataFieldsPageObj.txtUpgradeEndDate().sendKeys(calculateEndDate());
                System.out.println("Backdated of the cover End date in AQ" + calculateEndDate());
                if (searchValue.equalsIgnoreCase("futuredate")) {
                    policyDataFieldsPageObj.txtUpgradeEndDate().click();
                    policyDataFieldsPageObj.txtUpgradeEndDate().sendKeys(Keys.CONTROL + "a");
                    policyDataFieldsPageObj.txtUpgradeEndDate().sendKeys(Keys.DELETE);
                    policyDataFieldsPageObj.txtUpgradeEndDate().sendKeys((calculateFutureEndDate()));
                }
                break;
            case "action":
                if (searchValue.equalsIgnoreCase("saveandclose")) {
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.btnClick(quoteDetailsPageObj.btnSaveAndClose());
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                }
                break;
        }
    }

    public void validateDataFeilds(List<List<String>> parameters) throws Throwable {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.validateDataItems(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
        quoteDetailsPageObj.btnSaveAndClose().click();
    }

    public void validateDataItems(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "premium":
                Assert.assertTrue(!policyDataFieldsPageObj.txtPremium().getAttribute("value").isEmpty());
                break;
            case "premium ipt":
                Assert.assertTrue(!policyDataFieldsPageObj.txtPremiumIPT().getAttribute("value").isEmpty());
                break;
            case "prorated premium":
                Assert.assertTrue(!policyDataFieldsPageObj.txtProratedPremium().getAttribute("value").isEmpty());
                break;
            case "total amount":
                Assert.assertTrue(!policyDataFieldsPageObj.txtTotalAmt().getAttribute("value").isEmpty());
                break;
            case "amount to pay":
                Assert.assertTrue(!policyDataFieldsPageObj.txtAmtToPay().getAttribute("value").isEmpty());
                break;
            case "expiry date":
                Assert.assertTrue(!policyDataFieldsPageObj.txtUpgradeExpiryDate().getAttribute("value").isEmpty());
                break;
        }
    }

    public String captureNewUpgradeExpiryDate(String cover) {
        newUpgradeExpiryDate = policyDataFieldsPageObj.upgradeExpiryDate(cover).getText();
        System.out.println("New Upgrade expiry date ------" + newUpgradeExpiryDate);
        return newUpgradeExpiryDate;
    }

    public String captureExistingUpgradeExpiryDate(String cover) {
        existingUpgradeExpiryDate = policyDataFieldsPageObj.upgradeExpiryDate(cover).getText();
        System.out.println("Existing Upgrade expiry date ------" + existingUpgradeExpiryDate);
        return existingUpgradeExpiryDate;
    }

    public void validateExpiryOfNewUpgrade(String cover) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String currentDate = sdf.format(c.getTime());
        System.out.println("Current date -------" + currentDate);
        String newUpgradePurchaseDate = policyDataFieldsPageObj.upgradePurchaseDate(cover).getText();
        System.out.println("New Upgrade Purchase date----" + newUpgradePurchaseDate);
        Assert.assertEquals(currentDate, newUpgradePurchaseDate);
        Assert.assertEquals(existingUpgradeExpiryDate, newUpgradeExpiryDate);
    }

    public void validateEffectiveStartDate(String cover, int days) {
        String effectiveDate = this.futureStartDate(days);
        System.out.println("date -------" + date);
        System.out.println("Effective start date ---------" + effectiveDate);
        String newUpgradePurchaseDate = policyDataFieldsPageObj.upgradePurchaseDate(cover).getText();
        System.out.println("New Upgrade Purchase date----" + newUpgradePurchaseDate);
        Assert.assertEquals(effectiveDate, newUpgradePurchaseDate);
    }

    public String futureStartDate(int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, days);
        String startDate = sdf.format(c.getTime());
        System.out.println("Start date ---" + startDate);
        return startDate;
    }

    public String calculateFutureStartDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, +2);
        String startDate = sdf.format(c.getTime());
        System.out.println("Start date ---" + startDate);
        return startDate;
    }

    public String calculateFutureEndDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, +2);
        String startDate = sdf.format(c.getTime());
        System.out.println("Start date ---" + startDate);
        c.add(Calendar.MONTH, 12);
        String endDate = sdf.format(c.getTime());
        System.out.println("End date ---" + endDate);
        return endDate;
    }

    public void addPaymentComment(String comments) throws Throwable {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        finalisePaymentPageObj.finalisePaymentAddComment().sendKeys(comments);
        finalisePaymentPageObj.paymetCommentSave().click();
    }

    public void markCustomerAsDeceased() {
        claimOperationObj.clickingUnderNextEventsAndButtons("out of process event");
        claimOperationObj.navigateToEventType("OOP Deceased Customer or Named Person");
        policyDataFieldsPageObj.editMainAccountHolder().click();
        policyDataFieldsPageObj.deceasedCustomerChkBox().click();
        policyDataFieldsPageObj.addInsuredPerson_SaveBtn().click();
        policyDataFieldsPageObj.policySave().click();
    }

    public void viewEndrosement(List<String> endrosementView) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.editPolicy().click();
        policyDataFieldsPageObj.endrosementTab().click();
        for (int i = 0; i < endrosementView.size(); i++) {
            switch (endrosementView.get(i).toLowerCase()) {
                case "status":
                    System.out.println("policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed()------------" + policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed());
                    Assert.assertTrue(policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed());
                    break;
                case "endorsement description":
                    System.out.println("policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed()------------" + policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed());
                    Assert.assertTrue(policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed());
                    break;
                case "date removed":
                    System.out.println("policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed()------------" + policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed());
                    Assert.assertTrue(policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed());
                    break;
                case "date added":
                    System.out.println("policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed()------------" + policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed());
                    Assert.assertTrue(policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed());
                    break;
                case "comments":
                    System.out.println("policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed()------------" + policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed());
                    Assert.assertTrue(policyDataFieldsPageObj.endrosementDetails(endrosementView.get(i)).isDisplayed());
                    break;
            }
        }
    }

    public void verifyEndorsementAdded(List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        policyDataFieldsPageObj.editPolicy().click();
        policyDataFieldsPageObj.endrosementTab().click();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.endorsementTableManipulation(parameters.get(1).get(0), parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    public void endorsementTableManipulation(String action, String actionType, String inputValue) {
        List<WebElement> tableRows = nextEventPageObj.findElements(By.xpath("//table[@id='Rad301966_ctl01']/tbody/tr")); //financialPageObj.claimMovementTable().findElements(By.tagName("tr"));
        int tableSize = tableRows.size();
        System.out.println("Table size ----------------------------------" + tableSize);
        String sysDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString();
        int perilColumn = webTableObj.getColumnFromWebTable(policyDataFieldsPageObj.endrosementTable(), "Peril");
        int subperilColumn = webTableObj.getColumnFromWebTable(policyDataFieldsPageObj.endrosementTable(), "Sub Peril");
        int amountColumn = webTableObj.getColumnFromWebTable(policyDataFieldsPageObj.endrosementTable(), "Amount");
        int fromDateColumn = webTableObj.getColumnFromWebTable(policyDataFieldsPageObj.endrosementTable(), "Instance From Date");
        int toDateColumn = webTableObj.getColumnFromWebTable(policyDataFieldsPageObj.endrosementTable(), "Instance To Date");
        int dateAddedColumn = webTableObj.getColumnFromWebTable(policyDataFieldsPageObj.endrosementTable(), "Date Added");
        int dateRemovedColumn = webTableObj.getColumnFromWebTable(policyDataFieldsPageObj.endrosementTable(), "Date removed");
        System.out.println("payment column value ------------------------------" + perilColumn);
        System.out.println("Reason column value ------------------------------" + subperilColumn);
        System.out.println("date column value ------------------------------" + amountColumn);
        System.out.println("agent column value ------------------------------" + fromDateColumn);
        System.out.println("dedeuction column value ------------------------------" + toDateColumn);
        System.out.println("Cause Code column value ------------------------------" + dateAddedColumn);
        for (int i = 1; i < tableSize; i++) {
            String reasonXpath = policyDataFieldsPageObj.endrosementTableXpath() + "/tbody/tr[" + i + "]/td[" + (perilColumn + 1) + "]";
            System.out.println("reason column xpath ------------------------------" + reasonXpath);
            String reason = nextEventPageObj.findElement(By.xpath(reasonXpath)).getText();
            System.out.println("Reason in finance tab-------------------------------" + reason);
            if (reason.equalsIgnoreCase(action)) {
                switch (actionType.toLowerCase()) {
                    case "to date":
                        String toDate = nextEventPageObj.findElement(By.xpath(policyDataFieldsPageObj.endrosementTableXpath() + "/tbody/tr[" + i + "]/td[" + (toDateColumn + 1) + "]")).getText();
                        System.out.println("movement date ----------------------------" + toDate.contains(sysDate));
                        Assert.assertTrue(toDate.contains(sysDate));
                        break;
                    case "from date":
                        String fromDate = nextEventPageObj.findElement(By.xpath(policyDataFieldsPageObj.endrosementTableXpath() + "/tbody/tr[" + i + "]/td[" + (fromDateColumn + 1) + "]")).getText();
                        System.out.println("movement date ----------------------------" + fromDate.contains(sysDate));
                        Assert.assertTrue(fromDate.contains(inputValue));
                        break;
                    case "amount":
                        Double amountChanged = Double.parseDouble(nextEventPageObj.findElement(By.xpath(policyDataFieldsPageObj.endrosementTableXpath() + "/tbody/tr[" + i + "]/td[" + (amountColumn + 1) + "]")).getText());
                        System.out.println("Amount -----------------------Changed------------" + amountChanged);
                        System.out.println("Amount input---------------------------" + inputValue);
                        System.out.println("Amount----------------------------------" + (amountChanged == Double.parseDouble(inputValue)));
                        Assert.assertTrue(amountChanged == Double.parseDouble(inputValue));
                        break;
                    case "peril":
                        String peril = nextEventPageObj.findElement(By.xpath(policyDataFieldsPageObj.endrosementTableXpath() + "/tbody/tr[" + i + "]/td[" + (perilColumn + 1) + "]")).getText();
                        System.out.println("movement date ----------------------------" + peril.equalsIgnoreCase(inputValue));
                        Assert.assertTrue(peril.contains(inputValue));
                        break;
                    case "sub peril":
                        String subperil = nextEventPageObj.findElement(By.xpath(policyDataFieldsPageObj.endrosementTableXpath() + "/tbody/tr[" + i + "]/td[" + (subperilColumn + 1) + "]")).getText();
                        System.out.println("movement date ----------------------------" + subperil.equalsIgnoreCase(inputValue));
                        Assert.assertTrue(subperil.contains(inputValue));
                        break;
                    case "date added":
                        String dateAdded = nextEventPageObj.findElement(By.xpath(policyDataFieldsPageObj.endrosementTableXpath() + "/tbody/tr[" + i + "]/td[" + (dateAddedColumn + 1) + "]")).getText();
                        System.out.println("movement date ----------------------------" + dateAdded.contains(sysDate));
                        Assert.assertTrue(dateAdded.contains(sysDate));
                        break;
                    case "date removed":
                        String dateRemoved = nextEventPageObj.findElement(By.xpath(policyDataFieldsPageObj.endrosementTableXpath() + "/tbody/tr[" + i + "]/td[" + (dateRemovedColumn + 1) + "]")).getText();
                        System.out.println("movement date ----------------------------" + dateRemoved.contains(sysDate));
                        Assert.assertTrue(dateRemoved.contains(sysDate));
                        break;
                }
                break;
            }
        }
    }

    public void setPolicyDuration(String months) {
        quoteDetailsPageObj.basePolicyLink().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteRenewalPageObj.txtQInceptionDate().clear();
        quoteRenewalPageObj.txtQInceptionDate().sendKeys(this.claculatePolicyDuration(months));
        quoteRenewalPageObj.txtQStartDate().clear();
        quoteRenewalPageObj.txtQStartDate().sendKeys(this.claculatePolicyDuration(months));
        quoteRenewalPageObj.saveAndClose().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public String claculatePolicyDuration(String month) {
        int months = Integer.parseInt(month);
        System.out.println("After data type conversion" + months);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -months);
        String startDate = sdf.format(c.getTime());
        System.out.println("Start date ---" + startDate);
        return startDate;
    }

    public void updatePricingDetailsForScheme(String cover) {
        schemeSummaryPageObj.specificScheme(cover).click();
        schemeSummaryPageObj.pricingTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        schemeSummaryPageObj.editBtn().click();
        schemeSummaryPageObj.txtEndDate().clear();
        schemeSummaryPageObj.txtEndDate().sendKeys(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString());
        schemeSummaryPageObj.updateBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        schemeSummaryPageObj.insertRecord().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        schemeSummaryPageObj.pricingTableId().clear();
        schemeSummaryPageObj.pricingTableId().sendKeys(rulesEngineOperationObj.ruleSetId);
        schemeSummaryPageObj.startDateTxt().clear();
        schemeSummaryPageObj.startDateTxt().sendKeys(new SimpleDateFormat("yyyy-MM-dd").format(DateUtils.addDays(new java.util.Date(), 1)).toString());
        schemeSummaryPageObj.updateBtn().click();
        nextEventPageObj.btnClick(quoteDetailsPageObj.btnSaveAndClose());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void deleteRuleSetDefined(String cover) {
        commandsObj.switchToDesiredWindow(By.xpath(schemeSummaryPageObj.specificSchemexpath(cover)));
        schemeSummaryPageObj.specificScheme(cover).click();
        schemeSummaryPageObj.pricingTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        List<WebElement> deleteLink = nextEventPageObj.findElements(By.xpath(policyDataFieldsPageObj.deleteLinkXpath()));
        if (deleteLink.size() >= 1) {
            for (int i = 1; i <= deleteLink.size() - 1; i++) {
                deleteLink.get(i).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
            }
        }
        schemeSummaryPageObj.editBtn().click();
        schemeSummaryPageObj.txtEndDate().clear();
        schemeSummaryPageObj.updateBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(quoteDetailsPageObj.btnSaveAndClose());
    }

    public void verifyBasePolicy(String basePolicyType) {
        try {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.clickBasePolicy(basePolicyType).click();
            nextEventPageObj.waitForMoreTime();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void validatePaymentStatusInLedgerTable(String status) {
        paymentFailurePageObj.paymentFailureForUpgradeBackBtn().click();
        policySummaryPageObj.ledgerBtn().click();
        paymentFailurePageObj.lnkpaymentScheduledForUpgrade().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(paymentFailurePageObj.paymentStatusForUpgrade(status).isDisplayed());
        paymentFailurePageObj.paymentFailureForUpgradeCancelBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        paymentFailurePageObj.paymentFailureForUpgradeBackBtn().isDisplayed();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        try {
            nextEventPageObj.btnClick(paymentFailurePageObj.paymentFailureForUpgradeBackBtn());
        } catch (Exception e) {
            nextEventPageObj.waitForMoreTime();
            paymentFailurePageObj.paymentFailureForUpgradeBackBtn().click();
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void getPolicyNumber() {
        policyNumber = policyDataFieldsPageObj.policyNumber().getText();
        System.out.println("policy number-----------------------" + policyNumber);
    }

    public void getPolicyNumberFromScreen() {
        policyNumber = policyDataFieldsPageObj.getPolicyNumberFromScreen().getText();
        System.out.println("policy number from screen-----------------------" + policyNumber);
        getPolicyValue();
    }

    public String getPolicyValue() {
        policyId = policyNumber;
        System.out.println("policyId-----------------------" + policyId);
        return policyId;
    }

    public void captureReopenDetails(List<List<String>> lstInputs) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.nextEventClaims().click();
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                if (lstInputs.get(i).get(j).equalsIgnoreCase("oop re-open claim")) {
                    new Select(nextEventPageObj.nextEventClaims()).selectByVisibleText(lstInputs.get(i).get(j));
                }
            }
        }
        nextEventPageObj.nextButtonSensitive().click();
    }

    public void captureCustomerUpdateDetails(List<List<String>> lstInputs) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                String fieldName = lstInputs.get(0).get(j);
                String fieldValue = lstInputs.get(i).get(j);
                switch (fieldName.toLowerCase()) {
                    case "dob":
                        policyDataFieldsPageObj.dobUpdate().clear();
                        policyDataFieldsPageObj.dobUpdate().sendKeys(lstInputs.get(i).get(j));
                        break;
                    case "mobile phone":
                        policyDataFieldsPageObj.mobilePhoneUpdate().clear();
                        policyDataFieldsPageObj.mobilePhoneUpdate().sendKeys(lstInputs.get(i).get(j));
                        break;
                    case "firstname":
                        policyDataFieldsPageObj.add_FirstName().clear();
                        policyDataFieldsPageObj.add_FirstName().sendKeys(lstInputs.get(i).get(j));
                        break;
                    case "dateofbirth":
                        if (fieldValue.equalsIgnoreCase("7daysbefore70thbirthday") || fieldValue.equalsIgnoreCase("30daysbefore70thbirthday") || fieldValue.equalsIgnoreCase("30daysbefore18thbirthday")
                                || fieldValue.equalsIgnoreCase("7daysbefore18thbirthday") || fieldValue.equalsIgnoreCase("30daysbefore23rdbirthday") || fieldValue.equalsIgnoreCase("7daysbefore23rdbirthday") || fieldValue.equalsIgnoreCase("70thbirthdayreached") || fieldValue.equalsIgnoreCase("30daysafter70thbirthday")) {
                            System.out.println("Enter from date -----" + this.DobDate(fieldValue));
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            policyDataFieldsPageObj.addSub_DateOfBirth().clear();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            policyDataFieldsPageObj.addSub_DateOfBirth().sendKeys(this.DobDate(fieldValue));
                        } else {
                            policyDataFieldsPageObj.add_DateOfBirth().clear();
                            policyDataFieldsPageObj.add_DateOfBirth().sendKeys(fieldValue);
                        }
                        break;
                    case "birthdate":
                        if (fieldValue.equalsIgnoreCase("7daysbefore70thbirthday") || fieldValue.equalsIgnoreCase("30daysbefore70thbirthday") || fieldValue.equalsIgnoreCase("30daysbefore18thbirthday")
                                || fieldValue.equalsIgnoreCase("7daysbefore18thbirthday") || fieldValue.equalsIgnoreCase("30daysbefore23rdbirthday") || fieldValue.equalsIgnoreCase("7daysbefore23rdbirthday") || fieldValue.equalsIgnoreCase("70thbirthdayreached") || fieldValue.equalsIgnoreCase("30daysafter70thbirthday")) {
                            System.out.println("into birth date***********************");
                            System.out.println("Enter from date -----" + this.DobDate(fieldValue));
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            policyDataFieldsPageObj.addSub_DateOfBirth().clear();
                            nextEventPageObj.waitForMoreTime();
                            nextEventPageObj.waitForMoreTime();
                            policyDataFieldsPageObj.addSub_DateOfBirth().sendKeys(this.DobDate(fieldValue));
                        } else {
                            policyDataFieldsPageObj.addSub_DateOfBirth().clear();
                            policyDataFieldsPageObj.addSub_DateOfBirth().sendKeys(fieldValue);
                        }
                        break;
                }
            }
        }
        policyDataFieldsPageObj.policySave().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void captureAdditionalInformation(List<List<String>> lstInputs) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                switch (lstInputs.get(0).get(j).toLowerCase()) {
                    case "Special Requirements":
                        tmaDetailsPageObj.chxSpecialRequirements().sendKeys(lstInputs.get(i).get(j));
                        break;
                }
            }
        }
        policyDataFieldsPageObj.policySave().click();
    }

    public void captureTestingWPCardNotificationUpdate(List<List<String>> option) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < option.size(); i++) {
            for (int j = 0; j < option.get(0).size(); j++) {
                System.out.println("---option-----" + option.get(i).get(0));
                this.testingWPCardNotificationUpdate(option.get(0).get(j), option.get(i).get(j));
            }
        }
    }

    public void testingWPCardNotificationUpdate(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "WP CardToken":
                policyDataFieldsPageObj.wp_cardToken().clear();
                policyDataFieldsPageObj.wp_cardToken().sendKeys(fieldValue);
                break;
            case "WP MaskedCardNumber":
                policyDataFieldsPageObj.wp_MaskedCardNumber().clear();
                policyDataFieldsPageObj.wp_MaskedCardNumber().sendKeys(fieldValue);
                break;
            case "WP ExpiryMonth":
                policyDataFieldsPageObj.wp_ExpiryMonth().clear();
                policyDataFieldsPageObj.wp_ExpiryMonth().sendKeys(fieldValue);
                break;
            case "WP ExpiryYear":
                policyDataFieldsPageObj.wp_ExpiryYear().clear();
                policyDataFieldsPageObj.wp_ExpiryYear().sendKeys(fieldValue);
                break;
            case "WP CardType":
                policyDataFieldsPageObj.wp_CardType().clear();
                policyDataFieldsPageObj.wp_CardType().sendKeys(fieldValue);
                break;
            case "WP Payment Status":
                policyDataFieldsPageObj.wp_PaymentStatus().clear();
                policyDataFieldsPageObj.wp_PaymentStatus().sendKeys(fieldValue);
                break;
            case "WP Token Expiry Day of Month":
                policyDataFieldsPageObj.wp_TokenExpiryDayofMonth().clear();
                policyDataFieldsPageObj.wp_TokenExpiryDayofMonth().sendKeys(fieldValue);
                break;
            case "WP Token Expiry Month":
                policyDataFieldsPageObj.wp_TokenExpiryMonth().clear();
                policyDataFieldsPageObj.wp_TokenExpiryMonth().sendKeys(fieldValue);
                break;
            case "WP Token Expiry Year":
                policyDataFieldsPageObj.wp_TokenExpiryYear().clear();
                policyDataFieldsPageObj.wp_TokenExpiryYear().sendKeys(fieldValue);
                break;
            case "WP CardHolderName":
                policyDataFieldsPageObj.wp_CardHolderName().clear();
                policyDataFieldsPageObj.wp_CardHolderName().sendKeys(fieldValue);
                break;
            case "WP Address 1":
                policyDataFieldsPageObj.wp_Address1().clear();
                policyDataFieldsPageObj.wp_Address1().sendKeys(fieldValue);
                break;
            case "WP Address 2":
                policyDataFieldsPageObj.wp_Address2().clear();
                policyDataFieldsPageObj.wp_Address2().sendKeys(fieldValue);
                break;
            case "WP Postal Code":
                policyDataFieldsPageObj.wp_PostalCode().clear();
                policyDataFieldsPageObj.wp_PostalCode().sendKeys(fieldValue);
                break;
            case "WP City":
                policyDataFieldsPageObj.wp_City().clear();
                policyDataFieldsPageObj.wp_City().sendKeys(fieldValue);
                break;
            case "WP County":
                policyDataFieldsPageObj.wp_County().clear();
                policyDataFieldsPageObj.wp_County().sendKeys(fieldValue);
                break;
            case "WP CountryCode":
                policyDataFieldsPageObj.wp_CountryCode().clear();
                policyDataFieldsPageObj.wp_CountryCode().sendKeys(fieldValue);
                break;
        }
    }


    public void captureTestingWPSetToken(List<List<String>> option) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < option.size(); i++) {
            for (int j = 0; j < option.get(0).size(); j++) {
                System.out.println("---option-----" + option.get(i).get(0));
                Assert.assertTrue(policyDataFieldsPageObj.testing_WP(option.get(i).get(0)).isDisplayed());
            }
        }
        policySummaryPageObj.btnChequeSave().click();
        nextEventPageObj.waitForPageLoad();
    }

    public void captureLuggageRepatriation(List<List<String>> lstInputs) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                switch (lstInputs.get(0).get(j).toLowerCase()) {
                    case "Special Requirements":
                        tmaDetailsPageObj.chxSpecialRequirements().sendKeys(lstInputs.get(i).get(j));
                        break;
                }
            }
        }
        policyDataFieldsPageObj.policySave().click();
    }

    public void captureSupplierInstruction(List<List<String>> lstInputs) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                switch (lstInputs.get(0).get(j).toLowerCase()) {
                    case "supplier selection":
                        tmaDetailsPageObj.chxSupplierSelected().click();
                        break;
                    case "luggage repatriation inc":
                        tmaDetailsPageObj.chxluggageSelected().click();
                        break;
                }
            }
        }
        policyDataFieldsPageObj.policySave().click();
    }

    public void captureMissingPersonDetails(List<List<String>> lstInputs) {
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                this.enterMissingPersonDetails(lstInputs.get(0).get(j), lstInputs.get(i).get(j));
            }
        }
        nextEventPageObj.btnClick(policyDataFieldsPageObj.policySave());
        nextEventPageObj.waitForPageLoad();
        System.out.println("Inside Notify DLG Team checkbox validation");
    }

    private void enterMissingPersonDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "who is missing":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                nextEventPageObj.waitForPageLoad();
                System.out.println("Entering into Missing person details");
                policyDataFieldsPageObj.validateMissingPersonFieldValue(fieldName).clear();
                policyDataFieldsPageObj.validateMissingPersonFieldValue(fieldName).sendKeys(fieldValue);
                break;
            case "name and contact details of travelling companion if any":
                Assert.assertTrue(policyDataFieldsPageObj.validateTravellingCompanionFields(fieldName).isDisplayed());
                policyDataFieldsPageObj.validateTravellingCompanionFieldValue(fieldName).clear();
                policyDataFieldsPageObj.validateTravellingCompanionFieldValue(fieldName).sendKeys(fieldValue);
                break;
            case "name and contact details of any witnesses including last seen details date time location":
                Assert.assertTrue(policyDataFieldsPageObj.validateMissingPersonFields(fieldName).isDisplayed());
                policyDataFieldsPageObj.validateMissingPersonFieldValue(fieldName).clear();
                policyDataFieldsPageObj.validateMissingPersonFieldValue(fieldName).sendKeys(fieldValue);
                break;
            case "circumstances that led to the missing person report":
                Assert.assertTrue(policyDataFieldsPageObj.validateTravellingCompanionFields(fieldName).isDisplayed());
                policyDataFieldsPageObj.validateTravellingCompanionFieldValue(fieldName).clear();
                policyDataFieldsPageObj.validateTravellingCompanionFieldValue(fieldName).sendKeys(fieldValue);
                break;
            case "notify dlg media team":
            case "notify foreign embassy":
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                Assert.assertTrue(policyDataFieldsPageObj.validateTravellingCompanionFields(fieldName).isDisplayed());
                if (fieldValue.equalsIgnoreCase("true") && (policyDataFieldsPageObj.validateDLGMediaTeamCKboxValidation(fieldName).getAttribute("value").equalsIgnoreCase("false"))) {
                    policyDataFieldsPageObj.validateMissingPersonFieldValue(fieldName).click();
                }
                break;
            case "the foreign embassy has been notified":
                Assert.assertTrue(policyDataFieldsPageObj.validateTravellingCompanionFields(fieldName).isDisplayed());
                if (fieldValue.equalsIgnoreCase("true") && (policyDataFieldsPageObj.validateDLGMediaTeamCKboxValidation(fieldName).getAttribute("value").equalsIgnoreCase("false"))) {
                    policyDataFieldsPageObj.validateMissingPersonFieldValue(fieldName).click();
                    System.out.println("Inside Foreign embassy checkbox validation");
                }
                break;
            case "foreign embassy contact details":
                Assert.assertTrue(policyDataFieldsPageObj.validateMissingPersonFields(fieldName).isDisplayed());
                policyDataFieldsPageObj.validateMissingPersonFieldValue(fieldName).clear();
                policyDataFieldsPageObj.validateMissingPersonFieldValue(fieldName).sendKeys(fieldValue);
                break;
            case "travelling companion":
                Assert.assertTrue(policyDataFieldsPageObj.validateMissingPersonFields(fieldName).isDisplayed());
                policyDataFieldsPageObj.validateMissingPersonFieldValue(fieldName).clear();
                policyDataFieldsPageObj.validateMissingPersonFieldValue(fieldName).sendKeys(fieldValue);
                break;
        }
    }

    public void captureMissingPersonFoundDetails(List<List<String>> lstInputs) {
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                this.enterMissingPersonFoundDetails(lstInputs.get(0).get(j), lstInputs.get(i).get(j));
            }
        }
        policyDataFieldsPageObj.policySave().click();
    }

    private void enterMissingPersonFoundDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "missing person found details":
                policyDataFieldsPageObj.validateMissingPersonFieldValue(fieldName).clear();
                policyDataFieldsPageObj.validateMissingPersonFieldValue(fieldName).sendKeys(fieldValue);
                break;
            case "type of claim":
                policyDataFieldsPageObj.currentPatientStatus().click();
                policyDataFieldsPageObj.selectTypeOfClaim(fieldValue).click();
                break;
        }
    }

    public void validateTheDataInTheTabs(List<List<String>> parameters) {
        nextEventPageObj.switchToDefault();
        policySummaryPageObj.leadDetailsLink().click();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                switch (parameters.get(0).get(j).toLowerCase()) {
                    case "tab":
                        policyDataFieldsPageObj.tabToSelect(parameters.get(i).get(j)).click();
                        break;
                    case "marked deceased":
                        String flagDeceased = policyDataFieldsPageObj.deceasedMarkedInNamedPeopleTable().getText();
                        System.out.println("date of death -----------------flagDeceased--------------" + flagDeceased);
                        Assert.assertTrue(flagDeceased.equalsIgnoreCase(parameters.get(i).get(j)));
                        break;
                    case "date of death":
                        String dateOfDeath = customerDetailsFieldPageObj.dateOfDeath().getText();
                        System.out.println("date of death -------------------------------" + dateOfDeath);
                        //     Assert.assertTrue(dateOfDeath.equalsIgnoreCase(parameters.get(i).get(j)));
                        break;
                    case "cause of death":
                        String causeOfDeath = customerDetailsFieldPageObj.causeOfDeath().getAttribute("value");
                        System.out.println("causeOfDeath------------------------" + causeOfDeath);
                        Assert.assertTrue(causeOfDeath.equalsIgnoreCase(parameters.get(i).get(j)));
                        break;
                    case "details of death":
                        String detailsOfDeath = customerDetailsFieldPageObj.detailsOfDeath().getText();
                        System.out.println("detailsOfDeath----------------------------" + detailsOfDeath);
                        Assert.assertTrue(detailsOfDeath.equalsIgnoreCase(parameters.get(i).get(j)));
                        break;
                    case "location of death":
                        String locationOfDeath = customerDetailsFieldPageObj.locationOfDeath().getAttribute("value");
                        System.out.println("locationOfDeath-----------------------------" + locationOfDeath);
                        Assert.assertTrue(locationOfDeath.equalsIgnoreCase(parameters.get(i).get(j)));
                        break;
                    case "notify funeral director":
                        String notifyFuneralDirector = customerDetailsFieldPageObj.notifyFuneralDirector().getAttribute("checked");
                        System.out.println("notifyFuneralDirector--------------------------------" + notifyFuneralDirector);
                        Assert.assertTrue(notifyFuneralDirector.equalsIgnoreCase(parameters.get(i).get(j)));
                        break;
                    case "notify dlg media team":
                        String notifyDLGMediaTeam = customerDetailsFieldPageObj.notifyDLGMediaTeam().getAttribute("checked");
                        System.out.println("notifyDLGMediaTeam---------------------------" + notifyDLGMediaTeam);
                        Assert.assertTrue(notifyDLGMediaTeam.equalsIgnoreCase(parameters.get(i).get(j)));
                        break;
                    case "notify tim":
                        String notifyTim = customerDetailsFieldPageObj.notifyTIMTravelInsuranceManagement().getAttribute("checked");
                        System.out.println("notifyTim---------------------------" + notifyTim);
                        Assert.assertTrue(notifyTim.equalsIgnoreCase(parameters.get(i).get(j)));
                        break;
                }
            }
        }
        nextEventPageObj.btnCloseWindow().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void removeDeceasedPerson(String fieldName) {
        System.out.println("field name --------------------" + fieldName);
        switch (fieldName.toLowerCase()) {
            case "main account holder":
            case "joint account holder":
            case "daughter":
            case "guest":
            case "son":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("Inside out of process event");
                claimSummaryPageObj.outOfProcessEvent().click();
                nextEventPageObj.btnClick(nextEventPageObj.go());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                navigationObj.navigateToNextEventType("OOP Update Insured Persons");
                nextEventPageObj.switchToDefault();
                nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                policyDataFieldsPageObj.editCustomer(fieldName.trim()).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (policyDataFieldsPageObj.chkBk_RemoveNamedPerson().isSelected()) {
                    Assert.assertTrue(policyDataFieldsPageObj.chkBk_RemoveNamedPerson().isDisplayed());
                } else {
                    Assert.assertTrue(policyDataFieldsPageObj.chkBk_RemoveNamedPerson().isDisplayed());
                    policyDataFieldsPageObj.chkBk_RemoveNamedPerson().click();
                }
                policyDataFieldsPageObj.addInsuredPerson_SaveBtn().click();
                break;
        }
    }

    public String DobDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String returnValue = null;
        switch (date.toLowerCase()) {
            case "30daysafter70thbirthday":
                c.add(Calendar.YEAR, -70);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, -30);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "30daysbefore70thbirthday":
                c.add(Calendar.YEAR, -70);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, 30);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "7daysbefore70thbirthday":
                c.add(Calendar.YEAR, -70);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, 7);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "69years11months":
                c.add(Calendar.YEAR, -69);
                c.add(Calendar.MONTH, -11);
                c.add(Calendar.DATE, -25);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "69years10months":
                c.add(Calendar.YEAR, -69);
                c.add(Calendar.MONTH, -10);
                c.add(Calendar.DATE, -1);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "70thbirthdayreached":
                c.add(Calendar.YEAR, -70);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, 0);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "30daysbefore18thbirthday":
                c.add(Calendar.YEAR, -18);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, 30);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "7daysbefore18thbirthday":
                c.add(Calendar.YEAR, -18);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, 7);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "30daysbefore23rdbirthday":
                c.add(Calendar.YEAR, -23);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, 30);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "7daysbefore23rdbirthday":
                c.add(Calendar.YEAR, -23);
                c.add(Calendar.MONTH, 0);
                c.add(Calendar.DATE, 7);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
        }
        return returnValue;
    }

    public void updateCustomerDOB(int age) {
        if (age == 70) {
            String dob = this.DobDate("70thbirthdayreached");
            this.dateOfBirth(dob);
            System.out.println("Update Customer DOB as 70 yrs" + dob);
            policyDataFieldsPageObj.county().click();
            nextEventPageObj.waitForMoreTime();
        }
        policyDataFieldsPageObj.updateCustomer().click();
        nextEventPageObj.waitForMoreTime();
        try {
            Thread.sleep(8000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void capturePolicyId() {
        policyId = policyDataFieldsPageObj.txtPolicyId().getText();
        System.out.println("Policy id is----" + policyId);
    }

    public void enterNonPackagedPaymentDetails(List<List<String>> lstInputs) throws Throwable {
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                this.enterPaymentDetails(lstInputs.get(0).get(j), lstInputs.get(i).get(j));
            }
        }
    }

    public void makePolicyInactive(String value) {
        quoteDetailsPageObj.basePolicyLink().click();
        policyDataFieldsPageObj.dropDownPolicyStatus().click();
        policyDataFieldsPageObj.dropDownPolicyStatusValue(value).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteRenewalPageObj.saveAndClose().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void addNewScheme(List<List<String>> parameters) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String date = "";
        if (nextEventPageObj.elementDisplayed(By.xpath(schemeSummaryPageObj.addSchemebtnVisibility()))) {
            schemeSummaryPageObj.addSchemebtn().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                switch (parameters.get(0).get(j).toLowerCase()) {
                    case "cover":
                        schemeSummaryPageObj.addCover().click();
                        nextEventPageObj.switchToFrameById(policySummaryPageObj.addCoverBtnFrame());
                        schemeSummaryPageObj.selectCover(parameters.get(i).get(j)).click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.switchToDefault();
                        break;
                    case "date from":
                        schemeSummaryPageObj.dateFromtextbox().clear();
                        if (parameters.get(i).get(j).equalsIgnoreCase("today")) {
                            date = sdf.format(c.getTime());
                            schemeSummaryPageObj.dateFromtextbox().sendKeys(date);
                            System.out.println("From date entered" + date);
                        }
                        break;
                    case "date to":
                        schemeSummaryPageObj.dateTotextbox().clear();
                        if (parameters.get(i).get(j).equalsIgnoreCase("currentdate+30 days")) {
                            c.add(Calendar.DATE, 30);
                            date = sdf.format(c.getTime());
                            schemeSummaryPageObj.dateTotextbox().sendKeys(date);
                            System.out.println("To date entered" + date);
                        }
                        break;
                    case "retrieveschemeid":
                        retrievedSchemeID = schemeSummaryPageObj.retrieveSchemeID().getText();
                        System.out.println("Retrieved Scheme ID" + retrievedSchemeID);
                        break;
                }
            }
        }
        schemeSummaryPageObj.saveAndCloseBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateProductTermsAndConditions(String action, List<List<String>> parameters) {
        System.out.println("Validating retrieved schemeID" + retrievedSchemeID);
        schemeSummaryPageObj.editCreatedScheme(retrievedSchemeID).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (action.equalsIgnoreCase("validate")) {
            this.validateSchemeDetails(parameters);
        }
        if (action.equalsIgnoreCase("amend")) {
            this.amendSchemeDetails(parameters);

        }
    }

    public void validateSchemeDetails(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                switch (parameters.get(0).get(j).toLowerCase()) {
                    case "applicable insured persons":
                        schemeSummaryPageObj.covertermsTab().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        schemeSummaryPageObj.insertRecord_InsuredPersons().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        schemeSummaryPageObj.insuredPersonsTypedropdownImg().click();
                        nextEventPageObj.waitForMoreTime();
                        for (int t = 0; t < parameters.get(i).get(j).split("#").length; t++) {
                            Assert.assertTrue(schemeSummaryPageObj.insuredPersonsType(parameters.get(i).get(j).split("#")[t]).isDisplayed());
                            if (t == parameters.get(i).get(j).split("#").length - 1) {
                                schemeSummaryPageObj.insuredPersonsType(parameters.get(i).get(j).split("#")[t]).click();
                            }
                        }
                        break;
                    case "age limit":
                        schemeSummaryPageObj.ageLimitInputbox().clear();
                        schemeSummaryPageObj.ageLimitInputbox().sendKeys(parameters.get(i).get(j));
                        break;
                    case "independent travel":
                        schemeSummaryPageObj.independentTravelChkbox().click();
                        break;
                    case "in fulltime education":
                        schemeSummaryPageObj.fullTimeEducationChkbox().click();
                        break;
                    case "update insured persons":
                        schemeSummaryPageObj.updatebtnInsuredPersons().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "residency restriction":
                        schemeSummaryPageObj.residencyRestrictiondropdownImg().click();
                        Assert.assertTrue(schemeSummaryPageObj.residencyRequirementDropdownValues(parameters.get(i).get(j)).isDisplayed());
                        schemeSummaryPageObj.residencyRequirementDropdownValues(parameters.get(i).get(j)).click();
                        break;
                    case "maximum trip length":
                        schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).clear();
                        Assert.assertTrue(schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).isDisplayed());
                        schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).sendKeys(parameters.get(i).get(j));
                        break;
                    case "winter sports max days per year":
                        schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).clear();
                        Assert.assertTrue(schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).isDisplayed());
                        schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).sendKeys(parameters.get(i).get(j));
                        break;
                    case "home area minimum duration in days":
                        schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).clear();
                        Assert.assertTrue(schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).isDisplayed());
                        schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).sendKeys(parameters.get(i).get(j));
                        break;
                    case "geographical limit":
                        schemeSummaryPageObj.insertRecord_geographicalLimit().click();
                        schemeSummaryPageObj.geographicalLimitdropdownImg().click();
                        for (int t = 0; t < parameters.get(i).get(j).split("#").length; t++) {
                            Assert.assertTrue(schemeSummaryPageObj.geographicalLimitdropDownValues(parameters.get(i).get(j).split("#")[t]).isDisplayed());
                            if (t == parameters.get(i).get(j).split("#").length - 1) {
                                schemeSummaryPageObj.geographicalLimitdropDownValues(parameters.get(i).get(j).split("#")[t]).click();
                            }
                        }
                        break;
                    case "update geographical limit":
                        schemeSummaryPageObj.updatebtnInsuredPersons().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                }
            }
        }
        schemeSummaryPageObj.saveAndCloseBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void amendSchemeDetails(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                switch (parameters.get(0).get(j).toLowerCase()) {
                    case "applicable insured persons":
                        schemeSummaryPageObj.btnClick(schemeSummaryPageObj.covertermsTab());
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        schemeSummaryPageObj.amend_InsuredPersons().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        schemeSummaryPageObj.insuredPersonsTypedropdownImg().click();
                        nextEventPageObj.waitForMoreTime();
                        for (int t = 0; t < parameters.get(i).get(j).split("#").length; t++) {
                            Assert.assertTrue(schemeSummaryPageObj.insuredPersonsType(parameters.get(i).get(j).split("#")[t]).isDisplayed());
                        }
                        schemeSummaryPageObj.insuredPersonsType(parameters.get(i).get(j)).click();
                        break;
                    case "age limit":
                        schemeSummaryPageObj.ageLimitInputbox().clear();
                        schemeSummaryPageObj.ageLimitInputbox().sendKeys(parameters.get(i).get(j));
                        break;
                    case "independent travel":
                        schemeSummaryPageObj.independentTravelChkbox().click();
                        break;
                    case "in fulltime education":
                        schemeSummaryPageObj.fullTimeEducationChkbox().click();
                        break;
                    case "update insured persons":
                        schemeSummaryPageObj.updatebtnInsuredPersons().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "residency restriction":
                        schemeSummaryPageObj.residencyRestrictiondropdownImg().click();
                        Assert.assertTrue(schemeSummaryPageObj.residencyRequirementDropdownValues(parameters.get(i).get(j)).isDisplayed());
                        schemeSummaryPageObj.residencyRequirementDropdownValues(parameters.get(i).get(j)).click();
                        break;
                    case "maximum trip length":
                        schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).clear();
                        Assert.assertTrue(schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).isDisplayed());
                        schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).sendKeys(parameters.get(i).get(j));
                        break;
                    case "winter sports max days per year":
                        schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).clear();
                        Assert.assertTrue(schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).isDisplayed());
                        schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).sendKeys(parameters.get(i).get(j));
                        break;
                    case "home area minimum duration in days":
                        schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).clear();
                        Assert.assertTrue(schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).isDisplayed());
                        schemeSummaryPageObj.tripLengthInputBox(parameters.get(0).get(j)).sendKeys(parameters.get(i).get(j));
                        break;
                    case "geographical limit":
                        schemeSummaryPageObj.amend_GeographicalLimit().click();
                        schemeSummaryPageObj.geographicalLimitdropdownImg().click();
                        for (int t = 0; t < parameters.get(i).get(j).split("#").length; t++) {
                            Assert.assertTrue(schemeSummaryPageObj.geographicalLimitdropDownValues(parameters.get(i).get(j).split("#")[t]).isDisplayed());
                        }
                        schemeSummaryPageObj.geographicalLimitdropDownValues(parameters.get(i).get(j)).click();
                        break;
                    case "update geographical limit":
                        schemeSummaryPageObj.updatebtnInsuredPersons().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                }
            }
        }
        schemeSummaryPageObj.saveAndCloseBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void updateSchemeDetails(String scheme, List<List<String>> parameters) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String date = "";
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (nextEventPageObj.elementDisplayed(By.xpath(schemeSummaryPageObj.validityOfBlackCoverScheme(scheme)))) {
            schemeSummaryPageObj.selectBlackCoverScheme(scheme).click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                switch (parameters.get(0).get(j).toLowerCase()) {
                    case "date to":
                        schemeSummaryPageObj.dateTotextbox().clear();
                        if (parameters.get(i).get(j).equalsIgnoreCase("today")) {
                            c.add(Calendar.DATE, 0);
                            date = sdf.format(c.getTime());
                            schemeSummaryPageObj.dateTotextbox().sendKeys(date);
                            System.out.println("To date entered" + date);
                        }
                        break;
                    case "action":
                        if (parameters.get(i).get(j).equalsIgnoreCase("save")) {
                            basicClaimDetailsPageObj.editSave().click();
                        }
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        break;
                    case "upgradevalidity":
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        schemeSummaryPageObj.upgradeTabInScheme().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        Assert.assertTrue(schemeSummaryPageObj.toValidateUpgradeAvailability(parameters.get(i).get(j)).isDisplayed());
                        break;
                    case "date from":
                        schemeSummaryPageObj.dateFromtextbox().clear();
                        if (parameters.get(i).get(j).equalsIgnoreCase("today")) {
                            c.add(Calendar.DATE, 1);
                            date = sdf.format(c.getTime());
                            schemeSummaryPageObj.dateFromtextbox().sendKeys(date);
                            System.out.println("From date entered" + date);
                        }
                        break;
                    case "upgrade non availablity":
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        schemeSummaryPageObj.upgradeTabInScheme().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        Assert.assertTrue(!commandsObj.elementDisplayedWithLessTime(By.xpath(schemeSummaryPageObj.validateUpgradeNonAvailability(parameters.get(i).get(j)))));
                        break;
                }
            }
        }
        schemeSummaryPageObj.saveAndCloseBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void confirmationOfCoverLetter(String nextAction, List<List<String>> parameters) {
        System.out.println("Inside go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.btnClick(nextEventPageObj.go());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        navigationObj.navigateToNextEventType(nextAction);
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                switch (parameters.get(0).get(j).toLowerCase()) {
                    case "who requested":
                        policyDataFieldsPageObj.whoRequestTextBox().clear();
                        policyDataFieldsPageObj.whoRequestTextBox().sendKeys(parameters.get(i).get(j));
                        break;
                    case "cover letter additional text":
                        policyDataFieldsPageObj.additionalTextBox().clear();
                        policyDataFieldsPageObj.additionalTextBox().sendKeys(parameters.get(i).get(j));
                        break;
                }
            }
        }
        policyDataFieldsPageObj.policySave().click();
    }

    public void retrieveJointAcctHolders() {
        List<WebElement> jointAcctSize = nextEventPageObj.findElements(By.xpath(policyDataFieldsPageObj.lblJointAcctHolders()));
        int totalJointDisplayed = jointAcctSize.size();
        System.out.println("Total no. of Joint account holders displayed -----" + totalJointDisplayed);
    }

    public void validateMarketingPreference(List<List<String>> parameters) {
        policyDataFieldsPageObj.moreDetails().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                String searchField = parameters.get(0).get(j);
                String searchValue = parameters.get(i).get(j);
                switch (searchField) {
                    case "marketing preference":
                        nextEventPageObj.switchToDefault();
                        policyDataFieldsPageObj.commPreferenceTab().click();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        Assert.assertTrue(policyDataFieldsPageObj.retrievingMarketingPreferenceValue().getAttribute("value").equalsIgnoreCase(searchValue));
                        break;
                }
            }
        }
    }

    public void selectCover(String strCoverName) {
        policyDataFieldsPageObj.getDriver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
        policyDataFieldsPageObj.waitForMoreTime();
        policyDataFieldsPageObj.waitForMoreTime();
        policyDataFieldsPageObj.waitForMoreTime();
        policyDataFieldsPageObj.switchToWindowByIndex(1);
        policyDataFieldsPageObj.selectCoverDescFilterTextBox().sendKeys(strCoverName);
        policyDataFieldsPageObj.selectCoverDescFilterImg().click();
        policyDataFieldsPageObj.waitForMoreTime();
        policyDataFieldsPageObj.waitForMoreTime();
        policyDataFieldsPageObj.waitForMoreTime();
        if (System.getProperty("driverType") != null && System.getProperty("driverType").equalsIgnoreCase("ie")) {
            policyDataFieldsPageObj.waitForMoreTime();
            policyDataFieldsPageObj.waitForMoreTime();
            policyDataFieldsPageObj.waitForMoreTime();
            policyDataFieldsPageObj.waitForMoreTime();
            policyDataFieldsPageObj.waitForMoreTime();
            policyDataFieldsPageObj.waitForMoreTime();
        }
        policyDataFieldsPageObj.containsFilter().click();
        policyDataFieldsPageObj.waitForMoreTime();
        policyDataFieldsPageObj.waitForMoreTime();
        policyDataFieldsPageObj.waitForMoreTime();
        if (System.getProperty("driverType") != null && System.getProperty("driverType").equalsIgnoreCase("ie")) {
            policyDataFieldsPageObj.waitForMoreTime();
            policyDataFieldsPageObj.waitForMoreTime();
            policyDataFieldsPageObj.waitForMoreTime();
            policyDataFieldsPageObj.waitForMoreTime();
            policyDataFieldsPageObj.waitForMoreTime();
            policyDataFieldsPageObj.waitForMoreTime();
        }
        policyDataFieldsPageObj.selectCover(strCoverName).click();
    }

    public void authorisationMTCRefundRequest(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "refund allowed":
                claimSummaryPageObj.selectMTCRefunddrpdown().click();
                claimSummaryPageObj.selectMTCRefundApproval(fieldValue).click();
                break;
        }
    }

    public void backDatingThePolicy() {
        claimOperationObj.clickingUnderNextEventsAndButtons("out of process event");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimOperationObj.navigateToEventType("__TestRenewals");
        quoteRenewalPageObj.txtXdaysPrior().sendKeys("100");
        quoteRenewalPageObj.txtXdaysPrior().sendKeys(Keys.TAB);
        nextEventPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void captureRepatriationDetails(List<List<String>> lstInputs) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        System.out.println("into captureRepatriationDetails********");
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get(0).size(); j++) {
                String fieldName = lstInputs.get(0).get(j);
                String fieldValue = lstInputs.get(i).get(j);
                switch (fieldName) {
                    case "Escorted":
                        tmaDetailsPageObj.escorted().click();
                        tmaDetailsPageObj.drpdnEscorted(fieldValue).click();
                        break;
                    case "On Original Flight":
                        tmaDetailsPageObj.chkBxOnOriginalFlight().click();
                        break;
                    case "Flight Details":
                        nextEventPageObj.waitForMoreTime();
                        tmaDetailsPageObj.txtFlightDetails().sendKeys(fieldValue);
                    case "Business":
                        tmaDetailsPageObj.chkBxBusiness().click();
                        break;
                    case "Extra Seats":
                        System.out.println("Extra seats chkbox checked......");
//                        if (fieldValue.equalsIgnoreCase("True")) {
                        tmaDetailsPageObj.chkBxExtraSeats().click();
                        break;
                    case "How Many Seats Required":
                        nextEventPageObj.waitForMoreTime();
                        tmaDetailsPageObj.seatsRequired().sendKeys(fieldValue);
                        break;
                    case "Oxygen Required":
                        tmaDetailsPageObj.oxygenRequired().sendKeys(fieldValue);
                        break;
                    case "Litres Of Oxygen Required":
                        tmaDetailsPageObj.litresOfOxygenRequired().sendKeys(fieldValue);
                        break;
                    case "Air Ambulance":
                        tmaDetailsPageObj.airAmbulance().click();
                        tmaDetailsPageObj.drpdnAirAmbulance(fieldValue).click();
                        break;
                    case "Stretcher":
                        tmaDetailsPageObj.chkBxStretcher().click();
                        break;
                    case "Non Medical Escort":
                        tmaDetailsPageObj.chkBxNonMedicalEscort().click();
                        break;
                    case "Deceased":
                        tmaDetailsPageObj.chkBxDeceased().click();
                        break;
                    case "Wheelchair Assistance":
                        tmaDetailsPageObj.wheelChairAssistance().click();
                        tmaDetailsPageObj.drpdnWheelChairAssistance(fieldValue).click();
                        break;
                    case "Admission":
                        tmaDetailsPageObj.chkBxAdmission().click();
                        break;
                    case "UK Hospital Details":
                        tmaDetailsPageObj.txtUKHospitalDetails().sendKeys(fieldValue);
                        break;
                    case "Intl Ambulance Repatriation":
                        tmaDetailsPageObj.chkBxIntlAmbulanceRepatriation().click();
                        break;
                    case "Repatriation By Train":
                        tmaDetailsPageObj.chkBxRepatriationByTrain().click();
                        break;
                    case "Repatriation By Boat":
                        tmaDetailsPageObj.chkBxRepatriationByBoat().click();
                        break;
                    case "No Repatriation Required":
                        tmaDetailsPageObj.chkBxNoRepatriationRequired().click();
                        break;
                    case "Action":
                        nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();
                        policyDataFieldsPageObj.policySave().click();
                        break;
                }
            }
        }
    }

    public void validateJointAccountHolderDetails(int count) throws Exception {
        System.out.println("Inside validateJointAccountHolderDetails************");
        namedPeopleCount = policySummaryPageObj.jointAccountHolderCount();
        j = 1;
        jhCount = count;
        for (int i = 4; i <= namedPeopleCount; i++) {
            String rowValue = policySummaryPageObj.jointAccountHolderDetails(i);
            Assert.assertTrue(rowValue.equalsIgnoreCase("Secondary") || rowValue.equalsIgnoreCase("Joint Account Holder"));
            System.out.println("Joint Account Holder***" + j + "***details are managed within base policy");
            i = i + 1;
            j = j + 1;
        }
        j = j - 1;
        Assert.assertTrue(jhCount == j);
        System.out.println("All the joint acount holder details are populated in UI");
    }

    public void verifyCustomerTab() throws InterruptedException {
        policySummaryPageObj.customerDetailsTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        fname1 = policyDataFieldsPageObj.firstName().getAttribute("value");
        System.out.println("FirstName from Customer tab*******" + fname1);
        System.out.println("FirstName from Affinion*******" + mappingFieldValues.firstName);
        Assert.assertTrue(fname1.equalsIgnoreCase(mappingFieldValues.firstName));
        lname = policyDataFieldsPageObj.lastName().getAttribute("value");
        System.out.println("LastName from Customer tab*******" + lname);
        System.out.println("LastName from Affinion*******" + mappingFieldValues.lastName);
        Assert.assertTrue(lname.equalsIgnoreCase(mappingFieldValues.lastName));
        dob = new Date(policyDataFieldsPageObj.dateOfBirth().getAttribute("value"));
        System.out.println("dob from Customer tab before formating*******" + dob);
        SimpleDateFormat dateFormatObj = new SimpleDateFormat("yyyyMMdd");
        Date = dateFormatObj.format(dob);
        System.out.println("dob from Customer tab after formating*******" + Date);
        System.out.println("DOB from Affinion*******" + mappingFieldValues.dob);
        Assert.assertTrue(Date.equalsIgnoreCase(mappingFieldValues.dob));
        address1 = policyDataFieldsPageObj.addressLine1().getAttribute("value");
        System.out.println("address1 from Customer tab*******" + address1);
        System.out.println("Address2 from Affinion*******" + mappingFieldValues.address2);
        Assert.assertTrue(address1.equalsIgnoreCase(mappingFieldValues.address2));
        town = policyDataFieldsPageObj.town().getAttribute("value");
        System.out.println("town from Customer tab*******" + town);
        System.out.println("country from Affinion*******" + mappingFieldValues.country);
        Assert.assertTrue(town.equalsIgnoreCase(mappingFieldValues.country));
        postcode = policyDataFieldsPageObj.postCode().getAttribute("value");
        System.out.println("postcode from Customer tab*******" + postcode);
        System.out.println("postcode from Affinion*******" + mappingFieldValues.postCode);
        Assert.assertTrue(postcode.equalsIgnoreCase(mappingFieldValues.postCode));
        email = policyDataFieldsPageObj.emailId().getAttribute("value");
        System.out.println("email from Customer tab*******" + email);
        System.out.println("email from Affinion*******" + mappingFieldValues.email);
        Assert.assertTrue(email.equalsIgnoreCase(mappingFieldValues.email));
        mobile = policyDataFieldsPageObj.mobileNo().getAttribute("value");
        System.out.println("mobile from Customer tab*******" + mobile);
        System.out.println("mobile from Affinion*******" + mappingFieldValues.mobile);
        Assert.assertTrue(mobile.equalsIgnoreCase(mappingFieldValues.mobile));
        System.out.println("Sysout after final assertion*****");
    }

    //    TODO Customer details tab to be changed as Partner once build is available. Change the webelement based on Partner tab
    public void verifyCustomerTabName(String name) {
        customerTabName = policySummaryPageObj.customerDetailsTab().getAttribute("name");
        System.out.println("customerTabName Attribute*****" + customerTabName);
        Assert.assertTrue(customerTabName.contains(name));
        System.out.println("*********Assertion for Customer tab name passed*****");
    }

    public void updateCustomerEmailId(String emailId) {
        email = policyDataFieldsPageObj.emailId().getAttribute("value");
        System.out.println("Email Id before updating*****" + email);
        policyDataFieldsPageObj.emailId().clear();
        policyDataFieldsPageObj.emailId().sendKeys(emailId);
        policyDataFieldsPageObj.updateCustomer().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        updatedEmailId = policyDataFieldsPageObj.emailId().getAttribute("value");
        System.out.println("Email Id after updating*****" + updatedEmailId);
        Assert.assertTrue(updatedEmailId.equalsIgnoreCase(emailId));
        System.out.println("*****Email update Assertion Passed*****");
    }

    public void enterJointData(String fieldName, String fieldValue) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        switch (fieldName.toLowerCase()) {
            case "mobile":
                policyDataFieldsPageObj.mobileText().clear();
                policyDataFieldsPageObj.mobileText().sendKeys(fieldValue);
                break;
            case "email":
                policyDataFieldsPageObj.email().clear();
                policyDataFieldsPageObj.email().sendKeys(fieldValue);
                break;
            case "dateofbirth":
                policyDataFieldsPageObj.dobJoint().clear();
                policyDataFieldsPageObj.dobJoint().sendKeys(fieldValue);
                break;
        }
    }
}