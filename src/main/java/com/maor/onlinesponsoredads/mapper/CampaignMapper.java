package com.maor.onlinesponsoredads.mapper;

import com.maor.onlinesponsoredads.dto.CampaignDto;
import com.maor.onlinesponsoredads.model.Campaign;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CampaignMapper {
  @Mapping(target = "productsSerialNumbers", source = "products")
  CampaignDto campaignToDto(Campaign campaign);

  @Mapping(target = "products", source = "productsSerialNumbers")
  Campaign dtoToCampaign(CampaignDto dto);
}
