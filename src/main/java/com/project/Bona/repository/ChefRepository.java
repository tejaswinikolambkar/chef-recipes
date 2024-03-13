package com.project.Bona.repository;

import com.project.Bona.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ChefRepository extends JpaRepository<Chef,Integer> {

    @Query("SELECT c FROM Chef c WHERE c.chefEmail=?1")
    Chef findByEmail(String chefEmail);

    @Query("SELECT COUNT(c) FROM Chef c WHERE c.chefCity=?1")
    String findByCityName(String chefCity);
}
