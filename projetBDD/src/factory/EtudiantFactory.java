package factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Etudiant;

public class EtudiantFactory {

	private static EtudiantFactory instance;
	private Connection c;
	
	public EtudiantFactory() {
		c = ConnectionFactory.getInstance().getConnection();
	}

	public final static EtudiantFactory getInstance(){
		if(instance == null)
			instance = new EtudiantFactory();
		return instance;
	}
	
	public List<Etudiant> rechercherEtudiantByCC(Integer idcc){
		List<Etudiant> listeEtu = new ArrayList<Etudiant>();
		
			try {
				PreparedStatement st = c.prepareStatement("select idetu, nometu, prenometu from etudiant natural join note where idcc = '" + idcc + "'");
			
				ResultSet rs = st.executeQuery();
				
				Etudiant etu = null;
				while(rs.next()){
					etu = new Etudiant();
					
					etu.setIdEtu(rs.getInt("idetu"));
					etu.setNom(rs.getString("nometu"));
					etu.setPrenom(rs.getString("prenometu"));
					
					listeEtu.add(etu);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return listeEtu;
	}
	
}
