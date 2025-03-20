//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.920001800
package com.pwb.feeRegistrationPortal.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class RegistrationCreateRequest(
   	@get: NotNull(message = "registrationStudentId is required")
	var registrationStudentId: Int?=null,
	@get: NotNull(message = "registrationFeeId is required")
	var registrationFeeId: Int?=null,
	@get: NotEmpty(message = "registrationDate is required")
	var registrationDate: String?=null
)

data class RegistrationUpdateRequest(
   	@get: NotNull(message = "registrationId is required")
	var registrationId: Int?=null,
	var registrationStudentId: Int?=null,
	var registrationFeeId: Int?=null,
	var registrationDate: String?=null,
	var registrationStatus: String?=null
)

data class RegistrationReadRequest(
   	var registrationId: Int?=null,
	var registrationStudentId: Int?=null,
	var registrationFeeId: Int?=null,
	var registrationDate: String?=null,
	var registrationStatus: String?=null,
	var registrationCreatedAt: String?=null,
	var registrationUpdatedAt: String?=null
)

data class RegistrationDeleteRequest(
   	@get: NotNull(message = "registrationId is required")
	var registrationId: Int?=null
)
