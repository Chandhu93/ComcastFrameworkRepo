package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		
		// return new Random().nextInt(6999); code optimzation
		
		Random ran= new Random();
		int randomNumber = ran.nextInt(5000);
		return randomNumber;
	}

	public String getSystemDateyyyMMdd() {
		
		// return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy_HH:mm:ss"));
		
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		String date= sdf.format(dateObj);
		return date;
	}
	
	public String getRequriesDate(int days) {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		sdf.format(dateObj);
		Calendar cal =sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sdf.format(cal.getTime());
		return reqDate;
	}
	
	
	
	
	
	
	
	
	
}
