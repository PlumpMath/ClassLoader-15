package com.jiangnan.classloader.load;

public class Person {
	private static int hands;
	static {
		System.out.println("Person static set hands = 1");
		hands = 1;
	}
	public Person() {
		System.out.println("Person construct set hands = 2");
		hands = 2;
	}
	public static int getHands() {
		return hands;
	}
}
