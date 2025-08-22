package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.auction.AuctionItem;

public class TestDetachment {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		AuctionItem item = (AuctionItem) session.get(AuctionItem.class, 1);

		session.close();

		item.setDescription("auction 1");

		Session session2 = sf.openSession();

		Transaction tx = session2.beginTransaction();

		session2.update(item);

		tx.commit();

		session2.close();
	}
}