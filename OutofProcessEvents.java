package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.NextEventPage;

public class OutofProcessEvents {

    private NextEventPage nextEventPageObj = new NextEventPage();
    private Navigation navigationObj = new Navigation();

    public void startOutOfProcesEvent(String strOOPEvent) {
        nextEventPageObj.addOutOfProcessEvent().click();
        nextEventPageObj.btnClick(nextEventPageObj.go());
        nextEventPageObj.switchToFrameById(nextEventPageObj.frame());
        navigationObj.navigateToNextEventType(strOOPEvent);
    }

}
