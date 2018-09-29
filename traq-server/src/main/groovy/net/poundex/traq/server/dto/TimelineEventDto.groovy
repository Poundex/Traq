package net.poundex.traq.server.dto

import groovy.transform.Canonical
import net.poundex.traq.server.domain.TimelineEvent

import java.time.LocalDate
import java.time.LocalTime

@Canonical
class TimelineEventDto<T extends TimelineEvent> implements Dto
{
	LocalDate date
	LocalTime startTime
	String description
	Iterable<TagDto> tags

	public void apply(T event)
	{
		event.date = date
		event.startTime = startTime
		event.description = description
	}
}
