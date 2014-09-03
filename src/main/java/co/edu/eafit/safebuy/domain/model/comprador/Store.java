package co.edu.eafit.safebuy.domain.model.comprador;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STORE")
public class Store implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5068008994998612018L;
	
	@Id
	@SequenceGenerator(name = "webstore_idwebstore_seq", sequenceName = "webstore_idwebstore_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "webstore_idwebstore_seq" )
	@Column(name = "id", updatable=false)
	private int id;
	
	private String name;
	
	private String nit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

}
