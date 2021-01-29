package com.projet.gestionBudget.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.gestionBudget.bean.BudgetCompteComptable;
import com.projet.gestionBudget.model.dao.BudgetCompteComptableRepository;
import com.projet.gestionBudget.model.service.facade.BudgetCompteComptableService;

@Service
public class BudgetCompteComptableServiceImpl implements BudgetCompteComptableService{
	@Autowired
	private BudgetCompteComptableRepository budgetCompteComptableRepository;

	@Override
	public List<BudgetCompteComptable> findByMontant(int montant) {
		return budgetCompteComptableRepository.findByMontant(montant);
	}

	@Override
	public BudgetCompteComptable save(BudgetCompteComptable budget) {
		return budgetCompteComptableRepository.save(budget);
	}

	@Override
	public List<BudgetCompteComptable> findAll() {
		return budgetCompteComptableRepository.findAll();
	}

	@Override
	public BudgetCompteComptable findById(Long id) {
		return budgetCompteComptableRepository.findById(id).get();
	}
	@Transactional
	@Override
	public void deleteById(Long id) {
		budgetCompteComptableRepository.deleteById(id);
	}

	
}
