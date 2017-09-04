package ua.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan("ua.com.*")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public JavaMailSender javaMailSender(){
        JavaMailSenderImpl  javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("jktujktu9898@gmail.com");
        javaMailSender.setPassword("jktu98jktu98");
        Properties properties=javaMailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol","smtp");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.debug","true");
        return javaMailSender;

    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/TRIGER/**")
                .addResourceLocations("/WEB-INF/style/");
        registry.addResourceHandler("/IMAGE/**")
                .addResourceLocations("/WEB-INF/images/");
        registry.addResourceHandler("/PICTURE/**")
                .addResourceLocations("file:C:\\Users\\olegf\\Desktop\\Sombra_Test_Shop-master\\TMP\\");
        registry.addResourceHandler("/JS/**")
                .addResourceLocations("/WEB-INF/javascript/");
    }
}
