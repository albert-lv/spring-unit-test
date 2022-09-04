package study.albert.spring.unit.test.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import study.albert.spring.unit.test.model.Customer;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author albert.lv
 */
@DataJpaTest
public class CustomerRepositoryTests {

    private static final String NAME = "albert";

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testFindByName() {
        Optional<Customer> optionalUser = customerRepository.findByName(NAME);
        assertThat(optionalUser).isPresent();
        assertThat(optionalUser.get()).extracting(Customer::getName).isEqualTo(NAME);
    }


}
