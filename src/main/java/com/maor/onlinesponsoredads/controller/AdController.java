package com.maor.onlinesponsoredads.controller;

import com.maor.onlinesponsoredads.dto.ProductDto;
import com.maor.onlinesponsoredads.model.Campaign;
import com.maor.onlinesponsoredads.service.AdServiceImpl;
import com.maor.onlinesponsoredads.service.CampaignService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/ads")
public class AdController {

  private final CampaignService campaignService;
  private final AdServiceImpl adService;

  @GetMapping("{category}")
  public ResponseEntity<ProductDto> serveAd(@PathVariable String category) {
    Campaign campaign = campaignService.getValidTopCampaignByCategory(category);

    ProductDto productDto = adService.getProductByCategoryAndCampaign(
      category,
      campaign
    );

    return ResponseEntity.ok(productDto);
  }
}
