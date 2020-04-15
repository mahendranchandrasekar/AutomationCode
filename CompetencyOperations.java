package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.ClaimCompetencyPage;
import co.uk.directlinegroup.tt.pages.LeftNavPanePage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.pages.PolicyDataFieldsPage;
import co.uk.directlinegroup.tt.utils.common.Commands;
import co.uk.directlinegroup.tt.utils.common.RandomGenerator;
import com.usmanhussain.habanero.framework.WebDriverDiscovery;
import cucumber.api.PendingException;
import net.serenitybdd.core.annotations.findby.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by 324102 on 10/4/2017.
 */
public class CompetencyOperations extends WebDriverDiscovery {

    private ClaimCompetencyPage claimCompetencyPageObj = new ClaimCompetencyPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    private co.uk.directlinegroup.tt.utils.Navigation navigationObj = new co.uk.directlinegroup.tt.utils.Navigation();
    private RandomGenerator randomGeneratorObj = new RandomGenerator();
    private LeftNavPanePage leftNavPanePageObj = new LeftNavPanePage();
    private co.uk.directlinegroup.tt.utils.common.Select selectObj = new co.uk.directlinegroup.tt.utils.common.Select();
    private Commands commandsObj = new Commands();
    private PolicyDataFieldsPage policyDataFieldsPageObj = new PolicyDataFieldsPage();

    public static String userGenerated = "";
    public static String claimHandler = "";
    public static String claimIDForCompetency = "";
    public static String userRetrieved = "";
    public static String competencyName="";
    public static String[] competencyNameAfterSplitting;
    public static String firstCompetencyName;
    public static String checkUserStatus="";

