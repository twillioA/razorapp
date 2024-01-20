package com.razorpayment1.razorpay1.app.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import com.razorpayment1.razorpay1.app.payload.OrderRequest;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//http://localhost:8080/api/create-order
@RestController
@RequestMapping("/api")
public class PaymentController {
    @RequestMapping("/create-order")
    public String createOrder(@RequestBody OrderRequest order) throws RazorpayException {
        RazorpayClient razorpay = new RazorpayClient("rzp_test_lTkPHkHb5848u7", "dUwCVH81tla1NXQvBTIfKulY");

        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount",order.getAmount()*100);
        orderRequest.put("currency","INR");
        orderRequest.put("receipt", "receipt#1");
        JSONObject notes = new JSONObject();
        notes.put("notes_key_1", "Tea, Earl Grey, Hot");
        notes.put("notes_key_1", "Tea, Earl Grey, Hot");


        orderRequest.put("notes",notes);

        Order orderResponse = razorpay.orders.create(orderRequest);

        return orderResponse.get("id").toString();

    }
}


