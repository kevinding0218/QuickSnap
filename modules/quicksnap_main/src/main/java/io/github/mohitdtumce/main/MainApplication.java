package io.github.mohitdtumce.main;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.github.mohitdtumce.main.api.MainApplicationResources;
import io.github.mohitdtumce.main.health.BasicHealthCheck;

public class MainApplication extends Application<MainApplicationConfig> {
	public static void main(String[] args) throws Exception {
		new MainApplication().run(args);
	}

	@Override
	public String getName() {
		return "MainApplication";
	}

	@Override
	public void initialize(Bootstrap<MainApplicationConfig> bootstrap) {
		super.initialize(bootstrap);
	}

	@Override
	public void run(MainApplicationConfig mainApplicationConfig, Environment environment) throws Exception {

		final BasicHealthCheck basicHealthCheck = new BasicHealthCheck(mainApplicationConfig.getGreetingTemplate());
		final MainApplicationResources mainApplicationResources
				= new MainApplicationResources(mainApplicationConfig.getQuestion(), mainApplicationConfig.getGreetingTemplate());

		environment.healthChecks().register("Template Check", basicHealthCheck);
		environment.jersey().register(mainApplicationResources);

//        System.out.println("Hello World");
//        Profile profile = new Profile();
//        System.out.println(profile.testProfile());
	}
}
