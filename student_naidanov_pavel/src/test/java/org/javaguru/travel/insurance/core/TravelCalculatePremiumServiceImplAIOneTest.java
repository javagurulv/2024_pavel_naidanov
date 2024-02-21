package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelCalculatePremiumServiceImplAIOneTest {
    private DateTimeService dateTimeService;
    private TravelCalculatePremiumServiceImpl premiumService;

    @BeforeEach
    public void setUp() {
        premiumService = new TravelCalculatePremiumServiceImpl(dateTimeService);
    }


    @Test
    public void calculatePremium_shouldSetValuesCorrectly() {
        // Arrange
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("John", "Doe", new Date(1), new Date(1));

        // Act
        TravelCalculatePremiumResponse response = premiumService.calculatePremium(request);

        // Assert
        assertEquals("John", response.getPersonFirstName());
        assertEquals("Doe", response.getPersonLastName());
        assertEquals(new Date(1), response.getAgreementDateFrom());
        assertEquals(new Date(1), response.getAgreementDateTo());
    }


}
