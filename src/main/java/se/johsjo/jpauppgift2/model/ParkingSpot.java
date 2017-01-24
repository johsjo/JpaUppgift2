package se.johsjo.jpauppgift2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ParkingSpot {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String label;

	@OneToOne
	private Employee employee;

	public ParkingSpot() {

	}

	public String getLabel() {
		return label;
	}

	public void setLabel(Employee employee) {
		this.employee = employee;
		this.label = employee.getFirstName() + " " + employee.getFirstName();
	}

}
