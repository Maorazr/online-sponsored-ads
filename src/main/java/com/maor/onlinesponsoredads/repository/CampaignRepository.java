package com.maor.onlinesponsoredads.repository;

import com.maor.onlinesponsoredads.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {}
