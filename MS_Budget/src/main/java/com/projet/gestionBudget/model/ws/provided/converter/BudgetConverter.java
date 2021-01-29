package com.projet.gestionBudget.model.ws.provided.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.projet.gestionBudget.bean.Budget;
import com.projet.gestionBudget.model.ws.provided.vo.BudgetVo;

@Component
public class BudgetConverter {

	public BudgetVo toVo(Budget bean) {
		BudgetVo vo = new BudgetVo();
		if(bean.getRefBudget()!=null) {
			vo.setRefBudget(bean.getRefBudget());
		}
		if(bean.getAnnee() != null) {
			vo.setAnnee(bean.getAnnee().toString());
		}
		if(bean.getMontantFonctionement()!=null) {
			vo.setMontantFonctionement(bean.getMontantFonctionement().toString());
		}
		if(bean.getMontantInvestisement()!=null) {
			vo.setMontantInvestisement(bean.getMontantInvestisement().toString());
		}
		if(bean.getMontantFonctionementRestant()!=null) {
			vo.setMontantFonctionementRestant(bean.getMontantFonctionementRestant().toString());
		}
		if(bean.getMontantInvestisementRestant()!=null) {
			vo.setMontantInvestisementRestant(bean.getMontantInvestisementRestant().toString());
		}
		if(bean.getCreditOuvert()!=null) {
			vo.setCreditOuvert(bean.getCreditOuvert().toString());
		}
		if(bean.getMontantTotal()!=null) {
			vo.setMontantTotal(bean.getMontantTotal().toString());
		}
		if(bean.getDescription()!=null) {
			vo.setDescription(bean.getDescription());
		}
		return vo;
	}
	
	public Budget toBean(BudgetVo vo) {
		Budget bean = new Budget();
		if(vo.getRefBudget()!=null) {
			bean.setRefBudget(vo.getRefBudget());
		}
		if(vo.getAnnee() != null) {
			bean.setAnnee(Integer.parseInt(vo.getAnnee()));
		}
		if(vo.getMontantFonctionement()!=null) {
			bean.setMontantFonctionement(Double.parseDouble(vo.getMontantFonctionement()));
		}
		if(vo.getMontantInvestisement()!=null) {
			bean.setMontantInvestisement(Double.parseDouble(vo.getMontantInvestisement()));
		}
		if(vo.getMontantFonctionementRestant()!=null) {
			bean.setMontantFonctionementRestant(Double.parseDouble(vo.getMontantFonctionementRestant()));
		}
		if(vo.getMontantInvestisementRestant()!=null) {
			bean.setMontantInvestisementRestant(Double.parseDouble(vo.getMontantInvestisementRestant()));
		}
		if(vo.getCreditOuvert()!=null) {
			bean.setCreditOuvert(Double.parseDouble(vo.getCreditOuvert()));
		}
		if(vo.getMontantTotal()!=null) {
			bean.setMontantTotal(Double.parseDouble(vo.getMontantTotal()));
		}
		if(vo.getDescription()!=null) {
			bean.setDescription(vo.getDescription());
		}
		return bean;
	}
	
	public List<BudgetVo> toVos(List<Budget> beans){
		List<BudgetVo> vos = new ArrayList<>();
		for(int i=0;i< beans.size();i++) {
			vos.add(toVo(beans.get(i)));
		}
		return vos;
	}
	public List<Budget> toBeans(List<BudgetVo> vos){
		List<Budget> beans = new ArrayList<>();
		for(int i=0;i< vos.size();i++) {
			beans.add(toBean(vos.get(i)));
		}
		return beans;
	}
}
