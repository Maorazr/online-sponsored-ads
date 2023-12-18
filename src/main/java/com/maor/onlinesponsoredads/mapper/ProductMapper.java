package com.maor.onlinesponsoredads.mapper;

import com.maor.onlinesponsoredads.dto.ProductDto;
import com.maor.onlinesponsoredads.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
  ProductDto productToDto(Product product);

  @Mapping(target = "campaigns", ignore = true)
  @Mapping(target = "serialNumber", ignore = true)
  Product dtoToProduct(ProductDto productDto);

  default Long mapProductToLong(Product product) {
    System.out.println(product.getSerialNumber());
    return product.getSerialNumber();
  }
}
