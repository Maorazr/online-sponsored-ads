package com.maor.onlinesponsoredads.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import com.maor.onlinesponsoredads.dto.CampaignDto;
import com.maor.onlinesponsoredads.mapper.CampaignMapper;
import com.maor.onlinesponsoredads.model.Campaign;
import com.maor.onlinesponsoredads.model.Product;
import com.maor.onlinesponsoredads.repository.CampaignRepository;
import com.maor.onlinesponsoredads.repository.ProductRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@Transactional
@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CampaignServiceImplTest {

  @Autowired
  private CampaignRepository campaignRepository;

  @Autowired
  private ProductRepository productRepository;

  @Mock
  private CampaignMapper campaignMapper;

  @Autowired
  @InjectMocks
  private CampaignServiceImpl campaignService;

  private Product product;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this); // Initialize annotated mocks
    campaignRepository.deleteAll();
    productRepository.deleteAll();

    product =
      new Product(
        "Test Product",
        "Test Category",
        100.0,
        1L,
        new ArrayList<>()
      );
    productRepository.save(product);
  }

  @AfterEach
  public void tearDown() {
    campaignRepository.deleteAll();
    productRepository.deleteAll();
  }

  @Test
  void testCreateCampaign() {
    Campaign campaign = new Campaign(
      1L,
      "Test Campaign",
      LocalDateTime.now(ZoneOffset.UTC),
      new ArrayList<>(List.of(product)),
      50.0
    );
    CampaignDto campaignDto = new CampaignDto(
      "Test Campaign",
      LocalDateTime.now(ZoneOffset.UTC),
      List.of(2L),
      50.0
    );
    when(
      campaignMapper.dtoToCampaign(
        any(CampaignDto.class),
        eq(productRepository)
      )
    )
      .thenReturn(campaign);

    CampaignDto result = campaignService.createCampaign(campaignDto);

    assertNotNull(result);
    assertEquals("Test Campaign", result.getName());
  }
}
