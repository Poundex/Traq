import {TimelineEvent} from "./timeline-event";

export interface Day
{
	date;
	events: Array<TimelineEvent>;
}
