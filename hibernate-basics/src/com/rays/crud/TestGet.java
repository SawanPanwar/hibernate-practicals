package com.rays.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestGet {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto = (UserDTO) session.get(UserDTO.class, 1);

		System.out.print(dto.getId());
		System.out.print("\t" + dto.getFirstName());
		System.out.print("\t" + dto.getLastName());
		System.out.print("\t" + dto.getLoginId());
		System.out.print("\t" + dto.getPassword());
		System.out.print("\t" + dto.getDob());
		System.out.println("\t" + dto.getAddress());

		session.close();
	}
}