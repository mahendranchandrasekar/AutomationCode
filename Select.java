package co.uk.directlinegroup.tt.utils.common;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Select {

    private static String strNoValueEntryString = "Nothing Entered";

    public void selectByVisibleText(WebElement wbElement, String strInput) {
        if (strInput.equalsIgnoreCase( strNoValueEntryString ) && !strInput.isEmpty() && strInput != null) {
            boolean bContinue = true;
            int icount = 0;
            do {
                icount++;
                if (new org.openqa.selenium.support.ui.Select( wbElement ).getOptions().size() > 0) {
                    new org.openqa.selenium.support.ui.Select( wbElement ).selectByVisibleText( strInput );
                    break;
                }

                if (icount > 1000) {
                    break;
                }
            } while (bContinue);
        }
    }

    public void selectByIndex(WebElement wbElement, int iIndex) {
        new org.openqa.selenium.support.ui.Select( wbElement ).selectByIndex( iIndex );
    }

    public void selectByValue(WebElement wbElement, String strValue) {
        if (!strValue.isEmpty() && strValue != null && !strValue.equalsIgnoreCase( strNoValueEntryString )) {
            new org.openqa.selenium.support.ui.Select( wbElement ).selectByValue( strValue );
        }
    }

    public boolean validateValuesInDropDown(WebElement wbSelectElement, List<String> lstValues) {
        boolean bFound = false;
        List<WebElement> optionSelect = new org.openqa.selenium.support.ui.Select( wbSelectElement ).getOptions();
        for (int iString = 0; iString < lstValues.size(); iString++) {
            bFound = false;
            String strValueToCheck = lstValues.get( iString );
            System.out.println( "strValueToCheck===" + strValueToCheck );

            for (int iValue = 0; iValue < optionSelect.size(); iValue++) {
                System.out.println( "iValue==" + iValue );
                System.out.println( "optionSelect.get( iValue ).getText()===" + optionSelect.get( iValue ).getText() );
                if (optionSelect.get( iValue ).getText().equalsIgnoreCase( strValueToCheck )) {
                    bFound = true;
                    break;
                }
            }
            if (!bFound) {
                return false;
            }
        }
        return true;
    }

    public boolean validateValuesAreNotInDropDown(WebElement wbSelectElement, List<String> lstValues) {
        boolean bFound = false;
        List<WebElement> optionSelect = new org.openqa.selenium.support.ui.Select( wbSelectElement ).getOptions();
        for (int iString = 0; iString < lstValues.size(); iString++) {
            bFound = false;
            String strValueToCheck = lstValues.get( iString );
            for (int iValue = 0; iValue < optionSelect.size(); iValue++) {
                if (optionSelect.get( iValue ).getText().equalsIgnoreCase( strValueToCheck )) {
                    return false;
                }
            }
        }
        return true;
    }

    public void selectValueFromDropdown(WebElement wbSelectElement, String strValueToSelect){
        List<WebElement> options = new org.openqa.selenium.support.ui.Select(wbSelectElement).getOptions();
        for (int iValue = 0; iValue < options.size(); iValue++) {
                String strValue = options.get(iValue).getText();
            if (strValue.trim().equalsIgnoreCase(strValueToSelect)) {
                new org.openqa.selenium.support.ui.Select(wbSelectElement).selectByVisibleText(strValue);
                break;
            }
        }

    }


}
