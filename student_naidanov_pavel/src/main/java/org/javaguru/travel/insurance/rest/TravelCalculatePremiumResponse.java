package org.javaguru.travel.insurance.rest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

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

    public TravelCalculatePremiumResponse() {
    }

    public TravelCalculatePremiumResponse(
            String personFirstName,
            String personLastName,
            Date agreementDateFrom,
            Date agreementDateTo,
            BigDecimal agreementPrice
            )
    {
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
        this.agreementDateFrom = agreementDateFrom;
        this.agreementDateTo = agreementDateTo;
        this.agreementPrice = agreementPrice;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public Date getAgreementDateFrom() {
        return agreementDateFrom;
    }

    public void setAgreementDateFrom(Date agreementDateFrom) {
        this.agreementDateFrom = agreementDateFrom;
    }

    public Date getAgreementDateTo() {
        return agreementDateTo;
    }

    public void setAgreementDateTo(Date agreementDateTo) {
        this.agreementDateTo = agreementDateTo;
    }

    public BigDecimal getAgreementPrice() {
        return agreementPrice;
    }

    public void setAgreementPrice(BigDecimal agreementPrice) {
        this.agreementPrice = agreementPrice;
    }
}
