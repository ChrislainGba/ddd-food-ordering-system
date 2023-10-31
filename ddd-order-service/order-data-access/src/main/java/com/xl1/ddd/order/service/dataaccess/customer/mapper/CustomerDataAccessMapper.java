package com.xl1.ddd.order.service.dataaccess.customer.mapper;

import org.springframework.stereotype.Component;

import com.xl1.ddd.domain.valueobject.CustomerId;
import com.xl1.ddd.order.service.dataaccess.customer.entity.CustomerEntity;
import com.xl1.ddd.order.service.domain.entity.Customer;

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return new Customer(new CustomerId(customerEntity.getId()));
    }
}
