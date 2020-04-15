package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.ClaimSummaryPage;
import co.uk.directlinegroup.tt.pages.ClaimsRepudiationPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ClaimsRepudiationOperations {

    private ClaimsRepudiationPage claimsRepudiationPageObj = new ClaimsRepudiationPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();

    public void repudiateClaim(List<List<String>> strRepudiate) {
        System.out.println("INside REPUDIATION");
        for (int row = 1; row < strRepudiate.size(); row++) {
            for (int column = 0; column < strRepudiate.get(0).size(); column++) {
                this.validateRepudiateClaim(strRepudiate.get(0).get(column), strRepudiate.get(row).get(column));
            }
        }
        System.out.println("Switch to default");
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
       claimsRepudiationPageObj.save().click();
        nextEventPageObj.waitForMoreTime();
        try{Thread.sleep(4000L);}catch(Exception e){}
        nextEventPageObj.waitForMoreTime();
    }

    public void validateRepudiateClaim(String searchField, String searchValue) {
        switch (searchField.toLowerCase()) {
            case "repudiateclaim":
                claimsRepudiationPageObj.repudiateClaim().click();
                claimsRepudiationPageObj.repudiateClaimOption(searchValue).click();
                break;
            case "repudiatereason":
                claimsRepudiationPageObj.ClaimReasonbtn().click();
                nextEventPageObj.switchToFrameById(nextEventPageObj.claimreasonframe());
                claimsRepudiationPageObj.repudiateClaimSubReasonInput().clear();
                claimsRepudiationPageObj.repudiateClaimSubReasonInput().sendKeys(searchValue);
                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(claimsRepudiationPageObj.repudiateClaimSubReasonInputFilter());
                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick(claimSummaryPageObj.containsFilter());
                nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
                claimsRepudiationPageObj.repudiateClaimReasonOption(searchValue).click();
                break;
        }
    }

    public void validateApproveRejectRepudiation(List<List<String>> strRepudiate) {
        String strSearchField, strSearchValue;
        try {
            for (int row = 1; row < strRepudiate.size(); row++) {
                for (int col = 0; col < strRepudiate.get(0).size(); col++) {
                    strSearchField = strRepudiate.get(0).get(col);
                    strSearchValue = strRepudiate.get(row).get(col);
                    switch (strSearchField.toLowerCase().trim()) {
                        case "approve/reject":
                            claimsRepudiationPageObj.approveRepudiation().click();
                            claimsRepudiationPageObj.ApprovalValuedropdown(strSearchValue).click();
                            if(strSearchValue.equalsIgnoreCase("yes")){
                                claimsRepudiationPageObj.repudiationapproveSave().click();
                                nextEventPageObj.waitForMoreTime();
                                claimsRepudiationPageObj.repudiationapproveSave().click();
                            }
                            break;
                        case "repudiatereason":
                            claimsRepudiationPageObj.ApprovalDeclinedReasons().sendKeys(strSearchValue);
                            claimsRepudiationPageObj.repudiationapproveSave().click();
                            nextEventPageObj.waitForMoreTime();
                            break;
                        case "approve/reject line item":
                            new Select(claimsRepudiationPageObj.approveRejectrepudiateLineItemdropdown()).selectByVisibleText(strSearchValue);
                            claimsRepudiationPageObj.repudiateLineItemSave().click();
                            nextEventPageObj.waitForMoreTime();
                            claimsRepudiationPageObj.repudiateLineItemSave().click();
                            break;

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateCRRepudiationMessage(List<List<String>> strRepudiate){
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        claimsRepudiationPageObj.CRQuestionsButton().click();
        for (int row = 1; row < strRepudiate.size(); row++) {
            for (int column = 0; column < strRepudiate.get(0).size(); column++) {
                this.CRRepudiationMessage(strRepudiate.get(0).get(column), strRepudiate.get(row).get(column));
            }
        }
        claimsRepudiationPageObj.save().click();

    }
    public void CRRepudiationMessage(String searchField, String searchValue) {
        switch (searchField) {
            case "Parameter":
                System.out.println("Parameter-----"+claimsRepudiationPageObj.verifymessage(searchField,searchValue).getText());
                Assert.assertTrue(claimsRepudiationPageObj.verifymessage(searchField,searchValue).getText().equalsIgnoreCase(searchValue));
                break;
            case "Requirement":
                System.out.println("Requirement-----"+claimsRepudiationPageObj.verifymessage(searchField,searchValue).getText());
                Assert.assertTrue(claimsRepudiationPageObj.verifymessage(searchField,searchValue).getText().equalsIgnoreCase(searchValue));
                break;
            case "Value":
                System.out.println("Value-----"+claimsRepudiationPageObj.verifymessage(searchField,searchValue).getText());
                Assert.assertTrue(claimsRepudiationPageObj.verifymessage(searchField,searchValue).getText().equalsIgnoreCase(searchValue));
                break;
        }
    }

    public void validateClearCloseReason(List<List<String>> strRepudiate){
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        for (int row = 1; row < strRepudiate.size(); row++) {
            for (int column = 0; column < strRepudiate.get(0).size(); column++) {
                this.clearCloseReason(strRepudiate.get(0).get(column), strRepudiate.get(row).get(column));
            }
        }
        claimsRepudiationPageObj.save().click();
    }

    public void clearCloseReason(String searchField, String searchValue){
        switch (searchField.toLowerCase()) {
            case "repudiateclaim":
                if(searchValue.equalsIgnoreCase("no")) {
                    claimsRepudiationPageObj.repudiateClaim().click();
                    claimsRepudiationPageObj.repudiateClaimOption(searchValue).click();
                    claimsRepudiationPageObj.ClaimClearReasonbtn().click();
                    nextEventPageObj.waitForMoreTime();
                }
                break;
        }
    }

    public void validateTMAProcessingAdvice(){
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.TMAProcessingAdviceSaveBtn();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateTheRepudiationReasonList(List<String> parameters) {

    }
}