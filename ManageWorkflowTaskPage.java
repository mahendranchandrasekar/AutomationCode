package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ManageWorkflowTaskPage extends AbstractPage {

    public WebElement filterByAssigneeDropdown() {
        return waitAndFindElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ddlFilterByAssignee"));
    }

    public WebElement filterByWorkFlowGroupDropdown() {
        return waitAndFindElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ddlFilterByWorkflowGroup"));
    }

    public WebElement workFlowTaskTable() {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgWorkflowTasks_ctl01']"));
    }

    public String workFlowTaskTableTbody() {
        return "//table[contains(@id,'rgWorkflowTasks')]/tbody";
    }

    public WebElement assigneeFilter() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ddlFilterByAssignee"));
    }

    public WebElement workflowGroupFilter() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ddlFilterByWorkflowGroup"));
    }

    public WebElement workflowTaskAssignmentTable() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_rgWorkflowTasks_ctl01"));
    }

    public List<WebElement> workflowTasksLists() {
        return findElements(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgWorkflowTasks_ctl01']/tbody/tr"));
    }

    public WebElement leadID(String strRow) {
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgWorkflowTasks_ctl01']/tbody/tr[" + strRow + "]/td[11]"));
    }

    public WebElement caseID(String strRow) {
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgWorkflowTasks_ctl01']/tbody/tr[" + strRow + "]/td[12]"));
    }

    public WebElement assignee(String strRow) {
        return waitForElementPresent(By.xpath("//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgWorkflowTasks_ctl01']/tbody/tr[" + strRow + "]/td[8]"));
    }

    public WebElement caseIdInWorkflow(String caseID) {
        return waitForElementPresent(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_rgWorkflowTasks_ctl01']/tbody/tr/descendant::td/a[contains(text(),'" + caseID + "')]"));
    }

    public WebElement policyNumberInWorkFlowTaskTable(String policyNumber) {
        return waitForElementPresent(By.xpath("//*[contains(text(),'" + policyNumber + "')]"));
    }
    public void waitForDisableProgressWorkflowManage() {
        waitForElementInVisible(By.xpath("//*[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_imgProgressWorkflowManageTasks']"));
    }

    public WebElement caseIdTextbox() {
        return waitAndFindElement(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_txtCaseID"));
    }

    public WebElement assigneeFilterbtn() {
        return waitForElementPresent(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_btnFilterByCaseID"));
    }
}
