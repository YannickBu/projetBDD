package factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.Formation;
import data.UE;

public class UEFactory {

	private static UEFactory instance;
	private Connection c;
	
	public UEFactory() {
		c = ConnectionFactory.getInstance().getConnection();
	}
	
	public final static UEFactory getInstance(){
		if(instance == null)
			instance = new UEFactory();
		return instance;
	}

	public UE rechercherUEById(Integer id){
		UE ue = null;
		Formation form = null;
		
		try {
			PreparedStatement st = c.prepareStatement("select idue, idform, libue, racue, nbcreditue from ue where idue = ?");
			st.setInt(1, id);
		
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				form = new Formation();
				form.setIdForm(rs.getInt("idform"));
				ue = new UE();
				ue.setIdUE(rs.getInt("idue"));
				ue.setForm(form);
				ue.setLibelle(rs.getString("libue"));
				ue.setRac(rs.getString("racue"));
				ue.setNbCred(rs.getInt("nbcreditue"));
			}
			
		} catch (SQLException e) {
			System.out.println("Erreur rechercherUEById - " + e.getMessage());
		}
		
		return ue;
	}
}
