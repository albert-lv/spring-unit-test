package study.albert.spring.unit.test.service;

import study.albert.spring.unit.test.model.Customer;

import java.util.Optional;

/**
 * 用户服务层
 *
 * @author albert.lv
 */
public interface CustomerService {

    Optional<Customer> getCustomer(Long id);

}
