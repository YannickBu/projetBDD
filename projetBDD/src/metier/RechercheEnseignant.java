package metier;

import java.sql.SQLException;
import java.util.List;

import data.Enseignant;
import factory.EnseignantFactory;


public class RechercheEnseignant {

	public Enseignant rechercheEnseignant(String nom) throws SQLException {
		EnseignantFactory fabEns = EnseignantFactory.getInstance();
		
		if(fabEns.rechercherEnseignantByNom(nom) != null) {
			Enseignant ens = fabEns.rechercherEnseignantByNom(nom);
			
			return ens;
		}
		
		return null;	
		
	}

	public List<Enseignant> rechercheEnseignantParCC (Integer idcc) {
		return EnseignantFactory.getInstance().rechercherEnseignantsParCC(idcc);
	}
}