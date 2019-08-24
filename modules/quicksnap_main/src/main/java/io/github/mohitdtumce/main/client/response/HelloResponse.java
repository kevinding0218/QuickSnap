package io.github.mohitdtumce.main.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloResponse {

	private long id;
	private String greeting;

	public HelloResponse() {

	}

	public HelloResponse(long id, String greetingTemplate, String name) {
		this.id = id;
		this.greeting = String.format(greetingTemplate, name);
	}

	@JsonProperty
	public long getId() {
		return id;
	}

	@JsonProperty
	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty
	public String getGreeting() {
		return greeting;
	}

	@JsonProperty
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public String toString() {
		return "Response{" + this.id + ", " + greeting + "}\n";
	}
}
