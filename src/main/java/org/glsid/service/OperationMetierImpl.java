package org.glsid.service;


import org.glsid.dao.CompteRepository;
import org.glsid.dao.EmployeRepository;
import org.glsid.dao.OperationRepository;
import org.glsid.entites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class OperationMetierImpl {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private EmployeRepository employeRepository;


    @Transactional
    public boolean verser(String code, double montant, Long codeEmp) {
        Compte cp = compteRepository.findById(code).get();
        Employe e = employeRepository.findById(codeEmp).get();
        Operation o = new Versement();
        o.setDateOperation(new Date());
        o.setMontant(montant);
        o.setCompte(cp);
        o.setEmploye(e);
        operationRepository.save(o);
        cp.setSolde(cp.getSolde() + montant);
		compteRepository.save(cp);
        return true;
    }


    @Transactional
    public boolean retirer(String code, double montant, Long codeEmp) {
        // TODO Auto-generated method stub
        Compte cp = compteRepository.findById(code).get();
        Employe e = employeRepository.findById(codeEmp).get();
        Operation o = new Retrait();
        o.setDateOperation(new Date());
        o.setMontant(montant);
        o.setCompte(cp);
        o.setEmploye(e);
        operationRepository.save(o);
        cp.setSolde(cp.getSolde() - montant);
        return true;
    }


    @Transactional
    public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) {
        retirer(cpte1, montant, codeEmp);
        verser(cpte2, montant, codeEmp);
        return true;
    }


    public Page<Operation> getOperations(org.springframework.data.domain.Pageable pageable, String codeCompte) {
        return operationRepository.findAllByCompteCodeCompte(codeCompte, pageable);
    }


}
