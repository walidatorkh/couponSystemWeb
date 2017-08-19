package com.ws.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.ws.rsp.CouponResponse;

public class CompanyCreateTC {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Ignore
	@Test
	public void test010createCouponService() {

		AllTests.token = AllTests.service.path("Admin").path("createCouponService").queryParam("User", "Admin")
				.queryParam("PW", "Admin").queryParam("Title", "coup1").queryParam("StartDate", "2017-01-01")
				.queryParam("EndDate", "2018-12-31").queryParam("Amount", "5").queryParam("Type", "CAMPING")
				.queryParam("Message", "coup0").queryParam("Price", "12.34").queryParam("Image", "coup0")
				.accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		CouponResponse couponResponse = new CouponResponse();
		try {
			couponResponse = UnMarHelpers.unmarshallCoupon(AllTests.token);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			fail(e1.getMessage());
		}
		System.out.println(couponResponse.getMessage());
		assertEquals("success", couponResponse.getMessage());

	}
	
	@Ignore
	@Test
	public void test020updateCouponService() {

		AllTests.token = AllTests.service.path("Admin").path("updateCouponService").queryParam("User", "Admin")
				.queryParam("PW", "Admin").queryParam("Title", "coup1").queryParam("StartDate", "2016-01-01")
				.queryParam("EndDate", "2019-12-31").queryParam("Amount", "10").queryParam("Type", "RESTAURANTS")
				.queryParam("Message", "coup1").queryParam("Price", "12.34").queryParam("Image", "coup1")
				.accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		CouponResponse couponResponse = new CouponResponse();
		try {
			couponResponse = UnMarHelpers.unmarshallCoupon(AllTests.token);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			fail(e1.getMessage());
		}
		System.out.println(couponResponse.getMessage());
		assertEquals("success", couponResponse.getMessage());

	}

}
