package com.exam.common.constant;

public class Constants {
	Constants(){
		
	}
	
	public static final String ROLE_ADMIN="hasAnyRole('ROLE_ADMIN')";
	public static final String ROLE_NORMAL="hasAnyRole('ROLE_NORMAL')";
	public static final String ROLE_ADMIN_AND_NORMAL="hasAnyRole('ROLE_ADMIN','ROLE_NORMAL')";
}
