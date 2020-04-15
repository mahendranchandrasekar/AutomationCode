package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.BasicClaimDetailsPage;
import co.uk.directlinegroup.tt.pages.ClaimSummaryPage;
import co.uk.directlinegroup.tt.pages.MontrealConventionPage;import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.common.LoadTTPropertiesFiles;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.List;

public class ClaimCreation {

    public static String claimID = "";
    private ClaimsOperations claimOperationObj = new ClaimsOperations();
    private BasicClaimDetailsPage basicClaimDetObj = new BasicClaimDetailsPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private PerformSearch perfSerachObj = new PerformSearch();
    private ClaimSummaryPage claimSummaryPageObj = new ClaimSummaryPage();
    private Commands commandsObj = new Commands();
    private MontrealConventionPage montrealConventionPageObj = new MontrealConventionPage();
    private String sysDate = "";

    public void createANewClaim(String claim, List<List<String>> parameters) {
        System.out.println("parameters passed::" + parameters);
        List<List<String>> newParameters = commandsObj.parameterMappingNew(1, parameters, LoadTTPropertiesFiles.CLAIMDETAILS_PROP);
        System.out.println(newParameters);
        commandsObj.loadingPageInSeconds(60L);
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.navigateToClaimViewFromPolicyView();
        nextEventPageObj.btnClick(claimSummaryPageObj.newClaim());
        commandsObj.loadingPageInSeconds(60L);
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        this.claimID = basicClaimDetObj.getFirstClaim().getText();
        this.claimID = nextEventPageObj.firstClaimID().getText();
        System.out.println("Claim ID2:: " + claimID);
        claimOperationObj.claimID = claimID;
        try {
            if (nextEventPageObj.goDisplayed()) {
                nextEventPageObj.go().click();
                nextEventPageObj.waitForMoreTime();

            }
        } catch (org.openqa.selenium.WebDriverException ex) {
            if (nextEventPageObj.loadingPage()) {
                if (nextEventPageObj.goDisplayed()) {
                    nextEventPageObj.go().click();
                    nextEventPageObj.waitForMoreTime();
                }
            }
        }
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        int iSize = parameters.size();
        if (claim.contains("#")) {
            iSize = Integer.parseInt(claim.split("#")[1]);
        } else {
            iSize = 1;
        }
        newParameters = commandsObj.parameterMappingNew(1, parameters, LoadTTPropertiesFiles.CLAIMDETAILS_PROP);
        claimOperationObj.createEditClaims(claim, newParameters);
        nextEventPageObj.waitForMoreTime();
        if(!claim.contains("ContributionClaim")) {
            nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
            commandsObj.loadingPageInSeconds(60L);
            claimOperationObj.validateClaimCause(claim, "Save", newParameters);
            claimOperationObj.addPersonCostItem(claim, newParameters);
            this.sysDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString();
        }
    }

    public void enterThirPartyDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "reference number":
                this.enterReferenceNumber(fieldValue);
                break;
            case "supplier":
                this.enterSupplierDetail(fieldValue);
                break;
            case "action":
                nextEventPageObj.btnClick(nextEventPageObj.saveBtn());
                break;
            case "other party address 1":
            case "other party address 2":
            case "other party town":
            case "other party county":
            case "other party post code":
            case "other party name":
            case "other party email":
                basicClaimDetObj.enterOtherThirdPartyDetails(fieldName).clear();
                basicClaimDetObj.enterOtherThirdPartyDetails(fieldName).sendKeys(fieldValue);
                break;
            case "check_letter":
                if (fieldValue.equalsIgnoreCase("yes")) {
                    nextEventPageObj.btnClick(basicClaimDetObj.chkBoxLetter());
                }
                break;
        }
    }

    private void enterSupplierDetail(String fieldValue) {
        nextEventPageObj.btnClick(basicClaimDetObj.selectOtherPartyAddBtn());
        nextEventPageObj.switchToFrameById(nextEventPageObj.supplierFrame());
        montrealConventionPageObj.txtAirlineType().sendKeys(fieldValue);
        nextEventPageObj.btnClick(montrealConventionPageObj.selectFilter());
        nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(montrealConventionPageObj.selectFilterOperation());
        nextEventPageObj.btnClick(basicClaimDetObj.selectOtherParty(fieldValue));
        nextEventPageObj.switchToDefault();
    }

    private void enterReferenceNumber(String fieldValue) {
        basicClaimDetObj.thirdPartyReferenceNumber().sendKeys(fieldValue);
    }

    public void createAnotherNewClaim(String claim, List<List<String>> parameters) {
        List<List<String>> newParameters = commandsObj.parameterMappingNew(1, parameters, LoadTTPropertiesFiles.CLAIMDETAILS_PROP);
        System.out.println(newParameters);
        nextEventPageObj.loadingPage();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick(claimSummaryPageObj.newClaim());
        claimID = basicClaimDetObj.getFirstClaim().getText();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimID = nextEventPageObj.firstClaimID().getText();
        System.out.println("Claim ID2" + claimID);
        try {
            if (nextEventPageObj.goDisplayed()) {
                nextEventPageObj.go().click();
            }
        } catch (org.openqa.selenium.WebDriverException ex) {
            if (nextEventPageObj.loadingPage()) {
                if (nextEventPageObj.goDisplayed()) {
                    nextEventPageObj.go().click();
                }
            }
        }
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        int iSize = parameters.size();
        if (claim.contains("#")) {
            iSize = Integer.parseInt(claim.split("#")[1]);
        } else {
            iSize = 1;
        }
        newParameters = commandsObj.parameterMappingNew(1, parameters, LoadTTPropertiesFiles.CLAIMDETAILS_PROP);
        claimOperationObj.createEditClaims(claim, newParameters);
        basicClaimDetObj.save().click();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        claimOperationObj.validateClaimCause(claim, "Save", newParameters);
        claimOperationObj.addPersonCostItem(claim, newParameters);
        this.sysDate = new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()).toString();
    }

    public void navigateToTheClaim() {
        nextEventPageObj.switchToDefault();
        if (nextEventPageObj.elementDisplayed(By.xpath(nextEventPageObj.navigateToPolicyLink()))) {
            nextEventPageObj.clickPolicyLink().click();
        } else {
            nextEventPageObj.navigateToDashboard().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.navigateToFirstPolicy().click();
            nextEventPageObj.switchToLastOpenWindow();

        }
    }

    public void createPartialOnlineClaim(String claim, List<List<String>> parameters) {
        System.out.println("parameters passed::" + parameters);
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.createEditClaims(claim, parameters);
        basicClaimDetObj.save().click();
        nextEventPageObj.waitForMoreTime();
    }

    public void enterPartialClaimDetails(String claim, List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.switchToFrameById(nextEventPageObj.fancyFrame());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.validateClaimCause(claim, "Save", parameters);
        claimOperationObj.addPersonCostItem(claim, parameters);
    }

    public void enterMultiplePerilDetails(String claim, List<List<String>> parameters) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimOperationObj.validateClaimCause(claim, "Save", parameters);
        claimOperationObj.addPersonCostItem(claim, parameters);
    }
    public void getErrorMessage(String text){
        basicClaimDetObj.messageValidation().getText();
    }
}
