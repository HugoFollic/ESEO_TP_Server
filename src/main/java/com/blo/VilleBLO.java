package com.blo;

import java.util.ArrayList;
import com.dto.Ville;

public interface VilleBLO {
	
	public ArrayList<Ville> getInfoVille(String monParam);
	
	public void postNouvelleVille(Ville paramVille);
		
	public void putVille(String insse, Ville paramVille);
	
	public void deleteVille(String insse);
}
