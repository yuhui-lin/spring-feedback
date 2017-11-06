package com.yuhui.spring.feedback.repository;

import java.util.List;

import com.yuhui.spring.feedback.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}
