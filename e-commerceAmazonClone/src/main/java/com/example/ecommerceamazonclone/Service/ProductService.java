package com.example.ecommerceamazonclone.Service;

import com.example.ecommerceamazonclone.ApiRespoens.ApiRespoens;
import com.example.ecommerceamazonclone.Modle.Category;
import com.example.ecommerceamazonclone.Modle.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Service
public class ProductService  {


    @Autowired
    private CategoryService categoryService ;


    ArrayList<Product> products = new ArrayList<>();


    public ArrayList<Product> getallProducts(){
        return products;
    }

    public boolean addProducts(Product product){
        ArrayList<Category> categories = categoryService.getCategories();
        for (Category c : categories){
            if(product.getCategoryID().equals(c.getId())) {
                products.add(product);
                return true;
            }
        }
        return false;
    }


    public boolean updateProducts(String id, Product product) {
        ArrayList<Category> categories = categoryService.getCategories();
        boolean st=false;

        for (int i = 0; i < products.size(); i++) {
            for (Category c : categories){
                if (products.get(i).getId().equals(id) && product.getCategoryID().equals(c.getId())) {
                    products.set(i, product);
                    st= true;}}
                   // products.add(product);
        }return st;
    }


    public boolean deleteProducts(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)){
                products.remove(i);
                return true;
            }
        }
        return false;
    }



}
