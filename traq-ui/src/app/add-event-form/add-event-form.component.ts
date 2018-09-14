import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {DataService} from "../data.service";
import {ActivatedRoute, Router} from "@angular/router";
import {TimelineEvent} from "../timeline-event";

@Component({
	selector: 'app-add-event-form',
	templateUrl: './add-event-form.component.html',
	styleUrls: ['./add-event-form.component.css']
})
export class AddEventFormComponent implements OnInit
{
	timelineEvent: TimelineEvent;

	@Input()
	span: boolean;

	constructor(private dataService: DataService, private router: Router, private route: ActivatedRoute)
	{
		let now: Date = new Date();
		this.timelineEvent = {
			date: "" + now.getFullYear() + "-" + this.padTime(now.getMonth()) + "-" + this.padTime(now.getDate()),
			startTime: "" + this.padTime(now.getHours()) + ":" + this.padTime(now.getMinutes()),
			description: null
		};

	}

	ngOnInit()
	{
		this.route.paramMap.subscribe((params) => this.timelineEvent.date = params.get("date"));
	}

	onSubmit(): void
	{
		this.dataService.saveEvent(this.timelineEvent, this.span).subscribe(() =>
			this.router.navigate(["/day", this.timelineEvent.date]));
	}

	private padTime(v: number): string
	{
		return v.toString().padStart(2, "0");
	}
}
