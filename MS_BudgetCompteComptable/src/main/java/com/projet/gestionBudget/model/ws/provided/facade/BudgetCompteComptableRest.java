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
import com.projet.gestionBudget.model.ws.provided.converter.BudgetCompteComptableConverter;
import com.projet.gestionBudget.model.ws.provided.vo.BudgetCompteComptableVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette class permet de gerer les traiements relative au BudgetCompteComptable à savoir Save, FindAll, ...etc.")
@RestController
@RequestMapping("budgetcomptecomptable")
public class BudgetCompteComptableRest {
	@Autowired
	private BudgetCompteComptableService budgetCompteComptableService;
	
	@Autowired
	private BudgetCompteComptableConverter budgetCompteComptableConverter;
	
	@GetMapping("/Montant/{montant}")
	@ApiOperation("Cette methode permet de trouver l'ensemble des BudgetCompteComptables par montant")
	public List<BudgetCompteComptableVo> findByMontant(@PathVariable int montant) {
		List<BudgetCompteComptable> budgetCompteComptables = budgetCompteComptableService.findByMontant(montant);
		return budgetCompteComptableConverter.toVos(budgetCompteComptables);
	}
	
	@PostMapping("/")
	@ApiOperation("Cette methode permet d'inserer un nouveau BudgetCompteComptable")
	public int save(@RequestBody BudgetCompteComptableVo budgetCompteComptableVo) {
		return budgetCompteComptableService.save(budgetCompteComptableConverter.toBean(budgetCompteComptableVo));
	}
	
	@GetMapping("/")
	@ApiOperation("Cette methode permet d'afficher l'enssemble des BudgetCompteComptables")
	public List<BudgetCompteComptableVo> findAll() {
		List<BudgetCompteComptable> budgetCompteComptables = budgetCompteComptableService.findAll();
		return budgetCompteComptableConverter.toVos(budgetCompteComptables);
	}
	
	@GetMapping("/id/{id}")
	@ApiOperation("Cette methode permet de trouver un BudgetCompteComptables par id")
	public BudgetCompteComptableVo findById(@PathVariable Long id) {
		BudgetCompteComptable budgetCompteComptable = budgetCompteComptableService.findById(id);
		return budgetCompteComptableConverter.toVo(budgetCompteComptable);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("Cette methode permet de supprimer un BudgetCompteComptables par id")
	public void deleteById(@PathVariable Long id) {
		budgetCompteComptableService.deleteById(id);
	}
	
}
