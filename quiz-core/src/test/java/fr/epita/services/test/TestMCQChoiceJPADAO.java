package fr.epita.services.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.datamodel.MCQChoice;
import fr.epita.datamodel.Question;
import fr.epita.exception.CreationFailedException;
import fr.epita.services.MCQChoiceJPADAO;
import fr.epita.services.QuestionJPADAO;
import fr.epita.services.QuizCreationDataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestMCQChoiceJPADAO {
	
	@Inject
	MCQChoiceJPADAO dao;
	@Inject
	QuestionJPADAO questionDao;
	
	@Inject
	QuizCreationDataService dataservice;
	
	@Inject
	@Named("datasourceH2")
	DataSource ds;
	

	@Test
	public void testCreation() {
		Question question = new Question();
		question.setQuestionTitle("What is Java ?");
		
		MCQChoice choice = new MCQChoice();
		choice.setValid(true);
		choice.setChoice("an indonesian island?");
		
		MCQChoice choice2= new MCQChoice();
		choice2.setValid(true);
		choice2.setChoice("a programming language?");
		
		MCQChoice choice3= new MCQChoice();
		choice3.setValid(true);
		choice3.setChoice("a term that designs coffee");
		
		
		
		//when
		try {
			
			dataservice.createMCQQuestion(question, Arrays.asList(choice, choice2, choice3));
		
		} catch (CreationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		// then
		try (Connection connection = ds.getConnection();
				PreparedStatement stmt = connection
						.prepareStatement("select choice from MCQCHOICES where choice = ?")) {
			stmt.setString(1,choice.getChoice() );
			ResultSet rs = stmt.executeQuery();
			int i = 0; 
			while (rs.next()) {
				System.out.println(rs.getString("choice"));
				i++;
			}
			Assert.assertNotEquals(0, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
