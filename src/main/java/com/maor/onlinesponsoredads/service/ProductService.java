package com.maor.onlinesponsoredads.service;

import com.maor.onlinesponsoredads.dto.ProductDto;
import java.util.Optional;

public interface ProductService {
  Optional<ProductDto> getPromotedProductByCategory(String category);
}
