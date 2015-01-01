package metier;

import java.sql.SQLException;

import data.Note;
import factory.NoteFactory;

public class RechercheNote {

	public Note rechercheNoteEtu (Integer idEtu, Integer idCC) throws SQLException {
		NoteFactory fabNote = NoteFactory.getInstance();
		
		if(fabNote.rechercher(idEtu, idCC) != null) {
			Note note = fabNote.rechercher(idEtu, idCC);
			return note;
	
		}
		
		return null;	
		
	}
}
