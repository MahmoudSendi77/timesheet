package tn.esprit.spring.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IEntrepriseService;

@SpringBootTest
@RunWith(SpringRunner.class)

public class EntrepriseServiceImplTest {
	@Autowired
	IEntrepriseService ientrepriseservice;
	
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	
	Integer idE=8;
	
	
	@Test
	public void testAjouterEntreprise()  {      
		 idE=ientrepriseservice.ajouterEntreprise(new Entreprise("test_nom_entreprise","test_raison_sociale "));
		assertNotNull(idE);
	}
	
	@Test
	public void testGetEntrpriseById() {
		Entreprise e =ientrepriseservice.getEntrepriseById(1); 
		assertEquals(1, e.getId());
	}
	
	@Test
	public void testGetAllDepartementsNamesByEntreprise() {
		
		List<String> depNames = ientrepriseservice.getAllDepartementsNamesByEntreprise(1);
		assertNotNull(depNames);
	}

	
	
	
	@Test
	public void testDeleteEntrepriseById()
	{
		
		int i = ientrepriseservice.deleteEntrepriseById(idE);
		
		assertEquals(0, i);
		
	}
		
	
	
	
}