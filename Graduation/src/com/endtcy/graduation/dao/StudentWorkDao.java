package com.endtcy.graduation.dao;

import java.util.List;

import com.endtcy.graduation.base.BaseDao;
import com.endtcy.graduation.entity.Studentwork;

public interface StudentWorkDao extends BaseDao<Studentwork>{
	
	/**
	 * 根据学生id和作业id获取StudentWork对象
	 * @param stuid
	 * @param workid
	 * @return
	 */
	public Studentwork findByStudentAndWork(Long stuid, Long workid);
	/**
	 * 根据学生id获取已上交的StudentWork对象
	 */
	public List<Studentwork> findWorksByStuid(Long stuid);

	/**
	 * 根据workid获取所有学生作业
	 */
	public List<Studentwork> findStuWorkByWorkid(Long workid);
}
