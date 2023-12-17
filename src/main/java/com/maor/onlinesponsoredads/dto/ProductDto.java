package com.maor.onlinesponsoredads.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

  @NotNull
  private String title;

  @NotNull
  private String category;

  private double price;
}
