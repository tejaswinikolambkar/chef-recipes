package com.project.Bona.repository;

import com.project.Bona.dto.*;
import com.project.Bona.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface CatalogueRepository extends JpaRepository<Catalogue,Integer> {


    @Query("DELETE FROM Catalogue c where c.catalogueName=?1")
    List<Catalogue> deleteByName(String recipeName);



}
