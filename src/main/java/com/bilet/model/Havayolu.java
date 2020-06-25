package com.bilet.model;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;


import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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


	/*
	public List<Havaalani> getHavaalanliste() {
		return havaalanliste;
	}

	public void setHavaalanliste(List<Havaalani> havaalanliste) {
		this.havaalanliste = havaalanliste;
	}

	 */
}
