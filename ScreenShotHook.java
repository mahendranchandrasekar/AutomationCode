package co.uk.directlinegroup.tt.hooks;

import co.uk.directlinegroup.tt.BaseStepDef;
import co.uk.directlinegroup.tt.pages.CustomerPortalHomePage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.step_definitions.Workflow;
import co.uk.directlinegroup.tt.utils.ClaimCreation;
import co.uk.directlinegroup.tt.utils.PolicyOperations;
import co.uk.directlinegroup.tt.utils.QuoteAndBuyOperations;
import co.uk.directlinegroup.tt.utils.common.Commands;
import com.usmanhussain.habanero.framework.WebDriverDiscovery;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotHook extends BaseStepDef {

    protected static final Logger LOG = LoggerFactory.getLogger(ScreenShotHook.class);
    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

    public Commands commandsObj = new Commands();
    public NextEventPage nextEventPageObj = new NextEventPage();
    public CustomerPortalHomePage customerPortalHomePageObj = new CustomerPortalHomePage();
    public PolicyOperations policyOperationsObj = new PolicyOperations();
    public QuoteAndBuyOperations quoteAndBuyOperationsObj = new QuoteAndBuyOperations();

    /**
     * Takes screen-shot if the scenario fails
     * <p>
     * //* @param scenario
     */
    @After()
    public void afterTest(Scenario scenario) throws InterruptedException, IOException {
        if (scenario.isFailed()) {
            try {
                scenario.write(getDriver().getCurrentUrl());
                byte[] screenShot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenShot, "image/png");
                scenario.embed(getDriver().getPageSource().getBytes(), "text/plain");
                //Har har = WebDriverDiscovery.server.getHar();
                //File harFile = new File("target/cucumber_reports/" + scenario.getName().replace("/", "").replace(" ", "") + ".har");
                //har.writeTo(harFile);
            } catch (WebDriverException e) {
                LOG.error(e.getMessage());
            }
        }else{
            //BN - This line is introduced to get rid of screen shot hook error when running tests from Jenkins
            getDriver().quit();
        }
        Workflow.hardLogout(commandsObj, customerPortalHomePageObj, nextEventPageObj);

        Date enddateobj = new Date();
        System.out.println("Scenario----------->" + scenario.getName() + "---End time---->" + df.format(enddateobj));
        /*scenario.write("Scenario----------->" + scenario.getName() + "---End time---->" + df.format(enddateobj));
        scenario.write("Customer Full Name : " + quoteAndBuyOperationsObj.randomCustomerFullName);
        scenario.write("Customer Portal Login ID : " + policyOperationsObj.randomEmailID);
        scenario.write("Policy id --------------->" + policyOperationsObj.policyId);
        scenario.write("Claim id --------------->" + ClaimCreation.claimID);*/
        scenario.write(scenario.getName()+"#"+quoteAndBuyOperationsObj.randomCustomerFullName+"#"+policyOperationsObj.randomEmailID+"#"+policyOperationsObj.policyId+"#"+ClaimCreation.claimID+"#"+scenario.isFailed());
        commandsObj.writingScenarioDetails(scenario.getName(),quoteAndBuyOperationsObj.randomCustomerFullName,policyOperationsObj.randomEmailID,policyOperationsObj.policyId,ClaimCreation.claimID);
    }

    @Before()
    public void beforeScenario(Scenario scenario) {
        try {
            System.out.println("*********************************** Running the try block ******************************");
//            WebDriverDiscovery.server.newHar(scenario.getName());
            String originalHandle = getDriver().getWindowHandle();
            int i = 0;
            for (String handle : getDriver().getWindowHandles()) {
                i++;
                if (!handle.equals(originalHandle)) {
                    getDriver().switchTo().window(handle);
                    getDriver().close();
                    System.out.println("Closing window " + i);
                }
            }
            getDriver().switchTo().window(originalHandle);
            Date startdateobj = new Date();
            System.out.println("Scenario----------->" + scenario.getName() + "---Start time---->" + df.format(startdateobj));
            if(scenario.getName().contains("CR61")){
               // System.setProperty("brand",null);
                System.clearProperty("brand");
                //System.getProperty("brand") = null;
            }
            System.out.println("************************************** END OF THE TRY BLOCK ****************************");
        } catch (NoClassDefFoundError e) {
            System.out.println("****************** NoClassDefFoundError has been detected ***********************");
            LOG.warn("No class definition has been thrown. Catching it so that the test is able to continue: " + e);
            String originalHandle = getDriver().getWindowHandle();
            int i = 0;
            for (String handle : getDriver().getWindowHandles()) {
                i++;
                if (!handle.equals(originalHandle)) {
                    getDriver().switchTo().window(handle);
                    getDriver().close();
                    System.out.println("Closing window " + i);
                }
            }
            getDriver().switchTo().window(originalHandle);
            Date startdateobj = new Date();
            System.out.println("Scenario----------->" + scenario.getName() + "---Start time---->" + df.format(startdateobj));
            System.out.println("********************************* END **********************************************");
        }
    }
}
