package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.ClaimSummaryPage;
import co.uk.directlinegroup.tt.pages.ManageWorkflowTaskPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class WorkflowAllocations {

    private ManageWorkflowTaskPage manageWorkflowTasksPageObj = new ManageWorkflowTaskPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();

    public boolean checkWorkflowTaskAllocation(String strAssignee, String strWorkflowGroup, String strLeadID, String strCaseID, String strPosition) {
        new Select(manageWorkflowTasksPageObj.assigneeFilter()).selectByVisibleText(strAssignee);
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
        new Select(manageWorkflowTasksPageObj.workflowGroupFilter()).selectByVisibleText(strWorkflowGroup);
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
        manageWorkflowTasksPageObj.waitForMoreTime();
        manageWorkflowTasksPageObj.waitForMoreTime();
        manageWorkflowTasksPageObj.waitForMoreTime();
        int iIndex = manageWorkflowTasksPageObj.workflowTasksLists().size();
        switch (strPosition.toLowerCase()) {
            case "first":
                break;
            case "last":
                System.out.println("index===" + iIndex);
                System.out.println("Lead ID====" + manageWorkflowTasksPageObj.leadID(String.valueOf(iIndex)).getText());
                System.out.println("strLeadID===" + strLeadID);
                System.out.println("Case ID====" + manageWorkflowTasksPageObj.caseID(String.valueOf(iIndex)).getText());
                System.out.println("strCaseId===" + strCaseID);
                System.out.println("Assignee====" + manageWorkflowTasksPageObj.assignee(String.valueOf(iIndex)).getText());
                System.out.println("strAssignee===" + strAssignee);
                Assert.assertTrue(manageWorkflowTasksPageObj.assignee(String.valueOf(iIndex)).getText().trim().equalsIgnoreCase(strAssignee));
                Assert.assertTrue(manageWorkflowTasksPageObj.leadID(String.valueOf(iIndex)).getText().trim().equalsIgnoreCase(strLeadID));
                Assert.assertTrue(manageWorkflowTasksPageObj.caseID(String.valueOf(iIndex)).getText().trim().equalsIgnoreCase(strCaseID));
                break;
        }
        return true;
    }
}
