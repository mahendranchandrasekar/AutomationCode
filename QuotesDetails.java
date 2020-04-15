package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.CustomerPortalQuotePage;
import co.uk.directlinegroup.tt.pages.NextEventPage;

public class QuotesDetails {

    private static String strNoValueEntryString = "Nothing Entered";
    public String strSearchCondition = "";
    NextEventPage nextEventPageObj;
    private CustomerPortalQuotePage customerPortalQuotePageObj = new CustomerPortalQuotePage();

    public void AnswerQuestioneries(String searchField, String searchValue) throws Throwable {
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "insuredpersons advice":
                    this.insuredpersons(searchValue);
                    break;
                case "heartorcancer condition":
                    this.heartOrCancerCondition(searchValue);
                    break;
                case "awaiting investigation":
                    this.awaiting_Investigation(searchValue);
                case "waiting list":
                    this.waitingListForTreatment(searchValue);
                    break;
                case "terminal prognosis":
                    this.terminalPrognosis(searchValue);
                case "apply to person":
                    this.applytoPerson(searchValue);
                    customerPortalQuotePageObj.nextbtn_MedicalConditions().click();
                    break;
                case "medical condition":
                    this.enterMedicalCondition(searchValue);
                    break;
                case "COPD Diagnosis":
                    this.COPDDiagnosis(searchValue);
                    break;
                case "asthma diagnosed age":
                    this.asthmaDiagnosedAge(searchValue);
                case "Medicines Prescribed":
                    this.numberOfMedicinesPrescribed(searchValue);
                    break;
                case "number of hospital admissions":
                    this.numberOfHospitalAdmissions(searchValue);
                    break;
                case "short of breath":
                    this.shortOfBreath(searchValue);
                    break;
                case "prescribed Oxygen":
                    this.everPrescribedOxygen(searchValue);
                    break;
                case "smoker":
                    this.everBeenASmoker(searchValue);
                    break;
                case "pneumonia":
                    this.episodeOfPneumonia(searchValue);
                    break;
            }
        }
    }

    public void insuredpersons(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            if (response.equalsIgnoreCase("Yes")) {
                customerPortalQuotePageObj.insuredPersonAdvice_Yes();
                customerPortalQuotePageObj.insuredPersonAdvice_Yes().click();
            }
            if (response.equalsIgnoreCase("No")) {
                customerPortalQuotePageObj.insuredPersonAdvice_No();
                customerPortalQuotePageObj.insuredPersonAdvice_No().click();
            } else {
            }
        }
    }

    public void heartOrCancerCondition(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            if (response.equalsIgnoreCase("Yes")) {
                customerPortalQuotePageObj.insuredPersonEverHad_HeartOrCancerRelatedCondition_Yes();
                customerPortalQuotePageObj.insuredPersonEverHad_HeartOrCancerRelatedCondition_Yes().click();
            }
            if (response.equalsIgnoreCase("No")) {
                customerPortalQuotePageObj.insuredPersonEverHad_HeartOrCancerRelatedCondition_No();
                customerPortalQuotePageObj.insuredPersonEverHad_HeartOrCancerRelatedCondition_No().click();
            } else {
            }
        }
    }

    public void awaiting_Investigation(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            if (response.equalsIgnoreCase("Yes")) {
                customerPortalQuotePageObj.isInsuredPersonAwaitingForInvestigation_Yes();
                customerPortalQuotePageObj.isInsuredPersonAwaitingForInvestigation_Yes().click();
            }
            if (response.equalsIgnoreCase("No")) {
                customerPortalQuotePageObj.isInsuredPersonAwaitingForInvestigation_No();
                customerPortalQuotePageObj.isInsuredPersonAwaitingForInvestigation_No().click();
            } else {
            }
        }
    }

    public void waitingListForTreatment(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            if (response.equalsIgnoreCase("Yes")) {
                customerPortalQuotePageObj.isAnyinsuredPersonOnAWaitingListForTreatment_Yes();
                customerPortalQuotePageObj.isAnyinsuredPersonOnAWaitingListForTreatment_Yes().click();
            }
            if (response.equalsIgnoreCase("No")) {
                customerPortalQuotePageObj.isAnyinsuredPersonOnAWaitingListForTreatment_No();
                customerPortalQuotePageObj.isAnyinsuredPersonOnAWaitingListForTreatment_No().click();
            } else {
            }
        }
    }

    public void terminalPrognosis(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            if (response.equalsIgnoreCase("Yes")) {
                customerPortalQuotePageObj.isInsuredPersonReceivedATerminalPrognosis_Yes();
                customerPortalQuotePageObj.isInsuredPersonReceivedATerminalPrognosis_Yes().click();
            }
            if (response.equalsIgnoreCase("No")) {
                customerPortalQuotePageObj.isInsuredPersonReceivedATerminalPrognosis_No();
                customerPortalQuotePageObj.isInsuredPersonReceivedATerminalPrognosis_No().click();
            } else {
            }
        }
    }

    public void applytoPerson(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            if (response.equalsIgnoreCase("murali thogata")) {
                customerPortalQuotePageObj.whoDoesThisApplyToPerson1();
                customerPortalQuotePageObj.whoDoesThisApplyToPerson1().click();
            }
            if (response.equalsIgnoreCase("hello mike")) {
                customerPortalQuotePageObj.whoDoesThisApplyToPerson2();
                customerPortalQuotePageObj.whoDoesThisApplyToPerson2().click();
            }
            if (response.equalsIgnoreCase("Test User1")) {
                customerPortalQuotePageObj.whoDoesThisApplyToPerson3();
                customerPortalQuotePageObj.whoDoesThisApplyToPerson3().click();
            } else {
            }
        }
    }

    public void enterMedicalCondition(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            customerPortalQuotePageObj.enterMedicalCondition();
            customerPortalQuotePageObj.enterMedicalCondition().sendKeys(response);
            customerPortalQuotePageObj.toSelectMedicalconditionAsAsthma();
            customerPortalQuotePageObj.toSelectMedicalconditionAsAsthma().click();
        }
    }

    public void COPDDiagnosis(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            if (response.equalsIgnoreCase("Yes")) {
                customerPortalQuotePageObj.everHadADiagnosisMadeofCOPD_Yes();
                customerPortalQuotePageObj.everHadADiagnosisMadeofCOPD_Yes().click();
            }
            if (response.equalsIgnoreCase("No")) {
                customerPortalQuotePageObj.everHadADiagnosisMadeofCOPD_No();
                customerPortalQuotePageObj.everHadADiagnosisMadeofCOPD_No().click();
            } else {
            }
        }
    }

    public void asthmaDiagnosedAge(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            if (response.equalsIgnoreCase("50 or over")) {
                customerPortalQuotePageObj.howOldAreYouWhenAsthmaDiagnosed_50orOver();
                customerPortalQuotePageObj.howOldAreYouWhenAsthmaDiagnosed_50orOver().click();
            }
            if (response.equalsIgnoreCase("Below 50")) {
                customerPortalQuotePageObj.howOldAreYouWhenAsthmaDiagnosed_Under50();
                customerPortalQuotePageObj.howOldAreYouWhenAsthmaDiagnosed_Under50().click();
            } else {
            }
        }
    }

    public void numberOfMedicinesPrescribed(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            if (response.equalsIgnoreCase("One to two medicines")) {
                customerPortalQuotePageObj.howManyMedicnesArePrescribedForYourBrathingCondition_oneortwoMedicines();
                customerPortalQuotePageObj.howManyMedicnesArePrescribedForYourBrathingCondition_oneortwoMedicines().click();
            }
            if (response.equalsIgnoreCase("")) {
            } else {
            }
        }
    }

    public void numberOfHospitalAdmissions(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            if (response.equalsIgnoreCase("None")) {
                customerPortalQuotePageObj.howManyHospitalAdmissions_HaveyouHadYouBreathingConditions_None();
                customerPortalQuotePageObj.howManyHospitalAdmissions_HaveyouHadYouBreathingConditions_None().click();
            }
            if (response.equalsIgnoreCase("")) {
            } else {
            }
        }
    }

    public void shortOfBreath(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            if (response.equalsIgnoreCase("walk easily")) {
                customerPortalQuotePageObj.howShortOfBreath_ICanWalkEasily();
                customerPortalQuotePageObj.howShortOfBreath_ICanWalkEasily().click();
            }
            if (response.equalsIgnoreCase("")) {
            } else {
            }
        }
    }

    public void everPrescribedOxygen(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            if (response.equalsIgnoreCase("Yes")) {
            }
            if (response.equalsIgnoreCase("No")) {
                customerPortalQuotePageObj.haveYouEverBeenPrescribedOxygen_No();
                customerPortalQuotePageObj.haveYouEverBeenPrescribedOxygen_No().click();
            } else {
            }
        }
    }

    public void everBeenASmoker(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            if (response.equalsIgnoreCase("Yes")) {
            }
            if (response.equalsIgnoreCase("No")) {
                customerPortalQuotePageObj.haveYouEverBeenASmoker_No();
                customerPortalQuotePageObj.haveYouEverBeenASmoker_No().click();
            } else {
            }
        }
    }

    public void episodeOfPneumonia(String response) {
        if (!response.equalsIgnoreCase(strNoValueEntryString) && !response.isEmpty() && response != null) {
            if (response.equalsIgnoreCase("Yes")) {
            }
            if (response.equalsIgnoreCase("No")) {
                customerPortalQuotePageObj.haveYouhadAChestInfection_No();
                customerPortalQuotePageObj.haveYouhadAChestInfection_No().click();
                customerPortalQuotePageObj.medicalScreeningContinuebtn();
            } else {
            }
        }
    }
}