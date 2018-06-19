package poferries;
	// test
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.*;
	public class DateUtility
	{
	    public static void main(String args[]){
	        System.out.println(dayName("2015-03-05 00:00:00", "YYYY-MM-DD HH:MM:ss"));
	    }
	    public static String dayName(String inputDate, String format){
	        Date date = null;
	        
	        try {
	            date = new SimpleDateFormat(format).parse(inputDate);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
	    }
	}