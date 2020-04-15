package co.uk.directlinegroup.tt.utils.common;

import co.uk.directlinegroup.tt.pages.CommonPage;
import co.uk.directlinegroup.tt.pages.NextEventPage;
import co.uk.directlinegroup.tt.pages.QuoteDetailsPage;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DateOperations {
    private CommonPage commonPageObj = new CommonPage();
    private NextEventPage nextEventPageObj = new NextEventPage();
   // private QuoteAndBuyOperations quoteAndBuyOperationsObj = new QuoteAndBuyOperations();
    private QuoteDetailsPage quoteDetailsPageObj = new QuoteDetailsPage();
   // private PolicyOperations policyOperationsObj = new PolicyOperations();

    public String dateValues="";
    public String dateCellValue = "";
    public String sMonth="";
    public String sDate="";
    public String futureMonth="";
    public String futureYear="";

    public boolean isThisDateValid(String dateToValidate, String dateFromat) {
        if (dateToValidate == null || dateToValidate.isEmpty()) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(dateToValidate);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public int getMonthsBetWeenTwoDates(String strFromDate, String strToDate, String strDateFormat) {
        DateFormat df = new SimpleDateFormat(strDateFormat);
        Calendar startCalendar = new GregorianCalendar();
        try {
            startCalendar.setTime(df.parse(strFromDate));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        Calendar endCalendar = new GregorianCalendar();
        try {
            endCalendar.setTime(df.parse(strToDate));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
        return diffMonth;
    }

    public boolean compareDateSortOrder(String sortOrder, String dateFormat, List<String> strDates) {
        DateFormat df = new SimpleDateFormat(dateFormat);
        if (strDates.size() > 1) {
            for (int i = 1; i < strDates.size(); i++) {
                String strDateCurrent = strDates.get(i);
                String strDatePrevious = strDates.get(i - 1);
                switch (sortOrder.toLowerCase()) {
                    case "asc":
                    case "acsending":
                        try {
                            if (df.parse(strDateCurrent).compareTo(df.parse(strDatePrevious)) < 0) {
                                return false;
                            }
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    case "desc":
                    case "descending":
                        try {
                            if (df.parse(strDateCurrent).compareTo(df.parse(strDatePrevious)) > 0) {
                                return false;
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        }
        return true;
    }

    public boolean compareTwoDates(String strDate1, String strDate2, String strDateFormat, String strOperand) {
        DateFormat df = new SimpleDateFormat(strDateFormat);
        try {
            switch (strOperand) {
                case "=":
                    if (df.parse(strDate1).compareTo(df.parse(strDate2)) > 0 || df.parse(strDate1).compareTo(df.parse(strDate2)) < 0) {
                        return false;
                    }
                    break;

                case ">":
                    if (df.parse(strDate1).compareTo(df.parse(strDate2)) < 0 || df.parse(strDate1).compareTo(df.parse(strDate2)) == 0) {
                        return false;
                    }
                    break;

                case "<":
                    if (df.parse(strDate1).compareTo(df.parse(strDate2)) > 0 || df.parse(strDate1).compareTo(df.parse(strDate2)) == 0) {
                        return false;
                    }
                    break;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }

    public String getCurrentDate() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date();
        String strDate = dateFormat.format(date);
        return strDate;
    }

    public String date(String dateInString, String dateFromat) {
        if (dateInString == null || dateInString.isEmpty()) {
            return "";
        }
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat InputFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();

        String dateOutString = "";
        try {
            Date date = InputFormat.parse(dateInString);
            cal.setTime(date);
            cal.set(Calendar.HOUR, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            dateOutString = outputFormat.format(cal.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateOutString;
    }

    public int differenceBetweenTwoDateInDays(String fromDate, String toDate) throws ParseException {

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dateFrom = df.parse(fromDate);
        Date dateTo = df.parse(toDate);
        long diff = dateTo.getTime() - dateFrom.getTime();
        int diffDays = (int) (diff / (1000 * 60 * 60 * 24));
        System.out.println("days------------" + diffDays);
        System.out.println(dateFrom);
        return diffDays;
    }

    public String addingDays(int noOfDays) {
        String sf = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String date = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(sf));
            c.add(Calendar.DATE, noOfDays);  // number of days to add
            date = sdf.format(c.getTime());  // dt is now the new date
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(10000L );
        } catch (InterruptedException e) {

        }
        return date;
    }
    public String addingDaysSpecificFormat(int noOfDays) {
        String sf = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        String date = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(sf));
            c.add(Calendar.DATE, noOfDays-1);  // number of days to add
            date = sdf.format(c.getTime());  // dt is now the new date
            System.out.println("Date needs to be selected is from TRY----"+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Date needs to be selected is from TRY----"+date);
        return date;
    }
    public String subDaysSpecificFormat(int noOfDays) {
        String sf = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        String date = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(sf));
            c.add(Calendar.DATE, -noOfDays);  // number of days to add
            date = sdf.format(c.getTime());  // dt is now the new date
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public void selectddMMYYYDateFromCalendar(String strDate){
        System.out.println("strDate==="+ strDate);
        String strDay = strDate.substring(0,2);
        String strMonth = strDate.substring(3,5).trim();
        String strYear = strDate.substring(6);
        int iMonth = Integer.parseInt(strMonth);
        //Get month in full calendar formmat
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        strMonth = monthNames[iMonth];

        new Select(commonPageObj.year()).selectByVisibleText(strYear);
        new Select(commonPageObj.month()).selectByVisibleText(strMonth);
        commonPageObj.day(strDay).click();
    }

    public void dateCalendarFromDateGuest(String fieldValue) {
        String[] tripDetails = fieldValue.split(";");
        if (tripDetails[0].equalsIgnoreCase("currentdate")||tripDetails[0].equalsIgnoreCase("today")) {

            dateValues = this.tripDate(tripDetails[0]);
            System.out.println("dateval:" + dateValues);
        } else {
            dateValues = tripDetails[0];
            System.out.println("dateval:" + dateValues);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sMonthYear = new SimpleDateFormat("MMMM YYYY");
        SimpleDateFormat sDt = new SimpleDateFormat("dd");
        try {
            sMonth = sMonthYear.format(sdf.parse(dateValues));
            sDate = sDt.format(sdf.parse(dateValues));
        } catch (ParseException p) {
            System.out.println("Parse Exception : " + p);
        }
        futureMonth = sMonth.trim().split(" ")[0];
        futureYear = sMonth.trim().split(" ")[1];
        System.out.println("Date Format-Year---" + futureYear);
        System.out.println("Date Format-Month---" + futureMonth);
        System.out.println("*****Future-date***" + sDate);

        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.lblmonth());
        nextEventPageObj.waitForMoreTime();
        System.out.println("Month needs to be selected is -------------" + futureMonth);
//                selectYear = new Select(quoteDetailsPageObj.drpdnToYear());
//                selectMonth = new Select(quoteDetailsPageObj.drpdnToMonth());
//                new Select(quoteDetailsPageObj.drpdnToYear()).selectByVisibleText(futureYear);
        nextEventPageObj.waitForMoreTime();
        System.out.println("Clicking Calendar----------");
        new Select(quoteDetailsPageObj.dateTableForTripFromMonthXpathGuest()).selectByVisibleText(futureMonth);
        System.out.println("Selecting Month----------");


        nextEventPageObj.waitForMoreTime();
        if (sDate.startsWith("0")) {
            sDate = sDate.substring(1);
        }
        quoteDetailsPageObj.dateTableForTripFromDateXpathGuest(sDate,futureYear).click();
        nextEventPageObj.waitForMoreTime();
    }




    public void dateCalendarFromDateWedding(String fieldValue) {

        if (fieldValue.equalsIgnoreCase("currentdate") || fieldValue.equalsIgnoreCase("today")|| fieldValue.equalsIgnoreCase("futuredate1month") || fieldValue.equalsIgnoreCase("futuredate6month")
                || fieldValue.equalsIgnoreCase("futuredate1yr") || fieldValue.equalsIgnoreCase("futuredatebyexceeding1yr") || fieldValue.equalsIgnoreCase("futuredate18months")
                || fieldValue.equalsIgnoreCase("backdate1month") || fieldValue.equalsIgnoreCase("nextday") || fieldValue.equalsIgnoreCase("futuredate2month")
                || fieldValue.equalsIgnoreCase("futuredate184days")
                || fieldValue.equalsIgnoreCase("futuredate90days") || fieldValue.equalsIgnoreCase("futuredate31days") || fieldValue.equalsIgnoreCase("futuredate22days")) {

            dateValues = this.tripDate(fieldValue);
            System.out.println("dateval:" + dateValues);
        }
        else {
            dateValues = fieldValue;
            System.out.println("dateval:" + dateValues);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sMonthYear = new SimpleDateFormat("MMMM YYYY");
        SimpleDateFormat sDt = new SimpleDateFormat("dd");
        try {
            sMonth = sMonthYear.format(sdf.parse(dateValues));
            sDate = sDt.format(sdf.parse(dateValues));
        } catch (ParseException p) {
            System.out.println("Parse Exception : " + p);
        }
        futureMonth = sMonth.trim().split(" ")[0];
        futureYear = sMonth.trim().split(" ")[1];
        System.out.println("Date Format-Year---" + futureYear);
        System.out.println("Date Format-Month---" + futureMonth);
        System.out.println("*****Future-date***" + sDate);

        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.lblmonth());
        nextEventPageObj.waitForMoreTime();
        System.out.println(" Month needs to be selected is -------------" + futureMonth);
//                selectYear = new Select(quoteDetailsPageObj.drpdnToYear());
//                selectMonth = new Select(quoteDetailsPageObj.drpdnToMonth());
//                new Select(quoteDetailsPageObj.drpdnToYear()).selectByVisibleText(futureYear);
        System.out.println("Clicking Calendar----------");
        quoteDetailsPageObj.tripFromDate().click();
        new Select(quoteDetailsPageObj.drpdnFromMonth()).selectByVisibleText(futureMonth);
        System.out.println("Selecting Month----------");
        nextEventPageObj.waitForMoreTime();
        if (sDate.startsWith("0")) {
            sDate = sDate.substring(1);
        }
       // quoteDetailsPageObj.tripFromDate().click();
        quoteDetailsPageObj.dateTableForTripFromDateXpath(sDate).click();
        nextEventPageObj.waitForMoreTime();
    }


    public void dateCalendarTodateGuest(String fieldValue) {

        String dateValueforToDate = "";
        String sMonthValue = "";
        String sDateValue = "";
        String futureMonthValue = "";
        String futureYearValue = "";
        String dateValues = "";

        String[] tripDetails = fieldValue.split(";");

        if (tripDetails[1].equalsIgnoreCase("currentdate") || tripDetails[1].equalsIgnoreCase("futuredate1month") || tripDetails[1].equalsIgnoreCase("futuredate6month")
                || tripDetails[1].equalsIgnoreCase("futuredate1yr") || tripDetails[1].equalsIgnoreCase("futuredatebyexceeding1yr") || tripDetails[1].equalsIgnoreCase("futuredate18months")
                || tripDetails[1].equalsIgnoreCase("backdate1month") || tripDetails[1].equalsIgnoreCase("nextday") || tripDetails[1].equalsIgnoreCase("futuredate2month")
                || tripDetails[1].equalsIgnoreCase("futuredate184days") || tripDetails[1].equalsIgnoreCase("futuredate89days")
                || tripDetails[1].equalsIgnoreCase("futuredate90days") || tripDetails[1].equalsIgnoreCase("futuredate31days") || tripDetails[1].equalsIgnoreCase("futuredate22days")) {

            dateValues = this.tripDate(tripDetails[1]);
            System.out.println("dateval:" + dateValues);
        }
        else if (tripDetails[1].contains("days")) {

            System.out.println("adding--------------------------DAtes-----------------" + this.addingDaysSpecificFormat(Integer.parseInt(tripDetails[1].split(" ")[0])));
//                        quoteDetailsPageObj.tripToDate().sendKeys(dateOperationsObj.addingDaysSpecificFormat(Integer.parseInt(fieldValue.split(" ")[0])));
            dateValues = this.addingDaysSpecificFormat(Integer.parseInt(tripDetails[1].split(" ")[0]));
            System.out.println("dateval:" + dateValues);

        }


        else {
            dateValues = tripDetails[1];
            System.out.println("dateval:" + dateValues);
        }

        dateValueforToDate = dateValues;
        System.out.println("dateValueForToDate:" + dateValueforToDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sMonthYear = new SimpleDateFormat("MMMM YYYY");
        SimpleDateFormat sDt = new SimpleDateFormat("dd");
        sDateValue = "";
        try {
            sMonthValue = sMonthYear.format(sdf.parse(dateValueforToDate));
            sDateValue = sDt.format(sdf.parse(dateValueforToDate));
        } catch (ParseException p) {
            System.out.println("Parse Exception : " + p);
        }
        futureMonthValue = sMonthValue.trim().split(" ")[0];
        futureYearValue = sMonthValue.trim().split(" ")[1];
        System.out.println("Date Format-Year---" + futureYearValue);
        System.out.println("Date Format-Month---" + futureMonthValue);
        System.out.println("*****Future-date***" + sDateValue);
        int count = 0;
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.lblmonth());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println(" Month needs to be selected is -------------" + futureMonthValue);
        //new Select(quoteDetailsPageObj.drpdnToMonth()).selectByVisibleText(futureMonthValue);
        quoteDetailsPageObj.tripToDate().click();
        System.out.println("Selecting Month----------");
        System.out.println("div testuing --------------"+new Select(quoteDetailsPageObj.drpdnToMonth()).getFirstSelectedOption().getText());
        while(!new Select(quoteDetailsPageObj.drpdnToMonth()).getFirstSelectedOption().getText().equalsIgnoreCase(futureMonthValue) & count<=12)
        {
            System.out.println("Inside selecting mopnth--------------"+new Select(quoteDetailsPageObj.drpdnToMonth()).getFirstSelectedOption().getText());
            quoteDetailsPageObj.nextMonthButtonForToDate().click();
            count++;
        }
        nextEventPageObj.waitForMoreTime();
//        quoteDetailsPageObj.tripToDate().clear();
        quoteDetailsPageObj.tripToDate().click();
        nextEventPageObj.waitForMoreTime();
        if (sDateValue.startsWith("0")) {
            sDateValue = sDateValue.substring(1);
        }
        quoteDetailsPageObj.tripToDate().click();
//        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.dateTableForTripTo());
        System.out.println("Date xcpath ---------------------"+quoteDetailsPageObj.dateTableForTripToDateXpathGuest(sDateValue));
        quoteDetailsPageObj.dateTableForTripToDateXpathGuest(sDateValue).click();
        nextEventPageObj.waitForMoreTime();
    }




    public void dateCalendarToDateWedding(String fieldValue) {
        String dateValueforToDate = "";
        String sMonthValue = "";
        String sDateValue = "";
        String futureMonthValue = "";
        String futureYearValue = "";
        String dateValues = "";

        if (fieldValue.equalsIgnoreCase("currentdate") || fieldValue.equalsIgnoreCase("futuredate1month") || fieldValue.equalsIgnoreCase("futuredate6month")
                || fieldValue.equalsIgnoreCase("futuredate1yr") || fieldValue.equalsIgnoreCase("futuredatebyexceeding1yr") || fieldValue.equalsIgnoreCase("futuredate18months")
                || fieldValue.equalsIgnoreCase("backdate1month") || fieldValue.equalsIgnoreCase("nextday") || fieldValue.equalsIgnoreCase("futuredate2month")
                || fieldValue.equalsIgnoreCase("futuredate184days")
                || fieldValue.equalsIgnoreCase("futuredate90days") || fieldValue.equalsIgnoreCase("futuredate31days") || fieldValue.equalsIgnoreCase("futuredate22days")) {

            dateValues = this.tripDate(fieldValue);
            System.out.println("dateval:" + dateValues);
        }
        else if (fieldValue.contains("days")) {

            System.out.println("adding--------------------------DAtes-----------------" + this.addingDaysSpecificFormat(Integer.parseInt(fieldValue.split(" ")[0])));
//                        quoteDetailsPageObj.tripToDate().sendKeys(dateOperationsObj.addingDaysSpecificFormat(Integer.parseInt(fieldValue.split(" ")[0])));
            dateValues = this.addingDaysSpecificFormat(Integer.parseInt(fieldValue.split(" ")[0]));
            System.out.println("dateval:" + dateValues);

        }

        else {
            dateValues = fieldValue;
            System.out.println("dateval:" + dateValues);
        }

        dateValueforToDate = dateValues;
        System.out.println("dateValueForToDate:" + dateValueforToDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sMonthYear = new SimpleDateFormat("MMMM YYYY");
        SimpleDateFormat sDt = new SimpleDateFormat("dd");
        sDateValue = "";
        try {
            sMonthValue = sMonthYear.format(sdf.parse(dateValueforToDate));
            sDateValue = sDt.format(sdf.parse(dateValueforToDate));
        } catch (ParseException p) {
            System.out.println("Parse Exception : " + p);
        }
        futureMonthValue = sMonthValue.trim().split(" ")[0];
        futureYearValue = sMonthValue.trim().split(" ")[1];
        System.out.println("Date Format-Year---" + futureYearValue);
        System.out.println("Date Format-Month---" + futureMonthValue);
        System.out.println("*****Future-date***" + sDateValue);
int count = 0;
        nextEventPageObj.elementDisplayed(quoteDetailsPageObj.lblmonth());
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        nextEventPageObj.waitForMoreTime();
        System.out.println(" Month needs to be selected is -------------" + futureMonthValue);
//        new Select(quoteDetailsPageObj.drpdnToMonth()).selectByVisibleText(futureMonthValue);
        quoteDetailsPageObj.tripToDate().click();
        System.out.println("Selecting Month----------");
        System.out.println("div testuing --------------"+new Select(quoteDetailsPageObj.drpdnToMonth()).getFirstSelectedOption().getText());
        while(!new Select(quoteDetailsPageObj.drpdnToMonth()).getFirstSelectedOption().getText().equalsIgnoreCase(futureMonthValue) & count <=12)
        {
            System.out.println("Inside selecting mopnth--------------"+new Select(quoteDetailsPageObj.drpdnToMonth()).getFirstSelectedOption().getText());
            quoteDetailsPageObj.nextMonthButtonForToDate().click();
            count++;
        }
        nextEventPageObj.waitForMoreTime();
//        quoteDetailsPageObj.tripToDate().clear();
        quoteDetailsPageObj.tripToDate().click();
        nextEventPageObj.waitForMoreTime();

        if (sDateValue.startsWith("0")) {
            sDateValue = sDateValue.substring(1);
        }
        quoteDetailsPageObj.dateTableForTripToDateXpath(sDateValue).click();
        nextEventPageObj.waitForMoreTime();
    }

    public String tripDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        String returnValue = null;
        switch (date.toLowerCase()) {
            case "currentdate":
            case "today":
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);

                break;
            case "futuredate1month":
                c.add(Calendar.DATE, 30);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate184days":
                c.add(Calendar.DATE, 184);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);

                break;

            case "futuredate90days":
                c.add(Calendar.DATE, 90);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);

                break;
            case "futuredate31days":
                c.add(Calendar.DATE, 31);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);

                break;
            case "futuredate22days":
                c.add(Calendar.DATE, 22);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);

                break;
            case "futuredate2month":
                c.add(Calendar.DATE, 60);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);

                break;
            case "nextday":
                c.add(Calendar.DATE, 1);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);

                break;
            case "futuredate6month":
                c.add(Calendar.MONTH, 6);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate365days":
                c.add(Calendar.DATE, 365);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate1yr":
                c.add(Calendar.YEAR, 1);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredatebyexceeding1yr":

                c.add(Calendar.DATE, 366);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;

            case "futuredate18months":
                c.add(Calendar.MONTH, 18);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "backdate1month":
                c.add(Calendar.MONTH, -1);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "previousdayoftripstartdate":
                c.add(Calendar.DATE, 29);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;
            case "futuredate89days":
                c.add(Calendar.DATE, 89);
                date = sdf.format(c.getTime());
                returnValue = date;
                System.out.println("***** Date ***" + returnValue);
                break;

        }
        return returnValue;
    }

}



