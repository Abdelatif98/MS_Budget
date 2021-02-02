package com.projet.gestionBudget.model.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.projet.gestionBudget.bean.Budget;
import com.projet.gestionBudget.model.dao.BudgetRepository;
import com.projet.gestionBudget.model.service.facade.BudgetService;
import com.projet.gestionBudget.model.ws.required.facade.BudgetDepartementRequiredRest;
import com.projet.gestionBudget.model.ws.required.facade.DepartementRequiredRest;

@Service
public class BudgetServiceImpl implements BudgetService{
	@Autowired
	private BudgetRepository budgetRepository;
	
	@Autowired
	private BudgetDepartementRequiredRest budgetDepartementRequiredRest;
	
	@Autowired
	private DepartementRequiredRest departementRequiredRest;
	
	@Override
	public Budget findByAnnee(int annee) {
		return budgetRepository.findByAnnee(annee);
	}
	
	@Override
	public Budget findByRefBudget(String ref) {
		return budgetRepository.findByRefBudget(ref);
	}
	

	public boolean testByAnneeAndBudgetDepartementDepartementLibelle(int annee,String libelle) {
		boolean test = false;
		Budget budget = budgetRepository.findByAnnee(annee);
		String ref = departementRequiredRest.findByLibelle(libelle).getReference();
		for(int i=0; i<budgetDepartementRequiredRest.findByRefDepartement(ref).size(); i++) {
			if(budgetDepartementRequiredRest.findByRefDepartement(ref).get(i).getRefBudget().equals(budget.getRefBudget())) {
				test = true;
			}
		}
		return test;
	}
		
	@Override
	public List<Budget> recupererByMontantInvestisementInf(double montant) {
		return budgetRepository.recupererByMontantInvestisementInf(montant);
	}

	@Override
	public List<Budget> recupererByMontantInvestisementSup(double montant) {
		return budgetRepository.recupererByMontantInvestisementSup(montant);
	}

	@Override
	public List<Budget> recupererByMontantFonctionementInf(double montant) {
		if(budgetRepository.recupererByMontantFonctionementInf(montant).isEmpty()) {
			return null;
			
		}
		return budgetRepository.recupererByMontantFonctionementInf(montant);
	}

	@Override
	public List<Budget> recupererByMontantFonctionementSup(double montant) {
		if(budgetRepository.recupererByMontantFonctionementSup( montant).isEmpty()) {
			return null;
			
		}
		return budgetRepository.recupererByMontantFonctionementSup( montant);
	}

	@Override
	public List<Budget> findByMontantInvestisementRestantGreaterThanEqual(double montantInvestisementRestant) {
		if(budgetRepository.findByMontantInvestisementRestantGreaterThanEqual(montantInvestisementRestant).isEmpty()) {
			return null;
			
		}
		return budgetRepository.findByMontantInvestisementRestantGreaterThanEqual(montantInvestisementRestant);
	}

	@Override
	public List<Budget> findByMontantInvestisementRestantLessThanEqual(double montantInvestisementRestant) {
		if(budgetRepository.findByMontantInvestisementRestantLessThanEqual(montantInvestisementRestant).isEmpty()) {
			return null;
			
		}
		return budgetRepository.findByMontantInvestisementRestantLessThanEqual(montantInvestisementRestant);
	}

	@Override
	public List<Budget> findByMontantFonctionementRestantGreaterThanEqual(double montantFonctionementRestant) {
		if(budgetRepository.findByMontantFonctionementRestantGreaterThanEqual(montantFonctionementRestant).isEmpty()) {
			return null;
			
		}
		return budgetRepository.findByMontantFonctionementRestantGreaterThanEqual(montantFonctionementRestant);
	}

	@Override
	public List<Budget> findByMontantFonctionementRestantLessThanEqual(double montantFonctionementRestant) {
		if( budgetRepository.findByMontantFonctionementRestantLessThanEqual(montantFonctionementRestant).isEmpty()) {
			return null;
			
		}
		return budgetRepository.findByMontantFonctionementRestantLessThanEqual(montantFonctionementRestant);
	}

	@Override
	public List<Budget> findByMontantTotal(double montantTotal) {
		if( budgetRepository.findByMontantTotal(montantTotal).isEmpty()) {
			return null;
		}
		return budgetRepository.findByMontantTotal(montantTotal);
	}

	@Override
	public int save(Budget budget) {
		Budget loadedBudget = findByAnnee((budget.getAnnee()));
		if(loadedBudget != null) {
			return -1;
		}
		else {
			budget.setMontantTotal(budget.getMontantFonctionement()+budget.getMontantInvestisement());
			budgetRepository.save(budget);
			return 1;
		}
	}
	
	/*@Override
	public int saveBudget(Budget budget) {
		Budget loadedBudget = findByAnnee(budget.getAnnee());
		double montantI=0;
		double montantF=0;
		//tester si null
		for(int i=0;i<budget.getBudgetDepartement().size();i++) {
			montantI+=budget.getBudgetDepartement().get(i).getMontantInvestisement();
			montantF+=budget.getBudgetDepartement().get(i).getMontantFonctionement();
		}
		if(loadedBudget == null) {
			return -1;
		}
		else {
			for(int i=0;i < budgetDepartementRequiredRest.findByRefBudget(budget.getRefBudget()).size();i++) { // besoin de la liste a inserer
				if(this.testByAnneeAndBudgetDepartementDepartementLibelle(budget.getAnnee(),budgetDepartementRequiredRest.findByRefBudget(budget.getRefBudget()).get(i).get) == true) {
					//update
				}
				else {
					//delete
				}
			}
			this.save(budget); // on va faire update
			return 0;
		}
	}*/
	
	@Override
	public List<Budget> findAll() {
		return budgetRepository.findAll();
	}

	@Override
	public Budget findById(Long id) {
		if(this.budgetRepository.findById(id).isPresent()) {
			return budgetRepository.findById(id).get();
		}
		return null;
	}
    @Transactional
	@Override
	public boolean deleteById(Long id) {
    	if(this.budgetRepository.findById(id).isPresent()) {
    		Budget budget = this.budgetRepository.findById(id).get();
    		budgetDepartementRequiredRest.deleteByRefBudget(budget.getRefBudget());
    		budgetRepository.deleteById(id);
    		return true;
    	}
    	return false;
    	
	}
	
}
