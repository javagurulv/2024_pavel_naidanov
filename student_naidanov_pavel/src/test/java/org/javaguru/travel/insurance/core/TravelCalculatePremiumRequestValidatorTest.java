package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumRequestValidatorTest {
    @Mock private TravelCalculatePremiumRequest request;

    @Test
    void should_return_error_when_person_first_name_is_null() {
        var validator = new TravelCalculatePremiumRequestValidator();

        var errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("personFirstName", errors.get(0).getField());
        assertEquals("Must not be empty!", errors.get(0).getMessage());
    }

    @Test
    void should_return_error_when_person_first_name_is_empty() {
        var validator = new TravelCalculatePremiumRequestValidator();
        when(request.getPersonFirstName()).thenReturn("");

        var errors = validator.validate(request);

        assertEquals(1, errors.size());
        assertEquals("personFirstName", errors.get(0).getField());
        assertEquals("Must not be empty!", errors.get(0).getMessage());
    }

    @Test
    void should_return_empty_when_person_last_name_is_valid() {
        var validator = new TravelCalculatePremiumRequestValidator();
        when(request.getPersonFirstName()).thenReturn("Pavel");

        var errors = validator.validate(request);

        assertTrue(errors.isEmpty());
    }


}