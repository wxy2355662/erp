package com.mar.erp.purchase.vo;

import com.mar.erp.purchase.model.Purchase;
import com.mar.erp.purchase.model.PurchaseDetails;

import java.util.Date;
import java.util.List;

public class PurchaseVo extends Purchase {


    private String min;
    private String max;

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    private List<PurchaseDetails> plist;





}
