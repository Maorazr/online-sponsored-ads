package com.maor.onlinesponsoredads.dto;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampaignDto {

  @NotNull
  private String name;

  @NotNull
  private LocalDateTime startDate;

  @NotNull
  private List<Long> productsSerialNumbers;

  private double bid;
}
