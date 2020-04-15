package co.uk.directlinegroup.tt.utils.common;

import org.junit.Assert;

import java.util.*;

public class StringOperations {

    public boolean validateStringIsInAlphabeticalOrder(List<String> strStringList) {
        System.out.println("Extering validateStringIsInAlphabeticalOrder Fun");
        try {
            String previous = ""; // empty string: guaranteed to be less than or equal to any Other
            for (final String current : strStringList) {
                System.out.println("current:: "+current);
                System.out.println("previous:: "+previous);
                if (current.compareTo(previous) < 0) {
                    System.out.println("Inside compare < 0 return - 1");
                    return false;
                }
                previous = current;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Inside Exception return - 2");
            return false;
        }
        System.out.println("Inside  return - 3");
        System.out.println("Exiting validateStringIsInAlphabeticalOrder Fun");
        return true;
    }

    public boolean checkStringIsValidCurrency(String strCurrency) {
        Currency currency = Currency.getInstance(Locale.getDefault());
        String symbol = currency.getSymbol();
        if (strCurrency.startsWith(symbol) || strCurrency.endsWith(symbol)) {
            return true;
        }
        return false;
    }

    public String getColorInHexCode(String colorInRGB) throws Exception {
        String[] hexValue = colorInRGB.replace("rgba(", "").replace(")", "").split(",");
        int hexValue1 = Integer.parseInt(hexValue[0]);
        hexValue[1] = hexValue[1].trim();
        int hexValue2 = Integer.parseInt(hexValue[1]);
        hexValue[2] = hexValue[2].trim();
        int hexValue3 = Integer.parseInt(hexValue[2]);
        String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
        System.out.println(actualColor);
        return actualColor;
    }

    public String getColorInRGB(String colorStrInHex) {
        int r = Integer.valueOf(colorStrInHex.substring(1, 3), 16);
        int g = Integer.valueOf(colorStrInHex.substring(3, 5), 16);
        int b = Integer.valueOf(colorStrInHex.substring(5, 7), 16);
        return String.valueOf(r);
    }

    public boolean numberStringSortOrder(List<String> lstNumberString, String strSortOrder) {
        if (lstNumberString.size() > 1) {
            System.out.println("size is " + lstNumberString.size());
            for (int i = 1; i < lstNumberString.size(); i++) {
                String strCurrentNumber = lstNumberString.get(i);
                String strPreviousNumber = lstNumberString.get(i - 1);
                switch (strSortOrder.toLowerCase()) {
                    case "asc":
                    case "acsending":
                        System.out.println("Inside asc");
                        System.out.print(strCurrentNumber.compareTo(strPreviousNumber));
                        if (strCurrentNumber.compareTo(strPreviousNumber) < 0) {
                            return false;
                        }
                        break;
                    case "desc":
                    case "descending":
                        if (strCurrentNumber.compareTo(strPreviousNumber) > 0) {
                            return false;
                        }
                        break;
                }
            }
        }
        return true;
    }

    public boolean checkExpListInActList(List<List<String>> expList, List<List<String>> actList) {
        Collection<List<String>> expectedList = expList;
        Collection<List<String>> actualList = actList;
        Collection<List<String>> similar = new HashSet<List<String>>(expectedList);
        Collection<List<String>> different = new HashSet<List<String>>(expectedList);

        similar.retainAll(actualList);
        different.removeAll(actualList);
        System.out.printf("One:%s%nTwo:%s%nSimilar:%s%nDifferent:%s%n", expectedList, actualList, similar, different);
        if (!(similar.size() == expectedList.size())) {
            return false;
        }
        return true;
    }

    public List<Integer> compareTwoStringList(List<List<String>> firstList, List<List<String>> secondList, String strKeyCol) {
        //create a dummy list to store the compared row and the number of matches
        List<Integer> comparingList = new ArrayList<Integer>();
        for (int a = 0; a < firstList.size(); a++) {
            comparingList.add(0);
        }
        int iMatchedCount = 0;
        int firstListKeyIndex = 0;
        int secondListKeyIndex = 0;
        boolean iMatched = false;
        String strFirstListColValue = "";
        String strSecondListColValue = "";

        //Identify the key column index in first list
        for (int iFirstListCol = 0; iFirstListCol < firstList.get(0).size(); iFirstListCol++) {
            if (firstList.get(0).get(iFirstListCol).equals(strKeyCol)) {
                firstListKeyIndex = iFirstListCol;
                System.out.println("first list level col index===========" + firstListKeyIndex);
            }
        }
        //Identify the key column index in second list
        for (int iSecondListCol = 0; iSecondListCol < secondList.get(0).size(); iSecondListCol++) {
            if (secondList.get(0).get(iSecondListCol).equals(strKeyCol)) {
                secondListKeyIndex = iSecondListCol;
                System.out.println("second list level col index===========" + secondListKeyIndex);
            }
        }

        //Now iterate through both lists and compare values.
        //Do the comparison only when key coolumn value is matched in both list, else error.
        for (int iFirstListRow = 1; iFirstListRow < firstList.size(); iFirstListRow++) {
            iMatchedCount = 0;
            iMatched = false;
            for (int iSecondListRow = 1; iSecondListRow < secondList.size(); iSecondListRow++) {
                System.out.println("firstList.get(iFirstListRow).get(firstListKeyIndex)=================" + firstList.get(iFirstListRow).get(firstListKeyIndex));
                System.out.println("secondList.get(iSecondListRow).get(secondListKeyIndex)=============" + secondList.get(iSecondListRow).get(secondListKeyIndex));
                if (secondList.get(iSecondListRow).get(secondListKeyIndex).equals(firstList.get(iFirstListRow).get(firstListKeyIndex))) {
                    for (int iFirstListCol = 0; iFirstListCol < firstList.get(iFirstListRow).size(); iFirstListCol++) {
                        for (int iSecondListCol = 0; iSecondListCol < secondList.get(iSecondListRow).size(); iSecondListCol++) {
                            strFirstListColValue = firstList.get(iFirstListRow).get(iFirstListCol);
                            strSecondListColValue = secondList.get(iSecondListRow).get(iSecondListCol);
                            //matching the header to do further comparison
                            if (secondList.get(0).get(iSecondListCol).equals(firstList.get(0).get(iFirstListCol))) {
                                if (strFirstListColValue.equals(strSecondListColValue)) {
                                    System.out.println(strFirstListColValue + "=" + strSecondListColValue);
                                    iMatchedCount++;
                                    iMatched = true;
                                    break;
                                }
                            }
                        }
                        //Check if the value is the column value is available
                        //Check if the record is available
                        if (!iMatched) {
                            Assert.assertTrue(iMatched);
                            System.out.println("Column value :" + strFirstListColValue);
                        }
                    }
                    //Check if the record is available
                    if (!iMatched) {
                        Assert.assertTrue(iMatched);
                        System.out.println("No proper match found");
                    }
                }
            }
            System.out.println("rowCounter" + iFirstListRow + ":Match flag:" + iMatchedCount);
            comparingList.set(iFirstListRow, iMatchedCount);
        }
        return comparingList;
    }

}
