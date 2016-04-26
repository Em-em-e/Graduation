package com.endtcy.graduation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseDaoTest {
	private ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	public void testFindByID() {
		SessionFactory sf=(SessionFactory)ac.getBean("sessionFactory");
		Session session=sf.getCurrentSession();
		
		//TeacherDao te=new TeacherDaoImpl();
		//te.save(new Teacher());
		
	}

}
