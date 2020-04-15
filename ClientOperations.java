package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.common.DateOperations;
import com.usmanhussain.habanero.framework.WebDriverDiscovery;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 324102 on 9/13/2017.
 */
public class ClientOperations extends WebDriverDiscovery {

    public static String caseIdForPolicy = "";
    private CustomerDetailsFieldPage customerDetailsFieldPageObj = new CustomerDetailsFieldPage();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private co.uk.directlinegroup.tt.utils.Navigation navigationObj = new co.uk.directlinegroup.tt.utils.Navigation();
    private Commands commandsObj = new Commands();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private DateOperations dateOperationsObj = new DateOperations();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private PolicyOperations policyOperationsObj = new PolicyOperations();
    private FullEventHistoryPage fullEventHistoryPageObj = new FullEventHistoryPage();
    private SetUpPage setUpPageObj = new SetUpPage();
    private LeftNavPanePage leftNavPanePageObj = new LeftNavPanePage();

    public void verifyBarringFieldDetails(String OOPForBar, List<List<String>> parameters) {
        claimsOperationsObj.clickingUnderNextEventsAndButtons("out of process event");
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
        navigationObj.navigateToNextEventType(OOPForBar);
        if(OOPForBar.equalsIgnoreCase("OOP Add Multiple Bars")){
            nextEventPageObj.waitForMoreTime();
            claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
        }
        System.out.println("going to click Customer Bar plus icon");
        customerDetailsFieldPageObj.waitForMoreTime();
        customerDetailsFieldPageObj.waitForMoreTime();
        customerDetailsFieldPageObj.waitForMoreTime();
        customerDetailsFieldPageObj.selectCutomerBar().click();
        nextEventPageObj.switchToFrameById(policyDataFieldsPageObj.policyFrame());
        for (int i = 0; i < parameters.size(); i++) {
            Assert.assertTrue(customerDetailsFieldPageObj.fieldsInBarringPage(parameters.get(i).get(0)).isDisplayed());
        }
    }

