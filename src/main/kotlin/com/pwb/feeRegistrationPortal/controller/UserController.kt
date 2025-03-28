//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.621571600
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
@RequestMapping("/{stage}/user")
class UserController(
	private val userService: UserService,
	private val environment: Environment
){
   	@PostMapping("/create")
	fun create(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:UserCreateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return userService.create(request)
	}

	@PostMapping("/bulk-create")
	fun bulkCreate(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:List<UserCreateRequest>, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.CREATE),
			authorization)
		return userService.bulkCreate(request)
	}

	@PostMapping("/update")
	fun update(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:UserUpdateRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.UPDATE),
			authorization)
		return userService.update(request)
	}

	@PostMapping("/delete")
	fun delete(@RequestHeader("Authorization") authorization:String, @Valid @RequestBody request:UserDeleteRequest, @PathVariable stage: String):BaseResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.DELETE),
			authorization)
		return userService.delete(request)
	}

	@GetMapping("/read")
	fun read(@RequestHeader("Authorization") authorization:String, @PathVariable stage: String):UserReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userService.read()
	}

	@GetMapping("/read-by-user-id/{userId}")
	fun readByUserId(@RequestHeader("Authorization") authorization:String, @PathVariable userId:Int, @PathVariable stage: String):UserReadSingleResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userService.readByUserId(userId)
	}

	@GetMapping("/read-by-user-role-id/{userRoleId}")
	fun readByUserRoleId(@RequestHeader("Authorization") authorization:String, @PathVariable userRoleId:Int, @PathVariable stage: String):UserReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userService.readByUserRoleId(userRoleId)
	}

	@GetMapping("/read-by-user-email/{userEmail}")
	fun readByUserEmail(@RequestHeader("Authorization") authorization:String, @PathVariable userEmail:String, @PathVariable stage: String):UserReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userService.readByUserEmail(userEmail)
	}

	@GetMapping("/read-by-user-first-name/{userFirstName}")
	fun readByUserFirstName(@RequestHeader("Authorization") authorization:String, @PathVariable userFirstName:String, @PathVariable stage: String):UserReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userService.readByUserFirstName(userFirstName)
	}

	@GetMapping("/read-by-user-last-name/{userLastName}")
	fun readByUserLastName(@RequestHeader("Authorization") authorization:String, @PathVariable userLastName:String, @PathVariable stage: String):UserReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userService.readByUserLastName(userLastName)
	}

	@GetMapping("/read-by-user-password/{userPassword}")
	fun readByUserPassword(@RequestHeader("Authorization") authorization:String, @PathVariable userPassword:String, @PathVariable stage: String):UserReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userService.readByUserPassword(userPassword)
	}

	@GetMapping("/read-by-user-phone-number/{userPhoneNumber}")
	fun readByUserPhoneNumber(@RequestHeader("Authorization") authorization:String, @PathVariable userPhoneNumber:String, @PathVariable stage: String):UserReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userService.readByUserPhoneNumber(userPhoneNumber)
	}

	@GetMapping("/read-by-user-job-role-alias/{userJobRoleAlias}")
	fun readByUserJobRoleAlias(@RequestHeader("Authorization") authorization:String, @PathVariable userJobRoleAlias:String, @PathVariable stage: String):UserReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userService.readByUserJobRoleAlias(userJobRoleAlias)
	}

	@GetMapping("/read-by-user-status/{userStatus}")
	fun readByUserStatus(@RequestHeader("Authorization") authorization:String, @PathVariable userStatus:String, @PathVariable stage: String):UserReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userService.readByUserStatus(userStatus)
	}

	@GetMapping("/read-by-user-created-at/{userCreatedAt}")
	fun readByUserCreatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable userCreatedAt:String, @PathVariable stage: String):UserReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userService.readByUserCreatedAt(userCreatedAt)
	}

	@GetMapping("/read-by-user-updated-at/{userUpdatedAt}")
	fun readByUserUpdatedAt(@RequestHeader("Authorization") authorization:String, @PathVariable userUpdatedAt:String, @PathVariable stage: String):UserReadListResponse{
		environment.userInfo = environment.jwtUtil.privilegeAuthorization<LoginResponse>(
			ModulePrivilege(this::class.java.name.split(".").last().removeSuffix("Controller").camelToSnakeCase().uppercase(), PrivilegeConstant.READ),
			authorization)
		return userService.readByUserUpdatedAt(userUpdatedAt)
	}

}
