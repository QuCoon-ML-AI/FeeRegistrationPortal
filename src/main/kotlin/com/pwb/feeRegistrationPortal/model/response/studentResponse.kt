//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.762201
package com.pwb.feeRegistrationPortal.model.response

import com.pwb.feeRegistrationPortal.model.entity.student


data class StudentReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<student>
)

data class StudentReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: student
)
