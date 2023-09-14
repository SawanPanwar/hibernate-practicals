package com.rays.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.rays.dto.UserDTO;
import com.rays.model.UserModel;

public class TestUserModel {

	public static void main(String[] args) {

		// testAdd();
		// testUpdate();
		// testAuth();
		// testFindByPk();
		testSearch();

	}

	private static void testSearch() {

		UserDTO dto = new UserDTO();

		dto.setFirstName("aman");

		UserModel model = new UserModel();

		List list = model.search(null, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			dto = (UserDTO) it.next();

			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLoginId());
			System.out.print("\t" + dto.getPassword());
			System.out.print("\t" + dto.getDob());
			System.out.println("\t" + dto.getAddress());

		}

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
		dto.setFirstName("abc");
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

		dto.setId(6);
		dto.setFirstName("pranav");
		dto.setLastName("mahajan");
		dto.setLoginId("pranav@gmail.com");
		dto.setPassword("123");
		dto.setDob(new Date());
		dto.setAddress("indore");

		UserModel model = new UserModel();

		model.add(dto);

	}

}
