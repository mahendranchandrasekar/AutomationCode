package co.uk.directlinegroup.tt.utils.common;

import co.uk.directlinegroup.tt.utils.DigitalOperations;
import co.uk.directlinegroup.tt.utils.TTAPIOperations;

public class TTConstants {
    public static final String PAY_DD = "Pay By Direct Debit";

    //Affinion Report test result table columns
    public static final String UNID = "UNID";
    public static final String H_UNIQUEFILETEXT = "H_UniqueFileText";
    public static final String AFFINIONSTATE = "AffinionState";
    public static final String OPERATIONTYPE = "OperationType";
    public static final String PRIMARYMEMBEREXTREF = "PrimaryMemberExtRef";
    public static final String PRIMARYMEMBERFIRSTNAME = "PrimaryMemberFirstName";
    public static final String PRIMARYMEMBERLASTNAME = "PrimaryMemberLastName";
    public static final String PRIMARYMEMBERDOB = "PrimaryMemberDOB";
    public static final String MAILINGADDRESSPOSTCODE = "MailingAddressPostCode";
    public static final String ACCOUNTNUMBER = "AccountNumber";
    public static final String SORTCODE = "SortCode";
    public static final String RECONCILESTATE = "ReconcileState";
    public static final String RECONCILEMESSAGE = "ReconcileMessage";
    public static final String CUSTOMERID = "CustomerID";
    public static final String POLICYADMINMATTERID = "PolicyAdminMatterID";
    public static final String AFFINIONDATA = "AffinionData";
    public static final String FILTER_STARTS_WITH ="Starts with";
    public static final String FILTER_IS_EQUAL_TO ="Is equal to";

    // Quote And Buy
    public static final String BUYBUTTON_LABEL = "Buy";
    public static final String PAYMENT_BY_CARD = "pay by card";
    public static final String PAYMENT_BY_DD = "pay by direct debit";
    public static final String PAYMENT_BY_ADD= "Pay by annual direct debit";




    public static final String PROPERTYQUESTIONREFPROGRESSCLAIM = "questionRef";
    public static final String PROPERTYTYPEPROGRESSCLAIM = "type";
    public static final String VALUETOCOMPARE = "Outcome";
    public static final String MEDICALCONDITIONASTHMANOTDECLARED = "{\"IsDeclaredCondition\":false,\"Condition\":\"Asthma\",\"ConditionId\":50751,\"ConditionSubtype\":0}";


    public static final String DAMAGEDADDITIONALDATA ="[\n" +
            "                {\n" +
            "                    \"id\": 175691,\n" +
            "                    \"text\": \"Dropped on to a hard surface\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": 175692,\n" +
            "                    \"text\": \"Dropped in water\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": 175693,\n" +
            "                    \"text\": \"Damaged by another party\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": 175694,\n" +
            "                    \"text\": \"In the care of an airline/transport operator\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": 175695,\n" +
            "                    \"text\": \"Not listed\"\n" +
            "                }\n" +
            "            ]\n";

    public static final String LOSTPLACEADDITIONALDATA ="[\n" +
            "                {\n" +
            "                    \"id\": 175670,\n" +
            "                    \"text\": \"Left in a motor vehicle, accommodation or tent\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": 175671,\n" +
            "                    \"text\": \"Carried with me at the time\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": 175669,\n" +
            "                    \"text\": \"In the care of an airline/transport operator\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": 175672,\n" +
            "                    \"text\": \"Not listed\"\n" +
            "                }\n" +
            "            ]";
    public static final String MEDICALEXPENSEADDITIONALDATA ="[\n" +
            "                {\n" +
            "                    \"id\": 175700,\n" +
            "                    \"text\": \"0-24 hours\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": 175701,\n" +
            "                    \"text\": \"24-48 hours\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": 175702,\n" +
            "                    \"text\": \"48-72 hours\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": 175703,\n" +
            "                    \"text\": \"72 hours +\"\n" +
            "                }\n" +
            "            ]";

    public static final String CIRCUMSTANCESOFLOSS ="[\n" +
            "                {\n" +
            "                    \"id\": 175676,\n" +
            "                    \"text\": \"Pick pocketed\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": 175677,\n" +
            "                    \"text\": \"Dropped\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": 175678,\n" +
            "                    \"text\": \"Misplaced\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": 175679,\n" +
            "                    \"text\": \"Unknown\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"id\": 175680,\n" +
            "                    \"text\": \"Other\"\n" +
            "                }\n" +
            "            ]";
}
