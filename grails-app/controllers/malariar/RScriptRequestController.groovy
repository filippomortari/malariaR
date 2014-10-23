package malariar

import grails.converters.JSON

class RScriptRequestController {
	
	def ScriptInvokerService

	def index() { }

	def newRequest(RequestObjectCommand reqObj){
		println(reqObj as JSON)
		UUID sesID = ScriptInvokerService.runRScript(reqObj)
		def result = [sessionID:sesID.toString()]
		render result as JSON
	}
}


class RequestObjectCommand {

	String diseaseName
	String species
	Boolean estimateR
	
	static constraints = {
		diseaseName nullable: true
		species nullable: true
		estimateR nullable: true
	}
	
	
}

