/**
 * 
 */
package com.contacts.properties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * @author Siva Nadupuru
 *
 */
@Data
@ConfigurationProperties(prefix = "phnbook")
@EnableConfigurationProperties
@Configuration
public class AppProperties {
	
	private Map<String,String> messages=new HashMap<>();
	
	

}
