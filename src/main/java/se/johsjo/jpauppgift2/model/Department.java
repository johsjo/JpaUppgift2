package se.johsjo.jpauppgift2.model;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String name;

	@OneToMany
	private Collection<Employee> empInDep = new HashSet<>();

	protected Department() {
	}

	public Department(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Employee> getEmpInDep() {
		return empInDep;
	}

	public void addEmpInDep(Employee employee) {
		this.empInDep.add(employee);
	}
}
