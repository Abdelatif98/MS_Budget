package com.projet.gestionBudget.model.ws.provided.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.projet.gestionBudget.bean.BudgetCompteComptable;
import com.projet.gestionBudget.model.service.util.NumberUtil;
import com.projet.gestionBudget.model.ws.provided.vo.BudgetCompteComptableVo;

@Component
public class BudgetCompteComptableConverter {

	public BudgetCompteComptableVo toVo(BudgetCompteComptable bean) {
		BudgetCompteComptableVo vo = new BudgetCompteComptableVo();
		if(bean.getRefBudgetCompteComptable()!=null) {
			vo.setRefBudgetCompteComptable(bean.getRefBudgetCompteComptable());
		}
		if(bean.getMontant() != null) {
			vo.setMontant(bean.getMontant().toString());
		}
		if(bean.getRefCompteComptable()!=null) {
			vo.setRefBudget(bean.getRefCompteComptable());
		}
		if(bean.getRefBudget()!=null) {
			vo.setRefBudget(bean.getRefBudget());
		}
		return vo;
	}
	
	public BudgetCompteComptable toBean(BudgetCompteComptableVo vo) {
		BudgetCompteComptable bean = new BudgetCompteComptable();
		if(vo.getRefBudgetCompteComptable()!=null) {
			bean.setRefBudgetCompteComptable(vo.getRefBudgetCompteComptable());
		}
		if(vo.getMontant() != null) {
			bean.setMontant(NumberUtil.toDouble(vo.getMontant()));
		}
		if(vo.getRefCompteComptable()!=null) {
			bean.setRefCompteComptable(vo.getRefCompteComptable());
		}
		if(vo.getRefBudget()!=null) {
			bean.setRefBudget(vo.getRefBudget());
		}
		return bean;
	}
	
	public List<BudgetCompteComptableVo> toVos(List<BudgetCompteComptable> beans){
		List<BudgetCompteComptableVo> vos = new ArrayList<>();
		for(int i=0;i< beans.size();i++) {
			vos.add(toVo(beans.get(i)));
		}
		return vos;
	}
	public List<BudgetCompteComptable> toBeans(List<BudgetCompteComptableVo> vos){
		List<BudgetCompteComptable> beans = new ArrayList<>();
		for(int i=0;i< vos.size();i++) {
			beans.add(toBean(vos.get(i)));
		}
		return beans;
	}
}
