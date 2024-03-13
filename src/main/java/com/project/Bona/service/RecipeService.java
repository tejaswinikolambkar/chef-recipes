package com.project.Bona.service;

import com.project.Bona.dto.*;
import com.project.Bona.model.*;
import com.project.Bona.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    /* Add Recipe */
    public Recipe saveRecipe(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    /* Get List of all Recipe */
    public List<Recipe> getRecipe(){
        return recipeRepository.findAll();
    }

    /* Delete Recipe*/
    public void deleteRecipe(int recipeId){
        recipeRepository.deleteById(recipeId);
    }

    public List<Recipe> getRecipe(int chefId){
        return recipeRepository.getAllRecipe(chefId);
    }

    public void updateR(Recipe recipe) {
    recipeRepository.save(recipe);
    }

    public List<Recipe> findAllRecords(Chef chef) {

        return recipeRepository.findByChef(chef);
    }


}
