package factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.Enseignant;
import data.UE;

public class EnseigneFactory {

	private static EnseigneFactory instance;
	private Connection c;
	
	public EnseigneFactory() {
		c = ConnectionFactory.getInstance().getConnection();
	}
	
	public final static EnseigneFactory getInstance(){
		if(instance == null)
			instance = new EnseigneFactory();
		return instance;
	}

	public List<UE> listerUEPourUnEnseignant(int idEnseign){
		List<UE> listeUE = new ArrayList<UE>();
		UE ue = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = c.prepareStatement("select idue from enseigne where idenseigne = ?");
			st.setInt(1, idEnseign);
			rs = st.executeQuery();
			
			while(rs.next()){
				ue = UEFactory.getInstance().rechercherUEById(rs.getInt("idue"));
				listeUE.add(ue);
			}
			
		} catch (SQLException e) {
			System.out.println("Erreur listerUEPourUnEnseignant - " + e.getMessage());
		}
		
		return listeUE;
	}
	
	public List<Enseignant> listerEnseignantPourUneUE(int idUE){
		List<Enseignant> listeEnseignant = new ArrayList<Enseignant>();
		Enseignant enseignant = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = c.prepareStatement("select idenseigne from enseigne where idue = ?");
			st.setInt(1, idUE);
			rs = st.executeQuery();
			
			while(rs.next()){
				enseignant = EnseignantFactory.getInstance().rechercherEnseignantById(rs.getInt("idenseigne"));
				listeEnseignant.add(enseignant);
			}
			
		} catch (SQLException e) {
			System.out.println("Erreur listerEnseignantPourUneUE - " + e.getMessage());
		}
		
		return listeEnseignant;
	}
}
