package com.kuzi.core.microservice.adapter.product;

import com.kuzi.core.microservice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class ProductManager {
  private ProductManagerClient productManagerClient;
  public List<Product> getProducts() {
    try {
      ResponseEntity<List<Product>> products = productManagerClient.getProducts();
      return products.getBody();
    } catch (Exception ex) {
      log.error(ex.getMessage());
    }
    return null;
  }
}
