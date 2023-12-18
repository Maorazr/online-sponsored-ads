package com.maor.onlinesponsoredads.repository;

import com.maor.onlinesponsoredads.model.Campaign;
import com.maor.onlinesponsoredads.model.Product;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  Product getFirstByCategoryAndCampaigns(String category, Campaign campaign);

  List<Product> findByCampaignsStartDateLessThanEqualAndCategory(
    LocalDateTime date,
    String category
  );
  boolean existsByCategory(String category);
}
