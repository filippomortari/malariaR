package malariar

import grails.transaction.Transactional

@Transactional
class ScriptInvokerService {
	
	def grailsApplication
	
    def serviceMethod() {

    }
	
	
	 def runRScript(RequestObjectCommand rObj) {

		 //String[] envSettings = ["SGE_ROOT="+grailsApplication.config.SGE_ROOT,"SGE_QMASTER_PORT=6444","SGE_EXECD_PORT=6445","SGE_CELL="+grailsApplication.config.SGE_CELL,"SGE_CLUSTER_NAME="+grailsApplication.config.SGE_CLUSTER_NAME]
		 String cmd = grailsApplication.config.SGE_ROOT+"/bin/lx26-amd64/qsub -pe smp 1 "+grailsApplication.config.R_SCRIPT_PATH+" "+grailsApplication.config.RESULT_TARGET_LOCATION+" "
		 
		 def sesID = UUID.randomUUID()
		 cmd = cmd + sesID.toString() + " 15 0.2 1 10 10 500 20 1"
		 println(cmd)
		 Process scriptProc = Runtime.getRuntime().exec(cmd)
		 
		 return sesID
	 }
	 
	 def hi(){
		 println("hello")
	 }
}
