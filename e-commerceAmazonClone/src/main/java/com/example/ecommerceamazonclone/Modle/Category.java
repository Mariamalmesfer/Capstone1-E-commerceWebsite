package com.example.ecommerceamazonclone.Modle;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {

    @NotEmpty(message = "The categoryID must not be empty")
    private String id;


    @NotEmpty(message = "The name must not be empty")
    @Size(min = 4,message = "The name have to be more than 3 litters")
    private String name;


}

