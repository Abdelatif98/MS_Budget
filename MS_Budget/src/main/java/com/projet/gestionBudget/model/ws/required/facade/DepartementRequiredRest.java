package com.projet.gestionBudget.model.ws.required.facade;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.projet.gestionBudget.model.ws.provided.vo.DepartementVo;


@FeignClient(name = "Departement")
public interface DepartementRequiredRest {
	
	@RequestMapping(value = "/departement/libelle/{Libelle}",method = RequestMethod.GET)
	public DepartementVo findByLibelle(@PathVariable String Libelle);
	
	@RequestMapping(value = "/departement/refDepartement/{refDepartement}",method = RequestMethod.GET)
	public DepartementVo findByRefDepartement(@PathVariable String refDepartement);
	
	@RequestMapping(value = "/departement/all",method = RequestMethod.GET)
	public List<DepartementVo> findAll();

	@RequestMapping(value = "/departement",method = RequestMethod.POST)
	public int save( @RequestBody DepartementVo departementVo);

	@RequestMapping(value = "/departement/id/{id}",method = RequestMethod.DELETE)
	public int deleteById( @PathVariable Long id);
}
