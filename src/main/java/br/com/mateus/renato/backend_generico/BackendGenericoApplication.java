package br.com.mateus.renato.backend_generico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("test")
public class BackendGenericoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendGenericoApplication.class, args);
	}

}
