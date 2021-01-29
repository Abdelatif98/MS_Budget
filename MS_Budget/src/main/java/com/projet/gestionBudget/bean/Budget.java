package com.projet.gestionBudget.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Budget implements Serializable{
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String refBudget;
	private Integer annee;
	private String description;
	private Double creditOuvert;
	private Double montantInvestisement;
	private Double montantFonctionement;
	private Double montantInvestisementRestant;
	private Double montantFonctionementRestant;
	private Double montantTotal;
	
	public Long getId() {
		return id;
	}

	public Budget(Long id, String refBudget, Integer annee, String description, Double creditOuvert,
			Double montantInvestisement, Double montantFonctionement, Double montantInvestisementRestant,
			Double montantFonctionementRestant, Double montantTotal) {
		super();
		this.id = id;
		this.refBudget = refBudget;
		this.annee = annee;
		this.description = description;
		this.creditOuvert = creditOuvert;
		this.montantInvestisement = montantInvestisement;
		this.montantFonctionement = montantFonctionement;
		this.montantInvestisementRestant = montantInvestisementRestant;
		this.montantFonctionementRestant = montantFonctionementRestant;
		this.montantTotal = montantTotal;
	}

	public Budget() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRefBudget() {
		return refBudget;
	}

	public void setRefBudget(String refBudget) {
		this.refBudget = refBudget;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCreditOuvert() {
		return creditOuvert;
	}

	public void setCreditOuvert(Double creditOuvert) {
		this.creditOuvert = creditOuvert;
	}

	public Double getMontantInvestisement() {
		return montantInvestisement;
	}

	public void setMontantInvestisement(Double montantInvestisement) {
		this.montantInvestisement = montantInvestisement;
	}

	public Double getMontantFonctionement() {
		return montantFonctionement;
	}

	public void setMontantFonctionement(Double montantFonctionement) {
		this.montantFonctionement = montantFonctionement;
	}

	public Double getMontantInvestisementRestant() {
		return montantInvestisementRestant;
	}

	public void setMontantInvestisementRestant(Double montantInvestisementRestant) {
		this.montantInvestisementRestant = montantInvestisementRestant;
	}

	public Double getMontantFonctionementRestant() {
		return montantFonctionementRestant;
	}

	public void setMontantFonctionementRestant(Double montantFonctionementRestant) {
		this.montantFonctionementRestant = montantFonctionementRestant;
	}

	public Double getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(Double montantTotal) {
		this.montantTotal = montantTotal;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Budget [id=" + id + ", refBudget=" + refBudget + ", annee=" + annee + ", description=" + description
				+ ", creditOuvert=" + creditOuvert + ", montantInvestisement=" + montantInvestisement
				+ ", montantFonctionement=" + montantFonctionement + ", montantInvestisementRestant="
				+ montantInvestisementRestant + ", montantFonctionementRestant=" + montantFonctionementRestant
				+ ", montantTotal=" + montantTotal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annee == null) ? 0 : annee.hashCode());
		result = prime * result + ((creditOuvert == null) ? 0 : creditOuvert.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((montantFonctionement == null) ? 0 : montantFonctionement.hashCode());
		result = prime * result + ((montantFonctionementRestant == null) ? 0 : montantFonctionementRestant.hashCode());
		result = prime * result + ((montantInvestisement == null) ? 0 : montantInvestisement.hashCode());
		result = prime * result + ((montantInvestisementRestant == null) ? 0 : montantInvestisementRestant.hashCode());
		result = prime * result + ((montantTotal == null) ? 0 : montantTotal.hashCode());
		result = prime * result + ((refBudget == null) ? 0 : refBudget.hashCode());
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
		Budget other = (Budget) obj;
		if (annee == null) {
			if (other.annee != null)
				return false;
		} else if (!annee.equals(other.annee))
			return false;
		if (creditOuvert == null) {
			if (other.creditOuvert != null)
				return false;
		} else if (!creditOuvert.equals(other.creditOuvert))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (montantFonctionement == null) {
			if (other.montantFonctionement != null)
				return false;
		} else if (!montantFonctionement.equals(other.montantFonctionement))
			return false;
		if (montantFonctionementRestant == null) {
			if (other.montantFonctionementRestant != null)
				return false;
		} else if (!montantFonctionementRestant.equals(other.montantFonctionementRestant))
			return false;
		if (montantInvestisement == null) {
			if (other.montantInvestisement != null)
				return false;
		} else if (!montantInvestisement.equals(other.montantInvestisement))
			return false;
		if (montantInvestisementRestant == null) {
			if (other.montantInvestisementRestant != null)
				return false;
		} else if (!montantInvestisementRestant.equals(other.montantInvestisementRestant))
			return false;
		if (montantTotal == null) {
			if (other.montantTotal != null)
				return false;
		} else if (!montantTotal.equals(other.montantTotal))
			return false;
		if (refBudget == null) {
			if (other.refBudget != null)
				return false;
		} else if (!refBudget.equals(other.refBudget))
			return false;
		return true;
	}
}	