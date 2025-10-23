package org.cours.SpringDataRest;

import org.cours.modele.Proprietaire;
import org.cours.modele.ProprietaireRepo;
import org.cours.modele.Voiture;
import org.cours.modele.VoitureRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("org.cours.modele")
@EnableJpaRepositories("org.cours.modele")
@ComponentScan({"org.cours.SpringDataRest", "org.cours.web"})
public class SpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(VoitureRepo repository, ProprietaireRepo proprietaireRepo){
		return args -> {
			Proprietaire proprietaire1 = new Proprietaire("Ali" , "Hassan");
			Proprietaire proprietaire2 = new Proprietaire("Najat" , "Bani");
			proprietaireRepo.save(proprietaire1);
			proprietaireRepo.save(proprietaire2);
			
			Voiture voiture1 = new Voiture("Toyota", "Corolla", "Grise", "A-1-9090", 2018, 95000);
			voiture1.setProprietaire(proprietaire1);
			repository.save(voiture1);
			
			Voiture voiture2 = new Voiture("Ford", "Fiesta", "Rouge", "A-2-8090", 2015, 90000);
			voiture2.setProprietaire(proprietaire1);
			repository.save(voiture2);
			
			Voiture voiture3 = new Voiture("Honda", "CRV", "Bleu", "A-3-7090", 2016, 140000);
			voiture3.setProprietaire(proprietaire2);
			repository.save(voiture3);
		};
	}
}
