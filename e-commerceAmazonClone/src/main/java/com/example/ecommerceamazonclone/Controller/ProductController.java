package com.example.ecommerceamazonclone.Controller;

import com.example.ecommerceamazonclone.ApiRespoens.ApiRespoens;
import com.example.ecommerceamazonclone.Modle.Category;
import com.example.ecommerceamazonclone.Modle.Product;
import com.example.ecommerceamazonclone.Service.CategoryService;
import com.example.ecommerceamazonclone.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getProduct(){
        return ResponseEntity.status(200).body(productService);
    }


    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody @Valid Product product, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(productService.addProducts(product)) {
            return ResponseEntity.status(200).body(new ApiRespoens("The product added successfully"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("Category id not found"));
    }




    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable String id , @RequestBody @Valid Product product , Errors errors ){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdate =productService.updateProducts(id,product);
        if(isupdate){
            return ResponseEntity.status(200).body(new ApiRespoens("The product Updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("The Category id not found or the id not found"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        boolean isdelted = productService.deleteProducts(id);
        if(isdelted){
            return  ResponseEntity.status(200).body(new ApiRespoens("The product deleted successfully "));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("The id is not found"));
    }





}
