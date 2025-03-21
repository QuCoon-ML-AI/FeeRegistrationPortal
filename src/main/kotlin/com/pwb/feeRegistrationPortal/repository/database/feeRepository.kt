//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.841198800
package com.pwb.feeRegistrationPortal.repository.database

import com.pwb.feeRegistrationPortal.model.entity.fee
import com.pwb.feeRegistrationPortal.utility.Environment
import org.pwb.utility.general.createQueryWithoutOnMappingFailure
import com.pwb.feeRegistrationPortal.repository.database.query.FeeQuery
import org.springframework.stereotype.Repository



@Repository
interface FeeRepository{
   	fun create(fee:fee):Long
	fun bulkCreate(fees:List<fee>)
	fun update(fee:fee):Int
	fun delete(feeId:Int):Int
	fun truncate(): Boolean
	fun read():MutableList<fee>
	fun readByFeeId(feeId: Int):Fee?
	fun readByFeeAmount(feeAmount: String):MutableList<Fee>
	fun readByFeeDescription(feeDescription: String):MutableList<Fee>
	fun readByFeeStatus(feeStatus: String):MutableList<Fee>
	fun readByFeeCreatedAt(feeCreatedAt: String):MutableList<Fee>
	fun readByFeeUpdatedAt(feeUpdatedAt: String):MutableList<Fee>
}

@Repository
class FeeRepositoryImpl(private val environment: Environment): FeeRepository{
   	override fun create(fee:Fee):Long{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(FeeQuery.INSERT)
			.bind(fee)
			.executeUpdate().getKey(Long::class.java)
	}

	override fun bulkCreate(fees:List<fee>){
		environment.databaseUtil?.getSql2o()?.beginTransaction().use { connection ->
			val query = connection?.createQueryWithoutOnMappingFailure(FeeQuery.INSERT, false)
			for (fee in fees)
				query?.bind(fee)?.addToBatch()
			query?.executeBatch()
			connection?.commit()
		}
	}

	override fun update(fee:Fee):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(FeeQuery.UPDATE)
		.bind(fee)
		.executeUpdate().result
	}

	override fun delete(feeId:Int):Int{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(FeeQuery.DELETE)
		.addParameter("feeId", feeId)
		.executeUpdate().result
	}

	override fun truncate(): Boolean{
		return environment.databaseUtil?.sql2oConnection!!.jdbcConnection.createStatement().execute(FeeQuery.TRUNCATE)
	}

	override fun read():MutableList<fee>{
		return environment.databaseUtil?.sql2oConnection!!.createQueryWithoutOnMappingFailure(FeeQuery.READ)
		.executeAndFetch(fee::class.java)
	}

	override fun readByFeeId(feeId: Int):Fee?{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(FeeQuery.READ_BY_FEE_ID)
				.addParameter("feeId", feeId)
				.executeAndFetch(Fee::class.java).firstOrNull()
	}

	override fun readByFeeAmount(feeAmount: String):MutableList<Fee>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(FeeQuery.READ_BY_FEE_AMOUNT)
				.addParameter("feeAmount", feeAmount)
				.executeAndFetch(Fee::class.java)
	}

	override fun readByFeeDescription(feeDescription: String):MutableList<Fee>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(FeeQuery.READ_BY_FEE_DESCRIPTION)
				.addParameter("feeDescription", feeDescription)
				.executeAndFetch(Fee::class.java)
	}

	override fun readByFeeStatus(feeStatus: String):MutableList<Fee>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(FeeQuery.READ_BY_FEE_STATUS)
				.addParameter("feeStatus", feeStatus)
				.executeAndFetch(Fee::class.java)
	}

	override fun readByFeeCreatedAt(feeCreatedAt: String):MutableList<Fee>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(FeeQuery.READ_BY_FEE_CREATED_AT)
				.addParameter("feeCreatedAt", feeCreatedAt)
				.executeAndFetch(Fee::class.java)
	}

	override fun readByFeeUpdatedAt(feeUpdatedAt: String):MutableList<Fee>{
		return environment.databaseUtil?.sql2oConnection!!
				.createQueryWithoutOnMappingFailure(FeeQuery.READ_BY_FEE_UPDATED_AT)
				.addParameter("feeUpdatedAt", feeUpdatedAt)
				.executeAndFetch(Fee::class.java)
	}
}
