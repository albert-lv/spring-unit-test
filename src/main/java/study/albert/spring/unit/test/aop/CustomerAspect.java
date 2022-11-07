package study.albert.spring.unit.test.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import study.albert.spring.unit.test.model.Customer;
import study.albert.spring.unit.test.service.CustomerService;

import java.util.Optional;

/**
 * @author albert.lv
 */
@RequiredArgsConstructor
@Component
@Aspect
@Slf4j
public class CustomerAspect {

    private final CustomerService customerService;

    @Before(value = "execution(* study.albert.spring.unit.test.rest.CustomerRest.getCustomer(..)) && args(id)")
    public void before(Long id) {
        Optional<Customer> optionalCustomer = customerService.getCustomer(id);
        if (optionalCustomer.isPresent()) {
            return;
        }
        throw new RuntimeException("customer not found");
    }

}
