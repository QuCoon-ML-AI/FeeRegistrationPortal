//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.762201
package com.pwb.feeRegistrationPortal.model.request

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


data class StudentCreateRequest(
   	@get: NotEmpty(message = "studentEmail is required")
	var studentEmail: String?=null,
	@get: NotEmpty(message = "studentName is required")
	var studentName: String?=null,
	@get: NotEmpty(message = "studentPassword is required")
	var studentPassword: String?=null
)

data class StudentUpdateRequest(
   	@get: NotNull(message = "studentId is required")
	var studentId: Int?=null,
	var studentEmail: String?=null,
	var studentName: String?=null,
	var studentStatus: String?=null,
	var studentPassword: String?=null
)

data class StudentReadRequest(
   	var studentId: Int?=null,
	var studentEmail: String?=null,
	var studentName: String?=null,
	var studentStatus: String?=null,
	var studentCreatedAt: String?=null,
	var studentUpdatedAt: String?=null,
	var studentPassword: String?=null
)

data class StudentDeleteRequest(
   	@get: NotNull(message = "studentId is required")
	var studentId: Int?=null
)
