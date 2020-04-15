package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.CustomerDetailsFieldPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.pages.PolicyDataFieldsPage;

import java.util.List;

public class CommPrefOperations {
    private NextEventPage nextEventPageObj = new NextEventPage();
    private CustomerDetailsFieldPage customerDetailsFieldPageObj = new CustomerDetailsFieldPage();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();

    public void communicationPreference(List<List<String>> commPref) throws Throwable {
        for (int i = 1; i < commPref.size(); i++) {
            System.out.println("----------i----------value ---" + i);
            for (int j = 0; j < commPref.get(i).size(); j++) {
                System.out.println("----------j----------value ---" + j);
                System.out.println("inside comm pref loop..");
                this.updateCommPref(commPref.get(i).get(j));
            }
        }
        customerDetailsFieldPageObj.saveAndCloseButton().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void updateCommPref(String commPref) {
        switch (commPref.toLowerCase()) {
            case "email":
                if (customerDetailsFieldPageObj.commPrefEMail().isSelected()) {

                } else {
                    customerDetailsFieldPageObj.commPrefEMail().click();
                }
                break;
            case "letter":
                if (customerDetailsFieldPageObj.commPrefLetter().isSelected()) {

                } else {
                    customerDetailsFieldPageObj.commPrefLetter().click();
                }
                break;
            case "sms":
                if (!(customerDetailsFieldPageObj.commPrefSMS().isSelected())) {
                    customerDetailsFieldPageObj.commPrefSMS().click();
                }
                break;
        }
    }

    public void commPref(String commPref)
    {
        switch (commPref.toLowerCase())
        {
            case "email":
                if(policyDataFieldsPageObj.eMail().isSelected())
                {

                }else{
                    policyDataFieldsPageObj.eMail().click();
                }
                break;
            case "letter":
                if(policyDataFieldsPageObj.letter().isSelected())
                {

                }else {
                    policyDataFieldsPageObj.letter().click();
                }
                break;
            case "sms":
                if(!(policyDataFieldsPageObj.sms().isSelected()))
                {
                    policyDataFieldsPageObj.sms().click();
                }
                break;
            case "phone":
                if(policyDataFieldsPageObj.phone().isSelected())
                {

                }else {
                    policyDataFieldsPageObj.phone().click();
                }
                break;
        }
    }
}
