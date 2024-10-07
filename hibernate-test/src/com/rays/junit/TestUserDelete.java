package com.rays.junit;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TestUserDelete {

	@Test
	public void delete() throws Exception {

		UserModel.delete(14);

		UserBean bean = UserModel.findByPk(13);

		assertNull("data not deleted", bean);
	}
}
