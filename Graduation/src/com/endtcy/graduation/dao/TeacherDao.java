package com.endtcy.graduation.dao;

import com.endtcy.graduation.base.BaseDao;
import com.endtcy.graduation.entity.Teacher;

public interface TeacherDao extends BaseDao<Teacher> {

	public Teacher findByUnameAndPsw(String username, String password);

}
