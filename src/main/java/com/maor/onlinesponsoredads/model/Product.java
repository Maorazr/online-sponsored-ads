package com.maor.onlinesponsoredads.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

  private String title;
  private String category;
  private double price;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long serialNumber;

  @ManyToMany(mappedBy = "products")
  private List<Campaign> campaigns = new ArrayList<>();
}
