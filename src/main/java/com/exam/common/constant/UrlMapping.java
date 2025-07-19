package com.exam.common.constant;

public class UrlMapping {

	public UrlMapping() {
		super();
	}

	public static final String BASE_URL = "/api/p2/v1/";
	public static final String GENERATE_TOKEN_URL="/generate-token";

	// User
	public static final String USERS = "users";
	public static final String USER_UUID = USERS + "/{userUuid}";
}
