package com.crm.crud.demo.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( path = "crud/v1/customer")
public class CustomerController {

    private final CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping()
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String displayCustomer(@PathVariable("id") Long customerId){
        Customer customer = customerService.getCustomerById(customerId);
        if (customer == null){
            return "Customer not found with id "+customerId;
        }
        return "Customer found "+customerId;
    }

    //Post mapping
    @PostMapping
    public void registerNewCustomer(@RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }

    //Delete mapping with id
    @DeleteMapping(path = "/{customerId}")
    public void deleteCustomerById(@PathVariable("customerId") Long id){
        customerService.deleteCustomerById(id);
    }

    //Delete mapping with name
    @DeleteMapping(path = "/{customerName}")
    public void deleteCustomerByName(@PathVariable("customerName") String name){
        customerService.deleteCustomerByName(name);
    }

    //Update mapping with name
    @PatchMapping(path = "/{customerId}")
    public void updateCustomer(@PathVariable("customerId") Long id,
            @PathVariable(required = false) String name,
             @PathVariable(required = false) String email
//                @Validated @RequestBody Customer customerDetails
    ){
        customerService.updateCustomer(id, name, email);
    }

}
