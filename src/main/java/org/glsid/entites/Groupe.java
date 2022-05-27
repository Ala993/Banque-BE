package org.glsid.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="Groupes")
public class Groupe implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long codeGroupe;
private String nomGroupe;
@ManyToMany(mappedBy="groupes")
@JsonIgnore
private Collection<Employe> employes;
public Long getCodeGroupe() {
	return codeGroupe;
}
public void setCodeGroupe(Long codeGroupe) {
	this.codeGroupe = codeGroupe;
}
public String getNomGroupe() {
	return nomGroupe;
}
public void setNomGroupe(String nomGroupe) {
	this.nomGroupe = nomGroupe;
}
public Collection<Employe> getEmployes() {
	return employes;
}
public void setEmployes(Collection<Employe> employes) {
	this.employes = employes;
}
public Groupe() {
	super();
}
public Groupe(String nomGroupe) {
	super();
	this.nomGroupe = nomGroupe;
}

}
