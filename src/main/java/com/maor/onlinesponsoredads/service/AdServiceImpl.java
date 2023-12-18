package com.maor.onlinesponsoredads.service;

import com.maor.onlinesponsoredads.dto.ProductDto;
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
    Product product = productRepository.getFirstByCategoryAndCampaigns(
      category,
      campaign
    );
    return productMapper.productToDto(product);
  }
}
