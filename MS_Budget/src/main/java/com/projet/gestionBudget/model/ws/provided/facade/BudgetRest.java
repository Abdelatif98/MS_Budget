package com.projet.gestionBudget.model.ws.provided.facade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.projet.gestionBudget.bean.Budget;
import com.projet.gestionBudget.model.service.facade.BudgetService;
import com.projet.gestionBudget.model.ws.provided.converter.BudgetConverter;
import com.projet.gestionBudget.model.ws.provided.vo.BudgetVo;
import com.projet.gestionBudget.model.ws.required.vo.BudgetDepartementVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette class permet de gerer les traiements relative aux budgets à savoir Save, FindAll, ...etc.")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BudgetRest {
	@Autowired
	private BudgetService budgetService;
	@Autowired
	private BudgetConverter budgetConverter;
	@RequestMapping(value = "/budgets/annee/{annee}",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet de trouver l'ensemble des budgets par annee")
	public BudgetVo findByAnnee(@PathVariable int annee) {
		Budget budget = budgetService.findByAnnee(annee);
		return budgetConverter.toVo(budget);
	}
	
	/*@RequestMapping(value = "/budgets/annee/{annee}/libelle/{libelle}",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet de trouver l'ensemble des budgets par annee et libelle des departement")
	public BudgetVo findByAnneeAndBudgetDepartementDepartementLibelle(@PathVariable int annee,@PathVariable String libelle) {
		Budget budget = budgetService.findByAnneeAndBudgetDepartementDepartementLibelle(annee,libelle);
		return budgetConverter.toVo(budget);
	}*/
	
	@RequestMapping(value = "/budgets/montantInvestisementInf/{montantInvestisementInf}",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet de trouver l'ensemble des budgets avec un montant Investisement Inférieur à une valeur donné")
	public List<BudgetVo> recupererByMontantInvestisementInf(@PathVariable double montantInvestisementInf) {
		List<Budget> budget = budgetService.recupererByMontantInvestisementInf(montantInvestisementInf);
		return budgetConverter.toVos(budget);
	}
	@RequestMapping(value = "/budgets/montantInvestisementSup/{montantInvestisementSup}",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet de trouver l'ensemble des budgets avec un montant Investisement supérieur à une valeur donné")
	public List<BudgetVo> recupererByMontantInvestisementSup(@PathVariable double montant) {
		List<Budget> budget = budgetService.recupererByMontantInvestisementSup(montant);
		return budgetConverter.toVos(budget);
	}
	@RequestMapping(value = "/budgets/montantFonctionementInf/{montantFonctionementInf}",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet de trouver l'ensemble des budgets avec un montant Fonctionement Inférieur à une valeur donné")
	public List<BudgetVo> recupererByMontantFonctionementInf(@PathVariable double montantFonctionementInf) {
		List<Budget> budget = budgetService.recupererByMontantFonctionementInf(montantFonctionementInf);
		return budgetConverter.toVos(budget);
	}
	@RequestMapping(value = "/budgets/montantFonctionementSup/{montantFonctionementSup}",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet de trouver l'ensemble des budgets avec un montant Fonctionement supérieur à une valeur donné")
	public List<BudgetVo> recupererByMontantFonctionementSup(@PathVariable double montantFonctionementSup) {
		List<Budget> budget = budgetService.recupererByMontantFonctionementSup(montantFonctionementSup);
		return budgetConverter.toVos(budget);
	}
	@RequestMapping(value = "/budgets/montantInvestisementRestantSup/{montantInvestisementRestantSup}",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet de trouver l'ensemble des budgets avec un montant Investisement Restant supérieur à une valeur donné")
	public List<BudgetVo> findByMontantInvestisementRestantGreaterThanEqual(@PathVariable double montantInvestisementRestantSup) {
		List<Budget> budget = budgetService.findByMontantInvestisementRestantGreaterThanEqual(montantInvestisementRestantSup);
		return budgetConverter.toVos(budget);
	}
	
	@RequestMapping(value = "/budgets/montantInvestisementRestantInf/{montantInvestisementRestantInf}",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet de trouver l'ensemble des budgets avec un montant Investisement Restant Inférieur à une valeur donné")
	public List<BudgetVo> findByMontantInvestisementRestantLessThanEqual(@PathVariable double montantInvestisementRestantInf) {
		List<Budget> budget = budgetService.findByMontantInvestisementRestantLessThanEqual(montantInvestisementRestantInf);
		return budgetConverter.toVos(budget);
	}
	@RequestMapping(value = "/budgets/montantFonctionementRestantSup/{montantFonctionementRestantSup}",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet de trouver l'ensemble des budgets avec un montant Fonctionement Restant supérieur à une valeur donné")
	public List<BudgetVo> findByMontantFonctionementRestantGreaterThanEqual(@PathVariable double montantFonctionementRestantSup) {
		List<Budget> budget = budgetService.findByMontantFonctionementRestantGreaterThanEqual(montantFonctionementRestantSup);
		return budgetConverter.toVos(budget);
	}
	@RequestMapping(value = "/budgets/montantFonctionementRestantInf/{montantFonctionementRestantInf}",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet de trouver l'ensemble des budgets avec un montant Fonctionement Restant Inférieur à une valeur donné")
	public List<BudgetVo> findByMontantFonctionementRestantLessThanEqual(@PathVariable double montantFonctionementRestantInf) {
		List<Budget> budget = budgetService.findByMontantFonctionementRestantLessThanEqual(montantFonctionementRestantInf);
		return budgetConverter.toVos(budget);
	}
	
	@RequestMapping(value = "/budgets/montantTotal/{montantTotal}",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet de trouver l'ensemble des budgets par Montant Total")
	public List<BudgetVo> findByMontantTotal(@PathVariable double montantTotal) {
		List<Budget> budget = budgetService.findByMontantTotal(montantTotal);
		return budgetConverter.toVos(budget);
	}
	
	@RequestMapping(value = "/budgets",method = RequestMethod.POST)
	@ApiOperation("Cette methode permet d'inserer un nouveau budget")
	public int save(@RequestBody BudgetVo budgetVo) {
		Budget budget = budgetConverter.toBean(budgetVo);
		return budgetService.save(budget);
	}
	
	@RequestMapping(value = "/budgets",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet d'afficher l'enssemble des budgets")
	public List<BudgetVo> findAll() {
		List<Budget> budget = budgetService.findAll();
		return budgetConverter.toVos(budget);
	}
	
	@RequestMapping(value = "/budgets/id/{id}",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet de trouver l'ensemble des budgets par id")
	public BudgetVo findById(@PathVariable Long id) {
		Budget budget = budgetService.findById(id);
		return budgetConverter.toVo(budget);
	}
	@RequestMapping(value = "/budgets/{id}",method = RequestMethod.DELETE)
	@ApiOperation("Cette methode permet de supprimer un budget par id")
	public boolean deleteById(@PathVariable Long id) {
		if(budgetService.deleteById(id)) {
			return true;
		}
		return false;
	}
	
	/*@ApiOperation("cette methode permet de modifier un budget")
	@RequestMapping(value = "/budgets/annee/{annee}",method = RequestMethod.PUT)
	public int saveBudget(@RequestBody BudgetVo budgetVo) {
		Budget budget = budgetConverter.toBean(budgetVo);
		return budgetService.saveBudget(budget);
	}*/
	
}
