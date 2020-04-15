package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CustomerPortalCreateClaim {

    private static String strNoValueEntryString = "Nothing Entered";
    public String strSearchCondition = "";
    private CustomerPortalClaimTypesPage customerPortalClaimTypesPageObj = new CustomerPortalClaimTypesPage();
    private CustomerPortalHomePage customerPortalHomePageObj = new CustomerPortalHomePage();
    private CustomerPortalPeoplePage customerPortalPeoplePageObj = new CustomerPortalPeoplePage();

    public void stratMakeAClaim() {
        customerPortalHomePageObj.waitForMoreTime();
        customerPortalHomePageObj.makeAClaim().click();
    }

    public void selectClaimTypes(List<List<String>> claimTypes) {
        for (int row = 1; row < claimTypes.size(); row++) {
            for (int column = 0; column < claimTypes.get(0).size(); column++) {
                switch (claimTypes.get(0).get(column).toLowerCase()) {
                    case "cancellingyourtrip":
                        System.out.println("1" + claimTypes.get(row).get(column));
                        this.baggageTypeSelect(claimTypes.get(row).get(column));
                        break;
                    case "cuttingshortyourtrip":
                        System.out.println("2" + claimTypes.get(row).get(column));
                        this.cancellationTypeSelect(claimTypes.get(row).get(column));
                        break;
                    case "coversforyou":
                        System.out.println("3" + claimTypes.get(row).get(column));
                        this.curtailmentTypeSelect(claimTypes.get(row).get(column));
                        break;
                    case "coversforyourproperty":
                        System.out.println("4" + claimTypes.get(row).get(column));
                        this.emergencyTypeSelect(claimTypes.get(row).get(column));
                        break;
                }
            }
        }
    }

    public void addTripDetails(List<List<String>> parameters) {
        for (int row = 1; row < parameters.size(); row++) {
            for (int column = 0; column < parameters.get(0).size(); column++) {
                this.getTheTripDetails(parameters.get(0).get(column), parameters.get(row).get(column));
            }
        }
    }

    public void getTheTripDetails(String searchField, String searchValue) {
        if (!searchValue.equalsIgnoreCase(strNoValueEntryString) && !searchValue.isEmpty() && searchValue != null) {
            strSearchCondition = strSearchCondition + "#" + searchField + "-" + searchValue;
            switch (searchField.toLowerCase()) {
                case "destination":
                    this.tripDestinationSelect(searchValue);
                    break;
                case "datetripbooked":
                    this.dateTripBooked(searchValue);
                    break;
                case "tripdatesfrom":
                    this.tripDatesFrom(searchValue);
                    break;
                case "tripdatesto":
                    this.tripDatesTo(searchValue);
                    break;
                case "anydetails":
                    this.anyDetailsTrip(searchValue);
                    break;
            }
        }
    }

    public void selectTitle(String strTitle) {
        customerPortalPeoplePageObj.title().click();
        new Select(customerPortalPeoplePageObj.title()).selectByVisibleText(strTitle);
    }

    public void selectRelationship(String strRelationship) {
        customerPortalPeoplePageObj.title().click();
        new Select(customerPortalPeoplePageObj.relationship()).selectByVisibleText(strRelationship);
    }

    public void firstName(String strFirstname) {
        customerPortalPeoplePageObj.firstName().sendKeys(strFirstname);
    }

    public void lastName(String strLastname) {
        customerPortalPeoplePageObj.lastName().sendKeys(strLastname);
    }

    public void dob(String strDOB) {
        customerPortalPeoplePageObj.dob().sendKeys(strDOB);
    }

    public void baggageTypeSelect(String strBaggageType) {
        customerPortalClaimTypesPageObj.baggage().click();
        customerPortalClaimTypesPageObj.waitForMoreTime();
        new Select(customerPortalClaimTypesPageObj.baggageType()).selectByVisibleText(strBaggageType);
    }

    public void cancellationTypeSelect(String strCancellationType) {
        customerPortalClaimTypesPageObj.cancellation().click();
        new Select(customerPortalClaimTypesPageObj.cancellationType()).selectByVisibleText(strCancellationType);
    }

    public void curtailmentTypeSelect(String strCurtailmentType) {
        customerPortalClaimTypesPageObj.curtailment().click();
        new Select(customerPortalClaimTypesPageObj.curtailementType()).selectByVisibleText(strCurtailmentType);
    }

    public void emergencyTypeSelect(String strEmergencyType) {
        customerPortalClaimTypesPageObj.emergencyMedical().click();
        new Select(customerPortalClaimTypesPageObj.emergencyMedicalType()).selectByVisibleText(strEmergencyType);
    }

    public void tripDestinationSelect(String strTripDestination) {
        customerPortalHomePageObj.destination().click();
        new Select(customerPortalHomePageObj.destination()).selectByVisibleText(strTripDestination);
    }

    public void dateTripBooked(String strTripDate) {
        customerPortalHomePageObj.dateTripBooked().clear();
        if (!strTripDate.equalsIgnoreCase(strNoValueEntryString) && !strTripDate.isEmpty() && strTripDate != null) {
            customerPortalHomePageObj.dateTripBooked().sendKeys(strTripDate);
        }
    }

    public void tripDatesFrom(String strTripDate) {
        customerPortalHomePageObj.tripDatesFrom().clear();
        if (!strTripDate.equalsIgnoreCase(strNoValueEntryString) && !strTripDate.isEmpty() && strTripDate != null) {
            customerPortalHomePageObj.tripDatesFrom().sendKeys(strTripDate);
        }
    }

    public void tripDatesTo(String strTripDate) {
        customerPortalHomePageObj.tripDatesTo().clear();
        if (!strTripDate.equalsIgnoreCase(strNoValueEntryString) && !strTripDate.isEmpty() && strTripDate != null) {
            customerPortalHomePageObj.tripDatesTo().sendKeys(strTripDate);
        }
    }

    public void anyDetailsTrip(String strTripDate) {
        customerPortalHomePageObj.anyDetailsTrip().clear();
        if (!strTripDate.equalsIgnoreCase(strNoValueEntryString) && !strTripDate.isEmpty() && strTripDate != null) {
            customerPortalHomePageObj.anyDetailsTrip().sendKeys(strTripDate);
        }
    }

    public void clickTripDetailsSave() {
        customerPortalHomePageObj.tripDetailsSave().click();
        customerPortalHomePageObj.waitForMoreTime();
    }

    public void navigateFromClaimTypesPage() {
        customerPortalClaimTypesPageObj.nextButton().click();
    }

    public void selectPeopleOnClaim(List<List<String>> claimPeople) {
        for (int row = 1; row < claimPeople.size(); row++) {
            for (int column = 0; column < claimPeople.get(0).size(); column++) {
                switch (claimPeople.get(0).get(column).toLowerCase()) {
                    case "title":
                        this.selectTitle(claimPeople.get(row).get(column));
                        break;
                    case "firstname":
                        this.firstName(claimPeople.get(row).get(column));
                        break;
                    case "lastname":
                        this.lastName(claimPeople.get(row).get(column));
                        break;
                    case "relationship":
                        this.selectRelationship(claimPeople.get(row).get(column));
                        break;
                    case "dob":
                        this.dob(claimPeople.get(row).get(column));
                        break;
                }
            }
        }
    }

    public void addPerson() {
        customerPortalPeoplePageObj.addPerson().click();
    }

    public void savePersonDetails() {
        customerPortalPeoplePageObj.saveIcon().click();
    }

    public void savePersonsDetails() {
        customerPortalPeoplePageObj.saveIcon1().click();
    }

}
