package com.nys.service.controller;

import com.nys.cost.domain.Cost;
import com.nys.cost.domain.PageBean;
import com.nys.cost.service.CostService;
import com.nys.service.domain.Service;
import com.nys.service.domain.ServiceWarp;
import com.nys.service.service.ServiceService;
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
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private CostService costService;

    @Resource
    private PageBean pageBean;

    @RequestMapping("/findServiceByPage")
    public String findServiceByPage(
            int pc, String osUsername, String unixHost, String idcardNo, String status, Model model){
        String[] params = {"osUsername","unixHost","idcardNo","status"};
        if (osUsername!=null){
            osUsername=osUsername.trim();
        }if (unixHost!=null){
            unixHost=unixHost.trim();
        }if (idcardNo!=null){
            idcardNo=idcardNo.trim();
        }if (status!=null){
            status=status.trim();
        }
        String[] values = {osUsername,unixHost,idcardNo,status};
        int size = this.pageBean.getPageSize();
        int begin = (pc-1)*size;
        List<Service> services = serviceService.findServiceByPage(begin,size,values);
        int count = serviceService.findCount(values);
        PageBean pageBean = PagingUtil.getPageBean(this.pageBean, services, pc, count, params, values);
        model.addAttribute("pageBean",pageBean);
        return "WEB-INF/service/service_list";
    }

    @RequestMapping("/updateStatus")
    public String updateStatus(String status,int serviceId){
        serviceService.updateStatus(status,serviceId);
        return "redirect:/service/findServiceByPage?pc=1";
    }

    @RequestMapping("/ServiceDetail/{id}")
    public String ServiceDetail(@PathVariable int id,Model model){
        Service service = serviceService.findByServiceId(id);
        model.addAttribute("service",service);
        return "WEB-INF/service/service_detail";
    }

    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        List<Cost> costlist = costService.findAllCost();
        model.addAttribute("costs",costlist);
        return "WEB-INF/service/service_add";
    }

    @RequestMapping("/deleteService/{serviceId}")
    public String deleteService(@PathVariable int serviceId){
        serviceService.deleteService(serviceId);
        return "redirect:/service/findServiceByPage?pc=1";
    }

    @RequestMapping("/findServiceByUnixHost")
    @ResponseBody
    public ServiceWarp findServiceByUnixHost(String unixHost){
        List<Service> services = serviceService.findServiceByUnixHost(unixHost);
        ServiceWarp serviceWarp = new ServiceWarp(200,"success",services);
        return serviceWarp;
    }

    @RequestMapping("/addService")
    public String addService(Service service){
        serviceService.addService(service);
        return "redirect:/service/findServiceByPage?pc=1";
    }

    @RequestMapping("/toModi/{serviceId}")
    public String toModi(@PathVariable int serviceId,Model model){
        Service service = serviceService.findByServiceId(serviceId);
        List<Cost> costs = costService.findAllCost();
        model.addAttribute("service",service);
        model.addAttribute("costs",costs);
        return "WEB-INF/service/service_modi";
    }

    @RequestMapping("/modify")
    public String modify(Service service){
        serviceService.updateService(service);
        return "redirect:/service/findServiceByPage?pc=1";
    }

}
