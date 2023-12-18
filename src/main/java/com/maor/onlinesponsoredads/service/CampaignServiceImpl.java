package com.maor.onlinesponsoredads.service;

import com.maor.onlinesponsoredads.dto.CampaignDto;
import com.maor.onlinesponsoredads.mapper.CampaignMapper;
import com.maor.onlinesponsoredads.model.Campaign;
import com.maor.onlinesponsoredads.model.Product;
import com.maor.onlinesponsoredads.repository.CampaignRepository;
import com.maor.onlinesponsoredads.repository.ProductRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CampaignServiceImpl implements CampaignService {

  @Autowired
  private CampaignRepository campaignRepository;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CampaignMapper campaignMapper;

  @Override
  @Transactional
  public CampaignDto createCampaign(CampaignDto campaignDto) {
    Campaign campaign = campaignMapper.dtoToCampaign(
      campaignDto,
      productRepository
    );

    if (
      campaignDto.getProductsSerialNumbers() != null &&
      !campaignDto.getProductsSerialNumbers().isEmpty()
    ) {
      List<Product> products = productRepository.findAllById(
        campaignDto.getProductsSerialNumbers()
      );
      campaign.setProducts(products);

      products.forEach(product -> {
        List<Campaign> campaigns = product.getCampaigns();
        if (!(campaigns instanceof ArrayList)) {
          campaigns = new ArrayList<>(campaigns);
          product.setCampaigns(campaigns);
        }
        campaigns.add(campaign);
      });
    }

    Campaign savedCampaign = campaignRepository.save(campaign);

    return campaignMapper.campaignToDto(savedCampaign, productRepository);
  }

  public Campaign getValidTopCampaignByCategory(String category) {
    LocalDateTime tenDaysAgo = LocalDateTime.now().minusDays(10);
    List<Campaign> activeCampaigns =
      campaignRepository.findCampaignsByStartDateGreaterThanAndProductsCategory(
        tenDaysAgo,
        category
      );
    return getCampaignWithHighestBid(activeCampaigns);
  }

  @Override
  public Campaign getCampaignWithHighestBid(List<Campaign> campaigns) {
    return campaigns
      .stream()
      .max(Comparator.comparing(Campaign::getBid))
      .orElse(null);
  }
}
