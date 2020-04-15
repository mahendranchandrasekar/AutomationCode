package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.CustomerPortalSignInPage;
import co.uk.directlinegroup.tt.pages.LoginPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class User {

    private LoginPage loginPageObj = new LoginPage();
    private CustomerPortalSignInPage customerPortalSignInPageObj = new CustomerPortalSignInPage();
    private NextEventPage nextEventPageObj = new NextEventPage();

    public List<String> getUserDetails(String userType) {
        Properties prop = new Properties();
        InputStream input = null;
        List<String> userDetails = new ArrayList<String>();

        try {
            input = new FileInputStream("src/test/resources/LoginProfiles.properties");
            prop.load(input);
            String strLoginProfileDet = prop.getProperty(userType);
            System.out.println(strLoginProfileDet.split("#")[0]);
            userDetails.add(strLoginProfileDet.split("#")[0]);
            userDetails.add(strLoginProfileDet.split("#")[1]);
            userDetails.add(strLoginProfileDet.split("#")[2]);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return userDetails;
    }

    public void login(String userName, String password) {
        loginPageObj.eMail().sendKeys(userName);
        loginPageObj.password().sendKeys(password);
        nextEventPageObj.btnClick(loginPageObj.logon());
    }

    public void logOut() {
        nextEventPageObj.switchToWindowByIndex(1);
        nextEventPageObj.btnClick(nextEventPageObj.logOut());
    }

    public void customerPortalLogin(String email, String password) {
        customerPortalSignInPageObj.email().sendKeys(email);
        customerPortalSignInPageObj.password().sendKeys(password);
        nextEventPageObj.waitForMoreTime();
        customerPortalSignInPageObj.signIn().click();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void customerPortalSignOut() {
        customerPortalSignInPageObj.btnClick(customerPortalSignInPageObj.signOut());
        customerPortalSignInPageObj.waitForMoreTime();
        customerPortalSignInPageObj.waitForMoreTime();
        customerPortalSignInPageObj.btnClick(customerPortalSignInPageObj.signOutConfirm());
    }
}
