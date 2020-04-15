package co.uk.directlinegroup.tt.utils.common;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait extends AbstractPage {

    public void waitForValuesToLoad(WebElement element) {
        try {
            getDriver.wait(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElementToLoad(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        //getDriver.manage().timeouts().implicitlyWait()
    }

    public void waitForExtraTime(int noOfIterations){
        for(int i=0;i<noOfIterations;i++){
            waitForMoreTime();
        }
    }

}
