package com.projet.gestionBudget.model.ws.provided.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.gestionBudget.bean.BudgetCompteComptable;
import com.projet.gestionBudget.model.service.facade.BudgetCompteComptableService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette class permet de gerer les traiements relative au BudgetCompteComptable à savoir Save, FindAll, ...etc.")
@RestController
@RequestMapping("budgetcomptecomptable")
public class BudgetCompteComptableRest {
	@Autowired
	private BudgetCompteComptableService budgetCompteComptableService;
	
	@GetMapping("/Montant/{montant}")
	@ApiOperation("Cette methode permet de trouver l'ensemble des BudgetCompteComptables par montant")
	public List<BudgetCompteComptable> findByMontant(@PathVariable int montant) {
		return budgetCompteComptableService.findByMontant(montant);
	}
	
	@PostMapping("/")
	@ApiOperation("Cette methode permet d'inserer un nouveau BudgetCompteComptable")
	public BudgetCompteComptable save(@RequestBody BudgetCompteComptable budget) {
		return budgetCompteComptableService.save(budget);
	}
	
	@GetMapping("/")
	@ApiOperation("Cette methode permet d'afficher l'enssemble des BudgetCompteComptables")
	public List<BudgetCompteComptable> findAll() {
		return budgetCompteComptableService.findAll();
	}
	
	@GetMapping("/id/{id}")
	@ApiOperation("Cette methode permet de trouver l'ensemble des BudgetCompteComptables par id")
	public BudgetCompteComptable findById(@PathVariable Long id) {
		return budgetCompteComptableService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("Cette methode permet de supprimer un BudgetCompteComptables par id")
	public void deleteById(@PathVariable Long id) {
		budgetCompteComptableService.deleteById(id);
	}
	
}
