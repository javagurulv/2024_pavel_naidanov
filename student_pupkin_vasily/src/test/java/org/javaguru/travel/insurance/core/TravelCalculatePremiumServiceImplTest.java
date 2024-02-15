package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelCalculatePremiumServiceImplTest {

    private final TravelCalculatePremiumService service = new TravelCalculatePremiumServiceImpl();


    @Test
    public void shouldPopulateResponse(){
        final Date dateFrom = new Date(123);
        final Date dateTo = new Date(321);
        final TravelCalculatePremiumRequest req = new TravelCalculatePremiumRequest(
        "First Name", "Last Name", dateFrom, dateTo
        );

        final TravelCalculatePremiumResponse resp = service.calculatePremium(req);

        assertEquals(resp.getPersonFirstName(), req.getPersonFirstName());
        assertEquals(resp.getPersonLastName(), req.getPersonLastName());
        assertEquals(resp.getAgreementDateFrom(), req.getAgreementDateFrom());
        assertEquals(resp.getAgreementDateTo(), req.getAgreementDateTo());
    }

}