//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.777842500
package com.pwb.feeRegistrationPortal.service

import com.pwb.feeRegistrationPortal.repository.database.studentRepository
import com.pwb.feeRegistrationPortal.model.entity.student
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.model.response.BaseResponse
import org.springframework.stereotype.Service
import org.pwb.utility.constant.GSON
import com.pwb.feeRegistrationPortal.model.response.*
import com.pwb.feeRegistrationPortal.model.request.*
import org.pwb.utility.exception.*


@Service
class StudentService(
   private val studentRepository: StudentRepository
){
   	fun create(request:StudentCreateRequest):BaseResponse{
		val student = GSON.fromJson(GSON.toJson(request), Student::class.java).apply { studentStatus = studentStatus?:"ACTIVE" }
		studentRepository.create(student)
		return ResponseConstant.SUCCESS 
	}

	fun bulkCreate(request:List<StudentCreateRequest>):BaseResponse{
		val students = GSON.fromJson(GSON.toJson(request), Array<Student>::class.java).toList()
		studentRepository.bulkCreate(students)
		return ResponseConstant.SUCCESS
	}

	fun update(request:StudentUpdateRequest):BaseResponse{
		var student = studentRepository.readByStudentId(request.studentId!!)
			?:throw UnableToLocateRecordException()
		student = student.apply{
				studentId = request.studentId?:studentId
				studentEmail = request.studentEmail?:studentEmail
				studentName = request.studentName?:studentName
				studentStatus = request.studentStatus?:studentStatus
				studentPassword = request.studentPassword?:studentPassword
			}
		studentRepository.update(student)
		return ResponseConstant.SUCCESS
	}

	fun delete(request:StudentDeleteRequest):BaseResponse{
		var updateResponse = studentRepository.delete(request.studentId!!)
		if(updateResponse < 1) throw FailedToUpdateRecord()
		return ResponseConstant.SUCCESS
	}

	fun read():studentReadListResponse{
		var student = studentRepository.read()
		return studentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

	fun readByStudentId(studentId:Int): StudentReadSingleResponse{
		var student = studentRepository.readByStudentId(studentId) 
			?: throw UnableToLocateRecordException()
		return StudentReadSingleResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

	fun readByStudentEmail(studentEmail:String): StudentReadListResponse{
		var student = studentRepository.readByStudentEmail(studentEmail) 
		return StudentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

	fun readByStudentName(studentName:String): StudentReadListResponse{
		var student = studentRepository.readByStudentName(studentName) 
		return StudentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

	fun readByStudentStatus(studentStatus:String): StudentReadListResponse{
		var student = studentRepository.readByStudentStatus(studentStatus) 
		return StudentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

	fun readByStudentCreatedAt(studentCreatedAt:String): StudentReadListResponse{
		var student = studentRepository.readByStudentCreatedAt(studentCreatedAt) 
		return StudentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

	fun readByStudentUpdatedAt(studentUpdatedAt:String): StudentReadListResponse{
		var student = studentRepository.readByStudentUpdatedAt(studentUpdatedAt) 
		return StudentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

	fun readByStudentPassword(studentPassword:String): StudentReadListResponse{
		var student = studentRepository.readByStudentPassword(studentPassword) 
		return StudentReadListResponse(
			responseCode = ResponseConstant.SUCCESS.responseCode,
			responseMessage = ResponseConstant.SUCCESS.responseMessage,
			data = student
		)
	}

}
