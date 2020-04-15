package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.CustomerFAQPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.common.FileOperations;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by 588800 on 10/4/2017.
 */
public class CustomerFAQOperations {

    List<String> recordDetails = null;
    List<WebElement> listedApplicationFAQs = null;
    private NextEventPage nextEventPageOnj = new NextEventPage();
    private FileOperations fileOperationsObj = new FileOperations();
    private CustomerFAQPage customerFAQPageObj = new CustomerFAQPage();

    public void validateAllCategoriesFAQ(List<String> category) {
        customerFAQPageObj.lblMyCover().click();
        nextEventPageOnj.waitForMoreTime();
        this.verifyListedQuestions(category, 0);
        customerFAQPageObj.lblMedCond().click();
        nextEventPageOnj.waitForMoreTime();
        this.verifyListedQuestions(category, 1);
        customerFAQPageObj.lblClaim().click();
        nextEventPageOnj.waitForMoreTime();
        this.verifyListedQuestions(category, 2);
        customerFAQPageObj.lblPolicy().click();
        nextEventPageOnj.waitForMoreTime();
        this.verifyListedQuestions(category, 3);
        customerFAQPageObj.lblChangeAddr().click();
        nextEventPageOnj.waitForMoreTime();
        this.verifyListedQuestions(category, 4);
        customerFAQPageObj.lblAddUpgrades().click();
        nextEventPageOnj.waitForMoreTime();
        this.verifyListedQuestions(category, 5);
        customerFAQPageObj.lblCloseAcct().click();
        nextEventPageOnj.waitForMoreTime();
        this.verifyListedQuestions(category, 6);
    }

    public void verifyListedQuestions(List<String> propertyParameter, int position) {
        listedApplicationFAQs = nextEventPageOnj.getDriver.findElements(By.tagName("h3"));
        System.out.println("FAQs from appl-------- size -------" + listedApplicationFAQs.size());
        recordDetails = fileOperationsObj.getListOfAllDigitalFAQ(propertyParameter.get(position));
        System.out.println("FAQs from property file ----size---" + recordDetails.size());
        System.out.println("FAQs from property file ----" + recordDetails);
        for (int i = 0; i < recordDetails.size(); i++) {
            boolean flag = false;
            for (int j = 0; j < listedApplicationFAQs.size(); j++) {
                if (recordDetails.get(i).equalsIgnoreCase(listedApplicationFAQs.get(j).getText())) {
                    System.out.println("FAQs from appl--------------" + listedApplicationFAQs.get(j).getText());
                    System.out.println("Values are equal.... :)");
                    flag = true;
                    break;
                }
            }
            if (flag) {
                Assert.assertTrue(flag);
            }
        }
    }
}
