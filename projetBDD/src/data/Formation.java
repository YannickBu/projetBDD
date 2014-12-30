package data;

import java.util.List;

public class Formation {

	private Integer idForm;
	private String libelle;
	private String annee;
	private String semestre;
	
	private List<UE> listeUE;
	
	public Formation() {
		
	}

	public Integer getIdForm() {
		return idForm;
	}

	public void setIdForm(Integer idForm) {
		this.idForm = idForm;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public List<UE> getListeUE() {
		return listeUE;
	}

	public void setListeUE(List<UE> listeUE) {
		this.listeUE = listeUE;
	}

	
	
}
