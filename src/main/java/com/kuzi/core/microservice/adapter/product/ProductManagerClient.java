package com.kuzi.core.microservice.adapter.product;

import com.kuzi.core.microservice.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(url = "${submanager.url}", name = "productManagerClient", decode404 = true)
public interface ProductManagerClient {

  @GetMapping(value = "/products/", consumes = APPLICATION_JSON_VALUE)
  ResponseEntity<List<Product>> getProducts();

  // test
}
