package com.projet.gestionBudget.model.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.gestionBudget.bean.Departement;
import com.projet.gestionBudget.model.dao.DepartementRepository;
import com.projet.gestionBudget.model.service.facade.DepartementService;

@Service
public class DepartementServiceImpl implements DepartementService {
	@Autowired
	DepartementRepository departementRep;
	public Departement findByLibelle(String libelle) {
		return departementRep.findByLibelle(libelle);
	}

	public Departement findByRefDepartement(String refDepartement) {
		return departementRep.findByLibelle(refDepartement);
	}
	
public  int  save(Departement dep) {
	Departement loaddep=findByLibelle(dep.getLibelle());
	if(loaddep!=null) {
		return -1;
	}
	else {
		departementRep.save(dep);
		return 1;
	}
	}

	public List<Departement> findAll() {
		return departementRep.findAll();
	}

	public Optional<Departement>  findById(Long id) {
		if (this.departementRep.findById(id).isPresent())return departementRep.findById(id);
		
		return null;
	}

	@Transactional
	public int deleteById(Long id) {
		if(this.departementRep.findById(id).isPresent()) {
    		departementRep.deleteById(id);
    		return 1;
	}
		return 0;
		
	}

	public void deleteAll() {
		departementRep.deleteAll();
	}




	
	
}