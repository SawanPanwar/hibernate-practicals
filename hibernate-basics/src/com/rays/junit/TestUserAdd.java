package com.rays.junit;

import org.junit.Test;

import junit.framework.TestCase;

public class TestUserAdd extends TestCase {

	@Test
	public void testAdd() throws Exception {

		UserBean bean = new UserBean();
		bean.setId(8);
		bean.setName("xyz");
		bean.setSalary(5000);

		UserModel model = new UserModel();

		model.add(bean);

		bean = model.findByPk(7);

		assertNotNull("record is not added", bean);
	}
}