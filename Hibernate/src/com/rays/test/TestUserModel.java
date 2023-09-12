package com.rays.test;

import java.util.Date;

import com.rays.dto.UserDTO;
import com.rays.model.UserModel;

public class TestUserModel {

	public static void main(String[] args) {

		// testAdd();
		// testUpdate();
		// testAuth();
		testFindByPk();

	}

	private static void testFindByPk() {

		UserModel model = new UserModel();

		UserDTO dto = model.findByPk(1);

		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLoginId());
		System.out.println(dto.getPassword());
		System.out.println(dto.getDob());
		System.out.println(dto.getAddress());

	}

	private static void testAuth() {

		UserModel model = new UserModel();

		UserDTO dto = model.authenticate("arun12@gmail.com", "123");

		if (dto != null) {

			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLoginId());
			System.out.println(dto.getPassword());
			System.out.println(dto.getDob());
			System.out.println(dto.getAddress());

		} else {

			System.out.println("User not exist...!!!");

		}

	}

	private static void testUpdate() {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("arun");
		dto.setLastName("ojha");
		dto.setLoginId("arun123@gmail.com");
		dto.setPassword("123");
		dto.setDob(new Date());
		dto.setAddress("indore");

		UserModel model = new UserModel();

		model.update(dto);

	}

	private static void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("arun");
		dto.setLastName("ojha");
		dto.setLoginId("arun@gmail.com");
		dto.setPassword("123");
		dto.setDob(new Date());
		dto.setAddress("indore");

		UserModel model = new UserModel();

		model.add(dto);

	}

}
