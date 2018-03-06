package com.nys.account.dao;

import com.nys.account.domain.Account;
import com.nys.account.domain.AccountPc;

import java.util.List;
import java.util.Map;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> findAccountByPc(AccountPc paramMap);

    int findCount(AccountPc accountPc);

    void startAccount(int id);
    void pauseAccount(int id);

    String findIdcardNoByAccountId(Integer accountId);

    int findAccountBIdByIdcardNo(String recommenderIdCard);

    void deleteAccount(int accountId);

    Account findAccountByIdcardNo(String idcardNo);
}