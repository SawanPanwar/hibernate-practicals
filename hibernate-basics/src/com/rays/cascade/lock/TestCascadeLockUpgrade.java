package com.rays.cascade.lock;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestCascadeLockUpgrade {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session1 = sf.openSession();
		Transaction tx1 = session1.beginTransaction();

		Employee e1 = (Employee) session1.get(Employee.class, 1);

		session1.lock(e1, LockMode.UPGRADE); // Locking with SELECT FOR UPDATE

		e1.setName("t111");

		Session session2 = sf.openSession();
		Transaction tx2 = session2.beginTransaction();

		Employee e2 = (Employee) session2.get(Employee.class, 1);

		try {
			e2.setName("t222");
			tx2.commit();
		} catch (Exception ex) {
			tx2.rollback();
			System.out.println("Transaction 2 failed due to lock timeout.");
		}
		session2.close();

		tx1.commit(); // The lock will be released here
		session1.close();

		sf.close();
	}
}