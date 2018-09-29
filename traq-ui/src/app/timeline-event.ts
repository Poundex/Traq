
export interface TimelineEvent {
	id?: number;
	date;
	description: string;
	startTime;
	endTime?;
	duration?: number;
	tags: Array<Tag>;
}

export interface Tag
{
	name: string;
	description?: string;
}
