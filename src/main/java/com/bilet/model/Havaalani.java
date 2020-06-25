package com.bilet.model;

import java.util.List;

import javax.persistence.*;

import lombok.*;



@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Havaalani {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	  	
	  	private String havalaniad;
	  	private String sehir;

	    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH} )
	    @JoinTable(name = "HavaYoluHavaAlani",
	    joinColumns = @JoinColumn(name = "havaalani_id ",referencedColumnName = "id",updatable = false,insertable = false),
	    inverseJoinColumns = @JoinColumn(name = "havayolu_id",referencedColumnName = "id",updatable = false,insertable = false))
		private List<Havayolu> havayolulist;


		

}
