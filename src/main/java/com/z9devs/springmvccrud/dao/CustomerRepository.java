package com.z9devs.springmvccrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.z9devs.springmvccrud.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> 
{
	@Query(value = "SELECT c FROM Customer c WHERE c.name LIKE '%' || :keyword || '%'"
			+ " OR c.email LIKE '%' || :keyword || '%'")
	public List<Customer> search(@Param("keyword") String keyword);
}
