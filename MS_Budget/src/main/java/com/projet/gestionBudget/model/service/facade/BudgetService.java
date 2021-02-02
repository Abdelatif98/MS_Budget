package com.projet.gestionBudget.model.service.facade;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projet.gestionBudget.bean.Budget;
import com.projet.gestionBudget.model.ws.required.vo.BudgetDepartementVo;

@Service
public interface BudgetService {
	public Budget findByAnnee(int annee);
	
	//public Budget findByAnneeAndBudgetDepartementDepartementLibelle(int annee,String libelle);
	
	public List<Budget> recupererByMontantInvestisementInf(double montant);
	
	public List<Budget> recupererByMontantInvestisementSup(double montant);
	
	public List<Budget> recupererByMontantFonctionementInf(double montant);
	
	public List<Budget> recupererByMontantFonctionementSup(double montant);
	
	public List<Budget> findByMontantInvestisementRestantGreaterThanEqual(double montantInvestisementRestant);
	
	public List<Budget> findByMontantInvestisementRestantLessThanEqual(double montantInvestisementRestant);
	
	public List<Budget> findByMontantFonctionementRestantGreaterThanEqual(double montantFonctionementRestant);
	
	public List<Budget> findByMontantFonctionementRestantLessThanEqual(double montantFonctionementRestant);
	
	public List<Budget> findByMontantTotal(double montantTotal);
	
	public int save(Budget budget);
	
	public List<Budget> findAll();
	
	public Budget findById(Long id);
	
	public Budget findByRefBudget(String ref);
	
	@Transactional
	public boolean  deleteById(Long id);

	//public int saveBudget(Budget budget);

}
