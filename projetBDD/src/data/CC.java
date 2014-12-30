package data;

import java.util.List;

public class CC {

	private Integer idCC;
	private Integer noteMax;
	private String type;
	private String ssType;
	private Integer coeff;
	
	private List<Etudiant> listeEtu;
	private EC ec;
	
	public CC() {
		
	}

	public Integer getIdCC() {
		return idCC;
	}

	public void setIdCC(Integer idCC) {
		this.idCC = idCC;
	}

	public Integer getNoteMax() {
		return noteMax;
	}

	public void setNoteMax(Integer noteMax) {
		this.noteMax = noteMax;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSsType() {
		return ssType;
	}

	public void setSsType(String ssType) {
		this.ssType = ssType;
	}

	public Integer getCoeff() {
		return coeff;
	}

	public void setCoeff(Integer coeff) {
		this.coeff = coeff;
	}


	public List<Etudiant> getListeEtu() {
		return listeEtu;
	}

	public void setListeEtu(List<Etudiant> listeEtu) {
		this.listeEtu = listeEtu;
	}

	public EC getEc() {
		return ec;
	}

	public void setEc(EC ec) {
		this.ec = ec;
	}

	
	
}
