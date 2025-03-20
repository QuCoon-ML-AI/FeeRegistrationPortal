//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.621571600
package com.pwb.feeRegistrationPortal.model.response

import com.pwb.feeRegistrationPortal.model.entity.User


data class UserReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<User>
)

data class UserReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: User
)
