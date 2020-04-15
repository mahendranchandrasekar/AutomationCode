package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.IAdminSecurityManagementPage;
import org.openqa.selenium.support.ui.Select;

public class  Access {

    private Navigation navigationObj = new Navigation();
    private IAdminSecurityManagementPage iAdminSecurityMngmtPageObj = new IAdminSecurityManagementPage();

    public void provideAccess(String recordaccesstype, String username) {
        navigationObj.navigateToManageUserGroup();
        iAdminSecurityMngmtPageObj.provideSensitiveAccess(recordaccesstype).click();
        new Select(iAdminSecurityMngmtPageObj.provideUserAccess()).selectByVisibleText(username);
        iAdminSecurityMngmtPageObj.assignSensitiveAccess().click();
    }
}
