package com.nys.cost.controller;

import com.nys.cost.domain.Cost;
import com.nys.cost.domain.PageBean;
import com.nys.cost.service.CostService;
import com.nys.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/cost")
public class CostController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CostService costService;
    @Autowired
    private PageBean pageBean;

    @RequestMapping("/findAllCost")
    public String findAllCost(int pc,String byCost,String byDuration,Model model){
        int size = pageBean.getPageSize();
        int begin = (pc-1)*size;
        List<Cost> costs = costService.findCostByPc(begin,size,byCost,byDuration);
        int count = costService.findCount();
//        Map<String,String> params = new HashMap<>();
//        params.put("byCost",byCost);
//        params.put("byDuration",byDuration);
//        pageBean.setParams(params);
        String[] params={"byCost","byDuration"};
        String[] values={byCost,byDuration};
        PageBean pageBean = PagingUtil.getPageBean(this.pageBean, costs, pc, count,params,values);
        model.addAttribute("pageBean",pageBean);
        return "WEB-INF/fee/fee_list";
    }

    @RequestMapping("/addCost")
    public String addCost(Cost cost){

        costService.addCost(cost);
        return "redirect:/cost/findAllCost?pc=1";
    }

    @RequestMapping("/toModi/{costId}")
    public String toModi(@PathVariable int costId , Model model){
        Cost byCostId = costService.findByCostId(costId);
        model.addAttribute("cost",byCostId);
        return "WEB-INF/fee/fee_modi";
    }

    @RequestMapping("/modify")
    public String modify(Cost cost){
        costService.updateByCostId(cost);
        return "redirect:/cost/findAllCost?pc=1";
    }

    @RequestMapping("/deleteCost/{costId}")
    public String deleteCost(@PathVariable int costId){
        costService.deleteByCostId(costId);
        return "redirect:/cost/findAllCost?pc=1";
    }

    @RequestMapping("/updateStatus/{costId}")
    public String updateStatus(@PathVariable int costId){
        costService.updateStatusByCostId(costId);
        return "redirect:/cost/findAllCost?pc=1";
    }

    @RequestMapping("/detail/{costId}")
    public String detail(@PathVariable int costId,Model model){
        Cost byCostId = costService.findByCostId(costId);
        model.addAttribute("cost",byCostId);
        return "WEB-INF/fee/fee_detail";
    }
}
