package com.project.Bona.controller;

import com.project.Bona.RuntimeException.*;
import com.project.Bona.dto.*;
import com.project.Bona.model.*;
import com.project.Bona.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ChefController {
    @Autowired
    private ChefService chefService;
    @Autowired
    private CatalogueService catalogueService;
    @Autowired
    private RecipeService recipeService;

    /* Registration Method */
    @PostMapping("/registerChef")
    public RegisterStatus registerChef(@RequestBody Chef chef){
            try{
                chefService.saveChef(chef);
                RegisterStatus status=new RegisterStatus();
                status.setStatus(Status.StatusType.SUCCESS);
                status.setMessage("Registration Successful!");
                return status;
            }
            catch (CustomerServiceException e){
                RegisterStatus status=new RegisterStatus();
                status.setStatus(Status.StatusType.FAILURE);
                status.setMessage(e.getMessage());
                return status;
            }
    }

    /* Login Method */
    @PostMapping("/authChef")
    public String login(@RequestBody Chef chef){
        Chef db=chefService.findByEmail(chef.getChefEmail());
        if(db!=null && chef.getChefEmail().equals(db.getChefEmail())){
            if(chef.getChefPassword().equals(db.getChefPassword())){

                return "Chef has successfully Logged in";
            }
            else
                return "Invalid password";
        }
        else
            return "Chef has not registered";
    }

    /* List of Registered Chef */
    @GetMapping("/getAllChef")
    public List<Chef> chefList(){
        return chefService.getChef();
    }

    @GetMapping("/searchByCity/{chefCity}")
    public String searchByCityName(@PathVariable String chefCity){
         return chefService.findByCity(chefCity);
    }

}
