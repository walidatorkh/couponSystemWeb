package com.ws.services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ws.rsp.CustomerResponse;
import com.ws.rsp.CompanyResponse;
import com.ws.rsp.CouponResponse;

import beans.dao.Coupon;
import beans.dao.CouponType;
import core.cs.ClientType;
import core.cs.CouponSystem;
import e.Exeptions.CouponSystemsException;
import f.Facade.CompanyFacade;
import f.Facade.CustomerFacade;

@Path("/Customer")
public class CustomerService {
	private CouponResponse couponResponse;

	static {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Path("/purchaseCouponService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse purchaseCouponService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Title") String title) throws Throwable {

		Coupon coupon = new Coupon(title, null, null, 0, null, title, 0, title);
		couponResponse = new CouponResponse();
		try {
			CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.CUSTOMER);
			customerFacade.purchaseCoupon(coupon);
		} catch (CouponSystemsException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}
	
	
	
	
	@Path("/getAllPurchasedCouponsService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse getAllPurchasedCouponsService(@QueryParam("User") String user, @QueryParam("PW") String pw) throws Throwable {

		
		couponResponse = new CouponResponse();
		try {
			CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.CUSTOMER);

			couponResponse.setCoupons((ArrayList<Coupon>) customerFacade.getAllPurchasedCoupons());
		} catch (CouponSystemsException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}
	
	
	

	@Path("/getAllPurchasedCouponsByTypeService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse getAllPurchasedCouponsByTypeService(@QueryParam("User") String user, @QueryParam("PW") String pw, @QueryParam("Type") String type) throws Throwable {

		
		couponResponse = new CouponResponse();
		try {
			CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.CUSTOMER);

			couponResponse.setCoupons((ArrayList<Coupon>) customerFacade.getAllPurchasedCouponsByType(CouponType.valueOf(type)));
		} catch (CouponSystemsException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}
	
	
	

	@Path("/getAllPurchasedCouponsByPriceService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse getAllPurchasedCouponsByPriceService(@QueryParam("User") String user, @QueryParam("PW") String pw, @QueryParam("Price") String price) throws Throwable {

		
		couponResponse = new CouponResponse();
		try {
			CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.CUSTOMER);

			couponResponse.setCoupons((ArrayList<Coupon>) customerFacade.getAllPurchasedCouponsByPrice(Double.valueOf(price)));
		} catch (CouponSystemsException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}



}
