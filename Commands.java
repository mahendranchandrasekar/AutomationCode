package co.uk.directlinegroup.tt.utils.common;

import co.uk.directlinegroup.tt.pages.NextEventPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import static com.usmanhussain.habanero.framework.AbstractPage.getDriver;

public class Commands {

    private FileOperations fileOperationsObj = new FileOperations();
    private NextEventPage nextEventPageObj = new NextEventPage();

    public List<List<String>> parameterMapping(Integer iSize, List<List<String>> parameters) {
        List<List<String>> newParameters = new ArrayList<>();
        String dataRecord = "";
        String dataHeader = "";
        List<String> headerDetails = fileOperationsObj.getClaimData(parameters.get(0).get(0));
        newParameters.add(headerDetails);
        for (int row = 1; row < iSize + 1; row++) {
            List<String> recordDetails = fileOperationsObj.getClaimData(parameters.get(row).get(0));
            for (int column = 1; column < parameters.get(0).size(); column++) {
                dataHeader = parameters.get(0).get(column);
                dataRecord = parameters.get(row).get(column);
                int indexc = headerDetails.indexOf(dataHeader);
                recordDetails.set(indexc, recordDetails.get(indexc).replace(recordDetails.get(indexc), dataRecord));
            }
            newParameters.add(recordDetails);
        }
        return newParameters;
    }



    //TODO-Sruthi Start
    public List<List<String>> parameterMappingNew(Integer iSize, List<List<String>> parameters, String fileName) {
        List<List<String>> newParameters = new ArrayList<>();
        String dataRecord = "";
        String dataHeader = "";
        //TODO Sruthi - to be removed
        //fileName = LoadTTPropertiesFiles.CLAIMDETAILS_PROP;
        Properties prop = null;
        if(null!=fileName){

            if(LoadTTPropertiesFiles.TTCOMMON_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.TTCOMMONPROPLIST;
            }else if(LoadTTPropertiesFiles.CLAIMDETAILS_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.CLAIMDETAILSPROPLIST;
            }else  if(LoadTTPropertiesFiles.CREDENTIALS_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.CREDENTIALSPROPLIST;
            }else if(LoadTTPropertiesFiles.DIGITALCUSTOMERSETUP_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.DIGITALCUSTOMERSETUPPROPLIST;
            }else if(LoadTTPropertiesFiles.DIGITALFAQ_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.DIGITALFAQPROPLIST;
            }else if(LoadTTPropertiesFiles.DIGITALQUOTE_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.DIGITALQUOTEPROPLIST;
            }else if(LoadTTPropertiesFiles.DOWNLOADSLINK_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.DOWNLOADSLINKPROPLIST;
            }else if(LoadTTPropertiesFiles.HAZARDOUSCOVERACTIVITIES_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.HAZARDOUSCOVERACTIVITIESPROPLIST;
            }else if(LoadTTPropertiesFiles.INBOUDFILEPATHFORINTEGRATION_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.INBOUDFILEPATHFORINTEGRATIONPROPLIST;
            }else if(LoadTTPropertiesFiles.LOGINPROFILES_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.LOGINPROFILESPROPLIST;
            }else if(LoadTTPropertiesFiles.PERILQUESTIONS_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.PERILQUESTIONSPROPLIST;
            }else if(LoadTTPropertiesFiles.POLICYDETAILS_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.POLICYDETAILSPROPLIST;
            }else if(LoadTTPropertiesFiles.QUOTEANDBUY_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.QUOTEANDBUYPROPLIST;
            }else if(LoadTTPropertiesFiles.APPLICATIONURL_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.APPLICATIONURLPROPLIST;
            }else if(LoadTTPropertiesFiles.CONTRIBUTIONCLAIMD_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.CONTRIBUTIONCLAIMPROPLIST;
            }else if(LoadTTPropertiesFiles.DIGITALCLAIMDETAIL_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.DIGITALCLAIMDETAILPROPLIST;
            }else if(LoadTTPropertiesFiles.CUSTOEMRCREATIONAPI.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.CUSTOMERCREATIONAPIPROPLIST;
            }


        }else{
            System.out.println("Properites File Name missing. Please provide the details");
        }
        // Send Header Details to property file
        List<String> headerDetails = fileOperationsObj.getPropValue(parameters.get(0).get(0),true,prop);
        System.out.println("headerDetails:: "+headerDetails);
        newParameters.add(headerDetails);
        System.out.println("newParameters 1:: "+newParameters);
        // Send value details
        for (int row = 1; row < parameters.size(); row++) {
            // List<String> recordDetails = fileOperationsObj.getClaimData(parameters.get(row).get(0));
            System.out.println("parameters.get(row).get(0): "+parameters.get(row).get(0));
            String strPropValuesKey = parameters.get(row).get(0);
            if(strPropValuesKey.equalsIgnoreCase("BasicPolicy")){
                strPropValuesKey = strPropValuesKey+System.getProperty("brand");
            }
            //List<String> recordDetails = fileOperationsObj.getPropValue(parameters.get(row).get(0),false,prop);
            List<String> recordDetails = fileOperationsObj.getPropValue(strPropValuesKey,false,prop);
            System.out.println("parameters.get(row).get(0)- recordDetails: "+recordDetails);
            for (int column = 1; column < parameters.get(0).size(); column++) {
                dataHeader = parameters.get(0).get(column);
                System.out.println("dataHeader Before"+ dataHeader);
                System.out.println("dataRecord Before"+ parameters.get(row).get(column));
                dataRecord = fileOperationsObj.getPropValue(parameters.get(row).get(column),false,prop).get(0);
                int indexc = headerDetails.indexOf(dataHeader);
                System.out.println("Before :: "+ "row :: "+row+" " +recordDetails);
                //override the generic value with specific value
                recordDetails.set(indexc, recordDetails.get(indexc).replace(recordDetails.get(indexc), dataRecord));
                System.out.println("After :: "+ "row :: "+row+" " + recordDetails);
            }
            newParameters.add(recordDetails);
        }
        System.out.println("newParameters return:: "+newParameters);
        return newParameters;
    }

