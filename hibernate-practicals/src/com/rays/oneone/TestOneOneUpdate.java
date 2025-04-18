package com.rays.oneone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneOneUpdate {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		Employee e = (Employee) session.get(Employee.class, 1);

		if (e != null) {
			e.setName("abc");
			
			Address empAddress = e.getEmpAddress();
			empAddress.setStreet("street2");
			empAddress.setCity("indore");
		} else {
			System.out.println("Employee not found!");
		}

		tx.commit();
		session.close();
		sf.close();
	}
}
