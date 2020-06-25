package com.bilet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@NoArgsConstructor
public class Kullanici {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



	private String kullanici;
	
	private String sifre;
	
	private Integer rolid;


	public Long getId() {return id;	}

	public String getKullanici() {
		return kullanici;
	}

	public void setKullanici(String kullanici) {
		this.kullanici = kullanici;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public Integer getRolid() {
		return rolid;
	}

	public void setRolid(Integer rolid) {
		this.rolid = rolid;
	}
}
