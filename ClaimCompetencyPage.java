package co.uk.directlinegroup.tt.pages;

import com.usmanhussain.habanero.framework.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClaimCompetencyPage extends AbstractPage {

    public WebElement addCompetency() {
        return waitForElementPresent( By.id( "ctl00_cphBody_btnAddNew" ) );
    }

    public WebElement levelName() {
        return waitForElementPresent( By.id( "ctl00_cphBody_txtLevelName" ) );
    }

    public WebElement levelDescription() {
        return waitForElementPresent( By.id( "ctl00_cphBody_txtLevelDescription" ) );
    }

    public WebElement maximumNumberOfPerils() {
        return waitForElementPresent( By.id( "ctl00_cphBody_txtMaximumNumberOfPerils_text" ) );
    }

    public WebElement maximumNumberOfClaimants() {
        return waitForElementPresent( By.id( "ctl00_cphBody_txtMaximumNumberOfClaimants_text" ) );
    }

    public WebElement maximumNumberOfLineItemsLinkedToClaim() {
        return waitForElementPresent( By.id( "ctl00_cphBody_txtMaximumNumberOfLineItemsLinkedToClaim_text" ) );
    }

    public WebElement maximumClaimValue() {
        return waitForElementPresent( By.id( "ctl00_cphBody_txtMaximumClaimValue_text" ) );
    }

    public WebElement maximumLoadPercentageValue() {
        return waitForElementPresent( By.id( "ctl00_cphBody_txtMaximumLoadPercentage_text" ) );
    }

    public WebElement schemeApplicableToDropdown() {
        return waitForElementPresent( By.id( "ctl00_cphBody_ddlSchemeApplicableTo" ) );
    }

    public WebElement typeOfPerilsDropdown() {
        return waitForElementPresent( By.id( "ctl00_cphBody_ddlTypeOfPerils" ) );
    }

    public WebElement addPerilbtn() {
        return waitForElementPresent( By.id( "ctl00_cphBody_btnAddPeril" ) );
    }

    public WebElement complexityPointsToAllocatePerClaim() {
        return waitForElementPresent( By.id( "ctl00_cphBody_txtComplexityPointsToAllocatePerClaim_text" ) );
    }

    public WebElement saveBtn() {
        return waitForElementPresent( By.id( "ctl00_cphBody_btnSave" ) );
    }

    public WebElement manageUsersTab() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'MANAGE USERS')]" ) );
    }

    public WebElement manageUsersWait() {
        return (new WebDriverWait( getDriver, 20 )).until( ExpectedConditions.presenceOfElementLocated( By.xpath( "//div[contains(text(),'iAdmin - User Management')]" ) ) );
    }

//    public WebElement addNewUser() {
//        return waitForElementPresent( By.id( "ctl00_cphBody_btnAddNew" ) );
//    }

    public WebElement addNewUsersWait() {
        return (new WebDriverWait( getDriver, 20 )).until( ExpectedConditions.presenceOfElementLocated( By.xpath( "//div[contains(text(),'Add/Edit a User')]" ) ) );
    }

    public WebElement title() {
        return waitForElementPresent( By.id( "ctl00_cphBody_titles" ) );
    }

    public WebElement firstName() {
        return waitForElementPresent( By.id( "ctl00_cphBody_firstName" ) );
    }

    public WebElement lastName() {
        return waitForElementPresent( By.id( "ctl00_cphBody_lastName" ) );
    }

    public WebElement office() {
        return waitForElementPresent( By.id( "ctl00_cphBody_offices" ) );
    }

    public WebElement language() {
        return waitForElementPresent( By.id( "ctl00_cphBody_ddlLanguage" ) );
    }

    public WebElement emailAddress() {
        return waitForElementPresent( By.id( "ctl00_cphBody_emailAddress" ) );
    }

    public WebElement administrationGroup() {
        return waitForElementPresent( By.id( "ctl00_cphBody_ddAdminGroup" ) );
    }

    public WebElement submitbtn() {
        return waitForElementPresent( By.id( "ctl00_cphBody_SubmitButton" ) );
    }

    public WebElement claimCompetencyTable(int columnNo) {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBody_grdCompetency_ctl01']//tbody/tr[last()]/td[" + columnNo + "]" ) );
    }

    public WebElement filterWithDate() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Date Created')]/../../../tr[2]/td[8]/input" ) );
    }

    public WebElement dateFilter() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Date Created')]/../../../tr[2]/td[8]/img" ) );
    }

    public WebElement teamNameFilter() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Team Name')]/../../../tr[2]/td[6]/img" ) );
    }

    public WebElement contains() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'Contains')]" ) );
    }

    public WebElement filterWithTeamName() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Team Name')]/../../../tr[2]/td[6]/input" ) );
    }

    public WebElement validateUserRetrieved(String user) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + user + "')]" ) );
    }

    public WebElement editRetrievedUser(String user) {
                return waitForElementPresent( By.xpath( "(//td[contains(text(),'" + user + "')]/following-sibling::td[7]/input)[last()]" ) );
    }


    public WebElement addTeamMemberbtn() {
        return waitForElementPresent( By.id( "ctl00_cphBody_btnAddTeamMember" ) );
    }

