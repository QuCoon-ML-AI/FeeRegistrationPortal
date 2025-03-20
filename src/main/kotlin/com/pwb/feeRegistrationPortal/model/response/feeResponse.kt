//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.841198800
package com.pwb.feeRegistrationPortal.model.response

import com.pwb.feeRegistrationPortal.model.entity.fee


data class FeeReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<fee>
)

data class FeeReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: fee
)
