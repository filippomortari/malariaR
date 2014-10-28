package malariar

import grails.converters.JSON
import grails.transaction.Transactional
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.util.Base64
import org.codehaus.groovy.grails.web.mapping.LinkGenerator

@Transactional
class ResponseManagerService {

	def grailsApplication
	def grailsLinkGenerator

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

	def packClientResponse(def sesID){
		
		//File imageFile =new File(grailsApplication.config.RESULT_TARGET_LOCATION+"/"+sesID+"/plot.png");
		//String base64String= imageFile.getBytes().encodeBase64().toString()
		def result = [imageURL:grailsLinkGenerator.link(controller: 'RScriptRequest', action: 'resultAsPNG', params:[sessionID:sesID], absolute: true)]

		return result
	}
	
	def retrieveResultAsImage(def sesID){
		File imageFile =new File(grailsApplication.config.RESULT_TARGET_LOCATION+"/"+sesID+"/plot.png");
		return imageFile
	}
}
