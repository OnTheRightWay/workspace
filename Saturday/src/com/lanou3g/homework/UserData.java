package com.lanou3g.homework;

public class UserData {
	private static String userData[][]
			={
				{"张三","zhangSan","111111","Worker"},
				{"李四","liSi666","222222","Doctor"},
				{"王五","wangWu888","333333","Cooker"},
				{"赵六","zhaoLiu999","444444","Boss"},
			};

	public static String[][] getUserData() {
		return userData;
	}

	public static void setUserData(String[][] userData) {
		UserData.userData = userData;
	}
}
