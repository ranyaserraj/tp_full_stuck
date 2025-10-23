package org.cours.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Voiture {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NonNull private String marque;
	@NonNull
	private String modele;
	@NonNull
	private String couleur;
	@NonNull
	private String immatricule;
	@NonNull
	private int annee;
	@NonNull
	private int prix;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proprietaire")
	@JsonIgnore
	private Proprietaire proprietaire;
}

