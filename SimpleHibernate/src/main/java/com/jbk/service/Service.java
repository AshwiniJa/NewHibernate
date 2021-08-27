package com.jbk.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jbk.config.HibernateConfiguration;
import com.jbk.entity.User;

public class Service {

	public User prepareUser() {
		User user = new User();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Id");
		user.setId(scanner.nextInt());
		System.out.println("Enter name");
		user.setName(scanner.next());
		System.out.println("Enter City");
		user.setCity(scanner.next());
		System.out.println("Enter Department");
		user.setDepartment(scanner.next());
		System.out.println("Enter Phone");
		user.setPhone(scanner.next());
		System.out.println("Enter Salary");
		user.setSalary(scanner.nextDouble());
		return user;
	}

	public String saveUser(User user) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(user);
		transaction.commit();
		return "User Added";
	}

	public User getUserById(int id) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();

		User user = session.get(User.class, id);
		return user;
	}

	public String updateUser(User user) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.update(user);
		session.beginTransaction().commit();

		return "Record Updated";
	}

	public List<User> listOfUser() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		List<User> users = criteria.list();
		return users;
	}

	public List<User> listOfUser_ASC_Name() {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(3);
		criteria.addOrder(Order.asc("name"));

		List<User> users = criteria.list();
		return users;
	}

	public List<User> maxSalaryUsers(double salary) {
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.addOrder(Order.asc("name"));
		criteria.add(Restrictions.gt("salary", salary));
		
		
		List<User> users = criteria.list();

		return users;

	}

	public String deleteUser(int id1) {
		// TODO Auto-generated method stub
		return null;
	}

}
