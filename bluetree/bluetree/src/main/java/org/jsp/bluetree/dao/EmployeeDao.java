package org.jsp.bluetree.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jsp.bluetree.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {

	@Autowired
	EntityManagerFactory factory;

	public void insert(Employee employee) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}

	public List<Employee> fetch() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("select e from Employee e", Employee.class);
		return query.getResultList();
	}

	public void removeEmployee(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Employee employee = manager.find(Employee.class, id);

		transaction.begin();
		manager.remove(employee);
		transaction.commit();
	}

	public Employee fetchById(int id) {
		EntityManager manager = factory.createEntityManager();
		return manager.find(Employee.class, id);
	}

	public void update(Employee employee) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(employee);
		transaction.commit();
	}
}
