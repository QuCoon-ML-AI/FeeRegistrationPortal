//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.920001800
package com.pwb.feeRegistrationPortal.repository.database.query

import com.pwb.feeRegistrationPortal.utility.constant.PrefixConstant


object registrationQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}REGISTRATION(
			registrationStudentId,
			registrationFeeId,
			registrationDate,
			registrationStatus,
			registrationCreatedAt,
			registrationUpdatedAt
		) VALUES (
			:registrationStudentId,
			:registrationFeeId,
			:registrationDate,
			COALESCE(:registrationStatus,'ACTIVE'),
			COALESCE(:registrationCreatedAt,getdate()),
			COALESCE(:registrationUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}REGISTRATION SET
			registrationStudentId=:registrationStudentId,
			registrationFeeId=:registrationFeeId,
			registrationDate=:registrationDate,
			registrationStatus=:registrationStatus,
			registrationCreatedAt=:registrationCreatedAt,
			registrationUpdatedAt=GETDATE()
		WHERE registrationId=:registrationId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}REGISTRATION SET registrationStatus = 'DELETED', registrationUpdatedAt = GETDATE()
		WHERE registrationId=:registrationId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}REGISTRATION 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}REGISTRATION WHERE registrationStatus<>'DELETED'
	"""

	const val READ_BY_REGISTRATION_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}REGISTRATION WHERE registrationId=:registrationId AND registrationStatus<>'DELETED'
	"""

	const val READ_BY_REGISTRATION_STUDENT_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}REGISTRATION WHERE registrationStudentId=:registrationStudentId AND registrationStatus<>'DELETED'
	"""

	const val READ_BY_REGISTRATION_FEE_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}REGISTRATION WHERE registrationFeeId=:registrationFeeId AND registrationStatus<>'DELETED'
	"""

	const val READ_BY_REGISTRATION_DATE = """
		SELECT * FROM ${PrefixConstant.ENTITY}REGISTRATION WHERE registrationDate=:registrationDate AND registrationStatus<>'DELETED'
	"""

	const val READ_BY_REGISTRATION_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}REGISTRATION WHERE registrationStatus=:registrationStatus AND registrationStatus<>'DELETED'
	"""

	const val READ_BY_REGISTRATION_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}REGISTRATION WHERE registrationCreatedAt=:registrationCreatedAt AND registrationStatus<>'DELETED'
	"""

	const val READ_BY_REGISTRATION_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}REGISTRATION WHERE registrationUpdatedAt=:registrationUpdatedAt AND registrationStatus<>'DELETED'
	"""
}
