package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.utils.common.HashMapForAllFlows;
import co.uk.directlinegroup.tt.utils.common.RandomGenerator;
import org.json.simple.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 324102 on 12/07/2018.
 */
public class TTAPIMappingValueRequestOperations {


    private RandomGenerator randomGeneratorObj = new RandomGenerator();
  //  private TTAPIOperations ttapiOperationsObj = new TTAPIOperations();
    private HashMapForAllFlows hashMapForAllFlowsObj = new HashMapForAllFlows();

    public static String causeCodeAndSubcauseCode = "";
    public static String claimItem1And2 = "";
    public static Long perilIDToAppendLater ;
    public static String brandName ="";
    public static String brandNameCode ="";
    public static String productType ="";
    public static String firstName ="";
    public static String lastName ="";
    public static String sortCode = "";
    public static String accountNumber = "";
    public static String dob = "";
    public static String secondaryFirstName ="";
    public static String secondaryLastName ="";
    public static String secondJHFirstName ="";
    public static String secondJHLastName ="";
    public static String thirdJHFirstName ="";
    public static String thirdJHLastName ="";
    public static String jointAccountHolderIndicator ="";
    public static String address1 ="";
    public static String address2 ="";
    public static String town ="";
    public static String postCode ="";
    public static String mobile ="";
    public static String email ="";
    public static String emailJH1 ="";
    public static String emailJH2 ="";
    public static String emailJH3 ="";
    public static String country ="";
    public static String dateofbirth ="";

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat df = new SimpleDateFormat("dd MMM yyyy");
    Calendar c = Calendar.getInstance();
    String date = "";

