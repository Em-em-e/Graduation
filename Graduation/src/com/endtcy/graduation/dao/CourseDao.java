package com.endtcy.graduation.dao;

import java.util.List;

import com.endtcy.graduation.base.BaseDao;
import com.endtcy.graduation.entity.Course;

public interface CourseDao extends BaseDao<Course>{


	public List<Course> findCourseByClassAndTeacher(Long teacherid, Long classid);
	
}
