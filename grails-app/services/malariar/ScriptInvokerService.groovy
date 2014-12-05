package malariar

import grails.transaction.Transactional

@Transactional
class ScriptInvokerService {

	def grailsApplication

	def serviceMethod() {

	}


	def runRScript(RequestObjectCommand rObj) {

		String[] envSettings = ["SGE_ROOT="+grailsApplication.config.SGE_ROOT,"SGE_QMASTER_PORT=6444","SGE_EXECD_PORT=6445","SGE_CELL="+grailsApplication.config.SGE_CELL,"SGE_CLUSTER_NAME="+grailsApplication.config.SGE_CLUSTER_NAME]
		String cmd = grailsApplication.config.SGE_ROOT+"/bin/lx26-amd64/qsub -q quick "+grailsApplication.config.R_SCRIPT_PATH+" -p "+grailsApplication.config.RESULT_TARGET_LOCATION+" "

		def sesID = UUID.randomUUID()
		cmd = cmd +" -l "+ sesID.toString() +
				" -P " + ((rObj.isFigure== 1) ? "T" : "F" ) +
				" -e " + ((rObj.estimateR == true) ? "T" : "F" ) +
				//z
				" -Z "+((rObj.isDefZ == 0) ? rObj.zVal : rObj.zValDef )+" "+
				//k
				"-k "+((rObj.isDefK == 0) ? rObj.kVal : rObj.kValDef )+" "+
				//imported
				"-i "+((rObj.isDefImported == 0) ? rObj.imported : rObj.importedDef )+" "+
				//detected
				"-c "+((rObj.isDefCasesDetected == 0) ? rObj.casesDetected : rObj.casesDetectedDef )+" "+
				//cdr
				"-d "+((rObj.isDefCDR == 0) ? rObj.cdrVal : rObj.cdrValDef)+" "+
				//minFigRangeDef
				"-m "+((rObj.isDefMinFR == 0) ? rObj.minFigRange : rObj.minFigRangeDef)+" "+
				"-x "+((rObj.isDefMaxFR == 0) ? rObj.maxFigRange : rObj.maxFigRangeDef)+" "+
				"-n " + rObj.nrOfPoints+" "+
				"-s "+ rObj.isLogXAxis+" "+
				"-R 1"+" "+
				"-E "+rObj.email
		println(cmd)
		
		Process scriptProc = Runtime.getRuntime().exec(cmd,envSettings)
		
		return sesID
	}

	def hi(){
		println("hello")
	}
}
