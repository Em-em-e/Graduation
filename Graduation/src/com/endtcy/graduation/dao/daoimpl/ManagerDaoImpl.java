package com.endtcy.graduation.dao.daoimpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.endtcy.graduation.base.BaseDaoImpl;
import com.endtcy.graduation.dao.ManagerDao;
import com.endtcy.graduation.entity.Manager;
@Repository
@Transactional
public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao{

	public Manager findByUnameAndPsw(String username, String password) {
		return null;
	}
	

}
