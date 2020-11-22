package br.com.originalcustomers.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private String name;

    private int age;

    private String cpf;

    private String email;

    private Address address;

}
