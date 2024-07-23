package com.rays.junit;

import junit.framework.TestSuite;

public class TestAllSuite {

	public static void main(String[] args) {

		TestSuite suite = new TestSuite("Test All");
		suite.addTestSuite(TestAssertNotNull.class);
		suite.addTestSuite(TestAssertNull.class);

		junit.textui.TestRunner.run(suite);

	}
}
