//TODO ==== BUILT WITH QOONITY VERSION-1.0 - YINKA-ANTHONY-NKAY ON 2025-03-20T08:30:15.479629900
package com.pwb.feeRegistrationPortal.lambda

import com.amazonaws.serverless.exceptions.ContainerInitializationException
import com.amazonaws.serverless.proxy.model.AwsProxyRequest
import com.amazonaws.serverless.proxy.model.AwsProxyResponse
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import com.pwb.feeRegistrationPortal.FeeRegistrationPortalApplication

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

//com.pwb.feeRegistrationPortal.lambda.LambdaProxy::handleRequest
class LambdaProxy : RequestStreamHandler {
	@Throws(IOException::class)
	override fun handleRequest(inputStream: InputStream, outputStream: OutputStream, context: Context) {
		handler?.proxyStream(inputStream, outputStream, context)
	}

	companion object {
		private var handler: SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse>? = null

		init {
			try {
				handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(
					FeeRegistrationPortalApplication::class.java
				)
			} catch (e: ContainerInitializationException) {
				// if we fail here. We re-throw the exception to force another cold start
				e.printStackTrace()
				throw RuntimeException("Could not initialize Spring framework", e)
			}
		}
	}
}

