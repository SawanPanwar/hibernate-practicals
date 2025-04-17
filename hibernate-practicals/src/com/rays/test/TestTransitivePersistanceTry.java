package com.rays.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.auction.AuctionItem;
import com.rays.auction.Bid;

public class TestTransitivePersistanceTry {

	public static void main(String[] args) {

		Bid bid = new Bid();
		bid.setId(4);
		bid.setAmount(4000);
		bid.setTimeStamp("AAAA");

		Set s = new HashSet();

		s.add(bid);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		AuctionItem item = (AuctionItem) session.get(AuctionItem.class, 1);

		item.setBids(s);

		tx.commit();

		session.close();
	}
}