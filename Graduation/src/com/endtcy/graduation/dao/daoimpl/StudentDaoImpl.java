package com.endtcy.graduation.dao.daoimpl;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.endtcy.graduation.base.BaseDaoImpl;
import com.endtcy.graduation.dao.StudentDao;
import com.endtcy.graduation.entity.Student;
@Repository
@Transactional
public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao{

	
	/**根据用户名和密码查询单个学生实例*/
	public Student findByUnameAndPsw(String username, String password) {
		SQLQuery query=getSession().createSQLQuery("select * from student where username=? and password=?");
		query.setString(0, username);
		query.setString(1, password);
		query.addEntity(Student.class);
		Student st=(Student) query.uniqueResult();
		return st;
	}

	
}
