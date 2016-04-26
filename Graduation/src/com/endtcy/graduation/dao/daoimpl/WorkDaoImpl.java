package com.endtcy.graduation.dao.daoimpl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.endtcy.graduation.base.BaseDaoImpl;
import com.endtcy.graduation.dao.WorkDao;
import com.endtcy.graduation.entity.Work;

@Repository
@SuppressWarnings("unchecked")
public class WorkDaoImpl extends BaseDaoImpl<Work> implements WorkDao {

	public List<Work> findWorksByStuId(Long stuid) {
		SQLQuery query = getSession()
				.createSQLQuery(
						"SELECT work.* FROM STUDENT,COURSE,WORK " +
						"WHERE STUDENT.CLASSID=COURSE.CLASSID " +
						"and COURSE.ID=WORK.COURSEID " +
						"and STUDENT.ID=? ORDER BY WORK.LASTTIME");
		query.setLong(0, stuid);
		query.addEntity(Work.class);
		return query.list();
	}

	public List<Work> findFinishedWork(Long stuid) {
		SQLQuery query = getSession()
				.createSQLQuery(
						"select work.* from studentwork,work "
								+ "where studentwork.workid=work.id and studentwork.stuid=?");
		query.setLong(0, stuid);
		query.addEntity(Work.class);
		return query.list();
	}

	public List<Work> findUnfinishedWork(Long stuid) {
		SQLQuery query = getSession()
				.createSQLQuery("SELECT work.* FROM STUDENT,COURSE,WORK " +
						"WHERE STUDENT.CLASSID=COURSE.CLASSID and COURSE.ID=WORK.COURSEID and STUDENT.ID=? and work.id not in " +
						"(select work.id from studentwork,work where studentwork.workid=work.id and studentwork.stuid=?) GROUP BY lastTime,firstTime");
		query.setLong(0, stuid);
		query.setLong(1, stuid);
		query.addEntity(Work.class);
		return query.list();
		
		
	}

	public List<Work> findTeaWorks(Long teaid) {
		SQLQuery query = getSession()
		.createSQLQuery(
				"select work.* from course,work "
						+ "where work.courseid=course.id and course.teacherid=? GROUP BY lastTime,firstTime");
		query.setLong(0, teaid);
		query.addEntity(Work.class);
		return query.list();
	}

}
