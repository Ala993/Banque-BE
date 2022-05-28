package org.glsid.service;

import org.glsid.dao.ClientRepository;
import org.glsid.dao.CompteRepository;
import org.glsid.dao.EmployeRepository;
import org.glsid.entites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CompteServiceImpl {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EmployeRepository employeRepository;

    public Compte createCompteCourant(Compte compte){
        Employe employe = employeRepository.findById(Long.valueOf(1)).get();
        Client client = new Client();
        client.setNomClient(compte.getClient().getNomClient());
        client = clientRepository.save(client);

        Compte compteCourant = new CompteCourant();
        compteCourant.setCodeCompte(compte.getCodeCompte());
        compteCourant.setSolde(compte.getSolde());
        compteCourant.setClient(client);
        compteCourant.setEmploye(employe);
        compteCourant.setDateCreation(new Date());
        return compteRepository.save(compteCourant);
    }


    public Compte createCompteEpargne(Compte compte){
        Employe employe = employeRepository.findById(Long.valueOf(1)).get();
        Client client = new Client();
        client.setNomClient(compte.getClient().getNomClient());
        client = clientRepository.save(client);

        Compte compteEpargne = new CompteEpargne();
        compteEpargne.setCodeCompte(compte.getCodeCompte());
        compteEpargne.setSolde(compte.getSolde());
        compteEpargne.setClient(client);
        compteEpargne.setEmploye(employe);
        compteEpargne.setDateCreation(new Date());
        return compteRepository.save(compteEpargne);

    }
}
