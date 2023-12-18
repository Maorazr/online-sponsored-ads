package com.maor.onlinesponsoredads.repository;

import com.maor.onlinesponsoredads.model.Campaign;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
  List<Campaign> findCampaignsByStartDateGreaterThanAndProductsCategory(
    LocalDateTime localDateTime,
    String category
  );
}
