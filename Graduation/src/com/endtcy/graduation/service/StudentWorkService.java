package com.endtcy.graduation.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.endtcy.graduation.dao.StudentWorkDao;
import com.endtcy.graduation.dao.WorkDao;
import com.endtcy.graduation.entity.Studentwork;
import com.endtcy.graduation.entity.Work;

@Service
public class StudentWorkService {

	@Resource
	private StudentWorkDao studentWorkDao;
	@Resource
	private WorkDao workDao;
	
	public Studentwork findByStudentAndWork(Long stuid, Long workid) {
		return studentWorkDao.findByStudentAndWork(stuid, workid);
	}
	
	public void save(Studentwork stuwork) {
		studentWorkDao.save(stuwork);
	}

	public Work findByID(Long wid) {
		return workDao.findByID(wid);
	}

	public void update(Studentwork stuwork) {
		studentWorkDao.update(stuwork);
	}

	public List<Studentwork> findStuWorkByWorkid(Long swid) {
		return studentWorkDao.findStuWorkByWorkid(swid);
	}

	public List<Work> findFinishedWork(Long id) {
		return workDao.findFinishedWork(id);
	}

	public List<Work> findUnfinishedWork(Long id) {
		return workDao.findUnfinishedWork(id);
	}
	
}
