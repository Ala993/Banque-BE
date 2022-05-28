package org.glsid;

import org.glsid.dao.ClientRepository;
import org.glsid.dao.CompteRepository;
import org.glsid.dao.EmployeRepository;
import org.glsid.dao.GroupeRepository;
import org.glsid.entites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class BanqueApplication implements ApplicationRunner {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private GroupeRepository groupeRepository;

	public static void main(String[] args) {
		SpringApplication.run(BanqueApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Groupe groupe = new Groupe();
		groupe.setNomGroupe("emp");
		groupe = groupeRepository.save(groupe);

		Employe employe = new Employe();
		employe.setNomEmploye("mohamed");
		employe.setGroupes(Arrays.asList(groupe));
		employe = employeRepository.save(employe);

		Client client = new Client();
		client.setNomClient("amin");
		client = clientRepository.save(client);


		Compte compteCourant = new CompteCourant();
		compteCourant.setCodeCompte("cc1");
		compteCourant.setSolde(5000);
		compteCourant.setClient(client);
		compteCourant.setEmploye(employe);
		compteCourant.setDateCreation(new Date());
		compteRepository.save(compteCourant);

		client.setComptes(Arrays.asList(compteCourant));
		clientRepository.save(client);

	}
}
