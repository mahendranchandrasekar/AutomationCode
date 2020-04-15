package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.WeakHashMap;

/**
 * Created by 588800 on 11/21/2017.
 */
public class AffinionOperations {

    private IReportingOperations iReportingOperationsObj = new IReportingOperations();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private QuoteDetailsPage quoteDetailsPageObj = new QuoteDetailsPage();
    private AccountInformationPage accountInformationPageObj = new AccountInformationPage();
    private SearchPage searchPageObj = new SearchPage();
    private Commands commandsObj = new Commands();
    private PolicySummaryPage policySummaryPage = new PolicySummaryPage();

    public void validateAffinionPolicyCreation() {
        System.out.println("aff-0-------------------------" + iReportingOperationsObj.affinionData);
        String[] receivedFeed = iReportingOperationsObj.affinionData.split(" ");
        String accountType = receivedFeed[0].substring(receivedFeed[0].length() - 2);
        System.out.println("Received account type-------" + accountType);
        Assert.assertTrue(!policyDataFieldsPageObj.policyNumber().getText().isEmpty());
        this.validateAccountType(accountType);
    }

    public void validateMultipleAccountType(){
        String accountType ="";
        List<WebElement> searchResults = nextEventPageObj.findElements(By.xpath(searchPageObj.tableSearchResult()));
        for(int i=1;i<=searchResults.size();i++)
        {
            searchPageObj.lnkSearchResults(i).click();
            nextEventPageObj.switchToLastOpenWindow();
           this.validateAccountType(accountType);
            commandsObj.closeNextWindow();
        }
    }

    public void validateAccountType(String accountType)
    {
        if (accountType.equalsIgnoreCase("ZQ")) {
            Assert.assertTrue(policyDataFieldsPageObj.lblPolicyType().getText().contains("Black Cover"));
        } else if (accountType.equalsIgnoreCase("ZM") || accountType.equalsIgnoreCase("QC")) {
            Assert.assertTrue(policyDataFieldsPageObj.lblPolicyType().getText().equalsIgnoreCase("Silver Cover"));
        } else if (accountType.equalsIgnoreCase("WX")) {
            Assert.assertTrue(policyDataFieldsPageObj.lblPolicyType().getText().contains("Platinum Cover"));
        }
    }

