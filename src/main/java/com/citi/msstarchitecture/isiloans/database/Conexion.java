package com.citi.msstarchitecture.isiloans.database;

import oracle.jdbc.pool.OracleDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.citi.msstarchitecture.isiloans.cyberark.CyberArk;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties("oracle")
public class Conexion {

	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String url;

	@Autowired
	CyberArk cyberArk;

	@Bean
	DataSource dataSource() throws Exception {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(username);
		try {
			dataSource.setPassword(cyberArk.getSecretFromNickname());
		} catch (Exception e) {
			dataSource.setPassword(password);
		}
		dataSource.setURL(url);
		dataSource.setImplicitCachingEnabled(true);
		dataSource.setFastConnectionFailoverEnabled(true);
		return dataSource;
	}

}
