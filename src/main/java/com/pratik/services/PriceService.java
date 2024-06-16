package com.pratik.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PriceService {

    @Autowired
    private RestTemplate restTemplate;

    public Double getCurrentPrice() {
        String url = "https://fakestoreapi.com/products/1";
        PriceResponse response = restTemplate.getForObject(url, PriceResponse.class);

        if(response != null){
            System.out.println(response.getPrice());
            return response.getPrice();

        }
        return null;
    }

    private static class PriceResponse {
        private Double price;

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }
}
