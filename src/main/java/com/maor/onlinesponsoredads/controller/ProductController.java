package com.maor.onlinesponsoredads.controller;

import com.maor.onlinesponsoredads.dto.ProductDto;
import com.maor.onlinesponsoredads.service.ProductService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  @PostMapping
  public ResponseEntity<ProductDto> addProduct(
    @RequestBody ProductDto productDto
  ) {
    ProductDto savedProduct = productService.addProduct(productDto);
    return new ResponseEntity<ProductDto>(savedProduct, HttpStatus.OK);
  }

  @GetMapping("/{serialNumber}")
  public ResponseEntity<ProductDto> getProductBySerialNumber(
    @PathVariable Long serialNumber
  ) {
    ProductDto productDto = productService.getProductBySerialNumber(
      serialNumber
    );
    return ResponseEntity.ok(productDto);
  }

  @GetMapping("/all")
  public ResponseEntity<List<ProductDto>> getAllProducts() {
    List<ProductDto> products = productService.getAllProducts();
    return ResponseEntity.ok(products);
  }
}
