package com.nys.account.service;

import com.nys.account.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAccountByPc(int begin, int size, String[] params, String[] values);

    int findCount(String[] params, String[] values);

    void updateStatus(String status,int accountId);

    void addAccount(Account account);

    Account findAccountByAccountId(int accountId);

    void updateAccount(Account account);

    void deleteAccount(int accountId);

    String findIdcardNoByAccountId(Integer recommenderId);

    int findAccountBIdByIdcardNo(String recommenderIdCard);

    Account findAccountByIdcardNo(String idcardNo);
}
