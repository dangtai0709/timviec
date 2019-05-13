package common;

import java.time.LocalTime;

/**
 * TimeProcess.java
 * 
 * Date: Aug 15, 2018
 * 
 * DATE               AUTHOR          DESCRIPTION				
 * -------------------------------------------------				
 * Aug 15, 2018        DanTT           Create				
 */
public class TimeProcess {
	public static String getEndTime(String startTime, int delay) {
		int endHours = Integer.valueOf(startTime.substring(0, 2)) + delay;
		return String.format("%02d",endHours) + startTime.substring(2);
	}
	
	public static boolean isBetween(LocalTime candidate, LocalTime start, LocalTime end) {
		return !candidate.isBefore(start) && !candidate.isAfter(end); 
	}
}
