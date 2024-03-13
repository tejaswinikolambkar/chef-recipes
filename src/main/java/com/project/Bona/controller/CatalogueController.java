package com.project.Bona.controller;
import com.project.Bona.model.*;
import com.project.Bona.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
public class CatalogueController {
    @Autowired
    private CatalogueRepository catalogueRepository;
    @Autowired
    private RecipeRepository recipeRepository;

    @PostMapping("/addCatalogue")
    public Catalogue addCatalogue(@RequestBody Catalogue catalogue){
        return catalogueRepository.save(catalogue);
    }

    @GetMapping("/getCatalogue")
    public List<Catalogue> getCatalogue(){
        return catalogueRepository.findAll();
    }

    @DeleteMapping("/deleteCatalogue/{catalogueName}")
    public List<Catalogue> removeCatalogue(@PathVariable String catalogueName){
        return catalogueRepository.deleteByName(catalogueName);
    }

}
