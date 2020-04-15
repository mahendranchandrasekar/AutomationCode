package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.usmanhussain.habanero.framework.WebDriverDiscovery;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 324102 on 7/20/2017.
 */
public class SetUpOperations {

    protected static final Logger LOG = LoggerFactory.getLogger(SetUpOperations.class);
    public String chaseHours = "";
    private SetUpPage setUpPageObj = new SetUpPage();
    private PolicySummaryPage policySummaryPageObj = new PolicySummaryPage();
    private ChaseClaimsEvidencePage chaseClaimsEvidencePageObj = new ChaseClaimsEvidencePage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private LeftNavPanePage leftNavPanePageObj = new LeftNavPanePage();
    private PolicyOperations policyOperationsObj = new PolicyOperations();
    private Navigation navigationObj = new Navigation();
    private Commands commandsObj = new Commands();
    private CustomerDetailsFieldPage customerDetailsFieldPageObj = new CustomerDetailsFieldPage();
    private IAdminSecurityManagementPage iAdminSecurityManagementPageObj = new IAdminSecurityManagementPage();
    private User userObj= new User();
    private ClaimCompetencyPage claimCompetencyPageObj = new ClaimCompetencyPage();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private SchemeSummaryPage schemeSummaryPageObj= new SchemeSummaryPage();
    private DigitalOperations digitalOperationsObj = new DigitalOperations();

    public static String slaForProcess="";
    public static String timeRemainingForProcess="";

