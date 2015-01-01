package metier;

import java.sql.SQLException;

import data.Etudiant;
import data.Note;
import factory.EtudiantFactory;
import factory.NoteFactory;


public class CreerNote {

	public Note creerNoteEtu (Integer idEtu, Integer idCC , double note) throws SQLException {
		EtudiantFactory fabEtu = EtudiantFactory.getInstance();
		NoteFactory fabNote = NoteFactory.getInstance();
		Note noteEtu = null;
		Etudiant etudiant = fabEtu.rechercherEtudiantById(idEtu);
		
		if (etudiant != null){
			noteEtu = fabNote.creer(idEtu, idCC, note);	
		}
		
		return noteEtu;	
		
	}
}
