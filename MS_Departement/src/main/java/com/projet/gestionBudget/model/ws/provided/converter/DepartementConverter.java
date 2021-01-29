package com.projet.gestionBudget.model.ws.provided.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.projet.gestionBudget.bean.Departement;
import com.projet.gestionBudget.model.ws.provided.vo.DepartementVo;

@Component
public class DepartementConverter {

	public DepartementVo toVo(Departement bean) {
		DepartementVo vo = new DepartementVo();
		if(bean.getRefDepartement()!=null) {
			vo.setRefDepartement(bean.getRefDepartement());
		}
		if(bean.getLibelle() != null) {
			vo.setLibelle(bean.getLibelle());
		}
		return vo;
	}
	
	public Departement toBean(DepartementVo vo) {
		Departement bean = new Departement();
		if(vo.getRefDepartement()!=null) {
			bean.setRefDepartement(vo.getRefDepartement());
		}
		if(vo.getLibelle() != null) {
			bean.setLibelle(vo.getLibelle());
		}
		return bean;
	}
	
	public List<DepartementVo> toVos(List<Departement> beans){
		List<DepartementVo> vos = new ArrayList<>();
		for(int i=0;i< beans.size();i++) {
			vos.add(toVo(beans.get(i)));
		}
		return vos;
	}
	public List<Departement> toBeans(List<DepartementVo> vos){
		List<Departement> beans = new ArrayList<>();
		for(int i=0;i< vos.size();i++) {
			beans.add(toBean(vos.get(i)));
		}
		return beans;
	}
}
