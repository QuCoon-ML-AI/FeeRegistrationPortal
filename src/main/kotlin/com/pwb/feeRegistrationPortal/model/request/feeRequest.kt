//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.841198800
package com.pwb.feeRegistrationPortal.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class FeeCreateRequest(
   	@get: NotEmpty(message = "feeAmount is required")
	var feeAmount: String?=null,
	@get: NotEmpty(message = "feeDescription is required")
	var feeDescription: String?=null
)

data class FeeUpdateRequest(
   	@get: NotNull(message = "feeId is required")
	var feeId: Int?=null,
	var feeAmount: String?=null,
	var feeDescription: String?=null,
	var feeStatus: String?=null
)

data class FeeReadRequest(
   	var feeId: Int?=null,
	var feeAmount: String?=null,
	var feeDescription: String?=null,
	var feeStatus: String?=null,
	var feeCreatedAt: String?=null,
	var feeUpdatedAt: String?=null
)

data class FeeDeleteRequest(
   	@get: NotNull(message = "feeId is required")
	var feeId: Int?=null
)
