package com.pizzashop;

import com.pizzashop.controllers.PizzaController;
import com.pizzashop.models.Sauce;
import com.pizzashop.repositories.DbInitializer;
import com.pizzashop.repositories.SauceRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses=PizzaController.class)
public class PizzaShopApplication extends WebMvcConfigurerAdapter{
	public static void main(String[] args) {
		SpringApplication.run(PizzaShopApplication.class, args);
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/addProduct").setViewName("addProduct.html");
//		registry.addViewController("/deleteProduct").setViewName("deleteProduct.html");
//		registry.addViewController("/editProduct").setViewName("editProduct.html");
//		registry.addViewController("/readComplaint").setViewName("readComplaint.html");
//		registry.addViewController("/index").setViewName("index.html");
//		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//	}
//
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		super.configurePathMatch(configurer);
		configurer.setUseSuffixPatternMatch(false);
	}

	@Bean
	public BeanPrinter beanPrinter(){
		return new BeanPrinter();
}

	@Bean
	public DbInitializer getDbInitializer(){
		return new DbInitializer();
	}

//	@Bean
//	public HibernateJpaSessionFactoryBean sessionFactory() {
//		return new HibernateJpaSessionFactoryBean();
//	}
}
