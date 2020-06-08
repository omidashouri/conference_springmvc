package ir.omidashouri.conference.config;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jca.context.SpringContextResourceAdapter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.Locale;

@Configuration
@AllArgsConstructor
public class Config implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry){
        resourceHandlerRegistry.addResourceHandler("/files/**")
                .addResourceLocations("/WEB-INF/pdf");
    }

//    ---.---.---

  @Bean
  public ViewResolver viewResolver(){
      InternalResourceViewResolver bean = new InternalResourceViewResolver();
      bean.setPrefix("/WEB-INF/pages/");
      bean.setSuffix(".jsp");
      bean.setOrder(0);
      return bean;
  }

//  ---.---.---

  @Bean
  public LocaleResolver localeResolver(){
      SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
      sessionLocaleResolver.setDefaultLocale(Locale.US);
      return sessionLocaleResolver;
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
  }

  @Override
  public void addInterceptors(InterceptorRegistry interceptorRegistry){
        interceptorRegistry.addInterceptor(localeChangeInterceptor());
  }

//  ---.---.---

  @Bean
  public SpringResourceTemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
          templateResolver.setApplicationContext(applicationContext);
          templateResolver.setPrefix("/WEB-INF/views/");
          templateResolver.setSuffix(".html");
        return templateResolver;
  }

  @Bean
  public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
  }

  @Bean
  public ViewResolver thymeleafResolver(){
      ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
      viewResolver.setTemplateEngine(templateEngine());
      viewResolver.setOrder(1);
      return viewResolver;
  }


}
