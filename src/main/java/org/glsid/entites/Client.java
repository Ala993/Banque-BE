package org.glsid.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Client implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long codeClient;
private String nomClient;
@OneToMany (mappedBy="client",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
@JsonIgnore
private Collection<Compte> comptes;


public Long getCodeClient() {
	return codeClient;
}

public Client(Long codeClient, String nomClient, Collection<Compte> comptes) {
	super();
	this.codeClient = codeClient;
	this.nomClient = nomClient;
	this.comptes = comptes;
}

public String getNomClient() {
	return nomClient;
}
public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}
public Collection<Compte> getComptes() {
	return comptes;
}
public void setComptes(Collection<Compte> comptes) {
	this.comptes = comptes;
}
public Client(String nomClient) {
	super();
	this.nomClient = nomClient;
}
public Client() {
	super();
}


}