package com.bilet.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@EqualsAndHashCode(exclude={"havaalanliste"})
public class Havayolu {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String havayoluad;
	/*
	 @JsonIgnore
	 @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH} )
	 @JoinTable(name = "HavaYoluHavaAlani",
     joinColumns = @JoinColumn(name = "havayolu_id",referencedColumnName = "id" ,updatable = false,insertable = false),
     inverseJoinColumns = @JoinColumn(name = "havaalani_id",referencedColumnName = "id",updatable = false,insertable = false))
	 */
	 @ManyToMany(mappedBy = "havayolulist")
	 private List<Havaalani> havaalanliste;

	public Havayolu() {


	}



}
