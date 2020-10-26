package fr.epita.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class GenericDAO<T> {
	
	
	@Inject
	SessionFactory sf;
	
	
	public void create(T o) {
		Session session = sf.openSession();
		session.save(o);
	}
	public void update(T o) {
		Session session = sf.openSession();
		session.update(o);
	}
	public void delete(T o) {
		Session session = sf.openSession();
		session.delete(o);
	}
	
	public abstract List<T> search(T criteria);

}
