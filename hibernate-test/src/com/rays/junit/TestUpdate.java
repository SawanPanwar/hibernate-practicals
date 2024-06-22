package com.rays.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestUpdate {

	@Test
	public void update() throws Exception {

		UserBean bean = UserModel.findByPk(15);

		bean.setName("ravi");

		UserModel.update(bean);

		bean = UserModel.findByPk(15);

		assertEquals("ravi", bean.getName());

	}

}
