package net.poundex.traq.server.dao

import net.poundex.traq.server.domain.TimelineSpan
import org.springframework.data.jpa.repository.JpaRepository

import java.time.LocalDate
import java.time.LocalTime

interface TimelineSpanRepository extends JpaRepository<TimelineSpan, Long>
{
	Iterable<TimelineSpan> findAllByDateAndEndTimeAndIdNot(LocalDate date, LocalTime endTime, Long id)
}
