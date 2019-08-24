package io.github.mohitdtumce.main;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class MainApplicationConfig extends Configuration {

	@NotEmpty
	private String question;

	@NotEmpty
	private String greetingTemplate;

	@JsonProperty
	public String getQuestion() {
		return question;
	}

	@JsonProperty
	public void setQuestion(String question) {
		this.question = question;
	}

	@JsonProperty
	public String getGreetingTemplate() {
		return greetingTemplate;
	}

	@JsonProperty
	public void setGreetingTemplate(String greetingTemplate) {
		this.greetingTemplate = greetingTemplate;
	}
}
