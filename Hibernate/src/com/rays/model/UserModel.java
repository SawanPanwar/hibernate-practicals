package com.rays.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class UserModel {

	public void add(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(dto);

		tx.commit();

		session.close();

	}

	public void update(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.update(dto);

		tx.commit();

		session.close();

	}

	public void delete(UserDTO dto) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.delete(dto);

		tx.commit();

		session.close();

	}

	public UserDTO authenticate(String loginId, String password) {

		UserDTO dto = null;

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Query q = session.createQuery("from UserDTO where loginId = ? and password = ?");

		q.setString(0, loginId);
		q.setString(1, password);

		List list = q.list();

		if (list.size() > 0) {

			dto = (UserDTO) list.get(0);

		}

		return dto;

	}

	public UserDTO findByPk(int id) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		UserDTO dto = (UserDTO) session.get(UserDTO.class, id);

		return dto;

	}

}
