package com.nys.service.service;

import com.nys.service.domain.Service;

import java.util.List;

public interface ServiceService {
    int findCount(String[] values);

    List<Service> findServiceByPage(int begin, int size, String[] values);

    void updateStatus(String status, int serviceId);

    Service findByServiceId(int id);

    void deleteService(int serviceId);

    List<Service> findServiceByUnixHost(String unixHost);

    void addService(Service service);

    void updateService(Service service);
}
