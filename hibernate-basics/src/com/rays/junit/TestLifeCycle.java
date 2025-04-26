package com.rays.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLifeCycle {

	@BeforeClass
	public static void beforeClass() throws Exception {
		System.out.println("before class");
	}

	@Before
	public void before() throws Exception {
		System.out.println("before");
	}

	@Test
	public void testFindMax1() {
		System.out.println("Test 01");
		assertEquals(6, Calculation.findMax(new int[] { 1, 3, 4, 2, 6 }));
	}

	@Test
	public void testFindMax2() {
		System.out.println("Test 02");
		assertEquals(6, Calculation.findMax(new int[] { 1, 3, 4, 2, 6 }));
	}

	@After
	public void after() throws Exception {
		System.out.println("after");
	}

	@AfterClass
	public static void afterClass() throws Exception {
		System.out.println("after class");
	}
}