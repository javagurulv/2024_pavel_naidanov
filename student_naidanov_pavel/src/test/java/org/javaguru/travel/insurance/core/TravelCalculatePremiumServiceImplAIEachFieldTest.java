package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TravelCalculatePremiumServiceImplAIEachFieldTest {
    @Mock private DateTimeService dateTimeService;
    @InjectMocks private TravelCalculatePremiumServiceImpl premiumService;

    private TravelCalculatePremiumRequest request;

    @BeforeEach
    public void setUp() {
        request=createAllFields();
        when(dateTimeService.calculateAgreementDurationInDays(request.getAgreementDateTo(),request.getAgreementDateFrom())).thenReturn(0L);
    }

    private TravelCalculatePremiumRequest createAllFields() {
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("John");
        request.setPersonLastName("Doe");
        request.setAgreementDateFrom(toDate("2024-01-01"));
        request.setAgreementDateTo(toDate("2024-01-01"));
        return request;
    }


    @Test
    public void calculate_premium_should_set_person_first_name_correctly(){
        // Act
        TravelCalculatePremiumResponse response = premiumService.calculatePremium(request);

        // Assert
        assertEquals("John", response.getPersonFirstName());
    }

    @Test
    public void calculate_premium_should_set_person_last_name_correctly() {
        // Act
        TravelCalculatePremiumResponse response = premiumService.calculatePremium(request);

        // Assert
        assertEquals("Doe", response.getPersonLastName());
    }

    @Test
    public void calculate_premium_should_set_agreement_date_from_correctly() {
        // Act
        TravelCalculatePremiumResponse response = premiumService.calculatePremium(request);

        // Assert
        assertEquals(toDate("2024-01-01"), response.getAgreementDateFrom());
    }

    @Test
    public void calculate_premiumshould_set_agreement_date_to_correctly() {
        // Act
        TravelCalculatePremiumResponse response = premiumService.calculatePremium(request);

        // Assert
        assertEquals(toDate("2024-01-01"), response.getAgreementDateTo());
    }

    @Test
    public void should_calculate_agreement_price_correctly() {
        TravelCalculatePremiumResponse response = premiumService.calculatePremium(request);

        assertEquals(response.getAgreementPrice(), new BigDecimal(0));
    }

    public static Date toDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}