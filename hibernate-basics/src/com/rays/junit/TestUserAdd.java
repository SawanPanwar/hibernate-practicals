package com.rays.junit;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestUserAdd {

	@Test
	public void testAdd() throws Exception {

		UserBean bean = new UserBean();
		bean.setId(15);
		bean.setName("vinjal");
		bean.setSalary(5000);

		UserModel model = new UserModel();

		model.add(bean);

		bean = model.findByPk(16);

		assertNotNull("record is not added", bean);

	}

}
