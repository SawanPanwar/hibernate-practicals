package com.rays.junit;

import org.junit.Test;

import junit.framework.TestCase;

public class TestUserDelete extends TestCase {

	@Test
	public void testDelete() throws Exception {

		UserModel.delete(8);

		UserBean bean = UserModel.findByPk(8);

		assertNull("data not deleted", bean);

		// assertTrue(bean == null);
		// assertTrue("is not true", bean == null);
	}
}