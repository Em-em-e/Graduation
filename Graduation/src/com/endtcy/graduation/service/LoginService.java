package com.endtcy.graduation.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.endtcy.graduation.dao.ManagerDao;
import com.endtcy.graduation.dao.StudentDao;
import com.endtcy.graduation.dao.TeacherDao;

@Service
public class LoginService {
	@Resource
	private StudentDao studentDao;
	@Resource
	private TeacherDao teacherDao;
	@Resource
	private ManagerDao managerDao;
	
	/**根据用户选择从数据库查找相应的角色信息*/
	public Object findByUnameAndPsw(String username, String password, int role) {
		if(role==1)
			return studentDao.findByUnameAndPsw(username,password);
		if(role==2)
			return teacherDao.findByUnameAndPsw(username,password);
		if(role==3)
			return managerDao.findByUnameAndPsw(username,password);
		return null;
	}
	
}
