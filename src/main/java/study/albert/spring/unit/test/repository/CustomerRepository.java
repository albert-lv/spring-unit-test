package study.albert.spring.unit.test.repository;

import org.springframework.data.repository.CrudRepository;
import study.albert.spring.unit.test.model.Customer;

import java.util.Optional;

/**
 * @author albert.lv
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findByName(String name);

}
