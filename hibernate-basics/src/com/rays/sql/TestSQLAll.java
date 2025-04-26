package com.rays.sql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestSQLAll {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		SQLQuery q = session.createSQLQuery("select * from st_user");

		List list = q.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			Object[] dto = (Object[]) it.next();
			System.out.print(dto[0]);
			System.out.print("\t" + dto[1]);
			System.out.print("\t" + dto[2]);
			System.out.print("\t" + dto[3]);
			System.out.print("\t" + dto[4]);
			System.out.print("\t" + dto[5]);
			System.out.println("\t" + dto[6]);
		}
		tx.commit();
		session.close();
	}
}