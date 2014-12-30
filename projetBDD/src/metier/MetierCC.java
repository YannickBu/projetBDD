package metier;

import data.CC;
import factory.CCFactory;

public class MetierCC {

	public MetierCC() {
		
	}

	public CC rechercherCC(Integer idcc){
		return CCFactory.getInstance().rechercherCCById(idcc);
	}
	
	public boolean estValide(CC cc){
		return cc != null && "individuel".equals(cc.getSsType());
	}
}
