package com.example.ecommerceamazonclone.Service;

import com.example.ecommerceamazonclone.Modle.Category;
import com.example.ecommerceamazonclone.Modle.Merchant;
import com.example.ecommerceamazonclone.Modle.MerchantStock;
import com.example.ecommerceamazonclone.Modle.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {

    @Autowired
    MerchantStockService merchantStockService ;

    ArrayList<Merchant> merchants = new ArrayList<>();


    public ArrayList<Merchant> getMerchant() {
        return merchants;
    }

    public void addMerchant(Merchant merchant ) {
        merchants.add(merchant);
    }


    public boolean updateMerchant(String id,Merchant merchant) {
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId().equals(id)) {
                merchants.set(i, merchant);
                return true;
            }
        }
        return false;
    }


    public boolean deleteMerchant(String id) {
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId().equals(id)) {
                merchants.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean addStock(String proudctId, String merchantId, int stock) {
        ArrayList<MerchantStock> merchantStock = merchantStockService.getallMerchantStockS();
        for (int i = 0; i < merchants.size(); i++) {
                for (MerchantStock m: merchantStock){
                    if (merchants.get(i).getId().equals(merchantId) && m.getMerchantId().equals(merchantId)  && m.getProductId().equals(proudctId)){
                           m.setStock(m.getStock()+ stock);
                            return true;
                    }
                }
            }

        return false;
    }




//    public boolean addStock2(String proudctId, String merchantId, int stock) {
//
//        ArrayList<MerchantStock> merchantStock = merchantStockService.getallMerchantStockS();
//
//        for (int i = 0; i < merchants.size(); i++) {
//            if (!merchants.get(i).getId().equals(merchantId)){
//                break;
//            }
//            for (MerchantStock m: merchantStock){
//                if (m.getMerchantId().equals(merchantId) && m.getProductId().equals(proudctId)){
//                    m.setStock(m.getStock()+ stock);
//                    return true;
//            }
//        }} return false;}















}
