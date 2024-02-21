package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import static org.javaguru.travel.insurance.core.DateTimeService.calculateAgreementDurationInDays;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        var daysBetween = calculateAgreementDurationInDays(request);
        return new TravelCalculatePremiumResponse(request.getPersonFirstName(), request.getPersonLastName(), request.getAgreementDateFrom(), request.getAgreementDateTo(), new BigDecimal(daysBetween));
    }
}
