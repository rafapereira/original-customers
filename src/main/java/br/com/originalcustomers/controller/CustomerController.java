package br.com.originalcustomers.controller;

import br.com.originalcustomers.domain.Customer;
import br.com.originalcustomers.service.spec.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@Api(value="API Customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    @ApiOperation(value = "Get all customers.")
    public ResponseEntity<?> getAllCustomers() {

        try {
            return ResponseEntity.ok().body(customerService.getAllustomers());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Erro ao pesquisar por clientes.");
        }

    }

    @PostMapping
    @ApiOperation(value = "Add a customer.")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {

        try {

            Customer newCustomer = customerService.addCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Erro ao criar cliente.");

        }

    }

    @PutMapping()
    @ApiOperation(value = "Modify a customer.")
    public ResponseEntity<?> modifyCustomer(@RequestHeader("cpf") String cpf,
                                                   @RequestHeader(value = "name", required = false) String name,
                                                   @RequestHeader(value = "age", required = false) int age,
                                                   @RequestHeader(value = "email", required = false) String email) {


        try {

            Boolean customerModified = customerService.modifyCustomer(cpf, name, age, email);

            if(customerModified){
                return ResponseEntity.status(HttpStatus.CREATED).body("Cliente modificado com sucesso.");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("Cliente não foi modificado.");

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Erro ao criar cliente.");

        }
    }

    @DeleteMapping()
    @ApiOperation(value = "Delete all customers.")
    public ResponseEntity<?> deleteAllCustomers() {

        try {

            customerService.deleteAllustomers();

            return ResponseEntity.ok().body("Clientes deletados com sucesso.");

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Erro ao deletar clientes.");

        }

    }

}
