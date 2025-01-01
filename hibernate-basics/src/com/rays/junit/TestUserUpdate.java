package com.rays.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestUserUpdate {

	@Test
	public void update() throws Exception {

		UserBean bean = UserModel.findByPk(15);

		bean.setName("suraj");

		UserModel.update(bean);

		bean = UserModel.findByPk(15);

		assertEquals("suraj", bean.getName());

	}
}
