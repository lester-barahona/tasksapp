package com.startCMS.core.repositorys.interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
	
	public boolean save(T object);
	
	public boolean update(T object,Integer id);
	
	public boolean deleteById(Integer id);
	
	public List<T> findAll();
	
	public Optional<T> findById(Integer id);
}
