package net.poundex.traq.server.domain

import javax.persistence.Entity
import java.time.Duration
import java.time.LocalTime

@Entity
class TimelineSpan extends TimelineEvent
{
	LocalTime endTime

	Long getDuration()
	{
		Duration.between(startTime, endTime ?: LocalTime.now()).toMinutes()
	}
}
