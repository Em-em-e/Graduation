package com.endtcy.graduation.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.endtcy.graduation.dao.ClassesDao;
import com.endtcy.graduation.dao.CourseDao;
import com.endtcy.graduation.dao.WorkDao;
import com.endtcy.graduation.entity.Classes;
import com.endtcy.graduation.entity.Course;
import com.endtcy.graduation.entity.Work;

@Service
public class WorkService {

	@Resource
	private CourseDao courseDao;
	@Resource
	private ClassesDao classesDao;
	@Resource
	private WorkDao workDao;
	public List<Classes> findTClasses(Long id) {
		return classesDao.findTClasses(id);
	}
	public Course getCourseById(Long courseid) {
		return courseDao.findByID(courseid);
	}
	public void save(Work work) {
		workDao.save(work);
	}
	public List<Course> findCourseByClassAndTeacher(Long teacherid, Long classid) {
		return courseDao.findCourseByClassAndTeacher(teacherid,classid);
	}
	public List<Work> fTeaWorks(Long id) {
		return workDao.findTeaWorks(id);
	}
	
	
}
