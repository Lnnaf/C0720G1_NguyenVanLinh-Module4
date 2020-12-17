package com.project.controller;

import com.project.entity.*;
import com.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("service")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private RentTypeService rentTypeService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AttachServiceService attachServiceService;
    @Autowired
    private ContractDetailService contractDetailService;
    @GetMapping("/service-manager")
    public String servicePage(Model model){
        model.addAttribute("serviceObj",new Service());
        model.addAttribute("listServiceType",serviceTypeService.findAllServiceType());
        List<RentType> list = rentTypeService.findAllRentType();
        model.addAttribute("listRentType",rentTypeService.findAllRentType());
        model.addAttribute("listService",serviceService.findAllService());
        return "service-manager";
    }
    @PostMapping("/create")
    public String createNewService(Model model,@Valid @ModelAttribute("serviceObj") Service service, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("flag","1");
            model.addAttribute("listServiceType",serviceTypeService.findAllServiceType());
            List<RentType> list = rentTypeService.findAllRentType();
            model.addAttribute("listRentType",rentTypeService.findAllRentType());
            model.addAttribute("listService",serviceService.findAllService());
            return "service-manager";
        }
        serviceService.save(service);
        return "redirect:/service/service-manager";
    }
    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable Integer id){
        serviceService.delete(id);
        return "redirect:/service/service-manager";
    }
    @PostMapping("/update")
    public String updateService(Model model,@Valid @ModelAttribute("serviceObj") Service service, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("flag","2");
            model.addAttribute("listServiceType",serviceTypeService.findAllServiceType());
            List<RentType> list = rentTypeService.findAllRentType();
            model.addAttribute("listRentType",rentTypeService.findAllRentType());
            model.addAttribute("listService",serviceService.findAllService());
            return "service-manager";
        }
        serviceService.save(service);
        return "redirect:/service/service-manager";
    }
    @GetMapping("/contract")
    public String contractManager(Model model){
        model.addAttribute("contractObj",new Contract());
        model.addAttribute("contractDetailObj",new ContractDetail());
        model.addAttribute("listContract",contractService.findAll());
        model.addAttribute("listEmployee",employeeService.findAll());
        model.addAttribute("listCustomer",customerService.findAll());
        model.addAttribute("listAttachService",attachServiceService.findAll());
        model.addAttribute("listService",serviceService.findAllService());
        return "contract-manager";
    }
    @PostMapping("/contract-create")
    public String contractCreate(Model model,@Valid @ModelAttribute("contractObj") Contract contract,BindingResult bindingResult){
//     contractService.checkDate(contract,bindingResult);
        try {
            LocalDate startDate = LocalDate.parse(contract.getContractStartDate());
            LocalDate endDate = LocalDate.parse(contract.getContractEndDate());
            if (endDate.compareTo(startDate) <= 0) {
//            ObjectError error = new ObjectError("endDate", "End Date must be after Start Date");
//            bindingResult.addError(error);
                bindingResult.rejectValue("contractEndDate", "error.contract", "End Date must be after Start Date");
                bindingResult.rejectValue("contractStartDate", "error.contract", "End Date must be after Start Date");
            }
        } catch (Exception e) {
            bindingResult.rejectValue("contractStartDate", "error.contract", "Date can't be empty");
            bindingResult.rejectValue("contractEndDate", "error.contract", "Date can't be empty");
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("flag","1");
            model.addAttribute("contractDetailObj",new ContractDetail());
            model.addAttribute("listContract",contractService.findAll());
            model.addAttribute("listEmployee",employeeService.findAll());
            model.addAttribute("listCustomer",customerService.findAll());
            model.addAttribute("listAttachService",attachServiceService.findAll());
            model.addAttribute("listService",serviceService.findAllService());
        }else{
            contractService.save(contract);
        }
        return "contract-manager";
    }
    @GetMapping("/contract-delete/{id}")
    public String contractDelete(@PathVariable Integer id){
        contractService.delete(id);
        return "redirect:/service/contract";
    }
    @PostMapping("/contract-detail")
    public String contractDetail(@ModelAttribute ContractDetail contractDetail){
        contractDetailService.save(contractDetail);
        return "redirect:/service/contract";
    }
    @GetMapping("/attach-service")
    public String attachService(Model model){
        model.addAttribute("attachObj",new AttachService());
        model.addAttribute("listAttachService",attachServiceService.findAll());
        return "attach-service-manager";
    }
    @PostMapping("/attach-create")
    public String attachCreate(@ModelAttribute AttachService attachService){
        attachServiceService.save(attachService);
        return "redirect:/service/attach-service";
    }
    @PostMapping("/attach-delete/{id}")
    public String attachDelete(@PathVariable Integer id){
        attachServiceService.delete(id);
        return "redirect:/service/attach-service";
    }
    @PostMapping("/attach-update")
    public String attachUpdate(@ModelAttribute AttachService attachService){
        attachServiceService.save(attachService);
        return "redirect:/service/attach-service";
    }
}
