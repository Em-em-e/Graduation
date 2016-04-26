package com.endtcy.graduation.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;

import com.endtcy.graduation.base.BaseAction;
import com.endtcy.graduation.dao.ManagerDao;
import com.endtcy.graduation.dao.StudentDao;
import com.endtcy.graduation.dao.TeacherDao;
import com.endtcy.graduation.entity.Manager;
import com.endtcy.graduation.entity.Student;
import com.endtcy.graduation.entity.Teacher;

public class UpdateUserAction extends BaseAction{
	
	private Student stu;
	private Teacher tea;
	private Manager man;
	
	private String newpsw1;
	private String newpsw2;
	
	@Resource
	StudentDao studentDao;
	@Resource
	TeacherDao teacherDao;
	@Resource
	ManagerDao managerDao;
	/**
	 * 根据用户跳转到不同的修改个人信息页面
	 * @return
	 */
	public String execute(){
		Object user=session.get("user");
		if(user instanceof Student){
			Student s=(Student) user;
			stu=studentDao.findByID(s.getId());
			return "student_update";
		}
		if(user instanceof Teacher){
			Teacher t=(Teacher) user;
			tea=teacherDao.findByID(t.getId());
			return "teacher_update";
		}
		if(user instanceof Manager){
			Manager m=(Manager) user;
			man=managerDao.findByID(m.getId());
			return "manager_update";
		}
		return "login";
	}
	/**
	 * ajax验证密码
	 * @throws IOException
	 */
	public void verifyPsw() throws IOException{
		response.setCharacterEncoding("utf-8");
		String psw=request.getParameter("password");
		Object user=session.get("user");
		Object o=null;
		if(user instanceof Teacher){
			Teacher tea=(Teacher)user;
			o=teacherDao.findByUnameAndPsw(tea.getUsername(), psw);
		}
		if(user instanceof Student){
			Student stu=(Student)user;
			o=studentDao.findByUnameAndPsw(stu.getUsername(), psw);
		}
		PrintWriter out=response.getWriter();
		if(o==null){
			out.write("密码错误！，请重新输入。");
		}else{
			out.write("ok");
		}
	}
	/**
	 * 更新密码
	 * @return
	 */
	public String updatePsw(){
		Object user=session.get("user");
		if(newpsw1.equals(newpsw2)){
			if(user instanceof Teacher){
				Teacher t=(Teacher) user;
				Teacher tea=teacherDao.findByID(t.getId());
				tea.setPassword(newpsw1);
				teacherDao.update(tea);
			}
			if(user instanceof Student){
				Student s=(Student)user;
				Student stu=studentDao.findByID(s.getId());
				stu.setPassword(newpsw1);
				studentDao.update(stu);
			}
			return "success";
		}else{
			return "reinput";
		}
	}
	
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public Teacher getTea() {
		return tea;
	}
	public void setTea(Teacher tea) {
		this.tea = tea;
	}
	public Manager getMan() {
		return man;
	}
	public void setMan(Manager man) {
		this.man = man;
	}
	public String getNewpsw1() {
		return newpsw1;
	}
	public void setNewpsw1(String newpsw1) {
		this.newpsw1 = newpsw1;
	}
	public String getNewpsw2() {
		return newpsw2;
	}
	public void setNewpsw2(String newpsw2) {
		this.newpsw2 = newpsw2;
	}
	
	
}
