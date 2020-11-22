package br.com.originalcustomers.service.impl;

import br.com.originalcustomers.domain.Customer;
import br.com.originalcustomers.service.spec.CustomerService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    List<Customer> customerDataBaseList = new ArrayList<>();

    @Override
    public Customer addCustomer(Customer customerDTO) {

        // criando redundância apenas para ilustrar criação de novo usuário com Lombok
        Customer newCustomer = Customer.builder()
                                .name(customerDTO.getName())
                                .age(customerDTO.getAge())
                                .cpf(customerDTO.getCpf())
                                .email(customerDTO.getEmail())
                                .address(customerDTO.getAddress())
                                .build();

        customerDataBaseList.add(newCustomer);

        return newCustomer;
    }

    @Override
    public List<Customer> getAllustomers() {
        return customerDataBaseList;
    }

    @Override
    public void deleteAllustomers() {
        customerDataBaseList.clear();
    }

    @Override
    public Boolean modifyCustomer(String cpf, String name, int age, String email) {

        for ( Customer customer : customerDataBaseList) {
            if(customer.getCpf().equals(cpf)){
                customer.setName(name);
                customer.setAge(age);
                customer.setEmail(email);
                return true;
            }
        }

        return false;
    }
}
