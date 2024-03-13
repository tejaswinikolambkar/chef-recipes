package com.project.Bona.service;

import com.project.Bona.dto.*;
import com.project.Bona.model.*;
import com.project.Bona.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class CatalogueService {

    @Autowired
    private ChefRepository chefRepository;
    @Autowired
    private CatalogueRepository catalogueRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    /* Add Catalogues */
    public Catalogue saveCatalogue(Catalogue catalogue){
        return catalogueRepository.save(catalogue);
    }

    /* List of Catalogue */
    public List<Catalogue> getCatalogue(){
       return catalogueRepository.findAll();
    }

    /* Delete Recipe*/
    public List<Catalogue> deleteCatalog(String catalogueName){
        return catalogueRepository.deleteByName(catalogueName);
    }





}
