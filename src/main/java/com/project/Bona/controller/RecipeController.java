package com.project.Bona.controller;

import com.project.Bona.model.*;
import com.project.Bona.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class RecipeController {

    @Autowired
    private ChefService chefService;
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/getRecipe")
    public List<Recipe> listRecipe() {
        return recipeService.getRecipe();
    }

    @PostMapping("/addRecipe")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }

    @DeleteMapping("/deleteRecipe/{recipeId}")
    public void removeRecipe(@PathVariable int recipeId) {
        recipeService.deleteRecipe(recipeId);
    }

    @PutMapping("/update")
    public String updateRecipe(@RequestBody Recipe recipe){
            recipeService.saveRecipe(recipe);
            return "Updated";
    }

    @GetMapping("/getRecipe/{chefId}")
    public List<Recipe> getRecipe(@PathVariable int chefId) {
        return recipeService.getRecipe(chefId);
    }


    @GetMapping("/getAllRecipe/{chefId}")
    public List<Recipe> getAllRecipe(@PathVariable int chefId){
        Optional<Chef> val = chefService.findChefById(chefId);
        Chef chef = null;
        if(val.isPresent()) {
            chef = val.get();
        }
        List<Recipe> recipe = recipeService.findAllRecords(chef);
        return 	recipe;
    }


}