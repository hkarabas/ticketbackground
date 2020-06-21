package com.bilet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
public class Takvim {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "musteriid")
	private Long musteriId;
	
	@NotNull
	@Column(name = "havaalanid")
	private Long havaalanId;
	
	@NotNull
	@Column(name = "havayoluid")
	private Long havayoluId;
	
	private String pnr;
	
	@NotNull
	private Integer yon;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date gidistarih;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date donustarih;
	
	private Date rezarvasyontarih;
	
	private String ad;
	private String soyad;
	private String tcno;
	private String email;
	
	@Transient
	private String error=null;

	public Long getId() {return id;}

	public Long getMusteriId() {
		return musteriId;
	}

	public void setMusteriId(Long musteriId) {
		this.musteriId = musteriId;
	}

	public Long getHavaalanId() {
		return havaalanId;
	}

	public void setHavaalanId(Long havaalanId) {
		this.havaalanId = havaalanId;
	}

	public Long getHavayoluId() {
		return havayoluId;
	}

	public void setHavayoluId(Long havayoluId) {
		this.havayoluId = havayoluId;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public Integer getYon() {
		return yon;
	}

	public void setYon(Integer yon) {
		this.yon = yon;
	}

	public Date getGidistarih() {
		return gidistarih;
	}

	public void setGidistarih(Date gidistarih) {
		this.gidistarih = gidistarih;
	}

	public Date getDonustarih() {
		return donustarih;
	}

	public void setDonustarih(Date donustarih) {
		this.donustarih = donustarih;
	}

	public Date getRezarvasyontarih() {
		return rezarvasyontarih;
	}

	public void setRezarvasyontarih(Date rezarvasyontarih) {
		this.rezarvasyontarih = rezarvasyontarih;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
