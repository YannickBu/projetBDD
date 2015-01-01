package metier;

import java.sql.SQLException;
import java.util.List;

import data.Etudiant;
import factory.EtudiantFactory;

public class MetierEtudiant {

	public MetierEtudiant() {}

	public Etudiant rechercheEtudian(Integer id) throws SQLException {
		EtudiantFactory fabEtu = EtudiantFactory.getInstance();
		
		if(fabEtu.rechercherEtudiantById(id) != null) {
			Etudiant etu = fabEtu.rechercherEtudiantById(id);
				return etu;
			}
		
		return null;	
		
	}
	
	public List<Etudiant> rechercheEtuParCC (Integer idcc) {
		return EtudiantFactory.getInstance().rechercherEtudiantByCC(idcc);
	}
}
