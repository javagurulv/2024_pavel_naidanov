package org.javaguru.travel.insurance.core;

import org.assertj.core.api.Assertions;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Date;

class TravelCalculatePremiumServiceImplTest {
    private TravelCalculatePremiumServiceImpl premiumService;

    @BeforeEach
    public void setUp() {
        var dateTimeService = Mockito.mock(DateTimeService.class);
        premiumService = new TravelCalculatePremiumServiceImpl(dateTimeService);
    }

    @Test
    public void should_populate_person_first_name() {

        var request = new TravelCalculatePremiumRequest("John", "Doe", new Date(1), new Date(1));
        var expected = new TravelCalculatePremiumResponse( "John", "Doe", new Date(1), new Date(1), new BigDecimal(1));
        
        var calculatePremiumResponse = premiumService.calculatePremium(request);

        Assertions.assertThat(calculatePremiumResponse.getPersonFirstName()).isEqualTo(expected.getPersonFirstName());
    }

    @Test
    public void should_populate_person_last_name() {
        var request = new TravelCalculatePremiumRequest("John", "Doe", new Date(1), new Date(1));
        var expected = new TravelCalculatePremiumResponse("John", "Doe", new Date(1), new Date(1), new BigDecimal(1));

        var calculatePremiumResponse = premiumService.calculatePremium(request);

        Assertions.assertThat(calculatePremiumResponse.getPersonLastName()).isEqualTo(expected.getPersonLastName());
    }

    @Test
    public void should_populate_agreement_date_from() {
        var request = new TravelCalculatePremiumRequest("John", "Doe", new Date(1), new Date(1));
        var expected = new TravelCalculatePremiumResponse("John", "Doe", new Date(1), new Date(1), new BigDecimal(1));

        var calculatePremiumResponse = premiumService.calculatePremium(request);

        Assertions.assertThat(calculatePremiumResponse.getAgreementDateFrom()).isEqualTo(expected.getAgreementDateFrom());
    }

    @Test
    public void should_populate_agreement_date_to() {
        var request = new TravelCalculatePremiumRequest("John", "Doe", new Date(1), new Date(1));
        var expected = new TravelCalculatePremiumResponse("John", "Doe", new Date(1), new Date(1), new BigDecimal(1));

        var calculatePremiumResponse = premiumService.calculatePremium(request);

        Assertions.assertThat(calculatePremiumResponse.getAgreementDateTo()).isEqualTo(expected.getAgreementDateTo());
    }
}