package fr.epita.services.dto;

import java.util.List;

import fr.epita.datamodel.Question;

public class QuestionDTO {
	
	private int id;
	
	private String questionTitle;
	
	private List<MCQChoiceDTO> choices;

	
	
	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public List<MCQChoiceDTO> getChoices() {
		return choices;
	}

	public void setChoices(List<MCQChoiceDTO> choices) {
		this.choices = choices;
	}
	
	
	public Question toDataModel() {
		Question question = new Question();
		question.setQuestionId(id);
		question.setQuestionTitle(questionTitle);
		return question;
	}
	
	public void fromDataModel(Question question) {
		this.questionTitle = question.getQuestionTitle();
		this.id = question.getQuestionId();
	}

	@Override
	public String toString() {
		return "QuestionDTO [id=" + id + ", questionTitle=" + questionTitle + ", choices=" + choices + "]";
	}


}
