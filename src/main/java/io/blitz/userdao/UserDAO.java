package com.blitz.userdao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blitz.beans.User;
import com.blitz.util.HibernateUtil;

public class UserDAO {
	public int insertUser(User u) {
		Session session = HibernateUtil.getSession();
		
		Transaction tx = null;
		Integer userId = null;
		
		try {
			tx = session.beginTransaction();
			userId = (Integer) session.save(u);
			tx.commit();
			
		}catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
				System.out.println("Insert issue");
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return userId;
	}
	
	public User getuserById(Integer id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		User u = null;
		
		try {
			tx = session.beginTransaction();
			u = (User)session.get(User.class, id);
		
		}catch(HibernateException e) {
			if(tx != null) {
				tx.rollback();
				System.out.println("Get issue");
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		return u;
	}
}
