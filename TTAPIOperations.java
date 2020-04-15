package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.AccountInformationPage;
import co.uk.directlinegroup.tt.pages.ClaimSummaryPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.pages.SearchPage;
import co.uk.directlinegroup.tt.utils.common.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class TTAPIOperations {


    public FileOperations fileOperationsObj = new FileOperations();
    private HashMapForAllFlows hashMapForAllFlowsObj = new HashMapForAllFlows();
    private TTConstants ttConstantsObj = new TTConstants();
    private FileOperations fileOperationsOObj = new FileOperations();
    private Commands commandsObj = new Commands();
    private User userObj = new User();
    private DigitalOperations digitalOperationsObj = new DigitalOperations();
    private PerformSearch performSearchObj = new PerformSearch();
    private TTAPIMappingValueRequestOperations ttapiMappingValueRequestOperationsObj = new TTAPIMappingValueRequestOperations();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private SearchPage searchPageObj = new SearchPage();
    private ClaimsOperations claimsOperationsObj = new ClaimsOperations();
    private AccountInformationPage accountInformationPageObj = new AccountInformationPage();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private QuoteDetails_Aquarium quoteDetails_aquariumObj = new QuoteDetails_Aquarium();


    public static String authenticationCode = "";
    public static String loginKeyValue = "";
    public static String leadId = "";
    public static String loginUserName = "";
    public static String loginPwd = "";
    public boolean jsonMatchFlag = false;
    String retrievedProperty = "";
    public static String customerId = "";
    public static String claimId = "";
    public static String requestMappedWithFeaturefileForClaim = "";
    public static String progressClaimReferenceId = "";
    public static String namedPersonId = "";
    public static String envTOAppendInTargetURL = "";

    //Target URL
    public static String TARGETURL_LOGIN = "https://dlg-ENV.aquarium-software.com/QuoteBuy/CR21/GetAuthToken";
    public static String TARGETURL_CREATECUSTOMER = "https://dlg-ENV.aquarium-software.com/quotebuy/CR21/CreateCustomer";
    public static String TARGETURL_CLAIMCONFIG = "https://dlg-ENV.aquarium-software.com/QuoteBuy/CR21/GetClaimConfig";
    public static String TARGETURL_CLAIMCREATION = "https://dlg-ENV.aquarium-software.com/QuoteBuy/CR21/CreateClaim";
    public static String TARGETURL_NAMEDPERSON = "https://dlg-ENV.aquarium-software.com/QuoteBuy/CR21/GetNamedPeople?policyLeadID=";
    public static String TARGETURL_PROGRESSCLAIM = "https://dlg-ENV.aquarium-software.com/quotebuy/cr21/ProgressClaim";
    public static String TARGETURL_PROGRESSCLAIMFINALSAVE = "https://dlg-ENV.aquarium-software.com/QuoteBuy/CR21/FinalSave";
    public static String TARGETURL_PREPAREQUOTE = "https://dlg-ENV.aquarium-software.com/QuoteBuy/CR21/PrepareQuote?brandID=";
    public static String TARGETURL_BUYQUOTE = "https://dlg-ENV.aquarium-software.com/QuoteBuy/CR21/BuyQuoteDD";


    public static HashMap<String, JSONObject> countryMap = new HashMap();
    public static HashMap<String, JSONObject> perilcauseSubCauseMap = new HashMap();
    public static HashMap<String, JSONObject> currenciesMap = new HashMap();
    public static HashMap<String, JSONObject> perilclaimDetailMap = new HashMap();
    public static HashMap<String, JSONObject> perilQuestionsMap = new HashMap();
    public static String arrayName = "";


    public void dataMapping(String strRequest, List<List<String>> lstInput) {

        switch (strRequest) {
            case ("CreateCustomer"):
                // call basic request json from property file
                // call method to replace the input in basic json(strInputjson,strInput)

                //r
                break;
        }
    }

    public String retrevingRequestFromTemplate(Properties props, List<List<String>> newParameters, List<List<String>> parameters) {
        String inputData = "";
        String requestValueMapping = "";
        String requesttmpl = "";
        String baseProperty = props.getProperty(parameters.get(1).get(0));
        System.out.println("------------------Base------------------" + baseProperty);
        StringBuilder mergingDifferentModule = new StringBuilder();
        for (int i = 0; i < baseProperty.split("#").length; i++) {
            String inputDataToGetFrom = baseProperty.split("#")[i];
            inputData = props.getProperty(baseProperty.split("#")[i]);
            //	inputData=props.getProperty(inputDataToGetFrom);
            requesttmpl = fileOperationsObj.readFile(inputData);
            System.out.println("base pro------------------" + baseProperty);
            System.out.println("input pro------------------" + requesttmpl);
            if (inputDataToGetFrom.equalsIgnoreCase("create") || inputDataToGetFrom.equalsIgnoreCase("peril") || inputDataToGetFrom.equalsIgnoreCase("item") || inputDataToGetFrom.equalsIgnoreCase("answers")) {
                if (inputDataToGetFrom.equalsIgnoreCase("create")) {
                    mergingDifferentModule.append(requesttmpl);
                } else {
                    requestValueMapping = structureFormationForComplexRequest(requesttmpl, newParameters);
                    mergingDifferentModule.append(requestValueMapping);
                }
                System.out.println("Paril mapping-------------------" + requestValueMapping);
            } else {
                mergingDifferentModule.append(requesttmpl);
            }
            System.out.println("Paril mapping-------mergingDifferentModule------------" + mergingDifferentModule);
        }
        System.out.println("mergingDifferentModule.substring(mergingDifferentModule.length())-----------------------" + mergingDifferentModule.substring(mergingDifferentModule.length() - 1));
        if (mergingDifferentModule.substring(mergingDifferentModule.length() - 1).equals(",")) {
            System.out.println("-----------------------------Testing------------------------------");
            mergingDifferentModule.insert(0, "{");
            mergingDifferentModule.setLength(mergingDifferentModule.length() - 1);
            mergingDifferentModule.insert(mergingDifferentModule.length(), "}");
            System.out.println("-----------------------------Testing----------------" + mergingDifferentModule.toString());
        }
        return mergingDifferentModule.toString();
    }

    private static String structureFormationForComplexRequest(String inputData, List<List<String>> parameterMapping) {
        // TODO Auto-generated method stub
        String inputAfterRemovingBracket = inputData.substring(0, inputData.length() - 1);
        String anyId = ",".concat(inputAfterRemovingBracket.substring(inputAfterRemovingBracket.indexOf("{"), inputAfterRemovingBracket.indexOf("}") + 1));
        StringBuilder strBuilderForInputData = new StringBuilder(inputAfterRemovingBracket);
        System.out.println("String builder-----------------------" + strBuilderForInputData);
        System.out.println("String builder------Anyid-----------------" + anyId);
        for (int i = 1; i < parameterMapping.size() - 1; i++) {
            strBuilderForInputData.append(anyId);
            System.out.println("inside for loop-----------------" + strBuilderForInputData);
        }
        strBuilderForInputData.append("],");

        return strBuilderForInputData.toString();
    }

    public String mappingFeatureFileValueInRequest(LinkedHashMap<String, String> createClaimHashMap, List<List<String>> newPara, String requestInput) {
        for (int i = 1; i < newPara.size(); i++) {
            for (Map.Entry<String, String> entry : createClaimHashMap.entrySet()) {
                System.out.println("Key-------------" + entry.getKey() + "---Value--------------" + entry.getValue());
                for (int j = 0; j < newPara.get(0).size(); j++) {
                    if (entry.getValue().equals(newPara.get(0).get(j))) {
                        String processsedValue = changingUserSpecificValueToRequestAcceptValue(newPara.get(0).get(j), newPara.get(i).get(j), newPara.get(0).get(0));
                        if (newPara.get(0).get(j).equalsIgnoreCase("DateOfLoss") || newPara.get(0).get(j).equalsIgnoreCase("SubcauseCode")) {
                            requestInput = requestInput.replaceAll(entry.getKey(), processsedValue);
                        } else {
                            requestInput = requestInput.replaceFirst(entry.getKey(), processsedValue);
                        }
                    } else if (entry.getValue().equals("")) {
                        requestInput = requestInput.replaceFirst(entry.getKey(), "");
                    }
                }
                System.out.println("Key-------------" + entry.getKey() + "---Value--------------" + entry.getValue());
            }

            System.out.println("int----------------" + requestInput);
        }
        return requestInput;
    }

    public String changingUserSpecificValueToRequestAcceptValue(String key, String value, String operationType) {
        String returnvalue = value;
        if (operationType.equalsIgnoreCase("Brand")) {
            returnvalue = ttapiMappingValueRequestOperationsObj.policyValueReplacement(key, value);
        } else if (operationType.equalsIgnoreCase("BasicClaimType")) {
            returnvalue = ttapiMappingValueRequestOperationsObj.claimReplacement(key, value);
        } else {
            returnvalue = ttapiMappingValueRequestOperationsObj.progressClaimReplacement(key, value);
        }
        return returnvalue;
    }

    public String sendingRequest(String request, String targetURL) {
        String output = "";
        StringBuilder finalValue = new StringBuilder();
        try {
            //  String targetURL = "https://dlg-dev.aquarium-software.com/quotebuy/CR21/CreateCustomer";
            URL targetUrl = new URL(targetURL);
            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("POST");
            System.out.println("Authentication code-------------------------" + authenticationCode);
            if (!authenticationCode.equalsIgnoreCase(""))
                httpConnection.setRequestProperty("Cookie", "AqNET.Auth=" + authenticationCode);
            httpConnection.setRequestProperty("Content-Type", "application/json");
            System.out.println("Input:: " + request);
            OutputStream outputStream = httpConnection.getOutputStream();
            outputStream.write(request.getBytes());
            outputStream.flush();
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + httpConnection.getResponseCode());
            }
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                    (httpConnection.getInputStream())));

            System.out.println("Output from Server:\n");
            while ((output = (responseBuffer.readLine())) != null) {
                System.out.println(output);
                System.out.println("response inside While-----" + responseBuffer.toString());
                finalValue.append(output);
            }
            httpConnection.disconnect();
            System.out.println("outside while loopp---------------" + finalValue.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("output---------------------------------" + finalValue);
        return finalValue.toString();
    }

    public String parsingResponse(String response, String propertyToRetrieve) {
        String retrievedPropertyFromPRintJSONMethod = "";
        try {
            System.out.println("Response received ------------------------" + response);
            JSONParser parser = new JSONParser();
            org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(response);
            retrievedPropertyFromPRintJSONMethod = parsingJsonObjectForParticularProperty(json, propertyToRetrieve);
            jsonMatchFlag = false;
            retrievedProperty = "";
            System.out.println("Here comes the sort code -------" + retrievedPropertyFromPRintJSONMethod);
        } catch (Exception ex) {
            System.out.println("Inside Exception!!!.........");
            ex.printStackTrace();
        }
        return retrievedPropertyFromPRintJSONMethod;
    }


    public String parsingJsonObjectForParticularProperty(JSONObject jsonObj, String propertyToRetrieve) {
        int i = 0;

        for (Object key : jsonObj.keySet()) {
            if (!jsonMatchFlag) {
                i++;
                String keyStr = (String) key;
                Object keyvalue = jsonObj.get(keyStr);
                System.out.println("iteration::" + i + "key: " + keyStr + " value: " + keyvalue);
                if (keyStr.equalsIgnoreCase(propertyToRetrieve)) {
                    retrievedProperty = keyvalue.toString();
                    System.out.println("retrievedProperty-----------------------" + retrievedProperty + "i" + i);
                    jsonMatchFlag = true;
                    break;
                }
                if (keyvalue instanceof JSONObject && !jsonMatchFlag) {
                    parsingJsonObjectForParticularProperty((JSONObject) keyvalue, propertyToRetrieve);
                }
            }

        }
        System.out.println("retrievedProperty-----------------------" + retrievedProperty);
        return retrievedProperty;
    }

    public void createCustomerUsingAPI(String customer, List<List<String>> parameters) {
        List<List<String>> newParameters = commandsObj.parameterMappingNew(1, parameters, LoadTTPropertiesFiles.DIGITALCUSTOMERSETUP_PROP);
        String response = "";
        Properties props = fileOperationsOObj.readBasicPropertyFile();
        String proValue = props.getProperty(parameters.get(1).get(0));
        System.out.println("Prop Valu-----------------" + proValue);
        String requestFromTemplateFile = retrevingRequestFromTemplate(props, newParameters, parameters);
        System.out.println("---------------Requesttemplate---------------" + requestFromTemplateFile);
        System.out.println(requestFromTemplateFile);
        String requestMappedWithFeaturefile = mappingFeatureFileValueInRequest(hashMapForAllFlowsObj.createPolicyHashMap(), newParameters, requestFromTemplateFile);
        System.out.println("requestMappedWithFeaturefile-----------------------\n");
        System.out.println(requestMappedWithFeaturefile);
        System.out.println("Target url-------------------"+TARGETURL_CREATECUSTOMER);
        response = sendingRequest(requestMappedWithFeaturefile, TARGETURL_CREATECUSTOMER);
        System.out.println("Response------------------------------\n");
        System.out.println(response);
        leadId = parsingResponse(response, "policyAdminLeadID");
        customerId = parsingResponse(response, "customerID");
        System.out.println("Matter id ------------------------" + leadId);
        System.out.println("customerId ------------------------" + customerId);
    }

    public void loginAPI(String loginDetails) {
        String strEnvProfile = System.getProperty("ENV");
        System.out.println(strEnvProfile);
        if(strEnvProfile.contains("QA")){
            this.envTOAppendInTargetURL = "qa";
        }else if(strEnvProfile.contains("SIT")){
            this.envTOAppendInTargetURL =  "integration";
        }else if(strEnvProfile.contains("Dev")){
            this.envTOAppendInTargetURL =  "dev";
        }
        this.updatingENVInTargetURL(envTOAppendInTargetURL);
        loginKeyValue = loginDetails;
        List<String> userDet = userObj.getUserDetails(loginDetails);
        String response = "";
        loginUserName = userDet.get(1);
        loginPwd = userDet.get(2);
        System.out.println("loginUserName---------------" + loginUserName);
        System.out.println("loginPwd---------------" + loginPwd);
        Properties props = fileOperationsObj.readBasicPropertyFile();
        String proValue = props.getProperty("Login");
        System.out.println("Prop Valu-----------------" + proValue);
        String request = fileOperationsObj.readFile(props.getProperty(proValue));
        System.out.println("Request------------------------" + request);
        request = request.replaceAll("##username##", loginUserName);
        request = request.replaceAll("##password##", loginPwd);
        System.out.println("request after mapping data ----------------" +  TARGETURL_LOGIN);
        response = sendingRequest(request, TARGETURL_LOGIN);
        authenticationCode = parsingResponse(response, "aqAuthToken");
        System.out.println("Authentication code--------------------" + authenticationCode);

    }

    private void updatingENVInTargetURL(String envTOAppendInTargetURL) {
        TARGETURL_LOGIN = TARGETURL_LOGIN.replace("ENV",this.envTOAppendInTargetURL);
        System.out.println(TARGETURL_LOGIN);
        TARGETURL_CREATECUSTOMER=TARGETURL_CREATECUSTOMER.replace("ENV",this.envTOAppendInTargetURL);
        TARGETURL_CLAIMCONFIG=TARGETURL_CLAIMCONFIG.replace("ENV",this.envTOAppendInTargetURL);
        TARGETURL_CLAIMCREATION=TARGETURL_CLAIMCREATION.replace("ENV",this.envTOAppendInTargetURL);
        TARGETURL_NAMEDPERSON=TARGETURL_NAMEDPERSON.replace("ENV",this.envTOAppendInTargetURL);
        TARGETURL_PROGRESSCLAIM=TARGETURL_PROGRESSCLAIM.replace("ENV",this.envTOAppendInTargetURL);
        TARGETURL_PROGRESSCLAIMFINALSAVE=TARGETURL_PROGRESSCLAIMFINALSAVE.replace("ENV",this.envTOAppendInTargetURL);
        TARGETURL_PREPAREQUOTE=TARGETURL_PREPAREQUOTE.replace("ENV",this.envTOAppendInTargetURL);
        TARGETURL_BUYQUOTE=TARGETURL_BUYQUOTE.replace("ENV",this.envTOAppendInTargetURL);
    }

    public void retrieveCreatedClaim() {
        digitalOperationsObj.loginAQ(loginKeyValue);
        System.out.println("Calim id--------------------" + this.claimId);
        performSearchObj.retrievingTheMatterId("Matter ID", this.claimId);
        searchPageObj.firstRecordInSearch().click();
        nextEventPageObj.switchToLastOpenWindow();
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");

    }

    public void retrieveCreatedPolicy() {
        digitalOperationsObj.loginAQ(loginKeyValue);
        System.out.println("Calim id--------------------" + this.customerId);
        performSearchObj.retrievingTheMatterId("Customer ID", this.customerId);
        searchPageObj.firstRecordInSearch().click();
        nextEventPageObj.switchToLastOpenWindow();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void backDatingThePolicy() {
        //Backdating the policy
        claimsOperationsObj.clickingUnderNextEventsAndButtons("out of process event");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToDefault();
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimsOperationsObj.navigateToEventType("__TestRenewals");
        quoteDetails_aquariumObj.expireQuoteWithSpecificDays("x days prior to renewal");
        nextEventPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    //Get method
    public String sendingRequestWithGetMethod(String targetURL) {
        String output = "";
        StringBuilder finalValue = new StringBuilder();
        System.out.println("Target URL---------------------------" + targetURL);
        try {
            URL targetUrl = new URL(targetURL);
            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("GET");
            System.out.println("Authentication code-------------------------" + authenticationCode);
            if (!authenticationCode.equalsIgnoreCase(""))
                httpConnection.setRequestProperty("Cookie", "AqNET.Auth=" + authenticationCode);
            httpConnection.setRequestProperty("Content-Type", "application/json");
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + httpConnection.getResponseCode());
            }
            BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                    (httpConnection.getInputStream())));

            System.out.println("Output from Server:\n");
            while ((output = (responseBuffer.readLine())) != null) {
                System.out.println(output);
                System.out.println("response inside While-----" + responseBuffer.toString());
                finalValue.append(output);
            }
            httpConnection.disconnect();
            System.out.println("outside while loopp---------------" + finalValue.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("output---------------------------------" + finalValue);
        return finalValue.toString();
    }

    public void gettingClaimConfig(List<List<String>> claimValue) {
        String res = sendingRequestWithGetMethod(TARGETURL_CLAIMCONFIG);
        List<List<String>> newParameters = commandsObj.parameterMappingNew(1, claimValue, LoadTTPropertiesFiles.CLAIMDETAILS_PROP);
        JSONParser parser = new JSONParser();
        JSONObject json = null;
        try {
            json = (JSONObject) parser.parse(res);
            readClaimConfig(json);
            JSONObject json3 = (JSONObject) countryMap.get("France");
            Long countyId = (Long) json3.get("countryID");


            JSONObject json4 = (JSONObject) perilcauseSubCauseMap.get("Abandoned International Departure#No Reason Given");
            Long perilID = (Long) json4.get("perilID");


            JSONObject json5 = (JSONObject) currenciesMap.get("Brazil Reais");
            String currencyCode = (String) json5.get("currencyCode");


            Iterator itr = perilclaimDetailMap.entrySet().iterator();
            while (itr.hasNext()) {
                Map.Entry pair = (Map.Entry) itr.next();

            }

            JSONObject json6 = (JSONObject) perilclaimDetailMap.get("48447#Single Item (Clothing, Toiletries, Bags etc.)#General baggage");
            Long claimDetailID = (Long) json6.get("claimDetailID");


//            JSONObject json7 = (JSONObject) perilQuestionsMap.get("48378#Which of the following is the affected person?");
//            Long tableRowID = (Long) json7.get("tableRowID");

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parsingResponseForArrayValue(String responseList) {
        try {
            // System.out.println("Response received ------------------------" + responseList);
            JSONParser parser = new JSONParser();
            org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(responseList);
            JSONArray jsonArry = (JSONArray) json.get("id");
            Iterator<String> iterator = jsonArry.iterator();
            while (iterator.hasNext()) {
                System.out.println("JSon iterator:: countryName-----------------" + iterator.next());
            }
        } catch (Exception ex) {
            System.out.println("Inside Exception!!!.........");
            ex.printStackTrace();
        }
    }

    public static void readClaimConfig(JSONObject jsonObj) {

        for (Object key : ((Map<String, JSONObject>) jsonObj).keySet()) {
            // based on you key types
            String keyStr = (String) key;
            Object keyvalue = jsonObj.get(keyStr);

            // for nested objects iteration if required
            if (keyvalue instanceof JSONObject) {
                printJsonObject((JSONObject) keyvalue);
            } else if (keyvalue instanceof JSONArray) {
                arrayName = keyStr;
                if (arrayName.equals("countries")) {
                    JSONArray jsonArray = (JSONArray) keyvalue;
                    Iterator itr = jsonArray.iterator();
                    int i = 0;
                    while (itr.hasNext()) {
                        i++;
                        JSONObject jsonObj2 = (JSONObject) itr.next();
                        String countryKey = (String) jsonObj2.get("countryName");
                        countryMap.put(countryKey, jsonObj2);

                    }
                } else if (arrayName.equals("perils")) {
                    JSONArray jsonArray = (JSONArray) keyvalue;
                    Iterator itr = jsonArray.iterator();
                    int i = 0;
                    while (itr.hasNext()) {
                        i++;
                        JSONObject jsonObj2 = (JSONObject) itr.next();
                        String cause = (String) jsonObj2.get("cause");
                        String subCause = (String) jsonObj2.get("subCause");
                        String causeSubcause = cause + "#" + subCause;
                        perilcauseSubCauseMap.put(causeSubcause, jsonObj2);
                    }
                } else if (arrayName.equals("currencies")) {
                    JSONArray jsonArray = (JSONArray) keyvalue;
                    Iterator itr = jsonArray.iterator();
                    int i = 0;
                    while (itr.hasNext()) {
                        i++;
                        JSONObject jsonObj2 = (JSONObject) itr.next();
                        String currencyName = (String) jsonObj2
                                .get("currencyName");
                        currenciesMap.put(currencyName, jsonObj2);
                    }
                } else if (arrayName.equals("claimTypes")) {
                    JSONArray jsonArray = (JSONArray) keyvalue;
                    Iterator itr = jsonArray.iterator();
                    int i = 0;
                    while (itr.hasNext()) {
                        i++;
                        JSONObject jsonObj2 = (JSONObject) itr.next();
                        String perilID = ((Long) jsonObj2.get("perilID")).toString();
                        String claimItem1 = (String) jsonObj2.get("claimDetail1");
                        String claimItem2 = (String) jsonObj2.get("claimDetail2");
                        String perilClaimKey = perilID + "#" + claimItem1 + "#" + claimItem2;
                        perilclaimDetailMap.put(perilClaimKey, jsonObj2);
                    }
                } else if (arrayName.equals("perilQuestions")) {
                    JSONArray jsonArray = (JSONArray) keyvalue;
                    Iterator itr = jsonArray.iterator();
                    int i = 0;
                    while (itr.hasNext()) {
                        i++;
                        JSONObject jsonObj2 = (JSONObject) itr.next();
                        String perilID = ((Long) jsonObj2.get("perilID"))
                                .toString();
                        String question = (String) jsonObj2
                                .get("question");
                        String perilQuestionKey = perilID + "#" + question;
                        perilQuestionsMap.put(perilQuestionKey, jsonObj2);
                    }
                }
            }
        }
    }

    public static void printJsonObject(JSONObject jsonObj) {

        for (Object key : jsonObj.keySet()) {
            // based on you key types
            String keyStr = (String) key;
            Object keyvalue = jsonObj.get(keyStr);
            if (arrayName.equals("countries")) {
                System.out.println("key: " + keyStr + " value: " + keyvalue);
            }
            // for nested objects iteration if required
            if (keyvalue instanceof JSONObject) {
                System.out.println("***** Inside Nested Object ****");
                printJsonObject((JSONObject) keyvalue);
            } else if (keyvalue instanceof JSONArray) {
                arrayName = keyStr;
                if (arrayName.equals("countries")) {
                    System.out
                            .println("***** Inside JSON Array **** ArrayName :: "
                                    + arrayName);
                    JSONArray jsonArray = (JSONArray) keyvalue;
                    Iterator itr = jsonArray.iterator();
                    int i = 0;
                    while (itr.hasNext()) {
                        i++;
                        System.out.println("********* Inside while ************: " + i);
                        JSONObject jsonObj2 = (JSONObject) itr.next();
                        System.out.println("jsonObj2" + jsonObj2 + " i " + i);
                        String countryKey = (String) jsonObj2.get("countryName");
                        countryMap.put(countryKey, jsonObj2);
                        System.out.println("++++++++++key2: " + keyStr + " value2: " + keyvalue + " i " + i);
                    }
                }
            }
        }
    }


    public void createClaimUsingAPI(List<List<String>> claimValueParameter) {
        List<List<String>> newParameters = commandsObj.parameterMappingNew(1, claimValueParameter, LoadTTPropertiesFiles.CLAIMDETAILS_PROP);
        String response = "";
        Properties props = fileOperationsOObj.readBasicPropertyFile();
        String proValue = props.getProperty(claimValueParameter.get(1).get(0));
        System.out.println("Prop Valu-----------------" + proValue);
        String requestFromTemplateFile = retrevingRequestFromTemplate(props, newParameters, claimValueParameter);
        System.out.println("---------------Requesttemplate---------------" + requestFromTemplateFile);
        System.out.println(requestFromTemplateFile);
        requestMappedWithFeaturefileForClaim = mappingFeatureFileValueInRequest(hashMapForAllFlowsObj.createClaimHashMap(), newParameters, requestFromTemplateFile);
        System.out.println("requestMappedWithFeaturefile-----------------------\n");
        System.out.println(requestMappedWithFeaturefileForClaim);
    }

    public void mappingPerilQuestions(List<List<String>> perilQuestions) {
        LinkedHashMap<String, String> perilQuestionAndAnswerMap = new LinkedHashMap<>();
        perilQuestionAndAnswerMap = this.mappingPerilQuestionForUserGivenData(perilQuestions);
        String finalClaimRequest = this.extractAnswersBlockAndRepeating(requestMappedWithFeaturefileForClaim, perilQuestionAndAnswerMap);
        String mappingClaimRequestForPerilQuestions = "";
        System.out.println("finalClaimRequest---------------------\n" + finalClaimRequest);
        if (finalClaimRequest.contains("##PerilQuestion##")) {
            mappingClaimRequestForPerilQuestions = this.mappingQuestionAndAnswersInRequest(finalClaimRequest, perilQuestionAndAnswerMap);
        } else {
            mappingClaimRequestForPerilQuestions = finalClaimRequest;
        }
        mappingClaimRequestForPerilQuestions = mappingClaimRequestForPerilQuestions.replaceFirst("##LeadID##", this.leadId);
        mappingClaimRequestForPerilQuestions = mappingClaimRequestForPerilQuestions.replace("##PersonId##", this.namedPersonId);
        System.out.println("Request ------------------ \n" + mappingClaimRequestForPerilQuestions);
        String response = sendingRequest(mappingClaimRequestForPerilQuestions, TARGETURL_CLAIMCREATION);
        System.out.println("Response------------------------------\n");
        System.out.println(response);
        claimId = parsingResponse(response, "matterID");
        System.out.println("Matter id ------------------------" + leadId);
        System.out.println("claim id ------------------------" + claimId);

    }

    private String mappingQuestionAndAnswersInRequest(String finalClaimRequest, LinkedHashMap<String, String> perilQuestionAndAnswerMap) {
        for (Map.Entry<String, String> e : perilQuestionAndAnswerMap.entrySet()) {
            System.out.println("test-------------------" + TTAPIMappingValueRequestOperations.perilIDToAppendLater + "#" + e.getKey());
            JSONObject json7 = (JSONObject) perilQuestionsMap.get(TTAPIMappingValueRequestOperations.perilIDToAppendLater + "#" + e.getKey());
            Long tableRowID = (Long) json7.get("tableRowID");
            System.out.println("============currencyCode:: " + tableRowID);
            String answer = e.getValue();
            finalClaimRequest = finalClaimRequest.replaceFirst("##PerilQuestion##", tableRowID.toString());
            finalClaimRequest = finalClaimRequest.replaceFirst("##Answers##", e.getValue());
        }
        System.out.println("final request --------------------\n " + finalClaimRequest);
        return finalClaimRequest;
    }

    //Extracting the answer block from the request - do not remove this is for later reference
    private String extractAnswersBlockAndRepeating(String input, LinkedHashMap<String, String> perilQuestionAndAnswerMap) {
        String answers = input.substring(input.indexOf("Answers"), input.length() - 2).substring(input.substring(input.indexOf("Answers"), input.length() - 2).indexOf("{"), input.substring(input.indexOf("Answers"), input.length() - 2).length());//input.substring(input.indexOf("Answers"), input.length()-2);
        String rquest = input.substring(0, input.indexOf("Answers")).concat(answers.substring(0, answers.indexOf("{")));
        String answerExtracted = answers.concat(",");
        System.out.println("requesting-----------------" + rquest);
        System.out.println("Answers-----------------------" + answers);
        System.out.println("Size----------------------------" + perilQuestionAndAnswerMap.keySet().size());
        if (!perilQuestionAndAnswerMap.containsKey("NoQuestion")) {
            for (int i = 1; i < perilQuestionAndAnswerMap.keySet().size(); i++) {
                answerExtracted = answerExtracted.concat(answers + ",");
            }
            System.out.println("Answers--------------------\n" + answerExtracted);
            rquest = (rquest.concat("Answers\":[".concat(answerExtracted.substring(0, answerExtracted.length() - 1)))).concat("]}");
            System.out.println("Request-----------------------\n" + rquest);
        } else {
            rquest = rquest.concat("Answers\":[]}");
        }
        return rquest;
    }

    //Mapping the peril questions with the property file data  - do not remove this is for later reference
    private LinkedHashMap<String, String> mappingPerilQuestionForUserGivenData(List<List<String>> perilQuestions) {
        List<List<String>> perilQuestionFromPropertyFile = new ArrayList<List<String>>();
        LinkedHashMap<String, String> perilQuestionsMap = hashMapForAllFlowsObj.perilQuestionHashMap();
        LinkedHashMap<String, String> perilQuestionAndAnswerMap = new LinkedHashMap<>();
        for (int perilRow = 1; perilRow < perilQuestions.size(); perilRow++) {
            perilQuestionFromPropertyFile = commandsObj.perilQuestionMapping(perilQuestions, perilRow);
        }

        for (int i = 1; i < perilQuestionFromPropertyFile.size(); i++) {
            for (int j = 0; j < perilQuestionFromPropertyFile.get(i).size(); j++) {
                System.out.println("i==============" + perilQuestionFromPropertyFile.get(0).get(j) + "----------------j--------------" + perilQuestionFromPropertyFile.get(i).get(j));
                for (Map.Entry<String, String> e : perilQuestionsMap.entrySet()) {
                    System.out.println("Key----------------" + e.getKey());
                    if (e.getKey().equalsIgnoreCase(perilQuestionFromPropertyFile.get(0).get(j))) {
                        System.out.println("inside if loop----------------" + e.getKey() + "--------------val------------" + perilQuestionFromPropertyFile.get(i).get(j));
                        perilQuestionAndAnswerMap.put(e.getValue(), perilQuestionFromPropertyFile.get(i).get(j));
                    }
                }
            }
        }
        System.out.println("Maping contains -----------------" + perilQuestionAndAnswerMap.keySet());
        return perilQuestionAndAnswerMap;
    }

    public void progressClaim(String property, List<List<String>> parameters, String claimCreatedThrough) {
        hashMapForAllFlowsObj.progressClaimQuestionReference();
        String request = this.retrievingProgressClaimRequest(property, parameters, claimCreatedThrough);
        System.out.println("request-----------------------######" + request);
        String requestToPost = "";
        requestToPost = mappingFeaturFileData(hashMapForAllFlowsObj.progressClaimQuestionReference(), parameters, request);
        System.out.println("request ----------------\n" + request);
        System.out.println("requestToPost ----------------\n" + requestToPost);
        requestToPost = requestToPost.replace("##ClaimId##", claimId);
        requestToPost = requestToPost.replace("##ReferenceId##", progressClaimReferenceId);
        String response = this.sendingRequest(requestToPost, TARGETURL_PROGRESSCLAIM);
        System.out.println("Response-------------------" + response);
        String type = this.parsingResponseforJsonArray(response, ttConstantsObj.PROPERTYQUESTIONREFPROGRESSCLAIM, ttConstantsObj.PROPERTYTYPEPROGRESSCLAIM, ttConstantsObj.VALUETOCOMPARE);
        System.out.println("reference if ---------------" + type);
        String requestToFinalSave = response.substring(response.lastIndexOf("item2")+7,response.length()-1);;
        // Assert.assertTrue(type.equalsIgnoreCase("Triage") | type.equalsIgnoreCase("AutoSettle"));
        String finalSaveResponse = this.sendingRequest(requestToFinalSave, TARGETURL_PROGRESSCLAIMFINALSAVE);
        System.out.println("final save----------------" + finalSaveResponse);

    }

    private String parsingResponseforJsonArray(String response, String propertyToRetrieve, String propertyToCompare, String valuetocompare) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = null;
        String returnValue = "";
        try {
            jsonObj = (JSONObject) parser.parse(response);
            for (Object key : jsonObj.keySet()) {
                // based on you key types
                String keyStr = (String) key;
                Object keyvalue = jsonObj.get(keyStr);

                // for nested objects iteration if required
                if (keyvalue instanceof JSONObject) {
                    System.out.println("***** Inside Nested Object ****");
                    printJsonObject((JSONObject) keyvalue);
                } else if (keyvalue instanceof JSONArray) {

                    JSONArray jsonArray = (JSONArray) keyvalue;
                    Iterator itr = jsonArray.iterator();
                    int i = 0;
                    while (itr.hasNext()) {
                        i++;
                        System.out.println("********* Inside while ************: " + i);
                        JSONObject jsonObj2 = (JSONObject) itr.next();
                        String reference = (String) jsonObj2.get(propertyToRetrieve);
                        System.out.println("Question ref------------" + reference);
                        if (reference.equalsIgnoreCase(valuetocompare)) {
                            System.out.println("type------------------" + (String) jsonObj2.get(propertyToCompare));
                            returnValue = (String) jsonObj2.get(propertyToCompare);
                        } else {
                            returnValue = reference;
                        }
                    }
                }
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return returnValue;
    }


    private String mappingFeaturFileData(LinkedHashMap<String, String> reference, List<List<String>> parameters, String request) {
        String requestAfterReplacement = "";
        String valueToReplace = "";
        for (int i = 1; i < parameters.size(); i++) {
            for (Map.Entry<String, String> entry : reference.entrySet()) {
                System.out.println("Key-------------" + entry.getKey() + "---Value--------------" + entry.getValue());
                for (int j = 0; j < parameters.get(0).size(); j++) {
                    if (entry.getValue().equals(parameters.get(i).get(0))) {
                        request = assigningQuestionAndAnswers(parameters.get(0).get(j), entry.getKey(), parameters.get(i).get(j), request);
                    }
                }
            }
        }
        return request;
    }

    private String assigningQuestionAndAnswers(String fieldName, String substitutionVariable, String fieldValue, String request) {
        String requestToPost = "";
        String valueToReplace = "";
        switch (fieldName.toLowerCase()) {
            case "question":
                System.out.println("------------switch-------question---------" + fieldValue);
                request = request.replace("##Question##", fieldValue);
                break;
            case "answer":
                if (!fieldValue.contains("#")) {
                    valueToReplace = changingUserSpecificValueToRequestAcceptValue(fieldName, fieldValue, "");
                    request = request.replaceFirst(substitutionVariable, valueToReplace);
                } else {
                    for (int i = 0; i < fieldValue.split("#").length; i++) {
                        System.out.println("fieldValue.split(\"#\")[i]------------------------" + fieldValue.split("#")[i]);
                        valueToReplace = changingUserSpecificValueToRequestAcceptValue(fieldName, fieldValue.split("#")[i], "");
                        request = request.replaceFirst(substitutionVariable, valueToReplace);
                    }
                }
                break;
            case "type":
                valueToReplace = changingUserSpecificValueToRequestAcceptValue(fieldName, fieldValue, "");
                request = request.replaceFirst(substitutionVariable.concat("Type"), valueToReplace);
                break;
            case "questionset":
                request = request.replace("##QuestionSet##", fieldValue);
                break;
        }
        return request;
    }

    private String retrievingProgressClaimRequest(String property, List<List<String>> parameters, String claimCreatedThrough) {
        Properties props = fileOperationsOObj.readBasicPropertyFile();
        String claimCreated = "";
        if (claimCreatedThrough.equalsIgnoreCase("portal")) {
            claimCreated = "0";
        } else if (claimCreatedThrough.equalsIgnoreCase("AQ")) {
            claimCreated = "1";
        }
        String proValue = props.getProperty(property);
        System.out.println("Prop Valu-----------------" + proValue);
        String requesttmpl = fileOperationsObj.readFile(props.getProperty(proValue));
        String questionRepetition = "";
        String requestExtractedQuestion = requesttmpl.substring(0, requesttmpl.lastIndexOf("{"));
        System.out.println("---------------Requesttemplate---------------\n" + requesttmpl);
        System.out.println("---------------requestExtractedQuestion---------------\n" + requestExtractedQuestion);
        String questionBlock = requesttmpl.substring(requesttmpl.indexOf("[") + 2, requesttmpl.indexOf("]"));
        System.out.println("Questions block-----------------------\n " + questionBlock);
        for (int i = 1; i < parameters.size(); i++) {
            questionRepetition = questionRepetition.concat(questionBlock.concat(","));
            System.out.println("parameters.get(i).get(0)---------------" + parameters.get(i).get(0));
            List<String> OtherDetails = hashMapForAllFlowsObj.progressClaimOtherProperty().get(parameters.get(i).get(0));
            questionRepetition = questionRepetition.replaceFirst("##Question##", parameters.get(i).get(1));
            questionRepetition = questionRepetition.replaceFirst("##Refernce##", parameters.get(i).get(0));
            questionRepetition = questionRepetition.replaceFirst("##Tittle##", OtherDetails.get(0));
            questionRepetition = questionRepetition.replaceFirst("##QuestionSet##", OtherDetails.get(1));
            questionRepetition = questionRepetition.replaceFirst("##Data##", OtherDetails.get(3));
            questionRepetition = questionRepetition.replaceFirst("##Type##", OtherDetails.get(4));
            questionRepetition = questionRepetition.replaceFirst("##DateType##", OtherDetails.get(5));
            questionRepetition = questionRepetition.replaceFirst("##AdditionalData##", OtherDetails.get(6));

            System.out.println("after repeating block ----------------\n" + questionRepetition);
        }
        questionRepetition = questionRepetition.substring(0, questionRepetition.length() - 1);
        String request = (requestExtractedQuestion.concat(questionRepetition)).concat("],\n" +
                "    \"origin\": " + claimCreated + "}");
        System.out.println("after repeating block ----------------\n" + request);

        return request;
    }

    public void getRefernceID() {
        String basicProgressClaimToPost = "";
        Properties props = fileOperationsOObj.readBasicPropertyFile();
        String basicProgressClaimrequesttmpl = fileOperationsObj.readFile(props.getProperty("BASICPROGRESSCLAIM"));
        basicProgressClaimToPost = basicProgressClaimrequesttmpl.replace("##ClaimId##", claimId);
        System.out.println("basicProgressClaimrequesttmpl=--------------" + basicProgressClaimrequesttmpl);
        String response = this.sendingRequest(basicProgressClaimToPost, TARGETURL_PROGRESSCLAIM);
        System.out.println("Response-------------------" + response);
        progressClaimReferenceId = this.parsingResponse(response, "reference");
        System.out.println("reference if ---------------" + progressClaimReferenceId);


    }

    public void getPersonID() {

        System.out.println("named person--------------------" + TARGETURL_NAMEDPERSON.concat(this.leadId));
        String personId = sendingRequestWithGetMethod(TARGETURL_NAMEDPERSON.concat(this.leadId));
        System.out.println("response for person service --------------\n" + "{Respnse:" + personId + "}");
        namedPersonId = parsingResponseforJsonArray("{" + "\"Respnse:\"" + personId + "}", "id", "id", "");
        System.out.println("Named person id ----------------" + namedPersonId);

    }

    public void selectCreatedClaim() {
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountInformationPageObj.moreLink().click();
        System.out.println("claim id-------------------" + claimId);
        ClaimCreation.claimID = nextEventPageObj.firstClaimID().getText();
        claimSummaryPageObj.selectClaim(this.claimId).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
//        claimsOperationsObj.clickingUnderNextEventsAndButtons("refresh");
//        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        claimsOperationsObj.clickingUnderNextEventsAndButtons("refresh");
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimsOperationsObj.clickingUnderNextEventsAndButtons("go");
    }

    public void quoteAndBuyReqestAndResponse(String action, String covers) {
        //  commandsObj.waitForLoad(getDriver());
        this.getPersonID();
        //  List<List<String>> lstQuoteParamets = commandsObj.parameterMappingQuote(parameters, action);
        String request = "";
        String response = "";
        String finalResponse = "";
//        System.out.println("Question===" + lstQuoteParamets.get(0));
//        System.out.println("Asnwer===" + lstQuoteParamets.get(1));
        Properties props = fileOperationsOObj.readBasicPropertyFile();
        String proValue = props.getProperty(action);
        System.out.println("Prop Valu-----------------" + proValue);
        String requestFromTemplateFile = fileOperationsObj.readFile(props.getProperty(proValue));
        System.out.println("---------------Requesttemplate---------------");
        System.out.println(requestFromTemplateFile);
        StringBuilder quoteAndBuyRequest = new StringBuilder();
        quoteAndBuyRequest.append(requestFromTemplateFile);
        request = this.replacingLeadIDCustomerIDPersonIDFromRequest(quoteAndBuyRequest);
        response = sendingRequest(request, TARGETURL_PREPAREQUOTE + ttapiMappingValueRequestOperationsObj.brandNameCode);
        System.out.println("Response from prepare quote" + response);
        String requestAfterMapping = mappingUserDefinedValueInQuoteAndBuyRequest(response, covers);
        System.out.println("requestAfterMapping------------------------\n" + requestAfterMapping);
        finalResponse = sendingRequest(requestAfterMapping, TARGETURL_BUYQUOTE);
        System.out.println("Final outcome ------------------------\n" + finalResponse);
        // this.quoteAndBuyMapping(response);
        //  this.mappingUserDefinedValueInQuoteAndBuyRequest(quoteAndBuyRequest,parameters);

    }

    private String replacingLeadIDCustomerIDPersonIDFromRequest(StringBuilder quoteAndBuyRequest) {
        String request = quoteAndBuyRequest.toString();
        request = request.replaceAll("##LeadID##", leadId);
        request = request.replaceAll("##PersonID##", namedPersonId);
        request = request.replaceAll("##DOB##", ttapiMappingValueRequestOperationsObj.dob);
        request = request.replaceAll("##TripFromDate##", ttapiMappingValueRequestOperationsObj.claimReplacement("TripFromDate", "currentdate-5"));
        request = request.replaceAll("##TripToDate##", ttapiMappingValueRequestOperationsObj.claimReplacement("TripToDate", "futuredate30days"));
        request = request.replaceAll("##PolicyInceptionDate##", ttapiMappingValueRequestOperationsObj.policyValueReplacement("PolicyInceptionDate", "today"));
        System.out.println("request after mapping lead id---------------------------");
        System.out.println(request);
        return request;
    }

    private String mappingUserDefinedValueInQuoteAndBuyRequest(String quoteAndBuyRequest, String covers) {
        StringBuilder sb = new StringBuilder(quoteAndBuyRequest);
        for (int i = 0; i < covers.split("#").length; i++) {
            int strPosition = stringPosition(covers.split("#")[i]);
            int indexposition = quoteAndBuyRequest.indexOf("\"selected\"", quoteAndBuyRequest.indexOf(covers.split("#")[i]) - strPosition);
            int positionForCover = positionForEachUpgrade(covers.split("#")[i]);
            sb.replace(indexposition, indexposition + positionForCover, strToReplace(covers.split("#")[i]));
            System.out.println("BB------------------------------------\n" + sb);
        }
        return sb.toString();
    }

    private int stringPosition(String coverName) {
        int position = 0;
        if (coverName.equalsIgnoreCase("Business Cover") || coverName.equalsIgnoreCase("Medical Cover")) {
            position = 10;
        } else if (coverName.equalsIgnoreCase("Golf cover")) {
            position = 10;
        }
        return position;
    }

    private int positionForEachUpgrade(String coverName) {
        int position = 0;
        if (coverName.equalsIgnoreCase("Business Cover") || coverName.equalsIgnoreCase("Medical Cover")) {
            position = 17;
        } else if (coverName.equalsIgnoreCase("Golf cover")) {
            position = 16;
        }
        return position;
    }

    private String strToReplace(String coverName) {
        String replaceStr = "";
        if (coverName.equalsIgnoreCase("Business Cover") || coverName.equalsIgnoreCase("Medical Cover")) {
            replaceStr = "\"selected\":true,";
        } else if (coverName.equalsIgnoreCase("Golf cover")) {
            replaceStr = "selected\":true,";
        }
        return replaceStr;
    }

    private void quoteAndBuyMapping(String request) {
        HashMap<String, JSONObject> coverDetails = new HashMap();
        JSONParser parser = new JSONParser();
        JSONObject json = null;
        try {
            json = (JSONObject) parser.parse(request);
            readClaimConfig(json);
            JSONObject json3 = (JSONObject) coverDetails.get("Medical Cover");
            String selectParamenter = (String) json3.get("selected");
            System.out.println("Paramented-------------" + selectParamenter);

//            JSONObject json4 = (JSONObject) perilcauseSubCauseMap.get("Abandoned International Departure#No Reason Given");
//            Long perilID = (Long) json4.get("perilID");
//
//
//            JSONObject json5 = (JSONObject) currenciesMap.get("Brazil Reais");
//            String currencyCode = (String) json5.get("currencyCode");
//
//
//            Iterator itr = perilclaimDetailMap.entrySet().iterator();
//            while (itr.hasNext()) {
//                Map.Entry pair = (Map.Entry) itr.next();
//
//            }
//
//            JSONObject json6 = (JSONObject) perilclaimDetailMap.get("48447#Single Item (Clothing, Toiletries, Bags etc.)#General Baggage");
//            Long claimDetailID = (Long) json6.get("claimDetailID");
//
//
//            JSONObject json7 = (JSONObject) perilQuestionsMap.get("48378#Which of the following is the affected person?");
//            Long tableRowID = (Long) json7.get("tableRowID");

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
