package com.rays.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.user.UserDTO;

public class TestDelete {

	public static void main(String[] args) {

		UserDTO dto = new UserDTO();
		dto.setId(3);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.delete(dto);

		tx.commit();
		session.close();
	}
}