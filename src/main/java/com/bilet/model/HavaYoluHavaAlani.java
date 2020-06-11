package com.bilet.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "hava_yolu_hava_alani")
public class HavaYoluHavaAlani {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Long havaalani_id;
	
	private Long havayolu_id;




}