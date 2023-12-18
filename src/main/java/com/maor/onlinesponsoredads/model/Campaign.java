package com.maor.onlinesponsoredads.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "campaign")
public class Campaign {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private LocalDateTime startDate;

  @ManyToMany
  @JoinTable(
    name = "campaign_product",
    joinColumns = @JoinColumn(name = "campaign_id"),
    inverseJoinColumns = @JoinColumn(name = "serial_number")
  )
  private List<Product> products = new ArrayList<>();

  private double bid;
}
