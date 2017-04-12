package com.chapter15.generic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Definition {
	Date date = new Date();
	String s = (new SimpleDateFormat("yyyy-mm-dd").format(date));
	
}

