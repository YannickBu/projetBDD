package factory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.CC;
import data.EC;

public class CCFactory {

	private static CCFactory instance;
	private Connection c;
	
	public CCFactory() {
		c = ConnectionFactory.getInstance().getConnection();
	}
	
	public final static CCFactory getInstance(){
		if(instance == null)
			instance = new CCFactory();
		return instance;
	}

	public CC rechercherCCById(Integer id){
		CC cc = null;
		
		try {
			PreparedStatement st = c.prepareStatement("select idCC, idec, noteMaxCC, typecc, sstypecc, coeff from controle_connaissance where idcc = ?");
			st.setInt(1, id);
		
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				cc = new CC();
				cc.setIdCC(rs.getInt("idcc"));
				cc.setCoeff(rs.getInt("coeff"));
				cc.setNoteMax(rs.getInt("notemaxcc"));
				cc.setSsType(rs.getString("sstypecc"));
				cc.setType(rs.getString("typecc"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cc;
	}
	
	public List<CC> listerCC(){
		List<CC> listeCC = new ArrayList<CC>();
		CC cc = null;
		EC ec = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			st = c.prepareStatement("select idCC, idEC, noteMaxCC, typecc, sstypecc, coeff from controle_connaissance");
			rs = st.executeQuery();
			while(rs.next()){
				ec = ECFactory.getInstance().rechercherECById(rs.getInt("idEC"));
				cc = new CC();
				cc.setIdCC(rs.getInt("idCC"));
				cc.setEc(ec);
				cc.setNoteMax(rs.getInt("noteMaxCC"));
				cc.setType(rs.getString("typecc"));
				cc.setType(rs.getString("sstypecc"));
				cc.setCoeff(rs.getInt("coeff"));
				listeCC.add(cc);
			}
		} catch (SQLException e) {
			System.out.println("Erreur listerCC - " + e.getMessage());
		}
		
		return listeCC;
	}
	
	public static void main(String[] args) {
		CC cc = CCFactory.getInstance().rechercherCCById(1);
		System.out.println(cc.getIdCC());
	}
}
