package factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Enseignant;

public class EnseignantFactory {

	private static EnseignantFactory instance;
	private Connection c;
	
	public EnseignantFactory() {
		c = ConnectionFactory.getInstance().getConnection();
	}
	
	public final static EnseignantFactory getInstance(){
		if(instance == null)
			instance = new EnseignantFactory();
		return instance;
	}

	public Enseignant rechercherEnseignantById(Integer id){
		Enseignant ens = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = c.prepareStatement("select nomenseign, prenomenseign from enseignant where idenseign = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()){
				ens = new Enseignant();
				ens.setIdEns(id);
				ens.setNom(rs.getString("nomenseign"));
				ens.setPrenom(rs.getString("prenomenseign"));
			}
		} catch (SQLException e) {
			System.out.println("Erreur rechercherEnseignantById - " + e.getMessage());
		}
		
		
		return ens;
		
	}

	public Enseignant rechercherEnseignantByNom(String nom){
		Enseignant ens = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = c.prepareStatement("select idenseign, prenomenseign from enseignant where nomenseign = ?");
			st.setString(1, nom);
			rs = st.executeQuery();
			
			if(rs.next()){
				ens = new Enseignant();
				ens.setIdEns(rs.getInt("idenseign"));
				ens.setNom(nom);
				ens.setPrenom(rs.getString("prenomenseign"));
			}
		} catch (SQLException e) {
			System.out.println("Erreur rechercherEnseignantByNom - " + e.getMessage());
		}
		
		
		return ens;
		
	}
	
	public List<Enseignant> rechercherEnseignantsParCC(int idcc){
		List<Enseignant> listeEnseignant = new ArrayList<Enseignant>();
		Enseignant ens = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = c.prepareStatement("select idenseign, nomenseign, prenomenseign from enseignant join enseigne on enseignant.idenseign = enseigne.idenseigne" +
					" join ue on ue.idue = enseigne.idue join ec on ec.idue = ue.idue join controle_connaissance on controle_connaissance.idec = ec.idec" +
					" where controle_connaissance.idcc = ?");
			st.setInt(1, idcc);
			rs = st.executeQuery();
			
			while (rs.next()){
				ens = new Enseignant();
				ens.setIdEns(rs.getInt("idenseign"));
				ens.setNom(rs.getString("nomenseign"));
				ens.setPrenom(rs.getString("prenomenseign"));
				listeEnseignant.add(ens);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeEnseignant;
	}
}
