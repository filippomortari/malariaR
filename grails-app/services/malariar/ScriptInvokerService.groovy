package malariar

import grails.transaction.Transactional

@Transactional
class ScriptInvokerService {

	def grailsApplication

	def serviceMethod() {

	}


	def runRScript(RequestObjectCommand rObj) {

		String[] envSettings = ["SGE_ROOT="+grailsApplication.config.SGE_ROOT,"SGE_QMASTER_PORT=6444","SGE_EXECD_PORT=6445","SGE_CELL="+grailsApplication.config.SGE_CELL,"SGE_CLUSTER_NAME="+grailsApplication.config.SGE_CLUSTER_NAME]
		String cmd = grailsApplication.config.SGE_ROOT+"/bin/lx26-amd64/qsub -pe smp 1 "+grailsApplication.config.R_SCRIPT_PATH+" "+grailsApplication.config.RESULT_TARGET_LOCATION+" "

		def sesID = UUID.randomUUID()
		cmd = cmd + sesID.toString() + 
				" " +
				//z
				((rObj.zVal!= null) ? rObj.zVal : rObj.zValDef )+" "+
				//k
				((rObj.kVal!= null) ? rObj.kVal : rObj.kValDef )+" "+
				// R
				"1 "+
				//cdr
				((rObj.cdrVal!= null) ? rObj.cdrVal : rObj.cdrValDef)+" "+
				//minFigRangeDef
				((rObj.minFigRange!= null) ? rObj.minFigRange : rObj.minFigRangeDef)+" "+
				((rObj.maxFigRange!= null) ? rObj.maxFigRange : rObj.maxFigRangeDef)+" "+
				rObj.nrOfPoints+" "+
				rObj.isLogXAxis+" "+
				rObj.email
		println(cmd)
		
		Process scriptProc = Runtime.getRuntime().exec(cmd,envSettings)
		
		return sesID
	}

	def hi(){
		println("hello")
	}
}
