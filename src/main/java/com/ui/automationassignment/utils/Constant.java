package com.ui.automationassignment.utils;

import java.util.HashMap;

public class Constant {

	public static int timeout = 30;
	public static int polltime = 2;

	public static HashMap<String, String> savedValues = new HashMap<String, String>();

	public static String getSavedValues(String key) {
		return savedValues.get(key);
	}

}
