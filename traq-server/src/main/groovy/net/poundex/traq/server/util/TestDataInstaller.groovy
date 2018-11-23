package net.poundex.traq.server.util

import net.poundex.traq.server.dao.TagRepository
import net.poundex.traq.server.dao.TimelinePointRepository
import net.poundex.traq.server.dao.TimelineSpanRepository
import net.poundex.traq.server.domain.Tag
import net.poundex.traq.server.domain.TimelinePoint
import net.poundex.traq.server.domain.TimelineSpan
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

import java.time.LocalDate
import java.time.LocalTime

@Component
@Profile("installTestData")
class TestDataInstaller implements CommandLineRunner
{
	private final TimelineSpanRepository timelineSpanRepository
	private final TimelinePointRepository timelinePointRepository
	private final TagRepository tagRepository

	TestDataInstaller(TimelineSpanRepository timelineSpanRepository, TimelinePointRepository timelinePointRepository, TagRepository tagRepository)
	{
		this.timelineSpanRepository = timelineSpanRepository
		this.timelinePointRepository = timelinePointRepository
		this.tagRepository = tagRepository
	}

	@Override
	void run(String... args) throws Exception
	{
		timelineSpanRepository.save new TimelineSpan(date: LocalDate.now(), description: "One", startTime: LocalTime.of(9, 0), endTime: LocalTime.of(10, 0))
		timelineSpanRepository.save new TimelineSpan(date: LocalDate.now(), description: "Two", startTime: LocalTime.of(10, 0), endTime: LocalTime.of(11, 0))
		timelinePointRepository.save new TimelinePoint(date: LocalDate.now(), description: "Thing", startTime: LocalTime.of(10, 30))
		timelineSpanRepository.save new TimelineSpan(date: LocalDate.now(), description: "Three", startTime: LocalTime.of(11, 0), endTime: LocalTime.of(12, 0))

		tagRepository.save new Tag(name: "desc", description: "This tag has a description")
	}
}
