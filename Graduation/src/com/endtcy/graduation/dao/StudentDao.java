package com.endtcy.graduation.dao;

import com.endtcy.graduation.base.BaseDao;
import com.endtcy.graduation.entity.Student;

public interface StudentDao extends BaseDao<Student> {

	public Student findByUnameAndPsw(String username, String password);
}
