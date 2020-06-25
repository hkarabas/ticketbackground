package com.bilet.model;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "hava_yolu_hava_alani")
@Data
public class HavaYoluHavaAlani {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Long havaalani_id;

	private Long havayolu_id;

}