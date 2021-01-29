package com.projet.gestionBudget.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projet.gestionBudget.bean.BudgetCompteComptable;

@Repository
public interface BudgetCompteComptableRepository extends JpaRepository<BudgetCompteComptable,Long>{
	public List<BudgetCompteComptable> findByMontant(int montant);
}
