package malariar

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(RScriptRequestController)
class RScriptRequestControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test of example JSON request from AngularJS client"() {
		given: "JSON content to the body of the request"
			controller.request.content = '{"diseaseName":"","species":"","estimateR":""}'
		
		when:"newRequest method is called"
			controller.newRequest()
		
		then:"assert that request appears to have worked"
			controller.response.status == 200
			controller.response.contentAsString == '{"diseaseName":null,"errors":{"errors":[]},"estimateR":null,"species":null}'
    }
}
