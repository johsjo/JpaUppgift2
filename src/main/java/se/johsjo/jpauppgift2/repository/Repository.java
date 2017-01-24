package se.johsjo.jpauppgift2.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import se.johsjo.jpauppgift2.model.Department;
import se.johsjo.jpauppgift2.model.Employee;
import se.johsjo.jpauppgift2.model.ParkingSpot;

public final class Repository {

	private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("PersistenceUnit");

	EntityManager manager = FACTORY.createEntityManager();

	public void addUpdateEmployee(Employee employee) {
		manager.getTransaction().begin();
		manager.persist(employee);
		Collection<Department> departments = employee.getDepartment();
		for (Department d : departments) {
			manager.persist(d);
		}
		ParkingSpot parkingSpot = employee.getParkingSpot();
		manager.persist(parkingSpot);
		manager.getTransaction().commit();
	}

	public Employee getEmployee(long id) {
		return manager.find(Employee.class, id);
	}

}
