
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
	id: number;
	name: string;
	description?: string;
}
