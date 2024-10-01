package com.ponsun.pep.companiesAndLlp.CompaniesDirectors.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UpdateCompaniesDirectorsRequest extends AbstractCompaniesDirectorsRequest {
    @Override
    public String toString(){ return super.toString();}
}
