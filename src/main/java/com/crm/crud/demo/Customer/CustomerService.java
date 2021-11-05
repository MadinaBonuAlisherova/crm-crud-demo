package com.crm.crud.demo.Customer;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class CustomerService {


    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    //Get by Id
    public Customer getCustomerById(Long id){
        return customerRepository.getById(id);
    }


    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional =
        customerRepository.findCustomerByName(customer.getName());

        if (customerOptional.isPresent()){
            throw new IllegalStateException("Customer already exits!");
        }

        customerRepository.save(customer);
    }


    //Delete customer by id
    public void deleteCustomerById(Long id) {
        boolean exists = customerRepository.existsById(id);

        if (!exists){
            throw new IllegalStateException(
                    "Customer with this id "+id+" does not exist!"
            );
        }

        customerRepository.deleteById(id);
    }

    public void deleteCustomerByName(String name) {
        boolean exists = customerRepository.existsByName(name);

        if (!exists){
            throw new IllegalStateException(
                    "Customer with name "+name+" does not exist!"
            );
        }

        customerRepository.deleteByName(name);
    }

    //Update customer with name
    @Transactional
    public void updateCustomer(Long id, String name, String email) {
             Customer customer = customerRepository.findById(id)
                     .orElseThrow(() -> new IllegalStateException(
                             "Customer with id "+id+" doesn't exist"

                     ));
             if (name != null && name.length() > 0 && !Objects.equals(customer.getName(), name)){
                 customer.setName(name);
             }

             if (email != null && email.length() > 0 && !Objects.equals(customer.getEmail(), email)){
                 Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);

                 if (customerOptional.isPresent()){
                     throw new IllegalStateException("For this user, Email is taken");
                 }
                 customer.setEmail(email);
             }
//        customer.setName(cutomerDetails.getName());
//        customer.setEmail(cutomerDetails.getEmail());
        customerRepository.save(customer);

    }

}
