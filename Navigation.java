package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import co.uk.directlinegroup.tt.utils.common.Commands;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static co.uk.directlinegroup.tt.utils.ClaimCreation.claimID;


//import static co.uk.directlinegroup.tt.utils.ClaimCreation.claimID;

public class Navigation {


    private LeftNavPanePage leftNavPaneObj = new LeftNavPanePage();
    private DetailFieldsListPage detailFieldsListPageObj = new DetailFieldsListPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();
    private TMADetailsPage tmaDetailsPageObj = new TMADetailsPage();
    private CustomerDetailsFieldPage customerDetailsFieldPageObj = new CustomerDetailsFieldPage();
    private FullEventHistoryPage fullEventHistoryPageObj = new FullEventHistoryPage();
    private Commands commandsObj = new Commands();
    private ClaimCompetencyPage claimCompetencyPageObj = new ClaimCompetencyPage();

    private String assignee = "TestUser28 TestUser";
    private String assignee2 = "Blink Sil";
    public static List<WebElement> TMAClaimAssigneeList;
    public static List<WebElement> TMAClaimHandlerList;

    public void navigateToSearchScreen() {
        this.validatePoliciesPanelIsDisplayed();
        leftNavPaneObj.btnClick(leftNavPaneObj.searchLead());
    }

    public void validatePoliciesPanelIsDisplayed() {
        String strContinue = "Yes";
        int iCount = 0;
        do {
            if (leftNavPaneObj.policiesPanelIsDisplayed()) {
                if (!leftNavPaneObj.policiesPanel().getAttribute("style").contains("display: none;")) {
                    if (leftNavPaneObj.searchLead().isDisplayed()) {
                        break;
                    }
                }
            }
            leftNavPaneObj.leads().click();
            iCount++;
            if (iCount > 1000) {
                break;
            }
        } while (strContinue.equalsIgnoreCase("Yes"));
    }

    public void navigateToiAdmin() {
        leftNavPaneObj.iMenu().click();
        nextEventPageObj.waitForPageLoad();
        leftNavPaneObj.iAdmin().click();
        nextEventPageObj.waitForPageLoad();
    }

    public void navigateToManageUserGroup() {
        this.navigateToiAdmin();
        leftNavPaneObj.manageUserGroup().click();
    }

    public void naviagteToReport() {
        this.navigateToIReporting();
        this.navigateToManageReport();
    }

    public void navigateToNewPolicy() {
        String strContinue = "Yes";
        int iCount = 0;
        do {
            if (leftNavPaneObj.policiesPanelIsDisplayed()) {
                if (!leftNavPaneObj.policiesPanel().getAttribute("style").contains("display: none;")) {
                    if (leftNavPaneObj.newPolicy().isDisplayed()) {
                        break;
                    }
                }
            }
            leftNavPaneObj.leads().click();
            iCount++;
            if (iCount > 1000) {
                break;
            }
        } while (strContinue.equalsIgnoreCase("Yes"));
        System.out.println("outside do");
        leftNavPaneObj.btnClick(leftNavPaneObj.newPolicy());
    }

    public void navigateToDetailFieldListPage() {
        this.validatePoliciesPanelIsDisplayed();
        leftNavPaneObj.setUP().click();
        leftNavPaneObj.detailFields().click();
    }

    public void navigateToNoteTypes() {
        this.validatePoliciesPanelIsDisplayed();
        leftNavPaneObj.setUP().click();
        leftNavPaneObj.noteTypes().click();
    }

    public void navigateToResourcesAndTablesManagePagesScreen() {
        this.navigateToDetailFieldListPage();
        new Select(detailFieldsListPageObj.filterByLeadType()).selectByVisibleText("Resources and Tables");
        detailFieldsListPageObj.managePages().click();
    }

    public void naviagteToWorkflowTasks() {
        leftNavPaneObj.workflow().click();
        leftNavPaneObj.workflowTasks().click();
    }

    public void navigateToCustomerCommsPref() {
        if (policyDataFieldsPageObj.moreDetailsDisplayed()) {
            nextEventPageObj.btnClick(policyDataFieldsPageObj.moreDetails());
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            customerDetailsFieldPageObj.commPrefTab().click();
        }
    }

    public void navigateToWorkflowGroup() {
        leftNavPaneObj.workflow().click();
        leftNavPaneObj.workflowGroups().click();
    }

