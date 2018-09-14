package net.poundex.traq.timeline

import java.time.Duration
import java.time.LocalTime

class TimelineSpan extends TimelineEvent
{
	LocalTime endTime

	Long getDuration()
	{
		Duration.between(startTime, endTime ?: LocalTime.now()).toMinutes()
	}

	static constraints = {
		endTime nullable: true
	}
}
