package com.maor.onlinesponsoredads.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

  @NotBlank
  private String title;

  @NotBlank
  private String category;

  private double price;
}
