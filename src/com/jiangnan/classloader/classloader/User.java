package com.jiangnan.classloader.classloader;

public class User {
	public User() {
		System.out.println("User loaded by " + this.getClass().getClassLoader());
		new Person();
	}
}
