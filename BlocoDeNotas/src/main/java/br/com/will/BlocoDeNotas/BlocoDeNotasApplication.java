package br.com.will.BlocoDeNotas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BlocoDeNotasApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlocoDeNotasApplication.class, args);
	}

}
