//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.841198800
package com.pwb.feeRegistrationPortal.repository.database.query

import com.pwb.feeRegistrationPortal.utility.constant.PrefixConstant


object feeQuery{
   	const val INSERT = """
		INSERT INTO ${PrefixConstant.ENTITY}FEE(
			feeAmount,
			feeDescription,
			feeStatus,
			feeCreatedAt,
			feeUpdatedAt
		) VALUES (
			:feeAmount,
			:feeDescription,
			COALESCE(:feeStatus,'ACTIVE'),
			COALESCE(:feeCreatedAt,getdate()),
			COALESCE(:feeUpdatedAt,getdate())
		)
	"""

	const val UPDATE = """
		UPDATE ${PrefixConstant.ENTITY}FEE SET
			feeAmount=:feeAmount,
			feeDescription=:feeDescription,
			feeStatus=:feeStatus,
			feeCreatedAt=:feeCreatedAt,
			feeUpdatedAt=GETDATE()
		WHERE feeId=:feeId
	"""

	const val DELETE = """
		UPDATE ${PrefixConstant.ENTITY}FEE SET feeStatus = 'DELETED', feeUpdatedAt = GETDATE()
		WHERE feeId=:feeId
	"""

	const val TRUNCATE = """
		TRUNCATE TABLE ${PrefixConstant.ENTITY}FEE 
	"""

	const val READ = """
		SELECT * FROM ${PrefixConstant.ENTITY}FEE WHERE feeStatus<>'DELETED'
	"""

	const val READ_BY_FEE_ID = """
		SELECT * FROM ${PrefixConstant.ENTITY}FEE WHERE feeId=:feeId AND feeStatus<>'DELETED'
	"""

	const val READ_BY_FEE_AMOUNT = """
		SELECT * FROM ${PrefixConstant.ENTITY}FEE WHERE feeAmount=:feeAmount AND feeStatus<>'DELETED'
	"""

	const val READ_BY_FEE_DESCRIPTION = """
		SELECT * FROM ${PrefixConstant.ENTITY}FEE WHERE feeDescription=:feeDescription AND feeStatus<>'DELETED'
	"""

	const val READ_BY_FEE_STATUS = """
		SELECT * FROM ${PrefixConstant.ENTITY}FEE WHERE feeStatus=:feeStatus AND feeStatus<>'DELETED'
	"""

	const val READ_BY_FEE_CREATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}FEE WHERE feeCreatedAt=:feeCreatedAt AND feeStatus<>'DELETED'
	"""

	const val READ_BY_FEE_UPDATED_AT = """
		SELECT * FROM ${PrefixConstant.ENTITY}FEE WHERE feeUpdatedAt=:feeUpdatedAt AND feeStatus<>'DELETED'
	"""
}
