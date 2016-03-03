package com.jiangnan.classloader.classloader;


public class ClassLoaderTest1 {
	
	public static void main(String[] args) {
		MyClassLoader classLoader1 = new MyClassLoader("loader1", "E:\\classloader\\path1");
		Class<?> clazz1 = null;
		try {
			System.out.println("---------1----------");
			clazz1 = classLoader1.loadClass("com.jiangnan.classloader.classloader.User");
			clazz1.newInstance();
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
		}
		System.out.println("---------1----------");
		MyClassLoader classLoader2 = new MyClassLoader("loader2", "E:\\classloader\\path2", classLoader1);
		Class<?> clazz2 = null;
		try {
			System.out.println("---------2----------");
			clazz2 = classLoader2.loadClass("com.jiangnan.classloader.classloader.User");
			clazz2.newInstance();
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
		}
		System.out.println("---------2----------");
		
		MyClassLoader classLoader3 = new MyClassLoader("loader3", "E:\\classloader\\path3", null);
		Class<?> clazz3 = null;
		try {
			System.out.println("---------3----------");
			clazz3 = classLoader3.loadClass("com.jiangnan.classloader.classloader.User");
			Object obj = clazz3.newInstance();
			//System.out.println(User.class.getClassLoader());
			User user = (User)obj;
		} catch (Exception e) {
			System.out.println(e.getClass().getName());
		}
		System.out.println("---------3----------");
		
		System.out.println("clazz1 == clazz2 is " + (clazz1 == clazz2));
		System.out.println("clazz1 == clazz3 is " + (clazz1 == clazz3));
	}
	
}
