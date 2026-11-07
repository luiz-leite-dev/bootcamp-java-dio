package br.com.dio.marketplace.registration.infrastructure.persistence.repository;

import java.util.List;

import br.com.dio.marketplace.registration.domain.Customer;
import br.com.dio.marketplace.registration.domain.CustomerRepository;

public class JpaCustomerRepository implements CustomerRepository {

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return List.of();
    }

}