    public void validateCoveredPersons(List<String> parameters) {
        quoteDetailsPageObj.leadDetailsTab().click();
        commandsObj.waitForLoad(nextEventPageObj.getDriver);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        quoteDetailsPageObj.namedPeopleTab().click();
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(),60L);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 0; i < parameters.size(); i++) {
            this.verifyAffinionFeedDetails(parameters.get(i));
        }
    }

    private void verifyAffinionFeedDetails(String fieldName) {
        String[] receivedFeed = iReportingOperationsObj.affinionData.split(" ");
        switch (fieldName.toLowerCase()) {
            case "main account holder":
                Assert.assertTrue(policyDataFieldsPageObj.lblMainAcctHolderFirstName().getText().equalsIgnoreCase(receivedFeed[2]));
                Assert.assertTrue(policyDataFieldsPageObj.lblMainAcctHolderLastName().getText().equalsIgnoreCase(receivedFeed[3]));
                System.out.println("Main account holder name ------" + receivedFeed[2] + " " + receivedFeed[3]);
                break;
            case "join account holder":
                if (receivedFeed[4].concat(receivedFeed[5]).isEmpty()) {
                    System.out.println("Haven't received feed for joint account holder.....");
                } else {
                    Assert.assertTrue(policyDataFieldsPageObj.lblJointAcctHolderFirstName().getText().equalsIgnoreCase(receivedFeed[4]));
                    Assert.assertTrue(policyDataFieldsPageObj.lblJointAcctHolderLastName().getText().equalsIgnoreCase(receivedFeed[5]));
                    System.out.println("Main account holder name ------" + receivedFeed[4] + " " + receivedFeed[5]);
                }
                break;
            case "date":
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue(policyDataFieldsPageObj.txtAcctOpenDate().getAttribute("value").equalsIgnoreCase(receivedFeed[1]));
                break;
        }
    }

    public void validateAcctOpeningDate(List<String> parameters) {
        policyDataFieldsPageObj.tabAccountDetails().click();
        for (int i = 1; i < parameters.size(); i++) {
            this.verifyAffinionFeedDetails(parameters.get(i));
        }
    }

    public void validateTheMatchingDataFromAffion(String criterias) {
        for (int i = 0; i < criterias.split("#").length; i++) {
            switch (criterias.split("#")[i]) {
                case "Brand":
                    String brand = iReportingOperationsObj.uniqueFileText;
                    String fieldValue = brand.substring(0,brand.length()-2);
                    System.out.println("Brand --------"+fieldValue);
                    if(fieldValue.equalsIgnoreCase("RBSPCKGMBR"))
                    {
                        Assert.assertTrue(policySummaryPage.productName().getText().equalsIgnoreCase("RBS"));
                    }
                    else if(fieldValue.equalsIgnoreCase("NATPCKGMBR"))
                    {
                        Assert.assertTrue(policySummaryPage.productName().getText().equalsIgnoreCase("Natwest"));
                    }
                    break;
                case "FirstName":
                    System.out.println("First name -----------"+iReportingOperationsObj.primaryMemberFirstName);
                    Assert.assertTrue(accountInformationPageObj.randomCusomerFirstName().getText().equalsIgnoreCase(iReportingOperationsObj.primaryMemberFirstName));
                    break;
                case "LastName":
                    System.out.println("Last name -----------"+iReportingOperationsObj.primaryMemberLastName);
                    Assert.assertTrue(accountInformationPageObj.randomCusomerLastName().getText().equalsIgnoreCase(iReportingOperationsObj.primaryMemberLastName));
                    break;
                case "Postcode":
                    System.out.println("postcode---------------------"+iReportingOperationsObj.mailingAddressPostCode);
                   // System.out.println("accountInformationPageObj.postcode()----------------"+accountInformationPageObj.postcode().getAttribute("value"));
                    System.out.println("accountInformationPageObj.postcode()----------------"+policyDataFieldsPageObj.postCode().getAttribute("value"));
                    //Assert.assertTrue(accountInformationPageObj.postcode().getAttribute("value").equalsIgnoreCase(iReportingOperationsObj.mailingAddressPostCode));
                    break;
                case "AccountNo":
                    System.out.println("postcode---------------------"+iReportingOperationsObj.accountNumber);
                    Assert.assertTrue(accountInformationPageObj.accountNumber().getText().equalsIgnoreCase(iReportingOperationsObj.accountNumber));
                    break;
                case "CustomerID":
                    System.out.println("postcode---------------------"+iReportingOperationsObj.customerID);
                    Assert.assertTrue(accountInformationPageObj.customerID().getText().equalsIgnoreCase(iReportingOperationsObj.customerID));
                    break;
                case "PolicyId":
                    Assert.assertTrue(policyDataFieldsPageObj.policyNumber().getText().equalsIgnoreCase(iReportingOperationsObj.policyAdminMatterID));
                    break;
            }
        }
    }

    public void validateUpdatedFieldValue(String updatedField) {
        for (int i = 0 ; i < updatedField.split("#").length ; i++){
            String fieldName = updatedField.split("#")[i].split("-")[0];
            System.out.println("fieldname ---------------------------- "+fieldName);
            String fieldValue = updatedField.split("#")[i].split("-")[1];
            System.out.println("fieldValue ---------------------------- "+fieldValue);
            switch (fieldName){
                case "MobileNo":
                    Assert.assertTrue(policyDataFieldsPageObj.mobileNo().getAttribute("value").equalsIgnoreCase(fieldValue));
                    break;
                case "Email":
                    Assert.assertTrue(policyDataFieldsPageObj.email().getAttribute("value").equalsIgnoreCase(fieldValue));
                    break;
            }
        }
    }

    public void validateUpdatedAffinionFieldValue(String updatedField) {
        for (int i = 0 ; i < updatedField.split("#").length ; i++){
            String fieldName = updatedField.split("#")[i];
            System.out.println("fieldname ---------------------------- "+fieldName);
            System.out.println("iReportingOperationsObj.affinionHomePhone:: "+iReportingOperationsObj.affinionHomePhone);
            System.out.println("iReportingOperationsObj.affinionEmail:: "+iReportingOperationsObj.affinionEmail);
            System.out.println("mobileNo:: "+policyDataFieldsPageObj.mobileNo().getAttribute("value"));
            System.out.println("email:: "+policyDataFieldsPageObj.email().getAttribute("value"));

            switch (fieldName){
                case "MobileTelephone":
                    Assert.assertTrue(policyDataFieldsPageObj.mobileNo().getAttribute("value").equalsIgnoreCase(iReportingOperationsObj.affinionHomePhone));
                    break;
                case "EmailAddress":
                    Assert.assertTrue(policyDataFieldsPageObj.email().getAttribute("value").equalsIgnoreCase(iReportingOperationsObj.affinionEmail));
                    break;
            }
        }
    }
}
