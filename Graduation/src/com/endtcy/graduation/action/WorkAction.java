package com.endtcy.graduation.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.endtcy.graduation.base.BaseAction;
import com.endtcy.graduation.entity.Classes;
import com.endtcy.graduation.entity.Course;
import com.endtcy.graduation.entity.Studentwork;
import com.endtcy.graduation.entity.Teacher;
import com.endtcy.graduation.entity.Work;
import com.endtcy.graduation.service.StudentWorkService;
import com.endtcy.graduation.service.WorkService;

@Namespace("/teacher")
public class WorkAction extends BaseAction{
	private static final long serialVersionUID = 1L;

	
	private List<Course> courses=new ArrayList<Course>();
	private List<Classes> classes=new ArrayList<Classes>();
	private Long courseid;
	private File uploadfile;
	private String uploadfileFileName;
	private String uploadfileContentType;
	private String workName;
	private Date lasttime;
	private String describe;
	
	//作业列表数据
	private List<Work> works;
	//作业id
	private Long swid;
	//所有学生作业列表数据
	private List<Studentwork> studentworks;
	
	@Resource
	private WorkService workService;
	@Resource
	private StudentWorkService studentWorkService;
	//Session中获取的用户对象
	/**
	 * 跳转发布作业页面
	 */
	public String execute() throws Exception {
		Teacher teacher=(Teacher)session.get("user");
			classes=workService.findTClasses(teacher.getId());
			return "success";
	}
	
	/**发布作业action*/
	public String addWork(){
		Course course=workService.getCourseById(courseid);
		//构造作业附件存放路径
		String realpath=ServletActionContext.getServletContext()
						.getRealPath("workfile"+File.separator
								+course.getTerm().getName()+File.separator
								+course.getTeacher().getName()+File.separator
								+course.getClasses().getName()+File.separator
								+course.getName()+File.separator+workName);
		if(uploadfile!=null){
			File savefile=new File(realpath,uploadfileFileName);
			if(!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			try {
				FileUtils.copyFile(uploadfile, savefile);
			} catch (IOException e) {
				return "input";
			}
			System.out.println(savefile.getAbsolutePath());
			Work work =new Work();
			work.setAttachment(savefile.getAbsolutePath());
			work.setCourse(course);
			describe=describe.replaceAll(" ", "&nbsp;");
			work.setDescribe(describe.replaceAll("\n", "<br/>"));
			work.setLasttime(lasttime);
			work.setName(workName);
			
			workService.save(work);
		}
		return "success";
	}
	
	/**
	 * 获取教师作业列表
	 */
	@Action(value="listWork",results={@Result(location="/WEB-INF/jsp/listWork.jsp")})
	public String listWork(){
		Teacher teacher=(Teacher)session.get("user");
		works=workService.fTeaWorks(teacher.getId());
		return "success";
	}
	
	/**
	 * 获取学生作业列表
	 * @return
	 */
	@Action(value="listStudentWork",results={@Result(location="/WEB-INF/jsp/listStudentWork.jsp")})
	public String listStudentWorks(){
		studentworks=studentWorkService.findStuWorkByWorkid(swid);
		return "success";
	}
	
	@Action(value="delsession")
	public void removeSession(){
		session.remove("user");
		System.out.println(session.get("user"));
	}
	
	
	public Long getSwid() {
		return swid;
	}

	public void setSwid(Long swid) {
		this.swid = swid;
	}

	public List<Studentwork> getStudentworks() {
		return studentworks;
	}

	public void setStudentworks(List<Studentwork> studentworks) {
		this.studentworks = studentworks;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Long getCourseid() {
		return courseid;
	}

	public void setCourseid(Long courseid) {
		this.courseid = courseid;
	}

	public File getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}

	public String getUploadfileFileName() {
		return uploadfileFileName;
	}

	public void setUploadfileFileName(String uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}

	public String getUploadfileContentType() {
		return uploadfileContentType;
	}

	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}

	public String getWorkName() {
		return workName;
	}

	public void setWorkName(String workName) {
		this.workName = workName;
	}

	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public WorkService getWorkService() {
		return workService;
	}

	public void setWorkService(WorkService workService) {
		this.workService = workService;
	}

	public List<Classes> getClasses() {
		return classes;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}

	public List<Work> getWorks() {
		return works;
	}

	public void setWorks(List<Work> works) {
		this.works = works;
	}

	
}
