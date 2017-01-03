package ca.sheridancollege.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.multipart.MultipartFile;

import ca.sheridancollege.beans.Product;
import ca.sheridancollege.beans.Product;

public class DAO {
	
	SessionFactory sessionFactory = new Configuration()
			.configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();
	
	
	public void addProduct(Product product){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(product);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Product> viewProducts(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Product.class);
		List<Product> products = (List<Product>) criteria.list();

		session.getTransaction().commit();
		session.close();
		
		return products;
	}
	
	public void deleteProduct(Product Product){
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.remove(Product);

		session.getTransaction().commit();
		session.close();
	}
	
}
