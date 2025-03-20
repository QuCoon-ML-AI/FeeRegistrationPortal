//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.982743200
package com.pwb.feeRegistrationPortal.model.response

import com.pwb.feeRegistrationPortal.model.entity.Module


data class ModuleReadListResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: MutableList<Module>
)

data class ModuleReadSingleResponse(
   	var responseCode: String,
	var responseMessage: String,
	var data: Module
)
