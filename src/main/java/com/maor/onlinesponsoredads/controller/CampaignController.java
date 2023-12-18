package com.maor.onlinesponsoredads.controller;

import com.maor.onlinesponsoredads.dto.CampaignDto;
import com.maor.onlinesponsoredads.service.CampaignService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/campaigns")
public class CampaignController {

  private CampaignService campaignService;

  @PostMapping
  public ResponseEntity<CampaignDto> createCampaign(
    @RequestBody CampaignDto campaignDto
  ) {
    return new ResponseEntity<>(
      campaignService.createCampaign(campaignDto),
      HttpStatus.CREATED
    );
  }
}
