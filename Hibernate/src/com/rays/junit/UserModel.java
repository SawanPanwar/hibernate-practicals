package com.rays.junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.junit.UserBean;

public class UserModel {

	public static Integer nextPk() throws Exception {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/advance", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select max(id) from user");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

		}
		return pk + 1;
	}

	public static UserBean findByPk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/advance", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from user where id = ?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setSalary(rs.getInt(1));

		}
		return bean;

	}

	public UserBean findByLogin(String name) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/advance", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from user where name = ?");

		ps.setString(1, name);

		ResultSet rs = ps.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setSalary(rs.getInt(1));

		}
		return bean;

	}

	public static void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/advance", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into user values(?, ?, ?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getSalary());

		int i = ps.executeUpdate();

		System.out.println("Data Inserted " + i);

	}

	public void update(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/advance", "root", "root");

		PreparedStatement ps = conn.prepareStatement("update user set name = ?, salary = ? where id = ?");

		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getSalary());
		ps.setInt(3, bean.getId());

		int i = ps.executeUpdate();

		System.out.println("Data Updated " + i);

	}

}
