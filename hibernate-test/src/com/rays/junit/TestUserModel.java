package com.rays.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TestUserModel {

	@Test
	public void testAdd() throws Exception {

		UserBean bean = new UserBean();
		bean.setId(16);
		bean.setName("ajay");
		bean.setSalary(6000);

		UserModel model = new UserModel();

		model.add(bean);

		bean = model.findByPk(16);

		if (bean == null) {

			fail("Record is not added...!!!");

		} else {

			assertNotNull("Record is added", bean);

		}

	}

}
