package fr.epita.services;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.epita.datamodel.MCQChoice;
import fr.epita.datamodel.Question;

public class QuizzCreationDataService {
	
	@Inject
	MCQChoiceJPADAO mcqChoiceDAO;
	

	@Inject
	QuestionJPADAO questionDAO;
	
	@Inject
	SessionFactory sf;
	
	/**
	 * this method is transactional
	 * @param question
	 * @param choices
	 */
	public void createMCQQuestion(Question question, List<MCQChoice> choices) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		questionDAO.create(question);
		for (MCQChoice choice : choices) {
			choice.setQuestion(question);
			mcqChoiceDAO.create(choice);
		}
		tx.commit();
		
	}
}
