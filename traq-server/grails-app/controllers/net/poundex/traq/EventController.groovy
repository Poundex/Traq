package net.poundex.traq

import grails.rest.RestfulController
import net.poundex.traq.timeline.TimelineEvent

import java.time.LocalDate

class EventController extends RestfulController<TimelineEvent>
{
	static responseFormats = ['json']
	static allowedMethods = [index: 'GET']

	private final DtoService dtoService

	EventController(DtoService dtoService)
	{
		super(TimelineEvent, true)
		this.dtoService = dtoService
	}

	@Override
	def index()
	{
		LocalDate date = ! params['date'] || params['date'] == "today" ? LocalDate.now() : LocalDate.parse(params['date'])
		respond dtoService.toDtos(TimelineEvent.findAllByDate(date))
	}
}
