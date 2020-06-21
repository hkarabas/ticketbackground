package com.bilet.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "hava_yolu_hava_alani")
public class HavaYoluHavaAlani {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Long havaalani_id;
	
	private Long havayolu_id;

	public Long getHavaalani_id() {
		return havaalani_id;
	}

	public void setHavaalani_id(Long havaalani_id) {
		this.havaalani_id = havaalani_id;
	}

	public Long getHavayolu_id() {
		return havayolu_id;
	}

	public void setHavayolu_id(Long havayolu_id) {
		this.havayolu_id = havayolu_id;
	}
}