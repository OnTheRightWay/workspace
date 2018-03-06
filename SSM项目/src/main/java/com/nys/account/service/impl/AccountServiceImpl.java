package com.nys.account.service.impl;

import com.nys.account.dao.AccountMapper;
import com.nys.account.domain.Account;
import com.nys.account.domain.AccountPc;
import com.nys.account.service.AccountService;
import com.nys.service.dao.ServiceMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    private AccountMapper accountMapper;
    private ServiceMapper serviceMapper;
    public AccountServiceImpl(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        accountMapper = context.getBean(AccountMapper.class);
        serviceMapper = context.getBean(ServiceMapper.class);
    }

    @Override
    public List<Account> findAccountByPc(int begin, int size, String[] params, String[] values) {
        AccountPc accountPc = new AccountPc();
        accountPc.setBegin(begin);
        accountPc.setSize(size);
        accountPc.setIdcardNo(values[0]);
        accountPc.setRealName(values[1]);
        accountPc.setLoginName(values[2]);
        accountPc.setStatus(values[3]);
        return accountMapper.findAccountByPc(accountPc);

    }

    @Override
    public int findCount(String[] params, String[] values) {
        AccountPc accountPc = new AccountPc();
        accountPc.setIdcardNo(values[0]);
        accountPc.setRealName(values[1]);
        accountPc.setLoginName(values[2]);
        accountPc.setStatus(values[3]);
        return accountMapper.findCount(accountPc);
    }

    @Override
    public void updateStatus(String status,int accountId) {
        if (status.equals("0")){
            accountMapper.startAccount(accountId);
        }
        if (status.equals("1")){
            accountMapper.pauseAccount(accountId);
            serviceMapper.pauseServiceByAccountId(accountId);
            serviceMapper.updatePauseDateByAccoutId(accountId);
        }
    }

    @Override
    public void addAccount(Account account) {
        account.setStatus("1");
        String idcardNo = account.getIdcardNo();
        String s1 = idcardNo.substring(7,11);
        String s2 = idcardNo.substring(11,13);
        String s3 = idcardNo.substring(13,15);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
             date = sf.parse(s1 + "-" + s2 + "-" + s3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        account.setBirthdate(date);
        account.setCreateDate(new Date());
        accountMapper.insert(account);
    }

    @Override
    public Account findAccountByAccountId(int accountId) {
        return accountMapper.selectByPrimaryKey(accountId);
    }

    @Override
    public void updateAccount(Account account) {
        accountMapper.updateByPrimaryKey(account);
    }

    @Override
    public void deleteAccount(int accountId) {
        accountMapper.deleteAccount(accountId);
        serviceMapper.deleteServiceByAccountId(accountId);
    }

    @Override
    public String findIdcardNoByAccountId(Integer accountId) {
        return accountMapper.findIdcardNoByAccountId(accountId);
    }

    @Override
    public int findAccountBIdByIdcardNo(String recommenderIdCard) {
        return accountMapper.findAccountBIdByIdcardNo(recommenderIdCard);
    }

    @Override
    public Account findAccountByIdcardNo(String idcardNo) {
        return accountMapper.findAccountByIdcardNo(idcardNo);
    }
}
