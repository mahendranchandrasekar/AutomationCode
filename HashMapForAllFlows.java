package co.uk.directlinegroup.tt.utils.common;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 324102 on 27/06/2018.
 */
public class HashMapForAllFlows {

    public LinkedHashMap<String, String> createPolicyHashMap() {
        // TODO Auto-generated method stub
        LinkedHashMap<String, String> createCustomerMap = new LinkedHashMap<String, String>();
        createCustomerMap.put("##AccountNumber##", "AccountNumber");
        createCustomerMap.put("##FirstName##", "FirstName");
        createCustomerMap.put("##LastName##", "LastName");
//        createCustomerMap.put("##SecondMemberFirstName##", "");
        createCustomerMap.put("##Brand##", "Brand");
        createCustomerMap.put("##Email##","Email");
        createCustomerMap.put("##ProductType##", "ProductType");
        createCustomerMap.put("##ClaimItem##", "ClaimItem");
        createCustomerMap.put("##SortCode##","SortCode");
        createCustomerMap.put("##CINNumber##","CINNumber");
        createCustomerMap.put("##SecondMemberFirstName##", "SecondMemberFirstName");
        createCustomerMap.put("##SecondMemberLastName##", "SecondMemberLastName");
        createCustomerMap.put("##ThirdMemberFirstName##", "ThirdMemberFirstName");
        createCustomerMap.put("##ThirdMemberLastName##", "ThirdMemberLastName");
        createCustomerMap.put("##FourthMemberFirstName##", "FourthMemberFirstName");
        createCustomerMap.put("##FourthMemberLastName##", "FourthMemberLastName");
        createCustomerMap.put("##JointAccountHolderIndicator##", "JointAccountHolderIndicator");

        createCustomerMap.put("##Address1##", "Address1");
        createCustomerMap.put("##Address2##", "Address2");
        createCustomerMap.put("##Town##", "Town");
        createCustomerMap.put("##PostCode##", "PostCode");
        createCustomerMap.put("##Teleno1##", "Teleno1");
        createCustomerMap.put("##EmailID##", "EmailID");
        createCustomerMap.put("##EmailIDJH1##", "EmailIDJH1");
        createCustomerMap.put("##EmailIDJH2##", "EmailIDJH2");
        createCustomerMap.put("##EmailIDJH3##", "EmailIDJH3");
        createCustomerMap.put("##DateOfBirth##", "DateOfBirth");
        createCustomerMap.put("##Country##", "Country");
        createCustomerMap.put("##CINNumber1##","CINNumber1");
        createCustomerMap.put("##CINNumber2##","CINNumber2");
        createCustomerMap.put("##CINNumber3##","CINNumber3");



        return createCustomerMap;
    }
    public  LinkedHashMap<String, String> createClaimHashMap() {
        // TODO Auto-generated method stub
        LinkedHashMap<String, String> createClaimMap = new LinkedHashMap<String, String>();
        createClaimMap.put("##TripDestination##","TripDestination");
        createClaimMap.put("##DateTripBooked##","DateTripBooked");
        createClaimMap.put("##TripFromDate##","TripFromDate");
        createClaimMap.put("##TripToDate##","TripToDate");
        createClaimMap.put("##DateOfLoss##","DateOfLoss");
        createClaimMap.put("##CountryOfLoss##","CountryOfLoss");
        createClaimMap.put("##CauseCode##","CauseCode");
        createClaimMap.put("##SubcauseCode##","SubcauseCode");
        createClaimMap.put("##ClaimItem1##", "ClaimItem1");
        createClaimMap.put("##ClaimItem2##", "ClaimItem2");
        createClaimMap.put("##Currency##", "Currency");
        createClaimMap.put("##Cost##", "Cost");


        return createClaimMap;
    }
    //Peril question map. this map contains key as property file value which is used in UI and value as actual questions which is going to match with claim config service
    public  LinkedHashMap<String, String> perilQuestionHashMap() {
        LinkedHashMap<String, String> perilQuestionMap = new LinkedHashMap<String, String>();
        perilQuestionMap.put("anyone else insured the item","Have you, or anyone else, specifically insured the item(s) on another insurance policy? ");
        perilQuestionMap.put("loss reported","Was the loss reported within 24 hours of it's discovery and do you have confirmation nothing has been found? ");
        perilQuestionMap.put("the last known location","What was the last known location of the item(s)? ");
        perilQuestionMap.put("items were in a motor vehicle","If the items were in a motor vehicle, where in the vehicle were they?");
        perilQuestionMap.put("another person insured on this policy","Do you, or another person insured on this policy, own the item(s) being claimed? ");
        perilQuestionMap.put("evidence be provided","Can evidence be provided for the item(s) being claimed?");
        perilQuestionMap.put("Affected person","Which of the following is the affected person?");
        perilQuestionMap.put("Store Notes","Store notes relating to the previous question");
        perilQuestionMap.put("Undeclared medical condition","Was the injury linked to a undeclared medical condition?");
        perilQuestionMap.put("what injury did you suffer from?","what injury did you suffer from?");
        perilQuestionMap.put("Were you treated as an inpatient","Were you treated as an inpatient for 3 days or more?");
        perilQuestionMap.put("NoQuestion","NoQuestion");
        perilQuestionMap.put("condition that caused","What is the condition that caused the claim?");
        perilQuestionMap.put("patient been admitted as a inpatient","Had the patient been admitted as a inpatient in to a medical facility?");
        perilQuestionMap.put("trip have to be cut short","Did the trip have to be cut short, or extended as a result of the incident?");
        perilQuestionMap.put("to be with the patient?","Did anyone have to travel from the UK, to be with the patient?");
        perilQuestionMap.put("EHIC","Was the patient treated in a public hospital and was the European Health Insurance Card (EHIC) presented and accepted or Medicare used?");
        perilQuestionMap.put("result of you being a passenger","Is the claim as a result of you being a passenger or in control of, any type of motorised vehicle?");
        perilQuestionMap.put("result of participating in hazardous activities","Is the claim as a result of participating in hazardous activities?  Please answer no if this is an 'Included Activity' see your policy wording for more details.");
        return perilQuestionMap;
    }


