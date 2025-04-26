package com.rays.auction;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestAuction {

	public static void main(String[] args) {

		Bid bid1 = new Bid();
		bid1.setAmount(1000);
		bid1.setTimeStamp("A");

		Bid bid2 = new Bid();
		bid2.setAmount(2000);
		bid2.setTimeStamp("AA");

		Bid bid3 = new Bid();
		bid3.setAmount(3000);
		bid3.setTimeStamp("AAA");

		Set<Bid> bids = new HashSet<>();
		bids.add(bid1);
		bids.add(bid2);
		bids.add(bid3);

		AuctionItem item = new AuctionItem();
		item.setDescription("auction 1");
		item.setBids(bids);

		// Set the auction item for each bid
		bid1.setAuctionItem(item);
		bid2.setAuctionItem(item);
		bid3.setAuctionItem(item);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.save(item);

		tx.commit();
		session.close();
		sf.close();
	}
}