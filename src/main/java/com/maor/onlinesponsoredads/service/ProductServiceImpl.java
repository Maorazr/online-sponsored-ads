package com.maor.onlinesponsoredads.service;

import com.maor.onlinesponsoredads.dto.ProductDto;
import com.maor.onlinesponsoredads.mapper.ProductMapper;
import com.maor.onlinesponsoredads.model.Campaign;
import com.maor.onlinesponsoredads.model.Product;
import com.maor.onlinesponsoredads.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductMapper productMapper;

  @Override
  public Optional<ProductDto> getPromotedProductByCategory(String category) {
    LocalDateTime activeSince = LocalDateTime.now().minusDays(10);

    List<Product> products =
      productRepository.findByCampaignsStartDateLessThanEqualAndCategory(
        activeSince,
        category
      );

    return products
      .stream()
      .max(Comparator.comparing(this::getHighestBidForProduct))
      .map(productMapper::productToDto);
  }

  private double getHighestBidForProduct(Product product) {
    return product
      .getCampaigns()
      .stream()
      .mapToDouble(Campaign::getBid)
      .max()
      .orElse(0);
  }
}
