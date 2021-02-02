package com.projet.gestionBudget.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.gestionBudget.bean.Budget;


@Repository
public interface BudgetRepository extends JpaRepository<Budget,Long>{
	
	public Budget findByAnnee(int annee);
	
	public Budget findByRefBudget(String ref);
	
	//public Budget findByAnneeAndBudgetDepartementDepartementLibelle(int annee,String libelle);
	
	@Query("SELECT t FROM Budget t WHERE t.montantInvestisement <= :montant") //on interoge avec Bean
	public List<Budget> recupererByMontantInvestisementInf(@Param("montant") double montant);
	
	@Query("SELECT t FROM Budget t WHERE t.montantInvestisement >= :montant")
	public List<Budget> recupererByMontantInvestisementSup(@Param("montant") double montant);
	
	@Query(value = "SELECT * FROM budget t WHERE t.montant_fonctionement <= :montant", nativeQuery = true)
	public List<Budget> recupererByMontantFonctionementInf(@Param("montant") double montant);
	
	@Query(value = "SELECT * FROM budget t WHERE t.montant_fonctionement >= :montant", nativeQuery = true) //on interoge avec Sql
	public List<Budget> recupererByMontantFonctionementSup(@Param("montant") double montant);
	
	public List<Budget> findByMontantInvestisementRestantGreaterThanEqual(double montantInvestisementRestant);
	
	public List<Budget> findByMontantInvestisementRestantLessThanEqual(double montantInvestisementRestant);
	
	public List<Budget> findByMontantFonctionementRestantGreaterThanEqual(double montantFonctionementRestant);
	
	public List<Budget> findByMontantFonctionementRestantLessThanEqual(double montantFonctionementRestant);
	
	public List<Budget> findByMontantTotal(double montantTotal);
}
