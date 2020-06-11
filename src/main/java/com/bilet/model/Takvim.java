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

@Data
@Getter
@Setter
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
	
	

}
