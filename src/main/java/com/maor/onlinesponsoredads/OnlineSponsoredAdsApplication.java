package com.maor.onlinesponsoredads;

import com.maor.onlinesponsoredads.model.Campaign;
import com.maor.onlinesponsoredads.model.Product;
import com.maor.onlinesponsoredads.repository.CampaignRepository;
import com.maor.onlinesponsoredads.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
      List<String> categories = List.of(
        "Electronics",
        "Fashion",
        "Home Decor",
        "Sports",
        "Books"
      );

      List<Product> savedProducts = new ArrayList<>();

      for (int i = 1; i <= 20; i++) {
        String category = categories.get((i - 1) % categories.size());
        Product product = new Product(
          "Product " + i,
          category,
          i * 10.0,
          null,
          new ArrayList<>()
        );
        savedProducts.add(productRepository.save(product));
      }

      Campaign campaign1 = new Campaign(
        null,
        "Summer Sale",
        LocalDateTime.now(),
        new ArrayList<>(),
        0.10
      );

      Campaign campaign2 = new Campaign(
        null,
        "Winter Collection",
        LocalDateTime.now(),
        new ArrayList<>(),
        0.2
      );

      Campaign campaign3 = new Campaign(
        null,
        "Winter Sale",
        LocalDateTime.now(),
        new ArrayList<>(),
        0.3
      );

      for (Product product : savedProducts) {
        if (product.getSerialNumber() % 2 == 0) {
          campaign1.getProducts().add(product);
          product.getCampaigns().add(campaign1);
        } else if (product.getSerialNumber() % 3 == 0) {
          campaign3.getProducts().add(product);
          product.getCampaigns().add(campaign3);
        } else {
          campaign2.getProducts().add(product);
          product.getCampaigns().add(campaign2);
        }
      }

      campaignRepository.save(campaign1);
      campaignRepository.save(campaign2);
      campaignRepository.save(campaign3);

      for (Product product : savedProducts) {
        productRepository.save(product);
      }
    };
  }
}