    public String policyValueReplacement(String key,String value){
        String returnvalue="";
        if (key.equalsIgnoreCase("brand")) {
            if (value.equalsIgnoreCase("NatWest")) {
                System.out.println("Inside Brand if loop");
                brandName = value;
                returnvalue = "46548";
                brandNameCode = returnvalue;
            }if (value.equalsIgnoreCase("Ulster Bank")) {
                System.out.println("Inside Brand if loop");
                brandName = value;
                returnvalue = "46549";
                brandNameCode = returnvalue;
            }if (value.equalsIgnoreCase("Royal Bank of Scotland") | value.equalsIgnoreCase("RBS")) {
                System.out.println("Inside Brand if loop");
                brandName = value;
                returnvalue = "46547";
                brandNameCode = returnvalue;
            }
        }
        if (key.equalsIgnoreCase("LastName")) {
            if (value.equalsIgnoreCase("Random")) {
                System.out.println("Inside Brand if loop");
                returnvalue = randomGeneratorObj.randomString(4);
                lastName = returnvalue;
                PolicyOperations.retrieveRandomCustomerLastName =returnvalue;
                QuoteAndBuyOperations.randomCustomerLastName = returnvalue;
            }
        }
        if (key.equalsIgnoreCase("FirstName")) {
            if (value.equalsIgnoreCase("Random")) {
                System.out.println("Inside Brand if loop");
                returnvalue = randomGeneratorObj.randomString(4);
                firstName = returnvalue;
            }else{
                returnvalue=value;
                firstName = returnvalue;
                PolicyOperations.retrieveRandomCustomerFirstName = returnvalue;
            }
        }
        if (key.equalsIgnoreCase("ProductType")) {
            productType = value;
            String brandProductType = brandName.concat(value);
            if (brandProductType.equalsIgnoreCase("NatWestSilver")) {
                System.out.println("Inside Brand if loop");
                returnvalue = "46553";
            } if (brandProductType.equalsIgnoreCase("NatWestBlack")) {
                System.out.println("Inside Brand if loop");
                returnvalue = "46555";
            }if (brandProductType.equalsIgnoreCase("Ulster BankUFIRST Gold")) {
                System.out.println("Inside Brand if loop");
                returnvalue = "47486";
            }if (brandProductType.equalsIgnoreCase("Royal Bank of ScotlandPlatinum")) {
                System.out.println("Inside Brand if loop");
                returnvalue = "47472";
            }if (brandProductType.equalsIgnoreCase("NatWestPlatinum")) {
                System.out.println("Inside Brand if loop");
                returnvalue = "46554";
            }if (brandProductType.equalsIgnoreCase("Royal Bank of ScotlandSilver")) {
                System.out.println("Inside Brand if loop");
                returnvalue = "47471";
            }if (brandProductType.equalsIgnoreCase("Royal Bank of ScotlandBlack")) {
                System.out.println("Inside Brand if loop");
                returnvalue = "47473";
            }if (brandProductType.equalsIgnoreCase("Ulster BankUFIRST Private")) {
                System.out.println("Inside Brand if loop");
                returnvalue = "47487";
            }
        }
        if (key.equalsIgnoreCase("SortCode")) {
            sortCode = value;
                returnvalue=value;
        }
        if (key.equalsIgnoreCase("AccountNumber")) {
            accountNumber = value;
                returnvalue=value;
        }
//        if (key.equalsIgnoreCase("DateOfBirth")) {
//            dob = value;
//            returnvalue=value;
//        }
        if(key.equalsIgnoreCase("PolicyInceptionDate")){
                if (value.equalsIgnoreCase("today")) {
                    c.add(Calendar.DATE, 0);
                    date = sdf.format(c.getTime());
                    returnvalue = date;
                    System.out.println("calculated date" + returnvalue);
                }
        }
        if(key.equalsIgnoreCase("CINNumber")) {
            long CINnumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
            returnvalue =  String.valueOf(CINnumber);
            System.out.println("CIN number for main account holder****" + returnvalue);
        }
        if(key.equalsIgnoreCase("CINNumber1")) {
            long CINnumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
            returnvalue =  String.valueOf(CINnumber);
            System.out.println("CIN number for primary joint account holder****" + returnvalue);
        }
        if(key.equalsIgnoreCase("CINNumber2")) {
            long CINnumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
            returnvalue =  String.valueOf(CINnumber);
            System.out.println("CIN number for 2nd joint account holder****" + returnvalue);
        }
        if(key.equalsIgnoreCase("CINNumber3")) {
            long CINnumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
            returnvalue =  String.valueOf(CINnumber);
            System.out.println("CIN number for 3rd joint account holder****" + returnvalue);
        }
        if (key.equalsIgnoreCase("SecondMemberLastName")) {
            if (value.equalsIgnoreCase("Random")) {
                System.out.println("Inside Brand if loop");
                returnvalue = randomGeneratorObj.randomString(4);
                secondaryLastName = returnvalue;
            }else{
                returnvalue=value;
                secondaryLastName = returnvalue;
            }
        }
        if (key.equalsIgnoreCase("SecondMemberFirstName")) {
            if (value.equalsIgnoreCase("Random")) {
                System.out.println("Inside Brand if loop");
                returnvalue = randomGeneratorObj.randomString(4);
                secondaryFirstName = returnvalue;
            }else{
                returnvalue=value;
                secondaryFirstName = returnvalue;
            }
        }
        if (key.equalsIgnoreCase("ThirdMemberFirstName")) {
            if (value.equalsIgnoreCase("Random")) {
                System.out.println("Inside Brand if loop");
                returnvalue = randomGeneratorObj.randomString(4);
                secondJHFirstName = returnvalue;
            }else{
                returnvalue=value;
                secondJHFirstName = returnvalue;
            }
        }
        if (key.equalsIgnoreCase("ThirdMemberLastName")) {
            if (value.equalsIgnoreCase("Random")) {
                System.out.println("Inside Brand if loop");
                returnvalue = randomGeneratorObj.randomString(4);
                secondJHLastName = returnvalue;
            }else{
                returnvalue=value;
                secondJHLastName = returnvalue;
            }
        }
        if (key.equalsIgnoreCase("FourthMemberFirstName")) {
            if (value.equalsIgnoreCase("Random")) {
                System.out.println("Inside Brand if loop");
                returnvalue = randomGeneratorObj.randomString(4);
                thirdJHFirstName = returnvalue;
            }else{
                returnvalue=value;
                thirdJHFirstName = returnvalue;
            }
        }
        if (key.equalsIgnoreCase("FourthMemberLastName")) {
            if (value.equalsIgnoreCase("Random")) {
                System.out.println("Inside Brand if loop");
                returnvalue = randomGeneratorObj.randomString(4);
                thirdJHLastName = returnvalue;
            }else{
                returnvalue=value;
                thirdJHLastName = returnvalue;
            }
        }
        if (key.equalsIgnoreCase("JointAccountHolderIndicator")) {
            jointAccountHolderIndicator = value;
            returnvalue=value;
        }
        if (key.equalsIgnoreCase("Address1")) {
                address1 = "NO-14 NOTETEST";
                value = address1;
                returnvalue = value;
        }
        if (key.equalsIgnoreCase("Address2")) {
                address2 = "15-17 LONDON ROAD";
            value = address2;
            returnvalue = value;
        }
        if (key.equalsIgnoreCase("Town")) {
                town = "Bromley";
                value = town;
                returnvalue = value;
        }
        if (key.equalsIgnoreCase("Country")) {
                country = "UNITED KINGDOM";
                value = country;
                returnvalue = value;
        }
        if (key.equalsIgnoreCase("DateOfBirth")) {
                dob = "19930330";
                value = dob;
                returnvalue = value;
                PolicyOperations.retrieveCustomerDOB = "30/03/1993";
        }
        if (key.equalsIgnoreCase("EmailID")) {
                email = "bijith.narikkuni@directlinegroup.co.uk";
                value = email;
                returnvalue = value;
        }
        if(key.equalsIgnoreCase("EmailIDJH1")){
            emailJH1 = "thamarai.soundararajan@directlinegroup.co.uk";
            value = emailJH1;
            returnvalue = value;
        }
        if(key.equalsIgnoreCase("EmailIDJH2")){
            emailJH2 = "thamarai.soundararajan@cognizant.com";
            value = emailJH2;
            returnvalue = value;
        }
        if(key.equalsIgnoreCase("EmailIDJH3")){
            emailJH3 = "Muthukumar.Arumugavel@directlinegroup.co.uk";
            value = emailJH3;
            returnvalue = value;
        }
        if (key.equalsIgnoreCase("Teleno1")) {
                mobile = "7466505315";
                value = mobile;
                returnvalue = value;
        }
        if (key.equalsIgnoreCase("PostCode")) {
                postCode = "BR1  4AA";
                value = postCode;
                returnvalue = value;
        }
        return returnvalue;
    }

