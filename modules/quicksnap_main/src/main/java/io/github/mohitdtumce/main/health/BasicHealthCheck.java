package io.github.mohitdtumce.main.health;

import com.codahale.metrics.health.HealthCheck;

public class BasicHealthCheck extends HealthCheck {
	private String greetingTemplate;

	public BasicHealthCheck(String greetingTemplate) {
		this.greetingTemplate = greetingTemplate;
	}

	@Override
	protected Result check() throws Exception {
		final String greeting = String.format(this.greetingTemplate, "TEST");
		if (!greeting.contains("TEST"))
			return Result.unhealthy("Unhealthy");
		else
			return Result.healthy();
	}
}
