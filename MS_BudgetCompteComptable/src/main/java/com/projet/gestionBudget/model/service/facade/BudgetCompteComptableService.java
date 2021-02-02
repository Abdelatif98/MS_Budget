package com.projet.gestionBudget.model.service.facade;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.projet.gestionBudget.bean.BudgetCompteComptable;

public interface BudgetCompteComptableService {
	public List<BudgetCompteComptable> findByMontant(int montant);
	
	public int save(BudgetCompteComptable budget);
	
	public List<BudgetCompteComptable> findAll();
	
	public BudgetCompteComptable findById(Long id);
	
	@Transactional
	public void  deleteById(Long id);
}
