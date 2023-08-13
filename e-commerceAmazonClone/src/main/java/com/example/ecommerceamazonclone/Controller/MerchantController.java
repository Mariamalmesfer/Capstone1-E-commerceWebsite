package com.example.ecommerceamazonclone.Controller;

import com.example.ecommerceamazonclone.ApiRespoens.ApiRespoens;
import com.example.ecommerceamazonclone.Modle.Category;
import com.example.ecommerceamazonclone.Modle.Merchant;
import com.example.ecommerceamazonclone.Service.CategoryService;
import com.example.ecommerceamazonclone.Service.MerchantService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {



    private final MerchantService merchantService ;

    @GetMapping("/get")
    public ResponseEntity getMerchant(){
        return ResponseEntity.status(200).body(merchantService);
    }



    @PostMapping("/add")
    public ResponseEntity addMerchant(@RequestBody @Valid Merchant merchant , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body(new ApiRespoens("The merchant added successfully"));
    }




    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant (@PathVariable String id , @RequestBody @Valid Merchant merchant , Errors errors ){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdate =merchantService.updateMerchant(id,merchant);
        if(isupdate){
            return ResponseEntity.status(200).body(new ApiRespoens("The product updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("The is id not found"));
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable String id){
        boolean isdelted = merchantService.deleteMerchant(id);
        if(isdelted){
            return  ResponseEntity.status(200).body(new ApiRespoens("The merchant deleted successfully "));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("The is is not found"));
    }


    @PostMapping("/add-stock/{id}/{proudctId}/{stock}")
    public ResponseEntity addStock(@PathVariable  String id, @PathVariable   String proudctId, @PathVariable int stock  ) {
        boolean isupdate =merchantService.addStock(proudctId,id,stock);
        if(isupdate){
            return ResponseEntity.status(200).body(new ApiRespoens("The product updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("The is id not found"));
    }

    }







