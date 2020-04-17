package co.uk.directlinegroup.tt.pages;


import com.usmanhussain.habanero.framework.AbstractPage;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

/**
 * Created by 588800 on 11/2/2017.
 */
public class CustomerPortalRegistrationPage extends AbstractPage {

    public WebElement btnRegister(){
       return waitForElementPresent(By.xpath("//*[contains(text(),'Register') and @class='primary-button']"));
    }

     public WebElement lblRegistration(){
       return waitForElementPresent(By.xpath("//h1[contains(text(),'Registration')]"));
    }

    public String errMsgExceedingRegAttempts(){
        return "//div[@class='error show']";
    }

    public String lnkCustCare()
    {
        return "//a[contains(text(),'Customer Operations')]";
    }












}
