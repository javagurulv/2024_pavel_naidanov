package org.javaguru.travel.insurance.core;

import org.assertj.core.api.Assertions;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Date;
@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumServiceImplTest {
    @InjectMocks
    private TravelCalculatePremiumServiceImpl premiumService;

    @Mock
    private DateTimeService dateTimeService;

    @BeforeEach
    public void setUp(){
        Mockito.when(dateTimeService.calculateAgreementDurationInDays(new Date(1), new Date(1))).thenReturn(0L);
    }

    @Test
    public void should_populate_person_first_name() {
        var request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("John");
        
        var calculatePremiumResponse = premiumService.calculatePremium(request);

        Assertions.assertThat(calculatePremiumResponse.getPersonFirstName()).isEqualTo("John");
    }
   @Test
   public void should_populate_person_last_name() {
       var request = new TravelCalculatePremiumRequest();
       request.setPersonLastName("Doe");

       var calculatePremiumResponse = premiumService.calculatePremium(request);

       Assertions.assertThat(calculatePremiumResponse.getPersonLastName()).isEqualTo("Doe");
   }

    @Test
    public void should_populate_agreement_date_from() {
        var request = new TravelCalculatePremiumRequest();
        request.setAgreementDateFrom(new Date(1));

        var calculatePremiumResponse = premiumService.calculatePremium(request);

        Assertions.assertThat(calculatePremiumResponse.getAgreementDateFrom()).isEqualTo(new Date(1));
    }

    @Test
    public void should_populate_agreement_date_to() {
        var request = new TravelCalculatePremiumRequest();
        request.setAgreementDateTo(new Date(1));

        var calculate = premiumService.calculatePremium(request);

        Assertions.assertThat(calculate.getAgreementDateTo()).isEqualTo(new Date(1));
    }

    @Test
    public void should_populate_agreement_price() {
        var request = new TravelCalculatePremiumRequest();
        request.setAgreementDateFrom(new Date(1));
        request.setAgreementDateTo(new Date(1));

        var calculatePremiumResponse = premiumService.calculatePremium(request);

        Assertions.assertThat(calculatePremiumResponse.getAgreementPrice()).isEqualTo(new BigDecimal(0));
    }
}