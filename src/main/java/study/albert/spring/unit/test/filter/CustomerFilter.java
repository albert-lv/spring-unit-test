package study.albert.spring.unit.test.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.albert.spring.unit.test.model.Customer;
import study.albert.spring.unit.test.service.CustomerService;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author albert.lv
 */
@RequiredArgsConstructor
@Component
public class CustomerFilter implements Filter {

    private static final Pattern CUSTOMER_PATTERN = Pattern.compile("/customer/(\\d+)");

    private final CustomerService customerService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String pathInfo = ((HttpServletRequest) servletRequest).getRequestURI();
        Matcher matcher = CUSTOMER_PATTERN.matcher(pathInfo);
        if (matcher.matches()) {
            Long id = Long.valueOf(matcher.group(1));
            Optional<Customer> optionalCustomer = customerService.getCustomer(id);
            if (optionalCustomer.isPresent()) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
        return;
    }
}
