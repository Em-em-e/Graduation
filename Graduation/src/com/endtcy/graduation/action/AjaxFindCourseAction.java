package com.endtcy.graduation.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import com.endtcy.graduation.base.BaseAction;
import com.endtcy.graduation.entity.Course;
import com.endtcy.graduation.entity.Teacher;
import com.endtcy.graduation.service.WorkService;
import com.endtcy.graduation.util.JsonConfigFilter;

public class AjaxFindCourseAction extends BaseAction{
	
	@Resource
	private WorkService workService;
	
	/**
	 * ajax请求action--
	 * 获取班级下的课程
	 * @throws IOException
	 */
	public void findCourses() throws IOException{
		response.setCharacterEncoding("UTF-8");
		//获取查找参数
		Teacher teacher=(Teacher) session.get("user");
		String cla=request.getParameter("classid");
		Long teacherid=teacher.getId();
		Long classid=Long.parseLong(cla);
		List<Course> courses=workService.findCourseByClassAndTeacher(teacherid, classid);
		
		JSONArray jsonArray=JSONArray.fromObject(courses,
				JsonConfigFilter.getConfig(new String[]{"classes","teacher","works","term"}));
		PrintWriter out=response.getWriter();
		out.write(jsonArray.toString());
		System.out.println(jsonArray.toString());
	}
}
