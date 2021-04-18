package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Service
public class VilleDAOImpl implements VilleDAO {

	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> liste = new ArrayList<Ville>();

		Connection con = new JDBCConfiguration().getCo();
		try {
			Statement st = con.createStatement();
			ResultSet resultat = st.executeQuery("SELECT * FROM ville_france;");
			while (resultat.next()) {
				Ville ville = new Ville(resultat.getString(1), resultat.getString(2), resultat.getString(3),
						resultat.getString(4), resultat.getString(6), resultat.getString(7));
				liste.add(ville);
			}
			return liste;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<Ville> getVilleByCodePostal(String code) {
		ArrayList<Ville> liste = new ArrayList<Ville>();
		Connection con = new JDBCConfiguration().getCo();

		try {
			Statement st = con.createStatement();
			ResultSet resultat = st.executeQuery("SELECT * FROM ville_france WHERE Code_postal='" + code + "';");
			while (resultat.next()) {
				Ville ville = new Ville(resultat.getString(1), resultat.getString(2), resultat.getString(3),
						resultat.getString(4), resultat.getString(6), resultat.getString(7));
				liste.add(ville);
			}
			return liste;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void setNouvelleVille(Ville ville) {
		Connection con = new JDBCConfiguration().getCo();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO `ville_france` (`Code_commune_INSEE`, `Nom_commune`, `Code_postal`,"
					+ " `Libelle_acheminement`, `Ligne_5`, `Latitude`, `Longitude`) VALUES ('" + ville.getInsee() + "', '" + ville.getNom() 
					+ "', '" + ville.getCodePostal() + "', '" + ville.getNom() + "', '', '" + ville.getLatitude() 
					+ "', '" + ville.getLongitude() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setModificationVille(String insee, Ville ville) {
		Connection con = new JDBCConfiguration().getCo();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("UPDATE `ville_france` SET `Code_commune_INSEE` = '" + ville.getInsee() 
			+ "', `Nom_commune` = '" + ville.getNom() + "', `Code_postal` = '" + ville.getCodePostal() 
			+ "', `Libelle_acheminement` = '" + ville.getNom() + "', `Ligne_5` = '', `Latitude` = '" 
			+ ville.getLatitude() + "', `Longitude` = '" + ville.getLongitude() + "' WHERE `Code_commune_INSEE` = " + insee + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void supprimerVille(String insee) {
		Connection con = new JDBCConfiguration().getCo();
		try {
			Statement st = con.createStatement();
			st.executeUpdate("DELETE FROM `ville_france` WHERE `Code_commune_INSEE` = " + insee + ";");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
