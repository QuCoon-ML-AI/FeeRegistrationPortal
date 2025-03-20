//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.920001800
package com.pwb.feeRegistrationPortal.model.response

import com.pwb.feeRegistrationPortal.model.entity.registration


data class RegistrationReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<registration>
)

data class RegistrationReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: registration
)
