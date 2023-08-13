package com.example.ecommerceamazonclone.Modle;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    @NotEmpty(message = "The id must not be empty")
    private String id;

    @NotEmpty(message = "The id must not be empty")
    @Size(min=5,message = "The username have to be more than 5 litters")
    private String username;

    @NotEmpty(message = "The password must not be empty")
    @Size(min=6,message = "The password have to be more than 5 Char")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-zA-Z]).{6,}$" , message = "the password must have at least 1 number, 1 letter (upper or lower case) and min 6 char")
    private String password;

    @Email
    @NotEmpty(message = "The email must not be empty")
    private String email;

    @NotEmpty(message = "The email must not be empty")
    @Pattern(regexp ="^(Admin|Customer)$", message = "The Role should be Admin or Customer")
    private String role;

    @NotNull(message = "The balance must not be empty")
    @Positive
    private int balance;

}
