package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TravelCalculatePremiumServiceImplAIOneTest {
    @Mock
    private DateTimeService dateTimeService;
    @InjectMocks
    private TravelCalculatePremiumServiceImpl premiumService;
    @BeforeEach
    public void setUp() {
        when(dateTimeService.calculateAgreementDurationInDays(new Date(1), new Date(1))).thenReturn(0L);
    }

    @Test
    public void calculate_premium_should_set_values_correctly() {
        // Arrange
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("John", "Doe", new Date(1), new Date(1));

        // Act
        TravelCalculatePremiumResponse response = premiumService.calculatePremium(request);

        // Assert
        assertEquals("John", response.getPersonFirstName());
        assertEquals("Doe", response.getPersonLastName());
        assertEquals(new Date(1), response.getAgreementDateFrom());
        assertEquals(new Date(1), response.getAgreementDateTo());
        assertEquals(new BigDecimal(0), response.getAgreementPrice());
    }


}
