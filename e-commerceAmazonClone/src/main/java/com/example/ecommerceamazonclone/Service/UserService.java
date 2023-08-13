package com.example.ecommerceamazonclone.Service;

import com.example.ecommerceamazonclone.Modle.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private MerchantStockService merchantStockService;

    @Autowired
    private ProductService productService;

    ArrayList<User> users = new ArrayList<>();

    ArrayList<Review> reviews = new ArrayList<>();





    public ArrayList<User> getallUsers() {
        return users;
    }

    public void addUsers(User user) {
        users.add(user);
    }


    public boolean updateUsers(String id, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }


    public boolean deleteUsers(String id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }


    public boolean buyProduct(String userId, String productId, String merchantId) {
        ArrayList<MerchantStock> merchantStocks = merchantStockService.getallMerchantStockS();
        for (int i = 0; i < users.size(); i++) {
            for (MerchantStock m : merchantStocks) {
                if (users.get(i).equals(userId) && m.getProductId().equals(productId) && m.getMerchantId().equals(merchantId)) {
                    return false;
                }
                if (m.getProductId().equals(productId) && m.getMerchantId().equals(merchantId) && m.getStock() > 0) {
                    m.setStock(m.getStock() - 1);
                    Integer priece = 0;
                    ArrayList<Product> products = productService.getallProducts();
                    for (Product p : products) {
                        if (m.getProductId().equals(p.getId())) {
                            priece = p.getPrice();
                            if (users.get(i).getBalance() < priece) {
                                return false;
                            }
                            users.get(i).setBalance(users.get(i).getBalance() - priece);
                            return true;
                        }
                    }

                }
            }
        }

        return false;
    }


    // Extra credit 1 A endpoint where the user can check the product price

    public Integer checkprice(String productId) {
        ArrayList<Product> products = productService.getallProducts();
        for (Product p : products) {
            if (p.getId().equals(productId)) {
                return p.getPrice();
            }
        }
   return 0; }


    // Extra credit 2 A endpoint where the user can add review to the product

    public boolean addProudctReview (String productId,String review){
        ArrayList<Product> products = productService.getallProducts();
        for (Product p : products) {
            if (p.getId().equals(productId)) {

                for (Review r: reviews){
                    if(r.getProdcutid().equals(productId)){
                        r.getReview().add(review);
                        r.setReview(r.getReview());
                        return true;
                    }
                }
                   ArrayList<String> com = new ArrayList<>();
                    com.add(review);
                    Review review1 = new Review(productId, com);
                    reviews.add(review1);
                    return true;


                }}
        return false;
    }

    // Extra credit 3 A endpoint where the user can get all  reviews to a single product
    public ArrayList<String> getProudctReview (String productId) {

        for (Review r : reviews) {
            if (r.getProdcutid().equals(productId)) {
                return r.getReview();
            }

        }
        return null;
    }















}