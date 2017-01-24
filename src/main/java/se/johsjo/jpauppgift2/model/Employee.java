package se.johsjo.jpauppgift2.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private int employeeNumber;

	@OneToMany
	private Collection<Department> department;

	@OneToOne
	private ParkingSpot parkingSpot;

	protected Employee() {
	}

	public Employee(String firstName, String lastName, int employeeNumber, Collection<Department> departments,
			ParkingSpot parkingSpot) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeNumber = employeeNumber;
		this.department = departments;
		this.parkingSpot = parkingSpot;
		this.parkingSpot.setLabel(this);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public Collection<Department> getDepartment() {
		return department;
	}

	public void addDepartment(Department department) {
		this.department.add(department);
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}

	public long getId() {
		return id;
	}

}
