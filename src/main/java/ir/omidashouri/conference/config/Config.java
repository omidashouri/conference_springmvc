package ir.omidashouri.conference.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class Config implements WebMvcConfigurer {

  @Bean
  public ViewResolver viewResolver(){
      InternalResourceViewResolver bean = new InternalResourceViewResolver();
      bean.setPrefix("/WEB-INF/pages/");
      bean.setSuffix(".jsp");
      bean.setOrder(0);
      return bean;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry){
      resourceHandlerRegistry.addResourceHandler("/files/**")
              .addResourceLocations("/WEB-INF/pdf");
  }


}
