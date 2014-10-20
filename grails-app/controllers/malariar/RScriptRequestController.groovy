package malariar

import grails.converters.JSON

class RScriptRequestController {

	def index() { }

	def newRequest(RequestObjectCommand reqObj){
		println(reqObj as JSON)
		render reqObj as JSON
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

