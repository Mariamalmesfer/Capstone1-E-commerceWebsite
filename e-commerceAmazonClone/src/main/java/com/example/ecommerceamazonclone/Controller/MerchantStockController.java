package com.example.ecommerceamazonclone.Controller;

import com.example.ecommerceamazonclone.ApiRespoens.ApiRespoens;
import com.example.ecommerceamazonclone.Modle.MerchantStock;
import com.example.ecommerceamazonclone.Modle.Product;
import com.example.ecommerceamazonclone.Service.MerchantStockService;
import com.example.ecommerceamazonclone.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/merchantstock")
@RequiredArgsConstructor
public class MerchantStockController {


    private final MerchantStockService merchantStockService;


    @GetMapping("/get")
    public ResponseEntity getMerchantStock(){
        return ResponseEntity.status(200).body(merchantStockService);
    }
//
//
    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(merchantStockService.addMerchantStock(merchantStock)) {
            return ResponseEntity.status(200).body(new ApiRespoens("The merchantStock added successfully"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("check MerchantStock The product id or the merchant id not found"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable String id , @RequestBody @Valid MerchantStock merchantStock , Errors errors ){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isupdate =merchantStockService.updateMerchantStock(id,merchantStock);
        if(isupdate){
            return ResponseEntity.status(200).body(new ApiRespoens("The MerchantStock Updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("The product id or the merchant id not found"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable String id){
        boolean isdelted = merchantStockService.deleteMerchantStock(id);
        if(isdelted){
            return  ResponseEntity.status(200).body(new ApiRespoens("The merchantStock deleted successfully "));
        }
        return ResponseEntity.status(400).body(new ApiRespoens("The id is not found"));
    }

}
