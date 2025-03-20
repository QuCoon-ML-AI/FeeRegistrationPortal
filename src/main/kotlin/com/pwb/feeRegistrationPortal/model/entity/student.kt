//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.762201
package com.pwb.feeRegistrationPortal.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class student(
   	@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1,defaultValue="100")
	var studentId: Int?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var studentEmail: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var studentName: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,defaultValue="'ACTIVE'",length=100)
	var studentStatus: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var studentCreatedAt: String?=null,
	@Column(type="DATETIME", nullable=true,defaultValue="getdate()")
	var studentUpdatedAt: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,length=100)
	var studentPassword: String?=null
)
