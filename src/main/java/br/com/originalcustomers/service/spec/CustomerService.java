package br.com.originalcustomers.service.spec;

import br.com.originalcustomers.domain.Customer;

import java.util.List;

public interface CustomerService {

    Customer addCustomer (Customer customer);

    List<Customer> getAllustomers ();

    void deleteAllustomers ();

    Boolean modifyCustomer(String cpf, String name, int age, String email);

}
