package com.rays.criteria;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Criteria criteria = session.createCriteria(AuctionItem.class);

		criteria.setFetchMode("item_id", FetchMode.JOIN);

		criteria.add(Restrictions.eq("id", 2));

		List list = criteria.list();

		Iterator it = list.iterator();

		while (it.hasNext()) {

			AuctionItem action = (AuctionItem) it.next();

			System.out.print(action.getId());

			System.out.print("\t" + action.getDescription());

			Set s = action.getBids();

			Iterator it1 = s.iterator();

			while (it1.hasNext()) {
				Bid object = (Bid) it1.next();
				System.out.print("\t" + object.getId());
				System.out.print("\t" + object.getAmount());
				System.out.println("\t" + object.getTimeStamp());
			}

		}
		session.close();
	}

}
