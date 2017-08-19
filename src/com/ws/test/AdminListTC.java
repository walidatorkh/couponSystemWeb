package com.ws.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.ws.rsp.CompanyResponse;
import com.ws.rsp.CouponResponse;
import com.ws.rsp.CustomerResponse;

import beans.dao.Company;
import beans.dao.Coupon;
import beans.dao.Customer;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminListTC {

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

	// getcomp
		@Test
		public void test010getCompanyService() {

			
			AllTests.token = AllTests.service.path("Admin").path("getCompanyService").queryParam("User", "Admin")
					.queryParam("PW", "Admin").queryParam("Email", "comp1").accept(MediaType.APPLICATION_XML)
					.get(String.class);
			System.out.println("Token: " + AllTests.token);
			
			
			CompanyResponse companyResponse = new CompanyResponse();
			try {
				companyResponse = UnMarHelpers.unmarshallCompany(AllTests.token);
			} catch (JAXBException e1) {
				// TODO Auto-generated catch block
				fail(e1.getMessage());
			}
			
			ArrayList<Company> companies = companyResponse.getCompanies();
			Company company = companies.get(0);
			
			System.out.println(company);
			assertEquals(company.getCompName(), "comp1");
			assertEquals("success", companyResponse.getMessage());
			

		}
		
		

		
		
		
		@Test
		public void test020getAllCompaniesService() {

			
			AllTests.token = AllTests.service.path("Admin").path("getAllCompaniesService").queryParam("User", "Admin")
					.queryParam("PW", "Admin").accept(MediaType.APPLICATION_XML)
					.get(String.class);
			System.out.println("Token: " + AllTests.token);
			
			
			CompanyResponse companyResponse = new CompanyResponse();
			try {
				companyResponse = UnMarHelpers.unmarshallCompany(AllTests.token);
			} catch (JAXBException e1) {
				// TODO Auto-generated catch block
				fail(e1.getMessage());
			}
			
			assertEquals("success", companyResponse.getMessage());
			ArrayList<Company> companies = companyResponse.getCompanies();
			
			
			Company company = companies.get(0);
			
			System.out.println(company);
			assertEquals(company.getCompName(), "comp1");
		}
		@Ignore
		@Test
		public void test030getCustomerService() {

			
			AllTests.token = AllTests.service.path("Admin").path("getCustomerService").queryParam("User", "Admin")
					.queryParam("PW", "Admin").queryParam("Email", "cust1").accept(MediaType.APPLICATION_XML)
					.get(String.class);
			System.out.println("Token: " + AllTests.token);
			
			
			CustomerResponse customerResponse = new CustomerResponse();
			try {
				customerResponse = UnMarHelpers.unmarshallCustomer(AllTests.token);
			} catch (JAXBException e1) {
				// TODO Auto-generated catch block
				fail(e1.getMessage());
			}
			assertEquals("success", customerResponse.getMessage());
			ArrayList<Customer> customers = customerResponse.getCustomers();
			Customer customer = customers.get(0);
			
			System.out.println(customer);
			assertEquals(customer.getCustName(), "cust1");
		}
		
		@Ignore
		@Test
		public void test040getAllCustomersService() {

			
			AllTests.token = AllTests.service.path("Admin").path("getAllCustomersService").queryParam("User", "Admin")
					.queryParam("PW", "Admin").accept(MediaType.APPLICATION_XML)
					.get(String.class);
			System.out.println("Token: " + AllTests.token);
			
			
			CompanyResponse companyResponse = new CompanyResponse();
			try {
				companyResponse = UnMarHelpers.unmarshallCompany(AllTests.token);
			} catch (JAXBException e1) {
				// TODO Auto-generated catch block
				fail(e1.getMessage());
			}
			
			assertEquals("success", companyResponse.getMessage());
			ArrayList<Company> companies = companyResponse.getCompanies();
			
			
			Company company = companies.get(0);
			
			System.out.println(company);
			assertEquals(company.getCompName(), "comp1");
		}
		
		@Test
		public void test050getAllCouponsService() {

			
			AllTests.token = AllTests.service.path("Admin").path("getAllCouponsService").queryParam("User", "Admin")
					.queryParam("PW", "Admin").accept(MediaType.APPLICATION_XML)
					.get(String.class);
			System.out.println("Token: " + AllTests.token);
			
			
			CouponResponse couponResponse = new CouponResponse();
			try {
				couponResponse = UnMarHelpers.unmarshallCoupon(AllTests.token);
			} catch (JAXBException e1) {
				// TODO Auto-generated catch block
				fail(e1.getMessage());
			}
			
			assertEquals("success", couponResponse.getMessage());
			ArrayList<Coupon> coupons = couponResponse.getCoupons();
			
			
			Coupon coupon = coupons.get(0);
			
			System.out.println(coupon);
			assertEquals(coupon.getTitle(), "coup1");
		}
		
		@Test
		public void test060getCouponByCompanyService() {

			
			AllTests.token = AllTests.service.path("Admin").path("getCouponByCompanyService").queryParam("User", "Admin")
					.queryParam("PW", "Admin").queryParam("Email", "comp1").accept(MediaType.APPLICATION_XML)
					.get(String.class);
			System.out.println("Token: " + AllTests.token);
			
			
			CouponResponse couponResponse = new CouponResponse();
			try {
				couponResponse = UnMarHelpers.unmarshallCoupon(AllTests.token);
			} catch (JAXBException e1) {
				// TODO Auto-generated catch block
				fail(e1.getMessage());
			}
			
			assertEquals("success", couponResponse.getMessage());
			ArrayList<Coupon> coupons = couponResponse.getCoupons();
			
			
			Coupon coupon = coupons.get(0);
			
			System.out.println(coupon);
			assertEquals(coupon.getTitle(), "coup1");
		}
		
}
