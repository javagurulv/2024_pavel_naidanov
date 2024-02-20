package org.javaguru.travel.insurance.core;

import org.assertj.core.api.Assertions;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

class TravelCalculatePremiumServiceImplTest {

    @Test
    public void deleteMe() {
        var travel = new TravelCalculatePremiumServiceImpl();
        var request = new TravelCalculatePremiumRequest("John", "Doe", new Date(1), new Date(1));
        var expected = new TravelCalculatePremiumResponse( "John", "Doe", new Date(1), new Date(1));
        
        var calculatePremiumResponse = travel.calculatePremium(request);

        Assertions.assertThat(calculatePremiumResponse).isEqualTo(expected);
    }

}