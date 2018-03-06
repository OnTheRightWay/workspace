package com.nys.cost.dao;

import com.nys.cost.domain.Cost;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface CostMapper {
    int deleteByPrimaryKey(Integer costId);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer costId);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);

    List<Cost> findAllCost();

    void save(Cost cost);

    void updateStatusByCostId(int costId);

    void updateStartimeByCostId(int costId);

    int findCount();

    List<Cost> findCostByPc(List<Integer> a);
    List<Cost> findCostByPcDurationUp(List<Integer> a);
    List<Cost> findCostByPcCostUp(List<Integer> a);
    List<Cost> findCostByPcCostDurationUp(List<Integer> a);
}