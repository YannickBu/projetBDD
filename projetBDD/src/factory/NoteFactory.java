package factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import data.Note;


public class NoteFactory {
	
	private static NoteFactory singleton;
	
	public static NoteFactory getInstance(){
		if (singleton == null)
			singleton = new NoteFactory();
		return singleton;
	}

	public Note creer (int idEtu, int idCC, double note ) throws SQLException {
		Note noteEtu = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection connection = ConnectionFactory.getInstance().getConnection();
		String query = "INSERT INTO Note (idcc,idEtu,note) VALUES(?,?,?)";
		try {
			
			pst.setInt(1, idCC);
			pst.setInt(2, idEtu);
			pst.setDouble(3,note);
			
			pst.execute();
			
			noteEtu = new Note();
			if(rs.next()){
				noteEtu.setIdcc(idCC);
				noteEtu.setIdEtu(idEtu);
				noteEtu.setNote(note);	
			}
			
		} catch (SQLException se) {
			System.out.println("Echec de la creation de la note " +se.getMessage());
		}

		return noteEtu;
	}
	
	public Note rechercher (int idEtu, int idCC) throws SQLException{
		Note note = null;
		PreparedStatement pst = null;
		Connection connection = ConnectionFactory.getInstance().getConnection();
		String query = "SELECT note FROM Note WHERE idcc = ? and idEtu = ?";
		try {
		
			pst.setInt(1, idCC);
			pst.setInt(2, idEtu);
			
			ResultSet rs = pst.executeQuery();
			
			if(!rs.next()) {
				System.out.println( "Aucune note a ete trouve pour l'identifiant ");
			}

			note = new Note();
			note.setIdcc(idCC);
			note.setIdEtu(rs.getInt("idEtu"));
			note.setNote(rs.getDouble("note"));
			

		} catch (SQLException e) {
			System.out.println("Echec de la recuperation de la note "+e.getMessage());
		}
		return note;
	}
	

	public void supprimer (int idEtu , int idcc) throws SQLException{
		PreparedStatement pst = null;
		Connection connection = ConnectionFactory.getInstance().getConnection();
		String query = "DELETE FROM note WHERE idcc = ? and idEtu = ? ";
		try {
			pst = connection.prepareStatement(query);
			pst.clearParameters();
			
			pst.setInt(1, idcc);
			pst.setInt(2, idEtu);
			
			pst.execute();
			
		} catch (SQLException e) {
			System.out.println("Echec de la suppression de la note " +e.getMessage());
		}
	}
}
