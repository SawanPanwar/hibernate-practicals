package com.rays.junit;

import junit.framework.TestSuite;

public class TestAllSuite {

	public static void main(String[] args) {

		TestSuite suite = new TestSuite("Test All");

		suite.addTestSuite(TestUserAdd.class);
		suite.addTestSuite(TestUserUpdate.class);
		suite.addTestSuite(TestUserDelete.class);

		junit.textui.TestRunner.run(suite);
	}
}