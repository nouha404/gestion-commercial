package com.ism.ismecom;

import com.ism.ismecom.data.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IsmEcomApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IsmEcomApplication.class, args);
	}

	@Autowired
	private ClientRepository clientRepository;
	@Override
	public void run(String... args) throws Exception {
		//Liste des clients
		clientRepository.findAllByActiveTrue().stream().forEach(client -> {
			System.out.println(client.getNomComplet()+" "+client.getActive());
		});
	}
}
