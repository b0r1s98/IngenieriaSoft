package es.ucm.fdi.integracion.DAOs;

import java.util.List;

import es.ucm.fdi.integracion.POJOs.POJO;

public interface DAO<T> {
	public void save(T t);
	
	public void update(T t);
	
	public POJO getFromId(String id);
	
	public List<T> getFromIds(List<T> pojos);
	
	public void remove(String id);
}