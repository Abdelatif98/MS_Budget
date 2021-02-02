package com.projet.gestionBudget.model.ws.provided.vo;


public class DepartementVo{

private Long id;
private String libelle;
private String reference;
public Long getId() {
	return id;
}

public String getReference() {
	return reference;
}

public void setReference(String reference) {
	this.reference = reference;
}

public void setId(Long id) {
	this.id = id;
}

public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public DepartementVo() {
	super();

}
public DepartementVo(Long id, String libelle) {
	super();
	this.id = id;
	libelle = libelle;
}


}