    public void verifyOptions(List<List<String>> parameters) {
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(i).size(); j++) {
                this.verifyOptionsInClientBarring(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        getDriver().navigate().refresh();
    }

    private void verifyOptionsInClientBarring(String s, String s1) {
        for (int i = 0; i < s1.split("#").length; i++) {
            if (commandsObj.elementDisplayedWithLessTime(By.xpath(customerDetailsFieldPageObj.optionsInBarringPage(s1.split("#")[i])))) {
                System.out.println("s1.split(\"#\")[i]--------------------------" + s1.split("#")[i]);
                Assert.assertTrue(true);
            } else if (commandsObj.elementDisplayedWithLessTime(By.xpath(customerDetailsFieldPageObj.nextLink()))) {
                nextEventPageObj.waitForElementPresent(By.xpath(customerDetailsFieldPageObj.nextLink())).click();
                System.out.println("s1.split(\"#\")[i]--------------------------" + s1.split("#")[i]);
                Assert.assertTrue(commandsObj.elementDisplayedWithLessTime(By.xpath(customerDetailsFieldPageObj.optionsInBarringPage(s1.split("#")[i]))));
            } else {
                System.out.println("s1.split(\"#\")[i]-------else--------------------------" + s1.split("#")[i]);
                Assert.assertTrue(false);
            }
        }
    }

    private void updateReassessmentDate(int iDays) {
        customerDetailsFieldPageObj.reassessmentDate().clear();
        customerDetailsFieldPageObj.waitForMoreTime();
        customerDetailsFieldPageObj.waitForMoreTime();
        customerDetailsFieldPageObj.waitForMoreTime();
        customerDetailsFieldPageObj.reassessmentDate().sendKeys(dateOperationsObj.addingDays(iDays));
        customerDetailsFieldPageObj.waitForMoreTime();
        customerDetailsFieldPageObj.waitForMoreTime();
        customerDetailsFieldPageObj.waitForMoreTime();
    }

    public void verifyNameOfBarAdded(String bar, List<List<String>> parameters) {
        claimsOperationsObj.clickingUnderNextEventsAndButtons("out of process event");
        navigationObj.navigateToNextEventType(bar);
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                switch (parameters.get(0).get(j).toLowerCase()) {
                    case "name of bar":
                        Assert.assertTrue(customerDetailsFieldPageObj.nameOfBarInTable(parameters.get(i).get(j)).isDisplayed());
                        break;
                    case "bar status":
                        Assert.assertTrue(customerDetailsFieldPageObj.statusOfBar(parameters.get(i).get(j)).isDisplayed());
                        break;
                }
            }
        }
    }

    public void verifyMessageForNotification(String notificationType, List<List<String>> message) {
        String messageFromPage = customerDetailsFieldPageObj.notificationMessage(notificationType).getText();
        System.out.println("Message-----------------" + messageFromPage.replace("\n", " "));
        Assert.assertTrue(messageFromPage.replace("\n", " ").equalsIgnoreCase(message.get(1).get(0)));
    }

    public void validateLinkedConditionsDataInSchemesummary(String people, List<List<String>> parameters) {
        claimSummaryPageObj.selectNamedPeopleInSchemeSummary(people).click();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                String searchField = parameters.get(0).get(j);
                String searchValue = parameters.get(1).get(j);
                switch (parameters.get(0).get(j).toLowerCase()) {
                    case "screening date":
                        System.out.println("Inside screening date");
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
                        Date currentDate = new Date();
                        String strDate = dateFormat.format(currentDate);
                        searchValue=strDate;
                        System.out.println("System current date:" + searchValue);
                        Assert.assertTrue(claimSummaryPageObj.validateNamedPeopleDetailsInSchemeSummary(searchField, searchValue).isDisplayed());
                        break;
                    case "exclusions":
                        System.out.println("Inside exclusions");
                        Assert.assertTrue(claimSummaryPageObj.validateNamedPeopleDetailsInSchemeSummary(searchField, searchValue).isDisplayed());
                        break;
                    case "exclusions (linked conditions)":
                        System.out.println("Inside conditions");
                        Assert.assertTrue(claimSummaryPageObj.validateNamedPeopleDetailsInSchemeSummary(searchField, searchValue).isDisplayed());
                        break;
                    case "score":
                        System.out.println("Inside score");
                        Assert.assertTrue(claimSummaryPageObj.validateNamedPeopleDetailsInSchemeSummary(searchField, searchValue).isDisplayed());
                        break;
                }
            }
        }
    }

    public void removeBlockAndVerfyBlockMessageRemoved(String block) {
        claimsOperationsObj.clickingUnderNextEventsAndButtons("out of process event");
        navigationObj.navigateToNextEventType("OOP Edit Bars");
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        switch (block) {
            case "Compliance - A":
            case "Customer Bar":
                customerDetailsFieldPageObj.nameOfBarInEdit().click();
                customerDetailsFieldPageObj.nameOfBarBarStatusInEditOption("stop individual supplier payments").click();
                customerDetailsFieldPageObj.barStatus().click();
                customerDetailsFieldPageObj.nameOfBarBarStatusInEditOption("Inactive").click();
                break;
            case "Compliance - S":
            case "Compliance Bar":
                customerDetailsFieldPageObj.nameOfBarInEdit().click();
                customerDetailsFieldPageObj.nameOfBarBarStatusInEditOption("Stop payments to suppliers related to a claim").click();
                customerDetailsFieldPageObj.barStatus().click();
                customerDetailsFieldPageObj.nameOfBarBarStatusInEditOption("Inactive").click();
                break;
        }
        customerDetailsFieldPageObj.saveBtn().click();
        Assert.assertTrue(!commandsObj.elementDisplayed(By.xpath(customerDetailsFieldPageObj.notificationMessageXpath(block))));
    }

    public void verifyTaskAllocated() {
        System.out.println("case id------------------case -----------------" + caseIdForPolicy);
        String caseId = customerDetailsFieldPageObj.caseIdUnderWorkflow(caseIdForPolicy).getText();
        Assert.assertTrue(caseId.equalsIgnoreCase(caseIdForPolicy));
        getDriver().navigate().back();
    }

    public void verifyTaskAllocatedInGetNextTask() {
        String policyNumberSaved = policyOperationsObj.policyNumber;
        claimSummaryPageObj.getNextTask().click();
        policyOperationsObj.getPolicyNumber();
        String policyNumberAfterGetNextTask = policyOperationsObj.policyNumber;
        Assert.assertTrue(policyNumberSaved.equalsIgnoreCase(policyNumberAfterGetNextTask));
    }

    public void inactivateBarringOption(String barringOption, String oopEvent) {
        for (int i = 0; i < barringOption.split("#").length; i++) {
            claimsOperationsObj.clickingUnderNextEventsAndButtons("out of process event");
            navigationObj.navigateToNextEventType(oopEvent);
            claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
            customerDetailsFieldPageObj.nameOfBarInEdit().click();
            customerDetailsFieldPageObj.nameOfBarBarStatusInEditOption(barringOption).click();
            customerDetailsFieldPageObj.barStatus().click();
            customerDetailsFieldPageObj.nameOfBarBarStatusInEditOption("Inactive").click();
            customerDetailsFieldPageObj.saveBtn().click();
        }
    }

    public void validateErrorMessage(List<List<String>> message) {
        if (commandsObj.elementDisplayed(By.xpath(policyDataFieldsPageObj.createEventAndOpenToPrintBtnXpath())))
            policyDataFieldsPageObj.createEventAndOpenToPrintBtn().click();

        Assert.assertTrue(customerDetailsFieldPageObj.errorMessage(message.get(0).get(0)).isDisplayed());
    }

    public void navigateTOLeadManager() {
        navigationObj.navigateToImenu();
        navigationObj.navigateToLeadManager();

    }

    public void enterDeceasedDetails(String oopEvent, List<List<String>> parameters) {
        if(oopEvent.equalsIgnoreCase("Deceased OOP")) {
            claimsOperationsObj.clickingUnderNextEventsAndButtons("out of process event");
        } else if(!oopEvent.equalsIgnoreCase("Complete Deceased Dashboard")) {
            claimsOperationsObj.clickingUnderNextEventsAndButtons("add a jumpto event");
        }
        navigationObj.navigateToNextEventType(oopEvent);
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());

        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.enterDeceasedCustomerDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
        customerDetailsFieldPageObj.saveBtn().click();
    }

    private void enterDeceasedCustomerDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "select deceased":
                if (fieldValue.equalsIgnoreCase("verify deceased")) {
                    String deceasedValue = policyDataFieldsPageObj.deceasedMarked().getText();
                    System.out.println("deceasedValue-----------------------------------" + deceasedValue);
                    Assert.assertTrue(deceasedValue.equalsIgnoreCase("true"));
                } else if(fieldValue.equalsIgnoreCase("select deceased as true")){
                    String dateofBirth=policyDataFieldsPageObj.dateofBirthOfDeceasedPerson().getText();
                    policyDataFieldsPageObj.editMainAccountHolder().click();
                    policyDataFieldsPageObj.chkBk_Deceased().click();
                    policyDataFieldsPageObj.enterdateofBirthOfDeceasedPerson().sendKeys(dateofBirth);
                    policyDataFieldsPageObj.addInsuredPerson_SaveBtn().click();
                    Assert.assertTrue(policyDataFieldsPageObj.markedAsDeceased().getText().equalsIgnoreCase("true"));
                } else{
                    policyDataFieldsPageObj.editMainAccountHolder().click();
                    policyDataFieldsPageObj.chkBk_Deceased().click();
                    policyDataFieldsPageObj.addInsuredPerson_SaveBtn().click();
                }
                break;
            case "date of death":
                customerDetailsFieldPageObj.dateOfDeath().clear();
                customerDetailsFieldPageObj.dateOfDeath().sendKeys(fieldValue);
                break;
            case "cause of death":
                customerDetailsFieldPageObj.causeOfDeath().clear();
                customerDetailsFieldPageObj.causeOfDeath().sendKeys(fieldValue);
                break;
            case "details of death":
                customerDetailsFieldPageObj.detailsOfDeath().clear();
                customerDetailsFieldPageObj.detailsOfDeath().sendKeys(fieldValue);
                break;
            case "location of death":
                customerDetailsFieldPageObj.locationOfDeath().clear();
                customerDetailsFieldPageObj.locationOfDeath().sendKeys(fieldValue);
                break;
            case "notify funeral director":
                System.out.println("---------notify funeral director---------------------");
                customerDetailsFieldPageObj.notifyFuneralDirector().click();
                break;
            case "notify dlg media team":
                System.out.println("---------notify funeral director---------------------");
                customerDetailsFieldPageObj.notifyDLGMediaTeam().click();
                break;
            case "notify tim":
                System.out.println("---------notify funeral director---------------------");
                customerDetailsFieldPageObj.notifyTIMTravelInsuranceManagement().click();
                break;
        }
    }

    public void verifyNotificationEventsAndMail(List<List<String>> parameters) {
        nextEventPageObj.switchToDefault();
        claimsOperationsObj.clickingUnderNextEventsAndButtons("show full event history");
        String event = "";
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                switch (parameters.get(0).get(j).toLowerCase()) {
                    case "event":
                        event = parameters.get(i).get(j);
                        System.out.println("event innnnn-------------------" + event);
                        Assert.assertTrue(fullEventHistoryPageObj.eventsInHistory(parameters.get(i).get(j)).isDisplayed());
                        break;
                    case "team":
                        System.out.println("Event----------------------------" + event);
                        String comments = fullEventHistoryPageObj.lblComments(event).getText();
                        System.out.println("comments-----------------------------" + comments);
                        String subStringComments = comments.substring(comments.indexOf(":") + 1, comments.indexOf("CC"));
                        System.out.println("sub string ----------------" + subStringComments);
                        Assert.assertTrue(subStringComments.trim().equalsIgnoreCase(parameters.get(i).get(j)));
                        break;
                    case "mail notification":
                        Assert.assertTrue(fullEventHistoryPageObj.previewEmailLinkForEvent(event).isDisplayed());
                        break;
                }
            }
        }
    }

    public void selectAllowOption(String systemLockType, String bar){
        leftNavPanePageObj.setUP().click();
        leftNavPanePageObj.policyType().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPanePageObj.resourcesAndTables().click();
        setUpPageObj.customerBarredRulesEdit().click();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(customerDetailsFieldPageObj.barringConfigurationFrame());
        customerDetailsFieldPageObj.selectTheBar(systemLockType).click();
        setUpPageObj.allowPaymentChkBox().click();
        setUpPageObj.updateCutomerBarredRules().click();
        getDriver().navigate().refresh();
    }

    public void selectBarType(String systemLockType, String OOPForBar, String strDays) {
        int iNoOfBars = systemLockType.split("#").length;
        for (int i = 0; i < iNoOfBars; i++) {
            claimsOperationsObj.clickingUnderNextEventsAndButtons("out of process event");
            navigationObj.navigateToNextEventType(OOPForBar);
            if(OOPForBar.equalsIgnoreCase("OOP Add Multiple Bars")){
                nextEventPageObj.waitForMoreTime();
                claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
            }
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
            caseIdForPolicy = customerDetailsFieldPageObj.policyCaseId().getText();
            System.out.println("caseIdForPolicy------------------------" + caseIdForPolicy);
            customerDetailsFieldPageObj.waitForMoreTime();
            customerDetailsFieldPageObj.waitForMoreTime();
            customerDetailsFieldPageObj.waitForMoreTime();
            customerDetailsFieldPageObj.selectCutomerBar().click();
            nextEventPageObj.switchToFrameById(policyDataFieldsPageObj.policyFrame());
            if (commandsObj.elementDisplayed(By.xpath(customerDetailsFieldPageObj.selectSystemLockTypeXpath(systemLockType.split("#")[i]))))
                customerDetailsFieldPageObj.selectSystemLockType(systemLockType.split("#")[i]).click();
            else {
                nextEventPageObj.waitForElementPresent(By.xpath(customerDetailsFieldPageObj.nextLink())).click();
                customerDetailsFieldPageObj.selectSystemLockType(systemLockType.split("#")[i]).click();
            }
            customerDetailsFieldPageObj.waitForMoreTime();
            customerDetailsFieldPageObj.waitForMoreTime();
            customerDetailsFieldPageObj.waitForMoreTime();
            nextEventPageObj.switchToDefault();
            nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
            try {
                    Thread.sleep(5000);
            }catch (Exception e){
                System.out.println("Exception 0-----------------"+e);
            }
            if(strDays!=null & strDays!="NA") {
                this.updateReassessmentDate(Integer.parseInt(strDays));
            }
            nextEventPageObj.btnClick(customerDetailsFieldPageObj.saveBtn());
            nextEventPageObj.waitForPageLoad();
            if(OOPForBar.equalsIgnoreCase("OOP Add Multiple Bars")) {
                nextEventPageObj.btnClick(customerDetailsFieldPageObj.customerBlocks());
                if(iNoOfBars > 1) {
                    customerDetailsFieldPageObj.drdpcustomerBlocksOption().click();
                    customerDetailsFieldPageObj.customerBlocksOptionAsYes().click();
                }else{
                    customerDetailsFieldPageObj.drdpcustomerBlocksOption().click();
                    customerDetailsFieldPageObj.customerBlocksOptionAsNo().click();
                }
                nextEventPageObj.btnClick(customerDetailsFieldPageObj.saveBtn());
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimsOperationsObj.clickingUnderNextEventsAndButtons("refresh");
            }
        }
    }

    public void verifySpecificTaskAllocatedInGetNextTask(List<List<String>> parameters) {
        commandsObj.waitForLoad(getDriver());
        claimSummaryPageObj.getNextTask().click();
        commandsObj.waitForLoad(getDriver());
        String nextEven = null;
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                switch (parameters.get(0).get(j).toLowerCase()) {
                    case "nextevent":
                        nextEven = parameters.get(i).get(j);
                        System.out.println("nextevent-------------------" + nextEven);
                        String currTask = claimSummaryPageObj.getWorkflowCurrentTask().getText();
                        Assert.assertTrue(currTask.contains(nextEven));
                        break;
                    case "caseid":
                        String workflowCaseID = claimSummaryPageObj.getWorkflowCaseID().getText();
                        System.out.println("workflowCaseID from Summary Screen:: "+workflowCaseID);
                        System.out.println("claimsOperationsObj.claimcaseid :: "+claimsOperationsObj.claimcaseid);
                        //Assert.assertTrue(workflowCaseID.contains("57350100"));
                        Assert.assertTrue(workflowCaseID.contains(claimsOperationsObj.claimcaseid));
                        break;
                }
            }
        }
    }
}
