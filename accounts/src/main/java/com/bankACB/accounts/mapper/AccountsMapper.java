package com.bankACB.accounts.mapper;

import com.bankACB.accounts.dto.AccountsDTO;
import com.bankACB.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDTO mapToAccountsDto(Accounts accounts, AccountsDTO accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDTO accountsDto, Accounts accounts, boolean isNew) {
        if (isNew) {
            accounts.setAccountNumber(accountsDto.getAccountNumber());
        }
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }

}