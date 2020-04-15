package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.CustomerPortalMyPolicyPage;
import co.uk.directlinegroup.tt.pages.CustomerPortalSignInPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.pages.QuoteDetailsPage;
import co.uk.directlinegroup.tt.utils.common.RandomGenerator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by 588800 on 10/4/2017.
 */
public class CustomerPortalMyPolicyOperations {

    private CustomerPortalMyPolicyPage customerPortalMyPolicyPageObj = new CustomerPortalMyPolicyPage();
    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private QuoteDetailsPage quoteDetailsPageObj = new QuoteDetailsPage();
    private RandomGenerator randomGeneratorObj = new RandomGenerator();
    private CustomerPortalSignInPage customerPortalSignInPageObj = new CustomerPortalSignInPage();
    private PolicyOperations policyOperationsObj = new PolicyOperations();
    private QuoteAndBuyOperations quoteAndBuyOperationsObj = new QuoteAndBuyOperations();

    public static String randomUserFname = "";
    public static String randomUserLname = "";
    public static String updatedEmailID = "";

    public void validateDocuments(List<List<String>> parameters) throws InterruptedException {
        for (int i = 0; i < parameters.size(); i++) {
            System.out.println("----------i----------value ---" + i);
            for (int j = 0; j < parameters.get(i).size(); j++) {
                System.out.println("----------j----------value ---" + j);
                this.verifyAvailableDocuments(parameters.get(i).get(j));
            }
        }
    }

    private void verifyAvailableDocuments(String fieldName) throws InterruptedException {
        switch (fieldName) {
            case "Medical Screening Letter":
                try {
                    System.out.println("Awaiting for purchase letter...");
                    nextEventPageObj.getDriver.navigate().refresh();
                    Thread.sleep(50000L);
                    nextEventPageObj.getDriver.navigate().refresh();
                    Thread.sleep(50000L);
                } catch (NoSuchElementException ne) {
                    System.out.println("Handling No such element exception....");
                    Thread.sleep(5000L);
                    nextEventPageObj.getDriver.navigate().refresh();
                    Thread.sleep(5000L);
                } catch (Exception e) {
                    System.out.println("Handling exception....");
                    nextEventPageObj.getDriver.navigate().refresh();
                    Thread.sleep(5000L);
                }
                System.out.println("Click download link....");
                nextEventPageObj.btnClick(customerPortalMyPolicyPageObj.lnkPurchaseLetter());
                Thread.sleep(5000L);
                this.validateDownloadedDocFileSize();
                break;
            case "New Upgrade Purchase":
                System.out.println("New Upgrade Purchase....");
                Thread.sleep(5000L);
                nextEventPageObj.getDriver.navigate().refresh();
                nextEventPageObj.btnClick(customerPortalMyPolicyPageObj.lnkPurchaseLetter());
                Thread.sleep(5000L);
        }
    }

