package com.jiangnan.classloader.classloader;

import org.junit.Test;

public class ClassLoaderTest {
	
	@Test
	public void testClassLoader1() {
		System.out.println(this.getClass().getClassLoader());
		new User();
		System.out.println("String loaded by " + String.class.getClassLoader());
	}
	
	@Test
	public void testClassLoader2() {
		ClassLoader classLoader = this.getClass().getClassLoader();
		while(true) {
			System.out.println(classLoader);
			if (null == classLoader) {
				break;
			}
			classLoader = classLoader.getParent();
		}
	}
	
	@Test
	public void testClassLoader3() {
		MyClassLoader classLoader1 = new MyClassLoader("loader1", "E:\\classloader\\path1");
		Class<?> clazz1;
		try {
			clazz1 = classLoader1.loadClass("com.jiangnan.classloader.classloader.User");
			clazz1.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("---------1----------");
		MyClassLoader classLoader2 = new MyClassLoader("loader1", "E:\\classloader\\path2", classLoader1);
		Class<?> clazz2;
		try {
			clazz2 = classLoader2.loadClass("com.jiangnan.classloader.classloader.User");
			clazz2.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("---------2----------");
	}
}
