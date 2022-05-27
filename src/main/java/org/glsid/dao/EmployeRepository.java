package org.glsid.dao;

import org.glsid.entites.Employe;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeRepository extends JpaRepository<Employe,Long> {
	

}