    public void validateCoverLetter() {
        nextEventPageObj.waitForMoreTime();
        customerPortalMyPolicyPageObj.lnkCoverLetter().click();
        nextEventPageObj.switchToLastOpenWindow();
        System.out.println("Confirmation Cover title ..... " + nextEventPageObj.getDriver.getTitle().toString());

        if (nextEventPageObj.getDriver.getTitle().toString().equalsIgnoreCase("Internal Server Error") || nextEventPageObj.elementDisplayed(By.id("reload-button"))) {
            System.out.println("Confirmation Cover title ..... " + nextEventPageObj.getDriver.getTitle().toString());
            Assert.assertTrue(false);
        } else {
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void validateDownloadedDocFileSize() {
        try {
            Thread.sleep(10000L);
            int fileSize = 0;
            System.out.println("user dir -----" + System.getProperty("user.dir"));
            fileSize = (int) claimsOperationsObj.fileSize();
            System.out.println("file size----------------------------" + fileSize);
            Assert.assertTrue(fileSize > 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validatePersonalDetails(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            System.out.println("----------i----------value ---" + i);
            for (int j = 0; j < parameters.get(i).size(); j++) {
                System.out.println("----------j----------value ---" + j);
                this.verifyPersonalDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void verifyPersonalDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "account holder name":
                if (fieldValue.equalsIgnoreCase("Registered Customer")) {
                    String fname = customerPortalMyPolicyPageObj.lblAcctHolderName().getText().split(" ")[1];
                    String lname = customerPortalMyPolicyPageObj.lblAcctHolderName().getText().split(" ")[2];
                    String accountHolderName = fname.concat(" " + lname);
                    System.out.println("Name from AQ -------" + quoteAndBuyOperationsObj.randomCustomerFullName);
                    System.out.println("Name -----" + accountHolderName.trim());
                    Assert.assertTrue(accountHolderName.trim().equalsIgnoreCase(quoteAndBuyOperationsObj.randomCustomerFullName.trim()));
                }else if(fieldValue.equalsIgnoreCase("API Customer")){
                    String fname = customerPortalMyPolicyPageObj.lblAcctHolderName().getText().split(" ")[1];
                    String lname = customerPortalMyPolicyPageObj.lblAcctHolderName().getText().split(" ")[2];
                    String accountHolderName = fname.concat(" " + lname);
                    String fullname=PolicyOperations.retrieveRandomCustomerFirstName.concat(" "+quoteAndBuyOperationsObj.randomCustomerLastName);
                    Assert.assertTrue(accountHolderName.equalsIgnoreCase(fullname));
                }
                else {
                    System.out.println("Field value -------" + fieldValue);
                    System.out.println("Name -----" + customerPortalMyPolicyPageObj.lblAcctHolderName().getText());
                    Assert.assertTrue(customerPortalMyPolicyPageObj.lblAcctHolderName().getText().equalsIgnoreCase(fieldValue));
                }
                break;
            case "dob":
                System.out.println("Field value -------" + fieldValue);
                System.out.println("DOB -----" + customerPortalMyPolicyPageObj.lblDOB().getText());
                Assert.assertTrue(customerPortalMyPolicyPageObj.lblDOB().getText().equalsIgnoreCase(fieldValue));
                break;
            case "email":
                if (fieldValue.equalsIgnoreCase("Registered EmailID")) {
                    System.out.println("Registered Email ID value -------" + policyOperationsObj.randomEmailID);
                    System.out.println("Email -----" + customerPortalMyPolicyPageObj.lblEmail().getText());
                    Assert.assertTrue(customerPortalMyPolicyPageObj.lblEmail().getText().equalsIgnoreCase(policyOperationsObj.randomEmailID));
                } else {
                    System.out.println("Field value -------" + fieldValue);
                    System.out.println("Email -----" + customerPortalMyPolicyPageObj.lblEmail().getText());
                    Assert.assertTrue(customerPortalMyPolicyPageObj.lblEmail().getText().equalsIgnoreCase(fieldValue));
                }
                break;
            case "main telephone":
                System.out.println("Field value -------" + fieldValue);
                System.out.println("Telephone -----" + customerPortalMyPolicyPageObj.lblTelephone().getText());
                Assert.assertTrue(customerPortalMyPolicyPageObj.lblTelephone().getText().equalsIgnoreCase(fieldValue));
                break;
            case "mobile":
                System.out.println("Field value -------" + fieldValue);
                System.out.println("Mobile -----" + customerPortalMyPolicyPageObj.lblMobile().getText());
                Assert.assertTrue(customerPortalMyPolicyPageObj.lblMobile().getText().equalsIgnoreCase(fieldValue));
                break;
        }
    }

    public void enterGPDetails(String fieldValue) {
        if (!fieldValue.equalsIgnoreCase("nothing")) {
            String[] gpFieldValues = fieldValue.split(";");
            System.out.println("GP Field Values-------------------------" + gpFieldValues.length);
            System.out.println("GP field level details--------------------------" + "----GP Consent----" + gpFieldValues[0] + " ---- Name ------" + gpFieldValues[1] + "---GP Phone------" + gpFieldValues[2] + "-----Address---------" + gpFieldValues[3]);
            if (gpFieldValues[0].equalsIgnoreCase("yes"))
                customerPortalMyPolicyPageObj.btnYesGP().click();
            customerPortalMyPolicyPageObj.txtGPName().sendKeys(gpFieldValues[1]);
            customerPortalMyPolicyPageObj.txtGPPracticeName().sendKeys(gpFieldValues[1]);
            customerPortalMyPolicyPageObj.txtGPPhone().sendKeys(gpFieldValues[2]);
            customerPortalMyPolicyPageObj.btnAddrLookup().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            System.out.println("Postcode value-----" + gpFieldValues[3]);
            System.out.println(customerPortalMyPolicyPageObj.txtPostcode().isDisplayed());
            customerPortalMyPolicyPageObj.txtPostcode().isDisplayed();
            customerPortalMyPolicyPageObj.txtPostcode().click();
            customerPortalMyPolicyPageObj.txtPostcode().sendKeys(gpFieldValues[3]);
            nextEventPageObj.waitForMoreTime();
            customerPortalMyPolicyPageObj.btnFindAddress().click();
            nextEventPageObj.waitForMoreTime();
            customerPortalMyPolicyPageObj.selectAddress().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(customerPortalMyPolicyPageObj.btnSelectAddress());
            nextEventPageObj.waitForMoreTime();
            if(customerPortalMyPolicyPageObj.txtGPCounty().isDisplayed()){
                customerPortalMyPolicyPageObj.txtGPCounty().click();
                customerPortalMyPolicyPageObj.txtGPCounty().sendKeys("Kent");
            }
            customerPortalMyPolicyPageObj.btnGPSave().click();
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void updatePersonalDetails(List<List<String>> parameters) {
        customerPortalMyPolicyPageObj.lnkEditPersonalDetails().click();
        for (int i = 1; i < parameters.size(); i++) {
            System.out.println("----------i----------value ---" + i);
            for (int j = 0; j < parameters.get(i).size(); j++) {
                System.out.println("----------j----------value ---" + j);
                this.amendDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void amendDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "main telephone":
                customerPortalMyPolicyPageObj.txtMainTelephone().clear();
                customerPortalMyPolicyPageObj.txtMainTelephone().sendKeys(fieldValue);
                break;
            case "mobile":
                customerPortalMyPolicyPageObj.txtMobile().clear();
                customerPortalMyPolicyPageObj.txtMobile().sendKeys(fieldValue);
                break;
            case "email":
                customerPortalMyPolicyPageObj.txtEmail().clear();
                updatedEmailID = fieldValue;
                customerPortalMyPolicyPageObj.txtEmail().sendKeys(fieldValue);
                break;
            case "gp detail[consent;gp name;surgery phone no;surgery address]":
                System.out.println("GP Details ....");
                this.enterGPDetails(fieldValue);
                break;
            case "action":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(customerPortalMyPolicyPageObj.btnGPSave());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
        }
    }

    public void customerNotification(List<String> parameter) {
        System.out.println("Msg---" + parameter.get(0));
        Assert.assertTrue(customerPortalMyPolicyPageObj.msgCustNotification().getText().equalsIgnoreCase(parameter.get(0)));
    }

    public void addPerson(String person, List<List<String>> parameters) {
        customerPortalMyPolicyPageObj.btnAddPerson().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (person.equalsIgnoreCase("partner")) {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(customerPortalMyPolicyPageObj.iconPartner());
        } else if (person.equalsIgnoreCase("son")) {
            nextEventPageObj.waitForMoreTime();
            customerPortalMyPolicyPageObj.iconSon().click();
        } else if (person.equalsIgnoreCase("daughter")) {
            nextEventPageObj.waitForMoreTime();
            customerPortalMyPolicyPageObj.iconDaughter().click();
        }

        for (int i = 1; i < parameters.size(); i++) {
            System.out.println("----------i----------value ---" + i);
            for (int j = 0; j < parameters.get(i).size(); j++) {
                System.out.println("----------j----------value ---" + j);
                this.addPersonDetailsInCustomerportal(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void addPersonDetailsInCustomerportal(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "title":
                new Select(quoteDetailsPageObj.titleOfNewPerson()).selectByVisibleText(fieldValue);
                break;
            case "first name":
                if (fieldValue.equalsIgnoreCase("random")) {
                    fieldValue = randomGeneratorObj.randomString(4);
                    quoteDetailsPageObj.firstNameOfNewPerson().sendKeys(fieldValue);
                    randomUserFname = fieldValue;
                    System.out.println("Random user name ----" + randomUserFname);
                } else {
                    quoteDetailsPageObj.firstNameOfNewPerson().sendKeys(fieldValue);
                }
                nextEventPageObj.waitForMoreTime();
                break;
            case "last name":
                quoteDetailsPageObj.lastNameOfNewPerson().sendKeys(fieldValue);
                randomUserLname = fieldValue;
                nextEventPageObj.waitForMoreTime();
                break;
            case "dob":
                String day, month, year;
                String dob[] = fieldValue.split("/");
                day = dob[0];
                month = dob[1];
                year = dob[2];
                new Select(customerPortalMyPolicyPageObj.dobDate()).selectByVisibleText(day);
                new Select(customerPortalMyPolicyPageObj.dobMonth()).selectByVisibleText(month);
                new Select(customerPortalMyPolicyPageObj.dobYear()).selectByVisibleText(year);
                break;
            case "gp detail[consent;gp name;surgery phone no;surgery address]":
                System.out.println("GP Details ....");
                this.enterGPDetails(fieldValue);
                break;
            case "gp detail":
                if (fieldValue.equalsIgnoreCase("no")) {
                    customerPortalMyPolicyPageObj.btnNoGP().click();
                }
                break;
            case "action":
                customerPortalMyPolicyPageObj.btnGPSave().click();
                break;
        }
    }

    public void commPrefDetails(List<List<String>> parameters) {
        customerPortalMyPolicyPageObj.lnkEditCommPref().click();
        for (int i = 1; i < parameters.size(); i++) {
            System.out.println("----------i----------value ---" + i);
            for (int j = 0; j < parameters.get(i).size(); j++) {
                System.out.println("----------j----------value ---" + j);
                this.updateCommPref(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void updateCommPref(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "address 1":
                customerPortalMyPolicyPageObj.txtAddress1().clear();
                customerPortalMyPolicyPageObj.txtAddress1().sendKeys(fieldValue);
                break;
            case "town or city":
                customerPortalMyPolicyPageObj.txtTownCity().clear();
                customerPortalMyPolicyPageObj.txtTownCity().sendKeys(fieldValue);
                break;
            case "postcode":
                customerPortalMyPolicyPageObj.txtPincode().clear();
                customerPortalMyPolicyPageObj.txtPincode().sendKeys(fieldValue);
                break;
            case "large print":
                customerPortalMyPolicyPageObj.btnLarge(fieldValue).click();
                break;
            case "braille":
                customerPortalMyPolicyPageObj.btnBraille(fieldValue).click();
                break;
            case "audio":
                customerPortalMyPolicyPageObj.btnAudio(fieldValue).click();
                break;
            case "action":
                customerPortalMyPolicyPageObj.btnGPSave().click();
                break;
        }
    }

    public void clickOnIcon(String icon) {
        customerPortalMyPolicyPageObj.iconsOnMyPolicyScreen(icon).isDisplayed();
        customerPortalMyPolicyPageObj.iconsOnMyPolicyScreen(icon).click();
    }

    public void clickOnAddPerson() {
        nextEventPageObj.switchToDefault();
        customerPortalMyPolicyPageObj.btnAddPerson().isDisplayed();
        nextEventPageObj.waitForMoreTime();
        customerPortalMyPolicyPageObj.btnHome().click();
    }

    public void navigateToHomePage() {
        try {
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            customerPortalMyPolicyPageObj.btnHome().isDisplayed();
            nextEventPageObj.btnClick(customerPortalMyPolicyPageObj.btnHome());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.getDriver.navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            customerPortalMyPolicyPageObj.btnHome().isDisplayed();
            nextEventPageObj.btnClick(customerPortalMyPolicyPageObj.btnHome());
        }
        catch (Throwable e)
        {
            nextEventPageObj.getDriver.navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(customerPortalMyPolicyPageObj.btnHome());
        }
    }

    public void verifyAddressInPolicyPage() {
        String[] addressLine = customerPortalMyPolicyPageObj.txtpolicyAddress().getText().split("\n");
        String address = addressLine[0];
        String addressFromAQ = policyOperationsObj.addressLine1Aquarium;
        System.out.println("Address Line from aquarium------------" + addressFromAQ);
        System.out.println("Address Line from digital-------------" + address);
        Assert.assertTrue(address.trim().equalsIgnoreCase(addressFromAQ.trim()));
        System.out.println("Town from aquarium------------" + policyOperationsObj.townAquarium);
        String town = addressLine[1];
        System.out.println("Town from digital-------------" + town);
        Assert.assertTrue(town.equalsIgnoreCase(policyOperationsObj.townAquarium.trim()));
        System.out.println("Post Code from aquarium --------------" + policyOperationsObj.postcodeAquarium);
        String post_code = addressLine[2];
        System.out.println("Post Code from digital -------------" + post_code);
        Assert.assertTrue(post_code.equalsIgnoreCase(policyOperationsObj.postcodeAquarium.trim()));
    }

    public void verifyJointAccountHolder() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        List<WebElement> count = nextEventPageObj.findElements(By.xpath(customerPortalMyPolicyPageObj.txtJointAccountHolder()));
        System.out.println("size------" + count.size());
        if (count.size() > 0 && count.size() <= 4)
            Assert.assertTrue(true);
        else
            Assert.assertTrue(false);
    }

    public void validateAgedLogon(List<String> parameters) {
        System.out.println(" Input ------------------ "+parameters.get(0).trim());
        System.out.println(" Displayed in Appl  ----- "+customerPortalMyPolicyPageObj.lblAgeLogonMsg().getText().trim());
        Assert.assertEquals(parameters.get(0).trim(),customerPortalMyPolicyPageObj.lblAgeLogonMsg().getText().trim());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(customerPortalMyPolicyPageObj.btnOk());
        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalMyPolicyPageObj.lblMyPolicyScreen())));
    }
}
