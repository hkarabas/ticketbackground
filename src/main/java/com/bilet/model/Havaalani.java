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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;



@Entity
@EqualsAndHashCode(exclude={"havayolulist"})
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
	  	

		
		public Havaalani() {
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHavalaniad() {
		return havalaniad;
	}

	public void setHavalaniad(String havalaniad) {
		this.havalaniad = havalaniad;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	public List<Havayolu> getHavayolulist() {
		return havayolulist;
	}

	public void setHavayolulist(List<Havayolu> havayolulist) {
		this.havayolulist = havayolulist;
	}
}