    public String claimReplacement(String key,String value){
        String returnValue="";
        c.setTime(new Date());
        if (key.equalsIgnoreCase("TripDestination")) {
            JSONObject json3 = (JSONObject) TTAPIOperations.countryMap.get(value);
            Long countyId = (Long) json3.get("countryID");
            System.out.println("============Country Id:: " + countyId);
            returnValue = countyId.toString();
        }else if(key.equalsIgnoreCase("DateTripBooked")){
            if (value.equalsIgnoreCase("today")) {
                c.add(Calendar.DATE, 0);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("calculated date-------------" + returnValue);
            } else if (value.equalsIgnoreCase("currentdate-10")) {
                c.add(Calendar.DATE, -10);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("calculated date---------------" + returnValue);
            }
        }else if(key.equalsIgnoreCase("TripFromDate")){
            if (value.equalsIgnoreCase("today")) {
                c.add(Calendar.DATE, 0);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("calculated date" + returnValue);
            } else if (value.equalsIgnoreCase("currentdate-8")) {
                c.add(Calendar.DATE, -5);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("calculated date" + returnValue);
            } else if (value.equalsIgnoreCase("currentdate-5")) {
                c.add(Calendar.DATE, -5);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("calculated date" + returnValue);
            }
        }else if(key.equalsIgnoreCase("TripToDate")){
            if (value.equalsIgnoreCase("futuredate90days")) {
                c.add(Calendar.DATE, 90);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
            } else if (value.equalsIgnoreCase("futuredate30days")) {
                c.add(Calendar.DATE, 30);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
            } else if (value.equalsIgnoreCase("currentdate-1")) {
                c.add(Calendar.DATE, -1);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("calculated date" + returnValue);
            }  else if (value.equalsIgnoreCase("today")) {
                c.add(Calendar.DATE, 0);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("calculated date" + returnValue);
            }
        }else if(key.equalsIgnoreCase("DateOfLoss")){
            if (value.equalsIgnoreCase("today")) {
                c.add(Calendar.DATE, 0);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("calculated date" + returnValue);
            } else if (value.equalsIgnoreCase("currentdate-1")) {
                c.add(Calendar.DATE, -1);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("calculated date" + returnValue);
            } else if (value.equalsIgnoreCase("currentdate-3")) {
                c.add(Calendar.DATE, -3);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("calculated date" + returnValue);
            }
        }else if (key.equalsIgnoreCase("CountryOfLoss")){
            JSONObject json3 = (JSONObject) TTAPIOperations.countryMap.get(value);
            Long countyId = (Long) json3.get("countryID");
            System.out.println("============Country Id:: " + countyId);
            returnValue = countyId.toString();
        }else if (key.equalsIgnoreCase("CauseCode")){
            causeCodeAndSubcauseCode=value.concat("#");
            System.out.println("causeCodeAndSubcauseCode----------1234----------------"+causeCodeAndSubcauseCode);
        }else if (key.equalsIgnoreCase("SubcauseCode")){
            causeCodeAndSubcauseCode = causeCodeAndSubcauseCode.concat(value);
            System.out.println("causeCodeAndSubcauseCode--------------------------"+causeCodeAndSubcauseCode);
            JSONObject json4 = (JSONObject) TTAPIOperations.perilcauseSubCauseMap.get(causeCodeAndSubcauseCode);
            Long perilID = (Long) json4.get("perilID");
            perilIDToAppendLater = perilID;
            returnValue = perilID.toString();
            System.out.println("============perilID:: " + perilID);
        }else if (key.equalsIgnoreCase("ClaimItem1")){
            claimItem1And2=((perilIDToAppendLater.toString().concat("#")).concat(value)).concat("#");
            System.out.println("claimItem1And2----------1234----------------"+claimItem1And2);
        }else if (key.equalsIgnoreCase("ClaimItem2")){
            claimItem1And2=claimItem1And2.concat(value);
            System.out.println("claimItem1And2----------1234----------------"+claimItem1And2);
            JSONObject json6 = (JSONObject) TTAPIOperations.perilclaimDetailMap.get(claimItem1And2);
            Long claimDetailID = (Long)json6.get("claimDetailID");
            returnValue = claimDetailID.toString();
            System.out.println("============claimDetailID:: " + claimDetailID);
        }else if (key.equalsIgnoreCase("Currency")){
            JSONObject json5 = (JSONObject) TTAPIOperations.currenciesMap.get(value);
            String currencyCode = (String)json5.get("currencyCode");
            System.out.println("============currencyCode:: " + currencyCode);
            returnValue = currencyCode;
        }else if (key.equalsIgnoreCase("Cost")){
            ClaimsOperations.claimAmount = value;
            returnValue = value;
        }
        return returnValue;
    }

    public String progressClaimReplacement(String key, String value) {
        System.out.println("Key---------------"+key+"--------------value-------------"+value);
        String returnValue = "";
        if(value.equalsIgnoreCase("today")){
            returnValue = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString();
        }else if (value.equalsIgnoreCase("currentdate-8")) {
            c.add(Calendar.DATE, -5);
            date = sdf.format(c.getTime());
            returnValue = date;
            System.out.println("calculated date" + returnValue);
        }else{
            if(hashMapForAllFlowsObj.progressClaimAnswers().containsKey(value)){
                returnValue = hashMapForAllFlowsObj.progressClaimAnswers().get(value);
                System.out.println("returned value ---------------------------"+returnValue);
            }else {
                returnValue = value;
            }
        }
        return returnValue;
    }
}