    //TODO-Sruthi End

    public List<List<String>> parameterMappingPolicy(List<List<String>> parameters) {
        List<List<String>> newParameters = new ArrayList<>();
        String dataRecord = "";
        String dataHeader = "";
        List<String> headerDetails = fileOperationsObj.getPolicyData(parameters.get(0).get(0));
        newParameters.add(headerDetails);
        for (int row = 1; row < parameters.size(); row++) {
            List<String> recordDetails = fileOperationsObj.getPolicyData(parameters.get(row).get(0));
            for (int column = 1; column < parameters.get(0).size(); column++) {
                dataHeader = parameters.get(0).get(column);
                dataRecord = parameters.get(row).get(column);
                int indexc = headerDetails.indexOf(dataHeader);
                recordDetails.set(indexc, recordDetails.get(indexc).replace(recordDetails.get(indexc), dataRecord));
            }
            newParameters.add(recordDetails);
        }
        return newParameters;
    }

    public List<List<String>> parameterMappingContributionClaim(Integer iSize,List<List<String>> parameters) {
        List<List<String>> newParameters = new ArrayList<>();
        String dataRecord = "";
        String dataHeader = "";
        List<String> headerDetails = fileOperationsObj.getContributionClaimData(parameters.get(0).get(0));
        newParameters.add(headerDetails);
        for (int row = 1; row < parameters.size(); row++) {
            List<String> recordDetails = fileOperationsObj.getContributionClaimData(parameters.get(row).get(0));
            for (int column = 1; column < parameters.get(0).size(); column++) {
                dataHeader = parameters.get(0).get(column);
                dataRecord = parameters.get(row).get(column);
                int indexc = headerDetails.indexOf(dataHeader);
                recordDetails.set(indexc, recordDetails.get(indexc).replace(recordDetails.get(indexc), dataRecord));
            }
            newParameters.add(recordDetails);
        }
        return newParameters;
    }


    public List<List<String>> parameterMappingDigitalPolicy(List<List<String>> parameters) {
        List<List<String>> newParameters = new ArrayList<>();
        String dataRecord = "";
        String dataHeader = "";
        List<String> headerDetails = fileOperationsObj.getDigitalPolicyData(parameters.get(0).get(0));
        newParameters.add(headerDetails);
        for (int row = 1; row < parameters.size(); row++) {
            List<String> recordDetails = fileOperationsObj.getDigitalPolicyData(parameters.get(row).get(0));
            for (int column = 1; column < parameters.get(0).size(); column++) {
                dataHeader = parameters.get(0).get(column);
                dataRecord = parameters.get(row).get(column);
                int indexc = headerDetails.indexOf(dataHeader);
                recordDetails.set(indexc, recordDetails.get(indexc).replace(recordDetails.get(indexc), dataRecord));
            }
            newParameters.add(recordDetails);
        }
        return newParameters;
    }

