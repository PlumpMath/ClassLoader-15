package com.jiangnan.classloader.classloader;

public class Person {
	public Person() {
		System.out.println("Person loaded by " + this.getClass().getClassLoader());
	}
}
