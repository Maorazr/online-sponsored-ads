package com.maor.onlinesponsoredads.service;

import com.maor.onlinesponsoredads.dto.ProductDto;
import com.maor.onlinesponsoredads.exceptions.CategoryNotFoundException;
import com.maor.onlinesponsoredads.exceptions.ResourceNotFoundException;
import com.maor.onlinesponsoredads.mapper.ProductMapper;
import com.maor.onlinesponsoredads.model.Campaign;
import com.maor.onlinesponsoredads.model.Product;
import com.maor.onlinesponsoredads.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AdServiceImpl implements AdService {

  private ProductRepository productRepository;
  private ProductMapper productMapper;

  public ProductDto getProductByCategoryAndCampaign(
    String category,
    Campaign campaign
  ) {
    if (category == null || category.trim().isEmpty()) {
      throw new IllegalArgumentException(
        "Category is required and cannot be empty."
      );
    }

    if (!productRepository.existsByCategory(category)) {
      throw new CategoryNotFoundException("Category not found: " + category);
    }

    if (campaign == null) {
      throw new ResourceNotFoundException(
        "No active campaign found for category: " + category
      );
    }
    Product product = productRepository.getFirstByCategoryAndCampaigns(
      category,
      campaign
    );
    if (product == null) {
      throw new ResourceNotFoundException(
        "Product not found for category: " + category
      );
    }
    return productMapper.productToDto(product);
  }
}
