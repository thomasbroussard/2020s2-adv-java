package fr.epita.services.test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.datamodel.Question;
import fr.epita.services.QuestionJPADAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestQuestionDAO {
	
	@Inject
	QuestionJPADAO dao;
	
	
	@Test
	@Transactional
	public void testCreation() {
		//given
	
		Question question = new Question();
		question.setQuestionTitle("What is Java?");
		question.setDifficulty(2);
		
		//when
		dao.create(question);

		
		//todo check result
	}
	
	

}
