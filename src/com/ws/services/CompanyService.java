package com.ws.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ws.rsp.CouponResponse;

import beans.dao.Coupon;
import beans.dao.CouponType;
import core.cs.ClientType;
import core.cs.CouponSystem;
import e.Exeptions.CouponSystemsException;
import f.Facade.CompanyFacade;

@Path("/Company")
public class CompanyService {
	private CouponResponse couponResponse;

	static {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Path("/createCouponService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse createCouponService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Title") String title, @QueryParam("StartDate") String startDate,
			@QueryParam("EndDate") String endDate, @QueryParam("Amount") String amount, @QueryParam("Type") String type,
			@QueryParam("Message") String message, @QueryParam("Price") String price,
			@QueryParam("Image") String image) throws Throwable {

		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			Date utilStartDate = df.parse(startDate);
			Date utilEndDate = df.parse(endDate);

			java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
			java.sql.Date sqlEndDate = new java.sql.Date(utilEndDate.getTime());

			CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.COMPANY);
			Coupon coupon = new Coupon(title, sqlStartDate, sqlEndDate, Integer.parseInt(amount),
					CouponType.valueOf(type), message, Double.parseDouble(price), image);

			// Customer custromer = new Customer(name, customerPw, email);
			companyFacade.createCoupon(coupon);
		} catch (CouponSystemsException e) {
			// TODO Auto-generated catch block
			couponResponse = new CouponResponse("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse = new CouponResponse("success");
		return couponResponse;
	}

	@Path("/removeCouponService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse removeCouponService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Name") String name) throws Throwable {

		try {
			CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.COMPANY);
			Coupon coupon = new Coupon();
			companyFacade.removeCoupon(coupon);
		} catch (CouponSystemsException e) {
			// TODO Auto-generated catch block
			couponResponse = new CouponResponse("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse = new CouponResponse("success");
		return couponResponse;
	}

	@Path("/updateCouponService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse updateCouponService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Title") String title, @QueryParam("StartDate") String startDate,
			@QueryParam("EndDate") String endDate, @QueryParam("Amount") String amount, @QueryParam("Type") String type,
			@QueryParam("Message") String message, @QueryParam("Price") String price,
			@QueryParam("Image") String image) throws Throwable {

		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			Date utilStartDate = df.parse(startDate);
			Date utilEndDate = df.parse(endDate);

			java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
			java.sql.Date sqlEndDate = new java.sql.Date(utilEndDate.getTime());

			CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.COMPANY);
			Coupon coupon = new Coupon(title, sqlStartDate, sqlEndDate, Integer.parseInt(amount),
					CouponType.valueOf(type), message, Double.parseDouble(price), image);

			companyFacade.updateCoupon(coupon);
		} catch (CouponSystemsException e) {
			// TODO Auto-generated catch block
			couponResponse = new CouponResponse("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse = new CouponResponse("success");
		return couponResponse;
	}

	@Path("/getCouponService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse getCouponService(@QueryParam("User") String user, @QueryParam("PW") String pw,
			@QueryParam("Title") String title) throws Throwable {

		
		Coupon coupon = new Coupon(title, null, null, 0, null, title, 0, title);
		
		couponResponse = new CouponResponse();
		try {
			CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.COMPANY);
			
			coupon = companyFacade.getCoupon(coupon);
			ArrayList<Coupon> coupons = new ArrayList<>();
			coupons.add(coupon);
			couponResponse.setCoupons(coupons);
		} catch (CouponSystemsException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}

	@Path("/getAllMyCompanysCouponsService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse getAllMyCompanysCouponsService(@QueryParam("User") String user, @QueryParam("PW") String pw) throws Throwable {

		
		couponResponse = new CouponResponse();
		try {
			CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.COMPANY);

			couponResponse.setCoupons((ArrayList<Coupon>) companyFacade.getAllMyCompanyCoupons());
		} catch (CouponSystemsException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}
	
	
	
	@Path("/getCouponsByTypeService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse getCouponsByTypeService(@QueryParam("User") String user, @QueryParam("PW") String pw, @QueryParam("Type") String type) throws Throwable {

		
		couponResponse = new CouponResponse();
		try {
			CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.COMPANY);

			couponResponse.setCoupons((ArrayList<Coupon>) companyFacade.getCouponsByType(CouponType.valueOf(type)));
		} catch (CouponSystemsException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}
	
	
	

	@Path("/getCouponsByPriceService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse getCouponsByPriceService(@QueryParam("User") String user, @QueryParam("PW") String pw, @QueryParam("Price") String price) throws Throwable {

		
		couponResponse = new CouponResponse();
		try {
			CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.COMPANY);

			couponResponse.setCoupons((ArrayList<Coupon>) companyFacade.getCouponsByPrice(Double.valueOf(price)));
		} catch (CouponSystemsException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}


	
	
	@Path("/getCouponsByDateService")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public CouponResponse getCouponsByDateService(@QueryParam("User") String user, @QueryParam("PW") String pw, @QueryParam("Date") String date) throws Throwable {

		
		couponResponse = new CouponResponse();
		try {
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			Date utilDate = df.parse(date);
			
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstance().login(user, pw,
					ClientType.COMPANY);

			couponResponse.setCoupons((ArrayList<Coupon>) companyFacade.getCouponsByDate(sqlDate));
		} catch (CouponSystemsException e) {
			// TODO Auto-generated catch block
			couponResponse.setMessage("error: " + e.getMessage());
			return couponResponse;
		}

		couponResponse.setMessage("success");
		return couponResponse;
	}


}
