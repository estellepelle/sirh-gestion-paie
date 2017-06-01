package dev.paie.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class ProfilRemuneration {

	@Id
	private Integer id;
	private String code;
	
	
	@ManyToMany
	@JoinTable(name="cotisation_non_impo",joinColumns= @JoinColumn(name="id_non_imp", referencedColumnName="id"),
    inverseJoinColumns= @JoinColumn(name="id_cotis", referencedColumnName="id"))
	private List<Cotisation> cotisationsNonImposables;
	
	@ManyToMany
	@JoinTable(name="cotisation_impo",joinColumns= @JoinColumn(name="id_imp", referencedColumnName="id"),
    inverseJoinColumns= @JoinColumn(name="id_cotis", referencedColumnName="id"))
	private List<Cotisation> cotisationsImposables;
	
	@ManyToMany
	private List<Avantage> avantages;

	
	
	public ProfilRemuneration() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
