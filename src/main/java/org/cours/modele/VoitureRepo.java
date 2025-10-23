package org.cours.modele;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface VoitureRepo extends CrudRepository<Voiture, Long> {
	//Lister Voitures par modele
	List<Voiture> findByModele(@Param("modele") String modele);
	//Lister Voitures par couleur
	List<Voiture> findByCouleur(@Param("couleur") String couleur);
	// Sélectionnez les voitures par année
	List<Voiture> findByAnnee(@Param("annee") int annee);
	// Sélectionnez les voitures par marque et modele
	List<Voiture> findByMarqueAndModele(@Param("marque") String marque, @Param("modele") String modele);
	// Sélectionnez les voitures par marque ou couleur
	List<Voiture> findByMarqueOrCouleur(@Param("marque") String marque, @Param("couleur") String couleur);
	// Sélectionnez les voitures par marque et trier par annee
	List<Voiture> findByMarqueOrderByAnneeAsc(@Param("marque") String marque);
	// Sélectionnez les voitures par marque en utilisant SQL
	@Query("select v from Voiture v where v.marque = ?1")
	List<Voiture> findByMarque(@Param("marque") String marque);
	@Query("select v from Voiture v where v.marque like %?1")
	List<Voiture> findByMarqueEndsWith(@Param("marque") String marque);
}

