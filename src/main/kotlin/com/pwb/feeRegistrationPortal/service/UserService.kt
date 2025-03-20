//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.621571600
package com.pwb.feeRegistrationPortal.service

import com.pwb.feeRegistrationPortal.repository.database.UserRepository
import com.pwb.feeRegistrationPortal.model.entity.User
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.feeRegistrationPortal.model.response.*
import com.pwb.feeRegistrationPortal.model.request.*
import org.pwb.utility.exception.*


@Service
class UserService(
   private val userRepository: UserRepository
){
   	fun create(request:UserCreateRequest):BaseResponse{
		val user = GSON.fromJson(GSON.toJson(request), User::class.java).apply { userStatus = userStatus?:"ACTIVE" }
		userRepository.create(user)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<UserCreateRequest>):BaseResponse{
		val users = GSON.fromJson(GSON.toJson(request), Array<User>::class.java).toList()
		userRepository.bulkCreate(users)
		return ResponseConstant.SUCCESS
	}

	fun update(request:UserUpdateRequest):BaseResponse{
		var user = userRepository.readByUserId(request.userId!!)
			?:throw UnableToLocateRecordException()
		user = user.apply{
				userId = request.userId?:userId
				userRoleId = request.userRoleId?:userRoleId
				userEmail = request.userEmail?:userEmail
				userFirstName = request.userFirstName?:userFirstName
				userLastName = request.userLastName?:userLastName
				userPassword = request.userPassword?:userPassword
				userPhoneNumber = request.userPhoneNumber?:userPhoneNumber
				userJobRoleAlias = request.userJobRoleAlias?:userJobRoleAlias
				userStatus = request.userStatus?:userStatus
			}
		userRepository.update(user)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:UserDeleteRequest):BaseResponse{
		var updateResponse = userRepository.delete(request.userId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():UserReadListResponse{
		var user = userRepository.read()
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserId(userId:Int): UserReadSingleResponse{
		var user = userRepository.readByUserId(userId) 
			?: throw UnableToLocateRecordException()
		return UserReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserRoleId(userRoleId:Int): UserReadListResponse{
		var user = userRepository.readByUserRoleId(userRoleId) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserEmail(userEmail:String): UserReadListResponse{
		var user = userRepository.readByUserEmail(userEmail) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserFirstName(userFirstName:String): UserReadListResponse{
		var user = userRepository.readByUserFirstName(userFirstName) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserLastName(userLastName:String): UserReadListResponse{
		var user = userRepository.readByUserLastName(userLastName) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserPassword(userPassword:String): UserReadListResponse{
		var user = userRepository.readByUserPassword(userPassword) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserPhoneNumber(userPhoneNumber:String): UserReadListResponse{
		var user = userRepository.readByUserPhoneNumber(userPhoneNumber) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserJobRoleAlias(userJobRoleAlias:String): UserReadListResponse{
		var user = userRepository.readByUserJobRoleAlias(userJobRoleAlias) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserStatus(userStatus:String): UserReadListResponse{
		var user = userRepository.readByUserStatus(userStatus) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserCreatedAt(userCreatedAt:String): UserReadListResponse{
		var user = userRepository.readByUserCreatedAt(userCreatedAt) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

	fun readByUserUpdatedAt(userUpdatedAt:String): UserReadListResponse{
		var user = userRepository.readByUserUpdatedAt(userUpdatedAt) 
		return UserReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = user
		)
	}

}
