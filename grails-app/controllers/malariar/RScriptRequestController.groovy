package malariar

import grails.converters.JSON

class RScriptRequestController {
	
	def ScriptInvokerService
	def ResponseManagerService

	def index() { }

	def newRequest(RequestObjectCommand reqObj){
		println(reqObj as JSON)
		UUID sesID = ScriptInvokerService.runRScript(reqObj)
		def result = [sessionID:sesID.toString()]
		render result as JSON
	}
	
	def notifyResults(){
		def sesID = params.sessionID
		def email = params.email
		
		ResponseManagerService.sendResultsViaEmail(sesID,email);
		def jsonImageResponse = ResponseManagerService.packClientResponse(sesID);
		render jsonImageResponse as JSON
	}
	
	def resultAsPNG(){
		def sesID = params.sessionID
		
		File file = ResponseManagerService.retrieveResultAsImage(sesID)
		
		response.setHeader('Cache-Control', 'no-cache')
		response.contentType = "image/png"
		response.outputStream << file.getBytes()
		response.outputStream.flush()
	}
}


class RequestObjectCommand {

	String diseaseName
	String species
	Boolean estimateR
	
	Double zValDef
	Integer isDefZ
	Double zVal
	Double kValDef
	Integer isDefK
	Double kVal
	Integer cdrVal
	Integer cdrValDef
	Integer isDefCDR
	Integer isFigure
	Integer minFigRange
	Integer minFigRangeDef
	Integer isDefMinFR
	Integer maxFigRange
	Integer maxFigRangeDef
	Integer isDefMaxFR
	Integer nrOfPoints
	Integer isLogXAxis
	
	String email
	
	static constraints = {
		diseaseName nullable: true
		species nullable: true
		estimateR nullable: true
		zValDef nullable: true
		isDefZ nullable: true
		zVal nullable: true
		kValDef nullable: true
		isDefK nullable: true
		kVal nullable: true
		cdrVal nullable: true 
		cdrValDef nullable: true
		isDefCDR nullable: true
		isFigure nullable: true
		minFigRange nullable: true
		minFigRangeDef nullable: true
		isDefMinFR nullable: true
		maxFigRange nullable: true
		maxFigRangeDef nullable: true
		isDefMaxFR nullable: true
		nrOfPoints nullable: true
		isLogXAxis nullable: true
	}
	
	
}

