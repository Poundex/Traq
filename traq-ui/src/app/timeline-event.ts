
export interface TimelineEvent {
	id: number;
	date;
	description: string;
	startTime;
	endTime?;
	duration?;
}
