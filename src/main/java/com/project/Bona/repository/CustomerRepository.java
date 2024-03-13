package com.project.Bona.repository;
import com.project.Bona.model.Customer;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("SELECT c FROM Customer c WHERE c.customerEmail=?1")
    Customer findByEmail(String customerEmail);



}
