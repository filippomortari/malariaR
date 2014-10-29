package malariar

import grails.transaction.Transactional


@Transactional
class UserNotificationService {
	
	def brokerMessagingTemplate
	
    def serviceMethod() {

    }
	
	void notify(def sesID, def data){
		def address = "/topic/"+sesID
		brokerMessagingTemplate.convertAndSend address, data
	}
}
