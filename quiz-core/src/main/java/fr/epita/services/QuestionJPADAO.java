package fr.epita.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.epita.datamodel.Question;

public class QuestionJPADAO {

//	@Inject
//	SessionFactory sf;

	@PersistenceContext
	EntityManager em;

	public void create(Question question) {

		em.persist(question);
	}

}
