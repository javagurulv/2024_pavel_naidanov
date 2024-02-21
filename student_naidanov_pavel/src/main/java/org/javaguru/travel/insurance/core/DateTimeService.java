package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;

import java.util.concurrent.TimeUnit;

public class DateTimeService {
    private DateTimeService() {

    }
    static long calculateAgreementDurationInDays(TravelCalculatePremiumRequest request) {
        var difference = request.getAgreementDateTo().getTime() - request.getAgreementDateFrom().getTime();
        return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
    }
}
