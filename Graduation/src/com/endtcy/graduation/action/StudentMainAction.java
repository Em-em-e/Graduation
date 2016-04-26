package com.endtcy.graduation.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.endtcy.graduation.base.BaseAction;
import com.endtcy.graduation.dao.WorkDao;
import com.endtcy.graduation.entity.Student;
import com.endtcy.graduation.entity.Work;

public class StudentMainAction extends BaseAction{
	
	private List<Work> works=new ArrayList<Work>();
	
	@Resource
	private WorkDao workDao;
	
	/**获取学生作业列表  */
	public String execute(){
		System.out.println("获取学生作业列表action执行------");
		Object s=session.get("user");
			Student stu=(Student) s;
			works=workDao.findWorksByStuId(stu.getId());
			return "success";
	}
	
	
	public List<Work> getWorks() {
		return works;
	}
	public void setWorks(List<Work> work) {
		this.works = work;
	}
	
	
}
