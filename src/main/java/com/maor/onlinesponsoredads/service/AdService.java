package com.maor.onlinesponsoredads.service;

import com.maor.onlinesponsoredads.dto.ProductDto;
import com.maor.onlinesponsoredads.model.Campaign;

public interface AdService {
  public ProductDto getProductByCategoryAndCampaign(
    String category,
    Campaign campaign
  );
}
