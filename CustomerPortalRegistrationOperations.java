package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.CustomerPortalRegistrationPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.common.FileOperations;
import org.junit.Assert;

import java.util.List;

/**
 * Created by 588800 on 11/2/2017.
 */
public class CustomerPortalRegistrationOperations {

    private CustomerPortalRegistrationPage customerPortalRegistrationPageObj = new CustomerPortalRegistrationPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private DigitalOperations digitalOperationsObj = new DigitalOperations();
    private FileOperations fileOperationsObj = new FileOperations();

    public void clickOnRegistration() {
        customerPortalRegistrationPageObj.btnRegister().click();
        Assert.assertTrue(customerPortalRegistrationPageObj.lblRegistration().isDisplayed());
    }

//    Added for membership login
    public void launchRegistrationPage(){
        String strEnvProfile = System.getProperty("ENV");
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
        System.out.println("brand parameter value captured during registration is==="+brand);
        String strRegistrationURL = "";
        strRegistrationURL = fileOperationsObj.getApplicationURL("MembershipServicesRegistrationURL").replace("#brand#",brand);
    }

    public void launchRegistrationPageWithoutCaptcha(){
        String strEnvProfile = System.getProperty("ENV");
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
        System.out.println("brand parameter value captured during registration is==="+brand);
        String strRegistrationURL = "";
        if(strEnvProfile.contains("AquariumDevURL")){
            strRegistrationURL = fileOperationsObj.getApplicationURL("DigitalDevRegistrationURL").replace("#brand#",brand);
        }else if(strEnvProfile.contains("AquariumQAURL")) {
            strRegistrationURL = fileOperationsObj.getApplicationURL("DigitalQARegistrationURL").replace("#brand#",brand);
        }else if(strEnvProfile.contains("AquariumSITURL")){
            strRegistrationURL = fileOperationsObj.getApplicationURL("DigitalSITRegistrationURL").replace("#brand#",brand);
        }else if(strEnvProfile.contains("AquariumPREPRODURL")){
            strRegistrationURL = fileOperationsObj.getApplicationURL("DigitalPREPRODRegistrationURL").replace("#brand#",brand);
        }else if(strEnvProfile.contains("AquariumNFTURL")){
            if(brand.contains("ulster")){
                brand="ulsterbank";
            }
            strRegistrationURL = fileOperationsObj.getApplicationURL("DigitalNFTRegistrationURL").replace("#brand#",brand);
        }
        System.out.println("Digital Registration URL Launched is ===="+strRegistrationURL);
        nextEventPageObj.getDriver.get(strRegistrationURL);
    }

    public void enterRegistrationDetails(List<List<String>> newParameters) {
        for (int row = 1; row < newParameters.size(); row++) {
            for (int column = 0; column < newParameters.get(0).size(); column++) {
                System.out.println("Digital Customer setup ---------Field name ----" + newParameters.get(0).get(column) + "------- Field value-------" + newParameters.get(row).get(column));
                digitalOperationsObj.signUpDigCustomer(newParameters.get(0).get(column), newParameters.get(row).get(column));
            }
        }
    }

    public void reEnterCustomerRegistrationDetails(int attempts, List<List<String>> parameters) {
        for(int i=1;i<=attempts;i++)
        {
            System.out.println("No of attempts----"+i);
            this.enterRegistrationDetails(parameters);
        }
    }
}
