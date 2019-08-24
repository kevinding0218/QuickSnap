package io.github.mohitdtumce.main.client.request;

public class AskNameRequest {
	private long id;
	private String question;


	public AskNameRequest(long id, String question) {
		this.id = id;
		this.question = question;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Request{" + this.id + "," + question + "}";
	}
}
