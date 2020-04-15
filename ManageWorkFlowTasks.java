package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.ManageWorkflowTaskPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.common.WebTable;
import net.serenitybdd.core.annotations.findby.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ManageWorkFlowTasks {

    private WebTable webTableObj = new WebTable();
    private ManageWorkflowTaskPage manageWorkflowTaskPageObj = new ManageWorkflowTaskPage();
    private NextEventPage nextEventPageObj = new NextEventPage();

    public String getLatestRecord() {
        List<WebElement> lstRows = nextEventPageObj.findElements(By.xpath("//table[contains(@id,'rgWorkflowTasks')]/tbody/tr"));// manageWorkflowTaskPage.workFlowTableTbody().findElements(By.tagName("tr"));
        int noOfRows = nextEventPageObj.findElements(By.xpath("//table[contains(@id,'rgWorkflowTasks')]/tbody/tr")).size();
        int iAssigneeColumnNumber = webTableObj.getColumnFromWebTable(manageWorkflowTaskPageObj.workFlowTaskTable(), "Assignee");
        List<WebElement> lstCols = lstRows.get(noOfRows - 1).findElements(org.openqa.selenium.By.tagName("td"));
        String assignee = lstCols.get(iAssigneeColumnNumber).getText();
        return assignee;
    }

    public List<String> getUserNamePwd(String userType) {
        Properties prop = new Properties();
        InputStream input = null;
        List<String> loginDetails = new ArrayList<String>();
        try {
            input = new FileInputStream("src/test/resources/AssignDetails.properties");
            prop.load(input);
            String strLoginProfileDet = prop.getProperty(userType);
            loginDetails.add(strLoginProfileDet.split("#")[0]);
            loginDetails.add(strLoginProfileDet.split("#")[1]);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return loginDetails;
    }
}