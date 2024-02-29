package com.rays.junit;

import junit.framework.TestSuite;

public class TestAllSuite {

	public static void main(String[] args) {

		junit.textui.TestRunner.run(getSuite());

	}

	public static TestSuite getSuite() {

		TestSuite suite = new TestSuite("Test All");
		suite.addTestSuite(TestAssertNotNull.class);
		suite.addTestSuite(TestAssertNull.class);
		return suite;

	}

}
