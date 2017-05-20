package com.ws.test;


import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.ws.rsp.CompanyResponse;
import com.ws.rsp.CouponResponse;
import com.ws.rsp.CustomerResponse;


public class UnMarHelpers {

	public static CompanyResponse unmarshallCompany(String token) throws JAXBException {

		CompanyResponse companyResponse = new CompanyResponse();

		JAXBContext jaxbContext;

		jaxbContext = JAXBContext.newInstance(CompanyResponse.class);
		StringReader reader = new StringReader(AllTests.token);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		companyResponse = (CompanyResponse) jaxbUnmarshaller.unmarshal(reader);
		System.out.println(companyResponse);

		return companyResponse;

	}

	public static CustomerResponse unmarshallCustomer(String token) throws JAXBException {

		CustomerResponse customerResponse = new CustomerResponse();

		JAXBContext jaxbContext;

		jaxbContext = JAXBContext.newInstance(CompanyResponse.class);
		StringReader reader = new StringReader(AllTests.token);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		customerResponse = (CustomerResponse) jaxbUnmarshaller.unmarshal(reader);
		System.out.println(customerResponse);

		return customerResponse;

	}

	public static CouponResponse unmarshallCoupon(String token) throws JAXBException {

		CouponResponse couponResponse = new CouponResponse();

		JAXBContext jaxbContext;

		jaxbContext = JAXBContext.newInstance(CompanyResponse.class);
		StringReader reader = new StringReader(AllTests.token);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		couponResponse = (CouponResponse) jaxbUnmarshaller.unmarshal(reader);
		System.out.println(couponResponse);

		return couponResponse;

	}

}
