package org.javaguru.travel.insurance.core;

import org.assertj.core.api.Assertions;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateTimeServiceTest {
    private DateTimeService dateTimeService;
    @BeforeEach
    public void setUp() {
        dateTimeService = new DateTimeService();
    }
    @Test
    public void if_agreement_date_from_is_before_agreement_dateto_should_be_positive() {
        var date1 = new Date(2000, 1, 5);
        var date2 = new Date(2000, 1, 10);

        var result = dateTimeService.calculateAgreementDurationInDays(date1,date2);

        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    public void if_agreement_date_from_is_after_agreement_dateto_should_be_negative() {
        var date1 = new Date(2000, 1, 5);
        var date2 = new Date(2000, 1, 10);

        var result = dateTimeService.calculateAgreementDurationInDays(date2,date1);

        Assertions.assertThat(result).isEqualTo(-5);
    }

    @Test
    public void if_agreement_date_from_is_equal_to_agreement_dateto_should_be_zero() {
        var date1 = new Date(2000, 1, 5);
        var date2 = new Date(2000, 1, 5);

        var result = dateTimeService.calculateAgreementDurationInDays(date1,date2);

        Assertions.assertThat(result).isEqualTo(0);
    }
}
