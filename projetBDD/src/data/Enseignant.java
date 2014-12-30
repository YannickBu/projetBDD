package data;

import java.util.List;

public class Enseignant {
	
	private Integer idEns;
	private String nom;
	private String prenom;
	
	private List<UE> listeUE;

	public Enseignant() {
		
	}

	public Integer getIdEns() {
		return idEns;
	}

	public void setIdEns(Integer idEns) {
		this.idEns = idEns;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<UE> getListeUE() {
		return listeUE;
	}

	public void setListeUE(List<UE> listeUE) {
		this.listeUE = listeUE;
	}

	
	
}
