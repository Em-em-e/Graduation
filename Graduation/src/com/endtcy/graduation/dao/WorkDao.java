package com.endtcy.graduation.dao;

import java.util.List;

import com.endtcy.graduation.base.BaseDao;
import com.endtcy.graduation.entity.Work;

public interface WorkDao extends BaseDao<Work>{
	
	/**
	 * 根据学生id获取Work对象
	 * @param id
	 * @return
	 */
	 public List<Work> findWorksByStuId(Long stuid);
	 
	 /**
	  * 根据学生id查找已完成的作业Work对象
	  * @param stuid
	  * @return
	  */
	 public List<Work> findFinishedWork(Long stuid);
	 
	 /**
	  * 根据学生id查找未完成的作业Work对象
	  * @param stuid
	  * @return
	  */
	 public List<Work> findUnfinishedWork(Long stuid);
	 
	 /**
	  * 根据教师id查找所有work对象
	  * @param teaid
	  * @return
	  */
	 public List<Work> findTeaWorks(Long teaid);
	
}