    public LinkedHashMap<String, String> progressClaimQuestionReference(){
        LinkedHashMap<String,String> progressClaimQuestion = new LinkedHashMap<String, String>();
        progressClaimQuestion.put("##QI046##","QI046");
        progressClaimQuestion.put("##QI048##","QI048");
        progressClaimQuestion.put("##QI049##","QI049");
        progressClaimQuestion.put("##QI063##","QI063");
        progressClaimQuestion.put("##QI047##","QI047");
        progressClaimQuestion.put("##QI042##","QI042");
        progressClaimQuestion.put("##QI048TextBox##","QI048TextBox");
        progressClaimQuestion.put("##QI033##","QI033");
        progressClaimQuestion.put("##QI018##","QI018");
        progressClaimQuestion.put("##QI019##","QI019");
        progressClaimQuestion.put("##QI043##","QI043");
        progressClaimQuestion.put("##QI034##","QI034");
        progressClaimQuestion.put("##QI036##","QI036");
        progressClaimQuestion.put("##QI039##","QI039");
        progressClaimQuestion.put("##QI035##","QI035");
        progressClaimQuestion.put("##QI037##","QI037");
        progressClaimQuestion.put("##QI038##","QI038");
        progressClaimQuestion.put("##QI040##","QI040");
        progressClaimQuestion.put("##QI044##","QI044");
        progressClaimQuestion.put("##QI041##","QI041");
        progressClaimQuestion.put("##QI034TextBox##","QI034TextBox");
        progressClaimQuestion.put("##QI019TextBox##","QI019TextBox");
        progressClaimQuestion.put("##QI043TextBox##","QI043TextBox");
        progressClaimQuestion.put("##QI018TextBox##","QI018TextBox");
        for (Map.Entry<String,String> e: progressClaimQuestion.entrySet()){
            System.out.println("Key--------------------"+e.getKey());
            System.out.println("value--------------------"+e.getValue());
        }
        return progressClaimQuestion;
    }

    //Dropdown values map. This function contains the key value pair of dropdown values and respective code
    public LinkedHashMap<String,String> progressClaimAnswers(){
        LinkedHashMap<String,String> progressClaimAnswers = new LinkedHashMap<>();
        progressClaimAnswers.put("0-24 hours","175700");
        progressClaimAnswers.put("24-48 hours","175701");
        progressClaimAnswers.put("48-72 hours","175702");
        progressClaimAnswers.put("72 hours +","175703");
        progressClaimAnswers.put("Yes","true");
        progressClaimAnswers.put("No","false");
        progressClaimAnswers.put("Left in a motor vehicle, accommodation or tent","175670");
        progressClaimAnswers.put("Carried with me at the time","175671");
        progressClaimAnswers.put("In the care of an airline/transport operator","175669");
        progressClaimAnswers.put("Not listed","175672");
        progressClaimAnswers.put("Pick pocketed","175676");
        progressClaimAnswers.put("Dropped","175677");
        progressClaimAnswers.put("Misplaced","175678");
        progressClaimAnswers.put("Unknown","175679");
        progressClaimAnswers.put("Other","175680");


        return progressClaimAnswers;
    }

