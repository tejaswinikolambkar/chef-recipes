package com.project.Bona.repository;

import com.project.Bona.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query("DELETE FROM Address a where a.customerAddress=?1")
    public List<Address> deleteByName(String customerAddress);

    @Query("SELECT c from Address c where customer_id=?1")
    List<Address> getAddress(int customerId);


}