    public List<List<String>> parameterMappingQuote(List<List<String>> parameters, String strQuoteType) {
        List<List<String>> newParameters = new ArrayList<>();
        String dataRecord = "";
        String dataHeader = "";
        //TODO Sruthi - Start
        Properties prop = LoadTTPropertiesFiles.QUOTEANDBUYPROPLIST;
        //List<String> headerDetails = fileOperationsObj.getQuoteData(parameters.get(0).get(0));
        // consider oas not header , as we need to read the header value from properties file
        List<String> headerDetails = fileOperationsObj.getPropValue(parameters.get(0).get(0),false,prop);
        System.out.println("headerDetails::"+headerDetails);
        newParameters.add(headerDetails);
        //List<String> recordDetails = fileOperationsObj.getQuoteData(strQuoteType);
        List<String> recordDetails = fileOperationsObj.getPropValue(strQuoteType,false,prop);
        System.out.println("recordDetails::"+recordDetails  );
        //TODO Sruthi - End
        for (int row = 1; row < parameters.size(); row++) {
            dataHeader = parameters.get(row).get(0);
            //TODO Sruthi - Start
            //dataRecord = parameters.get(row).get(1);
            dataRecord = fileOperationsObj.getPropValue(parameters.get(row).get(1),false,prop).get(0);
            //TODO Sruthi - End
            if (!dataHeader.equalsIgnoreCase("default") && !dataRecord.equalsIgnoreCase("default")) {
                System.out.println("dataHeader:: "+dataHeader);
                System.out.println("dataRecord:: "+dataRecord);
                int indexc = headerDetails.indexOf(dataHeader);
                recordDetails.set(indexc, recordDetails.get(indexc).replace(recordDetails.get(indexc), dataRecord));
                newParameters.add(recordDetails);
            } else
                newParameters.add(recordDetails);
        }
        System.out.println("Returning from parameterMappingQuote");
        return newParameters;
    }

    public List<List<String>> parameterMappingDigitalQuote(List<List<String>> parameters, String strQuoteType) {
        List<List<String>> newParameters = new ArrayList<>();
        String dataRecord = "";
        String dataHeader = "";
        //TODO Sruthi - Start
        Properties prop = LoadTTPropertiesFiles.DIGITALQUOTEPROPLIST;
       // List<String> headerDetails = fileOperationsObj.getDigitalQuoteData(parameters.get(0).get(0));
        List<String> headerDetails = fileOperationsObj.getPropValue(parameters.get(0).get(0),true,prop);
        newParameters.add(headerDetails);
       // List<String> recordDetails = fileOperationsObj.getDigitalQuoteData(strQuoteType);
        List<String> recordDetails = fileOperationsObj.getPropValue(strQuoteType,false,prop);
        //TODO Sruthi - End
        for (int row = 1; row < parameters.size(); row++) {
            dataHeader = parameters.get(row).get(0);
            //TODO Sruthi - Start
            //dataRecord = parameters.get(row).get(1);
            dataRecord = fileOperationsObj.getPropValue(parameters.get(row).get(1),false,prop).get(0);
            //TODO Sruthi - End
            if (!dataHeader.equalsIgnoreCase("default") && !dataRecord.equalsIgnoreCase("default")) {
                int indexc = headerDetails.indexOf(dataHeader);
                recordDetails.set(indexc, recordDetails.get(indexc).replace(recordDetails.get(indexc), dataRecord));
                newParameters.add(recordDetails);
            } else
                newParameters.add(recordDetails);
        }
        return newParameters;
    }

    public List<List<String>> parameterMappingDigitalClaim(List<List<String>> parameters) {

        List<List<String>> newParameters = new ArrayList<>();
        String dataRecord = "";
        String dataHeader = "";
        List<String> headerDetails = fileOperationsObj.getDigitalClaimData(parameters.get(0).get(0));
        newParameters.add(headerDetails);
        for (int row = 1; row < parameters.size(); row++) {
            List<String> recordDetails = fileOperationsObj.getDigitalClaimData(parameters.get(row).get(0));
            for (int column = 1; column < parameters.get(0).size(); column++) {
                dataHeader = parameters.get(0).get(column);
                dataRecord = parameters.get(row).get(column);
                int indexc = headerDetails.indexOf(dataHeader);
                recordDetails.set(indexc, recordDetails.get(indexc).replace(recordDetails.get(indexc), dataRecord));
            }
            newParameters.add(recordDetails);
        }
        return newParameters;

     }

    public void waitForObject(WebElement wbEle) {
        int iCount = 0;
        do {
            iCount++;
            if (wbEle.isDisplayed()) {
                break;
            }
        } while (iCount < 100);
    }

