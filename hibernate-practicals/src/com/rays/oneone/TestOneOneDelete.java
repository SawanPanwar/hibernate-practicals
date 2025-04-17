package com.rays.oneone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneOneDelete {

	public static void main(String[] args) {

		Employee e = new Employee();

		e.setId(1);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.delete(e);

		tx.commit();

		session.close();
	}
}