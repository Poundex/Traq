package net.poundex.traq.timeline

import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

class TimelineSpan extends TimelineEvent
{
//	LocalTime endTime
	LocalDateTime endTime

	Long getDuration()
	{
		Duration.between(startTime, endTime ?: LocalDateTime.now()).toMinutes()
	}

	static constraints = {
		endTime nullable: true
	}
}
