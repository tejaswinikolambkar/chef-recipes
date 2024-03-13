package com.project.Bona.repository;

import com.project.Bona.dto.*;
import com.project.Bona.model.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Integer> {


    List<Recipe> findByChef(Chef chef);

    @Query("DELETE FROM Recipe r where recipe_id=?1")
    void deleteByName(int recipeId);

    @Query("SELECT r FROM Recipe r where chef_id=?1 ")
    List<Recipe> getAllRecipe(int chefId);

//    @Modifying
//    @Query("UPDATE recipe r SET r.recipeName=?1,r.recipePrice=?1,r.foodType=?1 WHERE recipeId=?1")
//    void updateRecipe(String recipeName, double recipePrice, String foodType,int recipeId);
}
