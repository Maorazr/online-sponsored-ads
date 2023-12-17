package com.maor.onlinesponsoredads.repository;

import com.maor.onlinesponsoredads.model.Product;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByCampaignsStartDateLessThanEqualAndCategory(
    LocalDateTime date,
    String category
  );
}
