package com.rays.oneone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneOne {

	public static void main(String[] args) {

		Address empAddress = new Address();
		empAddress.setStreet("street1");
		empAddress.setCity("indore");

		Employee e = new Employee();
		e.setName("abc");
		e.setEmpAddress(empAddress);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		// Save the Employee object, which will also save the Address object due to
		// CascadeType.ALL
		session.save(e);

		tx.commit();

		session.close();

		sf.close();
	}
}