package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelCalculatePremiumServiceImplAIOneTest {


    @Test
    public void calculatePremium_shouldSetValuesCorrectly() {
        // Arrange
        TravelCalculatePremiumServiceImpl premiumService = new TravelCalculatePremiumServiceImpl();
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
