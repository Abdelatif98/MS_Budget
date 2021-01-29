package com.projet.gestionBudget.bean;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BudgetCompteComptable implements Serializable{
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String refBudgetCompteComptable;
	private String refBudget;
	private String refCompteComptable;
	private Double montant;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRefBudget() {
		return refBudget;
	}
	public void setRefBudget(String refBudget) {
		this.refBudget = refBudget;
	}
	public String getRefCompteComptable() {
		return refCompteComptable;
	}
	public void setRefCompteComptable(String refCompteComptable) {
		this.refCompteComptable = refCompteComptable;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public String getRefBudgetCompteComptable() {
		return refBudgetCompteComptable;
	}
	public void setRefBudgetCompteComptable(String refBudgetCompteComptable) {
		this.refBudgetCompteComptable = refBudgetCompteComptable;
	}
	public BudgetCompteComptable(Long id, String refBudget, String refCompteComptable, double montant) {
		super();
		this.id = id;
		this.refBudget = refBudget;
		this.refCompteComptable = refCompteComptable;
		this.montant = montant;
	}
	public BudgetCompteComptable() {
		super();	
	}
	@Override
	public String toString() {
		return "BudgetCompteComptable [id=" + id + ", refBudget=" + refBudget + ", refCompteComptable="
				+ refCompteComptable + ", montant=" + montant + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(montant);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((refBudget == null) ? 0 : refBudget.hashCode());
		result = prime * result + ((refCompteComptable == null) ? 0 : refCompteComptable.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BudgetCompteComptable other = (BudgetCompteComptable) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(montant) != Double.doubleToLongBits(other.montant))
			return false;
		if (refBudget == null) {
			if (other.refBudget != null)
				return false;
		} else if (!refBudget.equals(other.refBudget))
			return false;
		if (refCompteComptable == null) {
			if (other.refCompteComptable != null)
				return false;
		} else if (!refCompteComptable.equals(other.refCompteComptable))
			return false;
		return true;
	}
}
