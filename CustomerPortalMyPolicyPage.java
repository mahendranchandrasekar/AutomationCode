package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by 588800 on 10/3/2017.
 */
public class CustomerPortalMyPolicyPage extends AbstractPage {


    public WebElement lnkPurchaseLetter() {
        return waitForElementPresent(By.xpath("//*[contains(text(),'New Upgrade Purchase')]/../..//span"));
    }
    public WebElement lnkCoverLetter() {
        return waitForElementPresent(By.cssSelector(".primary"));
    }

    public WebElement lblAcctHolderName()
    {
        return waitForElementPresent(By.xpath("//div[text()='Name:']/..//div[2]"));
    }

    public WebElement lblDOB()
    {
        return waitForElementPresent(By.xpath("//div[text()='Date of birth:']/..//div[2]"));
    }

    public WebElement lblTelephone()
    {
        return waitForElementPresent(By.xpath("//div[text()='Main Telephone:']/..//div[2]"));
    }
    public WebElement lblMobile()
    {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Mobile')]/..//div[2]"));
    }

    public WebElement lblEmail()
    {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Email')]/..//div[2]"));
    }

    public WebElement lnkEditPersonalDetails()
    {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Edit details')]"));
    }
    public WebElement lnkEditCommPref()
    {
        return waitForElementPresent(By.xpath("(//*[@class='link'])[2]"));
    }
    public WebElement msgCustNotification()
    {
        return waitForElementPresent(By.xpath("//div[@class='info-message fullwidth']//p"));
    }

    public WebElement btnYesGP()
    {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Yes')]"));
    }

    public WebElement btnNoGP()
    {
        return waitForElementPresent(By.xpath("//div[contains(text(),'No')]"));
    }
    public WebElement txtGPName()
    {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='gpName']"));
    }
    public WebElement txtGPPracticeName()
    {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='practiceName']"));
    }
    public WebElement txtGPPhone()
    {
        return waitForElementPresent(By.xpath("//h3[contains(text(),'GP Details')]/..//input[@formcontrolname='phone']"));
    }
    public WebElement btnAddrLookup()
    {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Address Lookup')]"));
    }

    public WebElement txtPostcode()
    {
        return waitForElementPresent(By.xpath("(//input[@formcontrolname='postcode'])[2]"));
    }
    public WebElement txtGPCounty()
    {
        return waitForElementPresent(By.xpath("(//input[@formcontrolname='county'])"));
    }

    public WebElement btnFindAddress()
    {
        return waitForElementPresent(By.xpath("//button[contains(text(),'Find Address')]"));
    }

    public WebElement selectAddress()
    {
        return waitForElementPresent(By.xpath("//div[@class='address-list']//div[1]/address"));
    }

    public WebElement btnSelectAddress()
    {
        return waitForElementPresent(By.xpath("//*[contains(text(),'Select Address')][@class='primary-button']"));
    }

    public WebElement btnGPSave()
    {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Save')]"));
    }

    public WebElement txtMobile()
    {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='mobile']"));
    }

    public WebElement txtMainTelephone()
    {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='phone']"));
    }

    public WebElement txtEmail()
    {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='email']"));
    }

    public WebElement btnAddPerson()
    {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Add Person')]/ancestor::a"));
    }

    public String addPersonOption()
    {
        return "//a[@class='primary-link']";
    }

    public String lblMyPolicyScreen()
    {
        return "//*[contains(text(),'Your Personal Details')]";
    }

    public WebElement iconPartner() {
        return waitForElementPresent(By.xpath("//div[@class='icon']/..//h3[contains(text(),'Partner')]"));
    }
    public WebElement btnHome()
    {
        return waitForElementPresent(By.xpath("//span[contains(text(),'Home')]"));
    }
    public WebElement iconSon()
    {
        return waitForElementPresent(By.xpath("//div[@class='icon']/..//h3[contains(text(),'Son')]"));
    }

    public WebElement iconDaughter()
    {
        return waitForElementPresent(By.xpath("//div[@class='icon']/..//h3[contains(text(),'Daughter')]"));
    }
    public WebElement dobDate() {
        return waitForElementPresent(By.xpath("(//*[@formcontrolname='dob']//select)[1]"));
    }
    public WebElement dobMonth() {
        return waitForElementPresent(By.xpath("(//*[@formcontrolname='dob']//select)[2]"));
    }
    public WebElement dobYear() {
        return waitForElementPresent(By.xpath("(//*[@formcontrolname='dob']//select)[3]"));
    }

    public WebElement txtAddress1()
    {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='address1']"));
    }

    public WebElement txtTownCity()
    {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='townCity']"));
    }
    public WebElement btnLarge(String option)
    {
        return waitForElementPresent(By.xpath("(//div[contains(text(),'"+option+"')])[1]"));
    }

    public WebElement btnBraille(String option)
    {
        return waitForElementPresent(By.xpath("(//div[contains(text(),'"+option+"')])[2]"));
    }

    public WebElement btnAudio(String option)
    {
        return waitForElementPresent(By.xpath("(//div[contains(text(),'"+option+"')])[3]"));
    }

    public WebElement txtPincode()
    {
        return waitForElementPresent(By.xpath("//input[@formcontrolname='postcode']"));
    }

    public WebElement iconsOnMyPolicyScreen(String icon)
    {
        return waitForElementPresent(By.xpath("//a[contains(text(),'"+icon+"')]"));
    }

    public WebElement txtpolicyAddress(){
        return waitForElementPresent(By.xpath("//address/div"));
    }
    public String txtJointAccountHolder(){
        return "//h3[contains(text(),'Joint Account Holder')]";
    }

    public WebElement lblAgeLogonMsg()
    {
        return waitForElementPresent(By.xpath("//*[@id='ConfirmModal']//p"));
    }

    public WebElement btnOk()
    {
        return waitForElementPresent(By.id("confirm"));
    }

}
