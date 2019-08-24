package io.github.mohitdtumce.main.api;

import com.codahale.metrics.annotation.Timed;
import io.github.mohitdtumce.main.client.request.AskNameRequest;
import io.github.mohitdtumce.main.client.response.HelloResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/v2")
@Produces(MediaType.APPLICATION_JSON)
public class MainApplicationResources {

	private String question;
	private String greetingTemplate;
	private final AtomicLong countSayHello, countAskName;

	public MainApplicationResources(String question, String greetingTemplate) {
		this.question = question;
		this.greetingTemplate = greetingTemplate;
		this.countAskName = new AtomicLong();
		this.countSayHello = new AtomicLong();
	}

	@POST
	@Path("/ask-question")
	@Timed
	public AskNameRequest postQuestion() {
		return new AskNameRequest(this.countAskName.incrementAndGet(), this.question);
	}

	@GET
	@Path("/greet")
	@Timed
	public HelloResponse sayHello(@QueryParam("name") Optional<String> name) {
		return new HelloResponse(countSayHello.incrementAndGet(), this.greetingTemplate, name.orElse("Stranger"));
	}
}
