package com.rays.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import junit.framework.TestCase;

public class TestAssertNotNull extends TestCase {

	@Test
	public void testFindByPk() throws Exception {

		UserBean bean = UserModel.findByPk(4);

		assertNotNull("user is not added", bean);

	}

}
