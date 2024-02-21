package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Component
public class DateTimeService {
    DateTimeService() {

    }
    static long calculateAgreementDurationInDays(TravelCalculatePremiumRequest request) {
        var difference = request.getAgreementDateTo().getTime() - request.getAgreementDateFrom().getTime();
        return TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
    }
}
