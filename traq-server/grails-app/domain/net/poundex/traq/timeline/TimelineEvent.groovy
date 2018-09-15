package net.poundex.traq.timeline

import grails.databinding.BindUsing

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

abstract class TimelineEvent
{
//	LocalDate date
//	@BindUsing({ obj, source ->
//		source['startTime'].with {
//			if (it instanceof LocalTime) return it
//			else return LocalTime.parse(it.toString())
//		}
//	})
//	LocalTime startTime
	LocalDateTime startTime
	String description

	static constraints = {
	}
}
