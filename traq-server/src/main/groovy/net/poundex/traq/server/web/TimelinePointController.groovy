package net.poundex.traq.server.web


import net.poundex.traq.server.domain.TimelinePoint
import net.poundex.traq.server.dto.DtoService
import net.poundex.traq.server.dto.TimelinePointDto
import net.poundex.traq.server.service.EventService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/point")
class TimelinePointController
{
	private final EventService eventService
	private final DtoService dtoService

	TimelinePointController(EventService eventService, DtoService dtoService)
	{
		this.eventService = eventService
		this.dtoService = dtoService
	}

	@PostMapping
	TimelinePointDto save(@RequestBody TimelinePointDto pointDto)
	{
		TimelinePoint point = new TimelinePoint()
		pointDto.apply(point)
		return dtoService.toDto(eventService.updateEvent(point), TimelinePointDto)
	}
}
