package com.projet.gestionBudget.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.gestionBudget.bean.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement,Long> {
	 public Departement findByid(Long id);
	 public Departement findByLibelle(String libelle);
	 public Departement findByRefDepartement(String refDepartement);
	
}
