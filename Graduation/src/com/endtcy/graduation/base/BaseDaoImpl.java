package com.endtcy.graduation.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Transactional
public abstract class BaseDaoImpl<T> implements BaseDao<T>{
	@Resource
	private SessionFactory sessionFactory;
	protected Class<T> arg0=null;
	
	public BaseDaoImpl(){
		//利用反射获取T的真实类型
		ParameterizedType pt=(ParameterizedType)this.getClass().getGenericSuperclass();
		this.arg0=(Class<T>) pt.getActualTypeArguments()[0];
	}
	
	public void delete(Long id) {
		Object entity=findByID(id);
		if(entity!=null)
			getSession().delete(entity);
	}
	public List<T> findAll() {
		return getSession().createQuery("FROM "+arg0.getSimpleName()).list();
		
	}

	
	public T findByID(Long id) {
		return (T) getSession().get(arg0, id);
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void update(T entity) {
		
		getSession().update(entity);
	}
	
	/**
	 * 获取当前可用的Session
	 * @return
	 */
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
}
