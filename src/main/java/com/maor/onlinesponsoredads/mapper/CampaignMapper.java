package com.maor.onlinesponsoredads.mapper;

import com.maor.onlinesponsoredads.dto.CampaignDto;
import com.maor.onlinesponsoredads.model.Campaign;
import com.maor.onlinesponsoredads.model.Product;
import com.maor.onlinesponsoredads.repository.ProductRepository;
import java.util.List;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface CampaignMapper {
  @Mapping(source = "products", target = "productsSerialNumbers")
  CampaignDto campaignToDto(
    Campaign campaign,
    @Context ProductRepository productRepository
  );

  @Mapping(source = "productsSerialNumbers", target = "products")
  @Mapping(target = "id", ignore = true)
  Campaign dtoToCampaign(
    CampaignDto campaignDto,
    @Context ProductRepository productRepository
  );

  default List<Product> mapListOfSerialToProducts(
    List<Long> serials,
    @Context ProductRepository productRepository
  ) {
    if (serials == null) {
      return null;
    }
    return productRepository.findAllById(serials);
  }

  default Product mapSerialNumberToProduct(
    Long serialNumber,
    @Context ProductRepository productRepository
  ) {
    if (serialNumber == null) {
      return null;
    }
    return productRepository.findById(serialNumber).orElse(null);
  }
}
