package com.hps.customers_experience.controller;

import com.hps.customers_experience.dto.ProductInsightDto;
import com.hps.customers_experience.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/product", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController {


    private final IProductService productInsightService;

    @Autowired
    public ProductController(IProductService productInsightService) {
        this.productInsightService = productInsightService;
    }

    @GetMapping("/insights")
    public List<ProductInsightDto> getAllProductInsights() {
        return productInsightService.getAllProductInsights();
    }
}