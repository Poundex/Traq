import {Tag, TimelineEvent} from "./timeline-event";

export interface Day
{
	date;
	events: Array<TimelineEvent>;
	tagSummary: { tagSummaryEntries: Array<{ tag: Tag, duration: number }> };
	durationTotal: number;
	durationAccountable: number;
	durationProductive: number;
}
