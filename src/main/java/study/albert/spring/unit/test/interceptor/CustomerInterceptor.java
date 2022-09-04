package study.albert.spring.unit.test.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import study.albert.spring.unit.test.model.Customer;
import study.albert.spring.unit.test.service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author albert.lv
 */
@RequiredArgsConstructor
@Component
public class CustomerInterceptor implements HandlerInterceptor {

    private static final Pattern CUSTOMER_PATTERN = Pattern.compile("/customer/(\\d+)");

    private final CustomerService customerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String pathInfo = request.getRequestURI();
        Matcher matcher = CUSTOMER_PATTERN.matcher(pathInfo);
        if (matcher.matches()) {
            Long id = Long.valueOf(matcher.group(1));
            Optional<Customer> optionalCustomer = customerService.getCustomer(id);
            if (optionalCustomer.isPresent()) {
                return true;
            }
        }
        return false;
    }
}
