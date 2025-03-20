//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.920001800
package com.pwb.feeRegistrationPortal.repository.database

import com.pwb.feeRegistrationPortal.model.entity.registration
import com.pwb.feeRegistrationPortal.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.feeRegistrationPortal.repository.database.query.RegistrationQuery
import org.springframework.stereotype.Repository



@Repository
interface RegistrationRepository{
   	fun create(registration:registration):Long
	fun bulkCreate(registrations:List<registration>)
	fun update(registration:registration):Int
	fun delete(registrationId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<registration>
	fun readByRegistrationId(registrationId: Int):Registration?
	fun readByRegistrationStudentId(registrationStudentId: Int):MutableList<Registration>
	fun readByRegistrationFeeId(registrationFeeId: Int):MutableList<Registration>
	fun readByRegistrationDate(registrationDate: String):MutableList<Registration>
	fun readByRegistrationStatus(registrationStatus: String):MutableList<Registration>
	fun readByRegistrationCreatedAt(registrationCreatedAt: String):MutableList<Registration>
	fun readByRegistrationUpdatedAt(registrationUpdatedAt: String):MutableList<Registration>
}

@Repository
class RegistrationRepositoryImpl(private val environment: Environment): RegistrationRepository{
   	override fun create(registration:Registration):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(RegistrationQuery.INSERT)
			.bind(registration)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(registrations:List<registration>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(RegistrationQuery.INSERT, false)
			for (registration in registrations)
				query?.bind(registration)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(registration:Registration):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(RegistrationQuery.UPDATE)
		.bind(registration)
		.executeUpdate().result
	}

	override fun delete(registrationId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(RegistrationQuery.DELETE)
		.addParameter("registrationId", registrationId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(RegistrationQuery.TRUNCATE)
	}

	override fun read():MutableList<registration>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(RegistrationQuery.READ)
		.executeAndFetch(registration::class.java)
	}

	override fun readByRegistrationId(registrationId: Int):Registration?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RegistrationQuery.READ_BY_REGISTRATION_ID)
				.addParameter("registrationId", registrationId)
				.executeAndFetch(Registration::class.java).firstOrNull()
	}

	override fun readByRegistrationStudentId(registrationStudentId: Int):MutableList<Registration>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RegistrationQuery.READ_BY_REGISTRATION_STUDENT_ID)
				.addParameter("registrationStudentId", registrationStudentId)
				.executeAndFetch(Registration::class.java)
	}

	override fun readByRegistrationFeeId(registrationFeeId: Int):MutableList<Registration>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RegistrationQuery.READ_BY_REGISTRATION_FEE_ID)
				.addParameter("registrationFeeId", registrationFeeId)
				.executeAndFetch(Registration::class.java)
	}

	override fun readByRegistrationDate(registrationDate: String):MutableList<Registration>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RegistrationQuery.READ_BY_REGISTRATION_DATE)
				.addParameter("registrationDate", registrationDate)
				.executeAndFetch(Registration::class.java)
	}

	override fun readByRegistrationStatus(registrationStatus: String):MutableList<Registration>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RegistrationQuery.READ_BY_REGISTRATION_STATUS)
				.addParameter("registrationStatus", registrationStatus)
				.executeAndFetch(Registration::class.java)
	}

	override fun readByRegistrationCreatedAt(registrationCreatedAt: String):MutableList<Registration>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RegistrationQuery.READ_BY_REGISTRATION_CREATED_AT)
				.addParameter("registrationCreatedAt", registrationCreatedAt)
				.executeAndFetch(Registration::class.java)
	}

	override fun readByRegistrationUpdatedAt(registrationUpdatedAt: String):MutableList<Registration>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(RegistrationQuery.READ_BY_REGISTRATION_UPDATED_AT)
				.addParameter("registrationUpdatedAt", registrationUpdatedAt)
				.executeAndFetch(Registration::class.java)
	}
}
