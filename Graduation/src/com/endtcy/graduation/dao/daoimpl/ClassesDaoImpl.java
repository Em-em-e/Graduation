package com.endtcy.graduation.dao.daoimpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.endtcy.graduation.base.BaseDaoImpl;
import com.endtcy.graduation.dao.ClassesDao;
import com.endtcy.graduation.entity.Classes;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class ClassesDaoImpl extends BaseDaoImpl<Classes> implements ClassesDao{

	
	public List<Classes> findTClasses(Long tid) {
		SQLQuery query=getSession().createSQLQuery("select distinct class.id,class.name from course,class where class.id=course.classid and teacherid=?");
		query.setLong(0, tid);
		query.addEntity(Classes.class);
		List<Classes> classes= query.list();
		
		return classes;
	}

}
