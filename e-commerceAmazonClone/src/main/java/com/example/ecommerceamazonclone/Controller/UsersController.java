package com.example.ecommerceamazonclone.Controller;

import com.example.ecommerceamazonclone.ApiRespoens.ApiRespoens;
import com.example.ecommerceamazonclone.Modle.Review;
import com.example.ecommerceamazonclone.Modle.User;
import com.example.ecommerceamazonclone.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UsersController {


    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(userService);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUsers(user);
        return ResponseEntity.status(200).body(new ApiRespoens("The User added successfully"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable String id , @RequestBody @Valid User user , Errors errors ){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdate =userService.updateUsers(id,user);
        if(isupdate){
            return ResponseEntity.status(200).body(new ApiRespoens("The User is updated successfully "));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("The is is not found"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id){
        boolean isdelted = userService.deleteUsers(id);
        if(isdelted){
            return  ResponseEntity.status(200).body(new ApiRespoens("The User is deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("The is is not found"));
    }



    @PostMapping("/buy-product/{userId}/{productId}/{merchantId}")
    public ResponseEntity buyProduct(@PathVariable String userId,@PathVariable String productId, @PathVariable String merchantId ) {
        boolean isupdate =userService.buyProduct(userId,productId,merchantId);
        if(isupdate){
            return ResponseEntity.status(200).body(new ApiRespoens("You have buy the product successfully"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("Check the requested ids and your balance"));
    }



    @GetMapping("/check-price/{productId}")
    public ResponseEntity checkprice(@PathVariable String productId){
        Integer p = userService.checkprice(productId);
        if(p>0){
            return ResponseEntity.status(200).body(new ApiRespoens("The product price is :"+p));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("Check the product id"));

    }



    @PostMapping("/addProudctReview/{productId}/{review}")
    public ResponseEntity addProudctReview(@PathVariable String productId , @PathVariable String review ) {
        boolean r =userService.addProudctReview(productId,review);
        if(r){
            return ResponseEntity.status(200).body(new ApiRespoens("review add  successfully"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("check the id"));}




    @GetMapping ("/getProudctReview/{productId}")
    public ResponseEntity getProudctReview(@PathVariable String productId ) {

        if(userService.getProudctReview(productId) != null){
            return ResponseEntity.status(200).body(userService.getProudctReview(productId));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("Check the  id"));
    }





}
