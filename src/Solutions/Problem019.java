package Solutions;
/*
 * Author - Alexander Kohler
 * 
 */
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Problem019 {

	
	/*
	 	You are given the following information, but you may prefer to do some research for yourself.
		1 Jan 1900 was a Monday.
	
Thirty days has September,
		April, June and November.
		All the rest have thirty-one,
	
Saving February alone,
		Which has twenty-eight, rain or shine.
	
And on leap years, twenty-nine.
		A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
	
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
	 */
	
	//Metrics - 110 ms
	
	static int countSundays()

{
	
Date date = new GregorianCalendar(1901, 1, 1).getTime();
		Date endDate = new GregorianCalendar(2000, 12, 31).getTime();
		int sundayCount = 0;
		int SUNDAY = 1;
	
int mon = 0;
		Calendar c = Calendar.getInstance();
		int dow = c.get(Calendar.DAY_OF_WEEK);
		while (date.compareTo(endDate) <= 0) //
	
{
	
c.setTime(date);
		dow = c.get(Calendar.DAY_OF_WEEK);
		mon = c.get(Calendar.DAY_OF_MONTH);
		if (dow == SUNDAY && mon == 1)
		
sundayCount++;
		
		c.add(Calendar.DATE, 1);  //add one date
	
date = c.getTime();
		}
			
		return sundayCount;
	}
	
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
	
System.out.println(countSundays());
		long endTime = System.currentTimeMillis();
		System.out.println("That took " + (endTime - startTime) + " milliseconds");

}

}