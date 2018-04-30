package ua.com.alistratenko.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import ua.com.alistratenko.entity.Order;
import ua.com.alistratenko.entity.OrderItem;
import ua.com.alistratenko.entity.Product;
import ua.com.alistratenko.entity.ProductCategory;
import ua.com.alistratenko.entity.User;
import ua.com.alistratenko.entity.UserRole;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:database.properties")
@ComponentScan(basePackages = {
        "ua.com.alistratenko.dao",
        "ua.com.alistratenko.entity",
        "ua.com.alistratenko.service",
        "ua.com.alistratenko.aspect",
})
public class RootConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driver"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.username"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties props=new Properties();
        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        props.put("hibernate.generate_statistics", env.getProperty("hibernate.generate.statistics"));

        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(User.class, UserRole.class, ProductCategory.class, Product.class, Order.class, OrderItem.class);
        return factoryBean;
    }
}
