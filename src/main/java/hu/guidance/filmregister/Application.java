package hu.guidance.filmregister;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// for modelmapping
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
