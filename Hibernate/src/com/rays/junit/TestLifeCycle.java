package com.rays.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rays.junit.Calculation;

public class TestLifeCycle {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before");
	}

	@Test
	public void testFindMax() {
		System.out.println("Test");
		assertEquals(6, Calculation.findMax(new int[] { 1, 3, 4, 2, 6 }));
		assertEquals(1, Calculation.findMax(new int[] { -12, 1, -3, -4, -2 }));
	}

	@Test
	public void testFindMax1() {
		System.out.println("Test");
		assertEquals(6, Calculation.findMax(new int[] { 1, 3, 4, 2, 6 }));
		assertEquals(-1, Calculation.findMax(new int[] { -12, 1, -3, -4, -2 }));
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

}
