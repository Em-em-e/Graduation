package com.endtcy.graduation.base;

import java.util.List;

public interface BaseDao<T> {
	
	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * 删除实体
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * 根据ID查找实体
	 * @param id
	 * @return
	 */
	T findByID(Long id);
	
	/**
	 * 获取所有实体
	 * @return
	 */
	List<T> findAll();
}
