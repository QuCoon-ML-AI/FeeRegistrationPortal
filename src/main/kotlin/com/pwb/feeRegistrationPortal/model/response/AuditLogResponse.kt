//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.998120300
package com.pwb.feeRegistrationPortal.model.response

import com.pwb.feeRegistrationPortal.model.entity.AuditLog


data class AuditLogReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<AuditLog>
)

data class AuditLogReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: AuditLog
)
