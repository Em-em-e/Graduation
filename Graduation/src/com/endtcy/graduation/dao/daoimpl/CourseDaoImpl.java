package com.endtcy.graduation.dao.daoimpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.endtcy.graduation.base.BaseDaoImpl;
import com.endtcy.graduation.dao.CourseDao;
import com.endtcy.graduation.entity.Course;
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao{


	public List<Course> findCourseByClassAndTeacher(Long teacherid, Long classid) {
		SQLQuery sqlQuery=getSession().createSQLQuery("select * from course where teacherid=? and classid=?");
		sqlQuery.setLong(0, teacherid);
		sqlQuery.setLong(1, classid);
		sqlQuery.addEntity(Course.class);
		return sqlQuery.list();
	}

}
