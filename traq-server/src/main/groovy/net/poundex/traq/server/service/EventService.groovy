package net.poundex.traq.server.service

import groovy.transform.CompileStatic
import net.poundex.traq.server.dao.TimelineEventRepository
import net.poundex.traq.server.dao.TimelineSpanRepository
import net.poundex.traq.server.domain.TimelineEvent
import net.poundex.traq.server.domain.TimelineSpan
import org.springframework.stereotype.Service

import java.time.LocalTime

@CompileStatic
@Service
class EventService
{
	private final TagService tagService
	private final TimelineSpanRepository timelineSpanRepository
	private final TimelineEventRepository timelineEventRepository

	EventService(TagService tagService, TimelineSpanRepository timelineSpanRepository, TimelineEventRepository timelineEventRepository)
	{
		this.tagService = tagService
		this.timelineSpanRepository = timelineSpanRepository
		this.timelineEventRepository = timelineEventRepository
	}

	TimelineSpan createSpan(TimelineSpan timelineSpan)
	{
		updateEvent(timelineSpan)
		timelineSpanRepository.findAllByDateAndEndTimeAndIdNot(timelineSpan.date, null, timelineSpan.id).each { TimelineSpan span ->
			span.endTime = LocalTime.now()
			timelineSpanRepository.save(span)
		}
		return timelineSpan
	}

	public <T extends TimelineEvent> T updateEvent(T timelineEvent)
	{
		List<String> tagTexts = timelineEvent.description.findAll("#[A-Za-z0-9_-]+")*.replace('#', '')
		if(timelineEvent.tags == null)
			timelineEvent.tags = new HashSet<>()
		timelineEvent.tags.clear()
		timelineEvent.tags.addAll(tagService.findOrCreateAllByText(tagTexts))
		timelineEventRepository.save(timelineEvent)
		return timelineEvent
	}
}
