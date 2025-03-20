//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.920001800
package com.pwb.feeRegistrationPortal.service

import com.pwb.feeRegistrationPortal.repository.database.registrationRepository
import com.pwb.feeRegistrationPortal.model.entity.registration
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.feeRegistrationPortal.model.response.*
import com.pwb.feeRegistrationPortal.model.request.*
import org.pwb.utility.exception.*


@Service
class RegistrationService(
   private val registrationRepository: RegistrationRepository
){
   	fun create(request:RegistrationCreateRequest):BaseResponse{
		val registration = GSON.fromJson(GSON.toJson(request), Registration::class.java).apply { registrationStatus = registrationStatus?:"ACTIVE" }
		registrationRepository.create(registration)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<RegistrationCreateRequest>):BaseResponse{
		val registrations = GSON.fromJson(GSON.toJson(request), Array<Registration>::class.java).toList()
		registrationRepository.bulkCreate(registrations)
		return ResponseConstant.SUCCESS
	}

	fun update(request:RegistrationUpdateRequest):BaseResponse{
		var registration = registrationRepository.readByRegistrationId(request.registrationId!!)
			?:throw UnableToLocateRecordException()
		registration = registration.apply{
				registrationId = request.registrationId?:registrationId
				registrationStudentId = request.registrationStudentId?:registrationStudentId
				registrationFeeId = request.registrationFeeId?:registrationFeeId
				registrationDate = request.registrationDate?:registrationDate
				registrationStatus = request.registrationStatus?:registrationStatus
			}
		registrationRepository.update(registration)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:RegistrationDeleteRequest):BaseResponse{
		var updateResponse = registrationRepository.delete(request.registrationId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():registrationReadListResponse{
		var registration = registrationRepository.read()
		return registrationReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = registration
		)
	}

	fun readByRegistrationId(registrationId:Int): RegistrationReadSingleResponse{
		var registration = registrationRepository.readByRegistrationId(registrationId) 
			?: throw UnableToLocateRecordException()
		return RegistrationReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = registration
		)
	}

	fun readByRegistrationStudentId(registrationStudentId:Int): RegistrationReadListResponse{
		var registration = registrationRepository.readByRegistrationStudentId(registrationStudentId) 
		return RegistrationReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = registration
		)
	}

	fun readByRegistrationFeeId(registrationFeeId:Int): RegistrationReadListResponse{
		var registration = registrationRepository.readByRegistrationFeeId(registrationFeeId) 
		return RegistrationReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = registration
		)
	}

	fun readByRegistrationDate(registrationDate:String): RegistrationReadListResponse{
		var registration = registrationRepository.readByRegistrationDate(registrationDate) 
		return RegistrationReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = registration
		)
	}

	fun readByRegistrationStatus(registrationStatus:String): RegistrationReadListResponse{
		var registration = registrationRepository.readByRegistrationStatus(registrationStatus) 
		return RegistrationReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = registration
		)
	}

	fun readByRegistrationCreatedAt(registrationCreatedAt:String): RegistrationReadListResponse{
		var registration = registrationRepository.readByRegistrationCreatedAt(registrationCreatedAt) 
		return RegistrationReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = registration
		)
	}

	fun readByRegistrationUpdatedAt(registrationUpdatedAt:String): RegistrationReadListResponse{
		var registration = registrationRepository.readByRegistrationUpdatedAt(registrationUpdatedAt) 
		return RegistrationReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = registration
		)
	}

}
