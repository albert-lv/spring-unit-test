package study.albert.spring.unit.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import study.albert.spring.unit.test.filter.CustomerFilter;
import study.albert.spring.unit.test.interceptor.CustomerInterceptor;

/**
 * @author albert.lv
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private CustomerFilter customerFilter;

    @Autowired
    private CustomerInterceptor customerInterceptor;

    @Bean
    public FilterRegistrationBean<CustomerFilter> loggingFilter(){
        FilterRegistrationBean<CustomerFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(customerFilter);
        registrationBean.addUrlPatterns("/customer/*");
        registrationBean.setOrder(1);

        return registrationBean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customerInterceptor)
                .addPathPatterns("/customer/*");
    }
}
