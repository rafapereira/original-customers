package br.com.originalcustomers.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private String street;

    private String number;

    private String complement;

    private String neighborhood;

}
