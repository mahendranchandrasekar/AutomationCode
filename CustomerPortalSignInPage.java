package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomerPortalSignInPage extends AbstractPage {

    public WebElement signIn() {

        return waitForElementPresent(By.xpath("//button[@class='primary-button active']"));
    }

    public String btnConfirm() {

        return "//button[@class='primary-button active']";
    }

    public WebElement lblSignIn() {
        return waitForElementPresent(By.xpath("//h1[contains(text(),'Sign In')]"));
    }

    public WebElement register() {
        return waitForElementPresent(By.xpath("//a[text()='Register']"));
    }

    public WebElement email() {
        return waitForElementPresent(By.cssSelector("input[formcontrolname='username']"));
    }

    public WebElement password() {

        return waitForElementPresent(By.cssSelector("input[formcontrolname='password']"));
    }

    public WebElement login() {
        return waitForElementPresent(By.cssSelector("button.primary-button.active"));
    }

    public WebElement signOut() {
        return waitForElementPresent(By.xpath("//span[text()='Sign out']"));
    }

    public WebElement signOutConfirm() {
        return waitForElementPresent(By.id("confirm"));
    }

    public WebElement createpassword() {
        return waitForElementPresent(By.xpath("/html/body/app/div/register/form/div/div/div[2]/div/div[2]/input"));
    }

    public WebElement confirmpassword() {
        return waitForElementPresent(By.xpath("/html/body/app/div/register/form/div/div/div[2]/div/div[3]/input"));
    }

    public WebElement signIn1() {
        return waitForElementPresent(By.xpath(" /html/body/app/div/register/form/div/div/div[2]/div/div[4]/button/i"));
    }

    public WebElement txtPostcode() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='postcode']"));
    }

    public WebElement txtAcctNo() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='accountNo']"));
    }

    public WebElement txtSortcodeOne() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='one']"));
    }

    public WebElement txtSortcodeTwo() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='two']"));
    }

    public WebElement txtSortcodeThree() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='three']"));
    }
    public WebElement titleOfNewPerson() {
        return waitForElementPresent(By.xpath("//select[@aria-label='Select title']"));
    }

    public WebElement btnRegister() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Register')]"));
    }

    public WebElement drpdnDOBDay() {
        return waitForElementPresent(By.xpath("(//*[@formcontrolname='dob']//select)[1]"));
    }

    public WebElement drpdnDOBMonth() {
        return waitForElementPresent(By.xpath("(//*[@formcontrolname='dob']//select)[2]"));
    }

    public WebElement drpdnDOBYear() {
        return waitForElementPresent(By.xpath("(//*[@formcontrolname='dob']//select)[3]"));
    }

    public WebElement lnkForgotID() {
        return waitForElementPresent(By.linkText("Forgot your username?"));
    }

    public WebElement lnkForgotPwd() {
        return waitForElementPresent(By.linkText("Forgot your password?"));
    }
    public WebElement btnRequestResetPwd() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Request Reset')]"));
    }

    public WebElement errMsgIncorrectLogin() {
        return waitForElementPresent(By.xpath("//div[@class='error']"));
    }

    public WebElement lblPwdResetConfirmation() {
        return waitForElementPresent(By.xpath("//h1[contains(text(),'Password reset request sent')]"));
    }

    public WebElement lnkForgotUserName() {
        return waitForElementPresent(By.xpath("//div[@class='form login']//following::input[@type='text']/following::a[1]"));
    }

    public WebElement lnkForgotYourPwd() {
        return waitForElementPresent(By.xpath("//div[@class='form login']//following::input[@type='password']/following::a[1]"));
    }

    public WebElement txtUserName() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='username']"));
    }

    public WebElement chkBkCaptcha() {
        return waitForElementPresent(By.cssSelector(".recaptcha-checkbox-checkmark"));
    }

    public WebElement frameCaptcha() {
        return waitForElementPresent(By.xpath("//*[@id='ngrecaptcha-0']/div/div/iframe"));
    }

    public WebElement lnkClickNotAnNatwestAccountHolder() {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'Not yet a NatWest account holder?')]/..//following::div[@class='primary-button']"));
    }


    public WebElement txtConfirmNewPassword() {
        return waitForElementPresent(By.xpath("//input[@aria-label='Confirm password']"));
    }

    public WebElement txtOTURLNotification() {
        return waitForElementPresent(By.xpath("//div[@class='headings']//p"));
    }

    public WebElement txtLoginErrorNotification() {
        return waitForElementPresent(By.xpath("//div[@class='error']"));
    }


    public WebElement errMsgResetPwd() {
        return waitForElementPresent(By.xpath("//div[@class='error']"));
    }


    public WebElement txtAddress2() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='address2']"));
    }

    public WebElement txtAddress1() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='address1']"));
    }

    public WebElement txtTownOrCity() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='townCity']"));
    }

    public WebElement digemail() {
        return waitForElementPresent(By.cssSelector("input[formcontrolname='email']"));
    }


    public WebElement tellUsAboutEveryOneOption(String option) {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'You should tell us about everyone who')]/../following-sibling::div//div[contains(text(),'" + option + "')]"));
    }

    public WebElement btnNext() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Next')]"));
    }

    public WebElement lnkClickNotAccountHolder() {
        return waitForElementPresent(By.xpath("//*[@class='primary-button'][contains(text(),'Click here')]"));
    }

    public WebElement selectAccount(String account) {
        return waitForElementPresent(By.xpath("//span[contains(text(),'" + account + "')]"));
    }

    public WebElement iUnderstandBtn() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'I Understand')]"));
    }

    public WebElement errMsgRegistration() {
        return waitForElementPresent(By.xpath("//div[@class='error msg show']"));
    }

    public WebElement btnLogin() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Login')]"));
    }

    public String lblSplashPage(String msg) {
        return "//h1[contains(text(),'" + msg + "')]";
    }

    public String msgSplashPage(String msg) {
        return "//p[contains(text(),'" + msg + "')]";
    }

    public WebElement jointAccountTitle() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Add Joint Account')]/../..//select[@aria-label='Select title']"));
    }

    public WebElement jointAccountFName() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Add Joint Account')]/../..//input[@formcontrolname='firstName']"));
    }

    public WebElement jointAccountLName() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Add Joint Account')]/../..//input[@formcontrolname='lastName']"));
    }

    public WebElement drpdnDOBirthDay1() {
        return waitForElementPresent(By.xpath("//*[@formcontrolname='dobDaySelect']"));
    }

    public WebElement drpdnDOBirthMonth1() {
        return waitForElementPresent(By.xpath("//*[@formcontrolname='dobMonthSelect']"));
    }

    public WebElement drpdnDOBirthYear1() {
        return waitForElementPresent(By.xpath("//*[@formcontrolname='dobYearSelect']"));
    }

    public WebElement btnSave() {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Save')]"));
    }

    public WebElement txtCounty() {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='county']"));
    }

    public WebElement lnkPrivacyAndSecurity() {
        return waitForElementToBeClickableAndReturnElement(By.linkText("Privacy & Security"));
    }

    public WebElement lnkICOWebsite() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[@href='https://ico.org.uk/global/contact-us/']"));
    }

    public WebElement lnkExperian() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[@href='https://www.experian.co.uk/crain/index.html']"));
    }

    public WebElement lnkInsuranceGroupCompanies() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[@href='https://www.u-k-insurance.co.uk/group-companies.html']"));
    }
    public boolean validateUpgradeTextNotDisplayed() {
        List<WebElement> lstWb = getDriver.findElements(By.xpath("//p[contains(text(),'If you would like make any amendments to any upgrades you already have please call us')]"));
        if (lstWb.size() == 0) {
            return true;
        }

        return false;
    }

    public WebElement linkLegal() {
        return waitForElementToBeClickableAndReturnElement(By.linkText("Legal"));
    }

    public WebElement lnkMembershipServices() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[contains(text(),'membership services')]"));
    }

    public WebElement linkPrivacyPolicy() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[contains(text(),'privacy policy')]"));
    }

    public WebElement lnkODRPlatform() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[contains(text(),'ODR platform')]"));
    }

    public WebElement lnkContactUs() {
        return waitForElementToBeClickableAndReturnElement(By.xpath("//a[contains(text(),'contact us')]"));
    }
}
