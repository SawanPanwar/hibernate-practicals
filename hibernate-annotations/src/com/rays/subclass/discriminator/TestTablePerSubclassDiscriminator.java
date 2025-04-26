package com.rays.subclass.discriminator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestTablePerSubclassDiscriminator {

	public static void main(String[] args) {

		CreditCardPayment ccp = new CreditCardPayment();
		ccp.setAmount(1000);
		ccp.setPaymentType("credit card");
		ccp.setCcType("VISA");

		Cash c = new Cash();
		c.setAmount(10000);
		c.setPaymentType("cash");

		Cheque ch = new Cheque();
		ch.setAmount(5000);
		ch.setPaymentType("cheque");
		ch.setBankName("Axis");
		ch.setChqNumber("AXIS12345");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(ccp);
		session.save(c);
		session.save(ch);

		tx.commit();
		session.close();
	}
}