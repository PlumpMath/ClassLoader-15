package com.jiangnan.classloader.load;

import org.junit.Test;


public class LoadTest {

	/**
	 * 仅加载
	 */
	@Test
	public void testLoad1() {
		System.out.println(Person.class.getName());
	}
	
	@Test
	public void testLoad2() {
		System.out.println(Person.getHands());
	}

	@Test
	public void testLoad3() {
		Person person1 = new Person();
		Person person2 = new Person();
	}
	
	@Test
	public void testLoad4() {
		System.out.println(User.age1);
		System.out.println(User.age2);
	}
	
	@Test
	public void testLoad5() {
		User user = new User();
		System.out.println(User.age1);
		System.out.println(User.age2);
	}
}
