package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import gherkin.lexer.Th;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

import static co.uk.directlinegroup.tt.utils.CustomerPortalLoginOperations.incorrectPassword;

public class CustomerPortalHomeOperations {

    private CustomerPortalHomePage customerPortalHomePageObj = new CustomerPortalHomePage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private CustomerPortalQuotePage customerPortalQuotePageObj = new CustomerPortalQuotePage();
    private Commands commandsObj = new Commands();
    private CustomerPortalMyPolicyPage customerPortalMyPolicyPageObj = new CustomerPortalMyPolicyPage();

    public static String selectedAccountType="";

    public void verifyAccountType(String acctType) {
        customerPortalMyPolicyPageObj.btnHome().click();
        String applTxt = customerPortalHomePageObj.lblAccountType().getText();
        System.out.println(" Text from appl -----------" + applTxt);
        String type = applTxt.split(" ")[12];
        System.out.println("Acct type -----" + type);
        Assert.assertTrue(acctType.equalsIgnoreCase(type));
    }

    public void setPassword(String password) {
        customerPortalHomePageObj.txtPwd().sendKeys(password);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalHomePageObj.txtConfirmPwd().sendKeys(password);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalHomePageObj.btnRegister().click();
    }

    public void clickOnIcon(String icon) {
        try {
            Thread.sleep(45000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalHomePageObj.clickAndNavigate(icon).click();
    }

    public void clickOnFAQ() {
        customerPortalHomePageObj.lnkFAQ().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToLastOpenWindow();
    }

    public void navigateToMainMenu(String parameter) {
        customerPortalHomePageObj.selectMainMenu(parameter);
        customerPortalHomePageObj.btnClick(customerPortalHomePageObj.selectMainMenu(parameter));
    }

    public void navigateToHomePage() {
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
        customerPortalMyPolicyPageObj.btnHome().isDisplayed();
        customerPortalMyPolicyPageObj.btnHome().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateAgeExtNotification() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        try {
            Thread.sleep(1000L);
//            Thread.sleep(40000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nextEventPageObj.getDriver.navigate().refresh();
        String msg = customerPortalHomePageObj.txtHomePageNotification().getText();
        System.out.println("Notification is-------" + msg);
        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalHomePageObj.lblHomePageNotification())));
    }

    public void NavigateToHome() {
        customerPortalQuotePageObj.btnHomePage().click();
    }

    public void verifyAccountLocked(List<String> parameter) {
        System.out.println("Msg from feature file----" + parameter.get(0));
        System.out.println("Msg from application-----" + customerPortalHomePageObj.msgAcctLocked().getText());
        Assert.assertTrue(parameter.get(0).equalsIgnoreCase(customerPortalHomePageObj.msgAcctLocked().getText()));
    }

    public void verifyTabsAreNotDisplayed(String tabs) {
        for (int i = 0; i < tabs.split("#").length; i++) {
            Assert.assertTrue(!commandsObj.elementDisplayedWithLessTime(By.xpath(customerPortalHomePageObj.tabsXpath(tabs.split("#")[i]))));
        }
    }

    public void validateAccountSelectionScreen() {
        commandsObj.elementDisplayedWithLessTime(org.openqa.selenium.By.xpath(customerPortalHomePageObj.lblAccountSelection()));
        System.out.println("Account selection screen is available");
    }

    public void accountSelection(String accountType) {
        selectedAccountType = accountType;
        Assert.assertTrue(customerPortalHomePageObj.btnSelectAccountType(accountType).isDisplayed());
        System.out.println("Selected account type is : " + accountType);
    }

    public void validateSelectedAccountDetails() {
        System.out.println("Displaying account details from application  ----- " + customerPortalHomePageObj.lblSelectedAccount().getText());
        System.out.println("Selected account is ----" + selectedAccountType);
        Assert.assertTrue(customerPortalHomePageObj.lblSelectedAccount().getText().contains(selectedAccountType));
    }

