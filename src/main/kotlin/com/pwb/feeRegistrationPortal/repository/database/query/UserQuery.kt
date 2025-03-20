//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.621571600
package com.pwb.feeRegistrationPortal.repository.database.query

import com.pwb.feeRegistrationPortal.utility.constant.PrefixConstant


object UserQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}USER(
			userRoleId,
			userEmail,
			userFirstName,
			userLastName,
			userPassword,
			userPhoneNumber,
			userJobRoleAlias,
			userStatus,
			userCreatedAt,
			userUpdatedAt
		) VALUES (
			:userRoleId,
			:userEmail,
			:userFirstName,
			:userLastName,
			:userPassword,
			:userPhoneNumber,
			:userJobRoleAlias,
			COALESCE(:userStatus,ACTIVE'),
			COALESCE(:userCreatedAt,getdate()),
			COALESCE(:userUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}USER SET
			userRoleId=:userRoleId,
			userEmail=:userEmail,
			userFirstName=:userFirstName,
			userLastName=:userLastName,
			userPassword=:userPassword,
			userPhoneNumber=:userPhoneNumber,
			userJobRoleAlias=:userJobRoleAlias,
			userStatus=:userStatus,
			userCreatedAt=:userCreatedAt,
			userUpdatedAt=GETDATE()
		WHERE userId=:userId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}USER SET userStatus = 'DELETED', userUpdatedAt = GETDATE()
		WHERE userId=:userId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}USER 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userStatus<>'DELETED'
	"""

	const val READ_BY_USER_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userId=:userId AND userStatus<>'DELETED'
	"""

	const val READ_BY_USER_ROLE_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userRoleId=:userRoleId AND userStatus<>'DELETED'
	"""

	const val READ_BY_USER_EMAIL = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userEmail=:userEmail AND userStatus<>'DELETED'
	"""

	const val READ_BY_USER_FIRST_NAME = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userFirstName=:userFirstName AND userStatus<>'DELETED'
	"""

	const val READ_BY_USER_LAST_NAME = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userLastName=:userLastName AND userStatus<>'DELETED'
	"""

	const val READ_BY_USER_PASSWORD = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userPassword=:userPassword AND userStatus<>'DELETED'
	"""

	const val READ_BY_USER_PHONE_NUMBER = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userPhoneNumber=:userPhoneNumber AND userStatus<>'DELETED'
	"""

	const val READ_BY_USER_JOB_ROLE_ALIAS = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userJobRoleAlias=:userJobRoleAlias AND userStatus<>'DELETED'
	"""

	const val READ_BY_USER_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userStatus=:userStatus AND userStatus<>'DELETED'
	"""

	const val READ_BY_USER_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userCreatedAt=:userCreatedAt AND userStatus<>'DELETED'
	"""

	const val READ_BY_USER_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}USER WHERE userUpdatedAt=:userUpdatedAt AND userStatus<>'DELETED'
	"""
}
