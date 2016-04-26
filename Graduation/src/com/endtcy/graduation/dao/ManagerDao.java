package com.endtcy.graduation.dao;

import com.endtcy.graduation.base.BaseDao;
import com.endtcy.graduation.entity.Manager;

public interface ManagerDao extends BaseDao<Manager> {
	public Manager findByUnameAndPsw(String username, String password);

}
