package com.maor.onlinesponsoredads.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampaignDto {

  private String name;
  private LocalDateTime startDate;
  private List<Long> productIds;
  private double bid;
}
