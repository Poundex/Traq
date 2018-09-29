package net.poundex.traq.server.web


import net.poundex.traq.server.domain.TimelineSpan
import net.poundex.traq.server.dto.DtoService
import net.poundex.traq.server.dto.TimelinePointDto
import net.poundex.traq.server.dto.TimelineSpanDto
import net.poundex.traq.server.service.EventService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/span")
class TimelineSpanController
{
	private final EventService eventService
	private final DtoService dtoService

	TimelineSpanController(EventService eventService, DtoService dtoService)
	{
		this.eventService = eventService
		this.dtoService = dtoService
	}

	@PostMapping
	TimelinePointDto save(@RequestBody TimelineSpanDto spanDto)
	{
		TimelineSpan span = new TimelineSpan()
		spanDto.apply(span)
		return dtoService.toDto(eventService.createSpan(span), TimelinePointDto)
	}
}
