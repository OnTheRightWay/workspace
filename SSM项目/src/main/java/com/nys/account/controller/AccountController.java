package com.nys.account.controller;

import com.nys.account.domain.Account;
import com.nys.account.domain.AccountWarp;
import com.nys.account.service.AccountService;
import com.nys.cost.domain.PageBean;
import com.nys.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Resource
    private PageBean pageBean;

    @RequestMapping("/findAccountByPc")
    public String findAccountByPc(
            int pc, String idcardNo, String realName, String loginName, String status, Model model){
        String[] params = {"idcardNo","realName","loginName","status"};
        if (idcardNo!=null){
            idcardNo=idcardNo.trim();
        }if (realName!=null){
            realName=realName.trim();
        }if (loginName!=null){
            loginName=loginName.trim();
        }if (status!=null){
            status=status.trim();
        }
        String[] values = {idcardNo,realName,loginName,status};
        int size = this.pageBean.getPageSize();
        int begin = (pc-1)*size;
        List<Account> accounts = accountService.findAccountByPc(begin,size,params,values);
        int count = accountService.findCount(params,values);
        PageBean pageBean = PagingUtil.getPageBean(this.pageBean, accounts, pc, count, params, values);
        model.addAttribute("pageBean",pageBean);
        return "WEB-INF/account/account_list";
    }

    @RequestMapping("/updateStatus")
    public String updateStatus(String status,int accountId){
        accountService.updateStatus(status,accountId);
        return "redirect:/account/findAccountByPc?pc=1";
    }

    @RequestMapping("/addAccount")
    public String addAccount(Account account,String recommenderIdCard){

        int a = accountService.findAccountBIdByIdcardNo(recommenderIdCard);
        account.setRecommenderId(a);
        accountService.addAccount(account);

        return "redirect:/account/findAccountByPc?pc=1";
    }

    @RequestMapping("/toModiAccount/{accountId}")
    public String toModi(@PathVariable int accountId,Model model){
        Account account = accountService.findAccountByAccountId(accountId);
        model.addAttribute("account",account);
        String idcardNo = accountService.findIdcardNoByAccountId(account.getRecommenderId());
        model.addAttribute("idcardNo",idcardNo);
        return "WEB-INF/account/account_modi";
    }

    @RequestMapping("/updateAccount")
    public String updateAccount(Account account,String recommenderIdCard){
        int a = accountService.findAccountBIdByIdcardNo(recommenderIdCard);
        account.setRecommenderId(a);
        accountService.updateAccount(account);
        return "redirect:/account/findAccountByPc?pc=1";
    }

    @RequestMapping("/deleteAccount/{accountId}")
    public String deleteAccount(@PathVariable int accountId){
        accountService.deleteAccount(accountId);
        return "redirect:/account/findAccountByPc?pc=1";
    }

    @RequestMapping("/accountDetail/{accountId}")
    public String accountDetail(@PathVariable int accountId,Model model){
        Account account = accountService.findAccountByAccountId(accountId);
        model.addAttribute("account",account);
        String idcardNo = accountService.findIdcardNoByAccountId(account.getRecommenderId());
        model.addAttribute("idcardNo",idcardNo);
        return "WEB-INF/account/account_detail";
    }

    @RequestMapping("/findAccountByIdcardNo/{idcardNo}")
    @ResponseBody
    public AccountWarp findAccountByIdcardNo(@PathVariable String idcardNo){
        Account account = accountService.findAccountByIdcardNo(idcardNo);
        AccountWarp accountWarp = new AccountWarp(200,"success",account);
        return accountWarp;
    }
}
