package com.simplon.dvdstore;
import com.simplon.dvdstore.repositories.DvdModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class DvdstoreApplication {


	public static void main(String[] args) {


		SpringApplication.run(DvdstoreApplication.class);

	}
	@Bean
	public CommandLineRunner demo(DvdModelRepository repository){
		return (args)->{
			repository.save(new DvdModel("Titanic","Drame"));
		};

	}

}
