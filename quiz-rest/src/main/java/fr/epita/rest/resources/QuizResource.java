package fr.epita.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.epita.services.dto.QuestionDTO;

@Path("/quiz")
public class QuizResource {
	
	
	@POST
	@Path("/{id}/question")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestionForQuiz(@PathParam("id") String id, QuestionDTO dto) {
		System.out.println(dto);
		return Response.ok().build();
	}
	
	
	@GET
	@Path("/question/{questionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestion(@PathParam("questionId") String questionId) {
		System.out.println(questionId);
		return Response.ok().build();
	}
	
	

}
