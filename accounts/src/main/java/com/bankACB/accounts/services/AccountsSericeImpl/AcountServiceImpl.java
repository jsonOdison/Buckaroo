package com.bankACB.accounts.services.AccountsSericeImpl;

import com.bankACB.accounts.constants.AccountsConstants;
import com.bankACB.accounts.dto.CustomerDTO;
import com.bankACB.accounts.entity.Accounts;
import com.bankACB.accounts.entity.Customer;
import com.bankACB.accounts.exception.CustomerAlreadyExistException;
import com.bankACB.accounts.exception.ResourceNotFoundException;
import com.bankACB.accounts.mapper.CustomerMapper;
import com.bankACB.accounts.repository.AccountsRepository;
import com.bankACB.accounts.repository.CustomerRepository;
import com.bankACB.accounts.services.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AcountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;


    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        Optional optionalCustomer = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException("Customer already registered with given mobile number" + customerDTO.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Jason Test");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Jason Test");
        return newAccount;
    }

    @Override
    public CustomerDTO fetchAccount(String mobileNumber) {
        return customerRepository.findByMobileNumber(mobileNumber)
                .map(customer -> CustomerMapper.mapToCustomerDTO(customer, new CustomerDTO()))
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
    }


}
