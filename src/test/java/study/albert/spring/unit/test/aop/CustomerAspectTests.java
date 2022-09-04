package study.albert.spring.unit.test.aop;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import study.albert.spring.unit.test.model.Customer;
import study.albert.spring.unit.test.rest.CustomerRest;
import study.albert.spring.unit.test.service.CustomerService;

import java.util.Optional;

import static study.albert.spring.unit.test.constant.Constants.CUSTOMER_ID;
import static study.albert.spring.unit.test.constant.Constants.HELLO_WORLD;

/**
 * @author albert.lv
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringAOPContext.class)
public class CustomerAspectTests {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRest customerRest;

    @SneakyThrows
    @Test
    public void testCustomerAspect() {
        Mockito.when(customerService.getCustomer(Mockito.anyLong())).thenReturn(Optional.of(new Customer()));
        Assert.assertEquals(HELLO_WORLD, customerRest.getCustomer(CUSTOMER_ID));
    }

    @SneakyThrows
    @Test(expected = RuntimeException.class)
    public void testCustomerAspectWithCustomerNotFound() {
        Mockito.when(customerService.getCustomer(Mockito.anyLong())).thenReturn(Optional.empty());
        customerRest.getCustomer(CUSTOMER_ID);
    }

}


@Configuration
@EnableAspectJAutoProxy
@ComponentScan(
        basePackages = "study.albert.spring.unit.test",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CustomerAspect.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CustomerRest.class)
        })
class SpringAOPContext {

    @Bean
    public CustomerService getCustomerService() {
        return Mockito.mock(CustomerService.class);
    }
}
