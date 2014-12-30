package data;

public class EC {

	private Integer idEC;
	private String libelle;
	private String rac;
	private Integer coeff;
	
	private UE ue;
	
	public EC() {
		
	}

	public Integer getIdEC() {
		return idEC;
	}

	public void setIdEC(Integer idEC) {
		this.idEC = idEC;
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

	public Integer getCoeff() {
		return coeff;
	}

	public void setCoeff(Integer coeff) {
		this.coeff = coeff;
	}

	public UE getUe() {
		return ue;
	}

	public void setUe(UE ue) {
		this.ue = ue;
	}

	
	
}