    //Service attribute map. This function contains the key value pair in which key is the question reference code and value is the value of different attribute in the service
    public LinkedHashMap<String,List<String>> progressClaimOtherProperty(){

        //String peril = "BaggageLost";
        LinkedHashMap<String,List<String>> questionBlockData = new LinkedHashMap<>();
        questionBlockData.put("QI033",Arrays.asList("Confirm Claimant owns item(s)","##QuestionSet##","QI033","##QI033##","YesNoQuestion","System.Boolean","null"));
        questionBlockData.put("QI018", Arrays.asList("Confirm if evidence can be provided","##QuestionSet##","QI018","##QI018##","YesNoQuestion","System.Boolean","null"));
        questionBlockData.put("QI019", Arrays.asList("Confirm if item insured elsewhere","##QuestionSet##","QI019","##QI019##","YesNoQuestion","System.Boolean","null"));
        questionBlockData.put("QI034", Arrays.asList("Confirm if the incident has been reported","##QuestionSet##","QI034","##QI034##","YesNoQuestion","System.Boolean","null"));
        questionBlockData.put("QI040", Arrays.asList("Confirm if locked, secured and out of sight","##QuestionSet##","QI040","##QI040##","YesNoQuestion","System.Boolean","null"));
        questionBlockData.put("QI034TextBox", Arrays.asList("Confirm if the incident has been reported","##QuestionSet##","QI034TextBox","\"##QI034TextBox##\"","FreeTextQuestion","System.String","null"));
        questionBlockData.put("QI036", Arrays.asList("Select last known location of item(s)","##QuestionSet##","QI036","##QI036##","MultiOptionQuestion","System.Int64",TTConstants.LOSTPLACEADDITIONALDATA));
        questionBlockData.put("QI019", Arrays.asList("Confirm if item insured elsewhere","##QuestionSet##","QI019","##QI019##","YesNoQuestion","System.Boolean","null"));
        questionBlockData.put("QI035", Arrays.asList("Confirm if the item has been inspected for repair","##QuestionSet##","QI035","##QI035##","YesNoQuestion","System.Boolean","null"));
        questionBlockData.put("QI037", Arrays.asList("Confirm if item still available for inspection","##QuestionSet##","QI037","##QI037##","YesNoQuestion","System.Boolean","null"));
        questionBlockData.put("QI038", Arrays.asList("Confirm how damage has occurred","##QuestionSet##","QI038","##QI038##","MultiOptionQuestion","System.Int64",TTConstants.DAMAGEDADDITIONALDATA));
        questionBlockData.put("QI039", Arrays.asList("Confirm whether claimed from Airline/Operator","##QuestionSet##","QI039","##QI039##","YesNoQuestion","System.Boolean","null"));
        questionBlockData.put("QI019TextBox", Arrays.asList("Confirm if item insured elsewhere","##QuestionSet##","QI019TextBox","\"##QI019TextBox##\"","FreeTextQuestion","System.String","null"));
        questionBlockData.put("QI046", Arrays.asList("Confirm if in-patient","##QuestionSet##","QI046","##QI046##","YesNoQuestion","System.Boolean","null"));
        questionBlockData.put("QI047", Arrays.asList("Enter details","##QuestionSet##","QI047","##QI047##","MultiOptionQuestion","System.Int64",TTConstants.MEDICALEXPENSEADDITIONALDATA));
        questionBlockData.put("QI048", Arrays.asList("Confirm if trip extended or cut short","##QuestionSet##","QI048","##QI048##","YesNoQuestion","System.Boolean","null"));
        questionBlockData.put("QI049", Arrays.asList("Confirm if anyone remained or travelled to be with you","##QuestionSet##","QI049","##QI049##","YesNoQuestion","System.Boolean","null"));
        questionBlockData.put("QI063", Arrays.asList("Enter name of person","##QuestionSet##","QI063","\"##QI063##\"","FreeTextQuestion","System.String","null"));
        questionBlockData.put("QI043", Arrays.asList("Confirm Claimant owns money","##QuestionSet##","QI043","##QI043##","YesNoQuestion","System.Boolean","null"));
        questionBlockData.put("QI044", Arrays.asList("Select last known location of item(s)","##QuestionSet##","QI044","##QI044##","MultiOptionQuestion","System.Int64",TTConstants.LOSTPLACEADDITIONALDATA));
        questionBlockData.put("QI041", Arrays.asList("Select circumstances of loss","##QuestionSet##","QI041","##QI041##","MultiOptionQuestion","System.Int64",TTConstants.CIRCUMSTANCESOFLOSS));
        questionBlockData.put("QI043TextBox", Arrays.asList("If no, please explain below:","##QuestionSet##","QI043TextBox","\"##QI043TextBox##\"","FreeTextQuestion","System.String","null"));
        questionBlockData.put("QI018TextBox", Arrays.asList("Confirm if evidence can be provided","##QuestionSet##","QI018TextBox","\"##QI018TextBox##\"","FreeTextQuestion","System.String","null"));
        return questionBlockData;
    }
}

