package malariar

import grails.transaction.Transactional

@Transactional
class ResponseManagerService {
	
	def grailsApplication
	
	def serviceMethod() {

	}

	def sendPost(def address, def attachmentLoc, def attachmentType){
		if (attachmentLoc == null){
			sendMail {
				to address
				from grailsApplication.config.MAIL_FROM
				subject "R script computation complete."
				body 'Your analysis has now completed. See the attached results.'
			}
		}
		else {
			sendMail {
				multipart true
				to address
				from grailsApplication.config.MAIL_FROM
				subject "R script computation complete."
				body 'Your analysis has now completed. See the attached results.'
				attachBytes attachmentLoc, attachmentType, new File(attachmentLoc).readBytes()
			}
		}

	}

	def sendResultsViaEmail(def sesID, def address){
		sendPost(address, grailsApplication.config.RESULT_TARGET_LOCATION+"/"+sesID+"/plot.pdf", "application/pdf")
	}
}
