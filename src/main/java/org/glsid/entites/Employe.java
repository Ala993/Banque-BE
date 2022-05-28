package org.glsid.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Employe implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long codeEmploye;
private String nomEmploye;
private double montant;
@ManyToOne
@JoinColumn(name="Code_emp_sup")
private Employe EmployesSup;
@ManyToMany
@JoinTable(name="Emp_Gr", joinColumns=
@JoinColumn(name="Num_Emp"), inverseJoinColumns=
@JoinColumn (name="Num_Groupe"))
private Collection<Groupe> groupes;

public Employe(String nomEmploye) {
	super();
	this.nomEmploye = nomEmploye;
}
public Employe() {
	super();
}
public Long getCodeEmploye() {
	return codeEmploye;
}
public void setCodeEmploye(Long codeEmploye) {
	this.codeEmploye = codeEmploye;
}
public String getNomEmploye() {
	return nomEmploye;
}
@JsonSetter
public void setNomEmploye(String nomEmploye) {
	this.nomEmploye = nomEmploye;
}
@JsonIgnore
public Employe getEmployesSup() {
	return EmployesSup;
}

public void setEmployesSup(Employe employesSup) {
	EmployesSup = employesSup;
}
@JsonIgnore
public Collection<Groupe> getGroupes() {
	return groupes;
}
public void setGroupes(Collection<Groupe> groupes) {
	this.groupes = groupes;
}

}