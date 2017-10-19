package lab.aikibo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("crud-angular");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/test-angular1").setViewName("test-angular1");
        registry.addViewController("/crud-angular").setViewName("crud-angular");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/tambah-user").setViewName("form");
        registry.addViewController("/form").setViewName("form");
    }
}
