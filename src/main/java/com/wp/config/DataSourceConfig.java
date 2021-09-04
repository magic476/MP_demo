package com.wp.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.wp.mapper",sqlSessionFactoryRef = "test1SqlSessionFactory")
public class DataSourceConfig {
    @Autowired
    private Environment env;

    @Bean("test1DataSource")
    public DataSource ghDataSource(/*Environment env*/) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/aaa");
        dataSource.setUsername("root");
        dataSource.setPassword("2274766152");
        return dataSource;

    }

    @Bean(name = "test1SqlSessionFactory")
    // 表示这个数据源是默认数据源
    @Primary
    // @Qualifier表示查找Spring容器中名字为test1DataSource的对象
    public SqlSessionFactory test1SqlSessionFactory(@Qualifier("test1DataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        /*bean.setMapperLocations(
                // 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/test01/*.xml"));*/
        return bean.getObject();
    }
    @Bean("test1SqlSessionTemplate")
    // 表示这个数据源是默认数据源
    @Primary
    public SqlSessionTemplate test1sqlsessiontemplate(@Qualifier("test1SqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }

//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactory1(){
//        try {
//            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//            sqlSessionFactoryBean.setDataSource(ghDataSource());
//            // 加载MyBatis配置文件
//            PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
//            String path = "classpath:*.xml";
//            // 能加载多个，所以可以配置通配符(如：classpath*:mapper/**/*.xml)
//            sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources(path));
//            //sqlSessionFactoryBean.set
//            // 配置mybatis的config文件(我目前用不上)
//            // sqlSessionFactoryBean.setConfigLocation("mybatis-config.xml");
//            return sqlSessionFactoryBean;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

}
