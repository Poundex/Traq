package net.poundex.traq.server.dto

import groovy.transform.Canonical
import net.poundex.traq.server.domain.TimelineEvent
import net.poundex.traq.server.domain.TimelineSpan

import java.time.LocalTime

@Canonical
class TimelineSpanDto extends TimelineEventDto<TimelineSpan>
{
	LocalTime endTime
	Long duration

	@Override
	void apply(TimelineSpan event)
	{
		super.apply(event)
		event.endTime = endTime
	}
}
