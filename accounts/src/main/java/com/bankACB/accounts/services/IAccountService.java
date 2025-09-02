package com.bankACB.accounts.services;

import com.bankACB.accounts.dto.CustomerDTO;

public interface IAccountService {
    void createAccount(CustomerDTO customerDTO);

    CustomerDTO fetchAccount(String mobileNumber);
}
