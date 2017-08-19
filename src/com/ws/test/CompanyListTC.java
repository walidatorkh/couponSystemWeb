package com.ws.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.ws.rsp.CouponResponse;

import beans.dao.Coupon;
import beans.dao.CouponType;

public class CompanyListTC {

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
	public void test010getCouponService() {

		AllTests.token = AllTests.service.path("Admin").path("getCouponService").queryParam("User", "Admin")
				.queryParam("PW", "Admin").queryParam("Title", "coup1")
				.accept(MediaType.APPLICATION_XML).get(String.class);
		System.out.println("Token: " + AllTests.token);

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String startDate =  "2016-01-01";
		String endDate =  "2019-12-31";
		
		Date utilStartDate = null;
		Date utilEndDate = null;
		try {
			utilStartDate = df.parse(startDate);
			utilEndDate = df.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
		java.sql.Date sqlEndDate = new java.sql.Date(utilEndDate.getTime());
		
		Coupon couponTest = new Coupon("coup1", sqlStartDate, sqlEndDate, 10, CouponType.RESTAURANTS, "coup1", 12.34, "coup1");
		
		
		
		CouponResponse couponResponse = new CouponResponse();
		try {
			couponResponse = UnMarHelpers.unmarshallCoupon(AllTests.token);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			fail(e1.getMessage());
		}
		
		assertEquals("success", couponResponse.getMessage());
		ArrayList<Coupon> coupons = couponResponse.getCoupons();
		
		
		Coupon couponXML = coupons.get(0);
		
		System.out.println(couponXML);
		assertEquals(couponXML.toString(), couponTest.toString());

	}
}
