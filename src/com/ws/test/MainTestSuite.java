package com.ws.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdminCreateTC.class, CompanyCreateTC.class, CustomerCreateTC.class, AdminListTC.class,
		CompanyListTC.class, CustomerListTC.class, CustomerRemoveTC.class, CompanyRemoveTC.class, AdminRemoveTC.class })
public class MainTestSuite {

}