//    public WebElement savebtn() {
//        return waitForElementPresent( By.id( "ctl00_cphBody_btnSave" ) );
//    }

    public WebElement deleteTeamMemberaddedInClaimHandlerTeam(String user) {
        System.out.println( "(//td/a[contains(text(),'Delete')])[last()]" );
        return waitForElementPresent( By.xpath( "(//td/a[contains(text(),'Delete')])[last()]" ) );
    }

    public WebElement editTeamMemberaddedInClaimHandlerTeam(String user) {
        System.out.println( "(//td[contains(text(),'" + user + "')]/preceding-sibling::td/a[contains(text(),'Edit')])])[last()]" );
        return waitForElementPresent( By.xpath( "(//td[contains(text(),'" + user + "')]/preceding-sibling::td/a[contains(text(),'Edit')])[last()]" ) );
    }

    public WebElement validateStatusofClaimHandler() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Inactive')]/../following-sibling::td/input[2]" ) );
    }

    public WebElement editCompetency(String competency) {
        return waitForElementPresent( By.xpath( "(//td[text()='" + competency + "']/preceding-sibling::td/a[contains(text(),'Edit')])[last()]" ) );
    }

    public WebElement editCompetencyStatus() {
        return waitForElementPresent( By.id( "ctl00_cphBody_ddlLevelStatus" ) );
    }

    public WebElement validateCompetencyStatus(String competency) {
        return waitForElementPresent( By.xpath( "(//td[text()='" + competency + "']/following-sibling::td[1])[last()]" ) );
    }

    public WebElement markAsActive() {
        return waitForElementPresent( By.xpath( "(//span[text()='Active'])[2]//../following-sibling::td/input" ) );
    }

    public WebElement validateActiveStatus() {
        return waitForElementPresent( By.xpath( "(//span[text()='Active'])[2]//../following-sibling::td/input[2]" ) );
    }

    public WebElement saveAndClose() {
        return waitForElementPresent( By.id( "btnSaveAndClose" ) );

    }

    public WebElement amendCompentency(String competencyLevel) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + competencyLevel + "')]/../td[1]/a" ) );
    }

    public WebElement addCompetencyToTeam() {
        return waitForElementPresent( By.id( "ctl00_cphBody_ddlCompetency" ) );
    }

    public WebElement claimHandlerTeam() {
        return waitForElementPresent( By.id( "ctl00_cphBody_ddlClaimHandlerTeam" ) );
    }

    public WebElement addCompetencyBtn() {
        return waitForElementPresent( By.id( "ctl00_cphBody_btnAddCompetency" ) );
    }

    public WebElement nameField() {
        return waitForElementPresent( By.xpath( "(//img[@alt='Filter'])[2]/preceding-sibling::input" ) );
    }

    public WebElement nameFilter() {
        return waitForElementPresent( By.xpath( "(//img[@alt='Filter'])[2]" ) );
    }

    public WebElement containsFilter() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'Contains')]" ) );
    }

    public WebElement userGroupValue() {
        return waitForElementPresent( By.xpath( "//span[text()='User Group']/../following-sibling::td/div//input[1]" ) );
    }

    public WebElement userGroupInformationTab() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'User Group Information')]" ) );
    }

    public WebElement competencyManagerTab() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Competency Manager')]" ) );
    }

    public WebElement supervisorValue() {
        return waitForElementPresent( By.xpath( "//span[text()='Supervisor']/../following-sibling::td/input" ) );
    }

    public WebElement teamNameValue() {
        return waitForElementPresent( By.xpath( "//span[text()='Team Name']/../following-sibling::td/input" ) );
    }

