package com.nys.service.service.impl;

import com.nys.account.dao.AccountMapper;
import com.nys.account.domain.Account;
import com.nys.account.service.AccountService;
import com.nys.service.dao.ServiceMapper;
import com.nys.service.domain.ServicePage;
import com.nys.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("serviceService")
public class ServiceServiceImpl implements ServiceService {

    private ServiceMapper serviceMapper;
    private AccountMapper accountMapper;

    @Autowired
    private ServicePage servicePage;

    public ServiceServiceImpl(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        serviceMapper = context.getBean(ServiceMapper.class);
        accountMapper = context.getBean(AccountMapper.class);
    }

    @Override
    public int findCount(String[] values) {
        servicePage.setOsUsername(values[0]);
        servicePage.setUnixHost(values[1]);
        servicePage.setIdcardNo(values[2]);
        servicePage.setStatus(values[3]);
        return serviceMapper.findCountByPage(servicePage);
    }

    @Override
    public List<com.nys.service.domain.Service> findServiceByPage(int begin, int size, String[] values) {

        servicePage.setOsUsername(values[0]);
        servicePage.setUnixHost(values[1]);
        servicePage.setIdcardNo(values[2]);
        servicePage.setStatus(values[3]);
        servicePage.setBegin(begin);
        servicePage.setSize(size);
        return serviceMapper.findServiceByPage(servicePage);
    }

    @Override
    public void updateStatus(String status, int serviceId) {
        if (status.equals("0")){
            com.nys.service.domain.Service service = serviceMapper.selectByPrimaryKey(serviceId);
            Account account = accountMapper.selectByPrimaryKey(service.getAccountId());
            if ("1".equals(account.getStatus())){
                System.out.println("开通失败");
                return;
            }
            serviceMapper.startService(serviceId);
            serviceMapper.deletePauseDate(serviceId);
        }
        if (status.equals("1")){
            serviceMapper.pauseService(serviceId);
            serviceMapper.updatePauseDate(serviceId);
        }
    }

    @Override
    public com.nys.service.domain.Service findByServiceId(int id) {
        return serviceMapper.findServiceByServiceId(id);
    }

    @Override
    public void deleteService(int serviceId) {
        serviceMapper.setStatus2(serviceId);
    }

    @Override
    public List<com.nys.service.domain.Service> findServiceByUnixHost(String unixHost) {
        return serviceMapper.findServiceByUnixHost(unixHost);
    }

    @Override
    public void addService(com.nys.service.domain.Service service) {
        service.setCreateDate(new Date());
        serviceMapper.insert(service);
    }

    @Override
    public void updateService(com.nys.service.domain.Service service) {
        serviceMapper.updateService(service);
    }
}
