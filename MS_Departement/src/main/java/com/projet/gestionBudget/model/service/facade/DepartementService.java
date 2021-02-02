package com.projet.gestionBudget.model.service.facade;

import java.util.List;

import com.projet.gestionBudget.bean.Departement;

public interface DepartementService {
	public List<Departement> findAll();
	int save(Departement departement);
	public int deleteById(Long id);
	public Departement findByLibelle(String libelle);
	public Departement findByRefDepartement(String refDepartement);
}