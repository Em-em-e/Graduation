package com.endtcy.graduation.dao;

import java.util.List;

import com.endtcy.graduation.base.BaseDao;
import com.endtcy.graduation.entity.Classes;

public interface ClassesDao extends BaseDao<Classes>{

	public List<Classes> findTClasses(Long id);
	
}