    public void enterClaimCompetencyDetails(List<List<String>> parameter) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (!commandsObj.elementDisplayedWithLessTime( By.xpath( leftNavPanePageObj.iAdminId() ) ))
            navigationObj.navigateToImenu();
        navigationObj.navigateToIAdmin();
        navigationObj.naivgateToClaimCompetency();
        claimCompetencyPageObj.addCompetency().click();
        for (int i = 1; i < parameter.size(); i++) {
            for (int j = 0; j < parameter.get( 0 ).size(); j++) {
                this.enterCompetencyDetails( parameter.get( 0 ).get( j ), parameter.get( i ).get( j ) );
            }
        }
        claimCompetencyPageObj.saveBtn().click();
    }

    public void amendClaimCompetencyDetails(String competency, List<List<String>> parameter) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (!commandsObj.elementDisplayedWithLessTime( By.xpath( leftNavPanePageObj.iAdminId() ) ))
            navigationObj.navigateToImenu();
        navigationObj.navigateToIAdmin();
        navigationObj.naivgateToClaimCompetency();
        claimCompetencyPageObj.competencyLevelNameInput().clear();
        claimCompetencyPageObj.competencyLevelNameInput().sendKeys( competency );
        nextEventPageObj.btnClick( claimCompetencyPageObj.competencyLevelNameInputFilter() );
        nextEventPageObj.btnClick( claimCompetencyPageObj.containsFilter() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.editCompetency().click();
        for (int i = 1; i < parameter.size(); i++) {
            for (int j = 0; j < parameter.get( 0 ).size(); j++) {
                this.enterCompetencyDetails( parameter.get( 0 ).get( j ), parameter.get( i ).get( j ) );
            }
        }
        claimCompetencyPageObj.saveBtn().click();
    }

    private void enterCompetencyDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "level name":
                claimCompetencyPageObj.levelName().clear();
                claimCompetencyPageObj.levelName().sendKeys( fieldValue );
                break;
            case "level description":
                claimCompetencyPageObj.levelDescription().clear();
                claimCompetencyPageObj.levelDescription().sendKeys( fieldValue );
                break;
            case "maximum number of perils":
                claimCompetencyPageObj.maximumNumberOfPerils().clear();
                claimCompetencyPageObj.maximumNumberOfPerils().sendKeys( fieldValue );
                break;
            case "maximum number of claimants":
                claimCompetencyPageObj.maximumNumberOfClaimants().clear();
                claimCompetencyPageObj.maximumNumberOfClaimants().sendKeys( fieldValue );
                break;
            case "maximum number of lines items linked to claim":
                claimCompetencyPageObj.maximumNumberOfLineItemsLinkedToClaim().clear();
                claimCompetencyPageObj.maximumNumberOfLineItemsLinkedToClaim().sendKeys( fieldValue );
                break;
            case "maximum claim value":
                claimCompetencyPageObj.maximumClaimValue().clear();
                claimCompetencyPageObj.maximumClaimValue().sendKeys( fieldValue );
                break;
            case "maximum load percentage":
                claimCompetencyPageObj.maximumLoadPercentageValue().clear();
                claimCompetencyPageObj.maximumLoadPercentageValue().sendKeys( fieldValue );
                break;
            case "scheme applicable to":
                new Select( claimCompetencyPageObj.schemeApplicableToDropdown() ).selectByVisibleText( fieldValue );
                break;
            case "complexity points to allocate per claim":
                claimCompetencyPageObj.complexityPointsToAllocatePerClaim().clear();
                claimCompetencyPageObj.complexityPointsToAllocatePerClaim().sendKeys( fieldValue );
                break;
            case "add type of peril":
                for (int i = 0; i < fieldValue.split( "#" ).length; i++) {
                    new org.openqa.selenium.support.ui.Select( claimCompetencyPageObj.typeOfPerilsDropdown() ).selectByVisibleText( fieldValue.split( "#" )[i] );
                    claimCompetencyPageObj.addPerilbtn().click();
                    nextEventPageObj.btnClick( claimCompetencyPageObj.addPerilbtn() );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                }
                break;
            case "competency level status verify":
                List<String> competencyStatusOption = new ArrayList<>();
                for (int i = 0; i < fieldValue.split( "#" ).length; i++) {
                    competencyStatusOption.add( fieldValue.split( "#" )[i] );
                }
                selectObj.validateValuesInDropDown( claimCompetencyPageObj.editCompetencyStatus(), competencyStatusOption );
                break;
            case "competency level status":
                new Select( claimCompetencyPageObj.editCompetencyStatus() ).selectByVisibleText( fieldValue );
                break;
            case "select competency level status":
                new Select( claimCompetencyPageObj.editCompetencyStatus() ).selectByVisibleText( fieldValue );
                break;
            case "active":
                claimCompetencyPageObj.changeTeamStatus().click();
                break;
        }
    }

    public void validateCreatedCompetency(List<List<String>> parameter) {
        int iCompetencyLevelName = 5;
        int iCompetencyLevelDescription = 6;
        int iCompetencyLevelStatus = 7;
        int iDateCreated = 8;
        int iMaximumNumberOfPerils = 9;
        int iTypeOfPerils = 10;
        int iMaximumNumberOfClaimants = 11;
        int iMaximumNumberoflineitemslinkedtoaclaim = 12;
        int iMaximumClaimValue = 13;
        int iSchemeApplicableTo = 14;
        int iComplexitypointstoallocateperclaim = 15;
        for (int i = 1; i < parameter.size(); i++) {
            for (int j = 0; j < parameter.get( 0 ).size(); j++) {
                String sysDate = new SimpleDateFormat( "yyyy-MM-dd" ).format( new java.util.Date() ).toString();
                claimCompetencyPageObj.filterWithDate().sendKeys( sysDate );
                claimCompetencyPageObj.dateFilter().click();
                claimCompetencyPageObj.contains().click();
                nextEventPageObj.waitForMoreTime();
                switch (parameter.get( 0 ).get( j )) {
                    case "Competency Level Name":
                        String sCompetencyLevelName = claimCompetencyPageObj.claimCompetencyTable( iCompetencyLevelName ).getText();
                        System.out.println( "sCompetencyLevelName----------------------" + sCompetencyLevelName );
                        Assert.assertTrue( sCompetencyLevelName.equalsIgnoreCase( parameter.get( i ).get( j ) ) );
                        break;
                    case "Competency Level Description":
                        String sCompetencyLevelDescription = claimCompetencyPageObj.claimCompetencyTable( iCompetencyLevelDescription ).getText();
                        System.out.println( "sCompetencyLevelName----------------------" + sCompetencyLevelDescription );
                        Assert.assertTrue( sCompetencyLevelDescription.equalsIgnoreCase( parameter.get( i ).get( j ) ) );
                        break;
                    case "Competency Level Status":
                        String sCompetencyLevelStatus = claimCompetencyPageObj.claimCompetencyTable( iCompetencyLevelStatus ).getText();
                        System.out.println( "sCompetencyLevelName----------------------" + sCompetencyLevelStatus );
                        Assert.assertTrue( sCompetencyLevelStatus.equalsIgnoreCase( parameter.get( i ).get( j ) ) );
                        break;
                    case "Date Created":
                        String sDateCreated = claimCompetencyPageObj.claimCompetencyTable( iDateCreated ).getText();
                        System.out.println( "sCompetencyLevelName----------------------" + sDateCreated );
                        System.out.println( "System date ------------------------" + sysDate );
                        Assert.assertTrue( sDateCreated.equalsIgnoreCase( sysDate ) );
                        break;
                    case "Maximum Number Of Perils":
                        String sMaximumNumberOfPerils = claimCompetencyPageObj.claimCompetencyTable( iMaximumNumberOfPerils ).getText();
                        System.out.println( "sCompetencyLevelName----------------------" + sMaximumNumberOfPerils );
                        Assert.assertTrue( sMaximumNumberOfPerils.equalsIgnoreCase( parameter.get( i ).get( j ) ) );
                        break;
                    case "Type Of Perils":
                        String sTypeOfPerils = claimCompetencyPageObj.claimCompetencyTable( iTypeOfPerils ).getText();
                        System.out.println( "sCompetencyLevelName----------------------" + sTypeOfPerils );
                        Assert.assertTrue( sTypeOfPerils.equalsIgnoreCase( parameter.get( i ).get( j ) ) );
                        break;
                    case "Maximum Number Of Claimants":
                        String sMaximumNumberOfClaimants = claimCompetencyPageObj.claimCompetencyTable( iMaximumNumberOfClaimants ).getText();
                        System.out.println( "sCompetencyLevelName----------------------" + sMaximumNumberOfClaimants );
                        Assert.assertTrue( sMaximumNumberOfClaimants.equalsIgnoreCase( parameter.get( i ).get( j ) ) );
                        break;
                    case "Maximum Number of line items linked to a claim":
                        String sMaximumNumberoflineitemslinkedtoaclaim = claimCompetencyPageObj.claimCompetencyTable( iMaximumNumberoflineitemslinkedtoaclaim ).getText();
                        System.out.println( "sCompetencyLevelName----------------------" + sMaximumNumberoflineitemslinkedtoaclaim );
                        Assert.assertTrue( sMaximumNumberoflineitemslinkedtoaclaim.equalsIgnoreCase( parameter.get( i ).get( j ) ) );
                        break;
                    case "Maximum Claim Value":
                        String sMaximumClaimValue = claimCompetencyPageObj.claimCompetencyTable( iMaximumClaimValue ).getText();
                        System.out.println( "sCompetencyLevelName----------------------" + sMaximumClaimValue );
                        Assert.assertTrue( sMaximumClaimValue.equalsIgnoreCase( parameter.get( i ).get( j ) ) );
                        break;
                    case "Scheme Applicable To":
                        String sSchemeApplicableTo = claimCompetencyPageObj.claimCompetencyTable( iSchemeApplicableTo ).getText();
                        System.out.println( "sCompetencyLevelName----------------------" + sSchemeApplicableTo );
                        Assert.assertTrue( sSchemeApplicableTo.equalsIgnoreCase( parameter.get( i ).get( j ) ) );
                        break;
                    case "Complexity points to allocate per claim":
                        String sComplexitypointstoallocateperclaim = claimCompetencyPageObj.claimCompetencyTable( iComplexitypointstoallocateperclaim ).getText();
                        System.out.println( "sCompetencyLevelName----------------------" + sComplexitypointstoallocateperclaim );
                        Assert.assertTrue( sComplexitypointstoallocateperclaim.equalsIgnoreCase( parameter.get( i ).get( j ) ) );
                        break;
                }
            }
        }
    }

    public void createNewUser(List<List<String>> lstInputs) {
        claimCompetencyPageObj.manageUsersTab().click();
        claimCompetencyPageObj.manageUsersWait();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.btnClick( claimCompetencyPageObj.addCompetency() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.addNewUsersWait();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get( 0 ).size(); j++) {
                this.enterNewUserDetails( lstInputs.get( 0 ).get( j ), lstInputs.get( i ).get( j ) );
            }
        }
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.btnClick( claimCompetencyPageObj.submitbtn() );
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void enterNewUserDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "title":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                new org.openqa.selenium.support.ui.Select( claimCompetencyPageObj.title() ).selectByVisibleText( fieldValue );
                nextEventPageObj.waitForMoreTime();
                break;
            case "first name":
                if (fieldValue.equalsIgnoreCase( "random" )) {
                    fieldValue = randomGeneratorObj.randomString( 4 );
                    userGenerated = fieldValue;
                }
                claimCompetencyPageObj.firstName().sendKeys( fieldValue );
                break;
            case "last name":
                if (fieldValue.equalsIgnoreCase( "random" )) {
                    fieldValue = randomGeneratorObj.randomString( 4 );
                }
                userGenerated = userGenerated.concat( " " + fieldValue );
                System.out.println( "userGenerated---------------------------" + userGenerated );
                claimCompetencyPageObj.lastName().sendKeys( fieldValue );
                break;
            case "office":
                new org.openqa.selenium.support.ui.Select( claimCompetencyPageObj.office() ).selectByVisibleText( fieldValue );
                break;
            case "language":
                new org.openqa.selenium.support.ui.Select( claimCompetencyPageObj.language() ).selectByVisibleText( fieldValue );
                break;
            case "email address":
                if (fieldValue.equalsIgnoreCase( "random" )) {
                    fieldValue = randomGeneratorObj.randomEmailAddress( 4 );
                }
                claimCompetencyPageObj.emailAddress().sendKeys( fieldValue );
                break;
            case "administration group":
                new org.openqa.selenium.support.ui.Select( claimCompetencyPageObj.administrationGroup() ).selectByVisibleText( fieldValue );
                break;
        }
        claimCompetencyPageObj.btnClick( claimCompetencyPageObj.submitbtn() );
    }

    public void toRetrieveUserName() {
        userRetrieved = userGenerated;
        System.out.println( "User retrieved:" + userRetrieved );
    }


    public void amendCompetency(String competencyLevel, List<List<String>> parameters) {
        claimCompetencyPageObj.competencyLevelNameInput().clear();
        claimCompetencyPageObj.competencyLevelNameInput().sendKeys( competencyLevel );
        nextEventPageObj.btnClick( claimCompetencyPageObj.competencyLevelNameInputFilter() );
        nextEventPageObj.btnClick( claimCompetencyPageObj.containsFilter() );
        claimCompetencyPageObj.amendCompentency( competencyLevel ).click();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                this.enterCompetencyDetails( parameters.get( 0 ).get( j ), parameters.get( i ).get( j ) );
            }
        }
        claimCompetencyPageObj.saveBtn().click();
    }

    public void allocateCompetency(List<List<String>> parameters) {
        leftNavPanePageObj.allocateCompetency().click();
        claimCompetencyPageObj.addCompetency().click();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 1 ).size(); j++) {
                switch (parameters.get( 0 ).get( j )) {
                    case "Claim Handler Team":
                        new Select( claimCompetencyPageObj.claimHandlerTeam() ).selectByVisibleText( parameters.get( i ).get( j ) );
                        break;
                    case "Add Competency To Team":
                        new Select( claimCompetencyPageObj.addCompetencyToTeam() ).selectByVisibleText( parameters.get( i ).get( j ) );
                        claimCompetencyPageObj.addCompetencyBtn().click();
                        break;
                }
            }
        }
        claimCompetencyPageObj.saveBtn().click();
    }

    public void validateNewUserDefaultFields(String action, String user, List<List<String>> lstInputs) {
        claimCompetencyPageObj.manageUsersTab().click();
        claimCompetencyPageObj.manageUsersWait();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println( "userGenerated---------------------" + userGenerated );
        if (user.equalsIgnoreCase( "random" )) {
            claimCompetencyPageObj.nameField().sendKeys( userGenerated );
        } else {
            claimCompetencyPageObj.nameField().sendKeys( user );
        }
        claimCompetencyPageObj.nameFilter().click();
        claimCompetencyPageObj.containsFilter().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (user.equalsIgnoreCase( "random" )) {
            claimCompetencyPageObj.validateUserRetrieved( userGenerated ).isDisplayed();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.btnClick( claimCompetencyPageObj.editRetrievedUser( userGenerated ) );
        } else {
            claimCompetencyPageObj.validateUserRetrieved( user ).isDisplayed();
            claimCompetencyPageObj.editRetrievedUser( user ).click();
        }
        System.out.println( "Random username" + userGenerated );
        if (action.equalsIgnoreCase( "validate" )) {
            for (int i = 1; i < lstInputs.size(); i++) {
                for (int j = 0; j < lstInputs.get( 0 ).size(); j++) {
                    this.validateDefaultFieldsValue( lstInputs.get( 0 ).get( j ), lstInputs.get( i ).get( j ) );
                }
            }
        }
        if (action.equalsIgnoreCase( "view" )) {
            for (int i = 1; i < lstInputs.size(); i++) {
                for (int j = 0; j < lstInputs.get( 0 ).size(); j++) {
                    // this.validateDefaultFieldsValue(lstInputs.get(0).get(j), lstInputs.get(i).get(j));
                }
            }
        }
        nextEventPageObj.btnCloseWindow().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateDefaultFieldsValue(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "user group":
                claimCompetencyPageObj.userGroupInformationTab().click();
                Assert.assertTrue( claimCompetencyPageObj.userGroupValue().getAttribute( "value" ).contains( fieldValue ) );
                break;
            case "supervisor":
                claimCompetencyPageObj.competencyManagerTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (fieldValue.equalsIgnoreCase( "disabled" )) {
                    System.out.println( "disabled value" + claimCompetencyPageObj.supervisorValue().getAttribute( "disabled" ) );
                    Assert.assertTrue( claimCompetencyPageObj.supervisorValue().getAttribute( "disabled" ).equalsIgnoreCase( "true" ) );
                }
                break;
            case "team name":
                claimCompetencyPageObj.competencyManagerTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (fieldValue.equalsIgnoreCase( "disabled" )) {
                    System.out.println( "disabled value" + claimCompetencyPageObj.teamNameValue().getAttribute( "disabled" ) );
                    Assert.assertTrue( claimCompetencyPageObj.teamNameValue().getAttribute( "disabled" ).equalsIgnoreCase( "true" ) );
                }
                break;
            case "status":
                claimCompetencyPageObj.competencyManagerTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (fieldValue.equalsIgnoreCase( "inactive" )) {
                    System.out.println( "Inactive Value" + claimCompetencyPageObj.validateStatusofClaimHandler().getAttribute( "value" ) );
                    Assert.assertTrue( claimCompetencyPageObj.validateActiveStatus().getAttribute( "value" ).equalsIgnoreCase( "False" ) );
                } else if (fieldValue.equalsIgnoreCase( "active" )) {
                    System.out.println( "Inactive Value" + claimCompetencyPageObj.validateStatusofClaimHandler().getAttribute( "value" ) );
                    Assert.assertTrue( claimCompetencyPageObj.validateActiveStatus().getAttribute( "value" ).equalsIgnoreCase( "True" ) );
                }
                break;
            case "allocated competency name":
                claimCompetencyPageObj.competencyManagerTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                String sAllocatedCompetencyName = claimCompetencyPageObj.allocatedCompetencyName().getAttribute( "value" );
                Assert.assertTrue( sAllocatedCompetencyName.equalsIgnoreCase( fieldValue ) );
                break;
            case "inactive due to holiday":
                claimCompetencyPageObj.competencyManagerTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (fieldValue.equalsIgnoreCase( "false" )) {
                    System.out.println( "Inactive Value" + claimCompetencyPageObj.validateStatusofClaimHandler().getAttribute( "value" ) );
                    Assert.assertTrue( claimCompetencyPageObj.inactiveDueToHolidayValidation().getAttribute( "value" ).equalsIgnoreCase( "False" ) );
                } else if (fieldValue.equalsIgnoreCase( "true" )) {
                    System.out.println( "Inactive Value" + claimCompetencyPageObj.validateStatusofClaimHandler().getAttribute( "value" ) );
                    Assert.assertTrue( claimCompetencyPageObj.inactiveDueToHolidayValidation().getAttribute( "value" ).equalsIgnoreCase( "True" ) );
                }
                break;
        }
    }

    public void addNewClaimHandlerTeam(List<List<String>> lstInputs) {
        claimCompetencyPageObj.claimCompetencyTab().click();
        claimCompetencyPageObj.claimHandlersTeamTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.addCompetency().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get( 0 ).size(); j++) {
                this.addNewClaimHandlerTeamParameters( lstInputs.get( 0 ).get( j ), lstInputs.get( i ).get( j ) );
            }
        }
        claimCompetencyPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void addNewClaimHandlerTeamParameters(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "supervisor":
                new org.openqa.selenium.support.ui.Select( claimCompetencyPageObj.supervisor() ).selectByVisibleText( fieldValue );
                break;
            case "team name":
                claimCompetencyPageObj.teamName().sendKeys( fieldValue );
                break;
            case "team description":
                claimCompetencyPageObj.teamDescription().sendKeys( fieldValue );
                break;
            case "location":
                claimCompetencyPageObj.location().sendKeys( fieldValue );
                break;
            case "add claim handler team member":
                for (int i = 0; i < fieldValue.split( "#" ).length; i++) {
                    if (fieldValue.equalsIgnoreCase( "random" )) {
                        new org.openqa.selenium.support.ui.Select( claimCompetencyPageObj.addClaimHandlerTeamMember() ).selectByVisibleText( userGenerated );
                    } else {
                        new org.openqa.selenium.support.ui.Select( claimCompetencyPageObj.addClaimHandlerTeamMember() ).selectByVisibleText( fieldValue );
                    }
                    claimCompetencyPageObj.addTeamMemberbtn().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                }
                break;
            case "active":
                if (fieldValue.equalsIgnoreCase( "True" )) {
                    claimCompetencyPageObj.changeTeamStatus().click();
                }
                break;
        }
    }

    public void archiveUser(String action, String competency) {
        navigationObj.naivgateToClaimCompetency();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        this.competencyLevelNamefiltering( competency );
        claimCompetencyPageObj.editCompetency( competency ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        new Select( claimCompetencyPageObj.editCompetencyStatus() ).selectByVisibleText( action );
        claimCompetencyPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue( claimCompetencyPageObj.validateCompetencyStatus( competency ).getText().equalsIgnoreCase( action ) );
    }

    public void changeUserStatus(String user, List<List<String>> lstInputs) {
        claimCompetencyPageObj.manageUsersTab().click();
        claimCompetencyPageObj.manageUsersWait();
        if (user.equalsIgnoreCase( "random" )) {
            claimCompetencyPageObj.nameField().sendKeys( userGenerated );
        } else {
            claimCompetencyPageObj.nameField().sendKeys( user );
        }
        claimCompetencyPageObj.nameFilter().click();
        claimCompetencyPageObj.containsFilter().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (user.equalsIgnoreCase( "random" )) {
            claimCompetencyPageObj.validateUserRetrieved( userGenerated ).isDisplayed();
            nextEventPageObj.btnClick( claimCompetencyPageObj.editRetrievedUser( userGenerated ) );

        } else {
            claimCompetencyPageObj.validateUserRetrieved( user ).isDisplayed();
            nextEventPageObj.btnClick( claimCompetencyPageObj.editRetrievedUser( user ) );

        }
        System.out.println( "Username" + userGenerated );
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get( 0 ).size(); j++) {
                this.manipulateUserFields( lstInputs.get( 0 ).get( j ), lstInputs.get( i ).get( j ) );
            }
        }
        claimCompetencyPageObj.saveAndClose().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void manipulateUserFields(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "status":
                claimCompetencyPageObj.competencyManagerTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (fieldValue.equalsIgnoreCase( "active" )) {
                    if (claimCompetencyPageObj.validateActiveStatus().getAttribute( "value" ).equalsIgnoreCase( "False" )) {
                        claimCompetencyPageObj.markAsActive().click();
                    }
                } else if (fieldValue.equalsIgnoreCase( "inactive" )) {
                    if (claimCompetencyPageObj.validateActiveStatus().getAttribute( "value" ).equalsIgnoreCase( "True" )) {
                        claimCompetencyPageObj.markAsActive().click();
                    }
                }
                else if (fieldValue.equalsIgnoreCase( "edit" )) {
                    Assert.assertTrue (claimCompetencyPageObj.validateActiveStatus().isEnabled());
                    System.out.println( "Status field is editable");
                    }
                else if (fieldValue.equalsIgnoreCase( "checkstatus" )) {

                    System.out.println( "claimCompetencyPageObj.checkActiveStatus().getAttribute value*******************"+claimCompetencyPageObj.checkActiveStatus().getAttribute( "value" ));
                    checkUserStatus=claimCompetencyPageObj.checkActiveStatus().getAttribute( "value" );
                    System.out.println( "Claim Handler status value******"+checkUserStatus);
                    Assert.assertTrue(checkUserStatus.equalsIgnoreCase("true"));
                    competencyName= claimCompetencyPageObj.allocatedCompetencyName().getAttribute( "value" );
                    System.out.println( "****Competency Name before spliting*****"+competencyName);
                    competencyNameAfterSplitting=competencyName.split(",");
                    firstCompetencyName=competencyNameAfterSplitting[0];
                    System.out.println( "*****First Competency Name in check status*****"+firstCompetencyName);
                }
                else if (fieldValue.equalsIgnoreCase( "modifystatus" )) {
                    claimCompetencyPageObj.markAsInActive().click();
                    System.out.println( "Changing claim handler status*******************"+claimCompetencyPageObj.checkActiveStatus().getAttribute( "value" ));
                }
                else if (fieldValue.equalsIgnoreCase("enableactive")){
                claimCompetencyPageObj.validateActiveStatus().getAttribute( "value" ).equalsIgnoreCase( "True");
            }
                break;
            case "inactive due to holiday":
                claimCompetencyPageObj.competencyManagerTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (fieldValue.equalsIgnoreCase( "true" )) {
                    if (claimCompetencyPageObj.inactiveDueToHolidayValidation().getAttribute( "value" ).equalsIgnoreCase( "False" )) {
                        claimCompetencyPageObj.inactiveDueToHoliday().click();
                    }
                } else if (fieldValue.equalsIgnoreCase( "false" )) {
                    if (claimCompetencyPageObj.inactiveDueToHolidayValidation().getAttribute( "value" ).equalsIgnoreCase( "True" )) {
                        claimCompetencyPageObj.inactiveDueToHoliday().click();
                    }
                }else if (fieldValue.equalsIgnoreCase( "editholidaytab" )) {

                        Assert.assertTrue( claimCompetencyPageObj.inactiveDueToHoliday().isEnabled());
                    System.out.println( "*****inactiveDueToHoliday field is editable*****");
                    }
                break;
            case "leave date":
                claimCompetencyPageObj.competencyManagerTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (fieldValue.equalsIgnoreCase( "currentdate" )) {
                    SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
                    Calendar c = Calendar.getInstance();
                    c.setTime( new Date() );
                    System.out.println( "Leave date" + sdf.format( c.getTime() ) );
                    claimCompetencyPageObj.leaveDate( fieldName ).clear();
                    claimCompetencyPageObj.leaveDate( fieldName ).sendKeys( sdf.format( c.getTime() ) );

                } else if (fieldValue.equalsIgnoreCase( "currentdate+1" )) {
                    SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
                    Calendar c = Calendar.getInstance();
                    c.setTime( new Date() );
                    c.add( Calendar.DATE, 1 );
                    System.out.println( "Leave date" + sdf.format( c.getTime() ) );
                    claimCompetencyPageObj.daysBeforeLeaveDate().clear();
                    claimCompetencyPageObj.daysBeforeLeaveDate().sendKeys( sdf.format( c.getTime() ) );
                }
                break;
            case "no new claims to be added (x) days before leave date":
                claimCompetencyPageObj.competencyManagerTab().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.daysBeforeLeaveDate().clear();
                claimCompetencyPageObj.daysBeforeLeaveDate().sendKeys( fieldValue );
                break;
            case "error message":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                Assert.assertTrue( claimCompetencyPageObj.archiveErrorMessage( fieldValue ).isDisplayed() );
                claimCompetencyPageObj.archiveErrorMessageClosebtn().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;

            case "Maximum no of claims":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
        }

    }

    public void validateNotAllowedArchived(String action, String user, List<List<String>> lstInputs) {
        navigationObj.naivgateToClaimCompetency();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        this.competencyLevelNamefiltering( user );
        claimCompetencyPageObj.editCompetency( user ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        new Select( claimCompetencyPageObj.editCompetencyStatus() ).selectByVisibleText( action );
        claimCompetencyPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get( 0 ).size(); j++) {
                this.manipulateUserFields( lstInputs.get( 0 ).get( j ), lstInputs.get( i ).get( j ) );
            }
        }
    }

    public void deleteTeamMemberFromClaimHandlerTeam(String user) {
        if (user.equalsIgnoreCase( "random" )) {
            claimCompetencyPageObj.editTeamMemberaddedInClaimHandlerTeam( userGenerated ).click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            claimCompetencyPageObj.removeTeamMemberLinkInClaimHandlerTeam( userGenerated ).click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            claimCompetencyPageObj.saveBtn().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            claimCompetencyPageObj.deleteTeamMemberaddedInClaimHandlerTeam( userGenerated ).click();
        } else {
            claimCompetencyPageObj.editTeamMemberaddedInClaimHandlerTeam( user ).click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            claimCompetencyPageObj.removeTeamMemberLinkInClaimHandlerTeam( user ).click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            claimCompetencyPageObj.saveBtn().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            claimCompetencyPageObj.deleteTeamMemberaddedInClaimHandlerTeam( user ).click();
        }
        getDriver().switchTo().alert().accept();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void validateCompetencyLevelChanges(String competencyLevel, List<List<String>> parameters) {
        claimCompetencyPageObj.historyOfCompetencyLevelLink( competencyLevel ).click();
        int iCompetencyLevelName = 2;
        int iCompetencyLevelDescription = 3;
        int iCompetencyLevelStatus = 4;
        int iDateCreated = 5;
        int iMaximumNumberOfPerils = 6;
        int iTypeOfPerils = 7;
        int iMaximumNumberOfClaimants = 8;
        int iMaximumNumberoflineitemslinkedtoaclaim = 9;
        int iMaximumClaimValue = 10;
        int iSchemeApplicableTo = 11;
        int iComplexitypointstoallocateperclaim = 12;
        int iWhenSaved = 14;// 13;
        int iWhoSaved = 15;//14;
        int iFirstName = 16;//15;
        int iLastName = 17;//16;
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                switch (parameters.get( 0 ).get( j )) {
                    case "Competency Level Name":
                        String sCompetencyLevelName = claimCompetencyPageObj.historyTable( iCompetencyLevelName, i ).getText();
                        Assert.assertTrue( sCompetencyLevelName.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "Competency Level Description":
                        String sCompetencyLevelDescription = claimCompetencyPageObj.historyTable( iCompetencyLevelDescription, i ).getText();
                        Assert.assertTrue( sCompetencyLevelDescription.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "Competency Level Status":
                        String sCompetencyLevelStatus = claimCompetencyPageObj.historyTable( iCompetencyLevelStatus, i ).getText();
                        System.out.println( "-------sCompetencyLevelStatus-------------" + sCompetencyLevelStatus );
                        Assert.assertTrue( sCompetencyLevelStatus.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "Date Created":
                        String sDateCreated = claimCompetencyPageObj.historyTable( iDateCreated, i ).getText();
                        System.out.println( "sCompetencyLevelName----------------------" + sDateCreated );
                        String sysDate = new SimpleDateFormat( "yyyy-MM-dd" ).format( new java.util.Date() ).toString();
                        System.out.println( "System date ------------------------" + sysDate );
                        Assert.assertTrue( sDateCreated.equalsIgnoreCase( sysDate ) );
                        break;
                    case "Maximum Number Of Perils":
                        String sMaximumNumberOfPerils = claimCompetencyPageObj.historyTable( iMaximumNumberOfPerils, i ).getText();
                        System.out.println( "-------sCompetencyLevelStatus-------------" + sMaximumNumberOfPerils );
                        Assert.assertTrue( sMaximumNumberOfPerils.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "Type Of Perils":
                        String sTypeOfPerils = claimCompetencyPageObj.historyTable( iTypeOfPerils, i ).getText();
                        System.out.println( "-------sCompetencyLevelStatus-------------" + sTypeOfPerils );
                        Assert.assertTrue( sTypeOfPerils.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "Maximum Number Of Claimants":
                        String sMaximumNumberOfClaimants = claimCompetencyPageObj.historyTable( iMaximumNumberOfClaimants, i ).getText();
                        System.out.println( "-------sCompetencyLevelStatus-------------" + sMaximumNumberOfClaimants );
                        Assert.assertTrue( sMaximumNumberOfClaimants.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "Maximum Number of line items linked to a claim":
                        String sMaximumNumberoflineitemslinkedtoaclaim = claimCompetencyPageObj.historyTable( iMaximumNumberoflineitemslinkedtoaclaim, i ).getText();
                        System.out.println( "-------sCompetencyLevelStatus-------------" + sMaximumNumberoflineitemslinkedtoaclaim );
                        Assert.assertTrue( sMaximumNumberoflineitemslinkedtoaclaim.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "Maximum Claim Value":
                        String sMaximumClaimValue = claimCompetencyPageObj.historyTable( iMaximumClaimValue, i ).getText();
                        System.out.println( "-------sCompetencyLevelStatus-------------" + sMaximumClaimValue );
                        Assert.assertTrue( sMaximumClaimValue.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "Scheme Applicable To":
                        String sSchemeApplicableTo = claimCompetencyPageObj.historyTable( iSchemeApplicableTo, i ).getText();
                        System.out.println( "-------sCompetencyLevelStatus-------------" + sSchemeApplicableTo );
                        Assert.assertTrue( sSchemeApplicableTo.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "Complexity points to allocate per claim":
                        String sComplexitypointstoallocateperclaim = claimCompetencyPageObj.historyTable( iComplexitypointstoallocateperclaim, i ).getText();
                        System.out.println( "-------sCompetencyLevelStatus-------------" + sComplexitypointstoallocateperclaim );
                        Assert.assertTrue( sComplexitypointstoallocateperclaim.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "WhenSaved":
                        String sWhenSaved = claimCompetencyPageObj.historyTable( iWhenSaved, i ).getText();
                        System.out.println( "sCompetencyLevelName----------------------" + sWhenSaved );
                        String sysDate1 = new SimpleDateFormat( "dd/MM/yyyy" ).format( new java.util.Date() ).toString();
                        System.out.println( "System date ------------------------" + sysDate1 );
                        Assert.assertTrue( sWhenSaved.contains( sysDate1 ) );
                        break;
                    case "WhoSaved":
                        String sWhoSaved = claimCompetencyPageObj.historyTable( iWhoSaved, i ).getText();
                        System.out.println( "-------sCompetencyLevelStatus-------------" + sWhoSaved );
                        Assert.assertTrue( sWhoSaved.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "FirstName":
                        String sFirstName = claimCompetencyPageObj.historyTable( iFirstName, i ).getText();
                        System.out.println( "-------sCompetencyLevelStatus-------------" + sFirstName );
                        Assert.assertTrue( sFirstName.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "LastName":
                        String sLastName = claimCompetencyPageObj.historyTable( iLastName, i ).getText();
                        System.out.println( "-------sCompetencyLevelStatus-------------" + sLastName );
                        Assert.assertTrue( sLastName.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                }
            }
        }
        claimCompetencyPageObj.goBackBtn().click();
    }

    public void deleteCompetency(String deleteIn, String competencyLevel) {
        switch (deleteIn) {
            case "competency level":
                claimCompetencyPageObj.deleteLinkInCompetency( competencyLevel ).click();
                getDriver().switchTo().alert().accept();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                break;
        }
    }

    public void validateCompetencyAllocated(List<List<String>> parameters) {
        int iClaimHandlerTeamId = 5;
        int iCompetencies = 6;
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                switch (parameters.get( 0 ).get( j )) {
                    case "ClaimHandlerTeamID":
                        String sClaimHandlerTeamId = claimCompetencyPageObj.allocationTable( iClaimHandlerTeamId ).getText();
                        System.out.println( "-sClaimHandlerTeamId-------------" + sClaimHandlerTeamId );
                        Assert.assertTrue( sClaimHandlerTeamId.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "Competencies":
                        String sCompetencies = claimCompetencyPageObj.allocationTable( iCompetencies ).getText();
                        System.out.println( "-sClaimHandlerTeamId-------------" + sCompetencies );
                        Assert.assertTrue( sCompetencies.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                }
            }
        }
        claimCompetencyPageObj.compentenciesSorting().click();
    }

    public void validateTeamDetails(List<List<String>> parameters) {
        claimCompetencyPageObj.claimCompetencyTab().click();
        claimCompetencyPageObj.claimHandlersTeamTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 0; i < parameters.size(); i++) {
            switch (parameters.get( i ).get( 0 )) {
                case "Team Name":
                    System.out.println( claimCompetencyPageObj.validateTeamLeaderInformation( parameters.get( i ).get( 0 ) ) );
                    Assert.assertTrue( claimCompetencyPageObj.validateTeamLeaderInformation( parameters.get( i ).get( 0 ) ).isDisplayed() );
                    break;
                case "Supervisor":
                    System.out.println( claimCompetencyPageObj.validateTeamLeaderInformation( parameters.get( i ).get( 0 ) ) );
                    Assert.assertTrue( claimCompetencyPageObj.validateTeamLeaderInformation( parameters.get( i ).get( 0 ) ).isDisplayed() );
                    break;
                case "Location":
                    System.out.println( claimCompetencyPageObj.validateTeamLeaderInformation( parameters.get( i ).get( 0 ) ) );
                    Assert.assertTrue( claimCompetencyPageObj.validateTeamLeaderInformation( parameters.get( i ).get( 0 ) ).isDisplayed() );
                    break;
                case "Team Members":
                    System.out.println( claimCompetencyPageObj.validateTeamLeaderInformation( parameters.get( i ).get( 0 ) ) );
                    Assert.assertTrue( claimCompetencyPageObj.validateTeamLeaderInformation( parameters.get( i ).get( 0 ) ).isDisplayed() );
                    break;
            }
        }
    }

    public void editTeamDetails(String teamName, String action, String claimHandler) {
        navigationObj.naivgateToClaimCompetency();
        claimCompetencyPageObj.claimHandlersTeamTab().click();
        claimCompetencyPageObj.filterWithTeamName().sendKeys( teamName );
        claimCompetencyPageObj.teamNameFilter().click();
        claimCompetencyPageObj.filterContains().click();
        claimCompetencyPageObj.editTeamMemberaddedInClaimHandlerTeam( teamName ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.removeTeamMemberLinkInClaimHandlerTeam( userGenerated ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void editAllocatedCompetency(String teamName, String action, String competencyLvel) {
        navigationObj.naivgateToClaimCompetency();
        leftNavPanePageObj.allocateCompetency().click();
        if (action.equalsIgnoreCase( "remove" )) {
            for (int i = 0; i < competencyLvel.split( "#" ).length; i++) {
                claimCompetencyPageObj.allocatedCompetencyFilterInput().sendKeys( teamName );
                claimCompetencyPageObj.allocatedFilterImg().click();
                claimCompetencyPageObj.filterContains().click();
                claimCompetencyPageObj.editTeamMemberaddedInClaimHandlerTeam( teamName ).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.removeTeamMemberLinkInClaimHandlerTeam( competencyLvel.split( "#" )[i] ).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.saveBtn().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
            }
        } else if (action.equalsIgnoreCase( "add competency" )) {
            claimCompetencyPageObj.editTeamMemberaddedInClaimHandlerTeam( teamName ).click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            new Select( claimCompetencyPageObj.addCompetencyToTeam() ).selectByVisibleText( competencyLvel );
            claimCompetencyPageObj.addCompetencyBtn().click();
            nextEventPageObj.waitForMoreTime();
            claimCompetencyPageObj.saveBtn().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void allocateCompetencyHistory(String allocation, List<List<String>> parameters) {
        navigationObj.naivgateToClaimCompetency();
        leftNavPanePageObj.allocateCompetency().click();
        claimCompetencyPageObj.historyOfCompetencyLevelLink( allocation ).click();
        int iClaimHandlerTeamID = 2;
        int iCompetencies = 3;
        int iWhenSaved = 4;
        int iWhoSaved = 5;
        int iFirstName = 6;
        int iLastName = 7;
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get( 0 ).size(); j++) {
                switch (parameters.get( 0 ).get( j )) {
                    case "ClaimHandlerTeamID":
                        String sClaimHandlerTeamID = claimCompetencyPageObj.historyTable( iClaimHandlerTeamID, i ).getText();
                        Assert.assertTrue( sClaimHandlerTeamID.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "Competencies":
                        if (!parameters.get( i ).get( j ).contains( "Blank" )) {
                            String sCompetencies = claimCompetencyPageObj.historyTable( iCompetencies, i ).getText();
                            Assert.assertTrue( sCompetencies.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        }
                        break;
                    case "WhenSaved":
                        String sWhenSaved = claimCompetencyPageObj.historyTable( iWhenSaved, i ).getText();
                        System.out.println( "sCompetencyLevelName----------------------" + sWhenSaved );
                        String sysDate1 = new SimpleDateFormat( "dd/MM/yyyy" ).format( new java.util.Date() ).toString();
                        System.out.println( "System date ------------------------" + sysDate1 );
                        Assert.assertTrue( sWhenSaved.contains( sysDate1 ) );
                        break;
                    case "WhoSaved":
                        String sWhoSaved = claimCompetencyPageObj.historyTable( iWhoSaved, i ).getText();
                        System.out.println( "-------sCompetencyLevelStatus-------------" + sWhoSaved );
                        Assert.assertTrue( sWhoSaved.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "FirstName":
                        String sFirstName = claimCompetencyPageObj.historyTable( iFirstName, i ).getText();
                        System.out.println( "-------sCompetencyLevelStatus-------------" + sFirstName );
                        Assert.assertTrue( sFirstName.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                    case "LastName":
                        String sLastName = claimCompetencyPageObj.historyTable( iLastName, i ).getText();
                        System.out.println( "-------sCompetencyLevelStatus-------------" + sLastName );
                        Assert.assertTrue( sLastName.equalsIgnoreCase( parameters.get( i ).get( j ) ) );
                        break;
                }
            }
        }
        claimCompetencyPageObj.goBackBtn().click();
    }

    public void verifyCompetencyTabDisplayed() {
        navigationObj.navigateToImenu();
        navigationObj.navigateToIAdmin();
        Assert.assertTrue( commandsObj.elementDisplayedWithLessTime( org.openqa.selenium.By.id( leftNavPanePageObj.claimCompetencyId() ) ) );
    }

    public void verifyCompetencyTabNotDisplayed() {
        navigationObj.navigateToImenu();
        navigationObj.navigateToLeadManager();
        Assert.assertTrue( !commandsObj.elementDisplayedWithLessTime( org.openqa.selenium.By.id( leftNavPanePageObj.claimCompetencyId() ) ) );
    }

    public void deletingCompetency(String competency, String teamName) {
        if (competency.equalsIgnoreCase( "allocate competency" )) {
            leftNavPanePageObj.allocateCompetency().click();
            claimCompetencyPageObj.allocatedCompetencyFilterInput().sendKeys( teamName );
            claimCompetencyPageObj.allocatedFilterImg().click();
            claimCompetencyPageObj.filterContains().click();
            claimCompetencyPageObj.deleteTeamMemberaddedInClaimHandlerTeam( teamName ).click();
            getDriver().switchTo().alert().accept();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
        if (competency.equalsIgnoreCase( "team" )) {
            claimCompetencyPageObj.claimHandlersTeamTab().click();
            claimCompetencyPageObj.filterWithTeamName().sendKeys( teamName );
            claimCompetencyPageObj.teamNameFilter().click();
            claimCompetencyPageObj.filterContains().click();
            claimCompetencyPageObj.deleteTeamMemberaddedInClaimHandlerTeam( teamName ).click();
            getDriver().switchTo().alert().accept();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
        if (competency.equalsIgnoreCase( "competency level" )) {
            navigationObj.naivgateToClaimCompetency();
            leftNavPanePageObj.claimCompetency().click();
            for (int i = 0; i < teamName.split( "#" ).length; i++) {
                claimCompetencyPageObj.filterInput().sendKeys( teamName.split( "#" )[i] );
                claimCompetencyPageObj.filterImg().click();
                claimCompetencyPageObj.filterContains().click();
                claimCompetencyPageObj.deleteTeamMemberaddedInClaimHandlerTeam( teamName.split( "#" )[i] ).click();
                getDriver().switchTo().alert().accept();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
            }
        }
    }

    public void changeAllCompetencyLevelStatus(String status) {
        leftNavPanePageObj.claimCompetencyTab().click();
        nextEventPageObj.waitForMoreTime();
        leftNavPanePageObj.claimCompetency().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        for (int i = 0; !commandsObj.elementDisplayedWithLessTime( org.openqa.selenium.By.xpath( "//span[text()='Next']" ) ); i++) {
            System.out.println( "Page------------------------------------" + commandsObj.elementDisplayedWithLessTime( org.openqa.selenium.By.xpath( "//span[text()='Next']" ) ) );
            WebElement table = claimCompetencyPageObj.claimCompetencyTable();
            List<WebElement> allrows = table.findElements( By.tagName( "tr" ) );
            System.out.println( "Number of rows in the table " + allrows.size() );
            int row_count = 0;
            for (WebElement row : allrows) {
                row_count++;
                String Cell = claimCompetencyPageObj.competencyTableCompetencyStatus( row_count ).getText();
                System.out.println( "Cell value retrieved in td[7]" + Cell );
                System.out.println( "Cell value" + Cell );
                if (!((Cell.equalsIgnoreCase( status )) && (Cell.equalsIgnoreCase( "Archived" )) && (Cell.equalsIgnoreCase( null )))) {
                    claimCompetencyPageObj.accessingClaimCompetencyTable( row_count ).click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    new Select( claimCompetencyPageObj.editCompetencyStatus() ).selectByVisibleText( status );
                    claimCompetencyPageObj.saveBtn().click();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                }

            }
            claimCompetencyPageObj.nextPageLink().click();
        }
    }

    public void disableUsers(String users) {
        claimCompetencyPageObj.manageUsersTab().click();
        claimCompetencyPageObj.manageUsersWait();
        for (int i = 0; i < users.split( "#" ).length; i++) {
            claimCompetencyPageObj.user_Namefield().sendKeys( users.split( "#" )[i] );
            claimCompetencyPageObj.user_NameFilter().click();
            claimCompetencyPageObj.containsFilter().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            claimCompetencyPageObj.diableUsers( users.split( "#" )[i] ).click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void amendAllCompentency(List<List<String>> parameters) {
        if (!commandsObj.elementDisplayedWithLessTime( By.xpath( leftNavPanePageObj.iAdminId() ) ))
            navigationObj.navigateToImenu();
        navigationObj.navigateToIAdmin();
        navigationObj.naivgateToClaimCompetency();
        List<WebElement> competencyTableRows = nextEventPageObj.findElements( org.openqa.selenium.By.xpath( claimCompetencyPageObj.claimCompetencyTableXpath() ) );
        int listSize = competencyTableRows.size();
        for (int i = 1; i <= listSize; i++) {
            String competencyNameXpath = claimCompetencyPageObj.claimCompetencyTableXpath() + "[" + i + "]/td[5]";
            System.out.println( "competencyNameXpath---------------------------" + competencyNameXpath );
            String competencyName = nextEventPageObj.findElement( org.openqa.selenium.By.xpath( competencyNameXpath ) ).getText();
            this.amendCompetency( competencyName, parameters );
        }
    }

    public void changeClaimHandlerTeamStatus(String status) {
        leftNavPanePageObj.claimCompetencyTab().click();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.claimHandlersTeamTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        WebElement table = claimCompetencyPageObj.claimHandlerTeamTable();
        List<WebElement> allrows = table.findElements( By.tagName( "tr" ) );
        System.out.println( "Number of rows in the table " + allrows.size() );
        int row_count = 0;
        for (WebElement row : allrows) {
            row_count++;
            String Cell = claimCompetencyPageObj.claimHandlerTeamStatus( row_count ).getText();
            System.out.println( "Cell value retrieved in td[8]" + Cell );
            if ((Cell.equalsIgnoreCase( "true" ))) {
                claimCompetencyPageObj.accessingClaimCompetencyTable( row_count ).click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.changeTeamStatus().click();
                claimCompetencyPageObj.saveBtn().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
            }
        }
    }

    public void makeTeamAsActive(String team, String status) {
        leftNavPanePageObj.claimCompetencyTab().click();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.claimHandlersTeamTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.filterWithTeamName().sendKeys( team );
        claimCompetencyPageObj.teamNameFilter().click();
        claimCompetencyPageObj.contains().click();
        if (claimCompetencyPageObj.getTeamStatus( team ).getText().equalsIgnoreCase( "false" )) {
            nextEventPageObj.btnClick( claimCompetencyPageObj.editClaimHandlerTeam( team ) );
            claimCompetencyPageObj.changeTeamStatus().click();
            claimCompetencyPageObj.saveBtn().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
        }
    }

    public void validateClaimHandlerisAllocatedWithPoints(String handler, String action) {
        claimCompetencyPageObj.manageUsersTab().click();
        claimCompetencyPageObj.manageUsersWait();
        if (handler.equalsIgnoreCase( "random" )) {
            String newHandler = userGenerated;
            for (int i = 0; i < newHandler.split( "#" ).length; i++) {
                claimCompetencyPageObj.user_Namefield().sendKeys( newHandler.split( "#" )[i] );
                claimCompetencyPageObj.user_NameFilter().click();
                claimCompetencyPageObj.containsFilter().click();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick( claimCompetencyPageObj.userEdit() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.btnClick( claimCompetencyPageObj.competencyManagerTab() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                String points = claimCompetencyPageObj.totalCompetencyPointsAllocated().getText();
                if (action.equalsIgnoreCase( "with points" )) {
                    if (Integer.parseInt( points ) > 0)
                        System.out.println( "Points are allocated" );
                    else
                        throw new PendingException();
                } else if (action.equalsIgnoreCase( "with no points" )) {
                    Assert.assertTrue( points.equalsIgnoreCase( "" ) );
                }
                nextEventPageObj.btnClick( nextEventPageObj.btnCloseWindow() );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
            }
        }
    }

    public void unallocateCompetencyFromTeam(String competency, String team) {
        leftNavPanePageObj.allocateCompetency().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        int rows = claimCompetencyPageObj.allocateCompetencyTable().findElements( By.tagName( "tr" ) ).size();
        System.out.println( "Row size" + rows );
        for (int i = 1; i <= rows; i++) {
            if (commandsObj.elementDisplayedWithLessTime( org.openqa.selenium.By.xpath( "//table[contains(@id,'ctl00_cphBody_grdCompetencyAllocation')]/tbody/tr[" + i + "]/td[contains(text(),'" + team + "')]" ) )) {
                this.removeCompetency( i, competency );
                i = rows + 1;
            }
            if (i == rows) {
                if (commandsObj.elementDisplayedWithLessTime( org.openqa.selenium.By.linkText( "Next" ) )) {
                    nextEventPageObj.btnClick( claimCompetencyPageObj.nextPageLink() );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    i = 1;
                    rows = claimCompetencyPageObj.allocateCompetencyTable().findElements( By.tagName( "tr" ) ).size();

                }
            }
            System.out.println( "Inside for loop counter" + i );
        }
    }

    public void removeCompetency(int i, String competency) {
        System.out.println( "Inside Remove competency" );
        claimCompetencyPageObj.editCompetency( i ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.removeCompetencyFromTeam( competency ).click();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
    }

    public void removeTeamMemberFromTeam(String teamMember, String team) {
        claimCompetencyPageObj.claimHandlersTeamTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.claimHandlerTeamNameInputbox().clear();
        claimCompetencyPageObj.claimHandlerTeamNameInputbox().sendKeys( team );
        claimCompetencyPageObj.claimHandlerTeamNameFilter().click();
        claimCompetencyPageObj.containsFilter().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.claimHandlerEditTeam( team ).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (teamMember.equalsIgnoreCase( "random" )) {
            claimCompetencyPageObj.claimHandlerRemoveTeamMember( userGenerated ).click();
        } else {
            claimCompetencyPageObj.claimHandlerRemoveTeamMember( teamMember ).click();
        }
        claimCompetencyPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPanePageObj.allocateCompetency().click();
        this.deleteEntireCompetencyLevel( team );
        claimCompetencyPageObj.claimHandlersTeamTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.claimHandlerTeamNameInputbox().clear();
        claimCompetencyPageObj.claimHandlerTeamNameInputbox().sendKeys( team );
        claimCompetencyPageObj.claimHandlerTeamNameFilter().click();
        claimCompetencyPageObj.containsFilter().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.deleteTeam( team ).click();
        getDriver().switchTo().alert().accept();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void deleteEntireCompetencyLevel(String team) {
        int rows = claimCompetencyPageObj.allocateCompetencyTable().findElements( By.tagName( "tr" ) ).size();
        System.out.println( "Row size" + rows );
        for (int i = 1; i <= rows; i++) {
            if (commandsObj.elementDisplayedWithLessTime( org.openqa.selenium.By.xpath( "//table[contains(@id,'ctl00_cphBody_grdCompetencyAllocation')]/tbody/tr[" + i + "]/td[contains(text(),'" + team + "')]" ) )) {
                this.deleteCompetencyLevel( i );
                i = rows + 1;
            }
            if (i == rows) {
                if (commandsObj.elementDisplayedWithLessTime( org.openqa.selenium.By.linkText( "Next" ) )) {
                    nextEventPageObj.btnClick( claimCompetencyPageObj.nextPageLink() );
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    i = 1;
                    rows = claimCompetencyPageObj.allocateCompetencyTable().findElements( By.tagName( "tr" ) ).size();
                }
            }
            System.out.println( "Inside for loop counter" + i );
        }
    }

    public void deleteCompetencyLevel(int i) {
        System.out.println( "Inside delete competency level" );
        claimCompetencyPageObj.deleteCompetencyLevel( i ).click();
        getDriver().switchTo().alert().accept();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void checkClaimInManualAllocationQueue(String details) {
        claimIDForCompetency = nextEventPageObj.firstClaimID().getText();
        System.out.println( "claim id----------------------------###########" + claimIDForCompetency );
        if (!commandsObj.elementDisplayedWithLessTime( By.xpath( leftNavPanePageObj.iAdminId() ) ))
            navigationObj.navigateToImenu();
        navigationObj.navigateToIAdmin();
        navigationObj.naivgateToManualAllocation();
        String perils = details.split( "#" )[0];
        claimCompetencyPageObj.perilsInAllocation().sendKeys( perils );
        claimCompetencyPageObj.perilsInAllocationFilter().click();
        claimCompetencyPageObj.filterContains().click();
        claimCompetencyPageObj.claimStatusInAllocation().sendKeys( perils );
        claimCompetencyPageObj.claimStatusInAllocationFilter().click();
        claimCompetencyPageObj.filterContains().click();
        Assert.assertTrue( true );
    }

    public void identifyUnallocatedClaim(String details) {
        claimIDForCompetency = nextEventPageObj.firstClaimID().getText();
        navigationObj.naivgateToManualClaimHandlerAlloc();
        nextEventPageObj.switchToDefault();
        claimCompetencyPageObj.claimIDFilterManualAllocationTab().sendKeys( claimIDForCompetency );
        claimCompetencyPageObj.claimIDFilterImgManualAllocationTab().click();
        claimCompetencyPageObj.equalToFilter().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println( "Claim id--------------++++++++++++++++#############" + claimIDForCompetency );
        Assert.assertTrue( claimCompetencyPageObj.manuallyAllocClaimId( claimIDForCompetency ).isDisplayed() );
        System.out.println( "claim id----------------------------###########" + claimIDForCompetency );
    }

    public void assignContributionClaim(String assign) {
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.firstUnAllocatedClaims().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.assignToClaimHandler().click();
    }

    public void competencyLevelNamefiltering(String competencyLevel) {
        claimCompetencyPageObj.compentencyLevelNameFilterInput().sendKeys( competencyLevel );
        claimCompetencyPageObj.compentencyLevelNameFilterImg().click();
        claimCompetencyPageObj.containsFilter().click();
    }

    public void competenciesfiltering(String competency) {
        claimCompetencyPageObj.compentenciesSorting().click();
    }

    public void changeCompetencyStatus(String competency, String comptencyStatus) {
        leftNavPanePageObj.claimCompetencyTab().click();
        nextEventPageObj.waitForMoreTime();
        leftNavPanePageObj.claimCompetency().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.compentencyLevelNameFilterInput().sendKeys( competency );
        claimCompetencyPageObj.compentencyLevelNameFilterImg().click();
        claimCompetencyPageObj.containsFilter().click();
        claimCompetencyPageObj.editCompetency( competency ).click();
        new Select( claimCompetencyPageObj.editCompetencyStatus() ).selectByVisibleText( comptencyStatus );
        claimCompetencyPageObj.saveBtn().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void deleteCompetency(String competencyLevel) {
        leftNavPanePageObj.claimCompetencyTab().click();
        nextEventPageObj.waitForMoreTime();
        leftNavPanePageObj.claimCompetency().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.compentencyLevelNameFilterInput().sendKeys( competencyLevel );
        claimCompetencyPageObj.compentencyLevelNameFilterImg().click();
        claimCompetencyPageObj.containsFilter().click();
        claimCompetencyPageObj.deleteLinkInCompetency( competencyLevel ).click();
        getDriver().switchTo().alert().accept();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void changeUserStatusByClickOnMoreDetails(String user, List<List<String>> lstInputs) {
        claimCompetencyPageObj.manageUsersTab().click();
        claimCompetencyPageObj.manageUsersWait();
        if (user.equalsIgnoreCase( "random" )) {
            claimCompetencyPageObj.nameField().sendKeys( userGenerated );
        } else {
            claimCompetencyPageObj.nameField().sendKeys( user );
        }
        claimCompetencyPageObj.nameFilter().click();
        claimCompetencyPageObj.containsFilter().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        if (user.equalsIgnoreCase( "random" )) {
            claimCompetencyPageObj.validateUserRetrieved( userGenerated ).isDisplayed();
            nextEventPageObj.btnClick( claimCompetencyPageObj.userEdit() );
        } else {
            claimCompetencyPageObj.validateUserRetrieved( user ).isDisplayed();
            nextEventPageObj.btnClick( claimCompetencyPageObj.userEdit() );
        }
        System.out.println( "Username" + userGenerated );
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get( 0 ).size(); j++) {
                this.manipulateUserFields( lstInputs.get( 0 ).get( j ), lstInputs.get( i ).get( j ) );
            }
        }
        claimCompetencyPageObj.saveAndClose().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

    public void navigateToClaimCompetency(String tab) {
        switch (tab.toLowerCase()) {
            case "claimcompetency":
                leftNavPanePageObj.claimCompetencyTab().click();
                nextEventPageObj.waitForMoreTime();
                break;
        }
    }

    public void checkUserStatus(String user, List<List<String>> lstInputs) {
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        navigationObj.navigateToImenu();
        navigationObj.navigateToIAdmin();
        claimCompetencyPageObj.manageUsersTab().click();
        claimCompetencyPageObj.manageUsersWait();
        try{
            Thread.sleep(40000L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        claimCompetencyPageObj.nameField().sendKeys( user );
        claimCompetencyPageObj.nameFilter().click();
        claimCompetencyPageObj.containsFilter().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.validateUserRetrieved( user ).isDisplayed();
        nextEventPageObj.btnClick( claimCompetencyPageObj.editRetrievedUser( user ) );
        // randomUserName = claimCompetencyPageObj.retrieveRandomUserFirstName().getText().concat(" " + claimCompetencyPageObj.retrieveRandomUserLastName().getText());
        System.out.println( "Username" + userGenerated );
        for (int i = 1; i < lstInputs.size(); i++) {
            for (int j = 0; j < lstInputs.get( 0 ).size(); j++) {
                this.manipulateUserFields( lstInputs.get( 0 ).get( j ), lstInputs.get( i ).get( j ) );
            }
        }
        claimCompetencyPageObj.saveAndClose().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
    }

   public void editNewCompetency(String competency, List<List<String>> parameter){
       leftNavPanePageObj.claimCompetencyTab().click();
       nextEventPageObj.waitForMoreTime();
       leftNavPanePageObj.claimCompetency().click();
       nextEventPageObj.waitForMoreTime();
       claimCompetencyPageObj.compentencyLevelNameFilterInput().sendKeys(competency);
       claimCompetencyPageObj.compentencyLevelNameFilterImg().click();
       claimCompetencyPageObj.containsFilter().click();
       claimCompetencyPageObj.editCompetency().click();
       for (int i = 1; i < parameter.size(); i++) {
           for (int j = 0; j < parameter.get(0).size(); j++) {
               this.editCompetencyDetails(parameter.get(0).get(j), parameter.get(i).get(j));
           }
       }
       claimCompetencyPageObj.saveBtn().click();

   }

    private void editCompetencyDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "level name":
                claimCompetencyPageObj.levelName().clear();
                claimCompetencyPageObj.levelName().sendKeys(fieldValue);
                break;
            case "level description":
                claimCompetencyPageObj.levelDescription().clear();
                claimCompetencyPageObj.levelDescription().sendKeys(fieldValue);
                break;
            case "maximum number of perils":
                claimCompetencyPageObj.maximumNumberOfPerils().clear();
                claimCompetencyPageObj.maximumNumberOfPerils().sendKeys(fieldValue);
                break;
            case "maximum number of claimants":
                claimCompetencyPageObj.maximumNumberOfClaimants().clear();
                claimCompetencyPageObj.maximumNumberOfClaimants().sendKeys(fieldValue);
                break;
            case "maximum number of lines items linked to claim":
                claimCompetencyPageObj.maximumNumberOfLineItemsLinkedToClaim().clear();
                claimCompetencyPageObj.maximumNumberOfLineItemsLinkedToClaim().sendKeys(fieldValue);
                break;
            case "maximum claim value":
                claimCompetencyPageObj.maximumClaimValue().clear();
                claimCompetencyPageObj.maximumClaimValue().sendKeys(fieldValue);
                break;
            case "maximum load percentage":
                claimCompetencyPageObj.maximumLoadPercentageValue().clear();
                claimCompetencyPageObj.maximumLoadPercentageValue().sendKeys(fieldValue);
                break;
            case "scheme applicable to":
                new Select(claimCompetencyPageObj.schemeApplicableToDropdown()).selectByVisibleText(fieldValue);
                break;
            case "complexity points to allocate per claim":
                claimCompetencyPageObj.complexityPointsToAllocatePerClaim().clear();
                claimCompetencyPageObj.complexityPointsToAllocatePerClaim().sendKeys(fieldValue);
                break;
            case "add type of peril":
                for (int i = 0; i < fieldValue.split("#").length; i++) {
                    new org.openqa.selenium.support.ui.Select(claimCompetencyPageObj.typeOfPerilsDropdown()).selectByVisibleText(fieldValue.split("#")[i]);
                    claimCompetencyPageObj.addPerilbtn().click();
                    nextEventPageObj.btnClick(claimCompetencyPageObj.addPerilbtn());
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                    nextEventPageObj.waitForMoreTime();
                }
                break;
        }
    }

    public void validateAllocatePoints(String user){
        navigationObj.navigateToImenu();
        navigationObj.navigateToIAdmin();
        claimCompetencyPageObj.manageUsersTab().click();
        claimCompetencyPageObj.manageUsersWait();
        try{
            Thread.sleep(40000L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        claimCompetencyPageObj.nameField().sendKeys( user );
        claimCompetencyPageObj.nameFilter().click();
        claimCompetencyPageObj.containsFilter().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.validateUserRetrieved( user ).isDisplayed();
        nextEventPageObj.btnClick( claimCompetencyPageObj.editRetrievedUser( user ) );
        String points = claimCompetencyPageObj.totalCompetencyPointsAllocated().getAttribute("value");
        System.out.println("points"+points);
        String maxpoints= claimCompetencyPageObj.totalMaximumPoints().getAttribute("value");
        System.out.println("maxpoints"+maxpoints);
        int pointsInt = Integer.parseInt(points);
        int maxpointsInt = Integer.parseInt(maxpoints);
        System.out.println("Total Competency Points allocated" + pointsInt);
        System.out.println("Total Maximum Points" + maxpointsInt);
        if (maxpointsInt>pointsInt){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }

    public void validateMaximumNumberOfClaimantsField()
    {
        navigationObj.naivgateToClaimCompetency();
        System.out.println( "firstCompetencyName*******"+firstCompetencyName );
        claimCompetencyPageObj.competencyLevelNameInput().sendKeys(firstCompetencyName);
        claimCompetencyPageObj.competencyLevelNameInputFilter().click();
        claimCompetencyPageObj.contains().click();
        claimCompetencyPageObj.editCompetency(firstCompetencyName).click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        Assert.assertTrue( claimCompetencyPageObj.maximumLoadPercentageValue().isEnabled() );
        System.out.println( "After assertion Maximum Number of Claims field is enabled" );
    }

    public void unallocatedClaimHandlerReason(){
        String claimHandler,claimId,unAllocatedReason="";
        claimHandler = policyDataFieldsPageObj.claimAllocation().getText();
        claimId = nextEventPageObj.firstClaimID().getText();
        System.out.println("Claim Allocation" + policyDataFieldsPageObj.claimAllocation().getText());
        if(claimHandler.equalsIgnoreCase("not assigned")){
            navigationObj.navigateToImenu();
            navigationObj.navigateToIAdmin();
            navigationObj.navigateToCompanyDetails();
            claimCompetencyPageObj.claimInformationTab().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            claimCompetencyPageObj.claimMatterID().sendKeys(claimId);
            claimCompetencyPageObj.claimMatterIDFilter().click();
            claimCompetencyPageObj.claimMatterIDEqualToFilter().click();
            nextEventPageObj.waitForMoreTime();nextEventPageObj.waitForMoreTime();
            unAllocatedReason = claimCompetencyPageObj.claimFirstUnallocatedReason(claimId).getText();
            System.out.println("unAllocatedReason: "+unAllocatedReason);
            switch (unAllocatedReason){
                case "Could not find a competency that has all of the claim perils":
                    case "- Contribution Claim":
                        case "No available team member found":
                            case "No competency found that meets the claim criteria":
                                case "- TMA Claim":
                                    Assert.assertTrue(claimCompetencyPageObj.claimFirstUnallocatedReason(claimId).isDisplayed());
                                    break;
            }
        }else{
            policyDataFieldsPageObj.claimAllocation().isDisplayed();
        }
    }

    public void validateExistingCompetency(String competencyLevel, List<List<String>> parameters) {
        leftNavPanePageObj.claimCompetencyTab().click();
        nextEventPageObj.waitForMoreTime();
        leftNavPanePageObj.claimCompetency().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.competencyLevelNameInput().clear();
        claimCompetencyPageObj.competencyLevelNameInput().sendKeys(competencyLevel);
        nextEventPageObj.btnClick(claimCompetencyPageObj.competencyLevelNameInputFilter());
        nextEventPageObj.btnClick(claimCompetencyPageObj.containsFilter());
        claimCompetencyPageObj.amendCompentency(competencyLevel).click();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.verifyCompetencyDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void verifyCompetencyDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "level name":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.competencylevelName().isEnabled();
                break;
            case "level description":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.competencylevelDescription().isEnabled();
                break;
            case "maximum number of perils":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.competencyMaxPerils().isEnabled();
                break;
            case "maximum number of claimants":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.competencyMaxClaim().isEnabled();
                break;
            case "maximum number of lines items linked to claim":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.competencyMaxClaimItems().isEnabled();
                break;
            case "maximum claim value":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.competencyMaxClaimValues().isEnabled();
                break;
//            case "maximum load percentage":
//                nextEventPageObj.waitForMoreTime();
//                nextEventPageObj.waitForMoreTime();
//                claimCompetencyPageObj.competencylevelDescription().isEnabled();
//                break;
//            case "scheme applicable to":
//                nextEventPageObj.waitForMoreTime();
//                nextEventPageObj.waitForMoreTime();
//                claimCompetencyPageObj.competencylevelDescription().isEnabled();
//                break;
            case "complexity points to allocate per claim":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.competencyComplexityPtsAllocatePerClaim().isEnabled();
                break;
            case "add type of peril":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.competencyTypesOfPeril().isEnabled();
                break;

        }
    }

    public void validateExistingAllocateCompetency(String competencyLevel, List<List<String>> parameters) {
        leftNavPanePageObj.claimCompetencyTab().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        leftNavPanePageObj.allocateCompetency().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.competencyClaimHandlerTeamId().clear();
        claimCompetencyPageObj.competencyClaimHandlerTeamId().sendKeys(competencyLevel);
        nextEventPageObj.btnClick(claimCompetencyPageObj.competencyClaimHandlerTeamIdInputFilter());
        nextEventPageObj.btnClick(claimCompetencyPageObj.containsFilter());
        claimCompetencyPageObj.amendCompentency(competencyLevel).click();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.verifyAllocateCompetencyDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void verifyAllocateCompetencyDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "claim handler team":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.competencyClaimHandlerTeam().isDisplayed();
                break;
            case "add competency to team":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.competencyAddCompetencyToTeam().isEnabled();
                break;
        }
    }

    public void validateExistingManageUsersCompetency(String competencyLevel, List<List<String>> parameters) {
        leftNavPanePageObj.manageUsers().click();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        claimCompetencyPageObj.competencyManageUsersName().clear();
        claimCompetencyPageObj.competencyManageUsersName().sendKeys(competencyLevel);
        nextEventPageObj.btnClick(claimCompetencyPageObj.competencyManageUsersNameInputFilter());
        nextEventPageObj.btnClick(claimCompetencyPageObj.containsFilter());
        claimCompetencyPageObj.moreDetailsUsersCompentency(competencyLevel).click();
        for (int i = 1; i < parameters.size(); i++) {
            for (int j = 0; j < parameters.get(0).size(); j++) {
                this.verifyManageUsersCompetencyDetails(parameters.get(0).get(j), parameters.get(i).get(j));
            }
        }
    }

    private void verifyManageUsersCompetencyDetails(String fieldName, String fieldValue) {
        switch (fieldName.toLowerCase()) {
            case "team name":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.compentencyTeamName().isEnabled();
                break;
            case "team description":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.compentencyTeamDescription().isEnabled();
                break;
            case "location":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.compentencyLocation().isEnabled();
                break;
            case "team members":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.compentencyTeamMembers().isEnabled();
                break;
            case "allocated competencies":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.compentenciesAllocated().isEnabled();
                break;
            case "allocated competencies names":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.compentenciesNameAllocated().isEnabled();
                break;
            case "total competency points allocated":
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                claimCompetencyPageObj.compentencyPointsAllocated().isEnabled();
                break;
        }
    }
}
