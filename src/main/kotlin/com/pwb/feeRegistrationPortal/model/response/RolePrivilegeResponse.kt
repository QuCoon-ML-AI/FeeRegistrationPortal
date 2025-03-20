//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.982743200
package com.pwb.feeRegistrationPortal.model.response

import com.pwb.feeRegistrationPortal.model.entity.RolePrivilege


data class RolePrivilegeReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<RolePrivilege>
)

data class RolePrivilegeReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: RolePrivilege
)
