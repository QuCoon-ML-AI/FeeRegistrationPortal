//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.920001800
package com.pwb.feeRegistrationPortal.controller

import com.pwb.feeRegistrationPortal.service.*
import org.pwb.utility.model.response.BaseResponse
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import com.pwb.feeRegistrationPortal.model.response.*
import com.pwb.feeRegistrationPortal.model.request.*
import org.pwb.utility.exception.BadRequestException
import org.pwb.utility.exception.ActivityAlreadyPerformedException
import org.pwb.utility.general.camelToSnakeCase
import org.pwb.utility.constant.*
import com.pwb.feeRegistrationPortal.utility.constant.*
import com.pwb.feeRegistrationPortal.utility.*
import org.pwb.utility.model.request.ModulePrivilege


@RestController
@RequestMapping("/{stage}/registration")
class RegistrationController(
	private val registrationService: RegistrationService,
	private val environment: Environment
){
   	@PostMapping("/create")
	fun create(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:RegistrationCreateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return registrationService.create(request)
	}

	@PostMapping("/bulk-create")
	fun bulkCreate(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:List<RegistrationCreateRequest>, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return registrationService.bulkCreate(request)
	}

	@PostMapping("/update")
	fun update(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:RegistrationUpdateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.UPDATE),
			authorization)
		return registrationService.update(request)
	}

	@PostMapping("/delete")
	fun delete(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:RegistrationDeleteRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.DELETE),
			authorization)
		return registrationService.delete(request)
	}

	@GetMapping("/read")
	fun read(@RequestHeader("Authorization") authorization:String, @PathVariable stage: String):registrationReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return registrationService.read()
	}

	@GetMapping("/read-by-registration-id/{registrationId}")
	fun readByRegistrationId(@RequestHeader("Authorization") authorization:String, @PathVariable registrationId:Int, @PathVariable stage: String):RegistrationReadSingleResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return registrationService.readByRegistrationId(registrationId)
	}

	@GetMapping("/read-by-registration-student-id/{registrationStudentId}")
	fun readByRegistrationStudentId(@RequestHeader("Authorization") authorization:String, @PathVariable registrationStudentId:Int, @PathVariable stage: String):RegistrationReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return registrationService.readByRegistrationStudentId(registrationStudentId)
	}

	@GetMapping("/read-by-registration-fee-id/{registrationFeeId}")
	fun readByRegistrationFeeId(@RequestHeader("Authorization") authorization:String, @PathVariable registrationFeeId:Int, @PathVariable stage: String):RegistrationReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return registrationService.readByRegistrationFeeId(registrationFeeId)
	}

	@GetMapping("/read-by-registration-date/{registrationDate}")
	fun readByRegistrationDate(@RequestHeader("Authorization") authorization:String, @PathVariable registrationDate:String, @PathVariable stage: String):RegistrationReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return registrationService.readByRegistrationDate(registrationDate)
	}

	@GetMapping("/read-by-registration-status/{registrationStatus}")
	fun readByRegistrationStatus(@RequestHeader("Authorization") authorization:String, @PathVariable registrationStatus:String, @PathVariable stage: String):RegistrationReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return registrationService.readByRegistrationStatus(registrationStatus)
	}

	@GetMapping("/read-by-registration-created-at/{registrationCreatedAt}")
	fun readByRegistrationCreatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable registrationCreatedAt:String, @PathVariable stage: String):RegistrationReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return registrationService.readByRegistrationCreatedAt(registrationCreatedAt)
	}

	@GetMapping("/read-by-registration-updated-at/{registrationUpdatedAt}")
	fun readByRegistrationUpdatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable registrationUpdatedAt:String, @PathVariable stage: String):RegistrationReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return registrationService.readByRegistrationUpdatedAt(registrationUpdatedAt)
	}

}
