package com.xl1.ddd.order.service.dataaccess.customer.adapter;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.xl1.ddd.order.service.dataaccess.customer.mapper.CustomerDataAccessMapper;
import com.xl1.ddd.order.service.dataaccess.customer.repositoty.CustomerJpaRepository;
import com.xl1.ddd.order.service.domain.entity.Customer;
import com.xl1.ddd.order.service.domain.ports.output.repository.CustomerRepository;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerDataAccessMapper customerDataAccessMapper;

    public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository,
                                  CustomerDataAccessMapper customerDataAccessMapper) {
        this.customerJpaRepository = customerJpaRepository;
        this.customerDataAccessMapper = customerDataAccessMapper;
    }

    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return customerJpaRepository.findById(customerId).map(customerDataAccessMapper::customerEntityToCustomer);
    }
}

