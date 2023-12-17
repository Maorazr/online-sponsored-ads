package com.maor.onlinesponsoredads.dto;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampaignDto {

  @NotBlank
  private String name;

  @NotNull
  @FutureOrPresent
  private LocalDateTime startDate;

  @NotNull
  private List<Long> productsSerialNumbers;

  private double bid;
}
