package com.example.ecommerceamazonclone.Service;

import com.example.ecommerceamazonclone.Modle.Category;
import com.example.ecommerceamazonclone.Modle.Merchant;
import com.example.ecommerceamazonclone.Modle.MerchantStock;
import com.example.ecommerceamazonclone.Modle.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {

    @Autowired
    private ProductService productService  ;

    @Autowired
    private MerchantService merchantService  ;

    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getallMerchantStockS(){
        return merchantStocks;
    }


    public boolean addMerchantStock(MerchantStock merchantStock){
        ArrayList<Product> products = productService.getallProducts();
        ArrayList<Merchant> merchants = merchantService.getMerchant();
        for (Product p : products){
            for (Merchant m:merchants){
                if(merchantStock.getProductId().equals(p.getId()) && merchantStock.getMerchantId().equals(m.getId())) {
                    merchantStocks.add(merchantStock);
                    return true;
                }
            }
        }
        return false;
    }



    public boolean updateMerchantStock(String id, MerchantStock merchantStock) {
        ArrayList<Product> products = productService.getallProducts();
        ArrayList<Merchant> merchants = merchantService.getMerchant();

        for (int i = 0; i < merchantStocks.size(); i++) {
            for (Product p : products){
                for (Merchant m:merchants){
                    if (merchantStocks.get(i).getId().equals(id) && merchantStock.getProductId().equals(p.getId()) && merchantStock.getMerchantId().equals(m.getId())){
                        merchantStocks.set(i,merchantStock);
                        return true;
                    }
                }
                }
                }
        return false;
    }



    public boolean deleteMerchantStock(String id) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId().equals(id)){
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }







}
