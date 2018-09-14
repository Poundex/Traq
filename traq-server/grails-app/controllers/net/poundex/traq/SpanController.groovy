package net.poundex.traq


import grails.rest.RestfulController
import net.poundex.traq.timeline.TimelinePoint
import net.poundex.traq.timeline.TimelineSpan

class SpanController extends RestfulController<TimelineSpan>
{
	static responseFormats = ['json']

	SpanController()
	{
		super(TimelineSpan)
	}
}
