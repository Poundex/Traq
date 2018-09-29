package net.poundex.traq.server.web

import net.poundex.traq.server.dao.TimelineEventRepository
import net.poundex.traq.server.domain.TimelineEvent
import net.poundex.traq.server.domain.TimelineSpan
import net.poundex.traq.server.dto.DayDto
import net.poundex.traq.server.dto.DtoService
import net.poundex.traq.server.dto.TimelineEventDto
import net.poundex.traq.server.dto.TimelineSpanDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.time.LocalDate

@RestController
@RequestMapping("/day")
class DayController
{
	private final DtoService dtoService
	private final TimelineEventRepository timelineEventRepository

	DayController(DtoService dtoService, TimelineEventRepository timelineEventRepository)
	{
		this.dtoService = dtoService
		this.timelineEventRepository = timelineEventRepository
	}

	@GetMapping
	DayDto viewDay(@RequestParam(required = false, name = "date") String forDate)
	{
		LocalDate date = ! forDate || forDate == "today" ? LocalDate.now() : LocalDate.parse(forDate)
		List<TimelineEvent> events = timelineEventRepository.findAllByDate(date)
		return new DayDto(date: date, events: dtoService.toDtos(events, TimelineEventDto, [(TimelineSpan): TimelineSpanDto]))
	}
}
