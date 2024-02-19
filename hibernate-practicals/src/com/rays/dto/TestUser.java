package com.rays.dto;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.rays.dto.UserDTO;

public class TestUser {

	public static void main(String[] args) {

		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("abc");
		dto.setLastName("xyz");
		dto.setLoginId("abc@gmail.com");
		dto.setPassword("123");
		dto.setDob(new Date());
		dto.setAddress("indore");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();

		session.close();
	}

}
