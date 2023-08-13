package com.example.ecommerceamazonclone.Controller;

import com.example.ecommerceamazonclone.ApiRespoens.ApiRespoens;
import com.example.ecommerceamazonclone.Modle.Category;
import com.example.ecommerceamazonclone.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {



    private final CategoryService serviec;

    @GetMapping("/get")
    public ResponseEntity getCategory(){
        return ResponseEntity.status(200).body(serviec);
    }



    @PostMapping("/add")
    public ResponseEntity addCategory(@RequestBody @Valid Category category, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        serviec.addCategories(category);
        return ResponseEntity.status(200).body(new ApiRespoens("The Category added successfully"));
    }




    @PutMapping("/update/{id}")
    public ResponseEntity updateCategory (@PathVariable String id , @RequestBody @Valid Category category , Errors errors ){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdate =serviec.updateCategories(id,category);
        if(isupdate){
            return ResponseEntity.status(200).body(new ApiRespoens("The merchant updated successfully "));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("The is is not found"));

    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCategory(@PathVariable String id){
        boolean isdelted = serviec.deleteCategories(id);
        if(isdelted){
            return  ResponseEntity.status(200).body(new ApiRespoens("The merchant deleted successfully"));
        }
          return ResponseEntity.status(400).body(new ApiRespoens("The is is not found"));
    }



}
