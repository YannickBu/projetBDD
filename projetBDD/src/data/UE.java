package data;

public class UE {

	private Integer idUE;
	private String libelle;
	private String rac;
	private Integer nbCred;
	
	private Formation form;
	
	public UE() {
		
	}

	public Integer getIdUE() {
		return idUE;
	}

	public void setIdUE(Integer idUE) {
		this.idUE = idUE;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getRac() {
		return rac;
	}

	public void setRac(String rac) {
		this.rac = rac;
	}

	public Integer getNbCred() {
		return nbCred;
	}

	public void setNbCred(Integer nbCred) {
		this.nbCred = nbCred;
	}

	public Formation getForm() {
		return form;
	}

	public void setForm(Formation form) {
		this.form = form;
	}

	
	
}
