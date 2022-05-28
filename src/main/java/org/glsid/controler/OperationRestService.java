package org.glsid.controler;


import org.glsid.entites.*;
import org.glsid.service.OperationMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class OperationRestService {
    @Autowired
    private OperationMetierImpl operationMetier;

    /**
     * Retourner liste d'oprations avec méthode GET
     */
    @PutMapping("/versement")
    public boolean verser(@RequestParam double montant, @RequestParam Long codeEmp, @RequestParam String code) {

        System.out.println(montant);
        return   operationMetier.verser(code, montant, codeEmp);

    }

    @PutMapping("/retrait")
    public boolean retirer(
            @RequestParam String code,
            @RequestParam double montant,
            @RequestParam Long codeEmp) {
        return operationMetier.retirer(code, montant, codeEmp);
    }


    @PutMapping("/virement")
    public boolean virement(
            @RequestParam String cpte1,
            @RequestParam String cpte2,
            @RequestParam double montant,
            @RequestParam Long codeEmp) {
        return operationMetier.virement(cpte1, cpte2, montant, codeEmp);
    }

    @GetMapping("/operations/{codeCompte}")
    public List<Operation> getOperations (org.springframework.data.domain.Pageable pageable, @PathVariable String codeCompte){
        return operationMetier.getOperations(pageable , codeCompte).getContent();
    }

}
