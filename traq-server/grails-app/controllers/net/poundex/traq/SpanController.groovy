package net.poundex.traq

import grails.gorm.transactions.Transactional
import grails.rest.RestfulController
import grails.web.http.HttpHeaders
import net.poundex.traq.timeline.TimelineSpan

import java.time.LocalTime

import static org.springframework.http.HttpStatus.CREATED

class SpanController extends RestfulController<TimelineSpan>
{
	static responseFormats = ['json']

	SpanController()
	{
		super(TimelineSpan)
	}

	@Transactional
	def save() {
		if(handleReadOnly()) {
			return
		}
		TimelineSpan instance = createResource()

		instance.validate()
		if (instance.hasErrors()) {
			transactionStatus.setRollbackOnly()
			respond instance.errors, view:'create' // STATUS CODE 422
			return
		}

		saveResource instance

		TimelineSpan.findByDateAndEndTimeAndIdNotEqual(instance.date, null, instance.id).each {
			it.endTime = LocalTime.now()
			it.save()
		}

		request.withFormat {
			form multipartForm {
				flash.message = message(code: 'default.created.message', args: [classMessageArg, instance.id])
				redirect instance
			}
			'*' {
				response.addHeader(HttpHeaders.LOCATION,
						grailsLinkGenerator.link( resource: this.controllerName, action: 'show',id: instance.id, absolute: true,
								namespace: hasProperty('namespace') ? this.namespace : null ))
				respond instance, [status: CREATED, view:'show']
			}
		}
	}
}
