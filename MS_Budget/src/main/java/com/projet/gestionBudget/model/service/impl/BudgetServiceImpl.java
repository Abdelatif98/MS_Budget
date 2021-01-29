package com.projet.gestionBudget.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.projet.gestionBudget.bean.Budget;
import com.projet.gestionBudget.model.dao.BudgetRepository;
import com.projet.gestionBudget.model.service.facade.BudgetService;



@Service
public class BudgetServiceImpl implements BudgetService{
	@Autowired
	private BudgetRepository budgetRepository;
	
	@Override
	public Budget findByAnnee(int annee) {
		return budgetRepository.findByAnnee(annee);
	}
	
	/*@Override
	public Budget findByAnneeAndBudgetDepartementDepartementLibelle(int annee,String libelle) {
		return budgetRepository.findByAnneeAndBudgetDepartementDepartementLibelle(annee,libelle);
	}*/
		
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
		return 0;
		/*Budget loadedBudget1 = findByAnnee((budget.getAnnee()));
		double montantF= 0;
		double montantI= 0;
		if(loadedBudget1 != null) {
			return -1;
		}
		else {
			budgetRepository.save(budget);
			Budget loadedBudget2 = findByAnnee((budget.getAnnee()));
			//save la liste des budgetDepartement pour mon budget (essayer d'app la meth d'Ayyoub)
			logger(budget.getBudgetDepartement().size());
			for(int i=0; i< budget.getBudgetDepartement().size();i++) {
				budget.getBudgetDepartement().get(i).setBudget(loadedBudget2);
				budgetDepartementServiceImpl.save(budget.getBudgetDepartement().get(i));
				montantF += budget.getBudgetDepartement().get(i).getMontantFonctionement();
				montantI += budget.getBudgetDepartement().get(i).getMontantInvestisement();
			}
			budget.setMontantFonctionement(montantF);
			budget.setMontantInvestisement(montantI);
			budget.setMontantTotal(budget.getMontantFonctionement()+budget.getMontantInvestisement());
			return 0;
		}*/
	}
	
	@Override
	public int saveBudget(Budget budget) {
		return 0;
		/*
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
		else if(montantI > loadedBudget.getMontantInvestisement() || montantF > loadedBudget.getMontantFonctionement()){
			return -2;
		}
		else {
			for(int i=0;i < budget.getBudgetDepartement().size();i++) {
				Budget loadedBudget2 = this.findByAnneeAndBudgetDepartementDepartementLibelle(budget.getAnnee(), budget.getBudgetDepartement().get(i).getDepartement().getLibelle());
				if(loadedBudget2 == null) {
					//update
				}
				else {
					//delete
				}
			}
			this.save(budget); // on va faire update
			return 0;
		}*/
	}
	
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
		return false;
    	/*
    	if(this.budgetRepository.findById(id).isPresent()) {
    		Budget budget = this.budgetRepository.findById(id).get();
    		this.budgetDepartementRepository.deleteByBudget(budget);
    		budgetRepository.deleteById(id);
    		return true;
    	}
    	return false;
    	*/
	}
	
}
