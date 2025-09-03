package com.bankACB.accounts.mapper;


import com.bankACB.accounts.dto.CustomerDto;
import com.bankACB.accounts.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDTO(Customer customer, CustomerDto customerDto) {
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer, boolean isNew) {
        if (isNew) {
            customer.setMobileNumber(customerDto.getMobileNumber());
        }
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }

}