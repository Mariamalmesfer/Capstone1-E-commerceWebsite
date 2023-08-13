package com.example.ecommerceamazonclone.Modle;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Product {

    @NotEmpty(message = "The id must not be empty")
    private String id;

    @NotEmpty(message = "The name must not be empty")
    @Size(min = 3,message = "The name have to be more than 3 litters")
    private String name;


    @NotNull(message = "The price must not be empty")
    @Positive(message = "The price must not be positive number")
    private Integer price;


    @NotEmpty(message = "The categoryID must not be empty")
    private String categoryID;




}
