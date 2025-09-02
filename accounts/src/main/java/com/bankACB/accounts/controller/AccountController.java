package com.bankACB.accounts.controller;

import com.bankACB.accounts.constants.AccountsConstants;
import com.bankACB.accounts.dto.CustomerDTO;
import com.bankACB.accounts.dto.ResponseDTO;
import com.bankACB.accounts.services.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountController {

    private IAccountService iAccountService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customerDTO) {
        iAccountService.createAccount(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccount(@RequestParam String mobileNumber) {
        CustomerDTO customerDTO = iAccountService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerDTO);
    }
}
