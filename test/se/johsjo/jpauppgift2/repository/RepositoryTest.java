package se.johsjo.jpauppgift2.repository;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashSet;

import org.junit.BeforeClass;
import org.junit.Test;

import se.johsjo.jpauppgift2.model.Department;
import se.johsjo.jpauppgift2.model.Employee;
import se.johsjo.jpauppgift2.model.ParkingSpot;

public class RepositoryTest {

	private static Repository repository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		repository = new Repository();
	}

	@Test
	public final void test() {

		Collection<Department> departments = new HashSet<>();
		departments.add(new Department("Ekonomi"));
		departments.add(new Department("Admin"));
		ParkingSpot parkingSpot = new ParkingSpot();

		Employee emp = new Employee("firstName", "lastName", 100, departments, parkingSpot);

		repository.addUpdateEmployee(emp);

		System.out.println("DONE");

		Employee dbEmployee = repository.getEmployee(emp.getId());
		
		dbEmployee.addDepartment(new Department("HeadOfDepDep"));
		
		Employee dbEmployee2 = repository.getEmployee(emp.getId());
		repository.addUpdateEmployee(dbEmployee2);

		dbEmployee2.getDepartment().forEach(d -> System.out.println(d.getName()));
	}

}
