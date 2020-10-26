package fr.epita.services;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import fr.epita.datamodel.Question;

public class QuestionJPADAO {

	@Inject
	SessionFactory sf;

	public void create(Question question) {
		
		Session session = sf.openSession();
		
		session.save(question);
	}
	
	

}