//    public WebElement closeWindow() {
//        return waitForElementPresent( By.id( "btnClose" ) );
//    }

    public WebElement claimCompetencyTab() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'CLAIM COMPETENCY')]" ) );
    }

    public WebElement claimHandlersTeamTab() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'CLAIM HANDLER TEAMS')]" ) );
    }

//    public WebElement addNewClaimCompetencybtn() {
//        return waitForElementPresent( By.id( "ctl00_cphBody_btnAddNew" ) );
//    }

    public WebElement supervisor() {
        return waitForElementPresent( By.id( "ctl00_cphBody_ddlSupervisor" ) );
    }

    public WebElement teamName() {
        return waitForElementPresent( By.id( "ctl00_cphBody_txtTeamName" ) );
    }

    public WebElement teamDescription() {
        return waitForElementPresent( By.id( "ctl00_cphBody_txtTeamDescription" ) );
    }

    public WebElement location() {
        return waitForElementPresent( By.id( "ctl00_cphBody_txtLocation" ) );
    }

    public WebElement addClaimHandlerTeamMember() {
        return waitForElementPresent( By.id( "ctl00_cphBody_ddlClaimHandler" ) );
    }

    public WebElement removeTeamMemberLinkInClaimHandlerTeam(String user) {
        System.out.println( "(//td[contains(text(),'" + user + "')]/preceding-sibling::td/a[contains(text(),'Remove')])[last()]" );
        return waitForElementPresent( By.xpath( "(//td[contains(text(),'" + user + "')]/preceding-sibling::td/a[contains(text(),'Remove')])[last()]" ) );
    }

    public WebElement historyOfCompetencyLevelLink(String competencyLevel) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + competencyLevel + "')]/../td[3]/a" ) );
    }

    public WebElement historyTable(int columnNo, int i) {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBody_rgHistoryRow_ctl01']//tbody/tr[" + i + "]/td[" + columnNo + "]" ) );
    }

    public WebElement deleteLinkInCompetency(String competencyLevel) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + competencyLevel + "')]/../td[2]/a" ) );
    }

    public WebElement goBackBtn() {
        return waitForElementPresent( By.id( "ctl00_cphBody_btnGoBack" ) );
    }

