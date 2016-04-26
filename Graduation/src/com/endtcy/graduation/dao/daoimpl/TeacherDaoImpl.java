package com.endtcy.graduation.dao.daoimpl;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.endtcy.graduation.base.BaseDaoImpl;
import com.endtcy.graduation.dao.TeacherDao;
import com.endtcy.graduation.entity.Teacher;

@Repository
@Transactional
public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDao{

	public Teacher findByUnameAndPsw(String username, String password) {
		SQLQuery query=getSession().createSQLQuery("select * from teacher where username=? and password=?");
		query.setString(0, username);
		query.setString(1, password);
		query.addEntity(Teacher.class);
		Teacher st=(Teacher) query.uniqueResult();
		return st;
	}

}
