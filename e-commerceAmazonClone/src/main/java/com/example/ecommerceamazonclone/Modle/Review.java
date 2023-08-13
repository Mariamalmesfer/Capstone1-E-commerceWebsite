package com.example.ecommerceamazonclone.Modle;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Review {

    @NotEmpty
    private String prodcutid;
    @NotEmpty
    private ArrayList<String> review;
}
