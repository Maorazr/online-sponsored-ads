package com.maor.onlinesponsoredads.service;

import com.maor.onlinesponsoredads.dto.CampaignDto;
import com.maor.onlinesponsoredads.mapper.CampaignMapper;
import com.maor.onlinesponsoredads.model.Campaign;
import com.maor.onlinesponsoredads.model.Product;
import com.maor.onlinesponsoredads.repository.CampaignRepository;
import com.maor.onlinesponsoredads.repository.ProductRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class CampaignServiceImpl implements CampaignService {

  private CampaignRepository campaignRepository;
  private ProductRepository productRepository;
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
      products.forEach(product -> product.getCampaigns().add(campaign));
    }

    Campaign savedCampaign = campaignRepository.save(campaign);

    return campaignMapper.campaignToDto(savedCampaign, productRepository);
  }
}
