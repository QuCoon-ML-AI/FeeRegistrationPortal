//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.762201
package com.pwb.feeRegistrationPortal.repository.database.query

import com.pwb.feeRegistrationPortal.utility.constant.PrefixConstant


object studentQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}STUDENT(
			studentEmail,
			studentName,
			studentStatus,
			studentCreatedAt,
			studentUpdatedAt,
			studentPassword
		) VALUES (
			:studentEmail,
			:studentName,
			COALESCE(:studentStatus,'ACTIVE'),
			COALESCE(:studentCreatedAt,getdate()),
			COALESCE(:studentUpdatedAt,getdate()),
			:studentPassword
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}STUDENT SET
			studentEmail=:studentEmail,
			studentName=:studentName,
			studentStatus=:studentStatus,
			studentCreatedAt=:studentCreatedAt,
			studentUpdatedAt=GETDATE(),
			studentPassword=:studentPassword
		WHERE studentId=:studentId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}STUDENT SET studentStatus = 'DELETED', studentUpdatedAt = GETDATE()
		WHERE studentId=:studentId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}STUDENT 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentStatus<>'DELETED'
	"""

	const val READ_BY_STUDENT_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentId=:studentId AND studentStatus<>'DELETED'
	"""

	const val READ_BY_STUDENT_EMAIL = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentEmail=:studentEmail AND studentStatus<>'DELETED'
	"""

	const val READ_BY_STUDENT_NAME = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentName=:studentName AND studentStatus<>'DELETED'
	"""

	const val READ_BY_STUDENT_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentStatus=:studentStatus AND studentStatus<>'DELETED'
	"""

	const val READ_BY_STUDENT_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentCreatedAt=:studentCreatedAt AND studentStatus<>'DELETED'
	"""

	const val READ_BY_STUDENT_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentUpdatedAt=:studentUpdatedAt AND studentStatus<>'DELETED'
	"""

	const val READ_BY_STUDENT_PASSWORD = """
		SELECT * FROM ${PrefixConstant.ENTITY}STUDENT WHERE studentPassword=:studentPassword AND studentStatus<>'DELETED'
	"""
}