    public boolean elementDisplayedWithLessTime(By by) {
        try {
            getDriver.executeScript("window.onbeforeunload = function(e){};", new Object[0]);
            WebDriverWait e = new WebDriverWait(getDriver, 1);
            e.until(ExpectedConditions.presenceOfElementLocated(by));
            nextEventPageObj.findElement(by);
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public boolean elementDisplayed(By by) {
        try {
            getDriver.executeScript("window.onbeforeunload = function(e){};", new Object[0]);
            WebDriverWait e = new WebDriverWait(getDriver, 10);
            e.until(ExpectedConditions.presenceOfElementLocated(by));
            nextEventPageObj.findElement(by);
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    public boolean elementDisplayedInSec(By by, Long timeOutInSec) {
        try {
            getDriver.executeScript("window.onbeforeunload = function(e){};", new Object[0]);
            WebDriverWait e = new WebDriverWait(getDriver, timeOutInSec);
            e.until(ExpectedConditions.presenceOfElementLocated(by));
            nextEventPageObj.findElement(by);
            return true;
        } catch (Exception var3) {
            return false;
        }
    }
    public void closeTab() {
        Set handles = getDriver.getWindowHandles();
        if(handles.size() > 2) {
            String handle = handles.toArray()[handles.size()-1].toString();
            getDriver.switchTo().window(handle);
            getDriver.close();
            //getDriver.switchTo().window(handle);
            nextEventPageObj.switchToLastOpenWindow();
        }

    }

    public void closeNextWindow() {
        Set handles = getDriver.getWindowHandles();
        if(handles.size() > 1) {
            String handle = handles.toArray()[handles.size()-1].toString();
            getDriver.switchTo().window(handle);
            getDriver.close();
            //getDriver.switchTo().window(handle);
            nextEventPageObj.switchToLastOpenWindow();
        }

    }


    public void switchToDesiredWindow(By we) {
        Set handles = getDriver.getWindowHandles();
        if (handles.size() > 0) {
            for (int i = 0; i < handles.size(); i++) {
                String handle = handles.toArray()[i].toString();
                getDriver.switchTo().window(handle);
                if (elementDisplayedWithLessTime(we)) {
                    System.out.println("elementDisplayedWithLessTime(we)----------" + elementDisplayedWithLessTime(we));
                    break;
                }
            }

        }
    }


    //TODO-Sruthi Start
    public List<List<String>> singleParameterMappingProp(List<List<String>> parameters, String fileName) {
        List<List<String>> newParameters = new ArrayList<>();
        String dataRecord = "";
        String dataHeader = "";
        Properties prop = null;
        if(null!=fileName){

            if(LoadTTPropertiesFiles.TTCOMMON_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.TTCOMMONPROPLIST;
            }else if(LoadTTPropertiesFiles.CLAIMDETAILS_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.CLAIMDETAILSPROPLIST;
            }else  if(LoadTTPropertiesFiles.CREDENTIALS_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.CREDENTIALSPROPLIST;
            }else if(LoadTTPropertiesFiles.DIGITALCUSTOMERSETUP_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.DIGITALCUSTOMERSETUPPROPLIST;
            }else if(LoadTTPropertiesFiles.DIGITALFAQ_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.DIGITALFAQPROPLIST;
            }else if(LoadTTPropertiesFiles.DIGITALQUOTE_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.DIGITALQUOTEPROPLIST;
            }else if(LoadTTPropertiesFiles.DOWNLOADSLINK_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.DOWNLOADSLINKPROPLIST;
            }else if(LoadTTPropertiesFiles.HAZARDOUSCOVERACTIVITIES_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.HAZARDOUSCOVERACTIVITIESPROPLIST;
            }else if(LoadTTPropertiesFiles.INBOUDFILEPATHFORINTEGRATION_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.INBOUDFILEPATHFORINTEGRATIONPROPLIST;
            }else if(LoadTTPropertiesFiles.LOGINPROFILES_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.LOGINPROFILESPROPLIST;
            }else if(LoadTTPropertiesFiles.PERILQUESTIONS_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.PERILQUESTIONSPROPLIST;
            }else if(LoadTTPropertiesFiles.POLICYDETAILS_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.POLICYDETAILSPROPLIST;
            }else if(LoadTTPropertiesFiles.QUOTEANDBUY_PROP.equalsIgnoreCase(fileName)){
                prop = LoadTTPropertiesFiles.QUOTEANDBUYPROPLIST;
            }

        }else{
            System.out.println("Properites File Name missing. Please provide the details");
        }
        List<String> headerDetails = new ArrayList<String>();
        for (int column = 0; column < parameters.get(0).size(); column++) {
           // headerDetails.set(column, parameters.get(0).get(column));
            headerDetails.add(parameters.get(0).get(column));

        }
        newParameters.add(headerDetails);
        for (int row = 1; row < parameters.size(); row++) {

            List<String> recordDetails = new ArrayList<String>();

            for (int column = 0; column < parameters.get(0).size(); column++) {
                dataHeader = parameters.get(0).get(column);
                dataRecord = fileOperationsObj.getPropValue(parameters.get(row).get(column), false, prop).get(0);
                //recordDetails.set(column, dataRecord);
                recordDetails.add(dataRecord);
            }
            newParameters.add(recordDetails);
        }
        System.out.println("newParameters:: "+newParameters);
        return newParameters;
    }

    //TODO-Sruthi End

    public WebElement waitForElementEnabled(By by) {
        getDriver.executeScript("window.onbeforeunload = function(e){};", new Object[0]);
        WebDriverWait wait = new WebDriverWait(getDriver, 15L);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        return this.waitForElementVisible(by);
    }

    public WebElement waitForElementVisible(By by) {
        getDriver.executeScript("window.onbeforeunload = function(e){};", new Object[0]);
        WebDriverWait wait = new WebDriverWait(getDriver, 15L);
        return (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30L);
        wait.until(pageLoadCondition);
    }

    public boolean loadingPageInSeconds(Long timeoutInSec) {
        return waitForElementInVisibleInSec(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_ucMatterList_imgProgressMatterList"),timeoutInSec );
    }

    public boolean LoadingSearchResultsInSeconds(Long timeoutInSec) {
        return waitForElementInVisibleInSec(By.id("ctl00_cphBodyWithoutUpdatePanel_cphBody_leadSearch1_ctl04_imgProgressSearchCriteria"),timeoutInSec );
    }


    public Boolean waitForElementInVisibleInSec(By by, Long timeoutInSec ) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver, timeoutInSec);
        return (Boolean)wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public String parameterMappingCustomerCreationAPI(String parameters) {
        String headerDetails = fileOperationsObj.getCustomerCreationAPI(parameters);
        /*newParameters.add(headerDetails);
        for (int row = 1; row < parameters.size(); row++) {
            List<String> recordDetails = fileOperationsObj.getDigitalClaimData(parameters.get(row).get(0));
            for (int column = 1; column < parameters.get(0).size(); column++) {
                dataHeader = parameters.get(0).get(column);
                dataRecord = parameters.get(row).get(column);
                int indexc = headerDetails.indexOf(dataHeader);
                recordDetails.set(indexc, recordDetails.get(indexc).replace(recordDetails.get(indexc), dataRecord));
            }
            newParameters.add(recordDetails);
        }*/
        return headerDetails;

    }

    public List<List<String>> perilQuestionMapping(List<List<String>> parameters, int perilRow) {
        List<List<String>> perilQuestions = new ArrayList<>();
        String dataRecord = (parameters.get(perilRow).get(0)) + "Ques";
        System.out.println(dataRecord);
        List<String> headerDetails = fileOperationsObj.getPerilQuestions(dataRecord);
        perilQuestions.add(headerDetails);
        List<String> recordDetails = fileOperationsObj.getPerilQuestions(parameters.get(perilRow).get(0));
        perilQuestions.add(recordDetails);
        return perilQuestions;
    }

    public String readingFinancialTableValues(String scenarioName) {
        Properties prop = new Properties();
        InputStream input = null;
        String financialTableContent ="";
        try {
            input = new FileInputStream("src/test/resources/FinancialTableValues.properties");
            prop.load(input);
            financialTableContent = prop.getProperty(scenarioName);
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
        return financialTableContent;
    }

    public void writingScenarioDetails(String name, String randomCustomerFullName, String randomEmailID, String policyId, String claimID) {
        PrintWriter out = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
            fw = new FileWriter("src/test/resources/ExecutionData.txt", true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(name+"#"+randomCustomerFullName+"#"+randomEmailID+"#"+policyId+"#"+claimID);
        }
        catch( IOException e ){
            // File writing/opening failed at some stage.
        }
        finally{
            try{
                if( out != null ){
                    out.close(); // Will close bw and fw too
                }
                else if( bw != null ){
                    bw.close(); // Will close fw too
                }
                else if( fw != null ){
                    fw.close();
                }
                else{
                    // Oh boy did it fail hard! :3
                }
            }
            catch( IOException e ){
                // Closing the file writers failed for some obscure reason
            }
        }
    }
}