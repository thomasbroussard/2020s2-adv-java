package fr.epita.services.dto;

import fr.epita.datamodel.MCQChoice;

public class MCQChoiceDTO {
	
	private int id;
	
	private String choiceTitle;

	public String getChoiceTitle() {
		return choiceTitle;
	}

	public void setChoiceTitle(String choiceTitle) {
		this.choiceTitle = choiceTitle;
	}
	
	public MCQChoice toDataModel() {
		MCQChoice choice = new MCQChoice();
		choice.setId(this.id);
		choice.setChoice(choiceTitle);
		return choice;
	}
	
	public MCQChoiceDTO fromDataModel(MCQChoice choice) {
		this.choiceTitle = choice.getChoice();
		this.id = choice.getId();
		return this;
	}

	@Override
	public String toString() {
		return "MCQChoiceDTO [id=" + id + ", choiceTitle=" + choiceTitle + "]";
	}
	
	

}
