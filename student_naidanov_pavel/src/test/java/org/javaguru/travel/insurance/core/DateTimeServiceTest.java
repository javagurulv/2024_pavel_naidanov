package org.javaguru.travel.insurance.core;

import org.assertj.core.api.Assertions;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateTimeServiceTest {
    @Test
    public void if_agreement_date_from_is_before_agreement_dateto_should_be_positive() {
        var result = DateTimeService.calculateAgreementDurationInDays(new TravelCalculatePremiumRequest("John", "Doe", new Date(2000, 1, 5), new Date(2000, 1, 10)));

        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    public void if_agreement_date_from_is_after_agreement_dateto_should_be_negative() {
        var result = DateTimeService.calculateAgreementDurationInDays(new TravelCalculatePremiumRequest("John", "Doe", new Date(2000, 1, 10), new Date(2000, 1, 5)));

        Assertions.assertThat(result).isEqualTo(-5);
    }

    @Test
    public void if_agreement_date_from_is_equal_to_agreement_dateto_should_be_zero() {
        var result = DateTimeService.calculateAgreementDurationInDays(new TravelCalculatePremiumRequest("John", "Doe", new Date(2000, 1, 10), new Date(2000, 1, 10)));

        Assertions.assertThat(result).isEqualTo(0);
    }
}
