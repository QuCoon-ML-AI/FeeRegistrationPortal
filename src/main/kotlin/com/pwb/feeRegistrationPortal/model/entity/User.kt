//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.605778800
package com.pwb.feeRegistrationPortal.model.entity

import org.pwb.utility.annotation.Column
import org.pwb.utility.annotation.Table

@Table
data class User(
   	@Column(type="INT", primaryKey=true,reference="USER",autoIncrement=true,startValue=100,step=1)
	var userId: Int?=null,
	@Column(type="INT", nullable=true,reference="USER")
	var userRoleId: Int?=null,
	@Column(type="VARCHAR(n)", nullable=true,reference="USER",length=100)
	var userEmail: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,reference="USER",length=100)
	var userFirstName: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,reference="USER",length=100)
	var userLastName: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,reference="USER",length=100)
	var userPassword: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,reference="USER",length=100)
	var userPhoneNumber: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,reference="USER",length=100)
	var userJobRoleAlias: String?=null,
	@Column(type="VARCHAR(n)", nullable=true,reference="USER",defaultValue="ACTIVE'",length=100)
	var userStatus: String?=null,
	@Column(type="DATETIME", nullable=true,reference="USER",defaultValue="getdate()")
	var userCreatedAt: String?=null,
	@Column(type="DATETIME", nullable=true,reference="USER",defaultValue="getdate()")
	var userUpdatedAt: String?=null
)