    public void changeThechaseValue() {
        leftNavPaneObj.chaseConfirmation().clear();
        leftNavPaneObj.chaseConfirmation().sendKeys("0");
        leftNavPaneObj.chasePayment().clear();
        leftNavPaneObj.chasePayment().sendKeys("0");
        policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.saveandclose());
        nextEventPageObj.waitForPageLoad();
    }

    public void changeThechaseValueAsOne() {
        leftNavPaneObj.chaseConfirmation().clear();
        leftNavPaneObj.chaseConfirmation().sendKeys("1");
        leftNavPaneObj.chasePayment().clear();
        leftNavPaneObj.chasePayment().sendKeys("1");
        policyDataFieldsPageObj.btnClick(policyDataFieldsPageObj.saveandclose());
        nextEventPageObj.waitForPageLoad();
    }

    public void navigateToNextEventType(String strEventType) {
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForPageLoad();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        if (nextEventPageObj.elementDisplayed(By.xpath(nextEventPageObj.nextEventClaimsXPath()))) {
            System.out.println("Inside the Claims - Capture Incident");
            new Select(nextEventPageObj.nextEventClaims()).selectByVisibleText(strEventType);
            nextEventPageObj.btnClick( nextEventPageObj.nextButtonSensitive());
            System.out.println("Finishing...1");
            commandsObj.waitForElementInVisibleInSec(nextEventPageObj.getLoader_PleasewaitLocator(), 60L);
            System.out.println("Finishing...2");
            commandsObj.waitForLoad(nextEventPageObj.getDriver);
            System.out.println("Finishing...3");
       }
    }

    public void navigateToIReporting() {
        if (leftNavPaneObj.IReportingPanelIsDisplayed()) {
            leftNavPaneObj.btnClick(leftNavPaneObj.IReportingPanel());
            leftNavPaneObj.ireportWait();
        }
    }

    public void navigateToManageReport() {
        if (leftNavPaneObj.manageReportPanelIsDisplayed()) {
            leftNavPaneObj.btnClick(leftNavPaneObj.ManageReportPanel());
            leftNavPaneObj.ManageReportWait();
        }
    }

    public void navigateToImenu() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.iMenu().isDisplayed();
        leftNavPaneObj.iMenu().click();
        leftNavPaneObj.imenuWait();
    }

    public void navigateToIAdmin() {
        leftNavPaneObj.iAdmin().isDisplayed();
        leftNavPaneObj.iAdmin().click();
        leftNavPaneObj.iadminWait();
    }

    public void navigateToRecoveryConfiguration() {
        leftNavPaneObj.recoveryConfigtab().isDisplayed();
        leftNavPaneObj.recoveryConfigtab().click();
        nextEventPageObj.waitForMoreTime();
    }

    public void navigateToCompanyDetails() {
        leftNavPaneObj.companyDetails().isDisplayed();
        leftNavPaneObj.companyDetails().click();
        leftNavPaneObj.companyDetailsWait();
    }

    public void navigateToRecovery() {
        leftNavPaneObj.recoveryTab().isDisplayed();
        leftNavPaneObj.recoveryTab().click();
        leftNavPaneObj.recoveryTaskTab().click();
        nextEventPageObj.waitForMoreTime();
    }

    public void verifyClaimID(String claimID) {
        leftNavPaneObj.claimIDFilter().sendKeys(claimID);
        leftNavPaneObj.claimIDFilterClick().click();
        leftNavPaneObj.claimIDFilterClickEqualTo().click();
        Assert.assertTrue(leftNavPaneObj.claimIDInRecoveryTask().getText().equalsIgnoreCase(claimID));
    }

    public void navigateToLeadManager() {
        leftNavPaneObj.leadManager().isDisplayed();
        leftNavPaneObj.leadManager().click();
    }

    public void navigateToIPT() {
        leftNavPaneObj.iptTab().isDisplayed();
        leftNavPaneObj.iptTab().click();
        leftNavPaneObj.waitForiptTab();
    }

    public void navigateToVAT() {
        leftNavPaneObj.vatTab().isDisplayed();
        leftNavPaneObj.vatTab().click();
        leftNavPaneObj.waitForVATTab();
    }

    public void navigateToTMA() {
        leftNavPaneObj.tmaTab().isDisplayed();
        leftNavPaneObj.tmaTab().click();
        leftNavPaneObj.waitFortmaTab();
    }

    public void navigateToWorkflow() {
        String strContinue = "Yes";
        do {
            if (leftNavPaneObj.workflowPanelIsDisplayed()) {
                if (!leftNavPaneObj.workflowPanel().getAttribute("style").contains("display: none;")) {
                    if (leftNavPaneObj.workflowTasks().isDisplayed()) {
                        break;
                    }
                }
            }
            leftNavPaneObj.workflow().click();
        } while (strContinue.equalsIgnoreCase("Yes"));
        System.out.println("outside do");
        leftNavPaneObj.btnClick(leftNavPaneObj.workflowTasks());
    }

    public void navigateToPolicyTypes() {
        this.validatePoliciesPanelIsDisplayed();
        leftNavPaneObj.setUP().click();
        leftNavPaneObj.policyType().click();
        leftNavPaneObj.resourcesAndTables().click();
    }

    public void navigateToSystem() {
        leftNavPaneObj.systemTab().isDisplayed();
        leftNavPaneObj.systemTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.lblDocuments();
    }

    public void navigateToIAdminToCaptureIPT() {
        leftNavPaneObj.switchToDefault();
        leftNavPaneObj.closeRuleEnginewindow().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        this.navigateToImenu();
        this.navigateToIAdmin();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void naivgateToClaimCompetency() {
        leftNavPaneObj.claimCompetencyTab().click();
        leftNavPaneObj.claimCompetency().click();
    }

    public void naivgateToManualAllocation() {
        leftNavPaneObj.claimCompetency().click();
        leftNavPaneObj.claimCompetencyTab().click();
    }

    public void navigateToNextEventType1(String strEventType, List<List<String>> parameters) {
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        if (nextEventPageObj.eventTypeDrpDwn().isDisplayed()) {
            System.out.println("Inside the Claims - Capture Incident");
            new Select(nextEventPageObj.nextEventClaims()).selectByVisibleText(strEventType);
            nextEventPageObj.nextButtonSensitive().click();
            for (int row = 1; row < parameters.size(); row++) {
                for (int column = 0; column < parameters.get(0).size(); column++) {
                    this.selectCommunicationPereference(parameters.get(row).get(column));
                    tmaDetailsPageObj.btnSave1().click();
                }
            }
        }
    }

    public void selectCommunicationPereference(String fieldName) {
        try {
            switch (fieldName.toLowerCase()) {
                case "supplier":
                    tmaDetailsPageObj.chBxSupplier().click();
                    break;
                case "customer":
                    tmaDetailsPageObj.chBxCustomer().click();
                    break;
                case "nextOfKin":
                    tmaDetailsPageObj.chBxNextOfKin().click();
                    break;
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public void navigateToPolicyView() {
        System.out.println("---------------Policy view---------------");
        policyDataFieldsPageObj.basePolicyLink().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void navigateToIncidentsConfig() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.iAdmin().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.companyDetails().click();
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.incidentTab().click();
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.waitForMoreTime();
    }

    public void navigateToIncidentsConfigEdit() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.iAdmin().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.companyDetails().click();
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.incidentTab().click();
        fullEventHistoryPageObj.waitForMoreTime();
        fullEventHistoryPageObj.btnClick(fullEventHistoryPageObj.editButton());
        fullEventHistoryPageObj.waitForMoreTime();
    }

    public void naivgateToManualClaimHandlerAlloc() {
        leftNavPaneObj.claimCompetencyTab().click();
        leftNavPaneObj.manualClaimHandlerAlloc().click();
    }

    public void navigateToClaimTasks(String tabName) {
        leftNavPaneObj.iMenu().click();
        leftNavPaneObj.leadManager().click();
        leftNavPaneObj.claimCompetencyTab().click();
        leftNavPaneObj.claimTasksTab().click();
    }

    public void navigateToDocumentManager() {
        leftNavPaneObj.documentManager().click();
    }

    public void reassignTheClaimReferral(String ClaimID) {
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.clickOnAssign(ClaimID).click();
        leftNavPaneObj.clickOnReAssignClaimID().isDisplayed();
        System.out.println("Assigning the claimID------Frame1---");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.clickOnReAssignClaimID().isDisplayed();
        leftNavPaneObj.clickOnReAssignClaimID().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("Assigning the claimID------Frame1---");
        nextEventPageObj.waitForMoreTime();
    }

    public void reassignSecondTimeTheClaimReferral(String ClaimID) {
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.clickOnReAssign(ClaimID).click();
        leftNavPaneObj.clickOnReAssignClaimID().isDisplayed();
        System.out.println("Assigning the claimID------Frame1---");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.clickOnReAssignSecondTimeClaimID().isDisplayed();
        leftNavPaneObj.clickOnReAssignSecondTimeClaimID().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("Assigning the claimID------Frame1---");
        nextEventPageObj.waitForMoreTime();
    }

    public void verifyReAssigneeName(String ClaimID) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("leftNavPaneObj.getAssigneNameInOutStanding(ClaimID).getText()------" + leftNavPaneObj.getAssigneNameInOutStanding(ClaimID).getText());
    }

    public void caseIDVerificationInWorkflow(String CaseID) {
        leftNavPaneObj.getAssigneeFromworkFlowTask(CaseID).isDisplayed();
        System.out.println("leftNavPaneObj.getAssigneeFromworkFlowTask(CaseID).getText())------" + leftNavPaneObj.getAssigneeFromworkFlowTask(CaseID).getText());
    }

    public void claimIDVerificationInPolicyPage(String ClaimID) {
        leftNavPaneObj.getAssigneeFromworkFlowTask(ClaimID).isDisplayed();
        System.out.println("leftNavPaneObj.getAssigneeFromPolicyPage(ClaimID).getText())" + leftNavPaneObj.getAssigneeFromPolicyPage(ClaimID).getText());
    }

    public void txtClaimHandlersTMA() {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        this.navigateToImenu();
        nextEventPageObj.waitForPageLoad();
        this.navigateToManageUserGroup();
        nextEventPageObj.btnClick(leftNavPaneObj.lnkEditTMAHandler());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TMAClaimHandlerList = nextEventPageObj.findElements(By.xpath(leftNavPaneObj.listTMAClaimHandler()));
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("no of items-----------------------------" + TMAClaimHandlerList.size());
        for (int i = 0; i < TMAClaimHandlerList.size(); i++) {
            System.out.println("TMA Claim Handler " + i + "is" + TMAClaimHandlerList.get(i).getText());
        }
    }

    public void allocateClaim(String claimId) {
        claimId = claimID;
        System.out.println("Claim id is ---- " +claimId);
        this.navigateToImenu();
        this.navigateToLeadManager();
        nextEventPageObj.btnClick(leftNavPaneObj.claimCompetencyTab());
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.btnClick(leftNavPaneObj.manualClaimHandlerAlloc());
        nextEventPageObj.waitForPageLoad();
        nextEventPageObj.btnClick(leftNavPaneObj.claimIdManualFilter());
        leftNavPaneObj.claimIdManualFilter().sendKeys(claimId);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(leftNavPaneObj.selectFilter());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(leftNavPaneObj.txtFilterValue());
        nextEventPageObj.waitForMoreTime();
        System.out.println("Validating the failure reason 'TMA Claim'");
         Assert.assertTrue(leftNavPaneObj.txtAllocationFailedReason().isDisplayed());
        System.out.println("Validated the failure reason 'TMA Claim'");
        nextEventPageObj.btnClick(claimCompetencyPageObj.allocateClaim(claimId));
        nextEventPageObj.waitForMoreTime();
    }

    public void allocateClaimToHandler(String allocation, String claimId, String handler) {
        claimId = claimID;
        this.navigateTOClaimAllocation(allocation);
        nextEventPageObj.btnClick(leftNavPaneObj.claimIdManualFilter());
        leftNavPaneObj.claimIdManualFilter().sendKeys(claimId);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(leftNavPaneObj.selectFilter());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(claimCompetencyPageObj.containsFilter());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("Validating the failure reason 'TMA Claim'");
        if(allocation.equalsIgnoreCase("allocate"))
            Assert.assertTrue(leftNavPaneObj.txtAllocationFailedReason().isDisplayed());
        System.out.println("Validated the failure reason 'TMA Claim'");
        nextEventPageObj.btnClick(claimCompetencyPageObj.allocateClaimManually(claimId,allocation));
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPaneObj.claimHandlerTextField().clear();
        leftNavPaneObj.claimHandlerTextField().sendKeys(handler);
        nextEventPageObj.btnClick(leftNavPaneObj.claimHandlerFilter());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(claimCompetencyPageObj.containsFilter());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(leftNavPaneObj.lnkAssignTMAClaim());
        nextEventPageObj.waitForMoreTime();
    }

    private void navigateTOClaimAllocation(String allocation) {
        this.navigateToImenu();
        this.navigateToLeadManager();
        nextEventPageObj.btnClick(leftNavPaneObj.claimCompetencyTab());
        nextEventPageObj.waitForPageLoad();
        if(allocation.equalsIgnoreCase("allocate"))
        nextEventPageObj.btnClick(leftNavPaneObj.manualClaimHandlerAlloc());
        else if(allocation.equalsIgnoreCase("reassign"))
        nextEventPageObj.btnClick(leftNavPaneObj.allocateCompetency());
        nextEventPageObj.waitForPageLoad();
    }

    public void validateAssigneewithClaimHandlersTMA() {
        try {
            Thread.sleep(8000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TMAClaimAssigneeList = nextEventPageObj.findElements(By.xpath(leftNavPaneObj.listTMAAssignee()));
        try {
            Thread.sleep(4000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println("no of items-----------------------------" + TMAClaimAssigneeList.size());
            if (TMAClaimAssigneeList.size() == TMAClaimHandlerList.size()) {
            for (int j = 0; j < TMAClaimHandlerList.size(); j++) {
                Assert.assertTrue(leftNavPaneObj.txtAssignee(TMAClaimHandlerList.get(j).getText()).isDisplayed());
                System.out.println("Assignee is  " + TMAClaimHandlerList.get(j).getText() + " validated");
            }
            }
    }

    public void validateClaimAtAssigneeLevel(String user){
       user = TMAClaimAssigneeList.get(0).getText();
       System.out.println("Assignee is ---- "+user);
        nextEventPageObj.btnClick(leftNavPaneObj.lnkAssignTMAClaim());
       try {
           Thread.sleep(10000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("Clicking Assign button");
       try {
           Thread.sleep(10000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       nextEventPageObj.waitForPageLoad();
       System.out.println("Navigate to IMenu");
       this.navigateToImenu();
       nextEventPageObj.waitForPageLoad();
       this.navigateToIAdmin();
       nextEventPageObj.waitForPageLoad();
       nextEventPageObj.btnClick(claimCompetencyPageObj.manageUsersTab());
       nextEventPageObj.waitForPageLoad();
       claimCompetencyPageObj.manageUsersWait();
       nextEventPageObj.waitForMoreTime();
       nextEventPageObj.waitForMoreTime();
       claimCompetencyPageObj.nameField().sendKeys(user);
       nextEventPageObj.waitForMoreTime();
       nextEventPageObj.waitForMoreTime();
       claimCompetencyPageObj.nameFilter().click();
       claimCompetencyPageObj.containsFilter().click();
       nextEventPageObj.waitForMoreTime();
       nextEventPageObj.waitForMoreTime();
       nextEventPageObj.waitForMoreTime();
       nextEventPageObj.btnClick(claimCompetencyPageObj.userEdit());
       nextEventPageObj.waitForPageLoad();
       System.out.println("Claim id is  ----- "+claimID);
       Assert.assertTrue(leftNavPaneObj.txtClaimIdAtAssignee(claimID).isDisplayed());
       System.out.println("Validated the claim at Assignee level");
       nextEventPageObj.btnClick(claimCompetencyPageObj.saveAndClose());
       nextEventPageObj.waitForMoreTime();
       nextEventPageObj.waitForMoreTime();
   }

   public void validateReAssigneeOption(){
       System.out.println("*****");
       nextEventPageObj.btnClick(leftNavPaneObj.claimCompetencyTab());
       nextEventPageObj.waitForPageLoad();
       nextEventPageObj.btnClick(leftNavPaneObj.allocateCompetency());
       nextEventPageObj.waitForPageLoad();
       try {
           Thread.sleep(8000L);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("Clicking ReAssign buttun");
       nextEventPageObj.btnClick(leftNavPaneObj.clickOnReAssign(claimID));
       System.out.println("Clicked ReAssign button");
       try {
           Thread.sleep(8000L);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       nextEventPageObj.waitForMoreTime();
       nextEventPageObj.waitForPageLoad();
       nextEventPageObj.btnClick(leftNavPaneObj.reassignTMAClaim());
       nextEventPageObj.waitForMoreTime();
       try {
           Thread.sleep(8000L);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }

}


