package net.poundex.traq.timeline

import grails.rest.Resource

import java.time.LocalDate
import java.time.LocalTime

@Resource(uri = '/event')
abstract class TimelineEvent {

    LocalDate date
    LocalTime startTime
    String description


    static constraints = {
    }
}
