//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.621571600
package com.pwb.feeRegistrationPortal.repository.database

import com.pwb.feeRegistrationPortal.model.entity.User
import com.pwb.feeRegistrationPortal.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.feeRegistrationPortal.repository.database.query.UserQuery
import org.springframework.stereotype.Repository



@Repository
interface UserRepository{
   	fun create(user:User):Long
	fun bulkCreate(users:List<User>)
	fun update(user:User):Int
	fun delete(userId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<User>
	fun readByUserId(userId: Int):User?
	fun readByUserRoleId(userRoleId: Int):MutableList<User>
	fun readByUserEmail(userEmail: String):MutableList<User>
	fun readByUserFirstName(userFirstName: String):MutableList<User>
	fun readByUserLastName(userLastName: String):MutableList<User>
	fun readByUserPassword(userPassword: String):MutableList<User>
	fun readByUserPhoneNumber(userPhoneNumber: String):MutableList<User>
	fun readByUserJobRoleAlias(userJobRoleAlias: String):MutableList<User>
	fun readByUserStatus(userStatus: String):MutableList<User>
	fun readByUserCreatedAt(userCreatedAt: String):MutableList<User>
	fun readByUserUpdatedAt(userUpdatedAt: String):MutableList<User>
}

@Repository
class UserRepositoryImpl(private val environment: Environment): UserRepository{
   	override fun create(user:User):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(UserQuery.INSERT)
			.bind(user)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(users:List<User>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(UserQuery.INSERT, false)
			for (user in users)
				query?.bind(user)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(user:User):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(UserQuery.UPDATE)
		.bind(user)
		.executeUpdate().result
	}

	override fun delete(userId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(UserQuery.DELETE)
		.addParameter("userId", userId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(UserQuery.TRUNCATE)
	}

	override fun read():MutableList<User>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(UserQuery.READ)
		.executeAndFetch(User::class.java)
	}

	override fun readByUserId(userId: Int):User?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserQuery.READ_BY_USER_ID)
				.addParameter("userId", userId)
				.executeAndFetch(User::class.java).firstOrNull()
	}

	override fun readByUserRoleId(userRoleId: Int):MutableList<User>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserQuery.READ_BY_USER_ROLE_ID)
				.addParameter("userRoleId", userRoleId)
				.executeAndFetch(User::class.java)
	}

	override fun readByUserEmail(userEmail: String):MutableList<User>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserQuery.READ_BY_USER_EMAIL)
				.addParameter("userEmail", userEmail)
				.executeAndFetch(User::class.java)
	}

	override fun readByUserFirstName(userFirstName: String):MutableList<User>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserQuery.READ_BY_USER_FIRST_NAME)
				.addParameter("userFirstName", userFirstName)
				.executeAndFetch(User::class.java)
	}

	override fun readByUserLastName(userLastName: String):MutableList<User>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserQuery.READ_BY_USER_LAST_NAME)
				.addParameter("userLastName", userLastName)
				.executeAndFetch(User::class.java)
	}

	override fun readByUserPassword(userPassword: String):MutableList<User>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserQuery.READ_BY_USER_PASSWORD)
				.addParameter("userPassword", userPassword)
				.executeAndFetch(User::class.java)
	}

	override fun readByUserPhoneNumber(userPhoneNumber: String):MutableList<User>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserQuery.READ_BY_USER_PHONE_NUMBER)
				.addParameter("userPhoneNumber", userPhoneNumber)
				.executeAndFetch(User::class.java)
	}

	override fun readByUserJobRoleAlias(userJobRoleAlias: String):MutableList<User>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserQuery.READ_BY_USER_JOB_ROLE_ALIAS)
				.addParameter("userJobRoleAlias", userJobRoleAlias)
				.executeAndFetch(User::class.java)
	}

	override fun readByUserStatus(userStatus: String):MutableList<User>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserQuery.READ_BY_USER_STATUS)
				.addParameter("userStatus", userStatus)
				.executeAndFetch(User::class.java)
	}

	override fun readByUserCreatedAt(userCreatedAt: String):MutableList<User>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserQuery.READ_BY_USER_CREATED_AT)
				.addParameter("userCreatedAt", userCreatedAt)
				.executeAndFetch(User::class.java)
	}

	override fun readByUserUpdatedAt(userUpdatedAt: String):MutableList<User>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(UserQuery.READ_BY_USER_UPDATED_AT)
				.addParameter("userUpdatedAt", userUpdatedAt)
				.executeAndFetch(User::class.java)
	}
}
