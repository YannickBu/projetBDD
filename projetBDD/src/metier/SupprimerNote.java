package metier;

import java.sql.SQLException;

import factory.NoteFactory;


public class SupprimerNote {

	public void supprimerNote (Integer idEtu, Integer idCC) throws SQLException {
		NoteFactory.getInstance().supprimer(idEtu,idCC);
	}

}
