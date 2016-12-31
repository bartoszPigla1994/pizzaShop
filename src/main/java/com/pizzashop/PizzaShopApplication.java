package com.pizzashop;

import com.pizzashop.controllers.PizzaController;
import com.pizzashop.repositories.DbInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses={PizzaController.class, DbInitializer.class})
@EnableTransactionManagement
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
//	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
//		JpaTransactionManager transactionManager = new JpaTransactionManager(emf);
//
//		return transactionManager;
//	}
//
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory
//			(DataSource dataSource, JpaVendorAdapter jpaVendeorAdapter)
//	{
//		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
//		entityManagerFactory.setDataSource(dataSource);
//		entityManagerFactory.setJpaVendorAdapter(jpaVendeorAdapter);
//		entityManagerFactory.setPackagesToScan("com.pizzashop.models");
//		return entityManagerFactory;
//	}
//
//	@Bean
//	public JpaVendorAdapter jpaVendorAdapter()
//	{
//		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//		adapter.setShowSql(true);
//		adapter.setGenerateDdl(false);
//		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
//
//		return adapter;
//	}
//	@Bean
//	public HibernateJpaSessionFactoryBean sessionFactory() {
//		return new HibernateJpaSessionFactoryBean();
//	}
}
