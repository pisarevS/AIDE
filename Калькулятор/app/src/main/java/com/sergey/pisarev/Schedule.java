package com.sergey.pisarev;

import java.text.*;
import java.util.*;
import android.app.*;
import android.widget.*;

public class Schedule {
	String date1=null;
	String date2=null;
	int n=0;

	Schedule(String date2) {
		this.date2 = date2;
	}

	void choiceShift(String shift) {
		switch (shift) {
			case "См.\"А\"":
				date1 = ("11.07.2018");
				break;
			case "См.\"Б\"":
				date1 = ("10.07.2018");
				break;
			case "См.\"В\"":
				date1 = ("12.07.2018");
				break;
			case "См.\"Г\"":
				date1 = ("13.07.2018");
				break;
		}
	}

	int howShiftWorks() {   
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date dateOne = null;
		Date dateTwo = null;
		try {
			dateOne = format.parse(date1);
			dateTwo = format.parse(date2);
		}
		catch ( Exception e) {	}
		long difference = dateOne.getTime() - dateTwo.getTime();
		int days =  (int)(difference / (24 * 60 * 60 * 1000));
		n = Math.abs(days) % 4;
		return n;
	}
	

}


