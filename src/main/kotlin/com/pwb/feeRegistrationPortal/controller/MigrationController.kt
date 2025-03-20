//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.495280900
package com.pwb.feeRegistrationPortal.controller

import com.pwb.feeRegistrationPortal.utility.Environment
import com.pwb.feeRegistrationPortal.utility.constant.PrefixConstant
import org.pwb.utility.constant.ResponseConstant
import org.pwb.utility.database.GenerateQuery
import org.pwb.utility.model.response.BaseDataResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/{stage}/migration")
class MigrationController(
    private val environment: Environment
) {

    @GetMapping("/execute")
    fun execute(@PathVariable stage: String): BaseDataResponse{
        return BaseDataResponse(
            responseCode = ResponseConstant.SUCCESS.responseCode,
            responseMessage = ResponseConstant.SUCCESS.responseMessage,
            data = GenerateQuery().createEntity(
                "com.pwb.feeRegistrationPortal.model.entity",
                PrefixConstant.ENTITY,
                environment.databaseUtil?.sql2oConnection!!,
                environment.executeDatabaseMigration
            )
        )
    }
}
