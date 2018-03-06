package com.nys.service_update_bak.dao;

import com.nys.service_update_bak.domain.ServiceUpdateBak;

public interface ServiceUpdateBakMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ServiceUpdateBak record);

    int insertSelective(ServiceUpdateBak record);

    ServiceUpdateBak selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ServiceUpdateBak record);

    int updateByPrimaryKey(ServiceUpdateBak record);
}