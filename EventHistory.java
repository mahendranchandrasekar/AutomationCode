package co.uk.directlinegroup.tt.utils;

import co.uk.directlinegroup.tt.pages.FullEventHistoryPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.utils.common.Commands;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static com.usmanhussain.habanero.framework.AbstractPage.getDriver;

public class EventHistory {

    private FullEventHistoryPage fullEventHistoryPageObj = new FullEventHistoryPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
    public static String eventName;
    public static int eventCount;
    List<WebElement> elementCount;
    private Commands commandsObj = new Commands();
    public String timestamp;
    public String generatedTimestamp;

    public boolean verifyingEvent() {
        List<WebElement> rows = fullEventHistoryPageObj.findElements(By.xpath(fullEventHistoryPageObj.eventhistorytableRows()));
        List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();
        for (WebElement row : rows) {
            List<WebElement> rowElements = row.findElements(By.xpath(fullEventHistoryPageObj.eventhistorytablerowdata()));
            ArrayList<String> rowData = new ArrayList<String>();
            for (WebElement column : rowElements) {
                rowData.add(column.getText().toString());
            }
            rowsData.add(rowData);
            if (!(rowsData.contains("High Value Reserve Email Notification (SYSTEM)"))) {
                Assert.assertTrue(!(rowsData.contains("High Value Reserve Email Notification (SYSTEM)")));
                return false;
            }
        }
        return true;
    }

    public boolean verifyingEventNotGenerated(String event) {
        List<WebElement> rows = fullEventHistoryPageObj.findElements(By.xpath(fullEventHistoryPageObj.eventhistorytableRows()));
        List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();
        for (WebElement row : rows) {
            List<WebElement> rowElements = row.findElements(By.xpath(fullEventHistoryPageObj.eventhistorytablerowdata()));
            ArrayList<String> rowData = new ArrayList<String>();
            for (WebElement column : rowElements) {
                rowData.add(column.getText().toString());
            }
            rowsData.add(rowData);
            if (!(rowsData.contains(event))) {
                Assert.assertFalse(!(rowsData.contains(event)));
                return false;
            }
        }
        return true;
    }

    public void refresh() throws Throwable {
        getDriver.navigate().refresh();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        getDriver.navigate().refresh();
    }

    public void getWindowTitle() throws Throwable {
        System.out.println("Window title" + getDriver.getTitle());
    }

    public void verifyEventCountInFullEventHistory(String events) {
        try {
            fullEventHistoryPageObj.showFullEventHistory().click();
            nextEventPageObj.switchToLastOpenWindow();
            System.out.println("verifying event genration count");
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            for(int i = 0 ; i < events.split("#").length;i++)
            {
                int noOfTimesEventGenerated = nextEventPageObj.findElements(By.xpath(fullEventHistoryPageObj.eventsInHistoryXpath(events.split("#")[i]))).size();
                System.out.println("Number of times event generated------------------" + noOfTimesEventGenerated);
                Assert.assertTrue(noOfTimesEventGenerated == 1);
            }
            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToLastOpenWindow();
            nextEventPageObj.waitForMoreTime();
        } catch (AssertionError e) {
            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToLastOpenWindow();
            nextEventPageObj.waitForMoreTime();
            Assert.assertTrue("Event generated more than once-----------", false);
        }
    }

    public void verifyingEventName(String event) {
        eventName = event;
        elementCount = new Select(nextEventPageObj.selectCase()).getOptions();
        int j=0;
        try {
            for (int i = 0; i < elementCount.size(); i++) {
                new Select( nextEventPageObj.selectCase() ).selectByIndex( i );
                nextEventPageObj.waitForMoreTime();
                nextEventPageObj.waitForMoreTime();
                if (commandsObj.elementDisplayedWithLessTime( By.xpath( "//td[contains(text(),'" + eventName + "')]" ) )) {
                    generatedTimestamp = fullEventHistoryPageObj.findElement( By.xpath( "//td[contains(text(),'"+ eventName +"')]/preceding-sibling::td" ) ).getText();
                    System.out.println( "generatedTimestamp in case****" + i + "*****" + generatedTimestamp );
                    if (!generatedTimestamp.equalsIgnoreCase( timestamp ))
                        System.out.println( "Event available :-------------------------" + nextEventPageObj.lblEvents( eventName ).getText() );
                    eventCount = j + 1;
                    System.out.println( "Into if loop*******" );
                }
                timestamp = generatedTimestamp;
                System.out.println( "Into case****************" + i );
                System.out.println( "EventCount in case******" + i + "*****" + eventCount );
            }
            Assert.assertTrue( eventCount == 1 );
            System.out.println( "****Only one event is generated******" + eventName );
            System.out.println( "****Event count in after Assertion check******" + eventCount );
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.waitForMoreTime();
            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToLastOpenWindow();
            nextEventPageObj.waitForMoreTime();
        }
        catch(Exception e)
        {
            fullEventHistoryPageObj.eventHistoryCloseWindow().click();
            nextEventPageObj.waitForMoreTime();
            nextEventPageObj.switchToLastOpenWindow();
            nextEventPageObj.waitForMoreTime();
            System.out.println("Exception occured is*******"+e);
            Assert.assertTrue(false);
        }
    }
}
