package com.example.ecommerceamazonclone.Modle;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Merchant {

    @NotEmpty(message = "The categoryID must not be empty")
    private String id;


    @NotEmpty(message = "The name must not be empty")
    @Size(min = 3,message = "The name have to be more than 3 litters")
    private String name;
}
