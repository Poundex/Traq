package traq.server

import net.poundex.traq.timeline.TimelineEvent
import net.poundex.traq.timeline.TimelinePoint
import net.poundex.traq.timeline.TimelineSpan
import org.grails.datastore.gorm.GormEntity

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class BootStrap {

    def init = { servletContext ->
//        save new TimelineSpan(date: LocalDate.now(), description: "One", startTime: LocalTime.of(9, 0), endTime: LocalTime.of(10, 0))
//        save new TimelineSpan(date: LocalDate.now(), description: "Two", startTime: LocalTime.of(10, 0), endTime: LocalTime.of(11, 0))
//        save new TimelinePoint(date: LocalDate.now(), description: "Thing", startTime: LocalTime.of(10, 30))
//        save new TimelineSpan(date: LocalDate.now(), description: "Three", startTime: LocalTime.of(11, 0), endTime: LocalTime.of(12, 0))
	    save new TimelineSpan(
			    description: "One",
			    startTime: LocalDateTime.of(2018, 8, 15, 9, 0),
			    endTime: LocalDateTime.of(2018, 8, 15, 10, 0))
//	    save new TimelineSpan(date: LocalDate.now(), description: "Two", startTime: LocalTime.of(10, 0), endTime: LocalTime.of(11, 0))
//	    save new TimelinePoint(date: LocalDate.now(), description: "Thing", startTime: LocalTime.of(10, 30))
//	    save new TimelineSpan(date: LocalDate.now(), description: "Three", startTime: LocalTime.of(11, 0), endTime: LocalTime.of(12, 0))
    }
    def destroy = {
    }

    static <T extends GormEntity<T>> T save(T obj, boolean flush = false) {
        return obj.save(failOnError: true, flush: flush)
    }
}
