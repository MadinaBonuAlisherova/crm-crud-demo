package com.crm.crud.demo.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository
        extends JpaRepository<Customer, Long>{


    @Query("select c from  #{#entityName} c where  c.name =?1 ")
    Optional<Customer> findCustomerByName(String name);

//    Stream<Customer> streamAllByName(String name);


    @Modifying
    @Query("delete from Customer c  where c.name =?1")
    void deleteByName(String name);


    boolean existsByName(String name);

//    @Query("select c from customer c where c.email =?1")
    Optional<Customer> findCustomerByEmail(String email);
}
