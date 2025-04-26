package com.rays.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.rays.user.UserDTO;

public class TestDetachedCriteria {

	public static void main(String[] args) {

		DetachedCriteria dc = DetachedCriteria.forClass(UserDTO.class);

		dc.add(Restrictions.like("firstName", "abc"));

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		List<UserDTO> list = dc.getExecutableCriteria(session).list();

		Iterator it = list.iterator();

		while (it.hasNext()) {
			UserDTO dto = (UserDTO) it.next();
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLoginId());
			System.out.print("\t" + dto.getPassword());
			System.out.print("\t" + dto.getDob());
			System.out.println("\t" + dto.getAddress());
		}
		session.close();
	}
}