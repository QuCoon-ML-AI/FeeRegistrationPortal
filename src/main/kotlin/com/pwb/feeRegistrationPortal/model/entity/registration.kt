//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.920001800
package com.pwb.feeRegistrationPortal.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class registration(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var registrationId: Int?=null,
	@Column(type="INT", nullable=true,foreignKey=true,reference="STUDENT(studentId)")
	var registrationStudentId: Int?=null,
	@Column(type="INT", nullable=true,foreignKey=true,reference="FEE(feeId)")
	var registrationFeeId: Int?=null,
	@Column(type="DATETIME", nullable=true)
	var registrationDate: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,defaultValue="'ACTIVE'",length=100)
	var registrationStatus: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var registrationCreatedAt: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var registrationUpdatedAt: String?=null
)
