package com.jiangnan.classloader.load;

public class User extends Person {
	public static int age1 = 0;
	static {
		System.out.println("User static set age1 = 2");
		age1 = 2;
	}
	public static int age2;
	private static User user = new User();
	
	public User() {
		System.out.println("User construct execute");
		age1++;
		age2++;
	}
}
