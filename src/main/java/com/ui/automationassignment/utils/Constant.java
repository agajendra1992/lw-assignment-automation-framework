package com.ui.automationassignment.utils;

import java.util.HashMap;

public class Constant {

	/**
	 * This static variable  is used for element time to be load.
	 */
	public static int timeout = 30;
	public static int polltime = 5;

	/**
	 * This static object is used for saved the run time value in haspmap usng key value pair.
	 */
	public static HashMap<String, String> savedValues = new HashMap<String, String>();
	/**
	 * This static method is used for get the savedvalue from haspmap usng key.
	 */
	public static String getSavedValues(String key) {
		return savedValues.get(key);
	}

}
