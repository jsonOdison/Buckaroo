package com.bankACB.accounts.services;

import com.bankACB.accounts.dto.CustomerDto;

public interface IAccountService {
    void createAccount(CustomerDto customerDTO);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDTO);

    boolean deleteAccount(String mobileNumber);
}
