package org.javaguru.travel.insurance.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TravelCalculatePremiumResponse {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TravelCalculatePremiumResponse that = (TravelCalculatePremiumResponse) o;

        if (!Objects.equals(personFirstName, that.personFirstName))
            return false;
        if (!Objects.equals(personLastName, that.personLastName))
            return false;
        if (!Objects.equals(agreementDateFrom, that.agreementDateFrom))
            return false;
        return Objects.equals(agreementDateTo, that.agreementDateTo);
    }

    @Override
    public int hashCode() {
        int result = personFirstName != null ? personFirstName.hashCode() : 0;
        result = 31 * result + (personLastName != null ? personLastName.hashCode() : 0);
        result = 31 * result + (agreementDateFrom != null ? agreementDateFrom.hashCode() : 0);
        result = 31 * result + (agreementDateTo != null ? agreementDateTo.hashCode() : 0);
        return result;
    }

    private String personFirstName;
    private String personLastName;
    private Date agreementDateFrom;
    private Date agreementDateTo;
    private BigDecimal agreementPrice;

}
