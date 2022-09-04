package study.albert.spring.unit.test.filter;


import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.albert.spring.unit.test.model.Customer;
import study.albert.spring.unit.test.service.CustomerService;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static study.albert.spring.unit.test.constant.Constants.CUSTOMER_ID;
import static study.albert.spring.unit.test.constant.Constants.HELLO_WORLD;

/**
 * @author albert.lv
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerFilterTests {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerFilter customerFilter;

    @SneakyThrows
    @Test
    public void testCustomerFilter() {
        Mockito.when(customerService.getCustomer(Mockito.anyLong())).thenReturn(Optional.of(new Customer()));
        standaloneSetup(new HelloWorldRest())
                .addFilter(customerFilter, "/customer/*")
                .build()
                .perform(get("/customer/" + CUSTOMER_ID))
                .andExpect(status().isOk())
                .andExpect(content().string(HELLO_WORLD));
    }

    @SneakyThrows
    @Test
    public void testCustomerFilterWithCustomerNotFound() {
        standaloneSetup(new HelloWorldRest())
                .addFilter(customerFilter, "/customer/*")
                .build()
                .perform(get("/customer/" + CUSTOMER_ID))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @RestController
    class HelloWorldRest {

        @GetMapping("/customer/{id}")
        public String helleWorld(@PathVariable Long id) {
            return HELLO_WORLD;
        }

    }

}
