package com.nys.cost.service.impl;

import com.nys.cost.dao.CostMapper;
import com.nys.cost.domain.Cost;
import com.nys.cost.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("costService")
public class CostServiceImpl implements CostService {

//    @Resource
    private CostMapper costMapper;

    public CostServiceImpl(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        costMapper = applicationContext.getBean(CostMapper.class);
    }

    @Override
    public List<Cost> findAllCost() {
        return costMapper.findAllCost();
    }

    @Override
    public void addCost(Cost cost) {

        cost.setCreatime(new Date());
        costMapper.save(cost);
    }

    @Override
    public Cost findByCostId(int costId) {
        return costMapper.selectByPrimaryKey(costId);
    }

    @Override
    public void updateByCostId(Cost cost) {
        Cost cost1 = costMapper.selectByPrimaryKey(cost.getCostId());
        if (!"0".equals(cost1.getStatus())){
            return;
        }
        cost.setCreatime(new Date());
        costMapper.updateByPrimaryKey(cost);
    }

    @Override
    public void deleteByCostId(int costId){
        Cost cost = costMapper.selectByPrimaryKey(costId);
        if (!"0".equals(cost.getStatus())){
            return;
//            throw new StatusException();
        }
        costMapper.deleteByPrimaryKey(costId);
    }

    @Override
    public void updateStatusByCostId(int costId) {
        Cost cost = costMapper.selectByPrimaryKey(costId);
        if (!"0".equals(cost.getStatus())){
            return;
//            throw new StatusException();
        }
        costMapper.updateStatusByCostId(costId);
        costMapper.updateStartimeByCostId(costId);
    }

    @Override
    public int findCount() {
        return costMapper.findCount();
    }

    @Override
    public List<Cost> findCostByPc(int pc,int size,String byCost,String byDuration) {
        List<Integer> a = new ArrayList<>();
        a.add(pc);
        a.add(size);
        if ((byCost==null||byCost.equals(""))&&(byDuration==null||byDuration.equals(""))){
            return costMapper.findCostByPc(a);
        }
        if ((byCost!=null&&!byCost.equals(""))&&(byDuration==null||byDuration.equals(""))){
            return costMapper.findCostByPcCostUp(a);
        }
        if ((byCost==null||byCost.equals(""))&&(byDuration!=null&&!byDuration.equals(""))){
            return costMapper.findCostByPcDurationUp(a);
        }
        if ((byCost!=null&&!byCost.equals(""))&&(byDuration!=null&&!byDuration.equals(""))){
            return costMapper.findCostByPcCostDurationUp(a);
        }
        return null;
    }
}
