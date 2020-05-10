package com.song.kyung;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
@MapperScan(value= {"com.song.kyung.Mapper"})
public class KyungApplication extends SpringBootServletInitializer {
	
	
/*	//war파일
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

	        return application.sources(KyungApplication.class);

	    }*/

	public static void main(String[] args) {
		// 스프링 버전 확인하기 

		String springVersion = org.springframework.core.SpringVersion.getVersion();

		System.out.println("Spring Version : " + springVersion);
		
		
		SpringApplication.run(KyungApplication.class, args);
	}
	
	
	//인터페이스 mapper 이랑 mapper.xml 연동
	
	 @Bean
	    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
	        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource);
	        
	        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
	        sessionFactory.setMapperLocations(res);
	        
	        return sessionFactory.getObject();
	    }

}
