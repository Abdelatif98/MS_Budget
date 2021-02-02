package com.projet.gestionBudget.model.ws.provided.facade;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.gestionBudget.bean.Departement;
import com.projet.gestionBudget.model.service.facade.DepartementService;
import com.projet.gestionBudget.model.ws.provided.converter.DepartementConverter;
import com.projet.gestionBudget.model.ws.provided.vo.DepartementVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api("Cette classe permet la gestion de departement")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DepartementRest {
	@Autowired
	DepartementService departementService;
	
	@Autowired
	private DepartementConverter departementConverter;
	
	@RequestMapping(value = "/departement/libelle/{Libelle}",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet de trouver un departement à partir de son libelle ")
	public DepartementVo findByLibelle(@PathVariable String Libelle) {
		Departement departement = departementService.findByLibelle(Libelle);
		return departementConverter.toVo(departement);
	}
	
	@RequestMapping(value = "/departement/refDepartement/{refDepartement}",method = RequestMethod.GET)
	@ApiOperation("Cette methode permet de trouver un departement à partir de son refDepartement ")
	public DepartementVo findByRefDepartement(@PathVariable String refDepartement) {
		Departement departement = departementService.findByRefDepartement(refDepartement);
		return departementConverter.toVo(departement);
	}
	
	@RequestMapping(value = "/departement/all",method = RequestMethod.GET)
    @ApiOperation("Cette methode permet de lister l'esemble des departements ")
	public List<DepartementVo> findAll() {
		List<Departement> departements = departementService.findAll();
		return departementConverter.toVos(departements);
	}

	@RequestMapping(value = "/departement",method = RequestMethod.POST)
    @ApiOperation("Cette methode permet de sauvegarder un departement ")
	public int save( @RequestBody DepartementVo departementVo) {
		Departement departement = departementConverter.toBean(departementVo);
		return departementService.save(departement);
	}
	@ApiOperation("Cette methode permet de supprimer un dep par son id ")
	@RequestMapping(value = "/departement/id/{id}",method = RequestMethod.DELETE)
	public int deleteById( @PathVariable Long id) {
		return departementService.deleteById(id);
	}
}