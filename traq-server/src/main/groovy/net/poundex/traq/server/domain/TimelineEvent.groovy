package net.poundex.traq.server.domain

import groovy.transform.CompileStatic

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany
import java.time.LocalDate
import java.time.LocalTime

@Entity
@CompileStatic
abstract class TimelineEvent
{
	@Id
	@GeneratedValue
	Long id
	LocalDate date
	LocalTime startTime
	String description

	@ManyToMany
	Set<Tag> tags = new HashSet<>()
}
