package net.poundex.traq.server.web

import groovy.transform.CompileStatic
import net.poundex.traq.server.dao.TimelineEventRepository
import net.poundex.traq.server.domain.Tag
import net.poundex.traq.server.domain.TimelineEvent
import net.poundex.traq.server.domain.TimelineSpan
import net.poundex.traq.server.dto.*
import net.poundex.traq.server.service.EventService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.time.LocalDate

@RestController
@RequestMapping("/day")
@CompileStatic
class DayController
{
	private final DtoService dtoService
	private final TimelineEventRepository timelineEventRepository
	private final EventService eventService

	DayController(DtoService dtoService, TimelineEventRepository timelineEventRepository, EventService eventService)
	{
		this.dtoService = dtoService
		this.timelineEventRepository = timelineEventRepository
		this.eventService = eventService
	}

	@GetMapping
	DayDto viewDay(@RequestParam(required = false, name = "date") String forDate)
	{
		LocalDate date = ! forDate || forDate == "today" ? LocalDate.now() : LocalDate.parse(forDate)
		List<TimelineEvent> events = timelineEventRepository.findAllByDate(date)
		DayDto dayDto = new DayDto(date: date, events: dtoService.toDtos(events, TimelineEventDto, [(TimelineSpan): TimelineSpanDto]))
		List<TimelineSpan> spans = events.findAll { it instanceof TimelineSpan } as List<TimelineSpan>
		Map<Tag, Long> tags = eventService.getTags(spans)
		dayDto.tagSummary = new TagSummary(tagSummaryEntries: tags
				.sort { l, r -> r.value <=> l.value }
				.collect { k, v -> new TagSummary.TagSummaryEntry(tag: dtoService.toDto(k, TagDto), duration: v) } )
		dayDto.durationTotal = (spans*.duration as long[]).sum()
		dayDto.durationAccountable = dayDto.durationTotal - ((spans.findAll {
			it.hasTag("noaccount")
		})*.duration as long[]).sum()
		dayDto.durationProductive = dayDto.durationTotal - ((spans.findAll {
			it.hasTag("noprod")
		})*.duration as long[]).sum()
		return dayDto
	}
}
