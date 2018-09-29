package net.poundex.traq.server.dto

import groovy.transform.Canonical

import java.time.LocalDate

@Canonical
class DayDto implements Dto
{
	LocalDate date
	Iterable<TimelineEventDto> events
}
