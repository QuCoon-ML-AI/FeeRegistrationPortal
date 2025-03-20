//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.605778800
package com.pwb.feeRegistrationPortal.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class UserCreateRequest(
   	@get: NotNull(message = "userRoleId is required")
	var userRoleId: Int?=null,
	@get: NotEmpty(message = "userEmail is required")
	var userEmail: String?=null,
	@get: NotEmpty(message = "userFirstName is required")
	var userFirstName: String?=null,
	@get: NotEmpty(message = "userLastName is required")
	var userLastName: String?=null,
	@get: NotEmpty(message = "userPassword is required")
	var userPassword: String?=null,
	@get: NotEmpty(message = "userPhoneNumber is required")
	var userPhoneNumber: String?=null,
	@get: NotEmpty(message = "userJobRoleAlias is required")
	var userJobRoleAlias: String?=null
)

data class UserUpdateRequest(
   	@get: NotNull(message = "userId is required")
	var userId: Int?=null,
	var userRoleId: Int?=null,
	var userEmail: String?=null,
	var userFirstName: String?=null,
	var userLastName: String?=null,
	var userPassword: String?=null,
	var userPhoneNumber: String?=null,
	var userJobRoleAlias: String?=null,
	var userStatus: String?=null
)

data class UserReadRequest(
   	var userId: Int?=null,
	var userRoleId: Int?=null,
	var userEmail: String?=null,
	var userFirstName: String?=null,
	var userLastName: String?=null,
	var userPassword: String?=null,
	var userPhoneNumber: String?=null,
	var userJobRoleAlias: String?=null,
	var userStatus: String?=null,
	var userCreatedAt: String?=null,
	var userUpdatedAt: String?=null
)

data class UserDeleteRequest(
   	@get: NotNull(message = "userId is required")
	var userId: Int?=null
)
