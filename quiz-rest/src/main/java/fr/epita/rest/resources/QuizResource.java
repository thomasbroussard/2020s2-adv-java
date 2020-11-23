package fr.epita.rest.resources;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.net.ssl.SSLEngineResult.Status;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import fr.epita.datamodel.MCQChoice;
import fr.epita.datamodel.Question;
import fr.epita.exception.CreationFailedException;
import fr.epita.services.QuizCreationDataService;
import fr.epita.services.dto.MCQChoiceDTO;
import fr.epita.services.dto.QuestionDTO;

@Path("/quiz")
public class QuizResource {

	@Inject
	QuizCreationDataService service;
	
	
	@POST
	@Path("/{id}/question")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestionForQuiz(@PathParam("id") String id, QuestionDTO dto) {
		if (dto == null) {
			return Response.status(400, "no question was provided").entity("bad request").build();
		}

		try {
			service.createMCQQuestion(dto);
		}catch(CreationFailedException cfe) {
			return Response.notModified().build();
		}
		
		return Response.created(URI.create(String.valueOf("quiz/"+id+"/question/"+ dto.getQuestionId()))).build();
	}
	
	
	@GET
	@Path("/question/{questionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestion(@PathParam("questionId") String questionId) {
		System.out.println(questionId);
		QuestionDTO dto = new QuestionDTO();
		dto.setQuestionTitle("title");
		MCQChoiceDTO choiceDTO = new MCQChoiceDTO();
		choiceDTO.setChoiceTitle("title");
		dto.setChoices(Arrays.asList(choiceDTO));
		return Response.ok().entity(dto).build();
	}
	
	

}
