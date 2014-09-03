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
@Table(name = "BUYER")
public class Buyer implements Serializable{

	/** */
	private static final long serialVersionUID = 8706438939162046811L;

	@Id
	@SequenceGenerator(name="webuser_idwebuser_seq", sequenceName="webuser_idwebuser_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="webuser_idwebuser_seq")
	@Column(name = "id", updatable=false)
	private int id;

	private String name;

	private String lastName;

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
