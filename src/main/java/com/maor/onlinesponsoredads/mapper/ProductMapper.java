package com.maor.onlinesponsoredads.mapper;

import com.maor.onlinesponsoredads.dto.ProductDto;
import com.maor.onlinesponsoredads.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  ProductDto productToDto(Product product);
  Product dtoToProduct(ProductDto dto);
}
