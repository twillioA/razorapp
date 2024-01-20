package com.razorpayment1.razorpay1.app.payload;

import lombok.Data;

@Data
public class OrderRequest {

    private long amount;
    private String currency;

}


