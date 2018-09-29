package net.poundex.traq.server.dao

import net.poundex.traq.server.domain.TimelineEvent
import org.springframework.data.jpa.repository.JpaRepository

import java.time.LocalDate

interface TimelineEventRepository extends JpaRepository<TimelineEvent, Long>
{
	List<TimelineEvent> findAllByDate(LocalDate localDate)
}
