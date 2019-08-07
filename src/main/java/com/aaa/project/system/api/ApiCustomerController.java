package com.aaa.project.system.api;

import com.aaa.project.system.customer.domain.Customer;
import com.aaa.project.system.customer.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class ApiCustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @RequestMapping("/selectCustomer")
    public List<Customer> selectCustomer(String userphone){
        List<Customer> list = customerService.selectCustomer(userphone);
        System.out.println(list);
        if (list.size()>0){
            return list;
        }
        return null;
    }
    @RequestMapping("/selectCustomerByUserid")
    public Customer selectCustomerByUserid(Customer customer) {
        return customerService.selectCustomerByUserid(customer);
    }
    @RequestMapping("/addCustomer")
    public Boolean addCustomer(String userphone) {
        Customer customer=new Customer();
        customer.setUserphone(userphone);
        if (customerService.addCustomer(customer)){
            return true;
        }
        return false;
    }
    @RequestMapping("/updateCustomers")
    public Boolean updateCustomers(@RequestBody Customer customer) {
        /*System.out.println(userid);
        System.out.println(username);
        System.out.println(userphone);
        Customer customer=new Customer();
        customer.setUserid(userid);
        customer.setUsername(username);
        customer.setUserphone(userphone);*/
        if (customerService.updateCustomers(customer)){
            return true;
        }
        return false;
    }
}
