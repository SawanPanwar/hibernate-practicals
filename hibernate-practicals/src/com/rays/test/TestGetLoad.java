package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestGetLoad {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto1 = (UserDTO) session.load(UserDTO.class, 5);

		// UserDTO dto1 = (UserDTO) session.get(UserDTO.class, 5);

		System.out.println(dto1);

	}

}
