package com.rays.junit;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TestDelete {

	@Test
	public void delete() throws Exception {

		UserModel.delete(11);

		UserBean bean = UserModel.findByPk(11);

		assertNull(bean);

	}
}
