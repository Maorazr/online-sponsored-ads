package com.maor.onlinesponsoredads.service;

import com.maor.onlinesponsoredads.dto.ProductDto;
import java.util.List;

public interface ProductService {
  ProductDto addProduct(ProductDto productDto);
  ProductDto getProductBySerialNumber(Long serialNumber);
  List<ProductDto> getAllProducts();
}
