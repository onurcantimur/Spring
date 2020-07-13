package com.example.spring.mvc.Controller;

import com.example.spring.mvc.dao.CustomerDAO;
import com.example.spring.mvc.entity.Customer;
import com.example.spring.mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
