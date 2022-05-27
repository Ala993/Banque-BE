package org.glsid.dao;


import org.glsid.entites.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OperationRepository extends JpaRepository <Operation,Long>{
	
	Page<Operation> findAllByCompteCodeCompte(String codeCompte, Pageable pageable);
	

}