    public void validatePaymentSchedule(String Upgrades, List<List<String>> paymentScheduleDetails) {
        try {
            nextEventPageObj.btnClick(policySummaryPageObj.btnPurchase());
            int kk = 0;
            while (kk <= 5) {
                try {
                    if (policySummaryPageObj.isBtnPurchaseInvisible()) {
                        System.out.println("Purchase Button is invisible??--- " + policySummaryPageObj.isBtnPurchaseInvisible());
                        break;
                    }
                } catch (Exception ex) {
                    System.out.println("Purchase Button is still visible--- ");
                    kk++;
                }
            }
            commandsObj.waitForLoad(nextEventPageObj.getDriver);
            nextEventPageObj.btnClick(policySummaryPageObj.lnkSelectUpgrade(Upgrades));
            int webEleSize = 0;
            int ll = 0;
            while (webEleSize == 0 && ll <= 3) {
                webEleSize = policySummaryPageObj.waitForPaymentScheduleModelWindow().size();
                ll++;
            }
            for (int i = 1; i < paymentScheduleDetails.size(); i++) {
                for (int j = 0; j < paymentScheduleDetails.get(i).size(); j++) {
                    this.validatePaymentScheduleDetails(paymentScheduleDetails.get(0).get(j), paymentScheduleDetails.get(i).get(j));
                }
            }
            policySummaryPageObj.btnClose().click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectLatestUpgrade(String upgrade)  {
        nextEventPageObj.getDriver.navigate().refresh();
        System.out.println("Waiting for Payment Status to get reflected in application...........");
        try {
            Thread.sleep(95000L);
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nextEventPageObj.getDriver.navigate().refresh();
        try {
            Thread.sleep(8000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nextEventPageObj.getDriver.navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        List<WebElement> totalUpgrades = nextEventPageObj.getDriver.findElements(By.xpath(policySummaryPageObj.lnkLatestUpgrade(upgrade)));
        System.out.println("Total available upgrades----" + totalUpgrades.size());
        int index = totalUpgrades.size();
        System.out.println("Index----" + index);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nextEventPageObj.getDriver.findElement(By.xpath(policySummaryPageObj.lnkLatestUpgrade(upgrade))).click();
    }

    public void validateAccountInfo(String upgrade) {
        List<WebElement> totalUpgrades = nextEventPageObj.getDriver.findElements(By.xpath(policySummaryPageObj.lnkAccountInfoList(upgrade)));
        System.out.println("Total available upgrades----" + totalUpgrades.size());
        int index = totalUpgrades.size();
        System.out.println("Index----" + index);
        nextEventPageObj.getDriver.findElement(By.xpath(policySummaryPageObj.lnkAcctInformation(upgrade, index))).click();
        System.out.println("Captured account no from Digital ---------" + digitalOperationsObj.accountNo.trim());
        System.out.println("Validate Account No.in AQ ---------" + policySummaryPageObj.lblAccountno().getText());
        Assert.assertTrue(policySummaryPageObj.lblAccountno().getText().equalsIgnoreCase(digitalOperationsObj.accountNo.trim()));
        nextEventPageObj.waitForMoreTime();
        policySummaryPageObj.btnCancel().click();
    }

    public void validateLatestPaymentSchedule(String Upgrades, List<List<String>> paymentScheduleDetails) {
        nextEventPageObj.getDriver.navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
        policySummaryPageObj.btnPurchase().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policySummaryPageObj.btnBack().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policySummaryPageObj.btnPurchase().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policySummaryPageObj.btnBack().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        policySummaryPageObj.btnPurchase().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        this.selectLatestUpgrade(Upgrades);
        for (int i = 1; i < paymentScheduleDetails.size(); i++) {
            for (int j = 0; j < paymentScheduleDetails.get(i).size(); j++) {
                this.validatePaymentScheduleDetails(paymentScheduleDetails.get(0).get(j), paymentScheduleDetails.get(i).get(j));
            }
        }
        policySummaryPageObj.btnClose().click();
    }

    private void validatePaymentScheduleDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "payment status":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                System.out.println("Payment status is ---------" + policySummaryPageObj.lblPaymentStatus(fieldValue).getText());
                Assert.assertTrue(policySummaryPageObj.lblPaymentStatus(fieldValue).isDisplayed());
                break;
            case "collection date":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (fieldValue.equalsIgnoreCase("Future date")) {
                    policyOperationsObj.verifyDateisFutureDate();
                } else if (fieldValue.equalsIgnoreCase("Current Date")) {
                    policyOperationsObj.verifyDateCurrentDate();
                }
                break;
        }
    }

    public void runBatchJob(String job) throws Throwable {
        leftNavPanePageObj.setUP().click();
        leftNavPanePageObj.batchJobs().click();
        chaseClaimsEvidencePageObj.selectLeadType("All Batch Jobs");
        Thread.sleep(50000L);// Application performance Issue. No Loader window
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.switchToParentFrame();
        chaseClaimsEvidencePageObj.waitForMoreTime();
        if (job.equalsIgnoreCase("21178")) {
            setUpPageObj.lnkSelectJob("Billing_BD10B_Request Policy DD Transaction").click();
            chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
            chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
            chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
            } else if (job.equalsIgnoreCase("21177")) {
            setUpPageObj.lnkSelectJob("Billing_BD10_Queue Policy DD Transaction").click();
            chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
            chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
            chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
        }
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
        chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
        chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
        System.out.println("After running batch job, waiting for some time to let the status reflected into the application....");
        Thread.sleep(95000L);
        nextEventPageObj.getDriver.navigate().refresh();
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.switchToParentFrame();

    }

    public void runRenewalBatchJob(List<List<String>> batchDetails) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPanePageObj.setUP().click();
        leftNavPanePageObj.batchJobs().click();
        chaseClaimsEvidencePageObj.selectLeadType("All Batch Jobs");
        Thread.sleep(50000L);// Application performance Issue. No Loader window
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.switchToParentFrame();
        chaseClaimsEvidencePageObj.waitForMoreTime();
        chaseClaimsEvidencePageObj.waitForMoreTime();
        for (int i = 1; i < batchDetails.size(); i++) {
            for (int j = 0; j < batchDetails.get(i).size(); j++) {
                this.runJobs(batchDetails.get(0).get(j), batchDetails.get(i).get(j));
            }
        }
        Thread.sleep(95000L);
        nextEventPageObj.getDriver.navigate().refresh();
        chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
        commandsObj.waitForLoad(nextEventPageObj.getDriver);
        chaseClaimsEvidencePageObj.switchToParentFrame();
    }

    private void runJobs(String fieldName, String fieldValue) throws Throwable {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        switch (fieldName) {
            case "21201":
            case "21202":
            case "21203":
            case "21204":
            case "21205":
            case "21206":
            case "21207":
            case "21208":
            case "21232":
            case "21234":
            case "21235":
            case "21236":
            case "21209":
            case "21200":
            case "21115":
                System.out.println("Run Batch Job ----------" + fieldValue);
                setUpPageObj.selectBatch(fieldValue).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                Thread.sleep(10000L);
                break;
            case "21217":
                System.out.println("Run Batch Job ----------" + fieldValue);
                setUpPageObj.btnClick(setUpPageObj.selectBatch(fieldValue));
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                Thread.sleep(10000L);
                break;
            case "21271":
                System.out.println("Run Batch Job ----------" + fieldValue);
                setUpPageObj.selectBatchJobGP(fieldValue).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21269":
            case "21268":
                System.out.println("Run Batch Job ----------" + fieldValue);
                setUpPageObj.linkSelectJob(fieldValue).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21270":
                System.out.println("Run Batch Job ----------" + fieldValue);
                setUpPageObj.linkSelectJob(fieldValue).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21272":
                System.out.println("Run Batch Job ----------" + fieldValue);
                setUpPageObj.linkSelectJob(fieldValue).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21273":
                System.out.println("Run Batch Job ----------" + fieldValue);
                setUpPageObj.linkSelectJob(fieldValue).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21274":
                System.out.println("Run Batch Job ----------" + fieldValue);
                setUpPageObj.linkSelectJob(fieldValue).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21275":
                System.out.println("Run Batch Job ----------" + fieldValue);
                setUpPageObj.linkSelectJob(fieldValue).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21252":
                System.out.println("Run Batch Job ----------"+fieldValue);
                Thread.sleep(15000L);
                setUpPageObj.selectTaskID().sendKeys(fieldName);
                setUpPageObj.selectEdit3ForAge().click();
                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
            break;
            case "21155":
                System.out.println("Run Batch Job ----------"+fieldValue);
                Thread.sleep(15000L);
                setUpPageObj.selectTaskID().sendKeys(fieldName);
                setUpPageObj.btnClick(setUpPageObj.selectEdit1ForAge(fieldValue));
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21156":
                System.out.println("Run Batch Job ----------"+fieldValue);
                setUpPageObj.selectTaskID().sendKeys(fieldName);
                setUpPageObj.btnClick(setUpPageObj.selectEdit4());
                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21159":
                System.out.println("Run Batch Job ----------"+fieldValue);
                setUpPageObj.selectTaskID().sendKeys(fieldName);
                setUpPageObj.btnClick(setUpPageObj.selectEdit5());
                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21160":
                System.out.println("Run Batch Job ----------"+fieldValue);
                setUpPageObj.selectTaskID().sendKeys(fieldName);
                setUpPageObj.btnClick(setUpPageObj.selectEdit6());
                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21157":
                System.out.println("Run Batch Job ----------"+fieldValue);
                setUpPageObj.selectTaskID().sendKeys(fieldName);
                setUpPageObj.btnClick(setUpPageObj.selectEdit7());
                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21151":
                System.out.println("Run Batch Job ----------"+fieldValue);
                Thread.sleep(15000L);
                setUpPageObj.selectTaskID().sendKeys(fieldName);
                setUpPageObj.btnClick(setUpPageObj.selectEdit1ForAge(fieldValue));
                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21158":
                System.out.println("Run Batch Job ----------"+fieldValue);
                setUpPageObj.selectTaskID().sendKeys(fieldName);
                nextEventPageObj.btnClick(setUpPageObj.selectEdit2ForAge());
                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow());
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21836":
                System.out.println("Run Batch Job ----------"+fieldValue);
                setUpPageObj.selectTaskID().sendKeys(fieldName);
                setUpPageObj.healixNurseNotes().click();
                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow().click();
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21909":
                System.out.println("Run Batch Job ----------"+fieldValue);
                setUpPageObj.selectTaskID().sendKeys(fieldName);
                nextEventPageObj.btnClick(setUpPageObj.selectEdit4ForAge());
                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow());
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
            case "21163":
                System.out.println("Run Batch Job ----------"+fieldValue);
                setUpPageObj.selectTaskID().sendKeys(fieldName);
                nextEventPageObj.btnClick(setUpPageObj.selectEdit5ForAge());
                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(chaseClaimsEvidencePageObj.evidanceChaseBaseSetNow());
                chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
                chaseClaimsEvidencePageObj.evidanceChaseBaseSave().click();
                break;
        }
        commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_Loading(), 60L);
        chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
        nextEventPageObj.getDriver.navigate().refresh();
        chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();chaseClaimsEvidencePageObj.waitForMoreTime();
        commandsObj.waitForLoad(nextEventPageObj.getDriver);
    }

    public void setMedicalReportChaseHours(String chaseField) throws Throwable {
        navigationObj.navigateToImenu();
        navigationObj.navigateToIAdmin();
        navigationObj.navigateToCompanyDetails();
        navigationObj.navigateToTMA();
        if (chaseField.equalsIgnoreCase("Medical report")) {
            setUpPageObj.enterMedicalReportChaseHours().clear();
            setUpPageObj.enterMedicalReportChaseHours().sendKeys(chaseHours);
        } else if (chaseField.equalsIgnoreCase("GPMedical Report")) {
        } else if (chaseField.equalsIgnoreCase("LOA")) {
            setUpPageObj.enterloaChaseHours().clear();
            setUpPageObj.enterloaChaseHours().sendKeys(chaseHours);
        } else if (chaseField.equalsIgnoreCase("Access to Medical Information Chase Time Hours")) {
            setUpPageObj.enteraccesstomedicalinformationChaseHours().clear();
            setUpPageObj.enteraccesstomedicalinformationChaseHours().sendKeys(chaseHours);
        }
        claimSummaryPageObj.saveAndCloseBtn().click();
    }

    public void setTheUserLevelForTheBar(String nameOfBar, List<List<String>> parameter) {
        this.updateConfigurationForBar(parameter, nameOfBar);
        customerDetailsFieldPageObj.updateBtn().click();
        nextEventPageObj.switchToDefault();
        customerDetailsFieldPageObj.closeBarringWindowInConfiguration().click();
    }

    private void updateConfigurationForBar(List<List<String>> parameter, String nameOfBar) {
        for (int i = 1; i < parameter.size(); i++) {
            for (int j = 0; j < parameter.get(0).size(); j++) {
                switch (parameter.get(0).get(j)) {
                    case "Admin Group Id":
                        String userLevelId = "";
                        if (!parameter.get(i).get(j).equalsIgnoreCase("0")) {
                            navigationObj.navigateToImenu();
                            navigationObj.navigateToManageUserGroup();
                            userLevelId = iAdminSecurityManagementPageObj.groupId(parameter.get(i).get(j)).getText();
                            System.out.println("Userlevelid-----------------" + userLevelId);
                            navigationObj.navigateToImenu();
                            navigationObj.navigateToLeadManager();
                        } else
                            userLevelId = parameter.get(i).get(j);
                        this.navigateToCustomerBar(nameOfBar);
                        customerDetailsFieldPageObj.adminGroupId().clear();
                        customerDetailsFieldPageObj.adminGroupId().sendKeys(userLevelId);
                        break;
                    case "Potential Related Fraud":
                        if (!commandsObj.elementDisplayed(By.xpath(customerDetailsFieldPageObj.potentialRelatedFraudXpath()))) {
                            System.out.println("potential fraud is not displayed hence navigating to that page");
                            this.navigateToCustomerBar(nameOfBar);
                        }
                        System.out.println("potential fraud is now displayed");
                        String checkedStatus = customerDetailsFieldPageObj.potentialRelatedFraud().getAttribute("checked");
                        System.out.println("checked status--------------" + checkedStatus);
                        if (parameter.get(i).get(j).equalsIgnoreCase("true")) {
                            try {
                                if (checkedStatus.equalsIgnoreCase("null")) {
                                    customerDetailsFieldPageObj.potentialRelatedFraud().click();
                                }
                            } catch (Exception e) {
                                System.out.println("Catch");
                                checkedStatus = "null";
                                customerDetailsFieldPageObj.potentialRelatedFraud().click();
                            }
                        } else if (parameter.get(i).get(j).equalsIgnoreCase("false")) {
                            try {
                                if (checkedStatus.equalsIgnoreCase("true")) {
                                    customerDetailsFieldPageObj.potentialRelatedFraud().click();
                                }
                            } catch (Exception e) {
                                System.out.println("Catch");
                                checkedStatus = "null";
                                customerDetailsFieldPageObj.potentialRelatedFraud().click();
                            }
                        }
                        break;
                }
            }
        }
    }

    public void filterWithRecentCase() {
        List<WebElement> options = new Select(setUpPageObj.filterWithCase()).getOptions();
        System.out.println("Total available options----" + options.size());
        int index = options.size() - 1;
        System.out.println("Total Options----" + index);
        setUpPageObj.filterWithCase().click();
        new Select(setUpPageObj.filterWithCase()).selectByIndex(index);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("Filtered with last index value ------" + index);
    }

    private void navigateToCustomerBar(String block) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPanePageObj.setUP().click();
        leftNavPanePageObj.policyType().click();
        leftNavPanePageObj.resourcesAndTables().click();
        setUpPageObj.customerBarredRulesEdit().click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(customerDetailsFieldPageObj.barringConfigurationFrame());
        customerDetailsFieldPageObj.selectTheBar(block).click();
    }

    public void verifyBarringBlockMessageIsConfigurable(String block) {
        this.navigateToCustomerBar(block);
        Assert.assertTrue(customerDetailsFieldPageObj.complianceBlockMessageField().isEnabled());
    }

    public void deleteSLA(String processDescription){
        setUpPageObj.navigateTonewlyCreatedSLAFordeleting(processDescription).click();
        setUpPageObj.deleteSLA().click();
        nextEventPageObj.getDriver.switchTo().alert().accept();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void defineSLABetweenProcess(String leadType, List<List<String>> parameters){
        leftNavPanePageObj.setUP().click();
        setUpPageObj.navigateToEventProcessDeadlines().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        new Select(setUpPageObj.selectClaimType()).selectByVisibleText(leadType);
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        setUpPageObj.newBtnInEventProcessDeadLine().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(i).size(); j++) {
                String searchField=parameters.get(0).get(j);
                String searchValue=parameters.get(i).get(j);
                switch (searchField.toLowerCase()){
                    case "lead type":
                        new Select(setUpPageObj.selectLeadTypeProcessInProcessDeadLinePage()).selectByVisibleText(searchValue);
                        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                        break;
                    case "process deadline description":
                        setUpPageObj.processDescriptionInProcessDeadLinePage().clear();
                        setUpPageObj.processDescriptionInProcessDeadLinePage().sendKeys(searchValue);
                        break;
                    case "from event":
                        new Select(setUpPageObj.fromEventInProcessDeadLinePage()).selectByVisibleText(searchValue);
                        break;
                    case "to event":
                        new Select(setUpPageObj.toEventInProcessDeadLinePage()).selectByVisibleText(searchValue);
                        break;
                    case "number of days":
                        setUpPageObj.numberOfDaysInProcessDeadLinePage().clear();
                        setUpPageObj.numberOfDaysInProcessDeadLinePage().sendKeys(searchValue);
                        break;
                    case "number of hours":
                        setUpPageObj.numberOfHoursInProcessDeadLinePage().clear();
                        setUpPageObj.numberOfHoursInProcessDeadLinePage().sendKeys(searchValue);
                        break;
                    case "number of minutes":
                        setUpPageObj.numberOfMinutesInProcessDeadLinePage().clear();
                        setUpPageObj.numberOfMinutesInProcessDeadLinePage().sendKeys(searchValue);
                        break;
                }
            }
        }
        setUpPageObj.saveBtnInProcessDeadLinePage().click();
    }

    public void validateProcessSuccessfullyCreated(){
        Assert.assertTrue("validating successful creation of process",setUpPageObj.validateEventProcessSuccessfullyCreated().isDisplayed());
    }

    public void validateNonAdminUserPreviligesInProcessCreation(String leadType){
        leftNavPanePageObj.setUP().click();
        setUpPageObj.navigateToEventProcessDeadlines().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        new Select(setUpPageObj.selectClaimType()).selectByVisibleText(leadType);
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        Assert.assertTrue(!setUpPageObj.newBtnInEventProcessDeadLine().isEnabled());
        System.out.println( "Next button not enabled after assertion" );
    }

    public void retrieveSLAForDeadLine(String process,String leadType){
        nextEventPageObj.waitForMoreTime();
        leftNavPanePageObj.setUP().click();
        nextEventPageObj.waitForMoreTime();
        setUpPageObj.navigateToEventProcessDeadlines().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        new Select(setUpPageObj.selectClaimType()).selectByVisibleText(leadType);
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        int totalRowsInEventProcessDeadlines= setUpPageObj.numberOFRowsInEventProcessDeadLineTable().findElements(By.tagName("tr")).size();
        String cellText="";
        for(int i=1; i<=totalRowsInEventProcessDeadlines; i++){
           List<WebElement> columns=setUpPageObj.eventProcessRowsDeadLineTable().findElements(By.tagName("td"));
            for(int j=0; j<columns.size();j++){
                cellText = columns.get(j).getText();
                System.out.print("Retrieved Cell Text" +cellText);
                if(cellText.equalsIgnoreCase(process))
                {
                   slaForProcess=setUpPageObj.retrieveDaysInProcessTable(i).getText()+":"+setUpPageObj.retrieveHoursInProcessTable(i).getText()+":"+setUpPageObj.retrieveMinutesInProcessTable(i).getText();
                    System.out.println("SLA Process Retrieved" +slaForProcess);
                }
            }
        }
    }

    public void navigateToSlaTab(){
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        navigationObj.navigateToImenu();
        navigationObj.navigateToIAdmin();
        setUpPageObj.slaTab().click();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
    }

    public void retrieveTasksInSlaTab(List<List<String>> parameters){
        for(int i=1; i<parameters.size();i++){
            for(int j=0; j<parameters.get(i).size(); j++){
                String searchField=parameters.get(0).get(j);
                String searchValue=parameters.get(i).get(j);
                switch (searchField.toLowerCase()){
                    case "lead type":
                        new Select(setUpPageObj.leadTypeInSLA()).selectByVisibleText(searchValue);
                        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                        break;
                    case "service level agreement":
                        new Select(setUpPageObj.slaInSLA()).selectByVisibleText(searchValue);
                        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                        break;
                    case "completed":
                        if(searchValue.equalsIgnoreCase("false")) {
                        } else if(searchValue.equalsIgnoreCase("true")){
                                setUpPageObj.completedStatusInSLA().click();
                                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                            }
                        break;
                    case "sla":
                        if(searchValue.equalsIgnoreCase("withinSLA")) {
                           setUpPageObj.withinslaInSLA().click();
                            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                        } else if(searchValue.equalsIgnoreCase("outsideSLA")){
                            setUpPageObj.outsideslaInSLA().click();
                            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                        }
                        break;
                    case "fromdate":
                        String fromdate="";
                        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar c1 = Calendar.getInstance();
                        c1.setTime(new Date());
                        fromdate = sdf1.format(c1.getTime());
                        if(searchValue.equalsIgnoreCase("currentdate")){
                            searchValue=fromdate;
                        }
                        setUpPageObj.fromDateInSLA().sendKeys(Keys.CONTROL + "a");
                        setUpPageObj.fromDateInSLA().sendKeys(Keys.DELETE);
                        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                        setUpPageObj.fromDateInSLA().sendKeys(searchValue);
                        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                        break;
                    case "todate":
                        String date="";
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Calendar c = Calendar.getInstance();
                        c.setTime(new Date());
                        date = sdf.format(c.getTime());
                        if(searchValue.equalsIgnoreCase("currentdate")){
                            searchValue=date;
                        }
                        setUpPageObj.toDateInSLA().sendKeys(Keys.CONTROL + "a");
                        setUpPageObj.toDateInSLA().sendKeys(Keys.DELETE);
                        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                        setUpPageObj.toDateInSLA().sendKeys(searchValue);
                        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                        break;
                    case "claimid":
                        String retrievedClaimID="";
                        retrievedClaimID=ClaimsOperations.claimID;
                        System.out.println("Retrieved claimID from ClaimOperations Page" +retrievedClaimID);
                        if(!(retrievedClaimID.equals(null))) {
                            setUpPageObj.claimIDInputBoxInSLA().sendKeys(Keys.CONTROL + "a");
                            setUpPageObj.claimIDInputBoxInSLA().sendKeys(Keys.DELETE);
                            setUpPageObj.claimIDInputBoxInSLA().sendKeys(retrievedClaimID);
                            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                            setUpPageObj.claimIDInputBoxFilterInSLA().click();
                            setUpPageObj.equalToFilter().click();
                            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                        }
                        else
                        Assert.assertFalse(true);
                        break;
                    case "validation":
                        if(searchValue.equalsIgnoreCase("claim should be listed")){
                            int size=setUpPageObj.claimValidationInTaskTable().findElements(By.tagName("tr")).size();
                            System.out.println("size of task table" +size);
                            if(setUpPageObj.claimValidationInTaskTable().findElements(By.tagName("tr")).size()>0){
                                  Assert.assertTrue(true);
                              }
                            else{
                                  Assert.assertTrue(false);
                              }
                        }  else if(searchValue.equalsIgnoreCase("claim should not be listed"))     {
                            Assert.assertTrue(setUpPageObj.validateNoTaskListed().isDisplayed());
                        }
                    case "time remaining":
                        if(searchField.equalsIgnoreCase("validate")) {
                            slaForProcess = setUpPageObj.slaInTaskTable().getText();
                            timeRemainingForProcess = setUpPageObj.timeRemainingInTaskTable().getText();
                            boolean flg = false;
                            for (int loop = 0; loop < slaForProcess.length(); loop++) {
                                if (slaForProcess.charAt(loop) != timeRemainingForProcess.charAt(loop)) {
                                    flg = true;
                                    //break;
                                }
                            }
                            if (flg) {
                                Assert.assertTrue(true);
                            } else {
                                Assert.assertFalse(true);
                            }
                        }
                        break;
                    case "assignedto":
                        List<String> userDet = userObj.getUserDetails(searchValue);
                        searchValue=userDet.get(0);
                        Assert.assertTrue(claimCompetencyPageObj.validateClaimHandlerAssignee(searchValue).isDisplayed());
                        break;
                    case "viewclaim":
                        claimSummaryPageObj.viewClaim(ClaimsOperations.claimID).click();
                        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                        break;
                    case "tmaclaimid":
                        String retrievedTMAClaimID="";
                        retrievedTMAClaimID=ClaimsOperations.retrievedTMAClaimId;
                        System.out.println("Retrieved claimID from ClaimOperations Page" +retrievedTMAClaimID);
                        if(!(retrievedTMAClaimID.equals(null))) {
                            setUpPageObj.claimIDInputBoxInSLA().sendKeys(Keys.CONTROL + "a");
                            setUpPageObj.claimIDInputBoxInSLA().sendKeys(Keys.DELETE);
                            setUpPageObj.claimIDInputBoxInSLA().sendKeys(retrievedTMAClaimID);
                            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                            setUpPageObj.claimIDInputBoxFilterInSLA().click();
                            setUpPageObj.equalToFilter().click();
                            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                        }
                        else
                            Assert.assertFalse(true);
                        break;
                }
            }
        }
    }

    public void updateCustomerBarRules(String barType, String paymentField) {
        nextEventPageObj.btnClick(setUpPageObj.customerBarredRulesEdit());
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(customerDetailsFieldPageObj.barringConfigurationFrame());
        nextEventPageObj.btnClick(customerDetailsFieldPageObj.selectTheBar(barType));
        System.out.println("setUpPageObj.allowPaymentChkBox().getAttribute(\"checked\")-----------------"+setUpPageObj.allowPaymentChkBox().getAttribute("checked"));
        if(paymentField.equalsIgnoreCase("Not to Allow Payment")){
            if(setUpPageObj.allowPaymentChkBox().getAttribute("checked")!=null && setUpPageObj.allowPaymentChkBox().getAttribute("checked").equalsIgnoreCase("true")){
                System.out.println("----------------------Checked-----------------");
                nextEventPageObj.btnClick(setUpPageObj.allowPaymentChkBox());
            }
        }else if(paymentField.equalsIgnoreCase("Allow Payment")){
            System.out.println("----------------------Checked--paymentField---------------"+paymentField);
            if(setUpPageObj.allowPaymentChkBox().getAttribute("checked")==null){
                System.out.println("-------UN---------------Checked-----------------");
                setUpPageObj.allowPaymentChkBox().click();
            }
        }else if(paymentField.contains("GroupID to edit")){
            setUpPageObj.groupIDtoEditBar().clear();
            setUpPageObj.groupIDtoEditBar().sendKeys(paymentField.split("#")[1]);
        }
        nextEventPageObj.btnClick(setUpPageObj.updateCutomerBarredRules());
        nextEventPageObj.switchToDefault();
        nextEventPageObj.btnClick(setUpPageObj.closeCustomerBarredRulesFrame());
    }
}
