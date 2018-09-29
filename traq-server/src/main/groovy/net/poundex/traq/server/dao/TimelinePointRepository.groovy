package net.poundex.traq.server.dao

import net.poundex.traq.server.domain.TimelinePoint
import org.springframework.data.jpa.repository.JpaRepository

import java.time.LocalDate

interface TimelinePointRepository extends JpaRepository<TimelinePoint, Long>
{
}
