package com.maor.onlinesponsoredads.controller;

import com.maor.onlinesponsoredads.dto.ProductDto;
import com.maor.onlinesponsoredads.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/ads")
public class AdController {

  private ProductService productService;

  @GetMapping
  public ResponseEntity<ProductDto> serveAd(@RequestParam String category) {
    return productService
      .getPromotedProductByCategory(category)
      .map(ResponseEntity::ok)
      .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
