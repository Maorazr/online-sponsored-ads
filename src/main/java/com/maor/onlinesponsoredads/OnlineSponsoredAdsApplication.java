package com.maor.onlinesponsoredads;

import com.maor.onlinesponsoredads.model.Campaign;
import com.maor.onlinesponsoredads.model.Product;
import com.maor.onlinesponsoredads.repository.CampaignRepository;
import com.maor.onlinesponsoredads.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineSponsoredAdsApplication {

  public static void main(String[] args) {
    SpringApplication.run(OnlineSponsoredAdsApplication.class, args);
  }

  @Bean
  CommandLineRunner initDatabase(
    ProductRepository productRepository,
    CampaignRepository campaignRepository
  ) {
    return args -> {
      Product product1 = new Product(
        "Product 1",
        "Electronics",
        299.99,
        null,
        new ArrayList<>()
      );

      Product product2 = new Product(
        "Product 2",
        "Electronics",
        59.99,
        null,
        new ArrayList<>()
      );

      Product product3 = new Product(
        "Product 3",
        "PetSupply",
        59.99,
        null,
        new ArrayList<>()
      );

      product1 = productRepository.save(product1);
      product2 = productRepository.save(product2);
      product3 = productRepository.save(product3);

      Campaign campaign1 = new Campaign(
        null,
        "Summer Sale",
        LocalDateTime.now(),
        new ArrayList<>(),
        0.10
      );

      Campaign campaign2 = new Campaign(
        null,
        "Summer Sale",
        LocalDateTime.now(),
        new ArrayList<>(),
        0.
      );

      campaign1.getProducts().add(product1);
      campaign2.getProducts().add(product2);
      campaign2.getProducts().add(product3);
      campaignRepository.save(campaign1);
      campaignRepository.save(campaign2);

      product1.setCampaigns(
        new ArrayList<>(Collections.singletonList(campaign1))
      );
      productRepository.save(product1);
    };
  }
}
