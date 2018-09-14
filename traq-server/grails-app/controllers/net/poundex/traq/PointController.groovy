package net.poundex.traq


import grails.rest.*
import grails.converters.*
import net.poundex.traq.timeline.TimelinePoint

class PointController extends RestfulController<TimelinePoint>
{
	static responseFormats = ['json']

	PointController()
	{
		super(TimelinePoint)
	}
}
