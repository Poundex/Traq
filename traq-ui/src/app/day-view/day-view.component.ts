import {Component, OnInit, SimpleChange} from '@angular/core';
import {TimelineEvent} from "../timeline-event";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-day-view',
  templateUrl: './day-view.component.html',
  styleUrls: ['./day-view.component.css']
})
export class DayViewComponent implements OnInit {

	date = new Date();
	data: Array<TimelineEvent> = [];

	constructor(private route: ActivatedRoute, private router: Router) {
	}

	ngOnInit(): void {
		this.route.data.subscribe(d =>{
			console.log(d);
			this.data = d['dayData'];
		});
		this.route.paramMap.subscribe((params) => {
			let dp: string = params.get("date");
			this.date = dp === "today" ? new Date() : new Date(dp);
		})
	}

	get minusOneDaysAgo(): string
	{
		return new Date(new Date().setDate(this.date.getDate() - 1)).toISOString().substr(0, 10);
	}

	get plusOneDay(): string
	{
		return new Date(new Date().setDate(this.date.getDate() + 1)).toISOString().substr(0, 10);
	}

	onDateChanged(event: string): void
	{
		// console.log(event);
		if( ! event || event === "")
			event = "today";
		this.router.navigate(["/day", event])
	}
}
