package com.ws.test;


import javax.ws.rs.core.UriBuilder;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@RunWith(Suite.class)
@SuiteClasses({ AllTests.class })
public class AllTests {
	public static WebResource service; 
	public static String token;
	
	static{
		ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    service = client.resource(UriBuilder
	    		        .fromUri("http://localhost:8080/coupons-web/restfulweb/")
	    		        .build());
	}
	

}
