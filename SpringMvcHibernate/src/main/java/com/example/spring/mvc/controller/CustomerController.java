package com.example.spring.mvc.controller;

import com.example.spring.mvc.entity.Customer;
import com.example.spring.mvc.service.CustomerService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public String listCustomers(Model model){

        List<Customer> customerList = customerService.getCustomers();


        model.addAttribute("customers",customerList);

        return "list-customers";
    }

    @GetMapping("/showFormAdd")
    public String addCustomer(Model model){

        Customer customer = new Customer();
        model.addAttribute("customer",customer);

        return "customer-form";
    }


    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        customerService.addCustomer(customer);


        return "redirect:/customer/list";
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("customerId") int id, Model model){

        Customer customer = customerService.getCustomer(id);


        model.addAttribute("customer",customer);

        return "customer-form";
    }


    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id){

        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }


}
