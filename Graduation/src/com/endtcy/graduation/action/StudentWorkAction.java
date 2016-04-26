package com.endtcy.graduation.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.endtcy.graduation.base.BaseAction;
import com.endtcy.graduation.entity.Student;
import com.endtcy.graduation.entity.Studentwork;
import com.endtcy.graduation.entity.Work;
import com.endtcy.graduation.service.StudentWorkService;

@Namespace("/student")
public class StudentWorkAction extends BaseAction{
	
	//workid
	private Long wid;
	//回显到uploadWork.do的work数据
	private Work work;
	//上传的文件对象
	private File uploadfile;
	//上传的文件名
	private String uploadfileFileName;
	//文件类型
	private String uploadfileContentType;
	//作业描述
	private String describe;
	
	//已完成的作业
	private List<Work> finishedWork;
	//未完成的作业
	private List<Work> unfinishWork;
	
	@Resource
	private StudentWorkService studentWorkService;
	
	@Action(value="listSomeStudentsWork",results={@Result(location="/WEB-INF/jsp/listSomeStudentsWork.jsp")})
	public String listSomeStudentsWork(){
		Student stu=(Student) session.get("user");
		finishedWork=studentWorkService.findFinishedWork(stu.getId());
		unfinishWork=studentWorkService.findUnfinishedWork(stu.getId());
		return "success";
	}
	
	/**
	 * 作业上传页面action
	 * @return
	 */
	public String execute(){
		if(wid==null){
			return "error";
		}
		work=studentWorkService.findByID(wid);
		return "success";
	}
	
	/**
	 * 上传作业action
	 * @return
	 */
	public String uploadWork(){
		if(wid==null){
			return "error";
		}
		Student stu=(Student) session.get("user");
		work=studentWorkService.findByID(wid);
		//自动构造作业文件存储路径
		String realpath=ServletActionContext.getServletContext().getRealPath("workfile"+File.separator
				+work.getCourse().getTerm().getName()+File.separator
				+work.getCourse().getTeacher().getName()+File.separator
				+work.getCourse().getClasses().getName()+File.separator
				+work.getCourse().getName()+File.separator
				+work.getName());
		//获取文件后缀名
		int a=uploadfileFileName.lastIndexOf('.');
		String filetype=uploadfileFileName.substring(a);
		if(uploadfile!=null){
			//作业文件自动重命名  格式为：学号+姓名
			File savefile=new File(realpath, stu.getStudentid()+"+"+stu.getName()+filetype);
			if(!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			System.out.println("uploadfileFileName:-----"+uploadfileFileName);
			System.out.println("uploadfile:------"+uploadfile);
			try {
				FileUtils.copyFile(uploadfile, savefile);
			} catch (IOException e) {
				return "input";
			}
			System.out.println("学生作业文件："+savefile.getAbsolutePath());
			/** 更新/新建学生作业记录，避免多条记录*/
			Studentwork stuwork=studentWorkService.findByStudentAndWork(stu.getId(), work.getId());
			System.out.println("学生id:"+stu.getId()+" 作业id:"+work.getId());
			System.out.println("获取的作业对象:"+stuwork);
			if(stuwork==null){
				stuwork=new Studentwork();
				stuwork.setDescribe(describe);
				stuwork.setStudent(stu);
				stuwork.setWork(work);
				stuwork.setPath(savefile.getAbsolutePath());
				studentWorkService.save(stuwork);
				System.out.println("---------作业上传成功！----------");
			}else{
				File file=new File(stuwork.getPath());
				if(file.exists())
					file.delete();
				stuwork.setDescribe(describe);
				stuwork.setPath(savefile.getAbsolutePath());
				stuwork.setUploadtime(new Date());
				studentWorkService.update(stuwork);
				System.out.println("----------作业更新成功---------");
			}
		}
		return "success";
	}
	
	
	public List<Work> getFinishedWork() {
		return finishedWork;
	}

	public void setFinishedWork(List<Work> finishedWork) {
		this.finishedWork = finishedWork;
	}

	public List<Work> getUnfinishWork() {
		return unfinishWork;
	}

	public void setUnfinishWork(List<Work> unfinishWork) {
		this.unfinishWork = unfinishWork;
	}

	public Long getWid() {
		return wid;
	}
	public void setWid(Long wid) {
		this.wid = wid;
	}
	public Work getWork() {
		return work;
	}
	public void setWork(Work work) {
		this.work = work;
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
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
}
