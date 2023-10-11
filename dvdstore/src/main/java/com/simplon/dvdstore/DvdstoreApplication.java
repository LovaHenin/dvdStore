package com.simplon.dvdstore;
import com.simplon.dvdstore.config.CorsConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(CorsConfig.class)
@SpringBootApplication
public class DvdstoreApplication {


	public static void main(String[] args) {


		SpringApplication.run(DvdstoreApplication.class);

	}
//	@Bean
//	public CommandLineRunner demo(DvdModelRepository repository){
//		return (args)->{
//			repository.save(new DvdModel("Titanic","Drame"));
//		};
//
//	}

}
