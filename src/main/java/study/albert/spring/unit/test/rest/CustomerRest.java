package study.albert.spring.unit.test.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.albert.spring.unit.test.model.Customer;
import study.albert.spring.unit.test.service.CustomerService;

import java.util.Optional;

/**
 * 用户API
 *
 * @author albert.lv
 */
@RestController
public class CustomerRest {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        Optional<Customer> optionalCustomer = customerService.getCustomer(id);
        if (optionalCustomer.isPresent()) {
            return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
