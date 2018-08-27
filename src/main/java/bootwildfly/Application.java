package bootwildfly;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import bootwildfly.main.repo.UserRepository;

//@EnableJpaRepositories("bootwildfly.main.repo")
//@EntityScan("bootwildfly.main.model")
@EnableAutoConfiguration
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	@Bean
	public CommandLineRunner loadData(UserRepository ur) {
		return (args) -> {

//			repository.save(new User("Jack", "Bauer"));
//			repository.save(new User("Chloe", "O'Brian"));
//			repository.save(new User("Kim", "Bauer"));
//			repository.save(new User("David", "Palmer"));
//			repository.save(new User("Michelle", "Dessler"));

		};
	}

}
