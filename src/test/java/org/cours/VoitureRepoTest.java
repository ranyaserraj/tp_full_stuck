package org.cours;

import static org.assertj.core.api.Assertions.assertThat;
import org.cours.SpringDataRest.SpringDataRestApplication;
import org.cours.modele.Proprietaire;
import org.cours.modele.Voiture;
import org.cours.modele.VoitureRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

@DataJpaTest
@ContextConfiguration(classes = SpringDataRestApplication.class)
//Si le test concerne uniquement les composantes JPA
//Lorsque cette annotation est utilisée, H2, Hibernate et Spring Data sont configurés 
//automatiquement pour le test.
public class VoitureRepoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	//TestEntityManager est utilisée pour manipuler les entités persistantes
	
	@Autowired
	VoitureRepo voitureRepo;
	
	@Test
	public void ajouterVoiture() {
		Proprietaire proprietaire = new Proprietaire("Ali", "Hassan");
		entityManager.persistAndFlush(proprietaire);
		
		Voiture voiture = new Voiture("MiolaCar","Uber","Blanche","M-2020", 2021, 180000);
		voiture.setProprietaire(proprietaire);
		entityManager.persistAndFlush(voiture);
		//permet de faire persister ce tuple de l'entité Voiture
		
		assertThat(voiture.getId()).isNotNull();
		//permet de tester qu'un tuple de Voiture a bien été ajoutée en mémoire H2
	}
	
	@Test
	public void supprimerVoiture() {
		Proprietaire proprietaire1 = new Proprietaire("Ali", "Hassan");
		Proprietaire proprietaire2 = new Proprietaire("Najat", "Bani");
		entityManager.persistAndFlush(proprietaire1);
		entityManager.persistAndFlush(proprietaire2);
		
		Voiture voiture1 = new Voiture("MiolaCar","Uber","Blanche","M-2020", 2021, 180000);
		voiture1.setProprietaire(proprietaire1);
		entityManager.persistAndFlush(voiture1);
		
		Voiture voiture2 = new Voiture("MiniCooper","Uber","Rouge","C-2020", 2021, 180000);
		voiture2.setProprietaire(proprietaire2);
		entityManager.persistAndFlush(voiture2);
		
		voitureRepo.deleteAll();
		assertThat(voitureRepo.findAll()).isEmpty();
		//permet de tester si tous les tuples ont été supprimés
	}
}

