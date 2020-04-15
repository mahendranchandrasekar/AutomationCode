package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.CustomerPortalSignInPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.common.FileOperations;
import net.serenitybdd.core.annotations.findby.By;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by 588800 on 10/17/2017.
 */
public class CustomerPortalLoginOperations {

    private NextEventPage nextEventPageObj = new NextEventPage();
    private CustomerPortalSignInPage customerPortalSignInPageObj = new CustomerPortalSignInPage();
    private PolicyOperations policyOperationsObj = new PolicyOperations();
    private FileOperations fileOperationsObj = new FileOperations();

    public static String incorrectPassword = "";

    public void clickOnLogin()
    {
        customerPortalSignInPageObj.btnLogin().isDisplayed();
        customerPortalSignInPageObj.btnLogin().click();
    }

    public void validateCredentialsFields(List<String> parameter) {
        customerPortalSignInPageObj.email().isDisplayed();
        customerPortalSignInPageObj.password().isDisplayed();
    }

    public void enterCredentials(List<List<String>> parameter) {
        for (int i = 1; i < parameter.size(); i++) {
            for (int j = 0; j < parameter.get(i).size(); j++) {
                this.enterLoginDetails(parameter.get(0).get(j), parameter.get(i).get(j));
            }
        }
    }

    private void enterLoginDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "user id":
                if(fieldValue.equalsIgnoreCase("registeredEmailID")){
                    fieldValue = policyOperationsObj.randomEmailID;
                }
                nextEventPageObj.waitForMoreTime();
                customerPortalSignInPageObj.email().clear();
                customerPortalSignInPageObj.email().sendKeys(fieldValue);
                break;
            case "password":
                nextEventPageObj.waitForMoreTime();
                customerPortalSignInPageObj.password().clear();
                customerPortalSignInPageObj.password().sendKeys(fieldValue);
                System.out.println("Entering pwd-----"+fieldValue);
                break;
            case "incorrect password":
                customerPortalSignInPageObj.password().clear();
                customerPortalSignInPageObj.password().sendKeys(fieldValue);
                incorrectPassword = fieldValue;
                System.out.println("Entered password is----" + incorrectPassword);
                break;
            case "action":
                customerPortalSignInPageObj.signIn().click();
                break;
            case "confirm password":
                customerPortalSignInPageObj.txtConfirmNewPassword().clear();
                customerPortalSignInPageObj.txtConfirmNewPassword().sendKeys(fieldValue);
                System.out.println("Confirm new password is----" + fieldValue);
                break;
            case "new password":
                customerPortalSignInPageObj.password().clear();
                customerPortalSignInPageObj.password().sendKeys(fieldValue);
                break;
            case "notification":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue(customerPortalSignInPageObj.errMsgResetPwd().isDisplayed());
                break;
        }
    }

    public void clickOnSignIn() {
        customerPortalSignInPageObj.signIn().click();
    }

    public void clickOnConfirm()
    {
        if(nextEventPageObj.elementDisplayed(nextEventPageObj.getDriver.findElement(By.xpath(customerPortalSignInPageObj.btnConfirm())))){
            customerPortalSignInPageObj.signIn().click();
        }
    }

    public void incorrectLogin(List<List<String>> parameter) {
        for (int i = 1; i < parameter.size(); i++) {
            for (int j = 0; j < parameter.get(i).size(); j++) {
                this.validateIncorrectCredentials(parameter.get(0).get(j), parameter.get(i).get(j));
            }
        }
    }

    private void validateIncorrectCredentials(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "notification message":
                System.out.println("Error Msg ----" + customerPortalSignInPageObj.errMsgIncorrectLogin().getText());
                Assert.assertTrue(customerPortalSignInPageObj.errMsgIncorrectLogin().getText().equalsIgnoreCase(fieldValue));
                break;
            case "forgot your user id":
                Assert.assertTrue(customerPortalSignInPageObj.lnkForgotID().isDisplayed());
                break;
            case "forgot your password":
                Assert.assertTrue(customerPortalSignInPageObj.lnkForgotPwd().isDisplayed());
                break;
            case "link of forgot user id":
                customerPortalSignInPageObj.lnkForgotUserName().getText();
                System.out.println("Forgot link of user name----------:" + customerPortalSignInPageObj.lnkForgotUserName().getText());
                System.out.println("User id Link from feature file----:" + fieldValue);
                Assert.assertTrue(fieldValue.equalsIgnoreCase((customerPortalSignInPageObj.lnkForgotUserName().getText())));
                Assert.assertTrue(customerPortalSignInPageObj.lnkForgotUserName().isDisplayed());
                break;
            case "link of forgot password":
                customerPortalSignInPageObj.lnkForgotYourPwd().getText();
                System.out.println("Forgot link of password-------------:" + customerPortalSignInPageObj.lnkForgotYourPwd().getText());
                System.out.println("Password Link from feature file-----:" + fieldValue);
                Assert.assertTrue(fieldValue.equalsIgnoreCase((customerPortalSignInPageObj.lnkForgotYourPwd().getText())));
                Assert.assertTrue(customerPortalSignInPageObj.lnkForgotYourPwd().isDisplayed());
                break;
        }
    }

    public void enterInvalidCredentials(int attempts, List<List<String>> parameter) {
        for (int i = 0; i < attempts; i++) {
            System.out.println("No of attempts......" + i);
            this.enterCredentials(parameter);
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void navigateToForgotPwd(List<List<String>> parameter) {
        customerPortalSignInPageObj.lnkForgotPwd().isDisplayed();
        customerPortalSignInPageObj.lnkForgotPwd().click();
        this.enterCredentials(parameter);
        customerPortalSignInPageObj.btnRequestResetPwd().isDisplayed();
        customerPortalSignInPageObj.btnRequestResetPwd().click();
    }

    public void validateResetReqSent() {
        Assert.assertTrue(customerPortalSignInPageObj.lblPwdResetConfirmation().isDisplayed());
    }

    public void validateLoginPage(List<List<String>> parameter) {
        for (int i = 1; i < parameter.size(); i++) {
            for (int j = 0; j < parameter.get(i).size(); j++) {
                this.validateDetailsOfLoginPage(parameter.get(0).get(j));
            }
        }
    }

    private void validateDetailsOfLoginPage(String fieldName) {
        switch (fieldName.toLowerCase()) {
            case "forgot your username?":
                Assert.assertTrue(customerPortalSignInPageObj.lnkForgotUserName().isDisplayed());
                break;
            case "forgot your password?":
                Assert.assertTrue(customerPortalSignInPageObj.lnkForgotYourPwd().isDisplayed());
                break;
            case "sign in":
                Assert.assertTrue(customerPortalSignInPageObj.signIn().isDisplayed());
                break;
            case "not yet a natWest account holder?":
                Assert.assertTrue(customerPortalSignInPageObj.lnkClickNotAnNatwestAccountHolder().isDisplayed());
                break;
        }
    }

    public void validateIncorrectPassword() throws Exception {
        int countSpecial = 0;
        int countDigit = 0;
        int countAlphabet = 0;
        System.out.println("To validate the Entered password-------" + incorrectPassword);
        if (incorrectPassword.length() < 8) {
            System.out.println("invalid");
        } else {
            char c;
            for (int i = 0; i < incorrectPassword.length(); i++) {
                c = incorrectPassword.charAt(i);
                if ((!Character.isLetterOrDigit(c))) {
                    countSpecial = countSpecial + 1;
                    System.out.println("Special Character in entered Password------" + c);
                    System.out.println("count of special characters------" + countSpecial);
                } else if (Character.isLetterOrDigit(c) && Character.isDigit(c)) {
                    countDigit = countDigit + 1;
                    System.out.println("Digits in entered Password--------------" + c);
                    System.out.println("count of digits------------" + countDigit);
                } else if (Character.isLetterOrDigit(c) && !Character.isDigit(c)) {
                    countAlphabet = countAlphabet + 1;
                    System.out.println("Alphabets in entered Password--------------" + c);
                    System.out.println("count of alphabets------------" + countAlphabet);
                } else
                    System.out.println("Invalid password");
            }
            System.out.println("countSpecial------" + countSpecial);
            System.out.println("countDigit------" + countDigit);
            System.out.println("countAlphabet------" + countAlphabet);
            try {
                if (countSpecial == 0 || countDigit == 0 || countAlphabet == 0) {
                    System.out.println("Exception occurred");
                    throw new Exception();
                } else {
                    System.out.println("Password follows business rules");
                }
            } catch (Exception e) {
                e.printStackTrace();
                Assert.assertTrue(false);
            }
        }
    }

    public void validateOTURLNotifications(List<String> parameter) {
        String notify = customerPortalSignInPageObj.txtOTURLNotification().getText();
        System.out.println("OTURL Notification is : " + notify);
        System.out.println("OTURL Message is :" + parameter.get(0));
        String oneTimeURL = parameter.get(0);
        Assert.assertTrue(notify.contains(oneTimeURL));
    }

    public void loginNotification(String message) {
        String msg = customerPortalSignInPageObj.txtLoginErrorNotification().getText();
        System.out.println("Error message from Application is : " + msg);
        System.out.println("Notification for incorrect login is : " + message);
        Assert.assertTrue(msg.equalsIgnoreCase(message));
    }

    public void loggedAsProspect() {
        customerPortalSignInPageObj.lnkClickNotAccountHolder().click();
    }

    public void selectTheRespectiveAccount(String account) {
        try{
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
        Thread.sleep(5000L);
        nextEventPageObj.getDriver.navigate().refresh();
            Thread.sleep(5000L);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
            Thread.sleep(5000L);
        nextEventPageObj.btnClick(customerPortalSignInPageObj.selectAccount(account));
        customerPortalSignInPageObj.iUnderstandBtn().click();
        }
        catch (Exception exe)
        {
            nextEventPageObj.getDriver.navigate().refresh();
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick(customerPortalSignInPageObj.selectAccount(account));
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            customerPortalSignInPageObj.iUnderstandBtn().click();
        }
    }
    public void launchDigitalForLogin(){
        String strEnvProfile = System.getProperty("ENV");
        String strURLToLaunch = "";
        String brand = "";
        System.out.println("PerformSearch.brandName--------------->"+PerformSearch.brandName);
        if(PerformSearch.brandName.contains("NatWest")){
            brand = "natwest";
        }else if(PerformSearch.brandName.contains("Royal Bank of Scotland")){
            brand = "rbs";
        }else if(PerformSearch.brandName.contains("Ulster Bank")){
            brand = "ulster";
        }
        if (System.getProperty("brand") != null){
            brand = System.getProperty("brand").toLowerCase();
        }
        System.out.println("------------------Note:Not executed Yet-----------------"+strEnvProfile);
        if(strEnvProfile.contains("AquariumDevURL")){
            strURLToLaunch = fileOperationsObj.getApplicationURL("DigitalDevURL").replace("#brand#",brand);
        }else if(strEnvProfile.contains("AquariumQAURL")) {
            strURLToLaunch = fileOperationsObj.getApplicationURL("DigitalQAURL").replace("#brand#",brand);
        }else if(strEnvProfile.contains("AquariumSITURL")){
            strURLToLaunch = fileOperationsObj.getApplicationURL("DigitalSITURL").replace("#brand#",brand);
        }else if(strEnvProfile.contains("AquariumPREPRODURL")){
            strURLToLaunch = fileOperationsObj.getApplicationURL("DigitalPREPRODURL").replace("#brand#",brand);
        }else if(strEnvProfile.contains("AquariumNFTURL")){
            if(brand.contains("ulster")){
                brand="ulsterbank";
            }
            strURLToLaunch = fileOperationsObj.getApplicationURL("DigitalNFTURL").replace("#brand#",brand);
        }
        System.out.println("URL that will be used to launch Digital===="+ strURLToLaunch);
        customerPortalSignInPageObj.getDriver.get(strURLToLaunch);
    }

    public void enterCredentialsForRecentUser(String user) {
        nextEventPageObj.waitForMoreTime();
        incorrectPassword = "Travel-1";
        if(user.equalsIgnoreCase("RecentRegisteredCustomer")) {
            customerPortalSignInPageObj.email().clear();
            System.out.println("Recent User is------" + policyOperationsObj.randomEmailID);
            customerPortalSignInPageObj.email().sendKeys(policyOperationsObj.randomEmailID);
        }else{
            customerPortalSignInPageObj.email().sendKeys(user);
        }
        nextEventPageObj.waitForMoreTime();
        customerPortalSignInPageObj.password().clear();
        customerPortalSignInPageObj.password().sendKeys(incorrectPassword);
        System.out.println("Entering pwd-----" + incorrectPassword);
        customerPortalSignInPageObj.signIn().click();
    }

    public void validateSplashPage(List<String> parameter) {
        System.out.println("I/p msg -----"+parameter.get(0));
        String downtimeMsg[] = parameter.get(0).split("#");
        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalSignInPageObj.lblSplashPage(downtimeMsg[0].split("'")[0].trim()))));
        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalSignInPageObj.lblSplashPage(downtimeMsg[0].split("'")[1].trim()))));
        Assert.assertTrue(nextEventPageObj.elementDisplayed(By.xpath(customerPortalSignInPageObj.msgSplashPage(downtimeMsg[1].trim()))));
    }

    public void capturePrivacyNoticesTextAndCompare(String strBrand) {
        WebElement wbBody = nextEventPageObj.getDriver.findElement(By.tagName("body"));
        String strTextFromApp = wbBody.getText().replaceAll("[^\\w\\d\\s]", " ");
        String strFile = "src/test/resources/CR43FilesToCompare/" + strBrand + "PrivacyNoticesBaseline.txt";
        strTextFromApp= strTextFromApp.replaceAll(" ","");
        System.out.println("From Applicaton=========" + strTextFromApp);
        String strOutput = fileOperationsObj.readFile(strFile).replaceAll("[^\\w\\d\\s]", " ");
        strOutput = strOutput.replaceAll(" ","");
        System.out.println("From baseline=========" + strOutput);
        System.out.println("Response :: "+strTextFromApp.toLowerCase().equalsIgnoreCase(strOutput.toLowerCase()));
        Assert.assertTrue(strTextFromApp.toLowerCase().equalsIgnoreCase(strOutput.toLowerCase()));
    }

    public void validateLinksInPrivacyNotices(){
        SoftAssertions softAssertions = new SoftAssertions();
        customerPortalSignInPageObj.lnkInsuranceGroupCompanies().click();
        nextEventPageObj.switchToWindowByIndex(1);
        String strInsuranceGroupCompanyTitle = nextEventPageObj.getDriver.getTitle();
        System.out.println("Insurance Group Title==="+strInsuranceGroupCompanyTitle);
        softAssertions.assertThat(strInsuranceGroupCompanyTitle).describedAs("Validating link Insurance Group of companies").isEqualTo("U K Insurance - Group Companies");
        nextEventPageObj.getDriver.close();
        nextEventPageObj.switchToWindowByIndex(0);
        customerPortalSignInPageObj.lnkExperian().click();
        nextEventPageObj.switchToWindowByIndex(1);
        String strExperianTitle = nextEventPageObj.getDriver.getTitle();
        System.out.println("Experian Title==="+strExperianTitle);
        softAssertions.assertThat(strExperianTitle).describedAs("Validating link Experian").isEqualTo("Credit Reference Agency Information Notice | Experian UK");;
        nextEventPageObj.getDriver.close();
        nextEventPageObj.switchToWindowByIndex(0);
        customerPortalSignInPageObj.lnkICOWebsite().click();
        nextEventPageObj.switchToWindowByIndex(1);
        String strICOTitle = nextEventPageObj.getDriver.getTitle();
        System.out.println("ICO Title==="+strICOTitle);
        softAssertions.assertThat(strICOTitle).describedAs("Validating link ICO Website").isEqualTo("Contact us | ICO");
        nextEventPageObj.getDriver.close();
        nextEventPageObj.switchToWindowByIndex(0);
        softAssertions.assertAll();
    }

    public void captureLegalDisclaimersTextAndCompare(String strBrand) {
        WebElement wbBody = nextEventPageObj.getDriver.findElement(By.tagName("body"));
        String strTextFromApp = wbBody.getText().replaceAll("[^\\w\\d\\s]", " ");
        String strFile = "src/test/resources/CR78FilesToCompare/" + strBrand + "LegalDisclaimersBaseline.txt";
        strTextFromApp= strTextFromApp.replaceAll(" ","");
        System.out.println("From Applicaton=========" + strTextFromApp);
        String strOutput = fileOperationsObj.readFile(strFile).replaceAll("[^\\w\\d\\s]", " ");
        strOutput = strOutput.replaceAll(" ","");
        System.out.println("From baseline=========" + strOutput);
        System.out.println("Response :: "+strTextFromApp.toLowerCase().equalsIgnoreCase(strOutput.toLowerCase()));
        Assert.assertTrue(strTextFromApp.toLowerCase().equalsIgnoreCase(strOutput.toLowerCase()));
    }


    public void validateLinksInLegalDisclaimers(){
        SoftAssertions softAssertions = new SoftAssertions();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalSignInPageObj.lnkMembershipServices().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToWindowByIndex(1);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        String strMembershipServicesTitle = nextEventPageObj.getDriver.getTitle();
        System.out.println("Membership Services Title==="+strMembershipServicesTitle);
        if(strMembershipServicesTitle.equalsIgnoreCase( "Home | Natwest Travel Insurance")) {
            softAssertions.assertThat(strMembershipServicesTitle).describedAs("Validating link Membership services").isEqualTo("Home | Natwest Travel Insurance");
            nextEventPageObj.getDriver.close();
            nextEventPageObj.switchToWindowByIndex(0);
        } else if (strMembershipServicesTitle.equalsIgnoreCase( "Home | RBS Travel Insurance")) {
            softAssertions.assertThat(strMembershipServicesTitle).describedAs("Validating link Membership services").isEqualTo("Home | RBS Travel Insurance");
            nextEventPageObj.getDriver.close();
            nextEventPageObj.switchToWindowByIndex(0);
        }else if (strMembershipServicesTitle.equalsIgnoreCase( "Home | Ulster Travel Insurance")) {
            softAssertions.assertThat(strMembershipServicesTitle).describedAs("Validating link Membership services").isEqualTo("Home | Ulster Travel Insurance");
            nextEventPageObj.getDriver.close();
            nextEventPageObj.switchToWindowByIndex(0);
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalSignInPageObj.linkPrivacyPolicy().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToWindowByIndex(1);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        String strPrivacyPolicyTitle = nextEventPageObj.getDriver.getTitle();
        System.out.println("Privacy policy Title==="+strPrivacyPolicyTitle);
        if(strPrivacyPolicyTitle.equalsIgnoreCase( "Privacy Notice | Natwest Travel Insurance")) {
            softAssertions.assertThat(strPrivacyPolicyTitle).describedAs("Validating link Privacy Policy").isEqualTo("Privacy Notice | Natwest Travel Insurance");
            nextEventPageObj.getDriver.close();
            nextEventPageObj.switchToWindowByIndex(0);
        }else if (strPrivacyPolicyTitle.equalsIgnoreCase( "Privacy Notice | RBS Travel Insurance")) {
            softAssertions.assertThat(strPrivacyPolicyTitle).describedAs("Validating link Privacy Policy").isEqualTo("Privacy Notice | RBS Travel Insurance");
            nextEventPageObj.getDriver.close();
            nextEventPageObj.switchToWindowByIndex(0);
        }else if (strPrivacyPolicyTitle.equalsIgnoreCase( "Privacy Notice | Ulster Travel Insurance")) {
            softAssertions.assertThat(strPrivacyPolicyTitle).describedAs("Validating link Membership services").isEqualTo("Privacy Notice | Ulster Travel Insurance");
            nextEventPageObj.getDriver.close();
            nextEventPageObj.switchToWindowByIndex(0);
        }
        softAssertions.assertAll();
    }
    public void captureEDRTextAndCompare(String strBrand) {
        WebElement wbBody = nextEventPageObj.getDriver.findElement(By.tagName("body"));
        String strTextFromApp = wbBody.getText().replaceAll("[^\\w\\d\\s]", " ");
        String strFile = "src/test/resources/CR78FilesToCompare/" + strBrand + "EDRBaseline.txt";
        strTextFromApp= strTextFromApp.replaceAll(" ","");
        System.out.println("From Applicaton=========" + strTextFromApp);
        String strOutput = fileOperationsObj.readFile(strFile).replaceAll("[^\\w\\d\\s]", " ");
        strOutput = strOutput.replaceAll(" ","");
        System.out.println("From baseline=========" + strOutput);
        System.out.println("Response :: "+strTextFromApp.toLowerCase().equalsIgnoreCase(strOutput.toLowerCase()));
        Assert.assertTrue(strTextFromApp.toLowerCase().equalsIgnoreCase(strOutput.toLowerCase()));
    }

    public void validateLinksInEDR(){
        SoftAssertions softAssertions = new SoftAssertions();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalSignInPageObj.lnkODRPlatform().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToWindowByIndex(1);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        String strODRTitle = nextEventPageObj.getDriver.getTitle();
        System.out.println("ODR Title==="+strODRTitle);
        strODRTitle.equalsIgnoreCase( "Online Dispute Resolution | European Commission");
            softAssertions.assertThat(strODRTitle).describedAs("Validating link Membership services").isEqualTo("Online Dispute Resolution | European Commission");
            nextEventPageObj.getDriver.close();
            nextEventPageObj.switchToWindowByIndex(0);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        customerPortalSignInPageObj.lnkContactUs().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToWindowByIndex(1);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        String strContactUsTitle = nextEventPageObj.getDriver.getTitle();
        System.out.println("Contact Us Title==="+strContactUsTitle);
        if(strContactUsTitle.equalsIgnoreCase( "Contact Us | Natwest Travel Insurance")) {
            softAssertions.assertThat(strContactUsTitle).describedAs("Validating link Contact us").isEqualTo("Contact Us | Natwest Travel Insurance");
            nextEventPageObj.getDriver.close();
            nextEventPageObj.switchToWindowByIndex(0);
        }else if (strContactUsTitle.equalsIgnoreCase( "Contact Us | RBS Travel Insurance")) {
            softAssertions.assertThat(strContactUsTitle).describedAs("Validating link Contact us").isEqualTo("Contact Us | RBS Travel Insurance");
            nextEventPageObj.getDriver.close();
            nextEventPageObj.switchToWindowByIndex(0);
        }else if (strContactUsTitle.equalsIgnoreCase( "Contact Us | Ulster Travel Insurance")) {
            softAssertions.assertThat(strContactUsTitle).describedAs("Validating link Contact us").isEqualTo("Contact Us | Ulster Travel Insurance");
            nextEventPageObj.getDriver.close();
            nextEventPageObj.switchToWindowByIndex(0);
        }
        softAssertions.assertAll();
    }
 }
