package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {

	ArrayList<Ville> findAllVilles();

	ArrayList<Ville> getVilleByCodePostal(String code);
	
	public void setNouvelleVille(Ville ville);
	
	public void setModificationVille(String insee, Ville ville);
	
	public void supprimerVille(String insee);
}
