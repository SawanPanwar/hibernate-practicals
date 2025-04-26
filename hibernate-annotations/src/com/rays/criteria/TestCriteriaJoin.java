package com.rays.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rays.auction.AuctionItem;
import com.rays.auction.Bid;

public class TestCriteriaJoin {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(AuctionItem.class);
		criteria.setFetchMode("bids", FetchMode.JOIN);
		criteria.add(Restrictions.eq("id", 1));
		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List<AuctionItem> list = criteria.list();

		for (AuctionItem auction : list) {
			System.out.println(auction.getId() + " : " + auction.getDescription());

			for (Bid bid : auction.getBids()) {
				System.out.println(bid.getId() + " : " + bid.getAmount() + " : " + bid.getTimeStamp());
			}
		}
		session.close();
		sessionFactory.close();
	}
}