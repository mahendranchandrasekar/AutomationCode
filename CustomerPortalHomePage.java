package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomerPortalHomePage extends AbstractPage {

    public WebElement makeAClaim() {
        return waitForElementPresent(By.linkText("New Claim"));
    }

    public WebElement destination() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/trip-page/div/div/div[2]/trip-edit/div[1]/form/div/div[1]/div/select"));
    }

    public WebElement dateTripBooked() {
        return waitForElementPresent(By.xpath("//*[@id=\"tripBooked\"]"));
    }

    public WebElement tripDatesFrom() {
        return waitForElementPresent(By.xpath("//*[@id=\"tripFrom\"]"));
    }

    public WebElement tripDatesTo() {
        return waitForElementPresent(By.xpath("//*[@id=\"tripTo\"]"));
    }

    public WebElement anyDetailsTrip() {
        return waitForElementPresent(By.xpath("//textarea[@formcontrolname='description']"));
    }

    public WebElement tripDetailsSave() {
        return waitForElementPresent(By.xpath("/html/body/app/div/fnol-page/trip-page/div/div/div[2]/trip-edit/div[2]/button/i"));
    }

    public WebElement btnSignOut() {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Sign out')]"));
    }
    public String btnSignOutXpath() {
        return "//span[contains(text(),'Sign out')]";
    }

    public WebElement lblSignOut() {
        return waitForElementPresent(By.xpath("//h2[contains(text(),'Sign out')]"));
    }

    public WebElement btnConfirmSignOut() {
        return waitForElementPresent(By.xpath("//*[@class='primary-button'][contains(text(),'Sign out')]"));
    }


    public WebElement btnSoleAuthorityNo() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'No')]"));
    }

    public WebElement lblAccountType() {
        return waitForElementPresent(By.xpath("(//div//p)[1]"));
    }

    public WebElement txtPwd() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='password']"));
    }

    public WebElement txtConfirmPwd() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='confirm']"));
    }

    public WebElement msgWelcome() {
        return waitForElementPresent(By.xpath("//h1[contains(text(),'Welcome,')]"));
    }

    public WebElement btnRegister() {
        return waitForElementPresent(By.xpath("//button[@class='primary-button active']"));
    }

    public WebElement clickAndNavigate(String icon) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'"+icon+"')]/ancestor::a[@class='row']"));
    }

    public WebElement lnkFAQ() {
        return waitForElementPresent(By.linkText("FAQ's"));
    }

    public WebElement selectMainMenu(String parameter) {

        return waitForElementPresent(By.xpath("//span[contains(text(),'" + parameter + "')]"));
    }

    public WebElement btnViewRenewal() {

        return waitForElementPresent(By.xpath("//button[contains(text(),'View Renewal')]"));
    }

    public String lblViewRenewal() {

        return "//*[contains(text(),'View Renewal')]";
    }


    public WebElement txtHomePageNotification() {
        return waitForElementPresent(By.xpath("//div[@class='content']//p"));
    }

    public WebElement btnHomePageNotification() {
        return waitForElementPresent(By.xpath("(//h3[contains(text(),'Age Extension Required')])[1]"));
    }

    public String lblHomePageNotification() {
        return "(//h3[contains(text(),'Age Extension Required')])[1]";
    }


    public WebElement txtHomePageExpiryDate() {
        return waitForElementPresent(net.serenitybdd.core.annotations.findby.By.xpath("//div[@class='quick-links home row']/..//b"));
    }

    public WebElement msgAcctLocked() {
        return waitForElementPresent(By.xpath("//*[@class='error']"));
    }

    public WebElement btnHome()
    {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Home')]"));
    }


    public WebElement returnBackToHomePage() {
        return waitForElementPresent(By.xpath("//button[text()='Home']"));
    }

    public String lblAccountSelection() {
        return "//h1[contains(text(),'Account Selection')]";
    }
    public WebElement btnSelectAccountType(String accountType) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'" + accountType + "')]"));

    }

    public WebElement selectAccountType(String accountType) {
        return waitForElementPresent(By.xpath("(//h3[contains(text(),'" + accountType + "')])[1]"));

    }

    public String lblSortCode(String accountType) {
        return "(//h3[contains(text(),'" + accountType + "')]/../..//h5)[2]";
    }

    public String lblAccountNumber(String accountType) {
        return "(//h3[contains(text(),'" + accountType + "')]/../..//h5)[1]";
    }

    public WebElement lblSelectedAccount() {
        return waitForElementPresent(By.xpath("(//*[@class='headings']//p)[1]"));
    }


    public String tabsXpath(String tabName) {
        return "//a/span[contains(text(),'" + tabName + "')]";
    }

    public String btnNotificationRemoval() {
        return "//p[contains(text(),'An age extension is required for cover to continue')]/..";
    }

    public WebElement msgClaimPaymentNotification(String msg) {
        return waitForElementPresent(By.xpath("//p[contains(text(),'"+msg+"')]"));
    }

    public WebElement msgPaymentsInOpenClaimDetailsPage(int i)
    {
        return waitForElementPresent(By.xpath("(//h3[contains(text(),'Payment')]/../p)["+i+"]"));
    }

    public WebElement lblClaimPayment()
    {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'Claim Payment')]"));
    }

    public String lblNotificationsOnHP(String notification,String msg)
    {
        return "//h3[contains(text(),'"+notification+"')]/../p[contains(text(),'"+msg+"')]";
    }

    public WebElement lblClaimNotification(String notification)
    {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'"+notification+"')]"));
    }

    public String lblNotifications(String notification)
    {
        return "//h3[contains(text(),'"+notification+"')]";
    }

    public WebElement medicalAssistanceInstructions(String header){
        return waitForElementPresent(By.xpath("//h2[contains(text(),'"+header+"')]"));
    }
}


