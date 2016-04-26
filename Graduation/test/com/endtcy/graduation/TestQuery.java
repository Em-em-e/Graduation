package com.endtcy.graduation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.endtcy.graduation.dao.ClassesDao;
import com.endtcy.graduation.dao.CourseDao;
import com.endtcy.graduation.dao.StudentWorkDao;
import com.endtcy.graduation.dao.WorkDao;
import com.endtcy.graduation.entity.Course;
import com.endtcy.graduation.entity.Studentwork;
@SuppressWarnings("unchecked")
public class TestQuery {
	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	public void testQueryH(){
		SessionFactory sf=(SessionFactory) ac.getBean("sessionFactory");
		Session session=sf.openSession();
		Course c=(Course) session.get(Course.class, 2l);
		System.out.println(c);
		System.out.println(c.getName());
		System.out.println(c.getTerm());
		System.out.println(c.getTerm().getName());
		System.out.println(c.getClasses().getName());
	}
	
	
	@Test
	public void test(){
		//测试班级Dao
		ClassesDao classesDao=(ClassesDao) ac.getBean("classesDaoImpl");
		List cla=classesDao.findTClasses(1l);
		
		System.out.println("class:"+cla);
		
		//测试课程dao
		CourseDao courseDao=(CourseDao) ac.getBean("courseDaoImpl");
		List cou=courseDao.findCourseByClassAndTeacher(1l, 2l);
		System.out.println("course:"+cou);
		
		//测试studentWorkDaoImpl
		StudentWorkDao studentWorkDao=(StudentWorkDao) ac.getBean("studentWorkDaoImpl");
		Studentwork stuw=studentWorkDao.findByStudentAndWork(1l,7l);
		System.out.println("已上交的作业："+studentWorkDao.findWorksByStuid(1l));
		System.out.println("已上交的学生作业："+studentWorkDao.findStuWorkByWorkid(3l));
		System.out.println("srudentWork:"+stuw.getDescribe());
	}
	
	@Test
	public void aaa(){
		WorkDao workDao=(WorkDao) ac.getBean("workDaoImpl");
		System.out.println("某学生所有作业"+workDao.findWorksByStuId(1l).size());
		System.out.println("已完成的作业："+workDao.findFinishedWork(1l).size());
		System.out.println("未完成的作业："+workDao.findUnfinishedWork(1l).size());
		System.out.println("某教师发布的所有作业："+workDao.findTeaWorks(2l).size());
		
	}
	
	@Test
	public void testJILianChaXun(){
		
	}
}
