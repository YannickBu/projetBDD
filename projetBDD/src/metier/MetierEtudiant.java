package metier;

import java.util.ArrayList;
import java.util.List;

import data.Enseignant;
import data.Etudiant;
import factory.EnseignantFactory;

public class MetierEtudiant {

	public MetierEtudiant() {
		
	}

	public List<Etudiant> listeEtudiantsParCCEtEnseignant(int idcc, String nomEns){
		List<Etudiant> listeEtu = new ArrayList<Etudiant>();
		
		Enseignant enseignant = EnseignantFactory.getInstance().rechercherEnseignantByNom(nomEns);
		
		
		
		return listeEtu;
	}
}
