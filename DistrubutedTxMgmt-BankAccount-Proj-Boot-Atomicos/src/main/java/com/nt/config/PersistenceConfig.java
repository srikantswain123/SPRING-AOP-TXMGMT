package com.nt.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
public class PersistenceConfig {
	
	@Bean("oraXda")
	public AtomikosDataSourceBean createOraAtomikos() {
		AtomikosDataSourceBean oraBean=new AtomikosDataSourceBean();
		oraBean.setUniqueResourceName("xaOra");
		oraBean.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource");
		Properties props=new Properties();
		props.setProperty("databaseName", "orcl");
		props.setProperty("user", "system");
		props.setProperty("password", "Srikant1234");
		props.setProperty("URL", "jdbc:oracle:thin:@localhost:1521:orcl");
		oraBean.setXaProperties(props);
		return oraBean;
		
	}
	
	@Bean("mySqlXda")
	public AtomikosDataSourceBean createMySqlAtomikos() {
		AtomikosDataSourceBean mySqlBean=new AtomikosDataSourceBean();
		mySqlBean.setUniqueResourceName("xaMySql");
		mySqlBean.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
		Properties props=new Properties();
		props.setProperty("databaseName", "ntsp713");
		props.setProperty("user", "root");
		props.setProperty("password", "root");
		props.setProperty("URL", "jdbc:mysql:///ntsp713");
		mySqlBean.setXaProperties(props);
		return mySqlBean;
	}
	
	
	//create template using xaDataSource
	
	@Bean("orajt")
	public JdbcTemplate orajt() {
		return new JdbcTemplate(createOraAtomikos());
	}
	@Bean("mysqljt")
	public JdbcTemplate mySqlJt() {
		return new JdbcTemplate(createMySqlAtomikos());
	}
	

}
