package com.maor.onlinesponsoredads.service;

import com.maor.onlinesponsoredads.dto.CampaignDto;
import com.maor.onlinesponsoredads.model.Campaign;
import java.util.List;

public interface CampaignService {
  CampaignDto createCampaign(CampaignDto campaignDto);
  Campaign getValidTopCampaignByCategory(String category);
  Campaign getCampaignWithHighestBid(List<Campaign> campaigns);
}
