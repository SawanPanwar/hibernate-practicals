package com.rays.criteria;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDTO;

public class TestDetachedCriteria {

	public static void main(String[] args) {

		DetachedCriteria dc = DetachedCriteria.forClass(UserDTO.class);

		dc.add(Restrictions.eq("firstName", "aman"));

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session1 = sf.openSession();

		List<UserDTO> list1 = dc.getExecutableCriteria(session1).list();

		Iterator it1 = list1.iterator();

		while (it1.hasNext()) {

			UserDTO dto = (UserDTO) it1.next();

			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLoginId());
			System.out.print("\t" + dto.getPassword());
			System.out.print("\t" + dto.getDob());
			System.out.println("\t" + dto.getAddress());

		}

		session1.close();

		Session session2 = sf.openSession();

		List<UserDTO> list2 = dc.getExecutableCriteria(session2).list();

		Iterator it2 = list2.iterator();

		while (it2.hasNext()) {

			UserDTO dto = (UserDTO) it2.next();

			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLoginId());
			System.out.print("\t" + dto.getPassword());
			System.out.print("\t" + dto.getDob());
			System.out.println("\t" + dto.getAddress());
		}
		session2.close();
	}

}
