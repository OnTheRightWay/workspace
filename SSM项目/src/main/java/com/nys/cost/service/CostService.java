package com.nys.cost.service;

import com.nys.cost.domain.Cost;

import java.util.List;

public interface CostService {
    List<Cost> findAllCost();
    void addCost(Cost cost);
    Cost findByCostId(int costId);
    void updateByCostId(Cost cost);
    void deleteByCostId(int costId);
    void updateStatusByCostId(int costId);

    int findCount();

    List<Cost> findCostByPc(int pc,int size,String byCost,String byDuration);
}
