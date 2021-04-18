package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {

	@Autowired
	VilleBLO villeBLOService;

	// Méthode GET
	@RequestMapping(value = "/ville_france", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codePostal") String codePostal) {
		return villeBLOService.getInfoVille(codePostal);
		
	}
	
	// Méthode POST
	@RequestMapping(value = "/ville_france", method = RequestMethod.POST)
	@ResponseBody
	public void appelPost(@RequestBody(required = true) Ville ville){
		villeBLOService.postNouvelleVille(ville);
		
	}
	
	// Méthode PUT
	@RequestMapping(value = "/ville_france", method = RequestMethod.PUT)
	@ResponseBody
	public void appelPut(@RequestBody(required = true) Ville ville, @RequestParam(required = true, value = "insee") String insee) {
		villeBLOService.putVille(insee, ville);
	}
	
	// Méthode DELETE
		@RequestMapping(value = "/ville_france", method = RequestMethod.DELETE)
		@ResponseBody
		public void appelDelete(@RequestParam(required = true, value = "insee") String insee) {
			villeBLOService.deleteVille(insee);
		}
}
