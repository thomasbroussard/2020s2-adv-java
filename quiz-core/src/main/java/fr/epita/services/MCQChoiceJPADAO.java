package fr.epita.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import fr.epita.datamodel.MCQChoice;

public class MCQChoiceJPADAO extends GenericDAO<MCQChoice>{


	
	@Override
	protected Map<String, Object> getParams(MCQChoice criteria) {
		Map<String,Object> parameters = new HashMap<String,Object>();
		
		parameters.put("question", criteria.getQuestion());
		parameters.put("valid", criteria.isValid());
		return parameters;
	}

	@Override
	protected String getQueryString() {
		return "from MCQChoice where valid=:valid and question=:question";
	}
	
	public List<MCQChoice> specificSearch(MCQChoice criteria){
		Function<MCQChoice, Map<String, Object>> getParamsFunction = choice -> {
			Map<String, Object> parameters = new HashMap<String,Object>();
			parameters.put("question", criteria.getQuestion());
			parameters.put("valid", criteria.isValid());
			return parameters;
		};
		return super.search(criteria, getParamsFunction, "from MCQChoice where valid=:valid and question=:question");
		
	}
	public List<MCQChoice> searchAll(){
	
		return super.search(null, choice -> new HashMap(), "from MCQChoice");
		
	}


}
