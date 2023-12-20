package com.maor.onlinesponsoredads.service;

import com.maor.onlinesponsoredads.dto.ProductDto;
import com.maor.onlinesponsoredads.exceptions.ResourceNotFoundException;
import com.maor.onlinesponsoredads.mapper.ProductMapper;
import com.maor.onlinesponsoredads.model.Campaign;
import com.maor.onlinesponsoredads.model.Product;
import com.maor.onlinesponsoredads.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class ProductServiceImpl implements ProductService {

  private ProductDto productDto;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductMapper productMapper;

  @Override
  public ProductDto addProduct(ProductDto productDto) {
    Product product = productMapper.dtoToProduct(productDto);
    Product savedProduct = productRepository.save(product);
    return productMapper.productToDto(savedProduct);
  }

  @Override
  public ProductDto getProductBySerialNumber(Long serialNumber) {
    Product product = productRepository
      .findById(serialNumber)
      .orElseThrow(() ->
        new ResourceNotFoundException(
          "Product not found for serial number: " + serialNumber
        )
      );
    return productMapper.productToDto(product);
  }

  @Override
  public List<ProductDto> getAllProducts() {
    List<Product> products = productRepository.findAll();
    return products
      .stream()
      .map(productMapper::productToDto)
      .collect(Collectors.toList());
  }
}
