package org.glsid.controler;

import org.glsid.dao.CompteRepository;
import org.glsid.entites.Compte;
import org.glsid.service.CompteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CompteRestService {

    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private CompteServiceImpl compteService;

    @GetMapping("/compte/{codeCompte}")
    public Compte getCompteByCode (@PathVariable String codeCompte) {
        return  compteRepository.findById(codeCompte).orElseThrow();
    }

    @PostMapping("/compte/{type}")
    public Compte createAccount (@PathVariable String type , @RequestBody Compte compte) {
        if(type.equals("CC")){
            return compteService.createCompteCourant(compte);
        }
        else{
            return compteService.createCompteEpargne(compte);
        }
    }
    @GetMapping("/comptes")
    public List<Compte> findAll(){
        return  compteRepository.findAll();
    }
}
