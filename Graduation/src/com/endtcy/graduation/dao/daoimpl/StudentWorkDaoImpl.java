package com.endtcy.graduation.dao.daoimpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.endtcy.graduation.base.BaseDaoImpl;
import com.endtcy.graduation.dao.StudentWorkDao;
import com.endtcy.graduation.entity.Studentwork;

@Repository
@Transactional
@SuppressWarnings("unchecked")
public class StudentWorkDaoImpl extends BaseDaoImpl<Studentwork> implements StudentWorkDao{
	
	public Studentwork findByStudentAndWork(Long stuid, Long workid) {
		SQLQuery query=getSession().createSQLQuery("select * from studentwork where stuid=? and workid=?");
		query.setLong(0, stuid);
		query.setLong(1, workid);
		query.addEntity(Studentwork.class);
		return (Studentwork) query.uniqueResult();
	}
	
	public List<Studentwork> findWorksByStuid(Long stuid) {
		SQLQuery query=getSession().createSQLQuery("select studentwork.* from studentwork,work where studentwork.workid=work.id and stuid=?");
		query.setLong(0, stuid);
		query.addEntity(Studentwork.class);
		return query.list();
	}

	public List<Studentwork> findStuWorkByWorkid(Long workid) {
		SQLQuery query=getSession().createSQLQuery("select studentwork.* from studentwork,work where studentwork.workid=work.id and workid=? group by uploadtime");
		query.setLong(0, workid);
		query.addEntity(Studentwork.class);
		return query.list();
	}
	
	

}
