package com.lanou3g.homework;

import java.util.ArrayList;
import java.util.List;

public class UserData {
	private static List<Person> userData = new ArrayList<Person>();

	public static List<Person> getUserData() {
		return userData;
	}

	public static void setUserData(List<Person> userData) {
		UserData.userData = userData;
	}
}
