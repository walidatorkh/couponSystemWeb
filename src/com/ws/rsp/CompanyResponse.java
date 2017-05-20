package com.ws.rsp;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import beans.dao.Company;

@XmlRootElement
public class CompanyResponse {
	private String message;
	private ArrayList<Company> companies;
	
	
	public CompanyResponse() {
		super();
	}
	
	
	public CompanyResponse(String message) {
		super();
		this.message = message;
	}


	public CompanyResponse(String message, ArrayList<Company> companies) {
		super();
		this.message = message;
		this.companies = companies;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(ArrayList<Company> companies) {
		this.companies = companies;
	}
	@Override
	public String toString() {
		return "CompanyResponse [message=" + message + ", companies=" + companies + "]";
	}
	
	

}
