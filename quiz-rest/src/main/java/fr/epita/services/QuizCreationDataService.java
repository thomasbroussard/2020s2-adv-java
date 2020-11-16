package fr.epita.services;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import fr.epita.datamodel.MCQChoice;
import fr.epita.datamodel.Question;
import fr.epita.exception.CreationFailedException;

public class QuizCreationDataService {
	
	@Inject
	MCQChoiceJPADAO mcqChoiceDAO;
	

	@Inject
	QuestionJPADAO questionDAO;
	
	@PersistenceContext
	EntityManager em;
	
	/**
	 * this method is transactional
	 * @param question
	 * @param choices
	 * @throws CreationFailedException 
	 */
	@Transactional(value = TxType.REQUIRED)
	public void createMCQQuestion(Question question, List<MCQChoice> choices) throws CreationFailedException {
		
	
		questionDAO.create(question);
		for (MCQChoice choice : choices) {
			choice.setQuestion(question);
			mcqChoiceDAO.create(choice);
		}
	}
}
