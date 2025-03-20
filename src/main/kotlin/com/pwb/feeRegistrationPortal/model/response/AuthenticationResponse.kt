//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:16.076222200
package com.pwb.feeRegistrationPortal.model.response


data class LoginResponse(
   	var userId: Int?=null,
	var userRoleId: Int?=null,
	var userEmail: String?=null,
	var userFirstName: String?=null,
	var userLastName: String?=null,
	var userPhoneNumber: String?=null,
	var userJobRoleAlias: String?=null,
	var userStatus: String?=null,
	var userCreatedAt: String?=null,
	var userUpdatedAt: String?=null,
	var privileges: List<String> = mutableListOf(),
	var token: String?=null,
	var responseCode: String?=null,
	var responseMessage: String?=null
)