//    public WebElement competencyStatus() {
//        return waitForElementPresent( By.id( "ctl00_cphBody_ddlLevelStatus" ) );
//    }

    public WebElement activeTeam() {
        return waitForElementPresent( By.id( "ctl00_cphBody_chkActive" ) );
    }

    public WebElement allocationTable(int columnNo) {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBody_grdCompetencyAllocation_ctl01']//tbody/tr[last()]/td[" + columnNo + "]" ) );
    }

    public WebElement allocatedCompetencyName() {
        return waitForElementPresent( By.xpath( "//span[text()='Allocated Competencies Names']/../following-sibling::td/input[1]" ) );
    }

    public WebElement inactiveDueToHoliday() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Inactive Due to Holiday')]/../following-sibling::td/input" ) );
    }

    public WebElement inactiveDueToHolidayValidation() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Inactive Due to Holiday')]/../following-sibling::td/input[2]" ) );
    }

    public WebElement validateTeamLeaderInformation(String field) {

        return waitForElementPresent( By.linkText( field ) );
    }

    public WebElement claimInformationTab() {

        return waitForElementPresent( By.xpath( "//span[contains(text(),'Claim Information')]" ) );
    }

    public WebElement claimHandlerAllocationchkbox() {

        return waitForElementPresent( By.xpath( "//span[contains(text(),'Automatic Claim Handler Allocation')]/../following-sibling::td/input" ) );
    }

    public WebElement claimHandlerAllocationchkbox_validation() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Automatic Claim Handler Allocation')]/../following-sibling::td/input[2]" ) );
    }

    public WebElement leaveDate(String field) {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'" + field + "')]/../following-sibling::td/div//span/input[1]" ) );
    }

    public WebElement daysBeforeLeaveDate() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'No New Claims')]/../following-sibling::td//input[1]" ) );
    }

    public WebElement claimCompetencyTable() {
        return waitForElementPresent( By.xpath( "//*[@id='ctl00_cphBody_grdCompetency_ctl01']/tbody" ) );
    }

    public WebElement accessingClaimCompetencyTable(int rowcount) {
        return waitForElementPresent( By.xpath( "//tr[" + rowcount + "]/td/a[contains(text(),'Edit')]" ) );
    }

    public WebElement competencyTableCompetencyStatus(int rowcount) {
        return waitForElementPresent( By.xpath( "//tr[" + rowcount + "]/td[7]" ) );
    }

    public WebElement editClaimHandlerTeam(String team) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + team + "')]/preceding-sibling::td/a[contains(text(),'Edit')]" ) );
    }

    public WebElement archiveErrorMessage(String errorMessage) {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'" + errorMessage + "')]" ) );
    }

    public WebElement archiveErrorMessageClosebtn() {
        return waitForElementPresent( By.xpath( "(//input[@value='Close'])[2]" ) );
    }

    public String claimCompetencyTableXpath() {
        return "//table[@id='ctl00_cphBody_grdCompetency_ctl01']//tbody/tr";
    }

    public WebElement user_Namefield() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Name')]/../../following-sibling::tr/td[2]/input" ) );
    }

    public WebElement user_NameFilter() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Name')]/../../following-sibling::tr/td[2]/img" ) );
    }

    public WebElement diableUsers(String users) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + users + "')]/following-sibling::td[9]/input" ) );
    }

    public WebElement claimHandlerTeamTable() {
        return waitForElementPresent( By.xpath( "//table[contains(@id,'ctl00_cphBody_grdTeam')]/tbody" ) );
    }

    public WebElement claimHandlerTeamStatus(int rowcount) {
        return waitForElementPresent( By.xpath( "//tr[" + rowcount + "]/td[8]" ) );
    }

    public WebElement changeTeamStatus() {
        return waitForElementPresent( By.id( "ctl00_cphBody_chkActive" ) );
    }

    public WebElement getTeamStatus(String team) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + team + "')]/following-sibling::td[2]" ) );
    }

    public WebElement userEdit() {
        return waitForElementPresent( By.xpath( "//input[@alt='Details']" ) );
    }

    public WebElement totalCompetencyPointsAllocated() {
        return waitForElementPresent( By.xpath( "//span[contains(text(),'Total Competency Points Allocated')]/../following-sibling::td/input[contains(@name,'txt302949')]" ) );
    }

    public WebElement competencyLevelNameInput() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Competency Level Name')]/../../following-sibling::tr/td[5]/input" ) );
    }

    public WebElement competencyLevelNameInputFilter() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Competency Level Name')]/../../following-sibling::tr/td[5]/img" ) );
    }

    public WebElement editCompetency() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'TIM - Complexity 4 (NW Black)')]/preceding-sibling::td/a[contains(text(),'Edit')]" ) );
    }

    public WebElement allocateCompetencyTable() {
        return waitForElementPresent( By.xpath( "//table[contains(@id,'ctl00_cphBody_grdCompetencyAllocation')]/tbody" ) );
    }

    public WebElement editCompetency(int row) {
        return waitForElementPresent( By.xpath( "//table[contains(@id,'ctl00_cphBody_grdCompetencyAllocation')]/tbody/tr[" + row + "]/td/a[contains(text(),'Edit')]" ) );
    }

    public WebElement removeCompetencyFromTeam(String competency) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + competency + "')]/preceding-sibling::td/a[contains(text(),'Remove')]" ) );
    }

    public WebElement nextPageLink() {
        return waitForElementPresent( By.linkText( "Next" ) );
    }

    public WebElement claimHandlerTeamNameInputbox() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Team Name')]/../../following-sibling::tr/td[6]/input" ) );
    }

    public WebElement claimHandlerTeamNameFilter() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Team Name')]/../../following-sibling::tr/td[6]/img" ) );
    }

    public WebElement claimHandlerEditTeam(String team) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + team + "')]/preceding-sibling::td/a[contains(text(),'Edit')]" ) );
    }

    public WebElement claimHandlerRemoveTeamMember(String teamMember) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + teamMember + "')]/preceding-sibling::td/a[contains(text(),'Remove')]" ) );
    }

    public WebElement deleteTeam(String team) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + team + "')]/preceding-sibling::td//a[contains(text(),'Delete')]" ) );
    }

    public WebElement deleteCompetencyLevel(int row) {
        return waitForElementPresent( By.xpath( "//table[contains(@id,'ctl00_cphBody_grdCompetencyAllocation')]/tbody/tr[" + row + "]/td/a[contains(text(),'Delete')]" ) );
    }

    public WebElement perilsInAllocation() {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBody_grdUnallocatedClaims_ctl01']/thead/tr[2]/td[9]/input" ) );
    }

    public WebElement perilsInAllocationFilter() {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBody_grdUnallocatedClaims_ctl01']/thead/tr[2]/td[9]/img" ) );
    }

    public WebElement filterContains() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'Contains')]" ) );
    }

    public WebElement claimStatusInAllocationFilter() {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBody_grdUnallocatedClaims_ctl01']/thead/tr[2]/td[8]/img" ) );
    }

    public WebElement claimStatusInAllocation() {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBody_grdUnallocatedClaims_ctl01']/thead/tr[2]/td[8]/input" ) );
    }

    public WebElement firstUnAllocatedClaims() {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBody_grdUnallocatedClaims_ctl01']/tbody/tr[1]//a" ) );
    }

    public WebElement assignToClaimHandler() {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBody_grdClaimHandlers_ctl01']/tbody/tr[1]//a" ) );
    }

    public WebElement contributionClaimAllocationWarning() {
        return waitForElementPresent( By.id( "Warning" ) );
    }

    public WebElement compentencyLevelNameFilterInput() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Competency Level Description')]/../../following-sibling::tr/td[5]/input" ) );
    }

    public WebElement compentencyLevelNameFilterImg() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Competency Level Description')]/../../following-sibling::tr/td[5]/img" ) );
    }

    public WebElement claimIDHeader_UnallocatedClaims() {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdUnallocatedClaims_ctl01']/thead/tr[2]/td[2]/input" ) );
    }

    public WebElement claimIDHeader_UnallocatedClaims_Filter() {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdUnallocatedClaims_ctl01']/thead/tr[2]/td[2]/img" ) );
    }

    public WebElement equalToFilter() {
        return waitForElementPresent( By.xpath( "//td[(text()='EqualTo')]" ) );
    }


    public WebElement compentenciesSorting() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'ResourceListID')]" ) );
    }

    public WebElement manuallyAssignClaimHandler() {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBody_grdUnallocatedClaims_ctl01']/tbody/tr[1]/td[1]" ) );
    }

    public WebElement competencyClaimDetails() {
        return waitForElementPresent( By.xpath( "(//td[contains(text(),'TMA Claim')])[1]/preceding-sibling::td[last()-1]" ) );
    }

    public WebElement allocateClaim(String claimID) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + claimID + "')]/preceding-sibling::td/a[contains(text(),'Allocate')]" ) );
    }

    public WebElement allocateClaimManually(String claimID, String allocation) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + claimID + "')]/preceding-sibling::td/a[contains(text(),'"+allocation+"')]" ) );
    }
    public WebElement assignClaimToClaimHandler(String username) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + username + "')]/preceding-sibling::td/a[contains(text(),'Assign')]" ) );
    }

    public WebElement validateAllocation() {
        return waitForElementPresent( By.xpath( "//div[contains(text(),'No records to display')]" ) );
    }

    public WebElement validateClaimHandlerAssignee(String user) {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBody_grdTasks_ctl01']/tbody/tr/td[contains(text(),'" + user + "')]" ) );
    }

    public WebElement referredClaimId(String claimID) {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdTasksOutstanding_ctl01']//td[contains(text(),'" + claimID + "')]" ) );
    }

    public WebElement manuallyAllocClaimId(String claimID) {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdUnallocatedClaims_ctl01']//td[contains(text(),'" + claimID + "')]" ) );
    }

    public WebElement filterInput() {
        return waitForElementVisible( By.xpath( "//table[contains(@id,'grdCompetency')]/thead/tr[2]/td[5]/input" ) );
    }

    public WebElement filterImg() {
        return waitForElementVisible( By.xpath( "//table[contains(@id,'grdCompetency')]/thead/tr[2]/td[5]/img" ) );
    }

    public WebElement allocatedCompetencyFilterInput() {
        return waitForElementVisible( By.xpath( "//table[contains(@id,'grdCompetency')]/thead/tr[2]/td[5]/input" ) );
    }

    public WebElement allocatedFilterImg() {
        return waitForElementVisible( By.xpath( "//table[contains(@id,'grdCompetency')]/thead/tr[2]/td[5]/img" ) );
    }

    public WebElement claimHandlerUsername() {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdClaimHandlers_ctl01']/thead/tr[2]/td[3]/input" ) );
    }

    public WebElement claimId() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'Claim ID')]/../../following-sibling::tr[1]/td[2]/input" ) );
    }

    public WebElement selectAllocateLink(String claimID) {
        return waitForElementPresent( By.xpath( "//*[contains(text(),'" + claimID + "')]/preceding-sibling::td[1]/a" ) );
    }

    public WebElement claimHandlerUsernameFilter() {
        return waitForElementPresent( By.xpath( "//table[@id='ctl00_cphBodyWithoutUpdatePanel_cphBody_grdClaimHandlers_ctl01']/thead/tr[2]/td[3]/img" ) );
    }

    public WebElement containsTab() {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'Contains')]" ) );
    }

    public WebElement claimIDFilter() {
        return waitForElementPresent( By.xpath( "(//input[contains(@name,'grdTasksOutstanding')])[11]" ) );
    }

    public WebElement claimIDFilterManualAllocationTab() {
        return waitForElementPresent( By.xpath( "(//input[contains(@name,'grdUnallocatedClaims')])[2]" ) );
    }

    public WebElement claimIDFilterImgManualAllocationTab() {
        return waitForElementPresent( By.xpath( "(//input[contains(@name,'grdUnallocatedClaims')])[2]/following-sibling::img" ) );
    }

    public WebElement claimTasksClaimIDFilter() {
        return waitForElementPresent( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_txtMatterID" ) );
    }

    public WebElement claimTasksClaimIDFilterBtn() {
        return waitForElementPresent( By.id( "ctl00_cphBodyWithoutUpdatePanel_cphBody_btnFilterOnMatterID" ) );
    }
    public WebElement checkActiveStatus() {
        return waitForElementPresent( By.xpath( "(//span[text()='Active'])[1]//../following-sibling::td/input[2]" ) );
    }
    public WebElement markAsInActive() {
        return waitForElementPresent( By.xpath( "(//span[text()='Active'])[1]//../following-sibling::td/input" ) );
    }
    public WebElement claimMatterID(){
        return waitForElementPresent(By.xpath("//input[@name='Rad302993$ctl01$ctl02$ctl02$ctl06']"));
    }
    public WebElement claimMatterIDFilter(){
        return waitForElementPresent(By.xpath("//input[@name='Rad302993$ctl01$ctl02$ctl02$ctl06']/../img"));
    }
    public WebElement claimMatterIDEqualToFilter(){
        return waitForElementPresent(By.xpath("//td[text()='EqualTo']"));
    }
    public WebElement claimFirstUnallocatedReason(String claimID){
        return waitForElementPresent(By.xpath("//td[text()='"+claimID+"']/following-sibling::td[1]"));
    }

    public WebElement totalMaximumPoints() {
        return waitForElementPresent( By.xpath( "//input[@id='txt303961']" ) );
    }

    public WebElement competencylevelName() {
        return waitForElementPresent( By.xpath("//div[contains(text(),'Level Name')]/following-sibling::div[1]/input"));
    }
    public WebElement competencylevelDescription() {
        return waitForElementPresent( By.xpath("//div[contains(text(),'Level Description')]/following-sibling::div[1]/input"));
    }

    public WebElement competencyMaxPerils() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Maximum Number Of Perils')]/following-sibling::div[1]/span/input[1]"));
    }

    public WebElement competencyMaxClaim() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Maximum Number Of Claimants')]/following-sibling::div[1]/span/input[1]"));
    }
    public WebElement competencyMaxClaimItems() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Maximum Number Of Lines Items Linked To Claim')]/following-sibling::div[1]/span/input[1]"));
    }
    public WebElement competencyMaxClaimValues() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Maximum Claim Value')]/following-sibling::div[1]/span/input[1]"));
    }
    public WebElement competencyComplexityPtsAllocatePerClaim() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Complexity Points To Allocate Per Claim')]/following-sibling::div[1]/span/input[1]"));
    }

    public WebElement competencyTypesOfPeril() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Add Type Of Peril')]/following-sibling::div[1]/select"));
    }

    public WebElement competencyClaimHandlerTeam() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Claim Handler Team')]/following-sibling::div[1]/span"));
    }

    public WebElement competencyAddCompetencyToTeam() {
        return waitForElementPresent(By.xpath("//div[contains(text(),'Add Competency To Team')]/following-sibling::div[1]/select[1]"));
    }

    public WebElement competencyClaimHandlerTeamId() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'ClaimHandlerTeamID')]/../../following-sibling::tr/td[5]/input" ) );
    }
    public WebElement competencyClaimHandlerTeamIdInputFilter() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'ClaimHandlerTeamID')]/../../following-sibling::tr/td[5]/img" ) );
    }
    public WebElement competencyManageUsersName() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'EmailAddress')]/../../following-sibling::tr/td[3]/input" ) );
    }
    public WebElement competencyManageUsersNameInputFilter() {
        return waitForElementPresent( By.xpath( "//a[contains(text(),'EmailAddress')]/../../following-sibling::tr/td[3]/img" ) );
    }
    public WebElement moreDetailsUsersCompentency(String competencyLevel) {
        return waitForElementPresent( By.xpath( "//td[contains(text(),'" + competencyLevel + "')]/following-sibling::td[6]/input" ) );
    }

    public WebElement compentencyTeamName() {
        return waitForElementPresent((By.id("txt302870_302904")));
    }
    public WebElement compentencyTeamDescription() {
        return waitForElementPresent((By.id("txt302871_302904")));
    }
    public WebElement compentencyLocation() {
        return waitForElementPresent((By.id("txt303039_302904")));
    }
    public WebElement compentencyTeamMembers() {
        return waitForElementPresent((By.id("txt302872_302904")));
    }
    public WebElement compentenciesAllocated() {
        return waitForElementPresent((By.id("txt302917")));
    }
    public WebElement compentenciesNameAllocated() {
        return waitForElementPresent((By.id("txt302921")));
    }
    public WebElement compentencyPointsAllocated() {
        return waitForElementPresent((By.id("txt302949")));
    }
}
