package factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.CC;
import data.EC;

public class ECFactory {

	private static ECFactory instance;
	private Connection c;
	
	public ECFactory() {
		c = ConnectionFactory.getInstance().getConnection();
	}
	
	public final static ECFactory getInstance(){
		if(instance == null)
			instance = new ECFactory();
		return instance;
	}

	public EC rechercherECById(Integer id){
		EC ec = null;
		
		try {
			PreparedStatement st = c.prepareStatement("select idec, idue, libec, racec from ec where idec = ?");
			st.setInt(1, id);
		
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				ec = new EC();
				ec.setIdEC(rs.getInt("idec"));
				ec.setLibelle(rs.getString("libec"));
				ec.setRac(rs.getString("racec"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ec;
	}
	
}
