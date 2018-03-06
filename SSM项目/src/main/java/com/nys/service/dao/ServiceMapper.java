package com.nys.service.dao;

import com.nys.service.domain.Service;
import com.nys.service.domain.ServicePage;

import java.util.List;

public interface ServiceMapper {
    int deleteByPrimaryKey(Integer serviceId);

    int insert(Service record);

    int insertSelective(Service record);

    Service selectByPrimaryKey(Integer serviceId);

    int updateByPrimaryKeySelective(Service record);

    int updateByPrimaryKey(Service record);

    int findCountByPage(ServicePage servicePage);

    List<Service> findServiceByPage(ServicePage servicePage);

    void startService(int serviceId);

    void pauseService(int serviceId);

    void updatePauseDate(int serviceId);

    void deletePauseDate(int serviceId);

    void deleteServiceByAccountId(int accountId);

    void pauseServiceByAccountId(int accountId);

    void updatePauseDateByAccoutId(int accountId);

    Service findServiceByServiceId(int id);

    void setStatus2(int serviceId);

    List<Service> findServiceByUnixHost(String unixHost);

    void updateService(Service service);
}