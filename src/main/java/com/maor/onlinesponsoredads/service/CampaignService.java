package com.maor.onlinesponsoredads.service;

import com.maor.onlinesponsoredads.dto.CampaignDto;
import com.maor.onlinesponsoredads.model.Campaign;

public interface CampaignService {
  Campaign createCampaign(CampaignDto campaignDto);
}
