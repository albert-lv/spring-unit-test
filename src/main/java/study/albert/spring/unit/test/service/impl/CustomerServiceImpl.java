package study.albert.spring.unit.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.albert.spring.unit.test.model.Customer;
import study.albert.spring.unit.test.repository.CustomerRepository;
import study.albert.spring.unit.test.service.CustomerService;

import java.util.Optional;

/**
 * @author albert.lv
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }
}
