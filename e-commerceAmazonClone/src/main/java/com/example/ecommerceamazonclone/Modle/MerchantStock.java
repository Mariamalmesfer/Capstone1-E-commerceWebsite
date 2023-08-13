package com.example.ecommerceamazonclone.Modle;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {

    @NotEmpty(message = "The id must not be empty")
    private String id;

    @NotEmpty(message = "The product id must not be empty")
    private String productId;


    @NotEmpty(message = "The Merchant id must not be empty")
    private String merchantId;

    @NotNull(message = "The stock must not be empty")
    @Min(value = 10 ,message ="The stock must at least 10  " )
    private Integer stock;
}