    public void validateAccountDetails(String accountType, List<String> parameters) {
        for (int i = 0; i < parameters.size(); i++) {
            System.out.println("Data Table size----" + parameters.size());
            this.verifyAccountDetails(accountType, parameters.get(i));
        }
        customerPortalHomePageObj.btnSelectAccountType(accountType).click();
    }

    private void verifyAccountDetails(String accountType, String fieldName) {
        switch (fieldName.toLowerCase()) {
            case "account no":
                nextEventPageObj.waitForMoreTime();
                System.out.println("Account No. ----" + nextEventPageObj.findElement(By.xpath(customerPortalHomePageObj.lblAccountNumber(accountType))).getText().split(" ")[2]);
                Assert.assertTrue(!nextEventPageObj.findElement(By.xpath(customerPortalHomePageObj.lblAccountNumber(accountType))).getText().split(" ")[2].isEmpty());
                break;
            case "sort code":
                nextEventPageObj.waitForMoreTime();
                System.out.println("Sortcode----" + nextEventPageObj.findElement(By.xpath(customerPortalHomePageObj.lblSortCode(accountType))).getText().split(" ")[2]);
                int sortcodeLength = nextEventPageObj.findElement(By.xpath(customerPortalHomePageObj.lblSortCode(accountType))).getText().split(" ").length;
                if (sortcodeLength >= 3) {
                    System.out.println("Sort Code ----" + nextEventPageObj.findElement(By.xpath(customerPortalHomePageObj.lblSortCode(accountType))).getText().split(" ")[2]);
                    Assert.assertTrue(!nextEventPageObj.findElement(By.xpath(customerPortalHomePageObj.lblSortCode(accountType))).getText().split(" ")[2].isEmpty());
                } else if (sortcodeLength <= 2) {
                    Assert.assertTrue(false);
                }
                break;
        }
    }

    public void validateClaimNotification(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.verifyClaimNotification(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void verifyClaimNotification(String fieldName, String fieldValue) {
        switch (fieldName)
        {
            case "Claim Payment":
                Assert.assertTrue(customerPortalHomePageObj.msgClaimPaymentNotification(fieldValue).isDisplayed());
                break;
            case "Notification":
                Assert.assertTrue(customerPortalHomePageObj.msgClaimPaymentNotification(fieldValue).isDisplayed());
                break;
            case "Advice of Evidence":
                Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalHomePageObj.lblNotificationsOnHP(fieldName, fieldValue))));
                break;
            case "Claim Closed":
            case "Claim Repudiated":
                Assert.assertTrue(customerPortalHomePageObj.msgClaimPaymentNotification(fieldValue).isDisplayed());
                break;

        }
    }

    public void clickOnClaimNotification() {
        customerPortalHomePageObj.lblClaimPayment().click();
        nextEventPageObj.waitForPageLoad();
    }

    public void clickOnNotification(String notification) {
        customerPortalHomePageObj.lblClaimNotification(notification).click();
        nextEventPageObj.waitForPageLoad();
    }

    public void clickOnRenewalNotification(String notification) {
        nextEventPageObj.getDriver.navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        try {
            nextEventPageObj.getDriver.navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalHomePageObj.lblViewRenewal())));
        }
        catch (Exception exe)
        {
            nextEventPageObj.getDriver.navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.getDriver.navigate().refresh();
            nextEventPageObj.waitForMoreTime();
            try {
                Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalHomePageObj.lblViewRenewal())));
            }
            catch (Exception exception)
            {
                nextEventPageObj.getDriver.navigate().refresh();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalHomePageObj.lblViewRenewal())));
            }
        }
    }

    public void medicalEmergencyAssitance(String number, List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                Assert.assertTrue(customerPortalHomePageObj.medicalAssistanceInstructions(parameters.get(i).get(j)).isDisplayed());
            }
        }
    }
}