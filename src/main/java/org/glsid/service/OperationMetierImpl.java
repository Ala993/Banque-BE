package org.glsid.service;


import org.glsid.dao.CompteRepository;
import org.glsid.dao.EmployeRepository;
import org.glsid.entites.Compte;

import org.glsid.dao.*;

import org.glsid.entites.Employe;
import org.glsid.entites.Operation;
import org.glsid.entites.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import javax.transaction.Transactional;
import java.util.Date;

@Service
public class OperationMetierImpl  {
	@Autowired
 private OperationRepository operationRepository;
	@Autowired
 private CompteRepository CompteRepository;
	@Autowired
	 private EmployeRepository employeRepository;
	private Object Pageable;
	

	@Transactional
	public boolean verser(String code, double montant, Long codeEmp) {
		Compte cp=CompteRepository.findById(code).get();
		Employe e=employeRepository.findById(codeEmp).get();
	Operation o=new Versement();
	o.setDateOperation(new Date());
	o.setMontant(montant);
	o.setCompte(cp);
	o.setEmploye(e);
	operationRepository.save(o);
	cp.setSolde(cp.getSolde()+montant);
	return true;
	}

	@Transactional
	public boolean verser2(String code, double montant, Long codeEmp) {
		Compte cp=CompteRepository.findById(code).get();
		Employe e=employeRepository.findById(codeEmp).get();
	Operation o=new Versement();
	o.setDateOperation(new Date());
	o.setMontant(montant);
	o.setCompte(cp);
	o.setEmploye(e);
	operationRepository.save(o);
	cp.setSolde(cp.getSolde()+montant);
	return true;
	}

	@Transactional
	public boolean retirer(String code, double montant, Long codeEmp) {
		// TODO Auto-generated method stub
		Compte cp=CompteRepository.findById(code).get();
		Employe e=employeRepository.findById(codeEmp).get();
		
		
		
	Operation o=new Versement();
	o.setDateOperation(new Date());
	o.setMontant(montant);
	o.setCompte(cp);
	o.setEmploye(e);
	operationRepository.save(o);
	cp.setSolde(cp.getSolde()-montant);
        
	
	return true;
        
	

	}


	@Transactional
	public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) {
		
		retirer(cpte1,montant,codeEmp);
		verser(cpte2,montant,codeEmp);
		return true;
	}

	public PageOperation getOperations(String codeCompte, int page, int size) {
       
		return null;
	}

	public Page<Operation> getOperations (org.springframework.data.domain.Pageable pageable, String codeCompte){
		return operationRepository.findAllByCompteCodeCompte(codeCompte, pageable);
	}

	
	

}
