package fr.epita.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.epita.exception.CreationFailedException;

public abstract class GenericDAO<T> {
	
	
	@Inject
	SessionFactory sf;
	
	
	public void create(T o) throws CreationFailedException{
		Session session = sf.openSession(); //not working : getCurrentSession();
		
		session.save(o);
		
	}
	private Session getCurrentSession() {
		Session session = sf.getCurrentSession();
		if (session == null) {
			session = sf.openSession();
		}
		return session;
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
