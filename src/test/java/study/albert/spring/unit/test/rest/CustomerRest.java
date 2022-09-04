package study.albert.spring.unit.test.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static study.albert.spring.unit.test.constant.Constants.HELLO_WORLD;

/**
 * @author albert.lv
 */
@RestController
public class CustomerRest {

    @GetMapping("/customer/{id}")
    public String getCustomer(@PathVariable Long id) {
        return HELLO_WORLD;
    }

}
